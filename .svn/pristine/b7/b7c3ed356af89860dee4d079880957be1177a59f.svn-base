<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="V_SmsinfoList" title="试验主表" actionUrl="V_SmsinfoController.do?datagrid"     idField="id" fit="true">
  <t:dgCol title="试验机ID" field="syjid" rowspan="2" colspan="1"></t:dgCol>
   <t:dgCol title="试验室" field="departname"  rowspan="2" colspan="1"></t:dgCol>
   <t:dgCol title="发送时间"  field="fasongshijian"  colspan="3" rowspan="1"></t:dgCol>
   <t:dgCol title="设备名称"  field="shebeijiancheng"  colspan="1" rowspan="1"></t:dgCol>
   <t:dgCol title="发送内容"  field="fasongcontent"  colspan="1" rowspan="1"></t:dgCol>
   
   <t:dgCol title="发送状态"  field="fasongstatus"  colspan="3" rowspan="1"></t:dgCol>
   <t:dgCol title="发送人"  field="fasongname"  colspan="1" rowspan="1"></t:dgCol>
   <t:dgCol title="原因分析"  field="chuli"  colspan="1" rowspan="1"></t:dgCol>  
   <t:dgCol field="opt" title="详情"></t:dgCol>
   <t:dgFunOpt funname="operationDetailadd(id)" title="查看"></t:dgFunOpt>
     
  </t:datagrid>
  </div>
 </div>