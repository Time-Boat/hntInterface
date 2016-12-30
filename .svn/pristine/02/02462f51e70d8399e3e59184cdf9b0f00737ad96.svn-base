package com.shtoone.qms.controller.bhz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.RoletoJson;
import org.jeecgframework.core.util.StringUtil;

import com.shtoone.qms.entity.bhz.Lilunpeibixixx;

import org.jeecgframework.web.system.pojo.base.TSDepart;
import com.shtoone.qms.service.bhz.LilunpeibixixxService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lilunpeihebiController")
public class LilunpeihebiController extends BaseController{
		
	private SystemService systemService;
	@Autowired
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	private LilunpeibixixxService lilunpeibixixxService;
	@Autowired
	public void setLilunpeibixixxService(LilunpeibixixxService lilunpeibixixxService) {
		this.lilunpeibixixxService = lilunpeibixixxService;
	}
	private String message;
	private String departid;
	public String getDepartid() {
		return departid;
	}

	public void setDepartid(String departid) {
		this.departid = departid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@RequestMapping(params = "lilunpeibiList")
	public ModelAndView shigongpeibiList(HttpServletRequest request) {
		// 给部门查询条件中的下拉框准备数据
		if(StringUtil.isNotEmpty(request.getParameter("superGroup"))){
			departid=request.getParameter("superGroup");
		}
		List<TSDepart> departList = systemService.getList(TSDepart.class);
		request.setAttribute("departsReplace", RoletoJson.listToReplaceStr(departList, "departname", "id"));
		return new ModelAndView("com/shtoone/qms/bhz/lilun/lilunpeibiList");
	}
	
	/**
	 * easyuiAJAX请求数据  lilunpeihebiController.do?lilunpeibiList
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagrid")
	public void datagrid(Lilunpeibixixx lilungph,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		HttpSession session = request.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt =session.getAttribute("userrgt").toString();
		//时间
		String startTime="";
		String endTime="";
		if(StringUtil.isNotEmpty(request.getParameter("reportDate_begin"))){
			startTime=request.getParameter("reportDate_begin");
		}
		if(StringUtil.isNotEmpty(request.getParameter("reportDate_end"))){
			endTime=request.getParameter("reportDate_end");
		}
		if(StringUtil.isNotEmpty(request.getParameter("superGroup"))){
			departid=request.getParameter("superGroup");
		}
		if(StringUtil.isNotEmpty(departid)){
			TSDepart dpt=systemService.getEntity(TSDepart.class, departid);
			userlft=dpt.getLft()+"";
			userrgt=dpt.getRgt()+"";
		}
		JSONObject jObject = lilunpeibixixxService.getLilunBySql(lilungph, dataGrid, userlft, userrgt, startTime, endTime);
		responseDatagrid(response, jObject);
		
	}

	/**
	 * 施工配合比页面跳转
	 * 
	 * @param icon
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(Lilunpeibixixx lilungph, HttpServletRequest req) {
		//添加跳转时，需要带入所属单位
		List<TSDepart> departList = systemService.getList(TSDepart.class);
		req.setAttribute("departList", departList);
		//如果是修改的话，就带入对象
		if (StringUtil.isNotEmpty(lilungph.getId())) {
			lilungph = lilunpeibixixxService.getEntity(Lilunpeibixixx.class, lilungph.getId());
			req.setAttribute("lilungph", lilungph);
		}else{
			lilungph=new Lilunpeibixixx();
			req.setAttribute("lilungph", lilungph);
		}
		return new ModelAndView("com/shtoone/qms/bhz/lilun/lilunpeibi");
	}
	
	
	
	/**
	 * 施工配合比复制并录入
	 * 
	 * @param icon
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "copyandadd")
	public ModelAndView copyandadd(Lilunpeibixixx lilungph, HttpServletRequest req) {
		//添加跳转时，需要带入所属单位
		List<TSDepart> departList = systemService.getList(TSDepart.class);
		req.setAttribute("departList", departList);
		//如果是修改的话，就带入对象
		if (StringUtil.isNotEmpty(lilungph.getId())) {
			lilungph = lilunpeibixixxService.getEntity(Lilunpeibixixx.class, lilungph.getId());
			req.setAttribute("lilungph", lilungph);
		}else{
			lilungph=new Lilunpeibixixx();
			req.setAttribute("lilungph", lilungph);
		}
		return new ModelAndView("com/shtoone/qms/bhz/lilun/lilunpeibinew");
	}
	
	
	/**
	 * 添加施工配合比信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "copyandsave")
	@ResponseBody
	public AjaxJson copyandsave(Lilunpeibixixx lilungph,HttpServletRequest request) {
		AjaxJson ajaxJson = new AjaxJson();
		TSDepart depart = systemService.getEntity(TSDepart.class, lilungph.getUserGroup());
		lilungph.setSuperGroup(depart.getDepartname());
		/*if (StringUtil.isNotEmpty(lilungph.getId())) {
			//在数据被更新时，将其状态更改为1
			message = "配合比报告编号: " + lilungph.getPhbreportId()+ "被更新成功";
			lilungph.setState("0");
			lilunpeibixixxService.saveOrUpdate(lilungph);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} else {*/
			message = "配合比报告编号: " + lilungph.getPhbreportId() + "被添加成功";
			//在数据被添加时，将其状态更改为0
			lilungph.setState("0");
			lilunpeibixixxService.save(lilungph);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
	/*	}*/
		//刷新缓存
		
		ajaxJson.setMsg(message);
		return ajaxJson;
	}
	
