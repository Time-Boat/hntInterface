package com.shtoone.qms.service.impl.bhz;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.service.bhz.XiangxixxyssjServiceI;

import net.sf.json.JSONObject;

@Service("xiangxixxyssjServiceI")
@Transactional
public class XiangxixxyssjServiceImpl extends CommonServiceImpl implements XiangxixxyssjServiceI{
	
	public JSONObject getJdGrid(Integer pageNo,Integer maxPageItems,String startTime,String endTime,String shebeibianhao,
			String userlft,String userrgt,String gongchenmingchen){
		String sqlWhere=" where 1=1";
		if (StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)) {
			sqlWhere += " and (convert(datetime,chuliaoshijian,121) between '"+ startTime + "' and '" + endTime + "')";
		}
		if(StringUtil.isNotEmpty(shebeibianhao)){
			sqlWhere+=" and shebeibianhao='"+shebeibianhao+"'";
		}
		if(StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)){
			sqlWhere += " and lft >= '"+userlft+"' and rgt <= '" + userrgt + "'";
		}
		if(StringUtil.isNotEmpty(gongchenmingchen)){
			sqlWhere+=" and gongchengmingcheng='"+gongchenmingchen+"'";
		}
		String sqlCnt = "select count(*) from HntviewYssj";
		//得到数据的总跳数
		sqlCnt+=sqlWhere;
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		//分页条数
		String sql="select * from HntviewYssj";
		sqlWhere+=" ORDER BY ID desc";
		sql+=sqlWhere;
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(),pageNo,maxPageItems);
		// 将结果集转换成页面上对应的数据集
		Db2Page[] db2Pages = {new Db2Page("id")
							,new Db2Page("banhezhanminchen")
							,new Db2Page("gongchengmingcheng")
							,new Db2Page("jiaozuobuwei")
							,new Db2Page("qiangdudengji")
							,new Db2Page("gujifangshu")
							,new Db2Page("chuliaoshijian")
							,new Db2Page("sha1_shijizhi")					
							,new Db2Page("shi1_shijizhi")					
							,new Db2Page("sha2_shijizhi")
							,new Db2Page("shi2_shijizhi")
							,new Db2Page("guliao5_shijizhi")
							,new Db2Page("shuini1_shijizhi")					
							,new Db2Page("shuini2_shijizhi")
							,new Db2Page("kuangfen3_shijizhi")
							,new Db2Page("feimeihui4_shijizhi")
							,new Db2Page("fenliao5_shijizhi")
							,new Db2Page("fenliao6_shijizhi")
							,new Db2Page("shui1_shijizhi")
							,new Db2Page("shui2_shijizhi")
							,new Db2Page("waijiaji1_shijizhi")
							,new Db2Page("waijiaji2_shijizhi")
							,new Db2Page("waijiaji3_shijizhi")
							,new Db2Page("waijiaji4_shijizhi")};
		//将数据集转换成JdGrid格式
		return getJsonJdGrid(mapList,iCount.intValue(),db2Pages);
	}
	
	public JSONObject getJsonJdGrid(List<Map<String, Object>> mapList, int iTotalCnt, Db2Page[] dataExchanger) {
		//easyUI的dataGrid方式  －－－－这部分可以提取成统一处理
		String jsonTemp = "{\"records\":" + iTotalCnt + ",\"rows\":[";
		for (int j = 0; j < mapList.size(); j++) {
			Map<String, Object> m = mapList.get(j);
			if (j > 0) {
				jsonTemp += ",";
			}
			jsonTemp += "{";
			for (int i = 0; i < dataExchanger.length; i++) {
				if (i > 0) {
					jsonTemp += ",";
				}
				//当从dataExchanger取到id时，则改变操作
				if(dataExchanger[i].getKey().equalsIgnoreCase("id")){
					jsonTemp+="\"id\":";
					Object objValue = dataExchanger[i].getData(m);
					if (objValue == null) {
						jsonTemp += "null";
					} else {
						jsonTemp += "\"" + objValue.toString() + "\",";
					}
					jsonTemp+="\"cell\":[";
				}else{  //cell
					Object objValue = dataExchanger[i].getData(m);
					if (objValue == null) {
						jsonTemp += "null";
					} else {
						jsonTemp += "\"" + objValue + "\"";
					}
				}
				if (i ==dataExchanger.length-1) {
					jsonTemp += "]";
				}
			}
			jsonTemp += "}";
		}
		jsonTemp += "]}";
		JSONObject jObject = JSONObject.fromObject(jsonTemp);
		return jObject;
	}
	
	public JSONObject getDataGrid(String startTime,String endTime,String shebeibianhao,
			String userlft,String userrgt,String gongchenmingchen,DataGrid dataGrid){
		String sqlWhere=" where 1=1";
		if (StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)) {
			sqlWhere += " and (convert(datetime,chuliaoshijian,121) between '"+ startTime + "' and '" + endTime + "')";
		}
		if(StringUtil.isNotEmpty(shebeibianhao)){
			sqlWhere+=" and shebeibianhao='"+shebeibianhao+"'";
		}
		if(StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)){
			sqlWhere += " and lft >= '"+userlft+"' and rgt <= '" + userrgt + "'";
		}
		if(StringUtil.isNotEmpty(gongchenmingchen)){
			sqlWhere+=" and gongchengmingcheng='"+gongchenmingchen+"'";
		}
		String sqlCnt = "select count(*) from HntviewYssj";
		//得到数据的总跳数
		sqlCnt+=sqlWhere;
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		//分页条数
		String sql="select * from HntviewYssj";
		sqlWhere+=" ORDER BY ID desc";
		sql+=sqlWhere;
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(),dataGrid.getPage(), dataGrid.getRows());
		// 将结果集转换成页面上对应的数据集
		Db2Page[] db2Pages = {new Db2Page("id")
							,new Db2Page("banhezhanminchen")
							,new Db2Page("gongchengmingcheng")
							,new Db2Page("jiaozuobuwei")
							,new Db2Page("qiangdudengji")
							,new Db2Page("gujifangshu")
							,new Db2Page("chuliaoshijian")
							,new Db2Page("sha1_shijizhi")					
							,new Db2Page("shi1_shijizhi")					
							,new Db2Page("sha2_shijizhi")
							,new Db2Page("shi2_shijizhi")
							,new Db2Page("guliao5_shijizhi")
							,new Db2Page("shuini1_shijizhi")					
							,new Db2Page("shuini2_shijizhi")
							,new Db2Page("kuangfen3_shijizhi")
							,new Db2Page("feimeihui4_shijizhi")
							,new Db2Page("fenliao5_shijizhi")
							,new Db2Page("fenliao6_shijizhi")
							,new Db2Page("shui1_shijizhi")
							,new Db2Page("shui2_shijizhi")
							,new Db2Page("waijiaji1_shijizhi")
							,new Db2Page("waijiaji2_shijizhi")
							,new Db2Page("waijiaji3_shijizhi")
							,new Db2Page("waijiaji4_shijizhi")};
		//将数据集转换成easyui格式
		return getJsonDatagridEasyUI(mapList,iCount.intValue(),db2Pages);
	}
}
