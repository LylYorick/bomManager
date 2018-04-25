/*
 * 文件名：MessageModel.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： MessageModel.java
 * 修改人：liyuelong 1610139
 * 修改时间：2018年4月23日
 * 修改内容：新增
 */
package com.manager.entity.model;

import java.io.File;

import com.manager.common.JsonResult;
import com.manager.entity.Bom;
import com.manager.entity.Message;
import com.manager.entity.common.Pagebean;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2018年4月23日
 * @since      CCAS
 */
public class MessageModel extends BaseModel{
	private Message entity;
	private JsonResult result;
	private String  imgFileName;
	private File img;
	private String imgContentType;
	private String beginDate;
	private String endDate;
	private String dir;
	public Message getEntity() {
		return entity;
	}
	public void setEntity(Message entity) {
		this.entity = entity;
	}
	public JsonResult getResult() {
		return result;
	}
	public void setResult(JsonResult result) {
		this.result = result;
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
	
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "MessageModel [entity=" + entity + ", result=" + result + ", imgFileName=" + imgFileName + ", img=" + img
				+ ", imgContentType=" + imgContentType + ", beginDate=" + beginDate + ", endDate=" + endDate + ", dir="
				+ dir + "]";
	}
	public MessageModel() {
		super();
		this.entity = new Message();
		this.pageBean = new Pagebean();
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	
	
	
}

