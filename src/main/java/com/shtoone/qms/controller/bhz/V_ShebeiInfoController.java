package com.shtoone.qms.controller.bhz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import com.shtoone.qms.entity.ShebeiInfoEntity;
import com.shtoone.qms.entity.bhz.V_ShebeiInfoEntity;
import com.shtoone.qms.service.bhz.ShebeiInfoServiceI;
import com.shtoone.qms.service.bhz.V_ShebeiInfoServiceI;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**   
 * @Title: Controller
 * @Description: 设备信息管理
 * @author zhangdaihao
 * @date 2015-10-10 17:11:33
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/v_ShebeiInfoController")
public class V_ShebeiInfoController extends BaseController {

	@Autowired
	private V_ShebeiInfoServiceI v_ShebeiInfoService;
	
	@Autowired
	private ShebeiInfoServiceI ShebeiInfoService;
	
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
	 * 设备信息管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "v_ShebeiInfo")
	public ModelAndView v_ShebeiInfo(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/v_ShebeiInfoList");
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
	public void datagrid(V_ShebeiInfoEntity v_ShebeiInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(V_ShebeiInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, v_ShebeiInfo, request.getParameterMap());
		this.v_ShebeiInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除设备信息管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ShebeiInfoEntity v_ShebeiInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		v_ShebeiInfo = systemService.getEntity(ShebeiInfoEntity.class, v_ShebeiInfo.getId());
		message = "设备信息管理删除成功";
		v_ShebeiInfoService.delete(v_ShebeiInfo);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加设备信息管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ShebeiInfoEntity v_ShebeiInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(v_ShebeiInfo.getId())) {
			message = "设备信息管理更新成功";
			ShebeiInfoEntity t = ShebeiInfoService.get(ShebeiInfoEntity.class, v_ShebeiInfo.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(v_ShebeiInfo, t);
				v_ShebeiInfoService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "设备信息管理更新失败";
			}
		} else {
			message = "设备信息管理添加成功";
			ShebeiInfoService.save(v_ShebeiInfo);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 设备信息管理列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(V_ShebeiInfoEntity v_ShebeiInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(v_ShebeiInfo.getId())) {
			ShebeiInfoEntity ShebeiInfo = v_ShebeiInfoService.getEntity(ShebeiInfoEntity.class, v_ShebeiInfo.getId());
			req.setAttribute("v_ShebeiInfoPage", ShebeiInfo);
		}
		return new ModelAndView("com/shtoone/qms/bhz/v_ShebeiInfo");
	}
	
	//设备编号
	@RequestMapping(params = "shebeiSearch")
	public void shebeiSearch(V_ShebeiInfoEntity ShebeiInfo, HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt =session.getAttribute("userrgt").toString();
		String departid=request.getParameter("departid");
		String bhjtype=request.getParameter("shebeitype");
		if(StringUtil.isNotEmpty(departid)){
			TSDepart dpt=systemService.getEntity(TSDepart.class, departid);
			userlft=dpt.getLft()+"";
			userrgt=dpt.getRgt()+"";
		}
		List<V_ShebeiInfoEntity> tempList=v_ShebeiInfoService.getShebeiBySql(bhjtype,userlft,userrgt);
		JSONObject returnJson=new JSONObject();
		returnJson.put("list", JSONArray.fromObject(tempList));
		responseDatagrid(response, returnJson);
	}
}
