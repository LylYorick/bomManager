/*
 * 文件名：WebContext.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： WebContext.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年5月11日
 * 修改内容：新增
 */
package com.manager.common;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年5月11日
 * @since      CCAS
 */
@SuppressWarnings("unchecked")
public class WebContext  implements IContext {
	
/*	public final static String ERROR= "error";
	
	FlowerTypeService flowerTypeService;
	
	
	


	public FlowerTypeService getFlowerTypeService() {
		return flowerTypeService;
	}


	public void setFlowerTypeService(FlowerTypeService flowerTypeService) {
		this.flowerTypeService = flowerTypeService;
	}
*/

	@Override
	@SuppressWarnings("unused")
	public String getFlowerTypeName(int TypeId) {
		Map<String, Object> session =  ActionContext.getContext().getSession();
		/*	List<FlowerType> list = (List<FlowerType>)session.get("allFlowerTypes");*/
		/*if (null == list) {
            list = flowerTypeService.getAll();
            session.put("allFlowerTypes", list);
        }*/
		/*List<FlowerType> list = new ArrayList<FlowerType>();
		list = flowerTypeService.getAll();
        session.put("allFlowerTypes", list);
        for(FlowerType item:list){
        	if(item.getId() == TypeId){
        		return item.getFlowerName();
        	}
        }*/
       return "error";
	}
	
}

