/*
 * 文件名：PoiUtil.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： PoiUtil.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月25日
 * 修改内容：新增
 */
package com.manager.entity.common;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import com.manager.entity.Order;

public class PoiUtil {
	private  String fileUrl;
	private String fileName;   
	private HSSFCellStyle style;
   
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public HSSFCellStyle getStyle() {
		return style;
	}
	public void setStyle(HSSFCellStyle style) {
		this.style = style;
	}
	
	public boolean buildExcel(List<Order> list){
		  //第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //第二步，在webbook中添加一个sheet，对应Excel文件中的 sheet
        HSSFSheet sheet = wb.createSheet("orderList");
        //第三步，在sheet中添加表头第0行，注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);
        //第四步，创建单元格样式：居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        this.style = style;
        
        //第五步，创建表头单元格，并设置样式
        HSSFCell cell;
        int eI = 0;
        for (OrderEnum e : OrderEnum.values()) {
        	createCell(row, eI, e.value);
        	eI++;
        }
        
        //第六步，写入实体数据，实际应用中这些数据从数据库得到
        for (int i = 1; i <= list.size(); i++) {
            row = sheet.createRow(i);
            Order item = list.get(i-1);
            createCell(row, item);
        }
        File file = new File(fileUrl);
        try {
        	FileOutputStream output=new FileOutputStream(file);  
        	wb.write(output);  
			output.flush();
			output.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;
	}
	/**
	 * 在一行中创建单元格
	 */
	public void createCell(HSSFRow row,int cellNo,String value){
		HSSFCell cell;
		cell = row.createCell(cellNo);
		cell.setCellValue(value);
		cell.setCellStyle(style);
	}
	public void createCell(HSSFRow row,Order order) {
		Class<?> cls = Order.class;
		int i = 0;
	    for (OrderEnum e : OrderEnum.values()) {
	    	Method method;
			try {
				method = cls.getDeclaredMethod("get"+e.name.substring(0,1).toUpperCase()+e.name.substring(1));
				createCell(row,i,method.invoke(order)+"");
				i++;
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
	    }
	}
}

