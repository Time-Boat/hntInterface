<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>	
<div class="easyui-layout" fit="true">
	<div region="center" style="padding:1px;" >
		<t:datagrid  name="hunnintuDuibi" title="拌和机对比查询" actionUrl="contrastController.do?datagrid" idField="id" fit="true" queryMode="true">
   			<t:dgCol title="编号" field="id"  hidden="hidden" ></t:dgCol>
   			<t:dgCol title="详细" field="opt" width="80"></t:dgCol>
   			<t:dgFunOpt funname="chakanxxyl(id)" title="查看"></t:dgFunOpt>
   		 	<c:if test="${hbfield!=null && hntbhzisShow!=null}">	
	     		<t:dgCol title="拌和机名称" field="banhezhanminchen" width="80"></t:dgCol>
	     		<c:if test="${ hntbhzisShow.gongdanhao==1}">
	     			<t:dgCol title="${hbfield.gongdanhao}" field="gongdanhao" width="80"></t:dgCol>    
			    </c:if>	
			    <c:if test="${ hntbhzisShow.gongchengmingcheng==1}">
			    	<t:dgCol title="${hbfield.gongchengmingcheng}" field="gongchengmingcheng" width="80"></t:dgCol>
			    </c:if>
			    <c:if test="${ hntbhzisShow.sigongdidian==1}">
			    	<t:dgCol title="${hbfield.sigongdidian}" field="sigongdidian" width="80"></t:dgCol>
			    </c:if>
			    <c:if test="${ hntbhzisShow.jiaozuobuwei==1}">
			    	<t:dgCol title="${hbfield.jiaozuobuwei}" field="jiaozuobuwei" width="80"></t:dgCol>	
			    </c:if>
			    <c:if test="${ hntbhzisShow.qiangdudengji==1}">
			    	<t:dgCol title="${hbfield.qiangdudengji}" field="qiangdudengji" width="80"></t:dgCol>
			    </c:if>
			    <c:if test="${ hntbhzisShow.gujifangshu==1}">
			    	<t:dgCol title="${hbfield.gujifangshu}" field="gujifangshu" width="80"></t:dgCol>
			    </c:if>
			    <c:if test="${hntbhzisShow.chuliaoshijian==1}">
			    	<t:dgCol title="${hbfield.chuliaoshijian}" field="chuliaoshijian" width="80"></t:dgCol>
			    </c:if>
			    <c:if test="${ hntbhzisShow.baocunshijian==1}">
			    	<t:dgCol title="${hbfield.baocunshijian}" field="baocunshijian" width="80"></t:dgCol>
			    </c:if>
			    <c:if test="${ hntbhzisShow.shui1_shijizhi==1}">
			    	<t:dgCol title="${hbfield.shui1_shijizhi}" field="shui1_shijizhi" width="80"></t:dgCol>
				</c:if>			    	
			    <c:if test="${hntbhzisShow.shui1_lilunzhi==1}">
			    	<t:dgCol title="${hbfield.shui1_lilunzhi}" field="shui1_lilunzhi" width="80"></t:dgCol>
				</c:if>
			    <c:if test="${ hntbhzisShow.shui2_shijizhi==1}">
			    	<t:dgCol title="${hbfield.shui2_shijizhi}" field="shui2_shijizhi" width="80"></t:dgCol>
				</c:if>	
			    <c:if test="${ hntbhzisShow.shui2_lilunzhi==1}">
			    	<t:dgCol title="${hbfield.shui2_lilunzhi}" field="shui2_lilunzhi" width="80"></t:dgCol>
			    </c:if>	
			    <c:if test="${ hntbhzisShow.shuini1_shijizhi==1}">
			    	<t:dgCol title="${hbfield.shuini1_shijizhi}" field="shuini1_shijizhi" width="80"></t:dgCol>
			    </c:if>			    	
			    <c:if test="${ hntbhzisShow.shuini1_lilunzhi==1}">
			    	<t:dgCol title="${hbfield.shuini1_lilunzhi}" field="shuini1_lilunzhi" width="80"></t:dgCol>
			    </c:if>
			    <c:if test="${hntbhzisShow.shuini2_shijizhi==1 }">
			    	<t:dgCol title="${hbfield.shuini2_shijizhi}" field="shuini2_shijizhi" width="80"></t:dgCol>			    	 
			    </c:if>
			    <c:if test="${ hntbhzisShow.shuini2_lilunzhi==1}">
			    	<t:dgCol title="${hbfield.shuini2_lilunzhi}" field="shuini2_lilunzhi" width="80"></t:dgCol>		    	 
			    </c:if>				    	
			    <c:if test="${ hntbhzisShow.sha1_shijizhi==1}">
			    	<t:dgCol title="${hbfield.sha1_shijizhi}" field="sha1_shijizhi" width="80"></t:dgCol>
			    </c:if>
			    <c:if test="${ hntbhzisShow.sha1_lilunzhi==1}">
			    	<t:dgCol title="${hbfield.sha1_lilunzhi}" field="sha1_lilunzhi" width="80"></t:dgCol>
			    </c:if>
			    <c:if test="${ hntbhzisShow.shi1_shijizhi==1}">
			    	<t:dgCol title="${hbfield.shi1_shijizhi}" field="shi1_shijizhi" width="80"></t:dgCol>			     
			   	</c:if>
			    <c:if test="${ hntbhzisShow.shi1_lilunzhi==1}">
			    	<t:dgCol title="${hbfield.shi1_lilunzhi}" field="shi1_lilunzhi" width="80"></t:dgCol>
			    </c:if>
			    <c:if test="${ hntbhzisShow.shi2_shijizhi==1}">
			    	<t:dgCol title="${hbfield.shi2_shijizhi}" field="shi2_shijizhi" width="80"></t:dgCol>
			  	</c:if>
			    <c:if test="${ hntbhzisShow.shi2_lilunzhi==1}">
			    	<t:dgCol title="${hbfield.shi2_lilunzhi}" field="shi2_lilunzhi" width="80"></t:dgCol>
			    </c:if>
			    <c:if test="${ hntbhzisShow.sha2_shijizhi==1}"> 
			    	<t:dgCol title="${hbfield.sha2_shijizhi}" field="sha2_shijizhi" width="80"></t:dgCol>
			    </c:if>	
			    <c:if test="${ hntbhzisShow.sha2_lilunzhi==1}">
			    	<t:dgCol title="${hbfield.sha2_lilunzhi}" field="sha2_lilunzhi" width="80"></t:dgCol>
			    </c:if>	
			    <c:if test="${hntbhzisShow.guliao5_shijizhi==1}">
			    	<t:dgCol title="${hbfield.guliao5_shijizhi}" field="guliao5_shijizhi" width="80"></t:dgCol>
			    </c:if>	
			    <c:if test="${ hntbhzisShow.guliao5_lilunzhi==1}">
			    	<t:dgCol title="${hbfield.guliao5_lilunzhi}" field="guliao5_lilunzhi" width="80"></t:dgCol>
				</c:if>				    	
			    <c:if test="${ hntbhzisShow.kuangfen3_shijizhi==1}">
			    	<t:dgCol title="${hbfield.kuangfen3_shijizhi}" field="kuangfen3_shijizhi" width="80"></t:dgCol>
			    </c:if>
			    <c:if test="${ hntbhzisShow.kuangfen3_lilunzhi==1}">
			    	<t:dgCol title="${hbfield.kuangfen3_lilunzhi}" field="kuangfen3_lilunzhi" width="80"></t:dgCol>
			    </c:if>
			    <c:if test="${hntbhzisShow.feimeihui4_shijizhi==1}">
			    	<t:dgCol title="${hbfield.feimeihui4_shijizhi}" field="feimeihui4_shijizhi" width="80"></t:dgCol>
			    </c:if>
			    <c:if test="${hntbhzisShow.feimeihui4_lilunzhi==1 }">
			    	<t:dgCol title="${hbfield.feimeihui4_lilunzhi}" field="feimeihui4_lilunzhi" width="80"></t:dgCol>
			    </c:if>
			    <c:if test="${hntbhzisShow.fenliao5_shijizhi==1}">
			    	<t:dgCol title="${hbfield.fenliao5_shijizhi}" field="fenliao5_shijizhi" width="80"></t:dgCol>
			    </c:if>			    	
			    <c:if test="${ hntbhzisShow.fenliao5_lilunzhi==1}">
			    	<t:dgCol title="${hbfield.fenliao5_lilunzhi}" field="fenliao5_lilunzhi" width="80"></t:dgCol>
			    </c:if>	
			    <c:if test="${ hntbhzisShow.fenliao6_shijizhi==1}">
			    	<t:dgCol title="${hbfield.fenliao6_shijizhi}" field="fenliao6_shijizhi" width="80"></t:dgCol>
			    </c:if>	
			    <c:if test="${ hntbhzisShow.fenliao6_lilunzhi==1}">
			    	<t:dgCol title="${hbfield.fenliao6_lilunzhi}" field="fenliao6_lilunzhi" width="80"></t:dgCol>
			    </c:if>			    	
			    <c:if test="${ hntbhzisShow.waijiaji1_shijizhi==1}">
			    	<t:dgCol title="${hbfield.waijiaji1_shijizhi}" field="waijiaji1_shijizhi" width="80"></t:dgCol>
			    </c:if>	
			    <c:if test="${ hntbhzisShow.waijiaji1_lilunzhi==1}">
			    	<t:dgCol title="${hbfield.waijiaji1_lilunzhi}" field="waijiaji1_lilunzhi" width="80"></t:dgCol>
			    </c:if>	
			    <c:if test="${ hntbhzisShow.waijiaji2_shijizhi==1}">
			    	<t:dgCol title="${hbfield.waijiaji2_shijizhi}" field="waijiaji2_shijizhi" width="80"></t:dgCol>
			    </c:if>				    
			    <c:if test="${ hntbhzisShow.waijiaji2_lilunzhi==1}">
			    	<t:dgCol title="${hbfield.waijiaji2_lilunzhi}" field="waijiaji2_lilunzhi" width="80"></t:dgCol>
			    </c:if>	
			    <c:if test="${ hntbhzisShow.waijiaji3_shijizhi==1}">
			    	<t:dgCol title="${hbfield.waijiaji3_shijizhi}" field="waijiaji3_shijizhi" width="80"></t:dgCol>			    	
			    </c:if>	
			    <c:if test="${ hntbhzisShow.waijiaji3_lilunzhi==1}">
			    	<t:dgCol title="${hbfield.waijiaji3_lilunzhi}" field="waijiaji3_lilunzhi" width="80"></t:dgCol>
			    </c:if>
			    <c:if test="${ hntbhzisShow.waijiaji4_shijizhi==1}">
			    	<t:dgCol title="${hbfield.waijiaji4_shijizhi}" field="waijiaji4_shijizhi" width="80"></t:dgCol>
			    </c:if>	
			    <c:if test="${ hntbhzisShow.waijiaji4_lilunzhi==1}">
			    	<t:dgCol title="${hbfield.waijiaji4_lilunzhi}" field="waijiaji4_lilunzhi" width="80"></t:dgCol>
			    </c:if>	
			    <c:if test="${ hntbhzisShow.shuinipingzhong==1}">
			    	<t:dgCol title="${hbfield.shuinipingzhong}" field="shuinipingzhong" width="80"></t:dgCol>
			    </c:if>	
			    <c:if test="${ hntbhzisShow.waijiajipingzhong==1}">
			    	<t:dgCol title="${hbfield.waijiajipingzhong}" field="waijiajipingzhong" width="80"></t:dgCol>
			    </c:if>
   		 	</c:if>  		    		
		</t:datagrid>	
		<!-- 加条件:update---Author:赵俊夫  Date:20130507 for：需要加name=searchColums属性 -->
		<div id="logListtb" style="padding: 3px; height: 50px">
			<div name="searchColums" style="float: left; padding-right: 15px;">
				<table>
					<tr>
						<td>
							<span>所属机构:</span>
								<input id="hnnnituDuibi_list"  value="${depart.TSPDepart.departname}" style="width: 160px;">
								<input id="hunnituDuibipdepartId" name="TSPDepart.id" style="display: none;" value="${depart.TSPDepart.id}">
							<span>拌和机名称:</span>
								<select id="hunnintuDuibishebeibianhao" name="shebeibianhao" style="height:24px;width:120px;"></select>				
							<span>工程名称：</span>
								<input id="gongchengmingcheng" name="gongchengmingcheng" type="text" style=" width: 80px; line-height:18px;border:1px solid #ccc">
							<span>浇筑部位：</span>
								<input id="jiaozuobuwei" name="jiaozuobuwei" type="text" style=" width: 80px; line-height:18px;border:1px solid #ccc">
							<span>出料时间:</span>
								<input id="startTime"  type="text" name="startTime" class="easyui-datetimebox" />
							<span>至:</span>
								<input id="endTime" type="text" name="endTime"  class="easyui-datetimebox"/>
							<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearchylcl();">查询</a>
						</td>
					</tr>
			</table>
		</div>
	</div>
