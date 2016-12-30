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

import com.shtoone.qms.entity.bhz.V_SmsinfoEntity;
import com.shtoone.qms.service.bhz.V_SmsinfoServiceI;

/**   
 * @Title: Controller
 * @Description: 试验主表
 * @author zhangdaihao
 * @date 2015-07-07 18:13:16
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/V_SmsinfoController")
public class V_SmsinfoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(V_SmsinfoController.class);

	@Autowired
	private V_SmsinfoServiceI V_SmsinfoService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	private Integer userlft = 0;
	private Integer userrgt =0;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
	 * 试验主表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "V_Smsinfo")
	public ModelAndView V_Smsinfo(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/V_SmsinfoList");
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
	public void datagrid(V_SmsinfoEntity V_Smsinfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//		CriteriaQuery cq = new CriteriaQuery(V_SmsinfoEntity.class, dataGrid);
		
		String pid =request.getParameter("biaoduanid");
		String starttime =request.getParameter("starttime");
		String endtime =request.getParameter("endtime");
		if(pid!=null && pid.length()>0){
			TSDepart dpt=systemService.getEntity(TSDepart.class, pid);
			//dpt.setId(pid);
			//List<TSDepart> list=systemService.findByQueryString("from t_s_depart where ID = '"+pid+"'");
			setUserlft( dpt.getLft() );
			setUserrgt( dpt.getRgt() );
		}else{
			HttpSession session = request.getSession();
			setUserlft(Integer.parseInt( session.getAttribute("userlft").toString()));
			setUserrgt(Integer.parseInt(session.getAttribute("userrgt").toString()));
		}
		if (StringUtil.isEmpty(starttime)&&StringUtil.isEmpty(endtime)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar day = Calendar.getInstance();
			endtime=sdf.format(day.getTime());
			day.add(Calendar.MONTH, -1);
			starttime=sdf.format(day.getTime());
		}
		JSONObject jObject = V_SmsinfoService.getDatagrid(V_Smsinfo, dataGrid,userlft,userrgt,starttime,endtime);
		responseDatagrid(response, jObject);
		//查询条件组装器
		/*org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, V_Smsinfo, request.getParameterMap());
		this.V_SmsinfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);*/
	}
	
	



}
