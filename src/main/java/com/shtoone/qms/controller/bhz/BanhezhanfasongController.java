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

import com.shtoone.qms.entity.bhz.BanhezhanfasongEntity;
import com.shtoone.qms.service.bhz.BanhezhanfasongServiceI;


@Controller
@RequestMapping("/banhezhanfasongController")
public class BanhezhanfasongController extends BaseController {

	@Autowired
	private BanhezhanfasongServiceI banhezhanfasongService;
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
	 * 接口管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "banhezhanfasong")
	public ModelAndView banhezhanfasong(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/banhezhanfasongList");
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
	public void datagrid(BanhezhanfasongEntity banhezhanfasong,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(BanhezhanfasongEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, banhezhanfasong, request.getParameterMap());
		this.banhezhanfasongService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除接口管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(BanhezhanfasongEntity banhezhanfasong, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		banhezhanfasong = systemService.getEntity(BanhezhanfasongEntity.class, banhezhanfasong.getId());
		message = "接口管理删除成功";
		banhezhanfasongService.delete(banhezhanfasong);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加接口管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(BanhezhanfasongEntity banhezhanfasong, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(banhezhanfasong.getId())) {
			message = "接口管理更新成功";
			BanhezhanfasongEntity t = banhezhanfasongService.get(BanhezhanfasongEntity.class, banhezhanfasong.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(banhezhanfasong, t);
				banhezhanfasongService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "接口管理更新失败";
			}
		} else {
			message = "接口管理添加成功";
			banhezhanfasongService.save(banhezhanfasong);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 接口管理列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(BanhezhanfasongEntity banhezhanfasong, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(banhezhanfasong.getId())) {
			banhezhanfasong = banhezhanfasongService.getEntity(BanhezhanfasongEntity.class, banhezhanfasong.getId());
			req.setAttribute("banhezhanfasongPage", banhezhanfasong);
		}
		return new ModelAndView("com/shtoone/qms/bhz/banhezhanfasong");
	}
}
