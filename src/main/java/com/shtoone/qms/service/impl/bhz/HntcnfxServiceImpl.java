package com.shtoone.qms.service.impl.bhz;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.stereotype.Service;

import com.shtoone.qms.service.bhz.HntcnfxServiceI;


@Service
public class HntcnfxServiceImpl extends CommonServiceImpl implements HntcnfxServiceI {
	
	// 方式3, 取值进一步自己处理(直接转换成easyUI的datagrid需要的东西，执行效率最高，最自由)  -------------------------------	
	public JSONObject getDatagrid3(DataGrid dataGrid,
			String startTime,String endTime,Integer cxlx,Integer userlft,Integer userrgt,String shebeibianhao) {
		String sqlWhere = getSqlWhere(startTime,endTime,cxlx,userlft,userrgt,shebeibianhao);
		String sqlCnt = "select count(*) from Hntview t";
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		switch (cxlx) {
			case 1://季度
				sql.append(" year(a.chuliaodate) as xa , datename(quarter,a.chuliaodate) as xb, ");
				break;
			case 2://月份
				sql.append(" year(a.chuliaodate) as xa , datename(month,a.chuliaodate) as xb, ");
				break;
			case 3://周
				sql.append(" year(a.chuliaodate) as xa , datename(week,a.chuliaodate) as xb, ");
				break;
			default:
				break;
		}
		sql.append(" case when SUM(a.panshu)>0 then SUM(a.panshu) else 0 end  AS pangshu,");
		sql.append(" case when SUM(zongfashu)>0 then SUM(zongfashu) else 0 end AS gujifangshu,");
		sql.append(" case when SUM(cbpanshu+mcbpanshu+hcbpanshu)>0 then SUM(cbpanshu+mcbpanshu+hcbpanshu) else 0 end AS lowcbps,");
		sql.append(" case when SUM(mcbpanshu+hcbpanshu)>0 then SUM(mcbpanshu+hcbpanshu) else 0 end AS midcbps,");
		sql.append(" case when SUM(hcbpanshu)>0 then SUM(hcbpanshu) else 0 end AS highcbps,");
		sql.append(" case  when SUM(a.panshu)>0 then  cast(round(cast((SUM(cbpanshu)+SUM(mcbpanshu)+SUM(hcbpanshu))*100 as numeric)/SUM(a.panshu),2) as numeric(20,2)) else 0 end AS lowcbper,");
		sql.append(" case  when SUM(a.panshu)>0 then  cast(round(cast((SUM(mcbpanshu)+SUM(hcbpanshu))*100 as numeric)/SUM(a.panshu),2) as numeric(20,2))  else 0 end  AS midcbper,");
		sql.append(" case  when SUM(a.panshu)>0 then  cast(round(cast(SUM(hcbpanshu)*100 as numeric)/SUM(a.panshu),2) as numeric(20,2)) else 0 end  AS highcbper ");
		sql.append(" FROM ( select shebeibianhao,chuliaodate,panshu,zongfashu,0 as cbpanshu,0 as mcbpanshu,0 as hcbpanshu,0 as cczpanshu,0 as mczpanshu,0 as hczpanshu from tongji_cl ");
		sql.append(" union all ");
		sql.append(" select shebeibianhao,chuliaodate,0 as panshu,0 as zongfashu,cbpanshu,mcbpanshu,hcbpanshu,cczpanshu,mczpanshu,hczpanshu from TONGJICB )  a, Banhezhanxinxi b ,t_s_depart c ");	
		if (!sqlWhere.isEmpty()) {
			sql.append(" where "+sqlWhere);
		}
		switch (cxlx) {
			case 1:
				sql.append(" group by year(a.chuliaodate)  , datename(quarter,a.chuliaodate)  ");
				break;
			case 2:
				sql.append(" group by year(a.chuliaodate)  , datename(month,a.chuliaodate) ");
				break;
			case 3:
				sql.append(" group by year(a.chuliaodate)  , datename(week,a.chuliaodate) ");
				break;
			default:
				break;
		}
		sql.append(" order by xa asc ,xb asc ");
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(), dataGrid.getPage(), dataGrid.getRows());
		// 将结果集转换成页面上对应的数据集
		Db2Page[] db2Pages = {new Db2Page("xa","xa")
							 ,new Db2Page("xb","xb")
							 ,new Db2Page("pangshu","pangshu")
							 ,new Db2Page("gujifangshu","gujifangshu")
							 ,new Db2Page("lowps","lowcbps")
							 ,new Db2Page("midps","midcbps")
							 ,new Db2Page("highps","highcbps")
							 ,new Db2Page("lowper","lowcbper")
							 ,new Db2Page("midper","midcbper")
							 ,new Db2Page("highper","highcbper")};
		return getJsonDatagridEasyUI(mapList, iCount.intValue(), db2Pages);
	}
		
	// 拼查询条件（where语句）
	String getSqlWhere(String startTime,String endTime,Integer cxlx,
			Integer userlft,Integer userrgt,String shebeibianhao) {
		// 拼出条件语句
		String sqlWhere = "";
		sqlWhere +=" a.shebeibianhao=b.gprsbianhao and b.departid=c.ID ";
		if (StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)) {
			if (!sqlWhere.isEmpty()) {
				sqlWhere += " and";
			}
			sqlWhere += " (convert(varchar(100),chuliaodate,23) between '"+startTime+"' and '" + endTime + "')";
		}
			
		if (userlft>0 && userrgt>0) {
			if (!sqlWhere.isEmpty()) {
				sqlWhere += " and";
			}
			sqlWhere += " c.lft >= '"+userlft+"' and c.rgt <= '" + userrgt + "'";
		}
			
		if (StringUtil.isNotEmpty(shebeibianhao)) {
			if (!sqlWhere.isEmpty()) {
				sqlWhere += " and";
			}
			sqlWhere += " b.gprsbianhao = '"+shebeibianhao + "'";
		}
		return sqlWhere;
	}
		
	public String getHntAnalysisColumnXml(JSONObject jObject,Integer cxlx) {
		return createhntcnfxxml(jObject,cxlx);
	}
		
	private String createhntcnfxxml(JSONObject jObject, int cnfxlx) {
		//解析json数据
		Iterator it = jObject.keys();
		JSONArray array=null;
		while(it.hasNext()){
			String key=(String)it.next();
			if(key.equals("rows")){
				array = jObject.getJSONArray(key);
			}		 
		}
		//绘制图表
		StringBuilder strXML = new StringBuilder("");  
	    strXML.append("<?xml version='1.0' encoding='utf-8'?>");
	    strXML.append("<chart palette='2' caption='砼产能分析' bgColor='#DAEDFB,#F5F9FF' "); 
	    strXML.append(" showValues='0' divLineDecimalPrecision='1' limitsDecimalPrecision='1'"); 
	    strXML.append(" PYAxisName='生产量(m³)' SYAxisName='超标率(%)' numberSuffix='m³'"); 
	    strXML.append(" SNumberSuffix='%' PNumberSuffix='m³' formatNumberScale='0' outCnvBaseFontSize='13'>"); 
	    String sxa = "年";
	    String sxb;
	    switch (cnfxlx) {
			case 1:
				sxb = "季度";
				break;
			case 2:
				sxb = "月份";
				break;
			case 3:
				sxb = "周";
				break;
			default:
				sxb = "月份";
				break;
		}
	    if  (cnfxlx==3){
	        strXML.append("<categories>");	      
			for(int i=0;i<array.size();i++){
				JSONObject key2=array.getJSONObject(i);
	        	strXML.append("<category label='"); 
	            Calendar c = Calendar.getInstance();
	  	        c.set(Calendar.YEAR, Integer.parseInt((String) key2.get("xa"))); 
	  	        c.set(Calendar.WEEK_OF_YEAR, Integer.parseInt((String) key2.get("xb"))); 
	  	        c.setFirstDayOfWeek(Calendar.MONDAY); 
	  	        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday 
	  	        SimpleDateFormat sdfy =   new SimpleDateFormat( "yyyy" );
	  	        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy年MM月dd日" );
	  	        SimpleDateFormat sdf1 =   new SimpleDateFormat( "MM月dd日" );
	  	        String str = sdfy.format(c.getTime());
	  	        if (str.equalsIgnoreCase((String) key2.get("xa"))){ 
	  	        	c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Sunday  
	  	        	strXML.append(sdf.format(c.getTime()));
	  	        	strXML.append("至");
	  	        	c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()+6); // Sunday  
	  	        	strXML.append(sdf1.format(c.getTime()));
	  	        } else {
	  	        	c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Sunday  
	  	        	strXML.append(sdf.format(c.getTime()));
	  	        	strXML.append("至");
	  	        	c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()+6); // Sunday  
	  	        	strXML.append(sdf.format(c.getTime()));
	  	        }
	  	      strXML.append("'/>");    	
	        }
	        strXML.append("</categories>"); 
	        } else {
	        	strXML.append("<categories>");
				for(int i=0;i<array.size();i++){
					JSONObject key2=array.getJSONObject(i);
	            	strXML.append("<category label='"); 
	            	strXML.append(key2.get("xa"));
	            	strXML.append(sxa);
	            	strXML.append(key2.get("xb"));
	            	strXML.append(sxb);
	                strXML.append("'/>");    	
	            }
	            strXML.append("</categories>"); 
	        }
	        
	        strXML.append("<dataset seriesName='生产量(m³)'  showValues='1'>");
	        for(int i=0;i<array.size();i++){
				JSONObject key2=array.getJSONObject(i);
	        	strXML.append("<set value='"); 
	        	strXML.append(key2.get("gujifangshu"));
	        	strXML.append("' displayValue='");
	        	strXML.append(key2.get("gujifangshu"));
	        	strXML.append("m³(");
	        	strXML.append(key2.get("pangshu"));
	        	strXML.append("盘)");
	        	strXML.append("' link='JavaScript:myJS(");
	        	strXML.append(key2.get("xa"));
	        	strXML.append(",");
	        	strXML.append(key2.get("xb"));
	           	strXML.append(",");
	        	strXML.append(cnfxlx);
	        	strXML.append(")'/>");
	        }
	        strXML.append("</dataset>");       

	        
	        strXML.append("<dataset lineThickness='3' seriesName='高级超标率(%)' renderAs='Line' parentYAxis='S' showValues='1'>");
	        for(int i=0;i<array.size();i++){
				JSONObject key2=array.getJSONObject(i);
				strXML.append("<set value='"); 
	        	strXML.append(key2.get("highper"));
	        	strXML.append("' displayValue='");
	        	strXML.append(key2.get("highper"));
	        	strXML.append("%(");
	        	strXML.append(key2.get("highps"));
	        	strXML.append("盘)");        	
	        	strXML.append("'/>");
	        }
	        strXML.append("</dataset>");   
	        
	        strXML.append("<dataset lineThickness='3' seriesName='中级超标率(%)' renderAs='Line' parentYAxis='S' showValues='1'>");
	        for(int i=0;i<array.size();i++){
				JSONObject key2=array.getJSONObject(i);
	        	strXML.append("<set value='"); 
	        	strXML.append(key2.get("midper"));
	        	strXML.append("' displayValue='");
	        	strXML.append(key2.get("midper"));
	        	strXML.append("%(");
	        	strXML.append(key2.get("midps"));
	        	strXML.append("盘)");        	
	        	strXML.append("'/>");
	        }
	        strXML.append("</dataset>");
	        strXML.append("<dataset lineThickness='3' seriesName='初级超标率(%)' renderAs='Line' parentYAxis='S' showValues='1'>");
//	        for (HunnintuView hv : hntviews) {
	        for(int i=0;i<array.size();i++){
				JSONObject key2=array.getJSONObject(i);
	        	strXML.append("<set value='"); 
	        	strXML.append(key2.get("lowper"));
	        	strXML.append("' displayValue='");
	        	strXML.append(key2.get("lowper"));
	        	strXML.append("%(");
	        	strXML.append(key2.get("lowps"));
	        	strXML.append("盘)");        	
	        	strXML.append("'/>");
	        }
	         
	        strXML.append("</dataset>"); 
	        strXML.append("</chart>");
			return strXML.toString();
		}
}
