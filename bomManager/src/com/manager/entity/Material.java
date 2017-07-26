package com.manager.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Material implements Serializable {
	private int hashCode = Integer.MIN_VALUE;

	private static final long serialVersionUID = 1L;

	
	
	private MaterialId id;
	private String partName;
	private String partDesc;
	private String tuNumber;
	private String partSpec;
	private String partStandard;
	private String partModel;
	private String partType;
	private String partUnit;
	private String partCost;
	private BigDecimal partQty=new BigDecimal(0);
	private BigDecimal partPrice=new BigDecimal(0);
	private String partRemark;
	private  String temp1;
	private String temp2;
	private String temp3;
	private BigDecimal temp4;
	private  Date temp5;
	private String editor;
	private Date datetime=new Date();
	public MaterialId getId() {
		return id;
	}
	public void setId(MaterialId id) {
		this.id = id;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getPartDesc() {
		return partDesc;
	}
	public void setPartDesc(String partDesc) {
		this.partDesc = partDesc;
	}
	public String getTuNumber() {
		return tuNumber;
	}
	public void setTuNumber(String tuNumber) {
		this.tuNumber = tuNumber;
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
	public String getPartModel() {
		return partModel;
	}
	public void setPartModel(String partModel) {
		this.partModel = partModel;
	}
	public String getPartType() {
		return partType;
	}
	public void setPartType(String partType) {
		this.partType = partType;
	}
	public String getPartUnit() {
		return partUnit;
	}
	public void setPartUnit(String partUnit) {
		this.partUnit = partUnit;
	}
	public String getPartCost() {
		return partCost;
	}
	public void setPartCost(String partCost) {
		this.partCost = partCost;
	}
	public BigDecimal getPartQty() {
		return partQty;
	}
	public void setPartQty(BigDecimal partQty) {
		this.partQty = partQty;
	}
	public BigDecimal getPartPrice() {
		return partPrice;
	}
	public void setPartPrice(BigDecimal partPrice) {
		this.partPrice = partPrice;
	}
	public String getPartRemark() {
		return partRemark;
	}
	public void setPartRemark(String partRemark) {
		this.partRemark = partRemark;
	}
	public String getTemp1() {
		return temp1;
	}
	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}
	public String getTemp2() {
		return temp2;
	}
	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}
	public String getTemp3() {
		return temp3;
	}
	public void setTemp3(String temp3) {
		this.temp3 = temp3;
	}
	public BigDecimal getTemp4() {
		return temp4;
	}
	public void setTemp4(BigDecimal temp4) {
		this.temp4 = temp4;
	}
	public Date getTemp5() {
		return temp5;
	}
	public void setTemp5(Date temp5) {
		this.temp5 = temp5;
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
	        	Material   material = (Material) obj;
	            if (null == this.getId() || null == material.getId())
	                return false;
	            else
	                return (this.getId().equals(material.getId()));
	        }
	}
}
