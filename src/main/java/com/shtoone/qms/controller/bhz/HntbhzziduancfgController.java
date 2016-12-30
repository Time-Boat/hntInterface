package com.shtoone.qms.controller.bhz;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.shtoone.qms.entity.bhz.HntbhzziduancfgEntity;
import com.shtoone.qms.service.bhz.HntbhzziduancfgServiceI;

/**   
 * @Title: Controller
 * @Description: 水泥混凝土字段及报警配置
 * @author zhangdaihao
 * @date 2015-06-17 09:47:09
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hntbhzziduancfgController")
public class HntbhzziduancfgController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HntbhzziduancfgController.class);

	@Autowired
	private HntbhzziduancfgServiceI hntbhzziduancfgService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 水泥混凝土字段及报警配置列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "hntbhzziduancfg")
	public ModelAndView hntbhzziduancfg(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/hntbhzziduancfgList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(HntbhzziduancfgEntity hntbhzziduancfg,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HntbhzziduancfgEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hntbhzziduancfg, request.getParameterMap());
		this.hntbhzziduancfgService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除水泥混凝土字段及报警配置
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(HntbhzziduancfgEntity hntbhzziduancfg, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		hntbhzziduancfg = systemService.getEntity(HntbhzziduancfgEntity.class, hntbhzziduancfg.getId());
		message = "水泥混凝土字段及报警配置删除成功";
		hntbhzziduancfgService.delete(hntbhzziduancfg);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加水泥混凝土字段及报警配置
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(HntbhzziduancfgEntity hntbhzziduancfg, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(hntbhzziduancfg.getId())) {
			message = "水泥混凝土字段及报警配置更新成功";
			HntbhzziduancfgEntity t = hntbhzziduancfgService.get(HntbhzziduancfgEntity.class, hntbhzziduancfg.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(hntbhzziduancfg, t);
				hntbhzziduancfgService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "水泥混凝土字段及报警配置更新失败";
			}
		} else {
			message = "水泥混凝土字段及报警配置添加成功";
			hntbhzziduancfgService.save(hntbhzziduancfg);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 水泥混凝土字段及报警配置列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(HntbhzziduancfgEntity hntbhzziduancfg, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hntbhzziduancfg.getId())) {
			hntbhzziduancfg = hntbhzziduancfgService.getEntity(HntbhzziduancfgEntity.class, hntbhzziduancfg.getId());
			req.setAttribute("hntbhzziduancfgPage", hntbhzziduancfg);
		}
		return new ModelAndView("com/shtoone/qms/bhz/hntbhzziduancfg");
	}
}
