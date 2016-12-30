<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>原材料进场登记信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">

  function changecailiaoValid(){
	var leixing=$("#leixing").val();
	if(leixing=="" || leixing==null){
		alert("请选择一种材料");
		return false;
	}else{
		if(leixing=="0"){ 
			alert("请选择一种材料");
			return false;
		}else{
			var cunchudidian=document.getElementById("cunchudidian").value;
			var jinchangbianhao=document.getElementById("jinchangbianhao").value;
			var pici=document.getElementById("bgbianhao").value;
			if(pici==null||pici==""||bgbianhao==null||bgbianhao==""||cunchudidian==null||cunchudidian==""){
				var nullzhi="";
				if(pici==null||pici==""){
					nullzhi+="批次,";
				}
				if(bgbianhao==null||bgbianhao==""){
					nullzhi+="检测报告编号,";
				}
				if(cunchudidian==null||cunchudidian==""){
					nullzhi+="存储地点";
				}
				alert(nullzhi+"不能为空");
				return false;
			}else{
				return true;
			}
		}
		}
	}
  
  
  function test(){
	  if(changecailiaoValid()){
		  return true;
	  }else{
		  return false;
	  }
  }
  
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="sYclAllController.do?doUpdate" tiptype="1" >
			<input id="id" name="id" type="hidden" value="${sYclAllPage.id }">
			<input name="id" type="hidden" value="${depart.id }">
			<input name="lft" type="hidden" value="${depart.lft }">
			<input name="rgt" type="hidden" value="${depart.rgt }">		
					<table cellpadding="0" cellspacing="1" class="formtable">
						<tr>
							<td align="right"><label class="Validform_label">原材料进场登记编号:</label></td>
							<td class="value"> <input id="jinchangbianhao" name="jinchangbianhao" type="text" style="width: 150px" class="inputxt" datatype="*">
							<span class="Validform_checktip"><font color="red">*必填*</font></span><label class="Validform_label" style="display: none;"></label></td>
							
							<td align="right"><label class="Validform_label">原材类型:</label></td>
							<td class="value">
									<select id="leixing" name="leixing" style="height:24px;width:155px;" datatype="*" nullmsg="请选择原材类型">
										<option value="">请选择</option>
										<option value="水">水</option>
										<option value="水泥">水泥</option>
										<option value="粗集料">粗集料</option>
										<option value="细集料">细集料</option>
										<option value="粉煤灰">粉煤灰</option>
										<option value="矿粉">矿粉</option>
										<option value="外加剂">外加剂</option>
									</select>
							<span class="Validform_checktip"><font color="red">*必选*</font></span>
							</td>
							
						</tr>
						<tr>
							<td align="right">
							<label class="Validform_label">
								原材料名称:
							</label>
							</td>
							<td class="value">
								<input id="mingcheng" name="mingcheng" type="text" style="width: 150px" class="inputxt" datatype="*">
								<span class="Validform_checktip"><font color="red">*必填*</font></span>
								<label class="Validform_label" style="display: none;">原材料名称</label>
							</td>
							<td align="right">
								<label class="Validform_label">原材料进场时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" readonly="readonly" id="rukushijian" name="rukushijian" datatype="*" value="${time}" >  
								<span class="Validform_checktip"><font color="red">*必选*</font></span>
								<label class="Validform_label" style="display: none;">原材料进场时间</label>
							</td>
						</tr>
						<!-- 产地、厂家 -->		
						<tr>
								<td align="right">
									<label class="Validform_label">
										产地:
									</label>
								</td>
								<td class="value">
								     	 <input id="chandi" name="chandi" type="text" style="width: 150px" class="inputxt"  
											               
											               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">产地</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							生产厂家:
						</label>
					</td>
					<td class="value">
					     	 <input id="scchangjia" name="scchangjia" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生产厂家</label>
						</td>
					</tr>
					
					
			<!-- 规格型号 -->			
					<tr>
					<td align="right">
						<label class="Validform_label">
							规格/型号:
						</label>
					</td>
					<td class="value">
						<input id="guige" name="guige" type="text" style="width: 150px" class="inputxt" nullmsg="请填写规格/型号" datatype="*">
						<span class="Validform_checktip"><font color="red">*必选*</font></span>
						<label class="Validform_label" style="display: none;"></label>
						 </td>
					<td align="right">
						<label class="Validform_label">
							存储地点:
						</label>
					</td>
					<td class="value"> 
						<input id="cunchudidian" name="cunchudidian" type="text" style="width: 150px" class="inputxt" >
						<label class="Validform_label" style="display: none;">存储地点</label>
					</td>
					</tr>
				<!-- 进场数量、产品批号 -->	
				<tr>
					<td align="right">
						<label class="Validform_label">
							进场数量(t):
						</label>
					</td>
					<td class="value">
					     	 <input id="jcshuliang" name="jcshuliang" type="text" style="width: 91px;height:17px;" class="inputxt" datatype="/^(([0-9]+[\.]?[0-9]+)|[1-9])$/" nullmsg="请填写进场数量" errormsg="请填写数字" >
							 <select id="danwei" name="danwei" style="height:24px;width:55px;" datatype="*" >
										<option value="吨">吨</option>
										<option value="千克">千克</option>
										<option value="立方">立方</option>
									</select>
							<span class="Validform_checktip"><font color="red">*必填数字*</font></span>
							<label class="Validform_label" style="display: none;">进场数量(t)</label>
						</td>
						<td align="right"><label class="Validform_label">批次:</label></td>
						<td class="value"><input id="pici" name="pici" type="text" style="width: 150px" class="inputxt" datatype="*" >
						<span class="Validform_checktip"><font color="red">*必填*</font></span><label class="Validform_label" style="display: none;">批次</label></td>
					
					</tr>
					
					<!-- 拟使用工程部位、取样日期 -->	
				<tr>
					<td align="right">
						<label class="Validform_label">
							拟使用工程部位:
						</label>
					</td>
					<td class="value">
					     	 <input id="syxingmu" name="syxingmu" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">拟使用工程部位</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							材料接收人:
						</label>
					</td>
					<td class="value"> <input id="jieshouren" name="jieshouren" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">材料接收人</label>
							</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
							所属机构:
							</label>
						</td>
							<td class="value" colspan="3">
									<select id="tspdepartId" name="tspdepartId" style="height:24px;width:157px;" datatype="*" errormsg="该字段不为空">
										<c:forEach items="${departlist}" var="lilun">
											<option value="${lilun.id}" >${lilun.departname}</option>
										</c:forEach>
									</select>
							</td>
					</tr>
					<tr>
						<td align="right">
						<label class="Validform_label">
							备注:
						</label>
						</td>
						<td class="value" colspan="3">
							<textarea rows="5" cols="80" name="beizhu"></textarea>
						</td>
					</tr>
					</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/shtoone/qms/bhz/sYclAll.js"></script>		