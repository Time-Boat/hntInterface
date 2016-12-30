<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="t_QPJJXSList" title="气泡间距系数" actionUrl="t_QPJJXSController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="ID" field="syjid" hidden="false"></t:dgCol>	
   <t:dgCol title="试验日期" field="syrq" width="200"></t:dgCol>
   <t:dgCol title="样本编号" field="ybbh" width="200"></t:dgCol>
   <t:dgCol title="试验编号" field="sybh" width="200"></t:dgCol>
   <t:dgCol title="试验人员" field="syry" width="200"></t:dgCol>
   <t:dgCol title="灰度阀值" field="hdfz" width="200"></t:dgCol>
   <t:dgToolBar title="查看" icon="icon-search" url="t_QPJJXSController.do?addorupdate" funname="detail" width="600" height="500"></t:dgToolBar>
   </t:datagrid>

	<div id="tb_qpjj" style="padding:5px">
	<table>
		<tr>
		  <td align="center">
		    <span>所属部门:</span>
		  </td>
		  <td>
		  	<input id="cc_qpjj"  value="${depart.TSPDepart.departname}" style="width:150px;">
			<input id="tspdepartId_qpjj" name="TSPDepart.id" style="display: none;"
			value="${depart.TSPDepart.id}">
		  </td>
		  <td align="center">
		  	<span>拌和机名称:</span>
		  </td>
		  <td>
		  	<select id="shebeibianhao_qpjj" name="shebeibianhao" style="height:22px;width:150px;">
			</select>
		  </td>
		  <td align="center">
		  	<span>时间:</span>
		  </td>
		  <td>
		  	<input id="startTime_qpjj" type="text" name="startTimeqpjj" class="easyui-datebox" />
		  </td>
		  <td align="center">
		  	<span>至:</span>
		  </td>
		  <td>
		  	<input id="endTime_qpjj" type="text" name="endTimeqpjj"  class="easyui-datebox"/>
		  </td>
		  <td>
		 	 <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="qpjj_doSearch()">查询</a>
		  </td>
		</tr>
		<tr>
			<td align="center">
				<span>样本编号:</span>
			</td>
			<td>
				<input type="text" id="ybbh_qpjj" />
			</td>
			<td align="center">
				<span>试验编号 :</span>
			</td>
			<td>
				<input type="text" id="sybh_qpjj" />
			</td>
		</tr>	
	</table>
	</div>

</div>   	
</div>	
 <script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
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
		$("#startTime_qpjj").val(begin);
		$("#endTime_qpjj").val(end);  
	});

	$(function() {
		$('#cc_qpjj').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
			onClick: function(node){
				$("#tspdepartId_qpjj").val(node.id);
				banhezhanxinxiSelect(node.id,"shebeibianhao_qpjj","1");
			}
		});
		banhezhanxinxiSelect("","shebeibianhao_qpjj","1");
	});
	
	function qpjj_doSearch() {
		$('#t_QPJJXSList').datagrid('load', {
			pid : $("#tspdepartId_qpjj").val(),
			startTime : $("input[name='startTimeqpjj']").val(),
			endTime : $("input[name='endTimeqpjj']").val(),
			shebeibianhao : $("#shebeibianhao_qpjj").val(),
			ybbh:$("#ybbh_qpjj").val(),
			sybh:$("#sybh_qpjj").val()
		});
	};
</script>