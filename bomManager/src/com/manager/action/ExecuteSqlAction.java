/*
 * 文件名：SupplierAction.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： SupplierAction.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月6日
 * 修改内容：新增
 */
package com.manager.action;

import com.manager.entity.model.ExecuteSqlModel;
import com.manager.service.InventoryService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月6日
 * @since      CCAS
 */
public class ExecuteSqlAction  extends BaseAction  implements ModelDriven{
	private static final long serialVersionUID = 1L;
	private InventoryService inventoryService;
	private ExecuteSqlModel  model;
	
	
	public InventoryService getInventoryService() {
		return inventoryService;
	}
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	public void setModel(ExecuteSqlModel model) {
		this.model = model;
	}
	@Override
	public Object getModel() {
		if (model == null) {
			model = new ExecuteSqlModel();
		}
		return model;
	}
	public String executeSql(){
		String result = null;
		//如果是查询
		result = inventoryService.excuteSql(model.getSqlType(), model.getSql());
		model.setResult(result);
		return "list";
	}

}

