package com.shtoone.qms.service.impl.bhz;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.V_ConsignEntity;
import com.shtoone.qms.entity.bhz.V_SYJZBEntity;
import com.shtoone.qms.service.bhz.V_ConsignServiceI;
import com.shtoone.qms.service.bhz.V_SYJZBServiceI;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl.Db2Page;
import org.jeecgframework.core.util.StringUtil;

@Service("V_ConsignService")
@Transactional
public class V_ConsignServiceImpl extends CommonServiceImpl implements V_ConsignServiceI {


	public JSONObject getDatagrid(V_ConsignEntity V_SYJZB, DataGrid dataGrid,
			Integer userlft, Integer userrgt, String starttime, String endtime) {
		// TODO Auto-generated method stub
		StringBuilder queryCtest = new StringBuilder("where 1=1");
		if(userlft>0 && userrgt>0){
			queryCtest.append(" and lft >= '"+userlft+"'"+" and rgt<= '"+userrgt+"'" );
		}
		 
			queryCtest.append(" and   SYRQ between '"+starttime+"' and '"+endtime+"'");
		 
		 
		StringBuffer sql = new StringBuffer();
		sql.append("select * from V_Consign where datediff(day,QYRQ,getdate())>= CONVERT(int, SYSULiang) and rgt = lft + 1 and SYXM='100014' and MSTATUS=0");
		
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from V_Consign where datediff(day,QYRQ,getdate())>= CONVERT(int, SYSULiang) and rgt = lft + 1 and SYXM='100014' and MSTATUS=0 ";
		System.out.println(sqlCnt);
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		
		System.out.println(sql.toString());
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(),dataGrid.getPage(), dataGrid.getRows());
		Db2Page[] db2Pages = {
				new Db2Page("F_TRNAME","Ftrname"),
				new Db2Page("WTBH","WTBH"),
				new Db2Page("SGBW","SGBW"),
				new Db2Page("QYDD","QYDD"),
				new Db2Page("DDSL","DDSL"),
				new Db2Page("QYRQ","QYRQ"),
				new Db2Page("SYSULiang","SYSULiang"),
				new Db2Page("GGZL","GGZL"),
				new Db2Page("SYSL","SYSL"),
				new Db2Page("id","id")
				
		};
		
		JSONObject jObject = getJsonDatagridEasyUI(mapList,iCount.intValue(),db2Pages);
		return jObject;
	}
	
}