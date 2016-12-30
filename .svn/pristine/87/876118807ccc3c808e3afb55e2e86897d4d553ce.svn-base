<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  	<div region="center" style="padding:1px;">
  		<t:datagrid name="banhezhanxinxiList" title="拌和机信息基础表" actionUrl="banhezhanxinxiController.do?datagrid" idField="id" fit="true" fitColumns="true">
   			<t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   			<t:dgCol title="操作" field="opt" frozenColumn="true"></t:dgCol>
   			<t:dgDelOpt title="清标识" url="banhezhanxinxiController.do?clearBiaoshi&id={id}" />
			<t:dgFunOpt funname="operationDetailLook(id)" title="查看"></t:dgFunOpt>
			<t:dgFunOpt funname="operationDetailEdit(id)"  operationCode="bhjEdit" title="编辑"></t:dgFunOpt>
			<t:dgDelOpt title="删除" url="banhezhanxinxiController.do?del&id={id}" />
   			<t:dgCol title="数据传输设备编号" field="gprsbianhao" frozenColumn="true"></t:dgCol>
   			<t:dgCol title="设备类型" field="gprstype" replace="压力机_4,万能机_3,沥青混凝土_2,水泥混凝土_1" frozenColumn="true"></t:dgCol>
   			<t:dgCol title="设备全称" field="banhezhanminchen" frozenColumn="true"></t:dgCol>
   			<t:dgCol title="设备简称" field="jianchen" ></t:dgCol>
   			<t:dgCol title="是否报警" field="smsbaojin"  replace="不报警_0,报警_1" frozenColumn="true"></t:dgCol>
   			<t:dgCol title="设备厂家" field="shebeichanjia" ></t:dgCol>
   			<t:dgCol title="设备型号" field="shebeixinghao" ></t:dgCol>
   			<t:dgCol title="工控机厂家" field="gongkongleixin" ></t:dgCol>
   			<t:dgCol title="采集软件版本" field="caijiduanruanjianbanben" ></t:dgCol>
   			<t:dgCol title="接口类型" field="jiekouleixin" ></t:dgCol>
  			<t:dgCol title="工控机数据库类型" field="shujukuleixin" ></t:dgCol>
   		<%--<t:dgCol title="数量" field="shuliang" ></t:dgCol> --%>
   			<t:dgCol title="SIM卡号" field="simhao" ></t:dgCol>
   			<t:dgCol title="SIM卡密码" field="simpwd" ></t:dgCol>
   			<t:dgCol title="数据传输设备波特率" field="botelu" ></t:dgCol>
   			<t:dgCol title="SIM卡套餐" field="taocan" ></t:dgCol>
   		<%-- 
   			<t:dgCol title="报警时段类型" field="smstype" ></t:dgCol>
   			<t:dgCol title="报警方式" field="sendtype" ></t:dgCol>
   			<t:dgCol title="汇总盘数" field="panshu" ></t:dgCol>
   			<t:dgCol title="报警上午开始时间" field="ambegin" ></t:dgCol>
   			<t:dgCol title="上午结束时间" field="amend" ></t:dgCol>
   			<t:dgCol title="报警下午开始时间" field="pmbegin" ></t:dgCol>
   			<t:dgCol title="下午结束时间" field="pmend" ></t:dgCol>
   			<t:dgCol title="短信报警设置方式" field="smssettype" ></t:dgCol>
   			<t:dgCol title="设备安装地址" field="shebeidizhi" ></t:dgCol>
   			<t:dgCol title="设备占地面积" field="shebeimianji" ></t:dgCol>
   		--%>
   			<t:dgCol title="设备操作人" field="caozuoren" ></t:dgCol>
   			<t:dgCol title="站长" field="zhanzhang" ></t:dgCol>
   			<t:dgCol title="联系电话" field="lianxidianhua" ></t:dgCol>
   		<%--
   			<t:dgCol title="数据时间格式" field="shijiangeshi" ></t:dgCol>
   			<t:dgCol title="排序" field="orderid" ></t:dgCol>
   			<t:dgCol title="所示部门" field="departid" ></t:dgCol>
   			<t:dgCol title="备注" field="remark" ></t:dgCol>
    	--%>  
    		<t:dgToolBar title="拌和机配置-录入" icon="icon-add" url="banhezhanxinxiController.do?addorupdate" funname="add"></t:dgToolBar>
   		<%--
   			<t:dgToolBar title="拌和机配置-编辑" icon="icon-edit" url="banhezhanxinxiController.do?addorupdate" funname="update"></t:dgToolBar>
   			<t:dgToolBar title="拌和机配置-查看" icon="icon-search" url="banhezhanxinxiController.do?addorupdate" funname="detail"></t:dgToolBar>
    	--%>
  		</t:datagrid>
