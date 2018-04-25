package com.manager.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Const {
	
	/**
	 * 当前用户
	 */
	public static String currentUser="currentUser";
	
	/**
	 * 上传图片dir
	 */
	public static String MESSGE_IMG_DIR="messageImg/";
	/**
	 * 用户列表
	 */
	public static String USER_LIST="userList";
	
	/**
	 * MaterialViewList 
	 */
	public static String MATERIAL_VIEW_LIST="MaterialViewList";
	
	/**
	 * MaterialList
	 */
	public static String MATERIAL_LIST="MaterialList";
	
	/**
	 * SupplierList
	 */
	public static String SUPPLIER_LIST="SupplierList";
	/**
	 * InventoryList
	 */
	public static String INVENTORY_LIST="InventoryList";
	
	public static String INVLOG_LIST="InvlogList";
	
	/**
	 * OrderList
	 */
	public static String Order_LIST="OrderList";
	/**
	 * BomList
	 */
	public static String BOM_LIST="BomList";
	
	/**
	 * topBomList
	 */
	public static String TOP_BOM_LIST="TopBomList";
	
	/**
	 * 消息列表
	 */
	public static String MESSAGE_LIST = "messageList";
	public static String SUM="sum";
	
	/*public static  int [] allLevels =  {1,2,3,4,5};*/
	
	public static  String LEVELS = "allLevels" ;
	
	public static  ArrayList<Integer> allLevels= getAllLevel();
	
	private static ArrayList<Integer> getAllLevel(){
		ArrayList<Integer> Levels = new ArrayList<Integer>();
		for(int i =1 ;i<6;i++){
			Levels.add(i);
		}
		return Levels;
	}
}
