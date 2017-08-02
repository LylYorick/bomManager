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
import com.manager.entity.common.Pagebean;
import com.manager.entity.common.PoiUtil;
import com.manager.entity.model.BomModel;
import com.manager.entity.model.OrderModel;
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
		return "list";
	}

}
