<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>部门信息</title>
<t:base type="jquery,easyui,tools"></t:base>
<script type="text/javascript">
	$(function() {
		$('#cc').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}',
			onClick: function(node){
				$("#tspdepartId").val(node.id);
				$("#cc").val(node.name);
			}
		});
	});
</script>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj" layout="div" dialog="true" action="systemController.do?saveDepart">
	<input name="id" type="hidden" value="${depart.id }">
	<input name="lft" type="hidden" value="${depart.lft }">
	<input name="rgt" type="hidden" value="${depart.rgt }">
	<fieldset class="step">
	<div class="form"><label class="Validform_label"> 部门名称: </label> <input name="departname" class="inputxt" value="${depart.departname }" validType="t_s_depart,departname,id" datatype="s3-20">
	<span class="Validform_checktip">部门名称在3~20位字符</span></div>
	<div class="form"><label class="Validform_label"> 职能描述: </label> <input name="description" class="inputxt" value="${depart.description }"></div>
	<div class="form"><label class="Validform_label"> 经度: </label> <input name="lng" class="inputxt" value="${depart.lng }"></div>
	<div class="form"><label class="Validform_label"> 纬度: </label> <input name="lat" class="inputxt" value="${depart.lat }"></div>
	<div class="form"><label class="Validform_label"> 类型: </label> 
		<input type="radio" name="type" id="gprstype1" value="1" <c:if test="${depart.type=='1'}">checked="checked"</c:if>/>水泥混凝土
		<input type="radio" name="type" id="gprstype1" value="2" <c:if test="${depart.type=='2'}">checked="checked"</c:if>/>沥青混凝土
		<input type="radio" name="type" id="gprstype1" value="3" <c:if test="${depart.type=='3'}">checked="checked"</c:if>/>试验室
		<input type="radio" name="type" id="gprstype1" value="4" <c:if test="${depart.type=='4'}">checked="checked"</c:if>/>项目部
		<input type="radio" name="type" id="gprstype1" value="5" <c:if test="${depart.type=='5'}">checked="checked"</c:if>/>水稳拌合站
	</div>
	<div class="form"><label class="Validform_label"> 上级部门: </label> <input id="cc"  value="${depart.TSPDepart.departname}">
	<input id="tspdepartId" name="TSPDepart.id" style="display: none;"
		value="${depart.TSPDepart.id}"></div>
	</fieldset>
</t:formvalid>
</body>
</html>
