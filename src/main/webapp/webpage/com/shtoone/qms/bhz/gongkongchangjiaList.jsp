<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="gongkongchangjiaList" title="设备工控机厂家" actionUrl="gongkongchangjiaController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="sbbh" field="sbbh" ></t:dgCol>
   <t:dgCol title="sbname" field="sbname" ></t:dgCol>
   <%--
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="gongkongchangjiaController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="gongkongchangjiaController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="gongkongchangjiaController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="gongkongchangjiaController.do?addorupdate" funname="detail"></t:dgToolBar>
    --%>
  </t:datagrid>
  </div>
 </div>