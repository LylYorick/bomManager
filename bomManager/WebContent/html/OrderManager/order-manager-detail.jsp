<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/H-ui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/style.css" />
	<style type="text/css">
		.a_downlaod:HOVER{
			cursor:pointer
		}
		.a_downlaod{
			color: blue;
			font-weight: bolder;
		}
	</style>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-user-add">
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">订单编号：</label>
		<div class="formControls col-sm-3">	
			<label class="form-label " >${entity.orderNumber}</label>
		</div>
	</div>
			
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">订单分类：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<s:hidden name="entity.orderMode"></s:hidden>
			<label class="form-label " >${entity.orderMode}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">名称：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<s:hidden name="entity.orderName"></s:hidden>
			<label class="form-label " >${entity.orderName}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">类型：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<s:hidden name="entity.orderType"></s:hidden>
			<label class="form-label " >${entity.orderType}</label>
		</div>
	</div>
		<div class="row cl">
		  <label class="form-label col-xs-4 col-sm-3">数量：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<s:hidden name="entity.orderQty"></s:hidden>
			<label class="form-label " >${entity.orderQty}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">材料：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<s:hidden name="entity.orderMaterial"></s:hidden>
			<label class="form-label " >${entity.orderMaterial}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">描述：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<s:hidden name="entity.orderDesc"></s:hidden>
			<label class="form-label " >${entity.orderDesc}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">需求日期：</label>
		<div class="formControls col-xs-8 col-sm-3">
				<s:hidden name="entity.reqDate"></s:hidden>
			<label class="form-label " ><s:date name="entity.reqDate" format="yyyy-MM-dd"/></label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">联系人：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<s:hidden name="entity.contact"></s:hidden>
			<label class="form-label " >${entity.contact}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">联系电话：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<s:hidden name="entity.cellPhone"></s:hidden>
			<label class="form-label " >${entity.cellPhone}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">联系地址：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<s:hidden name="entity.address"></s:hidden>
			<label class="form-label " >${entity.address}</label>
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">订单状态：</label>
		<div class="formControls col-xs-8 col-sm-3">
				<s:hidden name="entity.orderStatus"></s:hidden>
				<label class="form-label " >${entity.orderStatus}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">报价：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<label class="form-label " >${entity.orderPrice}</label>
		</div>
	</div>

	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">审核时间：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<label class="form-label " ><s:date name="entity.verifyTime" format="yyyy-MM-dd hh:mm:ss"/></label>
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">审核人：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<label class="form-label " >${entity.verifyBy}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">订单确认：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<label class="form-label " >
			<s:if test="'Y'.toString().equals(entity.orderConfirm)">
					是
				</s:if>
				<s:else>
					否
				</s:else>
			</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">确定时间：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<label class="form-label " ><s:date name="entity.confirmTime" format="yyyy-MM-dd hh:mm:ss"/></label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">确定人：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<label class="form-label " >${entity.confirmBy}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">是否交货：</label>
		<div class="formControls col-xs-8 col-sm-3">
		
			<label class="form-label " >
				<s:if test="'Y'.toString().equals(entity.delivered)">
					是
				</s:if>
				<s:else>
					否
				</s:else>
			</label>
		</div>
	</div>

	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">交货日期：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<label class="form-label " ><s:date name="entity.deliveryTime" format="yyyy-MM-dd hh:mm:ss"/></label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">结算金额：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<label class="form-label " >${entity.payment}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">结算方式：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<label class="form-label " >${entity.payWay}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">是否结算：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<label class="form-label " >
				<s:if test="'Y'.toString().equals(entity.paid)">
					是
				</s:if>
				<s:else>
					否
				</s:else>
			</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">运输方式：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<label class="form-label " >${entity.express}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">快递单号：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<label class="form-label " >${entity.expressNum}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">文件名：</label>
		<div class="formControls col-xs-8 col-sm-4">
			<label class="form-label">${entity.fileName}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"> 报价单文件：</label>
		<div class="formControls col-xs-8 col-sm-5">
			<a class="form-label a_downlaod"  href="${pageContext.request.contextPath}/quotationFile/${entity.orderNumber}/${entity.quotationFile}" download="${entity.quotationFile}">${entity.quotationFile}</a>
		</div>
	</div>
	</form>
</article>
</body>
	<!-- _footer 作为公共模版分离出去 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/hui/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/hui/H-ui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/hui/H-ui.admin.js"></script>
<!-- /_footer 作为公共模版分离出去 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/messages_zh.js"></script> 
</html>