/*
 * 文件名：SupplierService.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： SupplierService.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月6日
 * 修改内容：新增
 */
package com.manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manager.entity.Bom;
import com.manager.entity.BomId;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月6日
 * @since      CCAS
 */
public interface BomService {

	public void buildhql(StringBuffer hql, Map formParams, Bom bom, HashMap sqlParams);
	
	public String getListJson(Map formParams,Bom bom);
	public List getList(Map formParams,Bom bom);
	public int getNormalCount(Map formParams,Bom bom);
	public Bom getBom(BomId id);
	public List getNormalList(Map formParams,Bom bom,int offset,int length);
	public List getTopBom(Map formParams,Bom bom);
	public List getAllMertial();
	public List getAllTopBom();
	public List getAllBom();
	public List getNormalMaterial(Bom bom);
	public List getBomList(Bom bom);
	public Bom getFatherMaterial(Bom bom);
	public List getSonMaterial(Bom bom);
	public void buildTree(String partNumber,List<Bom> resultList);
	public boolean saveTopMaterial(Bom bom);
	public boolean saveNormalMaterial(Bom bom);
	public boolean deleteBom(Bom bom);
	public boolean  editBom(Bom bom,HashMap formParams);
	public boolean  isSingle(Bom bom,HashMap formParams);
}

