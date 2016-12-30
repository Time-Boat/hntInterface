<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/context/mytags.jsp"%>

<script type="text/javascript" src="plug-in/main/js/FusionCharts.js"></script>
<script type="text/javascript" src="plug-in/main/js/FusionChartsExportComponent.js"></script>

<table>
	<tr>
		<td>所属部门:</td>
		<td><input id="cc_material" value="${depart.TSPDepart.departname}"
					style="width: 180px;"> <input id="tspdepartId_material"
					name="TSPDepart.id" style="display: none;"
					value="${depart.TSPDepart.id}">
		</td>
		<td>拌和机名称:</td>
		<td><select id="shebeibianhao_material" name="shebeibianhao"
			style="height: 22px; width: 140px;">
			</select>
		</td>
		<td>工程名称:</td>
		<td><input id="gongchengmingcheng_material" type="text"
			name="gongchengmingcheng" style="height: 18px; width: 120px;" /></td>
		<td>浇注部位:</td>
		<td><input id="jiaozuobuwei_material" type="text" name="jiaozuobuwei" style="height: 18px; width: 120px;" /></td>
		<td>砼等级:</td>
		<td><input id="qiangdudengji_material" type="text" name="qiangdudengji" style="height: 18px; width: 120px;" />
		</td>
	</tr>
	<tr>
		<td>出料时间:</td>
		<td><input id="startTime_material" type="text" name="startTimematerial"
			class="easyui-datetimebox" /> 至:<input id="endTime_material" type="text"
			name="endTimematerial" class="easyui-datetimebox" />
		</td>
		<td><a href="#" class="easyui-linkbutton" iconCls="icon-search"
			onclick="material_doSearch()">查询</a></td>
		<td>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="courseListExportXls()">导出Excel</a>
		</td>
	</tr>
</table>

		<div>
			<hr style="text-align: left; width: 1164px; background-color: #E0E0E0; height: 2px" />
		</div>
		<div id='hntmaterialchartDiv' align='center'></div>

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
	 
	 
 	/* $("#startTime").datebox("setValue",begin);
 	$("#endTime").datebox("setValue",end); */
 	$("#startTime_material").val(begin);
 	$("#endTime_material").val(end);  
});

function courseListExportXls(){		  
	var startTime = $("input[name='startTimematerial']").val();
	var endTime = $("input[name='endTimematerial']").val();
	var gongchengmingcheng = $("#gongchengmingcheng_material").val();
	var jiaozuobuwei = $("#jiaozuobuwei_material").val();
	var qiangdudengji = $("#qiangdudengji_material").val();
	var pid = $("#tspdepartId_material").val();
	var shebeibianhao = $("#shebeibianhao_material").val();
	var url = "MaterialController.do?datagrid&type=exportData&shebeibianhao="+shebeibianhao+"&pid="+pid+"&qiangdudengji="+qiangdudengji+"&jiaozuobuwei="+jiaozuobuwei+"&gongchengmingcheng="+gongchengmingcheng+"&startTime="+startTime+"&endTime="+endTime;
	window.open(url);
	/*
	$.post(
		url,
		{}
	);
	*/
}

</script>
<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
<script type="text/javascript">	
$(function() {
	$('#cc_material').combotree({
		url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
		onClick: function(node){
			$("#tspdepartId_material").val(node.id);
			banhezhanxinxiSelect(node.id,"shebeibianhao_material","1");
		}
	});
	banhezhanxinxiSelect("","shebeibianhao_material","1");
});

 /* $(function() {
	doSearch();
}); */ 

	function material_doSearch() {
		var depart=$("#tspdepartId_material").val();
		if(depart==null || depart.length==0){
			alert("请选择部门查询");
		}else{
			$.ajax({
			type : "POST",
			url : "MaterialController.do?datagrid",
			data : {
				startTime : $("input[name='startTimematerial']").val(),
				endTime : $("input[name='endTimematerial']").val(),
				gongchengmingcheng : $("#gongchengmingcheng_material").val(),
				jiaozuobuwei : $("#jiaozuobuwei_material").val(),
				qiangdudengji : $("#qiangdudengji_material").val(),
				pid : $("#tspdepartId_material").val(),
				shebeibianhao : $("#shebeibianhao_material").val(),
				type : "findData"
			},
			success : function(data) {
				var chart_hntmaterialchart = new FusionCharts(
						'plug-in/main/FusionCharts/MSCombiDY2D.swf',
						'hntcnfxchart', '1000', '380', '0', '0');
				// Provide entire XML data using dataXML method
				chart_hntmaterialchart.setDataXML(data.strXML);
				// Finally, render the chart.
				chart_hntmaterialchart.render("hntmaterialchartDiv");
			}
		});
		}
	}
</script>


