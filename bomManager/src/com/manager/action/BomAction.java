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
}
