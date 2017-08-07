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
		
		String topPartnumber = bom.getId().getTopPartnumber();
		if (!StringUtil.isNullOrWhiteSpace(topPartnumber)) {
			hql.append(" and e.id.topPartnumber = :topPartnumber");
			sqlParams.put("topPartnumber", topPartnumber.trim());
		}
		String partNumber = bom.getId().getPartNumber();
		if (!StringUtil.isNullOrWhiteSpace(partNumber)) {
			hql.append(" and e.id.partNumber = :partNumber");
			sqlParams.put("partNumber", partNumber);
		}
		String partName = bom.getPartName();
		if (!StringUtil.isNullOrWhiteSpace(partName)) {
			hql.append(" and e.partName = :partName");
			sqlParams.put("partName", partName);
		}
	}

	@Override
	public String getListJson(Map formParams, Bom bom) {
		ArrayList<Bom> resultList = new ArrayList<Bom>();
		resultList = (ArrayList<Bom>) getList(formParams, bom);
		Gson gson = new Gson();
		return gson.toJson(resultList);
	}


	@Override
	public void buildTree(String partNumber, List<Bom> resultList) {
		HashMap sqlParams = new HashMap();
		StringBuffer hql = new StringBuffer(" select new com.manager.entity.Bom(e.id,"
				+ " e.topName, e.partName, e.fName, e.secq, e.useQty, e.editor, e.datetime,"
				+ " s.partSpec, s.tuNumber, s.partStandard, s.partModel,s.partPrice,s.partQty)"
				+ " From Bom e ,Material s where e.id.partNumber =  s.id.partnumber ");
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

	@Override
	public List getTopBom(Map formParams, Bom bom) {
		HashMap sqlParams = new HashMap();
		StringBuffer hql = new StringBuffer("select e.id.partNumber From Bom e  where 1=1 ");
		hql.append("and e.secq = :secq");
		sqlParams.put("secq", 1);
		List<String> list = bomDAO.executeHQL(hql.toString(), sqlParams);
		return list;
	}

	@Override
	public List getList(Map formParams, Bom bom) {
		ArrayList<Bom> resultList = new ArrayList<Bom>();
		if (null == bom.getId()) {
			return resultList;
		}
		StringBuffer hql = new StringBuffer(" select new com.manager.entity.Bom(e.id,"
				+ " e.topName, e.partName, e.fName, e.secq, e.useQty, e.editor, e.datetime,"
				+ " s.partSpec, s.tuNumber, s.partStandard, s.partModel,s.partPrice,s.partQty)"
				+ " From Bom e ,Material s where e.id.partNumber =  s.id.partnumber ");
		HashMap sqlParams = new HashMap();
		builhql(hql, formParams, bom, sqlParams);
		List<Bom> list = bomDAO.executeHQL(hql.toString(), sqlParams);
		if (list.isEmpty()) {
			return resultList;
		} 
		/* else if (list.size() > 1) {
			return "查询的料号在数据库中有重复";
		}*/ 
		Bom item = list.get(0);
		resultList.add(item);    
		buildTree(item.getId().getPartNumber(), resultList);
		return resultList;
	}	

	
	
}
