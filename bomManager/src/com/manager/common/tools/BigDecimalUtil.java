/*
 * 文件名：BigDecimal.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： BigDecimal.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年3月20日
 * 修改内容：新增
 */
package com.manager.common.tools;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年3月20日
 * @since      CCAS
 */
public class BigDecimalUtil
{

    public static String format(BigDecimal amount)
    {
        DecimalFormat df = new DecimalFormat("#,##0.00#");
        return df.format(amount.setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    /**
     * 将bigDecimal对象的精度设定为两位小数
     * @return String类型
     */
    public static String formatDecmical(BigDecimal amount)
    {
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(amount);
    }
    
    /**
     * 将bigDecimal对象的精度设定为两位小数
     * @return BigDecimal类型
     */
    public static BigDecimal Decimalformat(BigDecimal amount)
    {
    	BigDecimal bigDecimal = new BigDecimal(formatDecmical(amount));
        return bigDecimal;
    }

    /**
     * @param arg1 被减数
     * @param arg2 减数
     * @return 保留两位小数的结果
     */
    public static String subtract(Object arg1, Object arg2)
    {
        BigDecimal minumend = StringUtil.toBigDecimal(arg1);
        BigDecimal subtrahend = StringUtil.toBigDecimal(arg2);
        BigDecimal result = minumend.subtract(subtrahend);
        return formatDecmical(result);
    }

    public static void main(String[] args)
    {
        BigDecimal a = new BigDecimal(-120.457);
        System.out.println(formatDecmical(a));
    }

}
