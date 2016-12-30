<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
  <title>拌和机信息基础表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
	$(function() {
		$('#cc').combotree({
			//url : 'departController.do?setPFunction&selfId=${banhezhanxinxiPage.departid}',
			url : 'departController.do?setPFunction&selfId=${depart.id}',
			onClick: function(node){
				$("#banhezhanxinxitspdepartId").val(node.id);
			}
		});
	});
	
	function checkGprsbianhao(gprsbianhao){
		var Validform_gprsbianhaoOld=$('#Validform_gprsbianhaoOld').val();
		if(Validform_gprsbianhaoOld!=gprsbianhao){
			$.ajax({
				url:"banhezhanxinxiController.do?checkGprsbianhao",
				type:'post',
				dataType:"json",
				data:{
					gprsbianhao:gprsbianhao
				},
				success:function(data){
						$('#Validform_gprsbianhaoHidden').val(data.msg);
					if(data.msg=="succ"){
						$('#Validform_gprsbianhao').addClass("Validform_right Validform_wrong");
						$('#Validform_gprsbianhao').html("数据库已存在该编号！");
					}
				}
			});
		}else{
			$('#Validform_gprsbianhaoHidden').val("error");//不用验证
		}
	}
	
	function checkfrom(){
		var Validform_gprsbianhaoHidden=$('#Validform_gprsbianhaoHidden').val();
		if(Validform_gprsbianhaoHidden=="succ"){
			$('#Validform_gprsbianhao').addClass("Validform_right Validform_wrong");
			$('#Validform_gprsbianhao').html("数据库已存在该编号！");
			return false;
		}
	}
