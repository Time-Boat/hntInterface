package com.shtoone.qms.service.bhz;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import com.shtoone.qms.entity.bhz.HntviewEntity;

public interface HntsclhsServiceI extends CommonService{	
	//public void getDatagrid1(HntsclhsEntity pageObj, DataGrid dataGrid);
	//public void getDatagrid2(HntsclhsEntity pageObj, DataGrid dataGrid);
	public JSONObject getDatagrid3(HntviewEntity pageObj, DataGrid dataGrid,String ctBegin,String ctEnd,
			Integer userlft,Integer userrgt,String shebeibianhao);

}
