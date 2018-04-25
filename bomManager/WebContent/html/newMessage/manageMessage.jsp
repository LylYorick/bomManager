<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/H-ui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hui/style.css" />
	<!-- _footer 作为公共模版分离出去 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/hui/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/hui/H-ui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/hui/H-ui.admin.js"></script>
	<!-- 日期选择器插件 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/4.8/WdatePicker.js"></script>
<title>Insert title here</title>
</head>
	<body>
		<nav class="breadcrumb">
			<i class="Hui-iconfont">&#xe667;</i> 
			首页
			<span class="c-gray en">&gt;</span>
			消息管理
		</nav>
		<div class="page-container">
		<div class="text-c">
		<form id="orderForm" class="Huiform" method="post" action="order-toReport"  atarget="_self" accept-charset="utf-8" >
			<table class="table table-border table-bordered radius">
			<tr>
			<td class="text-r"> 
				</span>消息标题：</label>
			</td> 
			<td>
				<input type="text" class="input-text"   id="" name="entity.title" value="${entity.title}">
			</td>
			<td class="text-r"> 
				</span>更新时间：</label>
			</td> 
			<td>
				<input type="text" class="input-text Wdate " style="width:120px;"  onclick="WdatePicker({isShowClear:false,readOnly:true})"  placeholder="" id="beginDate" name="beginDate" value="${beginDate}" >-
				<input type="text" class="input-text Wdate " style="width:120px;"  onclick="WdatePicker({isShowClear:false,readOnly:true})"  placeholder="" id="endDate" name="endDate" value="${endDate}" >
			</td>
			<td>
			<button type="button" class="btn btn-success radius" id="" name="" onclick="doSearch()"><i class="Hui-iconfont">&#xe665;</i>搜索</button>
			</td>
			</tr>
			</table>
		</form>
		</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20">
	 <span class="l">
	 	<a href="javascript:;" onclick="messageShow('添加消息')" class="btn btn-primary radius">
	 	<i class="Hui-iconfont">&#xe600;</i> 添加消息
	 	</a>
	 </span>
	 <span class="r">共有数据：<strong>${request.sum}</strong> 条</span> 
	 </div>
		<table class="table table-border table-bordered table-hover table-bg">
			<thead>
				<tr class="text-c">
					<th width="50">消息id</th>
					<th width="300">消息名称</th>
					<th width="50">创建时间</th>
					<th width="50">更新时间</th>
					<th width="50">操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#request.messageList" var="item">
					<tr class="text-c">
						<td>${item.id}</td>
						<td>${item.title}</td>
						<td>${item.created}</td>
						<td>${item.updated}</td>
						<td class="td-manage">
						<a title="修改" href="javascript:;" onclick="messageEdit('修改','${item.id}')" class="ml-5" style="text-decoration:none">
								 <i class="Hui-iconfont">&#xe6df;</i>修改
						</a>
						<a title="删除" href="javascript:;" onclick="message_del('${item.id}')" class="ml-5" style="text-decoration:none">
								 <i class="Hui-iconfont">&#xe6e2;</i>删除
						</a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<center>
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
	</div>
		<form  id="fenyeForm" class="Huiform" method="post" action="message-manageMessage" target="_self">
			<input type="hidden" name="pageBean.currentPage" id="currentPage">
			<s:hidden name="entity.title"></s:hidden>
			<s:hidden name="beginDate"></s:hidden>
			<s:hidden name="endDate"></s:hidden>
		</form>

</body>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="js/hui/jquery.dataTables.min.js"></script> 
	<script type="text/javascript" src="js/hui/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="js/jquery.form.js"></script>
	<script type="text/javascript">
		function formSubmit(currentPage){
			$("#currentPage").val(currentPage);
			$("#fenyeForm").submit();
		}
		function doSearch(){
			$("#orderForm").attr("action","message-manageMessage")
			$("#orderForm").submit();
		}
		function messageShow(title){
			layer_show(title,"message-addMessage",1000,600);
		}
		function messageEdit(title,url){
			layer_show(title,"message-addMessage?entity.id="+url,1000,600);
		}
		function message_del(id){
			layer.confirm('确认要删除吗？',function(){
				$.ajax({
					type:"post",
					url: 'message-deleteMessage',
					dataType: 'json',
					data:{
						'entity.id':id,
					},
					success: function(data){
						if(data.status == 200){
							layer.msg('删除成功!',{icon:1,time:1000});
							setTimeout(function(){
								location.reload();
							},1000);
						}else if(data.status == 500){
							layer.alert(data.msg, {icon: 2});
						}
					},
					error:function(data) {
						console.log(data.msg);
					},
				});		
			});
		}
	</script>
</html>