<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户编辑页面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/H-ui.css" />
	<link rel="stylesheet" type="text/css" href="css/hui/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="css/hui/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="css/hui/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="css/hui/style.css" />
	<!-- _footer 作为公共模版分离出去 -->
	<script type="text/javascript" src="js/jquery.js"></script> 
	<script type="text/javascript" src="js/hui/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="js/hui/H-ui.js"></script>
	<script type="text/javascript" src="js/hui/H-ui.admin.js"></script>
	<!-- /_footer 作为公共模版分离出去 -->
</head>
<body>
<%-- <s:debug></s:debug> --%>
<article class="page-container">
	<form class="form form-horizontal" id="form-user-edit">
	<s:hidden  name="u_Number"></s:hidden>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户编码：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<label class="form-label ">${u_Number}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${u_Name}" placeholder="" id="u_Name" name="u_Name">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系方式：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${u_Phone}" placeholder="" id="u_Phone" name="u_Phone">
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户职称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${u_Title}" placeholder="" id="u_Title" name="u_Title">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>公司名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${u_Comany}" placeholder="" id="u_Comany" name="u_Comany">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系地址：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${u_Address}" placeholder="" id="u_Address" name="u_Address">
		</div>
	</div>
	<s:if test="session.currentUser.u_Level > 3">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户等级：</label>
		<div class="formControls col-xs-8 col-sm-9">
		<span class="select-box">
			<select class="select"  name="u_level">
					<s:iterator  value="#session.allLevels" var="index">
						 <option value='<s:property value="#index"/>' <s:if test="#index == u_Level"> selected</s:if>  ><s:property value="#index"/></option> 
					</s:iterator> 
			</select>
		</span>
		</div>
	</div>
	</s:if>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>建立日期：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<label class="form-label"><s:date name="u_CreateDate" format="yyyy-MM-dd hh:mm:ss"/></label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>编辑人：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<label class="form-label ">${editor}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>编辑时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<label class="form-label"><s:date name="datetime" format="yyyy-MM-dd hh:mm:ss"/></label>
		</div>
	</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input id="aa" class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
	</form>
</article>
</body>
<script type="text/javascript" src="js/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="js/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="js/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
$(function(){
	$("#form-user-edit").validate({
		rules:{
			u_Phone:{
				required:true,
			},
			u_Comany:{
				required:true,
			},
			u_Address:{
				required:true,
			},
			u_Level:{
				required:true,
			},
			editor:{
				required:true,
			}
			
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type: 'post',
				url: "user-doEdit", 
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