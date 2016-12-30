package com.shtoone.qms.service.impl.bhz;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.V_YalijiEntity;
import com.shtoone.qms.service.bhz.V_YalijiServiceI;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl.Db2Page;
import org.jeecgframework.core.util.StringUtil;

@Service("v_YalijiService")
@Transactional
public class V_YalijiServiceImpl extends CommonServiceImpl implements V_YalijiServiceI {
	@Autowired
	private JdbcDao  jdbcDao;
	
	public JSONObject getDatagrid3(V_YalijiEntity v_Yaliji,
			DataGrid dataGrid,String shebeibianhao,String rtcode,
			String sjbh,String wtbh,String cjmc,String sjqd,String lq,
			String pdjg,String startTime,String endTime,
			String userlft,String userrgt){
		StringBuffer queryCondition = new StringBuffer("");
		queryCondition.append(" SYRQ between '"+startTime+"' and '"+endTime+"'");
		if(StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)){
			queryCondition.append("and lft >='"+userlft+"' and  rgt <='"+userrgt+"'");
		}
		/*
		if(StringUtil.isNotEmpty(shebeibianhao)){
			queryCondition.append("");
		}
		*/
		
		String sqlCnt = "select count(*) from V_Yaliji t where"+queryCondition.toString();
		Long iCount = getCountForJdbcParam(sqlCnt, null);
					
		// 取出当前页的数据 
		StringBuffer sql = new StringBuffer();
		sql.append("select * from V_Yaliji t where"+queryCondition.toString());
		System.out.println(sql.toString());
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(), dataGrid.getPage(), dataGrid.getRows());			
		
	
		// 将结果集转换成页面上对应的数据集
					Db2Page[] db2Pages = {
							new Db2Page("id")
							//,new Db2Page("quanju","全局")
							,new Db2Page("departid")
							,new Db2Page("f_Trname","fTrname")
		
						
							,new Db2Page("rtcode")								
							,new Db2Page("wtbh")
							,new Db2Page("shebeijiancheng")
							,new Db2Page("testname")
							,new Db2Page("cjmc")
							,new Db2Page("sjbh")
							,new Db2Page("syrq")
							,new Db2Page("lq")
							
							,new Db2Page("sjcc")
							,new Db2Page("sjqd")
							,new Db2Page("kylz")
							,new Db2Page("kyqd")
							,new Db2Page("qddbz")
							,new Db2Page("pdjg")
				
					};
					JSONObject jObject = getJsonDatagridEasyUI(mapList, iCount.intValue(), db2Pages);
					return jObject;
	}
}