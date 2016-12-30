<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="jJGROUPList" title="交建组织机构" actionUrl="jJGROUPController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="ecode" field="ecode" ></t:dgCol>
   <t:dgCol title="grade" field="grade" ></t:dgCol>
   <t:dgCol title="name" field="name" ></t:dgCol>
   <t:dgCol title="oid" field="oid" ></t:dgCol>
   <t:dgCol title="poid" field="poid" ></t:dgCol>
   <t:dgCol title="status" field="status" ></t:dgCol>
   <t:dgCol title="type" field="type" ></t:dgCol>
   <t:dgCol title="typeext" field="typeext" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="jJGROUPController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="jJGROUPController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="jJGROUPController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="jJGROUPController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>