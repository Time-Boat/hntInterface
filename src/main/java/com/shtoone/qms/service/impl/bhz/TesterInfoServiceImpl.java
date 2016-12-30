package com.shtoone.qms.service.impl.bhz;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.TesterInfoViewEntity;
import com.shtoone.qms.service.bhz.TesterInfoServiceI;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl.Db2Page;
import org.jeecgframework.core.util.StringUtil;

@Service("testerInfoService")
@Transactional
public class TesterInfoServiceImpl extends CommonServiceImpl implements TesterInfoServiceI {

	
	public JSONObject getDatagrid(TesterInfoViewEntity testerview,
			DataGrid dataGrid, Integer lft, Integer rgt, String name) {
		StringBuilder queryCtest = new StringBuilder(" 1=1");
		if(lft>0 && rgt>0){
			queryCtest.append(" and lft >= '"+lft+"'"+" and rgt<= '"+rgt+"'" );
		}
		if(StringUtil.isNotEmpty(name)){
			queryCtest.append(" and   F_TRPNAME like '%"+name+"%'" );
		}
		StringBuffer sql = new StringBuffer();
		sql.append("select * "
				+ " from TesterInfoView "
				+ " where "+queryCtest.toString() );
		
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from TesterInfoView t     where"
						+ queryCtest.toString();
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(),dataGrid.getPage(), dataGrid.getRows());
		Db2Page[] db2Pages = {
				new Db2Page("id","id"),
				new Db2Page("departname","departname"),
				new Db2Page("fTrpname","F_Trpname"),
				new Db2Page("fWorkdate","F_Workdate"),
				new Db2Page("fJszc","F_Jszc"),
				new Db2Page("fZw","F_Zw"),
				new Db2Page("fbirthday","F_Birthday"),
				new Db2Page("fTrptel","F_Trptel")
		};
		
		JSONObject jObject = getJsonDatagridEasyUI(mapList,iCount.intValue(),db2Pages);
		return jObject;
	}
	
}