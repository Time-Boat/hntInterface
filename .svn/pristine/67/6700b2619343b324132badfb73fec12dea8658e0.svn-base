package com.shtoone.qms.service.impl.bhz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.V_SYJZBEntity;
import com.shtoone.qms.service.bhz.V_SYJZBServiceI;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl.Db2Page;
import org.jeecgframework.core.util.StringUtil;

@Service("v_SYJZBService")
@Transactional
public class V_SYJZBServiceImpl extends CommonServiceImpl implements V_SYJZBServiceI {


	public JSONObject getDatagrid(V_SYJZBEntity V_SYJZB, DataGrid dataGrid,
			Integer userlft, Integer userrgt, String starttime, String endtime) {
		// TODO Auto-generated method stub
		StringBuilder queryCtest = new StringBuilder("where 1=1");
		if(userlft>0 && userrgt>0){
			queryCtest.append(" and lft >= '"+userlft+"'"+" and rgt<= '"+userrgt+"'" );
		}
		 
			queryCtest.append(" and   SYRQ between '"+starttime+"' and '"+endtime+"'");
		 
		 
		StringBuffer sql = new StringBuffer();
		sql.append("select f.departname,f.TestName,sysl1,sysl2,sysl3,sysl4,sysl5,sysl6,"
				+ "sysl7,sysl8,sysl9,sysl10,sysl11,sysl12,sysl13,sysl14"
				+ " from (select d.departname,d.TestName,sysl1,sysl2,sysl3,sysl4,sysl5,sysl6,"
				+ "sysl7,sysl8,sysl9,"
				+ "case when sysl7!=0 then  sysl8*100/sysl7 else 0 end as sysl10,"
				+ "case when sysl7!=0 then  sysl9*100/sysl7 else 0 end as sysl11"
				+ " from (select departname,TestName,sysl1,sysl2,sysl3,sysl4,sysl5,sysl6,"
				+ "case when sysl1!=0 then  sysl4*100/sysl1 else 0 end as sysl7,"
				+ "case when sysl2!=0 then  sysl5*100/sysl2 else 0 end as sysl8,"
				+ "case when sysl3!=0 then  sysl6*100/sysl3 else 0 end as sysl9 "
				+ " from (select departname,TestName,sum(sysl1) as sysl1,"
				+ "sum(sysl2) as sysl2,sum(sysl3) as sysl3,"
				+ "sum(sysl4) as sysl4,sum(sysl5) as sysl5,sum(sysl6) as sysl6 "
				+ "from (select COUNT(*) as sysl1,case when (AREA=1) then sum(1) else sum(0) end as sysl2,"
				+ "case when (leixin=1 ) then sum(1) else sum(0) end as sysl3,"
				+ "case when (PDJG='合格') then sum(1) else sum(0) end as sysl4,"
				+ "case when (PDJG='合格' and AREA=1) then sum(1) else sum(0) end as sysl5,"
				+ "case when (PDJG='合格') then sum(1) else sum(0) end as sysl6,"
				+ "departname,TestName,parentdepartid,leixin,AREA,PDJG from V_SYJZB "
				+queryCtest
				+ " group by  departname,TestName,parentdepartid,leixin,AREA,PDJG "
				+ ")a "
				+ "group by departname,TestName )b)d)f left outer join(select departname,"
				+ "TestName,sum(sysl12) as sysl12,sum(sysl13) as sysl13,sum(sysl14) as sysl14 "
				+ " from (select departname,TestName,parentdepartid,leixin,AREA,COUNT(*) as sysl12,"
				+ "case when (AREA=1) then sum(1) else sum(0) end as sysl13,"
				+ "case when (leixin=1 ) then sum(1) else sum(0) end as sysl14 "
				+ "from  V_SYJZB "
				+queryCtest
				+ "group by  departname,TestName,parentdepartid,leixin,AREA"
				+ ") c "
				+ "group by departname,TestName) e on f.departname=e.departname and f.TestName=e.TestName");
		
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from (select count(*) as c from V_SYJZB t   "
						+ queryCtest.toString()+" group by departname,TestName )a ";
		System.out.println(sqlCnt);
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		
		System.out.println(sql.toString());
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(),dataGrid.getPage(), dataGrid.getRows());
		Db2Page[] db2Pages = {
				new Db2Page("departname","departname"),
				new Db2Page("testname","TestName"),
				new Db2Page("parentdepartid","sysl12"),
				new Db2Page("leixin","sysl13"),
				new Db2Page("area","sysl14"),
				new Db2Page("sylx","sysl1"),
				new Db2Page("wtbh","sysl2"),
				new Db2Page("sjbh","sysl3"),
				new Db2Page("sjcc","sysl4"),
				new Db2Page("sjmj","sysl5"),
				new Db2Page("sjsl","sysl6"),
				new Db2Page("sjqd","sysl7"),
				new Db2Page("zsxs","sysl8"),
				new Db2Page("qddbz","sysl9"),
				new Db2Page("cjmc","sysl10"),
				new Db2Page("pzbm","sysl11")
				
		};
		
		JSONObject jObject = getJsonDatagridEasyUI(mapList,iCount.intValue(),db2Pages);
		return jObject;
	}

	
	public JSONObject getDatagrid2(V_SYJZBEntity V_SYJZB, DataGrid dataGrid,
			Integer userlft, Integer userrgt, String starttime, String endtime) {
		// TODO Auto-generated method stub
		
		String sql="select * from V_SYJZB where  (PDJG='不合格' or PDJG='无效') ";
		
		String sqlCnt = "select count(*) from V_SYJZB where  (PDJG='不合格' or PDJG='无效') ";
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(),dataGrid.getPage(), dataGrid.getRows());
		Db2Page[] db2Pages = {
				new Db2Page("syjid","SYJID"),
				new Db2Page("wtbh","WTBH"),
				new Db2Page("departname","departname"),
				new Db2Page("syrq","SYRQ"),
				new Db2Page("testname","TestName"),
				new Db2Page("ggzl","GGZL"),
				new Db2Page("ddsl","DDSL"),
				new Db2Page("gcmc","GCMC"),
				new Db2Page("sgbw","SGBW"),
				new Db2Page("sjbh","SJBH"),
				new Db2Page("sjqd","SJQD"),
				new Db2Page("pzbm","PZBM"),
				new Db2Page("pdjg","PDJG")				
		};
		
