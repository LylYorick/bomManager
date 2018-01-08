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
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>名称：</label>
		<div class="formControls col-xs-4 col-sm-3">	
			<input type="text" class="input-text"  placeholder="" id="orderName" name="entity.orderName" >
		    
		</div>
		<div class="formControls col-xs-4 col-sm-3"> <span class="c-red">输入名称或项目名称</span></div>
	</div>
			
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>类型：</label>
		<div class="form-label col-xs-4 col-sm-3">
		 	<select class="multiSelect"   name="entity.orderType" id="orderType">
   		   			<option value="方案设计">方案设计</option>
   		   			<option value="3D模型">3D模型</option>
   		   			<option value="二维图设计">二维图设计</option>
   		   			<option value="模压模具设计">模压模具设计</option>
   		   			<option value="工装设计">工装设计</option>
	   		  </select>
		</div>
		<div class="formControls col-xs-4 col-sm-3"> <span class="c-red">输入所属类型</span></div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>材料：</label>
		<div class="form-label col-xs-4 col-sm-3">
			<input type="text" class="input-text"   placeholder="" id="orderMaterial" name="entity.orderMaterial" >
		</div>
		<div class="formControls col-xs-4 col-sm-3"> <span class="c-red">输入定制所需材料</span></div>
	</div>
	<div class="row cl">
	  <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>描述：</label>
		<div class="form-label col-xs-4 col-sm-7">
			<input type="text" class="input-text" placeholder="" id="orderDesc" name="entity.orderDesc">
		</div>
		<div class="formControls col-xs-4 col-sm-2"> <span class="c-red">输入其他具体要求</span></div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>需求日期：</label>
		<div class="form-label col-xs-4 col-sm-3">
			<input type="text" class="input-text Wdate"    onclick="WdatePicker({isShowClear:false,readOnly:true})"  placeholder="" id="reqDate" name="entity.reqDate"  >
		</div>
		<div class="formControls col-xs-4 col-sm-3"> <span class="c-red">输入希望交货日期</span></div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>数量：</label>
		<div class="formControls col-xs-8 col-sm-2">
			<input type="text"  class="input-text"   placeholder="" id="orderQty" name="entity.orderQty" >
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系人：</label>
		<div class="formControls col-xs-8 col-sm-9">
				<label class="text-l" >${currentUser.u_Name}</label>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系电话：</label>
		<div class="formControls col-xs-8 col-sm-3">
			<input type="text" class="input-text"  placeholder="" id="cellPhone" name="entity.cellPhone" value="${currentUser.u_Phone}">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系地址：</label>
		<div class="formControls col-xs-12 col-sm-9">
			<input type="text" class="input-text "  placeholder="" id="address" name="entity.address" value="${currentUser.u_Address}">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">附件上传：</label>
		<div class="formControls col-xs-8 col-sm-9">
		 <span class="btn-upload form-group" style="width:400px" id="uploadSpan" >
			<a href="javascript:void();" class="btn btn-primary radius upload-btn"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
				<input class="input-text upload-url" type="text"  id="" readonly nullmsg="请添加附件！" style="width:200px">
				<input type="file"  name="img" class="input-file">
			</span> 
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validation/1.14.0/messages_zh.js"></script> 

<!--引入select2插件 -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/select2/select2.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/select2/select2.js"></script>
<script type="text/javascript">
$(function(){
	validateInit();
	select2Init();
});  
function select2Init(){
	$(".multiSelect").select2({ 
		  width: "160px",
		  placeholder:"请选择",
		  allowClear:true,
		  tags: true,
	});
}
function validateInit(){
	$("#form-order-add").validate({
		debug:true,
		errorPlacement: function(error, element) {
			var name = element.attr( "name" );
			if(name == "img" ){
				$("#uploadSpan").before(error);
			}
		},
		rules:{
			'entity.orderName':{
				required:true,
			},
			'entity.orderType':{
				required:true,
			},
			'entity.orderQty':{
				required:true,
				minNumber:true,
				isFloatGteZero:true,
			},
			'entity.orderMaterial':{
				required:true,
			},
			'entity.reqDate':{
				required:true,
				isFuturer:true,
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
				checkPicSize:true,
			}
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type: 'post',
				url: "order-doAdd", 
				data:{"entity.orderMode":"个性定制"},
				success: function(data){
					//alert(data);
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
} 

</script> 
</html>