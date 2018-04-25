/*
 * 文件名：CommonMethod.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CommonMethod.java
 * 修改人：liyuelong 1610139
 * 修改时间：2018年4月23日
 * 修改内容：新增
 */
package com.manager.common;

import java.util.Date;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2018年4月23日
 * @since      CCAS
 */
public class CommonMethod {
	/**
	 * 对上传的文件进行重命名 
	 * 新文件名为当前时间的毫秒值
	 * @param fileName
	 */
	public static String renameFileName(String fileName){
		String[] arry = fileName.split("\\.");
		String fileType = arry[arry.length - 1];
		long currentTimeMillis = System.currentTimeMillis();
		return currentTimeMillis + "." + fileType;
	}
}

