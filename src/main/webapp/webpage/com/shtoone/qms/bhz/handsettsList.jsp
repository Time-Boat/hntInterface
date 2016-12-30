<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="handsettsList" title="报警手机号码配置" actionUrl="handsetController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
    <t:dgCol title="操作" field="opt" frozenColumn="true"></t:dgCol>
    <t:dgFunOpt funname="operationDetailadd(id)" title="批量增加"></t:dgFunOpt>
    
    <t:dgFunOpt exp="chulishijian#empty#true" funname="operationDetailChuli(id,xinxibianhao,shebeibianhao)"  operationCode="cbchuli" title="编辑"></t:dgFunOpt>
    
    <t:dgFunOpt exp="shenpidate#empty#true" funname="operationDetailShenpi(id,xinxibianhao,shebeibianhao)"  operationCode="cbshenpi" title="删除"></t:dgFunOpt>
    
   <t:dgCol title="群组名称" field="name" ></t:dgCol>
<%--    <t:dgCol title="手机号组" field="phone" ></t:dgCol>
   <t:dgCol title="所属机构" field="biaoduan" replace="${departsReplace}"></t:dgCol>
   <t:dgCol title="手机号对应人员名称" field="owername" ></t:dgCol> --%>
   <t:dgToolBar title="录入" icon="icon-add" url="handsetController.do?addorupdate" funname="add"></t:dgToolBar>
  </t:datagrid>
  
   <div id="logListtb" style="padding: 3px; height: 30px"><!-- update---Author:赵俊夫  Date:20130507 for：需要加name=searchColums属性 -->
<div name="searchColums" style="float: left; padding-right: 15px;">
<table>
	<tr>
		
		<td>群名称：<input type="text" id="qunname" name="qunname"></td>
		
		<td rowspan="2" align="right"><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="handsetListsearch();" >查询</a></td>
		</tr>
</table>
</div>
 <script type="text/javascript">
 //批量增加
 function operationDetailadd(id) {
	 createdetailwindow("批量增加","handsetController.do?addlist&id="+id,"1200px","500px");
 }
 
</script>

  </div>
 </div>