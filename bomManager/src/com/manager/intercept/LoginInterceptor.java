/*
 * 文件名：LoginIntercepter.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： LoginIntercepter.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年5月6日
 * 修改内容：新增
 */
package com.manager.intercept;

import java.util.Map;

import com.manager.action.BaseAction;
import com.manager.common.Const;
import com.manager.entity.UserInfo;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年5月6日
 * @since      CCAS
 */
public class LoginInterceptor extends MethodFilterInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation paramActionInvocation) throws Exception {
			BaseAction  baseAction = (BaseAction) paramActionInvocation.getAction();
			Map<String, Object> sessionMap = baseAction.getSession();
			UserInfo currentUser = (UserInfo) sessionMap.get(Const.currentUser);
			if(currentUser != null ){
				return paramActionInvocation.invoke();
			}
		return "login";
	}


}

