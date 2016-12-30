<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>短信充值</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
	$(function() {
		$('#ccsmsrecord').combotree({
			url : 'smsrecordController.do?setDepart',
			onClick: function(node){
				$("#departid").val(node.id);
			}
		});
	});
</script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="smsrecordController.do?save">
			<input id="id" name="id" type="hidden" value="${smsrecordPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
			<tr>
					<td align="right">
			           <label class="Validform_label"> 拌和站: </label> 
			        </td>
					<td class="value"><input id="ccsmsrecord"  value="${depart.departname}"  style="width: 200px;">	    
					<input id="departid" name="departid" style="display: none;"
		value="${smsrecordPage.departid}">                                 
		           </td>
		    </tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							剩余短信数量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="smscount" name="smscount" ignore="ignore"
							   value="${smsrecordPage.smscount}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发送成功:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="successcount" name="successcount" ignore="ignore"
							   value="${smsrecordPage.successcount}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							总发送:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="totalcount" name="totalcount" ignore="ignore"
							   value="${smsrecordPage.totalcount}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发送失败:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="failcount" name="failcount" ignore="ignore"
							   value="${smsrecordPage.failcount}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否提醒:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="isalarm" name="isalarm" ignore="ignore"
							   value="${smsrecordPage.isalarm}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							提醒余额:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="alarmcount" name="alarmcount" ignore="ignore"
							   value="${smsrecordPage.alarmcount}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							提醒手机号码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="alarmnumber" name="alarmnumber" ignore="ignore"
							   value="${smsrecordPage.alarmnumber}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否完成充值:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="completealarm" name="completealarm" ignore="ignore"
							   value="${smsrecordPage.completealarm}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>