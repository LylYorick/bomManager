/*
 * 文件名：BaseDAo.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： BaseDAo.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年4月26日
 * 修改内容：新增
 */
package com.manager.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.manager.dao.BaseDAO;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年4月26日
 * @since      CCAS
 */
@Repository
public class BaseDAOImpl implements BaseDAO{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//获取和当前线程绑定的 Session. 
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List getAll(String hql) {
		return getSession().createQuery(hql).list();
	}
	
	@Override
	public boolean Add(Object obj){
		try{
			getSession().save(obj);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Object get(Class refClass, Serializable key) {
		
		return getSession().get(refClass, key);
	}
	@Override
	public boolean update(Object obj) {
		try{
			getSession().clear();
			getSession().update(obj);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
				
		return false;
	}
	@Override
	public boolean delete(Object obj) {
		try{
			getSession().delete(obj);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Query getQuery(String queryStr, Map params) 
    {
        Query q = getSession().createQuery(queryStr);
        if (null != params)
        {
            for (Iterator i = params.entrySet().iterator(); i.hasNext();)
            {
                Map.Entry entry = (Map.Entry) i.next();
                
                String key = (String) entry.getKey();
                Object val = entry.getValue();
                // 这里考虑传入的参数是什么类型，不同类型使用的方法不同
                if (val instanceof Collection<?>)
                {
                    q.setParameterList(key, (Collection<?>) val);
                }
                else if (val instanceof Object[])
                {
                    q.setParameterList(key, (Object[]) val);
                }
                else
                {
                    q.setParameter(key, val);
                }
            }
        }
        return q;
    }
	
	@Override
	public List executeHQL(String hql, Map params, int offset,
			int length)  {
		Query query = getQuery(hql, params);
		if (offset > 0)
			query.setFirstResult(offset);
		if (length > 0)
			query.setMaxResults(length);
		return query.list();
	}
	
	@Override
	public List executeHQL(String hql, Map sqlParams)  {
		Query query = getQuery(hql, sqlParams);
		return query.list();
	}
	
	@Override
	public int getCount(String hql, Map sqlParams) {
		Query query = getQuery(hql, sqlParams);
		return ((Number)query.uniqueResult()).intValue();
	}
	@Override
	public int executeSql(String sql) {
		Query query = getSession().createSQLQuery(sql);
		return query.executeUpdate();
	}
	@Override
	public List executeSqlSelct(String sql) {
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}
	@Override
	public void saveOrUpdate(Object obj) {
		getSession().saveOrUpdate(obj);
	}
	
	
}

