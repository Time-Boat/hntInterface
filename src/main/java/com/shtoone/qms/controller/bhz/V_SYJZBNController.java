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

import com.shtoone.qms.entity.bhz.V_SYJZBNEntity;
import com.shtoone.qms.service.bhz.V_SYJZBNServiceI;

/**   
 * @Title: Controller
 * @Description: 试验主表
 * @author zhangdaihao
 * @date 2015-07-07 18:13:16
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/v_SYJZBNController")
public class V_SYJZBNController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(V_SYJZBNController.class);

	@Autowired
	private V_SYJZBNServiceI v_SYJZBNService;
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
	 * 试验主表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "v_SYJZBN")
	public ModelAndView v_SYJZBN(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/v_SYJZBNList");
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
	public void datagrid(V_SYJZBNEntity v_SYJZBN,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(V_SYJZBNEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, v_SYJZBN, request.getParameterMap());
		this.v_SYJZBNService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除试验主表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(V_SYJZBNEntity v_SYJZBN, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		v_SYJZBN = systemService.getEntity(V_SYJZBNEntity.class, v_SYJZBN.getId());
		message = "试验主表删除成功";
		v_SYJZBNService.delete(v_SYJZBN);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加试验主表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(V_SYJZBNEntity v_SYJZBN, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(v_SYJZBN.getId())) {
			message = "试验主表更新成功";
			V_SYJZBNEntity t = v_SYJZBNService.get(V_SYJZBNEntity.class, v_SYJZBN.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(v_SYJZBN, t);
				v_SYJZBNService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "试验主表更新失败";
			}
		} else {
			message = "试验主表添加成功";
			v_SYJZBNService.save(v_SYJZBN);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 试验主表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(V_SYJZBNEntity v_SYJZBN, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(v_SYJZBN.getId())) {
			v_SYJZBN = v_SYJZBNService.getEntity(V_SYJZBNEntity.class, v_SYJZBN.getId());
			req.setAttribute("v_SYJZBNPage", v_SYJZBN);
		}
		return new ModelAndView("com/shtoone/qms/bhz/v_SYJZBN");
	}
}
