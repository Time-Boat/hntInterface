package com.shtoone.qms.service.impl.bhz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.entity.bhz.HunnintuView;
import com.shtoone.qms.service.bhz.HntbhzziduancfgViewServiceI;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;

@Service("hntbhzziduancfgViewService")
@Transactional
public class HntbhzziduancfgViewServiceImpl extends CommonServiceImpl implements HntbhzziduancfgViewServiceI {
	@Autowired
	private JdbcDao jdbcDao;
	
	public HntbhzziduancfgViewEntity findByGprsbhandleixin(String gprsbh, String leixin) {
		String queryString = "select model.* from HntbhzziduancfgView as model where model.gprsbianhao='"+gprsbh+"' and model.leixin='"+leixin+"'";
		List<HntbhzziduancfgViewEntity> hlist =jdbcDao.find(queryString, HntbhzziduancfgViewEntity.class, new HashMap<String, String>());
		if (hlist.size()>0) {
			return hlist.get(0);
		} else {
			return null;
		}	
	}
	
	//材料误差分析图例中复选按钮是否显示与不显示
	public HntbhzziduancfgViewEntity gethntcfgisShow20(String shebeibianhao) {
		if (StringUtil.isNotEmpty(shebeibianhao)) {
			return findByGprsbhandleixin(shebeibianhao, "21");
		} else {
			return findByGprsbhandleixin("all", "20");
		}
	}
	
	public HntbhzziduancfgViewEntity gethntcfgfield(String shebeibianhao) {
		HntbhzziduancfgViewEntity hview = findByGprsbhandleixin(shebeibianhao, "1");
		if (null == hview) {
			hview = findByGprsbhandleixin("all", "100");
		}
		return hview;
	}
	
	public HntbhzziduancfgViewEntity gethntbhzisShow(String shebeibianhao) {
		HntbhzziduancfgViewEntity hview = findByGprsbhandleixin(shebeibianhao, "2");
		if (null == hview) {
			hview = findByGprsbhandleixin("all", "101");			
		}
		return hview;
	}
	
