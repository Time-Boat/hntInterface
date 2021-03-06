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

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shtoone.qms.entity.bhz.HntviewEntity;
import com.shtoone.qms.service.bhz.HntcnfxServiceI;
import com.shtoone.qms.util.HntExcelUtil;


@Controller
@RequestMapping("/HntcnfxController")
public class HntcnfxController extends BaseController{
	
	@Autowired
	private HntcnfxServiceI cnfxService;
	
	@Autowired
	private SystemService systemService;
	
	private String bhzid;
	private String startTime;
	private String endTime;
	private Integer cxlx=0;
	private TSDepart dpt;//上级部门
	private Integer userlft = 0;
	private Integer userrgt =0;
	private String shebeibianhao;

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
	public Integer getCxlx() {
		return cxlx;
	}

	public void setCxlx(Integer cxlx) {
		this.cxlx = cxlx;
	}

	public TSDepart getDpt() {
		return dpt;
	}

	public void setDpt(TSDepart dpt) {
		this.dpt = dpt;
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
	@RequestMapping(params = "hntcnfx")
	public ModelAndView hntcnfx(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/hntcnfx");
	}
	
	@RequestMapping(params = "datagrid")
	public void datagrid(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {		
		startTime=request.getParameter("startTime");
		endTime=request.getParameter("endTime");
		String pid = request.getParameter("pid");
		shebeibianhao = request.getParameter("shebeibianhao");		
		HttpSession session = request.getSession();
		Integer userlft = (Integer) session.getAttribute("userlft");
		Integer userrgt =(Integer) session.getAttribute("userrgt");
		if(pid!=null && pid.length()>0){
			dpt=systemService.getEntity(TSDepart.class, pid);
			userlft=dpt.getLft();
			userrgt=dpt.getRgt();
		}
		if (null == startTime && null == endTime) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar day = Calendar.getInstance();
			setEndTime(sdf.format(day.getTime()));
			day.add(Calendar.MONTH, -1);
			setStartTime(sdf.format(day.getTime()));
		}
		if(request.getParameter("cxlx")!=null){
			cxlx=Integer.parseInt(request.getParameter("cxlx"));
		}else{
			cxlx=0;
		}
		
		JSONObject jObject = cnfxService.getDatagrid3(dataGrid,startTime,endTime,cxlx,
				userlft,userrgt,shebeibianhao);
		String strxml="";
		if (null != jObject && jObject.size() > 0) {
			strxml=cnfxService.getHntAnalysisColumnXml(jObject, cxlx);
    	}else{
    		strxml="";
    	}
		jObject.put("strXML", strxml);
		responseDatagrid(response, jObject);
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "cnfxexportXls")
	@ResponseBody
	public void  cnfxexportXls(HntviewEntity hntviewEntity,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid) {
		startTime=request.getParameter("startTime");
		endTime=request.getParameter("endTime");
		String pid = request.getParameter("pid");
		shebeibianhao = request.getParameter("shebeibianhao");
		HttpSession session = request.getSession();
		Integer userlft = (Integer) session.getAttribute("userlft");
		Integer userrgt =(Integer) session.getAttribute("userrgt");
		if(pid!=null && pid.length()>0){
			dpt=systemService.getEntity(TSDepart.class, pid);
			userlft=dpt.getLft();
			userrgt=dpt.getRgt();
		}
		if (null == startTime && null == endTime) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar day = Calendar.getInstance();
			setEndTime(sdf.format(day.getTime()));
			day.add(Calendar.MONTH, -1);
			setStartTime(sdf.format(day.getTime()));
		}
		if(request.getParameter("cxlx")!=null){
			cxlx=Integer.parseInt(request.getParameter("cxlx"));
		}else{
			cxlx=0;
		}
		
		JSONObject jObject = cnfxService.getDatagrid3(dataGrid,startTime,endTime,cxlx,
				userlft,userrgt,shebeibianhao);
		
		//解析json数据
		Iterator it = jObject.keys();
		JSONArray array=null;
		while(it.hasNext()){
			String key=(String)it.next();
			if(key.equals("rows")){
				array = jObject.getJSONArray(key);
			}
				 
		}
		
		List<String> dataList = new ArrayList<String>();
		if (null != array && array.size() > 0) {
			for(int i=0;i<array.size();i++){
				JSONObject key2=array.getJSONObject(i);
				StringBuilder databuilder = new StringBuilder();
				databuilder.append(StringUtil.Null2Blank( (String)key2.get("xa")) + "&^&");
				databuilder.append(StringUtil.Null2Blank((String)key2.get("xb")) + "&^&");
				databuilder.append(StringUtil.Null2Blank((String)key2.get("gujifangshu")) + "&^&");
				databuilder.append(StringUtil.Null2Blank((String)key2.get("pangshu")) + "&^&");
				
				databuilder.append(StringUtil.Null2Blank((String)key2.get("highps")) + "&^&");
				databuilder.append(StringUtil.Null2Blank((String)key2.get("highper")) + "&^&");
				databuilder.append(StringUtil.Null2Blank((String)key2.get("midps")) + "&^&");
				databuilder.append(StringUtil.Null2Blank((String)key2.get("midper")) + "&^&");
				databuilder.append(StringUtil.Null2Blank((String)key2.get("lowps")) + "&^&");
				databuilder.append(StringUtil.Null2Blank((String)key2.get("lowper")));
				dataList.add(databuilder.toString());
			}
		}
		String path = request.getSession().getServletContext()
				.getRealPath("/");
		String excelName =  System.currentTimeMillis()
				+ ".xls";
		File file = new File(path + "excel");
		if (!file.exists()) {
			file.mkdir();
		}	
		
		String header = "月份";
		switch (cxlx) {
			case 1:
				header = "季度";
				break;
			case 2:
				header = "月份";
				break;
			case 3:
				header = "周";
				break;
			default:
				header = "月份";
				break;
		}
		HntExcelUtil.importcnfxExcel(path+"excel/产能分析.xls", path + excelName,startTime+"～"+endTime,header,dataList);
		try {
			response.reset();
			response.setContentType("application/vnd.ms-excel");
			// 根据浏览器进行转码，使其支持中文文件名
			if (BrowserUtils.isIE(request)) {
				response.setHeader("content-disposition",
						"attachment;filename="+ java.net.URLEncoder.encode(excelName,"UTF-8") );
			} else {
				String newtitle = new String(excelName.getBytes("UTF-8"),"ISO8859-1");
				response.setHeader("content-disposition","attachment;filename=" + newtitle);
			}
			java.io.FileInputStream in = new java.io.FileInputStream(path + excelName);
			PrintWriter out = response.getWriter();
			int i;
			while ((i = in.read()) != -1) {
				out.write(i);
			}
			in.close();
	        out.flush();
	        out.close();
		}catch(Exception e ){
		}
	}
		
}
