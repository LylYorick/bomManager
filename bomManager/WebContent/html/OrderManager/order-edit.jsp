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
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-order-add">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">订单编号：</label>
		<div class="formControls col-xs-4 col-sm-3">
			<s:hidden name="entity.orderNumber"></s:hidden>
			<label class="form-label " >${entity.orderNumber}</label>
		</div>
		<label class="form-label col-xs-4 col-sm-3">订单分类：</label>
		<div class="formControls col-xs-4 col-sm-3">	
			<s:hidden name="entity.orderMode"></s:hidden>
			<label class="form-label " >${entity.orderMode}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">名称：</label>
		<div class="formControls col-xs-4 col-sm-3">	
			<input type="text" class="input-text"  placeholder="" id="orderName" name="entity.orderName" value="${entity.orderName} ">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>类型：</label>
		<div class="form-label col-xs-4 col-sm-3">
			<input type="text" class="input-text"  placeholder="" id="orderType" name="entity.orderType" value="${entity.orderType}"  >
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>材料：</label>
		<div class="form-label col-xs-4 col-sm-3">
			<input type="text" class="input-text"   placeholder="" id="orderMaterial" name="entity.orderMaterial" value="${entity.orderMaterial}" >
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>描述：</label>
		<div class="form-label col-xs-4 col-sm-3">
			<input type="text" class="input-text" placeholder="" id="orderDesc" name="entity.orderDesc"  value="${entity.orderDesc}">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>需求日期：</label>
		<div class="form-label col-xs-4 col-sm-3">
			<input type="text" class="input-text Wdate"    onclick="WdatePicker({isShowClear:false,readOnly:true})"  placeholder="" id="reqDate" name="entity.reqDate"  value="${entity.reqDate}" >
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>数量：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<input type="text"  class="input-text"   placeholder="" id="orderQty" name="entity.orderQty"  value="${entity.orderQty}">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>报价:</label>
		<div class="formControls col-xs-8 col-sm-3">
			<input type="text" class="input-text"  placeholder="" id="entity.orderPrice" name="entity.orderPrice"  value="${entity.orderPrice}">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系人：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<input type="text" class="input-text"  placeholder="" id="contact" name="entity.contact" value="${entity.contact}" >
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系电话：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<input type="text" class="input-text"  placeholder="" id="cellPhone" name="entity.cellPhone"  value="${entity.cellPhone}">
		</div>
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系地址：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<input type="text" class="input-text"  placeholder="" id="address" name="entity.address" value="${entity.address}" >
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"> 图片文件：</label>
		<div class="formControls col-xs-8 col-sm-4">
		<a class="form-a"  href="${pageContext.request.contextPath}/OrderFile/${entity.fileName}" download="${entity.fileName}">${entity.fileName}</a>
		</div>
	</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-3 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;"  >
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
$(function(){
	$("#form-order-add").validate({
		debug:true,
		rules:{
			'entity.orderName':{
				required:true,
			},
			'entity.orderType':{
				required:true,
			},
			'entity.orderQty':{
				required:true,
			},
			'entity.orderMaterial':{
				required:true,
			},
			'entity.reqDate':{
				required:true,
			},
			'entity.contact':{
				required:true,
			},
			'entity.cellPhone':{
				required:true,
			},
			'entity.address':{
				required:true,
			},
			'img':{
				required:true,
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type: 'post',
				url: "order-doEdit", 
				success: function(data){
					//alert(data);
					if(data == "1"){
						layer.msg('编辑成功!',{icon:1,time:1000});
						setTimeout(function(){
							var index = parent.layer.getFrameIndex(window.name);
							parent.location.reload();
							parent.layer.close(index);
						},1000);
					}
					if(data == "0"){
						layer.msg('编辑失败!',{icon:1,time:1000});
					}
					
				},
                error: function(XmlHttpRequest, textStatus, errorThrown){
					layer.msg('error!',{icon:1,time:1000}); 
				}
			});
		}
	
	});
});  


</script> 
</html>