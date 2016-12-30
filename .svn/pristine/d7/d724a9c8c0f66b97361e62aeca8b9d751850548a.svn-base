package com.shtoone.qms.controller.bhz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fr.third.org.hsqldb.Session;

@Controller
@RequestMapping("/ChaolianjieController")
public class ChaolianjieController extends BaseController{
	
	@RequestMapping(params = "ChaolianjieController")
	public ModelAndView chuliaokouTemperaturedataView(HttpServletRequest request) {
		
//		String userid = "shtoone",pwd = null,timestamp = "1444496461";
//		System.out.println(userid+"---"+pwd+"---"+com.shtoone.qms.util.StringUtil.getMD5(userid+"_"+timestamp+"_zh"));  
		HttpSession session = request.getSession();
		TSUser user = ResourceUtil.getSessionUserName();
		String userid =user.getUserName();
		//获取当前时间戳
		String timestamp = String.valueOf(System.currentTimeMillis()/1000); 
		String pwd =com.shtoone.qms.util.StringUtil.getMD5(userid+"_"+timestamp+"_zh");
		session.setAttribute("userid", userid);
		session.setAttribute("timestamp", timestamp);
		session.setAttribute("pwd", pwd);
		return new ModelAndView("com/shtoone/qms/bhz/chaolianjieController");
	}

}
