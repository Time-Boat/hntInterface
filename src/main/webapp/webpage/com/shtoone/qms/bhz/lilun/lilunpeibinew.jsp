<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>理论配合比信息</title>
	<t:base type="jquery,easyui,tools,DatePicker"></t:base>
	<script type="text/javascript">
		//正浮点数
		var reg = new RegExp("^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$");
		$(function() {
			$('#superGroup').combotree({
				url : 'departController.do?setPFunction&selfId=${depart.id}&type=3',
				onClick: function(node){
					$("#userGroup").val(node.id);
				}
			});
			
			var reportDate=$('#reportDate').val();
			if(reportDate==null || reportDate==""){
				initTime();
			}
		});
		
		 //初始化时间
 		function initTime(){
	 		var date = new Date();
			var year = date.getFullYear();
			var month = date.getMonth();
			var day = date.getDate();
			var hour=date.getHours();
			var min=date.getMinutes();
			var sec=date.getSeconds();
			var shijian = year + '-' + (month < 10 ? ('0' + month) : month) + '-'+ (day< 10 ? ('0' + day) : day)+" "+
						  (hour<10 ? ('0'+hour):hour)+":"+(min<10 ? ('0'+min):min)+":"+(sec<10 ? ('0'+sec):sec);
		 	$("#reportDate").val(shijian);
 		}
		
		function shuini_llphbidValid(){
			var shuini_llphbid=$("#shuini_llphbid").val();
			if(shuini_llphbid=="" || shuini_llphbid==null){
				$("#shuini_llphbidSpan").html("");
				return true;
			}else{
					$("#shuini_llphbidSpan").html("");
					return true;
			}
		}
		
		function shuini_llphbValid(){
			var shuini_llphb=$("#shuini_llphb").val();
			if(shuini_llphb=="" || shuini_llphb==null){
				$("#shuini_llphbSpan").html("");
				return true;
			}else{
				if(!reg.test(shuini_llphb)){ 
					$("#shuini_llphbSpan").html("*水泥理论配合比用量必须输入数字类型*");
					$("#shuini_llphb").val("");
					return false;
				}else{
					$("#shuini_llphbSpan").html("");
					return true;
				}
			}
		}
		
		
		function fenmeihui_llphbidValid(){
			var fenmeihui_llphbid=$("#fenmeihui_llphbid").val();
			if(fenmeihui_llphbid=="" || fenmeihui_llphbid==null){
				$("#fenmeihui_llphbidSpan").html("");
				return true;
			}else{
					$("#fenmeihui_llphbidSpan").html("");
					return true;
			}
		}
		
		function fenmeihui_llphbValid(){
			var fenmeihui_llphb=$("#fenmeihui_llphb").val();
			if(fenmeihui_llphb=="" || fenmeihui_llphb==null){
				$("#fenmeihui_llphbSpan").html("");
				return true;
			}else{
				if(!reg.test(fenmeihui_llphb)){ 
					$("#fenmeihui_llphbSpan").html("*粉煤灰理论配合比用量必须输入数字类型*");
					$("#fenmeihui_llphb").val("");
					return false;
				}else{
					$("#fenmeihui_llphbSpan").html("");
					return true;
				}
			}
		}
		
		function kuangfen_llphbidValid(){
			var kuangfen_llphbid=$("#kuangfen_llphbid").val();
			if(kuangfen_llphbid=="" || kuangfen_llphbid==null){
				$("#kuangfen_llphbidSpan").html("");
				return true;
			}else{
				 
					$("#kuangfen_llphbidSpan").html("");
					return true;
			}
		}
		
		function kuangfen_llphbValid(){
			var kuangfen_llphb=$("#kuangfen_llphb").val();
			if(kuangfen_llphb=="" || kuangfen_llphb==null){
				$("#kuangfen_llphbSpan").html("");
				return true;
			}else{
				if(!reg.test(kuangfen_llphb)){ 
					$("#kuangfen_llphbSpan").html("*矿粉理论配合比用量必须输入数字类型*");
					$("#kuangfen_llphb").val("");
					return false;
				}else{
					$("#kuangfen_llphbSpan").html("");
					return true;
				}
			}
		}
		
		function xiguliao_llphbidValid(){
			var xiguliao_llphbid=$("#xiguliao_llphbid").val();
			if(xiguliao_llphbid=="" || xiguliao_llphbid==null){
				$("#xiguliao_llphbidSpan").html("");
				return true;
			}else{
				 
					$("#xiguliao_llphbidSpan").html("");
					return true;
			}
		}
		
		function xiguliao_llphbValid(){
			var xiguliao_llphb=$("#xiguliao_llphb").val();
			if(xiguliao_llphb=="" || xiguliao_llphb==null){
				$("#xiguliao_llphbSpan").html("");
				return true;
			}else{
				if(!reg.test(xiguliao_llphb)){ 
					$("#xiguliao_llphbSpan").html("*细骨料理论配合比用量必须输入数字类型*");
					$("#xiguliao_llphb").val("");
					return false;
				}else{
					$("#xiguliao_llphbSpan").html("");
					return true;
				}
			}
		}
		
		function cuguliao_llphbidValid(){
			var cuguliao_llphbid=$("#cuguliao_llphbid").val();
			if(cuguliao_llphbid=="" || cuguliao_llphbid==null){
				$("#cuguliao_llphbidSpan").html("");
				return true;
			}else{
				 
					$("#cuguliao_llphbidSpan").html("");
					return true;
			}
		}
		
		function cuguliao_llphbValid(){
			var cuguliao_llphb=$("#cuguliao_llphb").val();
			if(cuguliao_llphb=="" || cuguliao_llphb==null){
				$("#cuguliao_llphbSpan").html("");
				return true;
			}else{
				if(!reg.test(cuguliao_llphb)){ 
					$("#cuguliao_llphbSpan").html("*粗骨料理论配合比用量必须输入数字类型*");
					$("#cuguliao_llphb").val("");
					return false;
				}else{
					$("#cuguliao_llphbSpan").html("");
					return true;
				}
			}
		}
		
		function waijiaji_llphbidValid(){
			var waijiaji_llphbid=$("#waijiaji_llphbid").val();
			if(waijiaji_llphbid=="" || waijiaji_llphbid==null){
				$("#waijiaji_llphbidSpan").html("");
				return true;
			}else{
				 
					$("#waijiaji_llphbidSpan").html("");
					return true;
			}
		}
		
		function waijiaji_llphbValid(){
			var waijiaji_llphb=$("#waijiaji_llphb").val();
			if(waijiaji_llphb=="" || waijiaji_llphb==null){
				$("#waijiaji_llphbSpan").html("");
				return true;
			}else{
				if(!reg.test(waijiaji_llphb)){ 
					$("#waijiaji_llphbSpan").html("*外加剂理论配合比用量必须输入数字类型*");
					$("#waijiaji_llphb").val("");
					return false;
				}else{
					$("#waijiaji_llphbSpan").html("");
					return true;
				}
			}
		}
		
		
		function yingqiji_llphbidValid(){
			var yingqiji_llphbid=$("#yingqiji_llphbid").val();
			if(yingqiji_llphbid=="" || yingqiji_llphbid==null){
				$("#yingqiji_llphbidSpan").html("");
				return true;
			}else{
				 
					$("#yingqiji_llphbidSpan").html("");
					return true;
			}
		}
		
		function yingqiji_llphbValid(){
			var yingqiji_llphb=$("#yingqiji_llphb").val();
			if(yingqiji_llphb=="" || yingqiji_llphb==null){
				$("#yingqiji_llphbSpan").html("");
				return true;
			}else{
				if(!reg.test(yingqiji_llphb)){ 
					$("#yingqiji_llphbSpan").html("*外加剂理论配合比用量必须输入数字类型*");
					$("#yingqiji_llphb").val("");
					return false;
				}else{
					$("#yingqiji_llphbSpan").html("");
					return true;
				}
			}
		}
		
		function banheshui_llphbidValid(){
			var banheshui_llphbid=$("#banheshui_llphbid").val();
			if(banheshui_llphbid=="" || banheshui_llphbid==null){
				$("#banheshui_llphbidSpan").html("");
				return true;
			}else{
				 
					$("#banheshui_llphbidSpan").html("");
					return true;
			}
		}
		
		function banheshui_llphbValid(){
			var banheshui_llphb=$("#banheshui_llphb").val();
			if(banheshui_llphb=="" || banheshui_llphb==null){
				$("#banheshui_llphbSpan").html("");
				return true;
			}else{
				if(!reg.test(banheshui_llphb)){ 
					$("#banheshui_llphbSpan").html("*水理论配合比用量必须输入数字类型*");
					$("#banheshui_llphb").val("");
					return false;
				}else{
					$("#banheshui_llphbSpan").html("");
					return true;
				}
			}
		}
		
		function shuijiaobi_llphbValid(){
			var shuijiaobi_llphb=$("#shuijiaobi_llphb").val();
			if(shuijiaobi_llphb=="" || shuijiaobi_llphb==null){
				$("#shuijiaobi_llphbSpan").html("");
				return true;
			}else{
				if(!reg.test(shuijiaobi_llphb)){ 
					$("#shuijiaobi_llphbSpan").html("*水胶比必须输入数字类型*");
					$("#shuijiaobi_llphb").val("");
					return false;
				}else{
					$("#shuijiaobi_llphbSpan").html("");
					return true;
				}
			}
		}
		
		function jiaocai_llphbValid(){
			var jiaocai_llphb=$("#jiaocai_llphb").val();
			if(jiaocai_llphb=="" || jiaocai_llphb==null){
				$("#jiaocai_llphbSpan").html("");
				return true;
			}else{
				if(!reg.test(jiaocai_llphb)){ 
					$("#jiaocai_llphbSpan").html("*胶材必须输入数字类型*");
					$("#jiaocai_llphb").val("");
					return false;
				}else{
					$("#jiaocai_llphbSpan").html("");
					return true;
				}
			}
		}
		
		function shalv_llphbValid(){
			var shalv_llphb=$("#shalv_llphb").val();
			if(shalv_llphb=="" || shalv_llphb==null){
				$("#shalv_llphbSpan").html("");
				return true;
			}else{
				if(!reg.test(shalv_llphb)){ 
					$("#shalv_llphbSpan").html("*砂率必须输入数字类型*");
					$("#shalv_llphb").val("");
					return false;
				}else{
					$("#shalv_llphbSpan").html("");
					return true;
				}
			}
		}
		
		function kangyaqiangdu7dValid(){
			var kangyaqiangdu7d=$("#kangyaqiangdu7d").val();
			if(kangyaqiangdu7d=="" || kangyaqiangdu7d==null){
				$("#kangyaqiangdu7dSpan").html("");
				return true;
			}else{
				if(!reg.test(kangyaqiangdu7d)){ 
					$("#kangyaqiangdu7dSpan").html("*7d抗压强度必须输入数字类型*");
					$("#kangyaqiangdu7d").val("");
					return false;
				}else{
					$("#kangyaqiangdu7dSpan").html("");
					return true;
				}
			}
		}
		
		function kangyaqiangdu28dValid(){
			var kangyaqiangdu28d=$("#kangyaqiangdu28d").val();
			if(kangyaqiangdu28d=="" || kangyaqiangdu28d==null){
				$("#kangyaqiangdu28dSpan").html("");
				return true;
			}else{
				if(!reg.test(kangyaqiangdu28d)){ 
					$("#kangyaqiangdu28dSpan").html("*28d抗压强度必须输入数字类型*");
					$("#kangyaqiangdu28d").val("");
					return false;
				}else{
					$("#kangyaqiangdu28dSpan").html("");
					return true;
				}
			}
		}
		
		function kangyaqiangdu56dValid(){
			var kangyaqiangdu56d=$("#kangyaqiangdu56d").val();
			if(kangyaqiangdu56d=="" || kangyaqiangdu56d==null){
				$("#kangyaqiangdu56dSpan").html("");
				return true;
			}else{
				if(!reg.test(kangyaqiangdu56d)){ 
					$("#kangyaqiangdu56dSpan").html("*56d抗压强度必须输入数字类型*");
					$("#kangyaqiangdu56d").val("");
					return false;
				}else{
					$("#kangyaqiangdu56dSpan").html("");
					return true;
				}
			}
		}
		
		function diantongliangValid(){
			var diantongliang=$("#diantongliang").val();
			if(diantongliang=="" || diantongliang==null){
				$("#diantongliangSpan").html("");
				return true;
			}else{
				if(!reg.test(diantongliang)){ 
					$("#diantongliangSpan").html("*电通量必须输入数字类型*");
					$("#diantongliang").val("");
					return false;
				}else{
					$("#diantongliangSpan").html("");
					return true;
				}
			}	
		}
		
		function kangdongxingValid(){
			var kangdongxing=$("#kangdongxing").val();
			if(kangdongxing=="" || kangdongxing==null){
				$("#kangdongxingSpan").html("");
				return true;
			}else{
				if(!reg.test(kangdongxing)){ 
					$("#kangdongxingSpan").html("*抗冻性必须输入数字类型*");
					$("#kangdongxing").val("");
					return false;
				}else{
					$("#kangdongxingSpan").html("");
					return true;
				}
			}
		}
		
		function lvkuosanxishuValid(){
			var lvkuosanxishu=$("#lvkuosanxishu").val();
			if(lvkuosanxishu=="" || lvkuosanxishu==null){
				$("#lvkuosanxishuSpan").html("");
				return true;
			}else{
				if(!reg.test(lvkuosanxishu)){ 
					$("#lvkuosanxishuSpan").html("*氯离子扩散系数必须输入数字类型*");
					$("#lvkuosanxishu").val("");
					return false;
				}else{
					$("#lvkuosanxishuSpan").html("");
					return true;
				}
			}
		}
		
		function userGroupValid(){
			var userGroup=$("#userGroup").val();
			if(userGroup==null || userGroup==""){
				$("#userGroupSpan").html("*所属单位必须选择*");
				return false;
			}else{
				return true;
			}
		}
		
		//表单提交验证
		function formValid(){
			if(shuini_llphbValid() && fenmeihui_llphbValid() && kuangfen_llphbValid() && xiguliao_llphbValid() &&
				cuguliao_llphbValid() && waijiaji_llphbValid() && banheshui_llphbValid() && shuijiaobi_llphbValid() &&
				 jiaocai_llphbValid() && shalv_llphbValid() && kangyaqiangdu7dValid() &&
				kangyaqiangdu28dValid() && kangyaqiangdu56dValid() && diantongliangValid() && kangdongxingValid() &&
				lvkuosanxishuValid()&&shuini_llphbidValid() && fenmeihui_llphbidValid() && kuangfen_llphbidValid() && xiguliao_llphbidValid() &&
				cuguliao_llphbidValid() && waijiaji_llphbidValid() && banheshui_llphbidValid() ){
				return true;
			}else{
				return false;
			}
		}
	</script>
