<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="v_ShiyanshiInfoList" title="试验室参数设置" actionUrl="v_ShiyanshiInfoController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="试验室名称" field="departname" ></t:dgCol>
   <t:dgCol title="试验室编码" field="fTrcode" ></t:dgCol>
   <t:dgCol title="检测区段" field="fJcqd" ></t:dgCol>
   <t:dgCol title="通讯地址" field="fAddress" ></t:dgCol>
 
   <t:dgCol title="联系电话" field="fTel" ></t:dgCol>
   <t:dgCol title="母体试验室名称" field="fMothroom" ></t:dgCol>
   <t:dgCol title="母体试验室认证编号" field="fMothauth" ></t:dgCol>
   <t:dgCol title="母体试验室认证有效期" field="fMothvaliddate" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
<%--    <t:dgFunOpt title="编辑" funname="operationDetailLook1(id)"/>
   <t:dgFunOpt title="查看" funname="operationDetailLook1(id)" /> --%>
   <t:dgDelOpt title="删除" url="v_ShiyanshiInfoController.do?del&id={id}" />
   
    <t:dgToolBar title="录入" icon="icon-add" url="v_ShiyanshiInfoController.do?addorupdate" funname="add" width="1000" height="510"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="v_ShiyanshiInfoController.do?addorupdate" funname="update"  width="1000" height="510"></t:dgToolBar>
     <t:dgToolBar title="查看" icon="icon-search" url="v_ShiyanshiInfoController.do?addorupdate" funname="detail" width="1000" height="510"></t:dgToolBar>
  </t:datagrid>
  
   <div id="logListtb" style="padding: 3px; height: 30px"><!-- update---Author:赵俊夫  Date:20130507 for：需要加name=searchColums属性 -->
<div name="searchColums" style="float: left; padding-right: 15px;">
<table>
	<tr>
		<td align="left">试验室名称</td>
		<td><input id="ccshiyanshiinfoList"  value="${depart.TSPDepart.departname}" style="height:27px;width:180px;">
			<div><input id="shiyanshiinfoListtspdepartId" name="departid" style="display: none;" value="${depart.TSPDepart.id}"></div>
		</td>
		<%--
		<td><select id="handsetListshebeibianhao" name="shebeibianhao"  style="height:27px;width:180px;"></select></td>
		 --%>
		<td rowspan="1" align="right"><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="v_ShiyanshiInfoListsearch();" >查询</a></td>
		<!-- <td rowspan="1" align="right"><a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="handsetListsearch();" >新增</a></td> -->
		</tr>
</table>
</div>
<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
 <script type="text/javascript">
 $(function() {
		$('#ccshiyanshiinfoList').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=3',
			onClick: function(node){
				$("#shiyanshiinfoListtspdepartId").val(node.id);
				//banhezhanxinxiSelect(node.id,"handsetListshebeibianhao","1");
			}
		});
		//banhezhanxinxiSelect("","handsetListshebeibianhao","1");
	});
 
 function v_ShiyanshiInfoListsearch() {
	 $('#v_ShiyanshiInfoList').datagrid('load', {
		 biaoduanid :$("#shiyanshiinfoListtspdepartId").val()
		});
	 }
/*  //查看处理
 function operationDetailLook1(id) {
	// alert(jieguoid+"--"+jieguoid+"--"+gprsbianhao);
	createdetailwindow("查看","hntwuchaViewController.do?datagrid1&id="+id,"1200px","200px");
 } */
 
</script>

  </div>
 </div>