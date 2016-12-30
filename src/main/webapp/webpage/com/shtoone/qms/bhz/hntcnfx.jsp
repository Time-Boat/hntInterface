<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/context/mytags.jsp"%>

<script type="text/javascript" src="plug-in/main/js/FusionCharts.js"></script>
<script type="text/javascript" src="plug-in/main/js/FusionChartsExportComponent.js"></script>

<div class="easyui-layout" fit="true">
	<div region="center" style="padding: 5px;">
	
		
		<table>
			<tr>
				<td>所属部门:</td>
				<td><input id="cc_cnfx" value="${depart.TSPDepart.departname}"
					style="width: 120px;"> <input id="tspdepartId_cnfx"
					name="TSPDepart.id" style="display: none;"
					value="${depart.TSPDepart.id}"></td>
				<td>拌和机名称:</td>
				<td><select id="shebeibianhao_cnfx" name="shebeibianhao"
					style="height: 22px; width: 120px;">
				</select></td>
				<td>出料时间:</td>
				<td><input id="startTime_cnfx" type="text" name="startTimecnfx"
					class="easyui-datebox" /> 至: <input id="endTime_cnfx" type="text"
					name="endTimecnfx" class="easyui-datebox" /></td>
				<td>查询类型:</td>
				<td><input class="easyui-validatebox" type="radio"
					name="identity" value="1" />季度 <input class="easyui-validatebox"
					type="radio" name="identity" value="2" checked="checked" />月 <input
					class="easyui-validatebox" type="radio" name="identity" value="3" />周
					<a href="#" class="easyui-linkbutton" iconCls="icon-search"
					onclick="cnfx_doSearch()">查询</a>
					
					</td>
				<td>
					<a href="#" class="easyui-linkbutton" iconCls="icon-search"
					onclick="cnfx_daochu();">导出</a>
				</td>
			</tr>
			
		</table>
	
		<div>
			<hr style="text-align: left; width: 1150px; background-color: #E0E0E0; height: 2px" />
		</div>

		<div id='hntcnfxchartDiv' align='center'></div>

<script type='text/javascript'>
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
	 
	 
    $("#startTime_cnfx").val(begin);
 	$("#endTime_cnfx").val(end); 
});
</script>

<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
<script type="text/javascript">
$(function() {
	$('#cc_cnfx').combotree({
		url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
		onClick: function(node){
			$("#tspdepartId_cnfx").val(node.id);
			banhezhanxinxiSelect(node.id,"shebeibianhao_cnfx","1");
		}
	});
	banhezhanxinxiSelect("","shebeibianhao_cnfx","1");
});

/* $(function() {
	doSearch();
}); */

	function cnfx_doSearch() {
		var depart=$("#tspdepartId_cnfx").val();
		if(depart==null || depart.length==0){
			alert("请选择部门查询");
		}else{
			$.ajax({
			type : "POST",
			url : "HntcnfxController.do?datagrid",
			data : {
				startTime : $("input[name='startTimecnfx']").val(),
				endTime : $("input[name='endTimecnfx']").val(),
				cxlx : $("input[name='identity']:checked").val(),
				pid : $("#tspdepartId_cnfx").val(),
				shebeibianhao : $("#shebeibianhao_cnfx").val()
			},
			success : function(data) {
				var chart_hntcnfxchart = new FusionCharts(
						'plug-in/main/FusionCharts/MSCombiDY2D.swf',
						'hntcnfxchart', '1000', '380', '0', '0');
				// Provide entire XML data using dataXML method
				chart_hntcnfxchart.setDataXML(data.strXML);
				// Finally, render the chart.
				chart_hntcnfxchart.render("hntcnfxchartDiv");
			}
		});
		} 
	}
	
function cnfx_daochu() {
	var depart=$("#tspdepartId_cnfx").val();
	var startTime = $("input[name='startTimecnfx']").val();
	var endTime = $("input[name='endTimecnfx']").val();
	var cxlx = $("input[name='identity']:checked").val();
	var pid = $("#tspdepartId_cnfx").val();
	var shebeibianhao = $("#shebeibianhao_cnfx").val();
	var url = "HntcnfxController.do?cnfxexportXls&depart="+depart+"&startTime="+startTime+"&endTime="+endTime+"&cxlx="+cxlx+"&pid="+pid+"&shebeibianhao="+shebeibianhao;
	if(depart==null || depart.length==0){
		alert("请选择部门查询");
	}else{	
		window.open(url);

		}
	}
</script>

</div>
</div>


