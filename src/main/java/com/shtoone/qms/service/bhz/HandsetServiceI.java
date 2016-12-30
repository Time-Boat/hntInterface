package com.shtoone.qms.service.bhz;

import net.sf.json.JSONObject;

import java.util.List;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import com.shtoone.qms.app.entity.AppInterfaceHandSetBean;
import com.shtoone.qms.entity.bhz.HandsetEntity;

public interface HandsetServiceI extends CommonService{
	public JSONObject getDatagrid3(HandsetEntity pageObj, DataGrid dataGrid,
			String departid, String userlft, String userrgt);
	
	
	
	//app新增方法+++
	/**
	 * 获取指定号码所属的号码群组名称
	 * @param phone
	 * @return
	 */
	public List<AppInterfaceHandSetBean> getHandSet(String phone);
	
}
