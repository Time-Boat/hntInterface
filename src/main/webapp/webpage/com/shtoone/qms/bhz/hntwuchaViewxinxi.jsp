<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>误差查询详情</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="">
			<input id="id" name="id" type="hidden" value="${hunnintuViewPage.id }">
			<div style="  height:500px; overflow:scroll;">
			<table   cellpadding="0" cellspacing="1" class="formtable"  >
				<tr>
					<td align="right">
						<label class="Validform_label">
							工单号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${hunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							拌合站名称	:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${hunnintuViewPage.banhezhanminchen}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							操作者:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="chaozuozhe" name="chaozuozhe" ignore="ignore"
							   value="${hunnintuViewPage.chaozuozhe}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.sha1_shijizhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sha1_shijizhi" name="sha1_shijizhi" ignore="ignore"
							   value="${hunnintuViewPage.sha1_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.shi1_shijizhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shi1_shijizhi" name="shi1_shijizhi" ignore="ignore"
							   value="${hunnintuViewPage.shi1_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.shi2_shijizhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shi2_shijizhi" name="shi2_shijizhi" ignore="ignore"
							   value="${hunnintuViewPage.shi2_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.sha2_shijizhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sha2_shijizhi" name="sha2_shijizhi" ignore="ignore"
							   value="${hunnintuViewPage.sha2_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.guliao5_shijizhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="guliao5_shijizhi" name="guliao5_shijizhi" ignore="ignore"
							   value="${hunnintuViewPage.guliao5_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.shuini1_shijizhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shuini1_shijizhi" name="shuini1_shijizhi" ignore="ignore"
							   value="${hunnintuViewPage.shuini1_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.shuini2_shijizhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shuini2_shijizhi" name="shuini2_shijizhi" ignore="ignore"
							   value="${hunnintuViewPage.shuini2_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.kuangfen3_shijizhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="kuangfen3_shijizhi" name="kuangfen3_shijizhi" ignore="ignore"
							   value="${hunnintuViewPage.kuangfen3_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.feimeihui4_shijizhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="feimeihui4_shijizhi" name="feimeihui4_shijizhi" ignore="ignore"
							   value="${hunnintuViewPage.feimeihui4_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.fenliao5_shijizhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fenliao5_shijizhi" name="fenliao5_shijizhi" ignore="ignore"
							   value="${hunnintuViewPage.fenliao5_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.fenliao6_shijizhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fenliao6_shijizhi" name="fenliao6_shijizhi" ignore="ignore"
							   value="${hunnintuViewPage.fenliao6_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.shui1_shijizhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shui1_shijizhi" name="shui1_shijizhi" ignore="ignore"
							   value="${hunnintuViewPage.shui1_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.shui2_shijizhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shui2_shijizhi" name="shui2_shijizhi" ignore="ignore"
							   value="${hunnintuViewPage.shui2_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.waijiaji1_shijizhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji1_shijizhi" name="waijiaji1_shijizhi" ignore="ignore"
							   value="${hunnintuViewPage.waijiaji1_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.waijiaji2_shijizhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji2_shijizhi" name="waijiaji2_shijizhi" ignore="ignore"
							   value="${hunnintuViewPage.waijiaji2_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.waijiaji3_shijizhi}3:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji3_shijizhi" name="waijiaji3_shijizhi" ignore="ignore"
							   value="${hunnintuViewPage.waijiaji3_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.waijiaji4_shijizhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji4_shijizhi" name="waijiaji4_shijizhi" ignore="ignore"
							   value="${hunnintuViewPage.waijiaji4_shijizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出料时间:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="chuliaoshijian" name="chuliaoshijian" ignore="ignore"
							   value="${hunnintuViewPage.chuliaoshijian}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.sha1_lilunzhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sha1_lilunzhi" name="sha1_lilunzhi" ignore="ignore"
							   value="${hunnintuViewPage.sha1_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.shi1_lilunzhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shi1_lilunzhi" name="shi1_lilunzhi" ignore="ignore"
							   value="${hunnintuViewPage.shi1_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.shi2_lilunzhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shi2_lilunzhi" name="shi2_lilunzhi" ignore="ignore"
							   value="${hunnintuViewPage.shi2_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.sha2_lilunzhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sha2_lilunzhi" name="sha2_lilunzhi" ignore="ignore"
							   value="${hunnintuViewPage.sha2_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.guliao5_lilunzhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="guliao5_lilunzhi" name="guliao5_lilunzhi" ignore="ignore"
							   value="${hunnintuViewPage.guliao5_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.shuini1_lilunzhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shuini1_lilunzhi" name="shuini1_lilunzhi" ignore="ignore"
							   value="${hunnintuViewPage.shuini1_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.shuini2_lilunzhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shuini2_lilunzhi" name="shuini2_lilunzhi" ignore="ignore"
							   value="${hunnintuViewPage.shuini2_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.kuangfen3_lilunzhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="kuangfen3_lilunzhi" name="kuangfen3_lilunzhi" ignore="ignore"
							   value="${hunnintuViewPage.kuangfen3_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.feimeihui4_lilunzhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="feimeihui4_lilunzhi" name="feimeihui4_lilunzhi" ignore="ignore"
							   value="${hunnintuViewPage.feimeihui4_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.fenliao5_lilunzhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fenliao5_lilunzhi" name="fenliao5_lilunzhi" ignore="ignore"
							   value="${hunnintuViewPage.fenliao5_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.fenliao6_lilunzhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fenliao6_lilunzhi" name="fenliao6_lilunzhi" ignore="ignore"
							   value="${hunnintuViewPage.fenliao6_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.shui1_lilunzhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shui1_lilunzhi" name="shui1_lilunzhi" ignore="ignore"
							   value="${hunnintuViewPage.shui1_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.shui2_lilunzhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shui2_lilunzhi" name="shui2_lilunzhi" ignore="ignore"
							   value="${hunnintuViewPage.shui2_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.waijiaji1_lilunzhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji1_lilunzhi" name="waijiaji1_lilunzhi" ignore="ignore"
							   value="${hunnintuViewPage.waijiaji1_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.waijiaji2_lilunzhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji2_lilunzhi" name="waijiaji2_lilunzhi" ignore="ignore"
							   value="${hunnintuViewPage.waijiaji2_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.waijiaji3_lilunzhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji3_lilunzhi" name="waijiaji3_lilunzhi" ignore="ignore"
							   value="${hunnintuViewPage.waijiaji3_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							${fieldtest.waijiaji4_lilunzhi}:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiaji4_lilunzhi" name="waijiaji4_lilunzhi" ignore="ignore"
							   value="${hunnintuViewPage.waijiaji4_lilunzhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							工程名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gongchengmingcheng" name="gongchengmingcheng" ignore="ignore"
							   value="${hunnintuViewPage.gongchengmingcheng}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							施工地点:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sigongdidian" name="sigongdidian" ignore="ignore"
							   value="${hunnintuViewPage.sigongdidian}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							浇筑部位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jiaozuobuwei" name="jiaozuobuwei" ignore="ignore"
							   value="${hunnintuViewPage.jiaozuobuwei}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							水泥品种:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shuinipingzhong" name="shuinipingzhong" ignore="ignore"
							   value="${hunnintuViewPage.shuinipingzhong}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							外加剂品种:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="waijiajipingzhong" name="waijiajipingzhong" ignore="ignore"
							   value="${hunnintuViewPage.waijiajipingzhong}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							配方号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="peifanghao" name="peifanghao" ignore="ignore"
							   value="${hunnintuViewPage.peifanghao}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							强度等级:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="qiangdudengji" name="qiangdudengji" ignore="ignore"
							   value="${hunnintuViewPage.qiangdudengji}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							搅拌时间:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jiaobanshijian" name="jiaobanshijian" ignore="ignore"
							   value="${hunnintuViewPage.jiaobanshijian}">
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
							   value="${hunnintuViewPage.shebeibianhao}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							保存时间:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="baocunshijian" name="baocunshijian" ignore="ignore"
							   value="${hunnintuViewPage.baocunshijian}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							客户端编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="kehuduanbianhao" name="kehuduanbianhao" ignore="ignore"
							   value="${hunnintuViewPage.kehuduanbianhao}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							标识:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="biaoshi" name="biaoshi" ignore="ignore"
							   value="${hunnintuViewPage.biaoshi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							采集时间:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="caijishijian" name="caijishijian" ignore="ignore"
							   value="${hunnintuViewPage.caijishijian}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							估计方数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gujifangshu" name="gujifangshu" ignore="ignore"
							   value="${hunnintuViewPage.gujifangshu}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
			</div>
		</t:formvalid>
 </body>