package com.shtoone.qms.controller.bhz;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.shtoone.qms.entity.bhz.V_YalijiEntity;
import com.shtoone.qms.service.bhz.V_YalijiServiceI;

/**   
 * @Title: Controller
 * @Description: 压力机
 * @author zhangdaihao
 * @date 2015-10-13 10:30:15
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/v_YalijiController")
public class V_YalijiController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(V_YalijiController.class);

	@Autowired
	private V_YalijiServiceI v_YalijiService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	private String departid;
	
	
	
	public String getDepartid() {
		return departid;
	}

	public void setDepartid(String departid) {
		this.departid = departid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 压力机列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "v_Yaliji")
	public ModelAndView v_Yaliji(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/v_YalijiList");
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
	public void datagrid(V_YalijiEntity v_Yaliji,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//部门ID
		if(departid=="null" || departid==""){
			departid = request.getParameter("departid");
		}
		//设备id
		String shebeibianhao = request.getParameter("shebeibianhao");
		//施工配合比编号
		String rtcode = request.getParameter("rtcode");
		
		//试件编号
		String sjbh = request.getParameter("sjbh");
		
		//工程名称
		String wtbh = request.getParameter("wtbh");
		//施工部位
		String cjmc = request.getParameter("cjmc");
		
		//设计强度
		String sjqd = request.getParameter("sjqd");
		//龄期
		String lq = request.getParameter("lq");
		//评定结果
		String pdjg = request.getParameter("pdjg");
		
		//起始时间和结束时间
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		if(StringUtil.isEmpty(startTime) && StringUtil.isEmpty(endTime)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar day = Calendar.getInstance();
			endTime = sdf.format(day.getTime());
			day.add(Calendar.YEAR, -1);
			startTime = sdf.format(day.getTime());
		}
		HttpSession session = request.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt = session.getAttribute("userrgt").toString();
		if(departid!=null&&departid.length()>0){
			TSDepart dpt = systemService.getEntity(TSDepart.class, departid);
			userlft = dpt.getLft()+"";
			userrgt = dpt.getRgt()+"";
		}
		JSONObject jObject = v_YalijiService.getDatagrid3(v_Yaliji,dataGrid,shebeibianhao,rtcode,sjbh,wtbh,cjmc,sjqd,lq,pdjg,startTime,endTime,userlft,userrgt);
		
		responseDatagrid(response, jObject);
		/*
		CriteriaQuery cq = new CriteriaQuery(V_YalijiEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, v_Yaliji, request.getParameterMap());
		this.v_YalijiService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
		*/
		
	}

	/**
	 * 删除压力机
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(V_YalijiEntity v_Yaliji, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		v_Yaliji = systemService.getEntity(V_YalijiEntity.class, v_Yaliji.getId());
		message = "压力机删除成功";
		v_YalijiService.delete(v_Yaliji);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加压力机
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(V_YalijiEntity v_Yaliji, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(v_Yaliji.getId())) {
			message = "压力机更新成功";
			V_YalijiEntity t = v_YalijiService.get(V_YalijiEntity.class, v_Yaliji.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(v_Yaliji, t);
				v_YalijiService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "压力机更新失败";
			}
		} else {
			message = "压力机添加成功";
			v_YalijiService.save(v_Yaliji);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 压力机列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(V_YalijiEntity v_Yaliji, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(v_Yaliji.getId())) {
			v_Yaliji = v_YalijiService.getEntity(V_YalijiEntity.class, v_Yaliji.getId());
			req.setAttribute("v_YalijiPage", v_Yaliji);
		}
		return new ModelAndView("com/shtoone/qms/bhz/v_Yaliji");
	}
}
