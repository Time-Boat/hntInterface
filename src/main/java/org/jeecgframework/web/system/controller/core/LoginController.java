package org.jeecgframework.web.system.controller.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.jeecgframework.web.system.manager.ClientManager;
import org.jeecgframework.web.system.pojo.base.Client;
import org.jeecgframework.web.system.pojo.base.TSConfig;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSFunction;
import org.jeecgframework.web.system.pojo.base.TSRole;
import org.jeecgframework.web.system.pojo.base.TSRoleFunction;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.extend.datasource.DataSourceContextHolder;
import org.jeecgframework.core.extend.datasource.DataSourceType;
import org.jeecgframework.core.util.ContextHolderUtils;
import org.jeecgframework.core.util.IpUtil;
import org.jeecgframework.core.util.NumberComparator;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fr.general.FArray;
import com.fr.privilege.Authority;
import com.fr.stable.Constants;
import com.shtoone.qms.entity.bhz.TophunnintuViewEntity;
import com.shtoone.qms.entity.bhz.TophunnintusyViewEntity;
import com.shtoone.qms.entity.bhz.TopsysViewEntity;
import com.shtoone.qms.service.bhz.TophunnintuViewServiceI;

/**
 * 登陆初始化控制器
 * @author 张代浩
 * 
 */
@Controller
@RequestMapping("/loginController")
public class LoginController  extends BaseController{
	
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private TophunnintuViewServiceI tophntService;
	
	@Autowired
	private UserService userService;
	
	private String message = null;
	private Map<Integer, List<TSFunction>> shortcutFunctionMap = null;
	
	@RequestMapping(params = "goPwdInit")
	public String goPwdInit() {
		return "login/pwd_init";
	}

