<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/H-ui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/style.css" />
	<!-- _footer 作为公共模版分离出去 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/hui/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/hui/H-ui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/hui/H-ui.admin.js"></script>
<!-- /_footer 作为公共模版分离出去 -->
<title>Insert title here</title>
</head>
	<body>
		<nav class="breadcrumb">
			<i class="Hui-iconfont">&#xe667;</i> 
			首页
			<span class="c-gray en">&gt;</span>
			建立订单
		</nav>
		
		<div class="cl pd-5 bg-1 bk-gray mt-20">
		 <span>
		 	<a href="javascript:;" onclick="order_add('定制加工订单建立','order-toAddjj.action','800','600')" class="btn btn-primary radius">
		 	<i class="Hui-iconfont">&#xe600;</i> 定制加工订单建立
			</a>
		 </span>
			机械加工，PCB加工，电路装调，3D打印，模压，注塑，激光焊接
		 </div>
		 <div class="cl pd-5 bg-1 bk-gray mt-20">
		  <span>
		 	<a href="javascript:;" onclick="order_add('定制设计订单建立','order-toAddpcb.action','800','600')" class="btn btn-primary radius">
		 	<i class="Hui-iconfont">&#xe600;</i> 定制设计订单建立
		 </a>
		 </span>
		 	结构设计，2维机械设计，3D模型设计，电路原理图，PCB绘图，模压模具设计，嵌入式编程
		  </div>
		  <div class="cl pd-5 bg-1 bk-gray mt-20">
			  <span>
			 	<a href="javascript:;" onclick="order_add('定制采购订单建立','order-toAddgx.action','800','600')" class="btn btn-primary radius">
			 	<i class="Hui-iconfont">&#xe600;</i>定制采购订单建立
			 </a>
			 </span>
			电子元器件，BOM配单，激光配件，姿态传感，磁性元件，特种轴承，海外采购
		 </div>
		  <div class="cl pd-5 bg-1 bk-gray mt-20">
			  <span>
			 	<a href="javascript:;" onclick="order_add('定制软件订单建立','order-toAddxt.action','800','600')" class="btn btn-primary radius">
			 		<i class="Hui-iconfont">&#xe600;</i> 定制软件订单建立
				 </a>
				企业网站，BOM管理，产品管理，生产管理，实验管理，无人地面站，虚拟仪器
			 </span>
		  </div>
		<%--  <div class="cl pd-5 bg-1 bk-gray mt-20">
		  <span>
		 	<a href="javascript:;" onclick="order_add('全球定制采购订单建立','order-toAddcg.action','800','600')" class="btn btn-primary radius">
		 		<i class="Hui-iconfont">&#xe600;</i> 全球定制采购订单建立
			 </a>
		 </span>
		 	国内采购，国外采购，设备租用
		  </div> --%>
 		<img
		src="images/order-background.jpg"
		border="0"/>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="js/hui/jquery.dataTables.min.js"></script> 
	<script type="text/javascript" src="js/hui/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="js/jquery.form.js"></script>
	

	<script type="text/javascript">
	/*
		参数解释：
		title	标题
		url		请求的url
		id		需要操作的数据id
		w		弹出层宽度（缺省调默认值）
		h		弹出层高度（缺省调默认值）
	*/
	/*管理员-增加*/
	function order_add(title,url,w,h){
		layer_show(title,url,w,h);
	}
	
	</script>
</body>
</html>