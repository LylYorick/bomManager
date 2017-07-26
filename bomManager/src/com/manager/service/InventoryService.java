/*
 * 文件名：InventoryService.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： InventoryService.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月12日
 * 修改内容：新增
 */
package com.manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manager.entity.Inventory;
import com.manager.entity.Invlog;
import com.manager.entity.common.InventoryTree;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月12日
 * @since      CCAS
 */
public interface InventoryService {
	public int getCount(Map formParams,Inventory inventory);
	/**
	 * 分页查询代码
	 */
	public List<Inventory> getList(Map formParams,Inventory inventory,int offset,int length);

	public void builhql(StringBuffer hql, Map formParams,Inventory inventory, HashMap sqlParams);
	public String excuteSql(String sqlType,String sql);
	
}

