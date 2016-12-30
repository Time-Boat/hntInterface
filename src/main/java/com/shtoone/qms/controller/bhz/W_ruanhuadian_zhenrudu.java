package com.shtoone.qms.controller.bhz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;
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

import com.shtoone.qms.entity.bhz.BanhezhanfasongEntity;
import com.shtoone.qms.entity.bhz.W_ruanhuadian_MView;
import com.shtoone.qms.entity.bhz.W_zhenrudu_MView;
import com.shtoone.qms.service.bhz.BanhezhanfasongServiceI;

@Controller
@RequestMapping("/W_rhd_zrd")
public class W_ruanhuadian_zhenrudu extends BaseController {

	private static final Logger logger = Logger.getLogger(W_ruanhuadian_zhenrudu.class);
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
	 * 接口管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "ruanhuadian")
	public ModelAndView ruanhuadian(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/ruanhuadianList");
	}

	@RequestMapping(params = "zhenrudu")
	public ModelAndView zhenrudu(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/zhenruduList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "rhddatagrid")
	public void rhddatagrid(W_ruanhuadian_MView ruanhuadian, HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(W_ruanhuadian_MView.class, dataGrid);
		// 查询条件组装器
		String pid = request.getParameter("pid");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String fzlx = request.getParameter("fzlx");
		String shebeibianhao = request.getParameter("shebeibianhao");
		String gcmc = request.getParameter("gcmc");
		String gcbw = request.getParameter("gcbw");
		String ypmc = request.getParameter("ypmc");
		String ypbh = request.getParameter("ypbh");
		if (StringUtil.isNotEmpty(pid)) {
			TSDepart depart = systemService.getEntity(TSDepart.class, pid);
			cq.ge("lft", depart.getLft().toString());
			cq.le("rgt", depart.getRgt().toString());
		} else {
			HttpSession session = request.getSession();
			cq.ge("lft", session.getAttribute("userlft").toString());
			cq.le("rgt", session.getAttribute("userrgt").toString());
		}
		if (StringUtil.isNotEmpty(startTime)) {
			cq.ge("TIME", startTime);
		}
		if (StringUtil.isNotEmpty(endTime)) {
			cq.le("TIME", endTime);
		}
		if (StringUtil.isNotEmpty(fzlx)) {
			if("1".equals(fzlx)){
				cq.eq("isQualified", "合格");
			}else if("2".equals(fzlx)){
				cq.eq("isQualified", "不合格");
			}
		}
		if (StringUtil.isNotEmpty(shebeibianhao)) {
			cq.eq("gprsbianhao", shebeibianhao);
		}
		if (StringUtil.isNotEmpty(gcmc)) {
			cq.like("projectName", "%"+gcmc+"%");
		}
		if (StringUtil.isNotEmpty(gcbw)) {
			cq.like("GCBuWei", "%"+gcbw+"%");
		}
		if (StringUtil.isNotEmpty(ypmc)) {
			cq.like("sampleName", "%"+ypmc+"%");
		}
		if (StringUtil.isNotEmpty(ypbh)) {
			cq.like("sampleNo", "%"+ypbh+"%");
		}
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, new W_ruanhuadian_MView(),
				request.getParameterMap());
		this.systemService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "zrddatagrid")
	public void zrddatagrid(W_zhenrudu_MView zhenrudu, HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(W_zhenrudu_MView.class, dataGrid);
		// 查询条件组装器
		String pid = request.getParameter("pid");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String fzlx = request.getParameter("fzlx");
		String shebeibianhao = request.getParameter("shebeibianhao");
		String gcmc = request.getParameter("gcmc");
		String gcbw = request.getParameter("gcbw");
		String ypmc = request.getParameter("ypmc");
		String ypbh = request.getParameter("ypbh");
		if (StringUtil.isNotEmpty(pid)) {
			TSDepart depart = systemService.getEntity(TSDepart.class, pid);
			cq.ge("lft", depart.getLft().toString());
			cq.le("rgt", depart.getRgt().toString());
		} else {
			HttpSession session = request.getSession();
			cq.ge("lft", session.getAttribute("userlft").toString());
			cq.le("rgt", session.getAttribute("userrgt").toString());
		}
		if (StringUtil.isNotEmpty(startTime)) {
			cq.ge("TIME", startTime);
		}
		if (StringUtil.isNotEmpty(endTime)) {
			cq.le("TIME", endTime);
		}
		if (StringUtil.isNotEmpty(fzlx)) {
			if("1".equals(fzlx)){
				cq.eq("isQualified", "合格");
			}else if("2".equals(fzlx)){
				cq.eq("isQualified", "不合格");
			}
		}
		if (StringUtil.isNotEmpty(shebeibianhao)) {
			cq.eq("gprsbianhao", shebeibianhao);
		}
		if (StringUtil.isNotEmpty(gcmc)) {
			cq.like("projectName", "%"+gcmc+"%");
		}
		if (StringUtil.isNotEmpty(gcbw)) {
			cq.like("GCBuWei", "%"+gcbw+"%");
		}
		if (StringUtil.isNotEmpty(ypmc)) {
			cq.like("sampleName", "%"+ypmc+"%");
		}
		if (StringUtil.isNotEmpty(ypbh)) {
			cq.like("sampleNo", "%"+ypbh+"%");
		}
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, new W_zhenrudu_MView(),
				request.getParameterMap());
		this.systemService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
}
