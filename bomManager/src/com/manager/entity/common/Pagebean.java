/*
 * 文件名：Pagebean.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Pagebean.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年6月6日
 * 修改内容：新增
 */
package com.manager.entity.common;
/**
 * TODO 用于分页的bean
 * @since      CCAS
 */
public class Pagebean {
	public static String CURRENT_PAGE = "currentPage";
	public static String PAGE_SIZE = "pageSize";
	public static String OFFSET = "offset";
	//每页显示数量
	public static int pageSize = 5;
	
	private int currentPage;
	private int offset;
	private int totalPages;
	private int allRows;
	

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getAllRows() {
		return allRows;
	}

	public void setAllRows(int allRows) {
		this.allRows = allRows;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	public void setOffset() {
		if(currentPage == 0 ){
			currentPage = 1;
		}
		offset = (currentPage - 1) * pageSize;
	  
	}
	public void setTotalPages() {
		totalPages = (allRows % pageSize == 0)? (allRows / pageSize): (allRows / pageSize) + 1;
	}
	
	
}

