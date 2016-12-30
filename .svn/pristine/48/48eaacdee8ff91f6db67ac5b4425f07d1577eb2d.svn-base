package com.shtoone.qms.service.impl.bhz;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.HntviewEntity;
import com.shtoone.qms.service.bhz.Xiangxixx2015ServiceI;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;


@Service("Xiangxixx2015Service")
@Transactional
public class Xiangxixx2015ServiceImpl extends CommonServiceImpl implements Xiangxixx2015ServiceI {

	
	public JSONObject getDatagrid3(HntviewEntity pageObj, DataGrid dataGrid, String lft, String rgt) {
          String sqlWhere = getSqlWhere(pageObj, lft, rgt);
		
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from Hntview t";
		if (!sqlWhere.isEmpty()) {
			sqlCnt += " where" + sqlWhere;
		}
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		
		// 取出当前页的数据 
		String sql = "select t.* from Hntview t";
		if (!sqlWhere.isEmpty()) {
			sql += " where" + sqlWhere;
		}
		List<Map<String, Object>> mapList = findForJdbc(sql, dataGrid.getPage(), dataGrid.getRows());

		// 将结果集转换成页面上对应的数据集
		Db2Page[] db2Pages = {
				new Db2Page("id")
				,new Db2Page("chaozuozhe")
				,new Db2Page("sha1Shijizhi","sha1_shijizhi")
		};
		JSONObject jObject = getJsonDatagridEasyUI(mapList, iCount.intValue(), db2Pages);
		return jObject;
		// end of 方式3 ========================================= */
	}
	
	// 拼查询条件（where语句）
		String getSqlWhere(HntviewEntity pageObj, String lft, String rgt) {
			// 拼出条件语句
			String sqlWhere = "";
			if (StringUtil.isNotEmpty(pageObj.getLft())) {
				if (!sqlWhere.isEmpty()) {
					sqlWhere += " and";
				}
				sqlWhere += " t.lft between " + lft + " and " + rgt;
			}
			
			return sqlWhere;
		}
}