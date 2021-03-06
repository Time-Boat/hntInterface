package com.shtoone.qms.service.impl.bhz;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.SmsinfoViewEntity;
import com.shtoone.qms.service.bhz.SmsinfoViewServiceI;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;

@Service("smsinfoViewService")
@Transactional
public class SmsinfoViewServiceImpl extends CommonServiceImpl implements SmsinfoViewServiceI {

	// 方式3, 取值进一步自己处理(直接转换成easyUI的datagrid需要的东西，执行效率最高，最自由)  -------------------------------	
	public JSONObject getDatagrid3(SmsinfoViewEntity pageObj, DataGrid dataGrid,String departid,String startTime,String endTime,String userlft, String userrgt,String shebeibianhao) {
		StringBuilder queryCondition = new StringBuilder("");
		queryCondition.append(" (convert(datetime,shijian,121) between '" + startTime+ "' and '" + endTime + "')");
		if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
			queryCondition.append(" and lft >= '"+userlft+"' and rgt <= '" + userrgt + "'");
		}
		if(StringUtil.isNotEmpty(shebeibianhao)){
			queryCondition.append(" and shebeibianhao ='"+shebeibianhao+"'");
		}
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from SmsinfoView t where  "+queryCondition.toString();
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		// 取出当前页的数据 
		StringBuffer sql = new StringBuffer();
		sql.append("select * from SmsinfoView t where  "+queryCondition.toString() +" order by shijian desc");
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(), dataGrid.getPage(), dataGrid.getRows());
		// 将结果集转换成页面上对应的数据集
		Db2Page[] db2Pages = {new Db2Page("id")
							 ,new Db2Page("banhezhanminchen")
							 ,new Db2Page("shijian")
							 ,new Db2Page("fasongcontent")
							 ,new Db2Page("owername")
							 ,new Db2Page("fasongphone")
							 ,new Db2Page("fasongstatus")
							 ,new Db2Page("xxbianhao")};
		return getJsonDatagridEasyUI(mapList, iCount.intValue(), db2Pages);
	}
	
}