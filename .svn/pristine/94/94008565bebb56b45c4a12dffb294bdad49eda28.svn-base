<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addSYclGuigexinghaosBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delSYclGuigexinghaosBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addSYclGuigexinghaosBtn').bind('click', function(){   
 		 var tr =  $("#add_sYclGuigexinghaos_table_template tr").clone();
	 	 $("#add_sYclGuigexinghaos_table").append(tr);
	 	 resetTrNum('add_sYclGuigexinghaos_table');
    });  
	$('#delSYclGuigexinghaosBtn').bind('click', function(){   
      	$("#add_sYclGuigexinghaos_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_sYclGuigexinghaos_table'); 
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
			$(":input").each(function(){
				var $thisThing = $(this);
				$thisThing.attr("title",$thisThing.val());
			});
		}
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addSYclGuigexinghaosBtn" href="#">添加</a> <a id="delSYclGuigexinghaosBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:scroll;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="sYclGuigexinghaos_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								子表型号
							</label></td>
				 <!--  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								主表规格
							</label></td> -->
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								规格描述
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								型号描述
							</label></td>
	</tr>
	<tbody id="add_sYclGuigexinghaos_table">	
	<c:if test="${fn:length(sYclGuigexinghaosList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="sYclGuigexinghaosList[0].id" type="hidden"/>
				  <td align="left">
					  	<input name="sYclGuigexinghaosList[0].mselectkey" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">子表型号</label>
					</td>
				  <!-- <td align="left">
					  	<input name="sYclGuigexinghaosList[0].selectkey" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">主表规格</label>
					</td> -->
				  <td align="left">
					  	<input name="sYclGuigexinghaosList[0].selectvalue" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">规格描述</label>
					</td>
				  <td align="left">
					  	<input name="sYclGuigexinghaosList[0].remark" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">型号描述</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(sYclGuigexinghaosList)  > 0 }">
		<c:forEach items="${sYclGuigexinghaosList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="sYclGuigexinghaosList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
				   <td align="left">
					  	<input name="sYclGuigexinghaosList[${stuts.index }].mselectkey" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.mselectkey }">
					  <label class="Validform_label" style="display: none;">子表型号</label>
				   </td>
				 <%--   <td align="left">
					  	<input name="sYclGuigexinghaosList[${stuts.index }].selectkey" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.selectkey }">
					  <label class="Validform_label" style="display: none;">主表规格</label>
				   </td> --%>
				   <td align="left">
					  	<input name="sYclGuigexinghaosList[${stuts.index }].selectvalue" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.selectvalue }">
					  <label class="Validform_label" style="display: none;">规格描述</label>
				   </td>
				   <td align="left">
					  	<input name="sYclGuigexinghaosList[${stuts.index }].remark" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.remark }">
					  <label class="Validform_label" style="display: none;">型号描述</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>