package com.shtoone.qms.service.impl.bhz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.exception.BusinessException;

import com.shtoone.qms.service.bhz.SYclGuigexinghaomServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.io.Serializable;

import com.shtoone.qms.entity.bhz.BanhezhanxinxiEntity;
import com.shtoone.qms.entity.bhz.SYclGuigexinghaomEntity;
import com.shtoone.qms.entity.bhz.SYclGuigexinghaosEntity;
@Service("sYclGuigexinghaomService")
@Transactional
public class SYclGuigexinghaomServiceImpl extends CommonServiceImpl implements SYclGuigexinghaomServiceI {
	@Autowired
	private JdbcDao jdbcDao;
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((SYclGuigexinghaomEntity)entity);
 	}
	
	public void addMain(SYclGuigexinghaomEntity sYclGuigexinghaom,
	        List<SYclGuigexinghaosEntity> sYclGuigexinghaosList){
			//保存主信息
			this.save(sYclGuigexinghaom);
		
			/**保存-型号子表*/
			for(SYclGuigexinghaosEntity sYclGuigexinghaos:sYclGuigexinghaosList){
				//外键设置
				sYclGuigexinghaos.setSelectkey(sYclGuigexinghaom.getSelectkey());
				this.save(sYclGuigexinghaos);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(sYclGuigexinghaom);
	}

	
	public void updateMain(SYclGuigexinghaomEntity sYclGuigexinghaom,
	        List<SYclGuigexinghaosEntity> sYclGuigexinghaosList) {
		//保存主表信息
		this.saveOrUpdate(sYclGuigexinghaom);
		//===================================================================================
		//获取参数
		Object sELECTKEY0 = sYclGuigexinghaom.getSelectkey();
		//===================================================================================
		//1.查询出数据库的明细数据-型号子表
	    String hql0 = "from SYclGuigexinghaosEntity where 1 = 1 AND sELECTKEY = ? ";
	    List<SYclGuigexinghaosEntity> sYclGuigexinghaosOldList = this.findHql(hql0,sELECTKEY0);
		//2.筛选更新明细数据-型号子表
		for(SYclGuigexinghaosEntity oldE:sYclGuigexinghaosOldList){
			boolean isUpdate = false;
				for(SYclGuigexinghaosEntity sendE:sYclGuigexinghaosList){
					//需要更新的明细数据-型号子表
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-型号子表
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-型号子表
			for(SYclGuigexinghaosEntity sYclGuigexinghaos:sYclGuigexinghaosList){
				if(sYclGuigexinghaos.getId()==null){
					//外键设置
					sYclGuigexinghaos.setSelectkey(sYclGuigexinghaom.getSelectkey());
					this.save(sYclGuigexinghaos);
				}
			}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(sYclGuigexinghaom);
	}

	
	public void delMain(SYclGuigexinghaomEntity sYclGuigexinghaom) {
		//删除主表信息
		this.delete(sYclGuigexinghaom);
		//===================================================================================
		//获取参数
		Object sELECTKEY0 = sYclGuigexinghaom.getSelectkey();
		//===================================================================================
		//删除-型号子表
	    String hql0 = "from SYclGuigexinghaosEntity where 1 = 1 AND sELECTKEY = ? ";
	    List<SYclGuigexinghaosEntity> sYclGuigexinghaosOldList = this.findHql(hql0,sELECTKEY0);
		this.deleteAllEntitie(sYclGuigexinghaosOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(SYclGuigexinghaomEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(SYclGuigexinghaomEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(SYclGuigexinghaomEntity t){
	 	return true;
 	}
 	
 	public List<SYclGuigexinghaosEntity> getXinghaoBySql(String name){
		String queryString ="select * from s_ycl_guigexinghaos where 1=1";
		if (StringUtil.isNotEmpty(name) ) {
			queryString+=" and selectkey = '"+name+ "'";
		}
		//System.out.println(queryString);
		List<SYclGuigexinghaosEntity> bhzlist=jdbcDao.find(queryString, SYclGuigexinghaosEntity.class, new HashMap<String, String>());
		return bhzlist;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,SYclGuigexinghaomEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
 		sql  = sql.replace("#{selectkey}",String.valueOf(t.getSelectkey()));
 		sql  = sql.replace("#{selectvalue}",String.valueOf(t.getSelectvalue()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}