/*
 * 文件名：UserIAction.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： UserIAction.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年4月26日
 * 修改内容：新增
 */
package com.manager.action;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;


import com.manager.common.Const;
import com.manager.common.tools.MD5Util;
import com.manager.entity.UserInfo;
import com.manager.entity.view.UserInfoView;
import com.manager.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年4月26日
 * @since      CCAS
 */
public class UserAction extends BaseAction implements ModelDriven<UserInfoView>{

	private static final long serialVersionUID = -5369213220934305158L;

	private UserService userService;
	private String verification;    
	private UserInfoView userInfo;
	private String new_Password; 
	private String comfirm_Password;

	public String getComfirm_Password() {
		return comfirm_Password;
	}

	public void setComfirm_Password(String comfirm_Password) {
		this.comfirm_Password = comfirm_Password;
	}

	public String getNew_Password() {
		return new_Password;
	}

	public void setNew_Password(String new_Password) {
		this.new_Password = new_Password;
	}

	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}
	
	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 登录
	 * @return
	 */
	public String login(){
		//判断是否允许登录
  		boolean islogin= userService.checkLogin(userInfo);
		if(islogin){
			//将当前用户放入到session中
			session.put(Const.currentUser, userInfo);
			session.put(Const.LEVELS, Const.allLevels);
			return "fontPage";
		}
		addFieldError("loginError", "用户名或密码错误");
		return LOGIN;
	}
	/**
	 * 用户列表方法
	 * @return
	 */
	public String list() {
		UserInfoView currentUser = (UserInfoView)session.get(Const.currentUser);
		if (null == currentUser) {
			return LOGIN;
		}
		
		HashMap formParams = new HashMap<String,Object>();
		formParams.put(UserInfo.U_LEVEL,currentUser.getU_Level());
		
		int sum = userService.getCount(formParams, currentUser);
		
		//获取所有用户数量
		request.put("sum", sum);
		List<UserInfoView> list = userService.getList(formParams, currentUser);
		request.put(Const.USER_LIST, list);
		
		return "list";
	}
	public String delete(){
		
		if(userService.deleteUserInfo(userInfo)){
			setInputStream("1");
		}else{
			setInputStream("0");
		}
		return "ajax-success";
	}
	public String toEdit() {
		String uNumber = userInfo.getU_Number();
		UserInfoView userItem = userService.getUserInfoView(uNumber);
		userInfo.clone(userItem);
		return "toEdit";
	}
	
	public String toRegister() {
		return "toRegister";
	}
	
	public String doEdit() {
		try{
			userService.updateUserInfo(userInfo);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "ajax-success";
	}
	public String doReset() {
		try{
			String u_Number = userInfo.getU_Number();
			userService.doResetPassword(userInfo);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "ajax-success";
	}
	public String doRegister() {
		try{
			userService.AddUserInfo(userInfo);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "ajax-success";
	}
	public String logout(){
		session.clear();
		return LOGIN;
	}
	
	public String toAlterPassword(){
		return "toAlterPassword";
	}
	
	/**
	 * 检查原密码是否输出正确
	 */
	public String checkPassword(){
		UserInfoView currentuser = (UserInfoView) session.get(Const.currentUser);
		String clientPassword = MD5Util.getMD5(userInfo.getU_Password());
		if(currentuser.getU_Password().equals(clientPassword)){
			setInputStream("true");
		}else{
			setInputStream("false");
		}
		return "ajax-success";
	}
	
	public String doAlterPassword(){
		HashMap formParams = new HashMap<String,Object>();
		UserInfoView currentuser = (UserInfoView) session.get(Const.currentUser);
		formParams.put("new_Password",new_Password);
		formParams.put("comfirm_Password",comfirm_Password);
		if(userService.alterPassword(formParams, currentuser)){
			setInputStream("1");
		}else{
			setInputStream("0");
		}
		return "ajax-success";
	}
	@Override
	public UserInfoView getModel() {
		if(userInfo == null){
			userInfo = new UserInfoView();
		}
		return userInfo;
	}
	
}

