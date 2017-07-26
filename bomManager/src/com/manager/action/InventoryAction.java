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
import com.manager.entity.model.InventoryModel;
import com.manager.entity.view.UserInfoView;
import com.manager.service.InventoryService;
import com.manager.service.InvlogService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月6日
 * @since      CCAS
 */
public class InventoryAction  extends BaseAction  implements ModelDriven{
	private static final long serialVersionUID = 1L;
	private InventoryService inventoryService;
	private InventoryModel  model;
	
	
	public InventoryService getInventoryService() {
		return inventoryService;
	}
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	public void setModel(InventoryModel model) {
		this.model = model;
	}
	@Override
	public Object getModel() {
		if (model == null) {
			model = new InventoryModel();
		}
		return model;
	}
	public String list(){
		HashMap formParams = new HashMap<String,Object>();
		//获取实体类
		Inventory inventory = model.getEntity();
		//获取分页帮助类
		Pagebean pageBean = model.getPageBean();
		int sum  = inventoryService.getCount(formParams,inventory);
		pageBean.setOffset();
		request.put(Const.SUM, sum);
		pageBean.setAllRows(sum);
		pageBean.setTotalPages();
		List<Inventory> list = inventoryService.getList(formParams, inventory,pageBean.getOffset(),pageBean.pageSize);
		request.put(Const.INVENTORY_LIST, list);
		return "list";
	}

}

