package com.shtoone.qms.service.bhz;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import com.shtoone.qms.entity.bhz.V_WangnjEntity;

public interface V_WangnjServiceI extends CommonService{
	public JSONObject getDatagrid3(V_WangnjEntity v_Wangnj, 
			DataGrid dataGrid,String startTime,String endTime,
			String shebeibianhao,String testname,
			String pzbm,String gcmc,String sgbw,String sjbh, 
			String pdjg,String userlft,String userrgt);
}
