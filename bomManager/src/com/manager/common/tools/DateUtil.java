package com.manager.common.tools;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/**
 * <p>
 * Title: 日期处理的支持类
 * </p>
 * <p>
 * Description: 只能使用它的静态方法
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: 雁联
 * </p>
 * 
 * @author 郭兵
 * @version 1.0
 */
public class DateUtil
{

    private DateUtil()
    {
    };

    /**
     * 获取当前日期字符串，格式为dd/MM/yyyy
     * 
     * @return String
     */
    public static String getCurrentDateByMOType()
    {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }

    /**
     * 获取当前日期字符串，yyyyMMdd格式为dd/MM/yyyy
     * 
     * @return String
     */
    public static String setDateFormatByMOType(String date)
    {
        if (date != null && date.length() == 8)
            return date.substring(6) + "/" + date.substring(4, 6) + "/" + date.substring(0, 4);
        else
            return date;
    }

    /**
     * 获取当前日期字符串，yyyyMMdd格式为dd/MM/yy
     * 
     * @return String
     */
    public static String setDateFormatByMO(String date)
    {
        if (date != null && date.length() == 8)
            return date.substring(6) + "/" + date.substring(4, 6) + "/" + date.substring(2, 4);
        else
            return date;
    }

    /**
     * 获取当前日期字符串，yyyyMMdd格式为YYMMDD
     * 
     * @return String
     */
    public static String setDateFormatByMSGType(String date)
    {
        if (date.length() == 8)
            return date.substring(2, 4) + date.substring(4, 6) + date.substring(6);
        else
            return date;
    }

    /**
     * 將格式为dd/MM/yyyy的日期轉換為yyyyMMdd
     * 
     * @return String
     */
    public static String setMOTypeToDef(String date)
    {
        if (date.length() == 10)
        {
            String[] dateArray = date.split("/");
            if (dateArray.length == 3)
                return dateArray[2] + dateArray[1] + dateArray[0];
            else
                return date;
        }
        else
            return date;
    }

