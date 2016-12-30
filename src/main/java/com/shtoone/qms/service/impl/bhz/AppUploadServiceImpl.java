package com.shtoone.qms.service.impl.bhz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.service.bhz.AppUploadServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("appUploadService")
@Transactional
public class AppUploadServiceImpl extends CommonServiceImpl implements AppUploadServiceI {
	
}