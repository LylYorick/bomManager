/*
 * 文件名：OrderEnum.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： OrderEnum.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月25日
 * 修改内容：新增
 */
package com.manager.entity.common;

import java.util.Date;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月25日
 * @since      CCAS
 */
public enum OrderEnum {

	ORDERNUMBER(1,"订单编号","orderNumber"),
	ORDERMODE(2,"订单分类","orderMode"),
	ORDERNAME(3,"名称","orderName"),
	ORDERTYPE(4,"类型","orderType"),
	ORDERQTY(5,"数量","orderQty"),
	ORDERMATERIAL(6,"材料","orderMaterial"),
	ORDERDESC(7,"描述","orderDesc"),
	REQDATE(8,"需求日期","reqDate"),
	CONTACT(9,"联系人","contact"),
	CELLPHONE(10,"联系电话","cellPhone"),

	ADDRESS(11,"联系地址","address"),
	ORDERPRICE(12,"报价","orderPrice"),
	ORDERCONFIRM(13,"订单确认","orderConfirm"),
	ORDERSTATUS(14,"订单状态","orderStatus"),
	VERIFYTIME(15,"审核时间","verifyTime"),
	VERIFYBY(16,"审核人","verifyBy"),
	CONFIRMTIME(17,"确定时间","confirmTime"),
	CONFIRMBY(18,"确定人","confirmBy"),
	DELIVERED(19,"是否交货","delivered"),
	DELIVERYTIME(20,"交货日期","deliveryTime"),
	PAYMENT(21,"结算金额","payment"),
	PAYWAY(22,"结算方式","payWay"),
	PAID(23,"是否结算","paid"),
	EXPRESS(24,"运输方式","express"),
	EXPRESSNUM(25,"快递单号","expressNum"),
	FILENAME(26,"文件名","fileName");
	
	int id;
	String value;
	String name;


	private OrderEnum(int id, String value, String name) {
		this.id = id;
		this.value = value;
		this.name = name;
	}
	
	public static void main(String[] args) {
		  for (OrderEnum e : OrderEnum.values()) {
	            System.out.println(e.value);
	        }
	}
}

