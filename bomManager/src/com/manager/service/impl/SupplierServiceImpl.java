/*
 * 文件名：SupplierServiceImpl.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： SupplierServiceImpl.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月6日
 * 修改内容：新增
 */
package com.manager.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manager.common.tools.StringUtil;
import com.manager.dao.MaterialDAO;
import com.manager.dao.SupplierDAO;
import com.manager.entity.Material;
import com.manager.entity.MaterialId;
import com.manager.entity.Supplier;
import com.manager.entity.SupplierId;
import com.manager.service.SupplierService;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月6日
 * @since      CCAS
 */
public class SupplierServiceImpl implements SupplierService{
	private SupplierDAO supplierDAO;
	private MaterialDAO materialDAO;

	public MaterialDAO getMaterialDAO() {
		return materialDAO;
	}

	public void setMaterialDAO(MaterialDAO materialDAO) {
		this.materialDAO = materialDAO;
	}

	public SupplierDAO getSupplierDAO() {
		return supplierDAO;
	}

	public void setSupplierDAO(SupplierDAO supplierDAO) {
		this.supplierDAO = supplierDAO;
	}

	@Override
	public int getCount(Map formParams, Supplier supplier) {
		StringBuffer hql = new StringBuffer("SELECT count(*) From Supplier e where 1=1 ");
		HashMap sqlParams = new HashMap();
		builhql(hql, formParams, supplier, sqlParams);
		return supplierDAO.getCount(hql.toString(), sqlParams);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Supplier> getList(Map formParams, Supplier supplier, int offset, int length) {
		//hql语句
		StringBuffer hql = new StringBuffer("From Supplier e where 1=1 ");
		// 查询参数列表
		HashMap sqlParams = new HashMap();
		builhql(hql, formParams,supplier,sqlParams);
		List<Supplier> list = supplierDAO.executeHQL(hql.toString(), sqlParams,offset,length);
		return list;
	}

	@Override
	public void builhql(StringBuffer hql, Map formParams, Supplier supplier, HashMap sqlParams) {
		 if(null != supplier.getId()){
			 String partnumber = supplier.getId().getPartnumber();
			 	if(!StringUtil.isNullOrWhiteSpace(partnumber)){
					hql.append(" and e.id.partnumber = :partnumber");
				    sqlParams.put("partnumber", partnumber);
				}
			 	String partRev = supplier.getId().getPartRev();
			 	if(!StringUtil.isNullOrWhiteSpace(partRev)){
					hql.append(" and e.id.partRev = :partRev");
				    sqlParams.put("partRev", partRev);
				}
			 	String	supplierName = supplier.getId().getSupplierName();
			 	if(!StringUtil.isNullOrWhiteSpace(supplierName)){
					hql.append(" and e.id.supplierName = :supplierName");
				    sqlParams.put("supplierName", supplierName);
				}
			 }
	 		String supplierCode = supplier.getSupplierCode();
 	 		if(!StringUtil.isNullOrWhiteSpace(supplierCode)){
 	 			hql.append(" and e.supplierCode = :supplierCode");
 	 			sqlParams.put("supplierCode", supplierCode);
 	 		}
 	 		String partName = supplier.getPartName();
 			if(!StringUtil.isNullOrWhiteSpace(partName)){
 				hql.append(" and e.partName = :partName");
 			    sqlParams.put("partName", partName);
 			}
	}

	@Override
	public Supplier getSupplier(SupplierId id) {
		return (Supplier) supplierDAO.get(Supplier.class, id);
	}

	@Override
	public boolean updateSupplier(Supplier supplier) {
		supplier.setDatetime(new Date());
		String partActive = supplier.getPartActive();
		supplierDAO.update(supplier);
		if("Y".equals(partActive)){
			//1.修改有效这一栏位为Y时，
			//提交修改时把这行的材料规格，执行标准，单位，单价这几个值update到
			//Tblmaterial表中对应的料号和版本，料号有效为Y的这几个对应栏位中。
			MaterialId id = new MaterialId();
			id.setPartnumber(supplier.getId().getPartnumber());
			id.setPartActive("Y");
			id.setPartRev(supplier.getId().getPartRev());
			Material material =  (Material) materialDAO.get(Material.class, id);
			if(material == null ){
				//TODO 出现错误，需要事务回滚
				return false; 
			}else{
				//材料规格
				material.setPartSpec(supplier.getPartSpec());
				//执行标准（partStandard）
				material.setPartStandard(supplier.getPartStandard());
				//单位partUnit
				material.setPartUnit(supplier.getPartUnit());
				//单价PartPrice
				material.setPartPrice(supplier.getPartPrice());
				//执行更新  TODO 这里将这个更新提到supplierDAO.update(supplier); 之前就执行没有效果
				materialDAO.saveOrUpdate(material);
			}
			// 2.修改有效这一栏位为Y时，原则是一个料号只能有一笔记录有效，
			//该料号其他行全部Update成N。
			StringBuffer hql = new StringBuffer("Update tblsupplier set partActive = 'N' ");
			hql.append("where  partnumber = '").append(supplier.getId().getPartnumber()+"'");
			int result = supplierDAO.executeSql(hql.toString());
		}

		return true;
	}

	@Override
	public boolean AddSupplier(Supplier supplier) {
		return supplierDAO.Add(supplier);
	}

	@Override
	public boolean deleteSupplier(Supplier supplier) {
		Supplier item = (Supplier) supplierDAO.get(Supplier.class, supplier.getId());
		if(item == null){
			return false;
		}
		return supplierDAO.delete(item);
	}
	
	
	
} 

