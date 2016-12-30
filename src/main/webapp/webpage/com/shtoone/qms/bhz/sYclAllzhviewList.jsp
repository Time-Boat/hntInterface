<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  	<div region="center" style="padding:1px;">
  		<t:datagrid name="sYclAllzhviewList"   fitColumns="false" title="原材料综合管理" actionUrl="sYclAllzhviewController.do?datagrid" idField="id" fit="true" queryMode="group">
   			<t:dgCol title="操作" field="opt" frozenColumn="true"></t:dgCol>
   			<t:dgFunOpt funname="operationyclzhLook(id)" title="详情"></t:dgFunOpt>
   			<t:dgCol title="id"  field="id"  hidden="false"></t:dgCol>
   			<t:dgCol title="项目部"  field="departname"></t:dgCol>
   			<t:dgCol title="原材料"  field="leixing"></t:dgCol>
   			<t:dgCol title="检测次数"  field="totalcount"></t:dgCol>
   			<t:dgCol title="进场数量(t)"  field="ljjccount"></t:dgCol>
   			<t:dgCol title="规格"  field="guige"></t:dgCol>
   			<t:dgCol title="型号"  field="xinghao"></t:dgCol>
   			<t:dgCol title="产地"  field="chandi"></t:dgCol>
   			<t:dgCol title="生产厂家"  field="scchangjia"></t:dgCol>
   			<t:dgCol title="不合格次数"  field="bhgcount"></t:dgCol>
  		</t:datagrid>
  		<div id="sclallzh">
	 		<table cellpadding="0" cellspacing="1" class="formtable">
    			<tr>
    				<td>所属机构 :</td>
					<td><input id="cc_syclallzh"  value="${depart.TSPDepart.departname}" style="height:24px;width:180px;">
					    <div><input id="tspdepartId" name="departid" style="display: none;" value="${depart.TSPDepart.id}"></div>
					</td>
					<td>原材料:<input id="leixing1" type="text" name="leixing"/></td>
					<td>规格: <select id="guige1" name="guige" datatype="*" onchange="qh(this.value)">
							 	<option value="">---请选择规格---</option>
								<c:forEach items="${List}" var="depart">
									<option value="${depart.selectkey }">${depart.selectkey}</option>
								</c:forEach>
							</select></td>
					<td>型号: <select id="xinghao1" name="xinghao" datatype="*">
								<option value="">---请选择型号---</option>
								<c:forEach items="${sList}" var="depart">
									<option value="${depart.mselectkey }">${depart.mselectkey}</option>
								</c:forEach>
							</select></td>		
					<td><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="sYclAllzhviewListsearch();" >查询</a></td>
				</tr>
			</table>
		</div>
  	</div>
</div>
<script type="text/javascript">
 	$(function() {
	 	$('#cc_syclallzh').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}',
			onClick: function(node){
				$("#tspdepartId").val(node.id);
			}
		});
	});
 
 	function sYclAllzhviewListsearch() {
 		$('#sYclAllzhviewList').datagrid('load', {
			leixing : $('#leixing1').val(),
			guige : $("#guige1").val(),
			xinghao : $("#xinghao1").val(),
			biaoduanid :$("#tspdepartId").val()
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
				$('#'+"xinghao1").html("");
				var jsonStr='<option title="-1" selected="selected" value="">--请选择型号--</option>';
				$.each(data.list,function(i,item){
					jsonStr+='<option value="'+item.mselectkey+'">'+item.mselectkey+'</option>'
				});
				$('#'+"xinghao1").append(jsonStr);
			}
		});
 	}
 
 	function operationyclzhLook(id) {
		createdetailwindow("查看","sYclAllzhviewController.do?datagrid1&id="+id,"900px","350px");
 	}
 </script>
