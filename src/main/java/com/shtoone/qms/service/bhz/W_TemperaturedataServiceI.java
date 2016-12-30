package com.shtoone.qms.service.bhz;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import net.sf.json.JSONObject;

public interface W_TemperaturedataServiceI extends CommonService{

	JSONObject getDatagrid3(DataGrid dataGrid, String startTime, String endTime, String userlft, String userrgt,
			String shebeibianhao);

	String getbaobiaoxml(JSONObject jObject);

	JSONObject getDatagrid3(String startTime, String endTime, String userlft, String userrgt, String shebeibianhao);

}
