<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/context/mytags.jsp"%>

<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="hunnintuwuchaViewList" title="水泥混凝土误差查询" actionUrl="hntwuchaViewController.do?datagrid" idField="id" fit="true"  extendParams="" >
  
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="设备编号" field="shebeibianhao"  hidden="false"></t:dgCol>
   <t:dgCol title="拌和站名称" field="banhezhanminchen" ></t:dgCol>
   <t:dgCol title="工程名称" field="gongchengmingcheng" ></t:dgCol>
   <t:dgCol title="出料时间" field="chuliaoshijian" ></t:dgCol>
   <c:if test="${isshowtest.sha1_shijizhi==1 }">
   		<t:dgCol title="${fieldtest.sha1_shijizhi }" field="sha1Shijizhi" ></t:dgCol>
   </c:if>
   <c:if test="${isshowtest.sha2_shijizhi==1 }">
   		<t:dgCol title="${fieldtest.sha2_shijizhi }" field="sha2Shijizhi" ></t:dgCol>
   	</c:if>
   <c:if test="${isshowtest.shi1_shijizhi==1 }">
   		<t:dgCol title="${fieldtest.shi1_shijizhi }" field="shi1Shijizhi" ></t:dgCol>
    </c:if>
   <c:if test="${isshowtest.shi2_shijizhi==1 }">
   		<t:dgCol title="${fieldtest.shi2_shijizhi }" field="shi2Shijizhi" ></t:dgCol>
    </c:if>
   <c:if test="${isshowtest.guliao5_shijizhi==1 }">
   		<t:dgCol title="${fieldtest.guliao5_shijizhi }" field="guliao5Shijizhi" ></t:dgCol>
    </c:if>
   <c:if test="${isshowtest.shuini1_shijizhi==1 }">
   		<t:dgCol title="${fieldtest.shuini1_shijizhi }" field="shuini1Shijizhi" ></t:dgCol>
    </c:if>
   <c:if test="${isshowtest.shuini2_shijizhi==1 }">
   		<t:dgCol title="${fieldtest.shuini2_shijizhi }" field="shuini2Shijizhi" ></t:dgCol>
    </c:if>
   <c:if test="${isshowtest.kuangfen3_shijizhi==1 }">
   		<t:dgCol title="${fieldtest.kuangfen3_shijizhi }" field="kuangfen3Shijizhi" ></t:dgCol>
    </c:if>
   <c:if test="${isshowtest.feimeihui4_shijizhi==1 }">
   		<t:dgCol title="${fieldtest.feimeihui4_shijizhi }" field="feimeihui4Shijizhi" ></t:dgCol>
    </c:if>
   <c:if test="${isshowtest.fenliao5_shijizhi==1 }">
   		<t:dgCol title="${fieldtest.fenliao5_shijizhi }" field="fenliao5Shijizhi" ></t:dgCol>
    </c:if>
   <c:if test="${isshowtest.fenliao6_shijizhi==1 }">
   		<t:dgCol title="${fieldtest.fenliao6_shijizhi }" field="fenliao6Shijizhi" ></t:dgCol>
    </c:if>
   <c:if test="${isshowtest.shui1_shijizhi==1 }">
   		<t:dgCol title="${fieldtest.shui1_shijizhi }" field="shui1Shijizhi" ></t:dgCol>
    </c:if>
   <c:if test="${isshowtest.shui2_shijizhi==1 }">
  		 <t:dgCol title="${fieldtest.shui2_shijizhi }" field="shui2Shijizhi" ></t:dgCol>
    </c:if>
   <c:if test="${isshowtest.waijiaji1_shijizhi==1 }">
   		<t:dgCol title="${fieldtest.waijiaji1_shijizhi }" field="waijiaji1Shijizhi" ></t:dgCol>
    </c:if>
   <c:if test="${isshowtest.waijiaji2_shijizhi==1 }">
  		 <t:dgCol title="${fieldtest.waijiaji2_shijizhi }" field="waijiaji2Shijizhi" ></t:dgCol>
    </c:if>
   <c:if test="${isshowtest.waijiaji3_shijizhi==1 }">
  		 <t:dgCol title="${fieldtest.waijiaji3_shijizhi }" field="waijiaji3Shijizhi" ></t:dgCol>
    </c:if>
   <c:if test="${isshowtest.waijiaji4_shijizhi==1 }">
 	 	 <t:dgCol title="${fieldtest.waijiaji4_shijizhi }" field="waijiaji4Shijizhi" ></t:dgCol>
    </c:if>

	


   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgFunOpt funname="operationDetailLook(id)" title="误差比对查看"></t:dgFunOpt>
   <t:dgFunOpt funname="operationDetailLook1(id)" title="查看详情"></t:dgFunOpt>
  </t:datagrid>
 
 
   <div id="logListtb" style="padding: 3px; height: 50px"><!-- update---Author:赵俊夫  Date:20130507 for：需要加name=searchColums属性 -->
