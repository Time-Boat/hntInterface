<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript" src="js/shiyanshi.js" charset="UTF-8"></script>
<div class="easyui-layout" fit="true">
	<div region="center" style="padding: 1px;">
		<t:datagrid  name="hanshuilvSy" title="含水率试验查询" actionUrl="hanshuilvController.do?datagrid" idField="id" fit="true">
	     	<t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
	     	<t:dgCol title="所属试验室" field="STATUS"></t:dgCol>
	     	<t:dgCol title="设备名称" field="SYJID"></t:dgCol>
	     	<t:dgCol title="材料名称" field="CLMC"></t:dgCol>
	     	<t:dgCol title="检测时间" field="JCSJ"></t:dgCol>
	     	<t:dgCol title="湿砂质量" field="SZL"></t:dgCol>
	     	<t:dgCol title="干砂质量" field="GZL"></t:dgCol>
	     	<t:dgCol title="含水率" field="HSL"></t:dgCol>
	     	<t:dgCol title="上传时间" field="SJSCSJ"></t:dgCol>
	     	<t:dgCol title="操作人员" field="CZRY"></t:dgCol>
	     	<t:dgCol title="施工配合比" field="SGPHB"></t:dgCol>
		</t:datagrid>	
		<div id="logListtb" style="padding: 3px; height: 50px"><!-- update---Author:赵俊夫  Date:20130507 for：需要加name=searchColums属性 -->
			<div name="searchColums" style="float: left; padding-right: 15px;">
				<table>
					<tr>
						<td>
							<span>所属机构:</span>
								<input id="hanshuilv"  value="${depart.TSPDepart.departname}" style="width: 160px;">
								<input id="hanshuilvdepartId" name="TSPDepart.id" style="display: none;" value="${depart.TSPDepart.id}">
							<span>设备名称:</span>
								<select id="hanshuilvshebeibianhao"  name="shebeibianhao" style="height:24px;width:120px;"></select>				
							<span>检测日期:</span>
								<input id="startTime"  type="text" name="startTime" class="easyui-datetimebox" />
							<span>至:</span>
								<input id="endTime" type="text" name="endTime"  class="easyui-datetimebox"/>
							<span>材料名称:</span>
								<input id="CLMC"  type="text" name="CLMC"  />
								<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearchhanshuilv();">查询</a>
						</td>
					</tr>
				</table>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		$('#hanshuilv').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=3',
			onClick: function(node){
				$("#hanshuilvdepartId").val(node.id);
				//连动试验室
				shebeiSelect(node.id,"hanshuilvshebeibianhao","");
			}
		});
		shebeiSelect("","hanshuilvshebeibianhao","");
	});
</script>