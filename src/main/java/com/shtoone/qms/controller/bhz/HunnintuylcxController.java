package com.shtoone.qms.controller.bhz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.entity.bhz.HunnintuView;
import com.shtoone.qms.service.bhz.HntbhzziduancfgViewServiceI;
import com.shtoone.qms.service.bhz.HunnintuViewServiceI;

/**    
 * @Title: Controller
 * @Description: 拌合站用量查询
 * @author zhangdaihao
 * @date 2015-06-18 09:35:27
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/HunnintuylcxController")
public class HunnintuylcxController extends BaseController {
	
	@Autowired
	private HunnintuViewServiceI hunnintuViewService;
	
	@Autowired
	private HntbhzziduancfgViewServiceI  hntbhzziduancfgViewService; 
	
	@Autowired
	private SystemService systemService;
	

	private String message;
	private String startTime;
	private String endTime;
	private String jiaozuobuwei;
	private String gongchengmingcheng;
	private String pid;
	private TSDepart dpt;//上级部门
	private Integer userlft = 0;
	private Integer userrgt =0;
	private String shebeibianhao;
	
	public String getShebeibianhao() {
		return shebeibianhao;
	}

	public void setShebeibianhao(String shebeibianhao) {
		this.shebeibianhao = shebeibianhao;
	}

	public TSDepart getDpt() {
		return dpt;
	}

	public void setDpt(TSDepart dpt) {
		this.dpt = dpt;
	}

	public String getGongchengmingcheng() {
		return gongchengmingcheng;
	}

	public void setGongchengmingcheng(String gongchengmingcheng) {
		this.gongchengmingcheng = gongchengmingcheng;
	}

	public String getJiaozuobuwei() {
		return jiaozuobuwei;
	}

	public void setJiaozuobuwei(String jiaozuobuwei) {
		this.jiaozuobuwei = jiaozuobuwei;
	}

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
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

	/**
	 * 拌合站用量查询列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "hunnintuylcxlist")
	public ModelAndView hunnintuViewList(HttpServletRequest request) {
		HntbhzziduancfgViewEntity hbfield = hntbhzziduancfgViewService.gethntcfgfield(shebeibianhao);
		HntbhzziduancfgViewEntity hntbhzisShow = hntbhzziduancfgViewService.gethntbhzisShow(shebeibianhao);
		pid=request.getParameter("pid");
		if(StringUtil.isNotEmpty(pid)){
			TSDepart tspDepart = new TSDepart();
			TSDepart tsDepart = new TSDepart();
			TSDepart depart = systemService.getEntity(TSDepart.class, pid);
			tspDepart.setId(depart.getId());
			tspDepart.setDepartname(depart.getDepartname());
			tsDepart.setTSPDepart(tspDepart);
			request.setAttribute("depart", tsDepart);
		}
		request.setAttribute("hbfield", hbfield);
		request.setAttribute("hntbhzisShow", hntbhzisShow);
		return new ModelAndView("com/shtoone/qms/bhz/hunnintuylcxlist");
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
	public void datagrid(HunnintuView hunnintuView,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String shebeibianhao=request.getParameter("shebeibianhao");//设备编号
		String jiaozuobuwei=request.getParameter("jiaozuobuwei");//浇筑部位
		String startTime=request.getParameter("startTime");//出料开始时间
		String endTime=request.getParameter("endTime");//出料结束时间
		pid=request.getParameter("pid");
		if(StringUtil.isNotEmpty(pid)){			
			dpt=systemService.getEntity(TSDepart.class, pid);
			setUserlft(dpt.getLft());
			setUserrgt(dpt.getRgt());
		}else{
			HttpSession session = request.getSession();
			setUserlft(Integer.parseInt( session.getAttribute("userlft").toString()));
			setUserrgt(Integer.parseInt(session.getAttribute("userrgt").toString()));
		}
		String gongchengmingcheng=request.getParameter("gongchengmingcheng");//工程名称
		if (StringUtil.isEmpty(startTime)&&StringUtil.isEmpty(endTime)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Calendar day = Calendar.getInstance();
			endTime=sdf.format(day.getTime());
			day.add(Calendar.MONTH, -1);
			startTime=sdf.format(day.getTime());
		}
		
		HntbhzziduancfgViewEntity hbfield = hntbhzziduancfgViewService.gethntcfgfield(shebeibianhao);
		HntbhzziduancfgViewEntity hntbhzisShow = hntbhzziduancfgViewService.gethntbhzisShow(shebeibianhao);
		JSONObject jObject = hntbhzziduancfgViewService.getDatagrid3(hunnintuView, dataGrid,startTime,endTime, userlft, userrgt,jiaozuobuwei,gongchengmingcheng,shebeibianhao);
		Iterator it = jObject.keys();	
		JSONArray array = null;
		while (it.hasNext()) {
			String key = (String) it.next();
			if (key.equals("rows")){
				array = jObject.getJSONArray(key);			
			}
		}
		String strxml="";
		
		if (null != array && array.size()>0) {
			strxml=hntbhzziduancfgViewService.getHntAnalysisColumnXml(jObject,dataGrid,hbfield,hntbhzisShow);
    	}else{
    		strxml="";
    	}
		jObject.put("strXML", strxml);
		jObject.put("hbfield", hbfield);
		jObject.put("hntbhzisShow", hntbhzisShow);
		responseDatagrid(response, jObject);
		
	}
	
	//获取对应的字段名及是否显示
	@RequestMapping(params = "getFiled")
	public void getFiled(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String shebeibianhao=request.getParameter("shebeibianhao");//设备编号
		
		HntbhzziduancfgViewEntity hbfield = hntbhzziduancfgViewService.gethntcfgfield(shebeibianhao);
		HntbhzziduancfgViewEntity hntbhzisShow = hntbhzziduancfgViewService.gethntbhzisShow(shebeibianhao);
		JSONObject jObject = new JSONObject();

		jObject.put("hbfield", hbfield);
		jObject.put("hntbhzisShow", hntbhzisShow);
		responseDatagrid(response, jObject);
	}
	

	/**
	 * 删除拌合站时间查询
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(HunnintuView hunnintuView, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		hunnintuView = systemService.getEntity(HunnintuView.class, hunnintuView.getId());
		message = "拌合站时间查询删除成功";
		hunnintuViewService.delete(hunnintuView);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加拌合站时间查询
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(HunnintuView hunnintuView, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(hunnintuView.getId())) {
			message = "拌合站时间查询更新成功";
			HunnintuView t = hunnintuViewService.get(HunnintuView.class, hunnintuView.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(hunnintuView, t);
				hunnintuViewService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "拌合站时间查询更新失败";
			}
		} else {
			message = "拌合站时间查询添加成功";
			hunnintuViewService.save(hunnintuView);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 拌合站时间查询列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(HunnintuView hunnintuView, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hunnintuView.getId())) {		
			hunnintuView = hunnintuViewService.getEntity(HunnintuView.class, hunnintuView.getId());
			req.setAttribute("hunnintuViewPage", hunnintuView);
			HntbhzziduancfgViewEntity hbfield = hntbhzziduancfgViewService.gethntcfgfield(hunnintuView.getShebeibianhao());	
			HntbhzziduancfgViewEntity hntbhzisShow = hntbhzziduancfgViewService.gethntbhzisShow(hunnintuView.getShebeibianhao());
			req.setAttribute("hbfield",hbfield);
			req.setAttribute("hntbhzisShow",hntbhzisShow);
		}
		return new ModelAndView("com/shtoone/qms/bhz/hunnintuView");
	}

}
