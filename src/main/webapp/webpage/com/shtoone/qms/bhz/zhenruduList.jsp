<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<div class="easyui-layout" fit="true">
<div region="center" style="padding:1px;">
<t:datagrid name="tt_zrd" actionUrl="W_rhd_zrd.do?zrddatagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="设备名称" field="banhezhanminchen"></t:dgCol>
   <t:dgCol title="试验时间" field="TIME"></t:dgCol>
   <t:dgCol title="工程名称" field="ProjectName"></t:dgCol>
   <t:dgCol title="样品编号" field="SampleNo"></t:dgCol>
   <t:dgCol title="工程部位" field="GCBuWei"></t:dgCol>
   <t:dgCol title="样品名称" field="SampleName"></t:dgCol>
   <t:dgCol title="样品描述" field="SampleMS"></t:dgCol>
   <t:dgCol title="针入度(mm)单值1" field="zrd1"></t:dgCol>
   <t:dgCol title="针入度(mm)单值2" field="zrd2"></t:dgCol>
    <t:dgCol title="针入度(mm)单值3" field="zrd3"></t:dgCol>
   <t:dgCol title="标准值" field="biaozhunzhi1"></t:dgCol>
   <t:dgCol title="平均值" field="ZRDAvg"></t:dgCol>
   <t:dgCol title="是否合格" field="isQualified"></t:dgCol>
  </t:datagrid>

	<div id="tb_zrd" style="padding:5px">
	<table>
		<tr>
		  <td align="center">
		    <span>所属部门:</span>
		  </td>
		  <td>
		  	<input id="cc_zrd"  value="${depart.TSPDepart.departname}" style="width: 120px;">
			<input id="tspdepartId_zrd" name="TSPDepart.id" style="display: none;"
			value="${depart.TSPDepart.id}">
		  </td>
		  <td align="center">
		  	<span>拌和机名称:</span>
		  </td>
		  <td>
		  	<select id="shebeibianhao_zrd" name="shebeibianhao" style="height:22px;width:120px;">
			</select>
		  </td>
		  <td align="center">
		  	<span>时间:</span>
		  </td>
		  <td>
		  	<input id="startTime_zrd" type="text" name="startTimezrd" class="easyui-datebox" />
		  </td>
		  <td align="center">
		  	<span>至:</span>
		  </td>
		  <td>
		  	<input id="endTime_zrd" type="text" name="endTimezrd"  class="easyui-datebox"/>
		  </td>
		  <td align="center">
		  	<span>是否合格:</span>
			<input class="easyui-validatebox" type="radio"  name="identity_zrd" value="0" checked="checked" />全部
   			<input class="easyui-validatebox" type="radio"  name="identity_zrd" value="1" />合格	
   			<input class="easyui-validatebox" type="radio"  name="identity_zrd" value="2" />不合格
		  </td>
		  <td>
		 	 <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="zrd_doSearch()">查询</a>
		  </td>
		</tr>
		<tr>
			<td align="center">
				<span>工程名称: </span>
			</td>
			<td>
				<input type="text" id="gcmc_zrd" />
			</td>
			<td align="center">
				<span>工程部位:</span>
			</td>
			<td>
				<input type="text" id="gcbw_zrd" />
			</td>
			<td align="center">
				<span>样品名称:</span>
			</td>
			<td>
				<input type="text" id="ypmc_zrd" />
			</td>
			<td align="center">
				<span>样品编号:</span>
			</td>
			<td>
				<input type="text" id="ypbh_zrd" />
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
		$("#startTime_zrd").val(begin);
		$("#endTime_zrd").val(end);  
	});

	$(function() {
		$('#cc_zrd').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
			onClick: function(node){
				$("#tspdepartId_zrd").val(node.id);
				banhezhanxinxiSelect(node.id,"shebeibianhao_zrd","1");
			}
		});
		banhezhanxinxiSelect("","shebeibianhao_zrd","1");
	});
	
	function zrd_doSearch() {
		$('#tt_zrd').datagrid('load', {
			pid : $("#tspdepartId_zrd").val(),
			startTime : $("input[name='startTimezrd']").val(),
			endTime : $("input[name='endTimezrd']").val(),
			fzlx : $("input[name='identity_zrd']:checked").val(),
			shebeibianhao : $("#shebeibianhao_zrd").val(),
			gcmc:$("#gcmc_zrd").val(),
			gcbw:$("#gcbw_zrd").val(),
			ypmc:$("#ypmc_zrd").val(),
			ypbh:$("#ypbh_zrd").val()
		});
	};
</script>
