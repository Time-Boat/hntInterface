package com.shtoone.qms.service.bhz;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import com.shtoone.qms.entity.bhz.HntviewEntity;

public interface CbtongjiServiceI extends CommonService{	

	public JSONObject getDatagrid3(HntviewEntity pageObj, DataGrid dataGrid,String startTime
			,String endTime,Integer fzlx,String userlft,String userrgt,String shebeibianhao);

}
