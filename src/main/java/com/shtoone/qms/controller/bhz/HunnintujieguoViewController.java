package com.shtoone.qms.controller.bhz;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.UploadFile;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.DataUtils;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.ReflectHelper;
import org.jeecgframework.core.util.RoletoJson;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSDocument;
import org.jeecgframework.web.system.pojo.base.TSType;
import org.jeecgframework.web.system.pojo.base.TSTypegroup;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.shtoone.qms.entity.bhz.HunnintujieguoViewEntity;
import com.shtoone.qms.entity.bhz.XiangxixxjieguoEntity;
import com.shtoone.qms.service.bhz.HunnintujieguoViewServiceI;

/**   
 * @Title: Controller
 * @Description: 水泥混凝土超标结果视图
 * @author zhangdaihao
 * @date 2015-06-18 15:20:44
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hunnintujieguoViewController")
public class HunnintujieguoViewController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HunnintujieguoViewController.class);

	@Autowired
	private HunnintujieguoViewServiceI hunnintujieguoViewService;
	@Autowired
	private SystemService systemService;
	private String message;
	private String departid;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 水泥混凝土超标结果视图列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "hunnintujieguoView")
	public ModelAndView hunnintujieguoView(HttpServletRequest request) {
		departid=request.getParameter("departid");//所属机构编号
		request.setAttribute("depart", departid);
		return new ModelAndView("com/shtoone/qms/entity/bhz/hunnintujieguoViewList");
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
	public void datagrid(HunnintujieguoViewEntity hunnintujieguoView,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		if(departid==null ||departid=="" ){
		 departid=request.getParameter("departid");//所属机构编号
		}
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String leixing=request.getParameter("leixing");//超标类型 
		String chulijieguoType=request.getParameter("chulijieguoType");//处理结果类型
		String gongchengmingcheng=request.getParameter("gongchengmingcheng");//工程名称
		String jiaozuobuwei=request.getParameter("jiaozuobuwei");//浇筑部位
		String shebeibianhao=request.getParameter("shebeibianhao");
		String xinxibianhao=request.getParameter("xinxibianhao");//信息编号
		//System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+leixing+">>>>>>>>"+chulijieguoType+">>>>"+request.getParameter("CBLX"));
		if (StringUtil.isEmpty(startTime) && StringUtil.isEmpty(endTime)) {//如果日期都为空则默认查询最近一月
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
			//dpt.setId(pid);
			//List<TSDepart> list=systemService.findByQueryString("from t_s_depart where ID = '"+pid+"'");
			userlft=dpt.getLft()+"";
			userrgt=dpt.getRgt()+"";
		}
		
		JSONObject jObject = hunnintujieguoViewService.getDatagrid3(hunnintujieguoView, dataGrid,
				departid,startTime,endTime,leixing,chulijieguoType,gongchengmingcheng,jiaozuobuwei,shebeibianhao,xinxibianhao, userlft, userrgt);
		responseDatagrid(response, jObject);
		
		/*
		CriteriaQuery cq = new CriteriaQuery(HunnintujieguoViewEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hunnintujieguoView, request.getParameterMap());
		this.hunnintujieguoViewService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
		*/
	}

	/**
	 * 删除水泥混凝土超标结果视图
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(HunnintujieguoViewEntity hunnintujieguoView, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		hunnintujieguoView = systemService.getEntity(HunnintujieguoViewEntity.class, hunnintujieguoView.getId());
		message = "水泥混凝土超标结果视图删除成功";
		hunnintujieguoViewService.delete(hunnintujieguoView);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加水泥混凝土超标结果视图
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(HunnintujieguoViewEntity hunnintujieguoView, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(hunnintujieguoView.getId())) {
			message = "水泥混凝土超标结果视图更新成功";
			HunnintujieguoViewEntity t = hunnintujieguoViewService.get(HunnintujieguoViewEntity.class, hunnintujieguoView.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(hunnintujieguoView, t);
				hunnintujieguoViewService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "水泥混凝土超标结果视图更新失败";
			}
		} else {
			message = "水泥混凝土超标结果视图添加成功";
			hunnintujieguoViewService.save(hunnintujieguoView);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 水泥混凝土超标结果视图列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(HunnintujieguoViewEntity hunnintujieguoView, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hunnintujieguoView.getId())) {
			hunnintujieguoView = hunnintujieguoViewService.getEntity(HunnintujieguoViewEntity.class, hunnintujieguoView.getId());
			req.setAttribute("hunnintujieguoViewPage", hunnintujieguoView);
		}
		return new ModelAndView("com/shtoone/qms/entity/bhz/hunnintujieguoView");
	}
	
	
	
	@RequestMapping(params = "hntclchaobiaolist")
	public ModelAndView hntclchaobiaolist(HttpServletRequest request) {
		// 给部门查询条件中的下拉框准备数据
		List<TSDepart> departList = systemService.getList(TSDepart.class);
		request.setAttribute("departsReplace", RoletoJson.listToReplaceStr(departList, "departname", "id"));
		departid=request.getParameter("departid");//所属机构编号
		if(StringUtil.isNotEmpty(departid)){
			TSDepart tspDepart = new TSDepart();
			TSDepart tsDepart = new TSDepart();
			TSDepart depart = systemService.getEntity(TSDepart.class, departid);
			
			tspDepart.setId(depart.getId());
			tspDepart.setDepartname(depart.getDepartname());
			tsDepart.setTSPDepart(tspDepart);
			request.setAttribute("depart", tsDepart);
		}
		return new ModelAndView("com/shtoone/qms/bhz/hntclchaobiaolist");
		//return new ModelAndView("com/shtoone/qms/bhz/hntcnfx");
	}
	
	@RequestMapping(params = "addFiles")
	public ModelAndView addFiles(HttpServletRequest req) {
		String id=req.getParameter("id");
		req.setAttribute("hunnintujieguoID", id);
		return new ModelAndView("com/shtoone/qms/bhz/hntclchaobiaolistfiles");
	}
	
	/**
	 * 保存文件
	 * 
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, TSDocument document) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		TSTypegroup tsTypegroup=systemService.getTypeGroup("fieltype","文档分类");
		TSType tsType = systemService.getType("files","附件", tsTypegroup);
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		String documentTitle = oConvertUtils.getString(request.getParameter("documentTitle"));// 文件标题
		if (StringUtil.isNotEmpty(fileKey)) {
			document.setId(fileKey);
			document = systemService.getEntity(TSDocument.class, fileKey);
			document.setDocumentTitle(documentTitle);

		}
		document.setSubclassname(MyClassLoader.getPackPath(document));
		document.setCreatedate(DataUtils.gettimestamp());
		document.setTSType(tsType);
		UploadFile uploadFile = new UploadFile(request, document);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		document = systemService.uploadFile(uploadFile);
		
		//System.out.println(document.getSubclassname()+">>>>>>>>>>>>>>>>"+document.getId());
		String filepath=document.getId()+"**"+document.getSubclassname();//上传文件的编号和类型 来自t_s_document,t_s_attachment
		XiangxixxjieguoEntity t = hunnintujieguoViewService.get(XiangxixxjieguoEntity.class, new Integer(documentTitle));
	
			//MyBeanUtils.copyBeanNotNull2Bean(hunnintujieguoView, t);
			t.setFilepath(filepath);
			hunnintujieguoViewService.saveOrUpdate(t);
			
		attributes.put("url", document.getRealpath());
		attributes.put("fileKey", document.getId());
		attributes.put("name", document.getAttachmenttitle());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + document.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + document.getId());
		j.setMsg("文件添加成功");
		j.setAttributes(attributes);
		return j;
	}
	
	
	/**
	 * 附件预览读取
	 * 
	 * @return
	 */
	@RequestMapping(params = "viewFile")
	public void viewFile(HttpServletRequest request, HttpServletResponse response) {
		
		String filepath=request.getParameter("filepath");
		String [] filepathArray=filepath.split("\\*\\*");
		//System.out.println(filepathArray[0]+">>>>>>"+filepathArray[1]);
		String fileid =oConvertUtils.getString(filepathArray[0]);
		String subclassname = oConvertUtils.getString(filepathArray[1], "com.jeecg.base.pojo.TSAttachment");
		Class fileClass = MyClassLoader.getClassByScn(subclassname);// 附件的实际类
		Object fileobj = systemService.getEntity(fileClass, fileid);
		ReflectHelper reflectHelper = new ReflectHelper(fileobj);
		UploadFile uploadFile = new UploadFile(request, response);
		String contentfield = oConvertUtils.getString(request.getParameter("contentfield"), uploadFile.getByteField());
		byte[] content = (byte[]) reflectHelper.getMethodValue(contentfield);
		String path = oConvertUtils.getString(reflectHelper.getMethodValue("realpath"));
		String extend = oConvertUtils.getString(reflectHelper.getMethodValue("extend"));
		String attachmenttitle = oConvertUtils.getString(reflectHelper.getMethodValue("attachmenttitle"));
		uploadFile.setExtend(extend);
		uploadFile.setTitleField(attachmenttitle);
		uploadFile.setRealPath(path);
		uploadFile.setContent(content);
		//uploadFile.setView(true);
		systemService.viewOrDownloadFile(uploadFile);

	}

	public String getDepartid() {
		return departid;
	}

	public void setDepartid(String departid) {
		this.departid = departid;
	}
	
}
