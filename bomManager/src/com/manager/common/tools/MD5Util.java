/*
 * 文件名：MD5Util.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： MD5Util.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年5月7日
 * 修改内容：新增
 */
package com.manager.common.tools;
/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年5月7日
 * @since      CCAS
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public final static String getMD5(String s) {
		String result = "";
		char hexDidits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d',
				'e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u',
				'v','w','x','y','z'};
			MessageDigest mdTemp = null;
			try {
				mdTemp = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			byte[] strTemp = s.getBytes();
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j*2];
			int k = 0;
			for(int i=0;i<j;i++) {
				byte b = md[i];
				str[k++] = hexDidits[b>>4&0xf];
				str[k++] = hexDidits[b&0xf];
			}
			result = new String(str);
		return result;
	}
        public static void main(
                String args[]) throws Exception{
            System.out.println(getMD5("123"));
        }
}
