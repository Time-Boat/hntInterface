package com.shtoone.qms.controller.bhz;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shtoone.qms.entity.bhz.HntviewEntity;
import com.shtoone.qms.service.bhz.CbtongjiServiceI;
import com.shtoone.qms.util.HntExcelUtil;


@Controller
@RequestMapping("/CbtongjiController")
public class CbtongjiController extends BaseController{

	@Autowired
	private CbtongjiServiceI cbtjService;	
	@Autowired
	private SystemService systemService;
	
	private String bhzid;
	private String startTime;
	private String endTime;
	private Integer fzlx=0;
	private String shebeibianhao;
	private TSDepart dpt;//上级部门
	private String userlft = "";
	private String userrgt ="";
	
	public TSDepart getDpt() {
		return dpt;
	}

	public void setDpt(TSDepart dpt) {
		this.dpt = dpt;
	}

	public String getUserlft() {
		return userlft;
	}

	public void setUserlft(String userlft) {
		this.userlft = userlft;
	}

	public String getUserrgt() {
		return userrgt;
	}

	public void setUserrgt(String userrgt) {
		this.userrgt = userrgt;
	}

	public String getBhzid() {
		return bhzid;
	}

	public void setBhzid(String bhzid) {
		this.bhzid = bhzid;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public Integer getFzlx() {
		return fzlx;
	}

	public void setFzlx(Integer fzlx) {
		this.fzlx = fzlx;
	}
	
	public String getShebeibianhao() {
		return shebeibianhao;
	}

	public void setShebeibianhao(String shebeibianhao) {
		this.shebeibianhao = shebeibianhao;
	}

	/**
	 * 产能分析列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "cbtongji")
	public ModelAndView hntcnfx(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/cbtongji");
	}
	
	@RequestMapping(params = "datagrid")
	public void datagrid(HntviewEntity cbtj,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {		
		startTime=request.getParameter("startTime");
		endTime=request.getParameter("endTime");
		String pid = request.getParameter("pid");
		shebeibianhao = request.getParameter("shebeibianhao");
		HttpSession session = request.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt =session.getAttribute("userrgt").toString();
		
		if(StringUtil.isNotEmpty(pid)){
			dpt=systemService.getEntity(TSDepart.class, pid);
			userlft=dpt.getLft().toString();
			userrgt=dpt.getRgt().toString();
		}
		if(StringUtil.isNotEmpty(request.getParameter("fzlx"))){
			fzlx=Integer.parseInt(request.getParameter("fzlx"));
		}else{
			fzlx=0;
		}
		if (StringUtil.isEmpty(startTime) && StringUtil.isEmpty(endTime)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar day = Calendar.getInstance();
			setEndTime(sdf.format(day.getTime()));
			day.add(Calendar.MONTH, -1);
			setStartTime(sdf.format(day.getTime()));
		}
		JSONObject jObject = cbtjService.getDatagrid3(cbtj, dataGrid,startTime,endTime,fzlx, userlft, userrgt,shebeibianhao);
		responseDatagrid(response, jObject);
	}
	
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "cbtjexportXls")
	@ResponseBody
	public void  cbtjexportXls(HntviewEntity cbtj,HttpServletRequest request,HttpServletResponse response, DataGrid dataGrid) {
		startTime=request.getParameter("startTime");
		endTime=request.getParameter("endTime");
		String pid = request.getParameter("pid");
		shebeibianhao = request.getParameter("shebeibianhao");
		HttpSession session = request.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt =session.getAttribute("userrgt").toString();
		if(StringUtil.isNotEmpty(pid)){
			dpt=systemService.getEntity(TSDepart.class, pid);
			userlft=dpt.getLft().toString();
			userrgt=dpt.getRgt().toString();
		}
		if(StringUtil.isNotEmpty(request.getParameter("fzlx"))){
			fzlx=Integer.parseInt(request.getParameter("fzlx"));
		}else{
			fzlx=0;
		}
		if (StringUtil.isEmpty(startTime) && StringUtil.isEmpty(endTime)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar day = Calendar.getInstance();
			setEndTime(sdf.format(day.getTime()));
			day.add(Calendar.MONTH, -1);
			setStartTime(sdf.format(day.getTime()));
		}
		JSONObject jObject = cbtjService.getDatagrid3(cbtj, dataGrid,startTime,endTime,fzlx, userlft, userrgt,shebeibianhao);
		//解析json数据
		Iterator it = jObject.keys();
		JSONArray array=null;
		while(it.hasNext()){
			String key=(String)it.next();
			if(key.equals("rows")){
				array = jObject.getJSONArray(key);
			}					 
		}
		//导出的Excel表格内容
		List<String> dataList = new ArrayList<String>();
		//for (HunnintuView hview : smstjlist) {
		for(int i=0;i<array.size();i++){
			JSONObject key2=array.getJSONObject(i);
			StringBuilder databuilder = new StringBuilder();
			databuilder.append(StringUtil.Null2Blank((String)key2.get("banhezhanminchen")));
			databuilder.append("&^&");
			databuilder.append(StringUtil.Null2Blank((String)key2.get("gujifangshu")));
			databuilder.append("&^&");
			databuilder.append(StringUtil.Null2Blank((String)key2.get("pangshu")));
			databuilder.append("&^&");
			databuilder.append(StringUtil.Null2Blank((String)key2.get("ambegin")));
			databuilder.append("&^&");
			databuilder.append(StringUtil.Null2Blank((String)key2.get("amend")));
			databuilder.append("&^&");
			databuilder.append(StringUtil.Null2Blank((String)key2.get("shuinipingzhong") ));
			databuilder.append("&^&");
			databuilder.append(StringUtil.Null2Blank((String)key2.get("jiaozuobuwei")));
			databuilder.append("&^&");
			databuilder.append(StringUtil.Null2Blank((String)key2.get("pmbegin")));
			databuilder.append("&^&");
			databuilder.append(StringUtil.Null2Blank((String)key2.get("pmend")));
			databuilder.append("&^&");
			databuilder.append(StringUtil.Null2Blank((String)key2.get("Sha1_shijizhi") ));
			databuilder.append("&^&");
			databuilder.append(StringUtil.Null2Blank((String)key2.get("Sha1_lilunzhi")));
			databuilder.append("&^&");
			databuilder.append(StringUtil.Null2Blank((String)key2.get("Sha2_shijizhi")));
			databuilder.append("&^&");
			databuilder.append(StringUtil.Null2Blank((String)key2.get("Sha2_lilunzhi")));
			databuilder.append("&^&");
			databuilder.append(StringUtil.Null2Blank((String)key2.get("Shi1_shijizhi")));
			databuilder.append("&^&");
			databuilder.append(StringUtil.Null2Blank((String)key2.get("Shi1_lilunzhi")));
			databuilder.append("&^&");
			dataList.add(databuilder.toString());
		}
		String path = request.getSession().getServletContext().getRealPath("/");
		String excelName = "excel\\"+ System.currentTimeMillis() + ".xls";
		File file = new File(path + "excel");
		if (!file.exists()) {
			file.mkdir();
		}
		HntExcelUtil.importsmstjExcel(path + "excel\\超标统计.xls", path+ excelName, startTime+ "～" + endTime, dataList);
		try {
			response.reset();
			response.setContentType("bin");
			response.setHeader("Content-Disposition","attachment; filename=\"" + excelName + "\"");
			java.io.FileInputStream in = new java.io.FileInputStream(path+ excelName);
			PrintWriter out = response.getWriter();
			int i;
			while ((i = in.read()) != -1) {
				out.write(i);
			}
			in.close();
			out.flush();
			out.close();
		} catch (Exception e) {}
	}
		
}
