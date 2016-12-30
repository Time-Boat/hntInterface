<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="v_SYJZBList" title="试验信息月报" actionUrl="v_SYJZBController.do?datagrid"     idField="id" fit="true">
  <t:dgCol title="试验单位" field="departname" ></t:dgCol>
   <t:dgCol title="检查项目" field="testname"   ></t:dgCol>
   <t:dgCol title="本月检查自检"  field="sylx"   ></t:dgCol>
   <t:dgCol title="本月检查见证"  field="wtbh"   ></t:dgCol>
   <t:dgCol title="本月检查平行"  field="sjbh"   ></t:dgCol>
   
   <t:dgCol title="本月合格自检"  field="sjcc"   ></t:dgCol>
   <t:dgCol title="本月合格见证"  field="sjmj"   ></t:dgCol>
   <t:dgCol title="本月合格平行"  field="sjsl"   ></t:dgCol>  
     
   <t:dgCol title="合格率(%)自检"  field="sjqd"   ></t:dgCol>
   <t:dgCol title="合格率(%)见证"  field="zsxs"  ></t:dgCol>
   <t:dgCol title="合格率(%)平行"  field="qddbz"   ></t:dgCol>
  
	<t:dgCol title="累计自检"  field="parentdepartid"   ></t:dgCol>
   <t:dgCol title="累计见证"  field="leixin"   ></t:dgCol>
   <t:dgCol title="累计平行"  field="area"   ></t:dgCol>
   
    <t:dgCol title="见证率(%)"  field="cjmc"   ></t:dgCol>
   <t:dgCol title="平行试验频率(%)"  field="pzbm"  ></t:dgCol>
  
  </t:datagrid>
  
   <div id="logListtb" style="padding: 3px; height: 50px"><!-- update---Author:赵俊夫  Date:20130507 for：需要加name=searchColums属性 -->
<div name="searchColums" style="float: left; padding-right: 15px;">
<table>
	<tr>
		<td align="left" rowspan="2">部门</td>
		<td rowspan="2"><input id="ccsyjzb"  value="${depart.TSPDepart.departname}" style="height:24px;width:180px;">
			<div><input id="ccsyjzblisttspdepartId" name="departid" style="display:none;" value="${depart.TSPDepart.id}"></div>
			<select id="ccsyjzblistshebeibianhao" name="shebeibianhao" style="height:24px;width:180px;"></select>
		</td>
		<td rowspan="2">试验日期:</td>
		<td>
		<input id="shiyanstartTime" type="text" name="shiyanstartTime" class="easyui-datebox" /><br>
		<input id="shiyanendTime" type="text" name="shiyanendTime" class="easyui-datebox" />
		</td>
   		<td colspan="2" align="right"><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="shiyanListsearch();" >查询</a></td>
	</tr>
</table>
</div>
<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
 <script type="text/javascript">
 	$(function() {
		$('#ccsyjzb').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
			onClick: function(node){
				$("#ccsyjzblisttspdepartId").val(node.id);
				banhezhanxinxiSelect(node.id,"ccsyjzblistshebeibianhao","1");
			}
		});
		banhezhanxinxiSelect("","ccsyjzblistshebeibianhao","1");
	});
 	function shiyanListsearch(){
 		$('#v_SYJZBList').datagrid('load', {
 			starttime : $("input[name='shiyanstartTime']").val(),
			endtime : $("input[name='shiyanendTime']").val(),
			pid : $("#ccsyjzblisttspdepartId").val(),
			shebeibianhao : $("#ccsyjzblistshebeibianhao").val()
		});	
 		
 	}
 </script>
  </div>
 </div>