/*
 * 文件名：UserService.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： UserService.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年4月22日
 * 修改内容：新增
 */
package com.manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manager.entity.Material;
import com.manager.entity.MaterialId;
import com.manager.entity.view.MaterialView;


/**
 * 
 * @author     liyuelong 1610139
 * @version    CCAS 2017年4月22日
 * @since      CCAS
 */
public interface MaterialService {
	public int getCount(Map formParams,Material material);
	/**
	 * 分页查询代码
	 * @param formParams
	 * @param flowerView
	 * @param offset
	 * @param size
	 * @return
	 */
	public List<Material> getList(Map formParams,Material material,int offset,int length);
	public Material getMaterial(MaterialId id);
	public boolean updateMaterial(Material material);
	public void builhql(StringBuffer hql,Map formParams,Material material,HashMap sqlParams);
	public boolean AddMaterial(Material material);
	public boolean getAllowSoldOut(Material material);
}


