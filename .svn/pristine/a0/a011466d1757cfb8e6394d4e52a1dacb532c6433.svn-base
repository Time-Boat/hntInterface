<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<link rel="stylesheet" href="plug-in/jqGrid/css/ui.jqgrid.css" />
<link rel="stylesheet" href="plug-in/jqGrid/redmond/jquery-ui-1.8.16.custom.css" /> 
<script type="text/javascript" src="plug-in/jqGrid/js/jquery.jqGrid.src.js"></script>
<script type="text/javascript" src="plug-in/jqGrid/js/i18n/grid.locale-cn.js"></script> 
<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
<!-- 添加查询条件 -->
<table id="table">
	<thead>
		<tr>
			<th rowspan="2">组织机构:</th>
			<td><input id="cc_xiangxixx"  value="${depart.TSPDepart.departname}" style="width: 180px;">
				<input id="tspdepartId_xiangxixx" name="TSPDepart.id" style="display: none;" value="${depart.TSPDepart.id}"></td>
			<th rowspan="2">出料时间:</th>
			<td><input id="startTime_xiangxixx" type="text" name="startTime_xiangxixx" class="easyui-datebox" /></td>
<!-- 			<th>工程名称:</th> -->
<!-- 			<td><input id="gongchengmingchen_xiangxixx" type="text" name="gongchengmingchen_xiangxixx" /></td> -->
			<th rowspan="2">工程名称:</th>
			<td rowspan="2"><input id="gongchengmingchen_xiangxixx" type="text" name="gongchengmingchen_xiangxixx" /></td>
			<td rowspan="2">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="xiangxixx_doSearch()">查询</a>
				<a href="#" class="easyui-linkbutton" onclick="xiangxixx_upPage()">上一页</a>
				<a href="#" class="easyui-linkbutton" onclick="xiangxixx_downPage()">下一页</a>
			</td>
		</tr>
		<tr>
			<td><select id="shebeibianhao_xiangxixx" name="shebeibianhao_xiangxixx" style="height:22px;width:180px;"></select></td>
			<td><input id="endTime_xiangxixx" type="text" name="endTime_xiangxixx" class="easyui-datebox" /></td>
<!-- 			<th>当前页/总页数:</th> -->
<!-- 			<td><input id="pageNo" style="width:40px;" readonly="readonly"/>/<input id="records" style="width:90px;" readonly="readonly"/></td> -->
		</tr>
	</thead>
</table>

<!-- JqGrid -->
<table id="sg2"></table> 
<div id="psg2"></div>

