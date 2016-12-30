package com.shtoone.qms.service.impl.bhz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.V_ShebeiInfoEntity;
import com.shtoone.qms.entity.bhz.V_ShiyanshiInfoEntity;
import com.shtoone.qms.service.bhz.V_ShebeiInfoServiceI;

import java.util.HashMap;
import java.util.List;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;

@Service("v_ShebeiInfoService")
@Transactional
public class V_ShebeiInfoServiceImpl extends CommonServiceImpl implements V_ShebeiInfoServiceI {
	
	@Autowired
	private JdbcDao jdbcDao;
	
	public List<V_ShebeiInfoEntity> getShebeiBySql(String shebeitype,String userlft, String userrgt){
		String queryString ="select * from V_ShebeiInfo where 1=1";
		if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
			queryString+=" and lft >= '"+userlft+"' and rgt <= '" + userrgt + "'";
		}
		if(StringUtil.isNotEmpty(shebeitype)){
			queryString+=" and leixin="+shebeitype;
		}
		return jdbcDao.find(queryString, V_ShebeiInfoEntity.class, new HashMap<String, String>());
	}
}