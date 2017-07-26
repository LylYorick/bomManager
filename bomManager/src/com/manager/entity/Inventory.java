/*
 * 文件名：Invlog.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Invlog.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月12日
 * 修改内容：新增
 */
package com.manager.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月12日
 * @since      CCAS
 */
public class Inventory implements Serializable{
	//和 Supplier相同的Id
	private SupplierId id;
	private int hashCode = Integer.MIN_VALUE;
	private String partName;//名称
	private String partUnit;//单位 
	private BigDecimal i_Qty;//库存数量
	private String m_Editor;//编辑人
	private Date m_Datetime;//时间
	
	public SupplierId getId() {
		return id;
	}
	public void setId(SupplierId id) {
		this.id = id;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getPartUnit() {
		return partUnit;
	}
	public void setPartUnit(String partUnit) {
		this.partUnit = partUnit;
	}
	public BigDecimal getI_Qty() {
		return i_Qty;
	}
	public void setI_Qty(BigDecimal i_Qty) {
		this.i_Qty = i_Qty;
	}
	public String getM_Editor() {
		return m_Editor;
	}
	public void setM_Editor(String m_Editor) {
		this.m_Editor = m_Editor;
	}
	
	public Date getM_Datetime() {
		return m_Datetime;
	}
	public void setM_Datetime(Date m_Datetime) {
		this.m_Datetime = m_Datetime;
	}
	@Override
	public int hashCode() {
		 if (Integer.MIN_VALUE == this.hashCode)
	        {
	            if (null == this.getId())
	                return super.hashCode();
	            else
	            {
	                String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
	                this.hashCode = hashStr.hashCode();
	            }
	        }
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {

		  if (null == obj)
	            return false;
	        if (!(obj instanceof Inventory))
	            return false;
	        else
	        {
	        	Inventory   invlog = (Inventory) obj;
	            if (null == this.getId() || null == invlog.getId())
	                return false;
	            else
	                return (this.getId().equals(invlog.getId()));
	        }
	}
	@Override
	public String toString() {
		return "Invlog [id=" + id + ", partName=" + partName + ", partUnit=" + partUnit + ", i_Qty=" + i_Qty
				+ ", m_Editor=" + m_Editor + ", m_Datetime=" + m_Datetime + "]";
	}
	

}

