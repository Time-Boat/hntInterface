package com.shtoone.qms.controller;

import java.io.ByteArrayInputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ContextHolderUtils;
import org.jeecgframework.core.util.IpUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.manager.ClientManager;
import org.jeecgframework.web.system.pojo.base.Client;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shtoone.qms.service.DatasubmitService;


/**
 * 在线服务类
 * 
 * @author 
 * 
 */
@Controller
public class ServiceController {
	
	private UserService userService;
	private SystemService systemService;
	private DatasubmitService datasuber;	

	@Autowired
	public void setDatasuber(DatasubmitService datasuber) {
		this.datasuber = datasuber;
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	
    @RequestMapping("/online")
	public String online(@RequestParam("username") String name,HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/xml;charset=gbk");  
        response.setHeader("Cache-Control", "no-cache");
        //System.out.println(request.getSession().getAttribute("fr_authority"));
        //System.out.println(request.getSession().getAttribute("fr_username"));
        //request.getSession().getAttribute(Constants.P.PRIVILEGE_AUTHENCATION_KEY);
        PrintWriter out;
        try {
        	if (StringUtil.isEmpty(name,"").equalsIgnoreCase("shtoone")) {
        		out = response.getWriter();
	            out.print(1);
	            out.close();
        	}
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
		return null;
	} 
    
    @RequestMapping("/clientlogin")
	public String clientlogin(@RequestParam("username") String name,  @RequestParam("useraccount") String useraccount,  
	        @RequestParam("pwd") String pwd,HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/xml;charset=gbk");  
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out;
        try {
        	if (StringUtil.isEmpty(name,"").equalsIgnoreCase("shtoone")) {
        		useraccount = new String(com.shtoone.qms.util.StringUtil.getFromBASE64(useraccount),  "utf-8");
        		TSUser clientuser = new TSUser();
        		clientuser.setUserName(useraccount);
        		clientuser.setPassword(pwd);
        		TSUser u = userService.checkUserExits(clientuser);
        		HttpSession session = ContextHolderUtils.getSession();
        		if (u != null) {
    					String message = "用户: " + clientuser.getUserName() + "["
    							+ u.getTSDepart().getDepartname() + "]" + "从客户端登录";
    					Client client = new Client();
    					client.setIp(IpUtil.getIpAddr(request));
    					client.setLogindatetime(new Date());
    					client.setUser(u);
    					ClientManager.getInstance().addClinet(session.getId(),
    							client);
    					// 添加登陆日志
    					systemService.addLog(message, Globals.Log_Type_LOGIN,
    							Globals.Log_Leavel_INFO);
    					out = response.getWriter();
    		            out.print(8);
    		            out.close();
        		} 
        	}
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
		return null;
	}
    
    @RequestMapping("/getconsign")
	public String getconsign(@RequestParam("username") String name, @RequestParam("sbbh") String sbbh,HttpServletRequest request,
			HttpServletResponse response) {
        response.setContentType("image/gif;charset=ISO-8859-1");
		response.setHeader("Content-Disposition",
				"attachment; filename=\"consigndata\"");
        PrintWriter out;
        try {
        	if (StringUtil.isEmpty(name,"").equalsIgnoreCase("shtoone") || StringUtil.isEmpty(name,"").equalsIgnoreCase("hzxg") ) {
        		String bt = datasuber.findConsignBySbbh(sbbh);
        		if (null != bt && bt.length()>0) {
        			out = response.getWriter();        			
        			byte[] b = com.shtoone.qms.util.StringUtil.compressData(bt);
        			//FileOutputStream os = new FileOutputStream("r:\\test");
        			//os.write(bt.getBytes("utf-8"));
        			//os.close();
        			if (null !=b && b.length>0) {
        				out = response.getWriter();
        				ByteArrayInputStream bout = new ByteArrayInputStream(b);
        				int i;
            			while ((i = bout.read()) != -1) {
            				out.write(i);
            			}                			
        				out.flush();
        				bout.close();
    	                out.close();
        			}    			
        		}
            }
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
		return null;
	}

}