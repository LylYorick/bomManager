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

import com.manager.entity.UserInfo;
import com.manager.entity.view.UserInfoView;


/**
 * 
 * @author     liyuelong 1610139
 * @version    CCAS 2017年4月22日
 * @since      CCAS
 */
public interface UserService {
	
	public int getCount(Map formParams,UserInfoView userInfoView);
	public List getAll();
	public boolean checkLogin(UserInfoView userInfo);
	public UserInfoView getUserInfoView(String uNumber);
	public UserInfo getUserInfoByUserLoginId(String userLoginId);
	public void builhql(StringBuffer hql,Map formParams,UserInfoView userInfoView,HashMap sqlParams);

	public List<UserInfoView> getList(Map formParams,UserInfoView UserInfoView);
	/**
	 * 修改用户信息
	 * @param userInfo
	 * @return
	 */
	public boolean updateUserInfo(UserInfoView userInfoView);
	/**
	 * 重置用户密码
	 */
	void doResetPassword(UserInfoView userInfoView);
	
	/**
	 * 添加普通用户
	 * @param userInfo
	 * @return
	 */
	public boolean AddUserInfo(UserInfoView userInfoView);
	
	/**
	 * 删除用户
	 * @param userInfo
	 * @return
	 */
	public boolean deleteUserInfo(UserInfo userInfo);
	
	public boolean alterPassword(Map formParams,UserInfoView UserInfoView);
}


