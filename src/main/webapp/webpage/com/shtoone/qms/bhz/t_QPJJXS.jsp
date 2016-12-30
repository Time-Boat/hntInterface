<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>气泡间距系数</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="t_QPJJXSController.do?save">
			<input id="id" name="id" type="hidden" value="${t_QPJJXSPage.id }">
			<input id="syjid" name="syjid" type="hidden"  value="${t_QPJJXSPage.syjid}">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							试验日期:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="syrq" name="syrq" ignore="ignore"
							   value="${t_QPJJXSPage.syrq}">
						
					</td>
					<td align="right">
						<label class="Validform_label">
							样本编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ybbh" name="ybbh" ignore="ignore"
							   value="${t_QPJJXSPage.ybbh}">
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							试验编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sybh" name="sybh" ignore="ignore"
							   value="${t_QPJJXSPage.sybh}">
						
					</td>
					<td align="right">
						<label class="Validform_label">
							试验人员:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="syry" name="syry" ignore="ignore"
							   value="${t_QPJJXSPage.syry}">
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							灰度阀值:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="hdfz" name="hdfz" ignore="ignore"
							   value="${t_QPJJXSPage.hdfz}">
						
					</td>
					<td class="value">
					</td>
					<td class="value">
					</td>
				</tr>
				<tr>
					<td align="right">
					</td>
					<td class="value" align="center">
						<label class="Validform_label">
							1
						</label>
					</td>
					<td class="value" align="center">
						<label class="Validform_label">
							2
						</label>
					</td>
					<td class="value" align="center">
						<label class="Validform_label">
							3
						</label>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							气泡个数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="qpgs1" name="qpgs1" ignore="ignore"
							   value="${t_QPJJXSPage.qpgs1}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="qpgs2" name="qpgs2" ignore="ignore"
							   value="${t_QPJJXSPage.qpgs2}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="qpgs3" name="qpgs3" ignore="ignore"
							   value="${t_QPJJXSPage.qpgs3}">
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							气泡总量百分比:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="zzlbfb1" name="zzlbfb1" ignore="ignore"
							   value="${t_QPJJXSPage.zzlbfb1}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="zzlbfb2" name="zzlbfb2" ignore="ignore"
							   value="${t_QPJJXSPage.zzlbfb2}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="zzlbfb3" name="zzlbfb3" ignore="ignore"
							   value="${t_QPJJXSPage.zzlbfb3}">
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							气泡总长:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="qpzc1" name="qpzc1" ignore="ignore"
							   value="${t_QPJJXSPage.qpzc1}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="qpzc2" name="qpzc2" ignore="ignore"
							   value="${t_QPJJXSPage.qpzc2}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="qpzc3" name="qpzc3" ignore="ignore"
							   value="${t_QPJJXSPage.qpzc3}">
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							气泡总长百分比:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="zzcbfb1" name="zzcbfb1" ignore="ignore"
							   value="${t_QPJJXSPage.zzcbfb1}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="zzcbfb2" name="zzcbfb2" ignore="ignore"
							   value="${t_QPJJXSPage.zzcbfb2}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="zzcbfb3" name="zzcbfb3" ignore="ignore"
							   value="${t_QPJJXSPage.zzcbfb3}">
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							空气含量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="kqhl1" name="kqhl1" ignore="ignore"
							   value="${t_QPJJXSPage.kqhl1}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="kqhl2" name="kqhl2" ignore="ignore"
							   value="${t_QPJJXSPage.kqhl2}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="kqhl3" name="kqhl3" ignore="ignore"
							   value="${t_QPJJXSPage.kqhl3}">
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							平均弦长:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pjxc1" name="pjxc1" ignore="ignore"
							   value="${t_QPJJXSPage.pjxc1}">
						
					</td>

					<td class="value">
						<input class="inputxt" id="pjxc2" name="pjxc2" ignore="ignore"
							   value="${t_QPJJXSPage.pjxc2}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="pjxc3" name="pjxc3" ignore="ignore"
							   value="${t_QPJJXSPage.pjxc3}">
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							浆气比:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jqb1" name="jqb1" ignore="ignore"
							   value="${t_QPJJXSPage.jqb1}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="jqb2" name="jqb2" ignore="ignore"
							   value="${t_QPJJXSPage.jqb2}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="jqb3" name="jqb3" ignore="ignore"
							   value="${t_QPJJXSPage.jqb3}">
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							表面面积:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="bbmj1" name="bbmj1" ignore="ignore"
							   value="${t_QPJJXSPage.bbmj1}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="bbmj2" name="bbmj2" ignore="ignore"
							   value="${t_QPJJXSPage.bbmj2}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="bbmj3" name="bbmj3" ignore="ignore"
							   value="${t_QPJJXSPage.bbmj3}">
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							孔隙率:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="kxl1" name="kxl1" ignore="ignore"
							   value="${t_QPJJXSPage.kxl1}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="kxl2" name="kxl2" ignore="ignore"
							   value="${t_QPJJXSPage.kxl2}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="kxl3" name="kxl3" ignore="ignore"
							   value="${t_QPJJXSPage.kxl3}">
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							间距系数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jjxs1" name="jjxs1" ignore="ignore"
							   value="${t_QPJJXSPage.jjxs1}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="jjxs2" name="jjxs2" ignore="ignore"
							   value="${t_QPJJXSPage.jjxs2}">
						
					</td>
					<td class="value">
						<input class="inputxt" id="jjxs3" name="jjxs3" ignore="ignore"
							   value="${t_QPJJXSPage.jjxs3}">
						
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>