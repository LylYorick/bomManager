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
			订单管理
		</nav>
		<div class="page-container">
		<div class="text-c">
		<form id="orderForm" class="Huiform" method="get" action="order-toReport"  target="_self">
			
			<table class="table table-border table-bordered radius">
			<tr>
			<td> 
				</span>订单状态：</label>
			</td> 
			<td>
				<span class="select-box">
					<select class="select"  name="entity.orderStatus" id="orderStatus">
		    			<option value="">==请选择==</option>
		    			<option value="待审核" <s:if test="entity.orderStatus.equals('待审核')">selected</s:if> >待审核</option>
		    			<option value="已审核"  <s:if test="entity.orderStatus.equals('已审核')">selected</s:if>>已审核</option>
		    			<option value="已确认" <s:if test="entity.orderStatus.equals('已确认')">selected</s:if>>已确认</option>
		    			<option value="已完成"  <s:if test="entity.orderStatus.equals('已完成')">selected</s:if>>已完成</option>
		   		   </select>
				</span>
			</td>
			<td> 
				</span>订单类型：</label>
			</td> 
			<td>
				<span class="select-box">
					<select class="select"  name="entity.orderMode" id="orderMode" >
		    			<option value="">==请选择==</option>
		    			<option value="机加定制" <s:if test="entity.orderMode.equals('机加定制')">selected</s:if> >机加定制</option>
		    			<option value="PCB定制"  <s:if test="entity.orderMode.equals('PCB定制')">selected</s:if>>PCB定制</option>
		    			<option value="定制采购" <s:if test="entity.orderMode.equals('定制采购')">selected</s:if>>定制采购</option>
		    			<option value="系统定制" <s:if test="entity.orderMode.equals('系统定制')">selected</s:if>>系统定制</option>
		    			<option value="个性定制" <s:if test="entity.orderMode.equals('个性定制')">selected</s:if>>个性定制</option>
		   		   </select>
				</span>
			</td>
			<td> 
				</span>结算方式：</label>
			</td> 
			<td>
				<%-- <span class="select-box">
					<select class="select"  name="entity.id.partRev" id="partRev">
		    			<option value="0">==请选择==</option>
		   		   </select>
				</span> --%>
				<input type="text" class="input-text"   id="" name="entity.payWay" value="${entity.payWay}">
			</td>
			<td> 
				</span>是否结算：</label>
			</td> 
			<td>
				<span class="select-box">
					<select class="select"  name="entity.paid" id="paid">
		    			<option value="">==请选择==</option>
		    			<option value="Y" <s:if test="entity.paid.equals('Y'.toString())">selected</s:if>>是</option>
		    			<option value="N" <s:if test="entity.paid.equals('N'.toString())">selected</s:if>>否</option>
		   		   </select>
				</span>
			</td>
			<td>
			<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i>搜索订单信息</button>
			</td>
			</tr>
			<tr>
			<td> 
				</span>是否发货：</label>
			</td> 
			<td>
				<span class="select-box">
					<select class="select"  name="entity.delivered" id="delivered">
						<option value="">==请选择==</option>
		    			<option value="Y" <s:if test="entity.delivered.equals('Y'.toString())">selected</s:if>>是</option>
		    			<option value="N" <s:if test="entity.delivered.equals('N'.toString())">selected</s:if>>否</option>
		   		   </select>
				</span>
			</td>
			<td> 
				</span>下单时间：</label>
			</td> 
			<td>
				<span class="select-box">
					<select class="select"  name="orderTime" id="orderTime">
		    			<option value="">==请选择==</option>
		    			<option value="1" <s:if test="orderTime.equals('1'.toString())">selected</s:if>>最近一周</option>
		    			<option value="2" <s:if test="orderTime.equals('2'.toString())">selected</s:if>>最近一个月</option>
		    			<option value="3" <s:if test="orderTime.equals('3'.toString())">selected</s:if>>最近一年</option>
		   		   </select>
				</span>
			</td>
			<td>
			</td>
			<td>
			</td>
			<td>
			</td>
			<td>
			</td>
			<td>
				<button type="button" class="btn btn-success radius" id="" name=""  onclick="doExportExcel()"><i class="Hui-iconfont">&#xe665;</i> 导出订单信息</button>
			</td>
			</tr>
			</table>
		</form>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
		 <span class="r">共有数据：<strong>${request.sum}</strong> 条</span> 
		</div>
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th scope="col" colspan="18">管理列表</th>
				</tr>
				<tr class="text-c">
					<th width="150">订单编号</th>
					<th width="100">订单分类</th>
					<th width="100">名称</th>
					<th width="100">类型</th>
					<th width="100">数量</th>
					<th width="100">材料</th>
					<th width="100">描述</th>
					<th width="100">需求日期</th>
					<th width="100">联系人</th>
					<th width="100">联系电话</th>
					<th width="100">联系地址</th>
					<th width="100">报价</th>
					<th width="100">订单状态</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#request.OrderList">
					<tr class="text-c">
						<td>${orderNumber}</td>
						<td>${orderMode}</td>
						<td>${orderName}</td>
						<td>${orderType}</td>
						<td>${orderQty}</td>
						<td>${orderMaterial}</td>
						<td>${orderDesc}</td> 
						<td><s:date name="reqDate" format="yyyy-MM-dd hh:mm:ss"/></td>
						<td>${contact}</td>
						<td>${cellPhone}</td>
						<td>${address}</td>
						<td>${orderPrice}</td>
						<td>${orderStatus}</td>
						<td class="td-manage">
						<a title="详情" href="javascript:;" onclick="admin_detail('详情','order-toDetai.action?entity.orderNumber=${orderNumber}','800','500')" class="ml-5" style="text-decoration:none">
								 <i class="Hui-iconfont">&#xe715;</i>
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
		<form  id="fenyeForm" class="Huiform" method="post" action="order-toReport" target="_self">
			<input type="hidden" name="pageBean.currentPage" id="currentPage">
			<s:hidden name="entity.orderStatus"></s:hidden>
			<s:hidden name="entity.orderModel"></s:hidden>
			<s:hidden name="entity.paid"></s:hidden>
			<s:hidden name="entity.payWay"></s:hidden>
			<s:hidden name="entity.delivered"></s:hidden>
			<s:hidden name="orderTime"></s:hidden>
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
	function admin_detail(title,url,w,h){
		layer_show(title,url,w,h);
	}
	/* 分页表单提交 */
	function formSubmit(currentPage){
		$("#currentPage").val(currentPage);
		$("#fenyeForm").submit();
	}
	function doExportExcel(obj,id){
		$("#orderForm").ajaxSubmit({
			url:'order-doExport',
			success: function(data){
				console.log(data);
			}
		});
		
	}
	</script>
</body>
</html>