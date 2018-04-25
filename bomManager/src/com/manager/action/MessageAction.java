/*
 * 文件名：MessageAction.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： MessageAction.java
 * 修改人：liyuelong 1610139
 * 修改时间：2018年4月23日
 * 修改内容：新增
 */
package com.manager.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.manager.common.CommonMethod;
import com.manager.common.Const;
import com.manager.common.JsonResult;
import com.manager.common.PictureResult;
import com.manager.common.tools.FileUtil;
import com.manager.entity.Message;
import com.manager.entity.common.Pagebean;
import com.manager.entity.model.MessageModel;
import com.manager.service.MessageService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2018年4月23日
 * @since      CCAS
 */
public class MessageAction extends BaseAction implements ModelDriven{
	
	private MessageModel view;
	private MessageService messageService;


	public String uploadMessage(){
		String imgFileName = view.getImgFileName();
		//存储文件名到本地的OrderFile文件夹下
		imgFileName = CommonMethod.renameFileName(imgFileName);
		
		ServletContext servletContext = ServletActionContext.getServletContext();
		String targetFileName = servletContext.getRealPath("/" + Const.MESSGE_IMG_DIR + imgFileName );
		PictureResult result = new PictureResult();//图片文件
		try {
			FileUtil.writeFile(targetFileName, view.getImg());
			result.setError(0);
			result.setUrl(Const.MESSGE_IMG_DIR + imgFileName);
			view.setResult(JsonResult.ok(result));
		} catch (IOException e) {
			result.setError(1);
			result.setMessage("图片上传失败");
			view.setResult(JsonResult.ok(result));
			e.printStackTrace();
		}
		return "json-img";
	}
	/**
	 * 新增消息
	 */
	public String add(){
		Message entity = view.getEntity();
		try {
			messageService.doAddOrUpdate(entity);
			view.setResult(JsonResult.ok());
		} catch (Exception e) {
			e.printStackTrace();
			view.setResult(JsonResult.failed500("新增或修改内部出错！"));
		}
		return JSON;
	}
	
	/**
	 * 1，2级用户查看全部消息
	 */
	public String listMessage(){
		int sum  = messageService.getAllMessageCount();
		Pagebean pageBean = view.getPageBean();
		pageBean.setOffset();
		request.put(Const.SUM, sum);
		pageBean.setAllRows(sum);
		pageBean.setTotalPages();
		List<Message> allMessage = messageService.getAllMessage(pageBean.getOffset(), Pagebean.pageSize);
		request.put(Const.MESSAGE_LIST, allMessage);
		return SUCCESS;
	}
	/**
	 * 3,4,5级用户管理消息
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String manageMessage(){
		Map formParams = new  HashMap<String, Object>();
		formParams.put("entity", view.getEntity());
		formParams.put("beginDate", view.getBeginDate());
		formParams.put("endDate", view.getEndDate());
		int sum  = messageService.getCountByParam(formParams);
		Pagebean pageBean = view.getPageBean();
		pageBean.setOffset();
		request.put(Const.SUM, sum);
		pageBean.setAllRows(sum);
		pageBean.setTotalPages();
		List<Message> allMessage = messageService.getMessageByParam(formParams,pageBean.getOffset(), Pagebean.pageSize);
		request.put(Const.MESSAGE_LIST, allMessage);
		return SUCCESS;
	}
	public String showMessage(){
		Message entity = view.getEntity();
		Integer id = entity.getId();
		 entity = messageService.findById(id);
		view.setEntity(entity);
		return SUCCESS;
	}
	
	@Override
	public Object getModel() {
		if (view == null) {
			view = new MessageModel();
		}
		return view;
	}
	
	public String addMessage(){
		Message entity = view.getEntity();
		if (entity.getId() == null) {
			request.put("pageKey", "新增");
			return SUCCESS;
		}
		entity = messageService.findById(entity.getId());
		request.put("pageKey", "修改");
		view.setEntity(entity);
		return SUCCESS;
	}
	public String deleteMessage(){
		Message entity = view.getEntity();
		try {
			messageService.doDeleteById(entity.getId());
			view.setResult(JsonResult.ok());
		} catch (Exception e) {
			e.printStackTrace();
			view.setResult(JsonResult.failed500("删除失败！"));
		}
		return JSON;
	}
	
	public MessageModel getView() {
		return view;
	}

	public void setView(MessageModel view) {
		this.view = view;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
}

