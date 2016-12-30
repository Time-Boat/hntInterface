package com.shtoone.qms.controller.bhz;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExcelTitle;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.demo.entity.test.CourseEntity;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.core.util.MyBeanUtils;

import com.shtoone.qms.entity.bhz.TemperaturedataView;
import com.shtoone.qms.service.bhz.W_TemperaturedataServiceI;
import com.shtoone.qms.util.HntExcelUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/W_TemperaturedataController")
public class W_TemperaturedataController extends BaseController {

	private static final Logger logger = Logger.getLogger(W_TemperaturedataController.class);

	@Autowired
	private W_TemperaturedataServiceI temperaturedataServiceI;
	@Autowired
	private SystemService systemService;
	private String message;
	public String excelName;

	public String getExcelName() {
		return excelName;
	}

	public void setExcelName(String excelName) {
		this.excelName = excelName;
	}

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
	@RequestMapping(params = "stempquerylist")
	public ModelAndView stempquerylist(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/stempquerylist");
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
	public void datagrid(TemperaturedataView temperaturedataView, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TemperaturedataView.class, dataGrid);
		// 查询条件组装器
		String pid = request.getParameter("pid");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String shebeibianhao = request.getParameter("shebeibianhao");
		String userlft;
		String userrgt;
		if (StringUtil.isNotEmpty(pid)) {
			TSDepart depart = systemService.getEntity(TSDepart.class, pid);
			userlft = depart.getLft().toString();
			userrgt = depart.getRgt().toString();
		} else {
			HttpSession session = request.getSession();
			userlft = session.getAttribute("userlft").toString();
			userrgt = session.getAttribute("userrgt").toString();
		}
		JSONObject jObject = temperaturedataServiceI.getDatagrid3(dataGrid, startTime, endTime, userlft, userrgt,
				shebeibianhao);

		// 获取图表
		Iterator it = jObject.keys();
		JSONArray array = null;
		while (it.hasNext()) {
			String key = (String) it.next();
			if (key.equals("rows")) {
				array = jObject.getJSONArray(key);
			}
		}
		String strxml = "";
		if (null != array && array.size() > 0) {
			strxml = temperaturedataServiceI.getbaobiaoxml(jObject);
		} else {
			strxml = "";
		}
		// System.out.println(strxml+"-0-");
		jObject.put("strXML", strxml);
		responseDatagrid(response, jObject);
		// 导出
	}

	@RequestMapping(params = { "baobiao" })
	public void exportDataGrids(HttpServletRequest request, HttpServletResponse response) {
		String pid = request.getParameter("pid");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String shebeibianhao = request.getParameter("shebeibianhao");
		String userlft;
		String userrgt;
		if (StringUtil.isNotEmpty(pid)) {
			TSDepart depart = systemService.getEntity(TSDepart.class, pid);
			userlft = depart.getLft().toString();
			userrgt = depart.getRgt().toString();
		} else {
			HttpSession session = request.getSession();
			userlft = session.getAttribute("userlft").toString();
			userrgt = session.getAttribute("userrgt").toString();
		}
		JSONObject jObject = temperaturedataServiceI.getDatagrid3(startTime, endTime, userlft, userrgt, shebeibianhao);
		Iterator it = jObject.keys();
		JSONArray array = null;
		while (it.hasNext()) {
			String key = (String) it.next();
			if (key.equals("rows")) {
				array = jObject.getJSONArray(key);
			}
		}
		List<TemperaturedataView> list = new ArrayList<TemperaturedataView>();
		for (int i = 0; i < array.size(); i++) {
			TemperaturedataView view = new TemperaturedataView();
			view.setBanhezhanminchen(String.valueOf(array.getJSONObject(i).get("banhezhanminchen")));
			view.setTmpshijian(String.valueOf(array.getJSONObject(i).get("tmpshijian")));
			view.setTmpdata(String.valueOf(array.getJSONObject(i).get("tmpdata")));
			view.setWdfanwei(String.valueOf(array.getJSONObject(i).get("wdfanwei")));
			view.setShidudata(String.valueOf(array.getJSONObject(i).get("shidudata")));
			view.setSdfanwei(String.valueOf(array.getJSONObject(i).get("sdfanwei")));
			list.add(view);
		}
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			request.setCharacterEncoding("UTF-8");
			codedFileName = "温度湿度报表";
			if (BrowserUtils.isIE(request)) {
				response.setHeader("content-disposition",
						"attachment;filename=" + URLEncoder.encode(codedFileName, "UTF-8") + ".xls");
			} else {
				String newtitle = new String(codedFileName.getBytes("UTF-8"), "ISO8859-1");
				response.setHeader("content-disposition", "attachment;filename=" + newtitle + ".xls");
			}
			String[] headRow = { "设备名称", "采集时间", "温度(℃)", "温度标准范围(℃)20±2", "湿度(%)", "湿度标准范围(%)>=95" };
			HSSFWorkbook workbook = HntExcelUtil.WSbaobiao(codedFileName, headRow, list);
			fOut = response.getOutputStream();
			workbook.write(fOut);
		} catch (Exception localException) {
			System.out.println(localException.toString());
			try {

				fOut.flush();
				fOut.close();
			} catch (IOException localIOException) {
			}
		} finally {
			try {
				fOut.flush();
				fOut.close();
			} catch (IOException localIOException1) {

			}
		}

	}
}
