<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>设备信息管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/jquery/jquery-1.8.3.min.js"></script>
  <script type="text/javascript">
  	function save() {
		alert("保存");
	}
  	
  	function add() {
  		alert("增加一行");
  		
  	       var tr="<tr><td align='center'><input type='text'></td> <td align='center'><input type='text'></td>"+
  	       "<td align='center'><input type='text'></td>	<td align='center'><input type='text'></td>"+
  	       "<td align='center'><input type='text'></td>"+
  	       "<td align='center'><input type='text'></td>"+
			"<td align='center'><input type='button' value=''  onclick='save()'>"+
			"<td align='center'><input type='button' value='+' onclick='add()'></td>"+
			"<td align='center'><input type='button' value='-' onclick='del()'></td></tr>";
		 $("#jiaozhun").append(tr);   
  	    
	}
  	
  	function del() {
  		alert("删除一行");
  		var ls_t=document.all("jiaozhun");
  		ls_t.deleteRow(ls_t.rows.length-1);//每次点击都删除maillist的最后一行
	}
  	
  	
  	function savew() {
		alert("保存");
	}
  	
  	function addw() {
  		alert("增加一行");
  		
  	       var tr="<tr><td align='center'><input type='text'></td> <td align='center'><input type='text'></td>"+
  	       "<td align='center'><input type='text'></td>	<td align='center'><input type='text'></td>"+
  	       "<td align='center'><input type='text'></td>"+
  	       ""+
			"<td align='center'><input type='button' value=''  onclick='savew()'>"+
			"<td align='center'><input type='button' value='+' onclick='addw()'></td>"+
			"<td align='center'><input type='button' value='-' onclick='delw()'></td></tr>";
		 $("#weixiu").append(tr);   
  	    
	}
  	
  	function delw() {
  		alert("删除一行");
  		var ls_t=document.all("weixiu");
  		ls_t.deleteRow(ls_t.rows.length-1);//每次点击都删除maillist的最后一行
	}
  </script>
 </head>
 <body >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="v_ShebeiInfoController.do?save">
			<input id="id" name="id" type="hidden" value="${v_ShebeiInfoPage.id }">
			<table style="width: 1000px;height: 510px" cellpadding="0" cellspacing="1" class="formtable">
			<tr><td><div style="width:920px ;height:290px;border:0 solid navy;overflow:auto;">
			
			<table style="width: 900px;height: 250px" cellpadding="0" cellspacing="1" class="formtable">
			<tr><td align="center" colspan="7"><font color="#000000" style="font-weight: bolder;font-size: large;">试验室设备数据录入</font></td></tr>
			<tr cellpadding="0" cellspacing="0"><td class="value" colspan="3"></td><td>设备类型</td><td class="value"colspan="3"> 
				<select>
					<option>--请选择采集类型---</option>
					<option>可采集设备</option>
					<option>不可采集设备</option>
				</select></td></tr>
			<tr align="center">
				<td> <label class="Validform_label">内部编号：</label></td>
				<td class="value" colspan="2"><input class="inputxt" id="neibubianhao" name="neibubianhao" ignore="ignore"
							   value="${v_ShebeiInfoPage.neibubianhao}">
						<span class="Validform_checktip"></span></td>
				<td><label class="Validform_label">设备编号：</label></td>
				<td class="value"colspan="3"><input class="inputxt" id="shebeibianhao" name="shebeibianhao" ignore="ignore"
							   value="${v_ShebeiInfoPage.shebeibianhao}">
						<span class="Validform_checktip"></span></td></tr>
			<tr align="center">
				<td><label class="Validform_label">设备简称：</label></td>
				<td class="value"  colspan="2">
						<input class="inputxt" id="shebeijiancheng" name="shebeijiancheng" ignore="ignore"
							   value="${v_ShebeiInfoPage.shebeijiancheng}">
						<span class="Validform_checktip"></span></td>
				<td><label class="Validform_label">试验设备名称：</label></td ><td class="value"colspan="3">
						<input class="inputxt" id="shebeiname" name="shebeiname" ignore="ignore"
							   value="${v_ShebeiInfoPage.shebeiname}">
						<span class="Validform_checktip"></span></td></tr>
			<tr align="center">
				<td><label class="Validform_label">型号规格：</label></td><td class="value" colspan="2"> 
						<input class="inputxt" id="guige" name="guige" ignore="ignore"
							   value="${v_ShebeiInfoPage.guige}">
						<span class="Validform_checktip"></span>
					 </td>
				<td><label class="Validform_label">制造厂商：</label></td><td class="value"colspan="3"><input class="inputxt" id="changjia" name="changjia" ignore="ignore"
							   value="${v_ShebeiInfoPage.changjia}">
						<span class="Validform_checktip"></span></td></tr>
			<tr align="center">
				<td><label class="Validform_label">出厂编号：</label></td><td class="value" colspan="2"><input class="inputxt" id="chuchangnumber" name="chuchangnumber" ignore="ignore"
							   value="${v_ShebeiInfoPage.chuchangnumber}">
						<span class="Validform_checktip"></span></td>
				<td><label class="Validform_label">出厂日期：</label></td><td class="value"colspan="3"><input class="Wdate" readonly="readonly"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="chuchangriqi" name="chuchangriqi" ignore="ignore"
							     value="${v_ShebeiInfoPage.chuchangriqi}">
						<span class="Validform_checktip"></span></td></tr>
			<tr align="center">
				<td><label class="Validform_label">检定周期（月）：</label></td><td class="value" colspan="2">
					<input class="inputxt" id="jiandingzhouqi" name="jiandingzhouqi" ignore="ignore"
							   value="${v_ShebeiInfoPage.jiandingzhouqi}" datatype="n">
						<span class="Validform_checktip"></span></td>
				<td><label class="Validform_label">购置日期：</label></td><td class="value"colspan="3">
					<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" datatype="*" style="width: 150px" id="gouzhiriqi" name="gouzhiriqi" ignore="ignore"
							     value="${v_ShebeiInfoPage.gouzhiriqi}">
						<span class="Validform_checktip"></span></td></tr>
			<tr align="center">
				<td><label class="Validform_label">数量：</label></td><td class="value" colspan="2"><input class="inputxt" id="amount" name="amount" ignore="ignore"
							   value="${v_ShebeiInfoPage.amount}">
						<span class="Validform_checktip"></span></td>
				<td><label class="Validform_label">检定单位：</label></td><td class="value"colspan="3"><input class="inputxt" id="jiandingdanwei" name="jiandingdanwei" ignore="ignore"
							   value="${v_ShebeiInfoPage.jiandingdanwei}">
						<span class="Validform_checktip"></span></td></tr>
			
			<tr align="center">
				<td><label class="Validform_label">单价：</label></td><td class="value" colspan="2"><input class="inputxt" id="danjia" name="danjia" ignore="ignore"
							   value="${v_ShebeiInfoPage.danjia}">
						<span class="Validform_checktip"></span></td>
				<td><label class="Validform_label">最近检定日期：</label></td><td class="value"colspan="3"><input class="Wdate" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="jiandingriqi" name="jiandingriqi" ignore="ignore"
							     value="${v_ShebeiInfoPage.jiandingriqi}">
						<span class="Validform_checktip"></span></td></tr>
			<tr align="center">
				<td><label class="Validform_label">保管人：</label></td><td class="value" colspan="2"><input class="inputxt" id="baoguanren" name="baoguanren" ignore="ignore"
							   value="${v_ShebeiInfoPage.baoguanren}">
						<span class="Validform_checktip"></span></td>
				<td><label class="Validform_label">下次检定日期：</label></td><td class="value"colspan="3"><input class="Wdate" readonly="readonly" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="nextjiandingriqi" name="nextjiandingriqi" ignore="ignore"
							     value="${v_ShebeiInfoPage.nextjiandingriqi}">
						<span class="Validform_checktip"></span></td></tr>
			<tr align="center">
				<td><label class="Validform_label">所属操作室：</label></td><td class="value" colspan="2"><input class="inputxt" id="caozuoshi" name="caozuoshi" ignore="ignore"
							   value="${v_ShebeiInfoPage.caozuoshi}">
						<span class="Validform_checktip"></span></td>
				<td><label class="Validform_label">所属试验室：</label></td><td class="value"  colspan="3"><input class="inputxt" id="shiyanshiGuid" name="shiyanshiGuid" 
							   value="${v_ShebeiInfoPage.shiyanshiGuid}" datatype="*">
						<span class="Validform_checktip"></span></td></tr>
			<tr align="center">
				<td><label class="Validform_label">备注：</label></td><td class="value" colspan="6"><input class="inputxt" id="remark" name="remark" ignore="ignore"
							   value="${v_ShebeiInfoPage.remark}">
						<span class="Validform_checktip"></span></td> </tr>
			</table>
			</div></td></tr>
			
			<tr><td><div style="width:920px;height:90px;border:0 solid navy;overflow:auto;" >
			<table style="width: 900px;height: 80px" cellpadding="0" cellspacing="1" class="formtable" id="jiaozhun">
				<tr><td colspan="6" align="center"><font color="#000000" style="font-weight: bolder;font-size: large;">设备校准记录</font></td></tr>
				<tr><td align="center">校准时间</td><td align="center">校准人员</td><td align="center">校准单位</td><td align="center">校准结果</td>
					<td align="center">下次时间</td><td align="center">备注</td><td align="center">存</td><td align="center">增</td><td align="center">删</td></tr>
				<tr><td align="center"><input type="text"></td>
					<td align="center"><input type="text"></td>
					<td align="center"><input type="text"></td>
					<td align="center"><input type="text"></td>
					<td align="center"><input type="text"></td>
					<td align="center"><input type="text"></td>
					<td align="center"><input type="button" value=""  onclick="save()">
					<td align="center"><input type="button" value="+" onclick="add()"></td>
					<td align="center"><input type="button" value="-" onclick="del()"></td></tr>
			</table>
			</div>
			</td>
			</tr>
			
			<tr><td><div style="width:920px;height:90px;border:0 solid navy;overflow:auto;">
			<table style="width: 900px;height: 80px" cellpadding="0" cellspacing="1" class="formtable" id="weixiu">
				<tr><td colspan="6" align="center"><font color="#000000" style="font-weight: bolder;font-size: large;">设备维修记录</font></td></tr>
				<tr><td align="center">维修时间</td><td align="center">维修人员</td><td align="center">维修电话</td><td align="center">维修内容</td>
					<td align="center">维修结果</td> <td align="center">存</td><td align="center">增</td><td align="center">删</td></tr>
				<tr><td align="center"><input type="text"></td>
					<td align="center"><input type="text"></td>
					<td align="center"><input type="text"></td>
					<td align="center"><input type="text"></td>
					<td align="center"><input type="text"></td>
					<td align="center"><input type="button" value=""  onclick="savew()">
					<td align="center"><input type="button" value="+" onclick="addw()"></td>
					<td align="center"><input type="button" value="-" onclick="delw()"></td></tr>
			</table>
			</div>
			</td>
			</tr>
			</table>
		</t:formvalid>
 </body>