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

import com.shtoone.qms.entity.bhz.V_YalijiNEntity;
import com.shtoone.qms.service.bhz.V_YalijiNServiceI;

/**   
 * @Title: Controller
 * @Description: 压力试验子表
 * @author zhangdaihao
 * @date 2015-07-07 18:13:54
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/v_YalijiNController")
public class V_YalijiNController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(V_YalijiNController.class);

	@Autowired
	private V_YalijiNServiceI v_YalijiNService;
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
	 * 压力试验子表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "v_YalijiN")
	public ModelAndView v_YalijiN(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/v_YalijiNList");
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
	public void datagrid(V_YalijiNEntity v_YalijiN,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(V_YalijiNEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, v_YalijiN, request.getParameterMap());
		this.v_YalijiNService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除压力试验子表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(V_YalijiNEntity v_YalijiN, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		v_YalijiN = systemService.getEntity(V_YalijiNEntity.class, v_YalijiN.getId());
		message = "压力试验子表删除成功";
		v_YalijiNService.delete(v_YalijiN);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加压力试验子表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(V_YalijiNEntity v_YalijiN, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(v_YalijiN.getId())) {
			message = "压力试验子表更新成功";
			V_YalijiNEntity t = v_YalijiNService.get(V_YalijiNEntity.class, v_YalijiN.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(v_YalijiN, t);
				v_YalijiNService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "压力试验子表更新失败";
			}
		} else {
			message = "压力试验子表添加成功";
			v_YalijiNService.save(v_YalijiN);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 压力试验子表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(V_YalijiNEntity v_YalijiN, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(v_YalijiN.getId())) {
			v_YalijiN = v_YalijiNService.getEntity(V_YalijiNEntity.class, v_YalijiN.getId());
			req.setAttribute("v_YalijiNPage", v_YalijiN);
		}
		return new ModelAndView("com/shtoone/qms/bhz/v_YalijiN");
	}
}
