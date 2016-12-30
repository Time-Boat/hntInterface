<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>施工配合比信息</title>
	<t:base type="jquery,easyui,tools,DatePicker"></t:base>
	<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
	<script type="text/javascript">
		var reg = new RegExp("^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$");
		
		
		function  phidValid(){
 
			$("#xigl1phidSpan").html("");
			$("#xigl2phidSpan").html("");
			$("#chugl1phidSpan").html(""); 
			$("#chugl2phidSpan").html("");
			$("#chugl3phidSpan").html("");
			$("#shuini1phidSpan").html("");
			$("#kuangfenphidSpan").html("");
			$("#fenmeihuiphidSpan").html("");
			$("#shui1phidSpan").html("");
			$("#waijijia1phidSpan").html("");
			$("#waijijia2phidSpan").html("");
			$("#waijijia3phidSpan").html("");
			$("#waijijia4phidSpan").html("");
			
			return true;
		}
		
		function xigl1phValid(){
			var xigl1ph=$("#xigl1ph").val();
			if(xigl1ph=="" || xigl1ph==null){
				$("#xigl1phSpan").html("");
				return true;
			}else{
				if(!reg.test(xigl1ph)){ 
					$("#xigl1phSpan").html("*细骨料1施工配合比用量必须输入数字类型*");
					$("#xigl1ph").val("");
					return false;
				}else{
					$("#xigl1phSpan").html("");
					return true;
				}
			}
		}
		
		function xigl2phValid(){
			var xigl2ph=$("#xigl2ph").val();
			if(xigl2ph=="" || xigl2ph==null){
				$("#xigl2phSpan").html("");
				return true;
			}else{
				if(!reg.test(xigl2ph)){ 
					$("#xigl2phSpan").html("*细骨料2施工配合比用量必须输入数字类型*");
					$("#xigl2ph").val("");
					return false;
				}else{
					$("#xigl2phSpan").html("");
					return true;
				}
			}
		}
		
		function chuliaofangliangValid(){
			var chuliaofangliang=$("#chuliaofangliang").val();
			if(chuliaofangliang=="" || chuliaofangliang==null){
				$("#chuliaofangliangSpan").html("");
				return true;
			}else{
				if(!reg.test(chuliaofangliang)){ 
					$("#chuliaofangliangSpan").html("*出料方量必须输入数字类型*");
					$("#chuliaofangliang").val("");
					return false;
				}else{
					$("#chuliaofangliangSpan").html("");
					return true;
				}
			}
		}
		
		function chugl1phValid(){
			var chugl1ph=$("#chugl1ph").val();
			if(chugl1ph=="" || chugl1ph==null){
				$("#chugl1phSpan").html("");
				return true;
			}else{
				if(!reg.test(chugl1ph)){ 
					$("#chugl1phSpan").html("*粗骨料1施工配合比用量必须输入数字类型*");
					$("#chugl1ph").val("");
					return false;
				}else{
					$("#chugl1phSpan").html("");
					return true;
				}
			}
		}
		
		function chugl2phValid(){
			var chugl2ph=$("#chugl2ph").val();
			if(chugl2ph=="" || chugl2ph==null){
				$("#chugl2phSpan").html("");
				return true;
			}else{
				if(!reg.test(chugl2ph)){ 
					$("#chugl2phSpan").html("*粗骨料2施工配合比用量必须输入数字类型*");
					$("#chugl2ph").val("");
					return false;
				}else{
					$("#chugl2phSpan").html("");
					return true;
				}
			}
		}
		
		function chugl3phValid(){
			var chugl3ph=$("#chugl3ph").val();
			if(chugl3ph=="" || chugl3ph==null){
				$("#chugl3phSpan").html("");
				return true;
			}else{
				if(!reg.test(chugl3ph)){ 
					$("#chugl3phSpan").html("*粗骨料3施工配合比用量必须输入数字类型*");
					$("#chugl3ph").val("");
					return false;
				}else{
					$("#chugl3phSpan").html("");
					return true;
				}
			}
		}
		
		function shuini1phValid(){
			var shuini1ph=$("#shuini1ph").val();
			if(shuini1ph=="" || shuini1ph==null){
				$("#shuini1phSpan").html("");
				return true;
			}else{
				if(!reg.test(shuini1ph)){ 
					$("#shuini1phSpan").html("*水泥1施工配合比用量必须输入数字类型*");
					$("#shuini1ph").val("");
					return false;
				}else{
					$("#shuini1phSpan").html("");
					return true;
				}
			}
		}
		
		function kuangfenphValid(){
			var kuangfenph=$("#kuangfenph").val();
			if(kuangfenph=="" || kuangfenph==null){
				$("#kuangfenphSpan").html("");
				return true;
			}else{
				if(!reg.test(kuangfenph)){ 
					$("#kuangfenphSpan").html("*矿粉施工配合比用量必须输入数字类型*");
					$("#kuangfenph").val("");
					return false;
				}else{
					$("#kuangfenphSpan").html("");
					return true;
				}
			}
		}
		
		function fenmeihuiphValid(){
			var fenmeihuiph=$("#fenmeihuiph").val();
			if(fenmeihuiph=="" || fenmeihuiph==null){
				$("#fenmeihuiphSpan").html("");
				return true;
			}else{
				if(!reg.test(fenmeihuiph)){ 
					$("#fenmeihuiphSpan").html("*粉煤灰施工配合比用量必须输入数字类型*");
					$("#fenmeihuiph").val("");
					return false;
				}else{
					$("#fenmeihuiphSpan").html("");
					return true;
				}
			}
		}
		
		function shui1phValid(){
			var shui1ph=$("#shui1ph").val();
			if(shui1ph=="" || shui1ph==null){
				$("#shui1phSpan").html("");
				return true;
			}else{
				if(!reg.test(shui1ph)){ 
					$("#shui1phSpan").html("*水1施工配合比用量必须输入数字类型*");
					$("#shui1ph").val("");
					return false;
				}else{
					$("#shui1phSpan").html("");
					return true;
				}
			}
		}
		
		function waijijia1phValid(){
			var waijijia1ph=$("#waijijia1ph").val();
			if(waijijia1ph=="" || waijijia1ph==null){
				$("#waijijia1phSpan").html("");
				return true;
			}else{
				if(!reg.test(waijijia1ph)){ 
					$("#waijijia1phSpan").html("*外加剂1施工配合比用量必须输入数字类型*");
					$("#waijijia1ph").val("");
					return false;
				}else{
					$("#waijijia1phSpan").html("");
					return true;
				}
			}
		}
		
		function waijijia2phValid(){
			var waijijia2ph=$("#waijijia2ph").val();
			if(waijijia2ph=="" || waijijia2ph==null){
				$("#waijijia2phSpan").html("");
				return true;
			}else{
				if(!reg.test(waijijia2ph)){ 
					$("#waijijia2phSpan").html("*外加剂2施工配合比用量必须输入数字类型*");
					$("#waijijia2ph").val("");
					return false;
				}else{
					$("#waijijia2phSpan").html("");
					return true;
				}
			}
		}
		
		function waijijia3phValid(){
			var waijijia3ph=$("#waijijia3ph").val();
			if(waijijia3ph=="" || waijijia3ph==null){
				$("#waijijia3phSpan").html("");
				return true;
			}else{
				if(!reg.test(waijijia3ph)){ 
					$("#waijijia3phSpan").html("*外加剂3施工配合比用量必须输入数字类型*");
					$("#waijijia3ph").val("");
					return false;
				}else{
					$("#waijijia3phSpan").html("");
					return true;
				}
			}
		}
		
		function waijijia4phValid(){
			var waijijia4ph=$("#waijijia4ph").val();
			if(waijijia4ph=="" || waijijia4ph==null){
				$("#waijijia4phSpan").html("");
				return true;
			}else{
				if(!reg.test(waijijia4ph)){ 
					$("#waijijia4phSpan").html("*外加剂4施工配合比用量必须输入数字类型*");
					$("#waijijia4ph").val("");
					return false;
				}else{
					$("#waijijia4phSpan").html("");
					return true;
				}
			}
		}
		
		function shuijiaobiValid(){
			var shuijiaobi=$("#shuijiaobi").val();
			if(shuijiaobi=="" || shuijiaobi==null){
				$("#shuijiaobiSpan").html("");
				return true;
			}else{
				if(!reg.test(shuijiaobi)){ 
					$("#shuijiaobiSpan").html("*外加剂3施工配合比用量必须输入数字类型*");
					$("#shuijiaobi").val("");
					return false;
				}else{
					$("#shuijiaobiSpan").html("");
					return true;
				}
			}
		}
		
		//表单提交验证
		function formValid(){
			if(xigl1phValid() && xigl2phValid() && chuliaofangliangValid() && chugl1phValid() && chugl2phValid() &&
			   chugl3phValid() && shuini1phValid() && kuangfenphValid() && fenmeihuiphValid() && shui1phValid() &&
			   waijijia1phValid() && waijijia2phValid() && waijijia3phValid() && waijijia4phValid() && shuijiaobiValid()&& phidValid()){
				return true;
			}else{
				return false;
			}
		}
		
		//查看详情
		function operationDetail(lilunId){
			createdetailwindow("理论配合比查看","lilunpeihebiController.do?addorupdate&id="+lilunId,"1200px","500px");
		}
		
		$(function() {
			$('#cc_shigong').combotree({
				url : 'departController.do?setPFunction&selfId=${depart.id}&type=3',
				onClick: function(node){
					$("#ts_shigongpbdepartId").val(node.id);
					lilunFind(node.id,"lilunId");
				}
			});
			
			//报批日期，批复日期默认为系统时间
			var baopidata=$('#baopidata').val();
			if(baopidata==null || baopidata==""){
				initTime("baopidata");
			}
			var pifudata=$('#pifudata').val();
			if(pifudata==null || pifudata==""){
				initTime("pifudata");
			}
			
		});
		
		 //初始化时间
 		function initTime(obj){
	 		var date = new Date();
			var year = date.getFullYear();
			var month = date.getMonth();
			var day = date.getDate();
			var hour=date.getHours();
			var min=date.getMinutes();
			var sec=date.getSeconds();
			var shijian = year + '-' + (month < 10 ? ('0' + month) : month) + '-'+ (day< 10 ? ('0' + day) : day)+" "+
						  (hour<10 ? ('0'+hour):hour)+":"+(min<10 ? ('0'+min):min)+":"+(sec<10 ? ('0'+sec):sec);
		 	$("#"+obj).val(shijian);
 		}
		
		function lilunFind(obj,selectId){
			$.ajax({
				url:"lilunpeihebiController.do?lilunpbfind",
				type:'post',
				dataType:"json",
				data:{
					departId:obj
				},
				success:function(data){
					$('#'+selectId).html("");
					var jsonStr='<option title="-1" selected="selected" value="">--请选择理论配比--</option>';
					$.each(data.list,function(i,item){
						jsonStr+='<option value="'+item.id+'">'+item.phbreportId+'</option>'
					});
					$('#'+selectId).append(jsonStr);
				}
			});
		}
	</script>
