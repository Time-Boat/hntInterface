<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>app上传</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  
  <script type="text/javascript">

  	function uploadFile(data){
  	//当实体类提交后的回调函数
  		$("#appUploadId").val(data.obj.id);
  		if($(".uploadify-queue-item").length>0){
  			upload();
  		}else{
  			frameElement.api.opener.reloadTable();
  			frameElement.api.close();
  		}
  	}
  	
  	function close(){
  		frameElement.api.close();
  	}
  </script>
  
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="appUploadController.do?save" callback="@Override uploadFile" >
		<input id="appUid" name="id" type="hidden" value="${appUploadPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right">
					<label class="Validform_label">
						名称:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="appName" name="appName" ignore="ignore"
						   value="${appUploadPage.appName}">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						版本号:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="versionCode" name="versionCode" ignore="ignore"
						   value="${appUploadPage.versionCode}">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						版本名:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="versionName" name="versionName" ignore="ignore"
						   value="${appUploadPage.versionName}">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						包名:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="packageName" name="packageName" ignore="ignore"
						   value="${appUploadPage.packageName}">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						描述:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="description" name="description" 
						   value="${appUploadPage.description}" />
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						备注:
					</label>
				</td>
				<td class="value">
					<input class="inputxt" id="remark" name="remark" ignore="ignore"
						   value="${appUploadPage.remark}">
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						是否强制更新:
					</label>
				</td>
				<td class="value">
					<input type="radio" id="available2" name="isForceUpdate" ignore="ignore"
						   value="0" <c:if test="${appUploadPage.isForceUpdate==0 or appUploadPage.isForceUpdate==null}" >checked</c:if> /> <Label for="available2" >否  </Label> 
					<input type="radio" id="available1" name="isForceUpdate" ignore="ignore"
						   value="1" <c:if test="${appUploadPage.isForceUpdate==1}" >checked</c:if> /> <Label for="available1" >是  </Label> 
					<span class="Validform_checktip"></span>
				</td>
			</tr>
		</table>
			<div class="form" id="filediv" style="height: 50px"></div>
				<t:upload name="fiels" id="file_upload" extend="*.apk;" buttonText="添加文件"  uploader="appUploadController.do?saveFiles"  formData="documentTitle" ></t:upload>
				<%-- <t:upload name="fiels" buttonText="上传文件" uploader="hunnintujieguoViewController.do?saveFiles"  extend="*.xls;*.xlsx;*.jpg;*.png;*.bmp;*.gif;*.doc;*.docx;" id="file_upload" formData="documentTitle"></t:upload> --%>
	</t:formvalid>
	<form action="" id ="appUploadForm"> <input type="hidden" value="${appUploadPage.id}" id="appUploadId" name="appUploadId" /> </form>
 </body>