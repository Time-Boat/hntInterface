<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>压力机</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="v_YalijiController.do?save">
			<input id="id" name="id" type="hidden" value="${v_YalijiPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							caijizizengjiaid:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="caijizizengjiaid" name="caijizizengjiaid" 
							   value="${v_YalijiPage.caijizizengjiaid}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							syjid:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="syjid" name="syjid" 
							   value="${v_YalijiPage.syjid}" datatype="*">
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
							   value="${v_YalijiPage.sbbh}">
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
							   value="${v_YalijiPage.sylx}">
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
							   value="${v_YalijiPage.wtbh}">
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
							   value="${v_YalijiPage.sjbh}">
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
							   value="${v_YalijiPage.zzrq}">
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
							   value="${v_YalijiPage.syrq}">
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
							   value="${v_YalijiPage.sywcsj}">
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
							   value="${v_YalijiPage.sjscsj}">
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
							   value="${v_YalijiPage.lq}" datatype="n">
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
							   value="${v_YalijiPage.sjcc}">
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
							   value="${v_YalijiPage.sjmj}">
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
							   value="${v_YalijiPage.sjsl}">
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
							   value="${v_YalijiPage.sjqd}">
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
							   value="${v_YalijiPage.zsxs}">
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
							   value="${v_YalijiPage.qddbz}">
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
							   value="${v_YalijiPage.pdjg}">
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
							   value="${v_YalijiPage.czry}">
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
							   value="${v_YalijiPage.cjmc}">
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
							   value="${v_YalijiPage.pzbm}">
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
							   value="${v_YalijiPage.gczj}">
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
							   value="${v_YalijiPage.area}">
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
							   value="${v_YalijiPage.iswjj}" datatype="n">
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
							   value="${v_YalijiPage.rtcode}">
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
							   value="${v_YalijiPage.szfw}">
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
							   value="${v_YalijiPage.fbl}">
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
							   value="${v_YalijiPage.status}" datatype="n">
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
							   value="${v_YalijiPage.wtzs}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							fGuid:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fGuid" name="fGuid" 
							   value="${v_YalijiPage.fGuid}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sjxh:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sjxh" name="sjxh" ignore="ignore"
							   value="${v_YalijiPage.sjxh}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							zzjj:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="zzjj" name="zzjj" ignore="ignore"
							   value="${v_YalijiPage.zzjj}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							kylz:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="kylz" name="kylz" ignore="ignore"
							   value="${v_YalijiPage.kylz}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							kyqd:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="kyqd" name="kyqd" ignore="ignore"
							   value="${v_YalijiPage.kyqd}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sysj:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sysj" name="sysj" ignore="ignore"
							   value="${v_YalijiPage.sysj}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							wcsj:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="wcsj" name="wcsj" ignore="ignore"
							   value="${v_YalijiPage.wcsj}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							yskylz:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="yskylz" name="yskylz" ignore="ignore"
							   value="${v_YalijiPage.yskylz}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sjgc:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sjgc" name="sjgc" ignore="ignore"
							   value="${v_YalijiPage.sjgc}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							ystatus:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ystatus" name="ystatus" ignore="ignore"
							   value="${v_YalijiPage.ystatus}" datatype="n">
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
							   value="${v_YalijiPage.recGuid}">
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
							   value="${v_YalijiPage.testname}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shebeiname:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shebeiname" name="shebeiname" ignore="ignore"
							   value="${v_YalijiPage.shebeiname}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shebeijiancheng:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shebeijiancheng" name="shebeijiancheng" ignore="ignore"
							   value="${v_YalijiPage.shebeijiancheng}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							fTrname:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fTrname" name="fTrname" ignore="ignore"
							   value="${v_YalijiPage.fTrname}">
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
							   value="${v_YalijiPage.lft}" datatype="n">
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
							   value="${v_YalijiPage.rgt}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shebeibianhao:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shebeibianhao" name="shebeibianhao" ignore="ignore"
							   value="${v_YalijiPage.shebeibianhao}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>