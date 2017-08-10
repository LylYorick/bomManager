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
	<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>顶阶料号：</label>
		<div class="formControls col-xs-8 col-sm-9">	
			<s:hidden name="entity.id.partnumber"></s:hidden>
			<label class="form-label" >${entity.id.topPartnumber}</label>
		</div>
	</div>
			
	 <div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>顶阶料号名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<label class="form-label " >${entity.topName}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>父阶料号：</label>
		<div class="formControls col-xs-8 col-sm-9">
		<label class="form-label " >${entity.id.f_Partnumber}</label>
		</div>
	</div>
					
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>父阶料号名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<label class="form-label " >${entity.f_Name}</label>
		</div>
	</div>
	<div class="row cl">
	<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>本阶料号：</label>
		<div class="formControls col-xs-8 col-sm-9">	
			<label class="form-label" >${entity.id.partNumber}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>本阶料号名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<label class="form-label" >${entity.partName}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>阶层：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<label class="form-label " >${entity.secq}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用量：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text"  placeholder="" id="partSpec" name="useQty"  value="${entity.useQty}">
		</div>
	</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;" >
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
$(function(){
	$("#form-user-add").validate({
		rules:{
			partnumber:{
				required:true,
				maxlength:50,
			},
			partRev:{
				maxlength:10,
				required:true,
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type: 'post',
				url: "material-doEdit", 
				success: function(data){
					if(data == "1"){
						layer.msg('修改成功!',{icon:1,time:1000});
						setTimeout(function(){
							var index = parent.layer.getFrameIndex(window.name);
							parent.location.reload();
							parent.layer.close(index);
						},1000);
					}
					if(data == "0"){
						layer.msg('修改失败!',{icon:1,time:1000});
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