package com.shtoone.qms.controller.bhz;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import com.shtoone.qms.entity.bhz.T_QPJJXSEntity;
import com.shtoone.qms.entity.bhz.T_QPJJXS_View;
import com.shtoone.qms.service.bhz.T_QPJJXSServiceI;

/**   
 * @Title: Controller
 * @Description: 气泡间距系数
 * @author zhangdaihao
 * @date 2016-07-05 16:29:49
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_QPJJXSController")
public class T_QPJJXSController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_QPJJXSController.class);

	@Autowired
	private T_QPJJXSServiceI t_QPJJXSService;
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
	 * 气泡间距系数列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "t_QPJJXS")
	public ModelAndView t_QPJJXS(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/t_QPJJXSList");
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
	public void datagrid(T_QPJJXSEntity t_QPJJXS,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_QPJJXS_View.class, dataGrid);
		//查询条件组装器
		String pid =request.getParameter("pid");
		String startTime =request.getParameter("startTime");
		String endTime =request.getParameter("endTime");
		String shebeibianhao =request.getParameter("shebeibianhao");
		String ybbh=request.getParameter("ybbh");
		String sybh=request.getParameter("sybh");
		if (StringUtil.isNotEmpty(pid)) {
			TSDepart depart = systemService.getEntity(TSDepart.class, pid);
			cq.ge("lft", depart.getLft().toString());
			cq.le("rgt", depart.getRgt().toString());
		} else {
			HttpSession session = request.getSession();
			cq.ge("lft", session.getAttribute("userlft").toString());
			cq.le("rgt", session.getAttribute("userrgt").toString());
		}
		if (StringUtil.isNotEmpty(startTime)) {
			cq.ge("syrq", startTime);
		}
		if (StringUtil.isNotEmpty(endTime)) {
			cq.le("syrq", endTime);
		}
		if (StringUtil.isNotEmpty(shebeibianhao)) {
			cq.eq("sbbh", shebeibianhao);
		}
		if (StringUtil.isNotEmpty(ybbh)) {
			cq.like("ybbh", "%"+ybbh+"%");
		}
		if (StringUtil.isNotEmpty(sybh)) {
			cq.like("sybh", "%"+sybh+"%");
		}
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, new T_QPJJXS_View(), request.getParameterMap());
		this.t_QPJJXSService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除气泡间距系数
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_QPJJXSEntity t_QPJJXS, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		t_QPJJXS = systemService.getEntity(T_QPJJXSEntity.class, t_QPJJXS.getId());
		message = "气泡间距系数删除成功";
		t_QPJJXSService.delete(t_QPJJXS);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加气泡间距系数
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_QPJJXSEntity t_QPJJXS, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(t_QPJJXS.getId())) {
			message = "气泡间距系数更新成功";
			T_QPJJXSEntity t = t_QPJJXSService.get(T_QPJJXSEntity.class, t_QPJJXS.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(t_QPJJXS, t);
				t_QPJJXSService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "气泡间距系数更新失败";
			}
		} else {
			message = "气泡间距系数添加成功";
			t_QPJJXSService.save(t_QPJJXS);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 气泡间距系数列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_QPJJXSEntity t_QPJJXS, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_QPJJXS.getId())) {
			t_QPJJXS = t_QPJJXSService.getEntity(T_QPJJXSEntity.class, t_QPJJXS.getId());
			req.setAttribute("t_QPJJXSPage", t_QPJJXS);
		}
		return new ModelAndView("com/shtoone/qms/bhz/t_QPJJXS");
	}
}
