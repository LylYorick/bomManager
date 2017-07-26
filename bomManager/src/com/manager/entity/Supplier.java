package com.manager.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class Supplier implements  Serializable{
	private static final long serialVersionUID = 1L;
	private int hashCode = Integer.MIN_VALUE;
	private SupplierId id;
	private String partName;
	private String supplierCode;
	private String partSpec;
	private String partStandard;
	private String partUnit;

	private BigDecimal partPrice;
	private String partActive;
	private String s_Temp1;// 预留栏位1
	private BigDecimal s_Temp2;// 预留栏位2
	private String editor;//编辑人
	private Date datetime;//时间
	
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
	public String getPartSpec() {
		return partSpec;
	}
	public void setPartSpec(String partSpec) {
		this.partSpec = partSpec;
	}
	public String getPartStandard() {
		return partStandard;
	}
	public void setPartStandard(String partStandard) {
		this.partStandard = partStandard;
	}
	public String getPartUnit() {
		return partUnit;
	}
	public void setPartUnit(String partUnit) {
		this.partUnit = partUnit;
	}
	public BigDecimal getPartPrice() {
		return partPrice;
	}
	public void setPartPrice(BigDecimal partPrice) {
		this.partPrice = partPrice;
	}
	public String getPartActive() {
		return partActive;
	}
	public void setPartActive(String partActive) {
		this.partActive = partActive;
	}
	public String getS_Temp1() {
		return s_Temp1;
	}
	public void setS_Temp1(String s_Temp1) {
		this.s_Temp1 = s_Temp1;
	}
	public BigDecimal getS_Temp2() {
		return s_Temp2;
	}
	public void setS_Temp2(BigDecimal s_Temp2) {
		this.s_Temp2 = s_Temp2;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
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
	        if (!(obj instanceof Material))
	            return false;
	        else
	        {
	        	Supplier   supplier = (Supplier) obj;
	            if (null == this.getId() || null == supplier.getId())
	                return false;
	            else
	                return (this.getId().equals(supplier.getId()));
	        }
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public Supplier() {
		super();
	}
	public Supplier(SupplierId id) {
		super();
		this.id = id;
	}
	
	
}

