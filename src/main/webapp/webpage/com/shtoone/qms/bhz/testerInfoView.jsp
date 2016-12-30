<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>人员信息</title>
  <t:base type="ckfinder,ckeditor,jquery,easyui,tools,DatePicker"></t:base>
  <link rel="stylesheet" type="text/css" href="plug-in/jquery-ui/css/ui-lightness/jquery-ui-1.9.2.custom.min.css">
  <script type="text/javascript">
   $(function() {
		$('#testerinfotspdepartId').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=3',
			onClick: function(node){
				$("#testerinfoListinputtspdepartId").val(node.id);
				$("#shiyanshiGuid").val(node.id);
				//banhezhanxinxiSelect(node.id,"handsetListshebeibianhao","1");
			}
		});
		//banhezhanxinxiSelect("","handsetListshebeibianhao","1");
	});
   </script>
 </head>
 <body >
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="testerInfoViewController.do?save">
			<input id="id" name="id" type="hidden" value="${testerInfoViewPage.id }">
			<table style="width: 1000px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr><td align="center" colspan="7"><font color="#000000" style="font-weight: bolder;font-size: large;">人员信息登记表</font></td></tr>
				<tr>
					<td align="center">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value" colspan="2">
						<input class="inputxt" id="fTrpname" name="fTrpname" ignore="ignore"
							   value="${testerInfoViewPage.FTrpname}">
						<span class="Validform_checktip"></span>
					</td>
					<td align="center">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value" colspan="2">
						<%-- <input class="inputxt" id="fTrpsex" name="fTrpsex" ignore="ignore"
							   value="${testerInfoViewPage.FTrpsex}"> --%>
						<label><input id="fTrpsex" name="fTrpsex" type="radio" value="1" <c:if test="${testerInfoViewPage.FTrpsex==1}">checked="checked"</c:if>/>男</label>
						<label><input id="fTrpsex" name="fTrpsex" type="radio" value="2" <c:if test="${testerInfoViewPage.FTrpsex==2}">checked="checked"</c:if>/>女</label>
						<span class="Validform_checktip"></span>
					</td>
					<td rowspan="4" align="center">
						<t:ckfinder name="fPhotopath"  uploadType="Images" value="${testerInfoViewPage.FPhotopath}" width="80" height="100" buttonClass="ui-button" buttonValue="图像"  ></t:ckfinder>
					</td>
				</tr>
				<tr>
				<td align="center">
						<label class="Validform_label">
							年龄:
						</label>
					</td>
					<td class="value" colspan="2">
						<input class="inputxt" id="fTrpage" name="fTrpage" ignore="ignore"
							   value="${testerInfoViewPage.FTrpage}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
					<td align="center">
						<label class="Validform_label">
							出生日期:
						</label>
					</td>
					<td class="value" colspan="2">
					<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly"   id="fbirthday" name="fbirthday" value="${testerInfoViewPage.fbirthday}" datatype="*"> 
						<%-- <input class="inputxt" id="fbirthday" name="fbirthday" ignore="ignore"
							   value="${testerInfoViewPage.fbirthday}"> --%>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<!-- 组织机构 -->
				<tr>
				<td align="center">
						<label class="Validform_label">
							所属试验室:
						</label>
					</td>
					<td class="value" colspan="2">
						<input id="testerinfotspdepartId" name="testerinfotspdepartId"  value="${depart.TSPDepart.departname}" style="height:27px;width:180px;"> <!-- style="height:27px;width:180px;" -->
						<div><input id="testerinfoListinputtspdepartId" name="departid" style="display: none;" value="${depart.TSPDepart.id}"></div>
						 
						<input class="inputxt" id="shiyanshiGuid" name="shiyanshiGuid" 
							   value="${testerInfoViewPage.shiyanshiGuid}" datatype="*" type="hidden">
						<!-- <span class="Validform_checktip"></span> -->
					</td>
					
					<td align="center">
						<label class="Validform_label">
							工作日期:
						</label>
					</td>
					<td class="value" colspan="2">
					<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly"   id="fWorkdate" name="fWorkdate" value="${testerInfoViewPage.FWorkdate}" datatype="*"> 
						<%-- <input class="inputxt" id="fWorkdate" name="fWorkdate" ignore="ignore"
							   value="${testerInfoViewPage.FWorkdate}"> --%>
						<span class="Validform_checktip"></span>
					</td>
					
				</tr>
				<tr>
					<td align="center">
						<label class="Validform_label">
							身份证号:
						</label>
					</td>
					<td class="value" colspan="5">
						<input class="inputxt" id="fIdentitycode" name="fIdentitycode" ignore="ignore"
							   value="${testerInfoViewPage.FIdentitycode}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="center">
						<label class="Validform_label">
							专业:
						</label>
					</td>
					<td class="value" colspan="2">
						<input class="inputxt" id="fTrpspecial" name="fTrpspecial" ignore="ignore"
							   value="${testerInfoViewPage.FTrpspecial}">
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="center">
						<label class="Validform_label">
							毕业学校:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="fTrpscool" name="fTrpscool" ignore="ignore"
							   value="${testerInfoViewPage.FTrpscool}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="center">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value" colspan="2">
						<select id="fTrpxl" name="fTrpxl">
							<option value="0" <c:if test="${testerInfoViewPage.FTrpxl==0}">selected="selected"</c:if> >——请选择学历——</option>
							<option value="1" <c:if test="${testerInfoViewPage.FTrpxl==1}">selected="selected"</c:if>>高中</option>
							<option value="2" <c:if test="${testerInfoViewPage.FTrpxl==2}">selected="selected"</c:if>>中专</option>
							<option value="3" <c:if test="${testerInfoViewPage.FTrpxl==3}">selected="selected"</c:if>>专科</option>
							<option value="4" <c:if test="${testerInfoViewPage.FTrpxl==4}">selected="selected"</c:if>>本科</option>
							<option value="5" <c:if test="${testerInfoViewPage.FTrpxl==5}">selected="selected"</c:if>>硕士</option>
							<option value="6" <c:if test="${testerInfoViewPage.FTrpxl==6}">selected="selected"</c:if>>博士</option>
						</select>
						<%-- <input class="inputxt" id="fTrpxl" name="fTrpxl" ignore="ignore"
							   value="${testerInfoViewPage.FTrpxl}"> --%>
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="center">
						<label class="Validform_label">
							工作经验:
						</label>
					</td>
					<td class="value" colspan="3">
						<input class="inputxt" id="fPostime" name="fPostime" ignore="ignore"
							   value="${testerInfoViewPage.FPostime}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<tr>
					<td align="center">
						<label class="Validform_label">
							技术职称:
						</label>
					</td>
					<td class="value" colspan="2">
						<select id="fJszc" name="fJszc">
							<option value="0" <c:if test="${testerInfoViewPage.FJszc==0}">selected="selected"</c:if> >——请选择职称——</option>
							<option value="1" <c:if test="${testerInfoViewPage.FJszc==1}">selected="selected"</c:if>>助理工程师</option>
							<option value="2" <c:if test="${testerInfoViewPage.FJszc==2}">selected="selected"</c:if>>工程师</option>
							<option value="3" <c:if test="${testerInfoViewPage.FJszc==3}">selected="selected"</c:if>>高级工程师</option>
							<option value="4" <c:if test="${testerInfoViewPage.FJszc==4}">selected="selected"</c:if>>教授级工程师</option>
							<option value="5" <c:if test="${testerInfoViewPage.FJszc==5}">selected="selected"</c:if>>其他</option>
						</select>
						<%-- <input class="inputxt" id="fJszc" name="fJszc" ignore="ignore"
							   value="${testerInfoViewPage.FJszc}"> --%>
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="center">
						<label class="Validform_label">
							岗位/职务:
						</label>
					</td>
					<td class="value">
						<select id="fZw" name="fZw">
							<option value="0" <c:if test="${testerInfoViewPage.FZw==0}">selected="selected"</c:if> >——请选择职务——</option>
							<option value="1" <c:if test="${testerInfoViewPage.FZw==1}">selected="selected"</c:if>>试验室主任</option>
							<option value="2" <c:if test="${testerInfoViewPage.FZw==2}">selected="selected"</c:if>>技术负责人</option>
							<option value="3" <c:if test="${testerInfoViewPage.FZw==3}">selected="selected"</c:if>>试验员</option>
							<option value="4" <c:if test="${testerInfoViewPage.FZw==4}">selected="selected"</c:if>>质量负责人</option>
							<option value="5" <c:if test="${testerInfoViewPage.FZw==5}">selected="selected"</c:if>>试验室副主任</option>
							<option value="6" <c:if test="${testerInfoViewPage.FZw==5}">selected="selected"</c:if>>其他</option>
							<option value="7" <c:if test="${testerInfoViewPage.FZw==5}">selected="selected"</c:if>>试验室工程师</option>
						</select>
						<%-- <input class="inputxt" id="fZw" name="fZw" ignore="ignore"
							   value="${testerInfoViewPage.FZw}"> --%>
						<span class="Validform_checktip"></span>
					</td>
					
					<td align="center">
						<label class="Validform_label">
							联系电话:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fTrptel" name="fTrptel" ignore="ignore"
							   value="${testerInfoViewPage.FTrptel}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<tr>
					<td align="center">
						<label class="Validform_label">
							教育经历:
						</label>
					</td>
					<td class="value" colspan="6">
						<textarea rows="4" cols="150" id="fJyjl" name="fJyjl" >${testerInfoViewPage.FJyjl}</textarea>	
						<%-- <input class="inputxt" id="fJyjl" name="fJyjl" ignore="ignore"
							   value="${testerInfoViewPage.FJyjl}"> --%>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<tr>
					<td align="center">
						<label class="Validform_label">
							工作经历:
						</label>
					</td>
					<td class="value" colspan="6">
					<textarea rows="4" cols="150" id="fGzjl" name="fGzjl" >${testerInfoViewPage.FGzjl}</textarea>
						<%-- <input class="inputxt" id="fGzjl" name="fGzjl" ignore="ignore"
							   value="${testerInfoViewPage.FGzjl}"> --%>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				
				<tr>
					<td align="center">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value" colspan="6">
					<textarea rows="4" cols="150" id="fBake" name="fBake" >${testerInfoViewPage.FBake}</textarea>
						<%-- <input class="inputxt" id="fBake" name="fBake" ignore="ignore"
							   value="${testerInfoViewPage.FBake}"> --%>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<tr><td colspan="7" align="center">图片上传：(支持格式：jpg,png,gif  单个文件最大500kb)</td></tr>
				<tr>
					<td align="center">
						<label class="Validform_label">
							身份证:
						</label>
					</td>
					<td class="value" colspan="6">
						<t:ckfinder name="shenfenzhengPATH"  uploadType="Images" value="${testerInfoViewPage.shenfenzhengPATH}" width="80" height="100" buttonClass="ui-button" buttonValue="图像"  ></t:ckfinder> 
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="center">
						<label class="Validform_label">
							毕业证:
						</label>
					</td>
					<td class="value" colspan="6">
						 <t:ckfinder name="biyezhengPATH"  uploadType="Images" value="${testerInfoViewPage.biyezhengPATH}" width="80" height="100" buttonClass="ui-button" buttonValue="图像"  ></t:ckfinder>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="center">
						<label class="Validform_label">
							资格上岗证:
						</label>
					</td>
					<td class="value" colspan="6">
						 <t:ckfinder name="shangganzhengPATH"  uploadType="Images" value="${testerInfoViewPage.shangganzhengPATH}" width="80" height="100" buttonClass="ui-button" buttonValue="图像"  ></t:ckfinder>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<tr>
					<td align="center">
						<label class="Validform_label">
							其他证件:
						</label>
					</td>
					<td class="value" colspan="6">
						 <t:ckfinder name="qitazhengPATH"  uploadType="Images" value="${testerInfoViewPage.qitazhengPATH}" width="80" height="100" buttonClass="ui-button" buttonValue="图像"  ></t:ckfinder>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				
				 <!-- <tr>
					<td align="right">
						<label class="Validform_label">
							testerGuid:
						</label>
					</td>
					<td class="value"> -->
						<input class="inputxt" id="testerGuid" name="testerGuid" 
							   value="0"  type="hidden" >
				<!-- 		<span class="Validform_checktip"></span>
					</td>
				</tr> -->
				
			</table>
		</t:formvalid>
 </body>