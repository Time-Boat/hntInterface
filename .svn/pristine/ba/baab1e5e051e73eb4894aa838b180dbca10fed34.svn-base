<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="v_SYJZB1List" title="试验信息周报" actionUrl="v_SYJZBController.do?datagrid1"     idField="id" fit="true">
  <t:dgCol title="试验单位" field="departname" rowspan="2" colspan="1"></t:dgCol>
   <t:dgCol title="检查项目" field="testname"  rowspan="2" colspan="1"></t:dgCol>
   <t:dgCol title="本周检查自检"  field="sylx"  colspan="3" rowspan="1"></t:dgCol>
   <t:dgCol title="本周检查见证"  field="wtbh"  colspan="1" rowspan="1"></t:dgCol>
   <t:dgCol title="本周检查平行"  field="sjbh"  colspan="1" rowspan="1"></t:dgCol>
   
   <t:dgCol title="本周合格自检"  field="sjcc"  colspan="3" rowspan="1"></t:dgCol>
   <t:dgCol title="本周合格见证"  field="sjmj"  colspan="1" rowspan="1"></t:dgCol>
   <t:dgCol title="本周合格平行"  field="sjsl"  colspan="1" rowspan="1"></t:dgCol>  
     
   <t:dgCol title="合格率(%)自检"  field="sjqd"  colspan="3" rowspan="1"></t:dgCol>
   <t:dgCol title="合格率(%)见证"  field="zsxs"  colspan="1" rowspan="1"></t:dgCol>
   <t:dgCol title="合格率(%)平行"  field="qddbz"  colspan="1" rowspan="1"></t:dgCol>
  
	<t:dgCol title="累计自检"  field="parentdepartid"  colspan="3" rowspan="1"></t:dgCol>
   <t:dgCol title="累计见证"  field="leixin"  colspan="1" rowspan="1"></t:dgCol>
   <t:dgCol title="累计平行"  field="area"  colspan="1" rowspan="1"></t:dgCol>
   
    <t:dgCol title="见证率(%)"  field="cjmc"  colspan="1" rowspan="1"></t:dgCol>
   <t:dgCol title="平行试验频率(%)"  field="pzbm"  colspan="1" rowspan="1"></t:dgCol>
  </t:datagrid>
<div id="logListtb" style="padding: 3px; height: 50px"><!-- update---Author:赵俊夫  Date:20130507 for：需要加name=searchColums属性 -->
<div name="searchColums" style="float: left; padding-right: 15px;">
<table>
	<tr>
		<td align="left" rowspan="2">部门</td>
		<td rowspan="2"><input id="ccsyj1zb"  value="${depart.TSPDepart.departname}" style="height:24px;width:180px;">
			<div><input id="ccsyjz1blisttspdepartId" name="departid" style="display:none;" value="${depart.TSPDepart.id}"></div>
			<select id="ccsyjz1blistshebeibianhao" name="shebeibianhao" style="height:24px;width:180px;"></select>
		</td>
		<td rowspan="2">试验日期:</td>
		<td>
		<input id="shiyan1startTime" type="text" name="shiyan1startTime" class="easyui-datebox" /><br>
		<input id="shiyan1endTime" type="text" name="shiyan1endTime" class="easyui-datebox" />
		</td>
   		<td colspan="2" align="right"><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="shiyan1Listsearch();" >查询</a></td>
	</tr>
</table>
</div>
<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
 <script type="text/javascript">
 	$(function() {
		$('#ccsyj1zb').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
			onClick: function(node){
				$("#ccsyjz1blisttspdepartId").val(node.id);
				banhezhanxinxiSelect(node.id,"ccsyjz1blistshebeibianhao","1");
			}
		});
		banhezhanxinxiSelect("","ccsyjzblistshebeibianhao","1");
	});
 	function shiyan1Listsearch(){
 		$('#v_SYJZB1List').datagrid('load', {
 			starttime : $("input[name='shiyan1startTime']").val(),
			endtime : $("input[name='shiyan1endTime']").val(),
			biaoduanid : $("#ccsyjz1blisttspdepartId").val(),
			shebeibianhao : $("#ccsyjz1blistshebeibianhao").val()
		});	
 		
 	}
 </script>
  </div>
 </div>