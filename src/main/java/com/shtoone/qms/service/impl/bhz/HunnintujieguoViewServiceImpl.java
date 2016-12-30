package com.shtoone.qms.service.impl.bhz;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.HunnintujieguoViewEntity;
import com.shtoone.qms.service.bhz.HunnintujieguoViewServiceI;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;

@Service("hunnintujieguoViewService")
@Transactional
public class HunnintujieguoViewServiceImpl extends CommonServiceImpl implements HunnintujieguoViewServiceI {
	
	@Autowired
	private JdbcDao jdbcDao;
	
	// 方式3, 取值进一步自己处理(直接转换成easyUI的datagrid需要的东西，执行效率最高，最自由)  -------------------------------	
		public JSONObject getDatagrid3(HunnintujieguoViewEntity pageObj, DataGrid dataGrid,
				String departid,String startTime,String endTime,String leixing,String chulijieguoType,
				String gongchengmingcheng,String jiaozuobuwei,String shebeibianhao,String xinxibianhao, String userlft, String userrgt) {
			
			StringBuilder queryCondition = new StringBuilder("");
			queryCondition.append(" (convert(datetime,chuliaoshijian,121) between '" + startTime
			+ "' and '" + endTime + "')");
			
			if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
				queryCondition.append(" and lft >= '"+userlft
						+"' and rgt <= '" + userrgt + "'");
			}
			
			System.out.println(queryCondition.toString());
//			if(StringUtil.isNotEmpty(departid)){
//				queryCondition.append(" and departid='"+departid+"'");
//			}
			if(StringUtil.isNotEmpty(gongchengmingcheng)){
				queryCondition.append(" and gongchengmingcheng like '%"+gongchengmingcheng+"%'");
			}
			if(StringUtil.isNotEmpty(jiaozuobuwei)){
				queryCondition.append(" and jiaozuobuwei like '%"+jiaozuobuwei+"%'");
			}
			if(StringUtil.isNotEmpty(shebeibianhao)){
				queryCondition.append(" and shebeibianhao ='"+shebeibianhao+"'");
			}
			if(StringUtil.isNotEmpty(xinxibianhao)){
				queryCondition.append(" and xinxibianhao ='"+xinxibianhao+"'");
			}
			if(StringUtil.isEmpty(chulijieguoType)){
				chulijieguoType="0";//未处理
			}
			if(new Integer(chulijieguoType)==0){
	        	queryCondition.append(" and  isnull(filepath,'')=''  and isnull(chulijieguo,'')='' ");
	        }else{
	        	queryCondition.append(" and (  isnull(filepath,'')<>'' or  isnull(chulijieguo,'')<>''  ) ");
	        }
			if(StringUtil.isEmpty(leixing)){
				leixing="0";
			}
	        switch (new Integer(leixing)) {
	           case 1: queryCondition.append(" and  leixing=1 ");
	           break;
	           case 2: queryCondition.append(" and  leixing=2 ");
	           break;
	           case 3: queryCondition.append(" and  leixing=3 ");
	           break;
	           default:break;
	        }
	       
			// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
			String sqlCnt = "select count(*) from HunnintujieguoView t where"+queryCondition.toString();
			Long iCount = getCountForJdbcParam(sqlCnt, null);
			
			// 取出当前页的数据 
			StringBuffer sql = new StringBuffer();
			sql.append("select * from HunnintujieguoView t where"+queryCondition.toString());
			
			//System.out.println(sql.toString());
			List<Map<String, Object>> mapList = findForJdbc(sql.toString(), dataGrid.getPage(), dataGrid.getRows());
			// 将结果集转换成页面上对应的数据集
			Db2Page[] db2Pages = {
					new Db2Page("id")
					//,new Db2Page("quanju","全局")
					,new Db2Page("departid")
					,new Db2Page("shebeibianhao")
					,new Db2Page("banhezhanminchen")
					,new Db2Page("gongchengmingcheng")
					,new Db2Page("jiaozuobuwei")
					,new Db2Page("sigongdidian")					
					,new Db2Page("qiangdudengji")					
					,new Db2Page("peifanghao")
					,new Db2Page("chuliaoshijian")
					,new Db2Page("baocunshijian")
					,new Db2Page("xinxibianhao")					
					,new Db2Page("leixing")
					,new Db2Page("filepath")
					,new Db2Page("smsbaojin")
					,new Db2Page("leiji")
					,new Db2Page("jianchen")
					,new Db2Page("chulishijian")
					,new Db2Page("shenpidate")
					,new Db2Page("chuliren")
					,new Db2Page("shenpiren")
			};
			JSONObject jObject = getJsonDatagridEasyUI(mapList, iCount.intValue(), db2Pages);
			return jObject;
			// end of 方式3 ========================================= */
		}
		
		
		
		/*// 性别的数据变换实体
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
		}*/
}