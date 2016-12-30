package com.shtoone.qms.service.impl.bhz;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.ClksmscfgEntity;
import com.shtoone.qms.service.bhz.ClksmscfgServiceI;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("clksmscfgService")
@Transactional
public class ClksmscfgServiceImpl extends CommonServiceImpl implements ClksmscfgServiceI {
	@Autowired
	private JdbcDao jdbcDao;
	
	public ClksmscfgEntity findByshebeibianhao(String shebeibianhao) {
		String queryString = "select model.* from Clksmscfg as model where model.shebeibianhao='"+shebeibianhao+"'";
		List<ClksmscfgEntity> hlist =jdbcDao.find(queryString, ClksmscfgEntity.class, new HashMap<String, String>());
		//System.out.println(queryString);
		if (hlist.size()>0) {
			return hlist.get(0);
		} else {
			return null;
		}	
	}
	//出料口字段配置
			public ClksmscfgEntity getClksmscfg(String shebeibianhao) {
				ClksmscfgEntity xcsms = findByshebeibianhao(shebeibianhao);		
				if (null == xcsms) {
					xcsms = new ClksmscfgEntity();
					xcsms.setShebeibianhao(shebeibianhao);
					xcsms.setTmplow("100");
					xcsms.setTmphigh("100");
					xcsms.setTmplow1("100");
					xcsms.setTmphigh1("100");
					xcsms.setTmplow2("110");
					xcsms.setTmphigh2("180");
					xcsms.setSmsbaojin("1");
					
				}
				return xcsms;
			}
}