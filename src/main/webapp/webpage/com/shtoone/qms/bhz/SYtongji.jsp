<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="SYtongji" title="试验主表" actionUrl="v_SYJZBController.do?datagrid"     idField="id" fit="true">
  <t:dgCol title="试验单位" field="departname" rowspan="2" colspan="1"></t:dgCol>
  </t:datagrid>
  <div id="container" style="min-width:700px;height:400px"></div>
  </div>
  <script type="text/javascript" src="http://cdn.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
  <script type="text/javascript" src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
  <script type="text/javascript" src="http://cdn.hcharts.cn/highcharts/exporting.js"></script>
  <script type="text/javascript">
   			
  
  </script>
 </div>
   