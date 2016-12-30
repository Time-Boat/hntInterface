<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="v_YalijiList" title="压力机" actionUrl="v_YalijiController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="syjid" field="syjid" hidden="false" ></t:dgCol>  
   <t:dgCol title="caijizizengjiaid" field="caijizizengjiaid" hidden="false" ></t:dgCol>
   <t:dgCol title="fTrname" field="fTrname" hidden="false" ></t:dgCol>
   <t:dgCol title="设备名称" field="shebeijiancheng" ></t:dgCol>
   <t:dgCol title="实验名称" field="testname" ></t:dgCol>
   <t:dgCol title="施工配合比编号" field="rtcode" ></t:dgCol>
   <t:dgCol title="工程名称" field="wtbh" ></t:dgCol>
   <t:dgCol title="施工部位" field="cjmc" ></t:dgCol>
   <t:dgCol title="试件编号" field="sjbh" ></t:dgCol>
   <t:dgCol title="试验日期" field="syrq" ></t:dgCol>
   <t:dgCol title="龄期" field="lq" ></t:dgCol>
   <t:dgCol title="试件尺寸" field="sjcc" ></t:dgCol>
   <t:dgCol title="设计强度" field="sjqd" ></t:dgCol>
   <t:dgCol title="荷载" field="kylz" ></t:dgCol>
   <t:dgCol title="强度单值" field="kyqd" ></t:dgCol>
   <t:dgCol title="fGuid" field="fGuid" hidden="false"></t:dgCol>
   <t:dgCol title="强度代表值" field="qddbz" ></t:dgCol>
   <t:dgCol title="是否合格" field="pdjg" ></t:dgCol>   
<%--
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="v_YalijiController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="v_YalijiController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="v_YalijiController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="v_YalijiController.do?addorupdate" funname="detail"></t:dgToolBar>
 --%>     
  </t:datagrid>
   <div id="tbsj" style="padding:5px">	
		<div>
		<span>实验室:</span>
			<input id="ccv_yalijList"  value="${depart.TSPDepart.departname}" style="width: 140px;">
			<input id="v_WangnjListtspdepartId" name="TSPDepart.id" style="display: none;" value="${depart.TSPDepart.id}">
		<span>设备名称:</span>
			<select id="v_WangnjListshebeibianhao" name="shebeibianhao" ></select>				
		<span>施工配合比编号:</span>
			<input id="rtcode" name="rtcode" type="text" >
		<span>试件编号:</span>
			<input id="sjbh" name="sjbh" type="text">	
		<span>工程名称:</span>
			<input id="wtbh" name="wtbh" type="text" >					
		</div>
		<div>	
		<span>施工部位:</span>
			<input id="cjmc" name="cjmc" type="text" >		
		<span>设计强度:</span>
			<input id="sjqd" name="sjqd" type="text" >			
		<span>龄期:</span>
			<input id="lq" name="lq" type="text" >	
		<span>评定结果:</span>
			<input id="pdjg" name="pdjg" type="text" >						
		<span>试验日期:</span>
			<input id="v_WangnjListstartTime"  type="text" name="startTime" class="easyui-datebox" />
		<span>至:</span>
			<input id="v_WangnjListendTime" type="text" name="endTime"  class="easyui-datebox"/>	
		<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch();">查询</a>
		</div>
   
</div>
  <script type="text/javascript" src="js/shiyanshi.js" charset="UTF-8"></script>	
<script type="text/javascript">
$(function() {

	$('#ccv_yalijList').combotree({
		
		url : 'departController.do?setPFunction&selfId=${depart.id}&type=3',
		onClick: function(node){
			$("#v_WangnjListtspdepartId").val(node.id);
			shiyanshixinxiSelect(node.id,"v_WangnjListshebeibianhao");
		}
	});

	shiyanshixinxiSelect("","v_WangnjListshebeibianhao");

	
});

function doSearch() {
	 $('#v_WangnjList').datagrid('load', {			   
			startTime : $("input[name='startTime']").val(),
			endTime : $("input[name='endTime']").val(),
			pdjg : $('#pdjg').val(),
			sjbh : $('#sjbh').val(),
			sgbw : $('#sgbw').val(),
			gcmc : $('#gcmc').val(),
			pzbm : $('#pzbm').val(),
			testname : $('#testname').val(),
			departid : $("#v_WangnjListtspdepartId").val(),
			shebeibianhao : $("#v_WangnjListshebeibianhao").val()
		});	
	};

	//初始化时间
	$(function (){
		 var date = new Date();
		 var y = date.getFullYear();
		 var m0 = date.getMonth();
		 var m1 = date.getMonth() + 1;
		 var d = date.getDate();
		 var begin = y + '-' + (m0 < 10 ? ('0' + m0) : m0) + '-'
				+ (d < 10 ? ('0' + d) : d);
		 var end = y + '-' + (m1 < 10 ? ('0' + m1) : m1) + '-'
				+ (d < 10 ? ('0' + d) : d);
		 $("#v_WangnjListstartTime").val(begin);
		 $("#v_WangnjListendTime").val(end);
	});
</script>
  
  </div>
 </div>