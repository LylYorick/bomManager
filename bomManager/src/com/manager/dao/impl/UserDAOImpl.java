/*
 * 文件名：UserDao.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： UserDao.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年4月18日
 * 修改内容：新增
 */
package com.manager.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.manager.dao.UserDAO;
import com.manager.entity.UserInfo;
import com.manager.entity.view.UserInfoView;


/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年4月18日
 * @since      CCAS
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl implements UserDAO{

	@Override
	public int getId() {
		String hql = "SELECT count(*) FROM UserInfo b ";
		Query query = this.getSession().createQuery(hql);
		return ((Number)query.uniqueResult()).intValue();
		
	}
	@Override
	public int getcount() {
		String hql = "SELECT count(*) FROM UserInfo b where b.userType = '0'";
		Query query = getSession().createQuery(hql);
		int sum = ((Number)query.uniqueResult()).intValue();
		 return sum;
	}
	
	@Override
	public List<UserInfo> getAll() {
		String hql = "FROM UserInfo b where b.userType = '0'";
		return getSession().createQuery(hql).list();
	}

	@Override
	public UserInfo getUserInfoByUserLoginId(String userLoginId) {
		String hql = "From UserInfo b where b.userLoginId = ?";
		Query query = getSession().createQuery(hql).setString(0, userLoginId);
		UserInfo userInfo = (UserInfo) query.uniqueResult();
		//防止出现空指针异常
		if(userInfo!= null){
			return userInfo;
		}
		return new UserInfo();
		
	}

	@Override
	public UserInfo getUserInfoByUserId(int userId) {
		String hql = "From UserInfo b where b.userId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, userId);
		UserInfo userInfo = (UserInfo) query.uniqueResult();
		//防止出现空指针异常
		if(userInfo!= null){
			return userInfo;
		}
		return null;
	}

	@Override
	public void saveOrUpdate(UserInfo userInfo) {
		getSession().saveOrUpdate(userInfo);
	}
	
	/*public boolean delete(UserInfo userInfo){
		String userId = userInfo.getuNumber();
		String hql = "DELETE From UserInfo b where b.userId = ?";
		// executeUpdate(sql)的返回值是更新的条数
		int result= getSession().createQuery(hql).setInteger(0, userId).executeUpdate();
		if(result == 1){
			return true;
		}
		return false;
	}*/
	
	@Override
	public UserInfo get(Serializable key) {
		return (UserInfo)(this.get(UserInfo.class, key));
	}
}

