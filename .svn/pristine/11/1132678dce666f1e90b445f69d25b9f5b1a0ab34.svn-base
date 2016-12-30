package com.shtoone.qms.service.impl.bhz;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;

import com.shtoone.qms.entity.bhz.HntbhzziduancfgEntity;

import com.shtoone.qms.service.bhz.HntbhzziduancfgServiceI;

import org.jeecgframework.core.common.model.json.DataGrid;

import java.util.HashMap;
import java.util.List;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;

@Service("hntbhzziduancfgService")
@Transactional
public class HntbhzziduancfgServiceImpl extends CommonServiceImpl implements HntbhzziduancfgServiceI {
	@Autowired
	private JdbcDao jdbcDao;

	// 方式3, 取值进一步自己处理(直接转换成easyUI的datagrid需要的东西，执行效率最高，最自由)  -------------------------------	
		public JSONObject getDatagrid3(HntbhzziduancfgViewEntity pageObj, DataGrid dataGrid,
				String departid,String shebeibianhao, String userlft, String userrgt) {
			
			StringBuilder queryCondition = new StringBuilder("");
			queryCondition.append(" leixin='1'");
//			if(StringUtil.isNotEmpty(departid)){
//				queryCondition.append(" and departid='"+departid+"'");
//			}
			
			if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
				queryCondition.append(" and lft >= '"+userlft
						+"' and rgt <= '" + userrgt + "'");
			}
			
			if(StringUtil.isNotEmpty(shebeibianhao)){
				queryCondition.append(" and gprsbianhao='"+shebeibianhao+"'");
			}
			
			// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
			String sqlCnt = "select count(*) from HntbhzziduancfgView t where"+queryCondition.toString();
			Long iCount = getCountForJdbcParam(sqlCnt, null);
			
			// 取出当前页的数据 
			StringBuffer sql = new StringBuffer();
			sql.append("select * from HntbhzziduancfgView t where"+queryCondition.toString());
			
