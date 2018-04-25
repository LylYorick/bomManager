<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script> 
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/kindEditor/kindeditor.js"></script>
	<!--layer弹出层框架-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/hui/layer/2.4/layer.js"></script>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/kindEditor/themes/default/default.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/H-ui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/style.css" />
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/kindEditor/lang/zh_CN.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/jquery.validate.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/validate-methods.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/messages_zh.js"></script> 
	<!--里面有 ajaxSubmit方法 -->
 	<script type="text/javascript" src="${pageContext.request.contextPath}/js/hui/H-ui.js"></script>

	<script type="text/javascript">
		var editor;
		//判断是新增还是修改消息
		var pageKey = "${request.pageKey}";
		function initKindEditor(){
			KindEditor.ready(function(K) {
				editor = K.create('#desc', {
					allowFileManager : true,
					// 指定上传文件参数名称
					filePostName : "img",
					// 指定上传文件请求的url。
					uploadJson : 'message-uploadMessage',
					// 上传类型，分别为image、flash、media、file
				/* 	dir : "image", */
					height : '400px'
				});
			});
		}
		$(function(){
			initKindEditor();
			validateInit();
		});
		function validateInit(){
			$("#messageForm").validate({
				rules:{
					'entity.title':{
						required:true,
					},
					'entity.desc':{
						required:true,
					}
				},
				onkeyup:false,
				focusCleanup:true,
				success:"valid",
				submitHandler:function(form){
					layer.confirm('确认要'+ pageKey +'这条消息吗？',function(){
						editor.sync();
						$(form).ajaxSubmit({
							type: 'post',
							url: "message-add", 
							success: function(data){
								if(data.status == 200){
									layer.msg( pageKey +'消息成功!',{icon:1,time:1000});
									setTimeout(function(){
										var index = parent.layer.getFrameIndex(window.name);
										parent.location.reload();
										parent.layer.close(index);
									},1000);
								}else if(data.status == 500){
									layer.alert(data.msg, {icon: 2});
								}
							},
			                error: function(XmlHttpRequest, textStatus, errorThrown){
			                	layer.msg('添加成功!',{icon:1,time:1000});
							}
						});
					});
				}
			})
		}
	</script>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="messageForm" action="message-add" >
	<div class="row cl">
		<s:hidden name="entity.id"></s:hidden>
		<s:hidden name="entity.created"></s:hidden>
		<label class="form-label col-md-2 	col-sm-2">消息标题：</label>
		<div class="formControls col-md-10 col-sm-10">
			<input type="text" class="input-text"  placeholder="" id="title" name="entity.title" value="${entity.title}">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-md-2 col-sm-2">消息内容：</label>
		<div class="formControls col-md-10 col-sm-10 ">
			<textarea type="width:800px;height:800px;visibility:hidden;" name="entity.desc" id="desc">${entity.desc}</textarea>
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
</html>