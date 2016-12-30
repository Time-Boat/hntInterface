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
import org.jeecgframework.web.demo.entity.test.JeecgJdbcEntity;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.shtoone.qms.entity.bhz.HntviewEntity;
import com.shtoone.qms.entity.bhz.Xiangxixx2015Entity;
import com.shtoone.qms.fusioncharts.FusionChartsCreator;
import com.shtoone.qms.service.bhz.Xiangxixx2015ServiceI;

/**   
 * @Title: Controller
 * @Description: Xiangxixx2015
 * @author zhangdaihao
 * @date 2015-06-07 17:21:08
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/Xiangxixx2015Controller")
public class Xiangxixx2015Controller extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(Xiangxixx2015Controller.class);

	@Autowired
	private Xiangxixx2015ServiceI Xiangxixx2015Service;
	@Autowired
	private SystemService systemService;
	private String message;
	private StringBuilder strXML ;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * Xiangxixx2015列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "Xiangxixx2015")
	public ModelAndView Xiangxixx2015(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/xiangxixx2015List");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

/*	@RequestMapping(params = "datagrid")
	public void datagrid(Xiangxixx2015Entity Xiangxixx2015,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(Xiangxixx2015Entity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, Xiangxixx2015, request.getParameterMap());
		this.Xiangxixx2015Service.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}*/
	
	@RequestMapping(params = "datagrid")
	public void datagrid(HntviewEntity hnt,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		// 方式1, 用底层自带的方式往对象中设值  -------------------
		/*
		this.jeecgJdbcService.getDatagrid1(jeecgJdbc, dataGrid);
		TagUtil.datagrid(response, dataGrid);
		// end of 方式1 ========================================= */ 
		
		// 方式2, 取值自己处理(代码量多一些，但执行效率应该会稍高一些)  -------------------------------
		/*
		this.jeecgJdbcService.getDatagrid2(jeecgJdbc, dataGrid);
		TagUtil.datagrid(response, dataGrid);
		// end of 方式2 ========================================= */ 
		
		// 方式3, 取值进一步自己处理(直接转换成easyUI的datagrid需要的东西，执行效率最高，最自由)  -------------------------------
		//*
		HttpSession session = request.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt =session.getAttribute("userrgt").toString();		
		JSONObject jObject = this.Xiangxixx2015Service.getDatagrid3(hnt, dataGrid, userlft, userrgt);
		System.out.println(jObject.toString());
		strXML = new StringBuilder("");
		if(jObject.toString().contains(":'2'"))
		{
			
			strXML.append("<?xml version='1.0' encoding='utf-8'?><chart caption='拌和时间走势图' subcaption='(");
			strXML.append("2015-06-17");
			strXML.append("至");
			strXML.append("2015-06-17");
			strXML.append(")' lineThickness='2' showValues='0' anchorRadius='2' ");
			strXML.append("divLineAlpha='20' divLineColor='CC3300' divLineIsDashed='1' slantLabels='1' ");
			strXML.append("showAlternateHGridColor='1' alternateHGridColor='CC3300' shadowAlpha='40' ");
			strXML.append("labelStep='");
			strXML.append(3/5);
			strXML.append("' numvdivlines='15' chartRightMargin='35' chartLeftMargin='35' ");
			strXML.append("bgColor='FFFFFF,CC3300' bgAngle='270' bgAlpha='10,10' alternateHGridAlpha='5' numberSuffix='s'> ");
			strXML.append("<categories>");
			strXML.append("<category label='");
			strXML.append("2015-06-01 01:00:00");
			strXML.append("'/>");
			strXML.append("<category label='");
			strXML.append("2015-06-01 02:00:00");
			strXML.append("'/>");
			strXML.append("<category label='");
			strXML.append("2015-06-01 03:00:00");
			strXML.append("'/>");
			strXML.append("</categories>");
			strXML.append("<dataset color='F1683C' anchorBorderColor='F1683C' anchorBgColor='F1683C'>");
			strXML.append("<set value='");
			strXML.append("90");
			strXML.append("'/>");
			strXML.append("<set value='");
			strXML.append("100");
			strXML.append("'/>");
			strXML.append("<set value='");
			strXML.append("120");
			strXML.append("'/>");
			strXML.append("</dataset>");
			strXML.append(" <styles>");
	        strXML.append(" <definition>"); 
	        strXML.append(" <style type='font' name='captionFont' size='12'/>"); 
	        strXML.append(" </definition>"); 
	        strXML.append(" <application>"); 
	        strXML.append(" <apply toObject='Caption' styles='captionFont' />"); 
	        strXML.append(" <apply toObject='SubCaption' styles='SubcaptionFont' />"); 
	        strXML.append(" </application>"); 
	        strXML.append(" </styles>"); 
	        strXML.append(" </chart>");         
			
			
		}
		else {
		strXML.append("<?xml version='1.0' encoding='utf-8'?><chart caption='拌和时间走势图' subcaption='(");
		strXML.append("2015-06-17");
		strXML.append("至");
		strXML.append("2015-06-17");
		strXML.append(")' lineThickness='2' showValues='0' anchorRadius='2' ");
		strXML.append("divLineAlpha='20' divLineColor='CC3300' divLineIsDashed='1' slantLabels='1' ");
		strXML.append("showAlternateHGridColor='1' alternateHGridColor='CC3300' shadowAlpha='40' ");
		strXML.append("labelStep='");
		strXML.append(3/5);
		strXML.append("' numvdivlines='15' chartRightMargin='35' chartLeftMargin='35' ");
		strXML.append("bgColor='FFFFFF,CC3300' bgAngle='270' bgAlpha='10,10' alternateHGridAlpha='5' numberSuffix='s'> ");
		strXML.append("<categories>");
		strXML.append("<category label='");
		strXML.append("2015-06-01 01:00:00");
		strXML.append("'/>");
		strXML.append("<category label='");
		strXML.append("2015-06-01 02:00:00");
		strXML.append("'/>");
		strXML.append("<category label='");
		strXML.append("2015-06-01 03:00:00");
		strXML.append("'/>");
		strXML.append("</categories>");
		strXML.append("<dataset color='F1683C' anchorBorderColor='F1683C' anchorBgColor='F1683C'>");
		strXML.append("<set value='");
		strXML.append("60");
		strXML.append("'/>");
		strXML.append("<set value='");
		strXML.append("70");
		strXML.append("'/>");
		strXML.append("<set value='");
		strXML.append("80");
		strXML.append("'/>");
		strXML.append("</dataset>");
		strXML.append(" <styles>");
        strXML.append(" <definition>"); 
        strXML.append(" <style type='font' name='captionFont' size='12'/>"); 
        strXML.append(" </definition>"); 
        strXML.append(" <application>"); 
        strXML.append(" <apply toObject='Caption' styles='captionFont' />"); 
        strXML.append(" <apply toObject='SubCaption' styles='SubcaptionFont' />"); 
        strXML.append(" </application>"); 
        strXML.append(" </styles>"); 
        strXML.append(" </chart>");         
		
		}
		request.setAttribute("strXML", FusionChartsCreator.createChart("/qms/plug-in/main/FusionCharts/MSLine.swf", "",strXML.toString(), "chartbanheshijian", 1000, 200, false, false));
		responseDatagrid(response, jObject);
		// end of 方式3 ========================================= */
	}

	/**
	 * 删除Xiangxixx2015
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(Xiangxixx2015Entity Xiangxixx2015, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		Xiangxixx2015 = systemService.getEntity(Xiangxixx2015Entity.class, Xiangxixx2015.getId());
		message = "Xiangxixx2015删除成功";
		Xiangxixx2015Service.delete(Xiangxixx2015);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加Xiangxixx2015
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(Xiangxixx2015Entity Xiangxixx2015, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(Xiangxixx2015.getId())) {
			message = "Xiangxixx2015更新成功";
			Xiangxixx2015Entity t = Xiangxixx2015Service.get(Xiangxixx2015Entity.class, Xiangxixx2015.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(Xiangxixx2015, t);
				Xiangxixx2015Service.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "Xiangxixx2015更新失败";
			}
		} else {
			message = "Xiangxixx2015添加成功";
			Xiangxixx2015Service.save(Xiangxixx2015);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * Xiangxixx2015列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(Xiangxixx2015Entity Xiangxixx2015, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(Xiangxixx2015.getId())) {
			Xiangxixx2015 = Xiangxixx2015Service.getEntity(Xiangxixx2015Entity.class, Xiangxixx2015.getId());
			req.setAttribute("Xiangxixx2015Page", Xiangxixx2015);
		}
		return new ModelAndView("com/shtoone/qms/bhz/Xiangxixx2015");
	}
}
