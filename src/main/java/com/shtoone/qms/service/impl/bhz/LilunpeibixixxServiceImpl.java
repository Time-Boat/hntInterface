package com.shtoone.qms.service.impl.bhz;


import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;

import com.shtoone.qms.entity.bhz.Lilunpeibixixx;
import com.shtoone.qms.service.bhz.LilunpeibixixxService;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("lilunpeibixixxService")
@Transactional
public class LilunpeibixixxServiceImpl extends CommonServiceImpl implements LilunpeibixixxService{
	@Autowired
	private JdbcDao jdbcDao;
	
	//加权限查询数据
	
	public JSONObject getLilunBySql(Lilunpeibixixx lilun, DataGrid dataGrid,String userlft,String userrgt,String startTime,String endTime){
		String queryString=" 1=1 ";
		if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
			queryString+=" and lft >= '"+userlft+"' and rgt <= '" + userrgt + "'";
		}
		if(StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)){
			queryString+=" and (reportDate Between '"+startTime+"' and '"+endTime+"')";
		}
		
		queryString+=" ";
		//加载总页数
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from S_HNT_Lilun_PHBView t where "+queryString.toString();
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		// 取出当前页的数据 
		StringBuffer sql = new StringBuffer();
		sql.append("select * from S_HNT_Lilun_PHBView t where"+queryString.toString() +" order by reportDate desc");
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(), dataGrid.getPage(), dataGrid.getRows());
		// 将结果集转换成页面上对应的数据集
		Db2Page[] db2Pages = {
				                        //页面的fieldID  数据库的字段名
							 new Db2Page("id","ID")
							,new Db2Page("phbreportId","phbreportId")
							,new Db2Page("reportDate","reportDate")
							,new Db2Page("gongchengbuwei","gongchengbuwei")
							,new Db2Page("qiangdudengji","qiangdudengji")
							,new Db2Page("shuiniLlphb","shuini_llphb")
							,new Db2Page("fenmeihuiLlphb","fenmeihui_llphb")
							,new Db2Page("kuangfenLlphb","kuangfen_llphb")
							,new Db2Page("xiguliaoLlphb","xiguliao_llphb")
							,new Db2Page("cuguliaoLlphb","cuguliao_llphb")
							,new Db2Page("banheshuiLlphb","banheshui_llphb")
							,new Db2Page("waijiajiLlphb","waijiaji_llphb")
							,new Db2Page("shuijiaobiLlphb","shuijiaobi_llphb")
							,new Db2Page("jiaocaiLlphb","jiaocai_llphb")
							,new Db2Page("shalvLlphb","shalv_llphb")
							,new Db2Page("kangyaqiangdu7d","kangyaqiangdu7d")
							,new Db2Page("kangyaqiangdu28d","kangyaqiangdu28d")
							,new Db2Page("kangyaqiangdu56d","kangyaqiangdu56d")
							,new Db2Page("diantongliang","diantongliang")
							,new Db2Page("kangdongxing","kangdongxing")
							,new Db2Page("lvkuosanxishu","lvkuosanxishu")
							,new Db2Page("testResult","testResult")
							,new Db2Page("tester","tester")
							,new Db2Page("userGroup","userGroup")
							,new Db2Page("superGroup","departname")
					};
		JSONObject jObject = getJsonDatagridEasyUI(mapList, iCount.intValue(), db2Pages);
		return jObject;
	}
	
	//这里廖泰鑫重新设置数据修约的函数	
	class MyDataExchangerFormcat implements IMyDataExchangerFormcat{
		public Object exchange(Object value){
			Object valueTemp=null;
			try{
				PropertyDescriptor origDescriptors[]= PropertyUtils.getPropertyDescriptors(value);
				for (int i = 0; i < origDescriptors.length; i++) {
					if(StringUtil.isNotEmpty(PropertyUtils.getSimpleProperty(value, origDescriptors[i].getName()))){
						if(origDescriptors[i].getPropertyType().toString().contains("class java.lang") ||
						   origDescriptors[i].getPropertyType().toString().contains("class java.math")){
							valueTemp=String.format("%1$.2f", Double.parseDouble(PropertyUtils.getSimpleProperty(value, origDescriptors[i].getName()).toString()));
						}
					}
				}
			}catch(Exception ex){}
			return valueTemp;
		}
	}

	
	public List<Lilunpeibixixx> getLilunpeibiBySQL(String userlft, String userrgt) {
		String queryString=" 1=1 ";
		if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
			queryString+=" and lft >= '"+userlft+"' and rgt <= '" + userrgt + "'";
		}
		List<Lilunpeibixixx> lilunList=new ArrayList<Lilunpeibixixx>();
		List<Object> list=findListbySql("SELECT ID,phbreportId FROM S_HNT_Lilun_PHBView WHERE "+queryString);
		if(list!=null){
			for(int i=0;i<list.size();i++){
				Object[] objArr=(Object[])list.get(i);
				Lilunpeibixixx lilun=new Lilunpeibixixx();
				lilun.setId(String.valueOf(objArr[0]));
				lilun.setPhbreportId(String.valueOf(objArr[1]));
				lilunList.add(lilun);
			}
		}
		return lilunList;
	}
	
	public List<Lilunpeibixixx> getLilunpeibiByDepartBySQL(String departId,String userlft, String userrgt){
		String queryString ="SELECT ID,phbreportId FROM S_HNT_Lilun_PHBView WHERE 1=1";
		if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
			queryString+=" and lft >= '"+userlft+"' and rgt <= '" + userrgt + "'";
		}
		if(StringUtil.isNotEmpty(departId)){
			queryString+=" and userGroup ='"+departId+"'";
		}
		return jdbcDao.find(queryString,Lilunpeibixixx.class, new HashMap<String, String>());
	}
}
