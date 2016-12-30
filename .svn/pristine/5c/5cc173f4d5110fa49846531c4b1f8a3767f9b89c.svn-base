package com.shtoone.qms.service.bhz;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.CommonService;

import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.entity.bhz.HunnintuView;

import net.sf.json.JSONObject;

public interface HntwuchaAnalyseServiceI extends CommonService{
	public JSONObject HntwuchaAnalyseDataGrid(HunnintuView hntView, DataGrid dataGrid,String startTime,
			String endTime,String gongchengmingcheng,String jiaozuobuwei,Integer lft,Integer rgt);
	
	//绘制材料用量走势图
	public String HntUserImage(JSONObject jObject,HntbhzziduancfgViewEntity hntbhzField,HntbhzziduancfgViewEntity hntbhzisShow);
	
	//绘制材料误差走势图
	public String HntWuchaImage(JSONObject jObject,HntbhzziduancfgViewEntity hntbhzField,HntbhzziduancfgViewEntity hntbhzisShow);
	
	//将JOSN组合成Datagrid
	public DataGridReturn zhuheDataGrid(final JSONObject jObject,final boolean isOffset);
}
