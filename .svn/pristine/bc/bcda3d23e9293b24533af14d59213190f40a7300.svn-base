package com.shtoone.qms.service.impl.bhz;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.stereotype.Service;

import com.shtoone.qms.entity.bhz.HntviewEntity;
import com.shtoone.qms.service.bhz.HntsclhsServiceI;

@Service
public class HntsclhsServiceImpl extends CommonServiceImpl implements HntsclhsServiceI {
	
	// 方式3, 取值进一步自己处理(直接转换成easyUI的datagrid需要的东西，执行效率最高，最自由)  -------------------------------	
	public JSONObject getDatagrid3(HntviewEntity pageObj, DataGrid dataGrid,String ctBegin,String ctEnd,
			Integer userlft,Integer userrgt,String shebeibianhao) {
		String sqlWhere = getSqlWhere(pageObj,ctBegin,ctEnd,userlft,userrgt,shebeibianhao);
		// 取出当前页的数据 
		StringBuffer sql = new StringBuffer();
		appenShuliangSql(sql,pageObj);
		sql.append(" FROM tongji_cl a ,Banhezhanxinxi  b,t_s_depart c");
		if (!sqlWhere.isEmpty()) {
			sql.append(" where" + sqlWhere);
			sql.append(" group by qiangdudengji");
			appendGroupSql(pageObj,sql);
		}
			
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from ("+sql.toString()+") as m";
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		
		sql.append(" order by chuliaoshijian desc");//输出时根据出料时间排序
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(), dataGrid.getPage(), dataGrid.getRows());
		// 将结果集转换成页面上对应的数据集
		Db2Page[] db2Pages = {new Db2Page("id"),
							  new Db2Page("chuliaoshijian"),
							  new Db2Page("gongchengmingcheng"),
							  new Db2Page("sigongdidian"),
							  new Db2Page("jiaozuobuwei"),
							  new Db2Page("qiangdudengji"),
							  new Db2Page("peifanghao"),
							  new Db2Page("gujifangshu")};
		return getJsonDatagridEasyUI(mapList, iCount.intValue(), db2Pages);
	}
		
		// 拼查询条件（where语句）
	private	String getSqlWhere(HntviewEntity pageObj,String ctBegin,String ctEnd,Integer userlft,Integer userrgt,String shebeibianhao) {
		// 拼出条件语句
		String sqlWhere =" a.shebeibianhao=b.gprsbianhao and b.departid=c.ID and zongfashu>0 ";
		if (userlft>0 && userrgt>0) {
			if (!sqlWhere.isEmpty()) {
				sqlWhere += " and";
			}
			sqlWhere += " c.lft >= '"+userlft+"' and c.rgt <= '" + userrgt + "'";
		}
		if (StringUtil.isNotEmpty(shebeibianhao)) {
			if (!sqlWhere.isEmpty()) {
				sqlWhere += " and";
			}
			sqlWhere += " b.gprsbianhao = '"+shebeibianhao + "'";
		}	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String newDate = sdf.format(new Date());
		if (StringUtil.isNotEmpty(ctBegin) && StringUtil.isNotEmpty(ctEnd)) {
			if (!sqlWhere.isEmpty()) {
				sqlWhere += " and";
			}
			sqlWhere += " (convert(varchar(100),chuliaodate,23) between '" + ctBegin + "' and '" + ctEnd + "')";
		}
		if (StringUtil.isNotEmpty(ctBegin) && StringUtil.isEmpty(ctEnd)) {
			if (!sqlWhere.isEmpty()) {
				sqlWhere += " and";
			}
			sqlWhere += " (convert(varchar(100),chuliaodate,23) between '" + ctBegin + "' and '" + newDate + "')";
		}
		if (StringUtil.isEmpty(ctBegin) && StringUtil.isNotEmpty(ctEnd)) {
			if (!sqlWhere.isEmpty()) {
				sqlWhere += " and";
			}
			sqlWhere += " (convert(varchar(100),chuliaodate,23) between '2010-01-01' and '"  + ctEnd + "')";
		}
			
		if (StringUtil.isNotEmpty(pageObj.getGongchengmingcheng())) {
			if (!sqlWhere.isEmpty()) {
				sqlWhere += " and";
			}
			sqlWhere += " gongchengmingcheng like '%" + pageObj.getGongchengmingcheng() + "%'";
		}
			
		if (StringUtil.isNotEmpty(pageObj.getSigongdidian())) {
			if (!sqlWhere.isEmpty()) {
				sqlWhere += " and";
			}
			sqlWhere += " sigongdidian like '%" + pageObj.getSigongdidian() + "%'";
		}
		if (StringUtil.isNotEmpty(pageObj.getJiaozuobuwei())) {
			if (!sqlWhere.isEmpty()) {
				sqlWhere += " and";
			}
			sqlWhere += " jiaozuobuwei like '%" + pageObj.getJiaozuobuwei() + "%'";
		}
		if (StringUtil.isNotEmpty(pageObj.getQiangdudengji())) {
			if (!sqlWhere.isEmpty()) {
				sqlWhere += " and";
			}
			sqlWhere += " qiangdudengji like '%" + pageObj.getQiangdudengji() + "%'";
		}	
		return sqlWhere;
	}
		
		
	private void appenShuliangSql(StringBuffer sql,HntviewEntity pageObj) {		
		sql.append("select Max(shebeibianhao) as shebeibianhao,Max(chuliaodate) as chuliaoshijian,SUM(zongfashu)  AS gujifangshu,qiangdudengji");
		appendGroupSql(pageObj,sql);
	}
		
	private void appendGroupSql(HntviewEntity pageObj,StringBuffer sql){
		if(StringUtil.isNotEmpty(pageObj.getJiaozuobuwei())){
			sql.append(",jiaozuobuwei ");
		}
		if(StringUtil.isNotEmpty(pageObj.getPeifanghao())){
			sql.append(",peifanghao ");
		}
		if(StringUtil.isNotEmpty(pageObj.getGongchengmingcheng())){
			sql.append(",gongchengmingcheng ");
		}
		if(StringUtil.isNotEmpty(pageObj.getSigongdidian())){
			sql.append(",sigongdidian ");
		}
	}
}
