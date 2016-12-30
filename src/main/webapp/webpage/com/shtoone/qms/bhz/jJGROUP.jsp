<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>交建组织机构</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="jJGROUPController.do?save">
			<input id="id" name="id" type="hidden" value="${jJGROUPPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							ecode:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ecode" name="ecode" ignore="ignore"
							   value="${jJGROUPPage.ecode}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							grade:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="grade" name="grade" ignore="ignore"
							   value="${jJGROUPPage.grade}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							name:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="name" name="name" ignore="ignore"
							   value="${jJGROUPPage.name}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							oid:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="oid" name="oid" ignore="ignore"
							   value="${jJGROUPPage.oid}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							poid:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="poid" name="poid" ignore="ignore"
							   value="${jJGROUPPage.poid}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							status:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="status" name="status" ignore="ignore"
							   value="${jJGROUPPage.status}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							type:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="type" name="type" ignore="ignore"
							   value="${jJGROUPPage.type}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							typeext:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="typeext" name="typeext" ignore="ignore"
							   value="${jJGROUPPage.typeext}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>