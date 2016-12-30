package com.shtoone.qms.controller.bhz;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.shtoone.qms.entity.bhz.BhgsYclAllviewEntity;
import com.shtoone.qms.entity.bhz.SYclAllzhviewEntity;
import com.shtoone.qms.entity.bhz.SYclAllEntity;
import com.shtoone.qms.entity.bhz.SYclGuigexinghaomEntity;
import com.shtoone.qms.entity.bhz.SYclGuigexinghaosEntity;
import com.shtoone.qms.service.bhz.SYclAllServiceI;
import com.shtoone.qms.service.bhz.BhgsYclAllviewServiceI;

/**   
 * @Title: Controller
 * @Description: BHGS_YCL_ALLView
 * @author onlineGenerator
 * @date 2015-06-17 09:27:23
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/bhgsYclAllviewController")
public class BhgsYclAllviewController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BhgsYclAllviewController.class);

	@Autowired
	private BhgsYclAllviewServiceI bhgsYclAllviewService;
	@Autowired
	private SystemService systemService;
	private String message;
	private TSDepart dpt;//上级部门
	private Integer userlft = 0;
	private Integer userrgt =0;
	@Autowired
	private SYclAllServiceI sYclAllService;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * BHGS_YCL_ALLView列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "bhgsYclAllview")
	public ModelAndView bhgsYclAllview(HttpServletRequest request) {
		List<SYclGuigexinghaomEntity> List = new ArrayList<SYclGuigexinghaomEntity>();
		List<SYclGuigexinghaosEntity> sList = new ArrayList<SYclGuigexinghaosEntity>();
		List.addAll((List)systemService.getList(SYclGuigexinghaomEntity.class));
		request.setAttribute("List", List);
		sList.addAll((List)systemService.getList(SYclGuigexinghaosEntity.class));
		request.setAttribute("sList", sList);
		return new ModelAndView("com/shtoone/qms/bhz/bhgsYclAllviewList");
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
	public void datagrid(BhgsYclAllviewEntity bhgsYclAllview,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String leixing=request.getParameter("leixing");
		String guige=request.getParameter("guige");
		String xinghao=request.getParameter("xinghao");
		String pid =request.getParameter("biaoduanid");
		if(pid!=null && pid.length()>0){
			dpt=systemService.getEntity(TSDepart.class, pid);
			//dpt.setId(pid);
			//List<TSDepart> list=systemService.findByQueryString("from t_s_depart where ID = '"+pid+"'");
			setUserlft(dpt.getLft());
			setUserrgt(dpt.getRgt());
		}else{
			HttpSession session = request.getSession();
			setUserlft(Integer.parseInt( session.getAttribute("userlft").toString()));
			setUserrgt(Integer.parseInt(session.getAttribute("userrgt").toString()));
		}
		JSONObject jObject = bhgsYclAllviewService.getDatagrid5(bhgsYclAllview, dataGrid,leixing,guige,xinghao,userlft,userrgt);
		responseDatagrid(response, jObject);
		
	}

	
	@RequestMapping(params = "datagrid1")
	public ModelAndView datagrid1(BhgsYclAllviewEntity sYclAllzhview,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) throws ParseException {
		/*CriteriaQuery cq = new CriteriaQuery(SYclAllEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sYclAll, request.getParameterMap());
		try{
		//自定义追加查询条件
			
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.sYclAllService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);*/
		sYclAllzhview = systemService.getEntity(BhgsYclAllviewEntity.class, request.getParameter("id"));
		
//		sYclAll = systemService.getEntity(SYclAllEntity.class, sYclAllzhview.getId());
//		HttpSession session = request.getSession();
		String biaoduanid = sYclAllzhview.getBiaoduanid();
		String leixing = sYclAllzhview.getLeixing();
		String guige = sYclAllzhview.getGuige();
		String xinghao = sYclAllzhview.getXinghao();
		String chandi = sYclAllzhview.getChandi();
		String scchangjia = sYclAllzhview.getScchangjia();
		/*String biaoduanid = session.getAttribute("biaoduanid").toString();
		String leixing = session.getAttribute("leixing").toString();
		String guige = session.getAttribute("guige").toString();
		String xinghao = session.getAttribute("xinghao").toString();
		String chandi = session.getAttribute("chandi").toString();
		String scchangjia = session.getAttribute("scchangjia").toString();*/
		List<SYclAllEntity> syclalllist=new ArrayList<SYclAllEntity>();
		syclalllist = this.sYclAllService.getDatagrid4(sYclAllzhview, dataGrid, biaoduanid,leixing,guige,xinghao,chandi,scchangjia);
//		responseDatagrid(response, jObject);
		
		request.setAttribute("syclalllist", syclalllist);
		request.setAttribute("type", leixing);
		return new ModelAndView("com/shtoone/qms/bhz/sYclAllviewList");
	}
	
	/**
	 * 删除BHGS_YCL_ALLView
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BhgsYclAllviewEntity bhgsYclAllview, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		bhgsYclAllview = systemService.getEntity(BhgsYclAllviewEntity.class, bhgsYclAllview.getId());
		message = "BHGS_YCL_ALLView删除成功";
		try{
			bhgsYclAllviewService.delete(bhgsYclAllview);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "BHGS_YCL_ALLView删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除BHGS_YCL_ALLView
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "BHGS_YCL_ALLView删除成功";
		try{
			for(String id:ids.split(",")){
				BhgsYclAllviewEntity bhgsYclAllview = systemService.getEntity(BhgsYclAllviewEntity.class, 
				id
				);
				bhgsYclAllviewService.delete(bhgsYclAllview);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "BHGS_YCL_ALLView删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加BHGS_YCL_ALLView
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BhgsYclAllviewEntity bhgsYclAllview, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "BHGS_YCL_ALLView添加成功";
		try{
			bhgsYclAllviewService.save(bhgsYclAllview);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "BHGS_YCL_ALLView添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新BHGS_YCL_ALLView
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BhgsYclAllviewEntity bhgsYclAllview, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "BHGS_YCL_ALLView更新成功";
		BhgsYclAllviewEntity t = bhgsYclAllviewService.get(BhgsYclAllviewEntity.class, bhgsYclAllview.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(bhgsYclAllview, t);
			bhgsYclAllviewService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "BHGS_YCL_ALLView更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * BHGS_YCL_ALLView新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BhgsYclAllviewEntity bhgsYclAllview, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bhgsYclAllview.getId())) {
			bhgsYclAllview = bhgsYclAllviewService.getEntity(BhgsYclAllviewEntity.class, bhgsYclAllview.getId());
			req.setAttribute("bhgsYclAllviewPage", bhgsYclAllview);
		}
		return new ModelAndView("com/shtoone/qms/bhz/bhgsYclAllview-add");
	}
	/**
	 * BHGS_YCL_ALLView编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BhgsYclAllviewEntity bhgsYclAllview, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(bhgsYclAllview.getId())) {
			bhgsYclAllview = bhgsYclAllviewService.getEntity(BhgsYclAllviewEntity.class, bhgsYclAllview.getId());
			req.setAttribute("bhgsYclAllviewPage", bhgsYclAllview);
		}
		return new ModelAndView("com/shtoone/qms/bhz/bhgsYclAllview-update");
	}

	public TSDepart getDpt() {
		return dpt;
	}

	public void setDpt(TSDepart dpt) {
		this.dpt = dpt;
	}

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
}
