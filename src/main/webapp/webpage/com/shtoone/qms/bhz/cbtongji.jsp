<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<div class="easyui-layout" fit="true">
<div region="center" style="padding:1px;">

<table id="tt_cbtj" class="easyui-datagrid" fit="true"
		url="CbtongjiController.do?datagrid" toolbar="#tb_cbtj"
		title="超标统计" iconCls="icon-save"
		rownumbers="true">
	<thead>
		<tr class="aa">
			<th field="banhezhanminchen" align="center">拌和机名称</th>
			<th field="gujifangshu" align="center">总产量</th>
			<th field="pangshu" align="center">总盘数</th>
			<th field="ambegin" align="center">初级超标盘数</th>
			<th field="amend" align="center">初级超标率(%)</th>
			<th field="shuinipingzhong" align="center">中级超标盘数</th>
			<th field="jiaozuobuwei" align="center">中级超标率(%)</th>
			<th field="pmbegin" align="center">高级超标盘数</th>
			<th field="pmend" align="center">高级超标率(%)</th>
			<th field="Sha1_shijizhi" align="center">初级处置盘数</th>
			<th field="Sha1_lilunzhi" align="center">初级处置率(%)</th>
			<th field="Sha2_shijizhi" align="center">中级处置盘数</th>
			<th field="Sha2_lilunzhi" align="center">中级处置率(%)</th>
			<th field="Shi1_shijizhi" align="center">高级处置盘数</th>
			<th field="Shi1_lilunzhi" align="center">高级处置率(%)</th>
		</tr>
	</thead>
</table>

	<div id="tb_cbtj" style="padding:5px">
	<span>所属部门:</span>
			<input id="cc_cbtj"  value="${depart.TSPDepart.departname}" style="width: 120px;">
				<input id="tspdepartId_cbtj" name="TSPDepart.id" style="display: none;"
					value="${depart.TSPDepart.id}">
	<span>拌和机名称:</span>
	<select id="shebeibianhao_cbtj" name="shebeibianhao" style="height:22px;width:120px;">
	</select>
	
	<span>出料时间:</span>
		<input id="startTime_cbtj" type="text" name="startTimecbtj" class="easyui-datebox" />
	<span>至:</span>
		<input id="endTime_cbtj" type="text" name="endTimecbtj"  class="easyui-datebox"/>
	<span>分组类型:</span>
		<input class="easyui-validatebox" type="radio"  name="identity" value="0" checked="checked" />全局 
   		<!-- <input class="easyui-validatebox" type="radio"  name="identity" value="1" />项目 
   		<input class="easyui-validatebox" type="radio"  name="identity" value="2" />标段 -->
   		<input class="easyui-validatebox" type="radio"  name="identity" value="3" />拌合机	
	<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="cbtj_doSearch()">查询</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="cbtj_daochu()">导出</a>
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
		$("#startTime_cbtj").val(begin);
		$("#endTime_cbtj").val(end);  
	});

	$(function() {
		$('#cc_cbtj').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
			onClick: function(node){
				$("#tspdepartId_cbtj").val(node.id);
				banhezhanxinxiSelect(node.id,"shebeibianhao_cbtj","1");
			}
		});
		banhezhanxinxiSelect("","shebeibianhao_cbtj","1");
	});
	
	function cbtj_doSearch() {
		$('#tt_cbtj').datagrid('load', {
			pid : $("#tspdepartId_cbtj").val(),
			startTime : $("input[name='startTimecbtj']").val(),
			endTime : $("input[name='endTimecbtj']").val(),
			fzlx : $("input[name='identity']:checked").val(),
			shebeibianhao : $("#shebeibianhao_cbtj").val()
		});
	};
	function cbtj_daochu(){
		var pid = $("#tspdepartId_cbtj").val();
		var startTime = $("input[name='startTimecbtj']").val();
		var endTime = $("input[name='endTimecbtj']").val();
		var fzlx = $("input[name='identity']:checked").val();
		var shebeibianhao = $("#shebeibianhao_cbtj").val();
		var url = "CbtongjiController.do?cbtjexportXls&pid="+pid+"&startTime="+startTime+"&endTime="+endTime+"&fzlx="+fzlx+"&shebeibianhao="+shebeibianhao;
		window.open(url);
	}
	
	
</script>
