<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="v_SYJZBNList" title="试验主表" actionUrl="v_SYJZBNController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="syjid" field="syjid" ></t:dgCol>
   <t:dgCol title="sbbh" field="sbbh" ></t:dgCol>
   <t:dgCol title="sylx" field="sylx" ></t:dgCol>
   <t:dgCol title="wtbh" field="wtbh" ></t:dgCol>
   <t:dgCol title="sjbh" field="sjbh" ></t:dgCol>
   <t:dgCol title="zzrq" field="zzrq" ></t:dgCol>
   <t:dgCol title="syrq" field="syrq" ></t:dgCol>
   <t:dgCol title="sywcsj" field="sywcsj" ></t:dgCol>
   <t:dgCol title="sjscsj" field="sjscsj" ></t:dgCol>
   <t:dgCol title="lq" field="lq" ></t:dgCol>
   <t:dgCol title="sjcc" field="sjcc" ></t:dgCol>
   <t:dgCol title="sjmj" field="sjmj" ></t:dgCol>
   <t:dgCol title="sjsl" field="sjsl" ></t:dgCol>
   <t:dgCol title="sjqd" field="sjqd" ></t:dgCol>
   <t:dgCol title="zsxs" field="zsxs" ></t:dgCol>
   <t:dgCol title="qddbz" field="qddbz" ></t:dgCol>
   <t:dgCol title="pdjg" field="pdjg" ></t:dgCol>
   <t:dgCol title="czry" field="czry" ></t:dgCol>
   <t:dgCol title="cjmc" field="cjmc" ></t:dgCol>
   <t:dgCol title="pzbm" field="pzbm" ></t:dgCol>
   <t:dgCol title="gczj" field="gczj" ></t:dgCol>
   <t:dgCol title="area" field="area" ></t:dgCol>
   <t:dgCol title="iswjj" field="iswjj" ></t:dgCol>
   <t:dgCol title="rtcode" field="rtcode" ></t:dgCol>
   <t:dgCol title="szfw" field="szfw" ></t:dgCol>
   <t:dgCol title="fbl" field="fbl" ></t:dgCol>
   <t:dgCol title="status" field="status" ></t:dgCol>
   <t:dgCol title="wtzs" field="wtzs" ></t:dgCol>
   <t:dgCol title="testname" field="testname" ></t:dgCol>
   <t:dgCol title="recGuid" field="recGuid" ></t:dgCol>
   <t:dgCol title="lft" field="lft" ></t:dgCol>
   <t:dgCol title="rgt" field="rgt" ></t:dgCol>
   <t:dgCol title="departname" field="departname" ></t:dgCol>
   <t:dgCol title="leixin" field="leixin" ></t:dgCol>
   <t:dgCol title="parentdepartid" field="parentdepartid" ></t:dgCol>
   <t:dgCol title="departorderid" field="departorderid" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="v_SYJZBNController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="v_SYJZBNController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="v_SYJZBNController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="v_SYJZBNController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>