<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript" charset="utf-8">
	function courseListExportXls(){		    
		var departid = $('input[name=abcd]').val();
		var shebeibianhao = $('select[name=shebeibianhao]').val();
		var startTime = $('input[name=startTime]').val();
		var endTime = $('input[name=endTime]').val();
		var url = "hntsclhsController.do?datagrid&type=exportData&departid="+departid+"&shebeibianhao="+shebeibianhao+"&startTime="+startTime+"&endTime="+endTime;
		
		window.open(url);
		/*
		$.get(
			url,
			{}
		);
		*/
	}
</script>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid  name="hntsclhsList" title="生产量核算" actionUrl="hntsclhsController.do?datagrid" idField="id" pageSize="15" fit="true" queryMode="group">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>

   <t:dgCol title="最新出料时间" field="chuliaoshijian" align="center" formatter="yyyy-MM-dd" extend="{class:{value:'easyui-datebox'}}"></t:dgCol>
   <t:dgCol title="工程名称" field="gongchengmingcheng" align="center"></t:dgCol>
   <t:dgCol title="施工里程" field="sigongdidian" align="center"></t:dgCol>
   <t:dgCol title="浇注部位" field="jiaozuobuwei" align="center"></t:dgCol>
   <t:dgCol title="强度等级" field="qiangdudengji" align="center"></t:dgCol>
   <t:dgCol title="配合比编号" field="peifanghao" align="center"></t:dgCol>
   <t:dgCol title="强度实际使用量" field="gujifangshu" align="center"></t:dgCol>
  <%--  <t:dgToolBar title="导出Excel" icon="icon-search" onclick="courseListExportXls();"></t:dgToolBar> --%>
<%--    <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="hntsclhsController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="hntsclhsController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hntsclhsController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hntsclhsController.do?addorupdate" funname="detail"></t:dgToolBar> --%>
  </t:datagrid>


	<div>
	<span>所属部门:</span>
		<input id="cc_sclhs" name="abcd" value="${depart.TSPDepart.departname}" style="height:24px;width:180px;">
		<input id="tspdepartId_sclhs" name="departid" style="display: none;" value="${depart.TSPDepart.id}">
	<span>拌和机名称:</span>
		<select id="shebeibianhao_sclhs" name="shebeibianhao" style="height:22px;width:180px;">
		</select>
	<span>施工里程:</span>
		<input id="sigongdidian_sclhs" type="text" name="sigongdidian"/>
	<span>浇注部位:</span>
		<input id="jiaozuobuwei_sclhs" type="text" name="jiaozuobuwei"/>
	<span>强度等级:</span>
		<input id="qiangdudengji_sclhs" type="text" name="qiangdudengji"/>	
	</div>
	
	<div>
	<span>出料时间:</span>
		<input id="startTime_sclhs" type="text" name="startTime" class="easyui-datebox" />
	<span>至:</span> 
		<input id="endTime_sclhs" type="text" name="endTime" class="easyui-datebox" />
	<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="hntsclhsListsearch();" >查询</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="courseListExportXls();" >导出</a>
	</div>

</div>
</div>
<script type="text/javascript">
 $(function(){

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
// 	$("input[name='chuliaoshijian_begin']").datebox("setValue",begin);
 	/* $("input[name='chuliaoshijian_begin']").val(begin);
	$("input[name='chuliaoshijian_end']").val(end); */
	$("#startTime_sclhs").val(begin);
	$("#endTime_sclhs").val(end);
});
</script>

<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
<script type="text/javascript">
	$(function() {
		$('#cc_sclhs').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
			onClick: function(node){
				$("#tspdepartId_sclhs").val(node.id);
				banhezhanxinxiSelect(node.id,"shebeibianhao_sclhs","1");
			}
		});
		banhezhanxinxiSelect("","shebeibianhao_sclhs","1");
 }); 
</script>
