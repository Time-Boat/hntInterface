<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>水泥混凝土字段及报警配置</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="hntbhzziduancfgViewController.do?save">
			<input id="id" name="id" type="hidden" value="${hntbhzziduancfgPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<input type="hidden" value="${hntcfg.id}" name="hntcfg.id"/>
				<input type="hidden" value="${hntisshowcfg.id}" name="hntisshowcfg.id"/>
				<tr>
					<td align="right">拌和机</td>
					<td class="value">
						<c:if test="${defaultId==1}"><%--默认 --%>
							<input type="hidden"  name="hntcfg.gprsbianhao" value="${hntcfg.gprsbianhao}"/>
							<input type="hidden"  name="hntcfg.leixin" value="100"/>
							<input type="hidden"  name="hntisshowcfg.leixin" value="101"/>
						</c:if>
						<c:if test="${defaultId==0 }"><%--非默认 --%>
							<input type="hidden"  name="hntcfg.leixin" value="1"/>
							<input type="hidden"  name="hntisshowcfg.leixin" value="2"/>
		    
							<select id="hntcfg.gprsbianhao" name="hntcfg.gprsbianhao" datatype="*" errormsg="该字段不为空">
							<option value="">--请选择拌和机--</option>
							<c:forEach var="a" items="${banhezhanxinxiList}">
								<option value="${a.gprsbianhao }" <c:if test="${hntcfg.gprsbianhao==a.gprsbianhao }">selected='selected'</c:if>>${a.banhezhanminchen }</option>
							</c:forEach>
							</select>
							<span id="Validform_gprsbianhao" class="Validform_checktip"><font color=red>必选*</font></span>
						</c:if>
					</td>
					<td>是否显示在查询界面</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							baocunshijian:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="baocunshijian" name="baocunshijian" ignore="ignore"
							   value="${hntcfg.baocunshijian}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.baocunshijian" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.baocunshijian=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.baocunshijian" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.baocunshijian=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							chaozuozhe:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="chaozuozhe" name="chaozuozhe" ignore="ignore"
							   value="${hntcfg.chaozuozhe}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.chaozuozhe" id="smsbaojin11" value="0" <c:if test="${hntisshowcfg.chaozuozhe=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.chaozuozhe" id="smsbaojin21" value="1" <c:if test="${hntisshowcfg.chaozuozhe=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>

				<tr>
					<td align="right">
						<label class="Validform_label">
							chuliaoshijian:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="chuliaoshijian" name="chuliaoshijian" ignore="ignore"
							   value="${hntcfg.chuliaoshijian}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.chuliaoshijian" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.chuliaoshijian=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.chuliaoshijian" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.chuliaoshijian=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							feimeihui4_lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="feimeihui4_lilunzhi" name="feimeihui4_lilunzhi" ignore="ignore"
							   value="${hntcfg.feimeihui4_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.feimeihui4_lilunzhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.feimeihui4_lilunzhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.feimeihui4_lilunzhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.feimeihui4_lilunzhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							feimeihui4_shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="feimeihui4_shijizhi" name="feimeihui4_shijizhi" ignore="ignore"
							   value="${hntcfg.feimeihui4_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.feimeihui4_shijizhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.feimeihui4_shijizhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.feimeihui4_shijizhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.feimeihui4_shijizhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							fenliao5_lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fenliao5_lilunzhi" name="fenliao5_lilunzhi" ignore="ignore"
							   value="${hntcfg.fenliao5_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.fenliao5_lilunzhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.fenliao5_lilunzhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.fenliao5_lilunzhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.fenliao5_lilunzhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							fenliao5_shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fenliao5_shijizhi" name="fenliao5_shijizhi" ignore="ignore"
							   value="${hntcfg.fenliao5_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.fenliao5_shijizhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.fenliao5_shijizhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.fenliao5_shijizhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.fenliao5_shijizhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							fenliao6_lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fenliao6_lilunzhi" name="fenliao6_lilunzhi" ignore="ignore"
							   value="${hntcfg.fenliao6_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.fenliao6_lilunzhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.fenliao6_lilunzhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.fenliao6_lilunzhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.fenliao6_lilunzhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							fenliao6_shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fenliao6_shijizhi" name="fenliao6_shijizhi" ignore="ignore"
							   value="${hntcfg.fenliao6_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.fenliao6_shijizhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.fenliao6_shijizhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.fenliao6_shijizhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.fenliao6_shijizhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							gongchengmingcheng:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gongchengmingcheng" name="gongchengmingcheng" ignore="ignore"
							   value="${hntcfg.gongchengmingcheng}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.gongchengmingcheng" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.gongchengmingcheng=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.gongchengmingcheng" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.gongchengmingcheng=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							gongdanhao:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${hntcfg.gongdanhao}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.gongdanhao" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.gongdanhao=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.gongdanhao" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.gongdanhao=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<%--
				<tr>
					<td align="right">
						<label class="Validform_label">
							gprsbianhao:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gprsbianhao" name="gprsbianhao" ignore="ignore"
							   value="${hntcfg.gprsbianhao}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.gprsbianhao" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.gprsbianhao=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.gprsbianhao" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.gprsbianhao=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				 --%>
				<tr>
					<td align="right">
						<label class="Validform_label">
							guliao5_lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="guliao5_lilunzhi" name="guliao5_lilunzhi" ignore="ignore"
							   value="${hntcfg.guliao5_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.guliao5_lilunzhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.guliao5_lilunzhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.guliao5_lilunzhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.guliao5_lilunzhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							guliao5_shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="guliao5_shijizhi" name="guliao5_shijizhi" ignore="ignore"
							   value="${hntcfg.guliao5_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.guliao5_shijizhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.guliao5_shijizhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.guliao5_shijizhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.guliao5_shijizhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							jiaobanshijian:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jiaobanshijian" name="jiaobanshijian" ignore="ignore"
							   value="${hntcfg.jiaobanshijian}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.jiaobanshijian" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.jiaobanshijian=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.jiaobanshijian" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.jiaobanshijian=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							jiaozuobuwei:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jiaozuobuwei" name="jiaozuobuwei" ignore="ignore"
							   value="${hntcfg.jiaozuobuwei}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.jiaozuobuwei" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.jiaozuobuwei=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.jiaozuobuwei" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.jiaozuobuwei=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							kuangfen3_lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="kuangfen3_lilunzhi" name="kuangfen3_lilunzhi" ignore="ignore"
							   value="${hntcfg.kuangfen3_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.kuangfen3_lilunzhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.kuangfen3_lilunzhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.kuangfen3_lilunzhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.kuangfen3_lilunzhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							kuangfen3_shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="kuangfen3_shijizhi" name="kuangfen3_shijizhi" ignore="ignore"
							   value="${hntcfg.kuangfen3_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.kuangfen3_shijizhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.kuangfen3_shijizhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.kuangfen3_shijizhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.kuangfen3_shijizhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							peifanghao:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="peifanghao" name="peifanghao" ignore="ignore"
							   value="${hntcfg.peifanghao}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.peifanghao" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.peifanghao=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.peifanghao" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.peifanghao=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							qiangdudengji:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="qiangdudengji" name="qiangdudengji" ignore="ignore"
							   value="${hntcfg.qiangdudengji}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.qiangdudengji" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.qiangdudengji=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.qiangdudengji" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.qiangdudengji=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sha1_lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sha1_lilunzhi" name="sha1_lilunzhi" ignore="ignore"
							   value="${hntcfg.sha1_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.sha1_lilunzhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.sha1_lilunzhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.sha1_lilunzhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.sha1_lilunzhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sha1_shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sha1_shijizhi" name="sha1_shijizhi" ignore="ignore"
							   value="${hntcfg.sha1_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.sha1_shijizhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.sha1_shijizhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.sha1_shijizhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.sha1_shijizhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sha2_lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sha2_lilunzhi" name="sha2_lilunzhi" ignore="ignore"
							   value="${hntcfg.sha2_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.sha2_lilunzhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.sha2_lilunzhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.sha2_lilunzhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.sha2_lilunzhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sha2_shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sha2_shijizhi" name="sha2_shijizhi" ignore="ignore"
							   value="${hntcfg.sha2_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.sha2_shijizhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.sha2_shijizhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.sha2_shijizhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.sha2_shijizhi=='1'}">checked="checked"</c:if>/>
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
							   value="${hntcfg.shebeibianhao}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.shebeibianhao" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.shebeibianhao=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.shebeibianhao" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.shebeibianhao=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shi1_lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shi1_lilunzhi" name="shi1_lilunzhi" ignore="ignore"
							   value="${hntcfg.shi1_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.shi1_lilunzhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.shi1_lilunzhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.shi1_lilunzhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.shi1_lilunzhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shi1_shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shi1_shijizhi" name="shi1_shijizhi" ignore="ignore"
							   value="${hntcfg.shi1_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.shi1_shijizhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.shi1_shijizhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.shi1_shijizhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.shi1_shijizhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shi2_lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shi2_lilunzhi" name="shi2_lilunzhi" ignore="ignore"
							   value="${hntcfg.shi2_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.shi2_lilunzhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.shi2_lilunzhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.shi2_lilunzhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.shi2_lilunzhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shi2_shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shi2_shijizhi" name="shi2_shijizhi" ignore="ignore"
							   value="${hntcfg.shi2_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.shi2_shijizhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.shi2_shijizhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.shi2_shijizhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.shi2_shijizhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shui1_lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shui1_lilunzhi" name="shui1_lilunzhi" ignore="ignore"
							   value="${hntcfg.shui1_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.shui1_lilunzhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.shui1_lilunzhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.shui1_lilunzhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.shui1_lilunzhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shui1_shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shui1_shijizhi" name="shui1_shijizhi" ignore="ignore"
							   value="${hntcfg.shui1_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.shui1_shijizhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.shui1_shijizhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.shui1_shijizhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.shui1_shijizhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shui2_lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shui2_lilunzhi" name="shui2_lilunzhi" ignore="ignore"
							   value="${hntcfg.shui2_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.shui2_lilunzhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.shui2_lilunzhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.shui2_lilunzhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.shui2_lilunzhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shui2_shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shui2_shijizhi" name="shui2_shijizhi" ignore="ignore"
							   value="${hntcfg.shui2_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.shui2_shijizhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.shui2_shijizhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.shui2_shijizhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.shui2_shijizhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shuini1_lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shuini1_lilunzhi" name="shuini1_lilunzhi" ignore="ignore"
							   value="${hntcfg.shuini1_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.shuini1_lilunzhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.shuini1_lilunzhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.shuini1_lilunzhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.shuini1_lilunzhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shuini1_shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shuini1_shijizhi" name="shuini1_shijizhi" ignore="ignore"
							   value="${hntcfg.shuini1_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.shuini1_shijizhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.shuini1_shijizhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.shuini1_shijizhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.shuini1_shijizhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shuini2_lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shuini2_lilunzhi" name="shuini2_lilunzhi" ignore="ignore"
							   value="${hntcfg.shuini2_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.shuini2_lilunzhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.shuini2_lilunzhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.shuini2_lilunzhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.shuini2_lilunzhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shuini2_shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shuini2_shijizhi" name="shuini2_shijizhi" ignore="ignore"
							   value="${hntcfg.shuini2_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.shuini2_shijizhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.shuini2_shijizhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.shuini2_shijizhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.shuini2_shijizhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shuinipingzhong:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shuinipingzhong" name="shuinipingzhong" ignore="ignore"
							   value="${hntcfg.shuinipingzhong}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.shuinipingzhong" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.shuinipingzhong=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.shuinipingzhong" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.shuinipingzhong=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sigongdidian:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sigongdidian" name="sigongdidian" ignore="ignore"
							   value="${hntcfg.sigongdidian}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.sigongdidian" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.sigongdidian=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.sigongdidian" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.sigongdidian=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							waijiaji1_lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji1_lilunzhi" name="waijiaji1_lilunzhi" ignore="ignore"
							   value="${hntcfg.waijiaji1_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.waijiaji1_lilunzhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.waijiaji1_lilunzhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.waijiaji1_lilunzhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.waijiaji1_lilunzhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							waijiaji1_shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji1_shijizhi" name="waijiaji1_shijizhi" ignore="ignore"
							   value="${hntcfg.waijiaji1_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.waijiaji1_shijizhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.waijiaji1_shijizhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.waijiaji1_shijizhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.waijiaji1_shijizhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							waijiaji2_lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji2_lilunzhi" name="waijiaji2_lilunzhi" ignore="ignore"
							   value="${hntcfg.waijiaji2_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.waijiaji2_lilunzhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.waijiaji2_lilunzhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.waijiaji2_lilunzhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.waijiaji2_lilunzhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							waijiaji2_shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji2_shijizhi" name="waijiaji2_shijizhi" ignore="ignore"
							   value="${hntcfg.waijiaji2_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.waijiaji2_shijizhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.waijiaji2_shijizhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.waijiaji2_shijizhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.waijiaji2_shijizhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							waijiaji3_lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji3_lilunzhi" name="waijiaji3_lilunzhi" ignore="ignore"
							   value="${hntcfg.waijiaji3_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.waijiaji3_lilunzhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.waijiaji3_lilunzhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.waijiaji3_lilunzhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.waijiaji3_lilunzhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							waijiaji3_shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji3_shijizhi" name="waijiaji3_shijizhi" ignore="ignore"
							   value="${hntcfg.waijiaji3_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.waijiaji3_shijizhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.waijiaji3_shijizhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.waijiaji3_shijizhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.waijiaji3_shijizhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							waijiaji4_lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji4_lilunzhi" name="waijiaji4_lilunzhi" ignore="ignore"
							   value="${hntcfg.waijiaji4_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.waijiaji4_lilunzhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.waijiaji4_lilunzhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.waijiaji4_lilunzhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.waijiaji4_lilunzhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							waijiaji4_shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji4_shijizhi" name="waijiaji4_shijizhi" ignore="ignore"
							   value="${hntcfg.waijiaji4_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.waijiaji4_shijizhi" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.waijiaji4_shijizhi=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.waijiaji4_shijizhi" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.waijiaji4_shijizhi=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							waijiajipingzhong:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiajipingzhong" name="waijiajipingzhong" ignore="ignore"
							   value="${hntcfg.waijiajipingzhong}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.waijiajipingzhong" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.waijiajipingzhong=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.waijiajipingzhong" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.waijiajipingzhong=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<%--
				<tr>
					<td align="right">
						<label class="Validform_label">
							leixin:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="leixin" name="leixin" ignore="ignore"
							   value="${hntcfg.leixin}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.leixin" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.leixin=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.leixin" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.leixin=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				 --%>
				<tr>
					<td align="right">
						<label class="Validform_label">
							caijishijian:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="caijishijian" name="caijishijian" ignore="ignore"
							   value="${hntcfg.caijishijian}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.caijishijian" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.caijishijian=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.caijishijian" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.caijishijian=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							gujifangshu:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gujifangshu" name="gujifangshu" ignore="ignore"
							   value="${hntcfg.gujifangshu}">
						<span class="Validform_checktip"></span>
					</td>
					<td class="value">
						不显示<input type="radio" name="hntisshowcfg.gujifangshu" id="smsbaojin1" value="0" <c:if test="${hntisshowcfg.gujifangshu=='0'}">checked="checked"</c:if>/>
						显示<input type="radio" name="hntisshowcfg.gujifangshu" id="smsbaojin2" value="1" <c:if test="${hntisshowcfg.gujifangshu=='1'}">checked="checked"</c:if>/>
					</td>
				</tr>
				 
			</table>
		</t:formvalid>
 </body>