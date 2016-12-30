package com.shtoone.qms.service.impl.bhz;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.entity.bhz.HunnintujieguoViewEntity;
import com.shtoone.qms.entity.bhz.TophunnintuViewEntity;
import com.shtoone.qms.entity.bhz.TophunnintusyViewEntity;
import com.shtoone.qms.entity.bhz.TopsysViewEntity;
import com.shtoone.qms.service.bhz.TophunnintuViewServiceI;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl.Db2Page;
import org.jeecgframework.core.util.StringUtil;

@Service("tophunnintuViewService")
@Transactional
public class TophunnintuViewServiceImpl extends CommonServiceImpl implements TophunnintuViewServiceI {
	@Autowired
	private JdbcDao jdbcDao;
	
	// 方式3, 取值进一步自己处理(直接转换成easyUI的datagrid需要的东西，执行效率最高，最自由)  -------------------------------	
	
	public JSONObject getDatagrid3(TophunnintuViewEntity pageObj, DataGrid dataGrid,
			String departid,String biaoshi,String userlft,String userrgt,String shebeibianhao) {
		
		StringBuilder queryCondition = new StringBuilder("");
		if(StringUtil.isNotEmpty(departid)){
			queryCondition.append(" and departid like '%"+departid+"%'");
		}
		
		
		if(StringUtil.isEmpty(biaoshi)){
			biaoshi="0";
		}
		
		if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
			queryCondition.append(" and lft >= '"+userlft
					+"' and rgt <= '" + userrgt + "'");
		}
		
		if(StringUtil.isNotEmpty(shebeibianhao)){
			queryCondition.append(" and shebeibianhao ='"+shebeibianhao+"'");
		}
		
		Calendar day=Calendar.getInstance();
    	day.add(Calendar.DATE, -1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        switch (new Integer(biaoshi)) {
           case 1: queryCondition.append(" and convert(datetime,caijishijian,120) >='" + sdf.format(day.getTime()) + "'  and   cast(caijiyanshi as float) <=1200  and  cast(shangchuanyanshi as float)<=1800  ");
           break;
           case 2: queryCondition.append(" and convert(datetime,caijishijian,120) >='" + sdf.format(day.getTime()) + "'  and  ( cast(caijiyanshi as float) >1200  or  cast(shangchuanyanshi as float)>1800 ) ");
           break;
           case 3: queryCondition.append(" and convert(datetime,caijishijian,120) <'" + sdf.format(day.getTime()) + "'");
           break;
           default:break;
        }
        
     // 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
     			String sqlCnt = "select count(*) from TophunnintuView t where 1=1 "+queryCondition.toString();
     			Long iCount = getCountForJdbcParam(sqlCnt, null);
     			
     			// 取出当前页的数据 
     			StringBuffer sql = new StringBuffer();
     			sql.append("select * from TophunnintuView t where 1=1 "+queryCondition.toString());
     			//System.out.println(sql.toString());
    			List<Map<String, Object>> mapList = findForJdbc(sql.toString(), dataGrid.getPage(), dataGrid.getRows());
    			List<Map<String,Object>> returnMapList=new ArrayList<Map<String,Object>>();
    			for(Map<String,Object> temp:mapList){
    				String caijishijian=(String)temp.get("caijishijian");
    				String shangchuanyanshitemp=(String)temp.get("shangchuanyanshi");
    				Date caiji = day.getTime();					    	
			    	try {
			    		caiji = sdf.parse(caijishijian);
						} catch (ParseException ex) {
							
					}
			    	if (caiji.after(day.getTime()))
			    	{
			    		   double caijiyanshi =0;
							try {
								caijiyanshi = StringUtil.StrToZero(caijishijian);
							} catch (Exception e) {
							}
							double shangchuanyanshi =0;
							try {
								shangchuanyanshi = StringUtil.StrToZero(shangchuanyanshitemp);
							} catch (Exception e) {
							}
							if  ((caijiyanshi<=1200) && (shangchuanyanshi<=1800))
							{
								//thv.setBiaoshi("正常工作");
								//thv.setGujifangshu("1");
								temp.put("biaoshi", "正常工作");
								temp.put("gujifangshu", "1");
							} else {
								//thv.setBiaoshi("延时");
								//thv.setGujifangshu("2");
								temp.put("biaoshi", "延时");
								temp.put("gujifangshu", "2");
							}
			    	}
			    	else {
			    		//  thv.setBiaoshi("未工作"); thv.setGujifangshu("3");
			    		temp.put("biaoshi", "未工作");
						temp.put("gujifangshu", "3");
			    	}
			    	
			    	returnMapList.add(temp);
    			}
    			
    			// 将结果集转换成页面上对应的数据集
    			Db2Page[] db2Pages = {
    					new Db2Page("id")
    					,new Db2Page("departid")
    					,new Db2Page("banhezhanminchen")
    					,new Db2Page("chuliaoshijian")
    					,new Db2Page("baocunshijian")
    					,new Db2Page("caijishijian")
    					,new Db2Page("biaoshi")
    					
    			};
    			JSONObject jObject = getJsonDatagridEasyUI(mapList, iCount.intValue(), db2Pages);
    			return jObject;
		
	}

	
	public List<TophunnintusyViewEntity> getDatagrid4(
			String userlft, String userrgt) {
		// TODO Auto-generated method stub
		StringBuilder queryCondition = new StringBuilder("where 1=1");
		if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
			queryCondition.append(" and lft >= '"+userlft
					+"' and rgt <= '" + userrgt + "'");
		}
		String sqlCnt = "select * from TophunnintusyView t " +queryCondition.toString();
		List<TophunnintusyViewEntity> mapList = jdbcDao.find(sqlCnt, TophunnintusyViewEntity.class, new HashMap<String, String>());;
		
		return mapList;
	}
	
	
	public List<TophunnintuViewEntity> getDatagrid5(
			String userlft, String userrgt) {
		// TODO Auto-generated method stub
		StringBuilder queryCondition = new StringBuilder("where 1=1");
		if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
			queryCondition.append(" and lft >= '"+userlft
					+"' and rgt <= '" + userrgt + "'");
		}
		String sqlCnt = "select * from TophunnintuView t "+queryCondition.toString();
		List<TophunnintuViewEntity> mapList = jdbcDao.find(sqlCnt, TophunnintuViewEntity.class, new HashMap<String, String>());;
		
		return mapList;
	}
	
	
	public List<TopsysViewEntity> getDatagrid6(
			String userlft, String userrgt) {
		// TODO Auto-generated method stub
		StringBuilder queryCondition = new StringBuilder("where 1=1");
		if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
			queryCondition.append(" and lft >= '"+userlft
					+"' and rgt <= '" + userrgt + "'");
		}
		String sqlCnt = "select * from TopsysView t "+queryCondition.toString();
		List<TopsysViewEntity> mapList = jdbcDao.find(sqlCnt, TopsysViewEntity.class, new HashMap<String, String>());;
		
		return mapList;
	}
	
	
}