</head>
<body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="lilunpeihebiController.do?copyandsave" beforeSubmit="formValid()">
		<input id="id" name="id" type="hidden" value="${lilungph.id}">
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right"><label class="Validform_label">配合比报告编号:</label></td>
				<td class="value"><input class="inputxt" id="phbreportId" name="phbreportId" datatype="*" value="${lilungph.phbreportId}"><span class="Validform_checktip"><font color="red">*必填*</font></span></td>
				
				<%-- <td align="right"><label class="Validform_label">水泥报告编号:</label></td>
				<td class="value"><input class="inputxt" id="shuini_llphbid" name="shuiniLlphbid" datatype="*" value="${lilungph.shuiniLlphbid}" onblur="shuini_llphbidValid()"><span class="Validform_checktip"><font color="red">*必填*</font></span></td>
				 --%>
				 
				<td align="right"><label class="Validform_label">水泥报告编号:</label></td>
				<td class="value"><input class="inputxt" id="shuini_llphbid" name="shuiniLlphbid"  value="${lilungph.shuiniLlphbid}" onblur="shuini_llphbidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
				
				<td align="right"><label class="Validform_label">水泥理论配合比用量(%):</label></td>
				<td class="value"><input class="inputxt" id="shuini_llphb" name="shuiniLlphb"  value="${lilungph.shuiniLlphb}" onblur="shuini_llphbValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				<td align="right"><label class="Validform_label">水胶比(%):</label></td>
				<td class="value"><input class="inputxt" id="shuijiaobi_llphb" name="shuijiaobiLlphb" value="${lilungph.shuijiaobiLlphb}" onblur="shuijiaobi_llphbValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">报告日期:</label></td>
				<td class="value">
					<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="reportDate" name="reportDate" ignore="ignore" value="<fmt:formatDate value='${lilungph.reportDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
					<span class="Validform_checktip"><font color="red">*必选*</font></span>
				</td>
				
				<%-- <td align="right"><label class="Validform_label">粉煤灰报告编号:</label></td>
				<td class="value"><input class="inputxt" id="fenmeihuiLlphbid" name="fenmeihuiLlphbid" datatype="*" value="${lilungph.fenmeihuiLlphbid}" onblur="llphbidValid()"><span class="Validform_checktip"><font color="red">*必填*</font></span></td>
				 --%>
				<td align="right"><label class="Validform_label">粉煤灰报告编号:</label></td>
				<td class="value"><input class="inputxt" id="fenmeihui_llphbid" name="fenmeihuiLlphbid" value="${lilungph.fenmeihuiLlphbid}" onblur="fenmeihui_llphbidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
				
				 
				<td align="right"><label class="Validform_label">粉煤灰理论配合比用量(%):</label></td>
				<td class="value"><input class="inputxt" id="fenmeihui_llphb" name="fenmeihuiLlphb" value="${lilungph.fenmeihuiLlphb}" onblur="fenmeihui_llphbValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				<td align="right"><label class="Validform_label">砂率(%):</label></td>
				<td class="value"><input class="inputxt" id="shalv_llphb" name="shalvLlphb" value="${lilungph.shalvLlphb}" onblur="shalv_llphbValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">拟使用工程部位: </label></td>
				<td class="value"><input class="inputxt" id="gongchengbuwei" name="gongchengbuwei" value="${lilungph.gongchengbuwei}"></td>
				
				<%-- <td align="right"><label class="Validform_label">矿粉报告编号:</label></td>
				<td class="value"><input class="inputxt" id="kuangfenLlphbid" name="kuangfenLlphbid" datatype="*" value="${lilungph.kuangfenLlphbid}" onblur="llphbidValid()"><span class="Validform_checktip"><font color="red">*必填*</font></span></td>
				 --%>
				<td align="right"><label class="Validform_label">矿粉报告编号:</label></td>
				<td class="value"><input class="inputxt" id="kuangfen_llphbid" name="kuangfenLlphbid"  value="${lilungph.kuangfenLlphbid}" onblur="kuangfen_llphbidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
				
				 
				<td align="right"><label class="Validform_label">矿粉理论配合比用量(%):</label></td>
				<td class="value"><input class="inputxt" id="kuangfen_llphb" name="kuangfenLlphb"  value="${lilungph.kuangfenLlphb}" onblur="kuangfen_llphbValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				<td align="right"><label class="Validform_label">7d抗压强度(Mpa):</label></td>
				<td class="value"><input class="inputxt" id="kangyaqiangdu7d" name="kangyaqiangdu7d" value="${lilungph.kangyaqiangdu7d}" onblur="kangyaqiangdu7dValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">混凝土强度等级:</label></td>
				<td class="value">
					<select name="qiangdudengji" id="qiangdudengji" datatype="*" errormsg="该字段不为空">
						<option value="">-请选择强度等级-</option>
						<option value="C15" <c:if test="${lilungph.qiangdudengji=='C15'}">selected="selected"</c:if>>C15</option>
						<option value="C20" <c:if test="${lilungph.qiangdudengji=='C20'}">selected="selected"</c:if>>C20</option>
						<option value="C25" <c:if test="${lilungph.qiangdudengji=='C25'}">selected="selected"</c:if>>C25</option>
						<option value="C30" <c:if test="${lilungph.qiangdudengji=='C30'}">selected="selected"</c:if>>C30</option>
						<option value="C35" <c:if test="${lilungph.qiangdudengji=='C35'}">selected="selected"</c:if>>C35</option>
						<option value="C40" <c:if test="${lilungph.qiangdudengji=='C40'}">selected="selected"</c:if>>C40</option>
						<option value="C45" <c:if test="${lilungph.qiangdudengji=='C45'}">selected="selected"</c:if>>C45</option>
						<option value="C50" <c:if test="${lilungph.qiangdudengji=='C50'}">selected="selected"</c:if>>C50</option>
						<option value="C55" <c:if test="${lilungph.qiangdudengji=='C55'}">selected="selected"</c:if>>C55</option>
						<option value="C60" <c:if test="${lilungph.qiangdudengji=='C60'}">selected="selected"</c:if>>C60</option>
						<option value="C70" <c:if test="${lilungph.qiangdudengji=='C70'}">selected="selected"</c:if>>C70</option>
						<option value="C80" <c:if test="${lilungph.qiangdudengji=='C80'}">selected="selected"</c:if>>C80</option>
						<option value="其他材料" <c:if test="${lilungph.qiangdudengji=='其他材料'}">selected="selected"</c:if>>其他材料</option>
					</select>
					<span class="Validform_checktip"><font color=red>*必选*</font></span>
