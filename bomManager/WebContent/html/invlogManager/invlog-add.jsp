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
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>料号：</label>
		<div class="formControls col-xs-8 col-sm-9">	
		<%-- <s:text name="#request.inventoryTrees"></s:text> --%>
			<span class="select-box">
				<select class="select"  name="entity.partnumber" id="partnumber">
	    			<option value="0">==请选择==</option>
	   		   </select>
			</span>
		</div>
	
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>版本：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<span class="select-box">
				<select class="select"  name="entity.partRev" id="partRev">
	    			<option value="0">==请选择==</option>
	   		   </select>
			</span>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>供应商名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<span class="select-box">
				<select class="select"  name="entity.supplierName" id="supplierName">
		    			<option value="">==请选择==</option>
		   		</select>
			</span>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<label class="form-label " id="partName" name="entity.partName"></label>
			<input type="hidden" class="input-text" id="partName" name="entity.partName" >
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>单位：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text"  placeholder="" id="partUnit" name="entity.partUnit" >
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>数量：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text"  placeholder="" id="qty" name="entity.qty" >
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>单号：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text"  placeholder="" id="orderNumber" name="entity.orderNumber"  >
		</div>
	</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;" onsubmit="return checkId()">
		</div>
	</div>
	<s:hidden value="entity.MIo"></s:hidden>
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
<script type="text/javascript">
$(function(){
	$("#form-user-add").validate({
		debug:true,
		rules:{
			'entity.partnumber':{
				required:true,
			},
			'entity.partRev':{
				required:true,
			},
			'entity.partName':{
				required:true,
			},
			'entity.supplierName':{
				required:true,
			},
			'entity.partUnit':{
				required:true,
			},
			'entity.qty':{
				required:true,
				digits:true,
			},
			
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type: 'post',
				url: "invlog-doAdd", 
				success: function(data){
					if(data == "1"){
						layer.msg('入库成功!',{icon:1,time:1000});
						setTimeout(function(){
							var index = parent.layer.getFrameIndex(window.name);
							parent.location.reload();
							parent.layer.close(index);
						},1000);
					}
					if(data == "0"){
						layer.msg('入库失败!',{icon:1,time:1000});
					}
				},
                error: function(XmlHttpRequest, textStatus, errorThrown){
					layer.msg('error!',{icon:1,time:1000}); 
				}
			});
			
		}
	
	});
});  
$(function(){
	//加载料号
	loadPartnumber();
});
var tree = eval('<s:text name="#request.inventoryTrees"></s:text>');
function loadPartnumber(){
	for(var i = 0 ; i < tree.length;i++){
		if(tree[i].pid == 0){
			$("#partnumber").append("<option value="+ tree[i].value +" selfId =" + tree[i].id + " partName="+ tree[i].name +">" + tree[i].value + tree[i].name  +"</option>")
		}
	}
}
//加载版本
$("#partnumber").change(function(){
	var partnumber_id = $("#partnumber").val();
	var selfId = $("#partnumber").find("option:selected").attr("selfId");
	//设置料号名称
	var partName = $("#partnumber").find("option:selected").attr("partName");
	// label 
	 $("#partName").text(partName);
	// input hidden
	 $("[name='entity.partName']").val(partName);
	//初始化 下拉框
	 $("#partRev option").remove();
	 $("#partRev").append("<option value=''>==请选择==</option>");
	
	for(var i = 0 ; i < tree.length;i++){
		if(tree[i].pid == selfId){
			$("#partRev").append("<option value="+ tree[i].value +" selfId =" + tree[i].id + ">"+ tree[i].name +"</option>")
		}
	}
});
//加载供应商
$("#partRev").change(function(){
	var partnumber_id = $("#partRev").val();
	var selfId = $("#partRev").find("option:selected").attr("selfId");
	 $("#supplierName option").remove();
	$("#supplierName").append("<option value=''>==请选择==</option>");
	for(var i = 0 ; i < tree.length;i++){
		if(tree[i].pid == selfId){
			$("#supplierName").append("<option value="+ tree[i].value +" selfId =" + tree[i].id + ">"+ tree[i].name +"</option>")
		}
	}
});
</script> 
</html>