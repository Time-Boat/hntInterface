package com.shtoone.qms.service.bhz;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.shtoone.qms.entity.bhz.V_ShebeiInfoEntity;

public interface V_ShebeiInfoServiceI extends CommonService{
	public List<V_ShebeiInfoEntity> getShebeiBySql(String bhjtype,String userlft, String userrgt);
}
