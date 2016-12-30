<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>水泥混凝土误差查看</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <style type="text/css">
  .inputxt1{
  	width:40px;
  	text-align:center;
  }
  </style>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="" btnsub="">
		

<table style="border: 0px;"  class="formtable">
			<tr>
				<th   align="center">拌和站名称</th>
				<th   align="center">工程名称</th>
				<th   align="center">出料时间</th>
				<th    align="center">${fieldtest.sha1_shijizhi}</th>
				<th    align="center">${fieldtest.sha2_shijizhi}</th>
				<th    align="center">${fieldtest.shi1_shijizhi}</th>
				<th   align="center">${fieldtest.shi2_shijizhi}</th>
				<th   align="center">${fieldtest.guliao5_shijizhi}</th>
				<th   align="center">${fieldtest.shuini1_shijizhi}</th>
				<th   align="center">${fieldtest.shuini2_shijizhi}</th>
				<th   align="center">${fieldtest.kuangfen3_shijizhi}</th>
				<th   align="center">${fieldtest.feimeihui4_shijizhi}</th>
				<th   align="center">${fieldtest.fenliao5_shijizhi}</th>
				<th   align="center">${fieldtest.fenliao6_shijizhi}</th>
				<th   align="center">${fieldtest.shui1_shijizhi}</th>
				<th   align="center">${fieldtest.shui2_shijizhi}</th>
				<th   align="center">${fieldtest.waijiaji1_shijizhi}</th>
				<th   align="center">${fieldtest.waijiaji2_shijizhi}</th>
				<th   align="center">${fieldtest.waijiaji3_shijizhi}</th>
				<th   align="center">${fieldtest.waijiaji4_shijizhi}</th>
		</tr>
		<tr >
		<td>${hnt.banhezhanminchen}</td>
		<td>${hnt.gongchengmingcheng}</td>
		<td>${hnt.chuliaoshijian}</td>
		
		<td>${hnt.sha1_shijizhi}</td>
		<td>${hnt.sha2_shijizhi}</td>
		<td>${hnt.shi1_shijizhi}</td>
		<td>${hnt.shi2_shijizhi}</td>
		<td>${hnt.guliao5_shijizhi}</td>
		<td>${hnt.shuini1_shijizhi}</td>
		<td>${hnt.shuini2_shijizhi}</td>
		<td>${hnt.kuangfen3_shijizhi}</td>
		<td>${hnt.feimeihui4_shijizhi}</td>
		<td>${hnt.fenliao5_shijizhi}</td>
		<td>${hnt.fenliao6_shijizhi}</td>
		<td>${hnt.shui1_shijizhi}</td>
		<td>${hnt.shui2_shijizhi}</td>
		<td>${hnt.waijiaji1_shijizhi}</td>
		<td>${hnt.waijiaji2_shijizhi}</td>
		<td>${hnt.waijiaji3_shijizhi}</td>
		<td>${hnt.waijiaji4_shijizhi}</td>
		</tr>
		<tr>
		<td> </td>
		<td> </td>
		<td>施工配合比</td>
		<td>${hnt.sha1_lilunzhi}</td>
		<td>${hnt.sha2_lilunzhi}</td>
		<td>${hnt.shi1_lilunzhi}</td>
		<td>${hnt.shi2_lilunzhi}</td>
		<td>${hnt.guliao5_lilunzhi}</td>
		<td>${hnt.shuini1_lilunzhi}</td>
		<td>${hnt.shuini2_lilunzhi}</td>
		<td>${hnt.kuangfen3_lilunzhi}</td>
		<td>${hnt.feimeihui4_lilunzhi}</td>
		<td>${hnt.fenliao5_lilunzhi}</td>
		<td>${hnt.fenliao6_lilunzhi}</td>
		<td>${hnt.shui1_lilunzhi}</td>
		<td>${hnt.shui2_lilunzhi}</td>
		<td>${hnt.waijiaji1_lilunzhi}</td>
		<td>${hnt.waijiaji2_lilunzhi}</td>
		<td>${hnt.waijiaji3_lilunzhi}</td>
		<td>${hnt.waijiaji4_lilunzhi}</td>
		</tr>
		<tr>
			<td> </td>
			<td> </td>
			<td>误差</td>
			<td>${hnt.glw1}</td>
			<td>${hnt.glw4}</td>
			<td>${hnt.glw2}</td>
			<td>${hnt.glw3}</td>
			<td>${hnt.glw5}</td>
			<td>${hnt.flw1}</td>
			<td>${hnt.flw2}</td>
			<td>${hnt.flw3}</td>
			<td>${hnt.flw4}</td>
			<td>${hnt.flw5}</td>
			<td>${hnt.flw6}</td>
			<td>${hnt.shw1}</td>
			<td>${hnt.shw2}</td>
			<td>${hnt.wjw1}</td>
			<td>${hnt.wjw2}</td>
			<td>${hnt.wjw3}</td>
			<td>${hnt.wjw4}</td>
		</tr>
		<tr>
			<td> </td>
			<td> </td>
			<td>百分比(%)</td>
			<td>${hnt.glper1}</td>
			<td>${hnt.glper4}</td>
			<td>${hnt.glper2}</td>
			<td>${hnt.glper3}</td>
			<td>${hnt.glper5}</td>
			<td>${hnt.flper1}</td>
			<td>${hnt.flper2}</td>
			<td>${hnt.flper3}</td>
			<td>${hnt.flper4}</td>
			<td>${hnt.flper5}</td>
			<td>${hnt.flper6}</td>
			<td>${hnt.shper1}</td>
			<td>${hnt.shper2}</td>
			<td>${hnt.wjper1}</td>
			<td>${hnt.wjper2}</td>
			<td>${hnt.wjper3}</td>
			<td>${hnt.wjper4}</td>
		</tr>
</table>
		
			
		</t:formvalid>
 </body>
 <script type="text/javascript">

 </script>