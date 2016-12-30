package com.shtoone.qms.app.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.app.service.SmsinfoInterfaceService;

@Service("smsinfoInterfaceService")
@Transactional
public class SmsinfoInterfaceServiceImpl extends CommonServiceImpl implements SmsinfoInterfaceService{

}
