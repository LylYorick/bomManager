/*
 * 文件名：SupplierAction.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： SupplierAction.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月6日
 * 修改内容：新增
 */
package com.manager.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.manager.common.Const;
import com.manager.common.tools.DateUtil;
import com.manager.common.tools.FileUtil;
import com.manager.common.tools.TimeHelper;
import com.manager.entity.Order;
import com.manager.entity.Supplier;
import com.manager.entity.common.Pagebean;
import com.manager.entity.common.PoiUtil;
import com.manager.entity.model.OrderModel;
import com.manager.entity.view.UserInfoView;
import com.manager.service.OrderService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * TODO添加类描述
 * 
 * @author liyuelong 1610139
 * @version CCAS 2017年7月6日
 * @since CCAS
 */
public class OrderAction extends BaseAction implements ModelDriven {
	private static final long serialVersionUID = 1L;
	private OrderService orderService;
	private OrderModel model;

	public void setModel(OrderModel model) {
		this.model = model;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public Object getModel() {
		if (model == null) {
			model = new OrderModel();
		}
		return model;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public String list() {
		return "list";
	}

	public String toAddjj() {
		return "addjj";
	}

	public String toAddpcb() {
		return "addpcb";
	}

	public String toAddcg() {
		return "addcg";
	}

	public String toAddxt() {
		return "addpxt";
	}

	public String toAddgx() {
		return "addpgx";
	}

	public String doAdd() {
		
		// 获取文件名
		String imgFileName = model.getImgFileName();
		// 获取文件的后缀名,即文件类型
		String[] arry = model.getImgFileName().split("\\.");
		String fileType = arry[arry.length - 1];
		// 订单编号自动生成，规则为XHH+YYYYMMDDHHMMSS
		String orderNumber = "XHH" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		// 重命名文件名,以订单号+文件类型命名
		String fileName = orderNumber + "." + fileType;
		
		// 设置新的文件名
		Order order = model.getEntity();
		order.setOrderNumber(orderNumber);
		order.setFileName(fileName);
		//获取当前用户
		UserInfoView currentuser = (UserInfoView) session.get(Const.currentUser);
		order.setContact(currentuser.getU_Name());
		order.setAddress(currentuser.getU_Address());
		
		//存储文件名到本地的OrderFile文件夹下
		ServletContext servletContext = ServletActionContext.getServletContext();
		String targetFileName = servletContext.getRealPath("/OrderFile/" + fileName);
		try {
			FileUtil.writeFile(targetFileName, model.getImg());
		} catch (IOException e) {
			this.setInputStream("0");
		}
		//进行新增订单操作操作
		if (orderService.Add(order)) {
			this.setInputStream("1");
		} else {
			this.setInputStream("0");
		}
		return "ajax-success";
	}
	public String verifyList() {
		HashMap formParams = new HashMap<String,Object>();
		//获取实体类
		Order order = model.getEntity();
		//获取分页帮助类
		order.setOrderConfirm("N");
		order.setOrderStatus("待审核");
		int sum  = orderService.getCount(formParams,order);
		
		Pagebean pageBean = model.getPageBean();
		pageBean.setOffset();
		request.put(Const.SUM, sum);
		pageBean.setAllRows(sum);
		pageBean.setTotalPages();
		List<Order> list = orderService.getList(formParams, order,pageBean.getOffset(),pageBean.pageSize);
		request.put(Const.Order_LIST, list);
		return "verifyList";
	}
	
	public String toVerify(){
		Order order = model.getEntity();
		order =  orderService.getOrder(order);
		model.setEntity(order);
		return "toVerify";
	}
	
	public String doVerify(){
		Order order = model.getEntity();
		Double orderPrice =	order.getOrderPrice();
		order =  orderService.getOrder(order);
		//
		order.setOrderPrice(orderPrice);
		order.setOrderStatus("已审核");
		//获取当前用户
		UserInfoView currentuser = (UserInfoView) session.get(Const.currentUser);
		order.setVerifyBy(currentuser.getU_Number());
		order.setVerifyTime(new Date());
		if(orderService.verify(order)){
			setInputStream("1");
		}else{
			setInputStream("0");
		}
		return "ajax-success";
	}
	public String toManager(){
		Order order = model.getEntity();
		UserInfoView currentuser = (UserInfoView) session.get(Const.currentUser);
		HashMap formParams = new HashMap<String,Object>();
		formParams.put("u_level",currentuser.getU_Level());
		formParams.put("u_number",currentuser.getU_Number());
		formParams.put("orderby", "orderNumber");
		int sum  = orderService.getCount(formParams,order);
		Pagebean pageBean = model.getPageBean();
		pageBean.setOffset();
		request.put(Const.SUM, sum);
		pageBean.setAllRows(sum);
		pageBean.setTotalPages();
		List<Order> list = orderService.getList(formParams, order,pageBean.getOffset(),pageBean.pageSize);
		request.put(Const.Order_LIST, list);
		return "toManager";
	}
	public String toDetai(){
		Order order = model.getEntity();
		order =  orderService.getOrder(order);
		model.setEntity(order);
		return "toDetail";
	}
	public String toEdit(){
		Order order = model.getEntity();
		order =  orderService.getOrder(order);
		model.setEntity(order);
		return "toEdit";
	}
	public String doEdit(){
		Order order = model.getEntity();
		if (orderService.edit(order)) {
			this.setInputStream("1");
		} else {
			this.setInputStream("0");
		}
		return "ajax-success";
	}
	public String doConfirm(){
		UserInfoView currentuser = (UserInfoView) session.get(Const.currentUser);
		Order order = model.getEntity();
		order =  orderService.getOrder(order);
		order.setConfirmBy(currentuser.getU_Number());
		order.setOrderStatus("已确认");
		order.setConfirmTime(new Date());
		order.setOrderConfirm("Y");
		if (orderService.confirm(order)) {
			this.setInputStream("1");
		} else {
			this.setInputStream("0");
		}
		return "ajax-success";
	}
	public String toComplete(){
		Order order = model.getEntity();
		order =  orderService.getOrder(order);
		model.setEntity(order);
		return "toComplete";
	}
	public String doComplete(){
		Order order = model.getEntity();
		if (orderService.complete(order)) {
			this.setInputStream("1");
		} else {
			this.setInputStream("0");
		}
		return "ajax-success";
	}
	public String toReport(){
		Order order = model.getEntity();
		UserInfoView currentuser = (UserInfoView) session.get(Const.currentUser);
		HashMap formParams = new HashMap<String,Object>();
		formParams.put("orderTime", TimeHelper.comverToOrderTime(model.getOrderTime()));
		formParams.put("orderby", "orderNumber");
		int sum  = orderService.getCount(formParams,order);
		Pagebean pageBean = model.getPageBean();
		pageBean.setOffset();
		request.put(Const.SUM, sum);
		pageBean.setAllRows(sum);
		pageBean.setTotalPages();
		List<Order> list = orderService.getList(formParams, order,pageBean.getOffset(),pageBean.pageSize);
		request.put(Const.Order_LIST, list);
		return "toReport";
	}
	public String doExport() throws Exception{
		Order order = model.getEntity();
		UserInfoView currentuser = (UserInfoView) session.get(Const.currentUser);
		HashMap formParams = new HashMap<String,Object>();
		formParams.put("orderTime", TimeHelper.comverToOrderTime(model.getOrderTime()));
		formParams.put("orderby", "orderNumber");
		int sum  = orderService.getCount(formParams,order);
		Pagebean pageBean = model.getPageBean();
		pageBean.setOffset();
		request.put(Const.SUM, sum);
		pageBean.setAllRows(sum);
		pageBean.setTotalPages();
		//获取查询结果
		List<Order> list = orderService.getList(formParams, order);
		request.put(Const.Order_LIST, list);
		//生成excel
		PoiUtil poiUtil = new PoiUtil();
		// 获取临时存储的文件夹并清空文件夹中的全部文件
		ServletContext servletContext = ServletActionContext.getServletContext();
		String directoryUrl = servletContext.getRealPath("/OrderFile/ExcelTmp");
		FileUtil.clearDir(directoryUrl);
		//创建服务端临时的Excel文件 生成规则 为当前时间
		String fileName = DateUtil.getCurrentDateTime()+".xls";
		//设置客户端下载时看到的文件名
		model.setImgFileName(fileName);
		//构建excel文件
		String fileUrl = directoryUrl + File.separatorChar+fileName;
		poiUtil.setFileUrl(fileUrl);
		poiUtil.buildExcel(list);
		//导出excel文件
		inputStream = new FileInputStream(fileUrl);
		return "file-downLoad";
	}
}
