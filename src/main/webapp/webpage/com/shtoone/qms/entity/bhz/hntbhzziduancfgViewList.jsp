<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="hntbhzziduancfgViewList" title="水泥混凝土字段及报警配置视图" actionUrl="hntbhzziduancfgViewController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="baocunshijian" field="baocunshijian" ></t:dgCol>
   <t:dgCol title="chaozuozhe" field="chaozuozhe" ></t:dgCol>
   <t:dgCol title="chuliaoshijian" field="chuliaoshijian" ></t:dgCol>
   <t:dgCol title="feimeihui4Lilunzhi" field="feimeihui4Lilunzhi" ></t:dgCol>
   <t:dgCol title="feimeihui4Shijizhi" field="feimeihui4Shijizhi" ></t:dgCol>
   <t:dgCol title="fenliao5Lilunzhi" field="fenliao5Lilunzhi" ></t:dgCol>
   <t:dgCol title="fenliao5Shijizhi" field="fenliao5Shijizhi" ></t:dgCol>
   <t:dgCol title="fenliao6Lilunzhi" field="fenliao6Lilunzhi" ></t:dgCol>
   <t:dgCol title="fenliao6Shijizhi" field="fenliao6Shijizhi" ></t:dgCol>
   <t:dgCol title="gongchengmingcheng" field="gongchengmingcheng" ></t:dgCol>
   <t:dgCol title="gongdanhao" field="gongdanhao" ></t:dgCol>
   <t:dgCol title="gprsbianhao" field="gprsbianhao" ></t:dgCol>
   <t:dgCol title="guliao5Lilunzhi" field="guliao5Lilunzhi" ></t:dgCol>
   <t:dgCol title="guliao5Shijizhi" field="guliao5Shijizhi" ></t:dgCol>
   <t:dgCol title="jiaobanshijian" field="jiaobanshijian" ></t:dgCol>
   <t:dgCol title="jiaozuobuwei" field="jiaozuobuwei" ></t:dgCol>
   <t:dgCol title="kuangfen3Lilunzhi" field="kuangfen3Lilunzhi" ></t:dgCol>
   <t:dgCol title="kuangfen3Shijizhi" field="kuangfen3Shijizhi" ></t:dgCol>
   <t:dgCol title="peifanghao" field="peifanghao" ></t:dgCol>
   <t:dgCol title="qiangdudengji" field="qiangdudengji" ></t:dgCol>
   <t:dgCol title="sha1Lilunzhi" field="sha1Lilunzhi" ></t:dgCol>
   <t:dgCol title="sha1Shijizhi" field="sha1Shijizhi" ></t:dgCol>
   <t:dgCol title="sha2Lilunzhi" field="sha2Lilunzhi" ></t:dgCol>
   <t:dgCol title="sha2Shijizhi" field="sha2Shijizhi" ></t:dgCol>
   <t:dgCol title="shebeibianhao" field="shebeibianhao" ></t:dgCol>
   <t:dgCol title="shi1Lilunzhi" field="shi1Lilunzhi" ></t:dgCol>
   <t:dgCol title="shi1Shijizhi" field="shi1Shijizhi" ></t:dgCol>
   <t:dgCol title="shi2Lilunzhi" field="shi2Lilunzhi" ></t:dgCol>
   <t:dgCol title="shi2Shijizhi" field="shi2Shijizhi" ></t:dgCol>
   <t:dgCol title="shui1Lilunzhi" field="shui1Lilunzhi" ></t:dgCol>
   <t:dgCol title="shui1Shijizhi" field="shui1Shijizhi" ></t:dgCol>
   <t:dgCol title="shui2Lilunzhi" field="shui2Lilunzhi" ></t:dgCol>
   <t:dgCol title="shui2Shijizhi" field="shui2Shijizhi" ></t:dgCol>
   <t:dgCol title="shuini1Lilunzhi" field="shuini1Lilunzhi" ></t:dgCol>
   <t:dgCol title="shuini1Shijizhi" field="shuini1Shijizhi" ></t:dgCol>
   <t:dgCol title="shuini2Lilunzhi" field="shuini2Lilunzhi" ></t:dgCol>
   <t:dgCol title="shuini2Shijizhi" field="shuini2Shijizhi" ></t:dgCol>
   <t:dgCol title="shuinipingzhong" field="shuinipingzhong" ></t:dgCol>
   <t:dgCol title="sigongdidian" field="sigongdidian" ></t:dgCol>
   <t:dgCol title="waijiaji1Lilunzhi" field="waijiaji1Lilunzhi" ></t:dgCol>
   <t:dgCol title="waijiaji1Shijizhi" field="waijiaji1Shijizhi" ></t:dgCol>
   <t:dgCol title="waijiaji2Lilunzhi" field="waijiaji2Lilunzhi" ></t:dgCol>
   <t:dgCol title="waijiaji2Shijizhi" field="waijiaji2Shijizhi" ></t:dgCol>
   <t:dgCol title="waijiaji3Lilunzhi" field="waijiaji3Lilunzhi" ></t:dgCol>
   <t:dgCol title="waijiaji3Shijizhi" field="waijiaji3Shijizhi" ></t:dgCol>
   <t:dgCol title="waijiaji4Lilunzhi" field="waijiaji4Lilunzhi" ></t:dgCol>
   <t:dgCol title="waijiaji4Shijizhi" field="waijiaji4Shijizhi" ></t:dgCol>
   <t:dgCol title="waijiajipingzhong" field="waijiajipingzhong" ></t:dgCol>
   <t:dgCol title="leixin" field="leixin" ></t:dgCol>
   <t:dgCol title="caijishijian" field="caijishijian" ></t:dgCol>
   <t:dgCol title="gujifangshu" field="gujifangshu" ></t:dgCol>
   <t:dgCol title="banhezhanminchen" field="banhezhanminchen" ></t:dgCol>
   <t:dgCol title="jianchen" field="jianchen" ></t:dgCol>
   <t:dgCol title="smsbaojin" field="smsbaojin" ></t:dgCol>
   <t:dgCol title="departid" field="departid" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hntbhzziduancfgViewController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="hntbhzziduancfgViewController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hntbhzziduancfgViewController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hntbhzziduancfgViewController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>