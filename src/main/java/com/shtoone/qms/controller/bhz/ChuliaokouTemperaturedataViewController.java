package com.shtoone.qms.controller.bhz;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
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

import com.shtoone.qms.entity.bhz.ChuliaokouTemperaturedataViewEntity;
import com.shtoone.qms.entity.bhz.ClksmscfgEntity;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.service.bhz.ChuliaokouTemperaturedataViewServiceI;
import com.shtoone.qms.service.bhz.ClksmscfgServiceI;

/**   
 * @Title: Controller
 * @Description: 出料口温度
 * @author zhangdaihao
 * @date 2015-10-16 09:20:30
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/chuliaokouTemperaturedataViewController")
public class ChuliaokouTemperaturedataViewController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ChuliaokouTemperaturedataViewController.class);

	@Autowired
	private ChuliaokouTemperaturedataViewServiceI chuliaokouTemperaturedataViewService;
	
	
	
	@Autowired
	private SystemService systemService;
	private String message;
	private String startTime;
	private String endTime;
	
	private String pid;
	private TSDepart dpt;//上级部门
	
	private Integer userlft = 0;
	private Integer userrgt =0;
	
	private String shebeibianhao;
	
	
	
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public TSDepart getDpt() {
		return dpt;
	}

	public void setDpt(TSDepart dpt) {
		this.dpt = dpt;
	}

	public Integer getUserlft() {
		return userlft;
	}

	public void setUserlft(Integer userlft) {
		this.userlft = userlft;
	}

	public Integer getUserrgt() {
		return userrgt;
	}

	public void setUserrgt(Integer userrgt) {
		this.userrgt = userrgt;
	}

	public String getShebeibianhao() {
		return shebeibianhao;
	}

	public void setShebeibianhao(String shebeibianhao) {
		this.shebeibianhao = shebeibianhao;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 出料口温度列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "chuliaokouTemperaturedataView")
	public ModelAndView chuliaokouTemperaturedataView(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/chuliaokouTemperaturedataViewList");
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
	public void datagrid(ChuliaokouTemperaturedataViewEntity chuliaokouTemperaturedataView,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		startTime = request.getParameter("startTime");
		endTime = request.getParameter("endTime");
		shebeibianhao = request.getParameter("shebeibianhao");
		pid=request.getParameter("pid");
		//System.out.println("pid:"+pid);
		if(pid!=null && pid.length()>0){			
			dpt=systemService.getEntity(TSDepart.class, pid);
			//dpt.setId(pid);
			//List<TSDepart> list=systemService.findByQueryString("from t_s_depart where ID = '"+pid+"'");
			setUserlft(dpt.getLft());
			setUserrgt(dpt.getRgt());
		}else{
			HttpSession session = request.getSession();
			setUserlft(Integer.parseInt( session.getAttribute("userlft").toString()));
			setUserrgt(Integer.parseInt(session.getAttribute("userrgt").toString()));
		}
		if(StringUtil.isEmpty(startTime)&&StringUtil.isEmpty(endTime)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Calendar day = Calendar.getInstance();
			endTime = sdf.format(day.getTime());
			day.add(Calendar.MONTH, -1);
			startTime = sdf.format(day.getTime());
		}
		
		JSONObject jObject = chuliaokouTemperaturedataViewService.getDatagrid3(chuliaokouTemperaturedataView, dataGrid,startTime,endTime, userlft, userrgt,shebeibianhao);
		
		Iterator it = jObject.keys();
		JSONArray array = null;
		while (it.hasNext()){
			String key = (String)it.next();
			if(key.equals("rows")){
				array = jObject.getJSONArray(key);
			}
		}
		String strxml="";
		if (null != array && array.size()>0) {
			strxml=chuliaokouTemperaturedataViewService.getChuliaokouXml(jObject,shebeibianhao);
    	}else{
    		strxml="";
    	}
		System.out.println(strxml+"-0-");
		jObject.put("strXML", strxml);
		
		responseDatagrid(response, jObject);
		/*
		CriteriaQuery cq = new CriteriaQuery(ChuliaokouTemperaturedataViewEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, chuliaokouTemperaturedataView, request.getParameterMap());
		this.chuliaokouTemperaturedataViewService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
		*/
	}

	/**
	 * 删除出料口温度
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ChuliaokouTemperaturedataViewEntity chuliaokouTemperaturedataView, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		chuliaokouTemperaturedataView = systemService.getEntity(ChuliaokouTemperaturedataViewEntity.class, chuliaokouTemperaturedataView.getId());
		message = "出料口温度删除成功";
		chuliaokouTemperaturedataViewService.delete(chuliaokouTemperaturedataView);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加出料口温度
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ChuliaokouTemperaturedataViewEntity chuliaokouTemperaturedataView, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(chuliaokouTemperaturedataView.getId())) {
			message = "出料口温度更新成功";
			ChuliaokouTemperaturedataViewEntity t = chuliaokouTemperaturedataViewService.get(ChuliaokouTemperaturedataViewEntity.class, chuliaokouTemperaturedataView.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(chuliaokouTemperaturedataView, t);
				chuliaokouTemperaturedataViewService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "出料口温度更新失败";
			}
		} else {
			message = "出料口温度添加成功";
			chuliaokouTemperaturedataViewService.save(chuliaokouTemperaturedataView);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 出料口温度列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ChuliaokouTemperaturedataViewEntity chuliaokouTemperaturedataView, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(chuliaokouTemperaturedataView.getId())) {
			chuliaokouTemperaturedataView = chuliaokouTemperaturedataViewService.getEntity(ChuliaokouTemperaturedataViewEntity.class, chuliaokouTemperaturedataView.getId());
			req.setAttribute("chuliaokouTemperaturedataViewPage", chuliaokouTemperaturedataView);
		}
		return new ModelAndView("com/shtoone/qms/bhz/chuliaokouTemperaturedataView");
	}
}
