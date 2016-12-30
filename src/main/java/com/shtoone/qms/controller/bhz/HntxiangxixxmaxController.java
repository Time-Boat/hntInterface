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

import com.shtoone.qms.entity.bhz.HntxiangxixxmaxEntity;
import com.shtoone.qms.service.bhz.HntxiangxixxmaxServiceI;

/**   
 * @Title: Controller
 * @Description: 最大一笔详细信息
 * @author zhangdaihao
 * @date 2015-06-23 18:08:24
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hntxiangxixxmaxController")
public class HntxiangxixxmaxController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HntxiangxixxmaxController.class);

	@Autowired
	private HntxiangxixxmaxServiceI hntxiangxixxmaxService;
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
	 * 最大一笔详细信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "hntxiangxixxmax")
	public ModelAndView hntxiangxixxmax(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/hntxiangxixxmaxList");
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
	public void datagrid(HntxiangxixxmaxEntity hntxiangxixxmax,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HntxiangxixxmaxEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hntxiangxixxmax, request.getParameterMap());
		this.hntxiangxixxmaxService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除最大一笔详细信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(HntxiangxixxmaxEntity hntxiangxixxmax, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		hntxiangxixxmax = systemService.getEntity(HntxiangxixxmaxEntity.class, hntxiangxixxmax.getId());
		message = "最大一笔详细信息删除成功";
		hntxiangxixxmaxService.delete(hntxiangxixxmax);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加最大一笔详细信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(HntxiangxixxmaxEntity hntxiangxixxmax, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(hntxiangxixxmax.getId())) {
			message = "最大一笔详细信息更新成功";
			HntxiangxixxmaxEntity t = hntxiangxixxmaxService.get(HntxiangxixxmaxEntity.class, hntxiangxixxmax.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(hntxiangxixxmax, t);
				hntxiangxixxmaxService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "最大一笔详细信息更新失败";
			}
		} else {
			message = "最大一笔详细信息添加成功";
			hntxiangxixxmaxService.save(hntxiangxixxmax);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 最大一笔详细信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(HntxiangxixxmaxEntity hntxiangxixxmax, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hntxiangxixxmax.getId())) {
			hntxiangxixxmax = hntxiangxixxmaxService.getEntity(HntxiangxixxmaxEntity.class, hntxiangxixxmax.getId());
			req.setAttribute("hntxiangxixxmaxPage", hntxiangxixxmax);
		}
		return new ModelAndView("com/shtoone/qms/bhz/hntxiangxixxmax");
	}
}