<script type="text/javascript">
	var colNames=new Array();
	var oneColNames=new Array();
	var displayCols=new Array();
	//var colNames=['拌和站名称','工程名称','浇筑部位','强度等级','方量','出料时间','砂1','石1','砂2','石2','骨料5','水泥1','水泥2','矿粉3','粉煤灰4','粉料5','粉料6','水1','水2','外加剂1','外加剂2','外加剂3','外加剂4'];
	$(function(){
		//获取表格头部信息
		ajaxHeader();
	  	//组织机构下拉列表
	  	departSel();
	});
	
	//通过Ajax动态获取表头信息
	function ajaxHeader(pid,startTime,endTime,shebeibianhao,gongchengmingchen,curpagenum){
		if(pid=="undefined" || pid==undefined || pid==null || pid==""){
			pid="";
		}
		if(startTime=="undefined" || startTime==undefined || startTime==null || startTime==""){
			startTime="";
		}
		if(endTime=="undefined" || endTime==undefined || endTime==null || endTime==""){
			endTime="";
		}
		if(shebeibianhao=="undefined" || shebeibianhao==undefined || shebeibianhao==null || shebeibianhao==""){
			shebeibianhao="";
		}
		if(gongchengmingchen=="undefined" || gongchengmingchen==undefined || gongchengmingchen==null || gongchengmingchen==""){
			gongchengmingchen="";
		}
		if(curpagenum=="undefined" || curpagenum==undefined || curpagenum==null || curpagenum==""){
			curpagenum="";
		}
		$.ajax({
			url:"xiangxixxyssjController.do?getTableHeader&shebeibianhao="+shebeibianhao,
			type:"post",
			dataType:"json",
			success:function(data){
				colNames[0]="编号";
				colNames[1]="拌和站名称";
				colNames[2]="工程名称";
				colNames[3]="浇筑部位";
				colNames[4]="强度等级";
				colNames[5]="方量";
				colNames[6]="出料时间";
				colNames[7]=data.hbfield.sha1_shijizhi;
				colNames[8]=data.hbfield.shi1_shijizhi;
				colNames[9]=data.hbfield.sha2_shijizhi;
				colNames[10]=data.hbfield.shi2_shijizhi;
				colNames[11]=data.hbfield.guliao5_shijizhi;
				colNames[12]=data.hbfield.shuini1_shijizhi;
				colNames[13]=data.hbfield.shuini2_shijizhi;
				colNames[14]=data.hbfield.kuangfen3_shijizhi;
				colNames[15]=data.hbfield.feimeihui4_shijizhi;
				colNames[16]=data.hbfield.fenliao5_shijizhi;
				colNames[17]=data.hbfield.fenliao6_shijizhi;
				colNames[18]=data.hbfield.shui1_shijizhi;
				colNames[19]=data.hbfield.shui2_shijizhi;
				colNames[20]=data.hbfield.waijiaji1_shijizhi;
				colNames[21]=data.hbfield.waijiaji2_shijizhi;
				colNames[22]=data.hbfield.waijiaji3_shijizhi;
				colNames[23]=data.hbfield.waijiaji4_shijizhi;
				//colNames[24]="详情";
				//加载表格
				if(pid=="" && startTime=="" && endTime=="" && shebeibianhao=="" && gongchengmingchen=="" && curpagenum==""){
					pageInit("","","","","","");
				}else{
					//真是坑爹，当有参数还要重新调用另一个方法,这API我也是醉了
					pageByButton(pid,startTime,endTime,shebeibianhao,gongchengmingchen,curpagenum);
				}
				
			}
		});
	}
	
	//点击查看按钮时发生
	function xiangxixx_doSearch(){
		var pid=$("#tspdepartId_xiangxixx").val();
		var startTime=$("input[name='startTime_xiangxixx']").val();
		var endTime=$("input[name='endTime_xiangxixx']").val();		
		var shebeibianhao=$("#shebeibianhao_xiangxixx").val();
		var gongchengmingchen=$("input[name='gongchengmingchen_xiangxixx']").val();
		//得到当前页码
		var curpagenum = $("#sg2").jqGrid('getGridParam', 'page');
		//获取表格头部信息
		ajaxHeader(pid,startTime,endTime,shebeibianhao,gongchengmingchen,curpagenum);		
	}
	
	//点击下一个时发生
	function xiangxixx_downPage(){
		var pid=$("#tspdepartId_xiangxixx").val();
		var startTime=$("input[name='startTime_xiangxixx']").val();
		var endTime=$("input[name='endTime_xiangxixx']").val();		
		var shebeibianhao=$("#shebeibianhao_xiangxixx").val();
		var gongchengmingchen=$("input[name='gongchengmingchen_xiangxixx']").val();
		//得到当前页码
		var curpagenum = $("#sg2").jqGrid('getGridParam', 'page');
		var rowListNum = $("#sg2").jqGrid('getGridParam', 'records');
		curpagenum+=1;
		//获取表格头部信息
		ajaxHeader(pid,startTime,endTime,shebeibianhao,gongchengmingchen,curpagenum);
	}
	
	//点击下一个时发生
	function xiangxixx_upPage(){
		var pid=$("#tspdepartId_xiangxixx").val();
		var startTime=$("input[name='startTime_xiangxixx']").val();
		var endTime=$("input[name='endTime_xiangxixx']").val();		
		var shebeibianhao=$("#shebeibianhao_xiangxixx").val();
		var gongchengmingchen=$("input[name='gongchengmingchen_xiangxixx']").val();
		//得到当前页码
		var curpagenum = $("#sg2").jqGrid('getGridParam', 'page');
		curpagenum=curpagenum-1;
		if(curpagenum==1){
			tip("当前已经是第一页了");
		}else{
			//获取表格头部信息
			ajaxHeader(pid,startTime,endTime,shebeibianhao,gongchengmingchen,curpagenum);
		}
	}
	
	//组织机构下拉列表
	function departSel(){
		$("#cc_xiangxixx").combotree({
			url : "departController.do?setPFunction&selfId=${depart.id}&type=1",
			onClick: function(node){
				$("#tspdepartId_xiangxixx").val(node.id);
				banhezhanxinxiSelect(node.id,"shebeibianhao_xiangxixx","1");
			}
		});
		banhezhanxinxiSelect("","shebeibianhao_xiangxixx","1");
	}
	
	//当用户点击按钮触发事件时，需要重新方法
	function pageByButton(pid,startTime,endTime,shebeibianhao,gongchengmingchen,curpagenum){
		var url="xiangxixxyssjController.do?datagrid&pid="+pid+"&startTime="+startTime+"&endTime="+endTime+"&shebeibianhao="+shebeibianhao+"&gongchengmingchen="+gongchengmingchen+"&pageNo="+curpagenum;
		jQuery("#sg2").jqGrid("setGridParam", {
            url: url,
            page: 1
        }).trigger("reloadGrid");
	}
	
	function pageInit(pid,startTime,endTime,shebeibianhao,gongchengmingchen,curpagenum){
		var url="xiangxixxyssjController.do?datagrid&pid="+pid+"&startTime="+startTime+"&endTime="+endTime+"&shebeibianhao="+shebeibianhao+"&gongchengmingchen="+gongchengmingchen+"&pageNo="+curpagenum;
		jQuery("#sg2").jqGrid({
	    	url:url,
	    	datatype: "json",
	    	height: 350,
	    	width:1165,
	       	colModel:[
	       	    {name:colNames[0],index:"id",hidden:true},
				{name:colNames[1],index:"banhezhanminchen",width:225},
				{name:colNames[2],index:"gongchengmingcheng",width:185},
				{name:colNames[3],index:"jiaozuobuwei",width:185},
				{name:colNames[4],index:"qiangdudengji",width:185},
				{name:colNames[5],index:"gujifangshu",width:125},
				{name:colNames[6],index:"chuliaoshijian",width:475},
				{name:colNames[7],index:"sha1_shijizhi"},
				{name:colNames[8],index:"shi1_shijizhi"},
				{name:colNames[9],index:"sha2_shijizhi"},
				{name:colNames[10],index:"shi2_shijizhi"},
				{name:colNames[11],index:"guliao5_shijizhi"},
				{name:colNames[12],index:"shuini1_shijizhi"},
				{name:colNames[13],index:"shuini2_shijizhi"},
				{name:colNames[14],index:"kuangfen3_shijizhi"},
				{name:colNames[15],index:"feimeihui4_shijizhi"},
				{name:colNames[16],index:"fenliao5_shijizhi"},
				{name:colNames[17],index:"fenliao6_shijizhi"},
				{name:colNames[18],index:"shui1_shijizhi"},
				{name:colNames[19],index:"shui2_shijizhi"},
				{name:colNames[20],index:"waijiaji1_shijizhi"},
				{name:colNames[21],index:"waijiaji2_shijizhi"},
				{name:colNames[22],index:"waijiaji3_shijizhi"},
				{name:colNames[23],index:"waijiaji4_shijizhi"}
	       	],
	       	rowNum:20,
	       	pager: "#psg2",
	       	sortname: "chuliaoshijian",
	      	viewrecords: true,
	      	sortorder: "desc",
	    	multiselect: false,
	        autoScroll: true,
	    	subGrid: true,
	    	caption: "树形表格列表",
	      	subGridOptions: {
	          	"plusicon"  : "ui-icon-triangle-1-e",
	          	"minusicon" : "ui-icon-triangle-1-s",
	          	"openicon"  : "ui-icon-arrowreturn-1-e",
	      		"expandOnLoad" : true
	    	},
	    	subGridRowExpanded: function(subgrid_id, row_id) {
	      		var subgrid_table_id;
	      		subgrid_table_id = subgrid_id+"_t";
 	      		$("#"+subgrid_id).html("<table id='"+subgrid_table_id+"'></table>");
				//得到字表的表格头部
				oneTableHeader(subgrid_table_id,row_id);	      		
	    	}
	  	});		
	}
	
	//判断是否是数组类型
	function isArray(arr){
	    return arr instanceof Array;
	}
	
	//获得字表的表头
	function oneTableHeader(subgrid_table_id,rowId){
		$.ajax({
			url:"xiangxixxyssjController.do?getOneTableHeader&rowId="+rowId,
			type:"post",
			dataType:"json",
			success:function(data){
				oneColNames[0]="编号";
				displayCols[0]=true;
				oneColNames[1]="投料完成时间";
				displayCols[1]=false;
				oneColNames[2]="卸砼开始时间";
				displayCols[2]=false;				
				oneColNames[3]="搅拌时间";
				displayCols[3]=false;	
				isBlank(data.xiangxixx.sha1name,4);
				isBlank(data.xiangxixx.shi1name,5);
				isBlank(data.xiangxixx.shi2name,6);
				isBlank(data.xiangxixx.sha2name,7);
				isBlank(data.xiangxixx.guliao5name,8);
				isBlank(data.xiangxixx.shuini1name,9);
				isBlank(data.xiangxixx.shuini2name,10);
				isBlank(data.xiangxixx.kuangfen3name,11);
				isBlank(data.xiangxixx.feimeihui4name,12);
				isBlank(data.xiangxixx.fenliao5name,13);
				isBlank(data.xiangxixx.fenliao6name,14);
				isBlank(data.xiangxixx.shui1name,15);
				isBlank(data.xiangxixx.shui2name,16);
				isBlank(data.xiangxixx.waijiaji1name,17);
				isBlank(data.xiangxixx.waijiaji2name,18);
				isBlank(data.xiangxixx.waijiaji3name,19);
				isBlank(data.xiangxixx.waijiaji4name,20);
				//加载子表格
				oneJdGrid(subgrid_table_id,rowId);
			}
		});
	}
	
	//调用子表格的jdgrid
	function oneJdGrid(subgrid_table_id,row_id){
		jQuery("#"+subgrid_table_id).jqGrid({
    		url:"xiangxixxyssjController.do?SubGrid&rowId="+row_id,
    		datatype: "json",
    		colNames:oneColNames,
    		colModel: [
      			{name:oneColNames[0],index:"id",hidden:displayCols[0]},
      			{name:oneColNames[1],index:'tlwcsj',width:25,hidden:displayCols[1],width:125},
	         	{name:oneColNames[2],index:'xhkssj',hidden:displayCols[2],width:125},
				{name:oneColNames[3],index:'jbsj',hidden:displayCols[3],width:55},
	         	{name:oneColNames[4],index:'sha1weight',hidden:displayCols[4],width:35},
	         	{name:oneColNames[5],index:'shi1weight',hidden:displayCols[5],width:35},
	         	{name:oneColNames[6],index:'shi2weight',hidden:displayCols[6],width:35},
	         	{name:oneColNames[7],index:'sha2weight',hidden:displayCols[7],width:35},
	         	{name:oneColNames[8],index:'guliao5weight',hidden:displayCols[8],width:35},
	         	{name:oneColNames[9],index:'shuini1weight',hidden:displayCols[9],width:35},
	         	{name:oneColNames[10],index:'shuini2weight',hidden:displayCols[10],width:35},
	         	{name:oneColNames[11],index:'kuangfen3weight',hidden:displayCols[11],width:35},
	         	{name:oneColNames[12],index:'feimeihui4weight',hidden:displayCols[12],width:35},
	         	{name:oneColNames[13],index:'fenliao5weight',hidden:displayCols[13],width:35},
	         	{name:oneColNames[14],index:'fenliao6weight',hidden:displayCols[14],width:35},
	         	{name:oneColNames[15],index:'shui1weight',hidden:displayCols[15],width:35},
	         	{name:oneColNames[16],index:'shui2weight',hidden:displayCols[16],width:35},
	         	{name:oneColNames[17],index:'waijiaji1weight',hidden:displayCols[17],width:55},
				{name:oneColNames[18],index:'waijiaji2weight',hidden:displayCols[18],width:55},
				{name:oneColNames[19],index:'waijiaji3weight',hidden:displayCols[19],width:55},
				{name:oneColNames[20],index:'waijiaji4weight',hidden:displayCols[20],width:55}
    		],
  			height:40
  		});
	}
	
	//判断是否为空
	function isBlank(obj,index){
		if(obj==null || obj=="" || obj=="undefined" || obj==undefined){
			oneColNames[index]="";
			displayCols[index]=true;
		}else{
			oneColNames[index]=obj;
			displayCols[index]=false;
		}
	}
	
	function detail(cellvalue){
		alert(cellvalue);
	}
</script>