	/**
	 * 添加施工配合比信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(Lilunpeibixixx lilungph,HttpServletRequest request) {
		AjaxJson ajaxJson = new AjaxJson();
		TSDepart depart = systemService.getEntity(TSDepart.class, lilungph.getUserGroup());
		lilungph.setSuperGroup(depart.getDepartname());
		if (StringUtil.isNotEmpty(lilungph.getId())) {
			//在数据被更新时，将其状态更改为1
			message = "配合比报告编号: " + lilungph.getPhbreportId()+ "被更新成功";
			lilungph.setState("0");
			lilunpeibixixxService.saveOrUpdate(lilungph);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} else {
			message = "配合比报告编号: " + lilungph.getPhbreportId() + "被添加成功";
			//在数据被添加时，将其状态更改为0
			lilungph.setState("0");
			lilunpeibixixxService.save(lilungph);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		//刷新缓存
		
		ajaxJson.setMsg(message);
		return ajaxJson;
	}
	
	/**
	 * 删除施工配合比信息（ID以G开头的是分组）
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(Lilunpeibixixx lilungph, HttpServletRequest request) {
		AjaxJson ajaxJson = new AjaxJson();
		lilungph= lilunpeibixixxService.getEntity(Lilunpeibixixx.class, lilungph.getId());
		message = "配合比报告编号: " + lilungph.getPhbreportId() + "被删除 成功";
		lilunpeibixixxService.delete(lilungph);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		//刷新缓存
		ajaxJson.setMsg(message);
		return ajaxJson;
	}
	
	//这个方法只是用于选择组织机构，遴选出理论配比
	@RequestMapping(params = "lilunpbfind")
	public void lilunpbfind(Lilunpeibixixx lilungph, HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt =session.getAttribute("userrgt").toString();
		String departid="";
		if(StringUtil.isNotEmpty(request.getParameter("departId"))){
			departid=request.getParameter("departId");
		}
		if(StringUtil.isNotEmpty(departid)){
			TSDepart dpt=systemService.getEntity(TSDepart.class, departid);
			userlft=dpt.getLft()+"";
			userrgt=dpt.getRgt()+"";
		}
		List<Lilunpeibixixx> lilunList=lilunpeibixixxService.getLilunpeibiByDepartBySQL(departid,userlft,userrgt);
		JSONObject returnJson=new JSONObject();
		returnJson.put("list",JSONArray.fromObject(lilunList));
		responseDatagrid(response, returnJson);
	}
}
