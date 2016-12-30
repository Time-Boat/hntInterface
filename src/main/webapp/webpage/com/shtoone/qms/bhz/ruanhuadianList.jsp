<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<div class="easyui-layout" fit="true">
<div region="center" style="padding:1px;">
<t:datagrid name="tt_rhd" actionUrl="W_rhd_zrd.do?rhddatagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="设备名称" field="banhezhanminchen"></t:dgCol>
   <t:dgCol title="试验时间" field="TIME"></t:dgCol>
   <t:dgCol title="工程名称" field="ProjectName"></t:dgCol>
   <t:dgCol title="样品编号" field="SampleNo"></t:dgCol>
   <t:dgCol title="工程部位" field="GCBuWei"></t:dgCol>
   <t:dgCol title="样品名称" field="SampleName"></t:dgCol>
   <t:dgCol title="样品描述" field="SampleMS"></t:dgCol>
   <t:dgCol title="软化点(℃)单值1" field="ruanhuadian1"></t:dgCol>
   <t:dgCol title="软化点(℃)单值2" field="ruanhuadian2"></t:dgCol>
   <t:dgCol title="标准值" field="biaozhunzhi1"></t:dgCol>
   <t:dgCol title="平均值" field="RHDAvg"></t:dgCol>
   <t:dgCol title="是否合格" field="isQualified"></t:dgCol>
  </t:datagrid>

	<div id="tb_rhd" style="padding:5px">
	<table>
		<tr>
		  <td align="center">
		    <span>所属部门:</span>
		  </td>
		  <td>
		  	<input id="cc_rhd"  value="${depart.TSPDepart.departname}" style="width: 120px;">
			<input id="tspdepartId_rhd" name="TSPDepart.id" style="display: none;"
			value="${depart.TSPDepart.id}">
		  </td>
		  <td align="center">
		  	<span>拌和机名称:</span>
		  </td>
		  <td>
		  	<select id="shebeibianhao_rhd" name="shebeibianhao" style="height:22px;width:120px;">
			</select>
		  </td>
		  <td align="center">
		  	<span>时间:</span>
		  </td>
		  <td>
		  	<input id="startTime_rhd" type="text" name="startTimerhd" class="easyui-datebox" />
		  </td>
		  <td align="center">
		  	<span>至:</span>
		  </td>
		  <td>
		  	<input id="endTime_rhd" type="text" name="endTimerhd"  class="easyui-datebox"/>
		  </td>
		  <td align="center">
		  	<span>是否合格:</span>
			<input class="easyui-validatebox" type="radio"  name="identity_zrd" value="0" checked="checked" />全部
   			<input class="easyui-validatebox" type="radio"  name="identity_zrd" value="1" />合格	
   			<input class="easyui-validatebox" type="radio"  name="identity_zrd" value="2" />不合格
		  </td>
		  <td>
		 	 <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="rhd_doSearch()">查询</a>
		  </td>
		</tr>
		<tr>
			<td align="center">
				<span>工程名称: </span>
			</td>
			<td>
				<input type="text" id="gcmc_rhd" />
			</td>
			<td align="center">
				<span>工程部位:</span>
			</td>
			<td>
				<input type="text" id="gcbw_rhd" />
			</td>
			<td align="center">
				<span>样品名称:</span>
			</td>
			<td>
				<input type="text" id="ypmc_rhd" />
			</td>
			<td align="center">
				<span>样品编号:</span>
			</td>
			<td>
				<input type="text" id="ypbh_rhd" />
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
		$("#startTime_rhd").val(begin);
		$("#endTime_rhd").val(end);  
	});

	$(function() {
		$('#cc_rhd').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
			onClick: function(node){
				$("#tspdepartId_rhd").val(node.id);
				banhezhanxinxiSelect(node.id,"shebeibianhao_rhd","1");
			}
		});
		banhezhanxinxiSelect("","shebeibianhao_rhd","1");
	});
	
	function rhd_doSearch() {
		$('#tt_rhd').datagrid('load', {
			pid : $("#tspdepartId_rhd").val(),
			startTime : $("input[name='startTimerhd']").val(),
			endTime : $("input[name='endTimerhd']").val(),
			fzlx : $("input[name='identity_zrd']:checked").val(),
			shebeibianhao : $("#shebeibianhao_rhd").val(),
			gcmc:$("#gcmc_rhd").val(),
			gcbw:$("#gcbw_rhd").val(),
			ypmc:$("#ypmc_rhd").val(),
			ypbh:$("#ypbh_rhd").val()
		});
	};
</script>
