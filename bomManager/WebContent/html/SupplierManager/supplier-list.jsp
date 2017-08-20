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
			供应商管理
		</nav>
		<div class="page-container">
		<div class="text-c">
		<form class="Huiform" method="post" action="supplier-list" target="_self">
			<input type="text" class="input-text" style="width:250px" placeholder="输入料号" id="" name="entity.id.partnumber">
			<input type="text" class="input-text" style="width:250px" placeholder="输入料号名称" id="" name="entity.partName">
			<input type="text" class="input-text" style="width:250px" placeholder="供应商名称" id="" name="entity.id.supplierName">
			<input type="text" class="input-text" style="width:250px" placeholder="供应商代码" id="" name="entity.supplierCode">
			<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜索材料信息</button>
		</form>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
		 <span class="l">
		 	<a href="javascript:;" onclick="material_add('添加供应商','supplier-toAdd.action','600','600')" class="btn btn-primary radius">
		 	<i class="Hui-iconfont">&#xe600;</i> 添加
		 </a>
		 </span>
		 <span class="r">共有数据：<strong>${request.sum}</strong> 条</span> 
		</div>
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th scope="col" colspan="18">用户列表</th>
				</tr>
				<tr class="text-c">
					<th width="150">料号</th>
					<th width="150">名称</th>
					<th width="100">版本</th>
					<th width="100">供应商名称</th>
					<th width="100">供应商代码</th>
					<th width="100">材料规格</th>
					<th width="100">执行标准</th>
					<th width="100">单位</th>
					<th width="100">单价</th>
					<th width="100">是否有效</th>
					<th width="100">编辑人</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#request.SupplierList">
					<tr class="text-c">
						<td>${id.partnumber}</td>
						<td>${partName}</td>
						<td>${id.partRev}</td>
						<td>${id.supplierName}</td>
						<td>${supplierCode}</td>
						<td>${partSpec}</td>
						<td>${partStandard}</td>
						<td>${partUnit}</td>
						<td>${partPrice}</td>
						<td>${partActive}</td>
						<td>${editor}</td>
						<td class="td-manage">
							<a title="编辑" href="javascript:;" onclick="admin_edit('供应商修改','supplier-toEdit.action?entity.id.partnumber=${id.partnumber}&&entity.id.supplierName=${id.supplierName}&&entity.id.partRev=${id.partRev}','800','500')" class="ml-5" style="text-decoration:none">
								 <i class="Hui-iconfont">&#xe6df;</i>
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
            <a href="supplier-list">首页</a>
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
		<form  id="fenyeForm" class="Huiform" method="post" action="supplier-list" target="_self">
		<s:hidden name="entity.id.partnumber"></s:hidden>
		<s:hidden name="entity.partName"></s:hidden>
		<s:hidden name="entity.id.supplierName"></s:hidden>
		<s:hidden name="entity.supplierCode"></s:hidden>
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