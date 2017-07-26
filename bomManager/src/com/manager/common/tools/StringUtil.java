package com.manager.common.tools;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * <p>
 * Title: 字符串处理的支持类
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

public class StringUtil {

	private StringUtil() {
	};

	/**
	 * 构造指定数量的空格字符串并返回。
	 * 
	 * @param amount
	 *            int 空格符的数量
	 * @return String
	 */
	public static String getSpacebar(int amount) {
		StringBuffer sb = new StringBuffer();
		sb.append("");
		if (amount > 0) {
			for (int i = 0; i < amount; i++) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	/**
	 * 构造指定数量的零字符组成字符串并返回。
	 * 
	 * @param amount
	 *            int 零字符的数量
	 * @return String
	 */
	public static String getZerobar(int amount) {
		StringBuffer sb = new StringBuffer();
		sb.append("");
		if (amount > 0) {
			for (int i = 0; i < amount; i++) {
				sb.append("0");
			}
		}
		return sb.toString();
	}

	/**
	 * 按照位数将源字符串切割成字符串数组
	 * 
	 * @param src
	 *            源字符串
	 * @param length
	 *            指定的位数
	 * @return
	 */
	public static String[] cutByLength(String src, int length) {
		if (null == src || src.length() == 0 || length <= 0) {
			return null;
		}
		int count = src.length() / length;
		if (src.length() % length != 0) { // 如果源字符串位数不能整除
			count++;
		}
		String[] result = new String[count];
		for (int i = 0; i < count - 1; i++) { // 注意此循环不切割最后一项
			result[i] = src.substring(i * length, (i + 1) * length);
		}
		result[count - 1] = src.substring((count - 1) * length); // 在此切割最后一项
		return result;
	}

	/*
	 * 金额小写转换成大写
	 */
	public static String convertDaxie(double money) {
		String hanzi[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		String wei[] = { "分", "角", "元", "拾", "佰", "仟", "萬", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "萬", "拾", "佰", "仟" };
		String retvalue = new String();
		int i, j = 0;
		boolean is_have = false, is_negative = false;

		if (money < 0) // 负数
		{
			money = Math.abs(money);
			is_negative = true;
		}

		money = Double.valueOf((new BigDecimal(money)).setScale(2, BigDecimal.ROUND_HALF_UP).toString()).doubleValue(); // 四舍五入
		if (money == 0.00)
			return "零元";

		for (i = 17; i >= 0; i--) // i 为位数
		{
			if (money == 0)
				break;

			double d1 = money / Math.pow(10.0, i - 2);
			String str = new String();

			if (i == 0)
				str = (new BigDecimal(d1)).setScale(0, BigDecimal.ROUND_HALF_DOWN).toString();
			else
				str = (new BigDecimal(d1)).setScale(0, BigDecimal.ROUND_DOWN).toString();

			// System.out.println("str = " + str + " d1=" + d1);
			j = Integer.valueOf(str).intValue(); // j 为 i 位上的数字
			// System.out.println("i = " + i + " j=" + j + " retvalue=" +
			// money);
			if (j == 0 && (i - 2) % 4 == 0 && is_have) {
				if (retvalue.substring(retvalue.length() - 1).equals(hanzi[0])) {
					if (!(retvalue.substring(retvalue.length() - 2).equals("亿零")))
						retvalue = retvalue.substring(0, retvalue.length() - 1) + wei[i];
				} else
					retvalue = retvalue + wei[i];

			} else if (j == 0 && is_have) {
				if (!(retvalue.substring(retvalue.length() - 1).equals(hanzi[0])))
					retvalue = retvalue + hanzi[0];
			} else if (j > 0) {
				retvalue = retvalue + hanzi[j] + wei[i];
				double d2 = Math.pow(10.0, i - 2);
				money = money - j * d2;
				money = Double.valueOf((new BigDecimal(money)).setScale(2, BigDecimal.ROUND_HALF_UP).toString()).doubleValue();
				is_have = true;
			}
			// System.out.println("retvalue=" + retvalue);
		}

		if (i >= 14)
			retvalue = retvalue + "萬亿元整";
		else if (i >= 10)
			retvalue = retvalue + "亿元整";
		else if (i == 9)
			retvalue = retvalue + "元整";
		else if (i >= 6)
			retvalue = retvalue + "萬元整";
		else if (i >= 2)
			retvalue = retvalue + "元整";
		else if (i >= 0)
			retvalue = retvalue + "整";

		if (is_negative)
			retvalue = "负" + retvalue; // 添前缀

		return retvalue;
	}

	/*
	 * 十六进制转换成二进制
	 */
	public static int Hex2Bin(char[] hexStr, long hexLen, byte[] binStr) {
		if (hexStr.length == 0 || hexLen <= 0 || (hexLen % 2) != 0)
			return -1;

		boolean errflag = false;
		int date[] = new int[2];

		int num = 0, pos = 0;

		while (num < hexLen && !errflag) {
			for (int i = 0; i < 2; i++) {
				if (hexStr[num + i] >= '0' && hexStr[num + i] <= '9')
					date[i] = hexStr[num + i] - '0';
				else if (hexStr[num + i] >= 'A' && hexStr[num + i] <= 'F')
					date[i] = 10 + hexStr[num + i] - 'A';
				else {
					errflag = true;
					break;
				}
			}

			binStr[pos] = (byte) (date[0] * 16 + date[1]);
			num += 2;
			pos++;
		}

		if (!errflag) {
			return 0;
		} else {
			return 1;
		}

	}

	/*
	 * 二进制转十六进制
	 */
	public static int Bin2Hex(byte[] binStr, int binLen, char[] hexStr) {
		// 不对binStr是否为NULL进行判断，因无法确定NULL对于二进制字符串而言是不是有效值
		if (binLen == 0)
			return -1;

		// define character for output
		char digitList[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char inData;
		boolean errflag = false;

		int num = 0, pos = 0;

		while (num < binLen && !errflag) {
			inData = (char) binStr[num];

			int charInd1 = (inData & 0xFF); // 禁止符号扩展

			hexStr[pos + 1] = digitList[charInd1];
			inData >>= 4;
			int charInd2 = (inData & 0xFF);
			hexStr[pos] = digitList[charInd2];
			num++;
			pos += 2;
		}

		if (!errflag) {
			return 0;
		} else {
			return 1;
		}
	}

	/*
	 * 将数字转换成百分数 scale：百分数的小数点后面的位数
	 */
	public static String getPercent(double d, int scale) {
		String str = String.valueOf(d);
		BigDecimal bd = new BigDecimal(str);
		str = bd.multiply(new BigDecimal(100)).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
		int iPos = str.indexOf(".");
		if (iPos > -1) {
			for (int i = scale; i >= 1; i--) {
				if (str.charAt(iPos + i) == '0')
					str = str.substring(0, iPos + i);
				else
					break;
			}
			if (str.length() == iPos + 1)
				str = str.substring(0, iPos);
		}

		return str + "%";
	}

	/**
	 * 字符串替换
	 * 
	 * @param str
	 *            字符串
	 * @param destStr
	 *            替换前字符串
	 * @param srcStr
	 *            替换后字符串
	 * @return
	 */
	public static String replaceMark(String str, String destStr, String srcStr) {

		// 返回值
		StringBuffer retVal = new StringBuffer();

		// 记录查找到相似字符的位置

		int findStation = str.indexOf(destStr);

		int resumStation = 0;

		while (findStation > -1) {
			retVal.append(str.substring(resumStation, findStation));
			retVal.append(srcStr);
			if ("".equals(srcStr))
				resumStation = findStation + 1;
			else
				resumStation = findStation + srcStr.length();

			findStation = str.indexOf(destStr, resumStation);
		}

		retVal.append(str.substring(resumStation));
		return retVal.toString();
	}

	/**
	 * 获取前面不带0755区号、0、-的电话号码
	 * 
	 * @param tel
	 *            电话号码
	 * @return
	 */
	public static String getPureTel(String tel) {
		if (tel != null && tel.length() > 0) {
			if (tel.startsWith("0755")) {
				tel = tel.substring(4);
				tel = tel.trim();
			}
			if (tel.startsWith("-")) {
				tel = tel.substring(1);
			}
			if (tel.startsWith("0")) {
				tel = tel.substring(1);
				tel = tel.trim();
			}
		}
		return tel;
	}

	/**
	 * 获取前面不带0的手机号码
	 * 
	 * @param telNo
	 *            手机号码
	 * @return
	 */
	public static String getPureMobileTel(String telNo) {
		if (telNo != null && telNo.length() > 0 && telNo.startsWith("01")) {
			telNo = telNo.substring(1);
		}
		return telNo;
	}

	/**
	 * 根据15位身份证号码获取18位升位后号码
	 * 
	 * @param perIDSrc
	 *            15位身份证号码
	 * @return
	 */
	public static String per15To18(String perIDSrc) {

		if (perIDSrc.length() != 15) // 如果长度不是15，默认返回null
			return null;

		long per15 = 0;

		// １５位身份证号不是整数
		try {
			per15 = Long.parseLong(perIDSrc);
		} catch (NumberFormatException e) {
			return null;
		}

		// １５位身份证号不是正整数
		if (per15 < 0) {
			return null;
		}

		int iS = 0;

		// 加权因子常数
		int[] iW = new int[] { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };

		// 校验码常数
		String LastCode = "10X98765432";

		// 新身份证号
		String perIDNew;

		perIDNew = perIDSrc.substring(0, 0 + 6);

		// 填在第6位及第7位上填上‘1’，‘9’两个数字
		perIDNew += "19";

		perIDNew += perIDSrc.substring(6, 6 + 9);

		// 进行加权求和
		for (int i = 0; i < 17; i++) {
			iS += Integer.parseInt(perIDNew.substring(i, i + 1)) * iW[i];
		}

		// 取模运算，得到模值
		int iY = iS % 11;

		// 从LastCode中取得以模为索引号的值，加到身份证的最后一位，即为新身份证号。
		perIDNew += LastCode.substring(iY, iY + 1);

		return perIDNew;
	}

	/**
	 * 全角转半角
	 * 
	 * @param QJstr
	 * @return
	 */
	public static final String qjStr2BjStr2(String QJstr) {
		String outStr = "";
		String Tstr = "";
		byte[] b = null;

		for (int i = 0; i < QJstr.length(); i++) {
			try {
				Tstr = QJstr.substring(i, i + 1);
				b = Tstr.getBytes("unicode");
			} catch (java.io.UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			if (b[3] == -1) {
				b[2] = (byte) (b[2] + 32);
				b[3] = 0;

				try {
					outStr = outStr + new String(b, "unicode");
				} catch (java.io.UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			} else
				outStr = outStr + Tstr;
		}

		return outStr;
	}

	/**
	 * 全角转半角
	 * 
	 * @param QJstr
	 * @return
	 */
	public static final String qjStr2BjStr(String QJstr) {
		if (null == QJstr || QJstr.length() == 0)
			return QJstr;
		String outStr = "";

		outStr = QJstr.replaceAll("１", "1").replaceAll("２", "2").replaceAll("３", "3").replaceAll("４", "4").replaceAll("５", "5").replaceAll("６", "6").replaceAll("７", "7").replaceAll("８", "8").replaceAll("９", "9").replaceAll("０", "0").replaceAll("。", ".").replaceAll("Ｘ", "X");
		return outStr;
	}

	/**
	 * 半角转全角
	 * 
	 * @param str36
	 * @return
	 */
	// public static final String bjStr2QjStr(String QJstr) {
	// String outStr = "";
	// String Tstr = "";
	// byte[] b = null;
	//  
	// for (int i = 0; i < QJstr.length(); i++) {
	// try {
	// Tstr = QJstr.substring(i, i + 1);
	// b = Tstr.getBytes("unicode");
	// } catch (java.io.UnsupportedEncodingException e) {
	// e.printStackTrace();
	// }
	//  
	// if (b[3] != -1) {
	// b[2] = (byte) (b[2] - 32);
	// b[3] = -1;
	// try {
	// outStr = outStr + new String(b, "unicode");
	// } catch (java.io.UnsupportedEncodingException e) {
	// e.printStackTrace();
	// }
	// } else
	// outStr = outStr + Tstr;
	// }
	//  
	// return outStr;
	// }
	/*
	 * 将两位的带字母的36进制数转为整数 比如0A转为10,0Z转为35
	 */
	public static final int str36ToInt(String str36) {
		if (null == str36 || str36.length() == 0)
			return -1;
		int result = 0;

		int num = 0;
		for (int i = 0; i < str36.length(); i++) {
			char c = str36.charAt(i);
			if (c >= '0' && c <= '9') {
				num = c - 48;
			} else if (c >= 'A' && c <= 'Z') {
				num = c - 55;
			}
			if (num == 0) {
				continue;
			} else {
				num = num * (int) Math.pow(36, str36.length() - i - 1);
			}
			result = result + num;
		}

		return result;
	}

	/*
	 * 将整数转为两位的带字母的36进制数 比如10转为0A,35转为0Z 该整数在0-1295之间
	 */
	public static final String intToStr36(int res) {
		if (res < 0 || res > 1295)
			return "ERROR";
		StringBuffer result = new StringBuffer();
		char c1, c2;
		int i1 = (int) res / 36;
		int i2 = (int) res % 36;
		if (i1 > 9) {
			c1 = (char) (i1 + 55);
		} else {
			c1 = (char) (i1 + 48);
		}
		if (i2 > 9) {
			c2 = (char) (i2 + 55);
		} else {
			c2 = (char) (i2 + 48);
		}
		result.append(c1).append(c2);
		return result.toString();
	}

	/**
	 * 左补字符
	 * 
	 * @param oldstr
	 *            原字符
	 * @param padStr
	 *            填充用字符
	 * @param strCount
	 *            填充后的字符串长度
	 */
	public static final String leftPad(String oldStr, char padStr, int strCount) {
		String newStr = oldStr;
		String leftAddStr = "";
		int oldstrCount = oldStr.length();
		int addCount = strCount - oldstrCount;

		if (addCount > 0) {

			for (int i = 0; i < addCount; i++) {
				leftAddStr += padStr;
			}

			newStr = leftAddStr + newStr;

		}
		return newStr;
	}

	/**
	 * 右补字符
	 * 
	 * @param oldstr
	 *            原字符
	 * @param padStr
	 *            填充用字符
	 * @param strCount
	 *            填充后的字符串长度
	 */
	public static final String rightPad(String oldStr, char padStr, int strCount) {
		String newStr = oldStr;
		String leftAddStr = "";
		int oldstrCount = oldStr.length();
		int addCount = strCount - oldstrCount;

		if (addCount > 0) {

			for (int i = 0; i < addCount; i++) {
				leftAddStr += padStr;
			}

			newStr = newStr + leftAddStr;

		}
		return newStr;
	}

	/**
	 * 将一个字符串的首字母改为大写或者小写
	 * 
	 * @param srcString
	 *            源字符串
	 * @param flag
	 *            大小写标识，ture小写，false大写
	 * @return 改写后的新字符串
	 */
	public static String toLowerCaseInitial(String srcString, boolean flag) {
		StringBuilder sb = new StringBuilder();
		if (flag) {
			sb.append(Character.toLowerCase(srcString.charAt(0)));
		} else {
			sb.append(Character.toUpperCase(srcString.charAt(0)));
		}
		sb.append(srcString.substring(1));
		return sb.toString();
	}

	/**
	 * 将字符串xxx_xxx_xxx转换为XxxXxxXxx
	 * 
	 * 
	 * 
	 */

	public static String getMethodNameFormatStr(String srcString) {
		String value = "";
		srcString=srcString.toLowerCase();
		String[] strs = srcString.split("_");
		for (int i = 0; i < strs.length; i++) {
			value += toLowerCaseInitial(strs[i].toLowerCase(), false);
		}
		return value;
	}

	// ///////////////////////add by 071291 on
	// 20071105//////////////////////////////////////
	/**
	 * 取得随机数字符串（在整数范围内）
	 * 
	 * @param amount
	 * @return
	 */
	private static java.util.Random r = new java.util.Random();

	public static String getRandomNumber() {
		return r.nextInt() + "";
	}
	// ///////////////////////end////////////////////////////////////////
	
	/***
     * 指示指定的字符串是 null、空还是仅由空白字符组成。
     * @param o
     * @return
     */
    public static boolean isNullOrWhiteSpace(String o) {
        return isNullOrWhiteSpace((Object)o);
    }
    
	/***
	 * 指示指定的字符串是 null、空还是仅由空白字符组成。
	 * @param o
	 * @return
	 */
	public static boolean isNullOrWhiteSpace(Object o) {
	    String val = null;
	    if (o == null)
	    {
	        return true;
	    }
	    val = o.toString().trim();
	    return val.equals(EMPTY);
	}
	
	/**
	 * 空字符串
	 */
	public static final String EMPTY = "";
    
      /* system properties to get separators */
    static final Properties PROPERTIES = new Properties(System.getProperties());

    private static String lineSeparator = null;
    /**
     * 行分隔符
     * @return line separator
     */
    public static String getLineSeparator(){
        if (lineSeparator == null)
        {
            lineSeparator = PROPERTIES.getProperty("line.separator");
        }
        return lineSeparator;
    }

    private static String pathSeparator = null;
    /**
     * 路径分隔符
     * @return path separator
     */
    public static String getPathSeparator(){
        if (pathSeparator == null)
        {
            pathSeparator = PROPERTIES.getProperty("path.separator");
        }
        return pathSeparator;
    }
    
	public static BigDecimal toBigDecimal(Object o)
    {
        return toBigDecimal(String.valueOf(o));
    }

    public static BigDecimal toBigDecimal(String o)
    {
        try
        {
            return new BigDecimal(o);    
        }
        catch (Exception e)
        {
            return new BigDecimal(0);
        }
    }
    
    public static Long toLong(Object o)
    {
        return toLong((String)o);
    }
    
    public static Long toLong(String o)
    {
        try
        {
            return Long.parseLong(o);   
        }
        catch (Exception e)
        {
            return 0L;
        }
    }
    
    public static int toInt(Object o)
    {
        return toInt((String)o);
    }
    
    public static int toInt(String o)
    {
        try
        {
            return Integer.parseInt(o);   
        }
        catch (Exception e)
        {
            return 0;
        }
    }
    
    public static double toDouble(Object o)
    {
    	if(isNullOrWhiteSpace(o)){
    		return 0;
    	}
        return toDouble(o.toString());
    }
    
    public static double toDouble(String o)
    {
        try
        {
            return Double.parseDouble(o);   
        }
        catch (Exception e)
        {
            return 0;
        }
    }
    
    public static BigDecimal moneyToBigDecimal(String val)
    {
        return toBigDecimal(val.replace(",", EMPTY));
    }

    
    public static InputStream stringToInputStream(String str)
    {
        return new ByteArrayInputStream(str.getBytes(Charset.forName("UTF-8")));
    }
    
    public static String getThrowableInfo(Throwable e)
    {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        e.printStackTrace(pw);
        pw.flush();
        sw.flush();
        return sw.toString();
    }
    /**  
     * 得到一个字符串的长度,显示的长度,一个汉字长度为3,英文字符长度为1
     * @param String s 需要得到长度的字符串  
     * @return int 得到的字符串长度  
     */   
    public static int  getLength(String s) {  
     int valueLength = 0;    
        String chinese = "[\u4e00-\u9fa5]";    
        // 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1    
        for (int i = 0; i < s.length(); i++) {    
            // 获取一个字符    
            String temp = s.substring(i, i + 1);    
            // 判断是否为中文字符    
            if (temp.matches(chinese)) {    
                // 中文字符长度为3   
                valueLength += 3;    
            } else {    
                // 其他字符长度为1    
                valueLength += 1;    
            }    
        }    
        //进位取整    
        return  valueLength;    
    } 
    
    /**
     * 判断字符串是否仅包含字母和数字
     * @param str
     * @return
     */
    public static boolean isLetterDigit(String str) {
    	  String regex = "^[a-z0-9A-Z]+$";
    	  return str.matches(regex);
    }
    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
    	System.out.println(isLetterDigit("78789"));
    }
}
