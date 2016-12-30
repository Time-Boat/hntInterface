package com.shtoone.qms.service.bhz;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import com.shtoone.qms.entity.bhz.TesterInfoViewEntity;


public interface TesterInfoServiceI extends CommonService{
	public JSONObject getDatagrid(TesterInfoViewEntity syclview, DataGrid dataGrid,Integer lft,Integer rgt,String name);
}
