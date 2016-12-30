<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>水泥混凝土超标查看及处理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <style type="text/css">
  .inputxt1{
  	width:40px;
  	text-align:center;
  }
  </style>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="hunnintuchaobiaoViewController.do?savecbchuzhi">
		

<table style="border: 0px;">
			<tr>
				<td style="border: 0px;">
					<table style="width: 650px" cellpadding="0" cellspacing="1" class="formtable">
				      	
						<tr style="border: 0px;">
							<td align="right"><label class="Validform_label">${hntbhzField.jiaobanshijian }</label></td>
							<td class="value" colspan="4">${hunnintuchaobiaoView.jiaobanshijian}</td>
						</tr>
						<tr>
							<td align="right"><label class="Validform_label">${hntbhzField.gujifangshu}</label></td>
							<td class="value" colspan="4">${hunnintuchaobiaoView.gujifangshu}</td>
						</tr>
						<tr>
							<td align="right"><label class="Validform_label">${hntbhzField.chuliaoshijian}</label></td>
							<td class="value" colspan="4">${hunnintuchaobiaoView.chuliaoshijian}</td>
						</tr>
						<tr>
							<td align="right"><label class="Validform_label">${hntbhzField.baocunshijian}</label></td>
							<td class="value" colspan="4">${hunnintuchaobiaoView.baocunshijian}</td>
						</tr>
						<tr>
							<td align="right"><label class="Validform_label">${hntbhzField.caijishijian}</label></td>
							<td class="value" colspan="4">${hunnintuchaobiaoView.caijishijian}</td>
						</tr>
						<tr>
							<td align="right"><label class="Validform_label">材料名称</label></td>
							<td align="center" style="width:120px;">实际值</td>
							<td align="center" style="width:120px;">理论值</td>
							<td align="center" style="width:120px;">误差值</td>
							<td align="center" style="width:120px;">百分比</td>
						</tr>
						
						<tr
						<c:if test="${hunnintuchaobiaoView.cbshui1_shijizhi==1 || hunnintuchaobiaoView.cbshui1_shijizhi==4}">
							style="color:#3C9EFE;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbshui1_shijizhi==2 || hunnintuchaobiaoView.cbshui1_shijizhi==5}">
							style="color:#B4C91F;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbshui1_shijizhi==3 || hunnintuchaobiaoView.cbshui1_shijizhi==6}">
							style="color:#D65859;font-weight:bolder;"
						</c:if>
						>
							<td align="right"><label class="Validform_label">${hntbhzField.shui1_shijizhi}</label></td>
							<td class="value">${hunnintuchaobiaoView.shui1_shijizhi}</td>
							<td class="value">${hunnintuchaobiaoView.shui1_lilunzhi}</td>
							<td class="value">${hunnintuchaobiaoView.shw1}</td>
							<td class="value">${hunnintuchaobiaoView.shper1}</td>
						</tr>
						<tr
						<c:if test="${hunnintuchaobiaoView.cbshuini1_shijizhi==1 || hunnintuchaobiaoView.cbshuini1_shijizhi==4}">
							style="color:#3C9EFE;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbshuini1_shijizhi==2 || hunnintuchaobiaoView.cbshuini1_shijizhi==5}">
							style="color:#B4C91F;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbshuini1_shijizhi==3 || hunnintuchaobiaoView.cbshuini1_shijizhi==6}">
							style="color:#D65859;font-weight:bolder;"
						</c:if>
						>
							<td align="right"><label class="Validform_label">${hntbhzField.shuini1_shijizhi}</label></td>
							<td Class="value">${hunnintuchaobiaoView.shuini1_shijizhi}</td>
							<td Class="value">${hunnintuchaobiaoView.shuini1_lilunzhi}</td>
							<td Class="value">${hunnintuchaobiaoView.flw1}</td>
							<td Class="value">${hunnintuchaobiaoView.flper1}</td>
						</tr>
						<tr
						<c:if test="${hunnintuchaobiaoView.cbshuini2_shijizhi==1 || hunnintuchaobiaoView.cbshuini2_shijizhi==4}">
							style="color:#3C9EFE;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbshuini2_shijizhi==2 || hunnintuchaobiaoView.cbshuini2_shijizhi==5}">
							style="color:#B4C91F;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbshuini2_shijizhi==3 || hunnintuchaobiaoView.cbshuini2_shijizhi==6}">
							style="color:#D65859;font-weight:bolder;"
						</c:if>
						>
							<td align="right"><label class="Validform_label">${hntbhzField.shuini2_shijizhi}</label></td>
							<td class="value">${hunnintuchaobiaoView.shuini2_shijizhi}</td>
							<td class="value">${hunnintuchaobiaoView.shuini2_lilunzhi}</td>
							<td class="value">${hunnintuchaobiaoView.flw2}</td>
							<td class="value">${hunnintuchaobiaoView.flper2}</td>
						</tr>
						<tr
						<c:if test="${hunnintuchaobiaoView.cbsha1_shijizhi==1 || hunnintuchaobiaoView.cbsha1_shijizhi==4}">
							style="color:#3C9EFE;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbsha1_shijizhi==2 || hunnintuchaobiaoView.cbsha1_shijizhi==5}">
							style="color:#B4C91F;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbsha1_shijizhi==3 || hunnintuchaobiaoView.cbsha1_shijizhi==6}">
							style="color:#D65859;font-weight:bolder;"
						</c:if>
						>
							<td align="right"><label class="Validform_label">${hntbhzField.sha1_shijizhi}</label></td>
							<td class="value">${hunnintuchaobiaoView.sha1_shijizhi}</td>
							<td class="value">${hunnintuchaobiaoView.sha1_lilunzhi}</td>
							<td class="value">${hunnintuchaobiaoView.glw1}</td>
							<td class="value">${hunnintuchaobiaoView.glper1}</td>
						</tr>
						<tr
						<c:if test="${hunnintuchaobiaoView.cbshi1_shijizhi==1 || hunnintuchaobiaoView.cbshi1_shijizhi==4}">
							style="color:#3C9EFE;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbshi1_shijizhi==2 || hunnintuchaobiaoView.cbshi1_shijizhi==5}">
							style="color:#B4C91F;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbshi1_shijizhi==3 || hunnintuchaobiaoView.cbshi1_shijizhi==6}">
							style="color:#D65859;font-weight:bolder;"
						</c:if>
						>
							<td align="right"><label class="Validform_label">${hntbhzField.shi1_shijizhi}</label></td>
							<td class="value">${hunnintuchaobiaoView.shi1_shijizhi}</td>
							<td class="value">${hunnintuchaobiaoView.shi1_lilunzhi}</td>
							<td class="value">${hunnintuchaobiaoView.glw2}</td>
							<td class="value">${hunnintuchaobiaoView.glper2}</td>
						</tr>
						<tr
						<c:if test="${hunnintuchaobiaoView.cbshi2_shijizhi==1 || hunnintuchaobiaoView.cbshi2_shijizhi==4}">
							style="color:#3C9EFE;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbshi2_shijizhi==2 || hunnintuchaobiaoView.cbshi2_shijizhi==5}">
							style="color:#B4C91F;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbshi2_shijizhi==3 || hunnintuchaobiaoView.cbshi2_shijizhi==6}">
							style="color:#D65859;font-weight:bolder;"
						</c:if>
						>
							<td align="right"><label class="Validform_label">${hntbhzField.shi2_shijizhi}</label></td>
							<td Class="value">${hunnintuchaobiaoView.shi2_shijizhi}</td>
							<td Class="value">${hunnintuchaobiaoView.shi2_lilunzhi}</td>
							<td Class="value">${hunnintuchaobiaoView.glw3}</td>
							<td Class="value">${hunnintuchaobiaoView.glper3}</td>
						</tr>
						<tr
						<c:if test="${hunnintuchaobiaoView.cbsha2_shijizhi==1 || hunnintuchaobiaoView.cbsha2_shijizhi==4}">
							style="color:#3C9EFE;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbsha2_shijizhi==2 || hunnintuchaobiaoView.cbsha2_shijizhi==5}">
							style="color:#B4C91F;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbsha2_shijizhi==3 || hunnintuchaobiaoView.cbsha2_shijizhi==6}">
							style="color:#D65859;font-weight:bolder;"
						</c:if>
						>
							<td align="right"><label class="Validform_label">${hntbhzField.sha2_shijizhi}</label></td>
							<td Class="value">${hunnintuchaobiaoView.sha2_shijizhi}</td>
							<td Class="value">${hunnintuchaobiaoView.sha2_lilunzhi}</td>
							<td Class="value">${hunnintuchaobiaoView.glw4}</td>
							<td Class="value">${hunnintuchaobiaoView.glper4}</td>
						</tr>
						<tr
						<c:if test="${hunnintuchaobiaoView.cbguliao5_shijizhi==1 || hunnintuchaobiaoView.cbguliao5_shijizhi==4}">
							style="color:#3C9EFE;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbguliao5_shijizhi==2 || hunnintuchaobiaoView.cbguliao5_shijizhi==5}">
							style="color:#B4C91F;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbguliao5_shijizhi==3 || hunnintuchaobiaoView.cbguliao5_shijizhi==6}">
							style="color:#D65859;font-weight:bolder;"
						</c:if>
						>
							<td align="right"><label class="Validform_label">${hntbhzField.guliao5_shijizhi}</label></td>
							<td class="value">${hunnintuchaobiaoView.guliao5_shijizhi}</td>
							<td class="value">${hunnintuchaobiaoView.guliao5_lilunzhi}</td>
							<td class="value">${hunnintuchaobiaoView.glw5}</td>
							<td class="value">${hunnintuchaobiaoView.glper5}</td>
						</tr>
						<tr
						<c:if test="${hunnintuchaobiaoView.cbkuangfen3_shijizhi==1 || hunnintuchaobiaoView.cbkuangfen3_shijizhi==4}">
							style="color:#3C9EFE;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbkuangfen3_shijizhi==2 || hunnintuchaobiaoView.cbkuangfen3_shijizhi==5}">
							style="color:#B4C91F;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbkuangfen3_shijizhi==3 || hunnintuchaobiaoView.cbkuangfen3_shijizhi==6}">
							style="color:#D65859;font-weight:bolder;"
						</c:if>
						>
							<td align="right"><label class="Validform_label">${hntbhzField.kuangfen3_shijizhi}</label></td>
							<td class="value">${hunnintuchaobiaoView.kuangfen3_shijizhi}</td>
							<td class="value">${hunnintuchaobiaoView.kuangfen3_lilunzhi}</td>
							<td class="value">${hunnintuchaobiaoView.flw3}</td>
							<td class="value">${hunnintuchaobiaoView.flper3}</td>
						</tr>
						<tr
						<c:if test="${hunnintuchaobiaoView.cbfeimeihui4_shijizhi==1 || hunnintuchaobiaoView.cbfeimeihui4_shijizhi==4}">
							style="color:#3C9EFE;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbfeimeihui4_shijizhi==2 || hunnintuchaobiaoView.cbfeimeihui4_shijizhi==5}">
							style="color:#B4C91F;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbfeimeihui4_shijizhi==3 || hunnintuchaobiaoView.cbfeimeihui4_shijizhi==6}">
							style="color:#D65859;font-weight:bolder;"
						</c:if>
						>
							<td align="right"><label class="Validform_label">${hntbhzField.feimeihui4_shijizhi}</label></td>
							<td class="value">${hunnintuchaobiaoView.feimeihui4_shijizhi}</td>
							<td class="value">${hunnintuchaobiaoView.feimeihui4_lilunzhi}</td>
							<td class="value">${hunnintuchaobiaoView.flw4}</td>
							<td class="value">${hunnintuchaobiaoView.flper4}</td>
						</tr>
						<tr
						<c:if test="${hunnintuchaobiaoView.cbfenliao5_shijizhi==1 || hunnintuchaobiaoView.cbfenliao5_shijizhi==4}">
							style="color:#3C9EFE;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbfenliao5_shijizhi==2 || hunnintuchaobiaoView.cbfenliao5_shijizhi==5}">
							style="color:#B4C91F;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbfenliao5_shijizhi==3 || hunnintuchaobiaoView.cbfenliao5_shijizhi==6}">
							style="color:#D65859;font-weight:bolder;"
						</c:if>
						>
							<td align="right"><label class="Validform_label">${hntbhzField.fenliao5_shijizhi}</label></td>
							<td class="value">${hunnintuchaobiaoView.fenliao5_shijizhi}</td>
							<td class="value">${hunnintuchaobiaoView.fenliao5_lilunzhi}</td>
							<td class="value">${hunnintuchaobiaoView.flw5}</td>
							<td class="value">${hunnintuchaobiaoView.flper5}</td>
						</tr>
						<tr
						<c:if test="${hunnintuchaobiaoView.cbfenliao6_shijizhi==1 || hunnintuchaobiaoView.cbfenliao6_shijizhi==4}">
							style="color:#3C9EFE;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbfenliao6_shijizhi==2 || hunnintuchaobiaoView.cbfenliao6_shijizhi==5}">
							style="color:#B4C91F;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbfenliao6_shijizhi==3 || hunnintuchaobiaoView.cbfenliao6_shijizhi==6}">
							style="color:#D65859;font-weight:bolder;"
						</c:if>
						>
							<td align="right"><label class="Validform_label">${hntbhzField.fenliao6_shijizhi}</label></td>
							<td class="value">${hunnintuchaobiaoView.fenliao6_shijizhi}</td>
							<td class="value">${hunnintuchaobiaoView.fenliao6_lilunzhi}</td>
							<td class="value">${hunnintuchaobiaoView.flw6}</td>
							<td class="value">${hunnintuchaobiaoView.flper6}</td>
						</tr>	
						<tr
						<c:if test="${hunnintuchaobiaoView.cbshui2_shijizhi==1 || hunnintuchaobiaoView.cbshui2_shijizhi==4}">
							style="color:#3C9EFE;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbshui2_shijizhi==2 || hunnintuchaobiaoView.cbshui2_shijizhi==5}">
							style="color:#B4C91F;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbshui2_shijizhi==3 || hunnintuchaobiaoView.cbshui2_shijizhi==6}">
							style="color:#D65859;font-weight:bolder;"
						</c:if>
						>
							<td align="right"><label class="Validform_label">${hntbhzField.shui2_shijizhi}</label></td>
							<td class="value">${hunnintuchaobiaoView.shui2_shijizhi}</td>
							<td class="value">${hunnintuchaobiaoView.shui2_lilunzhi}</td>
							<td class="value">${hunnintuchaobiaoView.shw2}</td>
							<td class="value">${hunnintuchaobiaoView.shper2}</td>
						</tr>
						<tr
						<c:if test="${hunnintuchaobiaoView.cbwaijiaji1_shijizhi==1 || hunnintuchaobiaoView.cbwaijiaji1_shijizhi==4}">
							style="color:#3C9EFE;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbwaijiaji1_shijizhi==2 || hunnintuchaobiaoView.cbwaijiaji1_shijizhi==5}">
							style="color:#B4C91F;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbwaijiaji1_shijizhi==3 || hunnintuchaobiaoView.cbwaijiaji1_shijizhi==6}">
							style="color:#D65859;font-weight:bolder;"
						</c:if>
						>
							<td align="right"><label class="Validform_label">${hntbhzField.waijiaji1_shijizhi}</label></td>
							<td class="value">${hunnintuchaobiaoView.waijiaji1_shijizhi}</td>
							<td class="value">${hunnintuchaobiaoView.waijiaji1_lilunzhi}</td>
							<td class="value">${hunnintuchaobiaoView.wjw1}</td>
							<td class="value">${hunnintuchaobiaoView.wjper1}</td>
						</tr>
						<tr
						<c:if test="${hunnintuchaobiaoView.cbwaijiaji2_shijizhi==1 || hunnintuchaobiaoView.cbwaijiaji2_shijizhi==4}">
							style="color:#3C9EFE;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbwaijiaji2_shijizhi==2 || hunnintuchaobiaoView.cbwaijiaji2_shijizhi==5}">
							style="color:#B4C91F;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbwaijiaji2_shijizhi==3 || hunnintuchaobiaoView.cbwaijiaji2_shijizhi==6}">
							style="color:#D65859;font-weight:bolder;"
						</c:if>
						>
							<td align="right"><label class="Validform_label">${hntbhzField.waijiaji2_shijizhi}</label></td>
							<td class="value">${hunnintuchaobiaoView.waijiaji2_shijizhi}</td>
							<td class="value">${hunnintuchaobiaoView.waijiaji2_lilunzhi}</td>
							<td class="value">${hunnintuchaobiaoView.wjw2}</td>
							<td class="value">${hunnintuchaobiaoView.wjper2}</td>
						</tr>
						<tr
						<c:if test="${hunnintuchaobiaoView.cbwaijiaji3_shijizhi==1 || hunnintuchaobiaoView.cbwaijiaji3_shijizhi==4}">
							style="color:#3C9EFE;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbwaijiaji3_shijizhi==2 || hunnintuchaobiaoView.cbwaijiaji3_shijizhi==5}">
							style="color:#B4C91F;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbwaijiaji3_shijizhi==3 || hunnintuchaobiaoView.cbwaijiaji3_shijizhi==6}">
							style="color:#D65859;font-weight:bolder;"
						</c:if>
						>
							<td align="right"><label class="Validform_label">${hntbhzField.waijiaji3_shijizhi}</label></td>
							<td class="value">${hunnintuchaobiaoView.waijiaji3_shijizhi}</td>
							<td class="value">${hunnintuchaobiaoView.waijiaji3_lilunzhi}</td>
							<td class="value">${hunnintuchaobiaoView.wjw3}</td>
							<td class="value">${hunnintuchaobiaoView.wjper3}</td>
						</tr>
						<tr
						<c:if test="${hunnintuchaobiaoView.cbwaijiaji4_shijizhi==1 || hunnintuchaobiaoView.cbwaijiaji4_shijizhi==4}">
							style="color:#3C9EFE;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbwaijiaji4_shijizhi==2 || hunnintuchaobiaoView.cbwaijiaji4_shijizhi==5}">
							style="color:#B4C91F;font-weight:bolder;"
						</c:if>
						<c:if test="${hunnintuchaobiaoView.cbwaijiaji4_shijizhi==3 || hunnintuchaobiaoView.cbwaijiaji4_shijizhi==6}">
							style="color:#D65859;font-weight:bolder;"
						</c:if>
						>
							<td align="right"><label class="Validform_label">${hntbhzField.waijiaji4_shijizhi}</label></td>
							<td class="value">${hunnintuchaobiaoView.waijiaji4_shijizhi}</td>
							<td class="value">${hunnintuchaobiaoView.waijiaji4_lilunzhi}</td>
							<td class="value">${hunnintuchaobiaoView.wjw4}</td>
							<td class="value">${hunnintuchaobiaoView.wjper4}</td>
						</tr>
						<tr>
							<td align="right"><label class="Validform_label">${hntbhzField.gongdanhao}</label></td>
							<td class="value" colspan="4">${hunnintuchaobiaoView.gongdanhao}</td>
						</tr>
						<tr>
							<td align="right"><label class="Validform_label">${hntbhzField.chaozuozhe}</label></td>
							<td Class="value" colspan="4" >${hunnintuchaobiaoView.chaozuozhe}</td>
						</tr>
						<tr>
							<td align="right"><label class="Validform_label">${hntbhzField.gongchengmingcheng}</label></td>
							<td class="value" colspan="4">${hunnintuchaobiaoView.gongchengmingcheng}</td>
						</tr>
						<tr>
							<td align="right"><label class="Validform_label">${hntbhzField.sigongdidian}</label></td>
							<td class="value" colspan="4">${hunnintuchaobiaoView.sigongdidian}</td>
						</tr>	
						<tr>
							<td align="right"><label class="Validform_label">${hntbhzField.jiaozuobuwei}</label></td>
							<td Class="value" colspan="4" >${hunnintuchaobiaoView.jiaozuobuwei}</td>
						</tr>
						<tr>
							<td align="right"><label class="Validform_label">${hntbhzField.waijiajipingzhong}</label></td>
							<td class="value" colspan="4">${hunnintuchaobiaoView.waijiajipingzhong}</td>
						</tr>
						<tr>
							<td align="right"><label class="Validform_label">${hntbhzField.shuinipingzhong}</label></td>
							<td class="value" colspan="4">${hunnintuchaobiaoView.shuinipingzhong}</td>
						</tr>	
						<tr>
							<td align="right"><label class="Validform_label">${hntbhzField.peifanghao}</label></td>
							<td class="value" colspan="4">${hunnintuchaobiaoView.peifanghao}</td>
						</tr>
						<tr>
							<td align="right"><label class="Validform_label">${hntbhzField.qiangdudengji}</label></td>
							<td class="value" colspan="4">${hunnintuchaobiaoView.qiangdudengji}</td>
						</tr>	
						<tr>
							<td align="right"><label class="Validform_label">${hntbhzField.shebeibianhao}</label></td>
							<td class="value" colspan="4">${hunnintuchaobiaoView.shebeibianhao}</td>
						</tr>
						
						<tr>
							<td align="right"><label class="Validform_label">客户端编号</label></td>
							<td class="value" colspan="4">${hunnintuchaobiaoView.kehuduanbianhao}</td>
						</tr>
						
					</table>	
				</td>

				<td valign="top" style="border: 0px;">
					<input type="hidden" value="${hunnintuchaobiaoView.jieguobianhao}" name="hunnintuchaobiaoView.jieguobianhao" id="biaoshi"/>
					<input type="hidden" name="operationType" value="${operationType }"/>
					<table style="width: 490px;"  cellpadding="0" cellspacing="1" class="formtable">
						<tr>
							<td align="right" styl="width:85px;"><label class="Validform_label">问题原因</label></td>
							<td style="border: none;" colspan="3"> <textarea <c:if test="${operationType==1 || operationType==3}">disabled</c:if> name="xiangxijieguovalue.wentiyuanyin" id="wentiyuanyin"  style="width: 420px; height: 85px;overflow:auto;">${xiangxijieguovalue.wentiyuanyin }</textarea> </td>
						</tr>
						<tr>
							<td align="right"><label class="Validform_label">处理方式</label></td>
							<td style="border: none;" colspan="3"> <textarea <c:if test="${operationType==1 || operationType==3}">disabled</c:if> name="xiangxijieguovalue.chulifangshi" id="chulifangshi"  style="width: 420px; height: 85px;overflow:auto;">${xiangxijieguovalue.chulifangshi }</textarea> </td>
						</tr>
						<tr>
							<td align="right"><label class="Validform_label">处理结果</label></td>
							<td style="border: none;" colspan="3"> 
								<%--
								<span style="position: absolute;  overflow: hidden; width: 332px; height: 18px; clip: rect(2px, 350px, 180px,312px);">
									<select name="chulijieguosel" id="chulijieguosel" style="width: 332px; height: 18px; margin-top: 1px;" onchange="javascript:chulijieguochange(this.value)">
										<option value="" >-请选择处理结果-</option>
										<option value="继续使用" >继续使用</option>
										<option value="降级标号使用" >降级标号使用</option>
										<option value="用于临建">用于临建</option>
										<option value="废弃" >废弃</option>
										<option value="其它" >其它</option>
									</select>
								</span> 
								 --%>
								<textarea <c:if test="${operationType==1 || operationType==3}">disabled</c:if> name="xiangxijieguovalue.chulijieguo" id="chulijieguo" style="width:420px; height: 85px; margin-top: -2px;overflow:auto;">${xiangxijieguovalue.chulijieguo}</textarea>
								</td>
							</td>
						</tr>
						<%--
						<tr>
							<td align="right"><label class="Validform_label">处理时间</label></td>
							<td style="border: none;"> <input <c:if test="${operationType==1 || operationType==3}">readOnly</c:if> type="text" name="xiangxijieguovalue.chulishijian" id="chulishijian" value="${xiangxijieguovalue.chulishijian }"  style="width: 180px;border: none;" readonly="true"/> </td>
							<td align="right"><label class="Validform_label">处理人</label></td>
							<td style="border: none;"> <input <c:if test="${operationType==1 || operationType==3}">readOnly</c:if> type="text" name="xiangxijieguovalue.chuliren" id="chuliren" value="${xiangxijieguovalue.chuliren }"  style="width: 180px;border: none;" readonly="true"/> </td>
						</tr>
						 --%>
						 <tr>
							<td align="right"><label class="Validform_label">处理时间</label></td>
							<td style="border: none;text-align:center;">${xiangxijieguovalue.chulishijian }</td>
							<td align="right"><label class="Validform_label">处理人</label></td>
							<td style="border: none;text-align:center;">${xiangxijieguovalue.chuliren }</td>
						</tr>
						<tr>
							<td align="right"><label class="Validform_label">监理审批</label></td>
							<td style="border: none;" colspan="3"> <textarea <c:if test="${operationType==1 || operationType==2}">disabled</c:if> name="xiangxijieguovalue.jianlishenpi" id="jianlishenpi"  style="width: 420px; height: 85px;overflow:auto;">${xiangxijieguovalue.jianlishenpi }</textarea> </td>
						</tr>
						<%--
						<tr>
							<td align="right"><label class="Validform_label">审批日期</label></td>
							<td style="border: none;"><input <c:if test="${operationType==1 || operationType==2}">disabled</c:if> type="text" name="xiangxijieguovalue.shenpidate" id="shenpidate" value="${xiangxijieguovalue.shenpidate}"  style="width: 420px;border: none;" readonly="true"/></td>
						</tr>
						 --%>
						<tr>
							<td align="right"><label class="Validform_label">监理结果</label></td>
							<td style="border: none;" colspan="3"> <textarea <c:if test="${operationType==1 || operationType==2}">disabled</c:if> name="xiangxijieguovalue.jianliresult" id="jianliresult"  style="width: 420px; height: 85px;overflow:auto;">${xiangxijieguovalue.jianliresult}</textarea> </td>
						</tr>
						<%-- 
						<tr>
							<td align="right"><label class="Validform_label">审批日期</label></td>
							<td style="border: none;"><input <c:if test="${operationType==1 || operationType==2}">disabled</c:if> type="text" name="xiangxijieguovalue.confirmdate" id="confirmdate" value="${xiangxijieguovalue.confirmdate }"  style="width: 160px;border: none;" readonly="true"/></td>
							<td align="right"><label class="Validform_label">审批人</label></td>
							<td style="border: none;"><input <c:if test="${operationType==1 || operationType==2}">disabled</c:if> type="text" name="xiangxijieguovalue.shenpiren" id="shenpiren" value="${xiangxijieguovalue.shenpiren }"  style="width: 160px;border: none;" readonly="true"/></td>
						</tr>
						--%>
						<tr>
							<td align="right"><label class="Validform_label">处理时间</label></td>
							<td style="border: none;width:180px;text-align:center;">${xiangxijieguovalue.confirmdate }</td>
							<td align="right" style="width:45px;"><label class="Validform_label">审批人</label></td>
							<td style="border: none;width:180px;text-align:center;">${xiangxijieguovalue.shenpiren }</td>
						</tr>
						<tr>
							<td align="right"><label class="Validform_label">备注</label></td>
							<td style="border: none;" colspan="3"> <textarea <c:if test="${operationType==1 || operationType==3}">disabled</c:if> name="xiangxijieguovalue.beizhu" id="beizhu"  style="width: 420px; height: 85px;overflow:auto;">${xiangxijieguovalue.beizhu }</textarea> </td>
						</tr>
						
					</table>
					 
				</td>
			</tr>
		</table>
		
		
			
		</t:formvalid>
 </body>
 <script type="text/javascript">

 </script>