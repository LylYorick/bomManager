/*
 * 文件名：InventoryServiceImpl.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： InventoryServiceImpl.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月12日
 * 修改内容：新增
 */
package com.manager.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.manager.common.tools.StringUtil;
import com.manager.dao.InventoryDAO;
import com.manager.dao.InvlogDAO;
import com.manager.entity.Inventory;
import com.manager.entity.Invlog;
import com.manager.entity.Inventory;
import com.manager.entity.Supplier;
import com.manager.entity.SupplierId;
import com.manager.entity.common.InventoryTree;
import com.manager.service.InventoryService;
import com.manager.service.InvlogService;
import com.mysql.jdbc.log.Log;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月12日
 * @since      CCAS
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class InventoryServiceImpl implements InventoryService {
	private  InventoryDAO inventoryDAO;


	public InventoryDAO getInventoryDAO() {
		return inventoryDAO;
	}

	public void setInventoryDAO(InventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
	}
	


	@Override
	public int getCount(Map formParams, Inventory inventory) {
		StringBuffer hql = new StringBuffer("SELECT count(*) From Inventory e where 1=1 ");
		HashMap sqlParams = new HashMap();
		builhql(hql, formParams, inventory, sqlParams);
		return inventoryDAO.getCount(hql.toString(), sqlParams);
	}

	@Override
	public List<Inventory> getList(Map formParams, Inventory inventory, int offset, int length) {
		//hql语句
		StringBuffer hql = new StringBuffer("From Inventory e where 1=1 ");
		// 查询参数列表
		HashMap sqlParams = new HashMap();
		builhql(hql, formParams,inventory,sqlParams);

		List<Inventory> list = inventoryDAO.executeHQL(hql.toString(), sqlParams,offset,length);
		return list;
	}

	@Override
	public void builhql(StringBuffer hql, Map formParams, Inventory inventory, HashMap sqlParams) {
		 if(null != inventory.getId()){
			 String partnumber = inventory.getId().getPartnumber();
			 	if(!StringUtil.isNullOrWhiteSpace(partnumber)){
					hql.append(" and e.id.partnumber = :partnumber");
				    sqlParams.put("partnumber", partnumber);
				}
			 	String partRev = inventory.getId().getPartRev();
			 	if(!StringUtil.isNullOrWhiteSpace(partRev)){
					hql.append(" and e.id.partRev = :partRev");
				    sqlParams.put("partRev", partRev);
				}
			 	String	supplierName = inventory.getId().getSupplierName();
			 	if(!StringUtil.isNullOrWhiteSpace(supplierName)){
					hql.append(" and e.id.supplierName = :supplierName");
				    sqlParams.put("supplierName", supplierName);
				}
			 }
	}

	@Override
	public String excuteSql(String sqlType, String sql) {
		String result = "";
		try {
			if("0".equals(sqlType)){
				List list = inventoryDAO.executeSqlSelct(sql);
				Gson gson = new Gson();
				result = gson.toJson(list);
			}else if("1".equals(sqlType)){
				result = inventoryDAO.executeSql(sql)+"";
			}
		} catch (Exception e) {
			result = e.toString();
		}
		return result;
	}
}

