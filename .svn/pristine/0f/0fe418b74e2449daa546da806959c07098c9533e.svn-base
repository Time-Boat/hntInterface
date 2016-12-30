<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="topRealMaxhunnintuViewList" title="水泥混凝土短信报警配置" actionUrl="topRealMaxhunnintuViewController.do?datagrid" 
  idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="所属机构" field="departid" replace="${departsReplace }"></t:dgCol>
   <t:dgCol title="拌和站名称" field="banhezhanminchen"></t:dgCol>
   <t:dgCol title="拌和站编号" field="shebeibianhao"></t:dgCol>
   <t:dgCol title="简称" field="jianchen" ></t:dgCol>
   <%--<t:dgCol title="smsbaojin" field="smsbaojin" replace="不报警_1,报警_0"></t:dgCol> --%>
   <t:dgCol title="操作" field="opt" frozenColumn="true"></t:dgCol>
   <t:dgFunOpt funname="operationDetailEdit(id,shebeibianhao)" title="编辑" ></t:dgFunOpt>
   <t:dgFunOpt funname="operationDetail(id,shebeibianhao)" title="默认设置"></t:dgFunOpt>
   <!-- 
    title="设为默认值" url="topRealMaxhunnintuViewController.do?smscfginput&id={id}&leixinbh={gprsbianhao}&setdefault=1" />
     -->
   <t:dgDelOpt title="删除" url="topRealMaxhunnintuViewController.do?delsmscfg&shebeibianhao={shebeibianhao}" />
   
   <%--
   <t:dgToolBar title="录入" icon="icon-add" url="topRealMaxhunnintuViewController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="topRealMaxhunnintuViewController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="topRealMaxhunnintuViewController.do?addorupdate" funname="detail"></t:dgToolBar>
    --%>
  </t:datagrid>
  
   <div id="logListtb" style="padding: 3px; height: 30px"><!-- update---Author:赵俊夫  Date:20130507 for：需要加name=searchColums属性 -->
<div name="searchColums" style="float: left; padding-right: 15px;">
<table>
	<tr>
		<td align="left">所属机构</td>
		<td><input id="ccsmscfgList"  value="${depart.TSPDepart.departname}" style="height:27px;width:180px;">
			<div><input id="ccsmscfgListtspdepartId" name="departid" style="display: none;" value="${depart.TSPDepart.id}"></div>
		</td>
		<td><select id="smscfgListshebeibianhao" name="shebeibianhao"  style="height:27px;width:180px;"></select></td>
		<td rowspan="2" align="right"><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="topRealMaxhunnintuViewListsearch();" >查询</a></td>
		</tr>
</table>
</div>
<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
 <script type="text/javascript">
 $(function() {
		$('#ccsmscfgList').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
			onClick: function(node){
				$("#ccsmscfgListtspdepartId").val(node.id);
				banhezhanxinxiSelect(node.id,"smscfgListshebeibianhao","1");
			}
		});
		banhezhanxinxiSelect("","smscfgListshebeibianhao","1");
		//alert($(".pagination-prev").parent().parent().parent().parent().html());
		//上一页
		//$(".pagination-prev").parent().parent().parent().parent().bind({"click":function(){alert("adf");}});
		//下一页
		//$(".pagination-next").parent().parent().parent().parent().bind({"click":function(){alert("adf");}});
	});
</script>
  
  
  </div>
 </div>
 <script type="text/javascript">
 function operationDetailEdit(id,gprsbianhao) {
		add("报警配置编辑","topRealMaxhunnintuViewController.do?smscfginput&id="+id+"&leixinbh="+gprsbianhao+"&setdefault=0",'functionList',"1200px","500px");
	}
 function operationDetail(id,gprsbianhao) {
		add("报警配置默认值","topRealMaxhunnintuViewController.do?smscfginput&id="+id+"&leixinbh="+gprsbianhao+"&setdefault=1",'functionList',"1200px","500px");
	}
 </script>