<%-- 				<input class="inputxt" id="qiangdudengji" name="qiangdudengji" value="${lilungph.qiangdudengji}"> --%>
				</td>
				
				<%-- <td align="right"><label class="Validform_label">细集料报告编号:</label></td>
				<td class="value"><input class="inputxt" id="xiguliaoLlphbid" name="xiguliaoLlphbid" datatype="*" value="${lilungph.xiguliaoLlphbid}" onblur="llphbidValid()"><span class="Validform_checktip"><font color="red">*必填*</font></span></td>
				 --%>
				<td align="right"><label class="Validform_label">细骨料报告编号:</label></td>
				<td class="value"><input class="inputxt" id="xiguliao_llphbid" name="xiguliaoLlphbid" value="${lilungph.xiguliaoLlphbid}" onblur="xiguliao_llphbidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
				 
				<td align="right"><label class="Validform_label">细骨料理论配合比用量(%):</label></td>
				<td class="value"><input class="inputxt" id="xiguliao_llphb" name="xiguliaoLlphb" value="${lilungph.xiguliaoLlphb}" onblur="xiguliao_llphbValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				<td align="right"><label class="Validform_label">28d抗压强度(Mpa):</label></td>
				<td class="value"><input class="inputxt" id="kangyaqiangdu28d" name="kangyaqiangdu28d" value="${lilungph.kangyaqiangdu28d}" onblur="kangyaqiangdu28dValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">所属试验室:</label></td>
				<td class="value">
					<input class="inputxt" id="superGroup" name="superGroup" value="${lilungph.superGroup}" style="width:150px;">
					<input class="inputxt" id="userGroup" name="userGroup" type="hidden" value="${lilungph.userGroup}" datatype="*" errormsg="该字段不为空">
					<span class="Validform_checktip"><font color=red>*必选*</font></span>
				</td>
				
				<%-- <td align="right"><label class="Validform_label">粗集料报告编号:</label></td>
				<td class="value"><input class="inputxt" id="cuguliaoLlphbid" name="cuguliaoLlphbid" datatype="*" value="${lilungph.cuguliaoLlphbid}" onblur="llphbidValid()"><span class="Validform_checktip"><font color="red">*必填*</font></span></td>
			 --%>	
			 <td align="right"><label class="Validform_label">粗骨料报告编号:</label></td>
				<td class="value"><input class="inputxt" id="cuguliao_llphbid" name="cuguliaoLlphbid" value="${lilungph.cuguliaoLlphbid}" onblur="cuguliao_llphbidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
				
			 
				<td align="right"><label class="Validform_label">粗骨料理论配合比用量(%):</label></td>
				<td class="value"><input class="inputxt" id="cuguliao_llphb" name="cuguliaoLlphb" value="${lilungph.cuguliaoLlphb}" onblur="cuguliao_llphbValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				<td align="right"><label class="Validform_label">56d抗压强度(Mpa):</label></td>
				<td class="value"><input class="inputxt" id="kangyaqiangdu56d" name="kangyaqiangdu56d" value="${lilungph.kangyaqiangdu56d}" onblur="kangyaqiangdu56dValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">试验人员:</label></td>
				<td class="value"><input class="inputxt" id="tester" name="tester" value="${lilungph.tester}"></td>
				
				<%-- <td align="right"><label class="Validform_label">拌合水报告编号:</label></td>
				<td class="value"><input class="inputxt" id="banheshuiLlphbid" name="banheshuiLlphbid" datatype="*" value="${lilungph.banheshuiLlphbid}" onblur="llphbidValid()"><span class="Validform_checktip"><font color="red">*必填*</font></span></td>
				 --%>
				<td align="right"><label class="Validform_label">水报告编号:</label></td>
				<td class="value"><input class="inputxt" id="banheshui_llphbid" name="banheshuiLlphbid" value="${lilungph.banheshuiLlphbid}" onblur="banheshui_llphbidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
				
				
				<td align="right"><label class="Validform_label">水理论配合比用量(%):</label></td>
				<td class="value"><input class="inputxt" id="banheshui_llphb" name="banheshuiLlphb" value="${lilungph.banheshuiLlphb}" onblur="banheshui_llphbValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				<td align="right"><label class="Validform_label">电通量(C):</label></td>
				<td class="value"><input class="inputxt" id="diantongliang" name="diantongliang" value="${lilungph.diantongliang}" onblur="diantongliangValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">试验结论: </label></td>
				<td class="value">
					<select name="testResult" id="testResult" datatype="*" errormsg="该字段不为空">
						<option value="">-请选择试验结论-</option>
						<option value="不合格" <c:if test="${lilungph.testResult=='不合格'}">selected="selected"</c:if>>不合格</option>
						<option value="合格" <c:if test="${lilungph.testResult=='合格'}">selected="selected"</c:if>>合格</option>
					</select>
					<span class="Validform_checktip"><font color=red>*必选*</font></span>
				</td>
				
				<%-- <td align="right"><label class="Validform_label">外加剂报告编号:</label></td>
				<td class="value"><input class="inputxt" id="waijiajiLlphbid" name="waijiajiLlphbid" datatype="*" value="${lilungph.waijiajiLlphbid}" onblur="llphbidValid()"><span class="Validform_checktip"><font color="red">*必填*</font></span></td>
				 --%>
				<td align="right"><label class="Validform_label">外加剂报告编号:</label></td>
				<td class="value"><input class="inputxt" id="waijiaji_llphbid" name="waijiajiLlphbid" value="${lilungph.waijiajiLlphbid}" onblur="waijiaji_llphbidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
				 
				<td align="right"><label class="Validform_label">外加剂理论配合比用量(%):</label></td>
				<td class="value"><input class="inputxt" id="waijiaji_llphb" name="waijiajiLlphb" value="${lilungph.waijiajiLlphb}" onblur="waijiaji_llphbValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				<td align="right"><label class="Validform_label">抗冻性(%):</label></td>
				<td class="value"><input class="inputxt" id="kangdongxing" name="kangdongxing" value="${lilungph.kangdongxing}" onblur="kangdongxingValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				
			</tr>
			<tr>
				
				<td align="right"><label class="Validform_label">胶材(%):</label></td>
				<td class="value"><input class="inputxt" id="jiaocai_llphb" name="jiaocaiLlphb" value="${lilungph.jiaocaiLlphb}" onblur="jiaocai_llphbValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				<td align="right"><label class="Validform_label">氯离子扩散系数(㎡/s):</label></td>
				<td class="value"><input class="inputxt" id="lvkuosanxishu" name="lvkuosanxishu" value="${lilungph.lvkuosanxishu}" onblur="lvkuosanxishuValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				<td class="value"><label class="Validform_label">引气剂报告编号:</label></td>
				<td class="value"><input class="inputxt" id="yingqiji_llphbid" name="yingqijiLlphbid" value="${lilungph.yingqijiLlphbid}" onblur="yingqiji_llphbidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
				<td align="right"><label class="Validform_label">引气剂(%):</label></td>
				<td class="value"><input class="inputxt" id="yingqiji_llphb" name="yingqijiLlphb" value="${lilungph.yingqijiLlphb}" onblur="yingqiji_llphbValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 备注: </label></td>
				<td class="value" colspan="7">
					<textarea cols="80" name="beizhu" id="beizhu" rows="7">${lilungph.beizhu}</textarea></td>
			</tr>
			<tr>
				<td colspan="8" align="center">
					<span class="Validform_checktip" id="shuini_llphbSpan"></span>
					<span class="Validform_checktip" id="shuini_llphbidSpan"></span>
					<span class="Validform_checktip" id="fenmeihui_llphbSpan"></span>
					<span class="Validform_checktip" id="fenmeihui_llphbidSpan"></span>
					<span class="Validform_checktip" id="kuangfen_llphbSpan"></span>
					<span class="Validform_checktip" id="kuangfen_llphbidSpan"></span>
					<span class="Validform_checktip" id="xiguliao_llphbSpan"></span>
					<span class="Validform_checktip" id="xiguliao_llphbidSpan"></span>
					<span class="Validform_checktip" id="cuguliao_llphbSpan"></span>
					<span class="Validform_checktip" id="cuguliao_llphbidSpan"></span>
					<span class="Validform_checktip" id="banheshui_llphbSpan"></span>
					<span class="Validform_checktip" id="banheshui_llphbidSpan"></span>
					<span class="Validform_checktip" id="waijiaji_llphbSpan"></span>
					<span class="Validform_checktip" id="waijiaji_llphbidSpan"></span>
					<span class="Validform_checktip" id="yingqiji_llphbSpan"></span>
					<span class="Validform_checktip" id="yingqiji_llphbidSpan"></span>
					
					<span class="Validform_checktip" id="shuijiaobi_llphbSpan"></span>
					<span class="Validform_checktip" id="jiaocai_llphbSpan"></span>
					<span class="Validform_checktip" id="shalv_llphbSpan"></span>
					<span class="Validform_checktip" id="kangyaqiangdu7dSpan"></span>
					<span class="Validform_checktip" id="kangyaqiangdu28dSpan"></span>
					<span class="Validform_checktip" id="kangyaqiangdu56dSpan"></span>
					<span class="Validform_checktip" id="diantongliangSpan"></span>
					<span class="Validform_checktip" id="kangdongxingSpan"></span>
					<span class="Validform_checktip" id="lvkuosanxishuSpan"></span>
					<span class="Validform_checktip" id="userGroupSpan"></span>
				</td>
			</tr>
		</table>
	</t:formvalid>
</body>
</html>
