package com.shtoone.qms.service.impl.bhz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;







import com.shtoone.qms.entity.bhz.BanhezhanxinxiEntity;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.entity.bhz.HunnintuView;
import com.shtoone.qms.service.bhz.HunnintuViewServiceI;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl.Db2Page;
import org.jeecgframework.core.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service("hunnintuViewService")
@Transactional
public class HunnintuViewServiceImpl extends CommonServiceImpl implements
		HunnintuViewServiceI {
	@Autowired
	private JdbcDao jdbcDao;
	
	
	
	
	// 方式3, 取值进一步自己处理(直接转换成easyUI的datagrid需要的东西，执行效率最高，最自由)
	// -------------------------------
	public JSONObject getDatagrid3(HunnintuView hunnintuView,
			DataGrid dataGrid, String startTime, String endTime,
			Integer userlft, Integer userrgt, String jiaozuobuwei,
			String gongchengmingcheng,String shebeibianhao) {

		StringBuilder queryCtest = new StringBuilder("");
		queryCtest.append(" (convert(datetime,chuliaoshijian,121) between '"
				+ startTime + "' and '" + endTime + "')");
		if (StringUtil.isNotEmpty(jiaozuobuwei)) {
			queryCtest.append(" and jiaozuobuwei like '%" + jiaozuobuwei + "%'");
		}
		if (StringUtil.isNotEmpty(gongchengmingcheng)) {
			queryCtest.append(" and gongchengmingcheng like '%"
					+ gongchengmingcheng + "%'");
		}
		if(StringUtil.isNotEmpty(shebeibianhao)){
			queryCtest.append(" and shebeibianhao ='"+shebeibianhao+"'");
		}
		if(userlft>0 && userrgt>0){
			queryCtest.append(" and lft >= '"+userlft+"'"+" and rgt<= '"+userrgt+"'");
		}
		// String sqlWhere = getSqlWhere(hunnintuView,startTime,endTime);
		

		// 取当前页数据
		//System.out.println(queryCtest.toString()+"-00-");
		StringBuffer sql = new StringBuffer();
		sql.append("select * from HunnintuView t");
		sql.append(" where "+queryCtest.toString());
		sql.append("order by t.chuliaoshijian desc");
//		chuliaoshijian between '2015-05-05' and '2015-06-23'");
		//System.out.println("查询语句" + sql.toString());
		
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from HunnintuView t  where"
						+ queryCtest.toString();
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		System.out.println(sqlCnt);
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(),dataGrid.getPage(), dataGrid.getRows());
		
		/*
		 * if (!sqlWhere.isEmpty()) { sqlCnt += " where" + sqlWhere; }
		 * System.out.println(sqlCnt);
		 */

		// StringBuffer sql = new StringBuffer();
		// String sql = "select t.* from HunnintuView t";
		/*
		 * sql.append("select "); sql.append(
		 * " case when SUM(a.panshu)>0 then SUM(a.panshu) else 0 end  AS pangshu,"
		 * ); sql.append(
		 * " case when SUM(zongfashu)>0 then SUM(zongfashu) else 0 end AS gujifangshu,"
		 * ); sql.append(
		 * " case when SUM(cbpanshu+mcbpanshu+hcbpanshu)>0 then SUM(cbpanshu+mcbpanshu+hcbpanshu) else 0 end AS lowcbps,"
		 * ); sql.append(
		 * " case when SUM(mcbpanshu+hcbpanshu)>0 then SUM(mcbpanshu+hcbpanshu) else 0 end AS midcbps,"
		 * ); sql.append(
		 * " case when SUM(hcbpanshu)>0 then SUM(hcbpanshu) else 0 end AS highcbps,"
		 * ); sql.append(
		 * " case  when SUM(a.panshu)>0 then  cast(round(cast((SUM(cbpanshu)+SUM(mcbpanshu)+SUM(hcbpanshu))*100 as numeric)/SUM(a.panshu),2) as numeric(20,2)) else 0 end AS lowcbper,"
		 * ); sql.append(
		 * " case  when SUM(a.panshu)>0 then  cast(round(cast((SUM(mcbpanshu)+SUM(hcbpanshu))*100 as numeric)/SUM(a.panshu),2) as numeric(20,2))  else 0 end  AS midcbper,"
		 * ); sql.append(
		 * " case  when SUM(a.panshu)>0 then  cast(round(cast(SUM(hcbpanshu)*100 as numeric)/SUM(a.panshu),2) as numeric(20,2)) else 0 end  AS highcbper , "
		 * ); sql.append(
		 * " case when sum(cczpanshu+mczpanshu+hczpanshu)>0 then sum(cczpanshu+mczpanshu+hczpanshu) else 0 end as  cczpanshu, "
		 * ); sql.append(
		 * " case when sum(mczpanshu+hczpanshu)>0 then sum(mczpanshu+hczpanshu) else 0 end as mczpanshu, "
		 * ); sql.append(
		 * " case when sum(hczpanshu)>0 then sum(hczpanshu) else 0 end as hczpanshu, "
		 * ); sql.append(
		 * " case when sum(cbpanshu+mcbpanshu+hcbpanshu)>0 then cast(round(cast(sum(cczpanshu+mczpanshu+hczpanshu)*100 as numeric)/sum(cbpanshu+mcbpanshu+hcbpanshu),2) as numeric(20,2))  when  sum(cbpanshu+mcbpanshu+hcbpanshu)=0  and sum(cczpanshu+mczpanshu+hczpanshu)=0 then 100 else 0 end as czper, "
		 * ); sql.append(
		 * " case when sum(mcbpanshu+hcbpanshu)>0 then cast(round(cast(sum(mczpanshu+hczpanshu)*100 as numeric)/sum(mcbpanshu+hcbpanshu),2) as numeric(20,2))  when  sum(mcbpanshu+hcbpanshu)=0  and sum(mczpanshu+hczpanshu)=0 then 100 else 0 end as mczper, "
		 * ); sql.append(
		 * " case when sum(hcbpanshu)>0 then cast(round(cast(sum(hczpanshu)*100 as numeric)/sum(hcbpanshu),2) as numeric(20,2)) when  sum(hcbpanshu)=0  and sum(hczpanshu)=0 then 100 else 0  end as hczper "
		 * ); sql.append(
		 * " FROM ( select shebeibianhao,chuliaodate,panshu,zongfashu,0 as cbpanshu,0 as mcbpanshu,0 as hcbpanshu,0 as cczpanshu,0 as mczpanshu,0 as hczpanshu from tongji_cl "
		 * ); sql.append(" union all ");
		 */
		// sql.append(" select * from HunnintuView  ");

		// sql.append(" where (convert(datetime,chuliaoshijian,121) between '"
		// + startTime + "' and '" + endTime + "')");
		/*
		 * if (!sqlWhere.isEmpty()) { sql += " where" + sqlWhere; }
		 */

		// 将结果集转换成页面上对应的数据集
		Db2Page[] db2Pages = {
				new Db2Page("id", "id")
				// ,new Db2Page("quanju","全局")
				, new Db2Page("banhezhanminchen", "banhezhanminchen"),
				new Db2Page("gongchengmingcheng", "gongchengmingcheng"),
				new Db2Page("sigongdidian", "sigongdidian"),
				new Db2Page("jiaozuobuwei", "jiaozuobuwei"),
				new Db2Page("chuliaoshijian", "chuliaoshijian"),
				new Db2Page("baocunshijian", "baocunshijian"),
				new Db2Page("chaozuozhe", "chaozuozhe"),
				new Db2Page("jiaobanshijian", "jiaobanshijian") 
				
				,new Db2Page("sha1Shijizhi","sha1_shijizhi")
				,new Db2Page("sha2Shijizhi","sha2_shijizhi")
				,new Db2Page("shi1Shijizhi","shi1_shijizhi")
				,new Db2Page("shi2Shijizhi","shi2_shijizhi")
				,new Db2Page("shui1Shijizhi","shui1_shijizhi")
				,new Db2Page("shui2Shijizhi","shui2_shijizhi")
				,new Db2Page("shuini1Shijizhi","shuini1_shijizhi")
				,new Db2Page("shuini2Shijizhi","shuini2_shijizhi")
				,new Db2Page("guliao5Shijizhi","guliao5_shijizhi")
				,new Db2Page("feimeihui4Shijizhi","feimeihui4_shijizhi")
				,new Db2Page("kuangfen3Shijizhi","kuangfen3_shijizhi")
				,new Db2Page("fenliao5Shijizhi","fenliao5_shijizhi")
				,new Db2Page("fenliao6Shijizhi","fenliao6_shijizhi")
				,new Db2Page("waijiaji1Shijizhi","waijiaji1_shijizhi")
				,new Db2Page("waijiaji2Shijizhi","waijiaji2_shijizhi")
				,new Db2Page("waijiaji3Shijizhi","waijiaji3_shijizhi")
				,new Db2Page("waijiaji4Shijizhi","waijiaji4_shijizhi")
				
				
				,new Db2Page("sha1Lilunzhi","sha1_lilunzhi")
				,new Db2Page("sha2Lilunzhi","sha2_lilunzhi")
				,new Db2Page("shi1Lilunzhi","shi1_lilunzhi")
				,new Db2Page("shi2Lilunzhi","shi2_lilunzhi")
				,new Db2Page("shui1Lilunzhi","shui1_lilunzhi")
				,new Db2Page("shui2Lilunzhi","shui2_lilunzhi")
				,new Db2Page("shuini1Lilunzhi","shuini1_lilunzhi")
				,new Db2Page("shuini2Lilunzhi","shuini2_lilunzhi")
				,new Db2Page("guliao5Lilunzhi","guliao5_lilunzhi")
				,new Db2Page("feimeihui4Lilunzhi","feimeihui4_lilunzhi")
				,new Db2Page("kuangfen3Lilunzhi","kuangfen3_lilunzhi")
				,new Db2Page("fenliao5Lilunzhi","fenliao5_lilunzhi")
				,new Db2Page("fenliao6Lilunzhi","fenliao6_lilunzhi")
				,new Db2Page("waijiaji1Lilunzhi","waijiaji1_lilunzhi")
				,new Db2Page("waijiaji2Lilunzhi","waijiaji2_lilunzhi")
				,new Db2Page("waijiaji3Lilunzhi","waijiaji3_lilunzhi")
				,new Db2Page("waijiaji4Lilunzhi","waijiaji4_lilunzhi")
				
				
				,new Db2Page("glw1")
				,new Db2Page("glw2")
				,new Db2Page("glw3")
				,new Db2Page("glw4")
				,new Db2Page("glw5")
				,new Db2Page("flw1")
				,new Db2Page("flw2")
				,new Db2Page("flw3")
				,new Db2Page("flw4")
				,new Db2Page("flw5")
				,new Db2Page("flw6")
				,new Db2Page("shw1")
				,new Db2Page("shw2")
				,new Db2Page("wjw1")
				,new Db2Page("wjw2")
				,new Db2Page("wjw3")
				,new Db2Page("wjw4")
				
				
				,new Db2Page("glper1")
				,new Db2Page("glper2")
				,new Db2Page("glper3")
				,new Db2Page("glper4")
				,new Db2Page("glper5")
				,new Db2Page("flper1")
				,new Db2Page("flper2")
				,new Db2Page("flper3")
				,new Db2Page("flper4")
				,new Db2Page("flper5")
				,new Db2Page("flper6")
				,new Db2Page("shper1")
				,new Db2Page("shper2")
				,new Db2Page("wjper1")
				,new Db2Page("wjper2")
				,new Db2Page("wjper3")
				,new Db2Page("wjper4")
		};
		JSONObject jObject = getJsonDatagridEasyUI(mapList,iCount.intValue(),db2Pages);
		return jObject;
		// end of 方式3 ========================================= */
	}

	
	
	public JSONObject getDatagrid5(HunnintuView hunnintuView,
			DataGrid dataGrid, String startTime, String endTime,
			Integer userlft, Integer userrgt, String jiaozuobuwei,
			String gongchengmingcheng,String shebeibianhao) {

		StringBuilder queryCtest = new StringBuilder(" 1=1");
		queryCtest.append(" and (convert(datetime,chuliaoshijian,121) between '"
				+ startTime + "' and '" + endTime + "')");
		if (StringUtil.isNotEmpty(jiaozuobuwei)) {
			queryCtest.append(" and jiaozuobuwei like '%" + jiaozuobuwei + "%'");
		}
		if (StringUtil.isNotEmpty(gongchengmingcheng)) {
			queryCtest.append(" and gongchengmingcheng like '%"
					+ gongchengmingcheng + "%'");
		}
		if(StringUtil.isNotEmpty(shebeibianhao)){
			queryCtest.append(" and shebeibianhao ='"+shebeibianhao+"'");
		}
		if(userlft>0 && userrgt>0){
			queryCtest.append(" and lft >= '"+userlft+"'"+" and rgt<= '"+userrgt+"'" );
		}
		// String sqlWhere = getSqlWhere(hunnintuView,startTime,endTime);

		// 取当前页数据
		//System.out.println(queryCtest.toString()+"-00-");
		StringBuffer sql = new StringBuffer();
		sql.append("select id, banhezhanminchen,sigongdidian,jiaozuobuwei,chuliaoshijian,baocunshijian,chaozuozhe,jiaobanshijian,"
				+ " Convert(decimal(18,2),sha1_shijizhi) as sha1_shijizhi ,"
				+ " Convert(decimal(18,2),sha2_shijizhi) as sha2_shijizhi ,"
				+ " Convert(decimal(18,2),shi1_shijizhi) as shi1_shijizhi ,"
				+ " Convert(decimal(18,2),shi2_shijizhi) as shi2_shijizhi ,"
				+ " Convert(decimal(18,2),shui1_shijizhi) as shui1_shijizhi ,"
				+ " Convert(decimal(18,2),shui2_shijizhi) as shui2_shijizhi ,"
				+ " Convert(decimal(18,2),shuini1_shijizhi) as shuini1_shijizhi ,"
				+ " Convert(decimal(18,2),shuini2_shijizhi) as shuini2_shijizhi ,"
				+ " Convert(decimal(18,2),guliao5_shijizhi) as guliao5_shijizhi ,"
				+ " Convert(decimal(18,2),feimeihui4_shijizhi) as feimeihui4_shijizhi ,"
				+ " Convert(decimal(18,2),kuangfen3_shijizhi) as kuangfen3_shijizhi ,"
				+ " Convert(decimal(18,2),fenliao5_shijizhi) as fenliao5_shijizhi ,"
				+ " Convert(decimal(18,2),fenliao6_shijizhi) as fenliao6_shijizhi ,"
				+ " Convert(decimal(18,2),waijiaji1_shijizhi) as waijiaji1_shijizhi ,"
				+ " Convert(decimal(18,2),waijiaji2_shijizhi) as waijiaji2_shijizhi ,"
				+ " Convert(decimal(18,2),waijiaji3_shijizhi) as waijiaji3_shijizhi ,"
				+ " Convert(decimal(18,2),waijiaji4_shijizhi) as waijiaji4_shijizhi ,"
				+ " Convert(decimal(18,2),sha1_lilunzhi) as sha1_lilunzhi ,"
				+ " Convert(decimal(18,2),sha2_lilunzhi) as sha2_lilunzhi ,"
				+ " Convert(decimal(18,2),shi1_lilunzhi) as shi1_lilunzhi ,"
				+ " Convert(decimal(18,2),shi2_lilunzhi) as shi2_lilunzhi ,"
				+ " Convert(decimal(18,2),shui1_lilunzhi) as shui1_lilunzhi ,"
				+ " Convert(decimal(18,2),shui2_lilunzhi) as shui2_lilunzhi ,"
				+ " Convert(decimal(18,2),shuini1_lilunzhi) as shuini1_lilunzhi ,"
				+ " Convert(decimal(18,2),shuini2_lilunzhi) as shuini2_lilunzhi ,"
				+ " Convert(decimal(18,2),guliao5_lilunzhi) as guliao5_lilunzhi ,"
				+ " Convert(decimal(18,2),feimeihui4_lilunzhi) as feimeihui4_lilunzhi ,"
				+ " Convert(decimal(18,2),kuangfen3_lilunzhi) as kuangfen3_lilunzhi ,"
				+ " Convert(decimal(18,2),fenliao5_lilunzhi) as fenliao5_lilunzhi ,"
				+ " Convert(decimal(18,2),fenliao6_lilunzhi) as fenliao6_lilunzhi ,"
				+ " Convert(decimal(18,2),waijiaji1_lilunzhi) as waijiaji1_lilunzhi ,"
				+ " Convert(decimal(18,2),waijiaji2_lilunzhi) as waijiaji2_lilunzhi ,"
				+ " Convert(decimal(18,2),waijiaji3_lilunzhi) as waijiaji3_lilunzhi ,"
				+ " Convert(decimal(18,2),waijiaji4_lilunzhi) as waijiaji4_lilunzhi, "
				+ "  Convert(decimal(18,2),glw1) as glw1 ,"
				+ " Convert(decimal(18,2),glw2) as glw2 ,"
				+ " Convert(decimal(18,2),glw3) as glw3 ,"
				+ " Convert(decimal(18,2),glw4) as glw4 ,"
				+ " Convert(decimal(18,2),glw5) as glw5 ,"
				+ " Convert(decimal(18,2),flw1) as flw1 ,"
				+ " Convert(decimal(18,2),flw2) as flw2 ,"
				+ " Convert(decimal(18,2),flw3) as flw3 ,"
				+ "Convert(decimal(18,2),flw4) as flw4 ,"
				+ " Convert(decimal(18,2),flw5) as flw5 ,"
				+ " Convert(decimal(18,2),flw6) as flw6 ,"
				+ " Convert(decimal(18,2),shw1) as shw1 ,"
				+ " Convert(decimal(18,2),shw2) as shw2 ,"
				+ " Convert(decimal(18,2),wjw1) as wjw1 ,"
				+ " Convert(decimal(18,2),wjw2) as wjw2 ,"
				+ " Convert(decimal(18,2),wjw3) as wjw3 ,"
				+ " Convert(decimal(18,2),wjw4) as wjw4 , "
				+ " Convert(decimal(18,2),glper1) as glper1 ,"
				+ " Convert(decimal(18,2),glper2) as glper2 ,"
				+ " Convert(decimal(18,2),glper3) as glper3 ,"
				+ " Convert(decimal(18,2),glper4) as glper4 ,"
				+ " Convert(decimal(18,2),glper5) as glper5 ,"
				+ " Convert(decimal(18,2),flper1) as flper1 ,"
				+ " Convert(decimal(18,2),flper2) as flper2 ,"
				+ " Convert(decimal(18,2),flper3) as flper3 ,"
				+ " Convert(decimal(18,2),flper4) as flper4 ,"
				+ " Convert(decimal(18,2),flper5) as flper5 ,"
				+ " Convert(decimal(18,2),flper6) as flper6 ,"
				+ " Convert(decimal(18,2),shper1) as shper1 ,"
				+ " Convert(decimal(18,2),shper2) as shper2 ,"
				+ " Convert(decimal(18,2),wjper1) as wjper1 ,"
				+ " Convert(decimal(18,2),wjper2) as wjper2 ,"
				+ " Convert(decimal(18,2),wjper3) as wjper3 ,"
				+ " Convert(decimal(18,2),wjper4) as wjper4 "
				+ "from HunnintuView t");
		sql.append(" where "+queryCtest.toString() +" order by chuliaoshijian desc");
//		chuliaoshijian between '2015-05-05' and '2015-06-23'");
		//System.out.println("查询语句" + sql.toString());
		
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from HunnintuView t  where"
						+ queryCtest.toString();
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(),dataGrid.getPage(), dataGrid.getRows());
		

		// 将结果集转换成页面上对应的数据集
		Db2Page[] db2Pages = {
				new Db2Page("id", "id")
				// ,new Db2Page("quanju","全局")
				, new Db2Page("banhezhanminchen", "banhezhanminchen"),
				new Db2Page("gongchengmingcheng", "gongchengmingcheng"),
				new Db2Page("sigongdidian", "sigongdidian"),
				new Db2Page("jiaozuobuwei", "jiaozuobuwei"),
				new Db2Page("chuliaoshijian", "chuliaoshijian"),
				new Db2Page("baocunshijian", "baocunshijian"),
				new Db2Page("chaozuozhe", "chaozuozhe"),
				new Db2Page("jiaobanshijian", "jiaobanshijian") 
				
				,new Db2Page("sha1Shijizhi","sha1_shijizhi ")
				,new Db2Page("sha2Shijizhi","sha2_shijizhi")
				,new Db2Page("shi1Shijizhi","shi1_shijizhi")
				,new Db2Page("shi2Shijizhi","shi2_shijizhi")
				,new Db2Page("shui1Shijizhi","shui1_shijizhi")
				,new Db2Page("shui2Shijizhi","shui2_shijizhi")
				,new Db2Page("shuini1Shijizhi","shuini1_shijizhi")
				,new Db2Page("shuini2Shijizhi","shuini2_shijizhi")
				,new Db2Page("guliao5Shijizhi","guliao5_shijizhi")
				,new Db2Page("feimeihui4Shijizhi","feimeihui4_shijizhi")
				,new Db2Page("kuangfen3Shijizhi","kuangfen3_shijizhi")
				,new Db2Page("fenliao5Shijizhi","fenliao5_shijizhi")
				,new Db2Page("fenliao6Shijizhi","fenliao6_shijizhi")
				,new Db2Page("waijiaji1Shijizhi","waijiaji1_shijizhi")
				,new Db2Page("waijiaji2Shijizhi","waijiaji2_shijizhi")
				,new Db2Page("waijiaji3Shijizhi","waijiaji3_shijizhi")
				,new Db2Page("waijiaji4Shijizhi","waijiaji4_shijizhi")
				
				
				,new Db2Page("sha1Lilunzhi","sha1_lilunzhi")
				,new Db2Page("sha2Lilunzhi","sha2_lilunzhi")
				,new Db2Page("shi1Lilunzhi","shi1_lilunzhi")
				,new Db2Page("shi2Lilunzhi","shi2_lilunzhi")
				,new Db2Page("shui1Lilunzhi","shui1_lilunzhi")
				,new Db2Page("shui2Lilunzhi","shui2_lilunzhi")
				,new Db2Page("shuini1Lilunzhi","shuini1_lilunzhi")
				,new Db2Page("shuini2Lilunzhi","shuini2_lilunzhi")
				,new Db2Page("guliao5Lilunzhi","guliao5_lilunzhi")
				,new Db2Page("feimeihui4Lilunzhi","feimeihui4_lilunzhi")
				,new Db2Page("kuangfen3Lilunzhi","kuangfen3_lilunzhi")
				,new Db2Page("fenliao5Lilunzhi","fenliao5_lilunzhi")
				,new Db2Page("fenliao6Lilunzhi","fenliao6_lilunzhi")
				,new Db2Page("waijiaji1Lilunzhi","waijiaji1_lilunzhi")
				,new Db2Page("waijiaji2Lilunzhi","waijiaji2_lilunzhi")
				,new Db2Page("waijiaji3Lilunzhi","waijiaji3_lilunzhi")
				,new Db2Page("waijiaji4Lilunzhi","waijiaji4_lilunzhi")
				
				
				,new Db2Page("glw1")
				,new Db2Page("glw2")
				,new Db2Page("glw3")
				,new Db2Page("glw4")
				,new Db2Page("glw5")
				,new Db2Page("flw1")
				,new Db2Page("flw2")
				,new Db2Page("flw3")
				,new Db2Page("flw4")
				,new Db2Page("flw5")
				,new Db2Page("flw6")
				,new Db2Page("shw1")
				,new Db2Page("shw2")
				,new Db2Page("wjw1")
				,new Db2Page("wjw2")
				,new Db2Page("wjw3")
				,new Db2Page("wjw4")
				
				
				,new Db2Page("glper1")
				,new Db2Page("glper2")
				,new Db2Page("glper3")
				,new Db2Page("glper4")
				,new Db2Page("glper5")
				,new Db2Page("flper1")
				,new Db2Page("flper2")
				,new Db2Page("flper3")
				,new Db2Page("flper4")
				,new Db2Page("flper5")
				,new Db2Page("flper6")
				,new Db2Page("shper1")
				,new Db2Page("shper2")
				,new Db2Page("wjper1")
				,new Db2Page("wjper2")
				,new Db2Page("wjper3")
				,new Db2Page("wjper4")
		};
		JSONObject jObject = getJsonDatagridEasyUI(mapList,iCount.intValue(),db2Pages);
		return jObject;
		// end of 方式3 ========================================= */
	}
	
	
	/*
	 * 拼查询条件（where语句） String getSqlWhere(HunnintuViewEntity hunnintuView,String
	 * startTime ,String endTime) { // 拼出条件语句 String sqlWhere = "";
	 * 
	 * sqlWhere +=" t.chuliaoshijian between '" + startTime + "' and '" +
	 * endTime + "')";
	 * 
	 * return sqlWhere; }
	 */
	/*
	 * // 性别的数据变换实体 class MyDataExchangerSex implements IMyDataExchanger {
	 * public Object exchange(Object value) { if (value == null) { return ""; }
	 * else if ("0".equals(value.toString())) { return "男"; } else { return "女";
	 * } } }
	 * 
	 * public void listAllByJdbc(DataGrid dataGrid) { //从对应路径中，获取SQL
	 * [/jeecg/demo/sql/test/JeecgJdbcService_listAllByJdbc.sql] String sql =
	 * JeecgSqlUtil.getMethodSql(JeecgSqlUtil.getMethodUrl());
	 * 
	 * String countsql = JeecgSqlUtil.getCountSqlBySql(sql); List<Map<String,
	 * Object>> maplist = jdbcDao.findForJdbcParam(sql, dataGrid.getPage(),
	 * dataGrid.getRows()); Long count = jdbcDao.getCountForJdbcParam(countsql);
	 * dataGrid.setTotal(count.intValue()); dataGrid.setResults(maplist); }
	 */
	
	/**
	 * 图表显示
	 */
	
	public String getHntAnalysisColumnXml(JSONObject jObject) {
		String strXML = createhntcnfxxml(jObject);
		// System.out.println(lujing+"-2-2-");
		return strXML;
		// return
		// FusionChartsCreator.createChart("plug-in/main/FusionCharts/MSCombiDY2D.swf",
		// "",strXML.toString(), "hntcnfxchart", 800, 300, false, false);
	}
	private String createhntcnfxxml(JSONObject jObject) {
		// 解析json数据
		Iterator it = jObject.keys();
		JSONArray array = null;
		while (it.hasNext()) {
			String key = (String) it.next();
			if (key.equals("rows")){
				array = jObject.getJSONArray(key);
			}

		}
		//混凝土拌和站拌和时间查询走势图
		//	public String getHntBanheshijianXml(List<HunnintuView> hv) {
			
			
			StringBuilder strXML = new StringBuilder("");
			strXML.append("<?xml version='1.0' encoding='utf-8'?><chart caption='拌和时间走势图' subcaption='(");
			JSONObject key3 = array.getJSONObject(0);	
			strXML.append(key3.get("baocunshijian"));
			
			strXML.append("至");

			strXML.append(array.getJSONObject(array.size()-1).get("baocunshijian"));
			
			strXML.append(")' lineThickness='2' showValues='0' anchorRadius='2' ");
			strXML.append("divLineAlpha='20' divLineColor='CC3300' divLineIsDashed='1' slantLabels='1' ");
			strXML.append("showAlternateHGridColor='1' alternateHGridColor='CC3300' shadowAlpha='40' ");
			strXML.append("labelStep='");
			strXML.append(array.size()/5);
			strXML.append("' numvdivlines='15' chartRightMargin='35' chartLeftMargin='35' ");
			strXML.append("bgColor='FFFFFF,CC3300' bgAngle='270' bgAlpha='10,10' alternateHGridAlpha='5' numberSuffix='s'> ");
			strXML.append("<categories>");
			//for (HunnintuView hunnintuView : hv) {
			for (int i = 0; i < array.size(); i++) {
				JSONObject key2 = array.getJSONObject(i);
				strXML.append("<category label='");
				strXML.append(key2.get("baocunshijian"));
				strXML.append("'/>");
			}
			strXML.append("</categories>");
			strXML.append("<dataset color='F1683C' anchorBorderColor='F1683C' anchorBgColor='F1683C'>");
			//for (HunnintuView hunnintuView : hv) {
			for (int i = 0; i < array.size(); i++) {
				JSONObject key2 = array.getJSONObject(i);
				strXML.append("<set value='");
				strXML.append(key2.get("jiaobanshijian"));
				strXML.append("'/>");
			}
			strXML.append("</dataset>");
			strXML.append(" <styles>");
	        strXML.append(" <definition>"); 
	        strXML.append(" <style type='font' name='captionFont' size='12'/>"); 
	        strXML.append(" </definition>"); 
	        strXML.append(" <application>"); 
	        strXML.append(" <apply toObject='Caption' styles='captionFont' />"); 
	        strXML.append(" <apply toObject='SubCaption' styles='SubcaptionFont' />"); 
	        strXML.append(" </application>"); 
	        strXML.append(" </styles>"); 
	        strXML.append(" </chart>"); 
	        return strXML.toString();
		
		
	}

	
	
}