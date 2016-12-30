<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="testerInfoViewList" title="人员信息" actionUrl="testerInfoViewController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
    
    <t:dgCol title="姓名" field="fTrpname" ></t:dgCol>
   <t:dgCol title="所在单位" field="departname" ></t:dgCol>
   <t:dgCol title="入职日期" field="fWorkdate" ></t:dgCol>
   <t:dgCol title="技术职称" field="fJszc" ></t:dgCol>
   <t:dgCol title="职务" field="fZw" ></t:dgCol>
   
   <t:dgCol title="出生年月" field="fbirthday" ></t:dgCol>
   <t:dgCol title="联系方式" field="fTrptel" ></t:dgCol>
    
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="testerInfoViewController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="testerInfoViewController.do?addorupdate" funname="add"  width="1000" height="510"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="testerInfoViewController.do?addorupdate" funname="update"  width="1000" height="510"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="testerInfoViewController.do?addorupdate" funname="detail"  width="1000" height="510"></t:dgToolBar>
  </t:datagrid>
  <div id="logListtb" style="padding: 3px; height: 30px"><!-- update---Author:赵俊夫  Date:20130507 for：需要加name=searchColums属性 -->
<div name="searchColums" style="float: left; padding-right: 15px;">
<table>
	<tr>
		<td align="left">试验室名称：</td>
		<td><input id="cctesterinfoList"  value="${depart.TSPDepart.departname}" style="height:27px;width:180px;">
			<div><input id="testerinfoListtspdepartId" name="departid" style="display: none;" value="${depart.TSPDepart.id}"></div>
		</td>
		<td align="left">姓名：</td>
		<td><input id="name" name="name" type="text"></td>
		
		<td rowspan="1" align="right"><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="testerInfoListsearch();" >查询</a></td>
		<!-- <td rowspan="1" align="right"><a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="handsetListsearch();" >新增</a></td> -->
		</tr>
</table>
</div>
<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
 <script type="text/javascript">
 $(function() {
		$('#cctesterinfoList').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=3',
			onClick: function(node){
				$("#testerinfoListtspdepartId").val(node.id);
				//banhezhanxinxiSelect(node.id,"handsetListshebeibianhao","1");
			}
		});
		//banhezhanxinxiSelect("","handsetListshebeibianhao","1");
	});
 
 function testerInfoListsearch() {
	 $('#testerInfoViewList').datagrid('load', {
		 biaoduanid :$("#testerinfoListtspdepartId").val(),
		 name :$("#name").val()
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