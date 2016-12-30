<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="xiangxixxsmsList" title="发送短信临时表" actionUrl="xiangxixxsmsController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="leiji" field="leiji" ></t:dgCol>
   <t:dgCol title="panshu" field="panshu" ></t:dgCol>
   <t:dgCol title="shebeibianhao" field="shebeibianhao" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="xiangxixxsmsController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="xiangxixxsmsController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="xiangxixxsmsController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="xiangxixxsmsController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>