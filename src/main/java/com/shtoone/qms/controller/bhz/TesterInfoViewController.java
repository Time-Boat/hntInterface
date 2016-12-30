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

import com.shtoone.qms.entity.bhz.TesterInfoEntity;
import com.shtoone.qms.entity.bhz.TesterInfoViewEntity;
import com.shtoone.qms.service.bhz.TesterInfoServiceI;
import com.shtoone.qms.service.bhz.TesterInfoViewServiceI;

/**   
 * @Title: Controller
 * @Description: 人员信息
 * @author zhangdaihao
 * @date 2015-10-08 14:27:53
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/testerInfoViewController")
public class TesterInfoViewController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TesterInfoViewController.class);

	@Autowired
	private TesterInfoViewServiceI testerInfoViewService;
	
	@Autowired
	private TesterInfoServiceI testerInfoService;
	
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
	 * 人员信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "testerInfoView")
	public ModelAndView testerInfoView(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/testerInfoViewList");
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
	public void datagrid(TesterInfoViewEntity testerInfoView,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		/*CriteriaQuery cq = new CriteriaQuery(TesterInfoViewEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, testerInfoView, request.getParameterMap());
		this.testerInfoViewService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);*/
		
		String pid =request.getParameter("biaoduanid");
		String name =request.getParameter("name");
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
		JSONObject jObject = testerInfoService.getDatagrid(testerInfoView, dataGrid,userlft,userrgt,name);
		responseDatagrid(response, jObject);
	}

	/**
	 * 删除人员信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TesterInfoViewEntity testerInfoView, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		testerInfoView = systemService.getEntity(TesterInfoViewEntity.class, testerInfoView.getId());
		message = "人员信息删除成功";
		testerInfoViewService.delete(testerInfoView);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加人员信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TesterInfoEntity testerInfoView, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(testerInfoView.getId())) {
			message = "人员信息更新成功";
			TesterInfoEntity t = testerInfoViewService.get(TesterInfoEntity.class, testerInfoView.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(testerInfoView, t);
				testerInfoService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "人员信息更新失败";
			}
		} else {
			message = "人员信息添加成功";
			testerInfoService.save(testerInfoView);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 人员信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TesterInfoViewEntity testerInfoView, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(testerInfoView.getId())) {
			TesterInfoEntity testerInfo  = testerInfoViewService.getEntity(TesterInfoEntity.class, testerInfoView.getId());
			req.setAttribute("testerInfoViewPage", testerInfo);
			if(StringUtil.isNotEmpty(testerInfo.getShiyanshiGuid())){
				TSDepart depart = new TSDepart();
				TSDepart tsDepart = new TSDepart();
				depart = systemService.getEntity(TSDepart.class, testerInfo.getShiyanshiGuid());
				tsDepart.setId(depart.getId());
				tsDepart.setDepartname(depart.getDepartname());
				tsDepart.setTSPDepart(depart);
				req.setAttribute("depart", tsDepart);
			}
		}
		return new ModelAndView("com/shtoone/qms/bhz/testerInfoView");
	}
}
