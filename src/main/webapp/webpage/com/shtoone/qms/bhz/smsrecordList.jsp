<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script language="JavaScript" src="<%=request.getContextPath()%>/plug-in/main/js/FusionCharts.js"></script>  
<div class="easyui-layout" fit="true">
 
  <div region="center" style="padding:1px;">
  <t:datagrid name="smsrecordList" title="短信充值" actionUrl="smsrecordController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="拌和站名称" field="departname" ></t:dgCol>
   <t:dgCol title="剩余短信数量" field="smscount" ></t:dgCol>
   <t:dgCol title="发送失败" field="failcount" ></t:dgCol>
   <t:dgCol title="是否提醒" field="isalarm" ></t:dgCol>
   <t:dgCol title="提醒余额" field="alarmcount" ></t:dgCol>
   <t:dgCol title="提醒手机号" field="alarmnumber" ></t:dgCol>
   <t:dgCol title="发送成功" field="successcount" ></t:dgCol>
   <t:dgCol title="总发送" field="totalcount" ></t:dgCol>
   <t:dgCol title="completealarm" field="completealarm" hidden="false"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="smsrecordController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="smsrecordController.do?addorupdate" operationCode="recordnew"  funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="smsrecordController.do?addorupdate" operationCode="recordedit"  funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="smsrecordController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
     
 </div>