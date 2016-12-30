package org.jeecgframework.web.system.service.impl;

import java.util.List;

import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.UserService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author  张代浩
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl extends CommonServiceImpl implements UserService {

	public TSUser checkUserExits(TSUser user){
		return this.commonDao.getUserByUserIdAndUserNameExits(user);
	}
	
	public TSUser getUserByid(String userid){
		return this.commonDao.getUserByUserId(userid);
	}
	
	public TSUser getUserByMobilePhone(String mobilePhone){
		return this.commonDao.getUserByMobilePhone(mobilePhone);
	}
	
	public String getUserRole(TSUser user){
		return this.commonDao.getUserRole(user);
	}
	
	public void pwdInit(TSUser user,String newPwd) {
			this.commonDao.pwdInit(user,newPwd);
	}
	
	public int getUsersOfThisRole(String id) {
		Criteria criteria = getSession().createCriteria(TSRoleUser.class);
		criteria.add(Restrictions.eq("TSRole.id", id));
		int allCounts = ((Long) criteria.setProjection(
				Projections.rowCount()).uniqueResult()).intValue();
		return allCounts;
	}
	public void addDepart(TSDepart depart, String pid) {
		if (StringUtil.isNotEmpty(pid))
		{
			TSDepart tspdepart = get(TSDepart.class, pid);
			int lft = tspdepart.getLft();
			depart.setLft(lft+1);
			depart.setRgt(lft+2);
			executeSql("update t_s_depart set rgt = rgt + 2 where rgt>?", lft);
			executeSql("update t_s_depart set lft = lft + 2 where lft>?", lft);
		}
		save(depart);		
	}
	
	public void changePDepart(TSDepart depart, String pid) {
		long reccount = 1;
		if (StringUtil.isNotEmpty(pid)) {
		   reccount = getCountForJdbcParam("select count(ID) from t_s_depart where ID=? and parentdepartid=?", new Object[]{depart.getId(),pid});
		}
		saveOrUpdate(depart);
		if (reccount==0) {
			int lft = depart.getLft();
			int rgt = depart.getRgt();
			int mywidth = rgt-lft+1;
			//原子节点挂靠父节点
			//userService.executeSql("update t_s_depart set rgt = rgt - 1, lft = lft - 1 where ID<>? and (lft between ? and ?)",depart.getId(), lft, rgt);
			//要移动的节点及子节点临时编号
			executeSql("update t_s_depart set rgt = rgt - 100000, lft= lft - 100000 where lft between ? and ?", lft, rgt);
			//移除节点及子节点
			executeSql("update t_s_depart set rgt = rgt - "+mywidth+" where rgt>?", rgt);
			executeSql("update t_s_depart set lft = lft - "+mywidth+" where lft>?", rgt);
			
			TSDepart tspdepart = get(TSDepart.class, pid);
			int newlft = tspdepart.getLft();
			int newwidth = newlft - lft + 1;
			//在新的父节点处增加节点及子节点
			executeSql("update t_s_depart set rgt = rgt + "+mywidth+" where rgt>?", newlft);
			executeSql("update t_s_depart set lft = lft + "+mywidth+" where lft>?", newlft);
			executeSql("update t_s_depart set rgt=rgt+100000+"+newwidth+", lft=lft+100000+"+newwidth+" where lft between ? and ?", lft-100000, rgt-100000);
		}
	}
	
	public void delDepart(String cid) {
		TSDepart depart = getEntity(TSDepart.class, cid);
		// 删除部门之前更新与之相关的实体
		upEntity(cid);
		int lft = depart.getLft();
		int rgt = depart.getRgt();
		int mywidth = rgt-lft+1;
		delete(depart);
		executeSql("update t_s_depart set rgt = rgt -"+mywidth+" where rgt>?", rgt);
		executeSql("update t_s_depart set lft = lft -"+mywidth+" where lft>?", rgt);		
	}
	
	public void upEntity(String cid) {
		List<TSUser> users = findByProperty(TSUser.class, "TSDepart.id", cid);
		if (users.size() > 0) {
			for (TSUser tsUser : users) {
				//tsUser.setTSDepart(null);
				//systemService.saveOrUpdate(tsUser);
				delete(tsUser);
			}
		}
	}
	
}
