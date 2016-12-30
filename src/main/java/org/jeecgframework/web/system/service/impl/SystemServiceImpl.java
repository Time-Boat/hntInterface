package org.jeecgframework.web.system.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSFunction;
import org.jeecgframework.web.system.pojo.base.TSIcon;
import org.jeecgframework.web.system.pojo.base.TSLog;
import org.jeecgframework.web.system.pojo.base.TSRole;
import org.jeecgframework.web.system.pojo.base.TSRoleFunction;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSType;
import org.jeecgframework.web.system.pojo.base.TSTypegroup;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.core.util.ContextHolderUtils;
import org.jeecgframework.core.util.DataUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shtoone.qms.app.entity.Departxinxi;
import com.shtoone.qms.entity.bhz.BanhezhanxinxiEntity;
import com.shtoone.qms.entity.bhz.SmsinfohntEntity;
import com.shtoone.qms.entity.bhz.SmsrecordEntity;
import com.shtoone.qms.service.bhz.SmsinfohntServiceI;
import com.shtoone.qms.service.bhz.SmsrecordServiceI;
import com.shtoone.qms.util.Smssender;


import java.util.Hashtable;

@Service("systemService")
@Transactional
public class SystemServiceImpl extends CommonServiceImpl implements SystemService {
	static Log logger = LogFactory.getLog(Smssender.class);
	
	
	@Autowired
	private SmsrecordServiceI smshntService;
	
	@Autowired
	private SmsinfohntServiceI smsinfohntService;
	
	 
	public TSUser checkUserExits(TSUser user) throws Exception {
		return this.commonDao.getUserByUserIdAndUserNameExits(user);
	}

	/**
	 * 添加日志
	 */
	public void addLog(String logcontent, Short loglevel, Short operatetype) {
		HttpServletRequest request = ContextHolderUtils.getRequest();
		String broswer = BrowserUtils.checkBrowse(request);
		TSLog log = new TSLog();
		log.setLogcontent(logcontent);
		log.setLoglevel(loglevel);
		log.setOperatetype(operatetype);
		log.setNote(oConvertUtils.getIpAddrByRequest(request));
		log.setBroswer(broswer);
		log.setOperatetime(DataUtils.gettimestamp());
		log.setTSUser(ResourceUtil.getSessionUserName());
		commonDao.save(log);
	}

	/**
	 * 根据类型编码和类型名称获取Type,如果为空则创建一个
	 * 
	 * @param typecode
	 * @param typename
	 * @return
	 */
	public TSType getType(String typecode, String typename, TSTypegroup tsTypegroup) {
		TSType actType = commonDao.findUniqueByProperty(TSType.class, "typecode", typecode);
		if (actType == null) {
			actType = new TSType();
			actType.setTypecode(typecode);
			actType.setTypename(typename);
			actType.setTSTypegroup(tsTypegroup);
			commonDao.save(actType);
		}
		return actType;

	}