<div id="logListtb" style="padding: 3px; height: 50px"><!-- update---Author:赵俊夫  Date:20130507 for：需要加name=searchColums属性 -->
	<div name="searchColums" style="float: left; padding-right: 15px;">
		<table>
			<tr>
				<td align="left" rowspan="2">所属机构</td>
				<td rowspan="2"><input id="ccbanhezhanxinxilist"  value="${depart.TSPDepart.departname}" style="height:24px;width:180px;">
					<div><input id="ccbanhezhanxinxilisttspdepartId" name="departid" style="display: none;" value="${depart.TSPDepart.id}"></div>
					<%--
					<select id="hntclchaobiaolistshebeibianhao" name="shebeibianhao" style="height:24px;width:180px;"></select>
					 --%>
				</td>
				<td  rowspan="2">设备类型:</td>
				<td  rowspan="2" style="border:1px solid #ccc000;">
					<input class="easyui-validatebox" type="radio" name="temp" id="chaobiaoType0" value="1" onclick="chaobiaoTypeClick(this.id,1)"/>水泥混凝土&nbsp;&nbsp;
		   			<input class="easyui-validatebox" type="radio" name="temp"  id="chaobiaoType2" value="3" onclick="chaobiaoTypeClick(this.id,1)" />万能机 <br/>
		   			<input class="easyui-validatebox" type="radio" name="temp"  id="chaobiaoType1" value="2" onclick="chaobiaoTypeClick(this.id,1)" />沥青混凝土&nbsp;&nbsp;
		   			<input class="easyui-validatebox" type="radio" name="temp"  id="chaobiaoType3" value="4" onclick="chaobiaoTypeClick(this.id,1)" />压力机
		   			<input type="hidden" id="gprstype" name="gprstype" value="0">
		   		</td>	
		   		<td rowspan="2">是否报警:</td>
				<td rowspan="2" style="border:1px solid #ccc000;">
				<input type="radio" id="ab"  name="temp1" id="chulijieguoType0" onclick="chaobiaoTypeClick(this.id,2)" value="0" />未开启报警
		   		<input type="radio" id="ab1" name="temp1" id="chulijieguoType1" onclick="chaobiaoTypeClick(this.id,2)" value="1" />开启报警
		   		<input type="hidden" id="smsbaojin" name="smsbaojin" value="0">
   				<%--
   				<t:dictSelect field="CBLX" onclick="abc()"  id="CBLX" typeGroupCode="CBLX" defaultVal="--" hasLabel="false"  title="asd"></t:dictSelect>  
			 	--%>						
   			</td>
   			<td colspan="2" align="right"><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="banhezhanxinxiListsearch();" >查询</a></td>
		</tr>
	</table>
</div>
<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
 <script type="text/javascript">
 	$(function() {
		$('#ccbanhezhanxinxilist').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=3',
			onClick: function(node){
				$("#ccbanhezhanxinxilisttspdepartId").val(node.id);
				//banhezhanxinxiSelect(node.id,"hntclchaobiaolistshebeibianhao","1");
			}
		});
		//banhezhanxinxiSelect("","hntclchaobiaolistshebeibianhao","1");
	});
 	
 	 //单选按钮选择事件
 	 function chaobiaoTypeClick(id,type){
 		if(type==1){
 			$('#gprstype').val($('#'+id).val());
 		 }else{
 			$('#smsbaojin').val($('#'+id).val()); 
 		 }
 	 }
 	 
 	 //查看处理
 	 function operationDetailLook(xxid) {
 		// alert(jieguoid+"--"+jieguoid+"--"+gprsbianhao);
 		//add("超标查看","hunnintuchaobiaoViewController.do?hntxiangxicaocha&jieguoid="+jieguoid+"&xxid="+xxid+"&shebeibianhao="+gprsbianhao+"&operationType=1",'functionList',"1200px","500px");
 		 createdetailwindow("拌和机配置-查看","banhezhanxinxiController.do?addorupdate&id="+xxid,"650px","500px");
 	 }
 	 
 	 
 	function operationDetailEdit(xxid) {
 		// alert(jieguoid+"--"+jieguoid+"--"+gprsbianhao);
 		add("拌和机配置-编辑","banhezhanxinxiController.do?addorupdate&id="+xxid,'functionList',"650px","500px");
 	 }
 	 
</script>	
</div>
</div>