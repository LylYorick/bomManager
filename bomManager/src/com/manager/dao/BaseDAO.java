/*
 * 文件名：baseDAO.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： baseDAO.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年5月1日
 * 修改内容：新增
 */
package com.manager.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.manager.entity.Material;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年5月1日
 * @since      CCAS
 */
public interface BaseDAO {
	public boolean Add(Object obj);

	public List getAll(String hql);
	public Object get(Class refClass, Serializable key);
	public boolean update(Object obj);
	public boolean delete(Object obj);

	public Query getQuery(String queryStr, Map params);
	public List executeHQL(String hql, Map params, int offset,int length);
	public void saveOrUpdate(Object obj);
	public List executeHQL(String hql, Map sqlParams);
	public int executeSql(String sql);
	public List executeSqlSelct(String sql);
	public int getCount(String hql, Map sqlParams);
}

