<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script language="JavaScript" src="<%=request.getContextPath()%>/plug-in/main/js/FusionCharts.js"></script>  
 <%= (String)request.getAttribute("strXML")%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="Xiangxixx2015List" title="Xiangxixx2015" actionUrl="Xiangxixx2015Controller.do?datagrid" idField="id" fit="true" pageSize="15">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>   
   <t:dgCol title="chaozuozhe" field="chaozuozhe" ></t:dgCol>
   <t:dgCol title="sha1Shijizhi" field="sha1Shijizhi" ></t:dgCol>   
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="Xiangxixx2015Controller.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="Xiangxixx2015Controller.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="Xiangxixx2015Controller.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="Xiangxixx2015Controller.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>