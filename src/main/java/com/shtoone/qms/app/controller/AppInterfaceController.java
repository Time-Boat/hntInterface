package com.shtoone.qms.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.PasswordUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSRole;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.AppinfoDocumentImpl;

import com.shtoone.qms.app.entity.AppHunnintuView;
import com.shtoone.qms.app.entity.AppInterfaceHandSetBean;
import com.shtoone.qms.app.entity.AppInterfaceQuanXianBean;
import com.shtoone.qms.app.entity.BHZ_CaiLiaoYL_Item;
import com.shtoone.qms.app.entity.BHZ_SCSJCZSH;
import com.shtoone.qms.app.entity.BHZ_SCSJData_Item;
import com.shtoone.qms.app.entity.Departxinxi;
import com.shtoone.qms.app.entity.HntCountAnalyze;
import com.shtoone.qms.app.entity.HntMain;
import com.shtoone.qms.app.entity.HntMainLogoBean;
import com.shtoone.qms.app.entity.ShebeiListBean;
import com.shtoone.qms.app.entity.SysWNJlistBean;
import com.shtoone.qms.app.service.AppInterfaceService;
import com.shtoone.qms.app.entity.AppHntBanhejiState;
import com.shtoone.qms.app.entity.AppHntHomePageData;
import com.shtoone.qms.app.entity.AppHntSysHPData;
import com.shtoone.qms.entity.bhz.BanhezhanxinxiEntity;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.entity.bhz.HunnintuView;
import com.shtoone.qms.entity.bhz.HunnintuchaobiaoViewEntity;
import com.shtoone.qms.entity.bhz.HunnintujieguoViewEntity;
import com.shtoone.qms.service.bhz.HandsetServiceI;
import com.shtoone.qms.service.bhz.HntbhzziduancfgViewServiceI;
import com.shtoone.qms.util.GetDate;
import com.shtoone.qms.util.JsonUtil;
import com.shtoone.qms.util.StringUtil;
import com.thoughtworks.xstream.mapper.Mapper.Null;

/**
 * APP数据接口处理类
 * 
 * @author
 * 
 */
