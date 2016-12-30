<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<div class="easyui-layout" fit="true">	
<div region="center" style="padding:1px;">
<t:datagrid name="tt_bysws" actionUrl="W_TemperaturedataController.do?datagrid" idField="tmpid" fit="flase" onLoadSuccess="bysws_load">
   <t:dgCol title="编号" field="tmpid" hidden="false"></t:dgCol>
   <t:dgCol title="设备名称" field="banhezhanminchen"></t:dgCol>
   <t:dgCol title="采集时间" field="tmpshijian"></t:dgCol>
   <t:dgCol title="温度(℃)" field="tmpdata"></t:dgCol>
   <t:dgCol title="温度标准范围(℃)20±2" field="wdfanwei" style="background:red;_异常"></t:dgCol>
   <t:dgCol title="湿度(%)" field="shidudata"></t:dgCol>
   <t:dgCol title="湿度标准范围(%)>=95" field="sdfanwei" style="background:red;_异常"></t:dgCol>
  </t:datagrid>
	<div id="tb_bysws" style="padding:5px">
	<table>
		<tr>
		  <td align="center">
		    <span>所属部门:</span>
		  </td>
		  <td>
		  	<input id="cc_bysws"  value="${depart.TSPDepart.departname}" style="width: 120px;">
			<input id="tspdepartId_bysws" name="TSPDepart.id" style="display: none;"
			value="${depart.TSPDepart.id}">
		  </td>
		  <td align="center">
		  	<span>设备名称:</span>
		  </td>
		  <td>
		  	<select id="shebeibianhao_bysws" name="shebeibianhao" style="height:22px;width:120px;">
			</select>
		  </td>
		  <td align="center">
		  	<span>时间:</span>
		  </td>
		  <td>
		  	<input id="startTime_bysws" type="text" name="startTimebysws" class="easyui-datebox" />
		  </td>
		  <td align="center">
		  	<span>至:</span>
		  </td>
		  <td>
		  	<input id="endTime_bysws" type="text" name="endTimebysws"  class="easyui-datebox"/>
		  </td>
		  <td>
		 	 <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="bysws_doSearch()">查询</a>
		 	 <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="bysws_dobaobiao()">导出</a>
		  </td>
		</tr>
	</table>
</div>
</div>   	
<div class="easyui-panel" title="温湿度曲线图" style="height:450px;" data-options="footer:'#ft'">
		<div id="bysws_charts" align='center'></div> 
</div>
</div>	

<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
<script type="text/javascript" src="plug-in/main/js/FusionCharts.js"></script>
<script type="text/javascript" src="plug-in/main/js/FusionChartsExportComponent.js"></script>
<script type="text/javascript">
	$(function() {
		 var date = new Date();
		 var y = date.getFullYear();
		 var m0 = date.getMonth() + 1;
		 var d = date.getDate();
		 var  end= y + '-' + (m0 < 10 ? ('0' + m0) : m0) + '-'
				+ (d < 10 ? ('0' + d) : d);
		 
		 date.setDate(date.getDate()-30); 
		 var y1= date.getFullYear();
		 var m1 = date.getMonth() + 1;
		 var d1 = date.getDate();
		 var begin = y1 + '-' + (m1 < 10 ? ('0' + m1) : m1) + '-'
				+ (d1 < 10 ? ('0' + d1) : d1);
		$("#startTime_bysws").val(begin);
		$("#endTime_bysws").val(end);  
	});

	$(function() {
		$('#cc_bysws').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
			onClick: function(node){
				$("#tspdepartId_bysws").val(node.id);
				banhezhanxinxiSelect(node.id,"shebeibianhao_bysws","5");
			}
		});
		banhezhanxinxiSelect("","shebeibianhao_bysws","5");
	});
	
	
	function bysws_doSearch() {
		$('#tt_bysws').datagrid('load', {
			pid : $("#tspdepartId_bysws").val(),
			startTime : $("input[name='startTimebysws']").val(),
			endTime : $("input[name='endTimebysws']").val(),
			shebeibianhao : $("#shebeibianhao_bysws").val()
		});
	};		
	function bysws_load(data) {
		var chart_htsjcxchart = new FusionCharts(
				'plug-in/main/FusionCharts/MSLine.swf',
			'bysws_charts', '1000', '400', '0', '0');
		chart_htsjcxchart.setDataXML(data.strXML);
		chart_htsjcxchart.render("bysws_charts");
 	}
	function bysws_dobaobiao(){
		var pid=$("#tspdepartId_bysws").val();
		var startTime = $("input[name='startTimebysws']").val();
		var endTime = $("input[name='endTimebysws']").val();
		var shebeibianhao = $("#shebeibianhao_bysws").val();
		var url = "W_TemperaturedataController.do?baobiao&pid="+pid+"&startTime="+startTime+"&endTime="+endTime+"&shebeibianhao="+shebeibianhao;
		window.location.href=url;
	}
</script>
