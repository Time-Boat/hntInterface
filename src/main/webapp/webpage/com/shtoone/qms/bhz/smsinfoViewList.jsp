<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="smsinfoViewList" title="发送短信查询" actionUrl="smsinfoViewController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="拌和机" field="banhezhanminchen" width="150" frozenColumn="true" align="center" sortable="false" ></t:dgCol>
   <t:dgCol title="发送时间" field="shijian" width="120" frozenColumn="true" align="center" sortable="false" ></t:dgCol>
   <t:dgCol title="发送内容" field="fasongcontent" width="400" frozenColumn="true" align="center" sortable="false" ></t:dgCol>
   <t:dgCol title="发送号码" field="fasongphone" width="200" frozenColumn="true" align="center" sortable="false" ></t:dgCol>
    <t:dgCol title="发送状态" field="fasongstatus" width="100" frozenColumn="true" align="center" sortable="false" ></t:dgCol>
   <t:dgCol title="用户姓名" field="owername" width="80" frozenColumn="true" align="center" sortable="false" ></t:dgCol>
   
  
   <t:dgCol title="详细" field="opt" ></t:dgCol>
<%--    <t:dgDelOpt title="删除" url="smsinfoViewController.do?del&id={id}" /> --%>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="smsinfoViewController.do?addorupdate" funname="add"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="编辑" icon="icon-edit" url="smsinfoViewController.do?addorupdate" funname="update"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="smsinfoViewController.do?addorupdate" funname="detail"></t:dgToolBar> --%>

 
  <t:dgFunOpt funname="operationDetailLookxxwj(xxbianhao)" title="查看"></t:dgFunOpt>
  </t:datagrid>
  
<div id="logListtb" style="padding: 3px; height: 50px"><!-- update---Author:赵俊夫  Date:20130507 for：需要加name=searchColums属性 -->
<div name="searchColums" style="float: left; padding-right: 15px;">
<table>
	<tr>
		<td align="left" >所属机构</td>
		<td ><input id="cc_smsinfoviewlist"  value="${depart.TSPDepart.departname}" style="height:24px;width:180px;">
			<div><input id="smsinfoViewListdepartId" name="departid" style="display: none;" value="${depart.TSPDepart.id}"></div>
		</td>
		<td><select id="smsinfoviewlistshebeibianhao" name="shebeibianhao" style="height:24px;width:180px;"></select></td>
		
		<td >保存时间:</td>
		<td>
		<input id="startTime" type="text" name="startTime" class="easyui-datebox" />
		</td>
		<td>至
		<input id="endTime" type="text" name="endTime"  class="easyui-datebox"/>
	   </td>
	   <td></td>
   		<td  align="right"><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="smsinfoViewListsearch();" >查询</a></td>
	</tr>
	
	
</table>
</div>
<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
 <script type="text/javascript">
 	$(function() {
		$('#cc_smsinfoviewlist').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
			onClick: function(node){
				$("#smsinfoViewListdepartId").val(node.id);
				banhezhanxinxiSelect(node.id,"smsinfoviewlistshebeibianhao","1");
			}
		});
		banhezhanxinxiSelect("","smsinfoviewlistshebeibianhao","1");
	});
 //查看处理
 function operationDetailLookxxwj(xxbianhao) {
	// alert(jieguoid+"--"+jieguoid+"--"+gprsbianhao);
	 createdetailwindow("查看","HunnintuylcxController.do?addorupdate&id="+xxbianhao,"850px","500px");
 } 
 
 </script>
 

  
  </div>
 </div>