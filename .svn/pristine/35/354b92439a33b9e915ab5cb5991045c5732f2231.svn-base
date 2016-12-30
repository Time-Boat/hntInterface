package org.jeecgframework.web.demo.service.impl.test;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.jeecgframework.web.demo.entity.test.JeecgJdbcEntity;
import org.jeecgframework.web.demo.service.test.JeecgJdbcServiceI;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.JeecgSqlUtil;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("jeecgJdbcService")
@Transactional
public class JeecgJdbcServiceImpl extends CommonServiceImpl implements JeecgJdbcServiceI {
	
	@Autowired
	private JdbcDao jdbcDao;

	// wait to do: 参数(JeecgJdbcEntity pageObj, DataGrid dataGrid)中用到的数据不多，可以考虑变一下。。。
	// 实际上只有query的条件，以及dataGrid里的分页的数据
	
	// 方式1, 用底层自带的方式往对象中设值  -------------------
	
	public void getDatagrid1(JeecgJdbcEntity pageObj, DataGrid dataGrid) {
		//*
		String sqlWhere = getSqlWhere(pageObj);
		
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from jeecg_demo t";
		if (!sqlWhere.isEmpty()) {
			sqlCnt += " where" + sqlWhere;
		}
		Long iCount = getCountForJdbcParam(sqlCnt, null);

		
		String sql = "select t.id,t.user_name as userName,d.departname as depId,t.sex,t.age,t.birthday,t.email,t.mobile_phone as mobilePhone from jeecg_demo t left join t_s_depart d on d.id=t.dep_id";
		if (!sqlWhere.isEmpty()) {
			sql += " where" + sqlWhere;
		}
		// 结果往JeecgDemo这个类的各属性中设值（属性名如果和数据库中不一致，需要在SQL文中命别名，如userName）
		List list = findObjForJdbc(sql, dataGrid.getPage(), dataGrid.getRows(), JeecgJdbcEntity.class);
		// sex(性别的处理见方式2,可类似处理，重新循环一遍)
		
		// 返回Grid数据
		dataGrid.setResults(list);
		dataGrid.setTotal(iCount.intValue());
	}
	// end of 方式1 ========================================= */ 
	
	// 方式2, 取值自己处理(代码量多一些，但执行效率应该会稍高一些)  -------------------------------
	
	public void getDatagrid2(JeecgJdbcEntity pageObj, DataGrid dataGrid) {
		String sqlWhere = getSqlWhere(pageObj);
		
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from jeecg_demo t";
		if (!sqlWhere.isEmpty()) {
			sqlCnt += " where" + sqlWhere;
		}
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		
		
		String sql = "select t.*,d.departname from jeecg_demo t left join t_s_depart d on d.id=t.dep_id";
		if (!sqlWhere.isEmpty()) {
			sql += " where" + sqlWhere;
		}
		List<Map<String, Object>> mapList = findForJdbc(sql, dataGrid.getPage(), dataGrid.getRows());
		
		List list = new ArrayList();
		JeecgJdbcEntity obj = null;
		for(Map<String,Object> m:mapList){
			try {
				obj = new JeecgJdbcEntity();
				obj.setId((String)m.get("id"));
				obj.setUserName((String)m.get("user_name"));
				obj.setDepId((String)m.get("departname"));
				String sex = (String)m.get("sex");
				if (sex == null) {
					obj.setSex("");
				} else if (sex.equals("0")) {
					obj.setSex("男");
				} else {
					obj.setSex("女");
				}
				obj.setAge((Integer)m.get("age"));
				Date birthday = (Date)m.get("birthday");
				if (birthday != null) {
					obj.setBirthday(birthday);
				}
				obj.setEmail((String)m.get("email"));
				obj.setMobilePhone((String)m.get("mobile_phone"));
				list.add(obj);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 返回Grid数据
		dataGrid.setResults(list);
		dataGrid.setTotal(iCount.intValue());
	}
	// end of 方式2 ========================================= */ 
	
	// 推荐方法
	// 方式3, 取值进一步自己处理(直接转换成easyUI的datagrid需要的东西，执行效率最高，最自由)  -------------------------------
	
	public JSONObject getDatagrid3(JeecgJdbcEntity pageObj, DataGrid dataGrid) {
		String sqlWhere = getSqlWhere(pageObj);
		
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from jeecg_demo t";
		if (!sqlWhere.isEmpty()) {
			sqlCnt += " where" + sqlWhere;
		}
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		
		// 取出当前页的数据 
		String sql = "select t.*,d.departname from jeecg_demo t left join t_s_depart d on d.id=t.dep_id";
		if (!sqlWhere.isEmpty()) {
			sql += " where" + sqlWhere;
		}
		List<Map<String, Object>> mapList = findForJdbc(sql, dataGrid.getPage(), dataGrid.getRows());

		// 将结果集转换成页面上对应的数据集
		Db2Page[] db2Pages = {
				new Db2Page("id")
				,new Db2Page("userName", "user_name", null)
				,new Db2Page("depId", "departName", null)
				,new Db2Page("sex", null,new MyDataExchangerSex())
				,new Db2Page("age")
				,new Db2Page("birthday")
				,new Db2Page("email")
				,new Db2Page("mobilePhone", "mobile_phone", null)
		};
		JSONObject jObject = getJsonDatagridEasyUI(mapList, iCount.intValue(), db2Pages);
		return jObject;
		// end of 方式3 ========================================= */
	}
	
	// 拼查询条件（where语句）
	String getSqlWhere(JeecgJdbcEntity pageObj) {
		// 拼出条件语句
		String sqlWhere = "";
		if (StringUtil.isNotEmpty(pageObj.getUserName())) {
			if (!sqlWhere.isEmpty()) {
				sqlWhere += " and";
			}
			sqlWhere += " t.user_name like '%" + pageObj.getUserName() + "%'";
		}
		if (StringUtil.isNotEmpty(pageObj.getMobilePhone())) {
			if (!sqlWhere.isEmpty()) {
				sqlWhere += " and";
			}
			sqlWhere += " t.mobile_phone like '%" + pageObj.getMobilePhone() + "%'";
		}
		return sqlWhere;
	}
	
	
	
	// 性别的数据变换实体
	class MyDataExchangerSex implements IMyDataExchanger {
		public Object exchange(Object value) {
			if (value == null) {
				return "";
			} else if ("0".equals(value.toString())) {
				return "男";
			} else {
				return "女";
			}
		}
	}
	
	public void listAllByJdbc(DataGrid dataGrid) {
		//从对应路径中，获取SQL [/jeecg/demo/sql/test/JeecgJdbcService_listAllByJdbc.sql]
		String sql = JeecgSqlUtil.getMethodSql(JeecgSqlUtil.getMethodUrl());
		
		String countsql = JeecgSqlUtil.getCountSqlBySql(sql);
		List<Map<String, Object>> maplist =  jdbcDao.findForJdbcParam(sql, dataGrid.getPage(), dataGrid.getRows());
		Long count = jdbcDao.getCountForJdbcParam(countsql);
		dataGrid.setTotal(count.intValue());
		dataGrid.setResults(maplist);
	}
	
	public static void main(String[] args) {
		JeecgJdbcServiceImpl service = new JeecgJdbcServiceImpl();
		service.listAllByJdbc(null);
	}
}