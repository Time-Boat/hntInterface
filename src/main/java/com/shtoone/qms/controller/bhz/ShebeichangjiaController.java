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

import com.shtoone.qms.entity.bhz.ShebeichangjiaEntity;
import com.shtoone.qms.service.bhz.ShebeichangjiaServiceI;

/**   
 * @Title: Controller
 * @Description: 设备厂家
 * @author zhangdaihao
 * @date 2015-06-16 10:56:58
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/shebeichangjiaController")
public class ShebeichangjiaController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ShebeichangjiaController.class);

	@Autowired
	private ShebeichangjiaServiceI shebeichangjiaService;
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
	 * 设备厂家列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "shebeichangjia")
	public ModelAndView shebeichangjia(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/shebeichangjiaList");
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
	public void datagrid(ShebeichangjiaEntity shebeichangjia,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ShebeichangjiaEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, shebeichangjia, request.getParameterMap());
		this.shebeichangjiaService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除设备厂家
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ShebeichangjiaEntity shebeichangjia, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		shebeichangjia = systemService.getEntity(ShebeichangjiaEntity.class, shebeichangjia.getSbbh());
		message = "设备厂家删除成功";
		shebeichangjiaService.delete(shebeichangjia);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加设备厂家
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ShebeichangjiaEntity shebeichangjia, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(shebeichangjia.getSbbh())) {
			message = "设备厂家更新成功";
			ShebeichangjiaEntity t = shebeichangjiaService.get(ShebeichangjiaEntity.class, shebeichangjia.getSbbh());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(shebeichangjia, t);
				shebeichangjiaService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "设备厂家更新失败";
			}
		} else {
			message = "设备厂家添加成功";
			shebeichangjiaService.save(shebeichangjia);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 设备厂家列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ShebeichangjiaEntity shebeichangjia, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(shebeichangjia.getSbbh())) {
			shebeichangjia = shebeichangjiaService.getEntity(ShebeichangjiaEntity.class, shebeichangjia.getSbbh());
			req.setAttribute("shebeichangjiaPage", shebeichangjia);
		}
		return new ModelAndView("com/shtoone/qms/bhz/shebeichangjia");
	}
}
