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
<!-- /_footer 作为公共模版分离出去 -->
<title>Insert title here</title>
</head>
	<body>
		<nav class="breadcrumb">
			<i class="Hui-iconfont">&#xe667;</i> 
			首页
			<span class="c-gray en">&gt;</span>
			物料库存记录管理
		</nav>
		<div class="page-container">
		<div class="text-c">
		<form class="Huiform" method="post" action="invlog-list" target="_self">
			<input type="text" class="input-text" style="width:250px" placeholder="输入料号（模糊）" id="" name="entity.partnumber">
			<input type="text" class="input-text" style="width:250px" placeholder="输入料号名称（模糊）" id="" name="entity.partName">
			<input type="text" class="input-text" style="width:250px" placeholder="供应商名称（模糊）" id="" name="entity.supplierName">
			<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜索库存信息</button>
		</form>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
		 <span class="r">共有数据：<strong>${request.sum}</strong> 条</span> 
		</div>
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th scope="col" colspan="18">库存记录列表</th>
				</tr>
				<tr class="text-c">
					<th width="150">料号</th>
					<th width="100">版本</th>
					<th width="100">供应商名称</th>
					<th width="150">名称</th>
					<th width="100">单位</th>
					<th width="100">数量</th>
					<th width="100">进出</th>
					<th width="100">单号</th>
					<th width="100">编辑人</th>
					<th width="100">时间</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#request.InvlogList">
					<tr class="text-c">
						<td>${partnumber}</td>
						<td>${partRev}</td>
						<td>${supplierName}</td>
						<td>${partName}</td>
						<td>${partUnit}</td>
						<td>${qty}</td>
						<td>${MIo}</td>
						<td>${orderNumber}</td>
						<td>${editor}</td>
						<td><s:date name="datetime" format="yyyy-MM-dd hh:mm:ss"/></td>
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
            <a href="inventory-list">首页</a>
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
		<form  id="fenyeForm" class="Huiform" method="post" action="invlog-list" target="_self">
		<s:hidden name="entity.partnumber"></s:hidden>
		<s:hidden name="entity.partName"></s:hidden>
		<s:hidden name="entity.supplierName"></s:hidden>
		<input type="hidden" name="pageBean.currentPage" id="currentPage">
		</form>

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="js/hui/jquery.dataTables.min.js"></script> 
	<script type="text/javascript" src="js/hui/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="js/jquery.form.js"></script>
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
	function material_add(title,url,w,h){
		layer_show(title,url,w,h);
	}
	/*管理员-删除*/
	function admin_del(obj,partnumber,partRev,supplierName){
		layer.confirm('确认要删除吗？',function(index){
			$.ajax({
				type: 'POST',
				url: 'supplier-delete',
				dataType: 'text',
				data:{
					'entity.id.partnumber':partnumber,
     				'entity.id.partRev':partRev,
     				'entity.id.supplierName':supplierName,
				},
				success: function(data){
					if (data == "1") {
						layer.msg('已删除!',{icon:1,time:1000});
						setTimeout(function(){
							location.reload();
						},1000);
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
	/* 分页表单提交 */
	function formSubmit(currentPage){
		$("#currentPage").val(currentPage);
		$("#fenyeForm").submit();
	}
	</script>
</body>
</html>