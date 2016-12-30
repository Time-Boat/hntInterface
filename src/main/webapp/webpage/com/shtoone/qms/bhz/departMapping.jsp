<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>标段部门映射表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
	$(function() {
		$('#cc').combotree({
			url : 'departController.do?setPFunction&selfId=${departMappingPage.departid}',
			onClick: function(node){
				$("#tspdepartId").val(node.id);
			}
		});
	});
</script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="departMappingController.do?save">
			<input id="id" name="id" type="hidden" value="${departMappingPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							标段部门:
						</label>
					</td>
					<td class="value">
						<%--
						<input class="inputxt" id="departid" name="departid" ignore="ignore"
							   value="${departMappingPage.departid}">
						<span class="Validform_checktip"></span>
						 --%>
						<input id="cc" value="${departName}" style="width:250px;">
						<input id="tspdepartId" name="departid" style="display: none;"
							value="${departMappingPage.departid}" datatype="*" errormsg="该字段不为空">
							<span class="Validform_checktip"><font color=red>必选*</font></span>
							
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							映射编码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="mappingcoding" name="mappingcoding"
							   value="${departMappingPage.mappingcoding}" datatype="*" errormsg="该字段不为空">
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
							   value="${departMappingPage.remark}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>