<div name="searchColums" style="  padding-right: 1px;">
<table>
	<tr  >
		<td >所属机构</td>
		<td ><input id="cc_wccx"  value="${depart.TSPDepart.departname}" style="height:24px;width:180px;">
			<div><input id="tspdepartId" name="departid" style="display: none;" value="${depart.TSPDepart.id}"></div>
			
		</td>
		<td><select id="hntwuchalistshebeibianhao" name="shebeibianhao" style="height:24px;width:180px;"></select></td>
		<td >出料时间:</td>
		<td>
		<input id="startTime" type="text" name="startTime"  class="easyui-datetimebox"  />
		</td>
		<td>
		<input id="endTime" type="text" name="endTime"  class="easyui-datetimebox"  />
		</td>
   		<td>工程名称:</td>
   		<td><input name="gongchengmingcheng" id="gongchengmingcheng" /></td>
		<td  ><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="hunnintuwuchaViewList();" >查询</a></td>
	</tr>
<!-- 	<tr> -->
<!-- 		<td colspan="8"> -->
<%-- 			<c:forEach var="wclist" items="${wclist}" > --%>
<%-- 				<input  type="checkbox"   value="${wclist.id}" name="wclist[]" <c:if test="${wclist.id==wcselect[wclist.id-1]}">checked="checked"</c:if> />${wclist.name}  --%>
<%-- 			</c:forEach> --%>
<!-- 		</td> -->
<!-- 	</tr> -->
</table>
</div>
 
 <script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
 <script type="text/javascript">
 $(function() {
	 $('#cc_wccx').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
			onClick: function(node){
				$("#tspdepartId").val(node.id);
				banhezhanxinxiSelect(node.id,"hntwuchalistshebeibianhao");
			}
		});
		banhezhanxinxiSelect("","hntwuchalistshebeibianhao");
	});
 
 function hunnintuwuchaViewList() {
		//alert($("input[name='identity']:checked").val());
		$('#hunnintuwuchaViewList').datagrid('load', {
			gongchengmingcheng : $('#gongchengmingcheng').val(),
			startTime : $("input[name='startTime']").val(),
			endTime : $("input[name='endTime']").val(),
			pid : $("#tspdepartId").val(),
			shebeibianhao: $("#hntwuchalistshebeibianhao").val()
		});
		var categories = $('input[name="wclist[]"]:checked').map(function() {  
            return $(this).val();  
         }).get();  
		/* var categories = $('input[name="wclist[]"]:checked').map(function() {  
            return $(this).val();  
         }).get();  
		alert(categories); 
		$.ajax({
			type : "POST",
			url : "hntwuchaViewController.do?hntwuchaView",
			data:{
				gongchengmingcheng : $('#gongchengmingcheng').val(),
				startTime : $("input[name='startTime']").val(),
				endTime : $("input[name='endTime']").val(),
				pid : $("#tspdepartId").val(),
				shebeibianhao: $("#hntwuchalistshebeibianhao").val(),
				wuchalist:
			}
		}); */
		
	}
	
	
	function hunnintuwuchaViewListtest() {
		var games = document.getElementsByName('wclist[]');  
		var flag = true;  
		for(i=0; i<games.length; i++) {  
		    if(games[i].checked) {  
		        flag = false;  
		        break;  
		    }  
		}  
		if(flag) {  
		    alert('请勾选您要开通的服务');  
		    return false;  
		}  
		
		alert(games.toString());
		$.ajax({
			type : "POST",
			url : "hntwuchaViewController.do?hntwuchaView",
			data : {
				gongchengmingcheng : $('#gongchengmingcheng').val(),
				startTime : $("input[name='startTime']").val(),
				endTime : $("input[name='endTime']").val(),
				pid : $("#tspdepartId").val(),
				wuchaselect : games.toString()
			}
			});
		
	};
 
 
 //查看处理
 function operationDetailLook(id) {
	// alert(jieguoid+"--"+jieguoid+"--"+gprsbianhao);
	createdetailwindow("查看","hntwuchaViewController.do?datagrid1&id="+id,"1200px","200px");
 }
 
 //查看处理
 function operationDetailLook1(id) {
	// alert(jieguoid+"--"+jieguoid+"--"+gprsbianhao);
	createdetailwindow("查看","hntwuchaViewController.do?addorupdate&id="+id,"500px","350px");
 }
 
 </script>
  
  </div>
 </div>