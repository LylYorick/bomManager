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
			bom结构查询
		</nav>
		<div class="page-container">
		<div class="text-c">
		<form id="bomForm" class="Huiform" method="get"  target="_self">
			<table class="table table-border table-bordered radius">
			<tr>
			<td> 
				<label>请选择顶阶产品：</label>
			</td> 
			<td>
				<span class="select-box">
					<select class="select"  name="entity.id.topPartnumber" id="topPartnumber">
	   		   			<s:iterator value="#request.topPartList">
	   		   				<option value="<s:property/>"><s:property/></option>
	   		   			</s:iterator>
		   		    </select>
				</span>
			</td>
			<td> 
				<label>材料料号：</label>
			</td> 
			<td>
				<input type="text" class="input-text" style="width:250px" placeholder="材料料号" id="" name="entity.id.partNumber" value="${entity.id.partNumber}">
			</td>
			<td> 
				<label>材料名称：</label>
			</td> 
			<td>
				<input type="text" class="input-text" style="width:250px" placeholder="材料名称" id="" name="entity.partName" value="${entity.partName}">
			</td>
			<td>
				<button type="button" class="btn btn-success radius" id="" name="" onclick="doSearch()"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
			</td>
			<td>
				<button type="button" class="btn btn-success radius" id="" name=""  onclick="doExportExcel()">导出订单信息</button>
			</td>
			</tr>
			</table>
		</form>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
		  <span class='r'>共:<strong id='totalSum'>0</strong>元</span>
		</div>
		<table class="table table-border table-bordered table-bg" id="bomTb">
		</table>
		<center>
	</div>
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
	function initBom(){
		var bomList = eval('<s:text name="#request.bomJson"></s:text>');
		if(bomList == null ||bomList == undefined ||  bomList.length == 0){
			return;
		}
		var minLevel = 100;
		var maxLevel = 0;
		minLevel = bomList[0].secq;
		for(var i = 0; i<bomList.length; i++){
			var bom = bomList[i];
			if(bom.secq > maxLevel){
				maxLevel = bom.secq;
			}
		}
		var tbsum = maxLevel - minLevel + 1;
		//创建表头
		var bomTb = $("#bomTb").empty();
		var bomstring="";
		bomstring +="<thead>";
		bomstring +="<tr> <th scope='col' colspan='18'>管理列表</th></tr>";
		
		bomstring +=" <tr class='text-c'>";
		for(var i = minLevel; i < maxLevel+1 ; i++){
			bomstring += "<th width='100'>第"+i+"级</th>";
		}
		bomstring += "<th width='100'>	图样代号</th>";
		bomstring += "<th width='100'>	材料/规格</th>";
		bomstring += "<th width='100'>	执行标准</th>";
		bomstring += "<th width='100'>	单台部件数量</th>";
		bomstring += "<th width='100'>	单台零件数量</th>";
		bomstring += "<th width='100'>	单价</th>";
		bomstring += "<th width='100'>	成本数量</th>";
		bomstring += "<th width='100'>  单台合计</th>";
		bomstring += "</tr></thead>";
		//创建文字部分
		bomstring +="<tbody>"; 
		var totalSum = 0;
		var sum = 0;
		for(var i = 0; i< bomList.length; i++){
			bomstring += "<tr class='text-c' id=>";
			var bom = bomList[i];
			for(var j = minLevel; j< maxLevel+1;j++){
				if(j == bom.secq){
					bomstring += "<td>"+bom.partName+ "</td>";
				}else{
					bomstring += "<td></td>";
				}
			}
			bomstring += "<td>"+bom.tuNumber+ "</td>";
			bomstring += "<td>"+bom.partSpec+ "</td>";
			bomstring += "<td>"+bom.partStandard+"</td>";
			if(bom.partModel =='零件'){
				bomstring += "<td></td>";
				bomstring += "<td>" + bom.useQty + "</td>";
			}else if(bom.partModel =='部件'){
				bomstring += "<td>" + bom.useQty + "</td>";
				bomstring += "<td></td>";
			}else{
				bomstring += "<td></td>";
				bomstring += "<td></td>";
			}
			bomstring += "<td>"+bom.partPrice+"</td>";
			bomstring += "<td>"+bom.partQty+"</td>";
			bomstring += "<td>"+bom.partSum+"</td>";
			totalSum += bom.partSum;
		}
		bomstring +="</tbody>";
		bomTb.append(bomstring); 
		$("#totalSum").text(totalSum);
	}
	initBom();
	//回显上一次查询时的顶阶料号
	function initSelect(){
		var options  = $("#topPartnumber").find("option");
		options.each(function (){
			if(this.value =='${entity.id.topPartnumber}'){
				this.selected = true;
			};
			
		})
	}
	initSelect();
	function doExportExcel(){
		$("#bomForm").attr("action","bom-doExport")
		$("#bomForm").submit();
	}
	function doSearch(){
		$("#bomForm").attr("action","bom-list")
		$("#bomForm").submit();
	}
	</script>
</body>
</html>