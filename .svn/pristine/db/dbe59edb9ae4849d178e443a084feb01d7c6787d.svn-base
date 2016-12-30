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

import com.shtoone.qms.entity.bhz.V_WangnjEntity;
import com.shtoone.qms.service.bhz.V_WangnjServiceI;

/**   
 * @Title: Controller
 * @Description: 万能机
 * @author zhangdaihao
 * @date 2015-10-08 15:23:10
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/v_WangnjController")
public class V_WangnjController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(V_WangnjController.class);

	@Autowired
	private V_WangnjServiceI v_WangnjService;
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
	 * 万能机列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "v_Wangnj")
	public ModelAndView v_Wangnj(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/v_WangnjList");
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
	public void datagrid(V_WangnjEntity v_Wangnj,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		
		if(departid==null || departid==""){
			departid = request.getParameter("departid");
		}
		//通过name获取设备编号
	    String shebeibianhao = request.getParameter("shebeibianhao");
	    //试验名称
	    String testname = request.getParameter("testname");
	    //品种类型
	    String pzbm = request.getParameter("pzbm");
	    //工程名称
	    String gcmc = request.getParameter("gcmc");
	    //施工部位
	    String sgbw = request.getParameter("sgbw");
	    //试件编号
	    String sjbh = request.getParameter("sjbh");
	    //评定结果
	    String pdjg = request.getParameter("pdjg");
	    String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		System.out.println("设备编号："+shebeibianhao);
		System.out.println("试验名称"+testname);
		System.out.println("品种类型"+pzbm);
		System.out.println("工程名称"+gcmc);
		System.out.println("施工部位"+sgbw);
		System.out.println("试件编号"+sjbh);
		System.out.println("评定结果"+pdjg);
		System.out.println(startTime+"////"+endTime);
		if(StringUtil.isEmpty(startTime)&&StringUtil.isEmpty(endTime)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar day = Calendar.getInstance();
			endTime = sdf.format(day.getTime());
			day.add(Calendar.MONTH, -1);
			startTime = sdf.format(day.getTime());
		}
		System.out.println(startTime+"////"+endTime);
		HttpSession session = request.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt = session.getAttribute("userrgt").toString();
		if(departid!=null&&departid.length()>0){
			TSDepart dpt = systemService.getEntity(TSDepart.class, departid);
			userlft = dpt.getLft()+"";
			userrgt = dpt.getRgt()+"";
		}
		
		JSONObject jObject = v_WangnjService.getDatagrid3(v_Wangnj, dataGrid, startTime, endTime,  shebeibianhao, testname, pzbm, gcmc, sgbw, sjbh, pdjg, userlft, userrgt);
				
		responseDatagrid(response, jObject);
		/*
		if(departid!=null && departid.length()>0){
			TSDepart dpt=systemService.getEntity(TSDepart.class, departid);
			//dpt.setId(pid);
			//List<TSDepart> list=systemService.findByQueryString("from t_s_depart where ID = '"+pid+"'");
			userlft=dpt.getLft()+"";
			userrgt=dpt.getRgt()+"";
		}
		*/
		
		/*
		CriteriaQuery cq = new CriteriaQuery(V_WangnjEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, v_Wangnj, request.getParameterMap());
		this.v_WangnjService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
		  */
		
		
	}

	/**
	 * 删除万能机
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(V_WangnjEntity v_Wangnj, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		v_Wangnj = systemService.getEntity(V_WangnjEntity.class, v_Wangnj.getId());
		message = "万能机删除成功";
		v_WangnjService.delete(v_Wangnj);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加万能机
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(V_WangnjEntity v_Wangnj, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(v_Wangnj.getId())) {
			message = "万能机更新成功";
			V_WangnjEntity t = v_WangnjService.get(V_WangnjEntity.class, v_Wangnj.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(v_Wangnj, t);
				v_WangnjService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "万能机更新失败";
			}
		} else {
			message = "万能机添加成功";
			v_WangnjService.save(v_Wangnj);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 万能机列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(V_WangnjEntity v_Wangnj, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(v_Wangnj.getId())) {
			v_Wangnj = v_WangnjService.getEntity(V_WangnjEntity.class, v_Wangnj.getId());
			req.setAttribute("v_WangnjPage", v_Wangnj);
		}
		return new ModelAndView("com/shtoone/qms/bhz/v_Wangnj");
	}
}
