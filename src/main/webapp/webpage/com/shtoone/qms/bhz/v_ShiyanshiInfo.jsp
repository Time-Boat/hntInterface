<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>试验室设置</title>
  <t:base type="ckfinder,ckeditor,jquery,easyui,tools,DatePicker"></t:base>
  <link rel="stylesheet" type="text/css" href="plug-in/jquery-ui/css/ui-lightness/jquery-ui-1.9.2.custom.min.css">
  <script type="text/javascript">
  $(function() {
		$('#shiyanshiinfotspdepartId').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=3',
			onClick: function(node){
				$("#shiyanshiinfoListinputtspdepartId").val(node.id);
				$("#shiyanshiGuid").val(node.id);
				//banhezhanxinxiSelect(node.id,"handsetListshebeibianhao","1");
			}
		});
		//banhezhanxinxiSelect("","handsetListshebeibianhao","1");
	});
  </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="v_ShiyanshiInfoController.do?save">
			<input id="id" name="id" type="hidden" value="${v_ShiyanshiInfoPage.id }">
			<table style="width:1000px;" cellpadding="0" cellspacing="1" class="formtable">
			<tr><td>

			<div style="width:1000px ;height:510px;border:0 solid navy;overflow:auto;">
				<table style="width:1000px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr height="44px"><td colspan="10" align="center"> <font color="#000000" style="font-weight: bolder;font-size: large;">试验室基础信息</font> </td> </tr>
				<!-- 试验室名称需要采用组织机构 -->
				<tr>
					<td align="center">
						<label class="Validform_label">  
							试验室名称:
						</label>
					</td>
					<td class="value" > 
						<input id="shiyanshiinfotspdepartId" name="shiyanshiinfotspdepartId"  value="${depart.TSPDepart.departname}" style="height:27px;width:180px;"> <!-- style="height:27px;width:180px;" -->
						<div><input id="shiyanshiinfoListinputtspdepartId" name="departid" style="display: none;" value="${depart.TSPDepart.id}"></div>
						 
						<input class="inputxt" id="shiyanshiGuid" name="shiyanshiGuid" 
							   value="${v_ShiyanshiInfoPage.shiyanshiGuid}" datatype="*" type="hidden">
						<!-- <span class="Validform_checktip"></span> -->
					</td>
					
					<td align="center">
						<label class="Validform_label">
							试验室编码:
						</label>
					</td>
					<td class="value"> 
						<input class="inputxt" id="fTrcode" name="fTrcode" ignore="ignore"
							   value="${v_ShiyanshiInfoPage.FTrcode}">
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="center">
						<label class="Validform_label">
							检测区段:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fJcqd" name="fJcqd" ignore="ignore"
							   value="${v_ShiyanshiInfoPage.FJcqd}">
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="center">
						<label class="Validform_label">
							经度:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="longitude" name="longitude" ignore="ignore"
							   value="${v_ShiyanshiInfoPage.longitude}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="center">
						<label class="Validform_label">
							纬度:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="latitude" name="latitude" ignore="ignore"
							   value="${v_ShiyanshiInfoPage.latitude}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				
				
				<tr>
					<td align="center">
						<label class="Validform_label">
							邮编:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fPostcode" name="fPostcode" ignore="ignore"
							   value="${v_ShiyanshiInfoPage.FPostcode}">
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="center">
						<label class="Validform_label">
							传真:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fFax" name="fFax" ignore="ignore"
							   value="${v_ShiyanshiInfoPage.FFax}">
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="center">
						<label class="Validform_label">
							联系电话:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fTel" name="fTel" ignore="ignore"
							   value="${v_ShiyanshiInfoPage.FTel}">
						<span class="Validform_checktip"></span>
					</td>
				
				
					<td align="center">
						<label class="Validform_label">
							面积:
						</label>
					</td>
					<td class="value" colspan="3">
						<textarea rows="3" cols="50" id="mianji" name="mianji" >${v_ShiyanshiInfoPage.mianji}</textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<tr>
					<td align="center">
						<label class="Validform_label">
							通讯地址:
						</label>
					</td>
					<td class="value" colspan="5">
						<textarea rows="3" cols="80" id="fAddress" name="fAddress" >${v_ShiyanshiInfoPage.FAddress}</textarea>
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="center">
						<label class="Validform_label">
							主任:
						</label>
					</td>
					<td class="value" colspan="3">
						<textarea rows="3" cols="50" id="zhuren" name="zhuren" >${v_ShiyanshiInfoPage.zhuren}</textarea>
						<%-- <input class="inputxt" id="zhuren" name="zhuren" ignore="ignore"
							   value="${v_ShiyanshiInfoPage.zhuren}"> --%>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
	
				<tr>
					<td align="center" colspan="2">
						<label class="Validform_label">
							母体试验室名称:
						</label>
					</td>
					<td class="value" colspan="2">
						<input class="inputxt" id="fMothroom" name="fMothroom" ignore="ignore"
							   value="${v_ShiyanshiInfoPage.FMothroom}">
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="center" colspan="2">
						<label class="Validform_label">
							委外机构名称:
						</label>
					</td>
					<td class="value" colspan="4">
						<input class="inputxt" id="fWworg" name="fWworg" ignore="ignore"
							   value="${v_ShiyanshiInfoPage.FWworg}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				
				<tr>
					<td align="center" colspan="2">
						<label class="Validform_label">
							母体试验室认证编号:
						</label>
					</td>
					<td class="value" colspan="2">
						<input class="inputxt" id="fMothauth" name="fMothauth" ignore="ignore"
							   value="${v_ShiyanshiInfoPage.FMothauth}">
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="center" colspan="2">
						<label class="Validform_label">
							委外机构地址:
						</label>
					</td>
					<td class="value" colspan="4">
						<input class="inputxt" id="fWwaddress" name="fWwaddress" ignore="ignore"
							   value="${v_ShiyanshiInfoPage.FWwaddress}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
				<!-- 有效期需要采用日期格式 -->
					<td align="center" colspan="2">
						<label class="Validform_label">
							母体试验室认证有效期:
						</label>
					</td>
					<td class="value" colspan="2">
					<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly"   id="fMothvaliddate" name="fMothvaliddate" value="${v_ShiyanshiInfoPage.FMothvaliddate}" datatype="*"> 
						<%-- <input class="inputxt" id="fMothvaliddate" name="fMothvaliddate" ignore="ignore"
							   value="${v_ShiyanshiInfoPage.FMothvaliddate}"> --%>
						<span class="Validform_checktip"></span>
					</td>
				 
					<td align="center" colspan="2">
						<label class="Validform_label">
							委外机构资质认证编号:
						</label>
					</td>
					<td class="value" colspan="4">
						<input class="inputxt" id="fWwauth" name="fWwauth" ignore="ignore"
							   value="${v_ShiyanshiInfoPage.FWwauth}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<tr>
				<!-- 类型为下拉选择    		监理试验室、施工单位试验室 -->
				<td align="center" colspan="2">
						<label class="Validform_label">
							试验室类型:
						</label>
					</td>
					<td class="value" colspan="2">
						<select id="leixin" name="leixin" datatype="n"  value="${v_ShiyanshiInfoPage.leixin}">
								<option value="0" <c:if test="${v_ShiyanshiInfoPage.leixin==0}">selected="selected"</c:if>>请选择试验室类型</option>
						 	 	<option value="1" <c:if test="${v_ShiyanshiInfoPage.leixin==1}">selected="selected"</c:if>>监理试验室</option>
						 	  	<option value="2" <c:if test="${v_ShiyanshiInfoPage.leixin==2}">selected="selected"</c:if>>施工单位试验室</option>
						</select>
					</td>
				<!-- 有效期需要采用日期格式 -->
					<td align="center" colspan="2">
						<label class="Validform_label">
							委外机构认证有效期:
						</label>
					</td>
					<td class="value" colspan="4">
					<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  readonly="readonly"  id="fValiddate" name="fValiddate"
				value="${v_ShiyanshiInfoPage.FValiddate}" datatype="*">  
						<%-- <input class="inputxt" id="fValiddate" name="fValiddate" ignore="ignore"
							   value="${v_ShiyanshiInfoPage.FValiddate}" > --%>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				
				<tr>
					<td align="center" colspan="2">
						<label class="Validform_label">
							试验资料表头（项目名称）:
						</label>
					</td>
					<td class="value" colspan="2">
						<textarea rows="2" cols="35" id="fXmbt" name="fXmbt" >${v_ShiyanshiInfoPage.FXmbt}</textarea>	
						<%-- <input class="inputxt" id="fXmbt" name="fXmbt" ignore="ignore"
							   value="${v_ShiyanshiInfoPage.fXmbt}"> --%>
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="center" colspan="2">
						<label class="Validform_label">
							委外机构检测项目:
						</label>
					</td>
					<td class="value" colspan="4" align="center">
						<textarea rows="2" cols="70" id="fWwrange" name="fWwrange" >${v_ShiyanshiInfoPage.FWwrange}</textarea>	
						<%-- <input class="inputxt" id="fWwrange" name="fWwrange" ignore="ignore"
							   value="${v_ShiyanshiInfoPage.fWwrange}"> --%>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<tr>
					<td align="center" >
						<label class="Validform_label">
							描述信息:
						</label>
					</td>
					<td class="value" colspan="9" align="center">
						<textarea rows="4" cols="180" id="fDesc" name="fDesc" >${v_ShiyanshiInfoPage.FDesc}</textarea>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				</table>
			</div>

</td></tr></table>
		</t:formvalid>
 </body>