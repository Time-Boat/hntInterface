package com.shtoone.qms.service.bhz;

import org.jeecgframework.core.common.service.CommonService;

import com.shtoone.qms.entity.bhz.ClksmscfgEntity;

public interface ClksmscfgServiceI extends CommonService{
	public ClksmscfgEntity findByshebeibianhao(String shebeibianhao);
	public ClksmscfgEntity getClksmscfg(String shebeibianhao);
}