	/**
	 * 根据类型分组编码和名称获取TypeGroup,如果为空则创建一个
	 * 
	 * @param typecode
	 * @param typename
	 * @return
	 */
	public TSTypegroup getTypeGroup(String typegroupcode, String typgroupename) {
		TSTypegroup tsTypegroup = commonDao.findUniqueByProperty(TSTypegroup.class, "typegroupcode", typegroupcode);
		if (tsTypegroup == null) {
			tsTypegroup = new TSTypegroup();
			tsTypegroup.setTypegroupcode(typegroupcode);
			tsTypegroup.setTypegroupname(typgroupename);
			commonDao.save(tsTypegroup);
		}
		return tsTypegroup;
	}

	
	public TSTypegroup getTypeGroupByCode(String typegroupCode) {
		TSTypegroup tsTypegroup = commonDao.findUniqueByProperty(TSTypegroup.class, "typegroupcode", typegroupCode);
		return tsTypegroup;
	}

	
	public void initAllTypeGroups() {
		List<TSTypegroup> typeGroups = this.commonDao.loadAll(TSTypegroup.class);
		for (TSTypegroup tsTypegroup : typeGroups) {
			TSTypegroup.allTypeGroups.put(tsTypegroup.getTypegroupcode().toLowerCase(), tsTypegroup);
			List<TSType> types = this.commonDao.findByProperty(TSType.class, "TSTypegroup.id", tsTypegroup.getId());
			TSTypegroup.allTypes.put(tsTypegroup.getTypegroupcode().toLowerCase(), types);
		}
	}

	
	public void refleshTypesCach(TSType type) {
		TSTypegroup tsTypegroup = type.getTSTypegroup();
		TSTypegroup typeGroupEntity = this.commonDao.get(TSTypegroup.class, tsTypegroup.getId());
		List<TSType> types = this.commonDao.findByProperty(TSType.class, "TSTypegroup.id", tsTypegroup.getId());
		TSTypegroup.allTypes.put(typeGroupEntity.getTypegroupcode().toLowerCase(), types);
	}

	
	public void refleshTypeGroupCach() {
		TSTypegroup.allTypeGroups.clear();
		List<TSTypegroup> typeGroups = this.commonDao.loadAll(TSTypegroup.class);
		for (TSTypegroup tsTypegroup : typeGroups) {
			TSTypegroup.allTypeGroups.put(tsTypegroup.getTypegroupcode().toLowerCase(), tsTypegroup);
		}
	}

	// ----------------------------------------------------------------
	// ----------------------------------------------------------------

	
	public Set<String> getOperationCodesByRoleIdAndFunctionId(String roleId, String functionId) {
		Set<String> operationCodes = new HashSet<String>();
		TSRole role = commonDao.get(TSRole.class, roleId);
		CriteriaQuery cq1 = new CriteriaQuery(TSRoleFunction.class);
		cq1.eq("TSRole.id", role.getId());
		cq1.eq("TSFunction.id", functionId);
		cq1.add();
		List<TSRoleFunction> rFunctions = getListByCriteriaQuery(cq1, false);
		if (null != rFunctions && rFunctions.size() > 0) {
			TSRoleFunction tsRoleFunction = rFunctions.get(0);
			if (null != tsRoleFunction.getOperation()) {
				String[] operationArry = tsRoleFunction.getOperation().split(",");
				for (int i = 0; i < operationArry.length; i++) {
					operationCodes.add(operationArry[i]);
				}
			}
		}
		return operationCodes;
	}

	
	public Set<String> getOperationCodesByUserIdAndFunctionId(String userId, String functionId) {
		Set<String> operationCodes = new HashSet<String>();
		List<TSRoleUser> rUsers = findByProperty(TSRoleUser.class, "TSUser.id", userId);
		for (TSRoleUser ru : rUsers) {
			TSRole role = ru.getTSRole();
			CriteriaQuery cq1 = new CriteriaQuery(TSRoleFunction.class);
			cq1.eq("TSRole.id", role.getId());
			cq1.eq("TSFunction.id", functionId);
			cq1.add();
			List<TSRoleFunction> rFunctions = getListByCriteriaQuery(cq1, false);
			if (null != rFunctions && rFunctions.size() > 0) {
				TSRoleFunction tsRoleFunction = rFunctions.get(0);
				if (null != tsRoleFunction.getOperation()) {
					String[] operationArry = tsRoleFunction.getOperation().split(",");
					for (int i = 0; i < operationArry.length; i++) {
						operationCodes.add(operationArry[i]);
					}
				}
			}
		}
		return operationCodes;
	}

	// ----------------------------------------------------------------
	// ----------------------------------------------------------------
	
