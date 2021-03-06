<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="hunnintujieguoViewList" title="水泥混凝土超标结果视图" actionUrl="hunnintujieguoViewController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   
   <t:dgCol title="操作" field="opt" frozenColumn="true"></t:dgCol>
   <%--
   <t:dgDelOpt title="删除" url="hunnintujieguoViewController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="hunnintujieguoViewController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hunnintujieguoViewController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hunnintujieguoViewController.do?addorupdate" funname="detail"></t:dgToolBar>
    --%>
    <t:dgFunOpt funname="operationDetailLook(id,xinxibianhao,shebeibianhao)" title="查看"></t:dgFunOpt>
    
    <t:dgFunOpt exp="chulishijian#empty#true" funname="operationDetailChuli(id,xinxibianhao,shebeibianhao)"  operationCode="cbchuli" title="处理"></t:dgFunOpt>
    
    <t:dgFunOpt exp="shenpidate#empty#true" funname="operationDetailShenpi(id,xinxibianhao,shebeibianhao)"  operationCode="cbshenpi" title="审批"></t:dgFunOpt>
    
    <t:dgFunOpt exp="filepath#empty#true" operationCode="cbupload" funname="operationDetail(id)" title="上传" />
   <%--
    <t:dgFunOpt exp="filepath#empty#false" operationCode="cbdowload" funname="operationDetail(id)" title="下载" />
     --%>
    <t:dgDefOpt exp="filepath#empty#false" operationCode="cbdowload"  url="hunnintujieguoViewController.do?viewFile&filepath={filepath}" title="下载"></t:dgDefOpt>
    
   <%--
   <t:dgCol title="所属机构" field="departid" replace="${departsReplace}"></t:dgCol>
    --%>
   <t:dgCol title="设备编号" field="shebeibianhao"  hidden="false"></t:dgCol>
   <t:dgCol title="设备名称" field="banhezhanminchen" frozenColumn="true"></t:dgCol>
   <%--
   <t:dgCol title="设备简称" field="jianchen" ></t:dgCol>
    --%>
   <t:dgCol title="工程名称" field="gongchengmingcheng" ></t:dgCol>
   <t:dgCol title="浇筑部位" field="jiaozuobuwei" ></t:dgCol>
   <t:dgCol title="施工地点" field="sigongdidian" ></t:dgCol>
   <t:dgCol title="强度等级" field="qiangdudengji" ></t:dgCol>
   <t:dgCol title="配方号" field="peifanghao" ></t:dgCol>
   <t:dgCol title="出料时间" field="chuliaoshijian" frozenColumn="true"></t:dgCol>
   <t:dgCol title="保存时间" field="baocunshijian" ></t:dgCol>
   
   <%--
   <t:dgCol title="累积超标材料(个)" field="leiji" ></t:dgCol>
    --%>
   <t:dgCol title="超标类型" field="leixing" replace="高级_3,中级_2,初级_1" frozenColumn="true" style="background:#D65859_3,background:#CAFEB1_2,background:#3C9EFE_1"></t:dgCol>
   <%-- 
   <t:dgCol title="filepath" field="filepath" ></t:dgCol>
    --%>
   <%--
   <t:dgCol title="是否开启报警" field="smsbaojin" replace="未开启_0,开启_1"></t:dgCol>
   --%>
   <t:dgCol field="chuliren" title="超标处理人"></t:dgCol>
   <t:dgCol field="shenpiren" title="超标审批人"></t:dgCol>
   <t:dgCol title="信息编号" field="xinxibianhao" ></t:dgCol>
   
  </t:datagrid>
  
  <div id="logListtb" style="padding: 3px; height: 50px"><!-- update---Author:赵俊夫  Date:20130507 for：需要加name=searchColums属性 -->
