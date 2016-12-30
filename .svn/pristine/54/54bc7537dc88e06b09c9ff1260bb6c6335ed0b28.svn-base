package com.shtoone.qms.controller.bhz;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.jeecgframework.core.util.RoletoJson;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.shtoone.qms.entity.bhz.SmsinfoViewEntity;
import com.shtoone.qms.service.bhz.SmsinfoViewServiceI;


@Controller
@RequestMapping("/smsinfoViewController")
public class SmsinfoViewController extends BaseController {

	@Autowired
	private SmsinfoViewServiceI smsinfoViewService;
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
	 * 发送短信查询列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "smsinfoView")
	public ModelAndView smsinfoView(HttpServletRequest request) {
		// 给部门查询条件中的下拉框准备数据
		List<TSDepart> departList = systemService.getList(TSDepart.class);
		request.setAttribute("departsReplace", RoletoJson.listToReplaceStr(departList, "departname", "id"));
		return new ModelAndView("com/shtoone/qms/bhz/smsinfoViewList");
	}

	@RequestMapping(params = "datagrid")
	public void datagrid(SmsinfoViewEntity smsinfoView,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String departid=request.getParameter("departid");//所属机构编号
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String shebeibianhao=request.getParameter("shebeibianhao");
		if (StringUtil.isEmpty(startTime) && StringUtil.isEmpty(endTime)) {//如果日期都为空则默认查询最近一月
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar day = Calendar.getInstance();
			endTime=sdf.format(day.getTime());
			day.add(Calendar.MONTH, -1);
			startTime=sdf.format(day.getTime());
		}
		HttpSession session = request.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt =session.getAttribute("userrgt").toString();
		
		if(departid!=null && departid.length()>0){
			TSDepart dpt=systemService.getEntity(TSDepart.class, departid);
			userlft=dpt.getLft()+"";
			userrgt=dpt.getRgt()+"";
		}
		
		JSONObject jObject = smsinfoViewService.getDatagrid3(smsinfoView, dataGrid,departid,startTime,endTime,userlft,userrgt,shebeibianhao);
		responseDatagrid(response, jObject);
	}

	/**
	 * 删除发送短信查询
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SmsinfoViewEntity smsinfoView, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		smsinfoView = systemService.getEntity(SmsinfoViewEntity.class, smsinfoView.getId());
		message = "发送短信查询删除成功";
		smsinfoViewService.delete(smsinfoView);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加发送短信查询
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SmsinfoViewEntity smsinfoView, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(smsinfoView.getId())) {
			message = "发送短信查询更新成功";
			SmsinfoViewEntity t = smsinfoViewService.get(SmsinfoViewEntity.class, smsinfoView.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(smsinfoView, t);
				smsinfoViewService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "发送短信查询更新失败";
			}
		} else {
			message = "发送短信查询添加成功";
			smsinfoViewService.save(smsinfoView);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 发送短信查询列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SmsinfoViewEntity smsinfoView, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(smsinfoView.getId())) {
			smsinfoView = smsinfoViewService.getEntity(SmsinfoViewEntity.class, smsinfoView.getId());
			req.setAttribute("smsinfoViewPage", smsinfoView);
		}
		return new ModelAndView("com/shtoone/qms/bhz/smsinfoView");
	}
}
