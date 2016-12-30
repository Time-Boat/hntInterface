<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px">
  <t:datagrid name="appUploadList" title="app上传" actionUrl="appUploadController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="app名称" field="appName"   width="120"></t:dgCol>
   <t:dgCol title="版本号" field="versionName"   width="120"></t:dgCol>
   <t:dgCol title="包名" field="packageName"   width="120"></t:dgCol>
   <t:dgCol title="描述" field="description"   width="120"></t:dgCol>
   <t:dgCol title="下载次数" field="downloadCount"   width="120"></t:dgCol>
   <t:dgCol title="上传时间" field="uploadTime"   width="120"></t:dgCol>
   <t:dgCol title="是否强制更新" field="isforceupdate" replace="否_0,是_1"  width="120"></t:dgCol>
   <t:dgCol title="备注" field="remark"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="appUploadController.do?del&id={id}" />
   <t:dgFunOpt title="下载" funname="downloadFile(id)" />
   <t:dgToolBar title="上传" icon="icon-add" url="appUploadController.do?addorupdate" funname="add"></t:dgToolBar>
  </t:datagrid>
    <script>
  
	  	function downloadFile(id){
	  		window.open("appUploadController.do?download&id="+id);
	  		$('#appUploadList').datagrid('reload');
	  	}
	  	
    </script>
  </div>
 </div>