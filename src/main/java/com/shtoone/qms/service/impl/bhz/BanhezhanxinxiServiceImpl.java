package com.shtoone.qms.service.impl.bhz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.BanhezhanxinxiEntity;
import com.shtoone.qms.entity.bhz.V_ShiyanshiInfoEntity;
import com.shtoone.qms.service.bhz.BanhezhanxinxiServiceI;

@Service("banhezhanxinxiService")
@Transactional
public class BanhezhanxinxiServiceImpl extends CommonServiceImpl implements BanhezhanxinxiServiceI {
	@Autowired
	private JdbcDao jdbcDao;
	public BanhezhanxinxiEntity getBhzbydepartid(String departid) {
		String queryString = "from BanhezhanxinxiEntity as model where model.departid=?";
		List<BanhezhanxinxiEntity> bhzlist = this.findHql(queryString, departid);
		if (bhzlist.size() > 0) {
			return bhzlist.get(0);
		} else {
			return null;
		}
	}
	
	/**
	 * 获取指定组织机构下的拌和机信息
	 * @param departid
	 * @param bhjtype 1:水泥混凝土 2：沥青混凝土 3：万能机 4：压力机
	 * @param userlft
	 * @param userrgt
	 * @return
	 */
	public List<BanhezhanxinxiEntity> getBhzBySql(String departid,String bhjtype,String userlft, String userrgt){
		String queryString ="select * from BanhezhanxinxiView where 1=1";
		if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
			queryString+=" and lft >= '"+userlft
					+"' and rgt <= '" + userrgt + "'";
		}
		if(StringUtil.isNotEmpty(bhjtype)){
			queryString+=" and gprstype="+bhjtype;
		}
		//System.out.println(queryString);
		List<BanhezhanxinxiEntity> bhzlist=jdbcDao.find(queryString, BanhezhanxinxiEntity.class, new HashMap<String, String>());
		return bhzlist;
	}