	public JSONObject getDatagrid3(HunnintuView hunnintuView,
			DataGrid dataGrid, String startTime, String endTime,
			Integer userlft, Integer userrgt, String jiaozuobuwei,
			String gongchengmingcheng,String shebeibianhao) {

		StringBuilder queryCtest = new StringBuilder("");
		queryCtest.append(" (convert(datetime,chuliaoshijian,121) between '"+ startTime + "' and '" + endTime + "')");
		if (StringUtil.isNotEmpty(jiaozuobuwei)) {
			queryCtest.append(" and jiaozuobuwei like '%" + jiaozuobuwei + "%'");
		}
		if (StringUtil.isNotEmpty(gongchengmingcheng)) {
			queryCtest.append(" and gongchengmingcheng like '%"+ gongchengmingcheng + "%'");
		}
		if(StringUtil.isNotEmpty(shebeibianhao)){
			queryCtest.append(" and shebeibianhao ='"+shebeibianhao+"'");
		}
		if(userlft>0 && userrgt>0){
			queryCtest.append(" and lft >= '"+userlft+"'"+" and rgt<= '"+userrgt+"'");
		}

		StringBuffer sql = new StringBuffer();
		sql.append("select id,gongdanhao,chaozuozhe,chuliaoshijian,gongchengmingcheng,sigongdidian,jiaozuobuwei,shuinipingzhong,waijiajipingzhong,peifanghao,qiangdudengji,jiaobanshijian,shebeibianhao,baocunshijian,kehuduanbianhao,biaoshi,caijishijian,gujifangshu,bhzid,gprsbianhao,gprstype,banhezhanminchen,jianchen,shebeichanjia,shebeixinghao,gongkongleixin,caijiduanruanjianbanben,jiekouleixin,shujukuleixin,shuliang,simhao,simpwd,botelu,taocan,smsbaojin,smstype,sendtype,panshu,ambegin,amend,pmbegin,pmend,smssettype,shebeidizhi,shebeimianji,caozuoren,zhanzhang,lianxidianhua,shijiangeshi,orderid,departid,remark,lft,rgt,wjper4,wjper3,wjper2,wjper1,shper2,shper1,flper6,flper5,flper4,flper3,flper2,flper1,glper5,glper4,glper3,glper2,glper1,wjw4,wjw3,wjw2,wjw1,shw2,shw1,flw6,flw5,flw4,flw3,flw2,flw1,glw5,glw4,glw3,glw2,glw1,");
		sql.append("cast(sha1_shijizhi as numeric(22,2))as sha1_shijizhi,");
		sql.append("cast(shi1_shijizhi as numeric(22,2))as shi1_shijizhi,");	
		
		sql.append("cast(shi2_shijizhi as numeric(22,2))as shi2_shijizhi,");
		sql.append("cast(sha2_shijizhi as numeric(22,2))as sha2_shijizhi,");	
		
		sql.append("cast(guliao5_shijizhi as numeric(22,2))as guliao5_shijizhi,");
		sql.append("cast(shuini1_shijizhi as numeric(22,2))as shuini1_shijizhi,");	
		
		sql.append("cast(shuini2_shijizhi as numeric(22,2))as shuini2_shijizhi,");
		sql.append("cast(kuangfen3_shijizhi as numeric(22,2))as kuangfen3_shijizhi,");	
		
		sql.append("cast(feimeihui4_shijizhi as numeric(22,2))as feimeihui4_shijizhi,");
		sql.append("cast(fenliao5_shijizhi as numeric(22,2))as fenliao5_shijizhi,");	
		
		sql.append("cast(fenliao6_shijizhi as numeric(22,2))as fenliao6_shijizhi,");
		sql.append("cast(shui1_shijizhi as numeric(22,2))as shui1_shijizhi,");	
		
		sql.append("cast(shui2_shijizhi as numeric(22,2))as shui2_shijizhi,");
		sql.append("cast(waijiaji1_shijizhi as numeric(22,2))as waijiaji1_shijizhi,");	
		
		sql.append("cast(waijiaji2_shijizhi as numeric(22,2))as waijiaji2_shijizhi,");
		sql.append("cast(waijiaji3_shijizhi as numeric(22,2))as waijiaji3_shijizhi,");	
		
		sql.append("cast(waijiaji4_shijizhi as numeric(22,2))as waijiaji4_shijizhi,");
		sql.append("cast(sha1_lilunzhi as numeric(22,2))as sha1_lilunzhi,");	
		
		sql.append("cast(shi1_lilunzhi as numeric(22,2))as shi1_lilunzhi,");
		sql.append("cast(shi2_lilunzhi as numeric(22,2))as shi2_lilunzhi,");	
		
		sql.append("cast(sha2_lilunzhi as numeric(22,2))as sha2_lilunzhi,");
		sql.append("cast(guliao5_lilunzhi as numeric(22,2))as guliao5_lilunzhi,");	
		
		sql.append("cast(shuini1_lilunzhi as numeric(22,2))as shuini1_lilunzhi,");
		sql.append("cast(shuini2_lilunzhi as numeric(22,2))as shuini2_lilunzhi,");	
		
		sql.append("cast(kuangfen3_lilunzhi as numeric(22,2))as kuangfen3_lilunzhi,");
		sql.append("cast(feimeihui4_lilunzhi as numeric(22,2))as feimeihui4_lilunzhi,");	
		
		sql.append("cast(fenliao5_lilunzhi as numeric(22,2))as fenliao5_lilunzhi,");
		sql.append("cast(fenliao6_lilunzhi as numeric(22,2))as fenliao6_lilunzhi,");	
	
		sql.append("cast(shui1_lilunzhi as numeric(22,2))as shui1_lilunzhi,");
		sql.append("cast(shui2_lilunzhi as numeric(22,2))as shui2_lilunzhi,");	
	
		sql.append("cast(waijiaji1_lilunzhi as numeric(22,2))as waijiaji1_lilunzhi,");
		sql.append("cast(waijiaji2_lilunzhi as numeric(22,2))as waijiaji2_lilunzhi,");	
	
		sql.append("cast(waijiaji3_lilunzhi as numeric(22,2))as waijiaji3_lilunzhi,");
		sql.append("cast(waijiaji4_lilunzhi as numeric(22,2))as waijiaji4_lilunzhi");	
		
		
		sql.append(" from HunnintuView t");
		sql.append(" where "+queryCtest.toString());
		sql.append("order by t.chuliaoshijian desc");
		
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from HunnintuView t  where"+ queryCtest.toString();
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(),dataGrid.getPage(), dataGrid.getRows());
		
