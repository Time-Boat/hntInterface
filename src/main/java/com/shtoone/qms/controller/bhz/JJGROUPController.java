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

import com.shtoone.qms.entity.bhz.JJGROUPEntity;
import com.shtoone.qms.service.bhz.JJGROUPServiceI;

/**   
 * @Title: Controller
 * @Description: 交建组织机构
 * @author zhangdaihao
 * @date 2015-07-22 10:07:10
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/jJGROUPController")
public class JJGROUPController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(JJGROUPController.class);

	@Autowired
	private JJGROUPServiceI jJGROUPService;
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
	 * 交建组织机构列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "jJGROUP")
	public ModelAndView jJGROUP(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/jJGROUPList");
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
	public void datagrid(JJGROUPEntity jJGROUP,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(JJGROUPEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, jJGROUP, request.getParameterMap());
		this.jJGROUPService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除交建组织机构
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(JJGROUPEntity jJGROUP, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		jJGROUP = systemService.getEntity(JJGROUPEntity.class, jJGROUP.getId());
		message = "交建组织机构删除成功";
		jJGROUPService.delete(jJGROUP);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加交建组织机构
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(JJGROUPEntity jJGROUP, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(jJGROUP.getId())) {
			message = "交建组织机构更新成功";
			JJGROUPEntity t = jJGROUPService.get(JJGROUPEntity.class, jJGROUP.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(jJGROUP, t);
				jJGROUPService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "交建组织机构更新失败";
			}
		} else {
			message = "交建组织机构添加成功";
			jJGROUPService.save(jJGROUP);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 交建组织机构列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(JJGROUPEntity jJGROUP, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(jJGROUP.getId())) {
			jJGROUP = jJGROUPService.getEntity(JJGROUPEntity.class, jJGROUP.getId());
			req.setAttribute("jJGROUPPage", jJGROUP);
		}
		return new ModelAndView("com/shtoone/qms/bhz/jJGROUP");
	}
}
