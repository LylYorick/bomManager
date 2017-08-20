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
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>料号：</label>
		<div class="formControls col-xs-8 col-sm-9">	
			 	<select class="multiSelect"  name="entity.id.partnumber" id="partNumber">
   		   			<s:iterator value="#request.MaterialList" id="item" >
   		   				<option value='<s:property value="#item.partnumber"/>' partName='<s:property value="#item.partName"/>'/><s:property value="#item.partnumber"/> <s:property value="#item.partName"/></option>
   		   			</s:iterator>
	   		    </select>
	   		    <input type="hidden"  name="entity.partName"  id="partName" >
		</div>
	</div>
			
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
				<span id="spanPartName" name="entity.partName" ></span>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>版本：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text"  class="input-text"   placeholder="" id="partRev" name="entity.id.partRev"  >
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>供应商名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text"   placeholder="" id="supplierName" name="entity.id.supplierName" >
		</div>
	</div>
		<div class="row cl">
		  <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>供应商代码：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" placeholder="" id="supplierCode" name="entity.supplierCode">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>材料规格：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text"  placeholder="" id="partSpec" name="entity.partSpec"  >
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>执行标准：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text"  placeholder="" id="partStandard" name="entity.partStandard" >
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>单位：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text"  placeholder="" id="partUnit" name="entity.partUnit" >
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>单价：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text"  placeholder="" id="partPrice" name="entity.partPrice" >
		</div>
	</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;" onsubmit="return checkId()">
		</div>
	</div>
	</form>
</article>
</body>
	<!-- _footer 作为公共模版分离出去 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
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
	  $("#partNumber").select2({
		 	 placeholder:'请选择',
			 allowClear:true,
			 width: "300px",
	  });
	  $("#partNumber").val(null).trigger("change"); 
	  $("#partNumber").change(function(){
		  var partName =  $(this).find("option:selected").attr("partName");
		  $("#partName").val(partName);  
		  $("#spanPartName").text(partName);  
	 });
	$("#form-user-add").validate({
		debug:true,
		rules:{
			'entity.id.partnumber':{
				required:true,
			},
			'entity.id.supplierName':{
				required:true,
			},
			'entity.partSpec':{
				required:true,
			},
			'entity.partStandard':{
				required:true,
			},
			'entity.partUnit':{
				required:true,
			},
			'entity.partPrice':{
				required:true,
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type: 'post',
				url: "supplier-doAdd", 
				success: function(data){
					if(data == "1"){
						layer.msg('注册成功!',{icon:1,time:1000});
						setTimeout(function(){
							var index = parent.layer.getFrameIndex(window.name);
							parent.location.reload();
							parent.layer.close(index);
						},1000);
					}
					if(data == "0"){
						layer.msg('注册失败!',{icon:1,time:1000});
					}
					if(data == "2"){
						layer.alert('注册失败,一个料号，一个版本，只能建立一行同一供应商记录!',{icon:5});
					}
				},
                error: function(XmlHttpRequest, textStatus, errorThrown){
					layer.msg('error!',{icon:1,time:1000}); 
				}
			});
			
		}
	
	});
});  
function checkId(){
	$.ajax({
		type: 'post',
		url: "suppplier-validateId", 
		data:{
				'entity.id.partnumber':$("#partnumber").val(),
	     		'entity.id.partRev':$("#partRev").val(),
	     		'entity.id.supplierName':$("#supplierName").val(),
		},
		success: function(data){
			console.log(data);
			if(data == "0"){
				layer.msg('一个料号一个版本只能有一笔记录!',{icon:1,time:1000});
				return false;
			}
			return true;
		},
        error: function(XmlHttpRequest, textStatus, errorThrown){
			layer.msg('error!',{icon:1,time:1000});
			return false;
		}
	});	
}
</script> 
</html>