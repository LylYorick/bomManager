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

import com.manager.entity.Bom;
import com.manager.entity.Order;
import com.manager.entity.common.Pagebean;
/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月6日
 * @since      CCAS
 */
public class BomModel extends BaseModel {
	private Bom entity;
	private String  docFileName;
	private File doc;
	private String docContentType;
	public Bom getEntity() {
		return entity;
	}

	public void setEntity(Bom entity) {
		this.entity = entity;
	}
	public BomModel() {
		super();
		this.entity = new Bom();
		this.pageBean = new Pagebean();
	}

	public String getDocFileName() {
		return docFileName;
	}

	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}

	public File getDoc() {
		return doc;
	}

	public void setDoc(File doc) {
		this.doc = doc;
	}

	public String getDocContentType() {
		return docContentType;
	}

	public void setDocContentType(String docContentType) {
		this.docContentType = docContentType;
	}
	
}

