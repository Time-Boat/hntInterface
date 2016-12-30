<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="tophunnintuViewList" title="拌和机状态查询" actionUrl="tophunnintuViewController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="所属机构" field="departid" replace="${departsReplace}" width="100" frozenColumn="true" align="center" sortable="false" ></t:dgCol>
   <t:dgCol title="拌和站名称" field="banhezhanminchen" width="150" frozenColumn="true" align="center" sortable="false" ></t:dgCol>
   <t:dgCol title="出料时间" field="chuliaoshijian" width="120" frozenColumn="true" align="center" sortable="false" ></t:dgCol>
   <t:dgCol title="采集时间" field="baocunshijian" width="120" frozenColumn="true" align="center" sortable="false" ></t:dgCol>
   <t:dgCol title="上传时间" field="caijishijian" width="150" frozenColumn="true" align="center" sortable="false" ></t:dgCol>
   <t:dgCol title="工作状态" field="biaoshi" style="background:#D65859_3,background:#CAFEB1_2,background:#3C9EFE_1" width="60" frozenColumn="true" sortable="false" ></t:dgCol>
  
   
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol>--%>
<%--    <t:dgDelOpt title="删除" url="tophunnintuViewController.do?del&id={id}" /> --%>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="tophunnintuViewController.do?addorupdate" funname="add"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="编辑" icon="icon-edit" url="tophunnintuViewController.do?addorupdate" funname="update"></t:dgToolBar> --%>
 <%--   <t:dgToolBar title="查看" icon="icon-search" url="tophunnintuViewController.do?addorupdate" funname="detail"></t:dgToolBar>--%>
  </t:datagrid>
  
<div id="logListtb" style="padding: 3px; height: 50px"><!-- update---Author:赵俊夫  Date:20130507 for：需要加name=searchColums属性 -->
<div name="searchColums" style="float: left; padding-right: 15px;">
<table>
	<tr>
		<td align="left" >所属机构</td>
		<td ><input id="cc1"  value="${depart.TSPDepart.departname}" style="height:24px;width:180px;">
			<div><input id="tophunnintuViewListdepartId" name="departid" style="display: none;" value="${depart.TSPDepart.id}"></div>
			
		</td>
		<td><select id="tophunnintuviewlistshebeibianhao" name="shebeibianhao" style="height:24px;width:180px;"></select></td>
		
		
		<td style="width:320px;border:1px solid #ccc000;">
		拌合机状态2:
		<input class="easyui-validatebox" type="radio" name="temp" id="chaobiaoType0" value="0" onclick="zhuangtaiTypeClick(this.id)" checked  />全部 
   		<input class="easyui-validatebox" type="radio" name="temp"  id="chaobiaoType1" value="1" onclick="zhuangtaiTypeClick(this.id)"  />正常工作
   		<input class="easyui-validatebox" type="radio" name="temp"  id="chaobiaoType2" value="2" onclick="zhuangtaiTypeClick(this.id)"  />延迟
   		<input class="easyui-validatebox" type="radio" name="temp"  id="chaobiaoType3" value="3" onclick="zhuangtaiTypeClick(this.id)"  />未工作
   		<input type="hidden" id="biaoshi" name="biaoshi" value="0">
   		</td>	
   		
   		<td  align="left"><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="tophunnintuViewListsearch();" >查询</a></td>
   		
	</tr>
	<tr>
	   <td align="left" colspan="5">正常工作：24小时之内有数据上传，在20分钟内无延时采集，30分钟内无延时上传； 延时工作：24小时之内有数据上传，在20分钟内延时采集或者30分钟内延时上传; 未工作：24小时之内无数据上传;</td>
	</tr>
	
</table>
</div>
<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
 <script type="text/javascript">
 	$(function() {
		$('#cc1').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
			onClick: function(node){
		    $("#tophunnintuViewListdepartId").val(node.id);
			  banhezhanxinxiSelect(node.id,"tophunnintuviewlistshebeibianhao","1");
			}
		});
		banhezhanxinxiSelect("","tophunnintuviewlistshebeibianhao","1");
	});
 //单选按钮选择事件
 function zhuangtaiTypeClick(id){
	
		$('#biaoshi').val($('#'+id).val());
	 
 }
 </script>

  
  
  </div>
 </div>