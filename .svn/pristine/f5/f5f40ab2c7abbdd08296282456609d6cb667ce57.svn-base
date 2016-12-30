package com.shtoone.qms.controller.bhz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.shtoone.qms.entity.bhz.XiangxixxsmsEntity;
import com.shtoone.qms.service.bhz.XiangxixxsmsServiceI;

/**   
 * @Title: Controller
 * @Description: 发送短信临时表
 * @author zhangdaihao
 * @date 2015-06-24 16:18:19
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/xiangxixxsmsController")
public class XiangxixxsmsController extends BaseController {

	@Autowired
	private XiangxixxsmsServiceI xiangxixxsmsService;
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
	 * 发送短信临时表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "xiangxixxsms")
	public ModelAndView xiangxixxsms(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/xiangxixxsmsList");
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
	public void datagrid(XiangxixxsmsEntity xiangxixxsms,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(XiangxixxsmsEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, xiangxixxsms, request.getParameterMap());
		this.xiangxixxsmsService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除发送短信临时表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(XiangxixxsmsEntity xiangxixxsms, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		xiangxixxsms = systemService.getEntity(XiangxixxsmsEntity.class, xiangxixxsms.getId());
		message = "发送短信临时表删除成功";
		xiangxixxsmsService.delete(xiangxixxsms);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加发送短信临时表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(XiangxixxsmsEntity xiangxixxsms, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(xiangxixxsms.getId())) {
			message = "发送短信临时表更新成功";
			XiangxixxsmsEntity t = xiangxixxsmsService.get(XiangxixxsmsEntity.class, xiangxixxsms.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(xiangxixxsms, t);
				xiangxixxsmsService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "发送短信临时表更新失败";
			}
		} else {
			message = "发送短信临时表添加成功";
			xiangxixxsmsService.save(xiangxixxsms);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 发送短信临时表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(XiangxixxsmsEntity xiangxixxsms, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(xiangxixxsms.getId())) {
			xiangxixxsms = xiangxixxsmsService.getEntity(XiangxixxsmsEntity.class, xiangxixxsms.getId());
			req.setAttribute("xiangxixxsmsPage", xiangxixxsms);
		}
		return new ModelAndView("com/shtoone/qms/bhz/xiangxixxsms");
	}
}
