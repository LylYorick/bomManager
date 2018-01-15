/*
 * 文件名：SupplierService.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： SupplierService.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月6日
 * 修改内容：新增
 */
package com.manager.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manager.entity.Order;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月6日
 * @since      CCAS
 */
public interface OrderService {
	public int getCount(Map formParams,Order order);

	/**
	 * 分页查询代码
	 * @param formParams
	 * @return
	 */
	public List<Order> getList(Map formParams,Order order,int offset,int length);
	public List<Order> getList(Map formParams,Order order);

	public void builhql(StringBuffer hql, Map formParams, Order order, HashMap sqlParams);
	
	public boolean Add(Order order);
	
	public Order getOrder(Order order);
	public Boolean verify(Map params, Order order) throws IOException;
	public Boolean edit(Order order);
	public Boolean confirm(Order order);
	public Boolean complete(Order order);
	public Boolean delete(Order order);
	
}

