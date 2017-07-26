/*
 * 文件名：TimeHelper.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： TimeHelper.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月25日
 * 修改内容：新增
 */
package com.manager.common.tools;

import java.util.Date;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月25日
 * @since      CCAS
 */
public class TimeHelper {
	private static	String oneWeek = "1";
	private static	String oneMonth = "2";
	private static	String oneYear = "3";
	
	public static String comverToOrderTime(String orderTime){
		 if(StringUtil.isNullOrWhiteSpace(orderTime)){
			 return "";
		 }
		 String date ="";
		 if(oneWeek.equals(orderTime)){
			 date = DateUtil.currDateAddDay(-7);
		 }else if(oneMonth.equals(orderTime)){
			 date = DateUtil.addmonths(-1);
		 }else{
			 date = DateUtil.addmonths(-12);
		 }
		return "XHH"+date;
	}
}

