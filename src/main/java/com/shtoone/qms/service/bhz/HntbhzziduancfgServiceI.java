package com.shtoone.qms.service.bhz;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgEntity;


public interface HntbhzziduancfgServiceI extends CommonService{

	public JSONObject getDatagrid3(HntbhzziduancfgViewEntity pageObj, DataGrid dataGrid,
			String departid,String shebeibianhao, String userlft, String userrgt);

	//材料误差查询中的配置文件
	public HntbhzziduancfgEntity gethntcfg20(String shebeibianhao);

}
