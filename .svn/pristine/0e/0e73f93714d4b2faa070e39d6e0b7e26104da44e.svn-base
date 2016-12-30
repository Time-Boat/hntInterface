package com.shtoone.qms.controller.bhz;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

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

import com.shtoone.qms.entity.bhz.TophunnintuViewEntity;
import com.shtoone.qms.service.bhz.TophunnintuViewServiceI;

/**   
 * @Title: Controller
 * @Description: 拌合站状态查询
 * @author zhangdaihao
 * @date 2015-06-24 14:25:41
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tophunnintuViewController")
public class TophunnintuViewController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TophunnintuViewController.class);

	@Autowired
	private TophunnintuViewServiceI tophunnintuViewService;
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
	 * 拌合站状态查询列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tophunnintuView")
	public ModelAndView tophunnintuView(HttpServletRequest request) {
		// 给部门查询条件中的下拉框准备数据
		List<TSDepart> departList = systemService.getList(TSDepart.class);
		request.setAttribute("departsReplace", RoletoJson.listToReplaceStr(departList, "departname", "id"));
		return new ModelAndView("com/shtoone/qms/bhz/tophunnintuViewList");
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
	public void datagrid(TophunnintuViewEntity tophunnintuView,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String departid=request.getParameter("departid");//所属机构编号
		String biaoshi=request.getParameter("biaoshi");//工作状态
		String shebeibianhao=request.getParameter("shebeibianhao");
		
		HttpSession session = request.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt = session.getAttribute("userrgt").toString();
		
		if(departid!=null && departid.length()>0){
			TSDepart dpt=systemService.getEntity(TSDepart.class, departid);
			//dpt.setId(pid);
			//List<TSDepart> list=systemService.findByQueryString("from t_s_depart where ID = '"+pid+"'");
			userlft=dpt.getLft()+"";
			userrgt=dpt.getRgt()+"";
		}
		
		
		JSONObject jObject = tophunnintuViewService.getDatagrid3(tophunnintuView, dataGrid, departid, biaoshi,userlft,userrgt,shebeibianhao);
		
		responseDatagrid(response, jObject);
		
		/*
		CriteriaQuery cq = new CriteriaQuery(TophunnintuViewEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tophunnintuView, request.getParameterMap());
		this.tophunnintuViewService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);*/
	}

	/**
	 * 删除拌合站状态查询
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TophunnintuViewEntity tophunnintuView, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tophunnintuView = systemService.getEntity(TophunnintuViewEntity.class, tophunnintuView.getId());
		message = "拌合站状态查询删除成功";
		tophunnintuViewService.delete(tophunnintuView);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加拌合站状态查询
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TophunnintuViewEntity tophunnintuView, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tophunnintuView.getId())) {
			message = "拌合站状态查询更新成功";
			TophunnintuViewEntity t = tophunnintuViewService.get(TophunnintuViewEntity.class, tophunnintuView.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tophunnintuView, t);
				tophunnintuViewService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "拌合站状态查询更新失败";
			}
		} else {
			message = "拌合站状态查询添加成功";
			tophunnintuViewService.save(tophunnintuView);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 拌合站状态查询列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TophunnintuViewEntity tophunnintuView, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tophunnintuView.getId())) {
			tophunnintuView = tophunnintuViewService.getEntity(TophunnintuViewEntity.class, tophunnintuView.getId());
			req.setAttribute("tophunnintuViewPage", tophunnintuView);
		}
		return new ModelAndView("com/shtoone/qms/bhz/tophunnintuView");
	}
}
