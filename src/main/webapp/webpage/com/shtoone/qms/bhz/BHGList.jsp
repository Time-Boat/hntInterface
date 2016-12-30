<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="BHGList" title="不合格信息数据采集" actionUrl="BHGListController.do?datagrid"     idField="id" fit="true">
  <t:dgCol title="试件唯一编号" field="syjid" hidden="hidden" rowspan="2" colspan="1"></t:dgCol>
    <t:dgCol field="opt" title="操作"></t:dgCol>
   <t:dgFunOpt  funname="" operationCode="xiangqing" title="查看详情"></t:dgFunOpt>
   <t:dgFunOpt funname="" operationCode="baojing" title="查看报警"></t:dgFunOpt>
   <t:dgCol title="委托编号" field="wtbh" ></t:dgCol>
   <t:dgCol title="试验单位"  field="departname"  ></t:dgCol>
   <t:dgCol title="试验日期"  field="syrq"  ></t:dgCol>
   <t:dgCol title="试验名称"  field="testname"  ></t:dgCol>
   
   <t:dgCol title="规格种类"  field="ggzl"  ></t:dgCol>
   <t:dgCol title="代表数量"  field="ddsl" ></t:dgCol>
   <t:dgCol title="工程名称"  field="gcmc" ></t:dgCol>  
     
   <t:dgCol title="施工部位"  field="sgbw"  ></t:dgCol>
   <t:dgCol title="试件组号"  field="sjbh" ></t:dgCol>
   <t:dgCol title="设计强度"  field="sjqd"  ></t:dgCol>
  
	<t:dgCol title="品种编码"  field="pzbm"  ></t:dgCol>
   <t:dgCol title="试验结果"  field="pdjg"  ></t:dgCol>
   
 
  </t:datagrid>
  </div>
 </div>