	public void flushRoleFunciton(String id, TSFunction newFunction) {
		TSFunction functionEntity = this.getEntity(TSFunction.class, id);
		if (functionEntity.getTSIcon() == null || !StringUtil.isNotEmpty(functionEntity.getTSIcon().getId())) {
			return;
		}
		TSIcon oldIcon = this.getEntity(TSIcon.class, functionEntity.getTSIcon().getId());
		if (!oldIcon.getIconClas().equals(newFunction.getTSIcon().getIconClas())) {
			// 刷新缓存
			HttpSession session = ContextHolderUtils.getSession();
			TSUser user = ResourceUtil.getSessionUserName();
			List<TSRoleUser> rUsers = this.findByProperty(TSRoleUser.class, "TSUser.id", user.getId());
			for (TSRoleUser ru : rUsers) {
				TSRole role = ru.getTSRole();
				session.removeAttribute(role.getId());
			}
		}
	}

	
	
	public Hashtable saveandSendSms(int xxbh, String shebeibianhao, String phonenumber, String realphonename,String chuliaoshijian,String sms, String apitype) {		
		Hashtable recTable = null;
		if (StringUtil.Null2Blank(shebeibianhao).length()>0 && shebeibianhao.equalsIgnoreCase("test")) {
			logger.info(shebeibianhao+"发送短信("+phonenumber+"):"+sms);
			recTable = Smssender.SendSms(phonenumber, sms, apitype);			
		} else {
			String queryString = "from BanhezhanxinxiEntity as model where model.gprsbianhao=?";
			List<BanhezhanxinxiEntity> bhzlist = this.findHql(queryString, shebeibianhao);
			if (bhzlist.size() > 0) {
				BanhezhanxinxiEntity bhz = bhzlist.get(0);
				if (StringUtil.Null2Blank(bhz.getDepartid()).length() > 0) {
					SmsrecordEntity smsrecord = smshntService.getSmsrecordByDepartid(bhz.getDepartid());
					if (null != smsrecord && null != smsrecord.getSmscount() && smsrecord.getSmscount() > 0) {
						if (null == smsrecord.getTotalcount()) {
							smsrecord.setTotalcount(0);
						}
						if (null == smsrecord.getSuccesscount()) {
							smsrecord.setSuccesscount(0);
						}
						if (null == smsrecord.getFailcount()) {
							smsrecord.setFailcount(0);
						}
						logger.info(shebeibianhao+"发送短信("+phonenumber+"):"+sms);
						recTable = Smssender.SendSms(phonenumber, sms, apitype);
						if (null != recTable) {
							SmsinfohntEntity smsinfo = new SmsinfohntEntity();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String fsTime = sdf.format(System.currentTimeMillis());
							smsinfo.setXxbianhao(xxbh);
							smsinfo.setShijian(fsTime);
							smsinfo.setShebeibianhao(shebeibianhao);
							smsinfo.setFasongphone(phonenumber);
							smsinfo.setFasongcount(phonenumber.split(",").length);
							//在用户保存时，如果是阿里大鱼的短信内容，则解析JSON
							if (!StringUtil.Null2Blank(apitype).equalsIgnoreCase("97") && !StringUtil.Null2Blank(apitype).equalsIgnoreCase("123") && !StringUtil.Null2Blank(apitype).equalsIgnoreCase("100")) {
								JSONObject obj = JSON.parseObject(sms);				
								if (obj != null && StringUtil.isNotEmpty(obj.getString("neirong"))) {
									JSONObject obj1 = JSON.parseObject(obj.getString("neirong"));		
									if (obj1 != null) {
										smsinfo.setFasongcontent(String.format("%s站:%s|部:%s|料:%s实%s配%s误%s%%超%s%%", obj1.getString("shijian"), obj1.getString("name"),  obj1.getString("buwei"), obj1.getString("fieldname"),  obj1.getString("shiji"), obj1.getString("lilun"), obj1.getString("wucha"),  obj1.getString("bz")));
									}					
								}
							} else {
							   smsinfo.setFasongcontent(sms);
							}
							smsinfo.setFasongstatus((String)recTable.get("smsstatus"));
							smsinfo.setReturnmsg((String)recTable.get("mymsg"));
							smsinfo.setYonghumingchen(realphonename);
					    	smsinfo.setChuliaoshijian(chuliaoshijian);
							String successphone = StringUtil.Null2Blank((String)recTable.get("successphone"));
							if (successphone.length() > 0) {
								smsinfo.setSuccessphone(successphone);
								smsinfo.setSuccesscount(successphone.split(",").length);
								smsrecord.setSmscount(smsrecord.getSmscount() - smsinfo.getSuccesscount());
								smsrecord.setTotalcount(smsrecord.getTotalcount() + smsinfo.getFasongcount());
								smsrecord.setSuccesscount(smsrecord.getSuccesscount() + smsinfo.getSuccesscount());
								smsrecord.setFailcount(smsrecord.getFailcount() + smsinfo.getFasongcount() - smsinfo.getSuccesscount());
							} else {
								logger.info("短信账号异常，发送失败");
								smsrecord.setTotalcount(smsrecord.getTotalcount() + smsinfo.getFasongcount());
								smsrecord.setFailcount(smsrecord.getFailcount() + smsinfo.getFasongcount());
							}
							smshntService.saveOrUpdate(smsrecord);
							smsinfohntService.saveOrUpdate(smsinfo);
						}
						
					} else {
						logger.info("标段"+bhz.getDepartid()+bhz.getBanhezhanminchen()+bhz.getGprsbianhao()+"短信余额不足");
					}
				} else {
					logger.info("设备"+shebeibianhao+"未指定标段");
				}
			} else {
				logger.info("设备"+shebeibianhao+"未指定标段");
			}
		}
		
		return recTable;
	}

	
/*	public Hashtable lqsaveandSendSms(int xxbh, String shebeibianhao, String phonenumber, String realphonename,String chuliaoshijian,String sms, String apitype) {		
		Hashtable recTable = null;
		if (StringUtil.Null2Blank(shebeibianhao).length()>0 && shebeibianhao.equalsIgnoreCase("test")) {
			logger.info(shebeibianhao+"发送短信("+phonenumber+"):"+sms);
			recTable = Smssender.SendSms(phonenumber, sms, apitype);			
		} else {
			String queryString = "from LqBanhezhanxinxiEntity as model where model.gprsbianhao=?";
			List<LqBanhezhanxinxiEntity> bhzlist = this.findHql(queryString, shebeibianhao);
			if (bhzlist.size() > 0) {
				LqBanhezhanxinxiEntity bhz = bhzlist.get(0);
				//if (null != bhz.getBiaoduanid() && bhz.getBiaoduanid() > 0) {
					SmsrecordEntity smsrecord = smshntService.getSmsrecordByDepartid(bhz.getDepartid());
					if (null != smsrecord && null != smsrecord.getSmscount() && smsrecord.getSmscount() > 0) {
						if (null == smsrecord.getTotalcount()) {
							smsrecord.setTotalcount(0);
						}
						if (null == smsrecord.getSuccesscount()) {
							smsrecord.setSuccesscount(0);
						}
						if (null == smsrecord.getFailcount()) {
							smsrecord.setFailcount(0);
						}
						logger.info(shebeibianhao+"发送短信("+phonenumber+"):"+sms);
						recTable = Smssender.SendSms(phonenumber, sms, apitype);
						if (null != recTable) {
							
							SmsinfolqEntity smsinfo = new SmsinfolqEntity();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String fsTime = sdf.format(System.currentTimeMillis());
							smsinfo.setXxbianhao(xxbh);
							smsinfo.setShijian(fsTime);
							smsinfo.setShebeibianhao(shebeibianhao);
							smsinfo.setFasongphone(phonenumber);
							smsinfo.setFasongcount(phonenumber.split(",").length);
							smsinfo.setFasongcontent(sms);
							smsinfo.setFasongstatus((String)recTable.get("smsstatus"));
							smsinfo.setReturnmsg((String)recTable.get("mymsg"));
							smsinfo.setYonghumingchen(realphonename);
							smsinfo.setChuliaoshijian(chuliaoshijian);
							String successphone = StringUtil.Null2Blank((String)recTable.get("successphone"));
							if (successphone.length() > 0) {
								smsinfo.setSuccessphone(successphone);
								smsinfo.setSuccesscount(successphone.split(",").length);
								smsrecord.setSmscount(smsrecord.getSmscount() - smsinfo.getSuccesscount());
								smsrecord.setTotalcount(smsrecord.getTotalcount() + smsinfo.getFasongcount());
								smsrecord.setSuccesscount(smsrecord.getSuccesscount() + smsinfo.getSuccesscount());
								smsrecord.setFailcount(smsrecord.getFailcount() + smsinfo.getFasongcount() - smsinfo.getSuccesscount());
							} else {
								logger.info("短信账号异常，发送失败");
								smsrecord.setTotalcount(smsrecord.getTotalcount() + smsinfo.getFasongcount());
								smsrecord.setFailcount(smsrecord.getFailcount() + smsinfo.getFasongcount());
							}
							smshntService.saveOrUpdate(smsrecord);
							smsinfolqService.saveOrUpdate(smsinfo);
							
						}
						
					} else {
						logger.info(bhz.getBanhezhanminchen()+bhz.getGprsbianhao()+"短信余额不足");
					}
				//} else {
				//	logger.info("设备"+shebeibianhao+"未指定标段");
				//}
			} else {
				logger.info("设备"+shebeibianhao+"未指定标段");
			}
		}
		return recTable;
	}*/

