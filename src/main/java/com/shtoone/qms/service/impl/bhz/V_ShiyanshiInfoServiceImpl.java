package com.shtoone.qms.service.impl.bhz;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.third.org.hsqldb.lib.StringUtil;
import com.shtoone.qms.entity.bhz.SYclAllEntity;
import com.shtoone.qms.entity.bhz.SYclAllzhviewEntity;
import com.shtoone.qms.entity.bhz.V_ShiyanshiInfoEntity;
import com.shtoone.qms.service.bhz.V_ShiyanshiInfoServiceI;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl.Db2Page;

@Service("v_ShiyanshiInfoService")
@Transactional
public class V_ShiyanshiInfoServiceImpl extends CommonServiceImpl implements V_ShiyanshiInfoServiceI {

	
	public JSONObject getDatagrid(V_ShiyanshiInfoEntity  bhgview,
			DataGrid dataGrid  ,Integer lft,Integer rgt) {
		StringBuilder queryCtest = new StringBuilder(" 1=1");
		if(lft>0 && rgt>0){
			queryCtest.append(" and lft >= '"+lft+"'"+" and rgt<= '"+rgt+"'" );
		}
		StringBuffer sql = new StringBuffer();
		sql.append("select * "
				+ " from V_ShiyanshiInfo "
				+ " where "+queryCtest.toString() );
		
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from V_ShiyanshiInfo t     where"
						+ queryCtest.toString();
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(),dataGrid.getPage(), dataGrid.getRows());
		Db2Page[] db2Pages = {
				new Db2Page("id","id"),
				new Db2Page("departname","departname"),
				new Db2Page("fTrcode","F_TRCODE"),
				new Db2Page("fJcqd","F_JCQD"),
				new Db2Page("fAddress","F_ADDRESS"),
				new Db2Page("fTel","F_TEL"),
				new Db2Page("fMothroom","F_MOTHROOM"),
				new Db2Page("fMothauth","F_MOTHAUTH"),
				new Db2Page("fMothvaliddate","F_MOTHVALIDDATE") 
		};
		
		JSONObject jObject = getJsonDatagridEasyUI(mapList,iCount.intValue(),db2Pages);
		return jObject;
	}

	
}