/*
 * 文件名：MessageServiceImpl.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： MessageServiceImpl.java
 * 修改人：liyuelong 1610139
 * 修改时间：2018年4月24日
 * 修改内容：新增
 */
package com.manager.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manager.common.tools.DateUtil;
import com.manager.common.tools.StringUtil;
import com.manager.dao.MessageDAO;
import com.manager.entity.Message;
import com.manager.entity.Order;
import com.manager.service.MessageService;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2018年4月24日
 * @since      CCAS
 */
public class MessageServiceImpl  implements MessageService{
	private MessageDAO messageDAO;
	
	public MessageDAO getMessageDAO() {
		return messageDAO;
	}


	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	@Override
	public boolean doAddOrUpdate(Message message) {
		String currentDateTime = DateUtil.getCurrentPrettyDateTime();
		message.setUpdated(currentDateTime);
		//如果是新增
		if (message.getId() == null) {
			message.setCreated(currentDateTime);
			return messageDAO.Add(message);
		}
		//如果是修改
		return messageDAO.update(message);
	}


	@Override
	public List<Message> getAllMessage(int offset, int length) {
		//hql语句
		StringBuffer hql = new StringBuffer("From Message e order by e.updated desc ");
		List<Message> list = messageDAO.executeHQL(hql.toString(), null,offset,length);
		return list;
	}

	@Override
	public List<Message> getMessageByParam(Map formParams, int offset, int length) {
		StringBuffer hql = new StringBuffer("From Message e where 1=1 ");
		HashMap sqlParams = new HashMap();
		builhql(hql, formParams, sqlParams);
		hql.append(" order by e.updated desc");
		List<Message> list = messageDAO.executeHQL(hql.toString(), sqlParams,offset,length);
		return list;
	}
	@Override
	public int getCountByParam(Map formParams) {
		StringBuffer hql = new StringBuffer("SELECT count(*) From Message e where 1=1 ");
		HashMap sqlParams = new HashMap<String, Object>();
		builhql(hql, formParams, sqlParams);
		return messageDAO.getCount(hql.toString(), sqlParams);
	}
	
	@Override
	public void builhql(StringBuffer hql, Map formParams, HashMap sqlParams){
		Message message = (Message) formParams.get("entity");
		String title = message.getTitle();
		if(!StringUtil.isNullOrWhiteSpace(title)){
			title = "%"+title+"%";
			hql.append(" and e.title like :title");
		    sqlParams.put("title", title);
		}
		String beginDate = (String) formParams.get("beginDate");
		if(!StringUtil.isNullOrWhiteSpace(beginDate)){
			hql.append(" and e.updated >= :beginDate");
		    sqlParams.put("beginDate", beginDate);
		}
		String endDate = (String) formParams.get("endDate");
		if(!StringUtil.isNullOrWhiteSpace(endDate)){
			hql.append(" and e.updated <= :endDate");
			sqlParams.put("endDate", endDate);
		}
	}

	@Override
	public int getAllMessageCount() {
		StringBuffer hql = new StringBuffer("SELECT count(*) From Message e where 1=1 ");
		return messageDAO.getCount(hql.toString(), null);
	}


	@Override
	public Message findById(int id) {
		return (Message) messageDAO.get(Message.class, id);
	}


	@Override
	public void doDeleteById(int id) {
		Message entity = (Message) messageDAO.get(Message.class, id);
		messageDAO.delete(entity);
	}



	
}

