/*
 * 文件名：Message.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Message.java
 * 修改人：liyuelong 1610139
 * 修改时间：2018年4月23日
 * 修改内容：新增
 */
package com.manager.entity;

import com.manager.entity.common.Pagebean;

/**
 * 最新消息列表
 * @author     liyuelong 1610139
 * @version    CCAS 2018年4月23日
 * @since      CCAS
 */
public class Message {
	
	/** id 主键 */
	private Integer id;
	/** 消息描述*/
	private String desc;
	/** 消息标题*/
	private String title;
	/** 创建时间*/
	private String created;
	/** 修改时间*/
	private String updated;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", desc=" + desc + ", title=" + title + ", created=" + created + ", updated="
				+ updated + "]";
	}
	
}

