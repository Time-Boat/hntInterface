package com.shtoone.qms.service.bhz;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import com.shtoone.qms.entity.bhz.HunnintujieguoViewEntity;

public interface HunnintujieguoViewServiceI extends CommonService{
	public JSONObject getDatagrid3(HunnintujieguoViewEntity pageObj, DataGrid dataGrid,
			String departid,String startTime,String endTime,String leixing,String chulijieguoType,
			String gongchengmingcheng,String jiaozuobuwei,String shebeibianhao, String xinxibianhao,String userlft, String userrgt);
}
