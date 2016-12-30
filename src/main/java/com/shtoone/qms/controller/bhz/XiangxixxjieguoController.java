package com.shtoone.qms.controller.bhz;
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
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.shtoone.qms.entity.bhz.XiangxixxjieguoEntity;
import com.shtoone.qms.service.bhz.XiangxixxjieguoServiceI;

/**   
 * @Title: Controller
 * @Description: 水泥混凝土超标结果表
 * @author zhangdaihao
 * @date 2015-06-18 14:47:50
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/xiangxixxjieguoController")
public class XiangxixxjieguoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(XiangxixxjieguoController.class);

	@Autowired
	private XiangxixxjieguoServiceI xiangxixxjieguoService;
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
	 * 水泥混凝土超标结果表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "xiangxixxjieguo")
	public ModelAndView xiangxixxjieguo(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/entity/bhz/xiangxixxjieguoList");
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
	public void datagrid(XiangxixxjieguoEntity xiangxixxjieguo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(XiangxixxjieguoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, xiangxixxjieguo, request.getParameterMap());
		this.xiangxixxjieguoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除水泥混凝土超标结果表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(XiangxixxjieguoEntity xiangxixxjieguo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		xiangxixxjieguo = systemService.getEntity(XiangxixxjieguoEntity.class, xiangxixxjieguo.getId());
		message = "水泥混凝土超标结果表删除成功";
		xiangxixxjieguoService.delete(xiangxixxjieguo);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加水泥混凝土超标结果表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(XiangxixxjieguoEntity xiangxixxjieguo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(xiangxixxjieguo.getId())) {
			message = "水泥混凝土超标结果表更新成功";
			XiangxixxjieguoEntity t = xiangxixxjieguoService.get(XiangxixxjieguoEntity.class, xiangxixxjieguo.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(xiangxixxjieguo, t);
				xiangxixxjieguoService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "水泥混凝土超标结果表更新失败";
			}
		} else {
			message = "水泥混凝土超标结果表添加成功";
			xiangxixxjieguoService.save(xiangxixxjieguo);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 水泥混凝土超标结果表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(XiangxixxjieguoEntity xiangxixxjieguo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(xiangxixxjieguo.getId())) {
			xiangxixxjieguo = xiangxixxjieguoService.getEntity(XiangxixxjieguoEntity.class, xiangxixxjieguo.getId());
			req.setAttribute("xiangxixxjieguoPage", xiangxixxjieguo);
		}
		return new ModelAndView("com/shtoone/qms/entity/bhz/xiangxixxjieguo");
	}
}
