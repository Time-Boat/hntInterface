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
import org.jeecgframework.core.util.RoletoJson;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.shtoone.qms.entity.bhz.DepartMappingEntity;
import com.shtoone.qms.service.bhz.DepartMappingServiceI;

/**   
 * @Title: Controller
 * @Description: 标段部门映射表
 * @author zhangdaihao
 * @date 2015-06-18 11:23:40
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/departMappingController")
public class DepartMappingController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DepartMappingController.class);

	@Autowired
	private DepartMappingServiceI departMappingService;
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
	 * 标段部门映射表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "departMapping")
	public ModelAndView departMapping(HttpServletRequest request) {
		// 给部门查询条件中的下拉框准备数据
		List<TSDepart> departList = systemService.getList(TSDepart.class);
		request.setAttribute("departsReplace", RoletoJson.listToReplaceStr(departList, "departname", "id"));
		return new ModelAndView("com/shtoone/qms/bhz/departMappingList");
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
	public void datagrid(DepartMappingEntity departMapping,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DepartMappingEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, departMapping, request.getParameterMap());
		this.departMappingService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除标段部门映射表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(DepartMappingEntity departMapping, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		departMapping = systemService.getEntity(DepartMappingEntity.class, departMapping.getId());
		message = "标段部门映射表删除成功";
		departMappingService.delete(departMapping);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加标段部门映射表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(DepartMappingEntity departMapping, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(departMapping.getId())) {
			message = "标段部门映射表更新成功";
			DepartMappingEntity t = departMappingService.get(DepartMappingEntity.class, departMapping.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(departMapping, t);
				departMappingService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "标段部门映射表更新失败";
			}
		} else {
			message = "标段部门映射表添加成功";
			departMappingService.save(departMapping);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 标段部门映射表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(DepartMappingEntity departMapping, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(departMapping.getId())) {
			
			DepartMappingEntity t = departMappingService.get(DepartMappingEntity.class, departMapping.getId());
			
			TSDepart depart = systemService.getEntity(TSDepart.class, t.getDepartid());
			if(null==depart){
				req.setAttribute("departName", "");
			}else{
				req.setAttribute("departName", depart.getDepartname());
			}
			
			
			departMapping = departMappingService.getEntity(DepartMappingEntity.class, departMapping.getId());
			req.setAttribute("departMappingPage", departMapping);
		}else{
			req.setAttribute("departName", "");
		}
		return new ModelAndView("com/shtoone/qms/bhz/departMapping");
	}
}
