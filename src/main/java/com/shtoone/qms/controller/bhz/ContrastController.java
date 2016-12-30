package com.shtoone.qms.controller.bhz;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.entity.bhz.HunnintuView;
import com.shtoone.qms.entity.bhz.XiangxixxyssjEntity;
import com.shtoone.qms.service.bhz.HntbhzziduancfgViewServiceI;
import com.shtoone.qms.service.bhz.HunnintuViewServiceI;
import com.shtoone.qms.service.bhz.XiangxixxyssjServiceI;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/contrastController")
public class ContrastController extends BaseController{
	
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private XiangxixxyssjServiceI xiangxixxyssjService;
	
	@Autowired
	private HntbhzziduancfgViewServiceI  hntbhzziduancfgViewService; 
	
	@Autowired
	private HunnintuViewServiceI hunnintuViewService;
	
	@RequestMapping(params = "xiangxixxContrast")
	public ModelAndView xiangxixxContrast(HttpServletRequest request) {
		HntbhzziduancfgViewEntity hbfield = hntbhzziduancfgViewService.gethntcfgfield(null);
		HntbhzziduancfgViewEntity hntbhzisShow = hntbhzziduancfgViewService.gethntbhzisShow(null);
		request.setAttribute("hbfield", hbfield);
		request.setAttribute("hntbhzisShow", hntbhzisShow);
		return new ModelAndView("com/shtoone/qms/bhz/xiangxixxContrast");
	}
	
	@RequestMapping(params = "datagrid")
	@ResponseBody
	public void datagrid(HttpServletRequest request,HttpServletResponse response,DataGrid dataGrid){
		String startTime=null;
		String endTime=null;
		String shebeibianhao=null;
		String pid=null;
		String gongchengmingchen=null;
		String userlft=null;
		String userrgt=null;
		if(StringUtil.isNotEmpty(request.getParameter("pid"))){
			pid=request.getParameter("pid");
		}
		if(StringUtil.isNotEmpty(request.getParameter("shebeibianhao"))){
			shebeibianhao=request.getParameter("shebeibianhao");
		}
		if(StringUtil.isNotEmpty(request.getParameter("startTime"))){
			startTime=request.getParameter("startTime");
		}
		if(StringUtil.isNotEmpty(request.getParameter("endTime"))){
			endTime=request.getParameter("endTime");
		}
		if(StringUtil.isNotEmpty(request.getParameter("gongchengmingchen"))){
			gongchengmingchen=request.getParameter("gongchengmingchen");
		}
		//得到
		if(StringUtil.isNotEmpty(pid)){
			TSDepart dpt=systemService.getEntity(TSDepart.class, pid);
			userlft=dpt.getLft().toString();
			userrgt=dpt.getRgt().toString();
		}else{
			HttpSession session = request.getSession();
			userlft=session.getAttribute("userlft").toString();
			userrgt=session.getAttribute("userrgt").toString();
		}
		if (StringUtil.isEmpty(startTime) && StringUtil.isEmpty(endTime)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar day = Calendar.getInstance();
			endTime=sdf.format(day.getTime());
			day.add(Calendar.MONTH, -1);
			startTime=sdf.format(day.getTime());
		}
		JSONObject jObj=xiangxixxyssjService.getDataGrid(startTime, endTime, shebeibianhao, userlft, userrgt, gongchengmingchen, dataGrid);
		responseStr(response,jObj.toString());
	}
	
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(HunnintuView hunnintuView, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hunnintuView.getId())) {		
			hunnintuView = hunnintuViewService.getEntity(HunnintuView.class, hunnintuView.getId());
			if(hunnintuView!=null){
				req.setAttribute("hunnintuViewPage", hunnintuView);
				HntbhzziduancfgViewEntity hbfield = hntbhzziduancfgViewService.gethntcfgfield(hunnintuView.getShebeibianhao());	
				HntbhzziduancfgViewEntity hntbhzisShow = hntbhzziduancfgViewService.gethntbhzisShow(hunnintuView.getShebeibianhao());
				req.setAttribute("hbfield",hbfield);
				req.setAttribute("hntbhzisShow",hntbhzisShow);
			}
			//得到对比值
			XiangxixxyssjEntity xiangxixx=systemService.findUniqueByProperty(XiangxixxyssjEntity.class,"xxid",hunnintuView.getId());
			if(xiangxixx!=null){
				req.setAttribute("xiangxixx",xiangxixx);
			}
		}
		return new ModelAndView("com/shtoone/qms/bhz/contrastxixx");
	}
	
}