    /**
     * 获取对应Date的日期字符串，格式为dd/MM/yyyy
     * 
     * @param date
     *            源Date
     * @return String
     */
    public static String getPrettyDateByMOType(String forMat, Date date)
    {
        if (null != forMat && !"".equals(forMat))
        {
            return new SimpleDateFormat(forMat).format(date);
        }
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    static SimpleDateFormat prettyDateTimeByMOType = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    /**
     * 获取对应Date的字符串，格式为dd/MM/yyyy HH:mm:ss
     * 
     * @param date
     *            源Date
     * @return String
     */
    public static String getPrettyDateTimeByMOType(Date date)
    {
        return prettyDateTimeByMOType.format(date);
    }

    public static String getPrettyDateTimeByMOType()
    {
        return prettyDateTimeByMOType.format(new Date());
    }
    

 
    /**
     * 把日期转化成月份
     * @param month "mm/yyyy
     * @return "yyyymm"
     */
    public static String convertMonth(String month)
    {
        if (StringUtil.isNullOrWhiteSpace(month))
            return null;
        String[] temp = month.split("/");
        return temp[1] + temp[0];
    }

    /**
     * 获取当前日期字符串，格式为yyyyMMdd
     * 
     * @return String
     */
    public static String getCurrentDate()
    {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    /**
     * 获取当前日期字符串，格式为yyyy-MM-dd
     * 
     * @return String
     */
    public static String getCurrentDate10()
    {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * 获取当前日期字符串，格式为yyyy-MM-dd
     * 
     * @return String
     */
    public static String setDate8to10(String date)
    {
        if (date.length() == 8)
            return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6);
        else
            return date;
    }

    public static String setTimeFormat(String time)
    {
        if (time != null)
        {
            time = time.trim();
            if (time.length() == 6)
                return time.substring(0, 2) + ":" + time.substring(2, 4) + ":" + time.substring(4);
            else if (time.length() == 4)
                return time.substring(0, 2) + ":" + time.substring(2, 4);
            else
                return time;
        }
        else
            return time;
    }

    /**
     * 获取当前时间字符串，格式为HHmmss
     * 
     * @return String
     */
    public static String getCurrentTime()
    {
        return new SimpleDateFormat("HHmmss").format(new Date());
    }

    public static String getCurrentDateTime()
    {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    /**
     * 获取当前的毫秒时间，为long值
     * 
     * @return long
     */
    public static long getCurrentLongTime()
    {
        return new Date().getTime();
    }

    /**
     * 获取当前时间的字符串，格式为yyyy-MM-dd HH:mm:ss
     * 
     * @return String
     */
    public static String getCurrentPrettyDateTime()
    {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * 获取当前时间的字符串，格式为yyyy
     * 
     * @return String
     */
    public static String getCurrentPrettyYear()
    {
        return new SimpleDateFormat("yyyy").format(new Date());
    }

    /**
     * 获取当前时间的字符串，格式为yyyyMM
     * 
     * @return String
     */
    public static String getCurrentPrettyMonth()
    {
        return new SimpleDateFormat("yyyyMM").format(new Date());
    }

    /**
     * 获取对应Date的日期字符串，格式为yyyyMMdd
     * 
     * @param date
     *            源Date
     * @return
     */
    public static String getDate(Date date)
    {
        return new SimpleDateFormat("yyyyMMdd").format(date);
    }

    /**
     * 获取对应Date的时间字符串，格式为HHmmss
     * 
     * @param date
     *            源Date
     * @return String
     */
    public static String getTime(Date date)
    {
        return new SimpleDateFormat("HHmmss").format(date);
    }

    /**
     * 获取对应Date的时间字符串，格式为HH:mm:ss
     * 
     * @param date
     *            源Date
     * @return String
     */
    public static String getTime2(Date date)
    {
        return new SimpleDateFormat("HH:mm:ss").format(date);
    }

    /**
     * 获取对应Date的日期字符串，格式为yyyy-MM-dd
     * 
     * @param date
     *            源Date
     * @return String
     */
    public static String getPrettyDate(Date date)
    {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    /**
     * 获取对应Date的字符串，格式为yyyy-MM-dd HH:mm:ss
     * 
     * @param date
     *            源Date
     * @return String
     */
    public static String getPrettyDateTime(Date date)
    {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    /**
     * 获取Sybase的日期转换函数表达式，用于SQL中，格式是yyyy/MM/dd HH:mm:ss，没办法，Sybase不支持yyyy-MM-dd
     * HH:mm:ss
     * 
     * @param field
     *            要转换成yyyy/MM/dd HH:mm:ss格式字符串的日期类型字段名
     * @return String
     */
    public static String getSybaseConvertSQL(String field)
    {
        return "(CONVERT(varchar(12), " + field + ", 111) + ' ' + CONVERT(varchar(12), " + field + ", 108))";
    }

    /**
     * 获取Sybase的日期转换函数表达式，用于SQL中，格式是yyyy/MM/dd HH:mm:ss，没办法，Sybase不支持yyyy-MM-dd
     * HH:mm:ss
     * 
     * @param field
     *            要转换成yyyy/MM/dd HH:mm:ss格式字符串的日期类型字段名
     * @return String
     */
    public static String getSybaseYYYYMMDD(String field)
    {
        return "(CONVERT(varchar(12), " + field + ", 112))";
    }

    /**
     * 获取一年的所有日期列表
     * 
     * @param year
     *            年份
     * @return ArrayList
     */
    public static List getAllDates(String year)
    {
        ArrayList list = new ArrayList();
        int intYear;
        try
        {
            intYear = Integer.parseInt(year);
        }
        catch (NumberFormatException e)
        { // 如果不是合法的年份，返回空的列表
            return list;
        }
        intYear = intYear - 1900; // 需要减去1900
        for (int month = 0; month < 12; month++)
        {
            for (int day = 1; day < 32; day++)
            {
                Date date = new Date(intYear, month, day);
                if (!list.contains(date))
                {
                    list.add(date);
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    /*
     * 获取当前日期，格式为XXXX年XX月XX日 星期几
     */
    public static String getCurrentChnDate()
    {
        String strDate = new SimpleDateFormat("yyyyMMdd E", Locale.SIMPLIFIED_CHINESE).format(new Date());
        strDate = strDate.substring(0, 4) + "年" + strDate.substring(4, 6) + "月" + strDate.substring(6, 8) + "日" + strDate.substring(8);
        return strDate;
    }

    /*
     * 将日期转换为格式XXXX年XX月XX日
     */
    public static String getChnDate(Date date)
    {
        String strDate = new SimpleDateFormat("yyyyMMdd").format(date);
        strDate = strDate.substring(0, 4) + "年" + strDate.substring(4, 6) + "月" + strDate.substring(6) + "日";
        return strDate;
    }

    /*
     * 将字符串'yyyyMMdd'日期转换为格式XXXX年XX月XX日
     */
    public static String getChnDate(String strDate)
    {
        return strDate.substring(0, 4) + "年" + strDate.substring(4, 6) + "月" + strDate.substring(6) + "日";
    }

    /*
     * 获取星期几,输入date是yyyyMMdd格式
     */
    public static String getWeekDateFromString(String date) throws ParseException
    {
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat formatE = new SimpleDateFormat("E", Locale.SIMPLIFIED_CHINESE);
        result = formatE.format(sdf.parse(date));
        return result;
    }

    /**
     * 检查日期字符串是否合法
     * 
     * @param dateStr
     *            日期字符串
     * @param pattern
     *            日期格式
     * @return 布尔
     */
    public static boolean isValidDate(String dateStr, String pattern)
    {

        if (dateStr == null || dateStr.trim().length() == 0)
        {
            return true;
        }

        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(pattern);
        df.setLenient(false);
        try
        {
            Date date = df.parse(dateStr);
        }
        catch (ParseException e)
        {
            return false;
        }
        return true;
    }

    /**
     * 检查生日字符串是否合法
     * 
     * @param dateStr
     *            生日字符串
     * @param pattern
     *            日期格式
     * @return 布尔
     */
    public static boolean isValidBirthDate(String dateStr, String pattern)
    {

        if (dateStr == null || dateStr.trim().length() == 0)
        {
            return true;
        }

        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(pattern);
        df.setLenient(false);
        try
        {
            Date date = df.parse(dateStr);
            int year = date.getYear();
            if (year < 0 || year > new Date().getYear()) // 如果生日小于1900年或大于当前日，认为错误
            {
                return false;
            }
        }
        catch (ParseException e)
        {
            return false;
        }
        return true;
    }

    public static String convertExcelDate(String oldDate) throws Exception
    {
        if (null == oldDate)
        {
            return null;
        }

        SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;

        int len = oldDate.trim().length();

        String str = oldDate.substring(1, 2);
        // System.out.println("len=" + len + " pos=" + str);

        try
        {
            if (len == 8 && oldDate.substring(6, 7).equals("-")) // XXXX-X-X
            {
                oldDate = oldDate.substring(0, 5) + "0" + oldDate.substring(5, 7) + "0" + oldDate.substring(7);
                date1 = dfDate.parse(oldDate);
            }
            if (len == 8 && oldDate.indexOf("-") < 0 && oldDate.indexOf("/") < 0) // XXXXXXXX
            {
                // oldDate = oldDate.substring(0, 5) + "0" +
                // oldDate.substring(5, 7) + "0" + oldDate.substring(7);
                return oldDate;
            }
            if (len == 9 && oldDate.substring(6, 7).equals("-")) // XXXX-X-XX
            {
                oldDate = oldDate.substring(0, 5) + "0" + oldDate.substring(5);
                date1 = dfDate.parse(oldDate);
            }
            if (len == 9 && oldDate.substring(7, 8).equals("-")) // XXXX-XX-X
            {
                oldDate = oldDate.substring(0, 8) + "0" + oldDate.substring(8);
                date1 = dfDate.parse(oldDate);
            }
            if (len == 8 && str.charAt(0) == '/') // X/X/XXXX
            {
                oldDate = oldDate.substring(4) + "-0" + oldDate.substring(0, 1) + "-0" + oldDate.substring(2, 3);
                date1 = dfDate.parse(oldDate);
            }
            if (len == 9 && oldDate.substring(1, 2).equals("/")) // X/XX/XXXX
            {
                oldDate = oldDate.substring(5) + "-0" + oldDate.substring(0, 1) + "-" + oldDate.substring(2, 4);
                date1 = dfDate.parse(oldDate);
            }
            if (len == 9 && oldDate.substring(2, 3).equals("/")) // XX/X/XXXX
            {
                oldDate = oldDate.substring(5) + "-" + oldDate.substring(0, 2) + "-0" + oldDate.substring(3, 4);
                date1 = dfDate.parse(oldDate);
            }
            if (len == 10 && oldDate.substring(2, 3).equals("/")) // XX/XX/XXXX
            {
                oldDate = oldDate.substring(6) + "-" + oldDate.substring(0, 2) + "-" + oldDate.substring(3, 5);
                date1 = dfDate.parse(oldDate);
            }
            else if (len == 10)
            {
                date1 = dfDate.parse(oldDate);
            }
        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new Exception("日期格式错误" + oldDate);
        }

        return new SimpleDateFormat("yyyyMMdd").format(date1);
    }

    /**
     * 日期格式转换
     * 
     * @param dateStr
     *            原始日期字符串
     * @param srcPattern
     *            原始日期格式
     * @param destPattern
     *            目标日期格式
     * @return
     */
    public static String changeDateFormat(String dateStr, String srcPattern, String destPattern)
    {
        if (null == dateStr || srcPattern == null || destPattern == null)
        {
            return "";
        }
        if (dateStr.length() == 0 || srcPattern.length() == 0 || destPattern.length() == 0)
        {
            return "";
        }

        Date srcDate;
        try
        {
            srcDate = new SimpleDateFormat(srcPattern).parse(dateStr);
        }
        catch (ParseException e)
        {
            return "";
        }

        String destStr;
        try
        {
            destStr = new SimpleDateFormat(destPattern).format(srcDate);
        }
        catch (Exception e)
        {
            return "";
        }

        return destStr;
    }

    /**
     * 修改日期天数
     * 
     * @param baseDate
     *            基准日期String (格式yyyyMMdd)
     * @param amount
     *            要增加的天数（负数为减）
     * @return 基准日期增加或减少若干天后的日期
     */
    public static String dateModifyByMouth(String baseDate, int amount)
    {
        StringBuffer sb = new StringBuffer();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 将字符串格式化
        Date dt = sdf.parse(baseDate, new ParsePosition(0)); // 由格式化后的字符串产生一个Date对象

        java.util.Calendar c = java.util.Calendar.getInstance(); // 初始化一个Calendar
        c.setTime(dt); // 设置基准日期
        c.add(c.MONTH, amount); // 你要加减的月份數
        Date dt1 = c.getTime(); // 从Calendar对象获得基准日期增减后的日期
        sb = sdf.format(dt1, sb, new FieldPosition(0)); // 得到结果字符串

        return sb.toString();
    }

    /**
     * 修改日期天数
     * 
     * @param baseDate
     *            基准日期String (格式yyyyMMdd)
     * @param amount
     *            要增加的天数（负数为减）
     * @return 基准日期增加或减少若干天后的日期
     */
    public static String dateModify(String baseDate, int amount)
    {
        StringBuffer sb = new StringBuffer();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 将字符串格式化
        Date dt = sdf.parse(baseDate, new ParsePosition(0)); // 由格式化后的字符串产生一个Date对象

        java.util.Calendar c = java.util.Calendar.getInstance(); // 初始化一个Calendar
        c.setTime(dt); // 设置基准日期
        c.add(c.DATE, amount); // 你要加减的月份數
        Date dt1 = c.getTime(); // 从Calendar对象获得基准日期增减后的日期
        sb = sdf.format(dt1, sb, new FieldPosition(0)); // 得到结果字符串

        return sb.toString();
    }

    /**
     * 获取当前日期后x个月的日期，格式为yyyyMMdd
     * 
     * @param x
     *            后几个月,x必须大于0,小于13
     * @return String
     */
    public static String getMonthAfterCurrentDate(int x)
    {
        String nowDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String year = nowDate.substring(0, 4);
        String month = nowDate.substring(4, 6);
        String day = nowDate.substring(6);
        String new_year = "";
        String new_month = "";
        if (Integer.parseInt(month) + x > 12)
        {
            new_month = String.valueOf(Integer.parseInt(month) + x - 12);
            if (new_month.length() == 1)
            {
                new_month = "0" + new_month;
            }
            new_year = String.valueOf(Integer.parseInt(year) + 1);
        }
        else
        {
            new_month = String.valueOf(Integer.parseInt(month) + x);
            if (new_month.length() == 1)
            {
                new_month = "0" + new_month;
            }
            new_year = year;
        }
        return new_year + new_month + day;
    }

    /**
     * 获取某日期前x天的日期，格式为yyyyMMdd
     * 
     * @param dateString
     *            某日期
     * @param x
     *            前几天
     * 
     * @return Date
     */
    public static String getPreDate(String dateString, int x)
    {
        Date date;
        Calendar cal = Calendar.getInstance();
        try
        {
            date = new SimpleDateFormat("yyyyMMdd").parse(dateString);
            cal.setTime(date);
            cal.add(cal.DAY_OF_YEAR, x);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
    }

    /**
     * 字符串转换到时间格式
     * 
     * @param dateStr
     *            需要转换的字符串
     * @param formatStr
     *            需要格式的目标字符串 举例 yyyy-MM-dd,yyyyMMddhhmmss
     * @return Date 返回转换后的时间
     * @throws ParseException
     *             转换异常
     */
    public static Date strToDate(String dateStr, String formatStr)
    {
        if (dateStr == null)
            return null;
        DateFormat sdf = new SimpleDateFormat(formatStr);
        Date date = null;
        try
        {
            date = sdf.parse(dateStr);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 字符串转换到时间格式 默认yyyyMMddhhmmss
     * 
     * @return Date 返回转换后的时间
     * @throws ParseException
     *             转换异常
     */
    public static Date strToDate(String dateStr)
    {
        if (dateStr == null)
            return null;
        return strToDate(dateStr, "yyyyMMddHHmmss");
    }

    /**
     * 时间格式转到字符串 默认yyyyMMddHHmmss
     */
    public static String dateToStr(Date date)
    {

        if (date == null)
            return null;
        return dateToStr(date, null);
    }

    /**
     * 时间格式转到字符串 默认yyyyMMddHHmmss
     */
    public static String dateToStr(Date date, String format)
    {

        if (date == null)
            return null;
        if (format == null)
            format = "yyyyMMddHHmmss";
        DateFormat sdf = new SimpleDateFormat(format);
        String strDate = null;
        try
        {
            strDate = sdf.format(date);
        }
        catch (Exception e)
        {

        }
        return strDate;
    }

    /***
     * 日期格式轉換yyyy-MM-dd轉dd/MM/yyyy
     * 
     * @param strDate
     * @return
     */
    public static String strDate2StrDate2(String strDate)
    {
        if (strDate == null || strDate.length() != 10)
            return strDate;

        return strDate.substring(8, 10) + "/" + strDate.substring(5, 7) + "/" + strDate.substring(0, 4);
    }

    /***
     * 日期格式轉換yyyyMMdd轉dd/MM/yyyy
     * 
     * @param strDate
     * @return
     */
    public static String strDate2StrDate3(String strDate)
    {
        if (strDate == null || strDate.length() != 8)
            return strDate;

        return strDate.substring(6, 8) + "/" + strDate.substring(4, 6) + "/" + strDate.substring(0, 4);
    }

    /***
     * 日期格式轉換dd/MM/yyyy轉yyyyMMdd
     * 
     * @param strDate
     * @return
     */
    public static String strDate2StrDate4(String strDate)
    {
        if (strDate == null || strDate.length() != 10)
            return strDate;
        String[] strParts = strDate.split("/");
        if (strParts.length != 3)
            return strDate;
        return strParts[2] + strParts[1] + strParts[0];
    }
    
    /***
     * 日期格式轉換MM/yyyy轉yyyyMM
     * 
     * @param strDate
     * @return
     */
    public static String strDate2StrDateMonth(String strDate)
    {
        if (strDate == null || strDate.length() != 7)
            return strDate;
        String[] strParts = strDate.split("/");
        if (strParts.length != 2)
            return strDate;
        return strParts[1] + strParts[0];
    }

    /***
     * 時間格式轉換hhmmss轉HH:mm:ss
     * 
     * @param strDate
     * @return
     */
    public static String strTime2StrTime(String strDate)
    {
        if (strDate == null || strDate.length() != 6)
            return strDate;

        return strDate.substring(0, 2) + ":" + strDate.substring(2, 4) + ":" + strDate.substring(4, 6);
    }

    /***
     * 時間間隔
     * 
     * @param strDate
     *            hhmmss
     * @return HH:mm:ss
     */
    public static String rangeTime(String strDate)
    {
        if (strDate == null || strDate.length() != 6)
        {
            return strDate;
        }
        SimpleDateFormat d = new SimpleDateFormat("HHmmss");
        String nowtime = d.format(new Date());
        int ss1 = Integer.valueOf(strDate.substring(0, 2)) * 3600 + Integer.valueOf(strDate.substring(2, 4)) * 60 + Integer.valueOf(strDate.substring(4, 6));
        int ss2 = Integer.valueOf(nowtime.substring(0, 2)) * 3600 + Integer.valueOf(nowtime.substring(2, 4)) * 60 + Integer.valueOf(nowtime.substring(4, 6));
        ss1 = ss2 - ss1;
        ss1 = ss1 < 0 ? -ss1 : ss1;
        int h = ss1 / 3600;
        int m = ss1 % 3600 / 60;
        int s = ss1 % 60;
        return String.format("%02d", h) + ":" + String.format("%02d", m) + ":" + String.format("%02d", s);
    }

    // 日期加天数
    public static Date dateAddDay(Date date, int day)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /***
     * 以日期作為流水號yyyyMMddhhmmss+兩位隨機數
     */
    public static String getOrderNo()
    {
        String str1 = dateToStr(new Date(), "yyyyMMddHHmmss");
        String str2 = String.format("%02d", System.currentTimeMillis() % 100);
        return str1 + str2;
    }

    /*** 返回yyyyMMdd,當前日期加天數 ***/
    public static String currDateAddDay(int day)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, day);
        Date afterDate = calendar.getTime();
        return dateToStr(afterDate, "yyyyMMddHHMMSS");
    }

    /***
     * 日期格式轉換yyyyMMdd轉yyyy-MM-dd
     * 
     * @param strDate
     * @return
     */
    public static String strDate2StrDate(String strDate)
    {
        if (strDate == null || strDate.length() != 8)
            return strDate;

        return strDate.substring(0, 4) + "-" + strDate.substring(4, 6) + "-" + strDate.substring(6, 8);
    }

    public static String getCurrentDateTimeByFormat(String format)
    {
        return new SimpleDateFormat(format).format(new Date());
    }

    //兩個日期相減
    public static long getDaySub(String beginDateStr, String endDateStr)
    {
        long day = 0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyyMMdd");
        java.util.Date beginDate;
        java.util.Date endDate;
        try
        {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
            day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
            //System.out.println("相隔的天数="+day);   
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return day;
    }

    //獲取月份最後一天
    public static String getLastDayOfMonth(int year, int month)
    {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String lastDayOfMonth = sdf.format(cal.getTime());

        return lastDayOfMonth;
    }

    /**
     * @param 
     * @param i 增加的月份数
     * @return  当前日期加多少个月 返回增加i个月数后的月份的第一天 格式为"yyyyMMddhhmmss"
     * 
     */
    public static String addmonths(int i){
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddhhmmss");
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, i);
            return sdf2.format(calendar.getTime());
    }
    
    /**
     * 将yyyyMMdd 格式转化为Date格式
     * @param original
     * @return
     * @throws ParseException 
     */
    public static Date StringToDate(String original) throws ParseException{
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");//小写的mm表示的是分钟  
    	Date date=sdf.parse(original); 
    	return date;
    }

    public static String convertMonthtoEnglish(String Month) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
        Date date = sdf.parse(Month);
        System.out.println(date.toString());
        String aa = new SimpleDateFormat("MMM.yyyy", Locale.ENGLISH).format(date);
        //		return sdf.format(date).toString();
        return aa;
    }

    public static void main(String[] args)
    {
        try
        {
        		String date  ="20150202";
        		System.out.println(addmonths(-1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
