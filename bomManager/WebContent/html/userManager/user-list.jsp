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
<title>Insert title here</title>
</head>
	<body>
		<nav class="breadcrumb">
			<i class="Hui-iconfont">&#xe667;</i> 
			首页
			<span class="c-gray en">&gt;</span>
			用户管理 
		</nav>
		<div class="page-container">
		<div class="cl pd-5 bg-1 bk-gray mt-20">
		 <span class="l">
		 	<a href="javascript:;" onclick="admin_add('添加用户','user-toAdd.action','500','500')" class="btn btn-primary radius">
		 	<i class="Hui-iconfont">&#xe600;</i> 添加用户
		 </a>
		 </span>
		 <span class="r">共有数据：<strong>${request.sum}</strong> 条</span> 
		</div>
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th scope="col" colspan="12">用户列表</th>
				</tr>
				<tr class="text-c">
					<th width="150">用户编码</th>
					<th width="150">用户名</th>
					<th width="130">联系方式</th>
					<th width="100">用户职称</th>
					<th width="100">公司名称</th>
					<th width="100">联系地址</th>
					<s:if test="#session.currentUser.u_Level > 3">
						<th width="100">用户等级</th>
					</s:if>
					<th width="100">建立日期</th>
					<th width="100">编辑人</th>
					<th width="100">编辑时间</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#request.userList">
					<tr class="text-c">
						<td>${u_Number}</td>
						<td>${u_Name}</td>
						<td>${u_Phone}</td>
						<td>${u_Title}</td>
						<td>${u_Comany}</td>
						<td>${u_Address}</td>
						<s:if test="#session.currentUser.u_Level > 3">
							<td>${u_Level}</td>
						</s:if>
						<td><s:date name="u_CreateDate" format="yyyy-MM-dd hh:mm:ss"/></td>
						<td>${editor}</td>
						<td><s:date name="datetime" format="yyyy-MM-dd hh:mm:ss"/></td>
						<td class="td-manage">
							<a title="编辑" href="javascript:;" onclick="admin_edit('管理员编辑','user-toEdit.action?u_Number=${u_Number}','800','500')" class="ml-5" style="text-decoration:none">
								 <i class="Hui-iconfont">&#xe6df;</i>
							</a>
							<s:if test="#session.currentUser.u_Level > 1 && !#session.currentUser.u_Number.equals(u_Number)">
							<a title="删除" href="javascript:;" onclick="admin_del(this,${u_Number})" class="ml-5" style="text-decoration:none">
							 	<i class="Hui-iconfont">&#xe6e2;</i>
							</a>
							</s:if>
							<a title="重置密码" href="javascript:;" onclick="admin_reset(this,'${u_Number}')" class="ml-5" style="text-decoration:none">
								 <i class="Hui-iconfont">&#xe6f7;</i>
							</a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="js/hui/jquery.dataTables.min.js"></script> 
	<script type="text/javascript" src="js/hui/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">
	/*
		参数解释：
		title	标题
		url		请求的url
		id		需要操作的数据id
		w		弹出层宽度（缺省调默认值）
		h		弹出层高度（缺省调默认值）
	*/
	/*管理员-增加*/
	function admin_add(title,url,w,h){
		layer_show(title,url,w,h);
	}
	/*管理员-删除*/
	function admin_del(obj,id){
	
		layer.confirm('确认要删除吗？',function(index){
			$.ajax({
				type: 'POST',
				url: 'user-delete?u_Number='+id,
				dataType: 'text',
				success: function(data){
					if (data == "1") {
						layer.msg('已删除!',{icon:1,time:1000});
						setTimeout(function(){
							location.reload();
						},1000);
					}else if(data == "0"){
						layer.msg('删除失败!',{icon:5,time:2000});
					}
				},
				error:function(data) {
					console.log(data.msg);
				},
			});		
		});
	}
	
	/*管理员-编辑*/
	function admin_edit(title,url,id,w,h){
		layer_show(title,url,w,h);
	}
	/*管理员-删除*/
	function admin_reset(obj,id){
	
		layer.confirm('确认要重置密码吗？',function(index){
			$.ajax({
				type: 'POST',
				url: 'user-doReset?u_Number='+id,
				dataType: 'text',
				success: function(data){
					if (data == "1") {
						layer.msg('已重置密码为123456!',{icon:1,time:1000});
						setTimeout(function(){
							location.reload();
						},1000);
					}else if(data == "0"){
						layer.msg('重置失败!',{icon:5,time:2000});
					}
				},
				error:function(data) {
					console.log(data.msg);
				},
			});		
		});
	}
	</script>
</body>
</html>