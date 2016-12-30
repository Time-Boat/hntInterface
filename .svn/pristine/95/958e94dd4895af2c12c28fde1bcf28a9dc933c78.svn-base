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

import com.shtoone.qms.entity.bhz.XiangxixxEntity;
import com.shtoone.qms.service.bhz.XiangxixxServiceI;

/**   
 * @Title: Controller
 * @Description: 详细信息表
 * @author zhangdaihao
 * @date 2015-06-23 18:00:32
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/xiangxixxController")
public class XiangxixxController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(XiangxixxController.class);

	@Autowired
	private XiangxixxServiceI xiangxixxService;
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
	 * 详细信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "xiangxixx")
	public ModelAndView xiangxixx(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/xiangxixxList");
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
	public void datagrid(XiangxixxEntity xiangxixx,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(XiangxixxEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, xiangxixx, request.getParameterMap());
		this.xiangxixxService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除详细信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(XiangxixxEntity xiangxixx, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		xiangxixx = systemService.getEntity(XiangxixxEntity.class, xiangxixx.getId());
		message = "详细信息表删除成功";
		xiangxixxService.delete(xiangxixx);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加详细信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(XiangxixxEntity xiangxixx, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(xiangxixx.getId())) {
			message = "详细信息表更新成功";
			XiangxixxEntity t = xiangxixxService.get(XiangxixxEntity.class, xiangxixx.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(xiangxixx, t);
				xiangxixxService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "详细信息表更新失败";
			}
		} else {
			message = "详细信息表添加成功";
			xiangxixxService.save(xiangxixx);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 详细信息表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(XiangxixxEntity xiangxixx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(xiangxixx.getId())) {
			xiangxixx = xiangxixxService.getEntity(XiangxixxEntity.class, xiangxixx.getId());
			req.setAttribute("xiangxixxPage", xiangxixx);
		}
		return new ModelAndView("com/shtoone/qms/bhz/xiangxixx");
	}
}
