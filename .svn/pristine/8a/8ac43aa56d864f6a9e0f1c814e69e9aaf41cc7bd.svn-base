package com.shtoone.qms.service.bhz;


import java.util.List;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import com.shtoone.qms.entity.bhz.Lilunpeibixixx;

import net.sf.json.JSONObject;


public interface LilunpeibixixxService extends CommonService{
	//加权限查询数据
	public JSONObject getLilunBySql(Lilunpeibixixx lilun, DataGrid dataGrid,String userlft,String userrgt,String startTime,String endTime);
	//通过SQL语句得到当前登录用户中存在理论配比
	public List<Lilunpeibixixx> getLilunpeibiBySQL(String userlft,String userrgt);
	//哈哈哈，我只是尝试两种方式写，和第二行的效果是一样的呀。傻了吧
	public List<Lilunpeibixixx> getLilunpeibiByDepartBySQL(String departId,String userlft, String userrgt);
}
