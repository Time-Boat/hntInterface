<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  	<div region="center" style="padding:1px;">
  		<t:datagrid name="sYclAllList" pagination="true"  fitColumns="false" title="原材料进场登记信息" actionUrl="sYclAllController.do?datagrid" idField="id" fit="true" queryMode="group">
   			<t:dgCol title="操作" field="opt" frozenColumn="true"></t:dgCol>
   			<t:dgFunOpt funname="operationsyc(id)" title="复制并录入"></t:dgFunOpt>
   			<t:dgDelOpt title="删除" url="sYclAllController.do?doDel&id={id}" />
   			<t:dgToolBar title="录入" icon="icon-add" url="sYclAllController.do?goAdd" width="1200" height="400" funname="add"></t:dgToolBar>
		    <t:dgToolBar title="批量删除"  icon="icon-remove" url="sYclAllController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   			<t:dgToolBar title="导入" icon="icon-add" url="sYclAllController.do?goImport" height="340" funname="import"></t:dgToolBar>
		    <t:dgFunOpt funname="operationSYcALLEdit(id)" title="编辑" ></t:dgFunOpt>
		    <t:dgFunOpt funname="operationSYcALL(id)" title="查看"></t:dgFunOpt>
		    <t:dgCol title="id"  field="id"  hidden="false" ></t:dgCol>
		    <t:dgCol title="原材料进场登记编号"  field="jinchangbianhao"></t:dgCol>
		    <t:dgCol title="原材类型"  field="leixing"  ></t:dgCol>
		    <t:dgCol title="名称"  field="mingcheng"></t:dgCol>
		    <t:dgCol title="入库时间"  field="rukushijian" ></t:dgCol>
		    <t:dgCol title="存储地点"  field="cunchudidian"> </t:dgCol>
		    <t:dgCol title="生产厂家"  field="scchangjia" ></t:dgCol>
		    <t:dgCol title="产地"  field="chandi" ></t:dgCol>
		    <t:dgCol title="规格/型号"  field="guige" ></t:dgCol>
		    <t:dgCol title="批次"  field="pici" ></t:dgCol>
		    <t:dgCol title="进场数量"  field="jcshuliang" ></t:dgCol>
   			<t:dgCol title="材料接收人"  field="jieshouren"></t:dgCol>
   			<t:dgCol title="所属机构"  field="departname"></t:dgCol>
   			<t:dgCol title="状态"  field="daijian" replace="待检_0,已检_1"></t:dgCol>
  		</t:datagrid>
    	<div id="sclall">
    	<table cellpadding="0" cellspacing="1" class="formtable">
    	<tr>
    	<td>所属机构 :</td>
		<td><input id="cc_syclall"  value="${depart.TSPDepart.departname}" style="height:24px;width:180px;">
			<div><input id="tspdepartId" name="departid" style="display: none;" value="${depart.TSPDepart.id}"></div>
		</td>
		<td>原材料进场登记编号:</td>
		<td>
			<input id="ycljcbianhao" type="text" name="=jcbianhao"/>
		</td>
		<td>规格/型号:</td>
		<td>
			<input id="yclguige" type="text" name="guige"/> 
		</td>
		<td>
			状态:
				<select id="ycldaijian" name=""daijian"" datatype="*">
						<option value="">---请选择状态---</option>
						<option value="0">待检</option>
						<option value="1">已检</option>
						</select>
		</td>	
		<td>	<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="sYclAllListsearch();" >查询</a></td>
		</tr>
		<tr>
			<td>原材料名称:</td>
			<td><input id="yclmingcheng" style="width:160px;" type="text" name="mingcheng"/></td>
			<td>原材料进场时间:</td>
			<td><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  readonly="readonly" id="yclstartTime" name="startTime" ></td>
			<td align="center">至:</td>
			<td><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  readonly="readonly" id="yclendTime" name="endTime" ></td>
		</tr>
	</table>
	</div>
  
  </div>
 </div>
 <script src = "webpage/com/shtoone/qms/bhz/sYclAllList.js"></script>		
 <script type="text/javascript">
  $(function() {
	 $('#cc_syclall').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}',
			onClick: function(node){
				$("#tspdepartId").val(node.id);
			}
		});
	});  
 
 
 
 function sYclAllListsearch() {
	 $('#sYclAllList').datagrid('load', {
			leixing : $('#leixing').val(),
			mingcheng : $('#yclmingcheng').val(),
			guige : $("#yclguige").val(),
			daijian :$("#ycldaijian").val(),
			jinchangbianhao :$("#ycljcbianhao").val(),
			biaoduanid :$("#tspdepartId").val(),
			startTime :$("#yclstartTime").val(),
			endTime :$("#yclendTime").val()
		});
	}
 
 function qh(name){
	 $.ajax({
			url:"sYclGuigexinghaomController.do?xinghaolist",
			type:'post',
			dataType:"json",
			data:{
				name:name 
			},
			success:function(data){
				$('#'+"xinghao").html("");
				var jsonStr='<option title="-1" selected="selected" value="">--请选择型号--</option>';
				$.each(data.list,function(i,item){
					jsonStr+='<option value="'+item.mselectkey+'">'+item.mselectkey+'</option>'
				});
				$('#'+"xinghao").append(jsonStr);
			}
		});
	 
 }
 
 	function operationSYcALLEdit(id) {
		add("原材料编辑","sYclAllController.do?goUpdate&pagetype=edit&id="+id,'functionList',"1200px","400px");
	}
 	function operationsyc(id) {
		add("原材料录入","sYclAllController.do?goUpdate&pagetype=copy&id="+id,'functionList',"1200px","400px");
	}
	function operationSYcALL(id) {
	 	createdetailwindow("原材料查看","sYclAllController.do?funname=detail&goUpdate&id="+id,"1200px","400px");
	}
 </script>