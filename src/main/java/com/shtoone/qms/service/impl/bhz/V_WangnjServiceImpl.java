package com.shtoone.qms.service.impl.bhz;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.V_WangnjEntity;
import com.shtoone.qms.service.bhz.V_WangnjServiceI;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl.Db2Page;
import org.jeecgframework.core.util.StringUtil;

@Service("v_WangnjService")
@Transactional
public class V_WangnjServiceImpl extends CommonServiceImpl implements V_WangnjServiceI {
	@Autowired
	private JdbcDao  jdbcDao;
	
	public JSONObject getDatagrid3(V_WangnjEntity V_Wangnj,
			DataGrid dataGrid,String startTime,
			String endTime,String shebeibianhao,String testname,String pzbm,
			String gcmc,String sgbw,String sjbh,String pdjg,
			String userlft,String userrgt){
			StringBuffer queryCondition = new StringBuffer("");
		
			queryCondition.append(" SYRQ between '"+startTime+"' and '"+endTime+"'");
			
			if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
				queryCondition.append("and lft >= '"+userlft
						+"' and rgt <= '" + userrgt + "'");
			if(StringUtil.isNotEmpty(shebeibianhao)){
				queryCondition.append("and shebeibianhao ='" +shebeibianhao+"'" );
			}	
				
			if(StringUtil.isNotEmpty(testname)){
				queryCondition.append("and testname like '%"+testname+"%'");
				
			}
			if(StringUtil.isNotEmpty(pzbm)){
				queryCondition.append("and pzbm like '%"+pzbm+"%'");
			}
			if(StringUtil.isNotEmpty(gcmc)){
				queryCondition.append("and gcmc like '%"+gcmc+"%'");
			}
			if(StringUtil.isNotEmpty(sgbw)){
				queryCondition.append("and sgbw like '%"+sgbw+"%'");
			}
			if(StringUtil.isNotEmpty(sjbh)){
				queryCondition.append("and sjbh like '%"+sjbh+"%'");
			}
			if(StringUtil.isNotEmpty(pdjg)){
				queryCondition.append("and pdjg like '%"+pdjg+"%'");
			}
	
				/*
				
				if(StringUtil.isNotEmpty(testname)){
					queryCondition.append("and testname like '%"+testname+"%'");
				}
				if(StringUtil.isNotEmpty(testname)){
					queryCondition.append("and PZBM like '%"+pzbm+"%'");
				}
				*/}
			
			String sqlCnt = "select count(*) from V_Wangnj t where"+queryCondition.toString();
			Long iCount = getCountForJdbcParam(sqlCnt, null);
						
			// 取出当前页的数据 
			StringBuffer sql = new StringBuffer();
			sql.append("select * from V_Wangnj t where"+queryCondition.toString());
			System.out.println(sql.toString());
			List<Map<String, Object>> mapList = findForJdbc(sql.toString(), dataGrid.getPage(), dataGrid.getRows());			
			
		
			// 将结果集转换成页面上对应的数据集
						Db2Page[] db2Pages = {
								new Db2Page("id")
								//,new Db2Page("quanju","全局")
								,new Db2Page("departid")
								,new Db2Page("shebeijiancheng")
								,new Db2Page("fTrname","f_Trname")
								,new Db2Page("f_Guid","f_Guid")
								,new Db2Page("testname")
								,new Db2Page("gcmc")
								,new Db2Page("sjbh")
								,new Db2Page("syrq")
								,new Db2Page("ggzl")
								,new Db2Page("pzbm")
								,new Db2Page("qflz")
								,new Db2Page("qfqd")
								,new Db2Page("lz")
								,new Db2Page("lzqd")
								,new Db2Page("scl")
								,new Db2Page("pdjg")								
								,new Db2Page("sgbw")
						
						};
						JSONObject jObject = getJsonDatagridEasyUI(mapList, iCount.intValue(), db2Pages);
						return jObject;
	}
}