	//app新增方法+++
	public List<Departxinxi> RecursionDepartById(List<Departxinxi> departxixxList,String departId,String type,String newdepartId,String funtype){
		List<Departxinxi> departListTemp=new ArrayList<Departxinxi>();
		CriteriaQuery cq=new CriteriaQuery(TSDepart.class);
		if(StringUtil.Null2Blank(departId).length()>0){
			cq.eq("id", departId); //这句话是通过给HQL设置Id查询数据，得到主节点
		}
		if(StringUtil.Null2Blank(type).length()>0){
			cq.eq("type", type);
		}
		if(StringUtil.Null2Blank(newdepartId).length()>0){
			cq.eq("TSPDepart.id", newdepartId); //这句话是通过给HQL设置Id查询数据，得到主节点
		}
		cq.add();       //加载条件
		List<TSDepart> departList=this.commonDao.getListByCriteriaQuery(cq, false);    //返回的是departId组织机构下的所有子机构
		for(int i=0;i<departList.size();i++){
			TSDepart depart=departList.get(i);
			Departxinxi departxinxi=new Departxinxi();
			departxinxi.setID(depart.getId());
			newdepartId=depart.getId();
			if(depart.getTSPDepart()==null || depart.getId().equalsIgnoreCase(departId)){
				departxinxi.setParentdepartid("");
			}else{
				departxinxi.setParentdepartid(depart.getTSPDepart().getId());
			}
			departxinxi.setDepartname(depart.getDepartname());
			departxinxi.setDepartorderid(StringUtil.Null2Blank(depart.getDepartorderid()));
			departxinxi.setDescription(depart.getDescription());
			departxinxi.setLat(depart.getLat());
			departxinxi.setLft(String.valueOf(depart.getLft()));
			departxinxi.setLng(String.valueOf(depart.getLng()));
			departxinxi.setRgt(String.valueOf(depart.getRgt()));
			departxinxi.setType(String.valueOf(depart.getType()));
			departListTemp.add(departxinxi);
//			String sql="select count(*) from t_s_depart where (rgt-lft)=1 and parentdepartid='"+newdepartId+"' "
//					+"having (select count(*) from t_s_depart where (rgt-lft)!=1 and parentdepartid='"+newdepartId+"')<=0";    //父节点为newdepartId并且子节点为是最下级节点的数据
			String sql="select * from t_s_depart where type!=4 and parentdepartid='"+newdepartId+"' ";    //父节点为newdepartId并且子节点为是最下级节点的数据
			String sql1 = "select count(*) from t_s_depart where type=4 and parentdepartid='"+newdepartId+"'";
			List<Object[]> list=findListbySql(sql);
			List<Object[]> list1=findListbySql(sql1);
			if(StringUtil.isNotEmpty(newdepartId)){
				
				// rgt与lft之间相差1
				//哥哥我无解了
				if(list.size()>0){
					if(!"0".equals(list1.get(0)+"")){
						RecursionDepartById(departxixxList,null,type,newdepartId,funtype);
					}
					type=funtype;
				}
				RecursionDepartById(departxixxList,null,type,newdepartId,funtype);
				
			}
		}
		departxixxList.addAll(departListTemp);
		return departxixxList;
	}
	