</div>

<script type="text/javascript">

 	$(function() {
		$('#hnnnituDuibi_list').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
			onClick: function(node){
				$("#hunnituDuibipdepartId").val(node.id);
				banhezhanxinxiSelect(node.id,"hunnintuDuibishebeibianhao");
			}
		});
		banhezhanxinxiSelect("","hunnintuDuibishebeibianhao");
	});

 	var array=new Array();
 	
	function chulit(m,hh){
	 	if(hh.gongdanhao=='1'){
		 	array[0] =false;
	 	}else  if(hh.gongdanhao=='0'){
		 	array[0] =true;
	 	} 	 
	 	if(hh.gongchengmingcheng=='1'){
		 	array[1] =false;
	 	}else  if(hh.gongchengmingcheng=='0'){
		 	array[1] =true;
	 	} 	 
	 	if(hh.sigongdidian=='1'){
		 	array[2] =false;
	 	}else  if(hh.sigongdidian=='0'){
		 	array[2] =true;
	 	} 	 
	 	if(hh.jiaozuobuwei=='1'){
		 	array[3] =false;
	 	}else  if(hh.jiaozuobuwei=='0'){
		 	array[3] =true;
	 	} 	 
	 	if(hh.qiangdudengji=='1'){
			array[4] =false;
	 	}else  if(hh.qiangdudengji=='0'){
		 	array[4] =true;
	 	} 	 
	 	if(hh.gujifangshu=='1'){
		 	array[5] =false;
	 	}else  if(hh.gujifangshu=='0'){
		 	array[5] =true;
	 	} 	 
	 	if(hh.chuliaoshijian=='1'){
		 	array[6] =false;
	 	}else  if(hh.chuliaoshijian=='0'){
		 	array[6] =true;
	 	} 	 
	 	if(hh.baocunshijian=='1'){
		 	array[7] =false;
	 	}else  if(hh.baocunshijian=='0'){
		 	array[7] =true;
	 	} 	 
	 	if(hh.shui1_shijizhi=='1'){
		 	array[8] =false;
	 	}else  if(hh.shui1_shijizhi=='0'){
		 	array[8] =true;
	 	} 	 
	 	if(hh.shui1_lilunzhi=='1'){
		 	array[9] =false;
	 	}else  if(hh.shui1_lilunzhi=='0'){
		 	array[9] =true;
	 	} 	 
	 	if(hh.shui2_shijizhi=='1'){
		 	array[10] =false;
	 	}else  if(hh.shui2_shijizhi=='0'){
		 	array[10] =true;
	 	} 	 
	 	if(hh.shui2_lilunzhi=='1'){
		 	array[11] =false;
	 	}else  if(hh.shui2_lilunzhi=='0'){
		 	array[11] =true;
	 	} 	 
	 	if(hh.shuini1_shijizhi=='1'){
		 	array[12] =false;
	 	}else  if(hh.shuini1_shijizhi=='0'){
		 	array[12] =true;
	 	} 	 
	 	if(hh.shuini1_lilunzhi=='1'){
		 	array[13] =false;
	 	}else  if(hh.shuini1_lilunzhi=='0'){
		 	array[13] =true;
	 	} 	 
	 	if(hh.shuini2_shijizhi=='1'){
		 	array[14] =false;
	 	}else  if(hh.shuini2_shijizhi=='0'){
		 	array[14] =true;
	 	}  
	 	if(hh.shuini2_lilunzhi=='1'){
		 	array[15] =false;
	 	}else  if(hh.shuini2_lilunzhi=='0'){
		 	array[15] =true;
	 	} 	 
	 	if(hh.sha1_shijizhi=='1'){
			array[16] =false;
	 	}else  if(hh.sha1_shijizhi=='0'){
		 	array[16] =true;
	 	} 	 
	 	if(hh.sha1_lilunzhi=='1'){
		 	array[17] =false;
	 	}else  if(hh.sha1_lilunzhi=='0'){
		 	array[17] =true;
		} 
	 	if(hh.shi1_shijizhi=='1'){
		 	array[18] =false;
	 	}else  if(hh.shi1_shijizhi=='0'){
		 	array[18] =true;
	 	} 	 
	 	if(hh.shi1_lilunzhi=='1'){
		 	array[19] =false;
	 	}else  if(hh.shi1_lilunzhi=='0'){
		 	array[19] =true;
	 	} 	 
	 	if(hh.shi2_shijizhi=='1'){
		 	array[20] =false;
	 	}else  if(hh.shi2_shijizhi=='0'){
		 	array[20] =true;
	 	} 	 
	 	if(hh.shi2_lilunzhi=='1'){
		 	array[21] =false;
	 	}else  if(hh.shi2_lilunzhi=='0'){
		 	array[21] =true;
	 	} 	 
	 	if(hh.sha2_shijizhi=='1'){
		 	array[22] =false;
	 	}else  if(hh.sha2_shijizhi=='0'){
		 	array[22] =true;
	 	} 	 
	 	if(hh.sha2_lilunzhi=='1'){
		 	array[23] =false;
	 	}else  if(hh.sha2_lilunzhi=='0'){
		 	array[23] =true;
	 	}  
	 	if(hh.guliao5_shijizhi=='1'){
		 	array[24] =false;
	 	}else  if(hh.guliao5_shijizhi=='0'){
		 	array[24] =true;
	 	} 
	 	if(hh.guliao5_lilunzhi=='1'){
		 	array[25] =false;
	 	}else  if(hh.guliao5_lilunzhi=='0'){
		 	array[25] =true;
	 	} 	 
	 	if(hh.kuangfen3_shijizhi=='1'){
		 	array[26] =false;
	 	}else  if(hh.kuangfen3_shijizhi=='0'){
		 	array[26] =true;
	 	} 	 
	 	if(hh.kuangfen3_lilunzhi=='1'){
		 	array[27] =false;
	 	}else  if(hh.kuangfen3_lilunzhi=='0'){
		 	array[27] =true;
	 	}  
	 	if(hh.feimeihui4_shijizhi=='1'){
		 	array[28] =false;
	 	}else  if(hh.feimeihui4_shijizhi=='0'){
		 	array[28] =true;
	 	} 
	 	if(hh.feimeihui4_lilunzhi=='1'){
		 	array[29] =false;
	 	}else  if(hh.feimeihui4_lilunzhi=='0'){
		 	array[29] =true;
	 	}  
	 	if(hh.fenliao5_shijizhi=='1'){
		 	array[30] =false;
	 	}else  if(hh.fenliao5_shijizhi=='0'){
		 	array[30] =true;
	 	} 	 
	 	if(hh.fenliao5_lilunzhi=='1'){
		 	array[31] =false;
	 	}else  if(hh.fenliao5_lilunzhi=='0'){
		 	array[31] =true;
	 	} 	 
	 	if(hh.fenliao6_shijizhi=='1'){
		 	array[32] =false;
	 	}else  if(hh.fenliao6_shijizhi=='0'){
		 	array[32] =true;
	 	} 	 
	 	if(hh.fenliao6_lilunzhi=='1'){
		 	array[33] =false;
	 	}else  if(hh.fenliao6_lilunzhi=='0'){
		 	array[33] =true;
	 	} 	 
	 	if(hh.waijiaji1_shijizhi=='1'){
		 	array[34] =false;
	 	}else  if(hh.waijiaji1_shijizhi=='0'){
		 	array[34] =true;
	 	}  
	 	if(hh.waijiaji1_lilunzhi=='1'){
		 	array[35] =false;
	 	}else  if(hh.waijiaji1_lilunzhi=='0'){
		 	array[35] =true;
	 	}  
	 	if(hh.waijiaji2_shijizhi=='1'){
		 	array[36] =false;
	 	}else  if(hh.waijiaji2_shijizhi=='0'){
		 	array[36] =true;
	 	} 	 
	 	if(hh.waijiaji2_lilunzhi=='1'){
		 	array[37] =false;
	 	}else  if(hh.waijiaji2_lilunzhi=='0'){
		 	array[37] =true;
	 	} 	 
	 	if(hh.waijiaji3_shijizhi=='1'){
		 	array[38] =false;
	 	}else  if(hh.waijiaji3_shijizhi=='0'){
		 	array[38] =true;
	 	} 	 
	 	if(hh.waijiaji3_lilunzhi=='1'){
		 	array[39] =false;
	 	}else  if(hh.waijiaji3_lilunzhi=='0'){
		 	array[39] =true;
	 	} 	 
	 	if(hh.waijiaji4_shijizhi=='1'){
		 	array[40] =false;
	 	}else  if(hh.waijiaji4_shijizhi=='0'){
		 	array[40] =true;
	 	} 	 
	 	if(hh.waijiaji4_lilunzhi=='1'){
		 	array[41] =false;
	 	}else  if(hh.waijiaji4_lilunzhi=='0'){
		 	array[41] =true;
		} 	 
	 	if(hh.shuinipingzhong=='1'){
		 	array[42] =false;
	 	}else  if(hh.shuinipingzhong=='0'){
		 	array[42] =true;
	 	} 	 
	 	if(hh.waijiajipingzhong=='1'){
		 	array[43] =false;
	 	}else  if(hh.waijiajipingzhong=='0'){
		 	array[43] =true;
	 	} 
	 
	 	$("#hunnintuDuibi").datagrid({
			url : 'contrastController.do?datagrid',
			title : '拌和机对比查询',
			method : 'get',
			pagination : true,
			pageSize : 5,
			pageList : [ 10, 20, 30, 40 ],
			queryParams: {
				gongchengmingcheng : $('#gongchengmingcheng').val(),
				jiaozuobuwei : $('#jiaozuobuwei').val(),
				startTime : $("input[name='startTime']").val(),
				endTime : $("input[name='endTime']").val(),
				pid : $("#hunnintuylcxlisttspdepartId").val(),
				shebeibianhao:$("#hunnintuylcxlistshebeibianhao").val()
			},
			fit : false,
			fitColumns : false,
			nowarp : false,
			border : false,
			idField : 'chuliaoshijian',
			columns : [[ {
				title :'详细',
				field :'id',
				width : 80,
				formatter:operate
			},{
				title :'拌和机名称',
				field :'banhezhanminchen',
				width : 80,
			},{
				title :m.gongdanhao,
				field :'gongdanhao',
				width : 80,
				hidden:array[0]
			},{
				title :m.gongchengmingcheng,
				field :'gongchengmingcheng',
				width : 80,
				hidden:array[1]
			},{
				title :m.sigongdidian,
				field :'sigongdidian',
				width : 80,
				hidden:array[2]
			},{
				title :m.jiaozuobuwei,
				field :'jiaozuobuwei',
				width : 80,
				hidden:array[3]
			},{
				title :m.qiangdudengji,
				field :'qiangdudengji',
				width : 80,
				hidden:array[4]
			},{
				title :m.gujifangshu,
				field :'gujifangshu',
				width : 80,
				hidden:array[5]
			},{
				title :m.chuliaoshijian,
				field :'chuliaoshijian',
				width : 80,
				hidden:array[6]
			},{
				title :m.baocunshijian,
				field :'baocunshijian',
				width : 80,
				hidden:array[7]
			},{
				title :m.shui1_shijizhi,
				field :'shui1_shijizhi',
				width : 80,
				hidden:array[8]
			},{
				title :m.shui1_lilunzhi,
				field :'shui1_lilunzhi',
				width : 80,
				hidden:array[9]
			},{
				title :m.shui2_shijizhi,
				field :'shui2_shijizhi',
				width : 80,
				hidden:array[10]
			},{
				title :m.shui2_lilunzhi,
				field :'shui2_lilunzhi',
				width : 80,
				hidden:array[11]
			},{
				title :m.shuini1_shijizhi,
				field :'shuini1_shijizhi',
				width : 80,
				hidden:array[12]
			},{
				title :m.shuini1_lilunzhi,
				field :'shuini1_lilunzhi',
				width : 80,
				hidden:array[13]
			},{
				title :m.shuini2_shijizhi,
				field :'shuini2_shijizhi',
				width : 80,
				hidden:array[14]
			},{
				title :m.shuini2_lilunzhi,
				field :'shuini2_lilunzhi',
				width : 80,
				hidden:array[15]
			},{
				title :m.sha1_shijizhi,
				field :'sha1_shijizhi',
				width : 80,
				hidden:array[16]
			},{
				title :m.sha1_lilunzhi,
				field :'sha1_lilunzhi',
				width : 80,
				hidden:array[17]
			},{
				title :m.shi1_shijizhi,
				field :'shi1_shijizhi',
				width : 80,
				hidden:array[18]
			},{
				title :m.shi1_lilunzhi,
				field :'shi1_lilunzhi',
				width : 80,
				hidden:array[19]
			},{
				title :m.shi2_shijizhi,
				field :'shi2_shijizhi',
				width : 80,
				hidden:array[20]
			},{
				title :m.shi2_lilunzhi,
				field :'shi2_lilunzhi',
				width : 80,
				hidden:array[21]
			},{
				title :m.sha2_shijizhi,
				field :'sha2_shijizhi',
				width : 80,
				hidden:array[22]
			},{
				title :m.sha2_lilunzhi,
				field :'sha2_lilunzhi',
				width : 80,
				hidden:array[23]
			},{
				title :m.guliao5_shijizhi,
				field :'guliao5_shijizhi',
				width : 80,
				hidden:array[24]
			},{
				title :m.guliao5_lilunzhi,
				field :'guliao5_lilunzhi',
				width : 80,
				hidden:array[25]
			},{
				title :m.kuangfen3_shijizhi,
				field :'kuangfen3_shijizhi',
				width : 80,
				hidden:array[26]
			},{
				title :m.kuangfen3_lilunzhi,
				field :'kuangfen3_lilunzhi',
				width : 80,
				hidden:array[27]
			},{
				title :m.feimeihui4_shijizhi,
				field :'feimeihui4_shijizhi',
				width : 80,
				hidden:array[28]
			},{
				title :m.feimeihui4_lilunzhi,
				field :'feimeihui4_lilunzhi',
				width : 80,
				hidden:array[29]
			},{
				title :m.fenliao5_shijizhi,
				field :'fenliao5_shijizhi',
				width : 80,
				hidden:array[30]
			},{
				title :m.fenliao5_lilunzhi,
				field :'fenliao5_lilunzhi',
				width : 80,
				hidden:array[31]
			},{
				title :m.fenliao6_shijizhi,
				field :'fenliao6_shijizhi',
				width : 80,
				hidden:array[32]
			},{
				title :m.fenliao6_lilunzhi,
				field :'fenliao6_lilunzhi',
				width : 80,
				hidden:array[33]
			},{
				title :m.waijiaji1_shijizhi,
				field :'waijiaji1_shijizhi',
				width : 80,
				hidden:array[34]
			},{
				title :m.waijiaji1_lilunzhi,
				field :'waijiaji1_lilunzhi',
				width : 80,
				hidden:array[35]
			},{
				title :m.waijiaji2_shijizhi,
				field :'waijiaji2_shijizhi',
				width : 80,
				hidden:array[36]
			},{
				title :m.waijiaji2_lilunzhi,
				field :'waijiaji2_lilunzhi',
				width : 80,
				hidden:array[37]
			},{
				title :m.waijiaji3_shijizhi,
				field :'waijiaji3_shijizhi',
				width : 80,
				hidden:array[38]
			},{
				title :m.waijiaji3_lilunzhi,
				field :'waijiaji3_lilunzhi',
				width : 80,
				hidden:array[39]
			},{
				title :m.waijiaji4_shijizhi,
				field :'waijiaji4_shijizhi',
				width : 80,
				hidden:array[40]
			},{
				title :m.waijiaji4_lilunzhi,
				field :'waijiaji4_lilunzhi',
				width : 80,
				hidden:array[41]
			},{
				title :m.shuinipingzhong,
				field :'shuinipingzhong',
				width : 80,
				hidden:array[42]
			},{
				title :m.waijiajipingzhong,
				field :'waijiajipingzhong',
				width : 80,
				hidden:array[43]
			}]] ,
		});
	}
 	
 	function doSearchylcl() {
	 	$.ajax({
	     	type: "GET",
	     	url: "HunnintuylcxController.do?getFiled",
	     	data: {shebeibianhao:$("#hunnintuylcxlistshebeibianhao").val()},
	     	dataType: "json",
	     	success: function(data){
	 			chulit(data.hbfield,data.hntbhzisShow);   
	        }
	 	});
	}
	
	//查看
	 function chakanxxyl(id) {
		 createdetailwindow("对比详情查看","contrastController.do?addorupdate&id="+id,"1100px","500px");
	 } 	
	
	 function operate(value, row, index) {
        return '<a href="#" onclick="chakanxxyl('+value+')">查看</a>';
    }
</script>
