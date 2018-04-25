/*
 * 文件名：MessageService.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： MessageService.java
 * 修改人：liyuelong 1610139
 * 修改时间：2018年4月24日
 * 修改内容：新增
 */
package com.manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manager.entity.Message;
import com.manager.entity.Order;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2018年4月24日
 * @since      CCAS
 */
public interface MessageService {
	boolean doAddOrUpdate(Message message);
	/**
	 * @param offset 当前页面
	 * @param length 每页显示多少条记录
	 * 分页获取全部的消息
	 */
	List<Message> getAllMessage(int offset,int length);
	
	/**
	 * 根据条件分页查询消息
	 */
	List<Message> getMessageByParam(Map formParams,int offset,int length);
	/**
	 * 统计总共多少条消息
	 */
	int getAllMessageCount();
	/**
	 * 根据条件统计共多少条数据
	 */
	int getCountByParam(Map formParams);
	
	Message findById(int id);
	
	void doDeleteById(int id);
	/**
	 * 根据formParams的数值生成 hql
	 * @param hql 
	 * @param formParams 
	 * @param sqlParams
	 */
	void builhql(StringBuffer hql, Map formParams, HashMap sqlParams);
}

