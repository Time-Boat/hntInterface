<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
	<div region="center" style="padding: 1px;">
		<t:datagrid name="shigongpeibiList" title="施工配合比列表" actionUrl="ingroundManagerController.do?datagrid" idField="id" fit="true" fitColumns="false">
			<t:dgCol title="操作" field="opt" frozenColumn="true"></t:dgCol>
			<t:dgFunOpt funname="sgoperationcopyandadd(id)" title="复制并录入"></t:dgFunOpt>
			<t:dgDelOpt title="删除" url="ingroundManagerController.do?del&id={id}"/>
		    <t:dgToolBar title="施工配合比录入" icon="icon-add" url="ingroundManagerController.do?addorupdate" funname="add" width="1200"></t:dgToolBar>
 			<t:dgFunOpt funname="sgoperationDetailEdit(id)" title="编辑" ></t:dgFunOpt>
   			<t:dgFunOpt funname="sgoperationDetail(id)" title="查看"></t:dgFunOpt>
			<t:dgCol title="施工配合比编号" field="id" hidden="false"></t:dgCol>
			<t:dgCol title="所属机构" field="userGroup" ></t:dgCol>
			<t:dgCol title="所属拌合站" field="shebeibianhao" replace="${departsReplace}"></t:dgCol>
			<t:dgCol title="理论配比" field="lilunId" ></t:dgCol>
			<t:dgCol title="任务单号" field="productWorkNo" ></t:dgCol>
			<t:dgCol title="出料方量(㎥)" field="chuliaofangliang" ></t:dgCol>
<%-- 			<t:dgCol title="细骨料1配比(%)" field="xigl1ph"></t:dgCol> --%>
<%-- 			<t:dgCol title="细骨料2配比(%)" field="xigl2ph"></t:dgCol> --%>
<%-- 			<t:dgCol title="粗骨料1配比(%)" field="chugl1ph"></t:dgCol> --%>
<%-- 			<t:dgCol title="粗骨料2配比(%)" field="chugl2ph"></t:dgCol> --%>
<%-- 			<t:dgCol title="粗骨料3配比(%)" field="chugl3ph"></t:dgCol> --%>
<%-- 			<t:dgCol title="水泥1配比(%)" field="shuini1ph"></t:dgCol> --%>
<%-- 			<t:dgCol title="矿粉配比(%)" field="kuangfenph"></t:dgCol> --%>
<%-- 			<t:dgCol title="粉煤灰配比(%)" field="fenmeihuiph"></t:dgCol> --%>
<%-- 			<t:dgCol title="水1配比(%)" field="shui1ph"></t:dgCol> --%>
<%-- 			<t:dgCol title="外加剂1配比(%)" field="waijijia1ph"></t:dgCol> --%>
<%-- 			<t:dgCol title="外加剂2配比(%)" field="waijijia2ph"></t:dgCol> --%>
<%-- 			<t:dgCol title="外加剂3配比(%)" field="waijijia3ph"></t:dgCol> --%>
<%-- 			<t:dgCol title="外加剂4配比(%)" field="waijijia4ph"></t:dgCol> --%>
			<t:dgCol title="水胶比(%)" field="shuijiaobi" ></t:dgCol>
			<t:dgCol title="报批日期" field="baopidata" ></t:dgCol>
			<t:dgCol title="批复日期" field="pifudata" ></t:dgCol>
			<t:dgCol title="备注" field="remark"></t:dgCol>
		</t:datagrid>
		<!-- 这里加条件 -->
		<!-- update---Author:赵俊夫  Date:20130507 for：需要加name=searchColums属性 -->
		<div id="logListtb" style="padding: 3px; height:50px">
		<div name="searchColums" style="float: left; padding-right: 15px;">
			<table cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td rowspan="2">所属机构:</td>
					<td width="190"><input id="cc_shigongpeibi"  value="${depart.TSPDepart.departname}" style="height:22px;width:175px;">
						<div><input id="ts_shigongdepartId" name="superGroup" style="display: none;" value="${depart.TSPDepart.id}"></div>
					</td>
					<td rowspan="2">&nbsp;&nbsp;&nbsp;&nbsp;报批日期:</td>
					<td >&nbsp;&nbsp;&nbsp;&nbsp;<input id="baopidata_begin" type="text" name="baopidata_begin" class="easyui-datebox" /></td>
					<td rowspan="2">&nbsp;&nbsp;&nbsp;&nbsp;批复日期:</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;<input id="pifudata_begin" type="text" name="pifudata_begin" class="easyui-datebox" /></td>
					<td rowspan="2">&nbsp;&nbsp;&nbsp;&nbsp;理论配比:</td>
					<td rowspan="2" align="center">&nbsp;&nbsp;&nbsp;&nbsp;
						<select id="lilunId" name="lilunId" style="height: 22px; width: 180px;">
							<option value="">-请选择理论配比-</option>
 							<c:forEach items="${lilunReplace}" var="lilun">
 								 <option value="${lilun.id}">${lilun.phbreportId}</option>
 							</c:forEach> 
 						</select> 
 					</td> 
 					<td rowspan="2" align="center">&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="Shigongsearch();" >查询</a></td>
 				</tr> 
 				<tr> 
 					<td><select id="shigongShebeibianhao" name="shebeibianhao" style="height: 22px; width: 180px;"></select></td> 
 					<td>至:<input id="baopidata_end" type="text" name="baopidata_end" class="easyui-datebox" /></td> 
 					<td>至:<input id="pifudata_end" type="text" name="pifudata_end" class="easyui-datebox" /></td>
 				</tr> 
 			</table> 
 		</div> 
		<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
		<script type="text/javascript">
			$(function() {
				$('#cc_shigongpeibi').combotree({
					url : 'departController.do?setPFunction&selfId=${depart.id}',
					onClick: function(node){
						$("#ts_shigongdepartId").val(node.id);
						banhezhanxinxiSelect(node.id,"shigongShebeibianhao","1");
					}
				});
				banhezhanxinxiSelect("","shigongShebeibianhao","1");
			});
			
			function Shigongsearch(){
				$('#shigongpeibiList').datagrid('load', {
					baopidata_begin : $('#baopidata_begin').val(),
					baopidata_end : $('#baopidata_end').val(),
					pifudata_begin : $('#pifudata_begin').val(),
					pifudata_end : $('#baopidata_end').val(),
					shebeibianhao :$('#shigongShebeibianhao').val(),
					lilunId : $('#lilunId').val()
				});
			}
		
		 	function sgoperationDetailEdit(id) {
				add("施工配合比编辑","ingroundManagerController.do?addorupdate&id="+id,'functionList',"1200px","500px");
			}
		 	function sgoperationDetail(id) {
			 	createdetailwindow("施工配合比查看","ingroundManagerController.do?addorupdate&id="+id,"1200px","500px");
			}
		 	
		 	function sgoperationcopyandadd(id) {
				add("施工配合比录入","ingroundManagerController.do?copyandadd&id="+id,'functionList',"1200px","500px");
			}
		</script>
	</div>
</div>