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
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.shtoone.qms.entity.ShiyanshiInfoEntity;
import com.shtoone.qms.entity.bhz.V_ShiyanshiInfoEntity;
import com.shtoone.qms.service.bhz.ShiyanshiInfoServiceI;
import com.shtoone.qms.service.bhz.V_ShiyanshiInfoServiceI;

/**   
 * @Title: Controller
 * @Description: 试验室设置
 * @author zhangdaihao
 * @date 2015-07-06 17:01:38
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/v_ShiyanshiInfoController")
public class V_ShiyanshiInfoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(V_ShiyanshiInfoController.class);

	@Autowired
	private V_ShiyanshiInfoServiceI v_ShiyanshiInfoService;
	
	@Autowired
	private ShiyanshiInfoServiceI ShiyanshiInfoService;
	
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
	 * 试验室设置列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "v_ShiyanshiInfo")
	public ModelAndView v_ShiyanshiInfo(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/v_ShiyanshiInfoList");
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
	public void datagrid(V_ShiyanshiInfoEntity v_ShiyanshiInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		/*CriteriaQuery cq = new CriteriaQuery(V_ShiyanshiInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, v_ShiyanshiInfo, request.getParameterMap());
		this.v_ShiyanshiInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);*/
		
		String pid =request.getParameter("biaoduanid");
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
		JSONObject jObject = v_ShiyanshiInfoService.getDatagrid(v_ShiyanshiInfo, dataGrid,userlft,userrgt);
		responseDatagrid(response, jObject);
	}

	/**
	 * 删除试验室设置
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(V_ShiyanshiInfoEntity v_ShiyanshiInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		ShiyanshiInfoEntity ShiyanshiInfo = systemService.getEntity(ShiyanshiInfoEntity.class, v_ShiyanshiInfo.getId());
		message = "试验室设置删除成功";
		ShiyanshiInfoService.delete(ShiyanshiInfo);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加试验室设置
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(ShiyanshiInfoEntity v_ShiyanshiInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(v_ShiyanshiInfo.getId())) {
			message = "试验室设置更新成功";
			ShiyanshiInfoEntity t = v_ShiyanshiInfoService.get(ShiyanshiInfoEntity.class, v_ShiyanshiInfo.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(v_ShiyanshiInfo, t);
				t.setId(v_ShiyanshiInfo.getId());
				t.setShiyanshiGuid(request.getParameter("shiyanshiGuid"));
				ShiyanshiInfoService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "试验室设置更新失败";
			}
		} else {
			message = "试验室设置添加成功";
			v_ShiyanshiInfo.setId(v_ShiyanshiInfo.getId());
			v_ShiyanshiInfo.setShiyanshiGuid(request.getParameter("shiyanshiGuid"));
			ShiyanshiInfoService.save(v_ShiyanshiInfo);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 试验室设置列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(V_ShiyanshiInfoEntity v_ShiyanshiInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(v_ShiyanshiInfo.getId())) {
			ShiyanshiInfoEntity	ShiyanshiInfo = ShiyanshiInfoService.getEntity(ShiyanshiInfoEntity.class, v_ShiyanshiInfo.getId());
			req.setAttribute("v_ShiyanshiInfoPage", ShiyanshiInfo);
			if(StringUtil.isNotEmpty(ShiyanshiInfo.getShiyanshiGuid())){
				TSDepart depart = new TSDepart();
				TSDepart tsDepart = new TSDepart();
				depart = systemService.getEntity(TSDepart.class, ShiyanshiInfo.getShiyanshiGuid());
				tsDepart.setId(depart.getId());
				tsDepart.setDepartname(depart.getDepartname());
				tsDepart.setTSPDepart(depart);
				req.setAttribute("depart", tsDepart);
			}
		}
		return new ModelAndView("com/shtoone/qms/bhz/v_ShiyanshiInfo");
	}
}
