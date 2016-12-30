package com.shtoone.qms.service.impl.bhz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.shtoone.qms.service.bhz.W_TemperaturedataYHXServiceI;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;

@Service("temperaturedataYHXServiceI")
@Transactional
public class W_TemperaturedataYHXServiceImpl extends CommonServiceImpl implements W_TemperaturedataYHXServiceI {
	public JSONObject getDatagrid3(DataGrid dataGrid, String startTime, String endTime, String userlft, String userrgt,
			String shebeibianhao) {
		StringBuilder queryCondition = new StringBuilder("");
		queryCondition.append(" 1=1 ");
		
		
		queryCondition.append(" and lft >= '"+userlft+"' and rgt <= '" + userrgt + "'");
		
		if(StringUtil.isNotEmpty(shebeibianhao)){
			queryCondition.append(" and gprsbianhao ='"+shebeibianhao+"'");
		}
		if(StringUtil.isNotEmpty(startTime)){
			queryCondition.append(" and tmpshijian >='"+startTime+"'");
		}
		if(StringUtil.isNotEmpty(endTime)){
			queryCondition.append(" and tmpshijian <='"+endTime+"'");
		}
        
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from TemperaturedataViewYHX t where"+queryCondition.toString();
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		
		// 取出当前页的数据 
		StringBuffer sql = new StringBuffer();
		sql.append("select * from TemperaturedataViewYHX t where"+queryCondition.toString()+"order by tmpshijian asc");
		
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(), dataGrid.getPage(), dataGrid.getRows());
		// 将结果集转换成页面上对应的数据集
		Db2Page[] db2Pages = {
				new Db2Page("tmpid")
				,new Db2Page("banhezhanminchen")
				,new Db2Page("tmpshijian")
				,new Db2Page("tmpdata")
				,new Db2Page("wdfanwei")
				,new Db2Page("shidudata")
				,new Db2Page("sdfanwei")
		};
		JSONObject jObject = getJsonDatagridEasyUI(mapList, iCount.intValue(), db2Pages);
		return jObject;
	}

	public String getbaobiaoxml(JSONObject jObject) {
		Iterator it = jObject.keys();
		JSONArray array = null;
		while (it.hasNext()) {
			String key = (String) it.next();
			if (key.equals("rows")){
				array = jObject.getJSONArray(key);
			}
		}
		
		StringBuilder strXML = new StringBuilder("");
		int datasize = array.size();
		strXML.append("<?xml version='1.0' encoding='utf-8'?><chart caption='温度湿度走势图' subcaption='(");
		strXML.append(array.getJSONObject(0).get("tmpshijian"));
		strXML.append("至");
		strXML.append(array.getJSONObject(array.size()-1).get("tmpshijian"));
		strXML.append(")' xAxisName='' yAxisName='数值' showValues='0'>");
		strXML.append("<categories>");
		for (int i = 0; i < array.size(); i++) {
			strXML.append("<category label='");
			strXML.append(array.getJSONObject(i).get("tmpshijian"));
			strXML.append("'/>");
		}
		strXML.append("</categories>");
		
		strXML.append("<dataset seriesName='温度℃'>");
		for (int i = 0; i < array.size(); i++) {
			strXML.append("<set value='");
			strXML.append(array.getJSONObject(i).get("tmpdata"));
			strXML.append("' toolText ='");
			strXML.append(array.getJSONObject(i).get("banhezhanminchen"));
			strXML.append(" ");
			strXML.append(array.getJSONObject(i).get("tmpdata"));
			strXML.append("℃  ");
			strXML.append(array.getJSONObject(i).get("wdfanwei"));
			strXML.append("'/>");
		}
		strXML.append("</dataset>");
		
		strXML.append("<dataset seriesName='湿度%'>");
		for (int i = 0; i < array.size(); i++) {
			strXML.append("<set value='");
			strXML.append(array.getJSONObject(i).get("shidudata"));
			strXML.append("' toolText ='");
			strXML.append(array.getJSONObject(i).get("banhezhanminchen"));
			strXML.append(" ");
			strXML.append(array.getJSONObject(i).get("shidudata"));
			strXML.append("% ");
			strXML.append(array.getJSONObject(i).get("sdfanwei"));
			strXML.append("'/>");
		}
		strXML.append("</dataset>");

		strXML.append(" <styles>");
        strXML.append(" <definition>"); 
        strXML.append(" <style name='CanvasAnim' type='animation' param='_xScale' start='0' duration='1' />"); 
        strXML.append(" </definition>"); 
        strXML.append(" <application>"); 
        strXML.append(" <apply toObject='Canvas' styles='CanvasAnim' />"); 
        strXML.append(" </application>"); 
        strXML.append(" </styles>"); 
        strXML.append(" </chart>"); 
        return strXML.toString();
	}

	public JSONObject getDatagrid3(String startTime, String endTime, String userlft, String userrgt,
			String shebeibianhao) {
		StringBuilder queryCondition = new StringBuilder("");
		queryCondition.append(" 1=1 ");
		
		
		queryCondition.append(" and lft >= '"+userlft+"' and rgt <= '" + userrgt + "'");
		
		if(StringUtil.isNotEmpty(shebeibianhao)){
			queryCondition.append(" and gprsbianhao ='"+shebeibianhao+"'");
		}
		if(StringUtil.isNotEmpty(startTime)){
			queryCondition.append(" and tmpshijian >='"+startTime+"'");
		}
		if(StringUtil.isNotEmpty(endTime)){
			queryCondition.append(" and tmpshijian <='"+endTime+"'");
		}
        

		
		// 取出当前页的数据 
		StringBuffer sql = new StringBuffer();
		sql.append("select * from TemperaturedataViewYHX t where"+queryCondition.toString()+"order by tmpshijian asc");
		
		List<Map<String, Object>> mapList = findForJdbc(sql.toString());
		// 将结果集转换成页面上对应的数据集
		Db2Page[] db2Pages = {
				new Db2Page("tmpid")
				,new Db2Page("banhezhanminchen")
				,new Db2Page("tmpshijian")
				,new Db2Page("tmpdata")
				,new Db2Page("wdfanwei")
				,new Db2Page("shidudata")
				,new Db2Page("sdfanwei")
		};
		JSONObject jObject = getJsonDatagridEasyUI(mapList,mapList.size(), db2Pages);
		return jObject;
	}
	
}