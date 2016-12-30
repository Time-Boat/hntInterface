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
  
  $(function() {
		$('#cc').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}',
			onClick: function(node){
				$("#tspdepartId").val(node.id);
			}
		});
	});
  
  function qh(name,selectid){
		 $.ajax({
				url:"sYclGuigexinghaomController.do?xinghaolist",
				type:'post',
				dataType:"json",
				data:{
					name:name 
				},
				success:function(data){
					$('#'+selectid).html("");
					var jsonStr='<option title="-1" selected="selected" value="">--请选择型号--</option>';
					$.each(data.list,function(i,item){
						jsonStr+='<option value="'+item.mselectkey+'">'+item.mselectkey+'</option>'
					});
					$('#'+selectid).append(jsonStr);
				}
			});
		 
	 }
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="sYclAllController.do?doCopy" tiptype="1">
					<input id="id" name="id" type="hidden" value="${sYclAllPage.id }">
					
			<input name="id" type="hidden" value="${depart.id }">
			<input name="lft" type="hidden" value="${depart.lft }">
			<input name="rgt" type="hidden" value="${depart.rgt }">		
					
			<table cellpadding="0" cellspacing="1" class="formtable" >
				<c:if test="${sYclAllPage.leixing=='水泥'}">
						<tr>
							<td align="center"><label class="Validform_label" style="width: 150px">类型:</label></td>
							<td class="value"><input   name="leixing" id="leixing"  value='${sYclAllPage.leixing}'style="width: 150px" readonly="readonly"/>
								<span class="Validform_checktip"><font color="red">*不可选*</font></span><label class="Validform_label" style="display: none;">类型</label>
							</td>
							<td align="center"><label class="Validform_label" style="width: 150px">材料名称:</label></td>
							<td class="value"> <input id="shuini.mingcheng" name="shuini.mingcheng" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.mingcheng}'           >
								<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">材料名称</label>
							</td>
							<td align="center"><label class="Validform_label" style="width: 150px">标段部门:</label></td>
							<td class="value"><%-- <input id="cc"  value="${depart.TSPDepart.departname}" style="width: 150px">
									<span class="Validform_checktip"><font color="red">*必选*</font></span>
									<div><input id="tspdepartId" name="tspdepartId" style="display: none;"
									value="${depart.TSPDepart.id}"></div> --%>
									<select id="tspdepartId" name="tspdepartId" style="height:24px;width:120px;" datatype="*" errormsg="该字段不为空">
										<c:forEach items="${departlist}" var="lilun">
											<option  value="${lilun.id}" <c:if test="${lilun.id==sYclAllPage.biaoduanid}">selected="selected"</c:if>>${lilun.departname}</option>
										</c:forEach>
									</select>
							</td>
						</tr>
						
						<tr>
								<td align="center"><label class="Validform_label">产地:</label></td>
								<td class="value"><input id="shuini.chandi" name="shuini.chandi" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.chandi}' >
									<span class="Validform_checktip"></span>
									<label class="Validform_label" style="display: none;">产地</label></td>
								<td align="center"> <label class="Validform_label">生产厂家:</label></td>
								<td class="value"> <input id="shuini.scchangjia" name="shuini.scchangjia" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.scchangjia}' >
										<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">生产厂家</label></td>
								<td align="center"><label class="Validform_label">进场数量(t):</label></td>
								<td class="value"><input id="shuini.jcshuliang" name="shuini.jcshuliang" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.jcshuliang}' >
										<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span><label class="Validform_label" style="display: none;">进场数量(t)</label></td>
						</tr>
						
						<tr>
								<td align="center"><label class="Validform_label">规格:</label></td>
								<td class="value"><select id="shuini.guige" name="shuini.guige" datatype="*" onchange="qh(this.value,'shuinixinghao')">
									<c:forEach items="${List}" var="depart">
										<option value="${depart.selectkey }" <c:if test="${depart.selectkey==sYclAllPage.guige}">selected="selected"</c:if> onclick="">${depart.selectkey}</option>
									</c:forEach>
									</select>
									<span class="Validform_checktip"><font color="red">*必选*</font></span><label class="Validform_label" style="display: none;">请选择规格</label></td>
								<td align="center"><label class="Validform_label">型号:</label></td>
								<td class="value"><select id="shuinixinghao" name="shuinixinghao" datatype="*">
									<c:forEach items="${sList}" var="depart">
										<option value="${depart.mselectkey }" <c:if test="${depart.mselectkey==sYclAllPage.xinghao}">selected="selected"</c:if> onclick="">${depart.mselectkey}</option>
									</c:forEach>
									</select>
									<span class="Validform_checktip"><font color="red">*必选*</font></span><label class="Validform_label" style="display: none;">请选择型号</label></td>
							
							    <td align="center"><label class="Validform_label">产品批号:</label></td>
							    <td class="value"><input id="shuini.picihao" name="shuini.picihao" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.picihao}' >
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">产品批号</label></td>
						</tr>
						
						<!-- 拟使用工程部位、取样日期 -->	
						<tr>
								<td align="center"><label class="Validform_label">拟使用工程部位:</label></td>
								<td class="value"><input id="shuini.syxingmu" name="shuini.syxingmu" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.syxingmu}'   >
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">拟使用工程部位</label></td>
								<td align="center"><label class="Validform_label">取样时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="shuini.qyshijian" name="shuini.qyshijian" value="${sYclAllPage.qyshijian}" datatype="*" >  
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">取样时间</label></td>
								<td align="center"><label class="Validform_label">报告时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="shuini.ycl12" name="shuini.ycl12" value="${sYclAllPage.ycl12}" datatype="*"> 
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">报告时间</label></td>
						</tr>
						
						<tr>
								<td align="center"><label class="Validform_label">样品编号:</label></td>
								<td class="value"> <input id="shuini.ycl11" name="shuini.ycl11" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.ycl11}'>
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">样品编号</label></td>
								<td align="center"><label class="Validform_label">报告编号:</label></td>
								<td class="value"> <input id="shuini.bgbianhao" name="shuini.bgbianhao" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.bgbianhao}' datatype="*" >
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">报告编号</label></td>
								<td align="center"><label class="Validform_label">存储地点:</label></td>
								<td class="value"> <input id="shuini.cunchudidian" name="shuini.cunchudidian" type="text" datatype="*" style="width: 150px" class="inputxt" value='${sYclAllPage.cunchudidian}'  >
									<span class="Validform_checktip"><font color="red">必填</font></span><label class="Validform_label" style="display: none;">存储地点</label></td>
						</tr>	
						
						<tr>
								<td align="center"><label class="Validform_label">批次:</label></td>
								<td class="value"><input id="shuini.pici" name="shuini.pici" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.pici}' datatype="*"  >
									<span class="Validform_checktip"><font color="red">*必填*</font></span><label class="Validform_label" style="display: none;">批次</label></td>
								<td align="center"><label class="Validform_label">入库时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="shuini.rukushijian" name="shuini.rukushijian" value="${sYclAllPage.rukushijian}" datatype="*" >  
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">入库时间</label></td>
								<td align="center"><label class="Validform_label">试验时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="shuini.syshijian" name="shuini.syshijian" value="${sYclAllPage.syshijian}" datatype="*"> 
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">试验时间</label></td>
						</tr>
						
						<!-- 密度/比表面积 -->			
						<tr>
								<td align="center"><label class="Validform_label">密度(g/cm³):</label></td>
								<td class="value"> <input id="shuini.ycl1" name="shuini.ycl1" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.ycl1}' >
									<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span><label class="Validform_label" style="display: none;">密度</label></td>
								<td align="center"><label class="Validform_label">比表面积(cm²):</label></td>
								<td class="value"> <input id="shuini.ycl2" name="shuini.ycl2" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.ycl2}' >
									<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span><label class="Validform_label" style="display: none;">比表面积</label></td>
								<td align="center"><label class="Validform_label">标准稠度用水量(%):</label></td>
								<td class="value"> <input id="shuini.ycl3" name="shuini.ycl3" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.ycl3}' >
									<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> <label class="Validform_label" style="display: none;">标准稠度用水量</label></td>
						</tr>	
						
						
						<!-- 标准稠度用水量/初凝时间-->			
						<tr>
								<td align="center"><label class="Validform_label">初凝时间(min):</label></td>
								<td class="value"> <input id="shuini.ycl4" name="shuini.ycl4" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.ycl4}'              >
									<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span><label class="Validform_label" style="display: none;">初凝时间(min)</label></td>
								<td align="center"><label class="Validform_label">终凝时间(min):</label></td>
								<td class="value"> <input id="shuini.ycl5" name="shuini.ycl5" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.ycl5}' >
									<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span><label class="Validform_label" style="display: none;">终凝时间(min)</label></td>
								<td align="center"><label class="Validform_label">安定性:</label></td>
								<td class="value"><select  id="shuini.ycl6" name="shuini.ycl6" datatype="*">	
									<option value="合格" <c:if test="${sYclAllPage.ycl6=='合格'}"></c:if>>合格</option>
									<option value="不合格" <c:if test="${sYclAllPage.ycl6=='不合格'}"></c:if>>不合格</option>	  </select>	            
									<span class="Validform_checktip"><font color="red">*必选*</font></span><label class="Validform_label" style="display: none;">安定性</label></td>
						</tr>
						<!-- 3d抗折强度/3d抗压强度 -->			
						<tr>
								<td align="center"><label class="Validform_label">3d抗折强度(MPa):</label></td>
								<td class="value"> <input id="shuini.ycl7" name="shuini.ycl7" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl7}' >
									<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span><label class="Validform_label" style="display: none;">3d抗折强度</label></td>
								<td align="center"><label class="Validform_label">3d抗压强度(MPa):</label></td>
								<td class="value"> <input id="shuini.ycl8" name="shuini.ycl8" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.ycl8}' >
									<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span><label class="Validform_label" style="display: none;">3d抗压强度</label></td>
								<td align="center"><label class="Validform_label">28d抗折强度(MPa):</label></td>
								<td class="value"> <input id="shuini.ycl9" name="shuini.ycl9" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.ycl9}'              >
									<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span><label class="Validform_label" style="display: none;">28d抗折强度</label></td>
						</tr>
						<!-- 28d抗折强度/28d抗压强度 -->			
						<tr>
								<td align="center"><label class="Validform_label">28d抗压强度(MPa):</label></td>
								<td class="value"> <input id="shuini.ycl10" name="shuini.ycl10" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.ycl10}' >
									<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span><label class="Validform_label" style="display: none;">28d抗压强度</label></td>
								<td align="center"></td>
								<td class="value"></td>	
								<td align="center"></td>
								<td class="value"></td>	
					
					
						</tr>
					
					
					<!-- 检测结论/试验人员-->			
						<tr>
								<td align="center"><label class="Validform_label">检测结论:</label></td>
								<td class="value"> <select id="shuini.ycl0" name="shuini.ycl0" datatype="*">	
									<option value="合格" <c:if test="${sYclAllPage.ycl0=='合格'}">selected="selected"</c:if>>合格</option>
									<option value="不合格" <c:if test="${sYclAllPage.ycl0=='不合格'}">selected="selected"</c:if>>不合格</option>	  </select>	 
									<span class="Validform_checktip"><font color="red">*必选*</font></span><label class="Validform_label" style="display: none;">检测结论</label></td>
								<td align="center"> <label class="Validform_label">试验人员:</label></td>
								<td class="value"> <input id="shuini.shiyanren" name="shuini.shiyanren" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.shiyanren}'   >
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">试验人员</label></td>
								<%-- <td align="center"><label class="Validform_label">标记:</label></td>
								<td class="value"> <input id="shuini.biaoji" name="shuini.biaoji" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.biaoji}'  readonly="readonly" >
									<span class="Validform_checktip"><font color="red">*不可选*</font></span><label class="Validform_label" style="display: none;">标记</label></td> --%>
						</tr>
		</c:if>			
		<c:if test="${sYclAllPage.leixing=='粉煤灰'}">			
						<tr>
								<td align="center"><label class="Validform_label">类型:</label></td>
								<td class="value"><input   name="leixing" id="leixing"  value='${sYclAllPage.leixing}' readonly="readonly"/>
									<span class="Validform_checktip"><font color="red">*不可选*</font></span><label class="Validform_label" style="display: none;">类型</label></td>
								<td align="center"><label class="Validform_label">材料名称:</label></td>
								<td class="value"> <input id="fenmeihui.mingcheng" name="fenmeihui.mingcheng" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.mingcheng}'   >
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">材料名称</label></td>
								<td align="center">标段部门</td>
								<td class="value"><%-- <input id="cc"  value="${depart.TSPDepart.departname}" style="width: 150px"><span class="Validform_checktip"><font color="red">*必选*</font></span>
									<input id="tspdepartId" name="tspdepartId" style="display: none;"value="${depart.TSPDepart.id}"></div> --%>
									<select id="tspdepartId" name="tspdepartId" style="height:24px;width:120px;" datatype="*" errormsg="该字段不为空">
										<c:forEach items="${departlist}" var="lilun">
											<option  value="${lilun.id}" <c:if test="${lilun.id==sYclAllPage.biaoduanid}">selected="selected"</c:if>>${lilun.departname}</option>
										</c:forEach>
									</select>
									</td>
						</tr>
					<!-- 产地、厂家 -->		
						<tr>
								<td align="center"><label class="Validform_label">产地:</label></td>
								<td class="value"> <input id="fenmeihui.chandi" name="fenmeihui.chandi" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.chandi}' >
										<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">产地</label></td>
								<td align="center"><label class="Validform_label">生产厂家:</label></td>
								<td class="value"> <input id="fenmeihui.scchangjia" name="fenmeihui.scchangjia" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.scchangjia}' >
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">生产厂家</label></td>
								<td align="center"><label class="Validform_label">进场数量(t):</label></td>
								<td class="value"> <input id="fenmeihui.jcshuliang" name="fenmeihui.jcshuliang" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.jcshuliang}'  >
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">进场数量(t)</label></td>
						</tr>
						
					
			<!-- 规格型号 -->			
					<tr>
						<td align="center"><label class="Validform_label">规格:</label></td>
						<td class="value"><select id="fenmeihui.guige" name="fenmeihui.guige" datatype="*"  onchange="qh(this.value,'fenmeihuixinghao')">
							<c:forEach items="${List}" var="depart">
								<option value="${depart.selectkey }" <c:if test="${depart.selectkey==sYclAllPage.guige}">selected="selected"</c:if> onclick="">${depart.selectkey}</option>
							</c:forEach>
							</select><span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">请选择规格</label></td>
						<td align="center"><label class="Validform_label">型号:</label></td>
						<td class="value"><select id="fenmeihuixinghao" name="fenmeihuixinghao" datatype="*">
							<c:forEach items="${sList}" var="depart">
								<option value="${depart.mselectkey }" <c:if test="${depart.mselectkey==sYclAllPage.xinghao}">selected="selected"</c:if> onclick="">${depart.mselectkey}</option>
							</c:forEach>
							</select><span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">请选择型号</label></td>
						<td align="center"><label class="Validform_label">产品批号:</label></td>
						<td class="value"> <input id="fenmeihui.picihao" name="fenmeihui.picihao" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.picihao}'  >
							<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">产品批号</label></td>
					</tr>
					
					<!-- 拟使用工程部位、取样日期 -->	
				<tr>
					<td align="center"><label class="Validform_label">拟使用工程部位:</label></td>
					<td class="value"><input id="fenmeihui.syxingmu" name="fenmeihui.syxingmu" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.syxingmu}'>
							<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">拟使用工程部位</label></td>
					<td align="center"><label class="Validform_label">取样时间:</label></td>
					<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="fenmeihui.qyshijian" name="fenmeihui.qyshijian" value="${sYclAllPage.qyshijian}" datatype="*">  
							<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">取样时间</label></td>
					<td align="center"><label class="Validform_label">报告时间:</label></td>
					<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="fenmeihui.ycl12" name="fenmeihui.ycl12" value="${sYclAllPage.ycl12}" datatype="*"> 
							<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">报告时间</label></td>
				</tr>
					
				<!-- 样品编号、报告日期 -->			
				<tr>
					<td align="center"><label class="Validform_label">样品编号:</label></td>
					<td class="value"> <input id="fenmeihui.ycl11" name="fenmeihui.ycl11" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.ycl11}'  >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">样品编号</label></td>
					<td align="center"><label class="Validform_label">报告编号:</label></td>
					<td class="value"> <input id="fenmeihui.bgbianhao" name="fenmeihui.bgbianhao" type="text" datatype="*" style="width: 150px" class="inputxt"  value='${sYclAllPage.bgbianhao}'          >
							<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">报告编号</label></td>
					<td align="center"><label class="Validform_label">存储地点:</label></td>
								<td class="value"> <input id="fenmeihui.cunchudidian" name="fenmeihui.cunchudidian" datatype="*" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.cunchudidian}'  >
									<span class="Validform_checktip"><font color="red">*必填*</font></span><label class="Validform_label" style="display: none;">存储地点</label></td>
				</tr>	
				
				<tr>
								<td align="center"><label class="Validform_label">批次:</label></td>
								<td class="value"><input id="fenmeihui.pici" name="fenmeihui.pici" type="text" datatype="*" style="width: 150px" class="inputxt" value='${sYclAllPage.pici}'   >
									<span class="Validform_checktip"><font color="red">*必填*</font></span><label class="Validform_label" style="display: none;">批次</label></td>
								<td align="center"><label class="Validform_label">入库时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="fenmeihui.rukushijian" name="fenmeihui.rukushijian" value="${sYclAllPage.rukushijian}" datatype="*" >  
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">入库时间</label></td>
								<td align="center"><label class="Validform_label">试验时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="fenmeihui.syshijian" name="fenmeihui.syshijian" value="${sYclAllPage.syshijian}" datatype="*"> 
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">试验时间</label></td>
						</tr>
						
					<!-- 密度/比表面积 -->			
				<tr>
					<td align="center"><label class="Validform_label">45um方孔筛筛余(%):</label></td>
					<td class="value"> <input id="fenmeihui.ycl1" name="fenmeihui.ycl1" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.ycl1}'  >
							<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">密度</label></td>
					
					<td align="center"><label class="Validform_label">比表面积(cm²):</label></td>
					<td class="value"> <input id="fenmeihui.ycl2" name="fenmeihui.ycl2" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.ycl2}'   >
							<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">比表面积</label></td>
					<td align="center"><label class="Validform_label">需水量比(%):</label></td>
					<td class="value"> <input id="fenmeihui.ycl3" name="fenmeihui.ycl3" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.ycl3}'   >
							<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">需水量比</label></td>		
							
				</tr>	
					
					
					<!-- 标准稠度用水量/初凝时间-->			
					<tr>
						
						<td align="center"><label class="Validform_label">烧失量(%):</label></td>
						<td class="value"> <input id="fenmeihui.ycl4" name="fenmeihui.ycl4" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.ycl4}' >
								<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">烧失量</label></td>
						<td align="center"><label class="Validform_label">含水量(%):</label></td>
						<td class="value"> <input id="fenmeihui.ycl5" name="fenmeihui.ycl5" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.ycl5}'        >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">含水量</label> </td>
						<td align="center"> <label class="Validform_label"> 三氧化硫含量(%): </label> </td>
						<td class="value"> <input id="fenmeihui.ycl6" name="fenmeihui.ycl6" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl6}'      >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">三氧化硫含量</label> </td>
					</tr>
					
					
					<!-- 检测结论/试验人员-->			
					<tr>
						<td align="center"> <label class="Validform_label"> 检测结论: </label> </td>
						<td class="value"> <select id="fenmeihui.ycl0" name="fenmeihui.ycl0" datatype="*">	
								<option value="合格"  <c:if test="${sYclAllPage.ycl0=='合格'}">selected="selected"</c:if>>合格</option>
								<option value="不合格"<c:if test="${sYclAllPage.ycl0=='不合格'}">selected="selected"</c:if>>不合格</option>	  
								</select>	 
							<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">检测结论</label></td>
						<td align="center"> <label class="Validform_label"> 试验人员: </label> </td>
						<td class="value"> <input id="fenmeihui.shiyanren" name="fenmeihui.shiyanren" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.shiyanren}'            >
							<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">试验人员</label></td>
						<%-- <td align="center"> <label class="Validform_label"> 标记: </label> </td>
						<td class="value"> <input id="fenmeihui.biaoji" name="fenmeihui.biaoji" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.biaoji}'       readonly="readonly"   >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">标记</label> </td> --%>
					</tr>
					
			</c:if>		
			<c:if test="${sYclAllPage.leixing=='矿粉'}">		
					<tr>
						<td align="center"><label class="Validform_label">类型:</label></td>
						<td class="value"> <input   name="leixing" id="leixing"  value='${sYclAllPage.leixing}' readonly="readonly"/>
							<span class="Validform_checktip"><font color="red">*不可选*</font></span> <label class="Validform_label" style="display: none;">类型</label> </td>
					    <td align="center"> <label class="Validform_label"> 材料名称: </label> </td>
						<td class="value"> <input id="kuangfen.mingcheng" name="kuangfen.mingcheng" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.mingcheng}'   >
							<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">材料名称</label> </td>
						<td align="center">标段部门</td>
						<td class="value"><%-- <input id="cc"  value="${depart.TSPDepart.departname}" style="width: 150px">
								<span class="Validform_checktip"><font color="red">*必选*</font></span>
								<input id="tspdepartId" name="tspdepartId" style="display: none;"value="${depart.TSPDepart.id}"></div> --%>
								<select id="tspdepartId" name="tspdepartId" style="height:24px;width:120px;" datatype="*" errormsg="该字段不为空">
										<c:forEach items="${departlist}" var="lilun">
											<option  value="${lilun.id}" <c:if test="${lilun.id==sYclAllPage.biaoduanid}">selected="selected"</c:if>>${lilun.departname}</option>
										</c:forEach>
									</select>
									</td>
					</tr>
							<!-- 产地、厂家 -->		
					<tr>
						<td align="center"> <label class="Validform_label"> 产地: </label> </td>
						<td class="value"> <input id="kuangfen.chandi" name="kuangfen.chandi" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.chandi}'    >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">产地</label> </td>
						<td align="center"> <label class="Validform_label"> 生产厂家: </label> </td>
						<td class="value"> <input id="kuangfen.scchangjia" name="kuangfen.scchangjia" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.scchangjia}'             >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">生产厂家</label></td>
						<td align="center"> <label class="Validform_label"> 进场数量(t): </label> </td>
						<td class="value">  <input id="kuangfen.jcshuliang" name="kuangfen.jcshuliang" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.jcshuliang}'   >
							<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">进场数量(t)</label> </td>
					</tr>
					
					
			<!-- 规格型号 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> 规格: </label> </td>
						<td class="value"><select id="kuangfen.guige" name="kuangfen.guige" datatype="*" onchange="qh(this.value,'kuangfenxinghao')">
							<c:forEach items="${List}" var="depart">
								<option value="${depart.selectkey }" <c:if test="${depart.selectkey==sYclAllPage.guige}">selected="selected"</c:if> onclick="">${depart.selectkey}</option>
							</c:forEach>
							</select>
							<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">请选择规格</label></td>
						<td align="center"> <label class="Validform_label"> 型号: </label> </td>
						<td class="value">
					     	<select id="kuangfenxinghao" name="kuangfenxinghao" datatype="*">
							<c:forEach items="${sList}" var="depart">
								<option value="${depart.mselectkey }" <c:if test="${depart.mselectkey==sYclAllPage.xinghao}">selected="selected"</c:if> onclick="">${depart.mselectkey}</option>
							</c:forEach>
							</select>
							<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">请选择型号</label></td>
						<td align="center"> <label class="Validform_label"> 产品批号: </label> </td>
						<td class="value"> <input id="kuangfen.picihao" name="kuangfen.picihao" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.picihao}'      >
								<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">产品批号</label> </td>
					</tr>
					
					<!-- 拟使用工程部位、取样日期 -->	
					<tr>
						<td align="center"> <label class="Validform_label"> 拟使用工程部位: </label> </td>
						<td class="value"> <input id="kuangfen.syxingmu" name="kuangfen.syxingmu" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.syxingmu}' >
								<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">拟使用工程部位</label> </td>
						<td align="center"> <label class="Validform_label"> 取样时间: </label> </td>
						<td class="value"> <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="kuangfen.qyshijian" name="kuangfen.qyshijian" value="${sYclAllPage.qyshijian}" datatype="*">  
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">取样时间</label> </td>
						<td align="center"> <label class="Validform_label"> 报告时间: </label> </td>
						<td class="value"> <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="kuangfen.ycl12" name="kuangfen.ycl12" value="${sYclAllPage.ycl12}" datatype="*"> 
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">报告时间</label> </td>
					</tr>
				<!-- 样品编号、报告日期 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> 样品编号: </label> </td>
						<td class="value"> <input id="ycl11" name="ycl11" type="text" style="width: 150px" class="inputxt"    value='${sYclAllPage.ycl11}'   >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">样品编号</label> </td>
					
						<td align="center"> <label class="Validform_label"> 报告编号: </label> </td>
						<td class="value"> <input id="kuangfen.bgbianhao" name="kuangfen.bgbianhao" datatype="*" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.bgbianhao}'      >
							<span class="Validform_checktip"><font color="red">*必填*</font></span> <label class="Validform_label" style="display: none;">报告编号</label></td>
						<td align="center"><label class="Validform_label">存储地点:</label></td>
						<td class="value"> <input id="kuangfen.cunchudidian" name="kuangfen.cunchudidian" datatype="*" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.cunchudidian}'  >
									<span class="Validform_checktip"><font color="red">*必填*</font></span><label class="Validform_label" style="display: none;">存储地点</label></td>
					</tr>	
					
					<tr>
								<td align="center"><label class="Validform_label">批次:</label></td>
								<td class="value"><input id="kuangfen.pici" name="kuangfen.pici" datatype="*" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.pici}'   >
									<span class="Validform_checktip"><font color="red">*必填*</font></span><label class="Validform_label" style="display: none;">批次</label></td>
								<td align="center"><label class="Validform_label">入库时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="kuangfen.rukushijian" name="kuangfen.rukushijian" value="${sYclAllPage.rukushijian}" datatype="*" >  
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">入库时间</label></td>
								<td align="center"><label class="Validform_label">试验时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="kuangfen.syshijian" name="kuangfen.syshijian" value="${sYclAllPage.syshijian}" datatype="*"> 
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">试验时间</label></td>
						</tr>
					<!-- 密度/比表面积 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> 密度(g/cm³): </label> </td>
						<td class="value"> <input id="kuangfen.ycl1" name="kuangfen.ycl1" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.ycl1}'        >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">密度</label> </td>
						<td align="center"> <label class="Validform_label"> 比表面积(cm²): </label> </td>
						<td class="value"> <input id="kuangfen.ycl2" name="kuangfen.ycl2" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.ycl2}'      >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">比表面积</label> </td>
						<td align="center"> <label class="Validform_label"> 7d活性指数(%): </label> </td>
						<td class="value"> <input id="kuangfen.ycl3" name="kuangfen.ycl3" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.ycl3}'             >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">需水量比</label> </td>
					</tr>	
					
					
					<!-- 标准稠度用水量/初凝时间-->			
					<tr>
						<td align="center"> <label class="Validform_label"> 28d活性指数(%): </label> </td>
						<td class="value"> <input id="kuangfen.ycl4" name="kuangfen.ycl4" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl4}'    >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">28d活性指数</label> </td>
						<td align="center"> <label class="Validform_label"> 含水量(%): </label> </td>
						<td class="value"> <input id="kuangfen.ycl5" name="kuangfen.ycl5" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.ycl5}'     >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">含水量</label> </td>
						<td align="center"> <label class="Validform_label"> 三氧化硫含量(%): </label> </td>
						<td class="value"> <input id="kuangfen.ycl6" name="kuangfen.ycl6" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl6}'            >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">三氧化硫含量</label> </td>
					</tr>
					
					
					<!-- 检测结论/试验人员-->			
					<tr>
						<td align="center"> <label class="Validform_label"> 检测结论: </label> </td>
						<td class="value"> <select id="kuangfen.ycl0" name="kuangfen.ycl0" datatype="*">	
								<option value="合格" <c:if test="${sYclAllPage.ycl0=='合格'}">selected="selected"</c:if>>合格</option>
								<option value="不合格" <c:if test="${sYclAllPage.ycl0=='不合格'}">selected="selected"</c:if>>不合格</option>	 
								 </select>	 
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">检测结论</label> </td>
						<td align="center"> <label class="Validform_label"> 试验人员: </label> </td>
						<td class="value"> <input id="kuangfen.shiyanren" name="kuangfen.shiyanren" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.shiyanren}'  >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">试验人员</label> </td>
						<%-- <td align="center"> <label class="Validform_label"> 标记: </label> </td>
						<td class="value"> <input id="kuangfen.biaoji" name="kuangfen.biaoji" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.biaoji}'  readonly="readonly"       >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">试验人员</label> </td> --%>
					</tr>
					
		 </c:if>			
		<c:if test="${sYclAllPage.leixing=='粗骨料'}">			
					
					<tr>
						<td align="center"> <label class="Validform_label">  类型: </label> </td>
						<td class="value"> <input   name="leixing" id="leixing"  value='${sYclAllPage.leixing}' readonly="readonly"/>
								<span class="Validform_checktip"><font color="red">*不可选*</font></span> <label class="Validform_label" style="display: none;">类型</label> </td>
						<td align="center"> <label class="Validform_label"> 材料名称: </label> </td>
						<td class="value"> <input id="cunjiliao.mingcheng" name="cunjiliao.mingcheng" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.mingcheng}'    >
								<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">材料名称</label> </td>
						<td align="center">标段部门</td>
						<td class="value"><%-- <input id="cc"  value="${depart.TSPDepart.departname}" style="width: 150px">
								<span class="Validform_checktip"><font color="red">*必选*</font></span>
								<input id="tspdepartId" name="tspdepartId" style="display: none;" value="${depart.TSPDepart.id}"></div> --%>
								<select id="tspdepartId" name="tspdepartId" style="height:24px;width:120px;" datatype="*" errormsg="该字段不为空">
										<c:forEach items="${departlist}" var="lilun">
											<option  value="${lilun.id}" <c:if test="${lilun.id==sYclAllPage.biaoduanid}">selected="selected"</c:if>>${lilun.departname}</option>
										</c:forEach>
									</select>
								</td>
					</tr>
									<!-- 产地、厂家 -->		
					<tr>
						<td align="center"> <label class="Validform_label"> 产地: </label> </td>
						<td class="value"> <input id="cunjiliao.chandi" name="cunjiliao.chandi" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.chandi}'  >
								<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">产地</label> </td>
						<td align="center"> <label class="Validform_label"> 生产厂家: </label> </td>
						<td class="value"> <input id="cunjiliao.scchangjia" name="cunjiliao.scchangjia" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.scchangjia}'      >
								<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">生产厂家</label> </td>
						<td align="center"> <label class="Validform_label"> 进场数量(t): </label> </td>
						<td class="value"> <input id="cunjiliao.jcshuliang" name="cunjiliao.jcshuliang" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.jcshuliang}' >
								<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">进场数量(t)</label> </td>
					</tr>
					
					
			<!-- 规格型号 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> 规格: </label> </td>
						<td class="value"><select id="cunjiliao.guige" name="cunjiliao.guige" datatype="*" onchange="qh(this.value,'cunjiliaoxinghao')">
							<c:forEach items="${List}" var="depart">
								<option value="${depart.selectkey }" <c:if test="${depart.selectkey==sYclAllPage.guige}">selected="selected"</c:if> onclick="">${depart.selectkey}</option>
							</c:forEach>
							</select>
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">请选择规格</label> </td>
						<td align="center"> <label class="Validform_label"> 型号: </label> </td>
						<td class="value"> <select id="cunjiliaoxinghao" name="cunjiliaoxinghao" datatype="*">
							<c:forEach items="${sList}" var="depart">
								<option value="${depart.mselectkey }" <c:if test="${depart.mselectkey==sYclAllPage.xinghao}">selected="selected"</c:if> onclick="">${depart.mselectkey}</option>
							</c:forEach>
							</select>
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">请选择型号</label> </td>
					
						<td align="center"> <label class="Validform_label"> 产品批号: </label> </td>
						<td class="value"> <input id="cunjiliao.picihao" name="cunjiliao.picihao" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.picihao}'         >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">产品批号</label> </td>
					</tr>
					
					<!-- 拟使用工程部位、取样日期 -->	
					<tr>
						<td align="center"> <label class="Validform_label"> 拟使用工程部位: </label> </td>
						<td class="value"> <input id="cunjiliao.syxingmu" name="cunjiliao.syxingmu" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.syxingmu}'  >
								<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">拟使用工程部位</label> </td>
						<td align="center"> <label class="Validform_label"> 取样时间: </label> </td>
						<td class="value"> <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="cunjiliao.qyshijian" name="cunjiliao.qyshijian" value="${sYclAllPage.qyshijian}" datatype="*">  
								<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">取样时间</label></td>
						<td align="center"> <label class="Validform_label"> 报告时间: </label> </td>
						<td class="value"> <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="cunjiliao.ycl12" name="cunjiliao.ycl12" value="${sYclAllPage.ycl12} " datatype="*"> 
								<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">报告时间</label> </td>
					</tr>
					
				<!-- 样品编号、报告日期 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> 样品编号: </label> </td>
						<td class="value"> <input id="cunjiliao.ycl11" name="cunjiliao.ycl11" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.ycl11}'   >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">样品编号</label> </td>
					
						<td align="center"> <label class="Validform_label"> 报告编号: </label> </td>
						<td class="value"> <input id="cunjiliao.bgbianhao" name="cunjiliao.bgbianhao"  datatype="*" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.bgbianhao}'           >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">报告编号</label> </td>
						<td align="center"><label class="Validform_label">存储地点:</label></td>
						<td class="value"> <input id="cunjiliao.cunchudidian" name="cunjiliao.cunchudidian" datatype="*" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.cunchudidian}'  >
									<span class="Validform_checktip"><font color="red">*必选*</font></span><label class="Validform_label" style="display: none;">存储地点</label></td>
					</tr>	
					
					<tr>
								<td align="center"><label class="Validform_label">批次:</label></td>
								<td class="value"><input id="cunjiliao.pici" name="cunjiliao.pici" datatype="*" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.pici}'   >
									<span class="Validform_checktip"><font color="red">*必填*</font></span><label class="Validform_label" style="display: none;">批次</label></td>
								<td align="center"><label class="Validform_label">入库时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="cunjiliao.rukushijian" name="cunjiliao.rukushijian" value="${sYclAllPage.rukushijian}" datatype="*" >  
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">入库时间</label></td>
								<td align="center"><label class="Validform_label">试验时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="cunjiliao.syshijian" name="cunjiliao.syshijian" value="${sYclAllPage.syshijian}" datatype="*"> 
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">试验时间</label></td>
						</tr>
					<!-- 密度/比表面积 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> 级配: </label> </td>
						<td class="value"> <select id="cunjiliao.ycl1" name="cunjiliao.ycl1" datatype="*">	
								<option value="合格" <c:if test="${sYclAllPage.ycl1=='合格'}">selected="selected"</c:if>>合格</option>
								<option value="不合格" <c:if test="${sYclAllPage.ycl1=='不合格'}">selected="selected"</c:if>>不合格</option>	  </select>	 
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">级配</label> </td>
						<td align="center"> <label class="Validform_label"> 含泥量(%): </label> </td>
						<td class="value"> <input id="cunjiliao.ycl2" name="cunjiliao.ycl2" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.ycl2}' >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">含泥量</label> </td>
						<td align="center"> <label class="Validform_label"> 泥块含量(%): </label> </td>
						<td class="value"> <input id="cunjiliao.ycl3" name="cunjiliao.ycl3" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.ycl3}'  >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">泥块含量</label> </td>
					</tr>	
					
					
					<!-- 标准稠度用水量/初凝时间-->			
					<tr>
						<td align="center"> <label class="Validform_label"> 针片状含量(%): </label> </td>	
						<td class="value"> <input id="cunjiliao.ycl4" name="cunjiliao.ycl4" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.ycl4}'       >
								<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">针片状含量</label> </td>
						<td align="center"><label class="Validform_label">压碎值(%):</label></td>
						<td class="value"> <input id="cunjiliao.ycl5" name="cunjiliao.ycl5" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.ycl5}'          >
								<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">压碎值</label></td>
						<td align="center"></td>
						<td class="value"></td>
					</tr>
					
					
					<!-- 检测结论/试验人员-->			
					<tr>
						<td align="center"> <label class="Validform_label"> 检测结论: </label> </td>
						<td class="value"> <select id="cunjiliao.ycl0" name="cunjiliao.ycl0" datatype="*">	
								<option value="合格" <c:if test="${sYclAllPage.ycl0=='合格'}">selected="selected"</c:if>>合格</option>
								<option value="不合格" <c:if test="${sYclAllPage.ycl0=='不合格'}">selected="selected"</c:if>>不合格</option>	  </select>	 
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">检测结论</label> </td>
						<td align="center"> <label class="Validform_label"> 试验人员: </label> </td>
						<td class="value"> <input id="cunjiliao.shiyanren" name="cunjiliao.shiyanren" type="text" style="width: 150px" class="inputxt"   >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">试验人员</label> </td>
						<%-- <td align="center"> <label class="Validform_label"> 标记: </label> </td>
						<td class="value"> <input id="cunjiliao.biaoji" name="cunjiliao.biaoji" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.biaoji}'    readonly="readonly"      >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">试验人员</label> </td> --%>
					</tr>
					
					
		</c:if>			
		<c:if test="${sYclAllPage.leixing=='细骨料'}">		
				<tr>
					<td align="center"> <label class="Validform_label"> 类型: </label> </td>
					<td class="value"> <input   name="leixing" id="leixing"  value='${sYclAllPage.leixing}' readonly="readonly"/>
							<span class="Validform_checktip"><font color="red">*不可选*</font></span> <label class="Validform_label" style="display: none;">类型</label> </td>
					<td align="center"> <label class="Validform_label"> 材料名称: </label> </td>
					<td class="value"> <input id="xijiliao.mingcheng" name="xijiliao.mingcheng" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.mingcheng}'       >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">材料名称</label> </td>
					<td align="center">标段部门</td>
					<td class="value"><%-- <input id="cc"  value="${depart.TSPDepart.departname}" style="width: 150px">
							<span class="Validform_checktip"><font color="red">*必选*</font></span>
							<input id="tspdepartId" name="tspdepartId" style="display: none;" value="${depart.TSPDepart.id}"></div> --%>
							<select id="tspdepartId" name="tspdepartId" style="height:24px;width:120px;" datatype="*" errormsg="该字段不为空">
										<c:forEach items="${departlist}" var="lilun">
											<option  value="${lilun.id}" <c:if test="${lilun.id==sYclAllPage.biaoduanid}">selected="selected"</c:if>>${lilun.departname}</option>
										</c:forEach>
									</select>
							</td>
				</tr>
											<!-- 产地、厂家 -->		
				<tr>
					<td align="center"> <label class="Validform_label"> 产地: </label> </td>
					<td class="value">  <input id="xijiliao.chandi" name="xijiliao.chandi" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.chandi}'   >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">产地</label> </td>
					<td align="center"> <label class="Validform_label"> 生产厂家: </label> </td>
					<td class="value"> <input id="xijiliao.scchangjia" name="xijiliao.scchangjia" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.scchangjia}'  >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">生产厂家</label> </td>
					<td align="center"> <label class="Validform_label"> 进场数量(t): </label> </td>
					<td class="value"> <input id="xijiliao.jcshuliang" name="xijiliao.jcshuliang" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.jcshuliang}'  >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">进场数量(t)</label> </td>
				</tr>
					
			<!-- 规格型号 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> 规格: </label> </td>
						<td class="value"><select id="xijiliao.guige" name="xijiliao.guige" datatype="*" onchange="qh(this.value,'xijiliaoxinghao')">
							<c:forEach items="${List}" var="depart">
								<option value="${depart.selectkey }" <c:if test="${depart.selectkey==sYclAllPage.guige}">selected="selected"</c:if> onclick="">${depart.selectkey}</option>
							</c:forEach>
							</select>
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">请选择规格</label> </td>
						<td align="center"> <label class="Validform_label"> 型号: </label> </td>
						<td class="value">
					     	<select id="xijiliaoxinghao" name="xijiliaoxinghao" datatype="*">
								<c:forEach items="${sList}" var="depart">
									<option value="${depart.mselectkey }" <c:if test="${depart.mselectkey==sYclAllPage.xinghao}">selected="selected"</c:if> onclick="">${depart.mselectkey}</option>
								</c:forEach>
								</select>
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">请选择型号</label></td>
						<td align="center"> <label class="Validform_label"> 产品批号: </label> </td>
						<td class="value">  <input id="xijiliao.picihao" name="xijiliao.picihao" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.picihao}'     >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">产品批号</label> </td>
					</tr>
					
					<!-- 拟使用工程部位、取样日期 -->	
					<tr>
						<td align="center"> <label class="Validform_label"> 拟使用工程部位: </label> </td>
						<td class="value"> <input id="xijiliao.syxingmu" name="xijiliao.syxingmu" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.syxingmu}' >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">拟使用工程部位</label> </td>
						<td align="center"> <label class="Validform_label"> 取样时间: </label> </td>
						<td class="value">
							<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="xijiliao.qyshijian" name="xijiliao.qyshijian" value=" ${sYclAllPage.qyshijian}" datatype="*">  
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">取样时间</label> </td>
						<td align="center"> <label class="Validform_label"> 报告时间: </label> </td>
						<td class="value"> <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="xijiliao.ycl12" name="xijiliao.ycl12" value=" ${sYclAllPage.ycl12}" datatype="*"> 
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">报告时间</label> </td>
					</tr>
					
				<!-- 样品编号、报告日期 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> 样品编号: </label> </td>
						<td class="value"> <input id="xijiliao.ycl11" name="xijiliao.ycl11" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl11}'  >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">样品编号</label> </td>
					
						<td align="center"> <label class="Validform_label"> 报告编号: </label> </td>
						<td class="value"> <input id="xijiliao.bgbianhao" name="xijiliao.bgbianhao" datatype="*" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.bgbianhao}'   >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">报告编号</label> </td>
						<td align="center"><label class="Validform_label">存储地点:</label></td>
						<td class="value"> <input id="xijiliao.cunchudidian" name="xijiliao.cunchudidian" datatype="*"  type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.cunchudidian}'  >
									<span class="Validform_checktip"><font color="red">*必填*</font></span><label class="Validform_label" style="display: none;">存储地点</label></td>
					</tr>	
					
					<tr>
								<td align="center"><label class="Validform_label">批次:</label></td>
								<td class="value"><input id="xijiliao.pici" name="xijiliao.pici" type="text" datatype="*" style="width: 150px" class="inputxt" value='${sYclAllPage.pici}'   >
									<span class="Validform_checktip"><font color="red">*必填*</font></span><label class="Validform_label" style="display: none;">批次</label></td>
								<td align="center"><label class="Validform_label">入库时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="xijiliao.rukushijian" name="xijiliao.rukushijian" value="${sYclAllPage.rukushijian}" datatype="*" >  
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">入库时间</label></td>
								<td align="center"><label class="Validform_label">试验时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="xijiliao.syshijian" name="xijiliao.syshijian" value="${sYclAllPage.syshijian}" datatype="*"> 
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">试验时间</label></td>
						</tr>
					
					<!-- 密度/比表面积 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> 级配: </label> </td>
						<td class="value"> <select  id="xijiliao.ycl1" name="xijiliao.ycl1" datatype="*">	
								<option value="合格" <c:if test="${sYclAllPage.ycl1=='合格'}">selected="selected"</c:if>>合格</option>
								<option value="不合格" <c:if test="${sYclAllPage.ycl1=='不合格'}">selected="selected"</c:if>>不合格</option>	  
							</select>	 
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">级配</label> </td>
						<td align="center"> <label class="Validform_label"> 细度模数: </label> </td>
						<td class="value"> <input id="xijiliao.ycl2" name="xijiliao.ycl2" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.ycl2}'           >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">细度模数</label> </td>
						<td align="center"> <label class="Validform_label"> 含泥量(%): </label> </td>
						<td class="value"> <input id="xijiliao.ycl3" name="xijiliao.ycl3" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl3}'     >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">含泥量</label> </td>
					</tr>	
					
					
					<!-- 标准稠度用水量/初凝时间-->			
					<tr>
						<td align="center"> <label class="Validform_label"> 泥块含量(%): </label> </td>
						<td class="value"> <input id="xijiliao.ycl4" name="xijiliao.ycl4" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.ycl4}'     >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">泥块含量</label> </td>
						<td align="center"> <label class="Validform_label"> 堆积密度(%): </label> </td>
						<td class="value"> <input id="xijiliao.ycl5" name="xijiliao.ycl5" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl5}'   >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">堆积密度</label> </td>
						<td align="center"> <label class="Validform_label"> 氯离子含量(%): </label> </td>
						<td class="value"> <input id="xijiliao.ycl6" name="xijiliao.ycl6" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl6}'   >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">氯离子含量</label> </td>
					</tr>
					
					
					<!-- 检测结论/试验人员-->			
					<tr>
						<td align="center"> <label class="Validform_label"> 检测结论: </label> </td>
						<td class="value"> <select id="xijiliao.ycl0" name="xijiliao.ycl0" datatype="*">	
								<option value="合格" <c:if test="${sYclAllPage.ycl0=='合格'}">selected="selected"</c:if>>合格</option>
								<option value="不合格" <c:if test="${sYclAllPage.ycl0=='不合格'}">selected="selected"</c:if>>不合格</option>	 
								 </select>	 
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">检测结论</label> </td>
						<td align="center"> <label class="Validform_label"> 试验人员: </label> </td>
						<td class="value"> <input id="xijiliao.shiyanren" name="xijiliao.shiyanren" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.shiyanren}'        >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">试验人员</label> </td>
						<%-- <td align="center"> <label class="Validform_label"> 标记: </label> </td>
						<td class="value"> <input id="xijiliao.biaoji" name="xijiliao.biaoji" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.biaoji}'    readonly="readonly"      >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">试验人员</label> </td> --%>
					</tr>
					
					
		</c:if>			
		<c:if test="${sYclAllPage.leixing=='水'}">		
					
				<tr>
					<td align="center"> <label class="Validform_label"> 类型: </label> </td>
					<td class="value"> <input   name="leixing" id="leixing"  value='${sYclAllPage.leixing}' readonly="readonly"/>
							<span class="Validform_checktip"><font color="red">*不可选*</font></span> <label class="Validform_label" style="display: none;">类型</label> </td>
					<td align="center"> <label class="Validform_label"> 材料名称: </label></td>
					<td class="value"> <input id="shui.mingcheng" name="shui.mingcheng" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.mingcheng}'    >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">材料名称</label> </td>
					<td align="center">标段部门</td>
					<td class="value"><%-- <input id="cc"  value="${depart.TSPDepart.departname}" style="width: 150px">
								<span class="Validform_checktip"><font color="red">*必选*</font></span>
								<input id="tspdepartId" name="tspdepartId" style="display: none;" value="${depart.TSPDepart.id}"></div> --%>
								<select id="tspdepartId" name="tspdepartId" style="height:24px;width:120px;" datatype="*" errormsg="该字段不为空">
										<c:forEach items="${departlist}" var="lilun">
											<option  value="${lilun.id}" <c:if test="${lilun.id==sYclAllPage.biaoduanid}">selected="selected"</c:if>>${lilun.departname}</option>
										</c:forEach>
									</select>
								</td>
				</tr>
														<!-- 产地、厂家 -->		
				<tr>
					<td align="center"> <label class="Validform_label"> 产地: </label> </td>
					<td class="value"> <input id="shui.chandi" name="shui.chandi" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.chandi}'  >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">产地</label> </td>
					<td align="center"> <label class="Validform_label"> 生产厂家: </label> </td>
					<td class="value"> <input id="shui.scchangjia" name="shui.scchangjia" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.scchangjia}' >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">生产厂家</label> </td>
					<td align="center"> <label class="Validform_label"> 进场数量(t): </label> </td>
					<td class="value">  <input id="shui.jcshuliang" name="shui.jcshuliang" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.jcshuliang}'  >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">进场数量(t)</label> </td>
				</tr>
					
					
			<!-- 规格型号 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> 规格: </label> </td>
						<td class="value"><select id="shui.guige" name="shui.guige" datatype="*" onchange="qh(this.value,'shuixinghao')">
							<c:forEach items="${List}" var="depart">
								<option value="${depart.selectkey }" <c:if test="${depart.selectkey==sYclAllPage.guige}">selected="selected"</c:if> onclick="">${depart.selectkey}</option>
							</c:forEach>
							</select>
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">请选择规格</label> </td>
						<td align="center"> <label class="Validform_label"> 型号: </label> </td>
						<td class="value">
							    <select id="shuixinghao" name="shuixinghao" datatype="*">
								<c:forEach items="${sList}" var="depart">
									<option value="${depart.mselectkey }" <c:if test="${depart.mselectkey==sYclAllPage.xinghao}">selected="selected"</c:if> onclick="">${depart.mselectkey}</option>
								</c:forEach>
								</select>
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">请选择型号</label> </td> </td>
						<td align="center"> <label class="Validform_label"> 产品批号: </label> </td>
						<td class="value">  <input id="shui.picihao" name="shui.picihao" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.picihao}'  >
								<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">产品批号</label> </td>
				</tr>
					
					<!-- 拟使用工程部位、取样日期 -->	
				<tr>
					<td align="center"> <label class="Validform_label"> 拟使用工程部位: </label> </td>
					<td class="value"> <input id="shui.syxingmu" name="shui.syxingmu" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.syxingmu}'      >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">拟使用工程部位</label> </td>
					<td align="center"> <label class="Validform_label"> 取样时间: </label> </td>
					<td class="value"> <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="shui.qyshijian" name="shui.qyshijian" value="${sYclAllPage.qyshijian}" datatype="*">  
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">取样时间</label> </td>
					<td align="center"> <label class="Validform_label"> 报告时间: </label> </td>
					<td class="value"> <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="shui.ycl12" name="shui.ycl12" value="${sYclAllPage.ycl12}" datatype="*"> 
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">报告时间</label></td>
				</tr>
					
				<!-- 样品编号、报告日期 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> 样品编号: </label> </td>
						<td class="value"> <input id="shui.ycl11" name="shui.ycl11" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl11}' >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">样品编号</label> </td>
						<td align="center"> <label class="Validform_label"> 报告编号: </label> </td>
						<td class="value"> <input id="shui.bgbianhao" name="shui.bgbianhao" type="text" datatype="*" style="width: 150px" class="inputxt"  >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">报告编号</label> </td>
						<td align="center"><label class="Validform_label">存储地点:</label></td>
								<td class="value"> <input id="shui.cunchudidian" name="shui.cunchudidian" datatype="*" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.cunchudidian}'  >
									<span class="Validform_checktip"><font color="red">*必填*</font></span><label class="Validform_label" style="display: none;">存储地点</label></td>
					</tr>	
					
					<tr>
								<td align="center"><label class="Validform_label">批次:</label></td>
								<td class="value"><input id="shui.pici" name="shui.pici" type="text" datatype="*" style="width: 150px" class="inputxt" value='${sYclAllPage.pici}'   >
									<span class="Validform_checktip"><font color="red">*必填*</font></span><label class="Validform_label" style="display: none;">批次</label></td>
								<td align="center"><label class="Validform_label">入库时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="shui.rukushijian" name="shui.rukushijian" value="${sYclAllPage.rukushijian}" datatype="*" >  
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">入库时间</label></td>
								<td align="center"><label class="Validform_label">试验时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="shui.syshijian" name="shui.syshijian" value="${sYclAllPage.syshijian}" datatype="*"> 
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">试验时间</label></td>
						</tr>
					
					<!-- 密度/比表面积 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> pH: </label> </td>
						<td class="value"> <input id="shui.ycl1" name="shui.ycl1" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl1}'  >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">pH</label> </td>
						<td align="center"> <label class="Validform_label"> 不溶物(mg/L): </label> </td>
						<td class="value"> <input id="shui.ycl2" name="shui.ycl2" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl2}'     >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">不溶物(mg/L)</label> </td>
						<td align="center"> <label class="Validform_label"> 可溶物(mg/L): </label> </td>
						<td class="value"> <input id="shui.ycl3" name="shui.ycl3" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.ycl3}'   >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">可溶物</label> </td>
					</tr>	
					
					
					<!-- 标准稠度用水量/初凝时间-->			
					<tr>
						<td align="center"> <label class="Validform_label"> 氯化物（Cl-计）(mg/L): </label> </td>
						<td class="value"> <input id="shui.ycl4" name="shui.ycl4" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl4}'   >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">氯化物（Cl-计）</label> </td>
						<td align="center"> <label class="Validform_label"> 硫酸盐（SO42-计）(mg/L): </label> </td>
						<td class="value"> <input id="shui.ycl5" name="shui.ycl5" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl5}'    >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">硫酸盐（SO42-计）</label> </td>
						<td align="center"></td>
						<td class="value"></td>
					</tr>
					
					
					<!-- 检测结论/试验人员-->			
					<tr>
						<td align="center"> <label class="Validform_label"> 检测结论: </label> </td>
						<td class="value"> <select id="shui.ycl0" name="shui.ycl0" datatype="*">	
								<option value="合格" <c:if test="${sYclAllPage.ycl0=='合格'}">selected="selected"</c:if>>合格</option>
								<option value="不合格" <c:if test="${sYclAllPage.ycl0=='不合格'}">selected="selected"</c:if>>不合格</option>	  
								</select>	 
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">检测结论</label> </td>
						<td align="center"> <label class="Validform_label"> 试验人员: </label> </td>
						<td class="value"> <input id="shui.shiyanren" name="shui.shiyanren" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.shiyanren}'    >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">试验人员</label> </td>
						<%-- <td align="center"> <label class="Validform_label"> 标记: </label> </td>
						<td class="value"> <input id="shui.biaoji" name="shui.biaoji" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.biaoji}'     readonly="readonly"     >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">标记</label> </td> --%>
					</tr>
					
					
					</c:if>			
		<c:if test="${sYclAllPage.leixing=='外加剂'}">	
		
					<tr>
							<td align="center"> <label class="Validform_label"> 类型: </label> </td>
							<td class="value"> <input   name="leixing" id="leixing"  value='${sYclAllPage.leixing}' readonly="readonly"/>
								<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">类型</label> </td>
							<td align="center"><label class="Validform_label">材料名称:</label></td>
							<td class="value"> <input id="waijiaji.mingcheng" name="waijiaji.mingcheng" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.mingcheng}'   >
								<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">材料名称</label> </td>
							<td align="center">标段部门</td>
							<td class="value"><input id="cc"  value="${depart.TSPDepart.departname}" style="width: 150px">
								<input id="tspdepartId" name="tspdepartId" style="display: none;" value="${depart.TSPDepart.id}"></div> </td>
					</tr>
														<!-- 产地、厂家 -->		
					<tr>
						<td align="center"> <label class="Validform_label"> 产地: </label> </td>
						<td class="value"> <input id="waijiaji.chandi" name="waijiaji.chandi" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.chandi}'  >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">产地</label> </td>
						<td align="center"> <label class="Validform_label"> 生产厂家: </label> </td>
						<td class="value"> <input id="waijiaji.scchangjia" name="waijiaji.scchangjia" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.scchangjia}'  >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">生产厂家</label> </td>
						<td align="center"> <label class="Validform_label"> 进场数量(t): </label> </td>
						<td class="value"> <input id="waijiaji.jcshuliang" name="waijiaji.jcshuliang" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.jcshuliang}'        >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">进场数量(t)</label> </td>
					</tr>
					
					
			<!-- 规格型号 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> 规格: </label> </td>
						<td class="value"><select id="waijiaji.guige" name="waijiaji.guige" datatype="*" onchange="qh(this.value,'waijiajixinghao')">
							<c:forEach items="${List}" var="depart">
								<option value="${depart.selectkey }" <c:if test="${depart.selectkey==sYclAllPage.guige}">selected="selected"</c:if> onclick="">${depart.selectkey}</option>
							</c:forEach>
							</select>
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">请选择规格</label> </td>
						<td align="center"> <label class="Validform_label"> 型号: </label> </td>
						<td class="value">
						     <select id="waijiajixinghao" name="waijiajixinghao" datatype="*">
								<c:forEach items="${sList}" var="depart">
									<option value="${depart.mselectkey }" <c:if test="${depart.mselectkey==sYclAllPage.xinghao}">selected="selected"</c:if> onclick="">${depart.mselectkey}</option>
								</c:forEach>
							</select>
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">请选择型号</label> </td>
						<td align="center"> <label class="Validform_label"> 产品批号: </label> </td>
						<td class="value"> <input id="waijiaji.picihao" name="waijiaji.picihao" type="text" style="width: 150px" class="inputxt"    value='${sYclAllPage.picihao}' >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">产品批号</label> </td>
					</tr>
					
					<!-- 拟使用工程部位、取样日期 -->	
					<tr>
						<td align="center"> <label class="Validform_label"> 拟使用工程部位: </label> </td>
						<td class="value">  <input id="waijiaji.syxingmu" name="waijiaji.syxingmu" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.syxingmu}'  >
							<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">拟使用工程部位</label> </td>
						<td align="center"> <label class="Validform_label"> 取样时间: </label> </td>
						<td class="value">
							<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="waijiaji.qyshijian" name="waijiaji.qyshijian" value="${sYclAllPage.qyshijian}" datatype="*">  
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">取样时间</label> </td>
						<td align="center"> <label class="Validform_label"> 报告时间: </label> </td>
						<td class="value"> <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="waijiaji.ycl12" name="waijiaji.ycl12" value="${sYclAllPage.ycl12}" datatype="*"> 
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">报告时间</label> </td>
					</tr>
					
				<!-- 样品编号、报告日期 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> 样品编号: </label> </td>
						<td class="value"> <input id="waijiaji.ycl11" name="waijiaji.ycl11" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.ycl11}' >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">样品编号</label> </td>
						<td align="center"> <label class="Validform_label"> 报告编号: </label> </td>
						<td class="value"> <input id="waijiaji.bgbianhao" name="waijiaji.bgbianhao" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.bgbianhao}'         >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">报告编号</label> </td>
						<td align="center"><label class="Validform_label">存储地点:</label></td>
								<td class="value"> <input id="waijiaji.cunchudidian" name="waijiaji.cunchudidian" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.cunchudidian}'  >
									<span class="Validform_checktip"><font color="red">*必填*</font></span><label class="Validform_label" style="display: none;">存储地点</label></td>
					</tr>	
					
					<tr>
								<td align="center"><label class="Validform_label">批次:</label></td>
								<td class="value"><input id="waijiaji.pici" name="waijiaji.pici" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.pici}'   >
									<span class="Validform_checktip"><font color="red">*必填*</font></span><label class="Validform_label" style="display: none;">批次</label></td>
								<td align="center"><label class="Validform_label">入库时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="waijiaji.rukushijian" name="waijiaji.rukushijian" value="${sYclAllPage.rukushijian}" datatype="*" >  
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">入库时间</label></td>
								<td align="center"><label class="Validform_label">试验时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="waijiaji.syshijian" name="waijiaji.syshijian" value="${sYclAllPage.syshijian}" datatype="*"> 
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">试验时间</label></td>
						</tr>
					
					<!-- 密度/比表面积 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> 减水率(%): </label> </td>
						<td class="value"> <input id="waijiaji.ycl1" name="waijiaji.ycl1" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl1}'  >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">pH</label> </td>
						<td align="center"> <label class="Validform_label"> 含气量(%): </label> </td>
						<td class="value"> <input id="waijiaji.ycl2" name="waijiaji.ycl2" type="text" style="width: 150px" class="inputxt"    value='${sYclAllPage.ycl2}' >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">不溶物(mg/L)</label> </td>
						<td align="center"> <label class="Validform_label"> 泌水率比(%): </label> </td>
						<td class="value"> <input id="waijiaji.ycl3" name="waijiaji.ycl3" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.ycl3}'   >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">可溶物</label> </td>
					</tr>	
					
					
					<!-- 标准稠度用水量/初凝时间-->			
					<tr>
						<td align="center"> <label class="Validform_label"> 初凝时间差(min): </label> </td>
						<td class="value"> <input id="waijiaji.ycl4" name="waijiaji.ycl4" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl4}'  >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">氯化物（Cl-计）</label> </td>
						<td align="center"> <label class="Validform_label"> 终凝时间差(min): </label> </td>
						<td class="value"> <input id="waijiaji.ycl5" name="waijiaji.ycl5" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.ycl5}'   >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">硫酸盐（SO42-计）</label> </td>
						<td align="center"> <label class="Validform_label"> 28d抗压强度比(%): </label> </td>
						<td class="value"> <input id="waijiaji.ycl6" name="waijiaji.ycl6" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl6}'   >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">硫酸盐（SO42-计）</label> </td>
					</tr>
					
					
					<tr>
						<td align="center"> <label class="Validform_label"> 28d收缩率比(%): </label> </td>
						<td class="value"> <input id="waijiaji.ycl7" name="waijiaji.ycl7" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.ycl7}'       >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">硫酸盐（SO42-计）</label> </td>
						<td align="center"></td>
						<td class="value"></td>
						<td align="center"></td>
						<td class="value"></td>
					</tr>
					
					
					<!-- 检测结论/试验人员-->			
					<tr>
						<td align="center"> <label class="Validform_label"> 检测结论: </label> </td>
						<td class="value"> <select id="waijiaji.ycl0" name="waijiaji.ycl0" datatype="*">	
								<option value="合格" <c:if test="${sYclAllPage.ycl0=='合格'}">selected="selected"</c:if> >合格</option>
								<option value="不合格" <c:if test="${sYclAllPage.ycl0=='不合格'}">selected="selected"</c:if> >不合格</option>	  
								</select>	 
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">检测结论</label> </td>
						<td align="center"> <label class="Validform_label">  试验人员: </label> </td>
						<td class="value"> <input id="waijiaji.shiyanren" name="waijiaji.shiyanren" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.shiyanren}'   >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">试验人员</label> </td>
					<%-- 	<td align="center"> <label class="Validform_label"> 标记: </label> </td>
						<td class="value"> <input id="waijiaji.biaoji" name="waijiaji.biaoji" type="text" style="width: 150px" class="inputxt"    value='${sYclAllPage.biaoji}'   readonly="readonly"       >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">试验人员</label>
						</td> --%>
					</tr>
					
					
		</c:if>			
		<c:if test="${sYclAllPage.leixing=='其他'}">	
					<tr>
						<td align="center"> <label class="Validform_label"> 类型: </label> </td>
						<td class="value"> <input   name="leixing" id="leixing"  value='${sYclAllPage.leixing}' readonly="readonly"/>
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">类型</label> </td>
						<td align="center"><label class="Validform_label">材料名称:</label></td>
						<td class="value"> <input id="qita.mingcheng" name="qita.mingcheng" type="text" style="width: 150px" class="inputxt"value='${sYclAllPage.mingcheng}'       >
							<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">材料名称</label></td>
						<td align="center">标段部门</td>
						<td class="value"><%-- <input id="cc"  value="${depart.TSPDepart.departname}" style="width: 150px">
								<input id="tspdepartId" name="tspdepartId" style="display: none;"value="${depart.TSPDepart.id}"></div> --%>
								<select id="tspdepartId" name="tspdepartId" style="height:24px;width:120px;" datatype="*" errormsg="该字段不为空">
										<c:forEach items="${departlist}" var="lilun">
											<option  value="${lilun.id}" <c:if test="${lilun.id==sYclAllPage.biaoduanid}">selected="selected"</c:if>>${lilun.departname}</option>
										</c:forEach>
									</select>
								</td>
					</tr>
					<!-- 产地、厂家 -->		
					<tr>
					 	<td align="center"> <label class="Validform_label"> 产地: </label> </td>
						<td class="value">  <input id="qita.chandi" name="qita.chandi" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.chandi}'  >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">产地</label> </td>
						<td align="center"> <label class="Validform_label"> 生产厂家: </label> </td>
						<td class="value"> <input id="qita.scchangjia" name="qita.scchangjia" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.scchangjia}'          >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">生产厂家</label> </td>
						<td align="center"> <label class="Validform_label"> 进场数量(t): </label> </td>
						<td class="value"> <input id="qita.jcshuliang" name="qita.jcshuliang" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.jcshuliang}'    >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">进场数量(t)</label> </td>
					</tr>
					
					
			<!-- 规格型号 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> 规格: </label> </td>
						<td class="value"><select id="qita.guige" name="qita.guige" datatype="*" onchange="qh(this.value,'qitaxinghao')">
							<c:forEach items="${List}" var="depart">
								<option value="${depart.selectkey }" <c:if test="${depart.selectkey==sYclAllPage.guige}">selected="selected"</c:if> onclick="">${depart.selectkey}</option>
							</c:forEach>
							</select>
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">请选择规格</label>
						 </td>
						<td align="center"> <label class="Validform_label"> 型号: </label> </td>
						<td class="value"> <select id="qitaxinghao" name="qitaxinghao" datatype="*">
							<c:forEach items="${sList}" var="depart">
								<option value="${depart.mselectkey }" <c:if test="${depart.mselectkey==sYclAllPage.xinghao}">selected="selected"</c:if> onclick="">${depart.mselectkey}</option>
							</c:forEach>
							</select>
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">请选择型号</label> </td>
						<td align="center"> <label class="Validform_label"> 产品批号: </label> </td>
						<td class="value">
					     	 <input id="qita.picihao" name="qita.picihao" type="text" style="width: 150px" class="inputxt"   >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">产品批号</label> </td>
					</tr>
					
					<!-- 拟使用工程部位、取样日期 -->	
					<tr>
						<td align="center"> <label class="Validform_label"> 拟使用工程部位: </label> </td>
						<td class="value">
						     	 <input id="qita.syxingmu" name="qita.syxingmu" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.syxingmu}'  >
								<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">拟使用工程部位</label> </td>
						<td align="center"> <label class="Validform_label"> 取样时间: </label> </td>
						<td class="value">
							<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="qita.qyshijian" name="qita.qyshijian" value="${sYclAllPage.qyshijian}" datatype="*">  
								<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">取样时间</label> </td>
						<td align="center"> <label class="Validform_label"> 报告时间: </label> </td>
						<td class="value">
					     	<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="qita.ycl12" name="qita.ycl12" value=" ${sYclAllPage.ycl12}" datatype="*"> 
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">报告时间</label> </td>
					</tr>
					
				<!-- 样品编号、报告日期 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> 样品编号: </label> </td>
						<td class="value"> <input id="qita.ycl11" name="qita.ycl11" type="text" style="width: 150px" class="inputxt"    value='${sYclAllPage.ycl11}'           >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">样品编号</label> </td>
					
						<td align="center"> <label class="Validform_label"> 报告编号: </label> </td>
						<td class="value"> <input id="qita.bgbianhao" name="qita.bgbianhao" type="text" style="width: 150px" class="inputxt"   >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">报告编号</label> </td>
						<td align="center"><label class="Validform_label">存储地点:</label></td>
								<td class="value"> <input id="qita.cunchudidian" name="qita.cunchudidian" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.cunchudidian}'  >
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">存储地点</label></td>
					</tr>	
					
					<tr>
								<td align="center"><label class="Validform_label">批次:</label></td>
								<td class="value"><input id="qita.pici" name="qita.pici" type="text" style="width: 150px" class="inputxt" value='${sYclAllPage.pici}'   >
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">批次</label></td>
								<td align="center"><label class="Validform_label">入库时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="qita.rukushijian" name="qita.rukushijian" value="${sYclAllPage.rukushijian}" datatype="*" >  
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">入库时间</label></td>
								<td align="center"><label class="Validform_label">试验时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="qita.syshijian" name="qita.syshijian" value="${sYclAllPage.syshijian}" datatype="*"> 
									<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">试验时间</label></td>
						</tr>
					
					<!-- 密度/比表面积 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> 检测结果1: </label> </td>
						<td class="value"> <input id="qita.ycl1" name="qita.ycl1" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl1}'   >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">检测结果1</label> </td>
						<td align="center"> <label class="Validform_label"> 检测结果2: </label> </td>
						<td class="value"> <input id="qita.ycl2" name="qita.ycl2" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.ycl2}'    >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">检测结果2</label> </td>
						<td align="center"> <label class="Validform_label"> 检测结果3: </label> </td>
						<td class="value"> <input id="qita.ycl3" name="qita.ycl3" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl3}'      >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">检测结果3</label> </td>
					</tr>	
					
					
					<!-- 标准稠度用水量/初凝时间-->			
					<tr>
						
					
						<td align="center"> <label class="Validform_label"> 检测结果4: </label> </td>
						<td class="value"> <input id="qita.ycl4" name="qita.ycl4" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl4}'  >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">检测结果4</label> </td>
						<td align="center"> <label class="Validform_label"> 检测结果5: </label> </td>
						<td class="value"> <input id="qita.ycl5" name="qita.ycl5" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl5}'   >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">检测结果5</label> </td>
						<td align="center"> <label class="Validform_label"> 检测结果6: </label> </td>
						<td class="value">   <input id="qita.ycl6" name="qita.ycl6" type="text" style="width: 150px" class="inputxt"  value='${sYclAllPage.ycl6}'    >  
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">检测结果6</label> </td>
					</tr>
					<!-- 3d抗折强度/3d抗压强度 -->		
						
					<tr>
						<td align="center"> <label class="Validform_label"> 检测结果7: </label> </td>
						<td class="value"> <input id="qita.ycl7" name="qita.ycl7" type="text" style="width: 150px" class="inputxt"    value='${sYclAllPage.ycl7}'       >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">检测结果7</label> </td>
						<td align="center"> <label class="Validform_label"> 检测结果8: </label> </td>
						<td class="value"> <input id="qita.ycl8" name="qita.ycl8" type="text" style="width: 150px" class="inputxt"    value='${sYclAllPage.ycl8}'      >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">检测结果8</label> </td>
						<td align="center"> <label class="Validform_label"> 检测结果9: </label> </td>
						<td class="value"> <input id="qita.ycl9" name="qita.ycl9" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl9}'     >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">检测结果9</label> </td>
					</tr>
					<!-- 28d抗折强度/28d抗压强度 -->			
					<tr>
						<td align="center"> <label class="Validform_label"> 检测结果10: </label> </td>
						<td class="value"> <input id="qita.ycl10" name="qita.ycl10" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.ycl10}'        >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">检测结果10</label> </td>
						<td align="center"></td>
						<td class="value"></td>
						<td align="center"></td>
						<td class="value"></td>
					</tr>
					
					
					<!-- 检测结论/试验人员-->			
					<tr>
						<td align="center"> <label class="Validform_label"> 检测结论: </label> </td>
						<td class="value"> <select id="qita.ycl0" name="qita.ycl0" datatype="*">	
								<option value="合格" <c:if test="${sYclAllPage.ycl0=='合格'}">selected="selected"</c:if>>合格</option>
								<option value="不合格" <c:if test="${sYclAllPage.ycl0=='不合格'}">selected="selected"</c:if>>不合格</option>	  </select>	 
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">检测结论</label> </td>
					
						<td align="center"> <label class="Validform_label"> 试验人员: </label> </td>
						<td class="value"> <input id="qita.shiyanren" name="qita.shiyanren" type="text" style="width: 150px" class="inputxt"    value='${sYclAllPage.shiyanren}'           >
							<span class="Validform_checktip"></span> <label class="Validform_label" style="display: none;">试验人员</label> </td>
						<%-- <td align="center"> <label class="Validform_label"> 标记: </label> </td>
						<td class="value"> <input id="qita.biaoji" name="qita.biaoji" type="text" style="width: 150px" class="inputxt"   value='${sYclAllPage.biaoji}'  </td> --%>
					</tr>
				</c:if>			
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/shtoone/qms/bhz/sYclAll.js"></script>		