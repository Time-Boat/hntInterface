<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="v_ShebeiInfoList" title="设备信息管理" actionUrl="v_ShebeiInfoController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
	    <t:dgCol title="内部编号" field="neibubianhao" ></t:dgCol>
	    <t:dgCol title="设备名称" field="shebeiname" ></t:dgCol>
	    <t:dgCol title="所在单位" field="departname" ></t:dgCol>
	    <t:dgCol title="规格型号" field="guige" ></t:dgCol>
	    <t:dgCol title="制造厂商" field="changjia" ></t:dgCol>
	    <t:dgCol title="出厂编号" field="chuchangnumber" ></t:dgCol> 
	    <t:dgCol title="购置日期" field="gouzhiriqi" formatter="yyyy-MM-dd"></t:dgCol>
	    <t:dgCol title="数量" field="amount" ></t:dgCol>
	    <t:dgCol title="单价" field="danjia" ></t:dgCol>
	    <t:dgCol title="检定周期（月）" field="jiandingzhouqi" ></t:dgCol>
	    <t:dgCol title="检定单位" field="jiandingdanwei" ></t:dgCol>
	    <t:dgCol title="最近检定日期" field="jiandingriqi" formatter="yyyy-MM-dd"></t:dgCol>
	    <t:dgCol title="下次检定日期" field="nextjiandingriqi" formatter="yyyy-MM-dd"></t:dgCol>
	    <t:dgCol title="保管人" field="baoguanren" ></t:dgCol>
	    <t:dgCol title="所属操作室" field="caozuoshi" ></t:dgCol>
	   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
	   <t:dgDelOpt title="删除" url="v_ShebeiInfoController.do?del&id={id}" />
	   <t:dgToolBar title="录入" icon="icon-add" url="v_ShebeiInfoController.do?addorupdate" funname="add"  width="1000" height="510"></t:dgToolBar>
	   <t:dgToolBar title="编辑" icon="icon-edit" url="v_ShebeiInfoController.do?addorupdate" funname="update"  width="1000" height="510"></t:dgToolBar>
	   <t:dgToolBar title="查看" icon="icon-search" url="v_ShebeiInfoController.do?addorupdate" funname="detail"  width="1000" height="510"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>