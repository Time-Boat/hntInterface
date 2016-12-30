<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>报警手机号码配置</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
	$(function() {
		
		$('#cc').combotree({
			url : 'departController.do?setPFunction&selfId=${handsetPage.biaoduan}',
			onClick: function(node){
				$("#hansettspdepartId").val(node.id);
			}
		});
	});
</script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="handsetController.do?save">
			<input id="id" name="id" type="hidden" value="${handsetPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							群组名称:${departName }
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="name" name="name"
							   value="${handsetPage.name}" datatype="*" errormsg="该字段不为空">
						<span class="Validform_checktip"><font color=red>必填*</font></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							手机号组:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="phone" name="phone"
							   value="${handsetPage.phone}" datatype="*,m" errormsg="该字段不为空">
						<span class="Validform_checktip"><font color=red>必填*</font></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							所属机构:
						</label>
					</td>
					<td class="value">
						<%--
						<input class="inputxt" id="biaoduan" name="biaoduan" ignore="ignore"
							   value="${handsetPage.biaoduan}" datatype="n">
						<span class="Validform_checktip"></span>
						--%>
						<input id="cc" value="${departName}" style="width:250px;">
						<input id="hansettspdepartId" name="biaoduan" style="display: none;"
							value="${handsetPage.biaoduan}" datatype="*" errormsg="该字段不为空">
							<span class="Validform_checktip"><font color=red>必选*</font></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							手机号对应人员名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="owername" name="owername"
							   value="${handsetPage.owername}" datatype="*" errormsg="该字段不为空">
						<span class="Validform_checktip"><font color=red>必填*</font></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>