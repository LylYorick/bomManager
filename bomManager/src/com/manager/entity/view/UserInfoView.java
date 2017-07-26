package com.manager.entity.view;


import org.apache.commons.beanutils.BeanUtils;

import com.manager.entity.UserInfo;

public class UserInfoView extends UserInfo {
	private static final long serialVersionUID = 1L;

	public UserInfoView() {
		super();
	}
	public void  clone(UserInfoView userInfoView){
		try {
			BeanUtils.copyProperties(this, userInfoView);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public UserInfo  castToSon(){
		UserInfo userInfo  = new UserInfo();
		try {
			BeanUtils.copyProperties(userInfo, this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfo;
	}
	public UserInfoView(UserInfo userInfo) {
		try {
			BeanUtils.copyProperties(this, userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
