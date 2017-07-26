package com.manager.strutstypeconverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class DateConverter extends StrutsTypeConverter{
	
	private final DateFormat[] dfs={
			new SimpleDateFormat("yyyy年MM月dd日"),
			new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("yyyy.MM.dd"),
			new SimpleDateFormat("yyyy/MM/dd"),
			new SimpleDateFormat("yy.MM.dd"),
			new SimpleDateFormat("MM/dd/yy"),
	};

	/*将一个或多个字符串值转换为日期类型*/
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		String dataStr=arg1[0];   //获取日期的字符串
		for(int i=0; i<dfs.length;i++){
			try {
				return dfs[i].parse(dataStr);
			} catch (ParseException e) {
				continue;
			}
		}
		throw new TypeConversionException();
	}

	/*将日期对象转化为字符串*/
	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		Date date=(Date) arg1;
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

}
