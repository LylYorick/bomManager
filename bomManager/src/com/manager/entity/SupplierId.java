/*
 * 文件名：Supplier.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Supplier.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月6日
 * 修改内容：新增
 */
package com.manager.entity;

import java.io.Serializable;

public class SupplierId implements Serializable{
	private String partnumber;
	private String partRev;
	private String supplierName;
	public String getPartnumber() {
		return partnumber;
	}
	public void setPartnumber(String partnumber) {
		this.partnumber = partnumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partRev == null) ? 0 : partRev.hashCode());
		result = prime * result + ((partnumber == null) ? 0 : partnumber.hashCode());
		result = prime * result + ((supplierName == null) ? 0 : supplierName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SupplierId other = (SupplierId) obj;
		if (partRev == null) {
			if (other.partRev != null)
				return false;
		} else if (!partRev.equals(other.partRev))
			return false;
		if (partnumber == null) {
			if (other.partnumber != null)
				return false;
		} else if (!partnumber.equals(other.partnumber))
			return false;
		if (supplierName == null) {
			if (other.supplierName != null)
				return false;
		} else if (!supplierName.equals(other.supplierName))
			return false;
		return true;
	}
	public String getPartRev() {
		return partRev;
	}
	public void setPartRev(String partRev) {
		this.partRev = partRev;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public SupplierId() {
		super();
	}
	
}

