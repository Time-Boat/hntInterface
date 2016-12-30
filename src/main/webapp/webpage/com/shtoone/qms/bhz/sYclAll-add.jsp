<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>原材料进场登记信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  
  $(function() {
		$('#cc').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}',
			onClick: function(node){
				$("#tspdepartId").val(node.id);
			}
		});
	});
  
  
  $(function() {
		$('#ss').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}',
			onClick: function(node){
				$("#fmhtspdepartId").val(node.id);
			}
		});
	});
  
  
  $(function() {
		$('#aa').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}',
			onClick: function(node){
				$("#kftspdepartId").val(node.id);
			}
		});
	});
  
  $(function() {
		$('#bb').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}',
			onClick: function(node){
				$("#cjltspdepartId").val(node.id);
			}
		});
	});
  
  
  $(function() {
		$('#dd').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}',
			onClick: function(node){
				$("#xjltspdepartId").val(node.id);
			}
		});
	});
  
  $(function() {
		$('#ee').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}',
			onClick: function(node){
				$("#stspdepartId").val(node.id);
			}
		});
	});
  
  $(function() {
		$('#ff').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}',
			onClick: function(node){
				$("#wjjtspdepartId").val(node.id);
			}
		});
	});
  
  $(function() {
		$('#hh').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}',
			onClick: function(node){
				$("#qttspdepartId").val(node.id);
			}
		});
	});
  
  function qh(name,selectid){
		 $.ajax({
				url:"sYclGuigexinghaomController.do?xinghaolist",
				type:'post',
				dataType:"json",
				data:{
					name:name 
				},
				success:function(data){
					$('#'+selectid).html("");
					var jsonStr='<option title="-1" selected="selected" value="">--请选择型号--</option>';
					$.each(data.list,function(i,item){
						jsonStr+='<option value="'+item.mselectkey+'">'+item.mselectkey+'</option>'
					});
					$('#'+selectid).append(jsonStr);
				}
			});
		 
	 }
  
  //编写自定义JS代码
  //原材料进行操作