/*	public  List<LqBanhezhanxinxiEntity> getLQbhzBySql(String departid,String bhjtype,String userlft, String userrgt){
		String queryString ="select * from lqBanhezhanxinxiView where 1=1";
		if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
			queryString+=" and lft >= '"+userlft
					+"' and rgt <= '" + userrgt + "'";
		}
		if(StringUtil.isNotEmpty(bhjtype)){
			queryString+=" and shebeileixin="+bhjtype;
		}
		//System.out.println(queryString);
		List<LqBanhezhanxinxiEntity> lqbhzlist=jdbcDao.find(queryString, BanhezhanxinxiEntity.class, new HashMap<String, String>());
		return lqbhzlist;
	}*/
	
	
	
	
	//实验室设备
	public List<V_ShiyanshiInfoEntity> getWNJBySql(String departid,String bhjtype,String userlft, String userrgt){
		String queryString ="select * from V_ShiyanshiInfo where 1=1";
		if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
			queryString+=" and lft >= '"+userlft+"' and rgt <= '" + userrgt + "'";
		}
		if(StringUtil.isNotEmpty(bhjtype)){
			queryString+=" and gprstype="+bhjtype;
		}
		List<V_ShiyanshiInfoEntity> syslist=jdbcDao.find(queryString, V_ShiyanshiInfoEntity.class, new HashMap<String, String>());
		return syslist;
		
	}
	
	
	
	
	
	
	
	public List<TSDepart> getBHZ(String userlft, String userrgt){
		String queryString ="select * from t_s_depart where 1=1";
		if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
			queryString+=" and lft >= '"+userlft
					+"' and rgt <= '" + userrgt + "'";
		}
			queryString+=" and type=1";
		//System.out.println(queryString);
		List<TSDepart> bhzlist=jdbcDao.find(queryString, TSDepart.class, new HashMap<String, String>());
		return bhzlist;
	}
	
	//通过拌和机的心跳得到其拌合站数据
	public BanhezhanxinxiEntity getBhzByShebeibianhao(String shebeibianhao){
		String queryString ="from BanhezhanxinxiEntity as model where model.gprsbianhao=?";
		if(StringUtil.isNotEmpty(shebeibianhao)){
			List<BanhezhanxinxiEntity> bhzlist = this.findHql(queryString,shebeibianhao);
			if(bhzlist.size()>0){
				return bhzlist.get(0);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	
	// 方式3, 取值进一步自己处理(直接转换成easyUI的datagrid需要的东西，执行效率最高，最自由)  -------------------------------	
			public JSONObject getDatagrid3(BanhezhanxinxiEntity pageObj, DataGrid dataGrid,
					String departid,String gprstype,String smsbaojin,
					String shebeibianhao, String userlft, String userrgt) {
				
				StringBuilder queryCondition = new StringBuilder("");
				queryCondition.append(" 1=1 ");
				
				if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
					queryCondition.append(" and lft >= '"+userlft
							+"' and rgt <= '" + userrgt + "'");
				}
				
				if(StringUtil.isNotEmpty(shebeibianhao)){
					queryCondition.append(" and shebeibianhao ='"+shebeibianhao+"'");
				}

				if(StringUtil.isNotEmpty(gprstype)){
			        switch (new Integer(gprstype)) {
			           case 1: queryCondition.append(" and  gprstype=1 ");
			           break;
			           case 2: queryCondition.append(" and  gprstype=2 ");
			           break;
			           case 3: queryCondition.append(" and  gprstype=3 ");
			           break;
			           case 4: queryCondition.append(" and  gprstype=4 ");
			           
			           break;
			           case 5: queryCondition.append(" and  gprstype=5 ");
			           
			           break;
			           default:break;
			        }
				}
				if(StringUtil.isNotEmpty(smsbaojin)){
			        switch (new Integer(smsbaojin)) {
			           case 0: queryCondition.append(" and  smsbaojin=0 ");
			           break;
			           case 1: queryCondition.append(" and  smsbaojin=1 ");
			           break;
			           default:break;
			        }
				}
		        
				// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
				String sqlCnt = "select count(*) from BanhezhanxinxiView t where"+queryCondition.toString();
				Long iCount = getCountForJdbcParam(sqlCnt, null);
				
				// 取出当前页的数据 
				StringBuffer sql = new StringBuffer();
				sql.append("select * from BanhezhanxinxiView t where"+queryCondition.toString());
				
				//System.out.println(sql.toString());
				List<Map<String, Object>> mapList = findForJdbc(sql.toString(), dataGrid.getPage(), dataGrid.getRows());
				// 将结果集转换成页面上对应的数据集
				Db2Page[] db2Pages = {
						new Db2Page("id")
						,new Db2Page("gprsbianhao")
						,new Db2Page("gprstype")
						,new Db2Page("banhezhanminchen")
						,new Db2Page("jianchen")
						,new Db2Page("shebeichanjia")
						,new Db2Page("shebeixinghao")
						,new Db2Page("gongkongleixin")
						,new Db2Page("caijiduanruanjianbanben")
						,new Db2Page("jiekouleixin")
						,new Db2Page("shujukuleixin")
						,new Db2Page("shuliang")
						,new Db2Page("simhao")
						,new Db2Page("simpwd")
						,new Db2Page("botelu")
						,new Db2Page("taocan")
						,new Db2Page("smsbaojin")
						,new Db2Page("smstype")
						,new Db2Page("sendtype")
						,new Db2Page("panshu")
						,new Db2Page("ambegin")
						,new Db2Page("amend")
						,new Db2Page("pmbegin")
						,new Db2Page("pmend")
						,new Db2Page("smssettype")
						,new Db2Page("shebeidizhi")
						,new Db2Page("shebeimianji")
						,new Db2Page("caozuoren")
						,new Db2Page("zhanzhang")
						,new Db2Page("lianxidianhua")
						,new Db2Page("shijiangeshi")
						,new Db2Page("orderid")
						,new Db2Page("departid")
						,new Db2Page("remark")
				};
				JSONObject jObject = getJsonDatagridEasyUI(mapList, iCount.intValue(), db2Pages);
				return jObject;
				// end of 方式3 ========================================= */
			}
			
			
	
}