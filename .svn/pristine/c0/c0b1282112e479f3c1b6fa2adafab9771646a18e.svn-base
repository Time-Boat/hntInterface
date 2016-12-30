package com.shtoone.qms.service.impl.bhz;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.third.org.hsqldb.lib.StringUtil;
import com.shtoone.qms.service.bhz.BhgsYclAllviewServiceI;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl.Db2Page;

import com.shtoone.qms.entity.bhz.BhgsYclAllviewEntity;
import com.shtoone.qms.entity.bhz.HunnintuView;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;

@Service("bhgsYclAllviewService")
@Transactional
public class BhgsYclAllviewServiceImpl extends CommonServiceImpl implements BhgsYclAllviewServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((BhgsYclAllviewEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((BhgsYclAllviewEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((BhgsYclAllviewEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(BhgsYclAllviewEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(BhgsYclAllviewEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(BhgsYclAllviewEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,BhgsYclAllviewEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{bhgcount}",String.valueOf(t.getBhgcount()));
 		sql  = sql.replace("#{ljjccount}",String.valueOf(t.getLjjccount()));
 		sql  = sql.replace("#{departname}",String.valueOf(t.getDepartname()));
 		sql  = sql.replace("#{guige}",String.valueOf(t.getGuige()));
 		sql  = sql.replace("#{xinghao}",String.valueOf(t.getXinghao()));
 		sql  = sql.replace("#{biaoduanid}",String.valueOf(t.getBiaoduanid()));
 		sql  = sql.replace("#{chandi}",String.valueOf(t.getChandi()));
 		sql  = sql.replace("#{scchangjia}",String.valueOf(t.getScchangjia()));
 		sql  = sql.replace("#{leixing}",String.valueOf(t.getLeixing()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}

	
	public JSONObject getDatagrid5(BhgsYclAllviewEntity bhgview, DataGrid dataGrid,String leixing,String guige,String  xinghao,Integer lft,Integer rgt) {
		// TODO Auto-generated method stub
		StringBuilder queryCtest = new StringBuilder(" 1=1");
		if(!StringUtil.isEmpty(leixing)&&leixing!=null&&leixing.length()>0){
			queryCtest=queryCtest.append(" and leixing like '%"+leixing+"%'");
		}
		if(!StringUtil.isEmpty(guige)&&guige!=null&&guige.length()>0){
			queryCtest=queryCtest.append(" and guige  like '%"+guige+"%'");
		}
		if(!StringUtil.isEmpty(xinghao)&&xinghao!=null&&xinghao.length()>0){
			queryCtest=queryCtest.append(" and xinghao like '%"+xinghao+"%'");
		}
		if(lft>0 && rgt>0){
			queryCtest.append(" and lft >= '"+lft+"'"+" and rgt<= '"+rgt+"'" );
		}
		
		StringBuffer sql = new StringBuffer();
		sql.append("select t.id as id,bhgcount,round(convert(float,ljjccount),2) as ljjccount,t.departname,guige,xinghao,biaoduanid,chandi,scchangjia,leixing"
				+ " from bhgs_ycl_allview t"
				+ " inner join t_s_depart s on t.biaoduanid=s.ID "
				+ " where " +queryCtest.toString());
		// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
		String sqlCnt = "select count(*) from bhgs_ycl_allview t "
				+ " inner join t_s_depart s on t.biaoduanid=s.ID "
				+ " where"
						+ queryCtest.toString();
		Long iCount = getCountForJdbcParam(sqlCnt, null);
		
		List<Map<String, Object>> mapList = findForJdbc(sql.toString(),dataGrid.getPage(), dataGrid.getRows());
		Db2Page[] db2Pages = {
				new Db2Page("id"),
				new Db2Page("bhgcount"),
				new Db2Page("ljjccount"),
				new Db2Page("departname"),
				new Db2Page("guige"),
				new Db2Page("xinghao"),
				new Db2Page("biaoduanid"),
				new Db2Page("chandi"),
				new Db2Page("scchangjia"),
				new Db2Page("leixing")
		};
		
		JSONObject jObject = getJsonDatagridEasyUI(mapList,iCount.intValue(),db2Pages);
		return jObject;
	}
}