	/**
	 * admin账户密码初始化
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "pwdInit")
	public ModelAndView pwdInit(HttpServletRequest request) {
		ModelAndView modelAndView = null;
		TSUser user = new TSUser();
		user.setUserName("admin");
		String newPwd = "123456";
		userService.pwdInit(user, newPwd);
		modelAndView = new ModelAndView(new RedirectView("loginController.do?login"));
		return modelAndView;
	}

	/**
	 * 检查用户名称
	 * 
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "checkuser")
	@ResponseBody
	public AjaxJson checkuser(TSUser user, HttpServletRequest req) {
		HttpSession session = ContextHolderUtils.getSession();
		DataSourceContextHolder.setDataSourceType(DataSourceType.dataSource_jeecg);
		AjaxJson j = new AjaxJson();
		int users = userService.getList(TSUser.class).size();
		if (users == 0) {
			j.setMsg("a");
			j.setSuccess(false);
		} else {
			TSUser u = userService.checkUserExits(user);
			if (u != null) {
				// if (user.getUserKey().equals(u.getUserKey())) {
				if (true) {
					message = "用户: " + user.getUserName() + "["+ u.getTSDepart().getDepartname() + "]" + "登录成功";
					Client client = new Client();
					client.setIp(IpUtil.getIpAddr(req));
					client.setLogindatetime(new Date());
					client.setUser(u);
					ClientManager.getInstance().addClinet(session.getId(),client);
					// 添加登陆日志
					systemService.addLog(message, Globals.Log_Type_LOGIN,Globals.Log_Leavel_INFO);

				} else {
					j.setMsg("请检查U盾是否正确");
					j.setSuccess(false);
				}
			} else {
				j.setMsg("用户名或密码错误!");
				j.setSuccess(false);
			}
		}
		return j;
	}
	
	@RequestMapping(params = "comelogin")
	public String comelogin(@RequestParam("userid") String userid,  @RequestParam("timestamp") String timestamp,  
	        @RequestParam("pwd") String pwd, HttpServletRequest request) {
		if (StringUtil.isNotEmpty(userid) && StringUtil.isNotEmpty(timestamp) && StringUtil.isNotEmpty(pwd) 
			&& pwd.equalsIgnoreCase(com.shtoone.qms.util.StringUtil.getMD5(userid+"_"+timestamp+"_gzgs"))){
			DataSourceContextHolder.setDataSourceType(DataSourceType.dataSource_jeecg);
			TSUser user = userService.getUserByid(userid);
			String roles = "";
			if (user != null) {
				HttpSession session = request.getSession();
				com.fr.privilege.authentication.FreeAuthentication authentication;
				authentication = new com.fr.privilege.authentication.FreeAuthentication();
				List<TSRoleUser> rUsers = systemService.findByProperty(TSRoleUser.class, "TSUser.id", user.getId());
				if (rUsers.size()>0) {
					String [] s = new String[rUsers.size()];
					Authority[] as = new Authority[rUsers.size()];
					int i = 0;
					for (TSRoleUser ru : rUsers) {
						TSRole role = ru.getTSRole();
						s[i] = role.getRoleName();
						as[i] = new Authority(role.getRoleName());
						i++;
						roles += role.getRoleName() + ",";
					}
					authentication.setAuthorities(as);
					FArray fa = new FArray(s);
					//报表fr_authority
					session.setAttribute(Constants.P.PRIVILEGE_AUTHORITY, fa);
				}
				authentication.setAuthenticated(true);	
				session.setAttribute(Constants.P.PRIVILEGE_AUTHENCATION_KEY, authentication);
				//报表fr_username
				session.setAttribute(Constants.P.PRIVILEGE_USERNAME, user.getUserName());      
				if (roles.length() > 0) {
					roles = roles.substring(0, roles.length() - 1);
				}
				request.setAttribute("roleName", roles);
				request.setAttribute("userName", user.getUserName());
				int userlft = user.getTSDepart().getLft();
				int userrgt = user.getTSDepart().getRgt();
				String userdepartid = user.getTSDepart().getId();
				session.setAttribute("userlft", userlft);
				session.setAttribute("userrgt", userrgt);			
				session.setAttribute("userdepartid", userdepartid);
				session.setAttribute("fullname", user.getRealName());
				session.setAttribute("CKFinder_UserRole", "admin");
				//获取一级菜单列表
				request.setAttribute("primaryMenuList", getPrimaryMenu(rUsers));
				// 默认风格
				String indexStyle = "";
				/***
			 	Cookie[] cookies = request.getCookies();
				for (Cookie cookie : cookies) {
					if (cookie == null || StringUtils.isEmpty(cookie.getName())) {
						continue;
					}
					if (cookie.getName().equalsIgnoreCase("JEECGINDEXSTYLE")) {
						indexStyle = cookie.getValue();
					}
				}
				*/
				message = "用户: " + user.getUserName() + "["+ user.getTSDepart().getDepartname() + "]" + "登录成功";
				Client client = new Client();
				client.setIp(IpUtil.getIpAddr(request));
				client.setLogindatetime(new Date());
				client.setUser(user);
				ClientManager.getInstance().addClinet(session.getId(),client);
				// 添加登陆日志
				systemService.addLog(message, Globals.Log_Type_LOGIN,Globals.Log_Leavel_INFO);
				// 要添加自己的风格，复制下面三行即可
				if (StringUtils.isNotEmpty(indexStyle) && indexStyle.equalsIgnoreCase("bootstrap")) {
					return "main/bootstrap_main";
				}
				if (StringUtils.isNotEmpty(indexStyle) && indexStyle.equalsIgnoreCase("shortcut")) {
					return "main/shortcut_main";
				}
				return "main/main";
			} else {
				request.setAttribute("error", "true");
				return "login/login";
			} 
		}else {
			request.setAttribute("error", "true");
			return "login/login";
		}
	}
	
	@RequestMapping(params = "commonlogin")
	public String commonlogin(TSUser clientuser, HttpServletRequest request) {
		DataSourceContextHolder
				.setDataSourceType(DataSourceType.dataSource_jeecg);
		AjaxJson j = checkuser(clientuser, request);
		TSUser user = ResourceUtil.getSessionUserName();
		String roles = "";
		if (user != null) {
			HttpSession session = request.getSession();
			com.fr.privilege.authentication.FreeAuthentication authentication;
			authentication = new com.fr.privilege.authentication.FreeAuthentication();
			List<TSRoleUser> rUsers = systemService.findByProperty(TSRoleUser.class, "TSUser.id", user.getId());
			if (rUsers.size()>0) {
			  String [] s = new String[rUsers.size()];
			  Authority[] as = new Authority[rUsers.size()];
			  int i = 0;
			  for (TSRoleUser ru : rUsers) {
				  TSRole role = ru.getTSRole();
				  s[i] = role.getRoleName();
				  as[i] = new Authority(role.getRoleName());
				  i++;
				  roles += role.getRoleName() + ",";
			  }
			  authentication.setAuthorities(as);
			  
			  FArray fa = new FArray(s);
			  //报表fr_authority
		      session.setAttribute(Constants.P.PRIVILEGE_AUTHORITY, fa);
			}
			
			
			authentication.setAuthenticated(true);	
	
			session.setAttribute(Constants.P.PRIVILEGE_AUTHENCATION_KEY, authentication);
			//报表fr_username
			session.setAttribute(Constants.P.PRIVILEGE_USERNAME, user.getUserName());      
			
			if (roles.length() > 0) {
				roles = roles.substring(0, roles.length() - 1);
			}
			request.setAttribute("roleName", roles);
			request.setAttribute("userName", user.getUserName());
			int userlft = user.getTSDepart().getLft();
			int userrgt = user.getTSDepart().getRgt();
			String userdepartid = user.getTSDepart().getId();
			session.setAttribute("userlft", userlft);
			session.setAttribute("userrgt", userrgt);			
			session.setAttribute("userdepartid", userdepartid);
			session.setAttribute("fullname", user.getRealName());
			session.setAttribute("CKFinder_UserRole", "admin");
			//获取一级菜单列表
			request.setAttribute("primaryMenuList", getPrimaryMenu(rUsers));
			// 默认风格
			String indexStyle = "";
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if (cookie == null || StringUtils.isEmpty(cookie.getName())) {
					continue;
				}
				if (cookie.getName().equalsIgnoreCase("JEECGINDEXSTYLE")) {
					indexStyle = cookie.getValue();
				}
			}
			// 要添加自己的风格，复制下面三行即可
			if (StringUtils.isNotEmpty(indexStyle)
					&& indexStyle.equalsIgnoreCase("bootstrap")) {
				return "main/bootstrap_main";
			}
			if (StringUtils.isNotEmpty(indexStyle)
					&& indexStyle.equalsIgnoreCase("shortcut")) {
				return "main/shortcut_main";
			}
			
			return "main/main";
		} else {
			request.setAttribute("error", "true");
			return "login/login";
		}

	}

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "login")
	public String login(HttpServletRequest request) {
		DataSourceContextHolder.setDataSourceType(DataSourceType.dataSource_jeecg);
		TSUser user = ResourceUtil.getSessionUserName();
		String roles = "";
		if (user != null) {
			HttpSession session = request.getSession();
			com.fr.privilege.authentication.FreeAuthentication authentication;
			authentication = new com.fr.privilege.authentication.FreeAuthentication();
			List<TSRoleUser> rUsers = systemService.findByProperty(TSRoleUser.class, "TSUser.id", user.getId());
			if (rUsers.size()>0) {
			  String [] s = new String[rUsers.size()];
			  Authority[] as = new Authority[rUsers.size()];
			  int i = 0;
			  for (TSRoleUser ru : rUsers) {
				  TSRole role = ru.getTSRole();
				  s[i] = role.getRoleName();
				  as[i] = new Authority(role.getRoleName());
				  i++;
				  roles += role.getRoleName() + ",";
			  }
			  authentication.setAuthorities(as);
			  FArray fa = new FArray(s);
			  //报表fr_authority
		      session.setAttribute(Constants.P.PRIVILEGE_AUTHORITY, fa);
			}
			authentication.setAuthenticated(true);	
			session.setAttribute(Constants.P.PRIVILEGE_AUTHENCATION_KEY, authentication);
			//报表fr_username
			session.setAttribute(Constants.P.PRIVILEGE_USERNAME, user.getUserName());      
			if (roles.length() > 0) {
				roles = roles.substring(0, roles.length() - 1);
			}
			request.setAttribute("roleName", roles);
			request.setAttribute("userName", user.getUserName());
			int userlft = user.getTSDepart().getLft();
			int userrgt = user.getTSDepart().getRgt();
			String userdepartid = user.getTSDepart().getId();
			session.setAttribute("userlft", userlft);
			session.setAttribute("userrgt", userrgt);			
			session.setAttribute("userdepartid", userdepartid);
			session.setAttribute("fullname", user.getRealName());
			session.setAttribute("CKFinder_UserRole", "admin");
			//获取一级菜单列表
			request.setAttribute("primaryMenuList", getPrimaryMenu(rUsers));
			// 默认风格
			String indexStyle = "";
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if (cookie == null || StringUtils.isEmpty(cookie.getName())) {
					continue;
				}
				if (cookie.getName().equalsIgnoreCase("JEECGINDEXSTYLE")) {
					indexStyle = cookie.getValue();
				}
			}
			// 要添加自己的风格，复制下面三行即可
			if (StringUtils.isNotEmpty(indexStyle) && indexStyle.equalsIgnoreCase("bootstrap")) {
				return "main/bootstrap_main";
			}
			if (StringUtils.isNotEmpty(indexStyle) && indexStyle.equalsIgnoreCase("shortcut")) {
				return "main/shortcut_main";
			}
			return "main/main";
		} else {
			return "login/login";
		}

	}

	/**
	 * 退出系统
	 * 
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "logout")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = ContextHolderUtils.getSession();
		TSUser user = ResourceUtil.getSessionUserName();
		shortcutFunctionMap = null;
		
		systemService.addLog("用户" + user.getUserName() + "已退出",
				Globals.Log_Type_EXIT, Globals.Log_Leavel_INFO);
		ClientManager.getInstance().removeClinet(session.getId());
		ModelAndView modelAndView = new ModelAndView(new RedirectView(
				"loginController.do?login"));
		
		return modelAndView;
	}

	/**
	 * 菜单跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "left")
	public ModelAndView left(HttpServletRequest request) {
		TSUser user = ResourceUtil.getSessionUserName();
		HttpSession session = ContextHolderUtils.getSession();
		// 登陆者的权限
		if (user.getId() == null) {
			session.removeAttribute(Globals.USER_SESSION);
			return new ModelAndView(
					new RedirectView("loginController.do?login"));
		}

		request.setAttribute("menuMap", getFunctionMap(user));
		List<TSConfig> configs = userService.loadAll(TSConfig.class);
		for (TSConfig tsConfig : configs) {
			request.setAttribute(tsConfig.getCode(), tsConfig.getContents());
		}
		return new ModelAndView("main/left");
	}

	/**
	 * 获取权限的map
	 * 
	 * @param user
	 * @return
	 */
	private Map<Integer, List<TSFunction>> getFunctionMap(TSUser user) {
		Map<Integer, List<TSFunction>> functionMap = new HashMap<Integer, List<TSFunction>>();
		Map<String, TSFunction> loginActionlist = getUserFunction(user);
		if (loginActionlist.size() > 0) {
			Collection<TSFunction> allFunctions = loginActionlist.values();
			for (TSFunction function : allFunctions) {
				if (!functionMap.containsKey(function.getFunctionLevel() + 0)) {
					functionMap.put(function.getFunctionLevel() + 0,
							new ArrayList<TSFunction>());
				}
				functionMap.get(function.getFunctionLevel() + 0).add(function);
			}
			// 菜单栏排序
			Collection<List<TSFunction>> c = functionMap.values();
			for (List<TSFunction> list : c) {
				Collections.sort(list, new NumberComparator());
			}
		}
		return functionMap;
	}

	/**
	 * 获取用户菜单列表
	 * 
	 * @param user
	 * @return
	 */
	private Map<String, TSFunction> getUserFunction(TSUser user) {
		HttpSession session = ContextHolderUtils.getSession();
		Client client = ClientManager.getInstance().getClient(session.getId());
		if (client.getFunctions() == null) {
			Map<String, TSFunction> loginActionlist = new HashMap<String, TSFunction>();
			List<TSRoleUser> rUsers = systemService.findByProperty(
					TSRoleUser.class, "TSUser.id", user.getId());
			for (TSRoleUser ru : rUsers) {
				TSRole role = ru.getTSRole();
				List<TSRoleFunction> roleFunctionList = systemService
						.findByProperty(TSRoleFunction.class, "TSRole.id",
								role.getId());
				for (TSRoleFunction roleFunction : roleFunctionList) {
					TSFunction function = roleFunction.getTSFunction();
					loginActionlist.put(function.getId(), function);
				}
			}
			client.setFunctions(loginActionlist);
		}
		return client.getFunctions();
	}

	/**
	 * 首页跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "home")
	public ModelAndView home(HttpServletRequest request) {
		List<TophunnintusyViewEntity> tophntlist=new ArrayList<TophunnintusyViewEntity>();
		List<TophunnintuViewEntity> tophntvlist=new ArrayList<TophunnintuViewEntity>();
		List<TopsysViewEntity> topsyslist=new ArrayList<TopsysViewEntity>();
		String pid=request.getParameter("pid");
		TSDepart dpt;//上级部门
		Integer userlft = 0;
		Integer userrgt =0;
		if(pid!=null&&pid.length()>0){
		 dpt=systemService.getEntity(TSDepart.class, pid);
			userlft=dpt.getLft();
			userrgt=dpt.getRgt(); 
		}else{
			HttpSession session = request.getSession();
			userlft = Integer.parseInt( session.getAttribute("userlft").toString());
		 	userrgt = Integer.parseInt(session.getAttribute("userrgt").toString());
		}
		tophntlist=tophntService.getDatagrid4(String.valueOf(userlft), String.valueOf(userrgt));
		tophntvlist=tophntService.getDatagrid5(String.valueOf(userlft), String.valueOf(userrgt));
		
		topsyslist=tophntService.getDatagrid6(String.valueOf(userlft), String.valueOf(userrgt));
		
		String Str="" ;
		String Str1="" ;
		for(int i=0;i<tophntlist.size();i++){
			Str+="拌和站名称："+tophntlist.get(i).getDepartname()+","+tophntlist.get(i).getLng()+","+tophntlist.get(i).getLat()
					+","+tophntlist.get(i).getType()+",站长:"+tophntlist.get(i).getZhanzhang()+","+tophntlist.get(i).getShebeimianji()
					+","+tophntlist.get(i).getShuliang()+"台拌和机,"+tophntlist.get(i).getDepartid()+",";
			int h=0;
			Str1=tophntlist.get(0).getLng()+","+tophntlist.get(0).getLat();
			for(int j=0;j<tophntvlist.size();j++){
				if(tophntlist.get(i).getId().equals(tophntvlist.get(j).getDepartid())){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        	Calendar day=Calendar.getInstance(); 
		        	Date baocun;     	
					try {				
						baocun = sdf.parse(tophntvlist.get(j).getChuliaoshijian());
			        	day.add(Calendar.DATE, -1);
			        	if (baocun.after(day.getTime())) {
			        		Str+="生产#";
			        		h=1;
			        	}else{
			        		Str+="未生产#";
			        	}
					} catch (ParseException e) {
					}
					Str+=tophntvlist.get(j).getChuliaoshijian()+"#"+tophntvlist.get(j).getBanhezhanminchen()+"#"+"~";
				}
			}
			Str+=","+h;
			Str+="|";
		}
		for(int i=0;i<topsyslist.size();i++){
			Str+="试验室名称："+topsyslist.get(i).getF_TRNAME()+","+topsyslist.get(i).getLongitude()+","+topsyslist.get(i).getLatitude()
					+",3,主任:"+topsyslist.get(i).getZhuren()+","+topsyslist.get(i).getMianji()
					+","+topsyslist.get(i).getShuliang()+"座试验室,"+topsyslist.get(i).getShiyanshi_guid()+",";
			int h=0;
			if(Str1.equals("")){
				Str1=topsyslist.get(0).getLongitude()+","+topsyslist.get(0).getLatitude();
			}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        	Calendar day=Calendar.getInstance(); 
		        	Date baocun;     	
					try {				
						baocun = sdf.parse(topsyslist.get(i).getReportDate());
			        	day.add(Calendar.DATE, -1);
			        	if (baocun.after(day.getTime())) {
			        		Str+="生产#";
			        		h=1;
			        	}else{
			        		Str+="未生产#";
			        	}
					} catch (ParseException e) {
					}
			Str+=","+h;
			Str+="|";
		}
		
		if(Str1.equals("")){
			Str1="121,12";
		}
		request.setAttribute("toplist", Str);
		request.setAttribute("toplist1", Str1);
		return new ModelAndView("main/home");
	}
	
	
	
	@RequestMapping(params = "home1")
	public void home1(HttpServletRequest request,HttpServletResponse response, DataGrid dataGrid) {
		List<TophunnintusyViewEntity> tophntlist=new ArrayList<TophunnintusyViewEntity>();
		List<TophunnintuViewEntity> tophntvlist=new ArrayList<TophunnintuViewEntity>();
		List<TopsysViewEntity> topsyslist=new ArrayList<TopsysViewEntity>();
//		TophunnintuViewEntity tophnt=new TophunnintuViewEntity();
		String pid=request.getParameter("pid");
		TSDepart dpt;//上级部门
		Integer userlft = 0;
		Integer userrgt =0;
		if(pid!=null&&pid.length()>0){
		 dpt=systemService.getEntity(TSDepart.class, pid);
			userlft=dpt.getLft();
			userrgt=dpt.getRgt(); 
		}else{
			HttpSession session = request.getSession();
			userlft = Integer.parseInt( session.getAttribute("userlft").toString());
		 	userrgt = Integer.parseInt(session.getAttribute("userrgt").toString());
		}
		tophntlist=tophntService.getDatagrid4(String.valueOf(userlft), String.valueOf(userrgt));
		tophntvlist=tophntService.getDatagrid5(String.valueOf(userlft), String.valueOf(userrgt));
		
		topsyslist=tophntService.getDatagrid6(String.valueOf(userlft), String.valueOf(userrgt));
		
		String Str="" ;
		String Str1="" ;
		for(int i=0;i<tophntlist.size();i++){
			Str+="拌和站名称："+tophntlist.get(i).getDepartname()+","+tophntlist.get(i).getLng()+","+tophntlist.get(i).getLat()
					+","+tophntlist.get(i).getType()+",站长:"+tophntlist.get(i).getZhanzhang()+","+tophntlist.get(i).getShebeimianji()
					+","+tophntlist.get(i).getShuliang()+"台拌和机,"+tophntlist.get(i).getDepartid()+",";
			int h=0;
			Str1=tophntlist.get(0).getLng()+","+tophntlist.get(0).getLat();
			for(int j=0;j<tophntvlist.size();j++){
				if(tophntlist.get(i).getId().equals(tophntvlist.get(j).getDepartid())){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        	Calendar day=Calendar.getInstance(); 
		        	Date baocun;     	
					try {				
						baocun = sdf.parse(tophntvlist.get(j).getChuliaoshijian());
			        	day.add(Calendar.DATE, -1);
			        	if (baocun.after(day.getTime())) {
			        		Str+="生产#";
			        		h=1;
			        	}else{
			        		Str+="未生产#";
			        	}
					} catch (ParseException e) {
					}
					Str+=tophntvlist.get(j).getChuliaoshijian()+"#"+tophntvlist.get(j).getBanhezhanminchen()+"#"+"~";
				}
			}
			Str+=","+h;
			Str+="|";
		}
		
		for(int i=0;i<topsyslist.size();i++){
			Str+="试验室名称："+topsyslist.get(i).getF_TRNAME()+","+topsyslist.get(i).getLongitude()+","+topsyslist.get(i).getLatitude()
					+",3,主任:"+topsyslist.get(i).getZhuren()+","+topsyslist.get(i).getMianji()
					+","+topsyslist.get(i).getShuliang()+"座试验室,,"+topsyslist.get(i).getShiyanshi_guid()+",";
			int h=0;
			if(Str1.equals("")){
				Str1=topsyslist.get(0).getLongitude()+","+topsyslist.get(0).getLatitude();
			}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        	Calendar day=Calendar.getInstance(); 
		        	Date baocun;     	
					try {				
						baocun = sdf.parse(topsyslist.get(i).getReportDate());
			        	day.add(Calendar.DATE, -1);
			        	if (baocun.after(day.getTime())) {
			        		Str+="生产#";
			        		h=1;
			        	}else{
			        		Str+="未生产#";
			        	}
					} catch (ParseException e) {
					}
			Str+=","+h;
			Str+="|";
		}
		if(Str1.equals("")){
			Str1="113,23";
		}
		JSONObject jobject=new JSONObject(); 
		jobject.put("toplist",Str);
		jobject.put("toplist1",Str1);
		responseDatagrid(response, jobject);
	}
	/**
	 * 无权限页面提示跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "noAuth")
	public ModelAndView noAuth(HttpServletRequest request) {
		return new ModelAndView("common/noAuth");
	}
	/**
	 * @Title: top
	 * @Description: bootstrap头部菜单请求
	 * @param request
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(params = "top")
	public ModelAndView top(HttpServletRequest request) {
		TSUser user = ResourceUtil.getSessionUserName();
		HttpSession session = ContextHolderUtils.getSession();
		// 登陆者的权限
		if (user.getId() == null) {
			session.removeAttribute(Globals.USER_SESSION);
			return new ModelAndView(
					new RedirectView("loginController.do?login"));
		}
		request.setAttribute("menuMap", getFunctionMap(user));
		List<TSConfig> configs = userService.loadAll(TSConfig.class);
		for (TSConfig tsConfig : configs) {
			request.setAttribute(tsConfig.getCode(), tsConfig.getContents());
		}
		return new ModelAndView("main/bootstrap_top");
	}
	/**
	 * @Title: top
	 * @author gaofeng
	 * @Description: shortcut头部菜单请求
	 * @param request
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(params = "shortcut_top")
	public ModelAndView shortcut_top(HttpServletRequest request) {
		TSUser user = ResourceUtil.getSessionUserName();
		HttpSession session = ContextHolderUtils.getSession();
		// 登陆者的权限
		if (user.getId() == null) {
			session.removeAttribute(Globals.USER_SESSION);
			return new ModelAndView(
					new RedirectView("loginController.do?login"));
		}
		request.setAttribute("menuMap", getFunctionMap(user));
		List<TSConfig> configs = userService.loadAll(TSConfig.class);
		for (TSConfig tsConfig : configs) {
			request.setAttribute(tsConfig.getCode(), tsConfig.getContents());
		}
		return new ModelAndView("main/shortcut_top");
	}
	
	/**
	 * @Title: top
	 * @author:gaofeng
	 * @Description: shortcut头部菜单一级菜单列表，并将其用ajax传到页面，实现动态控制一级菜单列表
	 * @param request
	 * @return AjaxJson
	 * @throws
	 */
	public String getPrimaryMenu(List<TSRoleUser> rUsers) {
		
		//获取一级菜单列表
		Map<Integer, List<TSFunction>> functionMap = new HashMap<Integer, List<TSFunction>>();
		if(shortcutFunctionMap != null){

			//将更新前的菜单数据传过来
			functionMap = shortcutFunctionMap;
		}else{
			functionMap = getPrimaryMenuBase(rUsers);
		}
		
		String floor = "";
		List<TSFunction> primaryMenu = null;
		Iterator<Entry<Integer, List<TSFunction>>> it = functionMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			primaryMenu = (List<TSFunction>) pairs.getValue();

			for (TSFunction function : primaryMenu) {
//				org.jeecgframework.core.util.LogUtil.info(function.getFunctionName());
//				org.jeecgframework.core.util.LogUtil.info(function.getFunctionLevel());
				if(function.getFunctionLevel() == 0){

					if("Online 开发".equals(function.getFunctionName())){

						floor += " <li><img class='imag1' src='plug-in/login/images/online.png' /> " 
								+ " <img class='imag2' src='plug-in/login/images/online_up.png' style='display: none;' />" + " </li> ";
					}else if("统计分析".equals(function.getFunctionName())){

						floor += " <li><img class='imag1' src='plug-in/login/images/tongji.png' /> " 
								+ " <img class='imag2' src='plug-in/login/images/tongji_up.png' style='display: none;' />" + " </li> ";
					}else if("系统管理".equals(function.getFunctionName())){

						floor += " <li><img class='imag1' src='plug-in/login/images/xtgl.png' /> " 
								+ " <img class='imag2' src='plug-in/login/images/xtgl_up.png' style='display: none;' />" + " </li> ";
					}else if("常用示例".equals(function.getFunctionName())){

						floor += " <li><img class='imag1' src='plug-in/login/images/cysl.png' /> " 
								+ " <img class='imag2' src='plug-in/login/images/cysl_up.png' style='display: none;' />" + " </li> ";
					}else if("系统监控".equals(function.getFunctionName())){

						floor += " <li><img class='imag1' src='plug-in/login/images/xtjk.png' /> " 
								+ " <img class='imag2' src='plug-in/login/images/xtjk_up.png' style='display: none;' />" + " </li> ";
					}else if("数据采集".equals(function.getFunctionName())){

						floor += " <li><img class='imag1' src='plug-in/login/images/caiji.png' /> " 
								+ " <img class='imag2' src='plug-in/login/images/caiji_up.png' style='display: none;' />" + " </li> ";
					}else if("人员设备".equals(function.getFunctionName())){

						floor += " <li><img class='imag1' src='plug-in/login/images/renyuan.png' /> " 
								+ " <img class='imag2' src='plug-in/login/images/renyuan_up.png' style='display: none;' />" + " </li> ";
					}else{
						//其他的为默认通用的图片模式
						String s = "";
						if(function.getFunctionName().length()>=5 && function.getFunctionName().length()<7){
							s = "<div style='width:67px;position: absolute;top:40px;text-align:center;color:#909090;font-size:12px;'><span style='letter-spacing:-1px;'>"+ function.getFunctionName() +"</span></div>";
						}else if(function.getFunctionName().length()<5){
							s = "<div style='width:67px;position: absolute;top:40px;text-align:center;color:#909090;font-size:12px;'>"+ function.getFunctionName() +"</div>";
						}else if(function.getFunctionName().length()>=7){
							s = "<div style='width:67px;position: absolute;top:40px;text-align:center;color:#909090;font-size:12px;'><span style='letter-spacing:-1px;'>"+ function.getFunctionName().substring(0, 6) +"</span></div>";
						}
						floor += " <li style='position: relative;'><img class='imag1' src='plug-in/login/images/default.png' /> " 
								+ " <img class='imag2' src='plug-in/login/images/default_up.png' style='display: none;' />"
								+ s +"</li> ";
					}
				}
			}
		}
		
		return floor;
	}
	/**
	 * @Title: top
	 * @author:gaofeng
	 * @Description: shortcut头部菜单一级菜单列表，实现动态控制一级菜单列表的基础方法
	 * @param request
	 * @return AjaxJson
	 * @throws
	 */
	public Map<Integer, List<TSFunction>> getPrimaryMenuBase(List<TSRoleUser> rUsers) {
		
		//获取一级菜单列表
		Map<Integer, List<TSFunction>> functionMap = new HashMap<Integer, List<TSFunction>>();
		Map<String, TSFunction> loginActionlist = new HashMap<String, TSFunction>();
		for (TSRoleUser ru : rUsers) {
			TSRole role = ru.getTSRole();
			List<TSRoleFunction> roleFunctionList = systemService
					.findByProperty(TSRoleFunction.class, "TSRole.id",
							role.getId());
			for (TSRoleFunction roleFunction : roleFunctionList) {
				TSFunction function = roleFunction.getTSFunction();
				loginActionlist.put(function.getId(), function);
			}
		}
		
		if (loginActionlist.size() > 0) {
			Collection<TSFunction> allFunctions = loginActionlist.values();
			for (TSFunction function : allFunctions) {
				if (!functionMap.containsKey(function.getFunctionLevel() + 0)) {
					functionMap.put(function.getFunctionLevel() + 0,
							new ArrayList<TSFunction>());
				}
				functionMap.get(function.getFunctionLevel() + 0).add(function);
			}
			// 菜单栏排序
			Collection<List<TSFunction>> c = functionMap.values();
			for (List<TSFunction> list : c) {
				Collections.sort(list, new NumberComparator());
			}
		}
		//将更新前的菜单数据赋值过去
		shortcutFunctionMap = functionMap;
		return functionMap;
	}
	
	 
}