@Controller
@RequestMapping(value = "/app")
public class AppInterfaceController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AppInterfaceController.class);

	@Autowired
	private AppInterfaceService infService;

	@Autowired
	private UserService userService;

	@Autowired
	private SystemService systemService;

	@Autowired
	private HntbhzziduancfgViewServiceI hntbhzziduancfgViewService;

	@Autowired
	private HandsetServiceI handsetsService;

	@RequestMapping(params = "AppLogin")
	public void AppLogin(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj = new JSONObject();
		try {
			String userName = request.getParameter("userName");// 用户名
			String userPwd = request.getParameter("userPwd");// 密码
			String OSType = request.getParameter("OSType");// 当前登录手机类型 1:手机短信
															// 2:安卓3:苹果
			String sign = null;// 标识 phone:手机号码登陆 userName:用户名登陆
			System.out.println("APP登录:用户信息>>登录名【" + userName + "】密码【" + userPwd + "】手机类型(2:安卓3:苹果)【" + OSType + "】");
			if (StringUtil.Null2Blank(userName).length() > 0 && StringUtil.Null2Blank(userPwd).length() > 0) {
				TSUser user = userService.getUserByid(userName);
				if (null != user && user.getPassword() != null) {
					// 加密后密码
					String pwd = PasswordUtil.encrypt(user.getUserName(), userPwd, PasswordUtil.getStaticSalt());
					// 此时属于平台用户登录
					if (null != user && user.getPassword().equals(pwd)) {
						sign = "userName";
					} else {
						// 手机用户登录记录
						user = userService.getUserByMobilePhone(userName);
						if (null != user && user.getPassword().equals(pwd)) {
							sign = "phone";
						}
					}
					if (user != null && user.getPassword().equals(pwd) && sign != null) {
						returnJsonObj.put("userFullName", user.getRealName());// 当前登录用户名称
						returnJsonObj.put("departId", user.getTSDepart().getId());// 所属部门编号
						// 根据当前所属部门，查询组织机构名称
						TSDepart depart = systemService.findUniqueByProperty(TSDepart.class, "id",
								user.getTSDepart().getId()); // 机构id
						if (depart != null) {
							returnJsonObj.put("departName", depart.getDepartname());// 所属部门名称
							returnJsonObj.put("userRole", StringUtil.Null2Blank(depart.getType()));// 所属部门编号
						} else {
							returnJsonObj.put("departName", "");
							returnJsonObj.put("userRole", "");
						}
						List<TSDepart> departList = systemService.findByProperty(TSDepart.class, "TSPDepart.id",
								user.getTSDepart().getId());
						System.out.println(user.getTSDepart().getId());
						if (departList.size() > 0) {
							returnJsonObj.put("type", "GL");
						} else {
							returnJsonObj.put("type", "SG");
						}

						if (StringUtil.Null2Blank(user.getMobilePhone()).length() == 0) {
							returnJsonObj.put("userPhoneNum", "");// 用户电话号码
						} else {
							returnJsonObj.put("userPhoneNum", user.getMobilePhone());// 用户电话号码
						}
						String xmmc = "";// 项目名称
						String xmjc = "";// 项目简称用于手机推送消息唯一
						String filename = request.getSession().getServletContext().getRealPath("/") + "WEB-INF"
								+ File.separator + "classes" + File.separator + "xmmc.ini";
						File fp = new File(filename);
						if (!fp.exists()) {
							try {
								fp.createNewFile();
							} catch (IOException e) {
								logger.error(e.getMessage());
							}
						}
						if (fp.exists()) {
							try {
								Properties prop = new Properties();
								prop.load(new FileInputStream(fp));
								xmmc = prop.getProperty("xmmc", "项目APP");// 项目名称
								xmjc = prop.getProperty("xmjc", "XMJC");// 项目简称
								if (null == xmmc || xmmc.equals("项目APP")) {
									FileOutputStream fos = new FileOutputStream(fp);
									prop.setProperty("xmmc", "项目APP");
									prop.setProperty("xmjc", "XMJC");
									prop.store(fos, "xmmc");
									fos.close();
								}
							} catch (FileNotFoundException e) {
								logger.error(e.getMessage());
							} catch (IOException e) {
								logger.error(e.getMessage());
							}
						}
						returnJsonObj.put("xmmc", xmmc);// 当前登录用户名称
						String updateDepartTime = infService.getUpdateDepartTime();
						returnJsonObj.put("updateDepartTime", updateDepartTime);

						// 修改登陆用户手机类型
						try {
							// 登陆手机类型
							if (StringUtil.Null2Blank(OSType).length() > 0) {
								String sql = "update t_s_user set OSType='" + OSType + "' where id='" + user.getId()
										+ "'";
								infService.executeSql(sql);
							}
						} catch (Exception e) {
						}

						// 添加登陆日志
						String message = "用户: " + user.getUserName() + "[" + user.getTSDepart().getDepartname() + "]"
								+ "登录成功";
						systemService.addLog(message, Globals.Log_Type_LOGIN, Globals.Log_Leavel_INFO);

						// 获取登录用户的手机号码组
						try {
							if (StringUtil.Null2Blank(user.getMobilePhone()).length() > 0) {
								List<AppInterfaceHandSetBean> handsetlist = handsetsService
										.getHandSet(user.getMobilePhone());
								for (AppInterfaceHandSetBean handsetObj : handsetlist) {
									String sql = "update handsets set type=" + OSType + " where id="
											+ handsetObj.getId();
									infService.executeSql(sql);

									handsetObj.setName(xmjc + handsetObj.getName());
								}
								if (null != handsetlist && handsetlist.size() > 0) {
									returnJsonObj.put("SMSGroup", JSONArray.fromObject(handsetlist));
								} else {
									returnJsonObj.put("SMSGroup", "[]");
								}
							} else {
								returnJsonObj.put("SMSGroup", "[]");
							}
						} catch (Exception ex) {
							returnJsonObj.put("SMSGroup", "[]");
						}

						// 获取角色权限
						// 这样编写，源于TSRoleUser是中间表,桥梁表
						List<TSRoleUser> rUsers = systemService.findByProperty(TSRoleUser.class, "TSUser.id",
								user.getId());
						AppInterfaceQuanXianBean quanxianBean = new AppInterfaceQuanXianBean();// 权限对象
						if (rUsers.size() > 0) {
							for (TSRoleUser ru : rUsers) {
								TSRole role = ru.getTSRole();
								String roleCode = role.getRoleCode();
								// 在Web给手机App增加权限时，就需要加上APP三个字
								// 因为权限中已经包含了chaobiao角色代码，这里要剔除掉
								if (StringUtil.Null2Blank(roleCode).length() > 8
										&& roleCode.indexOf("chaobiao") != -1) {
									// 这种自定义的JAVABean反射弱爆了
									// SetZiduanValue(quanxianBean,roleCode);
									// 使用commons-beanutils自带的Java Bean反射机制
									PropertyUtils.setSimpleProperty(quanxianBean, roleCode, true);
								}
							}
							returnJsonObj.put("quanxian", quanxianBean);// 当前登录用户权限
						} else {
							returnJsonObj.put("quanxian", "");
						}

						// 闪屏页数据预处理
						// List<Departxinxi> deptList =
						// getDeptData(user.getTSDepart().getId(),StringUtil.Null2Blank(depart.getType()));
						// returnJsonObj.put("cacheDeptSysData",
						// AppPreprocessData(deptList,"3"));
						// returnJsonObj.put("cacheDeptLqBhzData",
						// AppPreprocessData(deptList,"2"));
						// returnJsonObj.put("cacheDeptHntBhzData",
						// AppPreprocessData(deptList,"1"));

						returnJsonObj.put("success", true);
					} else {
						System.out.println("用户【" + userName + "】密码【" + userPwd + "】错误！");
						returnJsonObj.put("data", "[]");
						returnJsonObj.put("success", false);
					}
				} else {
					System.out.println("用户【" + userName + "】不存在！");
					returnJsonObj.put("data", "[]");
					returnJsonObj.put("success", false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("登陆异常");
			returnJsonObj.put("data", "[]");
			returnJsonObj.put("success", false);
		}
		responseOutWrite(response, returnJsonObj);
	}

	/**
	 * 动态设置指定指端的值【这种方式弱爆了】
	 * 
	 * @param hnttempObj
	 * @param ziduanmingcheng
	 */
	public void SetZiduanValue(AppInterfaceQuanXianBean hnttempObj, String ziduanmingcheng) {
		try {
			hnttempObj.getClass()
					.getMethod("set" + ziduanmingcheng.replaceFirst(ziduanmingcheng.substring(0, 1),
							ziduanmingcheng.substring(0, 1).toUpperCase()), boolean.class)
					.invoke(hnttempObj, new Object[] { true });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 其实这里还可以在简化，通过传入的funtype,当用户不等于此类型是，利用for循环的continue **/
	@RequestMapping(params = "AppDepartTree")
	public void AppDepartTree(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj = new JSONObject();
		try {
			String updateTime = request.getParameter("updateDepartTime"); // 时间戳
			String departid = request.getParameter("userGroupId");// 所属机构编号
			String type = request.getParameter("type"); // 从登录API中获取 (userRole)
			String funtype = request.getParameter("funtype"); // 模块类型
			if (StringUtil.Null2Blank(updateTime).length() > 0) {
				// 如果登录中的时间和此时的时间比对是一致的，表示组织机构没有被更改过，否则就重新请求组织机构
				String tempTime = String.valueOf(GetDate.DateTimeConvetTimetmp(infService.getUpdateDepartTime()));// 组织机构更新时间,转换为时间戳
				if (StringUtil.Null2Blank(tempTime).length() > 0 && tempTime.equalsIgnoreCase(updateTime)) {
					returnJsonObj.put("data", "[]");
					returnJsonObj.put("success", false);
				} else {
					List<Departxinxi> departxixxList = new ArrayList<Departxinxi>();
					List<Departxinxi> departList = systemService.RecursionDepartById(departxixxList, departid, type,
							null, funtype);
					if (departList.size() > 0) {
						returnJsonObj.put("data", departList);
						returnJsonObj.put("success", true);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("获取组织机构树异常");
			returnJsonObj.put("data", "[]");
			returnJsonObj.put("success", false);
		}
		responseOutWrite(response, returnJsonObj);
	}

	/** 闪屏页数据预加载 */
	public JSONArray AppPreprocessData(List<Departxinxi> departList, String funtype) {
		List<Departxinxi> dtxList = new ArrayList<Departxinxi>();
		for (Departxinxi dept : departList) {
			if (dept.getType().equals(funtype) || dept.getType().equals("4")) {
				dtxList.add(dept);
			}
		}
		if (dtxList.size() > 0) {
			return JSONArray.fromObject(dtxList);
		}
		return null;
	}

	// 获取整个组织机构数据
	public List<Departxinxi> getDeptData(String pid, String type) {
		List<Departxinxi> departxixxList = new ArrayList<Departxinxi>();
		List<Departxinxi> departList = systemService.RecursionDepartById(departxixxList, pid, type, null, null);
		return departList;
	}

	/**
	 * 哎，，，真是想死的心都有了
	 * 
	 * @RequestMapping (params ="AppDepartTree") public void
	 *                 AppDepartTree(HttpServletRequest
	 *                 request,HttpServletResponse response){
	 *                 JsonUtil.responseUTF8(response); JSONObject
	 *                 returnJsonObj=new JSONObject(); try { String
	 *                 updateTime=request.getParameter("updateDepartTime");
	 *                 //时间戳 String
	 *                 departid=request.getParameter("userGroupId");//所属机构编号
	 *                 String type=request.getParameter("type"); //试验类型 String
	 *                 userlft=null; String userrgt=null; if
	 *                 (StringUtil.Null2Blank(departid).length()>0) { TSDepart
	 *                 dpt=systemService.getEntity(TSDepart.class, departid);
	 *                 userlft=dpt.getLft()+""; userrgt=dpt.getRgt()+""; }
	 *                 if(StringUtil.Null2Blank(updateTime).length()>0){
	 *                 //如果登录中的时间和此时的时间比对是一致的，表示组织机构没有被更改过，否则就重新请求组织机构 String
	 *                 tempTime=String.valueOf(GetDate.DateTimeConvetTimetmp(
	 *                 infService.getUpdateDepartTime()));//组织机构更新时间,转换为时间戳
	 *                 if(StringUtil.Null2Blank(tempTime).length()>0 &&
	 *                 tempTime.equalsIgnoreCase(updateTime)){
	 *                 returnJsonObj.put("data","[]");
	 *                 returnJsonObj.put("success", true); }else{ List
	 *                 <Departxinxi> departList
	 *                 =systemService.getDepartBySQL(userlft,userrgt,departid,
	 *                 type); if(departList.size()>0){
	 *                 returnJsonObj.put("data",departList);
	 *                 returnJsonObj.put("success", true); } } } } catch
	 *                 (Exception e) { e.printStackTrace();
	 *                 System.out.println("获取组织机构树异常");
	 *                 returnJsonObj.put("success", false); }
	 *                 responseOutWrite(response, returnJsonObj); }
	 **/

	/**
	 * //组织机构树[廖泰鑫写，带递归的方式,超级无敌脑残，还用两个循环体]
	 * 
	 * @RequestMapping (params ="AppDepartTree") public String
	 *                 AppDepartTree(HttpServletRequest
	 *                 request,HttpServletResponse response){
	 *                 JsonUtil.responseUTF8(response); JSONObject
	 *                 returnJsonObj=new JSONObject(); try { //获取组织机构树
	 *                 CriteriaQuery cq = new CriteriaQuery(TSDepart.class);
	 *                 cq.isNull("TSPDepart");
	 *                 //这句话是通过给HQL设置parentdepartid查询数据，得到主节点 cq.add();
	 *                 //给其设置了条件，一定要加载条件 List<TSDepart> departList
	 *                 =systemService.getListByCriteriaQuery(cq, false); List
	 *                 <UserGroupxinxx> userGroupList=new ArrayList
	 *                 <UserGroupxinxx>(); int level=1; //递归的层级
	 *                 //此时开始使用递归方法查询其子子孙孙 if(departList.size()>0){ String[]
	 *                 tmpIdArr=new String[departList.size()]; for(int
	 *                 i=0;i<departList.size();i++){ TSDepart
	 *                 depart=departList.get(i); UserGroupxinxx userGroup=new
	 *                 UserGroupxinxx(); userGroup.setDepth("1"); //此时其绝对为第一级
	 *                 userGroup.setName(depart.getDepartname());
	 *                 tmpIdArr[i]=depart.getId();
	 *                 userGroup.setNodeId(depart.getId());
	 *                 userGroup.setParentId("");
	 *                 userGroup.setLft(depart.getLft());
	 *                 userGroup.setRgt(depart.getRgt());
	 *                 userGroupList.add(userGroup); } //通过递归实现 for(int
	 *                 j=0;j<tmpIdArr.length;j++){
	 *                 systemService.RecursionDepart(userGroupList,tmpIdArr[j],
	 *                 level); } }
	 *                 returnJsonObj.put("departTree",userGroupList);
	 *                 returnJsonObj.put("success", true); } catch (Exception e)
	 *                 { // TODO: handle exception e.printStackTrace();
	 *                 System.out.println("获取组织机构树异常");
	 *                 returnJsonObj.put("success", false); }
	 *                 JsonUtil.outPrint(response, returnJsonObj.toString());
	 *                 return null; }
	 **/

	// 拌和站 统计主页
	@RequestMapping(params = "AppHntMain")
	public void AppHntMain(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj = new JSONObject();
		try {
			String departId = request.getParameter("departId");// 组织机构编号
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			if (null == startTime && null == endTime) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar day = Calendar.getInstance();
				endTime = sdf.format(day.getTime());
				day.add(Calendar.MONTH, -1);
				startTime = sdf.format(day.getTime());
			} else {
				startTime = GetDate.TimetmpConvetDateTime(request.getParameter("startTime"));// 开始时间
				endTime = GetDate.TimetmpConvetDateTime(request.getParameter("endTime"));// 终止时间
			}
			List<HntMain> returnList = new ArrayList<HntMain>();
			// 获取组织机构树
			if (StringUtil.Null2Blank(departId).length() > 0) {
				CriteriaQuery cq = new CriteriaQuery(TSDepart.class);
				cq.eq("TSPDepart.id", departId);
				cq.add();
				List<TSDepart> departList = systemService.getListByCriteriaQuery(cq, false);
				if (departList.size() > 0) { // 管理者进入
					for (TSDepart temp : departList) {
						// 为试验室时干掉
						if (StringUtil.sysType.equalsIgnoreCase(temp.getType())) {
							continue;
						}
						Integer bhjCount = infService.getBanhejiCount(1, temp.getLft(), temp.getRgt());// 统计水泥混凝土拌和机数量
						Integer bhzCount = infService.getBanhezhanCount(1, temp.getLft(), temp.getRgt());// 统计水泥混凝土拌和机数量
						HntMain hntMainObj = infService.getHntMainObj(temp.getLft(), temp.getRgt(), startTime, endTime,
								null);// 统计生产及超标信息
						if (null == hntMainObj) {
							hntMainObj = new HntMain();
						}
						hntMainObj.setBhjCount(bhjCount + "");
						hntMainObj.setBhzCount(bhzCount + "");
						hntMainObj.setDepartId(temp.getId());
						hntMainObj.setDepartName(temp.getDepartname());
						returnList.add(hntMainObj);
					}
				} else { // 施工人员进入
					TSDepart tsDepart = (TSDepart) systemService.findUniqueByProperty(TSDepart.class, "id", departId);
					if (tsDepart != null) {
						// 拌和机数量
						if (tsDepart.getType().equalsIgnoreCase(StringUtil.hntbhzType)) {
							List<BanhezhanxinxiEntity> bhzList = infService.getBanhejiList(1, tsDepart.getLft(),
									tsDepart.getRgt(), startTime, endTime, null);
							if (bhzList.size() > 0) {
								for (BanhezhanxinxiEntity bhz : bhzList) {
									HntMain hntMainObj = infService.getHntMainObj(tsDepart.getLft(), tsDepart.getRgt(),
											startTime, endTime, bhz.getGprsbianhao());// 统计生产及超标信息
									hntMainObj.setDepartId(tsDepart.getId());
									hntMainObj.setDepartName(bhz.getBanhezhanminchen());
									hntMainObj.setBhzCount("0");
									hntMainObj.setBhjCount("0");
									returnList.add(hntMainObj);
								}
							}
						}
					}
				}
			}
			if (returnList.size() <= 0) {
				returnJsonObj.put("data", "[]");
				returnJsonObj.put("success", false);
			} else {
				returnJsonObj.put("data", JSONArray.fromObject(returnList));
				returnJsonObj.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("获取App拌和站主页统计表格异常");
			returnJsonObj.put("data", "[]");
			returnJsonObj.put("success", false);
		}
		responseOutWrite(response, returnJsonObj);
	}

	// 生产数据列表查询
	@RequestMapping(params = "AppHntXiangxiList")
	public String AppHntXiangxiList(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj = new JSONObject();
		try {
			String departId = request.getParameter("departId");// 组织机构编号
			String gongchengmincheng = request.getParameter("gongchengmincheng");// 工程名称
			String jiaozhubuwei = request.getParameter("jiaozhubuwei");// 浇筑部位
			String startTime = request.getParameter("startTime");// 开始时间
			String endTime = request.getParameter("endTime");// 结束时间(时间戳)
			String shebeibianhao = request.getParameter("shebeibianhao");// 设备编号
			Integer userlft = 0;
			Integer userrgt = 0;
			String pageNoStr = request.getParameter("pageNo");// 当前页
			String maxPageItemsStr = request.getParameter("maxPageItems");// 每页条数
			Integer pageNo = 1;
			Integer maxPageItems = 10;
			if (StringUtil.Null2Blank(pageNoStr).length() > 0) {
				pageNo = new Integer(pageNoStr);
			}
			if (StringUtil.Null2Blank(maxPageItemsStr).length() > 0) {
				maxPageItems = new Integer(maxPageItemsStr);
			}

			if (null == startTime && null == endTime) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar day = Calendar.getInstance();
				endTime = sdf.format(day.getTime());
				day.add(Calendar.MONTH, -1);
				startTime = sdf.format(day.getTime());
			} else {
				startTime = GetDate.TimetmpConvetDateTime(request.getParameter("startTime"));// 出料时间
				endTime = GetDate.TimetmpConvetDateTime(request.getParameter("endTime"));// 出料时间
			}

			if (departId != null && departId.length() > 0) {
				TSDepart dpt = systemService.getEntity(TSDepart.class, departId);
				userlft = dpt.getLft();
				userrgt = dpt.getRgt();
			}

			// List<HunnintuView>
			// tempList=infService.AppHntXiangxiList(startTime, endTime,
			// userlft, userrgt, jiaozhubuwei, gongchengmincheng, shebeibianhao,
			// pageNo, maxPageItems);

			List<BHZ_SCSJData_Item> tempList = infService.AppHntXiangxiList(startTime, endTime, userlft, userrgt,
					jiaozhubuwei, gongchengmincheng, shebeibianhao, pageNo, maxPageItems);

			if (null == tempList) {
				returnJsonObj.put("data", "[]");
			} else {
				returnJsonObj.put("data", JSONArray.fromObject(tempList));
			}
			returnJsonObj.put("success", true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("获取App拌和站生产数据列表异常");
			returnJsonObj.put("success", false);
		}
		JsonUtil.outPrint(response, returnJsonObj.toString());
		return null;

	}

	// 生产数据明细查询
	@RequestMapping(params = "AppHntXiangxiDetail")
	public void AppHntXiangxiDetail(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj = new JSONObject();

		HntbhzziduancfgViewEntity hbfield = null;
		HntbhzziduancfgViewEntity hntbhzisShow = null;

		try {
			String bianhao = request.getParameter("bianhao");//

			HunnintuView tempObj = systemService.getEntity(HunnintuView.class, new Integer(bianhao));
			if (tempObj != null && StringUtil.Null2Blank(tempObj.getShebeibianhao()) != "") {
				hbfield = hntbhzziduancfgViewService.gethntcfgfield(tempObj.getShebeibianhao());
				hntbhzisShow = hntbhzziduancfgViewService.gethntbhzisShow(tempObj.getShebeibianhao());
			}
			List<BHZ_CaiLiaoYL_Item> bciList = bean2List(tempObj, hntbhzisShow, hbfield, 3);

			BHZ_SCSJData_Item tempList = new BHZ_SCSJData_Item();

			tempList.setChuliaoshijian(tempObj.getChuliaoshijian());
			tempList.setGongchengmingcheng(tempObj.getGongchengmingcheng());
			tempList.setJiaobanshijian(tempObj.getJiaobanshijian());
			tempList.setGujifangshu(tempObj.getGujifangshu());
			tempList.setPeifanghao(tempObj.getPeifanghao());
			tempList.setChaozuozhe(tempObj.getChaozuozhe());
			tempList.setSigongdidian(tempObj.getSigongdidian());
			tempList.setJiaozuobuwei(tempObj.getJiaozuobuwei());
			tempList.setWaijiajipingzhong(tempObj.getWaijiajipingzhong());
			tempList.setShuinipingzhong(tempObj.getShuinipingzhong());
			tempList.setQiangdudengji(tempObj.getQiangdudengji());
			tempList.setBanhezhanminchen(tempObj.getBanhezhanminchen());
			tempList.setGongdanhao(tempObj.getGongdanhao());

			if (null == tempObj) {
				returnJsonObj.put("data", "[]");
				returnJsonObj.put("success", false);
			} else {
				returnJsonObj.put("data", JSONArray.fromObject(bciList));
				returnJsonObj.put("headMsg", JSONObject.fromObject(tempList));
				returnJsonObj.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("获取App拌和站生产数据明细异常");
			returnJsonObj.put("data", "[]");
			returnJsonObj.put("success", false);
		}
		responseOutWrite(response, returnJsonObj);
	}

	// 生产数据超标列表查询
	@RequestMapping(params = "AppHntChaobiaoList")
	public String AppHntChaobiaoList(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj = new JSONObject();
		try {
			String departId = request.getParameter("departId");// 组织机构编号
			String gongchengmincheng = request.getParameter("gongchengmincheng");// 工程名称
			String jiaozhubuwei = request.getParameter("jiaozhubuwei");// 浇筑部位
			String startTime = request.getParameter("startTime");// 开始时间
			String endTime = request.getParameter("endTime");// 结束时间(时间戳)
			String shebeibianhao = request.getParameter("shebeibianhao");// 设备编号
			String dengji = request.getParameter("dengji");// 报警等级（0:全部 1:初级
															// 2:中级 3:高级）
			String chuzhileixing = request.getParameter("chuzhileixing");// 处置情况(0:未处置
																			// 1:已处置
																			// 2:已审批
																			// 3:未审批)
			Integer userlft = 0;
			Integer userrgt = 0;
			String pageNoStr = request.getParameter("pageNo");// 当前页
			String maxPageItemsStr = request.getParameter("maxPageItems");// 每页条数
			Integer pageNo = 1;
			Integer maxPageItems = 10;
			if (StringUtil.Null2Blank(pageNoStr).length() > 0) {
				pageNo = new Integer(pageNoStr);
			}
			if (StringUtil.Null2Blank(maxPageItemsStr).length() > 0) {
				maxPageItems = new Integer(maxPageItemsStr);
			}

			if (null == startTime && null == endTime) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar day = Calendar.getInstance();
				endTime = sdf.format(day.getTime());
				day.add(Calendar.MONTH, -1);
				startTime = sdf.format(day.getTime());
			} else {
				startTime = GetDate.TimetmpConvetDateTime(request.getParameter("startTime"));// 出料时间
				endTime = GetDate.TimetmpConvetDateTime(request.getParameter("endTime"));// 出料时间
			}

			if (departId != null && departId.length() > 0) {
				TSDepart dpt = systemService.getEntity(TSDepart.class, departId);
				userlft = dpt.getLft();
				userrgt = dpt.getRgt();
			}

			List<BHZ_SCSJData_Item> tempList = infService.AppHntjieguoList(departId, startTime, endTime, dengji,
					chuzhileixing, gongchengmincheng, jiaozhubuwei, shebeibianhao, "", userlft, userrgt, pageNo,
					maxPageItems);

			if (tempList != null && tempList.size() > 0) {
				returnJsonObj.put("data", JSONArray.fromObject(tempList));
				returnJsonObj.put("success", true);
			} else {
				returnJsonObj.put("data", "[]");
				returnJsonObj.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("获取App拌和站生产数据超标列表异常");
			returnJsonObj.put("data", "[]");
			returnJsonObj.put("success", false);
		}
		JsonUtil.outPrint(response, returnJsonObj.toString());
		return null;
	}

	// 生产数据超标明细查询
	@RequestMapping(params = "AppHntChaobiaoDetail")
	public void AppHntChaobiaoDetail(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj = new JSONObject();
		try {
			String bianhao = request.getParameter("bianhao");// 沥青信息编号
			HntbhzziduancfgViewEntity hbfield = null;
			HntbhzziduancfgViewEntity hntbhzisShow = null;

			BHZ_SCSJCZSH temp = null;
			List<BHZ_CaiLiaoYL_Item> data = null;
			if (StringUtil.Null2Blank(bianhao).length() > 0) {
				HunnintuchaobiaoViewEntity tempObj = systemService.getEntity(HunnintuchaobiaoViewEntity.class,
						new Integer(bianhao));
				// tempObj=infService.gethntchaobiaoDetailById(new
				// Integer(bianhao));
				if (StringUtil.Null2Blank(tempObj.getShebeibianhao()).length() > 0) {
					hbfield = hntbhzziduancfgViewService.gethntcfgfield(tempObj.getShebeibianhao());
					hntbhzisShow = hntbhzziduancfgViewService.gethntbhzisShow(tempObj.getShebeibianhao());
				}

				temp = new BHZ_SCSJCZSH();

				temp.setId(tempObj.getJieguobianhao() + "");
				temp.setChuliaoshijian(tempObj.getChuliaoshijian());
				temp.setGongchengmingcheng(tempObj.getGongchengmingcheng());
				temp.setJiaobanshijian(tempObj.getJiaobanshijian());
				temp.setGujifangshu(tempObj.getGujifangshu());
				temp.setPeifanghao(tempObj.getPeifanghao());
				temp.setChaozuozhe(tempObj.getChaozuozhe());
				temp.setSigongdidian(tempObj.getSigongdidian());
				temp.setJiaozuobuwei(tempObj.getJiaozuobuwei());
				temp.setWaijiajipingzhong(tempObj.getWaijiajipingzhong());
				temp.setShuinipingzhong(tempObj.getShuinipingzhong());
				temp.setQiangdudengji(tempObj.getQiangdudengji());
				temp.setBanhezhanminchen(tempObj.getBanhezhanminchen());
				temp.setGongdanhao(tempObj.getGongdanhao());
				temp.setChulijieguo(tempObj.getChulijieguo());

				temp.setWentiyuanyin(tempObj.getWentiyuanyin());
				temp.setChulishijian(tempObj.getChulishijian());
				temp.setChulifangshi(tempObj.getChulifangshi());
				temp.setConfirmdate(tempObj.getConfirmdate());
				temp.setJianliresult(tempObj.getJianliresult());
				temp.setJianlishenpi(tempObj.getJianlishenpi());
				temp.setShenpidate(tempObj.getShenpidate());
				temp.setChuliren(tempObj.getChuliren());
				temp.setShenpiren(tempObj.getShenpiren());
				temp.setFilePath(tempObj.getFilepath());

				data = bean2List(tempObj, hntbhzisShow, hbfield, 1);
			}

			if (data != null && data.size() > 0 && hbfield != null && hntbhzisShow != null) {
				returnJsonObj.put("data", JSONArray.fromObject(data));
				returnJsonObj.put("headMsg", JSONObject.fromObject(temp));
				returnJsonObj.put("success", true);
			} else {
				returnJsonObj.put("data", "[]");
				returnJsonObj.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("获取App拌和站生产数据超标列表异常");
			returnJsonObj.put("data", "[]");
			returnJsonObj.put("success", false);
		}
		responseOutWrite(response, returnJsonObj);
	}

	// 超标处置
	@RequestMapping(params = "AppHntChaobiaoChuzhi", method = RequestMethod.POST)
	public String AppHntChaobiaoChuzhi(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj = new JSONObject();
		try {
			request.setCharacterEncoding("UTF-8");

			String bianhaoStr = request.getParameter("jieguobianhao");// 数据编号
			if (StringUtil.Null2Blank(bianhaoStr).length() > 0) {
				String chaobiaoyuanyin = StringUtil.Null2Blank(request.getParameter("chaobiaoyuanyin"));// 超标原因
				String chuzhifangshi = StringUtil.Null2Blank(request.getParameter("chuzhifangshi"));// 处置方式
				String chuzhijieguo = StringUtil.Null2Blank(request.getParameter("chuzhijieguo"));// 处置结果
				String chuzhiren = StringUtil.Null2Blank(request.getParameter("chuzhiren"));// 处置人
				String chuzhishijian = GetDate
						.TimetmpConvetDateTime(StringUtil.Null2Blank(request.getParameter("chuzhishijian")));// 处置时间

				String isIos = request.getParameter("isIos");

				// -----代码片段 spingMVC上传文件
				MultipartHttpServletRequest mRequest = null;
				MultipartFile file = null;
				if ("1".equals(isIos)) {
					// android和ios文件上传后，在后台接受方式不一样
					mRequest = (MultipartHttpServletRequest) request;// request强制转换注意
					file = mRequest.getFile("file");
				} else {
					// 解决android乱码问题
					chaobiaoyuanyin = new String(chaobiaoyuanyin.getBytes("ISO-8859-1"), "utf-8");
					chuzhifangshi = new String(chuzhifangshi.getBytes("ISO-8859-1"), "utf-8");
					chuzhijieguo = new String(chuzhijieguo.getBytes("ISO-8859-1"), "utf-8");
					chuzhiren = new String(chuzhiren.getBytes("ISO-8859-1"), "utf-8");
				}

				if (StringUtil.Null2Blank(chuzhishijian).length() <= 0) {
					chuzhishijian = GetDate.getNowTime("yyyy-MM-dd HH:MM:ss");
				}

				String sql = "update Xiangxixxjieguo set chulishijian='" + chuzhishijian + "', wentiyuanyin='"
						+ chaobiaoyuanyin + "',chulifangshi='" + chuzhifangshi + "'," + "chulijieguo='" + chuzhijieguo
						+ "',chuliren='" + chuzhiren + "' where " + " id=" + bianhaoStr;

				InputStream input = request.getInputStream();// 读取二进制图片流

				if (file != null) {
					input = file.getInputStream();
				}

				if (null != input) {
					// 保存文件的物理根地址
					StringBuffer savepath = new StringBuffer(request.getSession().getServletContext().getRealPath("/"));
					savepath.append("\\" + "HNTChaoBiaoFile");
					// System.out.println(savepath);
					File savedir = new File(savepath.toString());
					if (!savedir.exists()) {
						savedir.mkdirs();
					}

					String tupianName = "APP_" + bianhaoStr + "_" + System.currentTimeMillis() + ".jpg";
					System.out.println(tupianName);
					FileOutputStream fos = new FileOutputStream(savepath + "\\" + tupianName);
					int size = 0;
					byte[] buffer = new byte[1024];
					while ((size = input.read(buffer, 0, 1024)) != -1) {
						fos.write(buffer, 0, size);
					}
					fos.close();
					input.close();
					sql = "update Xiangxixxjieguo set chulishijian='" + chuzhishijian + "',wentiyuanyin='"
							+ chaobiaoyuanyin + "',chulifangshi='" + chuzhifangshi + "' " + ",chuliren='" + chuzhiren
							+ "',filepath='" + ("HNTChaoBiaoFile/" + tupianName) + "',chulijieguo='" + chuzhijieguo
							+ "' where " + " id=" + bianhaoStr;
				}
				System.out.println(sql);
				infService.executeSql(sql);
				returnJsonObj.put("success", true);
			} else {
				returnJsonObj.put("success", false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("混凝土APP超标处置错误！");
			returnJsonObj.put("success", false);
		}
		JsonUtil.outPrint(response, returnJsonObj.toString());
		return null;

	}

	// 超标审批
	@RequestMapping(params = "AppHntChaobiaoShenpi", method = RequestMethod.POST)
	@ResponseBody
	public void AppHntChaobiaoShenpi(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj = new JSONObject();
		try {
			request.setCharacterEncoding("UTF-8");
			String bianhaoStr = request.getParameter("jieguobianhao");// 数据编号
			if (StringUtil.Null2Blank(bianhaoStr).length() > 0) {
				String jianliresult = StringUtil.Null2Blank(request.getParameter("jianliresult"));// 监理结果
				String jianlishenpi = StringUtil.Null2Blank(request.getParameter("jianlishenpi"));// 监理审批
				String confirmdate = GetDate
						.TimetmpConvetDateTime(StringUtil.Null2Blank(request.getParameter("confirmdate")));// 确认日期
				String shenpiren = StringUtil.Null2Blank(request.getParameter("shenpiren"));// 审批人
				String shenpidate = GetDate
						.TimetmpConvetDateTime(StringUtil.Null2Blank(request.getParameter("shenpidate")));// 审批日期
				if (StringUtil.Null2Blank(shenpidate).length() <= 0) {
					shenpidate = GetDate.getNowTime("yyyy-MM-dd HH:MM:ss");
				}

				String sql = "update Xiangxixxjieguo set shenpidate='" + shenpidate + "', jianliresult='" + jianliresult
						+ "',jianlishenpi='" + jianlishenpi + "'," + "confirmdate='" + confirmdate + "',shenpiren='"
						+ shenpiren + "' where " + " id=" + bianhaoStr;

				System.out.println(sql);
				infService.executeSql(sql);
				returnJsonObj.put("success", true);
			} else {
				returnJsonObj.put("success", false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("混凝土APP超标处置错误！");
			returnJsonObj.put("success", false);
		}
		// JsonUtil.outPrint(response, returnJsonObj.toString());
		responseOutWrite(response, returnJsonObj);
		// return null;

	}

	// 拌和机状态查询
	@RequestMapping(params = "AppHntBanhejiState")
	public void AppHntBanhejiState(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj = new JSONObject();
		try {
			request.setCharacterEncoding("UTF-8");
			String departId = request.getParameter("departId");// 所属机构编号
			String shebeibianhao = request.getParameter("shebeibianhao");// 设备编号
			Integer userlft = 0;
			Integer userrgt = 0;
			String pageNoStr = request.getParameter("pageNo");// 当前页
			String maxPageItemsStr = request.getParameter("maxPageItems");// 每页条数
			String state = request.getParameter("state");// 每页条数
			Integer pageNo = 1;
			Integer maxPageItems = 10;
			if (StringUtil.Null2Blank(pageNoStr).length() > 0) {
				pageNo = new Integer(pageNoStr);
			}
			if (StringUtil.Null2Blank(maxPageItemsStr).length() > 0) {
				maxPageItems = new Integer(maxPageItemsStr);
			}
			if (StringUtil.Null2Blank(departId).length() > 0) {
				TSDepart dpt = systemService.getEntity(TSDepart.class, departId);
				userlft = dpt.getLft();
				userrgt = dpt.getRgt();
			}
			List<AppHntBanhejiState> tempList = infService.AppHntBanhejiState(shebeibianhao, userlft, userrgt, pageNo,
					maxPageItems, state);
			if (null == tempList) {
				returnJsonObj.put("data", "[]");
				returnJsonObj.put("success", false);
			} else {
				returnJsonObj.put("data", tempList);
				returnJsonObj.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("混凝土APP拌和机状态错误！");
			returnJsonObj.put("data", "[]");
			returnJsonObj.put("success", false);
		}
		responseOutWrite(response, returnJsonObj);
	}

	// 材料用量核算
	@RequestMapping(params = "AppHntMaterial")
	public void AppHntMaterial(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj = new JSONObject();
		try {
			request.setCharacterEncoding("UTF-8");
			String departId = request.getParameter("departId");// 所属机构编号
			String startTime = request.getParameter("startTime");// 开始时间
			String endTime = request.getParameter("endTime");// 结束时间(时间戳)
			String shebeibianhao = request.getParameter("shebeibianhao");// 设备编号
			String gongchengmincheng = request.getParameter("gongchengmincheng");// 工程名称
			String jiaozhubuwei = request.getParameter("jiaozhubuwei");// 浇筑部位
			String qiangdudengji = request.getParameter("qiangdudengji");// 强度等级

			Integer userlft = 0;
			Integer userrgt = 0;
			String pageNoStr = request.getParameter("pageNo");// 当前页
			String maxPageItemsStr = request.getParameter("maxPageItems");// 每页条数
			Integer pageNo = 1;
			Integer maxPageItems = 10;
			if (StringUtil.Null2Blank(pageNoStr).length() > 0) {
				pageNo = new Integer(pageNoStr);
			}
			if (StringUtil.Null2Blank(maxPageItemsStr).length() > 0) {
				maxPageItems = new Integer(maxPageItemsStr);
			}

			if (null == startTime && null == endTime) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar day = Calendar.getInstance();
				endTime = sdf.format(day.getTime());
				day.add(Calendar.MONTH, -1);
				startTime = sdf.format(day.getTime());
			} else {
				startTime = GetDate.TimetmpConvetDateTime(request.getParameter("startTime"));// 出料时间
				endTime = GetDate.TimetmpConvetDateTime(request.getParameter("endTime"));// 出料时间
			}

			if (departId != null && departId.length() > 0) {
				TSDepart dpt = systemService.getEntity(TSDepart.class, departId);
				userlft = dpt.getLft();
				userrgt = dpt.getRgt();
			}
			HntbhzziduancfgViewEntity hbfield = hntbhzziduancfgViewService.gethntcfgfield(shebeibianhao);
			HntbhzziduancfgViewEntity hntbhzisShow = hntbhzziduancfgViewService.gethntbhzisShow(shebeibianhao);
			AppHunnintuView temp = infService.AppHntMaterial(gongchengmincheng, jiaozhubuwei, qiangdudengji, startTime,
					endTime, userlft, userrgt, shebeibianhao, pageNo, maxPageItems);

			List<BHZ_CaiLiaoYL_Item> bicList = bean2List(temp, hntbhzisShow, hbfield, 2);

			if (null == temp && hbfield == null && hntbhzisShow == null) {
				returnJsonObj.put("data", "[]");
				returnJsonObj.put("success", false);
			} else {
				returnJsonObj.put("data", JSONArray.fromObject(bicList));
				returnJsonObj.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("混凝土APP材料用量核算错误！");
			returnJsonObj.put("data", "[]");
			returnJsonObj.put("success", false);
		}
		responseOutWrite(response, returnJsonObj);
	}

	// 炸了....
	// 简单的泛型应用....
	public <T> List<BHZ_CaiLiaoYL_Item> bean2List(T t, HntbhzziduancfgViewEntity zdShow,
			HntbhzziduancfgViewEntity hbfield, int objType) {

		List<BHZ_CaiLiaoYL_Item> bciList = new ArrayList<BHZ_CaiLiaoYL_Item>();

		String[] cfg = { "Sha1_", "Shi1_", "Shi2_", "Sha2_", "Guliao5_", "Shuini1_", "Shuini2_", "Kuangfen3_",
				"Feimeihui4_", "Fenliao5_", "Fenliao6_", "Shui1_", "Shui2_", "Waijiaji1_", "Waijiaji2_", "Waijiaji3_",
				"Waijiaji4_" };

		for (int i = 0; i < 17; i++) {
			BHZ_CaiLiaoYL_Item bci = new BHZ_CaiLiaoYL_Item();
			try {
				if ("1".equals(zdShow.getClass().getMethod("get" + cfg[i] + "shijizhi", new Class[] {}).invoke(zdShow,
						new Object[] {}))) {
					String name = (String) hbfield.getClass().getMethod("get" + cfg[i] + "shijizhi", new Class[] {})
							.invoke(hbfield, new Object[] {});
					String shiji = (String) t.getClass().getMethod("get" + cfg[i] + "shijizhi", new Class[] {})
							.invoke(t, new Object[] {});
					String peibi = (String) t.getClass().getMethod("get" + cfg[i] + "lilunzhi", new Class[] {})
							.invoke(t, new Object[] {});

					// l...
					String decimal = i < 12 ? "0" : "2";

					shiji = String.format("%1$." + decimal + "f", Double.parseDouble(StringUtil.Null2Zero(shiji)));
					peibi = String.format("%1$." + decimal + "f", Double.parseDouble(StringUtil.Null2Zero(peibi)));

					String wuchazhi = String.format("%1$." + decimal + "f",
							Double.parseDouble(StringUtil.Null2Zero(shiji))
									- Double.parseDouble(StringUtil.Null2Zero(peibi)));

					bci.setName(name);
					bci.setShiji(shiji);
					bci.setPeibi(peibi);
					bci.setWuchazhi(wuchazhi);

					// 超标处置页面1 材料核算页面2 生产数据3
					switch (objType) {
					case 1:
						if (!"0".equals(shiji) && !"0".equals(wuchazhi) && !"0.00".equals(shiji)
								&& !"0.00".equals(wuchazhi)) {
							bci.setWuchalv(String.format("%1$.2f", Double.parseDouble(StringUtil.Null2Zero(wuchazhi))
									/ Double.parseDouble(shiji) * 100));
						} else {
							bci.setWuchalv("0.00");
						}

						String cbGrade = (String) t.getClass()
								.getMethod("getCb" + cfg[i].toLowerCase() + "shijizhi", new Class[] {})
								.invoke(t, new Object[] {});

						bci.setCbGrade(StringUtil.Null2Zero(cbGrade));
						break;
					case 2:
						break;
					case 3:
						if (!"0".equals(peibi) && !"0".equals(wuchazhi) && !"0.00".equals(peibi)
								&& !"0.00".equals(wuchazhi)) {
							bci.setWuchalv(String.format("%1$.2f", Double.parseDouble(StringUtil.Null2Zero(wuchazhi))
									/ Double.parseDouble(peibi) * 100));
						} else {
							bci.setWuchalv("0.00");
						}
						break;
					default:
						break;
					}

					bciList.add(bci);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bciList;
	}

	/**
	 * 获取设备列表
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "getShebeiList")
	public void getShebeiList(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj = new JSONObject();
		try {
			request.setCharacterEncoding("UTF-8");
			String departId = request.getParameter("userGroupId");// 所属机构编号
			Integer userlft = null;
			Integer userrgt = null;
			if (StringUtil.Null2Blank(departId).length() > 0) {
				TSDepart dpt = systemService.getEntity(TSDepart.class, departId);
				userlft = dpt.getLft();
				userrgt = dpt.getRgt();
			}
			List<ShebeiListBean> shebeiList = infService.getShebeilist(userlft, userrgt);
			if (shebeiList.size() > 0) {
				returnJsonObj.put("data", shebeiList);
				returnJsonObj.put("success", true);
			} else {
				returnJsonObj.put("data", "[]");
				returnJsonObj.put("success", false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("获取设备列表失败！");
			returnJsonObj.put("data", "[]");
			returnJsonObj.put("success", false);
		}
		responseOutWrite(response, returnJsonObj);
	}

	/**
	 * 混凝土主页logo
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "hntMainLogo")
	public void hntMainLogo(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj = new JSONObject();
		try {
			String departId = request.getParameter("userGroupId");// 所属机构编号
			Integer userlft = null;
			Integer userrgt = null;
			if (StringUtil.Null2Blank(departId).length() > 0) {
				TSDepart dpt = systemService.getEntity(TSDepart.class, departId);
				userlft = dpt.getLft();
				userrgt = dpt.getRgt();
			}
			HntMainLogoBean hntMain = infService.hntMainLogo(userlft, userrgt);
			if (hntMain != null) {
				returnJsonObj.put("data", hntMain);
				returnJsonObj.put("success", true);
			} else {
				returnJsonObj.put("data", "[]");
				returnJsonObj.put("success", false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("获取设备列表失败！");
			returnJsonObj.put("data", "[]");
			returnJsonObj.put("success", false);
		}
		responseOutWrite(response, returnJsonObj);
	}

	/**
	 * 混凝土拌合站主页数据 (NEW)
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "hntBhzMainLogo")
	public void hntBhzMainLogo(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj = new JSONObject();
		try {
			String departId = request.getParameter("userGroupId");// 所属机构编号
			Integer userlft = null;
			Integer userrgt = null;
			if (StringUtil.Null2Blank(departId).length() > 0) {
				TSDepart dpt = systemService.getEntity(TSDepart.class, departId);
				userlft = dpt.getLft();
				userrgt = dpt.getRgt();
			}
			AppHntHomePageData hntMain = infService.hntBhzMainLogo(userlft, userrgt);
			if (hntMain != null) {
				returnJsonObj.put("data", hntMain);
				returnJsonObj.put("success", true);
			} else {
				returnJsonObj.put("data", "[]");
				returnJsonObj.put("success", false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("获取拌合站主页数据失败！");
			returnJsonObj.put("data", "[]");
			returnJsonObj.put("success", false);
		}
		responseOutWrite(response, returnJsonObj);
	}

	/**
	 * 拌和站统计分析
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "hntCountAnalyze")
	public void hntCountAnalyze(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj = new JSONObject();
		try {
			String departId = request.getParameter("userGroupId");// 所属机构编号
			String startTime = request.getParameter("startTime");// 开始时间
			String endTime = request.getParameter("endTime");// 结束时间(时间戳)
			String shebeibianhao = request.getParameter("shebeibianhao");
			String cllx = request.getParameter("cllx");
			Integer userlft = null;
			Integer userrgt = null;
			if (StringUtil.Null2Blank(departId).length() > 0) {
				TSDepart dpt = systemService.getEntity(TSDepart.class, departId);
				userlft = dpt.getLft();
				userrgt = dpt.getRgt();
			}
			if (null == startTime && null == endTime) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar day = Calendar.getInstance();
				endTime = sdf.format(day.getTime());
				day.add(Calendar.MONTH, -3);
				startTime = sdf.format(day.getTime());
			} else {
				startTime = GetDate.TimetmpConvetDateTime(request.getParameter("startTime"));// 出料时间
				endTime = GetDate.TimetmpConvetDateTime(request.getParameter("endTime"));// 出料时间
			}
			if (StringUtil.Null2Blank(request.getParameter("cllx")).length() > 0) {
				cllx = request.getParameter("cllx");
			} else {
				cllx = "1";
			}
			List<HntCountAnalyze> hntCount = infService.HntCountAnalyze(userlft, userrgt, startTime, endTime,
					shebeibianhao, Integer.parseInt(cllx));
			if (hntCount != null) {
				returnJsonObj.put("data", hntCount);
				returnJsonObj.put("success", true);
			} else {
				returnJsonObj.put("data", "[]");
				returnJsonObj.put("success", false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("获取设备列表失败！");
			returnJsonObj.put("data", "[]");
			returnJsonObj.put("success", false);
		}
		responseOutWrite(response, returnJsonObj);
	}
	
}
