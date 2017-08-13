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
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.manager.common.Const;
import com.manager.common.tools.DateUtil;
import com.manager.common.tools.FileUtil;
import com.manager.common.tools.TimeHelper;
import com.manager.entity.Bom;
import com.manager.entity.BomId;
import com.manager.entity.Material;
import com.manager.entity.MaterialId;
import com.manager.entity.Order;
import com.manager.entity.common.Pagebean;
import com.manager.entity.common.PoiUtil;
import com.manager.entity.model.BomModel;
import com.manager.entity.view.UserInfoView;
import com.manager.service.BomService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * TODO添加类描述
 * 
 * @author liyuelong 1610139
 * @version CCAS 2017年7月6日
 * @since CCAS
 */
public class BomAction extends BaseAction implements ModelDriven {
	private static final long serialVersionUID = 1L;
	private BomService bomService;
	private BomModel model;

	public BomService getBomService() {
		return bomService;
	}
	public void setBomService(BomService bomService) {
		this.bomService = bomService;
	}
	@Override
	public Object getModel() {
		if (model == null) {
			model = new BomModel();
		}
		return model;
	}
	public String list(){
		HashMap formParams = new HashMap<String,Object>();
		Bom bom = model.getEntity();
		String json = bomService.getListJson(formParams, bom);
		request.put("bomJson", json);
		List<String> topPartList = bomService.getTopBom(formParams, bom);
		request.put("topPartList", topPartList);
		return "list";
	}
	/**
	 * bom管理的查询
	 * @return
	 */
	public String normalList(){
		HashMap formParams = new HashMap<String,Object>();
		Bom bom = model.getEntity();
		Pagebean pageBean = model.getPageBean();
		int sum  = bomService.getNormalCount(formParams,bom);
		pageBean.setOffset();
		request.put(Const.SUM, sum);
		pageBean.setAllRows(sum);
		pageBean.setTotalPages();
		List<Bom> list = bomService.getNormalList(formParams, bom,pageBean.getOffset(),pageBean.pageSize);
		request.put(Const.BOM_LIST, list);
		return "normalList";
	}
	public String toEdit() {
		Bom bom = model.getEntity();
		BomId id = bom.getId();
		Bom item = bomService.getBom(id);
		model.setEntity(item);
		List<Material> materilList = bomService.getAllMertial();
		request.put(Const.MATERIAL_LIST, materilList);
		return "toEdit";
	}
	public String doEdit() {
		Bom bom = model.getEntity();
		String alterPartNumber = model.getAlterPartNumber();
		HashMap formParams = new HashMap<String,Object>();
		formParams.put("alterPartNumber", alterPartNumber);
		UserInfoView currentuser = (UserInfoView) session.get(Const.currentUser);
		bom.setEditor(currentuser.getU_Number());
		if(bomService.getBom(bom.getId()) == null){
			setInputStream("0");
		}
		if(	bomService.editBom(bom,formParams)){
			setInputStream("1");
		}else{
			setInputStream("0");
		}
		return "ajax-success";
	}
	public String toTopAdd() {
		List<Material> materilList = bomService.getAllMertial();
		request.put(Const.MATERIAL_LIST, materilList);
		return "toTopAdd";
	}
	public String doTopAdd() {
		HashMap formParams = new HashMap<String,Object>();
		Bom bom = model.getEntity();
		UserInfoView currentuser = (UserInfoView) session.get(Const.currentUser);
		bom.setEditor(currentuser.getU_Number());
		
		if(bomService.saveTopMaterial(bom)){
			setInputStream("1");
		}else{
			setInputStream("0");
		}
		return "ajax-success";
	}
	
	public String toAdd() {
		List<Bom> topBoms = bomService.getAllTopBom();
		request.put(Const.TOP_BOM_LIST, topBoms);
		List<Bom> boms = bomService.getAllBom();
		request.put(Const.BOM_LIST, boms);
		List<Material> materilList = bomService.getAllMertial();
		request.put(Const.MATERIAL_LIST, materilList);
		return "toAdd";
	}
	public String doAdd() {
		HashMap formParams = new HashMap<String,Object>();
		Bom bom = model.getEntity();
		UserInfoView currentuser = (UserInfoView) session.get(Const.currentUser);
		bom.setEditor(currentuser.getU_Number());
		if(bomService.saveNormalMaterial(bom)){
			setInputStream("1");
		}else{
			setInputStream("0");
		}
		return "ajax-success";
	}
	public String getNormal() {
		//TODO 4.1	BOM结构建立 未完成  获取非顶阶材料 新增struts2 转换为json
		HashMap formParams = new HashMap<String,Object>();
		Bom bom = model.getEntity();
	    List<Bom> list = bomService.getNormalMaterial(bom);
	    model.setEntityList(list);
		return  "json-ajax";
	}
	
	public String doExport() throws Exception{
		HashMap formParams = new HashMap<String,Object>();
		Bom bom = model.getEntity();
		//获取查询结果
		List<Bom> list = bomService.getList(formParams, bom);
		//如果查询的list为空 则直接进入list();
		if(list == null || list.isEmpty()){
			return list();
		}
		//生成excel
		PoiUtil poiUtil = new PoiUtil();
		//获取临时存储的文件夹并清空文件夹中的全部文件
		ServletContext servletContext = ServletActionContext.getServletContext();
		String directoryUrl = servletContext.getRealPath("/BomFile");
		FileUtil.clearDir(directoryUrl);
		//创建服务端临时的Excel文件 生成规则 为当前时间
		String fileName = DateUtil.getCurrentDateTime()+".xls";
		//设置客户端下载时看到的文件名
		model.setDocFileName(fileName);
		//构建excel文件
		String fileUrl = directoryUrl + File.separatorChar+fileName;
		poiUtil.setFileUrl(fileUrl);
		poiUtil.buildBomExcel(list);
		//导出excel文件
		inputStream = new FileInputStream(fileUrl);
		return "file-downLoad";
	}
	
	public String delete() {
		HashMap formParams = new HashMap<String,Object>();
		Bom bom = model.getEntity();
		Bom property = bomService.getBom(bom.getId());
		if( null == property){
			setInputStream("0");
			return "ajax-success";
		}
		if(bomService.deleteBom(property)){
			setInputStream("1");
		}else{
			setInputStream("0");
		}
		return "ajax-success";
	}
	
}
