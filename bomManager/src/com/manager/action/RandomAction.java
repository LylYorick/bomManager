/*
 * 文件名：RandomAction.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： RandomAction.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年5月5日
 * 修改内容：新增
 */
package com.manager.action;

import java.io.ByteArrayInputStream;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.manager.common.tools.RandomNumUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年5月5日
 * @since      CCAS
 */
public class RandomAction extends ActionSupport implements SessionAware {
	
	private ByteArrayInputStream inputStream;    

	private Map<String, Object> session; 
	
	public String execute() throws Exception{     
		
	RandomNumUtil rdnu=RandomNumUtil.Instance(); 
	
	this.setInputStream(rdnu.getImage());//取得带有随机字符串的图片      
	session.put("sessionCode", rdnu.getString());//取得随机字符串放入HttpSession      
		return SUCCESS;      
	}      
	public void setInputStream(ByteArrayInputStream inputStream) {      
	this.inputStream = inputStream;      
	}      
	public ByteArrayInputStream getInputStream() {      
	return inputStream;      
	}  
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

