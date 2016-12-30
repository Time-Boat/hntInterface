package com.shtoone.qms.service.bhz;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.entity.bhz.HunnintuView;

public interface HntbhzziduancfgViewServiceI extends CommonService{
	public JSONObject getDatagrid3(HunnintuView hunnintuView, DataGrid dataGrid,String startTime
			,String endTime,Integer userlft,Integer userrgt,String jiaozuobuwei,
			String gongchengmingcheng,String shebeibianhao);	
	public String getHntAnalysisColumnXml(JSONObject jObject,DataGrid dataGrid,HntbhzziduancfgViewEntity hbfield,HntbhzziduancfgViewEntity hntbhzisShow);
	
	public HntbhzziduancfgViewEntity gethntcfgfield(String shebeibianhao);
	public HntbhzziduancfgViewEntity gethntbhzisShow(String shebeibianhao);
	
	//材料误差分析图例中复选按钮是否显示与不显示
	public HntbhzziduancfgViewEntity gethntcfgisShow20(String shebeibianhao);
}
