package com.shtoone.qms.service.impl.bhz;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;

import com.shtoone.qms.entity.bhz.Shigongpeibixixx;
import com.shtoone.qms.service.bhz.ShigongpeibixixxService;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("shigongpeibixixxService")
@Transactional
public class ShigongpeibixixxServiceImpl extends CommonServiceImpl implements ShigongpeibixixxService{
	
	public JSONObject getShigongByparams(Shigongpeibixixx shigong, DataGrid dataGrid,String shebeibianhao,
			String baopidata_begin,String baopidata_end,String pifudata_begin,String pifudata_end,String userlft,String userrgt,String lilunId){
		String queryString=" 1=1 ";
		if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
			queryString+=" and lft >= '"+userlft+"' and rgt <= '" + userrgt + "'";
		}
		if(StringUtil.isNotEmpty(baopidata_begin) && StringUtil.isNotEmpty(baopidata_end)){
			queryString+=" and (reportDate Between '"+baopidata_begin+"' and '"+baopidata_end+"')";
		}
		if(StringUtil.isNotEmpty(pifudata_begin) && StringUtil.isNotEmpty(pifudata_end)){
			queryString+=" and (reportDate Between '"+pifudata_begin+"' and '"+pifudata_end+"')";
		}
		if(StringUtil.isNotEmpty(shebeibianhao)){
			queryString+=" and shebeibianhao='"+shebeibianhao+"'";
		}
		if(StringUtil.isNotEmpty(lilunId)){
			queryString+=" and lilunId='"+lilunId+"'";
		}
		
		//加载总页数
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from S_HNT_PHBView t where "+queryString.toString();
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		// 取出当前页的数据 
		StringBuffer sql = new StringBuffer();
		sql.append("select * from S_HNT_PHBView t where"+queryString.toString()+" order by baopidata");
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(), dataGrid.getPage(), dataGrid.getRows());
		// 将结果集转换成页面上对应的数据集
		Db2Page[] db2Pages = {
				                        //页面的fieldID  数据库的字段名
							 new Db2Page("id","ID")
							,new Db2Page("productWorkNo","productWorkNo")
							,new Db2Page("shebeibianhao","banhezhanminchen")   //拌和机名称
							,new Db2Page("chuliaofangliang","chuliaofangliang")
							,new Db2Page("xigl1ph","xigl1ph")
							,new Db2Page("xigl2ph","xigl2ph")
							,new Db2Page("chugl1ph","chugl1ph")
							,new Db2Page("chugl2ph","chugl2ph")
							,new Db2Page("chugl3ph","chugl3ph")
							,new Db2Page("shuini1ph","shuini1ph")
							,new Db2Page("kuangfenph","kuangfenph")
							,new Db2Page("fenmeihuiph","fenmeihuiph")
							,new Db2Page("shui1ph","shui1ph")
							,new Db2Page("waijijia1ph","waijijia1ph")
							,new Db2Page("waijijia2ph","waijijia2ph")
							,new Db2Page("waijijia3ph","waijijia3ph")
							,new Db2Page("waijijia4ph","waijijia4ph")
							,new Db2Page("shuijiaobi","shuijiaobi")
							,new Db2Page("baopidata","baopidata")
							,new Db2Page("pifudata","pifudata")
							,new Db2Page("remark","remark")
							,new Db2Page("userGroup","departname")   //所属组织机构
							,new Db2Page("dataresource","dataresource")
							,new Db2Page("superGroup","departname") 
							,new Db2Page("lilunId","phbreportId")  //关联的理论配比
					};
		JSONObject jObject = getJsonDatagridEasyUI(mapList, iCount.intValue(), db2Pages);
		return jObject;
	}
}
