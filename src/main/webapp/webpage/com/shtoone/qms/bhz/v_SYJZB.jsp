<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>试验主表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="v_SYJZBController.do?save">
			<input id="id" name="id" type="hidden" value="${v_SYJZBPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							syjid:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="syjid" name="syjid" 
							   value="${v_SYJZBNPage.syjid}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sbbh:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sbbh" name="sbbh" ignore="ignore"
							   value="${v_SYJZBNPage.sbbh}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sylx:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sylx" name="sylx" ignore="ignore"
							   value="${v_SYJZBNPage.sylx}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							wtbh:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="wtbh" name="wtbh" ignore="ignore"
							   value="${v_SYJZBNPage.wtbh}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sjbh:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sjbh" name="sjbh" ignore="ignore"
							   value="${v_SYJZBNPage.sjbh}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							zzrq:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="zzrq" name="zzrq" ignore="ignore"
							   value="${v_SYJZBNPage.zzrq}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							syrq:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="syrq" name="syrq" ignore="ignore"
							   value="${v_SYJZBNPage.syrq}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sywcsj:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sywcsj" name="sywcsj" ignore="ignore"
							   value="${v_SYJZBNPage.sywcsj}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sjscsj:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sjscsj" name="sjscsj" ignore="ignore"
							   value="${v_SYJZBNPage.sjscsj}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							lq:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="lq" name="lq" ignore="ignore"
							   value="${v_SYJZBNPage.lq}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sjcc:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sjcc" name="sjcc" ignore="ignore"
							   value="${v_SYJZBNPage.sjcc}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sjmj:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sjmj" name="sjmj" ignore="ignore"
							   value="${v_SYJZBNPage.sjmj}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sjsl:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sjsl" name="sjsl" ignore="ignore"
							   value="${v_SYJZBNPage.sjsl}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sjqd:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sjqd" name="sjqd" ignore="ignore"
							   value="${v_SYJZBNPage.sjqd}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							zsxs:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="zsxs" name="zsxs" ignore="ignore"
							   value="${v_SYJZBNPage.zsxs}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							qddbz:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="qddbz" name="qddbz" ignore="ignore"
							   value="${v_SYJZBNPage.qddbz}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							pdjg:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pdjg" name="pdjg" ignore="ignore"
							   value="${v_SYJZBNPage.pdjg}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							czry:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="czry" name="czry" ignore="ignore"
							   value="${v_SYJZBNPage.czry}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cjmc:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cjmc" name="cjmc" ignore="ignore"
							   value="${v_SYJZBNPage.cjmc}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							pzbm:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pzbm" name="pzbm" ignore="ignore"
							   value="${v_SYJZBNPage.pzbm}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							gczj:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gczj" name="gczj" ignore="ignore"
							   value="${v_SYJZBNPage.gczj}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							area:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="area" name="area" ignore="ignore"
							   value="${v_SYJZBNPage.area}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							iswjj:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="iswjj" name="iswjj" ignore="ignore"
							   value="${v_SYJZBNPage.iswjj}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							rtcode:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="rtcode" name="rtcode" ignore="ignore"
							   value="${v_SYJZBNPage.rtcode}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							szfw:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="szfw" name="szfw" ignore="ignore"
							   value="${v_SYJZBNPage.szfw}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							fbl:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fbl" name="fbl" ignore="ignore"
							   value="${v_SYJZBNPage.fbl}">
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
							   value="${v_SYJZBNPage.status}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							wtzs:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="wtzs" name="wtzs" ignore="ignore"
							   value="${v_SYJZBNPage.wtzs}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							testname:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="testname" name="testname" ignore="ignore"
							   value="${v_SYJZBNPage.testname}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							recGuid:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="recGuid" name="recGuid" ignore="ignore"
							   value="${v_SYJZBNPage.recGuid}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							lft:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="lft" name="lft" ignore="ignore"
							   value="${v_SYJZBNPage.lft}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							rgt:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="rgt" name="rgt" ignore="ignore"
							   value="${v_SYJZBNPage.rgt}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							departname:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="departname" name="departname" 
							   value="${v_SYJZBNPage.departname}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							leixin:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="leixin" name="leixin" ignore="ignore"
							   value="${v_SYJZBNPage.leixin}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							parentdepartid:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="parentdepartid" name="parentdepartid" ignore="ignore"
							   value="${v_SYJZBNPage.parentdepartid}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							departorderid:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="departorderid" name="departorderid" ignore="ignore"
							   value="${v_SYJZBNPage.departorderid}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>