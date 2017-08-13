/*
 * 文件名：UserService.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： UserService.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年4月21日
 * 修改内容：新增
 */
package com.manager.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import com.manager.common.tools.MD5Util;
import com.manager.common.tools.StringUtil;
import com.manager.dao.MaterialDAO;
import com.manager.dao.UserDAO;
import com.manager.entity.Material;
import com.manager.entity.MaterialId;
import com.manager.entity.UserInfo;
import com.manager.entity.view.MaterialView;
import com.manager.entity.view.UserInfoView;
import com.manager.service.MaterialService;
import com.manager.service.UserService;


/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年4月21日
 * @since      CCAS
 */
@Service
public class MaterialServiceImpl implements MaterialService{
	
	private MaterialDAO materialDAO;

	public MaterialDAO getMaterialDAO() {
		return materialDAO;
	}

	public void setMaterialDAO(MaterialDAO materialDAO) {
		this.materialDAO = materialDAO;
	}

	@Override
	public int getCount(Map formParams,Material material) {
		StringBuffer hql = new StringBuffer("SELECT count(*) From Material e where 1=1 ");
		HashMap sqlParams = new HashMap();
		builhql(hql, formParams, material, sqlParams);
		return materialDAO.getCount(hql.toString(), sqlParams);
	}

	@Override
	public List<Material> getList(Map formParams, Material material, int offset, int length) {
		//hql语句
		StringBuffer hql = new StringBuffer("From Material e where 1=1 ");
		// 查询参数列表
		HashMap sqlParams = new HashMap();
		builhql(hql, formParams,material,sqlParams);
		List<Material> list = materialDAO.executeHQL(hql.toString(), sqlParams,offset,length);
		return list;
	}

	@Override
	public boolean AddMaterial(Material material) {
	
		return 	materialDAO.Add(material);
	}

	@Override
	public void builhql(StringBuffer hql, Map formParams, Material material, HashMap sqlParams) {
		 if(null != material.getId()){
		 String partnumber = material.getId().getPartnumber();
		 	if(!StringUtil.isNullOrWhiteSpace(partnumber)){
				hql.append(" and e.id.partnumber = :partnumber");
			    sqlParams.put("partnumber", partnumber);
			}
		 	String partRev = material.getId().getPartRev();
		 	if(!StringUtil.isNullOrWhiteSpace(partRev)){
				hql.append(" and e.id.partRev = :partRev");
			    sqlParams.put("partRev", partRev);
			}
		 	String	partActive = material.getId().getPartActive();
		 	if(!StringUtil.isNullOrWhiteSpace(partActive)){
				hql.append(" and e.id.partActive = :partActive");
			    sqlParams.put("partActive", partActive);
			}
		 }
		
		String partName = material.getPartName();
		if(!StringUtil.isNullOrWhiteSpace(partName)){
			hql.append(" and e.partName = :partName");
		    sqlParams.put("partName", partName);
		}
		String partDesc = material.getPartDesc();
		if(!StringUtil.isNullOrWhiteSpace(partDesc)){
			partDesc = "%"+ partDesc +"%";
			hql.append(" and e.partDesc like :partDesc");
		    sqlParams.put("partDesc", partDesc);
		}
	}

	@Override
	public Material getMaterial(MaterialId id) {
		Material material = (Material) materialDAO.get(Material.class, id);
		return material;
	}

	@Override
	public boolean updateMaterial(Material material) {
		// 查询参数列表
		material.setDatetime(new Date());
		material.getId().setPartActive("Y");
		//判断是否有这个材料在数据库中
		Material property =(Material) materialDAO.get(Material.class, material.getId());
		if(null == property){
			return false;
		}
		return materialDAO.update(material);
	}
	

}

