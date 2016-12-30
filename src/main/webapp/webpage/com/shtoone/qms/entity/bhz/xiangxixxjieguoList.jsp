<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="xiangxixxjieguoList" title="水泥混凝土超标结果表" actionUrl="xiangxixxjieguoController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="sha1Shijizhi" field="sha1Shijizhi" ></t:dgCol>
   <t:dgCol title="shi1Shijizhi" field="shi1Shijizhi" ></t:dgCol>
   <t:dgCol title="shi2Shijizhi" field="shi2Shijizhi" ></t:dgCol>
   <t:dgCol title="sha2Shijizhi" field="sha2Shijizhi" ></t:dgCol>
   <t:dgCol title="guliao5Shijizhi" field="guliao5Shijizhi" ></t:dgCol>
   <t:dgCol title="shuini1Shijizhi" field="shuini1Shijizhi" ></t:dgCol>
   <t:dgCol title="shuini2Shijizhi" field="shuini2Shijizhi" ></t:dgCol>
   <t:dgCol title="kuangfen3Shijizhi" field="kuangfen3Shijizhi" ></t:dgCol>
   <t:dgCol title="feimeihui4Shijizhi" field="feimeihui4Shijizhi" ></t:dgCol>
   <t:dgCol title="fenliao5Shijizhi" field="fenliao5Shijizhi" ></t:dgCol>
   <t:dgCol title="fenliao6Shijizhi" field="fenliao6Shijizhi" ></t:dgCol>
   <t:dgCol title="shui1Shijizhi" field="shui1Shijizhi" ></t:dgCol>
   <t:dgCol title="shui2Shijizhi" field="shui2Shijizhi" ></t:dgCol>
   <t:dgCol title="waijiaji1Shijizhi" field="waijiaji1Shijizhi" ></t:dgCol>
   <t:dgCol title="waijiaji2Shijizhi" field="waijiaji2Shijizhi" ></t:dgCol>
   <t:dgCol title="waijiaji3Shijizhi" field="waijiaji3Shijizhi" ></t:dgCol>
   <t:dgCol title="waijiaji4Shijizhi" field="waijiaji4Shijizhi" ></t:dgCol>
   <t:dgCol title="jiaobanshijian" field="jiaobanshijian" ></t:dgCol>
   <t:dgCol title="xinxibianhao" field="xinxibianhao" ></t:dgCol>
   <t:dgCol title="leiji" field="leiji" ></t:dgCol>
   <t:dgCol title="chulijieguo" field="chulijieguo" ></t:dgCol>
   <t:dgCol title="chuliaoshijian" field="chuliaoshijian" ></t:dgCol>
   <t:dgCol title="shebeibianhao" field="shebeibianhao" ></t:dgCol>
   <t:dgCol title="biaoshi" field="biaoshi" ></t:dgCol>
   <t:dgCol title="fasongcishu" field="fasongcishu" ></t:dgCol>
   <t:dgCol title="leixing" field="leixing" ></t:dgCol>
   <t:dgCol title="wentiyuanyin" field="wentiyuanyin" ></t:dgCol>
   <t:dgCol title="chulishijian" field="chulishijian" ></t:dgCol>
   <t:dgCol title="beizhu" field="beizhu" ></t:dgCol>
   <t:dgCol title="chulifangshi" field="chulifangshi" ></t:dgCol>
   <t:dgCol title="filepath" field="filepath" ></t:dgCol>
   <t:dgCol title="confirmdate" field="confirmdate" ></t:dgCol>
   <t:dgCol title="jianliresult" field="jianliresult" ></t:dgCol>
   <t:dgCol title="jianlishenpi" field="jianlishenpi" ></t:dgCol>
   <t:dgCol title="shenpidate" field="shenpidate" ></t:dgCol>
   <t:dgCol title="baocunshijian" field="baocunshijian" ></t:dgCol>
   <t:dgCol title="gongchengmingcheng" field="gongchengmingcheng" ></t:dgCol>
   <t:dgCol title="sigongdidian" field="sigongdidian" ></t:dgCol>
   <t:dgCol title="jiaozuobuwei" field="jiaozuobuwei" ></t:dgCol>
   <t:dgCol title="qiangdudengji" field="qiangdudengji" ></t:dgCol>
   <t:dgCol title="peifanghao" field="peifanghao" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="xiangxixxjieguoController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="xiangxixxjieguoController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="xiangxixxjieguoController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="xiangxixxjieguoController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>