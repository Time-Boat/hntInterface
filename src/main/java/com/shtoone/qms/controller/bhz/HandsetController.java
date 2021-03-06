package com.shtoone.qms.controller.bhz;
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

import com.shtoone.qms.entity.bhz.HandsetEntity;
import com.shtoone.qms.service.bhz.HandsetServiceI;

@Controller
@RequestMapping("/handsetController")
public class HandsetController extends BaseController {

	@Autowired
	private HandsetServiceI handsetService;
	
	@Autowired
	private SystemService systemService;
	
	private String message;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@RequestMapping(params = "handset")
	public ModelAndView handset(HttpServletRequest request) {
		// 给部门查询条件中的下拉框准备数据
		List<TSDepart> departList = systemService.getList(TSDepart.class);
		request.setAttribute("departsReplace", RoletoJson.listToReplaceStr(departList, "departname", "id"));
		return new ModelAndView("com/shtoone/qms/bhz/handsetList");
	}

	@RequestMapping(params = "datagrid")
	public void datagrid(HandsetEntity handset,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String departid=request.getParameter("departid");//所属机构编号
		HttpSession session = request.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt =session.getAttribute("userrgt").toString();
		if(departid!=null && departid.length()>0){
			TSDepart dpt=systemService.getEntity(TSDepart.class, departid);
			userlft=dpt.getLft()+"";
			userrgt=dpt.getRgt()+"";
		}
		
		JSONObject jObject = handsetService.getDatagrid3(handset, dataGrid,departid, userlft, userrgt);
		responseDatagrid(response, jObject);
	}
	
	
	

	/**
	 * 删除报警手机号码配置
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(HandsetEntity handset, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		handset = systemService.getEntity(HandsetEntity.class, handset.getId());
		message = "报警手机号码配置删除成功";
		handsetService.delete(handset);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加报警手机号码配置
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(HandsetEntity handset, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(handset.getId())) {
			message = "报警手机号码配置更新成功";
			HandsetEntity t = handsetService.get(HandsetEntity.class, handset.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(handset, t);
				handsetService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "报警手机号码配置更新失败";
			}
		} else {
			message = "报警手机号码配置添加成功";
			handsetService.save(handset);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 报警手机号码配置列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(HandsetEntity handset, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(handset.getId())) {
			handset = handsetService.getEntity(HandsetEntity.class, handset.getId());
			req.setAttribute("handsetPage", handset);
			TSDepart depart = systemService.getEntity(TSDepart.class, handset.getBiaoduan());
			req.setAttribute("departName", depart.getDepartname());
		}else{
			req.setAttribute("departName", "");
		}
		return new ModelAndView("com/shtoone/qms/bhz/handset");
	}
}