		// 将结果集转换成页面上对应的数据集
		Db2Page[] db2Pages = {
				new Db2Page("id", "id"),
				 new Db2Page("banhezhanminchen", "banhezhanminchen"),
				new Db2Page("gongchengmingcheng", "gongchengmingcheng"),
				new Db2Page("sigongdidian", "sigongdidian"),
				new Db2Page("jiaozuobuwei", "jiaozuobuwei"),
				new Db2Page("qiangdudengji", "qiangdudengji"),			
				new Db2Page("chuliaoshijian", "chuliaoshijian"),
				new Db2Page("baocunshijian", "baocunshijian"),
				
				
				new Db2Page("shui2_shijizhi", "shui2_shijizhi"),
				new Db2Page("shui2_lilunzhi", "shui2_lilunzhi"),
			
				new Db2Page("shuini1_shijizhi", "shuini1_shijizhi"),
				new Db2Page("shuini1_lilunzhi", "shuini1_lilunzhi"),
				new Db2Page("shuini2_shijizhi", "shuini2_shijizhi"),
				new Db2Page("shuini2_lilunzhi", "shuini2_lilunzhi"),
				
				new Db2Page("sha1_shijizhi", "sha1_shijizhi"),
				new Db2Page("sha1_lilunzhi", "sha1_lilunzhi"),
				
				new Db2Page("sha2_shijizhi", "sha2_shijizhi"),	
				new Db2Page("sha2_lilunzhi", "sha2_lilunzhi"),
				
				new Db2Page("shi1_shijizhi", "shi1_shijizhi"),	
				new Db2Page("shi1_lilunzhi", "shi1_lilunzhi"),
				new Db2Page("shi2_shijizhi", "shi2_shijizhi"),
				new Db2Page("shi2_lilunzhi", "shi2_lilunzhi"),
			
				
				new Db2Page("kuangfen3_shijizhi", "kuangfen3_shijizhi"),				
				new Db2Page("kuangfen3_lilunzhi", "kuangfen3_lilunzhi"),
				new Db2Page("feimeihui4_shijizhi", "feimeihui4_shijizhi"),
				new Db2Page("feimeihui4_lilunzhi", "feimeihui4_lilunzhi"),	
				
				new Db2Page("guliao5_shijizhi", "guliao5_shijizhi"),
				new Db2Page("guliao5_lilunzhi", "guliao5_lilunzhi"),
				
				new Db2Page("fenliao5_shijizhi", "fenliao5_shijizhi"),
				
				new Db2Page("fenliao5_lilunzhi", "fenliao5_lilunzhi"),
			
				new Db2Page("fenliao6_shijizhi", "fenliao6_shijizhi"),				
				new Db2Page("fenliao6_lilunzhi", "fenliao6_lilunzhi"),
				
				new Db2Page("waijiaji1_shijizhi", "waijiaji1_shijizhi"),				
				new Db2Page("waijiaji1_lilunzhi", "waijiaji1_lilunzhi"),
				new Db2Page("waijiaji2_shijizhi", "waijiaji2_shijizhi"),
				new Db2Page("waijiaji2_lilunzhi", "waijiaji2_lilunzhi"),				
				new Db2Page("waijiaji3_shijizhi", "waijiaji3_shijizhi"),
				new Db2Page("waijiaji3_lilunzhi", "waijiaji3_lilunzhi"),
				new Db2Page("waijiaji4_shijizhi", "waijiaji4_shijizhi"),				
				new Db2Page("waijiaji4_lilunzhi", "waijiaji4_lilunzhi"),
				new Db2Page("shuinipingzhong", "shuinipingzhong"),
				new Db2Page("waijiajipingzhong", "waijiajipingzhong"),
				
		
				new Db2Page("shui1_shijizhi", "shui1_shijizhi"),
				
				new Db2Page("shui1_lilunzhi", "shui1_lilunzhi"),
				new Db2Page("gujifangshu", "gujifangshu")
				
		};
		return getJsonDatagridEasyUI(mapList,iCount.intValue(),db2Pages);
	}
	
	/**
	 * 图表显示
	 */
	
	public String getHntAnalysisColumnXml(JSONObject jObject,DataGrid dataGrid,HntbhzziduancfgViewEntity hntbhzField,HntbhzziduancfgViewEntity hntbhzisShow) {
		return createhntcnfxxml(jObject,dataGrid,hntbhzField, hntbhzisShow);
	}
	
	public void appendSetXml(StringBuilder strb, String value) {
		float tf = -1;
		if(value == null|| value.trim().equals("")||value.trim().equalsIgnoreCase("null")){
			value= "";
			tf = StringUtil.toFloat(value);
		}else{
			tf = StringUtil.toFloat(value);
		}
		
		if (tf > 0) {
			strb.append("<set value='");
			strb.append(tf);
			strb.append("'/>");
		} else {
			strb.append("<set />");
		}		
	}
	
	private String createhntcnfxxml(JSONObject jObject,DataGrid dataGrid,HntbhzziduancfgViewEntity hntbhzField,HntbhzziduancfgViewEntity hntbhzisShow) {
				// 解析json数据
		Iterator it = jObject.keys();
		
		JSONArray array = null;
		while (it.hasNext()) {
			String key = (String) it.next();
			if (key.equals("rows")){
				array = jObject.getJSONArray(key);
			
			}

		}
		
		//混凝土拌和站材料用量查询走势图
		//public String getHntCailiaoXml(List<HunnintuView> hv, HntbhzziduancfgView hntbhzField, HntbhzziduancfgView hntbhzisShow) {
			StringBuilder strXML = new StringBuilder("");
			strXML.append("<?xml version='1.0' encoding='utf-8'?><chart caption='材料用量走势图(请点击该行以便显示走势图)' subcaption='(");
			JSONObject key3 = array.getJSONObject(0);	
			strXML.append(key3.get("baocunshijian"));
			
			strXML.append("至");
			
			strXML.append(array.getJSONObject(array.size()-1).get("baocunshijian"));
			
			strXML.append(")' lineThickness='2' showValues='0' anchorRadius='2' ");
			strXML.append("divLineAlpha='20' divLineColor='CC3300' divLineIsDashed='1' slantLabels='1' ");
			strXML.append("showAlternateHGridColor='1' alternateHGridColor='CC3300' shadowAlpha='40' ");
			strXML.append("labelStep='");
			strXML.append(array.size()/5);
			strXML.append("' numvdivlines='15' chartRightMargin='35' chartLeftMargin='35' formatNumberScale='0' ");
			strXML.append("bgColor='FFFFFF,CC3300' bgAngle='270' bgAlpha='10,10' alternateHGridAlpha='5' numberSuffix='kg'> ");
			strXML.append("<categories>");
			//for (HunnintuView hunnintuView : hv) {
			for (int i = 0; i < array.size(); i++) {
				JSONObject key2 = array.getJSONObject(i);
				strXML.append("<category label='");
				strXML.append(key2.get("baocunshijian"));
				strXML.append("'/>");
			}
			strXML.append("</categories>");
			if (null != hntbhzField && null != hntbhzisShow) {
				if (hntbhzisShow.getShui1_shijizhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getShui1_shijizhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						//System.out.println((String)(key2.get("shui1_shijizhi"))+"-0-");
						appendSetXml(strXML,(String)(key2.get("shui1_shijizhi")));					
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getShui1_lilunzhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getShui1_lilunzhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						//System.out.println((String)(key2.get("shui1_lilunzhi"))+"-0-");
						appendSetXml(strXML,(String)(key2.get("shui1_lilunzhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getShui2_shijizhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getShui2_shijizhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,  (String)(key2.get("shui2_shijizhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getShui2_lilunzhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getShui2_lilunzhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML, (String)(key2.get("shui2_lilunzhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getShuini1_shijizhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getShuini1_shijizhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML, (String)(key2.get("shuini1_shijizhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getShuini1_lilunzhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getShuini1_lilunzhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML, (String)(key2.get("shuini1_lilunzhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getShuini2_shijizhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getShuini2_shijizhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML, (String)(key2.get("shuini2_shijizhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getShuini2_lilunzhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getShuini2_lilunzhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML, (String)(key2.get("shuini2_lilunzhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getSha1_shijizhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getSha1_shijizhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML, (String)(key2.get("sha1_shijizhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getSha1_lilunzhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getSha1_lilunzhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML, (String)(key2.get("sha1_lilunzhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getShi1_shijizhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getShi1_shijizhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("shi1_shijizhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getShi1_lilunzhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getShi1_lilunzhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("shi1_lilunzhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getShi2_shijizhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getShi2_shijizhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("shi2_shijizhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getShi2_lilunzhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getShi2_lilunzhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("shi2_lilunzhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getSha2_shijizhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getSha2_shijizhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("sha2_shijizhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getSha2_lilunzhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getSha2_lilunzhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("sha2_lilunzhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getGuliao5_shijizhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getGuliao5_shijizhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("guliao5_shijizhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getGuliao5_lilunzhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getGuliao5_lilunzhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("guliao5_lilunzhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getKuangfen3_shijizhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getKuangfen3_shijizhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("Kuangfen3_shijizhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getKuangfen3_lilunzhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getKuangfen3_lilunzhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("kuangfen3_lilunzhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getFeimeihui4_shijizhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getFeimeihui4_shijizhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("feimeihui4_shijizhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getFeimeihui4_lilunzhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getFeimeihui4_lilunzhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("feimeihui4_lilunzhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getFenliao5_shijizhi().equalsIgnoreCase("1")) {
					//System.out.println( "粉料5实际值："+hntbhzisShow.getFenliao5_shijizhi());
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getFenliao5_shijizhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);		
						appendSetXml(strXML,(String)(key2.get("fenliao5_shijizhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getFenliao5_lilunzhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getFenliao5_lilunzhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("fenliao5_lilunzhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getFenliao6_shijizhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getFenliao6_shijizhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("fenliao6_shijizhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getFenliao6_lilunzhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getFenliao6_lilunzhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("fenliao6_lilunzhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getWaijiaji1_shijizhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getWaijiaji1_shijizhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("waijiaji1_shijizhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getWaijiaji1_lilunzhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getWaijiaji1_lilunzhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("waijiaji1_lilunzhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getWaijiaji2_shijizhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getWaijiaji2_shijizhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("waijiaji2_shijizhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getWaijiaji2_lilunzhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getWaijiaji2_lilunzhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("waijiaji2_lilunzhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getWaijiaji3_shijizhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getWaijiaji3_shijizhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML, (String)(key2.get("waijiaji3_shijizhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getWaijiaji3_lilunzhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getWaijiaji3_lilunzhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("waijiaji3_lilunzhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getWaijiaji4_shijizhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getWaijiaji4_shijizhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML,(String)(key2.get("waijiaji4_shijizhi")));
					}
					strXML.append("</dataset>");	
				}
				
				if (hntbhzisShow.getWaijiaji4_lilunzhi().equalsIgnoreCase("1")) {
					strXML.append("<dataset seriesName='");
					strXML.append(hntbhzField.getWaijiaji4_lilunzhi());
					strXML.append("'>");
					//for (HunnintuView hunnintuView : hv) {
					for (int i = 0; i < array.size(); i++) {
						JSONObject key2 = array.getJSONObject(i);
						appendSetXml(strXML, (String)(key2.get("waijiaji4_lilunzhi")));
					}
					strXML.append("</dataset>");	
				}
				
			} else {
				strXML.append("<dataset seriesName='水'>");
				//for (HunnintuView hunnintuView : hv) {
				for (int i = 0; i < array.size(); i++) {
					JSONObject key2 = array.getJSONObject(i);
					strXML.append("<set value='");
					strXML.append(key2.get("shui1_shijizhi"));
					strXML.append("'/>");
				}
				strXML.append("</dataset>");
				
				strXML.append("<dataset seriesName='粉料1'>");
				//for (HunnintuView hunnintuView : hv) {
				for (int i = 0; i < array.size(); i++) {
					JSONObject key2 = array.getJSONObject(i);
					strXML.append("<set value='");
					strXML.append(key2.get("shuini1_shijizhi"));
					strXML.append("'/>");
				}
				strXML.append("</dataset>");
				
				strXML.append("<dataset seriesName='粉料2'>");
				//for (HunnintuView hunnintuView : hv) {
				for (int i = 0; i < array.size(); i++) {
					JSONObject key2 = array.getJSONObject(i);
					strXML.append("<set value='");
					strXML.append(key2.get("shuini2_shijizhi") );
					strXML.append("'/>");
				}
				strXML.append("</dataset>");
				
				strXML.append("<dataset seriesName='粉料3'>");
				//for (HunnintuView hunnintuView : hv) {
				for (int i = 0; i < array.size(); i++) {
					JSONObject key2 = array.getJSONObject(i);
					strXML.append("<set value='");
					strXML.append(key2.get("kuangfen3_shijizhi"));
					strXML.append("'/>");
				}
				strXML.append("</dataset>");
				
				strXML.append("<dataset seriesName='粉料4'>");
				//for (HunnintuView hunnintuView : hv) {
				for (int i = 0; i < array.size(); i++) {
					JSONObject key2 = array.getJSONObject(i);
					strXML.append("<set value='");
					strXML.append(key2.get("feimeihui4_shijizhi"));
					strXML.append("'/>");
				}
				strXML.append("</dataset>");
				
				strXML.append("<dataset seriesName='骨料1'>");
				//for (HunnintuView hunnintuView : hv) {
				for (int i = 0; i < array.size(); i++) {
					JSONObject key2 = array.getJSONObject(i);
					strXML.append("<set value='");
					strXML.append(key2.get("sha1_shijizhi"));
					strXML.append("'/>");
				}
				strXML.append("</dataset>");
				
				strXML.append("<dataset seriesName='骨料2'>");
				//for (HunnintuView hunnintuView : hv) {
				for (int i = 0; i < array.size(); i++) {
					JSONObject key2 = array.getJSONObject(i);
					strXML.append("<set value='");
					strXML.append(key2.get("shi1_shijizhi") );
					strXML.append("'/>");
				}
				strXML.append("</dataset>");
				
				strXML.append("<dataset seriesName='骨料3'>");
				//for (HunnintuView hunnintuView : hv) {
				for (int i = 0; i < array.size(); i++) {
					JSONObject key2 = array.getJSONObject(i);
					strXML.append("<set value='");
					strXML.append(key2.get("shi2_shijizhi"));
					strXML.append("'/>");
				}
				strXML.append("</dataset>");
				
				strXML.append("<dataset seriesName='骨料4'>");
				//for (HunnintuView hunnintuView : hv) {
				for (int i = 0; i < array.size(); i++) {
					JSONObject key2 = array.getJSONObject(i);
					strXML.append("<set value='");
					strXML.append(key2.get("sha2_shijizhi"));
					strXML.append("'/>");
				}
				strXML.append("</dataset>");		
				
				strXML.append("<dataset seriesName='外加剂1'>");
				//for (HunnintuView hunnintuView : hv) {
				for (int i = 0; i < array.size(); i++) {
					JSONObject key2 = array.getJSONObject(i);
					strXML.append("<set value='");
					strXML.append(key2.get("waijiaji1_shijizhi"));
					strXML.append("'/>");
				}
				strXML.append("</dataset>");
			}

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
		//用量查询结束
		
	}
	
}