function changetype(obj){
	if(obj=="0"){
		document.getElementById("shuini").style.display="none";
		document.getElementById("fenmeihui").style.display="none";
		document.getElementById("kuangfen").style.display="none";
		document.getElementById("cunjiliao").style.display="none";
		document.getElementById("xijiliao").style.display="none";
		document.getElementById("shui").style.display="none";
		document.getElementById("waijiaji").style.display="none";
		document.getElementById("qita").style.display="none";
	}
	if(obj=="水泥"){
		document.getElementById("shuini").style.display="block";
		document.getElementById("fenmeihui").style.display="none";
		document.getElementById("kuangfen").style.display="none";
		document.getElementById("cunjiliao").style.display="none";
		document.getElementById("xijiliao").style.display="none";
		document.getElementById("shui").style.display="none";
		document.getElementById("waijiaji").style.display="none";
		document.getElementById("qita").style.display="none";
	}
	if(obj=="粉煤灰"){
		document.getElementById("shuini").style.display="none";
		document.getElementById("fenmeihui").style.display="block";
		document.getElementById("kuangfen").style.display="none";
		document.getElementById("cunjiliao").style.display="none";
		document.getElementById("xijiliao").style.display="none";
		document.getElementById("shui").style.display="none";
		document.getElementById("waijiaji").style.display="none";
		document.getElementById("qita").style.display="none";
	}
	if(obj=="矿粉"){
		document.getElementById("shuini").style.display="none";
		document.getElementById("fenmeihui").style.display="none";
		document.getElementById("kuangfen").style.display="block";
		document.getElementById("cunjiliao").style.display="none";
		document.getElementById("xijiliao").style.display="none";
		document.getElementById("shui").style.display="none";
		document.getElementById("waijiaji").style.display="none";
		document.getElementById("qita").style.display="none";
	}
	if(obj=="粗骨料"){
		document.getElementById("shuini").style.display="none";
		document.getElementById("fenmeihui").style.display="none";
		document.getElementById("kuangfen").style.display="none";
		document.getElementById("cunjiliao").style.display="block";
		document.getElementById("xijiliao").style.display="none";
		document.getElementById("shui").style.display="none";
		document.getElementById("waijiaji").style.display="none";
		document.getElementById("qita").style.display="none";
	}
	if(obj=="细骨料"){
		document.getElementById("shuini").style.display="none";
		document.getElementById("fenmeihui").style.display="none";
		document.getElementById("kuangfen").style.display="none";
		document.getElementById("cunjiliao").style.display="none";
		document.getElementById("xijiliao").style.display="block";
		document.getElementById("shui").style.display="none";
		document.getElementById("waijiaji").style.display="none";
		document.getElementById("qita").style.display="none";
	}
	if(obj=="水"){
		document.getElementById("shuini").style.display="none";
		document.getElementById("fenmeihui").style.display="none";
		document.getElementById("kuangfen").style.display="none";
		document.getElementById("cunjiliao").style.display="none";
		document.getElementById("xijiliao").style.display="none";
		document.getElementById("shui").style.display="block";
		document.getElementById("waijiaji").style.display="none";
		document.getElementById("qita").style.display="none";
	}
	if(obj=="外加剂"){
		document.getElementById("shuini").style.display="none";
		document.getElementById("fenmeihui").style.display="none";
		document.getElementById("kuangfen").style.display="none";
		document.getElementById("cunjiliao").style.display="none";
		document.getElementById("xijiliao").style.display="none";
		document.getElementById("shui").style.display="none";
		document.getElementById("waijiaji").style.display="block";
		document.getElementById("qita").style.display="none";
	}
	if(obj=="其他"){
		document.getElementById("shuini").style.display="none";
		document.getElementById("fenmeihui").style.display="none";
		document.getElementById("kuangfen").style.display="none";
		document.getElementById("cunjiliao").style.display="none";
		document.getElementById("xijiliao").style.display="none";
		document.getElementById("shui").style.display="none";
		document.getElementById("waijiaji").style.display="none";
		document.getElementById("qita").style.display="block";
	}
	if(obj!="0" && obj!="水泥" && obj!="粉煤灰" && obj!="矿粉" && obj!="粗骨料" && obj!="细骨料" && obj!="水" && obj!="外加剂" && obj!="其他"){
		document.getElementById("shuini").style.display="block";
		document.getElementById("fenmeihui").style.display="none";
		document.getElementById("kuangfen").style.display="none";
		document.getElementById("cunjiliao").style.display="none";
		document.getElementById("xijiliao").style.display="none";
		document.getElementById("shui").style.display="none";
		document.getElementById("waijiaji").style.display="none";
		document.getElementById("qita").style.display="none";
	}
	if(obj!=null && obj!=""){
		loadDaihaobytype(parseInt(obj)+1);
	}
}
  
  function changecailiaoValid(){
	var leixing=$("#leixing").val();
	if(leixing=="" || leixing==null){
		alert("请选择一种材料");
		return false;
	}else{
		if(leixing=="0"){ 
			alert("请选择一种材料");
			return false;
		}else if(leixing=="水泥"){
			var cunchudidian=document.getElementById("shuinicunchudidian").value;
			var bgbianhao=document.getElementById("shuinibgbianhao").value;
			var pici=document.getElementById("shuinibgbianhao").value;
			if(pici==null||pici==""||bgbianhao==null||bgbianhao==""||cunchudidian==null||cunchudidian==""){
				var nullzhi="";
				if(pici==null||pici==""){
					nullzhi+="批次,";
				}
				if(bgbianhao==null||bgbianhao==""){
					nullzhi+="检测报告编号,";
				}
				if(cunchudidian==null||cunchudidian==""){
					nullzhi+="存储地点";
				}
				alert(nullzhi+"不能为空");
				return false;
			}else{
				return true;
			}
		}else if(leixing=="粉煤灰"){
			var cunchudidian=document.getElementById("fenmeihuicunchudidian").value;
			var bgbianhao=document.getElementById("fenmeihuibgbianhao").value;
			var pici=document.getElementById("fenmeihuibgbianhao").value;
			if(pici==null||pici==""||bgbianhao==null||bgbianhao==""||cunchudidian==null||cunchudidian==""){
				var nullzhi="";
				if(pici==null||pici==""){
					nullzhi+="批次,";
				}
				if(bgbianhao==null||bgbianhao==""){
					nullzhi+="检测报告编号,";
				}
				if(cunchudidian==null||cunchudidian==""){
					nullzhi+="存储地点";
				}
				alert(nullzhi+"不能为空");
				return false;
			}else{
				return true;
			}
		}else if(leixing=="矿粉"){
			var cunchudidian=document.getElementById("kuangfencunchudidian").value;
			var bgbianhao=document.getElementById("kuangfenbgbianhao").value;
			var pici=document.getElementById("kuangfenbgbianhao").value;
			if(pici==null||pici==""||bgbianhao==null||bgbianhao==""||cunchudidian==null||cunchudidian==""){
				var nullzhi="";
				if(pici==null||pici==""){
					nullzhi+="批次,";
				}
				if(bgbianhao==null||bgbianhao==""){
					nullzhi+="检测报告编号,";
				}
				if(cunchudidian==null||cunchudidian==""){
					nullzhi+="存储地点";
				}
				alert(nullzhi+"不能为空");
				return false;
			}else{
				return true;
			}
		}else if(leixing=="粗骨料"){
			var cunchudidian=document.getElementById("cunjiliaocunchudidian").value;
			var bgbianhao=document.getElementById("cunjiliaobgbianhao").value;
			var pici=document.getElementById("cunjiliaobgbianhao").value;
			if(pici==null||pici==""||bgbianhao==null||bgbianhao==""||cunchudidian==null||cunchudidian==""){
				var nullzhi="";
				if(pici==null||pici==""){
					nullzhi+="批次,";
				}
				if(bgbianhao==null||bgbianhao==""){
					nullzhi+="检测报告编号,";
				}
				if(cunchudidian==null||cunchudidian==""){
					nullzhi+="存储地点";
				}
				alert(nullzhi+"不能为空");
				return false;
			}else{
				return true;
			}
		}else if(leixing=="细骨料"){
			var cunchudidian=document.getElementById("xijiliaocunchudidian").value;
			var bgbianhao=document.getElementById("xijiliaobgbianhao").value;
			var pici=document.getElementById("xijiliaobgbianhao").value;
			if(pici==null||pici==""||bgbianhao==null||bgbianhao==""||cunchudidian==null||cunchudidian==""){
				var nullzhi="";
				if(pici==null||pici==""){
					nullzhi+="批次,";
				}
				if(bgbianhao==null||bgbianhao==""){
					nullzhi+="检测报告编号,";
				}
				if(cunchudidian==null||cunchudidian==""){
					nullzhi+="存储地点";
				}
				alert(nullzhi+"不能为空");
				return false;
			}else{
				return true;
			}
		}else if(leixing=="水"){
			var cunchudidian=document.getElementById("shuicunchudidian").value;
			var bgbianhao=document.getElementById("shuibgbianhao").value;
			var pici=document.getElementById("shuibgbianhao").value;
			if(pici==null||pici==""||bgbianhao==null||bgbianhao==""||cunchudidian==null||cunchudidian==""){
				var nullzhi="";
				if(pici==null||pici==""){
					nullzhi+="批次,";
				}
				if(bgbianhao==null||bgbianhao==""){
					nullzhi+="检测报告编号,";
				}
				if(cunchudidian==null||cunchudidian==""){
					nullzhi+="存储地点";
				}
				alert(nullzhi+"不能为空");
				return false;
			}else{
				return true;
			}
		}else if(leixing=="外加剂"){
			var cunchudidian=document.getElementById("waijiajicunchudidian").value;
			var bgbianhao=document.getElementById("waijiajibgbianhao").value;
			var pici=document.getElementById("waijiajibgbianhao").value;
			if(pici==null||pici==""||bgbianhao==null||bgbianhao==""||cunchudidian==null||cunchudidian==""){
				var nullzhi="";
				if(pici==null||pici==""){
					nullzhi+="批次,";
				}
				if(bgbianhao==null||bgbianhao==""){
					nullzhi+="检测报告编号,";
				}
				if(cunchudidian==null||cunchudidian==""){
					nullzhi+="存储地点";
				}
				alert(nullzhi+"不能为空");
				return false;
			}else{
				return true;
			}
		}
		
	}
}  
  
  
  function test(){
	  if(changecailiaoValid()){
		  return true;
	  }else{
		  return false;
	  }
  }
  
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="sYclAllController.do?doAdd" tiptype="1" beforeSubmit="test()">
			<input id="id" name="id" type="hidden" value="${sYclAllPage.id }">
					
			<input name="id" type="hidden" value="${depart.id }">
			<input name="lft" type="hidden" value="${depart.lft }">
			<input name="rgt" type="hidden" value="${depart.rgt }">		
					
			<table  cellpadding="0" cellspacing="1" class="formtable">
				<tr>
				<div>
				<tr align="center">
					<td class="value">
							<select name="leixing" id="leixing" class="selector"
								onchange="changetype(this.value)" >
									<option value="0">选择原材料</option>
									<option value="水泥">水泥</option>
									<option value="粉煤灰">粉煤灰</option>
									<option value="矿粉">矿粉</option>
									<option value="粗骨料">粗骨料</option>
									<option value="细骨料">细骨料</option>
									<option value="水">水</option>
									<option value="外加剂">外加剂</option>
									<!-- <option value="其他">其他</option> -->
							</select>
							<span class="Validform_checktip"><font color="red">*必选*</font></span>
							<label class="Validform_label" style="display: none;">类型</label>
						</td>
					</tr>
					</div>
					</tr>
					<tr>
					<div><table></table></div>
					<div id="shuini" style="display:none;">
					<table cellpadding="0" cellspacing="1" class="formtable">
						<tr>
							<td align="right"><label class="Validform_label">材料名称:</label></td>
							<td class="value"> <input id="shuinimingcheng" name="shuinimingcheng" type="text" style="width: 150px" class="inputxt" >
										<span class="Validform_checktip"></span><label class="Validform_label" style="display: none;">材料名称</label></td>
							<td align="right">标段部门</td>
							<td class="value"><%-- <input id="cc"  value="${depart.TSPDepart.departname}" style="width: 150px" class="inputxt">
									<span class="Validform_checktip"><font color="red">*必选*</font></span>
									<label class="Validform_label" style="display: none;">标段部门</label>
									<div><input id="tspdepartId" name="tspdepartId" style="display: none;" value="${depart.TSPDepart.id}"></div> --%>
									<select id="tspdepartId" name="tspdepartId" style="height:24px;width:120px;" datatype="*" errormsg="该字段不为空">
										<c:forEach items="${departlist}" var="lilun">
											<option value="${lilun.id}" >${lilun.departname}</option>
										</c:forEach>
									</select>
							</td>
						</tr>
						<!-- 产地、厂家 -->		
						<tr>
								<td align="right">
									<label class="Validform_label">
										产地:
									</label>
								</td>
								<td class="value">
								     	 <input id="shuinichandi" name="shuinichandi" type="text" style="width: 150px" class="inputxt"  
											               
											               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">产地</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							生产厂家:
						</label>
					</td>
					<td class="value">
					     	 <input id="shuiniscchangjia" name="shuiniscchangjia" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生产厂家</label>
						</td>
					</tr>
					
					
			<!-- 规格型号 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							规格:
						</label>
					</td>
					<td class="value"><select id="shuiniguige" name="shuiniguige" datatype="*" onchange="qh(this.value,'shuinixinghao')">
						<c:forEach items="${List}" var="depart">
							<option value="${depart.selectkey }" <c:if test="${depart.id==guige}">selected="selected"</c:if> onclick="">${depart.selectkey}</option>
						</c:forEach>
						</select>
						<span class="Validform_checktip"><font color="red">*必选*</font></span>
							<label class="Validform_label" style="display: none;">请选择规格</label>
						 </td>
					<td align="right">
						<label class="Validform_label">
							型号:
						</label>
						</td>
					<td class="value">
					     	<select id="shuinixinghao" name="shuinixinghao" datatype="*">
						<c:forEach items="${sList}" var="depart">
							<option value="${depart.mselectkey }" <c:if test="${depart.id==xinghao}">selected="selected"</c:if> onclick="">${depart.mselectkey}</option>
						</c:forEach>
						</select>
						<span class="Validform_checktip"><font color="red">*必选*</font></span>
							<label class="Validform_label" style="display: none;">请选择型号</label>
						
						</td>
						</td>
					</tr>
				<!-- 进场数量、产品批号 -->	
				<tr>
					<td align="right">
						<label class="Validform_label">
							进场数量(t):
						</label>
					</td>
					<td class="value">
					     	 <input id="shuinijcshuliang" name="shuinijcshuliang" type="text" style="width: 150px" class="inputxt"  
								          value="0"     
								               >
							<span class="Validform_checktip"><font color="red">*必填数字*</font></span>
							<label class="Validform_label" style="display: none;">进场数量(t)</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							产品批号:
						</label>
					</td>
					<td class="value">
					     	 <input id="shuinipicihao" name="shuinipicihao" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">产品批号</label>
						</td>
					</tr>
					
					<!-- 拟使用工程部位、取样日期 -->	
				<tr>
					<td align="right">
						<label class="Validform_label">
							拟使用工程部位:
						</label>
					</td>
					<td class="value">
					     	 <input id="shuinisyxingmu" name="shuinisyxingmu" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">拟使用工程部位</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							取样时间:
						</label>
					</td>
					<td class="value">
					     	<!--  <input id="qyshijian" name="qyshijian" type="text" style="width: 150px" class="inputxt"  
								               > -->
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="shuiniqyshijian" name="shuiniqyshijian"
				value="${time}" datatype="*">  
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">取样时间</label>
						</td>
					</tr>
					
				<!-- 样品编号、报告日期 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							样品编号:
						</label>
					</td>
					<td class="value"> <input id="shuiniycl11" name="shuiniycl11" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">样品编号</label>
							</td>
					<td align="right">
						<label class="Validform_label">
							报告时间:
						</label>
						</td>
					<td class="value">
					     	<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="shuiniycl12" name="shuiniycl12"
				value="${time}" datatype="*"> 
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">报告时间</label>
						</td>
					</tr>	
					<!-- 报告编号 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							报告编号:
						</label>
					</td>
					<td class="value"> <input id="shuinibgbianhao" name="shuinibgbianhao" type="text" style="width: 150px" class="inputxt"  
								    >
							<span class="Validform_checktip"><font color="red">*必填*</font></span>
							<label class="Validform_label" style="display: none;">报告编号</label>
							</td>
								
								
				<td align="right">
						<label class="Validform_label">
							存储地点:
						</label>
					</td>
					<td class="value"> <input id="shuinicunchudidian" name="shuinicunchudidian" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="red">*必填*</font></span>
							<label class="Validform_label" style="display: none;">存储地点</label>
							</td>
					</tr>	
					
					<tr>
								<td align="right"><label class="Validform_label">入库时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="shuinirukushijian" name="shuinirukushijian" datatype="*" value="${time}" >  
									<span class="Validform_checktip"><font color="red">*必选*</font></span><label class="Validform_label" style="display: none;">入库时间</label></td>
								<td align="right"><label class="Validform_label">试验时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="shuinisyshijian" name="shuinisyshijian"  datatype="*"  value="${time}"> 
									<span class="Validform_checktip"><font color="red">*必选*</font></span><label class="Validform_label" style="display: none;">试验时间</label></td>
						</tr>
						
						<tr>
								<td align="right"><label class="Validform_label">批次:</label></td>
								<td class="value"><input id="shuinipici" name="shuinipici" type="text" style="width: 150px" class="inputxt"    >
									<span class="Validform_checktip"><font color="red">*必填*</font></span><label class="Validform_label" style="display: none;">批次</label></td>
								<td></td>
								<td></td>
						</tr>
						
					<!-- 密度/比表面积 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							密度(g/cm³):
						</label>
					</td>
					<td class="value"> <input id="shuiniycl1" name="shuiniycl1" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span>
							<label class="Validform_label" style="display: none;">密度</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							比表面积(cm²):
						</label>
					</td>
					<td class="value"> <input id="shuiniycl2" name="shuiniycl2" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span>
							<label class="Validform_label" style="display: none;">比表面积</label>
							</td>
					</tr>	
					
					
					<!-- 标准稠度用水量/初凝时间-->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							标准稠度用水量(%):
						</label>
					</td>
					<td class="value"> <input id="shuiniycl3" name="shuiniycl3" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span>
							<label class="Validform_label" style="display: none;">标准稠度用水量(%)</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							初凝时间(min):
						</label>
					</td>
					<td class="value"> <input id="shuiniycl4" name="shuiniycl4" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span>
							<label class="Validform_label" style="display: none;">初凝时间</label>
							</td>
					</tr>
					
					<!-- 终凝试件/比表面积 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							终凝时间(min):
						</label>
					</td>
					<td class="value"> <input id="shuiniycl5" name="shuiniycl5" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span>
							<label class="Validform_label" style="display: none;">终凝试件</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							安定性:
						</label>
					</td>
					<td class="value"><!--  <input id="ycl6" name="ycl6" type="text" style="width: 150px" class="inputxt"  
								               > -->
					<select  id="shuiniycl6" name="shuiniycl6" datatype="*">	
							<option value="合格" >合格</option>
							<option value="不合格" >不合格</option>	  </select>	            
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">安定性</label>
							</td>
					</tr>
					<!-- 3d抗折强度/3d抗压强度 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							3d抗折强度(MPa):
						</label>
					</td>
					<td class="value"> <input id="shuiniycl7" name="shuiniycl7" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span>
							<label class="Validform_label" style="display: none;">3d抗折强度</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							3d抗压强度(MPa):
						</label>
					</td>
					<td class="value"> <input id="shuiniycl8" name="shuiniycl8" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span>
							<label class="Validform_label" style="display: none;">3d抗压强度</label>
							</td>
					</tr>
					<!-- 28d抗折强度/28d抗压强度 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							28d抗折强度(MPa):
						</label>
					</td>
					<td class="value"> <input id="shuiniycl9" name="shuiniycl9" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span>
							<label class="Validform_label" style="display: none;">28d抗折强度</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							28d抗压强度(MPa):
						</label>
					</td>
					<td class="value"> <input id="shuiniycl10" name="shuiniycl10" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span>
							<label class="Validform_label" style="display: none;">28d抗压强度</label>
							</td>
					</tr>
					
					
					<!-- 检测结论/试验人员-->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							检测结论:
						</label>
					</td>
					<td class="value"> <select id="shuiniycl0" name="shuiniycl0" datatype="*">	
								<option value="合格">合格</option>
								<option value="不合格" >不合格</option>	  </select>	 
							<span class="Validform_checktip"><font color="red">*必选*</font></span> 
							<!--<label class="Validform_label" style="display: none;">检测结论</label>-->
							</td>
					
						<td align="right">
						<label class="Validform_label">
							试验人员:
						</label>
					</td>
					<td class="value"> <input id="shuinishiyanren" name="shuinishiyanren" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">试验人员</label>
							</td>
					</tr>
					
					
					<!-- <tr>
					
						<td align="right">
						<label class="Validform_label">
							标记:
						</label>
					</td>
					<td class="value"> <input id="shuinibiaoji" name="shuinibiaoji" type="text" style="width: 150px" class="inputxt"  
								     value="0"    readonly="readonly"      >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">试验人员</label>
							</td>
						<td align="center"></td>
								<td class="value"></td>	
					</tr> -->
					
					</table>
					</div>
					
					
					
					<div id="fenmeihui" style="display:none;">
					<table cellpadding="0" cellspacing="1" class="formtable">
					<tr>
									<td align="right">
								<label class="Validform_label">
									材料名称:
								</label>
							</td>
							<td class="value"> <input id="fenmeihuimingcheng" name="fenmeihuimingcheng" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">材料名称</label>
							</td>
							<td align="right">标段部门</td>
							<td class="value"><%-- <input id="ss"  value="${depart.TSPDepart.departname}">
								<span class="Validform_checktip"><font color="red">*必选*</font></span> 
								<input id="fmhtspdepartId" name="fmhtspdepartId" style="display: none;"
								value="${depart.TSPDepart.id}"></div> --%>
								<select id="fmhtspdepartId" name="fmhtspdepartId" style="height:24px;width:120px;" datatype="*" errormsg="该字段不为空">
										<c:forEach items="${departlist}" var="lilun">
											<option value="${lilun.id}" >${lilun.departname}</option>
										</c:forEach>
									</select>
							</td>
						</tr>
					<!-- 产地、厂家 -->		
			<tr>
					<td align="right">
						<label class="Validform_label">
							产地:
						</label>
					</td>
					<td class="value">
					     	 <input id="fenmeihuichandi" name="fenmeihuichandi" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">产地</label>-->
						</td>
					<td align="right">
						<label class="Validform_label">
							生产厂家:
						</label>
					</td>
					<td class="value">
					     	 <input id="fenmeihuiscchangjia" name="fenmeihuiscchangjia" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">生产厂家</label>-->
						</td>
					</tr>
					
					
			<!-- 规格型号 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							规格:
						</label>
					</td>
					<td class="value"><select id="fenmeihuiguige" name="fenmeihuiguige" datatype="*" onchange="qh(this.value,'fenmeihuixinghao')">
						<c:forEach items="${List}" var="depart">
							<option value="${depart.selectkey }" <c:if test="${depart.id==guige}">selected="selected"</c:if> onclick="">${depart.selectkey}</option>
						</c:forEach>
						</select>
						<span class="Validform_checktip"><font color="red">*必选*</font</span> 
							<label class="Validform_label" style="display: none;">请选择规格</label>
						 </td>
					<td align="right">
						<label class="Validform_label">
							型号:
						</label>
						</td>
					<td class="value">
					     	<select id="fenmeihuixinghao" name="fenmeihuixinghao" datatype="*">
						<c:forEach items="${sList}" var="depart">
							<option value="${depart.mselectkey }" <c:if test="${depart.id==xinghao}">selected="selected"</c:if> onclick="">${depart.mselectkey}</option>
						</c:forEach>
						</select>
						<span class="Validform_checktip"><font color="red">*必选*</font</span> 
							<label class="Validform_label" style="display: none;">请选择型号</label>
						
						</td>
						</td>
					</tr>
				<!-- 进场数量、产品批号 -->	
				<tr>
					<td align="right">
						<label class="Validform_label">
							进场数量(t):
						</label>
					</td>
					<td class="value">
					     	 <input id="fenmeihuijcshuliang" name="fenmeihuijcshuliang" type="text" style="width: 150px" class="inputxt"  
								               value="0"
								               >
							<span class="Validform_checktip"><font color="red">*必填数字*</font></span> 
							<!--<label class="Validform_label" style="display: none;">进场数量(t)</label>-->
						</td>
					<td align="right">
						<label class="Validform_label">
							产品批号:
						</label>
					</td>
					<td class="value">
					     	 <input id="fenmeihuipicihao" name="fenmeihuipicihao" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">产品批号</label>-->
						</td>
					</tr>
					
					<!-- 拟使用工程部位、取样日期 -->	
				<tr>
					<td align="right">
						<label class="Validform_label">
							拟使用工程部位:
						</label>
					</td>
					<td class="value">
					     	 <input id="fenmeihuisyxingmu" name="fenmeihuisyxingmu" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">拟使用工程部位</label>-->
						</td>
					<td align="right">
						<label class="Validform_label">
							取样时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="fenmeihuiqyshijian" name="fenmeihuiqyshijian"
				value="${time}" datatype="*">  
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">取样日期</label>-->
						</td>
					</tr>
					
				<!-- 样品编号、报告日期 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							样品编号:
						</label>
					</td>
					<td class="value"> <input id="fenmeihuiycl11" name="fenmeihuiycl11" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">样品编号</label>-->
							</td>
					<td align="right">
						<label class="Validform_label">
							报告时间:
						</label>
						</td>
					<td class="value">
					     	<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="fenmeihuiycl12" name="fenmeihuiycl12"
				value="${time}" datatype="*"> 
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">报告日期</label> -->
						</td>
					</tr>	
					<!-- 报告编号 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							报告编号:
						</label>
					</td>
					<td class="value"> <input id="fenmeihuibgbianhao" name="fenmeihuibgbianhao" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="red">*必填*</font></span>
							<!--<label class="Validform_label" style="display: none;">报告编号</label>-->
							</td>
							<td align="right">
						<label class="Validform_label">
							存储地点:
						</label>
					</td>
					<td class="value"> <input id="fenmeihuicunchudidian" name="fenmeihuicunchudidian" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="red">*必填*</font></span> 
							<label class="Validform_label" style="display: none;">存储地点</label>
							</td>
					</tr>	
					
					
					<tr>
								<td align="right"><label class="Validform_label">入库时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="fenmeihuirukushijian" name="fenmeihuirukushijian" datatype="*" value="${time}" >  
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">入库时间</label></td>
								<td align="right"><label class="Validform_label">试验时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="fenmeihuisyshijian" name="fenmeihuisyshijian"  datatype="*"  value="${time}"> 
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">试验时间</label></td>
						</tr>
						
						<tr>
								<td align="right"><label class="Validform_label">批次:</label></td>
								<td class="value"><input id="fenmeihuipici" name="fenmeihuipici" type="text" style="width: 150px" class="inputxt"    >
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">批次</label></td>
								<td></td>
								<td></td>
						</tr>
					
					<!-- 密度/比表面积 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							45um方孔筛筛余(%):
						</label>
					</td>
					<td class="value"> <input id="fenmeihuiycl1" name="fenmeihuiycl1" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">密度</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							比表面积(cm²):
						</label>
					</td>
					<td class="value"> <input id="fenmeihuiycl2" name="fenmeihuiycl2" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">比表面积</label>
							</td>
					</tr>	
					
					
					<!-- 标准稠度用水量/初凝时间-->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							需水量比(%):
						</label>
					</td>
					<td class="value"> <input id="fenmeihuiycl3" name="fenmeihuiycl3" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">需水量比</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							烧失量(%):
						</label>
					</td>
					<td class="value"> <input id="fenmeihuiycl4" name="fenmeihuiycl4" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">烧失量</label>
							</td>
					</tr>
					
					<!-- 终凝试件/比表面积 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							含水量(%):
						</label>
					</td>
					<td class="value"> <input id="fenmeihuiycl5" name="fenmeihuiycl5" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">含水量</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							三氧化硫含量(%):
						</label>
					</td>
					<td class="value"> <input id="fenmeihuiycl6" name="fenmeihuiycl6" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">三氧化硫含量</label>
							</td>
					</tr>
					
					
					<!-- 检测结论/试验人员-->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							检测结论:
						</label>
					</td>
					<td class="value"> <select id="fenmeihuiycl0" name="fenmeihuiycl0" datatype="*">	
								<option value="合格" >合格</option>
								<option value="不合格">不合格</option>	  
								</select>	 
							<span class="Validform_checktip"><font color="red">*必选*</font</span> 
							<label class="Validform_label" style="display: none;">检测结论</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							试验人员:
						</label>
					</td>
					<td class="value"> <input id="fenmeihuishiyanren" name="fenmeihuishiyanren" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">试验人员</label>
							</td>
					</tr>
					
					<!-- <tr>
					
						<td align="right">
						<label class="Validform_label">
							标记:
						</label>
					</td>
					<td class="value"> <input id="fenmeihuibiaoji" name="fenmeihuibiaoji" type="text" style="width: 150px" class="inputxt"  
								     value="0"    readonly="readonly"      >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">试验人员</label>
							</td>
							<td align="center"></td>
								<td class="value"></td>	
					</tr> -->
					</table>
					</div>
					
					
		 			
					<div id="kuangfen" style="display:none;">
					<table cellpadding="0" cellspacing="1" class="formtable">
					<tr>
									<td align="right">
								<label class="Validform_label">
									材料名称:
								</label>
							</td>
							<td class="value"> <input id="kuangfenmingcheng" name="kuangfenmingcheng" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">材料名称</label>-->
							</td>
							<td align="right">标段部门</td>
							<td class="value"><%-- <input id="aa"  value="${depart.TSPDepart.departname}">
								<span class="Validform_checktip"><font color="red">*必选*</font></span> 
								<input id="kftspdepartId" name="kftspdepartId" style="display: none;"
								value="${depart.TSPDepart.id}"></div> --%>
								<select id="kftspdepartId" name="kftspdepartId" style="height:24px;width:120px;" datatype="*" errormsg="该字段不为空">
										<c:forEach items="${departlist}" var="lilun">
											<option value="${lilun.id}" >${lilun.departname}</option>
										</c:forEach>
									</select>
							</td>
						</tr>
							<!-- 产地、厂家 -->		
			<tr>
					<td align="right">
						<label class="Validform_label">
							产地:
						</label>
					</td>
					<td class="value">
					     	 <input id="kuangfenchandi" name="kuangfenchandi" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">产地</label>-->
						</td>
					<td align="right">
						<label class="Validform_label">
							生产厂家:
						</label>
					</td>
					<td class="value">
					     	 <input id="kuangfenscchangjia" name="kuangfenscchangjia" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">生产厂家</label>-->
						</td>
					</tr>
					
					
			<!-- 规格型号 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							规格:
						</label>
					</td>
					<td class="value"><select id="kuangfenguige" name="kuangfenguige" datatype="*" onchange="qh(this.value,'kuangfenxinghao')">
						<c:forEach items="${List}" var="depart">
							<option value="${depart.selectkey }" <c:if test="${depart.id==guige}">selected="selected"</c:if> onclick="">${depart.selectkey}</option>
						</c:forEach>
						</select>
						<span class="Validform_checktip"><font color="red">*必选*</font</span> 
							<label class="Validform_label" style="display: none;">请选择规格</label>
						 </td>
					<td align="right">
						<label class="Validform_label">
							型号:
						</label>
						</td>
					<td class="value">
					     	<select id="kuangfenxinghao" name="kuangfenxinghao" datatype="*">
						<c:forEach items="${sList}" var="depart">
							<option value="${depart.mselectkey }" <c:if test="${depart.id==xinghao}">selected="selected"</c:if> onclick="">${depart.mselectkey}</option>
						</c:forEach>
						</select>
						<span class="Validform_checktip"><font color="red">*必选*</font</span> 
							<label class="Validform_label" style="display: none;">请选择型号</label>
						
						</td>
						</td>
					</tr>
				<!-- 进场数量、产品批号 -->	
				<tr>
					<td align="right">
						<label class="Validform_label">
							进场数量(t):
						</label>
					</td>
					<td class="value">
					     	 <input id="kuangfenjcshuliang" name="kuangfenjcshuliang" type="text" style="width: 150px" class="inputxt"  
								 value="0"               
								               >
							<span class="Validform_checktip"><font color="red">*必填数字*</font></span> 
							<label class="Validform_label" style="display: none;">进场数量(t)</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							产品批号:
						</label>
					</td>
					<td class="value">
					     	 <input id="kuangfenpicihao" name="kuangfenpicihao" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">产品批号</label>-->
						</td>
					</tr>
					
					<!-- 拟使用工程部位、取样日期 -->	
				<tr>
					<td align="right">
						<label class="Validform_label">
							拟使用工程部位:
						</label>
					</td>
					<td class="value">
					     	 <input id="kuangfensyxingmu" name="kuangfensyxingmu" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">拟使用工程部位</label>-->
						</td>
					<td align="right">
						<label class="Validform_label">
							取样时间:
						</label>
					</td>
					<td class="value">
					     	<!--  <input id="qyshijian" name="qyshijian" type="text" style="width: 150px" class="inputxt"  
								               > -->
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="kuangfenqyshijian" name="kuangfenqyshijian"
				value="${time}" datatype="*">  
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">取样日期</label>-->
						</td>
					</tr>
					
				<!-- 样品编号、报告日期 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							样品编号:
						</label>
					</td>
					<td class="value"> <input id="ycl11" name="ycl11" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">样品编号</label>-->
							</td>
					<td align="right">
						<label class="Validform_label">
							报告时间:
						</label>
						</td>
					<td class="value">
					     	<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="kuangfenycl12" name="kuangfenycl12"
				value="${time}" datatype="*"> 
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">报告日期</label> -->
						</td>
					</tr>	
					<!-- 报告编号 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							报告编号:
						</label>
					</td>
					<td class="value"> <input id="kuangfenbgbianhao" name="kuangfenbgbianhao" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="red">*必填*</font></span>
							<!--<label class="Validform_label" style="display: none;">报告编号</label>-->
							</td>
							<td align="right">
							<label class="Validform_label">
								存储地点:
							</label>
						</td>
						<td class="value"> <input id="kuangfencunchudidian" name="kuangfencunchudidian" type="text" style="width: 150px" class="inputxt"  
									               >
								<span class="Validform_checktip"><font color="red">*必填*</font></span> 
								<label class="Validform_label" style="display: none;">存储地点</label>
								</td>
					</tr>	
					
					<tr>
								<td align="right"><label class="Validform_label">入库时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="kuangfenrukushijian" name="kuangfenrukushijian" datatype="*" value="${time}" >  
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">入库时间</label></td>
								<td align="right"><label class="Validform_label">试验时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="kuangfensyshijian" name="kuangfensyshijian"  datatype="*"  value="${time}"> 
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">试验时间</label></td>
						</tr>
						
						<tr>
								<td align="right"><label class="Validform_label">批次:</label></td>
								<td class="value"><input id="kuangfenpici" name="kuangfenpici" type="text" style="width: 150px" class="inputxt"    >
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">批次</label></td>
								<td></td>
								<td></td>
						</tr>
					
					
					<!-- 密度/比表面积 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							密度(g/cm³):
						</label>
					</td>
					<td class="value"> <input id="kuangfenycl1" name="kuangfenycl1" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">密度</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							比表面积(cm²):
						</label>
					</td>
					<td class="value"> <input id="kuangfenycl2" name="kuangfenycl2" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">比表面积</label>
							</td>
					</tr>	
					
					
					<!-- 标准稠度用水量/初凝时间-->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							7d活性指数(%):
						</label>
					</td>
					<td class="value"> <input id="kuangfenycl3" name="kuangfenycl3" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">需水量比</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							28d活性指数(%):
						</label>
					</td>
					<td class="value"> <input id="kuangfenycl4" name="kuangfenycl4" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">28d活性指数</label>
							</td>
					</tr>
					
					<!-- 终凝试件/比表面积 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							含水量(%):
						</label>
					</td>
					<td class="value"> <input id="kuangfenycl5" name="kuangfenycl5" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">含水量</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							三氧化硫含量(%):
						</label>
					</td>
					<td class="value"> <input id="kuangfenycl6" name="kuangfenycl6" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">三氧化硫含量</label>
							</td>
					</tr>
					
					
					<!-- 检测结论/试验人员-->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							检测结论:
						</label>
					</td>
					<td class="value"> <select id="kuangfenycl0" name="kuangfenycl0" datatype="*">	
								<option value="合格" >合格</option>
								<option value="不合格" >不合格</option>	 
								 </select>	 
							<span class="Validform_checktip"><font color="red">*必选*</font</span> 
							<label class="Validform_label" style="display: none;">检测结论</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							试验人员:
						</label>
					</td>
					<td class="value"> <input id="kuangfenshiyanren" name="kuangfenshiyanren" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">试验人员</label>
							</td>
					</tr>
					
					<!-- <tr>
					
						<td align="right">
						<label class="Validform_label">
							标记:
						</label>
					</td>
					<td class="value"> <input id="kuangfenbiaoji" name="kuangfenbiaoji" type="text" style="width: 150px" class="inputxt"  
								     value="0"    readonly="readonly"      >
								     <select id="kuangfenbiaoji" name="kuangfenbiaoji" datatype="*">	
								<option value="0">0</option>
								<option value="1" >1</option>	  </select>	 
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">试验人员</label>
							</td>
						<td align="center"></td>
								<td class="value"></td>	
					</tr> -->
					
					</table>
					</table>
					</div>
					
					
					<div id="cunjiliao" style="display:none;">
					<table cellpadding="0" cellspacing="1" class="formtable">
					<tr>
									<td align="right">
								<label class="Validform_label">
									材料名称:
								</label>
							</td>
							<td class="value"> <input id="cunjiliaomingcheng" name="cunjiliaomingcheng" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">材料名称</label>-->
							</td>
							<td align="right">标段部门</td>
							<td class="value"><%-- <input id="bb"  value="${depart.TSPDepart.departname}">
								<span class="Validform_checktip"><font color="red">*必选*</font></span> 
								<input id="cjltspdepartId" name="cjltspdepartId" style="display: none;"
								value="${depart.TSPDepart.id}"></div> --%>
								<select id="cjltspdepartId" name="cjltspdepartId" style="height:24px;width:120px;" datatype="*" errormsg="该字段不为空">
										<c:forEach items="${departlist}" var="lilun">
											<option value="${lilun.id}" >${lilun.departname}</option>
										</c:forEach>
									</select>
							</td>
						</tr>
									<!-- 产地、厂家 -->		
			<tr>
					<td align="right">
						<label class="Validform_label">
							产地:
						</label>
					</td>
					<td class="value">
					     	 <input id="cunjiliaochandi" name="cunjiliaochandi" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">产地</label>-->
						</td>
					<td align="right">
						<label class="Validform_label">
							生产厂家:
						</label>
					</td>
					<td class="value">
					     	 <input id="cunjiliaoscchangjia" name="cunjiliaoscchangjia" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">生产厂家</label>-->
						</td>
					</tr>
					
					
			<!-- 规格型号 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							规格:
						</label>
					</td>
					<td class="value"><select id="cunjiliaoguige" name="cunjiliaoguige" datatype="*" onchange="qh(this.value,'cunjiliaoxinghao')">
						<c:forEach items="${List}" var="depart">
							<option value="${depart.selectkey }" <c:if test="${depart.id==guige}">selected="selected"</c:if> onclick="">${depart.selectkey}</option>
						</c:forEach>
						</select>
						<span class="Validform_checktip"><font color="red">*必选*</font</span> 
							<label class="Validform_label" style="display: none;">请选择规格</label>
						 </td>
					<td align="right">
						<label class="Validform_label">
							型号:
						</label>
						</td>
					<td class="value">
					     	<select id="cunjiliaoxinghao" name="cunjiliaoxinghao" datatype="*">
						<c:forEach items="${sList}" var="depart">
							<option value="${depart.mselectkey }" <c:if test="${depart.id==xinghao}">selected="selected"</c:if> onclick="">${depart.mselectkey}</option>
						</c:forEach>
						</select>
						<span class="Validform_checktip"><font color="red">*必选*</font</span> 
							<label class="Validform_label" style="display: none;">请选择型号</label>
						
						</td>
						</td>
					</tr>
				<!-- 进场数量、产品批号 -->	
				<tr>
					<td align="right">
						<label class="Validform_label">
							进场数量(t):
						</label>
					</td>
					<td class="value">
					     	 <input id="cunjiliaojcshuliang" name="cunjiliaojcshuliang" type="text" style="width: 150px" class="inputxt"  
								 value="0"               
								               >
							<span class="Validform_checktip"><font color="red">*必填数字*</font></span> 
							<label class="Validform_label" style="display: none;">进场数量(t)</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							产品批号:
						</label>
					</td>
					<td class="value">
					     	 <input id="cunjiliaopicihao" name="cunjiliaopicihao" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">产品批号</label>-->
						</td>
					</tr>
					
					<!-- 拟使用工程部位、取样日期 -->	
				<tr>
					<td align="right">
						<label class="Validform_label">
							拟使用工程部位:
						</label>
					</td>
					<td class="value">
					     	 <input id="cunjiliaosyxingmu" name="cunjiliaosyxingmu" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">拟使用工程部位</label>-->
						</td>
					<td align="right">
						<label class="Validform_label">
							取样时间:
						</label>
					</td>
					<td class="value">
					     	<!--  <input id="qyshijian" name="qyshijian" type="text" style="width: 150px" class="inputxt"  
								               > -->
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="cunjiliaoqyshijian" name="cunjiliaoqyshijian"
				value="${time}" datatype="*">  
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">取样日期</label>-->
						</td>
					</tr>
					
				<!-- 样品编号、报告日期 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							样品编号:
						</label>
					</td>
					<td class="value"> <input id="cunjiliaoycl11" name="cunjiliaoycl11" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">样品编号</label>-->
							</td>
					<td align="right">
						<label class="Validform_label">
							报告时间:
						</label>
						</td>
					<td class="value">
					     	<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="cunjiliaoycl12" name="cunjiliaoycl12"
				value="${time}" datatype="*"> 
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">报告日期</label> -->
						</td>
					</tr>	
					<!-- 报告编号 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							报告编号:
						</label>
					</td>
					<td class="value"> <input id="cunjiliaobgbianhao" name="cunjiliaobgbianhao" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="red">*必填*</font></span>
							<!--<label class="Validform_label" style="display: none;">报告编号</label>-->
							</td>
							<td align="right">
						<label class="Validform_label">
							存储地点:
						</label>
					</td>
					<td class="value"> <input id="cunjiliaocunchudidian" name="cunjiliaocunchudidian" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="red">*必填*</font></span>
							<label class="Validform_label" style="display: none;">存储地点</label>
							</td>
					</tr>	
					
					<tr>
								<td align="right"><label class="Validform_label">入库时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="cunjiliaorukushijian" name="cunjiliaorukushijian" datatype="*" value="${time}" >  
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">入库时间</label></td>
								<td align="right"><label class="Validform_label">试验时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="cunjiliaosyshijian" name="cunjiliaosyshijian"  datatype="*"  value="${time}"> 
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">试验时间</label></td>
						</tr>
						
						<tr>
								<td align="right"><label class="Validform_label">批次:</label></td>
								<td class="value"><input id="cunjiliaopici" name="cunjiliaopici" type="text" style="width: 150px" class="inputxt"    >
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">批次</label></td>
								<td></td>
								<td></td>
						</tr>
					
					<!-- 密度/比表面积 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							级配:
						</label>
					</td>
					<td class="value"> <select id="cunjiliaoycl1" name="cunjiliaoycl1" datatype="*">	
								<option value="合格" >合格</option>
								<option value="不合格" >不合格</option>	  </select>	 
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">级配</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							含泥量(%):
						</label>
					</td>
					<td class="value"> <input id="cunjiliaoycl2" name="cunjiliaoycl2" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">含泥量</label>
							</td>
					</tr>	
					
					
					<!-- 标准稠度用水量/初凝时间-->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							泥块含量(%):
						</label>
					</td>
					<td class="value"> <input id="cunjiliaoycl3" name="cunjiliaoycl3" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">泥块含量</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							针片状含量(%):
						</label>
					</td>
					<td class="value"> <input id="cunjiliaoycl4" name="cunjiliaoycl4" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">针片状含量</label>
							</td>
					</tr>
					
					<!-- 终凝试件/比表面积 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							压碎值(%):
						</label>
					</td>
					<td class="value"> <input id="cunjiliaoycl5" name="cunjiliaoycl5" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">压碎值</label>
							</td>
						<td align="center"></td>
								<td class="value"></td>	
					</tr>
					
					
					<!-- 检测结论/试验人员-->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							检测结论:
						</label>
					</td>
					<td class="value"> <select id="cunjiliaoycl0" name="cunjiliaoycl0" datatype="*">	
								<option value="合格" >合格</option>
								<option value="不合格" >不合格</option>	  </select>	 
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">检测结论</label>-->
							</td>
					
						<td align="right">
						<label class="Validform_label">
							试验人员:
						</label>
					</td>
					<td class="value"> <input id="cunjiliaoshiyanren" name="cunjiliaoshiyanren" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">试验人员</label>
							</td>
					</tr>
					
					<!-- <tr>
					
						<td align="right">
						<label class="Validform_label">
							标记:
						</label>
					</td>
					<td class="value"> <input id="cunjiliaobiaoji" name="cunjiliaobiaoji" type="text" style="width: 150px" class="inputxt"  
								     value="0"       readonly="readonly"   >
								     <select id="cunjiliaobiaoji" name="cunjiliaobiaoji" datatype="*">	
								<option value="0">0</option>
								<option value="1" >1</option>	  </select>	 
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">试验人员</label>
							</td>
						<td align="center"></td>
								<td class="value"></td>	
					</tr> -->
					
					</table>
					</div>
					 
					
					
					
					<div id="xijiliao" style="display:none;">
					<table cellpadding="0" cellspacing="1" class="formtable">
					<tr>
									<td align="right">
								<label class="Validform_label">
									材料名称:
								</label>
							</td>
							<td class="value"> <input id="xijiliaomingcheng" name="xijiliaomingcheng" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">材料名称</label>-->
							</td>
							<td align="right">标段部门</td>
							<td class="value"><%-- <input id="dd"  value="${depart.TSPDepart.departname}">
								<span class="Validform_checktip"><font color="red">*必选*</font></span> 
								<input id="xjltspdepartId" name="xjltspdepartId" style="display: none;"
								value="${depart.TSPDepart.id}"></div> --%>
								<select id="xjltspdepartId" name="xjltspdepartId" style="height:24px;width:120px;" datatype="*" errormsg="该字段不为空">
										<c:forEach items="${departlist}" var="lilun">
											<option value="${lilun.id}" >${lilun.departname}</option>
										</c:forEach>
									</select>
							</td>
						</tr>
											<!-- 产地、厂家 -->		
			<tr>
					<td align="right">
						<label class="Validform_label">
							产地:
						</label>
					</td>
					<td class="value">
					     	 <input id="xijiliaochandi" name="xijiliaochandi" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">产地</label>-->
						</td>
					<td align="right">
						<label class="Validform_label">
							生产厂家:
						</label>
					</td>
					<td class="value">
					     	 <input id="xijiliaoscchangjia" name="xijiliaoscchangjia" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">生产厂家</label>-->
						</td>
					</tr>
					
					
			<!-- 规格型号 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							规格:
						</label>
					</td>
					<td class="value"><select id="xijiliaoguige" name="xijiliaoguige" datatype="*" onchange="qh(this.value,'xijiliaoxinghao')">
						<c:forEach items="${List}" var="depart">
							<option value="${depart.selectkey }" <c:if test="${depart.id==guige}">selected="selected"</c:if> onclick="">${depart.selectkey}</option>
						</c:forEach>
						</select>
						<span class="Validform_checktip"><font color="red">*必选*</font></span> 
							<label class="Validform_label" style="display: none;">请选择规格</label>
						 </td>
					<td align="right">
						<label class="Validform_label">
							型号:
						</label>
						</td>
					<td class="value">
					     	<select id="xijiliaoxinghao" name="xijiliaoxinghao" datatype="*">
						<c:forEach items="${sList}" var="depart">
							<option value="${depart.mselectkey }" <c:if test="${depart.id==xinghao}">selected="selected"</c:if> onclick="">${depart.mselectkey}</option>
						</c:forEach>
						</select>
						<span class="Validform_checktip"><font color="red">*必选*</font></span> 
							<label class="Validform_label" style="display: none;">请选择型号</label>
						
						</td>
						</td>
					</tr>
				<!-- 进场数量、产品批号 -->	
				<tr>
					<td align="right">
						<label class="Validform_label">
							进场数量(t):
						</label>
					</td>
					<td class="value">
					     	 <input id="xijiliaojcshuliang" name="xijiliaojcshuliang" type="text" style="width: 150px" class="inputxt"  
								        value="0"        
								               >
							<span class="Validform_checktip"><font color="red">*必填数字*</font></span> 
							<label class="Validform_label" style="display: none;">进场数量(t)</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							产品批号:
						</label>
					</td>
					<td class="value">
					     	 <input id="xijiliaopicihao" name="xijiliaopicihao" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">产品批号</label>-->
						</td>
					</tr>
					
					<!-- 拟使用工程部位、取样日期 -->	
				<tr>
					<td align="right">
						<label class="Validform_label">
							拟使用工程部位:
						</label>
					</td>
					<td class="value">
					     	 <input id="xijiliaosyxingmu" name="xijiliaosyxingmu" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">拟使用工程部位</label>-->
						</td>
					<td align="right">
						<label class="Validform_label">
							取样时间:
						</label>
					</td>
					<td class="value">
					     	<!--  <input id="qyshijian" name="qyshijian" type="text" style="width: 150px" class="inputxt"  
								               > -->
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="xijiliaoqyshijian" name="xijiliaoqyshijian"
				value="${time}" datatype="*">  
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">取样日期</label>-->
						</td>
					</tr>
					
				<!-- 样品编号、报告日期 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							样品编号:
						</label>
					</td>
					<td class="value"> <input id="xijiliaoycl11" name="xijiliaoycl11" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">样品编号</label>-->
							</td>
					<td align="right">
						<label class="Validform_label">
							报告时间:
						</label>
						</td>
					<td class="value">
					     	<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="xijiliaoycl12" name="xijiliaoycl12"
				value="${time}" datatype="*"> 
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">报告日期</label> -->
						</td>
					</tr>	
					<!-- 报告编号 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							报告编号:
						</label>
					</td>
					<td class="value"> <input id="xijiliaobgbianhao" name="xijiliaobgbianhao" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="red">*必填*</font></span>
							<!--<label class="Validform_label" style="display: none;">报告编号</label>-->
							</td>
							<td align="right">
						<label class="Validform_label">
							存储地点:
						</label>
					</td>
					<td class="value"> <input id="xijiliaocunchudidian" name="xijiliaocunchudidian" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="red">*必填*</font></span>
							<label class="Validform_label" style="display: none;">存储地点</label>
							</td>	
					</tr>	
					
					<tr>
								<td align="right"><label class="Validform_label">入库时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="xijiliaorukushijian" name="xijiliaorukushijian" datatype="*" value="${time}" >  
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">入库时间</label></td>
								<td align="right"><label class="Validform_label">试验时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="xijiliaosyshijian" name="xijiliaosyshijian"  datatype="*"  value="${time}"> 
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">试验时间</label></td>
						</tr>
						
						<tr>
								<td align="right"><label class="Validform_label">批次:</label></td>
								<td class="value"><input id="xijiliaopici" name="xijiliaopici" type="text" style="width: 150px" class="inputxt"    >
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">批次</label></td>
								<td></td>
								<td></td>
						</tr>
					
					
					<!-- 密度/比表面积 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							级配:
						</label>
					</td>
					<td class="value"> <select  id="xijiliaoycl1" name="xijiliaoycl1" datatype="*">	
								<option value="合格" >合格</option>
								<option value="不合格" >不合格</option>	  
							</select>	 
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">级配</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							细度模数:
						</label>
					</td>
					<td class="value"> <input id="xijiliaoycl2" name="xijiliaoycl2" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">细度模数</label>
							</td>
					</tr>	
					
					
					<!-- 标准稠度用水量/初凝时间-->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							含泥量(%):
						</label>
					</td>
					<td class="value"> <input id="xijiliaoycl3" name="xijiliaoycl3" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">含泥量</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							泥块含量(%):
						</label>
					</td>
					<td class="value"> <input id="xijiliaoycl4" name="xijiliaoycl4" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">泥块含量</label>
							</td>
					</tr>
					
					<!-- 终凝试件/比表面积 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							堆积密度(g/cm³):
						</label>
					</td>
					<td class="value"> <input id="xijiliaoycl5" name="xijiliaoycl5" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">堆积密度</label>
							</td>
							
							
					<td align="right">
						<label class="Validform_label">
							氯离子含量(%):
						</label>
					</td>
					<td class="value"> <input id="xijiliaoycl6" name="xijiliaoycl6" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">氯离子含量</label>
							</td>
					
					</tr>
					
					
					<!-- 检测结论/试验人员-->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							检测结论:
						</label>
					</td>
					<td class="value"> <select id="xijiliaoycl0" name="xijiliaoycl0" datatype="*">	
								<option value="合格" >合格</option>
								<option value="不合格" >不合格</option>	 
								 </select>	 
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">检测结论</label>-->
							</td>
					
						<td align="right">
						<label class="Validform_label">
							试验人员:
						</label>
					</td>
					<td class="value"> <input id="xijiliaoshiyanren" name="xijiliaoshiyanren" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">试验人员</label>
							</td>
					</tr>
					
					<!-- <tr>
					
						<td align="right">
						<label class="Validform_label">
							标记:
						</label>
					</td>
					<td class="value"> <input id="xijiliaobiaoji" name="xijiliaobiaoji" type="text" style="width: 150px" class="inputxt"  
								     value="0"    readonly="readonly"      >
								     <select id="xijiliaobiaoji" name="xijiliaobiaoji" datatype="*">	
								<option value="0">0</option>
								<option value="1" >1</option>	  </select>	 
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">试验人员</label>
							</td>
						<td align="center"></td>
								<td class="value"></td>	
					</tr> -->
					
					
					</table>
					</div>
					 
					
					
					<div id="shui" style="display:none;">
					<table cellpadding="0" cellspacing="1" class="formtable">
					<tr>
									<td align="right">
								<label class="Validform_label">
									材料名称:
								</label>
							</td>
							<td class="value"> <input id="shuimingcheng" name="shuimingcheng" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">材料名称</label>-->
							</td>
							<td align="right">标段部门</td>
							<td class="value"><%-- <input id="ee"  value="${depart.TSPDepart.departname}">
								<span class="Validform_checktip"><font color="red">*必选*</font></span> 
								<input id="stspdepartId" name="stspdepartId" style="display: none;"
								value="${depart.TSPDepart.id}"></div> --%>
								<select id="stspdepartId" name="stspdepartId" style="height:24px;width:120px;" datatype="*" errormsg="该字段不为空">
										<c:forEach items="${departlist}" var="lilun">
											<option value="${lilun.id}" >${lilun.departname}</option>
										</c:forEach>
									</select>
							</td>
						</tr>
														<!-- 产地、厂家 -->		
			<tr>
					<td align="right">
						<label class="Validform_label">
							产地:
						</label>
					</td>
					<td class="value">
					     	 <input id="shuichandi" name="shuichandi" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">产地</label>-->
						</td>
					<td align="right">
						<label class="Validform_label">
							生产厂家:
						</label>
					</td>
					<td class="value">
					     	 <input id="shuiscchangjia" name="shuiscchangjia" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">生产厂家</label>-->
						</td>
					</tr>
					
					
			<!-- 规格型号 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							规格:
						</label>
					</td>
					<td class="value"><select id="shuiguige" name="shuiguige" datatype="*" onchange="qh(this.value,'shuixinghao')"> 
						<c:forEach items="${List}" var="depart">
							<option value="${depart.selectkey }" <c:if test="${depart.id==guige}">selected="selected"</c:if> onclick="">${depart.selectkey}</option>
						</c:forEach>
						</select>
						<span class="Validform_checktip"><font color="red">*必选*</font></span> 
							<label class="Validform_label" style="display: none;">请选择规格</label>
						 </td>
					<td align="right">
						<label class="Validform_label">
							型号:
						</label>
						</td>
					<td class="value">
					     	<select id="shuixinghao" name="shuixinghao" datatype="*">
						<c:forEach items="${sList}" var="depart">
							<option value="${depart.mselectkey }" <c:if test="${depart.id==xinghao}">selected="selected"</c:if> onclick="">${depart.mselectkey}</option>
						</c:forEach>
						</select>
						<span class="Validform_checktip"><font color="red">*必选*</font></span> 
							<label class="Validform_label" style="display: none;">请选择型号</label>
						
						</td>
						</td>
					</tr>
				<!-- 进场数量、产品批号 -->	
				<tr>
					<td align="right">
						<label class="Validform_label">
							进场数量(t):
						</label>
					</td>
					<td class="value">
					     	 <input id="shuijcshuliang" name="shuijcshuliang" type="text" style="width: 150px" class="inputxt"  
								 value="0"               
								               >
							<span class="Validform_checktip"><font color="red">*必填数字*</font></span> 
							<label class="Validform_label" style="display: none;">进场数量(t)</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							产品批号:
						</label>
					</td>
					<td class="value">
					     	 <input id="shuipicihao" name="shuipicihao" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">产品批号</label>-->
						</td>
					</tr>
					
					<!-- 拟使用工程部位、取样日期 -->	
				<tr>
					<td align="right">
						<label class="Validform_label">
							拟使用工程部位:
						</label>
					</td>
					<td class="value">
					     	 <input id="shuisyxingmu" name="shuisyxingmu" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">拟使用工程部位</label>-->
						</td>
					<td align="right">
						<label class="Validform_label">
							取样时间:
						</label>
					</td>
					<td class="value">
					     	<!--  <input id="qyshijian" name="qyshijian" type="text" style="width: 150px" class="inputxt"  
								               > -->
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="shuiqyshijian" name="shuiqyshijian"
				value="${time}" datatype="*">  
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">取样日期</label>-->
						</td>
					</tr>
					
				<!-- 样品编号、报告日期 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							样品编号:
						</label>
					</td>
					<td class="value"> <input id="shuiycl11" name="shuiycl11" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">样品编号</label>-->
							</td>
					<td align="right">
						<label class="Validform_label">
							报告时间:
						</label>
						</td>
					<td class="value">
					     	<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="shuiycl12" name="shuiycl12"
				value="${time}" datatype="*"> 
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">报告日期</label> -->
						</td>
					</tr>	
					<!-- 报告编号 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							报告编号:
						</label>
					</td>
					<td class="value"> <input id="shuibgbianhao" name="shuibgbianhao" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="red">*必填*</font></span>
							<!--<label class="Validform_label" style="display: none;">报告编号</label>-->
							</td>
							<td align="right">
						<label class="Validform_label">
							存储地点:
						</label>
					</td>
					<td class="value"> <input id="shuicunchudidian" name="shuicunchudidian" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="red">*必填*</font></span> 
							<label class="Validform_label" style="display: none;">存储地点</label>
							</td>	
					</tr>	
					
					<tr>
								<td align="right"><label class="Validform_label">入库时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="shuirukushijian" name="shuirukushijian" datatype="*" value="${time}" >  
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">入库时间</label></td>
								<td align="right"><label class="Validform_label">试验时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="shuisyshijian" name="shuisyshijian"  datatype="*"  value="${time}"> 
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">试验时间</label></td>
						</tr>
						
						<tr>
								<td align="right"><label class="Validform_label">批次:</label></td>
								<td class="value"><input id="shuipici" name="shuipici" type="text" style="width: 150px" class="inputxt"    >
									<span class="Validform_checktip"><font color="red">*必选*</font><label class="Validform_label" style="display: none;">批次</label></td>
								<td></td>
								<td></td>
						</tr>
					
					<!-- 密度/比表面积 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							pH:
						</label>
					</td>
					<td class="value"> <input id="shuiycl1" name="shuiycl1" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">pH</label>
							</td>
								<td align="right">
						<label class="Validform_label">
							不溶物(mg/L):
						</label>
					</td>
					<td class="value"> <input id="shuiycl2" name="shuiycl2" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">不溶物(mg/L)</label>
							</td>
					</tr>	
					
					
					<!-- 标准稠度用水量/初凝时间-->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							可溶物(mg/L):
						</label>
					</td>
					<td class="value"> <input id="shuiycl3" name="shuiycl3" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">可溶物</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							氯化物（Cl-计）(mg/L):
						</label>
					</td>
					<td class="value"> <input id="shuiycl4" name="shuiycl4" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">氯化物（Cl-计）</label>
							</td>
					</tr>
					
					<!-- 终凝试件/比表面积 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							硫酸盐（SO42-计）(mg/L):
						</label>
					</td>
					<td class="value"> <input id="shuiycl5" name="shuiycl5" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"<font color="#9C9C9C">*数字*</font>></span> 
							<label class="Validform_label" style="display: none;">硫酸盐（SO42-计）</label>
							</td>
							
						<td align="center"></td>
								<td class="value"></td>	
					</tr>
					
					
					<!-- 检测结论/试验人员-->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							检测结论:
						</label>
					</td>
					<td class="value"> <select id="shuiycl0" name="shuiycl0" datatype="*">	
								<option value="合格" >合格</option>
								<option value="不合格" >不合格</option>	  
								</select>	 
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">检测结论</label>-->
							</td>
					
						<td align="right">
						<label class="Validform_label">
							试验人员:
						</label>
					</td>
					<td class="value"> <input id="shuishiyanren" name="shuishiyanren" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">试验人员</label>
							</td>
					</tr>
					
					<!-- <tr>
					
						<td align="right">
						<label class="Validform_label">
							标记:
						</label>
					</td>
					<td class="value"> <input id="shuibiaoji" name="shuibiaoji" type="text" style="width: 150px" class="inputxt"  
								     value="0"     readonly="readonly"     >
								     <select id="shuibiaoji" name="shuibiaoji" datatype="*">	
								<option value="0">0</option>
								<option value="1" >1</option>	  </select>	 
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">试验人员</label>
							</td>
						<td align="center"></td>
								<td class="value"></td>	
					</tr> -->
					
					</table>
					</div>
					 
					
					<div id="waijiaji" style="display:none;">
					<table cellpadding="0" cellspacing="1" class="formtable">
					<tr>
									<td align="right">
								<label class="Validform_label">
									材料名称:
								</label>
							</td>
							<td class="value"> <input id="waijiajimingcheng" name="waijiajimingcheng" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">材料名称</label>-->
							</td>
							<td align="right">标段部门</td>
							<td class="value"><%-- <input id="ff"  value="${depart.TSPDepart.departname}">
								<span class="Validform_checktip"><font color="red">*必选*</font></span> 
								<input id="wjjtspdepartId" name="wjjtspdepartId" style="display: none;"
								value="${depart.TSPDepart.id}"></div> --%>
								<select id="wjjtspdepartId" name="wjjtspdepartId" style="height:24px;width:120px;" datatype="*" errormsg="该字段不为空">
										<c:forEach items="${departlist}" var="lilun">
											<option value="${lilun.id}" >${lilun.departname}</option>
										</c:forEach>
									</select>
							</td>
						</tr>
														<!-- 产地、厂家 -->		
			<tr>
					<td align="right">
						<label class="Validform_label">
							产地:
						</label>
					</td>
					<td class="value">
					     	 <input id="waijiajichandi" name="waijiajichandi" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">产地</label>-->
						</td>
					<td align="right">
						<label class="Validform_label">
							生产厂家:
						</label>
					</td>
					<td class="value">
					     	 <input id="waijiajiscchangjia" name="waijiajiscchangjia" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">生产厂家</label>-->
						</td>
					</tr>
					
					
			<!-- 规格型号 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							规格:
						</label>
					</td>
					<td class="value"><select id="waijiajiguige" name="waijiajiguige" datatype="*" onchange="qh(this.value,'waijiajixinghao')">
						<c:forEach items="${List}" var="depart">
							<option value="${depart.selectkey }" <c:if test="${depart.id==guige}">selected="selected"</c:if> onclick="">${depart.selectkey}</option>
						</c:forEach>
						</select>
						<span class="Validform_checktip"><font color="red">*必选*</font></span> 
							<label class="Validform_label" style="display: none;">请选择规格</label>
						 </td>
					<td align="right">
						<label class="Validform_label">
							型号:
						</label>
						</td>
					<td class="value">
					     	<select id="waijiajixinghao" name="waijiajixinghao" datatype="*">
						<c:forEach items="${sList}" var="depart">
							<option value="${depart.mselectkey }" <c:if test="${depart.id==xinghao}">selected="selected"</c:if> onclick="">${depart.mselectkey}</option>
						</c:forEach>
						</select>
						<span class="Validform_checktip"><font color="red">*必选*</font></span> 
							<label class="Validform_label" style="display: none;">请选择型号</label>
						
						</td>
						</td>
					</tr>
				<!-- 进场数量、产品批号 -->	
				<tr>
					<td align="right">
						<label class="Validform_label">
							进场数量(t):
						</label>
					</td>
					<td class="value">
					     	 <input id="waijiajijcshuliang" name="waijiajijcshuliang" type="text" style="width: 150px" class="inputxt"  
								  value="0"              
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<!--<label class="Validform_label" style="display: none;">进场数量(t)</label>-->
						</td>
					<td align="right">
						<label class="Validform_label">
							产品批号:
						</label>
					</td>
					<td class="value">
					     	 <input id="waijiajipicihao" name="waijiajipicihao" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">产品批号</label>-->
						</td>
					</tr>
					
					<!-- 拟使用工程部位、取样日期 -->	
				<tr>
					<td align="right">
						<label class="Validform_label">
							拟使用工程部位:
						</label>
					</td>
					<td class="value">
					     	 <input id="waijiajisyxingmu" name="waijiajisyxingmu" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">拟使用工程部位</label>-->
						</td>
					<td align="right">
						<label class="Validform_label">
							取样时间:
						</label>
					</td>
					<td class="value">
					     	<!--  <input id="qyshijian" name="qyshijian" type="text" style="width: 150px" class="inputxt"  
								               > -->
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="waijiajiqyshijian" name="waijiajiqyshijian"
				value="${time}" datatype="*">  
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">取样日期</label>-->
						</td>
					</tr>
					
				<!-- 样品编号、报告日期 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							样品编号:
						</label>
					</td>
					<td class="value"> <input id="waijiajiycl11" name="waijiajiycl11" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">样品编号</label>-->
							</td>
					<td align="right">
						<label class="Validform_label">
							报告时间:
						</label>
						</td>
					<td class="value">
					     	<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="waijiajiycl12" name="waijiajiycl12"
				value="${time}" datatype="*"> 
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">报告日期</label> -->
						</td>
					</tr>	
					<!-- 报告编号 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							报告编号:
						</label>
					</td>
					<td class="value"> <input id="waijiajibgbianhao" name="waijiajibgbianhao" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="red">*必填*</font></span>
							<!--<label class="Validform_label" style="display: none;">报告编号</label>-->
							</td>
							<td align="right">
						<label class="Validform_label">
							存储地点:
						</label>
					</td>
					<td class="value"> <input id="waijiajicunchudidian" name="waijiajicunchudidian" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="red">*必填*</font></span>
							<label class="Validform_label" style="display: none;">存储地点</label>
							</td>
					</tr>	
					
					
					<tr>
								<td align="right"><label class="Validform_label">入库时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="waijiajirukushijian" name="waijiajirukushijian" datatype="*" value="${time}" >  
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">入库时间</label></td>
								<td align="right"><label class="Validform_label">试验时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="waijiajisyshijian" name="waijiajisyshijian"  datatype="*"  value="${time}"> 
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">试验时间</label></td>
						</tr>
						
						<tr>
								<td align="right"><label class="Validform_label">批次:</label></td>
								<td class="value"><input id="waijiajipici" name="waijiajipici" type="text" style="width: 150px" class="inputxt"    >
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">批次</label></td>
								<td></td>
								<td></td>
						</tr>
					
					<!-- 密度/比表面积 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							减水率(%):
						</label>
					</td>
					<td class="value"> <input id="waijiajiycl1" name="waijiajiycl1" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">pH</label>
							</td>
								<td align="right">
						<label class="Validform_label">
							含气量(%):
						</label>
					</td>
					<td class="value"> <input id="waijiajiycl2" name="waijiajiycl2" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">不溶物(mg/L)</label>
							</td>
					</tr>	
					
					
					<!-- 标准稠度用水量/初凝时间-->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							泌水率比(%):
						</label>
					</td>
					<td class="value"> <input id="waijiajiycl3" name="waijiajiycl3" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">可溶物</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							初凝时间差(min):
						</label>
					</td>
					<td class="value"> <input id="waijiajiycl4" name="waijiajiycl4" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">氯化物（Cl-计）</label>
							</td>
					</tr>
					
					<!-- 终凝试件/比表面积 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							终凝时间差(min):
						</label>
					</td>
					<td class="value"> <input id="waijiajiycl5" name="waijiajiycl5" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">硫酸盐（SO42-计）</label>
							</td>
							
						<td align="right">
						<label class="Validform_label">
							28d抗压强度比(%):
						</label>
					</td>
					<td class="value"> <input id="waijiajiycl6" name="waijiajiycl6" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">硫酸盐（SO42-计）</label>
							</td>
							
					
					</tr>
					
					
					<tr>
						<td align="right">
						<label class="Validform_label">
							28d收缩率比(%):
						</label>
					</td>
					<td class="value"> <input id="waijiajiycl7" name="waijiajiycl7" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="#9C9C9C">*数字*</font></span> 
							<label class="Validform_label" style="display: none;">硫酸盐（SO42-计）</label>
							</td>
						<td align="center"></td>
								<td class="value"></td>	
					</tr>
					
					
					<!-- 检测结论/试验人员-->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							检测结论:
						</label>
					</td>
					<td class="value"> <select id="waijiajiycl0" name="waijiajiycl0" datatype="*">	
								<option value="合格" >合格</option>
								<option value="不合格" >不合格</option>	  
								</select>	 
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">检测结论</label>-->
							</td>
					
						<td align="right">
						<label class="Validform_label">
							试验人员:
						</label>
					</td>
					<td class="value"> <input id="waijiajishiyanren" name="waijiajishiyanren" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">试验人员</label>
							</td>
					</tr>
					
				<!-- 	<tr>
					
						<td align="right">
						<label class="Validform_label">
							标记:
						</label>
					</td>
					<td class="value"> <input id="waijiajibiaoji" name="waijiajibiaoji" type="text" style="width: 150px" class="inputxt"  
								     value="0"    readonly="readonly"      >
								     <select id="waijiajibiaoji" name="waijiajibiaoji" datatype="*">	
								<option value="0">0</option>
								<option value="1" >1</option>	  </select>	 
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">试验人员</label>
							</td>
						<td align="center"></td>
								<td class="value"></td>	
					</tr> -->
					
					</table>
					</div>
					
					 
					<div id="qita" style="display:none;">
					<table cellpadding="0" cellspacing="1" class="formtable">
					<tr>
									<td align="right">
								<label class="Validform_label">
									材料名称:
								</label>
							</td>
							<td class="value"> <input id="qita.mingcheng" name="qita.mingcheng" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">材料名称</label>-->
							</td>
							<td align="right">标段部门</td>
							<td class="value"><%-- <input id="hh"  value="${depart.TSPDepart.departname}">
								<span class="Validform_checktip"><font color="red">*必选*</font>
								<input id="qttspdepartId" name="qttspdepartId" style="display: none;"
								value="${depart.TSPDepart.id}"></div> --%>
								<select id="qttspdepartId" name="qttspdepartId" style="height:24px;width:120px;" datatype="*" errormsg="该字段不为空">
										<c:forEach items="${departlist}" var="lilun">
											<option value="${lilun.id}" >${lilun.departname}</option>
										</c:forEach>
									</select>
							</td>
						</tr>
					<!-- 产地、厂家 -->		
			<tr>
					<td align="right">
						<label class="Validform_label">
							产地:
						</label>
					</td>
					<td class="value">
					     	 <input id="qita.chandi" name="qita.chandi" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">产地</label>-->
						</td>
					<td align="right">
						<label class="Validform_label">
							生产厂家:
						</label>
					</td>
					<td class="value">
					     	 <input id="qita.scchangjia" name="qita.scchangjia" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">生产厂家</label>-->
						</td>
					</tr>
					
					
			<!-- 规格型号 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							规格:
						</label>
					</td>
					<td class="value"><select id="qita.guige" name="qita.guige" datatype="*" onchange="qh(this.value,'qitaxinghao')">
						<c:forEach items="${List}" var="depart">
							<option value="${depart.selectkey }" <c:if test="${depart.id==guige}">selected="selected"</c:if> onclick="">${depart.selectkey}</option>
						</c:forEach>
						</select>
						<span class="Validform_checktip"><font color="red">*必选*</font></span> 
							<label class="Validform_label" style="display: none;">请选择规格</label>
						 </td>
					<td align="right">
						<label class="Validform_label">
							型号:
						</label>
						</td>
					<td class="value">
					     	<select id="qitaxinghao" name="qita.xinghao" datatype="*">
						<c:forEach items="${sList}" var="depart">
							<option value="${depart.mselectkey }" <c:if test="${depart.id==xinghao}">selected="selected"</c:if> onclick="">${depart.mselectkey}</option>
						</c:forEach>
						</select>
						<span class="Validform_checktip"><font color="red">*必选*</font></span> 
							<label class="Validform_label" style="display: none;">请选择型号</label>
						
						</td>
						</td>
					</tr>
				<!-- 进场数量、产品批号 -->	
				<tr>
					<td align="right">
						<label class="Validform_label">
							进场数量(t):
						</label>
					</td>
					<td class="value">
					     	 <input id="qita.jcshuliang" name="qita.jcshuliang" type="text" style="width: 150px" class="inputxt"  
								 value="0"               
								               >
							<span class="Validform_checktip"><font color="red">*必填数字*</font></span> 
							<label class="Validform_label" style="display: none;">进场数量(t)</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							产品批号:
						</label>
					</td>
					<td class="value">
					     	 <input id="qita.picihao" name="qita.picihao" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">产品批号</label>-->
						</td>
					</tr>
					
					<!-- 拟使用工程部位、取样日期 -->	
				<tr>
					<td align="right">
						<label class="Validform_label">
							拟使用工程部位:
						</label>
					</td>
					<td class="value">
					     	 <input id="qita.syxingmu" name="qita.syxingmu" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">拟使用工程部位</label>-->
						</td>
					<td align="right">
						<label class="Validform_label">
							取样时间:
						</label>
					</td>
					<td class="value">
					     	<!--  <input id="qyshijian" name="qyshijian" type="text" style="width: 150px" class="inputxt"  
								               > -->
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="qita.qyshijian" name="qita.qyshijian"
				value="${time}" datatype="*">  
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">取样日期</label>-->
						</td>
					</tr>
					
				<!-- 样品编号、报告日期 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							样品编号:
						</label>
					</td>
					<td class="value"> <input id="qita.ycl11" name="qita.ycl11" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">样品编号</label>-->
							</td>
					<td align="right">
						<label class="Validform_label">
							报告时间:
						</label>
						</td>
					<td class="value">
					     	<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="qita.ycl12" name="qita.ycl12"
				value="${time}" datatype="*"> 
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">报告日期</label> -->
						</td>
					</tr>	
					<!-- 报告编号 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							报告编号:
						</label>
					</td>
					<td class="value"> <input id="qita.bgbianhao" name="qita.bgbianhao" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!--<label class="Validform_label" style="display: none;">报告编号</label>-->
							</td>
						<td align="right">
						<label class="Validform_label">
							存储地点:
						</label>
					</td>
					<td class="value"> <input id="qita.cunchudidian" name="qita.cunchudidian" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"><font color="red">*必选*</font>
							<label class="Validform_label" style="display: none;">存储地点</label>
							</td>
					</tr>	
					
					
					<tr>
								<td align="right"><label class="Validform_label">入库时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="qita.rukushijian" name="qita.rukushijian" datatype="*" value="${time}" >  
									<span class="Validform_checktip"><font color="red">*必选*</font><label class="Validform_label" style="display: none;">入库时间</label></td>
								<td align="right"><label class="Validform_label">试验时间:</label></td>
								<td class="value"><input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px" id="qita.syshijian" name="qita.syshijian"  datatype="*"  value="${time}"> 
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">试验时间</label></td>
						</tr>
						
						<tr>
								<td align="right"><label class="Validform_label">批次:</label></td>
								<td class="value"><input id="qita.pici" name="qita.pici" type="text" style="width: 150px" class="inputxt"    >
									<span class="Validform_checktip"><font color="red">*必选*</font></span> <label class="Validform_label" style="display: none;">批次</label></td>
								<td></td>
								<td></td>
						</tr>
					
					
					<!-- 密度/比表面积 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							检测结果1:
						</label>
					</td>
					<td class="value"> <input id="qita.ycl1" name="qita.ycl1" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!-- <label class="Validform_label" style="display: none;">检测结果1</label> -->
							</td>
					
						<td align="right">
						<label class="Validform_label">
							检测结果2:
						</label>
					</td>
					<td class="value"> <input id="qita.ycl2" name="qita.ycl2" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<!-- <label class="Validform_label" style="display: none;">检测结果2</label> -->
							</td>
					</tr>	
					
					
					<!-- 标准稠度用水量/初凝时间-->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							检测结果3:
						</label>
					</td>
					<td class="value"> <input id="qita.ycl3" name="qita.ycl3" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">检测结果3</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							检测结果4:
						</label>
					</td>
					<td class="value"> <input id="qita.ycl4" name="qita.ycl4" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">检测结果4</label>
							</td>
					</tr>
					
					<!-- 终凝试件/比表面积 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							检测结果5:
						</label>
					</td>
					<td class="value"> <input id="qita.ycl5" name="qita.ycl5" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">检测结果5</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							检测结果6:
						</label>
					</td>
					<td class="value">   <input id="qita.ycl6" name="qita.ycl6" type="text" style="width: 150px" class="inputxt"  
								               >  
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">检测结果6</label>
							</td>
					</tr>
					<!-- 3d抗折强度/3d抗压强度 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							检测结果7:
						</label>
					</td>
					<td class="value"> <input id="qita.ycl7" name="qita.ycl7" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">检测结果7</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							检测结果8:
						</label>
					</td>
					<td class="value"> <input id="qita.ycl8" name="qita.ycl8" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">检测结果8</label>
							</td>
					</tr>
					<!-- 28d抗折强度/28d抗压强度 -->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							检测结果9:
						</label>
					</td>
					<td class="value"> <input id="qita.ycl9" name="qita.ycl9" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">检测结果9</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							检测结果10:
						</label>
					</td>
					<td class="value"> <input id="qita.ycl10" name="qita.ycl10" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">检测结果10</label>
							</td>
					</tr>
					
					
					<!-- 检测结论/试验人员-->			
					<tr>
						<td align="right">
						<label class="Validform_label">
							检测结论:
						</label>
					</td>
					<td class="value"> <select id="qita.ycl0" name="qita.ycl0" datatype="*">	
								<option value="合格">合格</option>
								<option value="不合格">不合格</option>	  </select>	 
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">检测结论</label>
							</td>
					
						<td align="right">
						<label class="Validform_label">
							试验人员:
						</label>
					</td>
					<td class="value"> <input id="qita.shiyanren" name="qita.shiyanren" type="text" style="width: 150px" class="inputxt"  
								               >
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">试验人员</label>
							</td>
					</tr>
					
					
					<!-- <tr>
					
						<td align="right">
						<label class="Validform_label">
							标记:
						</label>
					</td>
					<td class="value"> <input id="qita.biaoji" name="qita.biaoji" type="text" style="width: 150px" class="inputxt"  
								     value="0"    readonly="readonly"     >
								     <select id="qita.biaoji" name="qita.biaoji" datatype="*">	
								<option value="0">0</option>
								<option value="1" >1</option>	  </select>	 
							<span class="Validform_checktip"></span> 
							<label class="Validform_label" style="display: none;">试验人员</label>
							</td>
						<td align="center"></td>
								<td class="value"></td>	
					</tr> -->
					</table>
					</div>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/shtoone/qms/bhz/sYclAll.js"></script>		