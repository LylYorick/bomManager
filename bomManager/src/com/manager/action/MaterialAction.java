/*
 * 文件名：UserIAction.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： UserIAction.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年4月26日
 * 修改内容：新增
 */
package com.manager.action;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.manager.common.Const;
import com.manager.entity.Bom;
import com.manager.entity.Material;
import com.manager.entity.common.Pagebean;
import com.manager.entity.model.MaterialModel;
import com.manager.entity.view.UserInfoView;
import com.manager.service.MaterialService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年4月26日
 * @since      CCAS
 */
public class MaterialAction extends BaseAction  implements ModelDriven{

	private static final long serialVersionUID = -8478640626209201412L;
	private MaterialService materialService;
	private MaterialModel model;

	public MaterialService getMaterialService() {
		return materialService;
	}

	public void setMaterialService(MaterialService materialService) {
		this.materialService = materialService;
	}

	public void setModel(MaterialModel model) {
		this.model = model;
	}

	
	public String list(){
		HashMap formParams = new HashMap<String,Object>();
		//获取实体类
		Material material = model.getEntity();
		//获取分页帮助类
		Pagebean pageBean = model.getPageBean();
		int sum  = materialService.getCount(formParams,material);
		pageBean.setOffset();
		request.put(Const.SUM, sum);
		pageBean.setAllRows(sum);
		pageBean.setTotalPages();
		List<Material> list = materialService.getList(formParams, material,pageBean.getOffset(),pageBean.pageSize);
		request.put(Const.MATERIAL_VIEW_LIST, list);
		return "list";
	}
	//验证主键是否重复
	public String validateId(){
		HashMap formParams = new HashMap<String,Object>();
		Material material = model.getEntity();
		material.setPartActive("Y");
		int count =   materialService.getCount(formParams, material);	
		if (count < 1) {
			setInputStream("true");
		}else{
			setInputStream("false");
		}
		return "ajax-success";
	}
	public String doAdd() {
		try{
			UserInfoView currentuser = (UserInfoView) session.get(Const.currentUser);
			Material material = model.getEntity();
			material.setEditor(currentuser.getU_Number());
			material.setDatetime(new Date());
			material.setPartActive("Y");
			materialService.AddMaterial(material);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "ajax-success";
	}
	public String toEdit() {
		Material material = model.getEntity();
		Material item = materialService.getMaterial(material);
		model.setEntity(item);
		return "toEdit";
	}
	public String doEdit() {
		try{
			UserInfoView currentuser = (UserInfoView) session.get(Const.currentUser);
			Material material = model.getEntity();
			material.setEditor(currentuser.getU_Number());
			materialService.updateMaterial(material);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		}catch(UnsupportedEncodingException e){
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "ajax-success";
	}

	@Override
	public Object getModel() {
		if(model == null){
			model = new MaterialModel();
		}
		return model;
	}
}

