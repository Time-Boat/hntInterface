<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="handsetList" title="报警手机号码配置" actionUrl="handsetController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="群组名称" field="name" ></t:dgCol>
   <t:dgCol title="手机号组" field="phone" ></t:dgCol>
   <t:dgCol title="所属机构" field="biaoduan" replace="${departsReplace}"></t:dgCol>
   <t:dgCol title="手机号对应人员名称" field="owername" ></t:dgCol>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="handsetController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="handsetController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="handsetController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="handsetController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  
   <div id="logListtb" style="padding: 3px; height: 30px"><!-- update---Author:赵俊夫  Date:20130507 for：需要加name=searchColums属性 -->
<div name="searchColums" style="float: left; padding-right: 15px;">
<table>
	<tr>
		<td align="left">所属机构</td>
		<td><input id="cchandsetList"  value="${depart.TSPDepart.departname}" style="height:27px;width:180px;">
			<div><input id="handsetListtspdepartId" name="departid" style="display: none;" value="${depart.TSPDepart.id}"></div>
		</td>
		<%--
		<td><select id="handsetListshebeibianhao" name="shebeibianhao"  style="height:27px;width:180px;"></select></td>
		 --%>
		<td rowspan="2" align="right"><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="handsetListsearch();" >查询</a></td>
		</tr>
</table>
</div>
<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
 <script type="text/javascript">
 $(function() {
		$('#cchandsetList').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
			onClick: function(node){
				$("#handsetListtspdepartId").val(node.id);
				//banhezhanxinxiSelect(node.id,"handsetListshebeibianhao","1");
			}
		});
		//banhezhanxinxiSelect("","handsetListshebeibianhao","1");
	});
</script>

  </div>
 </div>