			//System.out.println(sql.toString());
			List<Map<String, Object>> mapList = findForJdbc(sql.toString(), dataGrid.getPage(), dataGrid.getRows());
			// 将结果集转换成页面上对应的数据集
			Db2Page[] db2Pages = {
					new Db2Page("id", "id"),
					// ,new Db2Page("quanju","全局")
					new Db2Page("baocunshijian", "baocunshijian"),
					new Db2Page("chaozuozhe", "chaozuozhe"),
					new Db2Page("chuliaoshijian", "chuliaoshijian"),
					new Db2Page("feimeihui4_shijizhi", "feimeihui4_shijizhi"),
					new Db2Page("feimeihui4_lilunzhi", "feimeihui4_lilunzhi"),
					new Db2Page("fenliao5_shijizhi", "fenliao5_shijizhi"),
					new Db2Page("fenliao5_lilunzhi", "fenliao5_lilunzhi"),
					new Db2Page("fenliao6_shijizhi", "fenliao6_shijizhi"),				
					new Db2Page("fenliao6_lilunzhi", "fenliao6_lilunzhi"),
					new Db2Page("gongchengmingcheng", "gongchengmingcheng"),
					new Db2Page("gongdanhao", "gongdanhao"),
					new Db2Page("gprsbianhao", "gprsbianhao"),
					new Db2Page("guliao5_shijizhi", "guliao5_shijizhi"),
					new Db2Page("guliao5_lilunzhi", "guliao5_lilunzhi"),
					new Db2Page("jiaobanshijian", "jiaobanshijian"),
					new Db2Page("jiaozuobuwei", "jiaozuobuwei"),
					new Db2Page("kuangfen3_shijizhi", "kuangfen3_shijizhi"),				
					new Db2Page("kuangfen3_lilunzhi", "kuangfen3_lilunzhi"),
					new Db2Page("peifanghao", "peifanghao"),
					new Db2Page("qiangdudengji", "qiangdudengji"),	
					new Db2Page("sha1_shijizhi", "sha1_shijizhi"),
					new Db2Page("sha1_lilunzhi", "sha1_lilunzhi"),
					new Db2Page("sha2_shijizhi", "sha2_shijizhi"),	
					new Db2Page("sha2_lilunzhi", "sha2_lilunzhi"),
					new Db2Page("shebeibianhao", "shebeibianhao"),
					new Db2Page("shi1_shijizhi", "shi1_shijizhi"),	
					new Db2Page("shi1_lilunzhi", "shi1_lilunzhi"),
					new Db2Page("shi2_shijizhi", "shi2_shijizhi"),
					new Db2Page("shi2_lilunzhi", "shi2_lilunzhi"),
					new Db2Page("shui1_shijizhi", "shui1_shijizhi"),
					new Db2Page("shui1_lilunzhi", "shui1_lilunzhi"),
					new Db2Page("shui2_shijizhi", "shui2_shijizhi"),
					new Db2Page("shui2_lilunzhi", "shui2_lilunzhi"),
					new Db2Page("shuini1_shijizhi", "shuini1_shijizhi"),
					new Db2Page("shuini1_lilunzhi", "shuini1_lilunzhi"),
					new Db2Page("shuini2_shijizhi", "shuini2_shijizhi"),
					new Db2Page("shuinipingzhong", "shuinipingzhong"),
					new Db2Page("sigongdidian", "sigongdidian"),
					new Db2Page("shuini2_lilunzhi", "shuini2_lilunzhi"),
					new Db2Page("shuini2_lilunzhi", "shuini2_lilunzhi"),
					new Db2Page("waijiaji1_shijizhi", "waijiaji1_shijizhi"),				
					new Db2Page("waijiaji1_lilunzhi", "waijiaji1_lilunzhi"),
					new Db2Page("waijiaji2_shijizhi", "waijiaji2_shijizhi"),
					new Db2Page("waijiaji2_lilunzhi", "waijiaji2_lilunzhi"),				
					new Db2Page("waijiaji3_shijizhi", "waijiaji3_shijizhi"),
					new Db2Page("waijiaji3_lilunzhi", "waijiaji3_lilunzhi"),
					new Db2Page("waijiaji4_shijizhi", "waijiaji4_shijizhi"),				
					new Db2Page("waijiaji4_lilunzhi", "waijiaji4_lilunzhi"),
					new Db2Page("waijiajipingzhong", "waijiajipingzhong"),
					new Db2Page("leixin", "leixin"),
					new Db2Page("caijishijian", "caijishijian"),
					new Db2Page("gujifangshu", "gujifangshu"),
					new Db2Page("banhezhanminchen", "banhezhanminchen"),
					new Db2Page("jianchen", "jianchen"),
					new Db2Page("smsbaojin", "smsbaojin"),
					new Db2Page("departid", "departid")
			};
			JSONObject jObject = getJsonDatagridEasyUI(mapList, iCount.intValue(), db2Pages);
			return jObject;
			// end of 方式3 ========================================= */
		}
			

	//材料误差查询中的配置文件

	public HntbhzziduancfgEntity gethntcfg20(String shebeibianhao) {
		if (StringUtil.isNotEmpty(shebeibianhao)) {
			return findByGprsbhandleixin(shebeibianhao, "21");
		} else {
			return findByGprsbhandleixin("all", "20");
		}
	}
	
	public HntbhzziduancfgEntity findByGprsbhandleixin(String gprsbh, String leixin) {
		String queryString = "select model.* from Hntbhzziduancfg as model where model.gprsbianhao='"+gprsbh+"' and model.leixin='"+leixin+"'";
		List<HntbhzziduancfgEntity> hlist =jdbcDao.find(queryString, HntbhzziduancfgEntity.class, new HashMap<String, String>());
		if (hlist.size()>0) {
			return hlist.get(0);
		} else {
			return null;
		}	
	}

}