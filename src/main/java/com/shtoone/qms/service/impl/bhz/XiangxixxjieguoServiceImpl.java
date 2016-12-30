package com.shtoone.qms.service.impl.bhz;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.entity.bhz.XiangxixxjieguoEntity;
import com.shtoone.qms.service.bhz.XiangxixxjieguoServiceI;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("xiangxixxjieguoService")
@Transactional
public class XiangxixxjieguoServiceImpl extends CommonServiceImpl implements XiangxixxjieguoServiceI {
	
	@Autowired
	private JdbcDao jdbcDao;
	
	//根据基础信息编号获取超标结果对象
	public XiangxixxjieguoEntity findByxinxibianhao(Integer xinxibianhao) {
		String queryString = "select model.* from Xiangxixxjieguo as model where model.xinxibianhao="+xinxibianhao;
		List<XiangxixxjieguoEntity> hlist =jdbcDao.find(queryString, XiangxixxjieguoEntity.class, new HashMap<String, String>());
		if (hlist.size()>0) {
			return hlist.get(0);
		} else {
			return null;
		}	
	}
	
}