package com.shtoone.qms.controller.bhz;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.ComboTree;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.tag.vo.easyui.ComboTreeModel;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.shtoone.qms.entity.bhz.SmsrecordEntity;
import com.shtoone.qms.entity.bhz.SmsrecordViewEntity;
import com.shtoone.qms.fusioncharts.FusionChartsCreator;
import com.shtoone.qms.service.bhz.SmsrecordServiceI;

/**   
 * @Title: Controller
 * @Description: 短信充值
 * @author zhangdaihao
 * @date 2015-06-11 11:23:15
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/smsrecordController")
public class SmsrecordController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SmsrecordController.class);

	@Autowired
	private SmsrecordServiceI smsrecordService;
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
	 * 短信充值列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "smsrecord")
	public ModelAndView smsrecord(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/smsrecordList");
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
	public void datagrid(SmsrecordEntity smsrecord,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SmsrecordViewEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, smsrecord, request.getParameterMap());
		this.smsrecordService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除短信充值
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SmsrecordEntity smsrecord, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		smsrecord = systemService.getEntity(SmsrecordEntity.class, smsrecord.getId());
		message = "短信充值删除成功";
		smsrecordService.delete(smsrecord);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加短信充值
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SmsrecordEntity smsrecord, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(smsrecord.getId())) {
			message = "短信充值更新成功";
			SmsrecordEntity t = smsrecordService.get(SmsrecordEntity.class, smsrecord.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(smsrecord, t);
				smsrecordService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "短信充值更新失败";
			}
		} else {
			message = "短信充值添加成功";
			smsrecordService.save(smsrecord);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 短信充值列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SmsrecordEntity smsrecord, HttpServletRequest req) {			
		if (StringUtil.isNotEmpty(smsrecord.getId())) {
			smsrecord = smsrecordService.getEntity(SmsrecordEntity.class, smsrecord.getId());
			req.setAttribute("smsrecordPage", smsrecord);			
		
			TSDepart depart = systemService.getEntity(TSDepart.class, smsrecord.getDepartid());
			req.setAttribute("depart", depart);
		}
		return new ModelAndView("com/shtoone/qms/bhz/smsrecord");
	}
	
	@RequestMapping(params = "setDepart")
	@ResponseBody
	public List<ComboTree> setDepart(HttpServletRequest request, ComboTree comboTree) {		
		CriteriaQuery cq = new CriteriaQuery(TSDepart.class);		
		if (comboTree.getId() != null) {
			cq.eq("TSPDepart.id", comboTree.getId());
		}
		if (comboTree.getId() == null) {
			cq.isNull("TSPDepart");
		}
		cq.add();
		List<TSDepart> departsList = systemService.getListByCriteriaQuery(cq, false);
		List<ComboTree> comboTrees = new ArrayList<ComboTree>();
		ComboTreeModel comboTreeModel = new ComboTreeModel("id", "departname", "TSDeparts");
		comboTrees = systemService.ComboTree(departsList, comboTreeModel, null);
		return comboTrees;

	}
}
