package com.shtoone.qms.service.impl.bhz;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.stereotype.Service;

import com.shtoone.qms.entity.bhz.HntviewEntity;
import com.shtoone.qms.service.bhz.CbtongjiServiceI;


@Service
public class CbtongjiServiceImpl extends CommonServiceImpl implements CbtongjiServiceI {
	
	// 方式3, 取值进一步自己处理(直接转换成easyUI的datagrid需要的东西，执行效率最高，最自由)  -------------------------------	
	public JSONObject getDatagrid3(HntviewEntity pageObj, DataGrid dataGrid,String startTime
			,String endTime,Integer fzlx,String userlft,String userrgt,String shebeibianhao) {
		String sqlWhere = getSqlWhere(pageObj,startTime,endTime,fzlx,userlft,userrgt,shebeibianhao);
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from Hntview";
		/*
		 * if (!sqlWhere.isEmpty()) { sqlCnt += " where" + sqlWhere;
		 * }
		 */
		Long iCount = getCountForJdbcParam(sqlCnt, null);			
		// 取出当前页的数据 
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		if(fzlx==0 || fzlx==null){
			sql.append(" '全局' as banhezhanminchen ,");
		}else{
			switch (fzlx) {
				/*
				 case 1:
					sql.append(" biaoduanid,");
					break;
				case 2:
					sql.append(" biaoduanid,xiangmubuid,");
					break;
				*/
				case 3:
					sql.append(" departid,banhezhanminchen, ");
					break;
				default :
					break;
			}
		}
		sql.append(" case when SUM(a.panshu)>0 then SUM(a.panshu) else 0 end  AS pangshu,");
		sql.append(" case when SUM(zongfashu)>0 then SUM(zongfashu) else 0 end AS gujifangshu,");
		sql.append(" case when SUM(cbpanshu+mcbpanshu+hcbpanshu)>0 then SUM(cbpanshu+mcbpanshu+hcbpanshu) else 0 end AS lowcbps,");
		sql.append(" case when SUM(mcbpanshu+hcbpanshu)>0 then SUM(mcbpanshu+hcbpanshu) else 0 end AS midcbps,");
		sql.append(" case when SUM(hcbpanshu)>0 then SUM(hcbpanshu) else 0 end AS highcbps,");
		sql.append(" case  when SUM(a.panshu)>0 then  cast(round(cast((SUM(cbpanshu)+SUM(mcbpanshu)+SUM(hcbpanshu))*100 as numeric)/SUM(a.panshu),2) as numeric(20,2)) else 0 end AS lowcbper,");
		sql.append(" case  when SUM(a.panshu)>0 then  cast(round(cast((SUM(mcbpanshu)+SUM(hcbpanshu))*100 as numeric)/SUM(a.panshu),2) as numeric(20,2))  else 0 end  AS midcbper,");
		sql.append(" case  when SUM(a.panshu)>0 then  cast(round(cast(SUM(hcbpanshu)*100 as numeric)/SUM(a.panshu),2) as numeric(20,2)) else 0 end  AS highcbper , ");
		sql.append(" case when sum(cczpanshu+mczpanshu+hczpanshu)>0 then sum(cczpanshu+mczpanshu+hczpanshu) else 0 end as  cczpanshu, ");
		sql.append(" case when sum(mczpanshu+hczpanshu)>0 then sum(mczpanshu+hczpanshu) else 0 end as mczpanshu, ");
		sql.append(" case when sum(hczpanshu)>0 then sum(hczpanshu) else 0 end as hczpanshu, ");
		sql.append(" case when sum(cbpanshu+mcbpanshu+hcbpanshu)>0 then cast(round(cast(sum(cczpanshu+mczpanshu+hczpanshu)*100 as numeric)/sum(cbpanshu+mcbpanshu+hcbpanshu),2) as numeric(20,2))  when  sum(cbpanshu+mcbpanshu+hcbpanshu)=0  and sum(cczpanshu+mczpanshu+hczpanshu)=0 then 100 else 0 end as czper, ");
		sql.append(" case when sum(mcbpanshu+hcbpanshu)>0 then cast(round(cast(sum(mczpanshu+hczpanshu)*100 as numeric)/sum(mcbpanshu+hcbpanshu),2) as numeric(20,2))  when  sum(mcbpanshu+hcbpanshu)=0  and sum(mczpanshu+hczpanshu)=0 then 100 else 0 end as mczper, ");
		sql.append(" case when sum(hcbpanshu)>0 then cast(round(cast(sum(hczpanshu)*100 as numeric)/sum(hcbpanshu),2) as numeric(20,2)) when  sum(hcbpanshu)=0  and sum(hczpanshu)=0 then 100 else 0  end as hczper ");
		sql.append(" FROM ( select shebeibianhao,chuliaodate,panshu,zongfashu,0 as cbpanshu,0 as mcbpanshu,0 as hcbpanshu,0 as cczpanshu,0 as mczpanshu,0 as hczpanshu from tongji_cl ");
		sql.append(" union all ");
		sql.append(" select shebeibianhao,chuliaodate,0 as panshu,0 as zongfashu,cbpanshu,mcbpanshu,hcbpanshu,cczpanshu,mczpanshu,hczpanshu from TONGJICB )  a, Banhezhanxinxi b,t_s_depart c ");	
		if (!sqlWhere.isEmpty()) {
			sql.append(" where "+sqlWhere);
		}
		if(fzlx!=0 || fzlx!=null){
			switch (fzlx) {
				/*
				 case 1:
					sql.append(" group by biaoduanid");
					break;
				case 2:
					sql.append(" group by biaoduanid,xiangmubuid");
					break;*/
				case 3:
					sql.append(" group by departid,banhezhanminchen ");
					break;
			}
		}
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(), dataGrid.getPage(), dataGrid.getRows());
		// 将结果集转换成页面上对应的数据集
		Db2Page[] db2Pages = {
					new Db2Page("id")
					,new Db2Page("banhezhanminchen","banhezhanminchen")
					,new Db2Page("gujifangshu")
					,new Db2Page("pangshu")
					,new Db2Page("ambegin","lowcbps")
					,new Db2Page("amend","lowcbper")
					,new Db2Page("shuinipingzhong","midcbps")
					,new Db2Page("jiaozuobuwei","midcbper")					
					,new Db2Page("pmbegin","highcbps")					
					,new Db2Page("pmend","highcbper")
					,new Db2Page("Sha1_shijizhi","cczpanshu")
					,new Db2Page("Sha2_shijizhi","mczpanshu")
					,new Db2Page("Shi1_shijizhi","hczpanshu")					
					,new Db2Page("Sha1_lilunzhi","czper")
					,new Db2Page("Sha2_lilunzhi","mczper")
					,new Db2Page("Shi1_lilunzhi","hczper")
		};
		JSONObject jObject = getJsonDatagridEasyUI(mapList, iCount.intValue(), db2Pages);
		return jObject;
	}
		
	// 拼查询条件（where语句）
	String getSqlWhere(HntviewEntity pageObj,String startTime,String endTime,Integer fzlx,String userlft,String userrgt,String shebeibianhao) {
		// 拼出条件语句
		String sqlWhere = "";
		sqlWhere +=" a.shebeibianhao = b.gprsbianhao and b.departid=c.ID ";
		if (StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)) {
			sqlWhere += " and (convert(datetime,chuliaodate,121) between '"+ startTime + "' and '" + endTime + "')";
		}
		if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
			sqlWhere += " and c.lft >= '"+userlft+"' and c.rgt <= '" + userrgt + "'";
		}
		if(StringUtil.isNotEmpty(shebeibianhao)){
			sqlWhere +=" and  b.gprsbianhao= '"+shebeibianhao+"'";
		}
		return sqlWhere;
	}
		
}
