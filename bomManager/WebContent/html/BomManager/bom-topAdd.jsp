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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/select2/select2.css" />
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-user-add">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>顶阶料号：</label>
		<div class="formControls col-xs-8 col-sm-9">	
				 <select class="multiSelect"  name="entity.id.topPartnumber" id="topPartnumber">
   		   			<s:iterator value="#request.MaterialList" id="item" >
   		   				<option value='<s:property value="#item.partnumber"/>' topName='<s:property value="#item.partName"/>'/><s:property value="#item.partnumber"/> <s:property value="#item.partName"/></option>
   		   			</s:iterator>
	   		    </select>
				<input type="hidden"  name="entity.topName"  id="topName" >
		</div>
	</div>
	 <div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用量：</label>
			<div class="form-label col-xs-4 col-sm-3">
			<input type="text" class="input-text"  placeholder="" id="useQty" name="entity.useQty" >
		</div>
	</div>
	</div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;" >
		</div>
	</div>
	</form>
</article>
</body>
	<!-- _footer 作为公共模版分离出去 -->
	 <!--jQuery v1.9.1 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/hui/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/hui/H-ui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/hui/H-ui.admin.js"></script>
<!-- /_footer 作为公共模版分离出去 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/messages_zh.js"></script> 

<script type="text/javascript" src="${pageContext.request.contextPath}/js/select2/select2.js"></script> 
<script type="text/javascript">
$(function(){
	  $(".multiSelect").select2({ 
		  width: "300px",
		  placeholder:"sjss",
		  allowClear:true,
	 });
	 $("#topPartnumber").change(function(){
		  var topName =  $(this).find("option:selected").attr("topName");
		  $("#topName").val(topName);  
	 });
	$("#form-user-add").validate({
		rules:{
			'id.topPartnumber':{
				required:true,
			},
			'entity.useQty':{
				required:true,
				minNumber:true,
				isFloatGteZero:true,
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type: 'post',
				url: "bom-doTopAdd", 
				success: function(data){
					if(data == "1"){
						layer.msg('添加成功!',{icon:1,time:1000});
						setTimeout(function(){
							var index = parent.layer.getFrameIndex(window.name);
							parent.location.reload();
							parent.layer.close(index);
						},1000);
					}
					if(data == "0"){
						layer.msg('添加失败!',{icon:1,time:1000});
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