<div name="searchColums" style="float: left; padding-right: 15px;">
<table>
	<tr>
		<td align="left" rowspan="2">所属机构</td>
		<td rowspan="2"><input id="cchntclchaobiaolist"  value="${depart.TSPDepart.departname}" style="height:24px;width:180px;">
			<div><input id="cchntclchaobiaolisttspdepartId" name="departid" style="display:none;" value="${depart.TSPDepart.id}"></div>
			<select id="hntclchaobiaolistshebeibianhao" name="shebeibianhao" style="height:24px;width:180px;"></select>
		</td>
		<td rowspan="2">出料时间:</td>
		<td>
		<input id="hntclchaobiaoliststartTime" type="text" name="startTime" class="easyui-datebox" />
		</td>
		<td  rowspan="2">超标级别:</td>
		<td  rowspan="2" style="border:1px solid #ccc000;">
		<input class="easyui-validatebox" type="radio" name="temp" id="chaobiaoType0" value="0" onclick="chaobiaoTypeClick(this.id,1)" checked/>全部 
   		&nbsp;&nbsp;&nbsp;&nbsp; 
   		<input class="easyui-validatebox" type="radio" name="temp"  id="chaobiaoType1" value="1" onclick="chaobiaoTypeClick(this.id,1)" />初级(蓝)<br/>
   		<input class="easyui-validatebox" type="radio" name="temp"  id="chaobiaoType2" value="2" onclick="chaobiaoTypeClick(this.id,1)" />中级(绿)
   		<input class="easyui-validatebox" type="radio" name="temp"  id="chaobiaoType3" value="3" onclick="chaobiaoTypeClick(this.id,1)" />高级(红)
   		<input type="hidden" id="leixing" name="leixing" value="0">
   		</td>	
   		<td rowspan="2">处理结果:</td>
		<td rowspan="2" style="border:1px solid #ccc000;">
		<input type="radio" id="ab"  name="temp1" id="chulijieguoType0" onclick="chaobiaoTypeClick(this.id,2)" value="0" checked />未处理
   		<input type="radio" id="ab1" name="temp1" id="chulijieguoType1" onclick="chaobiaoTypeClick(this.id,2)" value="1" />已处理
   		<input type="hidden" id="chulijieguoType" name="chulijieguoType" value="0">
   		<%--
   		<t:dictSelect field="CBLX" onclick="abc()"  id="CBLX"
									typeGroupCode="CBLX" defaultVal="--" hasLabel="false"  title="asd"></t:dictSelect>  
			 --%>						
   		</td>
   		<td>工程名称:</td>
   		<td><input name="gongchengmingcheng"/></td>
   		<td>信息编号:</td>
   		<td><input name="xinxibianhao" style="width:55px;"/></td>
	</tr>
	<tr>
		<td>
		<input id="hntclchaobiaolistendTime" type="text" name="endTime"  class="easyui-datebox"/>
		</td>
		
   		<td>浇筑部位:</td>
   		<td><input name="jiaozuobuwei"/></td>
   		<td colspan="2" align="right"><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="hunnintujieguoViewListsearch();" >查询</a></td>
	</tr>
</table>
</div>
<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
 <script type="text/javascript">
 	$(function() {
		$('#cchntclchaobiaolist').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
			onClick: function(node){
				$("#cchntclchaobiaolisttspdepartId").val(node.id);
				banhezhanxinxiSelect(node.id,"hntclchaobiaolistshebeibianhao","1");
			}
		});
		banhezhanxinxiSelect("","hntclchaobiaolistshebeibianhao","1");
		initTime();
	});
 //初始化时间
 function initTime(){
	 var date = new Date();
	 var y = date.getFullYear();
	 var m0 = date.getMonth() + 1;
	 var d = date.getDate();
	 var  end= y + '-' + (m0 < 10 ? ('0' + m0) : m0) + '-'
			+ (d < 10 ? ('0' + d) : d);
	 
	 date.setDate(date.getDate()-30); 
	 var y1= date.getFullYear();
	 var m1 = date.getMonth() + 1;
	 var d1 = date.getDate();
	 var begin = y1 + '-' + (m1 < 10 ? ('0' + m1) : m1) + '-'
			+ (d1 < 10 ? ('0' + d1) : d1);
	 
	 
 	 $("#hntclchaobiaoliststartTime").val(begin);
 	 $("#hntclchaobiaolistendTime").val(end);
 }
 //单选按钮选择事件
 function chaobiaoTypeClick(id,type){
	if(type==1){
		$('#leixing').val($('#'+id).val());
	 }else{
		$('#chulijieguoType').val($('#'+id).val()); 
	 }
 }
 //上传附件
 function operationDetail(id) {
	add("上传超标附件_"+id,"hunnintujieguoViewController.do?addFiles&id="+id,'functionList',"660px","160px");
 }
 //查看处理
 function operationDetailLook(jieguoid,xxid,gprsbianhao) {
	// alert(jieguoid+"--"+jieguoid+"--"+gprsbianhao);
	//add("超标查看","hunnintuchaobiaoViewController.do?hntxiangxicaocha&jieguoid="+jieguoid+"&xxid="+xxid+"&shebeibianhao="+gprsbianhao+"&operationType=1",'functionList',"1200px","500px");
	 createdetailwindow("超标查看","hunnintuchaobiaoViewController.do?hntxiangxicaocha&jieguoid="+jieguoid+"&xxid="+xxid+"&shebeibianhao="+gprsbianhao+"&operationType=1","1200px","500px");
	 
 }
 function operationDetailChuli(jieguoid,xxid,gprsbianhao) {
	// alert(jieguoid+"--"+jieguoid+"--"+gprsbianhao);
	operationDetail(jieguoid);
	add("超标查看及处理_"+jieguoid,"hunnintuchaobiaoViewController.do?hntxiangxicaocha&jieguoid="+jieguoid+"&xxid="+xxid+"&shebeibianhao="+gprsbianhao+"&operationType=2",'functionList',"1200px","500px");
	
 }
 function operationDetailShenpi(jieguoid,xxid,gprsbianhao) {
	// alert(jieguoid+"--"+jieguoid+"--"+gprsbianhao);
	add("超标查看及审批","hunnintuchaobiaoViewController.do?hntxiangxicaocha&jieguoid="+jieguoid+"&xxid="+xxid+"&shebeibianhao="+gprsbianhao+"&operationType=3",'functionList',"1200px","500px");
 }
 </script>
  
  
  </div>
 </div>