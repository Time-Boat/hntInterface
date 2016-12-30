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
import org.springframework.web.servlet.ModelAndView;

import com.shtoone.qms.entity.bhz.HanshuilvSyEntity;
import com.shtoone.qms.service.bhz.HanshuilvSyServiceI;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/hanshuilvController")
public class HanshuilvController extends BaseController{
	
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private HanshuilvSyServiceI hanshuilvService;
	
	@RequestMapping(params = "hanshuilvSy")
	public ModelAndView hanshuilvSy(HttpServletRequest request) {
		// 给部门查询条件中的下拉框准备数据
		return new ModelAndView("com/shtoone/qms/bhz/hanshuilvSy");
	}
	
	@RequestMapping(params = "datagrid")
	public void datagrid(HanshuilvSyEntity hanshuilv,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String departid=request.getParameter("departid");//所属机构编号
		String shebeibianhao=request.getParameter("shebeibianhao");
		String startTime=request.getParameter("startTime");//出料开始时间
		String endTime=request.getParameter("endTime");//出料结束时间
		String CLMC=request.getParameter("CLMC");
		Integer userlft =null;
		Integer userrgt =null;
		if(StringUtil.isNotEmpty(departid)){
			TSDepart dpt=systemService.getEntity(TSDepart.class, departid);
			userlft=dpt.getLft();
			userrgt=dpt.getRgt();
		}else{
			HttpSession session = request.getSession();
			userlft=Integer.parseInt( session.getAttribute("userlft").toString());
			userrgt=Integer.parseInt(session.getAttribute("userrgt").toString());
		}
		if (StringUtil.isEmpty(startTime) && StringUtil.isEmpty(endTime)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Calendar day = Calendar.getInstance();
			endTime=sdf.format(day.getTime());
			day.add(Calendar.MONTH, -1);
			startTime=sdf.format(day.getTime());
		}
		
		JSONObject jObject =hanshuilvService.getDatagrid(hanshuilv, dataGrid, startTime, endTime, userlft, userrgt, CLMC, shebeibianhao);
		responseDatagrid(response, jObject);
	}
}