		JSONObject jObject = getJsonDatagridEasyUI(mapList,iCount.intValue(),db2Pages);
		return jObject;
	}

	
	public JSONObject getDatagrid3(V_SYJZBEntity V_SYJZB, DataGrid dataGrid,
			Integer userlft, Integer userrgt, String starttime, String endtime) {
		// TODO Auto-generated method stub
		String sql="select a.departname,geshu,zongshu,geshu*100/zongshu as bili,PDJG from  "
				+ " (select departname,count(*) as geshu,PDJG from V_SYJZB group by departname,PDJG )a "
				+ " left outer join  (select departname,COUNT(*) as zongshu from V_SYJZB group "
				+ "by departname )b  on a.departname=b.departname ";
		
		String sqlCnt = "select count(*) from (select departname,PDJG from V_SYJZB group by departname,PDJG)a";
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(),dataGrid.getPage(), dataGrid.getRows());
		Db2Page[] db2Pages = {
				new Db2Page("departname","departname"),
				new Db2Page("wtbh","geshu"),
				new Db2Page("pdjg","PDJG"),
				new Db2Page("sylx","zongshu"),
				new Db2Page("sjbh","bili")					
		};
		
		JSONObject jObject = getJsonDatagridEasyUI(mapList,iCount.intValue(),db2Pages);
		return jObject;
	}
	
	
	public JSONObject getDatagrid4(V_SYJZBEntity V_SYJZB, DataGrid dataGrid,
			Integer userlft, Integer userrgt, String starttime, String endtime) {
		// TODO Auto-generated method stub
		
		String sql="select TestName,departname,COUNT(*) as ct from V_SYJZB  group by TestName,departname";
		
		String sqlCnt = "select count(*) from ( select TestName,departname,COUNT(*) as ct from V_SYJZB  group by TestName,departname)a";
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(),dataGrid.getPage(), dataGrid.getRows());
		Db2Page[] db2Pages = {
				new Db2Page("testname","TestName"),
				new Db2Page("departname","departname"),
				new Db2Page("ct","SYRQ")			
		};
		
		JSONObject jObject = getJsonDatagridEasyUI(mapList,iCount.intValue(),db2Pages);
		return jObject;
	}
	
	
	
	public String getHntAnalysisColumnXml(JSONObject jObject) {
		String strXML = createhntcnfxxml(jObject);
		return strXML;
	}
	
	private String createhntcnfxxml(JSONObject jObject) {
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
        strXML.append("<chart palette='2' caption='试验统计图' bgColor='#DAEDFB,#F5F9FF' "); 
        strXML.append(" showValues='0' divLineDecimalPrecision='1' limitsDecimalPrecision='1'"); 
        strXML.append(" PYAxisName='生产量(m³)' SYAxisName='超标率(%)' numberSuffix='m³'"); 
        strXML.append(" SNumberSuffix='%' PNumberSuffix='m³' formatNumberScale='0' outCnvBaseFontSize='13'>"); 
        String sxa = "年";
        String sxb;
       /* switch (cnfxlx) {
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
        if  (cnfxlx==3)
        {*/
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
  	        if (str.equalsIgnoreCase((String) key2.get("xa")))
  	        { 
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
       /* } else {
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
        }*/
        
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
        	strXML.append(")'/>");
        }
        strXML.append("</dataset>");       

        
       /* strXML.append("<dataset lineThickness='3' seriesName='高级超标率(%)' renderAs='Line' parentYAxis='S' showValues='1'>");
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
//        for (HunnintuView hv : hntviews) {
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
         
        strXML.append("</dataset>"); */
        strXML.append("</chart>");
		return strXML.toString();
	}
}