<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>混凝土超标视图</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="hunnintuchaobiaoViewController.do?save">
			<input id="id" name="id" type="hidden" value="${hunnintuchaobiaoViewPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							gongdanhao:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
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
							   value="${hunnintuchaobiaoViewPage.chaozuozhe}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sha1Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sha1Shijizhi" name="sha1Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.sha1Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shi1Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shi1Shijizhi" name="shi1Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.shi1Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shi2Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shi2Shijizhi" name="shi2Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.shi2Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sha2Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sha2Shijizhi" name="sha2Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.sha2Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							guliao5Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="guliao5Shijizhi" name="guliao5Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.guliao5Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shuini1Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shuini1Shijizhi" name="shuini1Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.shuini1Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shuini2Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shuini2Shijizhi" name="shuini2Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.shuini2Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							kuangfen3Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="kuangfen3Shijizhi" name="kuangfen3Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.kuangfen3Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							feimeihui4Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="feimeihui4Shijizhi" name="feimeihui4Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.feimeihui4Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							fenliao5Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fenliao5Shijizhi" name="fenliao5Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.fenliao5Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							fenliao6Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fenliao6Shijizhi" name="fenliao6Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.fenliao6Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shui1Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shui1Shijizhi" name="shui1Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.shui1Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shui2Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shui2Shijizhi" name="shui2Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.shui2Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							waijiaji1Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji1Shijizhi" name="waijiaji1Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.waijiaji1Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							waijiaji2Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji2Shijizhi" name="waijiaji2Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.waijiaji2Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							waijiaji3Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji3Shijizhi" name="waijiaji3Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.waijiaji3Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							waijiaji4Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji4Shijizhi" name="waijiaji4Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.waijiaji4Shijizhi}">
						<span class="Validform_checktip"></span>
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
							   value="${hunnintuchaobiaoViewPage.chuliaoshijian}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sha1Lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sha1Lilunzhi" name="sha1Lilunzhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.sha1Lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shi1Lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shi1Lilunzhi" name="shi1Lilunzhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.shi1Lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shi2Lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shi2Lilunzhi" name="shi2Lilunzhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.shi2Lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sha2Lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sha2Lilunzhi" name="sha2Lilunzhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.sha2Lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							guliao5Lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="guliao5Lilunzhi" name="guliao5Lilunzhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.guliao5Lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shuini1Lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shuini1Lilunzhi" name="shuini1Lilunzhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.shuini1Lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shuini2Lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shuini2Lilunzhi" name="shuini2Lilunzhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.shuini2Lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							kuangfen3Lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="kuangfen3Lilunzhi" name="kuangfen3Lilunzhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.kuangfen3Lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							feimeihui4Lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="feimeihui4Lilunzhi" name="feimeihui4Lilunzhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.feimeihui4Lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							fenliao5Lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fenliao5Lilunzhi" name="fenliao5Lilunzhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.fenliao5Lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							fenliao6Lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fenliao6Lilunzhi" name="fenliao6Lilunzhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.fenliao6Lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shui1Lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shui1Lilunzhi" name="shui1Lilunzhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.shui1Lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shui2Lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shui2Lilunzhi" name="shui2Lilunzhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.shui2Lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							waijiaji1Lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji1Lilunzhi" name="waijiaji1Lilunzhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.waijiaji1Lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							waijiaji2Lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji2Lilunzhi" name="waijiaji2Lilunzhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.waijiaji2Lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							waijiaji3Lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji3Lilunzhi" name="waijiaji3Lilunzhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.waijiaji3Lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							waijiaji4Lilunzhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji4Lilunzhi" name="waijiaji4Lilunzhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.waijiaji4Lilunzhi}">
						<span class="Validform_checktip"></span>
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
							   value="${hunnintuchaobiaoViewPage.gongchengmingcheng}">
						<span class="Validform_checktip"></span>
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
							   value="${hunnintuchaobiaoViewPage.sigongdidian}">
						<span class="Validform_checktip"></span>
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
							   value="${hunnintuchaobiaoViewPage.jiaozuobuwei}">
						<span class="Validform_checktip"></span>
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
							   value="${hunnintuchaobiaoViewPage.shuinipingzhong}">
						<span class="Validform_checktip"></span>
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
							   value="${hunnintuchaobiaoViewPage.waijiajipingzhong}">
						<span class="Validform_checktip"></span>
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
							   value="${hunnintuchaobiaoViewPage.peifanghao}">
						<span class="Validform_checktip"></span>
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
							   value="${hunnintuchaobiaoViewPage.qiangdudengji}">
						<span class="Validform_checktip"></span>
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
							   value="${hunnintuchaobiaoViewPage.jiaobanshijian}">
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
							   value="${hunnintuchaobiaoViewPage.shebeibianhao}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							baocunshijian:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="baocunshijian" name="baocunshijian" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.baocunshijian}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							kehuduanbianhao:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="kehuduanbianhao" name="kehuduanbianhao" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.kehuduanbianhao}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							biaoshi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="biaoshi" name="biaoshi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.biaoshi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							caijishijian:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="caijishijian" name="caijishijian" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.caijishijian}">
						<span class="Validform_checktip"></span>
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
							   value="${hunnintuchaobiaoViewPage.gujifangshu}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							yuanchuliaoshijian:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="yuanchuliaoshijian" name="yuanchuliaoshijian" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.yuanchuliaoshijian}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							caijiyanshi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="caijiyanshi" name="caijiyanshi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.caijiyanshi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shangchuanyanshi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shangchuanyanshi" name="shangchuanyanshi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.shangchuanyanshi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							changstate:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="changstate" name="changstate" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.changstate}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							glw1:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="glw1" name="glw1" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.glw1}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							glw2:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="glw2" name="glw2" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.glw2}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							glw3:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="glw3" name="glw3" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.glw3}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							glw4:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="glw4" name="glw4" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.glw4}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							glw5:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="glw5" name="glw5" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.glw5}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							flw1:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="flw1" name="flw1" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.flw1}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							flw2:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="flw2" name="flw2" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.flw2}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							flw3:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="flw3" name="flw3" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.flw3}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							flw4:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="flw4" name="flw4" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.flw4}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							flw5:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="flw5" name="flw5" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.flw5}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							flw6:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="flw6" name="flw6" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.flw6}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shw1:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shw1" name="shw1" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.shw1}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shw2:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shw2" name="shw2" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.shw2}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							wjw1:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="wjw1" name="wjw1" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.wjw1}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							wjw2:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="wjw2" name="wjw2" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.wjw2}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							wjw3:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="wjw3" name="wjw3" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.wjw3}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							wjw4:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="wjw4" name="wjw4" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.wjw4}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							glper1:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="glper1" name="glper1" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.glper1}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							glper2:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="glper2" name="glper2" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.glper2}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							glper3:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="glper3" name="glper3" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.glper3}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							glper4:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="glper4" name="glper4" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.glper4}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							glper5:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="glper5" name="glper5" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.glper5}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							flper1:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="flper1" name="flper1" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.flper1}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							flper2:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="flper2" name="flper2" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.flper2}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							flper3:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="flper3" name="flper3" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.flper3}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							flper4:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="flper4" name="flper4" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.flper4}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							flper5:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="flper5" name="flper5" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.flper5}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							flper6:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="flper6" name="flper6" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.flper6}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shper1:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shper1" name="shper1" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.shper1}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							shper2:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shper2" name="shper2" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.shper2}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							wjper1:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="wjper1" name="wjper1" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.wjper1}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							wjper2:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="wjper2" name="wjper2" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.wjper2}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							wjper3:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="wjper3" name="wjper3" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.wjper3}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							wjper4:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="wjper4" name="wjper4" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.wjper4}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							departid:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="departid" name="departid" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.departid}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							banhezhanminchen:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="banhezhanminchen" name="banhezhanminchen" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.banhezhanminchen}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							panshu:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="panshu" name="panshu" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.panshu}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							smsbaojin:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="smsbaojin" name="smsbaojin" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.smsbaojin}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							smstype:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="smstype" name="smstype" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.smstype}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sendtype:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sendtype" name="sendtype" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.sendtype}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							ambegin:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ambegin" name="ambegin" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.ambegin}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							amend:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="amend" name="amend" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.amend}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							pmbegin:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pmbegin" name="pmbegin" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.pmbegin}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							pmend:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pmend" name="pmend" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.pmend}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							smssettype:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="smssettype" name="smssettype" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.smssettype}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							jianchen:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jianchen" name="jianchen" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.jianchen}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							jieguobianhao:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jieguobianhao" name="jieguobianhao" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.jieguobianhao}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cbjiaobanshijian:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cbjiaobanshijian" name="cbjiaobanshijian" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.cbjiaobanshijian}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cbsha1Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cbsha1Shijizhi" name="cbsha1Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.cbsha1Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cbshi1Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cbshi1Shijizhi" name="cbshi1Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.cbshi1Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cbshi2Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cbshi2Shijizhi" name="cbshi2Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.cbshi2Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cbsha2Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cbsha2Shijizhi" name="cbsha2Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.cbsha2Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cbguliao5Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cbguliao5Shijizhi" name="cbguliao5Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.cbguliao5Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cbshuini1Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cbshuini1Shijizhi" name="cbshuini1Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.cbshuini1Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cbshuini2Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cbshuini2Shijizhi" name="cbshuini2Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.cbshuini2Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cbkuangfen3Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cbkuangfen3Shijizhi" name="cbkuangfen3Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.cbkuangfen3Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cbfeimeihui4Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cbfeimeihui4Shijizhi" name="cbfeimeihui4Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.cbfeimeihui4Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cbfenliao5Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cbfenliao5Shijizhi" name="cbfenliao5Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.cbfenliao5Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cbfenliao6Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cbfenliao6Shijizhi" name="cbfenliao6Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.cbfenliao6Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cbshui1Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cbshui1Shijizhi" name="cbshui1Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.cbshui1Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cbshui2Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cbshui2Shijizhi" name="cbshui2Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.cbshui2Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cbwaijiaji1Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cbwaijiaji1Shijizhi" name="cbwaijiaji1Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.cbwaijiaji1Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cbwaijiaji2Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cbwaijiaji2Shijizhi" name="cbwaijiaji2Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.cbwaijiaji2Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cbwaijiaji3Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cbwaijiaji3Shijizhi" name="cbwaijiaji3Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.cbwaijiaji3Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cbwaijiaji4Shijizhi:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cbwaijiaji4Shijizhi" name="cbwaijiaji4Shijizhi" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.cbwaijiaji4Shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							leixing:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="leixing" name="leixing" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.leixing}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							filepath:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="filepath" name="filepath" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.filepath}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							chulijieguo:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="chulijieguo" name="chulijieguo" ignore="ignore"
							   value="${hunnintuchaobiaoViewPage.chulijieguo}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>