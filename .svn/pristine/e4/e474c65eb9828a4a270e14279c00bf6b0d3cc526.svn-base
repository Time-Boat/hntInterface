package com.shtoone.qms.service.impl.bhz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.HanshuilvSyEntity;
import com.shtoone.qms.service.bhz.HanshuilvSyServiceI;

import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;

@Service("hanshuilvSyServiceI")
@Transactional
public class HanshuilvSyServiceImpl extends CommonServiceImpl implements HanshuilvSyServiceI {
	public JSONObject getDatagrid(HanshuilvSyEntity hanshuilv, DataGrid dataGrid,String startTime
			,String endTime,Integer userlft,Integer userrgt,String clmc,String shebeibianhao){
		StringBuilder sql=new StringBuilder("select * from HanshuilvSyView where 1=1 ");
		StringBuilder sqlCount=new StringBuilder("select Count(*) from HanshuilvSyView where 1=1 ");
		StringBuilder query = new StringBuilder("");
		if(StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)){
			query.append(" and (convert(datetime,JCSJ,121) between '"+ startTime + "' and '" + endTime + "')");
		}
		if (StringUtil.isNotEmpty(shebeibianhao)) {
			query.append(" and SBBH='" + shebeibianhao+ "'");
		}
		if (StringUtil.isNotEmpty(clmc)) {
			query.append(" and CLMC like '%"+ clmc + "%'");
		}
		if(userlft>0 && userrgt>0){
			query.append(" and lft >= '"+userlft+"'"+" and rgt<= '"+userrgt+"'");
		}
		//总页数
		sqlCount.append(query.toString());
		Long iCount = getCountForJdbcParam(sqlCount.toString(), null);
		sql.append(query.toString());
		sql.append(" order by JCSJ desc");
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(),dataGrid.getPage(), dataGrid.getRows());
		Db2Page[] db2Pages = {new Db2Page("id", "id"),
				 			  new Db2Page("SYJID", "shebeiname"),
				 			  new Db2Page("SBBH", "SBBH"),
				 			  new Db2Page("CLMC", "CLMC"),
				 			  new Db2Page("JCSJ", "JCSJ"),
				 			  new Db2Page("SZL", "SZL"),			
				 			  new Db2Page("GZL", "GZL"),
				 			  new Db2Page("HSL", "HSL"),
				 			  new Db2Page("SJSCSJ", "SJSCSJ"),
				 			  new Db2Page("CZRY", "CZRY"),
				 			  new Db2Page("SGPHB", "SGPHB"),
				 			  new Db2Page("STATUS", "departname")};
		return getJsonDatagridEasyUI(mapList,iCount.intValue(),db2Pages);
	}
}