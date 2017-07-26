/*
 * 文件名：MaterialModel.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： MaterialModel.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月4日
 * 修改内容：新增
 */
package com.manager.entity.model;

import com.manager.dao.MaterialDAO;
import com.manager.entity.Material;
import com.manager.entity.common.Pagebean;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月4日
 * @since      CCAS
 */
public class MaterialModel extends BaseModel {
	
	private Material entity;

	public Material getEntity() {
		return entity;
	}
	public void setEntity(Material entity) {
		this.entity = entity;
	}
	public MaterialModel() {
		pageBean = new Pagebean();
		entity = new Material();
	}
}

