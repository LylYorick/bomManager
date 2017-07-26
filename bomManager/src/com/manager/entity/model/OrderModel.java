/*
 * 文件名：OrderModel.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： OrderModel.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月6日
 * 修改内容：新增
 */
package com.manager.entity.model;
import java.io.File;

import com.manager.entity.Order;
import com.manager.entity.common.Pagebean;
/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月6日
 * @since      CCAS
 */
public class OrderModel extends BaseModel {
	private Order entity;
	private String  imgFileName;
	private File img;
	private String imgContentType;
	private String orderTime;

	public Order getEntity() {
		return entity;
	}

	public void setEntity(Order entity) {
		this.entity = entity;
	}

	public OrderModel() {
		super();
		this.entity = new Order();
		this.pageBean = new Pagebean();
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}
	
	
	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

}

