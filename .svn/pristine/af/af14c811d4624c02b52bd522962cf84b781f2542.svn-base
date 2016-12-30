package com.shtoone.qms.service.impl.bhz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.service.bhz.SmsrecordServiceI;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.shtoone.qms.entity.ShebeiInfoEntity;
import com.shtoone.qms.entity.bhz.SYclGuigexinghaosEntity;
import com.shtoone.qms.entity.bhz.SmsrecordEntity;

@Service("smsrecordService")
@Transactional
public class SmsrecordServiceImpl extends CommonServiceImpl implements SmsrecordServiceI {
	public List<SmsrecordEntity> getalarmrecordList() {
		String queryString = "from SmsrecordEntity as model where model.isalarm=1 and model.completealarm=0";
		List<SmsrecordEntity> SmsrecordEntityList = this.findHql(queryString);
		return SmsrecordEntityList;
	}
	
	public SmsrecordEntity getSmsrecordByDepartid(String departid) {
		List<SmsrecordEntity> recordlist = new ArrayList<SmsrecordEntity>();
		recordlist = this.findByProperty(SmsrecordEntity.class, "departid", departid);
		if (recordlist.size() > 0) {
			return recordlist.get(0);
		} else {
			return null;
		}
	}
}