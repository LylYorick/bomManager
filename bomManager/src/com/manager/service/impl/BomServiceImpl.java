/*
 * 文件名：SupplierServiceImpl.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： SupplierServiceImpl.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月6日
 * 修改内容：新增
 */
package com.manager.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.manager.common.tools.StringUtil;
import com.manager.dao.BomDAO;
import com.manager.entity.Bom;
import com.manager.service.BomService;
import com.mchange.v2.c3p0.stmt.GooGooStatementCache;

/**
 * TODO添加类描述
 * 
 * @author liyuelong 1610139
 * @version CCAS 2017年7月6日
 * @since CCAS
 */
@SuppressWarnings("unchecked")
public class BomServiceImpl implements BomService {
	private BomDAO bomDAO;

	public BomDAO getBomDAO() {
		return bomDAO;
	}

	public void setBomDAO(BomDAO bomDAO) {
		this.bomDAO = bomDAO;
	}

	@Override
	public void builhql(StringBuffer hql, Map formParams, Bom bom, HashMap sqlParams) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getList(Map formParams, Bom bom) {
		if (null == bom.getId()) {
			return "";
		}
		StringBuffer hql = new StringBuffer(" From Bom e where 1 = 1");
		HashMap sqlParams = new HashMap();
		String partNumber = bom.getId().getPartNumber();
		if (!StringUtil.isNullOrWhiteSpace(partNumber)) {
			hql.append(" and e.id.partNumber = :partNumber");
			sqlParams.put("partNumber", partNumber);
		}
		List<Bom> list = bomDAO.executeHQL(hql.toString(), sqlParams);
		if (list.isEmpty()) {
			return "";
		} else if (list.size() > 1) {
			return "查询的料号在数据库中有重复";
		}
		Bom item = list.get(0);
		ArrayList<Bom> resultList = new ArrayList<Bom>();
		resultList.add(item);
		buildTree(item.getId().getPartNumber(), resultList);
		Gson gson = new Gson();
		return gson.toJson(resultList);
	}


	@Override
	public void buildTree(String partNumber, List<Bom> resultList) {
		HashMap sqlParams = new HashMap();
		StringBuffer hql = new StringBuffer(" From Bom e where 1 = 1 ");
		if (!StringUtil.isNullOrWhiteSpace(partNumber)) {
			hql.append("and e.id.fPartnumber = :partNumber and e.id.partNumber != :partNumber ");
			sqlParams.put("partNumber", partNumber);
		}
		List<Bom> list = bomDAO.executeHQL(hql.toString(), sqlParams);
		if (null == list || list.isEmpty()) {
			return;
		}
		for(Bom item : list){ 
			resultList.add(item);
			buildTree(item.getId().getPartNumber(), resultList);
		}
	}

}
