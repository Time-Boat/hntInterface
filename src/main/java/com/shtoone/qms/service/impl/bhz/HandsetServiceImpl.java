package com.shtoone.qms.service.impl.bhz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.app.entity.AppInterfaceHandSetBean;
import com.shtoone.qms.entity.bhz.HandsetEntity;
import com.shtoone.qms.service.bhz.HandsetServiceI;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;

@Service("handsetService")
@Transactional
public class HandsetServiceImpl extends CommonServiceImpl implements HandsetServiceI {

	// 方式3, 取值进一步自己处理(直接转换成easyUI的datagrid需要的东西，执行效率最高，最自由)  -------------------------------	
	public JSONObject getDatagrid3(HandsetEntity pageObj, DataGrid dataGrid,String departid, String userlft, String userrgt) {
		StringBuilder queryCondition = new StringBuilder("");
		queryCondition.append(" 1=1 ");
		if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
			queryCondition.append(" and lft >= '"+userlft+"' and rgt <= '" + userrgt + "'");
		}
	        
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from handsetView t where"+queryCondition.toString();
		Long iCount = getCountForJdbcParam(sqlCnt, null);
			
		// 取出当前页的数据 
		StringBuffer sql = new StringBuffer();
		sql.append("select * from handsetView t where"+queryCondition.toString());
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(), dataGrid.getPage(), dataGrid.getRows());
		// 将结果集转换成页面上对应的数据集
			
		Db2Page[] db2Pages = {new Db2Page("id")
							 ,new Db2Page("name")
							 ,new Db2Page("phone")
							 ,new Db2Page("biaoduan")
							 ,new Db2Page("owername")
		};
		return getJsonDatagridEasyUI(mapList, iCount.intValue(), db2Pages);
	}
		
	
	//app新增方法+++
	@Autowired
	private JdbcDao jdbcDao;
	
	public List<AppInterfaceHandSetBean> getHandSet(String phone){
		List<AppInterfaceHandSetBean> handsetsList=null;
		String sql="select * from handset where 1=1 and ISNULL(name,'')<>'' ";
		if(StringUtil.isNotEmpty(phone)){
			sql+=" and a.phone='"+phone+"'";
		}
		handsetsList=jdbcDao.find(sql, AppInterfaceHandSetBean.class, new HashMap<String, String>());
		if(handsetsList.size()>0){
			return handsetsList;
		}else{
			return null;
		}
	}
	
}