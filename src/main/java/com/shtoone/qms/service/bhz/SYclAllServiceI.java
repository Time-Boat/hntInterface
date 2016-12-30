package com.shtoone.qms.service.bhz;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import com.shtoone.qms.entity.bhz.BhgsYclAllviewEntity;
import com.shtoone.qms.entity.bhz.SYclAllzhviewEntity;
import com.shtoone.qms.entity.bhz.SYclAllEntity;

import java.io.Serializable;
import java.util.List;

public interface SYclAllServiceI extends CommonService{
	
 	public <T> void delete(T entity);
 	
 	public <T> Serializable save(T entity);
 	
 	public <T> void saveOrUpdate(T entity);
 	
 	public  List<SYclAllEntity> getDatagrid3(SYclAllzhviewEntity pageObj, DataGrid dataGrid, String biaodanid,String leixing,String guige,String xinghao,String chandi,String scchangjia);
 	
 	public  List<SYclAllEntity> getDatagrid4(BhgsYclAllviewEntity pageObj, DataGrid dataGrid, String biaodanid,String leixing,String guige,String xinghao,String chandi,String scchangjia);
 	
 	public JSONObject getDatagrid5(SYclAllEntity syclview, DataGrid dataGrid,String jcbianhao,String mingcheng,String startTime,String endTime,String daijian,String leixing,String guige,Integer lft,Integer rgt);
 	
 	
 	public List getDatagrid6(DataGrid dataGrid,Integer lft,Integer rgt);
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(SYclAllEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(SYclAllEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(SYclAllEntity t);
}
