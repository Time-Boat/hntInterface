<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>最大一笔详细信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="hntxiangxixxmaxController.do?save">
			<input id="id" name="id" type="hidden" value="${hntxiangxixxmaxPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							gongdanhao:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${hntxiangxixxmaxPage.gongdanhao}">
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
							   value="${hntxiangxixxmaxPage.chaozuozhe}">
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
							   value="${hntxiangxixxmaxPage.sha1Shijizhi}">
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
							   value="${hntxiangxixxmaxPage.shi1Shijizhi}">
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
							   value="${hntxiangxixxmaxPage.shi2Shijizhi}">
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
							   value="${hntxiangxixxmaxPage.sha2Shijizhi}">
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
							   value="${hntxiangxixxmaxPage.guliao5Shijizhi}">
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
							   value="${hntxiangxixxmaxPage.shuini1Shijizhi}">
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
							   value="${hntxiangxixxmaxPage.shuini2Shijizhi}">
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
							   value="${hntxiangxixxmaxPage.kuangfen3Shijizhi}">
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
							   value="${hntxiangxixxmaxPage.feimeihui4Shijizhi}">
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
							   value="${hntxiangxixxmaxPage.fenliao5Shijizhi}">
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
							   value="${hntxiangxixxmaxPage.fenliao6Shijizhi}">
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
							   value="${hntxiangxixxmaxPage.shui1Shijizhi}">
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
							   value="${hntxiangxixxmaxPage.shui2Shijizhi}">
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
							   value="${hntxiangxixxmaxPage.waijiaji1Shijizhi}">
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
							   value="${hntxiangxixxmaxPage.waijiaji2Shijizhi}">
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
							   value="${hntxiangxixxmaxPage.waijiaji3Shijizhi}">
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
							   value="${hntxiangxixxmaxPage.waijiaji4Shijizhi}">
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
							   value="${hntxiangxixxmaxPage.chuliaoshijian}">
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
							   value="${hntxiangxixxmaxPage.sha1Lilunzhi}">
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
							   value="${hntxiangxixxmaxPage.shi1Lilunzhi}">
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
							   value="${hntxiangxixxmaxPage.shi2Lilunzhi}">
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
							   value="${hntxiangxixxmaxPage.sha2Lilunzhi}">
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
							   value="${hntxiangxixxmaxPage.guliao5Lilunzhi}">
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
							   value="${hntxiangxixxmaxPage.shuini1Lilunzhi}">
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
							   value="${hntxiangxixxmaxPage.shuini2Lilunzhi}">
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
							   value="${hntxiangxixxmaxPage.kuangfen3Lilunzhi}">
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
							   value="${hntxiangxixxmaxPage.feimeihui4Lilunzhi}">
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
							   value="${hntxiangxixxmaxPage.fenliao5Lilunzhi}">
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
							   value="${hntxiangxixxmaxPage.fenliao6Lilunzhi}">
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
							   value="${hntxiangxixxmaxPage.shui1Lilunzhi}">
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
							   value="${hntxiangxixxmaxPage.shui2Lilunzhi}">
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
							   value="${hntxiangxixxmaxPage.waijiaji1Lilunzhi}">
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
							   value="${hntxiangxixxmaxPage.waijiaji2Lilunzhi}">
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
							   value="${hntxiangxixxmaxPage.waijiaji3Lilunzhi}">
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
							   value="${hntxiangxixxmaxPage.waijiaji4Lilunzhi}">
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
							   value="${hntxiangxixxmaxPage.gongchengmingcheng}">
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
							   value="${hntxiangxixxmaxPage.sigongdidian}">
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
							   value="${hntxiangxixxmaxPage.jiaozuobuwei}">
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
							   value="${hntxiangxixxmaxPage.shuinipingzhong}">
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
							   value="${hntxiangxixxmaxPage.waijiajipingzhong}">
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
							   value="${hntxiangxixxmaxPage.peifanghao}">
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
							   value="${hntxiangxixxmaxPage.qiangdudengji}">
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
							   value="${hntxiangxixxmaxPage.jiaobanshijian}">
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
							   value="${hntxiangxixxmaxPage.shebeibianhao}">
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
							   value="${hntxiangxixxmaxPage.baocunshijian}">
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
							   value="${hntxiangxixxmaxPage.kehuduanbianhao}">
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
							   value="${hntxiangxixxmaxPage.biaoshi}">
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
							   value="${hntxiangxixxmaxPage.caijishijian}">
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
							   value="${hntxiangxixxmaxPage.gujifangshu}">
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
							   value="${hntxiangxixxmaxPage.caijiyanshi}">
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
							   value="${hntxiangxixxmaxPage.shangchuanyanshi}">
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
							   value="${hntxiangxixxmaxPage.banhezhanminchen}">
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
							   value="${hntxiangxixxmaxPage.jianchen}">
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
							   value="${hntxiangxixxmaxPage.smsbaojin}">
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
							   value="${hntxiangxixxmaxPage.smstype}">
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
							   value="${hntxiangxixxmaxPage.sendtype}">
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
							   value="${hntxiangxixxmaxPage.panshu}">
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
							   value="${hntxiangxixxmaxPage.ambegin}">
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
							   value="${hntxiangxixxmaxPage.amend}">
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
							   value="${hntxiangxixxmaxPage.pmbegin}">
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
							   value="${hntxiangxixxmaxPage.pmend}">
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
							   value="${hntxiangxixxmaxPage.smssettype}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>