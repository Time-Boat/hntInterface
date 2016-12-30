package com.shtoone.qms.service.impl.bhz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.ChuliaokouTemperaturedataViewEntity;
import com.shtoone.qms.entity.bhz.ClksmscfgEntity;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.service.bhz.ChuliaokouTemperaturedataViewServiceI;
import com.shtoone.qms.service.bhz.ClksmscfgServiceI;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl.Db2Page;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.service.SystemService;

@Service("chuliaokouTemperaturedataViewService")
@Transactional
public class ChuliaokouTemperaturedataViewServiceImpl extends CommonServiceImpl implements ChuliaokouTemperaturedataViewServiceI {
	
	@Autowired
	private JdbcDao jdbcDao;
	
	@Autowired
	private ClksmscfgServiceI ClksmscfgService;
	
	public JSONObject getDatagrid3(ChuliaokouTemperaturedataViewEntity chuliaokouTemperaturedataView,
			DataGrid dataGrid,String startTime,String endTime,Integer userlft,Integer userrgt,String shebeibianhao){
		StringBuilder queryCondition = new StringBuilder("");
		
		queryCondition.append(" (convert(datetime,tmpshijian,121) between '"
				+ startTime + "' and '" + endTime + "')");
		
		if(userlft>0 && userrgt>0){
			queryCondition.append(" and lft >= '"+userlft+"'"+" and rgt<= '"+userrgt+"'");
		}
		
		if(StringUtil.isNotEmpty(shebeibianhao)){
			queryCondition.append(" and gprsbianhao='"+shebeibianhao+"'");
		}
	
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from ChuliaokouTemperaturedataView t where"+queryCondition.toString();
		Long iCount = getCountForJdbcParam(sqlCnt, null);
					
		// 取出当前页的数据 
		StringBuffer sql = new StringBuffer();
	    sql.append("select * from ChuliaokouTemperaturedataView t where"+queryCondition.toString());
					
		System.out.println(sql.toString());
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(), dataGrid.getPage(), dataGrid.getRows());
		// 将结果集转换成页面上对应的数据集
					Db2Page[] db2Pages = {
							new Db2Page("id", "id")
							// ,new Db2Page("quanju","全局")
							,new Db2Page("banhezhanminchen", "banhezhanminchen")
							,new Db2Page("tmpshijian", "tmpshijian")
							,new Db2Page("tmpdata", "tmpdata")
							,new Db2Page("tmpno", "tmpno")
							

					};
		JSONObject jObject = getJsonDatagridEasyUI(mapList, iCount.intValue(), db2Pages);
		return jObject;
	}
	/**
	 * 出料口温度图形
	 */
	public String getChuliaokouXml(JSONObject jObject, String shebeibianhao){
		String strXML = createChuliaokouXml(jObject,shebeibianhao);
		// System.out.println(lujing+"-2-2-");
		return strXML;
		
	}
	public void appendSetXml5(StringBuilder strb, String value,String shijian) {
		float tf = -1;
		tf = StringUtil.toFloat(value);   
		if (tf > 0) {
			strb.append("<set value='");
			strb.append(tf);
			strb.append("' toolText='"+shijian+","+value+"'/>");
		} else {
			strb.append("<set />");
		}		
	}
	
	
	private String createChuliaokouXml(JSONObject jObject,String shebeibianhao) {
		// 解析json数据
		Iterator it = jObject.keys();
		JSONArray array = null;
		while (it.hasNext()) {
			String key = (String) it.next();
			if (key.equals("rows")){
				array = jObject.getJSONArray(key);
			}

		}
		
		//温度速度查询走势图
		//public String getChuliaokouXml(List<ChuliaokouTemperaturedataView> tempdata,String shebeibianhao) {
			StringBuilder strXML = new StringBuilder("");
			int datasize = 3;
			JSONObject key3 = array.getJSONObject(0);	
			if(StringUtil.Null2Blank(shebeibianhao).length()==0){
				strXML.append("<?xml version='1.0' encoding='utf-8'?><chart caption='出料口温度走势图(°C)' subcaption='(");
			}else{
				strXML.append("<?xml version='1.0' encoding='utf-8'?><chart caption='"+key3.get("banhezhanminchen")+"走势图(°C)' subcaption='(");
			}
			if (null != array && array.size()>0) {
				strXML.append(key3.get("tmpshijian"));
				strXML.append("至");
				strXML.append( array.getJSONObject(array.size()-1).get("tmpshijian"));
				datasize = array.size()-1;
			}
			strXML.append(")' lineThickness='2' showValues='0' anchorRadius='2' ");
			strXML.append("divLineAlpha='40' divLineColor='CC3300' divLineIsDashed='1' slantLabels='1' ");
			strXML.append("showAlternateHGridColor='1' alternateHGridColor='CC3300' shadowAlpha='40' ");
			strXML.append("labelStep='");
			strXML.append(datasize);
			strXML.append("' numvdivlines='20' chartRightMargin='14' chartLeftMargin='14' formatNumberScale='0' ");
			strXML.append("bgColor='FFFFFF,CC3300' bgAngle='270' bgAlpha='10,10' alternateHGridAlpha='5' yAxisMinValue='100'> ");
			strXML.append("<categories>");
			if (null != array && array.size()>0) {
				for (int i = 0; i < array.size(); i++) {
					JSONObject key2 = array.getJSONObject(i);					
					strXML.append("<category label='");
//					strXML.append(tmp.getTmpshijian());
					strXML.append("'/>");
				}		
			}
			strXML.append("</categories>");
			if (null != array && array.size()>0) {
			strXML.append("<dataset seriesName='温度' color='0000FF'>");
			//for (ChuliaokouTemperaturedataView tmp : tempdata) {
				for (int i = 0; i < array.size(); i++) {
					JSONObject key2 = array.getJSONObject(i);
					System.out.println(key2.getString("tmpdata"));
					appendSetXml5(strXML, key2.getString("tmpdata"), key2.getString("tmpshijian"));	
					
				}
			//}
			strXML.append("</dataset>");	
			}		
			ClksmscfgEntity clk=ClksmscfgService.getClksmscfg(key3.getString("tmpno"));
			if(clk!=null){
				//画上下限
				strXML.append("<trendlines>");
				strXML.append("<line  alpha='0'  showOnTop='1' startValue='");
				strXML.append(clk.getTmplow());
				strXML.append("' color='FF3333' displayValue='");
				strXML.append(clk.getTmplow());
				strXML.append("' showOnTop='1' dashed='1'/>");
				strXML.append("<line alpha='0'   startValue='");
				strXML.append(clk.getTmphigh());
				strXML.append("' color='FF3333' displayValue='");
				strXML.append(clk.getTmphigh());
				strXML.append("' showOnTop='1' dashed='1' />");
			    strXML.append("</trendlines>");
			    
				strXML.append("<dataset  anchorRadius = '0' color='FF3333' seriesName='");
				strXML.append("道路石油沥青");
				strXML.append("'>");
				//for (ChuliaokouTemperaturedataView tmp : tempdata) {
				for (int i = 0; i < array.size(); i++) {
					strXML.append("<set color='#00A600' dashed='1'  value='");
					strXML.append(clk.getTmplow());	
	                strXML.append("' />");
				}
				//}
				strXML.append("</dataset>");	
				
				strXML.append("<dataset  anchorRadius = '0'  anchorBorderColor = 'FF3333' seriesName='");
				strXML.append("改性沥青");
				strXML.append("'>");
				//for (ChuliaokouTemperaturedataView tmp : tempdata) {
				for (int i = 0; i < array.size(); i++) {
					strXML.append("<set color='FF3333' dashed='1'  value='");
					strXML.append(clk.getTmphigh());	
	                strXML.append("' />");
				}
				//}
				strXML.append("</dataset>");
			}
//				strXML.append("<trendlines>");
//				strXML.append("<line startValue='"+xc.getTmplow()+"' color='0000FF' displayValue='初级下线,"+xc.getTmplow()+"' showOnTop='1' dashed='1'/>");
//				strXML.append("<line startValue='"+xc.getTmphigh()+"' color='80FF80' displayValue='初级上线,"+xc.getTmphigh()+"' showOnTop='1' dashed='1'/>");
//				strXML.append("<line startValue='"+xc.getTmplow1()+"' color='8000FF' displayValue='中级下线,"+xc.getTmplow1()+"' showOnTop='1' dashed='1'/>");
//				strXML.append("<line startValue='"+xc.getTmphigh1()+"' color='000000' displayValue='中级上线,"+xc.getTmphigh1()+"' showOnTop='1' dashed='1'/>");
//				strXML.append("<line startValue='"+xc.getTmplow2()+"' color='400080' displayValue='高级下线,"+xc.getTmplow2()+"' showOnTop='1' dashed='1'/>");
//				strXML.append("<line startValue='"+xc.getTmphigh2()+"' color='FF0000' displayValue='高级上线,"+xc.getTmphigh2()+"' showOnTop='1' dashed='1'/>");
//				strXML.append("</trendlines>");			
//			}		
			strXML.append(" <styles>");
	        strXML.append(" <definition>"); 
	        strXML.append(" <style type='font' name='captionFont' size='12'/>"); 
	        strXML.append(" </definition>"); 
	        strXML.append(" <application>"); 
	        strXML.append(" <apply toObject='Caption' styles='captionFont' />"); 
	        strXML.append(" <apply toObject='SubCaption' styles='SubcaptionFont' />"); 
	        strXML.append(" </application>"); 
	        strXML.append(" </styles>"); 
	        strXML.append(" </chart>"); 
	        return strXML.toString();
		    //return FusionChartsCreator.createChart(StringUtil.getWebrootpath()+"/FusionCharts/MSLine.swf", "",strXML.toString(), "chartbanhechuliaotemp", 1000, 300, false, false);
		//}
		
		
		
		
		
		
		
	}
}