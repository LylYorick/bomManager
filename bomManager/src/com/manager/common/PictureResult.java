/*
 * 文件名：PictureResult.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： PictureResult.java
 * 修改人：liyuelong 1610139
 * 修改时间：2018年4月23日
 * 修改内容：新增
 */
package com.manager.common;
/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2018年4月23日
 * @since      CCAS
 */
public class PictureResult {

	private int error;
	private String url;
	private String message;
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}