</head>
<body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="ingroundManagerController.do?save" beforeSubmit="formValid()">
		<input id="id" name="id" type="hidden" value="${shigongph.id}">
		<table cellpadding="0" cellspacing="1" class="formtable" width="1000px">
			<tr>
				<td align="right"><label class="Validform_label">生产任务单号:</label></td>
				<td class="value"><input class="inputxt" id="productWorkNo" name="productWorkNo" datatype="*" value="${shigongph.productWorkNo}"><span class="Validform_checktip"><font color="red">*必填*</font></span></td>
				
				<td align="right"><label class="Validform_label">细骨料1报告编号:</label></td>
				<td class="value"><input class="inputxt" id="xigl1phid" name="xigl1phid"  value="${shigongph.xigl1phid}" onblur="phidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
				
				<td align="right"><label class="Validform_label">细骨料1施工配合比用量(kg):</label></td>
				<td class="value"><input class="inputxt" id="xigl1ph" name="xigl1ph" value="${shigongph.xigl1ph}" onblur="xigl1phValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				
				<td align="right"><label class="Validform_label">细骨料2报告编号:</label></td>
				<td class="value"><input class="inputxt" id="xigl2phid" name="xigl2phid" datatype="*" value="${shigongph.xigl2phid}" onblur="phidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
				
				<td align="right"><label class="Validform_label">细骨料2施工配合比用量(kg):</label></td>
				<td class="value"><input class="inputxt" id="xigl2ph" name="xigl2ph" value="${shigongph.xigl2ph}" onblur="xigl2phValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				<%-- 
				<td align="right"><label class="Validform_label">出料时间:</label></td>
				<td class="value">
					<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="chuliaoshijian" name="chuliaoshijian" ignore="ignore" value="<fmt:formatDate value='${shigongph.chuliaoshijian}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
				</td>
				--%>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">出料方量(㎥):</label></td>
				<td class="value"><input class="inputxt" id="chuliaofangliang" name="chuliaofangliang" value="${shigongph.chuliaofangliang}" onblur="chuliaofangliangValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				
				<td align="right"><label class="Validform_label">粗骨料1报告编号:</label></td>
				<td class="value"><input class="inputxt" id="chugl1phid" name="chugl1phid"  value="${shigongph.chugl1phid}" onblur="phidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
				
				
				<td align="right"><label class="Validform_label">粗骨料1施工配合比用量(kg):</label></td>
				<td class="value"><input class="inputxt" id="chugl1ph" name="chugl1ph" value="${shigongph.chugl1ph}" onblur="chugl1phValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				
				<td align="right"><label class="Validform_label">粗骨料2报告编号:</label></td>
				<td class="value"><input class="inputxt" id="chugl2phid" name="chugl2phid"  value="${shigongph.chugl2phid}" onblur="phidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
			
				
				<td align="right"><label class="Validform_label">粗骨料2施工配合比用量(kg):</label></td>
				<td class="value"><input class="inputxt" id="chugl2ph" name="chugl2ph" value="${shigongph.chugl2ph}" onblur="chugl2phValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">报批日期:</label></td>
				<td class="value">
					<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="baopidata" name="baopidata" ignore="ignore" value="<fmt:formatDate value='${shigongph.baopidata}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
					<span class="Validform_checktip"><font color=red>*必选*</font></span>
				</td>
				
				<td align="right"><label class="Validform_label">粗骨料3报告编号:</label></td>
				<td class="value"><input class="inputxt" id="chugl3phid" name="chugl3phid"  value="${shigongph.chugl3phid}" onblur="phidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
				
				<td align="right"><label class="Validform_label">粗骨料3施工配合比用量(kg):</label></td>
				<td class="value"><input class="inputxt" id="chugl3ph" name="chugl3ph" value="${shigongph.chugl3ph}" onblur="chugl3phValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				
				<td align="right"><label class="Validform_label">水泥1报告编号:</label></td>
				<td class="value"><input class="inputxt" id="shuini1phid" name="shuini1phid"  value="${shigongph.shuini1phid}" onblur="phidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
				
				<td align="right"><label class="Validform_label">水泥1施工配合比用量(kg):</label></td>
				<td class="value"><input class="inputxt" id="shuini1ph" name="shuini1ph" value="${shigongph.shuini1ph}" onblur="shuini1phValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">批复日期:</label></td>
				<td class="value">
					<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="pifudata" name="pifudata" ignore="ignore" value="<fmt:formatDate value='${shigongph.pifudata}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
					<span class="Validform_checktip"><font color=red>*必选*</font></span>
				</td>
				
				<td align="right"><label class="Validform_label">矿粉报告编号:</label></td>
				<td class="value"><input class="inputxt" id="kuangfenphid" name="kuangfenphid"  value="${shigongph.kuangfenphid}" onblur="phidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
				
				<td align="right"><label class="Validform_label">矿粉施工配合比用量(kg):</label></td>
				<td class="value"><input class="inputxt" id="kuangfenph" name="kuangfenph" value="${shigongph.kuangfenph}" onblur="kuangfenphValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				
				<td align="right"><label class="Validform_label">粉煤灰报告编号:</label></td>
				<td class="value"><input class="inputxt" id="fenmeihuiphid" name="fenmeihuiphid"  value="${shigongph.fenmeihuiphid}" onblur="phidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
				
				
				<td align="right"><label class="Validform_label">粉煤灰施工配合比用量(kg):</label></td>
				<td class="value"><input class="inputxt" id="fenmeihuiph" name="fenmeihuiph" value="${shigongph.fenmeihuiph}" onblur="fenmeihuiphValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">所属拌和站:</label></td>
				<td class="value">
					<select id="shebeibianhao" name="shebeibianhao" style="height:24px;width:120px;" datatype="*" errormsg="该字段不为空">
						<option value="">-请选择拌和站-</option>
						<c:forEach items="${bhjList}" var="bhj">
							<option value="${bhj.id }" <c:if test="${bhj.id==shigongph.shebeibianhao}">selected="selected"</c:if>>${bhj.departname}</option>
						</c:forEach>
					</select>
					<span class="Validform_checktip"><font color=red>*必选*</font></span>
				</td>
				
				<td align="right"><label class="Validform_label">水1报告编号:</label></td>
				<td class="value"><input class="inputxt" id="shui1phid" name="shui1phid"  value="${shigongph.shui1phid}" onblur="phidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
				
				<td align="right"><label class="Validform_label">水1施工配合比用量(kg):</label></td>
				<td class="value"><input class="inputxt" id="shui1ph" name="shui1ph" value="${shigongph.shui1ph}" onblur="shui1phValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				
				<td align="right"><label class="Validform_label">外加剂1报告编号:</label></td>
				<td class="value"><input class="inputxt" id="waijijia1phid" name="waijijia1phid"  value="${shigongph.waijijia1phid}" onblur="phidValid()"><span class="Validform_checktip"><font color="#9C9C9C">* 非必填项*</font></span></td>
				<td align="right"><label class="Validform_label">外加剂1施工配合比用量(kg):</label></td>
				<td class="value"><input class="inputxt" id="waijijia1ph" name="waijijia1ph" value="${shigongph.waijijia1ph}" onblur="waijijia1phValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">配合比编号:</label></td>
				<td class="value"><input class="inputxt" id="phbid" name="phbid" value="${shigongph.phbid}"></td>
				
				<td align="right"><label class="Validform_label">外加剂2报告编号:</label></td>
				<td class="value"><input class="inputxt" id="waijijia2phid" name="waijijia2phid"  value="${shigongph.waijijia2phid}" onblur="phidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
				
				
				<td align="right"><label class="Validform_label">外加剂2施工配合比用量(kg):</label></td>
				<td class="value"><input class="inputxt" id="waijijia2ph" name="waijijia2ph" value="${shigongph.waijijia2ph}" onblur="waijijia2phValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				
				<td align="right"><label class="Validform_label">外加剂3报告编号:</label></td>
				<td class="value"><input class="inputxt" id="waijijia3phid" name="waijijia3phid"  value="${shigongph.waijijia3phid}" onblur="phidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*非必填项*</font></span></td>
				
				
				
				<td align="right"><label class="Validform_label">外加剂3施工配合比用量(kg):</label></td>
				<td class="value"><input class="inputxt" id="waijijia3ph" name="waijijia3ph" value="${shigongph.waijijia3ph}" onblur="waijijia3phValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">关联理论配比:</label></td>
				<td class="value">
					<!-- 加入组织机构 -->
					<input id="cc_shigong"  value="${depart.TSPDepart.departname}">
					<div><input id="ts_shigongpbdepartId" name="superGroup" style="display: none;" value="${depart.TSPDepart.id}"></div>
					
					<select id="lilunId" name="lilunId" style="height:24px;width:120px;" datatype="*" errormsg="该字段不为空">
						<option value="">-请选择理论配比-</option>
						<c:forEach items="${lilunList}" var="lilun">
							<option value="${lilun.id}" <c:if test="${lilun.id==shigongph.lilunId}">selected="selected"</c:if>>${lilun.phbreportId}</option>
						</c:forEach>
					</select>
					<span class="Validform_checktip"><font color=red>*必选*</font></span>
				</td>
				
				<td align="right"><label class="Validform_label">外加剂4报告编号:</label></td>
				<td class="value"><input class="inputxt" id="waijijia4phid" name="waijijia4phid"  value="${shigongph.waijijia4phid}" onblur="phidValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				
				
				<td align="right"><label class="Validform_label">外加剂4施工配合比用量(kg):</label></td>
				<td class="value"><input class="inputxt" id="waijijia4ph" name="waijijia4ph" value="${shigongph.waijijia4ph}" onblur="waijijia4phValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				<td align="right"><label class="Validform_label">水胶比(%):</label></td>
				<td class="value"><input class="inputxt" id="shuijiaobi" name="shuijiaobi" value="${shigongph.shuijiaobi}" onblur="shuijiaobiValid()"><span class="Validform_checktip"><font color="#9C9C9C">*数字,非必填项*</font></span></td>
				<td class="value"></td>
				<td class="value"></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 备注: </label></td>
				<td class="value" colspan="9">
					<textarea cols="80" name="remark" id="remark" rows="9">${shigongph.remark}</textarea></td>
			</tr>
			<tr>
				<td colspan="10" align="center">
					<span class="Validform_checktip" id="xigl1phSpan"></span>
					<span class="Validform_checktip" id="xigl2phSpan"></span>
					<span class="Validform_checktip" id="chuliaofangliangSpan"></span>
					<span class="Validform_checktip" id="chugl1phSpan"></span>
					<span class="Validform_checktip" id="chugl2phSpan"></span>
					<span class="Validform_checktip" id="chugl3phSpan"></span>
					<span class="Validform_checktip" id="shuini1phSpan"></span>
					<span class="Validform_checktip" id="kuangfenphSpan"></span>
					<span class="Validform_checktip" id="fenmeihuiphSpan"></span>
					<span class="Validform_checktip" id="shui1phSpan"></span>
					<span class="Validform_checktip" id="waijijia1phSpan"></span>
					<span class="Validform_checktip" id="waijijia2phSpan"></span>
					<span class="Validform_checktip" id="waijijia3phSpan"></span>
					<span class="Validform_checktip" id="waijijia4phSpan"></span>
					
					<span class="Validform_checktip" id="xigl1phidSpan"></span>
					<span class="Validform_checktip" id="xigl2phidSpan"></span>
					<span class="Validform_checktip" id="chugl1phidSpan"></span>
					<span class="Validform_checktip" id="chugl2phidSpan"></span>
					<span class="Validform_checktip" id="chugl3phidSpan"></span>
					<span class="Validform_checktip" id="shuini1phidSpan"></span>
					<span class="Validform_checktip" id="kuangfenphidSpan"></span>
					<span class="Validform_checktip" id="fenmeihuiphidSpan"></span>
					<span class="Validform_checktip" id="shui1phidSpan"></span>
					<span class="Validform_checktip" id="waijijia1phidSpan"></span>
					<span class="Validform_checktip" id="waijijia2phidSpan"></span>
					<span class="Validform_checktip" id="waijijia3phidSpan"></span>
					<span class="Validform_checktip" id="waijijia4phidSpan"></span>
					
					<span class="Validform_checktip" id="shuijiaobiSpan"></span>
				</td>
			</tr>
		</table>
	</t:formvalid>
</body>
</html>
