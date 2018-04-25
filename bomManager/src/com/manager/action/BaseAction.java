/*
 * 文件名：BaseAction.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： BaseAction.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年5月6日
 * 修改内容：新增
 */
package com.manager.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.manager.entity.common.Pagebean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年5月6日
 * @since      CCAS
 */
public class BaseAction extends ActionSupport implements SessionAware ,RequestAware {
	private static final long serialVersionUID = 1L;

	public static String LIST = "list";
	public final static String JSON = "json";
	
	
	protected Map<String, Object> session;
	
	protected Map<String, Object> request;
	protected InputStream inputStream;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession(){
	    return this.session;
	}
	
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public String toAdd() {
		return "toAdd";
	}
	
	public void setInputStream(String result){
		try {
			inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
	}
	
	
	
}

