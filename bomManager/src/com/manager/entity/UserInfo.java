package com.manager.entity;

import java.util.Date;

public class UserInfo {
	public static String U_NUMBER = "u_Number";
	public static String U_PHONE = "u_Phone";
	public static String U_NAME = "u_Name";
	public static String U_COMANY = "u_Comany";
	/**
	 *  用户等级
	 */
	public static String U_LEVEL = "u_Level";
	private String u_Number; //格式控制为手机号
	private String u_Name;//用户名
	private String u_Password;// 密码
	private String u_Phone;// 联系方式 
	private String u_Title;// 用户职称
	private String u_Comany;// 公司名称
	private String u_Address;// 联系地址
	private int u_Level;// 用户等级
	private String u_Active;// 用户有效
	private Date u_CreateDate;// 建立日期
	private String u_Temp1;// 预留栏位1
	private String u_Temp2;// 预留栏位2
	private String u_Temp3;// 预留栏位3
	private double u_Temp4;// 预留栏位4
	private Date u_Temp5;// 预留栏位5
	private String editor;//编辑人
	private Date datetime;//时间
	public String getU_Number() {
		return u_Number;
	}
	public void setU_Number(String u_Number) {
		this.u_Number = u_Number;
	}
	public String getU_Name() {
		return u_Name;
	}
	public void setU_Name(String u_Name) {
		this.u_Name = u_Name;
	}
	public String getU_Password() {
		return u_Password;
	}
	public void setU_Password(String u_Password) {
		this.u_Password = u_Password;
	}
	public String getU_Phone() {
		return u_Phone;
	}
	public void setU_Phone(String u_Phone) {
		this.u_Phone = u_Phone;
	}
	public String getU_Title() {
		return u_Title;
	}
	public void setU_Title(String u_Title) {
		this.u_Title = u_Title;
	}
	public String getU_Comany() {
		return u_Comany;
	}
	public void setU_Comany(String u_Comany) {
		this.u_Comany = u_Comany;
	}
	public String getU_Address() {
		return u_Address;
	}
	public void setU_Address(String u_Address) {
		this.u_Address = u_Address;
	}
	public int getU_Level() {
		return u_Level;
	}
	public void setU_Level(int u_Level) {
		this.u_Level = u_Level;
	}
	public String getU_Active() {
		return u_Active;
	}
	public void setU_Active(String u_Active) {
		this.u_Active = u_Active;
	}
	public Date getU_CreateDate() {
		return u_CreateDate;
	}
	public void setU_CreateDate(Date u_CreateDate) {
		this.u_CreateDate = u_CreateDate;
	}
	public String getU_Temp1() {
		return u_Temp1;
	}
	public void setU_Temp1(String u_Temp1) {
		this.u_Temp1 = u_Temp1;
	}
	public String getU_Temp2() {
		return u_Temp2;
	}
	public void setU_Temp2(String u_Temp2) {
		this.u_Temp2 = u_Temp2;
	}
	public String getU_Temp3() {
		return u_Temp3;
	}
	public void setU_Temp3(String u_Temp3) {
		this.u_Temp3 = u_Temp3;
	}
	public double getU_Temp4() {
		return u_Temp4;
	}
	public void setU_Temp4(double u_Temp4) {
		this.u_Temp4 = u_Temp4;
	}
	public Date getU_Temp5() {
		return u_Temp5;
	}
	public void setU_Temp5(Date u_Temp5) {
		this.u_Temp5 = u_Temp5;
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
	
}
