/*
 * 文件名：SupplierServiceImpl.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： SupplierServiceImpl.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月6日
 * 修改内容：新增
 */
package com.manager.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.manager.common.tools.BigDecimalUtil;
import com.manager.common.tools.DateUtil;
import com.manager.common.tools.StringUtil;
import com.manager.dao.BomDAO;
import com.manager.entity.Bom;
import com.manager.entity.BomId;
import com.manager.entity.Material;
import com.manager.service.BomService;

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
	public void buildhql(StringBuffer hql, Map formParams, Bom bom, HashMap sqlParams) {
		if(null != bom.getId()){
			String topPartnumber = bom.getId().getTopPartnumber();
			if (!StringUtil.isNullOrWhiteSpace(topPartnumber)) {
				hql.append(" and e.id.topPartnumber = :topPartnumber");
				sqlParams.put("topPartnumber", topPartnumber.trim());
			}
			String f_Partnumber = bom.getId().getF_Partnumber();
			if (!StringUtil.isNullOrWhiteSpace(f_Partnumber)) {
				hql.append(" and e.id.f_Partnumber = :f_Partnumber");
				sqlParams.put("f_Partnumber", f_Partnumber.trim());
			}
			String partNumber = bom.getId().getPartNumber();
			if (!StringUtil.isNullOrWhiteSpace(partNumber)) {
				hql.append(" and e.id.partNumber = :partNumber");
				sqlParams.put("partNumber", partNumber);
			}
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
				+ " e.topName, e.partName, e.f_Name, e.secq, e.useQty, e.editor, e.datetime,"
				+ " s.partSpec, s.tuNumber, s.partStandard, s.partModel,s.partPrice,s.partQty)"
				+ " From Bom e ,Material s where e.id.partNumber =  s.partnumber ");
		if (!StringUtil.isNullOrWhiteSpace(partNumber)) {
			hql.append("and e.id.f_Partnumber = :partNumber and e.id.partNumber != :partNumber ");
			sqlParams.put("partNumber", partNumber);
		}
		List<Bom> list = bomDAO.executeHQL(hql.toString(), sqlParams);
		if (null == list || list.isEmpty()) {
			return;
		}
		for(Bom item : list){ 
			calculatePartSum(item);
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
	public List getAllTopBom() {
		HashMap sqlParams = new HashMap();
		StringBuffer hql = new StringBuffer("From Bom e  where 1=1 ");
		hql.append("and e.secq = :secq");
		sqlParams.put("secq", 1);
		List<Bom> list = bomDAO.executeHQL(hql.toString(), sqlParams);
		return list;
	}

	@Override
	public List getAllBom() {
		HashMap sqlParams = new HashMap();
		StringBuffer hql = new StringBuffer("From Bom e  where 1=1 ");
		List<Bom> list = bomDAO.executeHQL(hql.toString(), sqlParams);
		return list;
	}

	@Override
	public List getList(Map formParams, Bom bom) {
		ArrayList<Bom> resultList = new ArrayList<Bom>();
		if (null == bom.getId()) {
			return resultList;
		}
		StringBuffer hql = new StringBuffer(" select new com.manager.entity.Bom(e.id,"
				+ " e.topName, e.partName, e.f_Name, e.secq, e.useQty, e.editor, e.datetime,"
				+ " s.partSpec, s.tuNumber, s.partStandard, s.partModel,s.partPrice,s.partQty)"
				+ " From Bom e ,Material s where e.id.partNumber =  s.partnumber ");
		HashMap sqlParams = new HashMap();
		buildhql(hql, formParams, bom, sqlParams);
		List<Bom> list = bomDAO.executeHQL(hql.toString(), sqlParams);
		if (list.isEmpty()) {
			return resultList;
		} 
		Bom item = list.get(0);
		calculatePartSum(item);
		resultList.add(item);    
		buildTree(item.getId().getPartNumber(), resultList);
		return resultList;
	}

	
	@Override
	public int getNormalCount(Map formParams, Bom bom) {
		StringBuffer hql = new StringBuffer("SELECT count(*) From Bom e where 1=1 ");
		HashMap sqlParams = new HashMap();
		buildhql(hql, formParams, bom, sqlParams);
		return bomDAO.getCount(hql.toString(), sqlParams);
	}

	@Override
	public List getNormalList(Map formParams, Bom bom,int offset,int length) {
		StringBuffer hql = new StringBuffer(" from Bom e where 1 = 1 ");
		HashMap sqlParams = new HashMap();
		buildhql(hql, formParams, bom, sqlParams);
		List<Bom> list = bomDAO.executeHQL(hql.toString(), sqlParams, offset, length);
		return list;
	}

	@Override
	public Bom getBom(BomId id) {
		Bom bom  = (Bom) bomDAO.get(Bom.class, id);
		return bom;
	}

	@Override
	public List getAllMertial() {
		HashMap sqlParams = new HashMap();
		StringBuffer hql = new StringBuffer("From Material e where 1=1 ");
		//选取材料时只选择有效的料号
		hql.append(" and e.id.partActive = :partActive");
	    sqlParams.put("partActive", "Y");
	    
		List<Material> list = bomDAO.executeHQL(hql.toString(), sqlParams);
		return list;
	}

	@Override
	public boolean saveTopMaterial(Bom bom) {
		BomId id = bom.getId();
		if(null == id){
			return false;
		}
		String topPartnumber = id.getTopPartnumber();
		id.setPartNumber(topPartnumber);
		id.setF_Partnumber(topPartnumber);
		String topName = bom.getTopName();
		if(StringUtil.isNullOrWhiteSpace(topName)){
			return false;
		}
		bom.setF_Name(topName);
		bom.setPartName(topName);
		bom.setSecq(1);
		return  saveNormalMaterial(bom);		
	}

	@Override
	public boolean saveNormalMaterial(Bom bom) {
		bom.setDatetime(new Date());
		//判断是否有重复的bom
		Bom item = getBom(bom.getId());
		if(item != null){
			return false;
		}
		if(null == bom.getSecq() || Bom.TOP_SECQ != bom.getSecq()){
			Bom fatherMaterial = getFatherMaterial(bom);
			if(null == fatherMaterial ){
				return false;
			}
			int secq = fatherMaterial.getSecq();
			bom.setSecq(secq + 1);
		}
		
		bomDAO.saveOrUpdate(bom);
		return true;
	}

	@Override
	public Bom getFatherMaterial(Bom bom) {
		BomId fatherId = new BomId();
		StringBuffer hql = new StringBuffer("From Bom e where 1=1 ");
		HashMap sqlParams = new HashMap();
		String topPartnumber = bom.getId().getTopPartnumber();
		if (!StringUtil.isNullOrWhiteSpace(topPartnumber)) {
			hql.append(" and e.id.topPartnumber = :topPartnumber");
			sqlParams.put("topPartnumber", topPartnumber.trim());
		}
		String f_PartNumber = bom.getId().getF_Partnumber();
		if (!StringUtil.isNullOrWhiteSpace(f_PartNumber)) {
			hql.append(" and e.id.partNumber = :partNumber");
			sqlParams.put("partNumber", f_PartNumber);
		}
		Bom fatherMaterial = (Bom) bomDAO.executeHQLPeak(hql.toString(), sqlParams);
		return fatherMaterial;
	}
	

	@Override
	public List getSonMaterial(Bom bom) {
		BomId sonId = new BomId();
		StringBuffer hql = new StringBuffer("From Bom e where 1=1 ");
		HashMap sqlParams = new HashMap();
		String topPartnumber = bom.getId().getTopPartnumber();
		if (!StringUtil.isNullOrWhiteSpace(topPartnumber)) {
			hql.append(" and e.id.topPartnumber = :topPartnumber");
			sqlParams.put("topPartnumber", topPartnumber.trim());
		}
		String f_Partnumber = bom.getId().getPartNumber();
		if (!StringUtil.isNullOrWhiteSpace(f_Partnumber)) {
			hql.append(" and e.id.f_Partnumber = :f_Partnumber");
			sqlParams.put("f_Partnumber", f_Partnumber.trim());
		}
		int secq = bom.getSecq();
		if( secq >0){
			hql.append(" and e.secq = :secq");
			sqlParams.put("secq", secq + 1);
		}
		
		List<Bom> list = bomDAO.executeHQL(hql.toString(), sqlParams);
		return list;
	}

	@Override
	public List getNormalMaterial(Bom bom) {
		HashMap sqlParams = new HashMap();
		String topPartnumber = bom.getId().getTopPartnumber();
		StringBuffer hql = new StringBuffer("From Bom e where 1=1 ");
		if (!StringUtil.isNullOrWhiteSpace(topPartnumber)) {
			hql.append(" and e.id.topPartnumber = :topPartnumber");
			sqlParams.put("topPartnumber", topPartnumber);
		}
		List<Bom> list = bomDAO.executeHQL(hql.toString(), sqlParams);
		return list;
	}

	@Override
	public boolean editBom(Bom bom,HashMap formParams) {
		String alterPartNumber = (String) formParams.get("alterPartNumber");
		String partNumber = bom.getId().getPartNumber();
		String  date = DateUtil.getCurrentPrettyDateTime(); 
		if(bom.getId().getPartNumber() != alterPartNumber){
			if(!isSingle(bom, formParams)){
				return false;
			}
			StringBuffer hql = new StringBuffer("Update tblbom set ");
			hql.append(" f_partNumber ='"+alterPartNumber + "' ");
			hql.append(", f_Name ='"+bom.getPartName() + "'");
			hql.append(", editor ='"+bom.getEditor() + "'");
			hql.append(", Datetime ='"+ date + "'");
			hql.append(" where Top_Partnumber = '" + bom.getId().getTopPartnumber() + "' ");
			hql.append(" and f_partNumber = '" + partNumber + "' ");
			System.out.println(hql.toString());
			bomDAO.executeSql(hql.toString());
			
		}
		StringBuffer hql = new StringBuffer("Update tblbom set ");
		hql.append(" partNumber ='"+alterPartNumber + "' ");
		hql.append(", partName ='"+bom.getPartName() + "'");
		hql.append(", Datetime ='"+ date + "'");
		hql.append(", editor ='"+bom.getEditor() + "'");
		hql.append(", useQty ='"+bom.getUseQty() + "'");
		hql.append(" where Top_Partnumber = '" + bom.getId().getTopPartnumber() + "' ");
		hql.append(" and f_partNumber = '" + bom.getId().getF_Partnumber() + "' ");
		hql.append(" and partNumber = '" + partNumber + "' ");
		System.out.println("after:" + hql.toString());
		bomDAO.executeSql(hql.toString());
		return true;
	}

	@Override
	public List getBomList(Bom bom) {
		StringBuffer hql = new StringBuffer("From Bom e where 1=1 ");
		HashMap sqlParams = new HashMap();
		HashMap formParams = new HashMap();
		buildhql(hql, formParams, bom, sqlParams);
		return bomDAO.executeHQL(hql.toString(), sqlParams);
	}

	@Override
	public boolean isSingle(Bom bom, HashMap formParams) {
		String alterPartNumber = (String) formParams.get("alterPartNumber");
		BomId id  = new BomId();
		id.setTopPartnumber(bom.getId().getTopPartnumber());
		id.setF_Partnumber(bom.getId().getF_Partnumber());
		id.setPartNumber(alterPartNumber);
		if(getBom(id) != null){
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteBom(Bom bom) {
		List<Bom> sonList = getSonMaterial(bom);
		if (!sonList.isEmpty()) {
			for(Bom item :sonList){
				deleteBom(item);
			}
		}
		return bomDAO.delete(bom);
	}

	public void calculatePartSum(Bom bom){
		BigDecimal partSum = new BigDecimal(0);
		BigDecimal partPrice = bom.getPartPrice(); 
		BigDecimal partQty= bom.getPartQty();
		BigDecimal  useQty  = new BigDecimal(bom.getUseQty());
		partSum = partPrice.multiply(partQty).multiply(useQty);
		partSum = BigDecimalUtil.Decimalformat(partSum);
		bom.setPartSum(partSum);
	}
	
}
