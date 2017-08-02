/*
 * 文件名：SupplierServiceImpl.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： SupplierServiceImpl.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月6日
 * 修改内容：新增
 */
package com.manager.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.manager.dao.BomDAO;
import com.manager.entity.Order;
import com.manager.service.BomService;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月6日
 * @since      CCAS
 */
public class BomServiceImpl implements BomService{
	private BomDAO bomDAO;
	
	public BomDAO getBomDAO() {
		return bomDAO;
	}
	public void setBomDAO(BomDAO bomDAO) {
		this.bomDAO = bomDAO;
	}


	@Override
	public void builhql(StringBuffer hql, Map formParams, Order order, HashMap sqlParams) {
		// TODO Auto-generated method stub
		
	}

	
} 

