<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>设备厂家</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="shebeichangjiaController.do?save">
			<input id="id" name="id" type="hidden" value="${shebeichangjiaPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							sbbh:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sbbh" name="sbbh" 
							   value="${shebeichangjiaPage.sbbh}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sbname:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sbname" name="sbname" ignore="ignore"
							   value="${shebeichangjiaPage.sbname}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>