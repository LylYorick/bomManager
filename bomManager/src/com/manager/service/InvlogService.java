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
public interface InvlogService {
	public int getCount(Map formParams,Invlog invlog);
	/**
	 * 分页查询代码
	 * @param formParams
	 * @param flowerView
	 * @param offset
	 * @param size
	 * @return
	 */
	public List<Invlog> getList(Map formParams,Invlog invlog,int offset,int length);

	public void builhql(StringBuffer hql, Map formParams,Invlog invlog, HashMap sqlParams);
	public List<InventoryTree> buildTree();
	public List<InventoryTree> buildDeliveryTree();
	public boolean AddInvlog(Invlog invlog);
	/**
	 * 出库操作
	 * @return
	 */
	public boolean deliveryInvlog(Invlog invlog);
	
	/**
	 * 验证是否允许出库
	 */
	public boolean validateDelivery(Invlog invlog);
}

