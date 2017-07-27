/*
 * 文件名：UserService.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： UserService.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年4月21日
 * 修改内容：新增
 */
package com.manager.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.manager.common.tools.MD5Util;
import com.manager.common.tools.StringUtil;
import com.manager.dao.UserDAO;
import com.manager.entity.UserInfo;
import com.manager.entity.view.UserInfoView;
import com.manager.service.UserService;


/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年4月21日
 * @since      CCAS
 */
@Service
public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO;
	public static String initPassword = MD5Util.getMD5("123456");
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	
	
	@Override
	public List getAll(){
		List<UserInfo> userInfos = userDAO.getAll(); 
		return userInfos;
	}

	
	
	
	@Override
	public boolean checkLogin(UserInfoView userInfo) {
		String uNumber  = userInfo.getU_Number();
		String password = userInfo.getU_Password();
		password = MD5Util.getMD5(password);
		UserInfo uInfo =  userDAO.get(uNumber);
		if(password.equals(uInfo.getU_Password())&&"Y".equals(uInfo.getU_Active())){
			userInfo.clone(new UserInfoView(uInfo));
			return true;
		}
		return false;
	}

	@Override
	public UserInfoView getUserInfoView(String uNumber) {
		UserInfoView uInfo =  new  UserInfoView(userDAO.get(uNumber));
		return uInfo;
	}

	@Override
	public UserInfo getUserInfoByUserLoginId(String userLoginId) {
		UserInfo uInfo =  userDAO.getUserInfoByUserLoginId(userLoginId);
		return uInfo;
	}

	@Override
	public boolean updateUserInfo(UserInfoView userInfo) {
		
		UserInfo property = userDAO.get(userInfo.getU_Number());
		
		UserInfo item = userInfo.castToSon();
		item.setU_Password(property.getU_Password());
		item.setEditor(property.getU_Name());
		item.setU_Active(property.getU_Active());
		item.setDatetime(new  Date());
		if(item.getU_Level() == 0 ){
			item.setU_Level(property.getU_Level());
		}
		userDAO.update(item);;
		return true;
	}

	@Override
	public boolean AddUserInfo(UserInfoView userInfoView) {
		userInfoView.setU_Password(initPassword);
		userInfoView.setU_CreateDate(new Date());
		userInfoView.setU_Level(1);
		userInfoView.setU_Active("Y");
		userInfoView.setEditor(userInfoView.getU_Name());
		userInfoView.setDatetime(new Date());
		UserInfo userInfo  =  userInfoView.castToSon();
		userDAO.saveOrUpdate(userInfo);
		return true;
	}

	@Override
	public boolean deleteUserInfo(UserInfo userInfo) {
		UserInfo item = (UserInfo) userDAO.get(UserInfo.class, userInfo.getU_Number());
		return userDAO.delete(item);
	}
	@Override
	public void builhql(StringBuffer hql,Map formParams,UserInfoView userInfoView,HashMap sqlParams){
		int u_Level = (Integer) formParams.get(UserInfo.U_LEVEL);
		if(u_Level != 0){
			hql.append(" and e.u_Level <= :u_Level");
		    sqlParams.put("u_Level", u_Level);
		}
		String  u_Comany = (String) formParams.get(UserInfo.U_COMANY);
		if(!StringUtil.isNullOrWhiteSpace(u_Comany)){
			hql.append(" and e.u_Comany = :u_Comany");
		    sqlParams.put("u_Comany", u_Comany);
		}
		String  u_Number = (String) formParams.get(UserInfo.U_NUMBER);
		if(!StringUtil.isNullOrWhiteSpace(u_Number)){
			hql.append(" and e.u_Number = :u_Number");
		    sqlParams.put("u_Number", u_Number);
		}
		
	}

	@Override
	public int getCount(Map formParams, UserInfoView userInfoView) {
		StringBuffer hql = new StringBuffer("SELECT count(*) From UserInfo e where 1=1 ");
		int u_Level = (Integer) formParams.get(UserInfo.U_LEVEL);
		if(u_Level == 1 || u_Level == 2 ){
			formParams.put(UserInfo.U_NUMBER, userInfoView.getU_Number());
		}else if(u_Level == 3){
			formParams.put(UserInfo.U_COMANY, userInfoView.getU_Comany());
		}
		HashMap sqlParams = new HashMap();
		builhql(hql, formParams, userInfoView, sqlParams);
		return userDAO.getCount(hql.toString(), sqlParams);
	}

	@Override
	public List<UserInfoView> getList(Map formParams, UserInfoView userInfoView) {
		//hql语句
		StringBuffer hql = new StringBuffer("select new com.manager.entity.view.UserInfoView(e) From UserInfo e where 1=1 ");
		// 查询参数列表
		HashMap sqlParams = new HashMap();
		builhql(hql, formParams,userInfoView,sqlParams);
		List<UserInfoView> list = userDAO.executeHQL(hql.toString(), sqlParams);
		return list;
	}
	
}

