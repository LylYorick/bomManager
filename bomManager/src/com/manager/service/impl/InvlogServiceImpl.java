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

import com.manager.common.tools.StringUtil;
import com.manager.dao.InventoryDAO;
import com.manager.dao.InvlogDAO;
import com.manager.entity.Inventory;
import com.manager.entity.Invlog;
import com.manager.entity.Inventory;
import com.manager.entity.Supplier;
import com.manager.entity.SupplierId;
import com.manager.entity.common.InventoryTree;
import com.manager.service.InvlogService;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月12日
 * @since      CCAS
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class InvlogServiceImpl implements InvlogService {
	private  InventoryDAO inventoryDAO;
	private  InvlogDAO invlogDAO;


	public InventoryDAO getInventoryDAO() {
		return inventoryDAO;
	}

	public void setInventoryDAO(InventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
	}

	public InvlogDAO getInvlogDAO() {
		return invlogDAO;
	}

	public void setInvlogDAO(InvlogDAO invlogDAO) {
		this.invlogDAO = invlogDAO;
	}

	


	@Override
	public int getCount(Map formParams, Invlog invlog) {
		StringBuffer hql = new StringBuffer("SELECT count(*) From Invlog e where 1=1 ");
		HashMap sqlParams = new HashMap();
		builhql(hql, formParams, invlog, sqlParams);
		return inventoryDAO.getCount(hql.toString(), sqlParams);
	}

	@Override
	public List<Invlog> getList(Map formParams, Invlog invlog, int offset, int length) {
		//hql语句
		StringBuffer hql = new StringBuffer("From Invlog e where 1=1 ");
		// 查询参数列表
		HashMap sqlParams = new HashMap();
		builhql(hql, formParams,invlog,sqlParams);

		List<Invlog> list = inventoryDAO.executeHQL(hql.toString(), sqlParams,offset,length);
		return list;
	}

	@Override
	public void builhql(StringBuffer hql, Map formParams, Invlog invlog, HashMap sqlParams) {
			 String partnumber = invlog.getPartnumber();
			 	if(!StringUtil.isNullOrWhiteSpace(partnumber)){
			 		partnumber = "%" + partnumber + "%";
					hql.append(" and e.id.partnumber like :partnumber");
				    sqlParams.put("partnumber", partnumber);
				}
			 	String partRev = invlog.getPartRev();
			 	if(!StringUtil.isNullOrWhiteSpace(partRev)){
			 		partRev = "%" + partRev + "%";
					hql.append(" and e.id.partRev like :partRev");
				    sqlParams.put("partRev", partRev);
				}
			 	String	supplierName = invlog.getSupplierName();
			 	if(!StringUtil.isNullOrWhiteSpace(supplierName)){
			 		supplierName = "%" + supplierName + "%";
					hql.append(" and e.id.supplierName like :supplierName");
				    sqlParams.put("supplierName", supplierName);
				}
	}

	@Override
	public List<InventoryTree> buildTree() {
		//查询出全部的料号和名称
		String sql = "select Partnumber,PartName  from tblmaterial";
		List<Object[]> resultList = inventoryDAO.executeSqlSelct(sql);
		
		List<InventoryTree>   inventoryTrees = new ArrayList<InventoryTree>(); 
		if(resultList==null || resultList.isEmpty()){
			return inventoryTrees;
		}
		int id = 1;
		InventoryTree inventoryTree = null;
		for(Object[] item :resultList){
			 inventoryTree = new InventoryTree(id, 0, item[0]+"",item[1]+"");
			 inventoryTrees.add(inventoryTree);
			int trueid = id;
			id = id+1;
			//查询出通过料号
			String sql2 = "select PartRev  from tblmaterial where Partnumber='"+item[0]+"'";
			List<Object[]> resultList2 = inventoryDAO.executeSqlSelct(sql2);
			if(resultList2==null || resultList2.isEmpty()){
				continue;
			}
			for(Object items2 :resultList2){
				inventoryTree = new InventoryTree(id,trueid, items2+"", items2+"");
				 inventoryTrees.add(inventoryTree);
				 int lastid = id;
				 id = id+1;
				String sql3 = "select supplierName from tblsupplier where Partnumber='"+item[0]+"'"
						+ "and PartRev ='" + items2 + "'" ;
				List<Object[]> resultList3 = inventoryDAO.executeSqlSelct(sql3); 
				if(resultList3==null || resultList3.isEmpty()){
					continue;
				}
				for(Object items3 :resultList3){
					inventoryTree = new InventoryTree(id,lastid, items3+"", items3+"");
					 inventoryTrees.add(inventoryTree);
				}
			}
		}
		return inventoryTrees;
	}
	

	@Override
	public List<InventoryTree> buildDeliveryTree() {
		//查询出全部的料号和名称
		String sql = "select Partnumber,PartName  from tblinventory";
		List<Object[]> resultList = inventoryDAO.executeSqlSelct(sql);
		
		List<InventoryTree>   inventoryTrees = new ArrayList<InventoryTree>(); 
		if(resultList==null || resultList.isEmpty()){
			return inventoryTrees;
		}
		int id = 1;
		InventoryTree inventoryTree = null;
		for(Object[] item :resultList){
			 inventoryTree = new InventoryTree(id, 0, item[0]+"",item[1]+"");
			 inventoryTrees.add(inventoryTree);
			int trueid = id;
			id = id+1;
			//查询出通过料号
			String sql2 = "select PartRev  from tblinventory where Partnumber='"+item[0]+"'";
			List<Object[]> resultList2 = inventoryDAO.executeSqlSelct(sql2);
			if(resultList2==null || resultList2.isEmpty()){
				continue;
			}
			for(Object items2 :resultList2){
				inventoryTree = new InventoryTree(id,trueid, items2+"", items2+"");
				 inventoryTrees.add(inventoryTree);
				 int lastid = id;
				 id = id+1;
				String sql3 = "select supplierName from tblinventory where Partnumber='"+item[0]+"'"
						+ "and PartRev ='" + items2 + "'" ;
				List<Object[]> resultList3 = inventoryDAO.executeSqlSelct(sql3); 
				if(resultList3==null || resultList3.isEmpty()){
					continue;
				}
				for(Object items3 :resultList3){
					inventoryTree = new InventoryTree(id,lastid, items3+"", items3+"");
					 inventoryTrees.add(inventoryTree);
				}
			}
		}
		return inventoryTrees;
	}

	@Override
	public boolean AddInvlog(Invlog invlog) {
		//1.判断是否有此库存
		SupplierId id = new SupplierId();
		id.setPartnumber(invlog.getPartnumber());
		id.setPartRev(invlog.getPartRev());
		id.setSupplierName(invlog.getSupplierName());
		Inventory inventory = (Inventory) invlogDAO.get(Inventory.class, id);
		if(inventory == null){
		//2.如果没有则将这笔库存，直接新增进去
			inventory = new Inventory();
			inventory.setId(id);
			//设置材料名称
			inventory.setPartName(invlog.getPartName());
			//设置单位
			inventory.setPartUnit(invlog.getPartUnit());
			//设置金额
			inventory.setI_Qty(invlog.getQty());
			//设置 编辑人和日期
			inventory.setM_Editor(invlog.getEditor());
			inventory.setM_Datetime(invlog.getDatetime());
			//新增一条库存
			invlogDAO.saveOrUpdate(inventory);
		}else{
			//3.如有则将本条库存的数量设为原来的数量加上此次的数量
			BigDecimal i_Qty= inventory.getI_Qty().add(invlog.getQty());
			inventory.setI_Qty(i_Qty);
			//设置 编辑人和日期
			inventory.setM_Editor(invlog.getEditor());
			inventory.setM_Datetime(invlog.getDatetime());
			invlogDAO.update(inventory);
		}
		//4. 将本次记录记录到
		invlogDAO.saveOrUpdate(invlog);
		return true;
	}

	@Override
	public boolean deliveryInvlog(Invlog invlog) {
		SupplierId id = new SupplierId();
		id.setPartnumber(invlog.getPartnumber());
		id.setPartRev(invlog.getPartRev());
		id.setSupplierName(invlog.getSupplierName());
		Inventory inventory = (Inventory) invlogDAO.get(Inventory.class, id);
		BigDecimal i_Qty = inventory.getI_Qty().subtract(invlog.getQty());
		inventory.setI_Qty(i_Qty);
		invlogDAO.update(inventory);
		invlogDAO.saveOrUpdate(invlog);
		return true;
	}

	@Override
	public boolean validateDelivery(Invlog invlog) {
		//1.判断 出库数量 是否是正数
		if(invlog.getQty().signum() != 1){
			return false;
		}
		//1.判断是否有此库存,且库存大于出库数量
		SupplierId id = new SupplierId();
		id.setPartnumber(invlog.getPartnumber());
		id.setPartRev(invlog.getPartRev());
		id.setSupplierName(invlog.getSupplierName());
		Inventory inventory = (Inventory) invlogDAO.get(Inventory.class, id);
		if(inventory == null){
			return false;
		}
		if(inventory.getI_Qty().compareTo(invlog.getQty()) <  0 ){
			return false;
		} 
		return true;
	}
	
	
}

