package com.shtoone.qms.service.bhz;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.shtoone.qms.entity.bhz.BanhezhanxinxiEntity;
import com.shtoone.qms.entity.bhz.SYclGuigexinghaomEntity;

import java.io.Serializable;

import com.shtoone.qms.entity.bhz.SYclGuigexinghaosEntity;

public interface SYclGuigexinghaomServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(SYclGuigexinghaomEntity sYclGuigexinghaom,
	        List<SYclGuigexinghaosEntity> sYclGuigexinghaosList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(SYclGuigexinghaomEntity sYclGuigexinghaom,
	        List<SYclGuigexinghaosEntity> sYclGuigexinghaosList);
	public void delMain (SYclGuigexinghaomEntity sYclGuigexinghaom);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(SYclGuigexinghaomEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(SYclGuigexinghaomEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(SYclGuigexinghaomEntity t);
 	
 	public List<SYclGuigexinghaosEntity> getXinghaoBySql(String name);
}
