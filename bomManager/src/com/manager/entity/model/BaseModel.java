/*
 * 文件名：BaseModel.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： BaseModel.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月6日
 * 修改内容：新增
 */
package com.manager.entity.model;

import com.manager.entity.common.Pagebean;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月6日
 * @since      CCAS
 */
public class BaseModel {
	protected Pagebean pageBean;
	public Pagebean getPageBean() {
		return pageBean;
	}
	public void setPageBean(Pagebean pageBean) {
		this.pageBean = pageBean;
	}
}

