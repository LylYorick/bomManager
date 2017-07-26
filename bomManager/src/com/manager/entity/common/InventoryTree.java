/*
 * 文件名：InventoryTree.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： InventoryTree.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月13日
 * 修改内容：新增
 */
package com.manager.entity.common;
/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月13日
 * @since      CCAS
 */
public class InventoryTree {
	private int id;
	private int pid;
	private String value;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public InventoryTree() {
		super();
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "InventoryTree [id=" + id + ", pid=" + pid + ", value=" + value + ", name=" + name + "]";
	}
	public InventoryTree(int id, int pid, String value, String name) {
		super();
		this.id = id;
		this.pid = pid;
		this.value = value;
		this.name = name;
	}
	
	
}

