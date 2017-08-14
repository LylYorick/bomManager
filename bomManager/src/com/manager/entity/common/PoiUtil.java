/*
 * 文件名：PoiUtil.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： PoiUtil.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月25日
 * 修改内容：新增
 */
package com.manager.entity.common;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import com.manager.entity.Bom;
import com.manager.entity.Order;

/**
 * @author liyuelong
 *
 */
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
	
	public void createCell(HSSFRow row,int cellNo,Double value){
		HSSFCell cell;
		cell = row.createCell(cellNo);
		cell.setCellValue(value);
		cell.setCellStyle(style);
	}
	/**
	 * 创建订单表的导出
	 * @param row
	 * @param order
	 */
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
	/**
	 * 构建bom的list
	 * @param list
	 * @return
	 * @throws Exception 
	 */
	public boolean buildBomExcel(List<Bom> list) throws Exception {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet，对应Excel文件中的 sheet
		HSSFSheet sheet = wb.createSheet("orderList");
		// 设置列宽
		sheet.setDefaultColumnWidth(20);
		// 第三步，在sheet中添加表头第0行，注意老版本poi对Excel的行数列数有限制
		HSSFRow row = sheet.createRow(0);
		// 第四步，创建单元格样式：居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		this.style = style;
		// 第五步，创建表头单元格，并设置样式
		HSSFCell cell;
		// 创建表头 begin
		
		int minLevel = list.get(0).getSecq();
		int maxLevel = -1;
		
		for (Bom bom : list) {
			int seq = bom.getSecq();
			if (seq > maxLevel) {
				maxLevel = seq;
			}
		}
		int cellNo = 0;
		for (cellNo = minLevel; cellNo < maxLevel + 1; cellNo++) {
			createCell(row, cellNo - minLevel, "第" + cellNo + "级");
		}
		createCell(row, cellNo - minLevel, "图样代号");
		createCell(row, cellNo - minLevel + 1, "材料/规格");
		createCell(row, cellNo - minLevel + 2, "执行标准");
		createCell(row, cellNo - minLevel + 3, "单台部件数量");
		createCell(row, cellNo - minLevel + 4, "单台零件数量");
		createCell(row, cellNo - minLevel + 5, "单价");
		createCell(row, cellNo - minLevel + 6, "成本数量");
		createCell(row, cellNo - minLevel + 7, "单台合计");
		// 创建表头end

		
		for (int i = 1, size = list.size(); i <= size; i++) {
			row = sheet.createRow(i);
			Bom item = list.get(i - 1);
			int j = minLevel;
			for (; j < maxLevel + 1; j++) {
				if (j == item.getSecq()) {
					// TODO 导出Bom结构时建立的合并单元格格式 但没有写完 有问题
					/* MergeCellBefore(sheet, i, maxLevel, minLevel, j); */
					createCell(row, j - minLevel, item.getPartName());
					continue;
				}
			}
			createCell(row, j - minLevel, item.getTuNumber());
			createCell(row, j - minLevel + 1, item.getPartSpec());
			createCell(row, j - minLevel + 2, item.getPartStandard());
			if ("部件".equals(item.getPartModel())) {
				createCell(row, j - minLevel + 3, item.getUseQty() + "");
			} else if ("零件".equals(item.getPartModel())) {
				createCell(row, j - minLevel + 4, item.getUseQty());
			}
			createCell(row, j - minLevel + 5, item.getPartPrice()+"");
			createCell(row, j - minLevel + 6, item.getPartQty()+"");
			createCell(row, j - minLevel + 7, item.getPartSum()+"");
		}
		File file = new File(fileUrl);
		try {
			FileOutputStream output = new FileOutputStream(file);
			wb.write(output);
			output.flush();
			output.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;
	}
	
	//TODO 导出Bom结构时建立的合并单元格格式 但没有写完 有问题
	/**
	 * 导出Bom结构时建立的合并单元格格式
	 *
	 * @param sheet
	 * @param row
	 * @param maxLevel
	 * @param minLevel
	 * @param cellNo
	 */
	private void MergeCellBefore(HSSFSheet sheet,int row,int maxLevel,int minLevel,int cellNo){
		  CellRangeAddress cra;
		  //如果是第一列cellNo-minLevel > 1 如果单元格不在在0个就合并前面的单元格
		if(cellNo-minLevel > 0){
			//合并前面的单元格
			cra=new CellRangeAddress(row, row, 0, cellNo-minLevel);
			 sheet.addMergedRegion(cra); 
		}
		 //如果是第一列maxLevel-cellNo  < 1 如果单元格不在在倒数第0个 或第1个就合并的单元格
		if( maxLevel-cellNo > 1){
			//不合并后面的单元格
			cra=new CellRangeAddress(row, row, cellNo-minLevel,maxLevel-minLevel);   
			 sheet.addMergedRegion(cra); 
		}
		// 普通的 即合并前面的单元格又合并后面的单元格
		
	}
}

