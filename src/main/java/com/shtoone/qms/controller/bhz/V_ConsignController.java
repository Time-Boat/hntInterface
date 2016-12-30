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

import com.shtoone.qms.entity.bhz.V_ConsignEntity;
import com.shtoone.qms.service.bhz.V_ConsignServiceI;

/**   
 * @Title: Controller
 * @Description: 试验主表
 * @author zhangdaihao
 * @date 2015-07-07 18:13:16
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/V_ConsignController")
public class V_ConsignController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(V_ConsignController.class);

	@Autowired
	private V_ConsignServiceI V_ConsignService;
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
	@RequestMapping(params = "V_Consign")
	public ModelAndView V_Consign(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/V_ConsignList");
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
	public void datagrid(V_ConsignEntity V_Consign,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//		CriteriaQuery cq = new CriteriaQuery(V_ConsignEntity.class, dataGrid);
		
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
		JSONObject jObject = V_ConsignService.getDatagrid(V_Consign, dataGrid,userlft,userrgt,starttime,endtime);
		responseDatagrid(response, jObject);
		//查询条件组装器
		/*org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, V_Consign, request.getParameterMap());
		this.V_ConsignService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);*/
	}
	

	/**
	 * 删除试验主表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(V_ConsignEntity V_Consign, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		V_Consign = systemService.getEntity(V_ConsignEntity.class, V_Consign.getId());
		message = "试验主表删除成功";
		V_ConsignService.delete(V_Consign);
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
	public AjaxJson save(V_ConsignEntity V_Consign, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(V_Consign.getId())) {
			message = "试验主表更新成功";
			V_ConsignEntity t = V_ConsignService.get(V_ConsignEntity.class, V_Consign.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(V_Consign, t);
				V_ConsignService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "试验主表更新失败";
			}
		} else {
			message = "试验主表添加成功";
			V_ConsignService.save(V_Consign);
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
	public ModelAndView addorupdate(V_ConsignEntity V_Consign, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(V_Consign.getId())) {
			V_Consign = V_ConsignService.getEntity(V_ConsignEntity.class, V_Consign.getId());
			req.setAttribute("V_ConsignPage", V_Consign);
		}
		return new ModelAndView("com/shtoone/qms/bhz/V_Consign");
	}
}
