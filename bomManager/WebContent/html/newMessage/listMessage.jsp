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
	<div class="row ">
		<label class="col-md-12 text-c"><strong class="c-red f-24">消息浏览</strong></label>
	</div>
	<s:iterator value="#request.messageList" var="item" status="st" >
		<div class="row">
			<div class="formControls col-md-11 col-md-offset-1 ">	
			 <label>
				 <div class="text-l f-18 text-overflow col-md-9">
				 	<s:if test="#st.first"><span class="va-t c-red f-12">新!</span></s:if>
				 	<strong>
				 		<a onclick="messageShow('${item.title}','${item.id}')">${item.title }</a>
				 	</strong>
				 </div>
			 	<span class="text-r col-md-3">${item.updated}</span>
			 </label>
			</div>
		</div>
	</s:iterator>
	<form id="fenyeForm" " method="post" action="message-listMessage" target="_self">
		<center>
			<input type="hidden" name="pageBean.currentPage" id="currentPage">
	        <font size="4">当前第<font color="red"><s:property value="pageBean.currentPage"/></font>页</font>&nbsp;&nbsp;
	        <font size="4">共<font color="red"><s:property value="pageBean.totalPages"/></font>页 </font>
	        <s:if test="pageBean.currentPage == 1">
	            首页&nbsp;&nbsp;&nbsp;上一页
	        </s:if>
	        <s:else>
	            <a  href="javascript:void(0)" onclick="formSubmit(<s:property value="1"/>)">首页</a>
	            &nbsp;&nbsp;&nbsp;
	        	<a href="javascript:void(0)" onclick="formSubmit(<s:property value="pageBean.currentPage  - 1"/>)">上一页</a>
	        </s:else>
	        <s:if test="pageBean.currentPage != pageBean.totalPages && pageBean.totalPages != 0">
	        <a href="javascript:void(0)" onclick="formSubmit(<s:property value="pageBean.currentPage  + 1"/>)">下一页</a>
	            &nbsp;&nbsp;&nbsp;
	            <a href="javascript:void(0)" onclick="formSubmit(<s:property value="pageBean.totalPages"/>)">尾页</a>
	        </s:if>
	        <s:else>
	            下一页&nbsp;&nbsp;&nbsp;尾页
	        </s:else>
        </center>
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
/* 分页表单提交 */
	function formSubmit(currentPage){
		$("#currentPage").val(currentPage);
		$("#fenyeForm").submit();
	}
	function messageShow(title,url){
		layer_show(title,"message-showMessage.action?entity.id=" + url,800,600);
	}
</script> 
</html>