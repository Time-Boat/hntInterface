<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/context/mytags.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<t:base type="jquery,easyui,tools"></t:base>
	<script type="text/javascript" src="plug-in/main/js/FusionCharts.js"></script>
	<script type="text/javascript" src="plug-in/main/js/FusionChartsExportComponent.js"></script>
</head>

<body>	
<div class="easyui-layout" fit="true">

<div region="center" style="padding:1px;" >
	<div style="overflow-y:auto ;">
	<table id="tt" class="easyui-datagrid" style="width:1140px;height:120px"
		url="hntwuchaAnalyseController.do?datagridGetwucha" toolbar="#tb"
		title="材料误差分析" iconCls="icon-save"
		rownumbers="true" pagination="true">
		
	</table>
<div id="tb" style="float: left; padding-right: 15px;">
	<span>所属机构:</span>
		<input id="cc_hntwucha"  value="${depart.TSPDepart.departname}" style="width: 180px;">
		<input id="tspdepartId" name="TSPDepart.id" style="display: none;" value="${depart.TSPDepart.id}">
	<span>拌和机名称</span>
		<select id="hntwuchashebeibianhao" name="shebeibianhao" style="height:24px;width:120px;"></select>				
	<span>工程名称：</span>
	<input id="gongchengmingcheng" name="gongchengmingcheng" type="text" style=" width: 70px; line-height:18px;border:1px solid #ccc">	
	<span>浇筑部位：</span>
	<input id="jiaozuobuwei" name="jiaozuobuwei" type="text" style=" width: 70px; line-height:18px;border:1px solid #ccc">
	<span>出料时间:</span>
		<input id="startTimehntwucha"  type="text" name="startTimehntwucha" class="easyui-datetimebox" />
	<span>至:</span>
		<input id="endTimehntwucha" type="text" name="endTimehntwucha"  class="easyui-datetimebox"/>
	
	<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch();">查询</a>
    </div>
		</div>
			<div>
			<div id="hntchart" align='center'></div>	
			<div id="hntwuchachart" align='center'></div>
			</div>
			</div>
</div>
 <script type="text/javascript">
 $(function() {
	 var date = new Date();
	 var y = date.getFullYear();
	 var m0 = date.getMonth() + 1;
	 var d = date.getDate();
	 var begin = y + '-' + (m0 < 10 ? ('0' + m0) : m0) + '-'
			+ (d < 10 ? ('0' + d) : d);
	 
	 date.setDate(date.getDate()-30); 
	 var y1= date.getFullYear();
	 var m1 = date.getMonth() + 1;
	 var d1 = date.getDate();
	 var end = y1 + '-' + (m1 < 10 ? ('0' + m1) : m1) + '-'
			+ (d1 < 10 ? ('0' + d1) : d1);
		$("#startTimehntwucha").datetimebox('setValue',begin);
		$("#endTimehntwucha").datetimebox('setValue',end);  
	
	}); 

 $(function() {
		$('#cc_hntwucha').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
			onClick: function(node){
				$("#tspdepartId").val(node.id);
				banhezhanxinxiSelect(node.id,"hntwuchashebeibianhao","1");
			}
		});
		doSearch();
	});

 function lod(data) {
	 var chart_hntUserchart = new FusionCharts('plug-in/main/FusionCharts/MSLine.swf','hntUserImage', '1150', '250', '0', '0');		
	 chart_hntUserchart.setDataXML(data.hntUserXML);		
	 chart_hntUserchart.render("hntchart");
	 
	 var chart_hntWuchachart = new FusionCharts('plug-in/main/FusionCharts/MSLine.swf','hntWuchaImage', '1150', '250', '0', '0');		
	 chart_hntWuchachart.setDataXML(data.hntWuchaXML);		
	 chart_hntWuchachart.render("hntwuchachart");
 }
 
 	
 function doSearch() {
	 $('#tt').datagrid({
			url : 'hntwuchaAnalyseController.do?datagridGetwucha&tspdepartId='+$("#tspdepartId").val()+'&shebeibianhao='+$("#hntwuchashebeibianhao").val()+'&gongchengmingcheng='+$("#gongchengmingcheng").val()+'&jiaozuobuwei='+$("#jiaozuobuwei").val()+'&startTime='+$("input[name='startTimehntwucha']").val()+'&endTimewc='+$("input[name='endTimehntwucha']").val(),
			title : '',
			iconCls : '',
			fit : true,
			fitColumns : true,
			pagination : true,
			pageSize : 1,
			pageList : [ 10,20,30 ],
			nowarp : false,
			border : false,
			onClickRow : function(rowIndex, rowData) {
			},
			onLoadSuccess : function(data) {
			 	 var chart_hntUserchart = new FusionCharts('plug-in/main/FusionCharts/MSLine.swf','hntUserImage', '1150', '250', '0', '0');		
			 	 chart_hntUserchart.setDataXML(data.hntUserXML);		
			 	 chart_hntUserchart.render("hntchart");
				 
			 	 var chart_hntWuchachart = new FusionCharts('plug-in/main/FusionCharts/MSLine.swf','hntWuchaImage', '1150', '250', '0', '0');		
			 	 chart_hntWuchachart.setDataXML(data.hntWuchaXML);		
			 	 chart_hntWuchachart.render("hntwuchachart");
			},
			onLoadError : function(data) {
			}
		});
	};
	
 	
 	
</script>
<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>		
</body>