<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="hntbhzziduancfgList" title="水泥混凝土报警配置" actionUrl="hntbhzziduancfgViewController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>

   <t:dgCol title="拌和站名称" field="banhezhanminchen" frozenColumn="true"></t:dgCol>
   <t:dgCol title="baocunshijian" field="baocunshijian" ></t:dgCol>
   <t:dgCol title="chaozuozhe" field="chaozuozhe" ></t:dgCol>
   <t:dgCol title="chuliaoshijian" field="chuliaoshijian" ></t:dgCol>
   <t:dgCol title="feimeihui4_lilunzhi" field="feimeihui4_lilunzhi" ></t:dgCol>
   <t:dgCol title="feimeihui4_shijizhi" field="feimeihui4_shijizhi" ></t:dgCol>
   <t:dgCol title="fenliao5_lilunzhi" field="fenliao5_lilunzhi" ></t:dgCol>
   <t:dgCol title="fenliao5_shijizhi" field="fenliao5_shijizhi" ></t:dgCol>
   <t:dgCol title="fenliao6_lilunzhi" field="fenliao6_lilunzhi" ></t:dgCol>
   <t:dgCol title="fenliao6_shijizhi" field="fenliao6_shijizhi" ></t:dgCol>
   <t:dgCol title="gongchengmingcheng" field="gongchengmingcheng" ></t:dgCol>
   <t:dgCol title="gongdanhao" field="gongdanhao" ></t:dgCol>
   <t:dgCol title="gprsbianhao" field="gprsbianhao" ></t:dgCol>
   <t:dgCol title="guliao5_lilunzhi" field="guliao5_lilunzhi" ></t:dgCol>
   <t:dgCol title="guliao5_shijizhi" field="guliao5_shijizhi" ></t:dgCol>
   <t:dgCol title="jiaobanshijian" field="jiaobanshijian" ></t:dgCol>
   <t:dgCol title="jiaozuobuwei" field="jiaozuobuwei" ></t:dgCol>
   <t:dgCol title="kuangfen3_lilunzhi" field="kuangfen3_lilunzhi" ></t:dgCol>
   <t:dgCol title="kuangfen3_shijizhi" field="kuangfen3_shijizhi" ></t:dgCol>
   <t:dgCol title="peifanghao" field="peifanghao" ></t:dgCol>
   <t:dgCol title="qiangdudengji" field="qiangdudengji" ></t:dgCol>
   <t:dgCol title="sha1_lilunzhi" field="sha1_lilunzhi" ></t:dgCol>
   <t:dgCol title="sha1_shijizhi" field="sha1_shijizhi" ></t:dgCol>
   <t:dgCol title="sha2_lilunzhi" field="sha2_lilunzhi" ></t:dgCol>
   <t:dgCol title="sha2_shijizhi" field="sha2_shijizhi" ></t:dgCol>
   <t:dgCol title="shebeibianhao" field="shebeibianhao" ></t:dgCol>
   <t:dgCol title="shi1_lilunzhi" field="shi1_lilunzhi" ></t:dgCol>
   <t:dgCol title="shi1_shijizhi" field="shi1_shijizhi" ></t:dgCol>
   <t:dgCol title="shi2_lilunzhi" field="shi2_lilunzhi" ></t:dgCol>
   <t:dgCol title="shi2_shijizhi" field="shi2_shijizhi" ></t:dgCol>
   <t:dgCol title="shui1_lilunzhi" field="shui1_lilunzhi" ></t:dgCol>
   <t:dgCol title="shui1_shijizhi" field="shui1_shijizhi" ></t:dgCol>
   <t:dgCol title="shui2_lilunzhi" field="shui2_lilunzhi" ></t:dgCol>
   <t:dgCol title="shui2_shijizhi" field="shui2_shijizhi" ></t:dgCol>
   <t:dgCol title="shuini1_lilunzhi" field="shuini1_lilunzhi" ></t:dgCol>
   <t:dgCol title="shuini1_shijizhi" field="shuini1_shijizhi" ></t:dgCol>
   <t:dgCol title="shuini2_lilunzhi" field="shuini2_lilunzhi" ></t:dgCol>
   <t:dgCol title="shuini2_shijizhi" field="shuini2_shijizhi" ></t:dgCol>
   <t:dgCol title="shuinipingzhong" field="shuinipingzhong" ></t:dgCol>
   <t:dgCol title="sigongdidian" field="sigongdidian" ></t:dgCol>
   <t:dgCol title="waijiaji1_lilunzhi" field="waijiaji1_lilunzhi" ></t:dgCol>
   <t:dgCol title="waijiaji1_shijizhi" field="waijiaji1_shijizhi" ></t:dgCol>
   <t:dgCol title="waijiaji2_lilunzhi" field="waijiaji2_lilunzhi" ></t:dgCol>
   <t:dgCol title="waijiaji2_shijizhi" field="waijiaji2_shijizhi" ></t:dgCol>
   <t:dgCol title="waijiaji3_lilunzhi" field="waijiaji3_lilunzhi" ></t:dgCol>
   <t:dgCol title="waijiaji3_shijizhi" field="waijiaji3_shijizhi" ></t:dgCol>
   <t:dgCol title="waijiaji4_lilunzhi" field="waijiaji4_lilunzhi" ></t:dgCol>
   <t:dgCol title="waijiaji4_shijizhi" field="waijiaji4_shijizhi" ></t:dgCol>
   <t:dgCol title="waijiajipingzhong" field="waijiajipingzhong" ></t:dgCol>
   <t:dgCol title="leixin" field="leixin" ></t:dgCol>
   <t:dgCol title="caijishijian" field="caijishijian" ></t:dgCol>
   <t:dgCol title="gujifangshu" field="gujifangshu" ></t:dgCol>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="hntbhzziduancfgViewController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="hntbhzziduancfgViewController.do?addorupdate&defaultId=0" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hntbhzziduancfgViewController.do?addorupdate&defaultId=0" funname="update"></t:dgToolBar>
   <t:dgToolBar title="默认值" icon="icon-edit" url="hntbhzziduancfgViewController.do?addorupdate&defaultId=1" funname="add"></t:dgToolBar>
   <%--
   <t:dgToolBar title="查看" icon="icon-search" url="hntbhzziduancfgController.do?addorupdate" funname="detail"></t:dgToolBar>
    --%>
  </t:datagrid>
  
  <div id="logListtb" style="padding: 3px; height: 30px"><!-- update---Author:赵俊夫  Date:20130507 for：需要加name=searchColums属性 -->
<div name="searchColums" style="float: left; padding-right: 15px;">
<table>
	<tr>
		<td align="left">所属机构</td>
		<td><input id="cchntbheziduancfgList"  value="${depart.TSPDepart.departname}" style="height:27px;width:180px;">
			<div><input id="cchntbheziduancfgListtspdepartId" name="departid" style="display: none;" value="${depart.TSPDepart.id}"></div>
		</td>
		<td><select id="hntbhzziduancfgListshebeibianhao" name="shebeibianhao"  style="height:27px;width:180px;"></select></td>
		<td rowspan="2" align="right"><a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="hntbhzziduancfgListsearch();" >查询</a></td>
		</tr>
</table>
</div>
<script type="text/javascript" src="js/banhezhanxinxi.js" charset="UTF-8"></script>
 <script type="text/javascript">
 $(function() {
		$('#cchntbheziduancfgList').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}&type=1',
			onClick: function(node){
				$("#cchntbheziduancfgListtspdepartId").val(node.id);
				banhezhanxinxiSelect(node.id,"hntbhzziduancfgListshebeibianhao","1");
			}
		});
		banhezhanxinxiSelect("","hntbhzziduancfgListshebeibianhao","1");
	});
</script>


  </div>
 </div>