</script>
 </head>
 <body >
  <t:formvalid beforeSubmit="checkfrom()" formid="formobj" dialog="true" usePlugin="password" layout="table" action="banhezhanxinxiController.do?save">
			<input id="id" name="id" type="hidden" value="${banhezhanxinxiPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							所属机构:
						</label>
					</td>
					<td class="value">
						<!-- 
						<input class="inputxt" id="departid" name="departid" ignore="ignore"
							   value="${banhezhanxinxiPage.departid}">
						<span class="Validform_checktip"></span>
						 -->
						<input id="cc" name="remark"  value="${banhezhanxinxiPage.remark}" style="width:250px;">
						<input id="banhezhanxinxitspdepartId" name="departid" style="display: none;"
							value="${banhezhanxinxiPage.departid}" datatype="*" errormsg="该字段不为空">
							<span class="Validform_checktip"><font color=red>必选*</font></span>
			
		
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							数据传输设备所属类型:
						</label>
					</td>
					<td class="value">
						<input type="radio" name="gprstype" id="gprstype1" value="1" <c:if test="${banhezhanxinxiPage.gprstype=='1'}">checked="checked"</c:if>/>水泥混凝土
						<input type="radio" name="gprstype" id="gprstype1" value="2" <c:if test="${banhezhanxinxiPage.gprstype=='2'}">checked="checked"</c:if>/>沥青混凝土
						<input type="radio" name="gprstype" id="gprstype1" value="3" <c:if test="${banhezhanxinxiPage.gprstype=='3'}">checked="checked"</c:if>/>万能机
						<input type="radio" name="gprstype" id="gprstype1" value="4" <c:if test="${banhezhanxinxiPage.gprstype=='4'}">checked="checked"</c:if>/>压力机
						<input type="radio" name="gprstype" id="gprstype1" value="5" <c:if test="${banhezhanxinxiPage.gprstype=='5'}">checked="checked"</c:if>/>水稳拌合站
						<!-- 
						<input class="inputxt" id="gprstype" name="gprstype" ignore="ignore"
							   value="${banhezhanxinxiPage.gprstype}">
							    -->
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							数据传输设备编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="gprsbianhao" name="gprsbianhao" 
							   value="${banhezhanxinxiPage.gprsbianhao}" datatype="*" errormsg="该字段不为空" onBlur="checkGprsbianhao(this.value)"/>
						
						<input id="Validform_gprsbianhaoOld" type="hidden" value="${banhezhanxinxiPage.gprsbianhao}"/>
						<input id="Validform_gprsbianhaoHidden" type="hidden" value="error"/>
						<span id="Validform_gprsbianhao" class="Validform_checktip"><font color=red>必填*</font></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							设备名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="banhezhanminchen" name="banhezhanminchen" 
							   value="${banhezhanxinxiPage.banhezhanminchen}" datatype="*" errormsg="该字段不为空">
						<span class="Validform_checktip"><font color=red>必填*</font></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							设备简称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jianchen" name="jianchen" ignore="ignore"
							   value="${banhezhanxinxiPage.jianchen}" datatype="*" errormsg="该字段不为空">
						<span class="Validform_checktip"><font color=red>必填*</font></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否报警:
						</label>
					</td>
					<td class="value">
						<!-- 
						<input class="inputxt" id="smsbaojin" name="smsbaojin" ignore="ignore"
							   value="${banhezhanxinxiPage.smsbaojin}">
						<span class="Validform_checktip"></span>
						 -->
						不报警<input type="radio" name="smsbaojin" id="smsbaojin1" value="0" <c:if test="${banhezhanxinxiPage.smsbaojin=='0'}">checked="checked"</c:if>/>
						报警<input type="radio" name="smsbaojin" id="smsbaojin2" value="1" <c:if test="${banhezhanxinxiPage.smsbaojin=='1'}">checked="checked"</c:if>/>
						
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							设备厂家:
						</label>
					</td>
					<td class="value">
						<!-- 
						<input class="inputxt" id="shebeichanjia" name="shebeichanjia" ignore="ignore"
							   value="${banhezhanxinxiPage.shebeichanjia}">
						<span class="Validform_checktip"></span>
						 -->
						<select id="shebeichanjia" name="shebeichanjia">
							<option value="">--请选择--</option>
							<c:forEach items="${ShebeichangjiaTemp}" var="depart">
								<option value="${depart.sbbh }" <c:if test="${depart.sbbh==banhezhanxinxiPage.shebeichanjia}">selected="selected"</c:if>>${depart.sbname}</option>
							</c:forEach>
						</select> <span class="Validform_checktip">请选择设备厂家</span>
			
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							设备型号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shebeixinghao" name="shebeixinghao" ignore="ignore"
							   value="${banhezhanxinxiPage.shebeixinghao}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							工控机厂家:
						</label>
					</td>
					<td class="value">
						<!-- 
						<input class="inputxt" id="gongkongleixin" name="gongkongleixin" ignore="ignore"
							   value="${banhezhanxinxiPage.gongkongleixin}">
						<span class="Validform_checktip"></span>
						 -->
						 <select id="gongkongleixin" name="gongkongleixin" >
							<option value="">--请选择--</option>
							<c:forEach items="${GongkongchangjiaTemp}" var="depart">
								<option value="${depart.sbbh }" <c:if test="${depart.sbbh==banhezhanxinxiPage.gongkongleixin}">selected="selected"</c:if>>${depart.sbname}</option>
							</c:forEach>
						</select> <span class="Validform_checktip">请选择工控机厂家</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							采集端软件及版本:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="caijiduanruanjianbanben" name="caijiduanruanjianbanben" ignore="ignore"
							   value="${banhezhanxinxiPage.caijiduanruanjianbanben}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							接口类型:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jiekouleixin" name="jiekouleixin" ignore="ignore"
							   value="${banhezhanxinxiPage.jiekouleixin}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							工控机数据库类型:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shujukuleixin" name="shujukuleixin" ignore="ignore"
							   value="${banhezhanxinxiPage.shujukuleixin}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							数量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shuliang" name="shuliang" ignore="ignore"
							   value="${banhezhanxinxiPage.shuliang}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							数据传输设备SIM卡号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="simhao" name="simhao" ignore="ignore"
							   value="${banhezhanxinxiPage.simhao}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							数据传输设备SIM卡密码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="simpwd" name="simpwd" ignore="ignore"
							   value="${banhezhanxinxiPage.simpwd}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							DTU波特率:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="botelu" name="botelu" ignore="ignore"
							   value="${banhezhanxinxiPage.botelu}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							数据传输设备SIM卡套餐:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="taocan" name="taocan" ignore="ignore"
							   value="${banhezhanxinxiPage.taocan}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				<!-- 
				<tr>
					<td align="right">
						<label class="Validform_label">
							报警时段类型:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="smstype" name="smstype" ignore="ignore"
							   value="${banhezhanxinxiPage.smstype}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							报警方式:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sendtype" name="sendtype" ignore="ignore"
							   value="${banhezhanxinxiPage.sendtype}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							汇总盘数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="panshu" name="panshu" ignore="ignore"
							   value="${banhezhanxinxiPage.panshu}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							上午开始时间:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ambegin" name="ambegin" ignore="ignore"
							   value="${banhezhanxinxiPage.ambegin}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							上午结束时间:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="amend" name="amend" ignore="ignore"
							   value="${banhezhanxinxiPage.amend}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							下午开始时间:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pmbegin" name="pmbegin" ignore="ignore"
							   value="${banhezhanxinxiPage.pmbegin}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							下午结束时间:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pmend" name="pmend" ignore="ignore"
							   value="${banhezhanxinxiPage.pmend}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							短信报警设置方式:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="smssettype" name="smssettype" ignore="ignore"
							   value="${banhezhanxinxiPage.smssettype}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				 -->
				<tr>
					<td align="right">
						<label class="Validform_label">
							设备安装地址:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shebeidizhi" name="shebeidizhi" ignore="ignore"
							   value="${banhezhanxinxiPage.shebeidizhi}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							设备占地面积:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shebeimianji" name="shebeimianji" ignore="ignore"
							   value="${banhezhanxinxiPage.shebeimianji}" datatype="d" errormsg="请输入数字">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							设备操作员:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="caozuoren" name="caozuoren" ignore="ignore"
							   value="${banhezhanxinxiPage.caozuoren}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							站长:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="zhanzhang" name="zhanzhang" ignore="ignore"
							   value="${banhezhanxinxiPage.zhanzhang}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							联系电话:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="lianxidianhua" name="lianxidianhua" ignore="ignore"
							   value="${banhezhanxinxiPage.lianxidianhua}" datatype="m" errormsg="手机号非法">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							时间格式:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shijiangeshi" name="shijiangeshi" ignore="ignore"
							   value="${banhezhanxinxiPage.shijiangeshi}">
						<br/><span class="Validform_checktip">该项是针对出料时间格式为yyyymmddHHmmss不是则空即可</span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							排序编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="orderid" name="orderid" ignore="ignore"
							   value="${banhezhanxinxiPage.orderid}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<!-- 
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="remark" name="remark" ignore="ignore"
							   value="${banhezhanxinxiPage.remark}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				 -->
			</table>
		</t:formvalid>
 </body>