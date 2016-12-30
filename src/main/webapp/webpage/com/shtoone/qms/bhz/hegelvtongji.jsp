<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="hegelvtongji" title="合格率信息统计" actionUrl="v_SYJZBController.do?datagrid2"     idField="id" fit="true">
  <t:dgCol title="试验室名称" field="departname" rowspan="2" colspan="1"></t:dgCol>
   <t:dgCol title="试验结果" field="pdjg"  rowspan="2" colspan="1"></t:dgCol>
   <t:dgCol title="累计"  field="wtbh"  colspan="3" rowspan="1"></t:dgCol>
   <t:dgCol title="总数"  field="sylx"  colspan="1" rowspan="1"></t:dgCol>
   <t:dgCol title="比例(%)"  field="sjbh"  colspan="1" rowspan="1"></t:dgCol>
  </t:datagrid>
  </div>
 </div>