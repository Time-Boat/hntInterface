<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>s_ycl_guigexinghaom</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="sYclGuigexinghaomController.do?doAdd">
					<input id="id" name="id" type="hidden" value="${sYclGuigexinghaomPage.id }">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">类型:</label>
			</td>
			<td class="value">
		     	 <!-- <input id="type" name="type" type="text" style="width: 150px" class="inputxt"  
					               
					               > -->
				<select name="type" id="type">
									<option value="0">选择原材料</option>
									<option value="水泥">水泥</option>
									<option value="粉煤灰">粉煤灰</option>
									<option value="矿粉">矿粉</option>
									<option value="粗骨料">粗骨料</option>
									<option value="细骨料">细骨料</option>
									<option value="水">水</option>
									<option value="外加剂">外加剂</option>
									<option value="其他">其他</option>
							</select>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">类型</label>
			</td>
			<td align="right">
				<label class="Validform_label">主表规格:</label>
			</td>
			<td class="value">
		     	 <input id="selectkey" name="selectkey" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">主表规格</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">规格描述:</label>
			</td>
			<td class="value">
		     	 <input id="selectvalue" name="selectvalue" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">规格描述</label>
			</td>
			<td align="right">
				<label class="Validform_label">原材料名称:</label>
			</td>
			<td class="value">
		     	 <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  
					               
					               >
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">原材料名称</label>
			</td>
		</tr>
	</table>
			<div style="width: auto;height: 350px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="sYclGuigexinghaomController.do?sYclGuigexinghaosList&sELECTKEY=${sYclGuigexinghaomPage.sELECTKEY}" icon="icon-search" title="型号子表" id="sYclGuigexinghaos"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_sYclGuigexinghaos_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="sYclGuigexinghaosList[#index#].mselectkey" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               >
					  <label class="Validform_label" style="display: none;">子表型号</label>
				  </td>
				 <!--  <td align="left">
					  	<input name="sYclGuigexinghaosList[#index#].selectkey" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               >
					  <label class="Validform_label" style="display: none;">主表规格</label>
				  </td> -->
				  <td align="left">
					  	<input name="sYclGuigexinghaosList[#index#].selectvalue" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               >
					  <label class="Validform_label" style="display: none;">规格描述</label>
				  </td>
				  <td align="left">
					  	<input name="sYclGuigexinghaosList[#index#].remark" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               >
					  <label class="Validform_label" style="display: none;">型号描述</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/shtoone/qms/bhz/sYclGuigexinghaom.js"></script>	