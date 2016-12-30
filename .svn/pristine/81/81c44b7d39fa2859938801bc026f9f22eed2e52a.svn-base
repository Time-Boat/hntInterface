<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="banhezhanfasongList" title="接口管理" actionUrl="banhezhanfasongController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="类型" field="leixing" ></t:dgCol>
   <t:dgCol title="发送url" field="urlname" ></t:dgCol>
   <t:dgCol title="验证用户" field="username" ></t:dgCol>
   <t:dgCol title="验证密码" field="password" ></t:dgCol>
   <t:dgCol title="备注" field="remark" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="banhezhanfasongController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="banhezhanfasongController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="banhezhanfasongController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="banhezhanfasongController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>