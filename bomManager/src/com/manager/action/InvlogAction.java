/*
 * 文件名：SupplierAction.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： SupplierAction.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月6日
 * 修改内容：新增
 */
package com.manager.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.manager.common.Const;
import com.manager.entity.Inventory;
import com.manager.entity.Invlog;
import com.manager.entity.common.InventoryTree;
import com.manager.entity.common.Pagebean;
import com.manager.entity.model.InvlogModel;
import com.manager.entity.view.UserInfoView;
import com.manager.service.InvlogService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月6日
 * @since      CCAS
 */
public class InvlogAction  extends BaseAction  implements ModelDriven{
	private static final long serialVersionUID = 1L;
	private InvlogService invlogService;
	private InvlogModel  model;
	
	public InvlogService getInvlogService() {
		return invlogService;
	}
	public void setInvlogService(InvlogService invlogService) {
		this.invlogService = invlogService;
	}
	public void setModel(InvlogModel model) {
		this.model = model;
	}
	@Override
	public Object getModel() {
		if (model == null) {
			model = new InvlogModel();
		}
		return model;
	}
	public String list(){
		HashMap formParams = new HashMap<String,Object>();
		//获取实体类
		Invlog invlog = model.getEntity();
		//获取分页帮助类
		Pagebean pageBean = model.getPageBean();
		int sum  = invlogService.getCount(formParams,invlog);
		pageBean.setOffset();
		request.put(Const.SUM, sum);
		pageBean.setAllRows(sum);
		pageBean.setTotalPages();
		List<Invlog> list = invlogService.getList(formParams, invlog,pageBean.getOffset(),pageBean.pageSize);
		request.put(Const.INVLOG_LIST, list);
		return "list";
	}

	
	@Override
	public String toAdd() {
		List<InventoryTree>   inventoryTrees = 	invlogService.buildTree();
		Gson gson = new Gson();  
		request.put("inventoryTrees", gson.toJson(inventoryTrees));
		Invlog invlog = model.getEntity();
		//设置为出库
		invlog.setMIo("I");
		return super.toAdd();
	}
	public String doAdd() {
		Invlog invlog = model.getEntity();
		//获取当前用户
		UserInfoView currentuser = (UserInfoView) session.get(Const.currentUser);
		//设置为进货
		invlog.setMIo("I");
		invlog.setEditor(currentuser.getU_Number());
		invlog.setDatetime(new Date());
		if(invlogService.AddInvlog(invlog)){
			setInputStream("1");
		}else{
			setInputStream("0");
		}
		return "ajax-success";
 	}
	public String toDelivery(){
		List<InventoryTree>   inventoryTrees = 	invlogService.buildDeliveryTree();
		Gson gson = new Gson();  
		request.put("inventoryTrees", gson.toJson(inventoryTrees));
		return "toDelivery";
	}
	public String doDelivery(){
		Invlog invlog = model.getEntity();
		//获取当前用户
		UserInfoView currentuser = (UserInfoView) session.get(Const.currentUser);
		//设置为进货
		invlog.setMIo("O");
		invlog.setEditor(currentuser.getU_Number());
		invlog.setDatetime(new Date());
		//验证是否允许出库
		if(!invlogService.validateDelivery(invlog)){
			setInputStream("2");
			return "ajax-success";
		}
		//出库
		if(invlogService.deliveryInvlog(invlog)){
			setInputStream("1");
		}else{
			setInputStream("0");
		}
		return "ajax-success";
	}
}

