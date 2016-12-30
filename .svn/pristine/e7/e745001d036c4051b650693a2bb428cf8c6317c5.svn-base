package com.shtoone.qms.service.impl.bhz;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.XiangxixxsmsEntity;
import com.shtoone.qms.service.bhz.XiangxixxsmsServiceI;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("xiangxixxsmsService")
@Transactional
public class XiangxixxsmsServiceImpl extends CommonServiceImpl implements XiangxixxsmsServiceI {
	
	@Autowired
	private JdbcDao jdbcDao;
	
	public XiangxixxsmsEntity getXxsmsbybh(String shebeibianhao){
		String queryString = "select model.* from Xiangxixxsms as model where model.shebeibianhao='"+shebeibianhao+"'";
		List<XiangxixxsmsEntity> hlist = jdbcDao.find(queryString, XiangxixxsmsEntity.class, new HashMap<String, String>());
		if(hlist.size()>0){
			return (XiangxixxsmsEntity)hlist.get(0);
		}else{
			return null;
		}
	}
}