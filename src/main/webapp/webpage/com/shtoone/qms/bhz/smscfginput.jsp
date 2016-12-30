<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>水泥混凝土刷新最新数据</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <style type="text/css">
  .inputxt1{
  	width:40px;
  	text-align:center;
  }
  </style>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="topRealMaxhunnintuViewController.do?savesmscfginput">
		
		<input type="hidden" value="${hntissms.id}" name="hntissms.id"/>
		<input type="hidden" value="${Tlow.id}" name="Tlow.id"/>
		<input type="hidden" value="${Thigh.id}" name="Thigh.id"/>
		<input type="hidden" value="${Tnumber.id}" name="Tnumber.id"/>
		<input type="hidden" value="${Tcontent.id}" name="Tcontent.id"/>
		<input type="hidden" value="${Tsheji.id}" name="Tsheji.id"/>
		<input type="hidden" value="${Tsheji2.id}" name="Tsheji2.id"/>
		<input type="hidden" value="${Tlow2.id}" name="Tlow2.id"/>
		<input type="hidden" value="${Thigh2.id}" name="Thigh2.id"/>
		<input type="hidden" value="${Tnumber2.id}" name="Tnumber2.id"/>
		<input type="hidden" value="${Tlow3.id}" name="Tlow3.id"/>
		<input type="hidden" value="${Thigh3.id}" name="Thigh3.id"/>
		<input type="hidden" value="${Tnumber3.id}" name="Tnumber3.id"/>		
		<input type="hidden" name="hntissms.gprsbianhao" value="${leixinbh}"/>	
		<%--<s:property value="${leixinbh}"/> --%>		
		<input type="hidden" name="Tlow.gprsbianhao" value="${Tlow.gprsbianhao}"/>
		<input type="hidden" name="Thigh.gprsbianhao" value="${Thigh.gprsbianhao}"/>
		<input type="hidden" name="Tnumber.gprsbianhao" value="${Tnumber.gprsbianhao}"/>
		<input type="hidden" name="Tcontent.gprsbianhao" value="${Tcontent.gprsbianhao}"/>
		<input type="hidden" name="Tsheji.gprsbianhao" value="${Tsheji.gprsbianhao}"/>
		<input type="hidden" name="Tsheji2.gprsbianhao" value="${Tsheji2.gprsbianhao}"/>
		<input type="hidden" name="Tlow2.gprsbianhao" value="${Tlow2.gprsbianhao}"/>
		<input type="hidden" name="Thigh2.gprsbianhao" value="${Thigh2.gprsbianhao}"/>
		<input type="hidden" name="Tnumber2.gprsbianhao" value="${Tnumber2.gprsbianhao}"/>
		<input type="hidden" name="Tlow3.gprsbianhao" value="${Tlow3.gprsbianhao}"/>
		<input type="hidden" name="Thigh3.gprsbianhao" value="${Thigh3.gprsbianhao}"/>
		<input type="hidden" name="Tnumber3.gprsbianhao" value="${Tnumber3.gprsbianhao}"/>
		<input type="hidden" name="hntissms.leixin" value="4"/>
		<input type="hidden" name="Tlow.leixin" value="5"/>
		<input type="hidden" name="Thigh.leixin" value="6"/>
		<input type="hidden" name="Tnumber.leixin" value="7"/>
		<input type="hidden" name="Tcontent.leixin" value="8"/>
		<input type="hidden" name="Tsheji.leixin" value="9"/>
		<input type="hidden" name="Tsheji2.leixin" value="16"/>
		<input type="hidden" name="Tlow2.leixin" value="10"/>
		<input type="hidden" name="Thigh2.leixin" value="11"/>
		<input type="hidden" name="Tnumber2.leixin" value="12"/>
		<input type="hidden" name="Tlow3.leixin" value="13"/>
		<input type="hidden" name="Thigh3.leixin" value="14"/>
		<input type="hidden" name="Tnumber3.leixin" value="15"/>
		
			<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<th width="80px">材料名称</th>
				<th width="80px">是否短信报警</th>
				<th>初级下限(项目部)(%)</th>
				<th>初级上限(项目部)(%)</th>
				<th>手机号码</th>
				<th>发送内容([%s]%s:%s实际值%s理论值%s已经%s%s%%)</th>
				<th>设计值(拌和时间)</th>
				<th>设计值(初支拌和时间)</th>
				<th>中级下限(%)(监理)</th>
				<th>中级上限(%)(监理)</th>
				<th>手机号码(监理)</th>
				<th>高级下限(%)(指挥部)</th>
				<th>高级上限(%)(指挥部)</th>
				<th>手机号码(指挥部)</th>
		  	</tr>
		  
				<tr>
					<td align="right">
						<label class="Validform_label">${smscfgfieldname.jiaobanshijian }</label>
					</td>
					<td class="value">
						不报警<input type="radio" name="hntissms.jiaobanshijian" id="gprstype1" value="0" <c:if test="${hntissms.jiaobanshijian=='0'}">checked="checked"</c:if>/>
						&nbsp;&nbsp;&nbsp;报警<input type="radio" name="hntissms.jiaobanshijian" id="gprstype2" value="1" <c:if test="${hntissms.jiaobanshijian=='1'}">checked="checked"</c:if>/>
						<%--
						<input class="inputxt1" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${topRealMaxhunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
						 --%>
					</td>
					<td class="value">
						<input class="inputxt1" id="Tlow.jiaobanshijian" name="Tlow.jiaobanshijian" value="${Tlow.jiaobanshijian }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh.jiaobanshijian" name="Thigh.jiaobanshijian" value="${Thigh.jiaobanshijian }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber.jiaobanshijian" name="Tnumber.jiaobanshijian" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber.jiaobanshijian}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input style="width:100px;" id="Tcontent.jiaobanshijian" name="Tcontent.jiaobanshijian" value="${Tcontent.jiaobanshijian }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji.jiaobanshijian" name="Tsheji.jiaobanshijian" value="${Tsheji.jiaobanshijian }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji2.jiaobanshijian" name="Tsheji2.jiaobanshijian" value="${Tsheji2.jiaobanshijian }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow2.jiaobanshijian" name="Tlow2.jiaobanshijian" value="${Tlow2.jiaobanshijian }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh2.jiaobanshijian" name="Thigh2.jiaobanshijian" value="${Thigh2.jiaobanshijian }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber2.jiaobanshijian" name="Tnumber2.jiaobanshijian" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber2.jiaobanshijian}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow3.jiaobanshijian" name="Tlow3.jiaobanshijian" value="${Tlow3.jiaobanshijian }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh3.jiaobanshijian" name="Thigh3.jiaobanshijian" value="${Thigh3.jiaobanshijian }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber3.jiaobanshijian" name="Tnumber3.jiaobanshijian" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber3.jiaobanshijian}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				
				<tr>
					<td align="right">
						<label class="Validform_label">${smscfgfieldname.shuini1_shijizhi }</label>
					</td>
					<td class="value">
						不报警<input type="radio" name="hntissms.shuini1_shijizhi" id="gprstype1" value="0" <c:if test="${hntissms.shuini1_shijizhi=='0'}">checked="checked"</c:if>/>
						&nbsp;&nbsp;&nbsp;报警<input type="radio" name="hntissms.shuini1_shijizhi" id="gprstype2" value="1" <c:if test="${hntissms.shuini1_shijizhi=='1'}">checked="checked"</c:if>/>
						<%--
						<input class="inputxt1" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${topRealMaxhunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
						 --%>
					</td>
					<td class="value">
						<input class="inputxt1" id="Tlow.shuini1_shijizhi" name="Tlow.shuini1_shijizhi" value="${Tlow.shuini1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh.shuini1_shijizhi" name="Thigh.shuini1_shijizhi" value="${Thigh.shuini1_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber.shuini1_shijizhi" name="Tnumber.shuini1_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber.shuini1_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input style="width:100px;" id="Tcontent.shuini1_shijizhi" name="Tcontent.shuini1_shijizhi" value="${Tcontent.shuini1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji.shuini1_shijizhi" name="Tsheji.shuini1_shijizhi" value="${Tsheji.shuini1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji2.shuini1_shijizhi" name="Tsheji2.shuini1_shijizhi" value="${Tsheji2.shuini1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow2.shuini1_shijizhi" name="Tlow2.shuini1_shijizhi" value="${Tlow2.shuini1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh2.shuini1_shijizhi" name="Thigh2.shuini1_shijizhi" value="${Thigh2.shuini1_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber2.shuini1_shijizhi" name="Tnumber2.shuini1_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber2.shuini1_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow3.shuini1_shijizhi" name="Tlow3.shuini1_shijizhi" value="${Tlow3.shuini1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh3.shuini1_shijizhi" name="Thigh3.shuini1_shijizhi" value="${Thigh3.shuini1_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber3.shuini1_shijizhi" name="Tnumber3.shuini1_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber3.shuini1_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">${smscfgfieldname.shuini2_shijizhi }</label>
					</td>
					<td class="value">
						不报警<input type="radio" name="hntissms.shuini2_shijizhi" id="gprstype1" value="0" <c:if test="${hntissms.shuini2_shijizhi=='0'}">checked="checked"</c:if>/>
						&nbsp;&nbsp;&nbsp;报警<input type="radio" name="hntissms.shuini2_shijizhi" id="gprstype2" value="1" <c:if test="${hntissms.shuini2_shijizhi=='1'}">checked="checked"</c:if>/>
						<%--
						<input class="inputxt1" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${topRealMaxhunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
						 --%>
					</td>
					<td class="value">
						<input class="inputxt1" id="Tlow.shuini2_shijizhi" name="Tlow.shuini2_shijizhi" value="${Tlow.shuini2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh.shuini2_shijizhi" name="Thigh.shuini2_shijizhi" value="${Thigh.shuini2_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber.shuini2_shijizhi" name="Tnumber.shuini2_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber.shuini2_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input style="width:100px;" id="Tcontent.shuini2_shijizhi" name="Tcontent.shuini2_shijizhi" value="${Tcontent.shuini2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji.shuini2_shijizhi" name="Tsheji.shuini2_shijizhi" value="${Tsheji.shuini2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji2.shuini2_shijizhi" name="Tsheji2.shuini2_shijizhi" value="${Tsheji2.shuini2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow2.shuini2_shijizhi" name="Tlow2.shuini2_shijizhi" value="${Tlow2.shuini2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh2.shuini2_shijizhi" name="Thigh2.shuini2_shijizhi" value="${Thigh2.shuini2_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber2.shuini2_shijizhi" name="Tnumber2.shuini2_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber2.shuini2_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow3.shuini2_shijizhi" name="Tlow3.shuini2_shijizhi" value="${Tlow3.shuini2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh3.shuini2_shijizhi" name="Thigh3.shuini2_shijizhi" value="${Thigh3.shuini2_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber3.shuini2_shijizhi" name="Tnumber3.shuini2_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber3.shuini2_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">${smscfgfieldname.kuangfen3_shijizhi }</label>
					</td>
					<td class="value">
						不报警<input type="radio" name="hntissms.kuangfen3_shijizhi" id="gprstype1" value="0" <c:if test="${hntissms.kuangfen3_shijizhi=='0'}">checked="checked"</c:if>/>
						&nbsp;&nbsp;&nbsp;报警<input type="radio" name="hntissms.kuangfen3_shijizhi" id="gprstype2" value="1" <c:if test="${hntissms.kuangfen3_shijizhi=='1'}">checked="checked"</c:if>/>
						<%--
						<input class="inputxt1" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${topRealMaxhunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
						 --%>
					</td>
					<td class="value">
						<input class="inputxt1" id="Tlow.kuangfen3_shijizhi" name="Tlow.kuangfen3_shijizhi" value="${Tlow.kuangfen3_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh.kuangfen3_shijizhi" name="Thigh.kuangfen3_shijizhi" value="${Thigh.kuangfen3_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber.kuangfen3_shijizhi" name="Tnumber.kuangfen3_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber.kuangfen3_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input style="width:100px;" id="Tcontent.kuangfen3_shijizhi" name="Tcontent.kuangfen3_shijizhi" value="${Tcontent.kuangfen3_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji.kuangfen3_shijizhi" name="Tsheji.kuangfen3_shijizhi" value="${Tsheji.kuangfen3_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji2.kuangfen3_shijizhi" name="Tsheji2.kuangfen3_shijizhi" value="${Tsheji2.kuangfen3_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow2.kuangfen3_shijizhi" name="Tlow2.kuangfen3_shijizhi" value="${Tlow2.kuangfen3_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh2.kuangfen3_shijizhi" name="Thigh2.kuangfen3_shijizhi" value="${Thigh2.kuangfen3_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber2.kuangfen3_shijizhi" name="Tnumber2.kuangfen3_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber2.kuangfen3_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow3.kuangfen3_shijizhi" name="Tlow3.kuangfen3_shijizhi" value="${Tlow3.kuangfen3_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh3.kuangfen3_shijizhi" name="Thigh3.kuangfen3_shijizhi" value="${Thigh3.kuangfen3_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber3.kuangfen3_shijizhi" name="Tnumber3.kuangfen3_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber3.kuangfen3_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">${smscfgfieldname.feimeihui4_shijizhi }</label>
					</td>
					<td class="value">
						不报警<input type="radio" name="hntissms.feimeihui4_shijizhi" id="gprstype1" value="0" <c:if test="${hntissms.feimeihui4_shijizhi=='0'}">checked="checked"</c:if>/>
						&nbsp;&nbsp;&nbsp;报警<input type="radio" name="hntissms.feimeihui4_shijizhi" id="gprstype2" value="1" <c:if test="${hntissms.feimeihui4_shijizhi=='1'}">checked="checked"</c:if>/>
						<%--
						<input class="inputxt1" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${topRealMaxhunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
						 --%>
					</td>
					<td class="value">
						<input class="inputxt1" id="Tlow.feimeihui4_shijizhi" name="Tlow.feimeihui4_shijizhi" value="${Tlow.feimeihui4_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh.feimeihui4_shijizhi" name="Thigh.feimeihui4_shijizhi" value="${Thigh.feimeihui4_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber.feimeihui4_shijizhi" name="Tnumber.feimeihui4_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber.feimeihui4_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input style="width:100px;" id="Tcontent.feimeihui4_shijizhi" name="Tcontent.feimeihui4_shijizhi" value="${Tcontent.feimeihui4_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji.feimeihui4_shijizhi" name="Tsheji.feimeihui4_shijizhi" value="${Tsheji.feimeihui4_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji2.feimeihui4_shijizhi" name="Tsheji2.feimeihui4_shijizhi" value="${Tsheji2.feimeihui4_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow2.feimeihui4_shijizhi" name="Tlow2.feimeihui4_shijizhi" value="${Tlow2.feimeihui4_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh2.feimeihui4_shijizhi" name="Thigh2.feimeihui4_shijizhi" value="${Thigh2.feimeihui4_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber2.feimeihui4_shijizhi" name="Tnumber2.feimeihui4_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber2.feimeihui4_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow3.feimeihui4_shijizhi" name="Tlow3.feimeihui4_shijizhi" value="${Tlow3.feimeihui4_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh3.feimeihui4_shijizhi" name="Thigh3.feimeihui4_shijizhi" value="${Thigh3.feimeihui4_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber3.feimeihui4_shijizhi" name="Tnumber3.feimeihui4_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber3.feimeihui4_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">${smscfgfieldname.fenliao5_shijizhi }</label>
					</td>
					<td class="value">
						不报警<input type="radio" name="hntissms.fenliao5_shijizhi" id="gprstype1" value="0" <c:if test="${hntissms.fenliao5_shijizhi=='0'}">checked="checked"</c:if>/>
						&nbsp;&nbsp;&nbsp;报警<input type="radio" name="hntissms.fenliao5_shijizhi" id="gprstype2" value="1" <c:if test="${hntissms.fenliao5_shijizhi=='1'}">checked="checked"</c:if>/>
						<%--
						<input class="inputxt1" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${topRealMaxhunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
						 --%>
					</td>
					<td class="value">
						<input class="inputxt1" id="Tlow.fenliao5_shijizhi" name="Tlow.fenliao5_shijizhi" value="${Tlow.fenliao5_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh.fenliao5_shijizhi" name="Thigh.fenliao5_shijizhi" value="${Thigh.fenliao5_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber.fenliao5_shijizhi" name="Tnumber.fenliao5_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber.fenliao5_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input style="width:100px;" id="Tcontent.fenliao5_shijizhi" name="Tcontent.fenliao5_shijizhi" value="${Tcontent.fenliao5_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji.fenliao5_shijizhi" name="Tsheji.fenliao5_shijizhi" value="${Tsheji.fenliao5_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji2.fenliao5_shijizhi" name="Tsheji2.fenliao5_shijizhi" value="${Tsheji2.fenliao5_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow2.fenliao5_shijizhi" name="Tlow2.fenliao5_shijizhi" value="${Tlow2.fenliao5_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh2.fenliao5_shijizhi" name="Thigh2.fenliao5_shijizhi" value="${Thigh2.fenliao5_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber2.fenliao5_shijizhi" name="Tnumber2.fenliao5_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber2.fenliao5_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow3.fenliao5_shijizhi" name="Tlow3.fenliao5_shijizhi" value="${Tlow3.fenliao5_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh3.fenliao5_shijizhi" name="Thigh3.fenliao5_shijizhi" value="${Thigh3.fenliao5_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber3.fenliao5_shijizhi" name="Tnumber3.fenliao5_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber3.fenliao5_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">${smscfgfieldname.fenliao6_shijizhi }</label>
					</td>
					<td class="value">
						不报警<input type="radio" name="hntissms.fenliao6_shijizhi" id="gprstype1" value="0" <c:if test="${hntissms.fenliao6_shijizhi=='0'}">checked="checked"</c:if>/>
						&nbsp;&nbsp;&nbsp;报警<input type="radio" name="hntissms.fenliao6_shijizhi" id="gprstype2" value="1" <c:if test="${hntissms.fenliao6_shijizhi=='1'}">checked="checked"</c:if>/>
						<%--
						<input class="inputxt1" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${topRealMaxhunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
						 --%>
					</td>
					<td class="value">
						<input class="inputxt1" id="Tlow.fenliao6_shijizhi" name="Tlow.fenliao6_shijizhi" value="${Tlow.fenliao6_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh.fenliao6_shijizhi" name="Thigh.fenliao6_shijizhi" value="${Thigh.fenliao6_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber.fenliao6_shijizhi" name="Tnumber.fenliao6_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber.fenliao6_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input style="width:100px;" id="Tcontent.fenliao6_shijizhi" name="Tcontent.fenliao6_shijizhi" value="${Tcontent.fenliao6_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji.fenliao6_shijizhi" name="Tsheji.fenliao6_shijizhi" value="${Tsheji.fenliao6_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji2.fenliao6_shijizhi" name="Tsheji2.fenliao6_shijizhi" value="${Tsheji2.fenliao6_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow2.fenliao6_shijizhi" name="Tlow2.fenliao6_shijizhi" value="${Tlow2.fenliao6_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh2.fenliao6_shijizhi" name="Thigh2.fenliao6_shijizhi" value="${Thigh2.fenliao6_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber2.fenliao6_shijizhi" name="Tnumber2.fenliao6_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber2.fenliao6_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow3.fenliao6_shijizhi" name="Tlow3.fenliao6_shijizhi" value="${Tlow3.fenliao6_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh3.fenliao6_shijizhi" name="Thigh3.fenliao6_shijizhi" value="${Thigh3.fenliao6_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber3.fenliao6_shijizhi" name="Tnumber3.fenliao6_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber3.fenliao6_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				
				<tr>
					<td align="right">
						<label class="Validform_label">${smscfgfieldname.sha1_shijizhi }</label>
					</td>
					<td class="value">
						不报警<input type="radio" name="hntissms.sha1_shijizhi" id="gprstype1" value="0" <c:if test="${hntissms.sha1_shijizhi=='0'}">checked="checked"</c:if>/>
						&nbsp;&nbsp;&nbsp;报警<input type="radio" name="hntissms.sha1_shijizhi" id="gprstype2" value="1" <c:if test="${hntissms.sha1_shijizhi=='1'}">checked="checked"</c:if>/>
						<%--
						<input class="inputxt1" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${topRealMaxhunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
						 --%>
					</td>
					<td class="value">
						<input class="inputxt1" id="Tlow.sha1_shijizhi" name="Tlow.sha1_shijizhi" value="${Tlow.sha1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh.sha1_shijizhi" name="Thigh.sha1_shijizhi" value="${Thigh.sha1_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber.sha1_shijizhi" name="Tnumber.sha1_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber.sha1_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input style="width:100px;" id="Tcontent.sha1_shijizhi" name="Tcontent.sha1_shijizhi" value="${Tcontent.sha1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji.sha1_shijizhi" name="Tsheji.sha1_shijizhi" value="${Tsheji.sha1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji2.sha1_shijizhi" name="Tsheji2.sha1_shijizhi" value="${Tsheji2.sha1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow2.sha1_shijizhi" name="Tlow2.sha1_shijizhi" value="${Tlow2.sha1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh2.sha1_shijizhi" name="Thigh2.sha1_shijizhi" value="${Thigh2.sha1_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber2.sha1_shijizhi" name="Tnumber2.sha1_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber2.sha1_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow3.sha1_shijizhi" name="Tlow3.sha1_shijizhi" value="${Tlow3.sha1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh3.sha1_shijizhi" name="Thigh3.sha1_shijizhi" value="${Thigh3.sha1_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber3.sha1_shijizhi" name="Tnumber3.sha1_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber3.sha1_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">${smscfgfieldname.shi1_shijizhi }</label>
					</td>
					<td class="value">
						不报警<input type="radio" name="hntissms.shi1_shijizhi" id="gprstype1" value="0" <c:if test="${hntissms.shi1_shijizhi=='0'}">checked="checked"</c:if>/>
						&nbsp;&nbsp;&nbsp;报警<input type="radio" name="hntissms.shi1_shijizhi" id="gprstype2" value="1" <c:if test="${hntissms.shi1_shijizhi=='1'}">checked="checked"</c:if>/>
						<%--
						<input class="inputxt1" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${topRealMaxhunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
						 --%>
					</td>
					<td class="value">
						<input class="inputxt1" id="Tlow.shi1_shijizhi" name="Tlow.shi1_shijizhi" value="${Tlow.shi1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh.shi1_shijizhi" name="Thigh.shi1_shijizhi" value="${Thigh.shi1_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber.shi1_shijizhi" name="Tnumber.shi1_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber.shi1_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input style="width:100px;" id="Tcontent.shi1_shijizhi" name="Tcontent.shi1_shijizhi" value="${Tcontent.shi1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji.shi1_shijizhi" name="Tsheji.shi1_shijizhi" value="${Tsheji.shi1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji2.shi1_shijizhi" name="Tsheji2.shi1_shijizhi" value="${Tsheji2.shi1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow2.shi1_shijizhi" name="Tlow2.shi1_shijizhi" value="${Tlow2.shi1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh2.shi1_shijizhi" name="Thigh2.shi1_shijizhi" value="${Thigh2.shi1_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber2.shi1_shijizhi" name="Tnumber2.shi1_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber2.shi1_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow3.shi1_shijizhi" name="Tlow3.shi1_shijizhi" value="${Tlow3.shi1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh3.shi1_shijizhi" name="Thigh3.shi1_shijizhi" value="${Thigh3.shi1_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber3.shi1_shijizhi" name="Tnumber3.shi1_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber3.shi1_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				

				<tr>
					<td align="right">
						<label class="Validform_label">${smscfgfieldname.shi2_shijizhi }</label>
					</td>
					<td class="value">
						不报警<input type="radio" name="hntissms.shi2_shijizhi" id="gprstype1" value="0" <c:if test="${hntissms.shi2_shijizhi=='0'}">checked="checked"</c:if>/>
						&nbsp;&nbsp;&nbsp;报警<input type="radio" name="hntissms.shi2_shijizhi" id="gprstype2" value="1" <c:if test="${hntissms.shi2_shijizhi=='1'}">checked="checked"</c:if>/>
						<%--
						<input class="inputxt1" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${topRealMaxhunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
						 --%>
					</td>
					<td class="value">
						<input class="inputxt1" id="Tlow.shi2_shijizhi" name="Tlow.shi2_shijizhi" value="${Tlow.shi2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh.shi2_shijizhi" name="Thigh.shi2_shijizhi" value="${Thigh.shi2_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber.shi2_shijizhi" name="Tnumber.shi2_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber.shi2_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input style="width:100px;" id="Tcontent.shi2_shijizhi" name="Tcontent.shi2_shijizhi" value="${Tcontent.shi2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji.shi2_shijizhi" name="Tsheji.shi2_shijizhi" value="${Tsheji.shi2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji2.shi2_shijizhi" name="Tsheji2.shi2_shijizhi" value="${Tsheji2.shi2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow2.shi2_shijizhi" name="Tlow2.shi2_shijizhi" value="${Tlow2.shi2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh2.shi2_shijizhi" name="Thigh2.shi2_shijizhi" value="${Thigh2.shi2_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber2.shi2_shijizhi" name="Tnumber2.shi2_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber2.shi2_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow3.shi2_shijizhi" name="Tlow3.shi2_shijizhi" value="${Tlow3.shi2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh3.shi2_shijizhi" name="Thigh3.shi2_shijizhi" value="${Thigh3.shi2_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber3.shi2_shijizhi" name="Tnumber3.shi2_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber3.shi2_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>


				<tr>
					<td align="right">
						<label class="Validform_label">${smscfgfieldname.sha2_shijizhi }</label>
					</td>
					<td class="value">
						不报警<input type="radio" name="hntissms.sha2_shijizhi" id="gprstype1" value="0" <c:if test="${hntissms.sha2_shijizhi=='0'}">checked="checked"</c:if>/>
						&nbsp;&nbsp;&nbsp;报警<input type="radio" name="hntissms.sha2_shijizhi" id="gprstype2" value="1" <c:if test="${hntissms.sha2_shijizhi=='1'}">checked="checked"</c:if>/>
						<%--
						<input class="inputxt1" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${topRealMaxhunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
						 --%>
					</td>
					<td class="value">
						<input class="inputxt1" id="Tlow.sha2_shijizhi" name="Tlow.sha2_shijizhi" value="${Tlow.sha2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh.sha2_shijizhi" name="Thigh.sha2_shijizhi" value="${Thigh.sha2_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber.sha2_shijizhi" name="Tnumber.sha2_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber.sha2_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input style="width:100px;" id="Tcontent.sha2_shijizhi" name="Tcontent.sha2_shijizhi" value="${Tcontent.sha2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji.sha2_shijizhi" name="Tsheji.sha2_shijizhi" value="${Tsheji.sha2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji2.sha2_shijizhi" name="Tsheji2.sha2_shijizhi" value="${Tsheji2.sha2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow2.sha2_shijizhi" name="Tlow2.sha2_shijizhi" value="${Tlow2.sha2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh2.sha2_shijizhi" name="Thigh2.sha2_shijizhi" value="${Thigh2.sha2_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber2.sha2_shijizhi" name="Tnumber2.sha2_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber2.sha2_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow3.sha2_shijizhi" name="Tlow3.sha2_shijizhi" value="${Tlow3.sha2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh3.sha2_shijizhi" name="Thigh3.sha2_shijizhi" value="${Thigh3.sha2_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber3.sha2_shijizhi" name="Tnumber3.sha2_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber3.sha2_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>

				<tr>
					<td align="right">
						<label class="Validform_label">${smscfgfieldname.guliao5_shijizhi }</label>
					</td>
					<td class="value">
						不报警<input type="radio" name="hntissms.guliao5_shijizhi" id="gprstype1" value="0" <c:if test="${hntissms.guliao5_shijizhi=='0'}">checked="checked"</c:if>/>
						&nbsp;&nbsp;&nbsp;报警<input type="radio" name="hntissms.guliao5_shijizhi" id="gprstype2" value="1" <c:if test="${hntissms.guliao5_shijizhi=='1'}">checked="checked"</c:if>/>
						<%--
						<input class="inputxt1" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${topRealMaxhunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
						 --%>
					</td>
					<td class="value">
						<input class="inputxt1" id="Tlow.guliao5_shijizhi" name="Tlow.guliao5_shijizhi" value="${Tlow.guliao5_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh.guliao5_shijizhi" name="Thigh.guliao5_shijizhi" value="${Thigh.guliao5_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber.guliao5_shijizhi" name="Tnumber.guliao5_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber.guliao5_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input style="width:100px;" id="Tcontent.guliao5_shijizhi" name="Tcontent.guliao5_shijizhi" value="${Tcontent.guliao5_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji.guliao5_shijizhi" name="Tsheji.guliao5_shijizhi" value="${Tsheji.guliao5_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji2.guliao5_shijizhi" name="Tsheji2.guliao5_shijizhi" value="${Tsheji2.guliao5_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow2.guliao5_shijizhi" name="Tlow2.guliao5_shijizhi" value="${Tlow2.guliao5_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh2.guliao5_shijizhi" name="Thigh2.guliao5_shijizhi" value="${Thigh2.guliao5_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber2.guliao5_shijizhi" name="Tnumber2.guliao5_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber2.guliao5_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow3.guliao5_shijizhi" name="Tlow3.guliao5_shijizhi" value="${Tlow3.guliao5_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh3.guliao5_shijizhi" name="Thigh3.guliao5_shijizhi" value="${Thigh3.guliao5_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber3.guliao5_shijizhi" name="Tnumber3.guliao5_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber3.guliao5_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>

				<tr>
					<td align="right">
						<label class="Validform_label">${smscfgfieldname.shui1_shijizhi }</label>
					</td>
					<td class="value">
						不报警<input type="radio" name="hntissms.shui1_shijizhi" id="gprstype1" value="0" <c:if test="${hntissms.shui1_shijizhi=='0'}">checked="checked"</c:if>/>
						&nbsp;&nbsp;&nbsp;报警<input type="radio" name="hntissms.shui1_shijizhi" id="gprstype2" value="1" <c:if test="${hntissms.shui1_shijizhi=='1'}">checked="checked"</c:if>/>
						<%--
						<input class="inputxt1" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${topRealMaxhunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
						 --%>
					</td>
					<td class="value">
						<input class="inputxt1" id="Tlow.shui1_shijizhi" name="Tlow.shui1_shijizhi" value="${Tlow.shui1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh.shui1_shijizhi" name="Thigh.shui1_shijizhi" value="${Thigh.shui1_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber.shui1_shijizhi" name="Tnumber.shui1_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber.shui1_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input style="width:100px;" id="Tcontent.shui1_shijizhi" name="Tcontent.shui1_shijizhi" value="${Tcontent.shui1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji.shui1_shijizhi" name="Tsheji.shui1_shijizhi" value="${Tsheji.shui1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji2.shui1_shijizhi" name="Tsheji2.shui1_shijizhi" value="${Tsheji2.shui1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow2.shui1_shijizhi" name="Tlow2.shui1_shijizhi" value="${Tlow2.shui1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh2.shui1_shijizhi" name="Thigh2.shui1_shijizhi" value="${Thigh2.shui1_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber2.shui1_shijizhi" name="Tnumber2.shui1_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber2.shui1_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow3.shui1_shijizhi" name="Tlow3.shui1_shijizhi" value="${Tlow3.shui1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh3.shui1_shijizhi" name="Thigh3.shui1_shijizhi" value="${Thigh3.shui1_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber3.shui1_shijizhi" name="Tnumber3.shui1_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber3.shui1_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>

				<tr>
					<td align="right">
						<label class="Validform_label">${smscfgfieldname.shui2_shijizhi }</label>
					</td>
					<td class="value">
						不报警<input type="radio" name="hntissms.shui2_shijizhi" id="gprstype1" value="0" <c:if test="${hntissms.shui2_shijizhi=='0'}">checked="checked"</c:if>/>
						&nbsp;&nbsp;&nbsp;报警<input type="radio" name="hntissms.shui2_shijizhi" id="gprstype2" value="1" <c:if test="${hntissms.shui2_shijizhi=='1'}">checked="checked"</c:if>/>
						<%--
						<input class="inputxt1" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${topRealMaxhunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
						 --%>
					</td>
					<td class="value">
						<input class="inputxt1" id="Tlow.shui2_shijizhi" name="Tlow.shui2_shijizhi" value="${Tlow.shui2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh.shui2_shijizhi" name="Thigh.shui2_shijizhi" value="${Thigh.shui2_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber.shui2_shijizhi" name="Tnumber.shui2_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber.shui2_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input style="width:100px;" id="Tcontent.shui2_shijizhi" name="Tcontent.shui2_shijizhi" value="${Tcontent.shui2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji.shui2_shijizhi" name="Tsheji.shui2_shijizhi" value="${Tsheji.shui2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji2.shui2_shijizhi" name="Tsheji2.shui2_shijizhi" value="${Tsheji2.shui2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow2.shui2_shijizhi" name="Tlow2.shui2_shijizhi" value="${Tlow2.shui2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh2.shui2_shijizhi" name="Thigh2.shui2_shijizhi" value="${Thigh2.shui2_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber2.shui2_shijizhi" name="Tnumber2.shui2_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber2.shui2_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow3.shui2_shijizhi" name="Tlow3.shui2_shijizhi" value="${Tlow3.shui2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh3.shui2_shijizhi" name="Thigh3.shui2_shijizhi" value="${Thigh3.shui2_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber3.shui2_shijizhi" name="Tnumber3.shui2_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber3.shui2_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>


				<tr>
					<td align="right">
						<label class="Validform_label">${smscfgfieldname.waijiaji1_shijizhi }</label>
					</td>
					<td class="value">
						不报警<input type="radio" name="hntissms.waijiaji1_shijizhi" id="gprstype1" value="0" <c:if test="${hntissms.waijiaji1_shijizhi=='0'}">checked="checked"</c:if>/>
						&nbsp;&nbsp;&nbsp;报警<input type="radio" name="hntissms.waijiaji1_shijizhi" id="gprstype2" value="1" <c:if test="${hntissms.waijiaji1_shijizhi=='1'}">checked="checked"</c:if>/>
						<%--
						<input class="inputxt1" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${topRealMaxhunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
						 --%>
					</td>
					<td class="value">
						<input class="inputxt1" id="Tlow.waijiaji1_shijizhi" name="Tlow.waijiaji1_shijizhi" value="${Tlow.waijiaji1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh.waijiaji1_shijizhi" name="Thigh.waijiaji1_shijizhi" value="${Thigh.waijiaji1_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber.waijiaji1_shijizhi" name="Tnumber.waijiaji1_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber.waijiaji1_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input style="width:100px;" id="Tcontent.waijiaji1_shijizhi" name="Tcontent.waijiaji1_shijizhi" value="${Tcontent.waijiaji1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji.waijiaji1_shijizhi" name="Tsheji.waijiaji1_shijizhi" value="${Tsheji.waijiaji1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji2.waijiaji1_shijizhi" name="Tsheji2.waijiaji1_shijizhi" value="${Tsheji2.waijiaji1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow2.waijiaji1_shijizhi" name="Tlow2.waijiaji1_shijizhi" value="${Tlow2.waijiaji1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh2.waijiaji1_shijizhi" name="Thigh2.waijiaji1_shijizhi" value="${Thigh2.waijiaji1_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber2.waijiaji1_shijizhi" name="Tnumber2.waijiaji1_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber2.waijiaji1_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow3.waijiaji1_shijizhi" name="Tlow3.waijiaji1_shijizhi" value="${Tlow3.waijiaji1_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh3.waijiaji1_shijizhi" name="Thigh3.waijiaji1_shijizhi" value="${Thigh3.waijiaji1_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber3.waijiaji1_shijizhi" name="Tnumber3.waijiaji1_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber3.waijiaji1_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>

				<tr>
					<td align="right">
						<label class="Validform_label">${smscfgfieldname.waijiaji2_shijizhi }</label>
					</td>
					<td class="value">
						不报警<input type="radio" name="hntissms.waijiaji2_shijizhi" id="gprstype1" value="0" <c:if test="${hntissms.waijiaji2_shijizhi=='0'}">checked="checked"</c:if>/>
						&nbsp;&nbsp;&nbsp;报警<input type="radio" name="hntissms.waijiaji2_shijizhi" id="gprstype2" value="1" <c:if test="${hntissms.waijiaji2_shijizhi=='1'}">checked="checked"</c:if>/>
						<%--
						<input class="inputxt1" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${topRealMaxhunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
						 --%>
					</td>
					<td class="value">
						<input class="inputxt1" id="Tlow.waijiaji2_shijizhi" name="Tlow.waijiaji2_shijizhi" value="${Tlow.waijiaji2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh.waijiaji2_shijizhi" name="Thigh.waijiaji2_shijizhi" value="${Thigh.waijiaji2_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber.waijiaji2_shijizhi" name="Tnumber.waijiaji2_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber.waijiaji2_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input style="width:100px;" id="Tcontent.waijiaji2_shijizhi" name="Tcontent.waijiaji2_shijizhi" value="${Tcontent.waijiaji2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji.waijiaji2_shijizhi" name="Tsheji.waijiaji2_shijizhi" value="${Tsheji.waijiaji2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji2.waijiaji2_shijizhi" name="Tsheji2.waijiaji2_shijizhi" value="${Tsheji2.waijiaji2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow2.waijiaji2_shijizhi" name="Tlow2.waijiaji2_shijizhi" value="${Tlow2.waijiaji2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh2.waijiaji2_shijizhi" name="Thigh2.waijiaji2_shijizhi" value="${Thigh2.waijiaji2_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber2.waijiaji2_shijizhi" name="Tnumber2.waijiaji2_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber2.waijiaji2_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow3.waijiaji2_shijizhi" name="Tlow3.waijiaji2_shijizhi" value="${Tlow3.waijiaji2_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh3.waijiaji2_shijizhi" name="Thigh3.waijiaji2_shijizhi" value="${Thigh3.waijiaji2_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber3.waijiaji2_shijizhi" name="Tnumber3.waijiaji2_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber3.waijiaji2_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>

				<tr>
					<td align="right">
						<label class="Validform_label">${smscfgfieldname.waijiaji3_shijizhi }</label>
					</td>
					<td class="value">
						不报警<input type="radio" name="hntissms.waijiaji3_shijizhi" id="gprstype1" value="0" <c:if test="${hntissms.waijiaji3_shijizhi=='0'}">checked="checked"</c:if>/>
						&nbsp;&nbsp;&nbsp;报警<input type="radio" name="hntissms.waijiaji3_shijizhi" id="gprstype2" value="1" <c:if test="${hntissms.waijiaji3_shijizhi=='1'}">checked="checked"</c:if>/>
						<%--
						<input class="inputxt1" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${topRealMaxhunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
						 --%>
					</td>
					<td class="value">
						<input class="inputxt1" id="Tlow.waijiaji3_shijizhi" name="Tlow.waijiaji3_shijizhi" value="${Tlow.waijiaji3_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh.waijiaji3_shijizhi" name="Thigh.waijiaji3_shijizhi" value="${Thigh.waijiaji3_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber.waijiaji3_shijizhi" name="Tnumber.waijiaji3_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber.waijiaji3_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input style="width:100px;" id="Tcontent.waijiaji3_shijizhi" name="Tcontent.waijiaji3_shijizhi" value="${Tcontent.waijiaji3_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji.waijiaji3_shijizhi" name="Tsheji.waijiaji3_shijizhi" value="${Tsheji.waijiaji3_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji2.waijiaji3_shijizhi" name="Tsheji2.waijiaji3_shijizhi" value="${Tsheji2.waijiaji3_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow2.waijiaji3_shijizhi" name="Tlow2.waijiaji3_shijizhi" value="${Tlow2.waijiaji3_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh2.waijiaji3_shijizhi" name="Thigh2.waijiaji3_shijizhi" value="${Thigh2.waijiaji3_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber2.waijiaji3_shijizhi" name="Tnumber2.waijiaji3_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber2.waijiaji3_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow3.waijiaji3_shijizhi" name="Tlow3.waijiaji3_shijizhi" value="${Tlow3.waijiaji3_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh3.waijiaji3_shijizhi" name="Thigh3.waijiaji3_shijizhi" value="${Thigh3.waijiaji3_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber3.waijiaji3_shijizhi" name="Tnumber3.waijiaji3_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber3.waijiaji3_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>


				<tr>
					<td align="right">
						<label class="Validform_label">${smscfgfieldname.waijiaji4_shijizhi }</label>
					</td>
					<td class="value">
						不报警<input type="radio" name="hntissms.waijiaji4_shijizhi" id="gprstype1" value="0" <c:if test="${hntissms.waijiaji4_shijizhi=='0'}">checked="checked"</c:if>/>
						&nbsp;&nbsp;&nbsp;报警<input type="radio" name="hntissms.waijiaji4_shijizhi" id="gprstype2" value="1" <c:if test="${hntissms.waijiaji4_shijizhi=='1'}">checked="checked"</c:if>/>
						<%--
						<input class="inputxt1" id="gongdanhao" name="gongdanhao" ignore="ignore"
							   value="${topRealMaxhunnintuViewPage.gongdanhao}">
						<span class="Validform_checktip"></span>
						 --%>
					</td>
					<td class="value">
						<input class="inputxt1" id="Tlow.waijiaji4_shijizhi" name="Tlow.waijiaji4_shijizhi" value="${Tlow.waijiaji4_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh.waijiaji4_shijizhi" name="Thigh.waijiaji4_shijizhi" value="${Thigh.waijiaji4_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber.waijiaji4_shijizhi" name="Tnumber.waijiaji4_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber.waijiaji4_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input style="width:100px;" id="Tcontent.waijiaji4_shijizhi" name="Tcontent.waijiaji4_shijizhi" value="${Tcontent.waijiaji4_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji.waijiaji4_shijizhi" name="Tsheji.waijiaji4_shijizhi" value="${Tsheji.waijiaji4_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tsheji2.waijiaji4_shijizhi" name="Tsheji2.waijiaji4_shijizhi" value="${Tsheji2.waijiaji4_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow2.waijiaji4_shijizhi" name="Tlow2.waijiaji4_shijizhi" value="${Tlow2.waijiaji4_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh2.waijiaji4_shijizhi" name="Thigh2.waijiaji4_shijizhi" value="${Thigh2.waijiaji4_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber2.waijiaji4_shijizhi" name="Tnumber2.waijiaji4_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber2.waijiaji4_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class="value">
					<input class="inputxt1" id="Tlow3.waijiaji4_shijizhi" name="Tlow3.waijiaji4_shijizhi" value="${Tlow3.waijiaji4_shijizhi }"/>
					</td>
					<td class="value">
					<input class="inputxt1" id="Thigh3.waijiaji4_shijizhi" name="Thigh3.waijiaji4_shijizhi" value="${Thigh3.waijiaji4_shijizhi }"/>
					</td>
					<td class="value">
					   <select style="width:140px;" id="Tnumber3.waijiaji4_shijizhi" name="Tnumber3.waijiaji4_shijizhi" >
							<option value="">--请选择--</option>
							<c:forEach items="${handsetTemp}" var="depart">
								<option value="${depart.id }" <c:if test="${depart.id==Tnumber3.waijiaji4_shijizhi}">selected="selected"</c:if>>${depart.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>




			</table>
		</t:formvalid>
 </body>