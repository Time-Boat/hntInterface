package com.shtoone.qms.service.impl.bhz;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.V_SmsinfoEntity;
import com.shtoone.qms.service.bhz.V_SmsinfoServiceI;
import com.shtoone.qms.service.bhz.V_SmsinfoServiceI;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl.Db2Page;
import org.jeecgframework.core.util.StringUtil;

@Service("V_SmsinfoService")
@Transactional
public class V_SmsinfoServiceImpl extends CommonServiceImpl implements V_SmsinfoServiceI {


	
	public JSONObject getDatagrid(V_SmsinfoEntity V_Smsinfo, DataGrid dataGrid,
			Integer userlft, Integer userrgt, String starttime, String endtime) {
		// TODO Auto-generated method stub
		
		String sql="select * from V_Smsinfo ";
		
		String sqlCnt = "select count(*) from V_Smsinfo ";
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		
		System.out.println(sql.toString());
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(),dataGrid.getPage(), dataGrid.getRows());
		Db2Page[] db2Pages = {
				new Db2Page("syjid","SYJID"),
				new Db2Page("departname","departname"),
				new Db2Page("fasongshijian","fasongshijian"),
				new Db2Page("shebeijiancheng","shebeijiancheng"),
				new Db2Page("fasongcontent","fasongcontent"),
				new Db2Page("fasongstatus","fasongstatus"),
				new Db2Page("fasongname","fasongname"),
				new Db2Page("chuli","chuli")				
		};
		
		JSONObject jObject = getJsonDatagridEasyUI(mapList,iCount.intValue(),db2Pages);
		return jObject;
	}
	
}