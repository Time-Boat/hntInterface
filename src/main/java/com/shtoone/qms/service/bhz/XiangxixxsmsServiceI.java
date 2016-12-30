package com.shtoone.qms.service.bhz;

import org.jeecgframework.core.common.service.CommonService;

import com.shtoone.qms.entity.bhz.XiangxixxsmsEntity;

public interface XiangxixxsmsServiceI extends CommonService{
	public XiangxixxsmsEntity getXxsmsbybh(String shebeibianhao);
}
