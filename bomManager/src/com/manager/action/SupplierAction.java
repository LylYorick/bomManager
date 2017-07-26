/*
 * 文件名：SupplierAction.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： SupplierAction.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年7月6日
 * 修改内容：新增
 */
package com.manager.action;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.manager.common.Const;
import com.manager.entity.Material;
import com.manager.entity.MaterialId;
import com.manager.entity.Supplier;
import com.manager.entity.SupplierId;
import com.manager.entity.common.Pagebean;
import com.manager.entity.model.SupplierModel;
import com.manager.entity.view.UserInfoView;
import com.manager.service.SupplierService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年7月6日
 * @since      CCAS
 */
public class SupplierAction  extends BaseAction  implements ModelDriven{
	private static final long serialVersionUID = 1L;
	private SupplierService supplierService;
	private SupplierModel  model;
	
	public void setModel(SupplierModel model) {
		this.model = model;
	}
	public SupplierService getSupplierService() {
		return supplierService;
	}
	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	@Override
	public Object getModel() {
		if (model == null) {
			model = new SupplierModel();
		}
		return model;
	}
	public String list(){
		HashMap formParams = new HashMap<String,Object>();
		//获取实体类
		Supplier supplier = model.getEntity();
		//获取分页帮助类
		Pagebean pageBean = model.getPageBean();
		int sum  = supplierService.getCount(formParams,supplier);
		pageBean.setOffset();
		request.put(Const.SUM, sum);
		pageBean.setAllRows(sum);
		pageBean.setTotalPages();
		List<Supplier> list = supplierService.getList(formParams, supplier,pageBean.getOffset(),pageBean.pageSize);
		request.put(Const.SUPPLIER_LIST, list);
		return "list";
	}
	public String toEdit() {
		Supplier supplier = model.getEntity();
		SupplierId id = supplier.getId();
		Supplier item = supplierService.getSupplier(id);
		model.setEntity(item);
		return "toEdit";
	}
	public String doEdit() {
			UserInfoView currentuser = (UserInfoView) session.get(Const.currentUser);
			Supplier supplier= model.getEntity();
			supplier.setEditor(currentuser.getU_Number());
			if(supplierService.updateSupplier(supplier)){
				setInputStream("1");
			}else{
				setInputStream("0");
			}
		return "ajax-success";

	}
	public String doAdd() {
		UserInfoView currentuser = (UserInfoView) session.get(Const.currentUser);
		Supplier supplier= model.getEntity();
		//验证主键是否重复
		HashMap formParams = new HashMap<String,Object>();
		Supplier item = new Supplier(supplier.getId());
		int count =   supplierService.getCount(formParams, item);
		
		if(count>0){
			setInputStream("2");
			return "ajax-success";
		}
		//默认设置为不激活
		supplier.setPartActive("Y");
		supplier.setEditor(currentuser.getU_Number());
		supplier.setDatetime(new Date());
		if(supplierService.AddSupplier(supplier)){
			setInputStream("1");
		}else{
			setInputStream("0");
		}
		return "ajax-success";
 	}
	//验证主键是否重复
	public String validateId(){
		HashMap formParams = new HashMap<String,Object>();
		Supplier supplier= model.getEntity();
		int count =   supplierService.getCount(formParams, supplier);	
		if (count < 1) {
			setInputStream("1");
		}else{
			setInputStream("0");
		}
		return "ajax-success";
	}
	public String delete(){
			HashMap formParams = new HashMap<String,Object>();
			Supplier supplier= model.getEntity();
			boolean flag = supplierService.deleteSupplier(supplier);
			if(flag){
				setInputStream("1");
			}else{
				setInputStream("0");
			}
		return "ajax-success";
	}
}

