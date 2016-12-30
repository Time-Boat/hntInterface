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

import com.shtoone.qms.entity.bhz.GongkongchangjiaEntity;
import com.shtoone.qms.service.bhz.GongkongchangjiaServiceI;

/**   
 * @Title: Controller
 * @Description: 设备工控机厂家
 * @author zhangdaihao
 * @date 2015-06-16 13:59:59
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/gongkongchangjiaController")
public class GongkongchangjiaController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(GongkongchangjiaController.class);

	@Autowired
	private GongkongchangjiaServiceI gongkongchangjiaService;
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
	 * 设备工控机厂家列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "gongkongchangjia")
	public ModelAndView gongkongchangjia(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/gongkongchangjiaList");
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
	public void datagrid(GongkongchangjiaEntity gongkongchangjia,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(GongkongchangjiaEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, gongkongchangjia, request.getParameterMap());
		this.gongkongchangjiaService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除设备工控机厂家
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(GongkongchangjiaEntity gongkongchangjia, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		gongkongchangjia = systemService.getEntity(GongkongchangjiaEntity.class, gongkongchangjia.getSbbh());
		message = "设备工控机厂家删除成功";
		gongkongchangjiaService.delete(gongkongchangjia);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加设备工控机厂家
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(GongkongchangjiaEntity gongkongchangjia, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(gongkongchangjia.getSbbh())) {
			message = "设备工控机厂家更新成功";
			GongkongchangjiaEntity t = gongkongchangjiaService.get(GongkongchangjiaEntity.class, gongkongchangjia.getSbbh());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(gongkongchangjia, t);
				gongkongchangjiaService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "设备工控机厂家更新失败";
			}
		} else {
			message = "设备工控机厂家添加成功";
			gongkongchangjiaService.save(gongkongchangjia);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 设备工控机厂家列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(GongkongchangjiaEntity gongkongchangjia, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(gongkongchangjia.getSbbh())) {
			gongkongchangjia = gongkongchangjiaService.getEntity(GongkongchangjiaEntity.class, gongkongchangjia.getSbbh());
			req.setAttribute("gongkongchangjiaPage", gongkongchangjia);
		}
		return new ModelAndView("com/shtoone/qms/bhz/gongkongchangjia");
	}
}
