package org.jeecgframework.web.system.service;

import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;
/**
 * 
 * @author  张代浩
 *
 */
public interface UserService extends CommonService{

	public TSUser checkUserExits(TSUser user);
	public TSUser getUserByid(String userid);
	public String getUserRole(TSUser user);
	public void pwdInit(TSUser user, String newPwd);
	/**
	 * 判断这个角色是不是还有用户使用
	 *@Author JueYue
	 *@date   2013-11-12
	 *@param id
	 *@return
	 */
	public int getUsersOfThisRole(String id);
	/**
	 * 增加部门
	 */
	public void addDepart(TSDepart depart, String pid);
	/**
	 * 更新部门并支持更换上级部门
	 */
	public void changePDepart(TSDepart depart, String pid);
	/**
	 * 删除部门
	 */
	public void delDepart(String cid);
	
	//app新增方法+++
	//根据手机号获取用户
	public TSUser getUserByMobilePhone(String userName);
}
