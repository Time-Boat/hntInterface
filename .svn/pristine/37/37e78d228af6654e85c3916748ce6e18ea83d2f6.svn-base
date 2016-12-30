<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<t:base type="jquery,easyui,tools"></t:base>
<script type="text/javascript" src="plug-in/main/js/FusionCharts.js"></script>
<script type="text/javascript" src="plug-in/main/js/FusionChartsExportComponent.js"></script>
<script type="text/javascript">
 $(function() {
		var date = new Date();
		var y = date.getFullYear();
		var m0 = date.getMonth();
		var m1 = date.getMonth() + 1;
		var d = date.getDate();
		var h = date.getHours();
		var f = date.getMinutes();
		var s = date.getSeconds();
		var begin = y + '-' + (m0 < 10 ? ('0' + m0) : m0) + '-'
				+ (d < 10 ? ('0' + d) : d) + ' ' +(h < 10?('0' + h):h) +':'+(f < 10?('0' + f):f) +':'+(s < 10?('0' + s):s);
		var end = y + '-' + (m1 < 10 ? ('0' + m1) : m1) + '-'
				+ (d < 10 ? ('0' + d) : d) + ' ' +(h < 10?('0' + h):h) +':'+(f < 10?('0' + f):f) +':'+(s < 10?('0' + s):s);
		$("#startTimehntview").datetimebox('setValue',begin);
		$("#endTimehntview").datetimebox('setValue',end);
	
	}); 

 $(function() {
		$('#cc_hntvhunnintuViewList').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=2',
			onClick: function(node){
				$("#hunnintuViewListtspdepartId").val(node.id);
				lqbanhezhanxinxiSelect(node.id,"hunnintuViewlistshebeibianhao",'2');
			}
		});
		lqbanhezhanxinxiSelect("","hunnintuViewlistshebeibianhao",'2');
	});

 function lod(data) {
	 var chart_htsjcxchart = new FusionCharts(
				'plug-in/main/FusionCharts/MSLine.swf',
			'hntcnfxchart', '1150', '220', '0', '0');
		
		chart_htsjcxchart.setDataXML(data.strXML);
		
		chart_htsjcxchart.render("htsjcxchartDiv");
 }
 
 	
 function doSearch() {
	 $('#chuliaokouTemperaturedataViewList').datagrid('load', {
		 	
			startTime : $("input[name='startTimehntview']").val(),
			endTime : $("input[name='endTimehntview']").val(),
			pid : $("#hunnintuViewListtspdepartId").val(),
			shebeibianhao:$("#hunnintuViewlistshebeibianhao").val()
		});		
	};
 		
</script>
<script type="text/javascript" src="js/liqing.js" charset="UTF-8"></script>	

</head>

<body>

<div class="easyui-layout" fit="true">

<div region="center" style="padding:1px;" >
 <t:datagrid name="chuliaokouTemperaturedataViewList" title="出料口温度" 

actionUrl="chuliaokouTemperaturedataViewController.do?datagrid" idField="id" fit="true" queryMode="true" onLoadSuccess="lod" fitColumns="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   
   <t:dgCol title="tmpno" field="tmpno" hidden="false"></t:dgCol>
    <t:dgCol title="设备名称" field="banhezhanminchen" ></t:dgCol>
    <t:dgCol title="采集时间" field="tmpshijian" ></t:dgCol>
    <t:dgCol title="温度(°C)" field="tmpdata" ></t:dgCol>
  </t:datagrid>
<div id="tbsj" style="padding:5px">
	
		<div>
		<span>所属机构:</span>
			<input id="cc_hntvhunnintuViewList"  value="${depart.TSPDepart.departname}" style="width: 160px;">
			<input id="hunnintuViewListtspdepartId" name="TSPDepart.id" style="display: none;" value="${depart.TSPDepart.id}">
		<span>拌和机名称</span>
			<select id="hunnintuViewlistshebeibianhao" name="shebeibianhao" style="height:24px;width:120px;"></select>				
		<span>保存时间:</span>
			<input id="startTimehntview"  type="text" name="startTimehntview" class="easyui-datetimebox" />
		<span>至:</span>
			<input id="endTimehntview" type="text" name="endTimehntview"  class="easyui-datetimebox"/>
	
		<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch();">查询</a>
		</div>
   
</div>
<div class="easyui-accordion">
<div title="" selected style="padding:10px;"></div>
<div title="出料口温度走势图(请点击该行以便显示走势图)" iconCls="icon-ok" selected="true" style="padding:10px;">
<div id="htsjcxchartDiv" align='center'></div> 
</div>
</div>
</div> 
	
</body>
</html>