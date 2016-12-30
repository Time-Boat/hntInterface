<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
	<head>
  	<title>对比详细查看</title>
  	<t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
<body >
  	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="">
		<input id="id" name="id" type="hidden" value="${hunnintuViewPage.id }">
		<table style="width: 800px;" cellpadding="0" cellspacing="1" class="formtable">	
			<tr>
				<td align="center" colspan="7">生产数据</td>
				<td align="center" colspan="2">对比数据</td>
			</tr>
			<tr>
				<td colspan="2" align="center" height="50px"><label class="Validform_label">其它信息</label></td>
				<td align="right" width="100px"><label class="Validform_label">材料名称</label></td>
				<td align="center" width="100px"><label class="Validform_label">实际值(施工)</label></td>
				<td align="center" width="100px"><label class="Validform_label">配比</label></td>
				<td align="center" width="100px"><label class="Validform_label">误差(kg)</label></td>
				<td align="center" width="100px"><label class="Validform_label">误差百分比(%)</label></td>
				<td align="center" width="100px"><label class="Validform_label">对比材料名称</label></td>
				<td align="center" width="100px"><label class="Validform_label">对比值</label></td>	
			</tr>
			<tr>
				<td align="right" width="100px"><label class="Validform_label">拌和站名称:</label></td>
				<td class="value" width="200px">${hunnintuViewPage.banhezhanminchen}</td>
				<td align="right"><label class="Validform_label">${hbfield.shui1_shijizhi}</label></td>
				<td class="value">${hunnintuViewPage.shui1_shijizhi}</td>				
				<td class="value">${hunnintuViewPage.shui1_lilunzhi}</td>
				<td class="value">${hunnintuViewPage.shw1}</td>
				<td class="value">${hunnintuViewPage.shper1}</td>
				<td class="value">${xiangxixx.shui1name}</td>	
				<td class="value">${xiangxixx.shui1weight}</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">${hbfield.gongchengmingcheng}</label></td>
				<td class="value">${hunnintuViewPage.gongchengmingcheng}</td>
				<td align="right"><label class="Validform_label">${hbfield.shuini1_shijizhi}</label></td>
				<td class="value">${hunnintuViewPage.shuini1_shijizhi}</td>
				<td class="value">${hunnintuViewPage.shuini1_lilunzhi}</td>
				<td class="value">${hunnintuViewPage.flw1}</td>
				<td class="value">${hunnintuViewPage.flper1}</td>
				<td class="value">${xiangxixx.shuini1name}</td>	
				<td class="value">${xiangxixx.shuini1weight}</td>
			</tr>
			<tr>
			   	<td align="right"><label class="Validform_label">${hbfield.jiaobanshijian}</label></td>
				<td class="value">${hunnintuViewPage.jiaobanshijian}</td>
				<td align="right"><label class="Validform_label">${hbfield.shuini2_shijizhi}</label></td>
				<td class="value">${hunnintuViewPage.shuini2_shijizhi}</td>
				<td class="value">${hunnintuViewPage.shuini2_lilunzhi}</td>
				<td class="value">${hunnintuViewPage.flw2}</td>
				<td class="value">${hunnintuViewPage.flper2}</td>
				<td class="value">${xiangxixx.shuini2name}</td>	
				<td class="value">${xiangxixx.shuini2weight}</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">${hbfield.gujifangshu}</label></td>
				<td class="value">${hunnintuViewPage.gujifangshu}</td>
				<td align="right"><label class="Validform_label">${hbfield.sha1_shijizhi}</label></td>
				<td class="value">${hunnintuViewPage.sha1_shijizhi}</td>
				<td class="value">${hunnintuViewPage.sha1_lilunzhi}</td>
				<td class="value">${hunnintuViewPage.glw1}</td>
				<td class="value">${hunnintuViewPage.glper1}</td>
				<td class="value">${xiangxixx.sha1name}</td>	
				<td class="value">${xiangxixx.sha1weight}</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">${hbfield.chuliaoshijian}</label></td>
				<td class="value">${hunnintuViewPage.chuliaoshijian}</td>
				<td align="right"><label class="Validform_label">${hbfield.shi1_shijizhi}</label></td>
				<td class="value">${hunnintuViewPage.shi1_shijizhi}</td>
				<td class="value">${hunnintuViewPage.shi1_lilunzhi}</td>
				<td class="value">${hunnintuViewPage.glw2}</td>
				<td class="value">${hunnintuViewPage.glper2}</td>
				<td class="value">${xiangxixx.shi1name}</td>	
				<td class="value">${xiangxixx.shi1weight}</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">${hbfield.gongdanhao}</label></td>
				<td class="value">${hunnintuViewPage.gongdanhao}</td>
				<td align="right"><label class="Validform_label">${hbfield.shi2_shijizhi}</label></td>
				<td class="value">${hunnintuViewPage.shi2_shijizhi}</td>
				<td class="value">${hunnintuViewPage.shi2_lilunzhi}</td>
				<td class="value">${hunnintuViewPage.glw3}</td>
				<td class="value">${hunnintuViewPage.glper3}</td>
				<td class="value">${xiangxixx.shi2name}</td>	
				<td class="value">${xiangxixx.shi2weight}</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">${hbfield.chaozuozhe}</label></td>
				<td class="value">${hunnintuViewPage.chaozuozhe}</td>
				<td align="right"><label class="Validform_label">${hbfield.sha2_shijizhi}</label></td>
				<td class="value">${hunnintuViewPage.sha2_shijizhi}</td>
				<td class="value">${hunnintuViewPage.sha2_lilunzhi}</td>
				<td class="value">${hunnintuViewPage.glw4}</td>
				<td class="value">${hunnintuViewPage.glper4}</td>	
				<td class="value">${xiangxixx.sha2name}</td>	
				<td class="value">${xiangxixx.sha2weight}</td>			
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">${hbfield.sigongdidian}</label></td>
				<td class="value">${hunnintuViewPage.sigongdidian}</td>
				<td align="right"><label class="Validform_label">${hbfield.guliao5_shijizhi}</label></td>
				<td class="value">${hunnintuViewPage.guliao5_shijizhi}</td>
				<td class="value">${hunnintuViewPage.guliao5_lilunzhi}</td>
				<td class="value">${hunnintuViewPage.glw5}</td>
				<td class="value">${hunnintuViewPage.glper5}</td>
				<td class="value">${xiangxixx.guliao5name}</td>	
				<td class="value">${xiangxixx.guliao5weight}</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">${hbfield.jiaozuobuwei}</label></td>
				<td class="value">${hunnintuViewPage.jiaozuobuwei}</td>
				<td align="right"><label class="Validform_label">${hbfield.kuangfen3_shijizhi}</label></td>
				<td class="value">${hunnintuViewPage.kuangfen3_shijizhi}</td>
				<td class="value">${hunnintuViewPage.kuangfen3_lilunzhi}</td>
				<td class="value">${hunnintuViewPage.flw3}</td>
				<td class="value">${hunnintuViewPage.flper3}</td>
				<td class="value">${xiangxixx.kuangfen3name}</td>	
				<td class="value">${xiangxixx.kuangfen3weight}</td>	
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">${hbfield.waijiajipingzhong}</label></td>
				<td class="value">${hunnintuViewPage.waijiajipingzhong}</td>
				<td align="right"><label class="Validform_label">${hbfield.feimeihui4_shijizhi}</label></td>
				<td class="value">${hunnintuViewPage.feimeihui4_shijizhi}</td>
				<td class="value">${hunnintuViewPage.feimeihui4_lilunzhi}</td>
				<td class="value">${hunnintuViewPage.flw4}</td>
				<td class="value">${hunnintuViewPage.flper4}</td>
				<td class="value">${xiangxixx.feimeihui4name}</td>	
				<td class="value">${xiangxixx.feimeihui4weight}</td>		
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">${hbfield.shuinipingzhong}</label></td>
				<td class="value">${hunnintuViewPage.shuinipingzhong}</td>
				<td align="right"><label class="Validform_label">${hbfield.fenliao5_shijizhi}</label></td>
				<td class="value">${hunnintuViewPage.fenliao5_shijizhi}</td>
				<td class="value">${hunnintuViewPage.fenliao5_lilunzhi}</td>
				<td class="value">${hunnintuViewPage.flw5}</td>
				<td class="value">${hunnintuViewPage.flper5}</td>	
				<td class="value">${xiangxixx.fenliao5name}</td>	
				<td class="value">${xiangxixx.fenliao5weight}</td>		
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">${hbfield.peifanghao}</label></td>
				<td class="value">${hunnintuViewPage.peifanghao}</td>
				<td align="right"><label class="Validform_label">${hbfield.fenliao6_shijizhi}</label></td>
				<td class="value">${hunnintuViewPage.fenliao6_shijizhi}</td>
				<td class="value">${hunnintuViewPage.fenliao6_lilunzhi}</td>
				<td class="value">${hunnintuViewPage.flw6}</td>
				<td class="value">${hunnintuViewPage.flper6}</td>
				<td class="value">${xiangxixx.fenliao6name}</td>	
				<td class="value">${xiangxixx.fenliao6weight}</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">${hbfield.qiangdudengji}</label></td>
				<td class="value">${hunnintuViewPage.qiangdudengji}</td>
				<td align="right"><label class="Validform_label">${hbfield.shui2_shijizhi}</label></td>
				<td class="value">${hunnintuViewPage.shui2_shijizhi}</td>
				<td class="value">${hunnintuViewPage.shui2_lilunzhi}</td>
				<td class="value">${hunnintuViewPage.shw2}</td>
				<td class="value">${hunnintuViewPage.shper2}</td>
				<td class="value">${xiangxixx.shui2name}</td>	
				<td class="value">${xiangxixx.shui2weight}</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">${hbfield.shebeibianhao}</label></td>
				<td class="value">${hunnintuViewPage.shebeibianhao}</td>
				<td align="right"><label class="Validform_label">${hbfield.waijiaji1_shijizhi}</label></td>
				<td class="value">${hunnintuViewPage.waijiaji1_shijizhi}</td>
				<td class="value">${hunnintuViewPage.waijiaji1_lilunzhi}</td>
				<td class="value">${hunnintuViewPage.wjw1}</td>
				<td class="value">${hunnintuViewPage.wjper1}</td>
				<td class="value">${xiangxixx.waijiaji1name}</td>	
				<td class="value">${xiangxixx.waijiaji1weight}</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">${hbfield.baocunshijian}</label></td>
				<td class="value">${hunnintuViewPage.baocunshijian}</td>
				<td align="right"><label class="Validform_label">${hbfield.waijiaji2_shijizhi}</label></td>
				<td class="value">${hunnintuViewPage.waijiaji2_shijizhi}</td>
				<td class="value">${hunnintuViewPage.waijiaji2_lilunzhi}</td>
				<td class="value">${hunnintuViewPage.wjw2}</td>
				<td class="value">${hunnintuViewPage.wjper2}</td>
				<td class="value">${xiangxixx.waijiaji2name}</td>	
				<td class="value">${xiangxixx.waijiaji2weight}</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">${hbfield.caijishijian}</label></td>
				<td class="value">${hunnintuViewPage.caijishijian}</td>
				<td align="right"><label class="Validform_label">${hbfield.waijiaji3_shijizhi}</label></td>
				<td class="value">${hunnintuViewPage.waijiaji3_shijizhi}</td>
				<td class="value">${hunnintuViewPage.waijiaji3_lilunzhi}</td>
				<td class="value">${hunnintuViewPage.wjw3}</td>
				<td class="value">${hunnintuViewPage.wjper3}</td>
				<td class="value">${xiangxixx.waijiaji3name}</td>	
				<td class="value">${xiangxixx.waijiaji3weight}</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">客户端编号</label></td>
				<td class="value">${hunnintuViewPage.kehuduanbianhao}</td>
				<td align="right"><label class="Validform_label">${hbfield.waijiaji4_shijizhi}</label></td>
				<td class="value">${hunnintuViewPage.waijiaji4_shijizhi}</td>
				<td class="value">${hunnintuViewPage.waijiaji4_lilunzhi}</td>
				<td class="value">${hunnintuViewPage.wjw4}</td>
				<td class="value">${hunnintuViewPage.wjper4}</td>
				<td class="value">${xiangxixx.waijiaji4name}</td>	
				<td class="value">${xiangxixx.waijiaji4weight}</td>
			</tr>
			<tr>
				<td align="right" colspan="7"></td>
				<td class="value">投料完成时间</td>	
				<td class="value">${xiangxixx.tlwcsj}</td>
			</tr>
			<tr>
				<td align="right" colspan="7"></td>
				<td class="value">卸砼开始时间</td>	
				<td class="value">${xiangxixx.xhkssj}</td>
			</tr>
		</table>
	</t:formvalid>
</body>
</html>