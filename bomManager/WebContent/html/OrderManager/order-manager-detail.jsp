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
	<table class="table table-bordered table-border">
		<tr>
			<td>订单编号：</td>
			<td><label class="form-label " >${entity.orderNumber}</label></td>
			<td>订单分类：</td>
			<td><label class="form-label " >${entity.orderMode}</label></td>
		</tr>
		<tr>
			<td>名称：</td>
			<td><label class="form-label " >${entity.orderName}</label></td>
			<td>类型：</td>
			<td><label class="form-label " >${entity.orderType}</label></td>
		</tr>
		<tr>
			<td>数量：</td>
			<td><label class="form-label " >${entity.orderQty}</label></td>
			<td>材料：</td>
			<td><label class="form-label " >${entity.orderMaterial}</label></td>
		</tr>
		<tr>
			<td>描述：</td>
			<td><label class="form-label " >${entity.orderDesc}</label></td>
			<td>需求日期：</td>
			<td><label class="form-label " ><s:date name="entity.reqDate" format="yyyy-MM-dd"/></label></td>
		</tr>
		<tr>
			<td>联系人：</td>
			<td><label class="form-label " >${entity.contact}</label></td>
			<td>联系电话：</td>
			<td><label class="form-label " >${entity.cellPhone}</label></td>
		</tr>
		<tr>
			<td>联系地址：</td>
			<td><label class="form-label " >${entity.address}</label></td>
			<td>订单状态：</td>
			<td><label class="form-label " >${entity.orderStatus}</label></td>
		</tr>
		<tr>
			<td>报价：</td>
			<td><label class="form-label " >${entity.orderPrice}</label></td>
			<td>审核时间：</td>
			<td><label class="form-label " ><s:date name="entity.verifyTime" format="yyyy-MM-dd hh:mm:ss"/></label></td>
		</tr>
		<tr>
			<td>审核人：</td>
			<td><label class="form-label " >${entity.verifyBy}</label></td>
			<td>订单确认：</td>
			<td>
				<label class="form-label " >
					<s:if test="'Y'.toString().equals(entity.orderConfirm)">
						是
					</s:if>
					<s:else>
						否
					</s:else>
				</label>
			</td>
		</tr>
		<tr>
			<td>确定时间：</td>
			<td>
				<label class="form-label " ><s:date name="entity.confirmTime" format="yyyy-MM-dd hh:mm:ss"/></label>
			</td>
			<td>确定人：</td>
			<td>
				<label class="form-label " >${entity.confirmBy}</label>
			</td>
		</tr>
		<tr>
			<td>是否交货：</td>
			<td>
				<label class="form-label " >
					<s:if test="'Y'.toString().equals(entity.delivered)">
						是
					</s:if>
					<s:else>
						否
					</s:else>
				</label>
			</td>
			<td>交货日期：</td>
			<td>
				<label class="form-label " ><s:date name="entity.deliveryTime" format="yyyy-MM-dd hh:mm:ss"/></label>
			</td>
		</tr>
		<tr>
			<td>结算金额：</td>
				<label class="form-label " >${entity.payment}</label>
			<td>
			</td>
			<td>结算方式：</td>
			<td>
				<label class="form-label " >${entity.payWay}</label>
			</td>
		</tr>
		<tr>
			<td>是否结算：</td>
			<td>
				<label class="form-label " >
					<s:if test="'Y'.toString().equals(entity.paid)">
						是
					</s:if>
					<s:else>
						否
					</s:else>
				</label>
			</td>
			<td>运输方式：</td>
			<td>
				<label class="form-label " >${entity.express}</label>
			</td>
		</tr>
		<tr>
			<td>快递单号：</td>
				<label class="form-label " >${entity.expressNum}</label>
			<td>
			</td>
			<td>文件名：</td>
			<td>
				<label class="form-label " >${entity.fileName}</label>
			</td>
		</tr>
		<tr>
			<td>报价单文件：</td>
			<td>
				<a class="form-label a_downlaod"  href="${pageContext.request.contextPath}/quotationFile/${entity.orderNumber}/${entity.quotationFile}" download="${entity.quotationFile}">${entity.quotationFile}</a>
			</td>
			<td></td>
			<td>
			</td>
		</tr>
	</table>
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