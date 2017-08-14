<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户编辑页面</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/H-ui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/style.css" />
	<!-- _footer 作为公共模版分离出去 -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/hui/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/hui/H-ui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/hui/H-ui.admin.js"></script>
	<!-- /_footer 作为公共模版分离出去 -->
</head>
<body>
<%-- <s:debug></s:debug> --%>
<article class="page-container">
	<form class="form form-horizontal" id="form-user-edit">
	<s:hidden  name="u_Number"></s:hidden>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>原密码：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="password" class="input-text"  placeholder="" id="u_Password" name="u_Password">
			<s:hidden name="session.currentUser.u_Number"></s:hidden>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>新密码：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="password" class="input-text"  placeholder="" id="new_Password" name="new_Password">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>再次输入新密码：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="password" class="input-text" value="" placeholder="" id="comfirm_Password" name="comfirm_Password">
		</div>
	</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input  class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
	</form>
</article>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
$(function(){
	$("#form-user-edit").validate({
		rules:{
			u_Password:{
				minlength:1,
				required:true,
				remote: {
				    url: "user-checkPassword",     //后台处理程序
				    type: "post",               //数据发送方式
				    data: {                     //要传递的数据
				    	u_Number: function() {
				            return $("#session_currentUser_u_Number").val();
				        }
				    }
				}
			},
			new_Password:{
				minlength:6,
				required:true,
			},
			comfirm_Password:{
				equalTo:"#new_Password",
			},
		},    
		messages: {
			u_Password:{
				remote: "原密码错误",
			},
			comfirm_Password: {
				equalTo:"两次输入密码不同",
			}
		},
		onkeyup:false,
		focusCleanup:false,
		onfocusout:false,
		OnSubmit:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type: 'post',
				url: "user-doAlterPassword", 
				success: function(data){
					console.log(data);
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