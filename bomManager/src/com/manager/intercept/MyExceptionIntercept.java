/*
 * 文件名：MyExceptionIntercept.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： MyExceptionIntercept.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年8月8日
 * 修改内容：新增
 */
package com.manager.intercept;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年8月8日
 * @since      CCAS
 */
public class MyExceptionIntercept extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation ac) throws Exception {
		String result = "";	
		try{
			result=ac.invoke();
		}catch(Exception e){
		//	这里可以有多个catch，但要注意顺序问题，用于捕捉不同的异常，进行不同的处理

		}
		return null;
	}

}

