<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid fitColumns="false" checkbox="true" name="sYclGuigexinghaomList" title="规格型号信息表" actionUrl="sYclGuigexinghaomController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="主表规格"  field="selectkey"  hidden="true"  queryMode="single" query="true" width="120"></t:dgCol>
   <t:dgCol title="规格描述"  field="selectvalue"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="原材料名称"  field="remark"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="sYclGuigexinghaomController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="sYclGuigexinghaomController.do?goAdd" funname="add" height="450"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="sYclGuigexinghaomController.do?goUpdate" funname="update" height="450"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="sYclGuigexinghaomController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="sYclGuigexinghaomController.do?goUpdate" funname="detail" height="450"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/shtoone/qms/bhz/sYclGuigexinghaomList.js"></script>		
 <script type="text/javascript">
  $(document).ready(function(){
 		//给时间控件加上样式
 });
 </script>