	//新版组织机构树
//	public List<Departxinxi> RecursionDepartById(List<Departxinxi> departxixxList,String departId,String type,String newdepartId,String funtype){
//		List<Departxinxi> departListTemp=new ArrayList<Departxinxi>();
//		CriteriaQuery cq=new CriteriaQuery(TSDepart.class);
//		if(StringUtil.isNotEmpty(departId)){
//			cq.eq("id", departId); //这句话是通过给HQL设置Id查询数据，得到主节点
//		}
//		if(StringUtil.isNotEmpty(type)){
//			cq.eq("type", type);
//			type="";
//		}
//		if(StringUtil.isNotEmpty(newdepartId)){
//			cq.eq("TSPDepart.id", newdepartId); //这句话是通过给HQL设置Id查询数据，得到主节点
//		}
//		cq.add();
//		List<TSDepart> departList=this.commonDao.getListByCriteriaQuery(cq, false);
//		for(int i=0;i<departList.size();i++){
//			TSDepart depart=departList.get(i);
//			Departxinxi departxinxi=new Departxinxi();
//			departxinxi.setID(depart.getId());
//			newdepartId=depart.getId();
//			if(depart.getTSPDepart()==null || depart.getId().equalsIgnoreCase(departId)){
//				departxinxi.setParentdepartid("");
//			}else{
//				departxinxi.setParentdepartid(depart.getTSPDepart().getId());
//			}
//			departxinxi.setDepartname(depart.getDepartname());
//			departxinxi.setDepartorderid(StringUtil.Null2Blank(depart.getDepartorderid()));
//			departxinxi.setDescription(depart.getDescription());
//			departxinxi.setLat(depart.getLat());
//			departxinxi.setLft(String.valueOf(depart.getLft()));
//			departxinxi.setLng(String.valueOf(depart.getLng()));
//			departxinxi.setRgt(String.valueOf(depart.getRgt()));
//			departxinxi.setType(String.valueOf(depart.getType()));
//			departListTemp.add(departxinxi);
//			String sql="select * from t_s_depart where (rgt-lft)=1 and parentdepartid='"+newdepartId+"'";
//			String departSql="";
//			if(depart.getTSPDepart()!=null){
//				departSql="select * from t_s_depart where parentdepartid='"+newdepartId+"'";
//			}
//			List<Object[]> list=findListbySql(sql);
//			List<Object[]> objList=null;
//			if(StringUtil.isNotEmpty(departSql)){
//				objList=findListbySql(departSql);
//			}
//			if(StringUtil.isNotEmpty(newdepartId)){
//				// rgt与lft之间相差1
//				//哥哥我无解了
//				if(list.size()>0 && objList==null){
//					type=funtype;
//				}
//				RecursionDepartById(departxixxList,null,type,newdepartId,funtype);
//			}
//		}
//		departxixxList.addAll(departListTemp);
//		return departxixxList;
//	}
	
}
