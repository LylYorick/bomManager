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
	<form class="form form-horizontal" id="form-user-add">
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">订单编号：</label>
		<div class="formControls col-xs-8 col-sm-9">	
			<s:hidden name="entity.orderNumber"></s:hidden>
			<label class="form-label " >${entity.orderNumber}</label>
		</div>
	</div>
			
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">订单分类：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<s:hidden name="entity.orderMode"></s:hidden>
			<label class="form-label " >${entity.orderMode}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<s:hidden name="entity.orderName"></s:hidden>
			<label class="form-label " >${entity.orderName}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>类型：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<s:hidden name="entity.orderType"></s:hidden>
			<label class="form-label " >${entity.orderType}</label>
		</div>
	</div>
		<div class="row cl">
		  <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>数量：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<s:hidden name="entity.orderQty"></s:hidden>
			<label class="form-label " >${entity.orderQty}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>材料：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<s:hidden name="entity.orderMaterial"></s:hidden>
			<label class="form-label " >${entity.orderMaterial}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>描述：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<s:hidden name="entity.orderDesc"></s:hidden>
			<label class="form-label " >${entity.orderDesc}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>需求日期：</label>
		<div class="formControls col-xs-8 col-sm-9">
				<s:hidden name="entity.reqDate"></s:hidden>
			<label class="form-label " >${entity.reqDate}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系人：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<s:hidden name="entity.contact"></s:hidden>
			<label class="form-label " >${entity.contact}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系电话：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<s:hidden name="entity.cellPhone"></s:hidden>
			<label class="form-label " >${entity.cellPhone}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系地址:</label>
		<div class="formControls col-xs-8 col-sm-9">
			<s:hidden name="entity.address"></s:hidden>
			<label class="form-label " >${entity.address}</label>
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>订单状态:</label>
		<div class="formControls col-xs-8 col-sm-9">
				<s:hidden name="entity.orderStatus"></s:hidden>
				<label class="form-label " >${entity.orderStatus}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>报价:</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text"  placeholder="" id="entity.orderPrice" name="entity.orderPrice"  value="${entity.orderPrice}">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>交货日期:</label>
		<div class="formControls col-xs-4 col-sm-3">
			<input type="text" class="input-text Wdate"  onclick="WdatePicker({isShowClear:false,readOnly:true})" placeholder="" id="entity.deliveryTime" name="entity.deliveryTime"  value="${entity.deliveryTime}">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3" >上传报价单文件：</label>
		<div class="formControls col-xs-12 col-sm-9">
		 <span class="btn-upload form-group" id="uploadSpan" >
			<a href="javascript:void();" class="btn btn-primary radius upload-btn"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
				<input class="input-text upload-url" type="text"  id="" readonly nullmsg="请添加文件！" style="width:200px">
				<input type="file"  name="img" class="input-file" id="uploadFile">
			</span> 
		</div>
	</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;" >
		</div>
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
	$("#form-user-add").validate({
		rules:{
			'entity.orderPrice':{
				required:true,
				minNumber:true,
				isFloatGteZero:true,
			},
			'img':{
				required:true,
				checkPicSize:true,
			},
		},
		errorPlacement: function(error, element) {
			var name = element.attr( "name" );
			if(name == "img" ){
				$("#uploadSpan").before(error);
			}
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			layer.confirm('是否确认审核？',function(){
				$(form).ajaxSubmit({
					type: 'post',
					url: "order-doVerify", 
					success: function(data){
						console.log(data);
						if(data == "1"){
							layer.msg('审核成功!',{icon:1,time:1000});
							setTimeout(function(){
								var index = parent.layer.getFrameIndex(window.name);
								parent.location.reload();
								parent.layer.close(index);
							},1000);
						}
						if(data == "0"){
							layer.msg('审核失败!',{icon:1,time:1000});
						}
					},
	                error: function(XmlHttpRequest, textStatus, errorThrown){
						layer.msg('error!',{icon:1,time:1000}); 
					}
				});
			});
		}
		
	});
}); 
</script> 
</html>