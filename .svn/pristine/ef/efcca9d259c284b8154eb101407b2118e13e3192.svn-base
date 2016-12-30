package com.shtoone.qms.controller.bhz;

import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;

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
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.shtoone.qms.entity.bhz.SYclAllzhviewEntity;
import com.shtoone.qms.entity.bhz.SYclGuigexinghaomEntity;
import com.shtoone.qms.entity.bhz.SYclGuigexinghaosEntity;
import com.shtoone.qms.entity.bhz.SYclAllEntity;
import com.shtoone.qms.service.bhz.SYclAllServiceI;
import com.shtoone.qms.service.bhz.SYclAllzhviewServiceI;

/**   
 * @Title: Controller
 * @Description: S_YCL_ALLZHView
 * @author onlineGenerator
 * @date 2015-06-17 09:27:04
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/sYclAllzhviewController")
public class SYclAllzhviewController extends BaseController {

	@Autowired
	private SYclAllzhviewServiceI sYclAllzhviewService;
	
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private SYclAllServiceI sYclAllService;
	
	private TSDepart dpt;//上级部门
	private Integer userlft = 0;
	private Integer userrgt =0;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	/**
	 * S_YCL_ALLZHView列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "sYclAllzhview")
	public ModelAndView sYclAllzhview(HttpServletRequest request) {
		List<SYclGuigexinghaomEntity> List = new ArrayList<SYclGuigexinghaomEntity>();
		List<SYclGuigexinghaosEntity> sList = new ArrayList<SYclGuigexinghaosEntity>();
		List.addAll((List)systemService.getList(SYclGuigexinghaomEntity.class));
		request.setAttribute("List", List);
		sList.addAll((List)systemService.getList(SYclGuigexinghaosEntity.class));
		request.setAttribute("sList", sList);
		return new ModelAndView("com/shtoone/qms/bhz/sYclAllzhviewList");
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
	public void datagrid(SYclAllzhviewEntity sYclAllzhview,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String leixing=request.getParameter("leixing");
		String guige=request.getParameter("guige");
		String xinghao=request.getParameter("xinghao");
		String pid =request.getParameter("biaoduanid");
		if(StringUtil.isNotEmpty(pid)){
			dpt=systemService.getEntity(TSDepart.class, pid);
			setUserlft(dpt.getLft());
			setUserrgt(dpt.getRgt());
		}else{
			HttpSession session = request.getSession();
			setUserlft(Integer.parseInt( session.getAttribute("userlft").toString()));
			setUserrgt(Integer.parseInt(session.getAttribute("userrgt").toString()));
		}
		JSONObject jObject = sYclAllzhviewService.getDatagrid5(sYclAllzhview, dataGrid,leixing,guige,xinghao,userlft,userrgt);
		responseDatagrid(response, jObject);
	}
	
	@RequestMapping(params = "datagrid1")
	public ModelAndView datagrid1(SYclAllzhviewEntity sYclAllzhview,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) throws ParseException {
		String id=request.getParameter("id");
		if(StringUtil.isNotEmpty(id)){
			sYclAllzhview = systemService.getEntity(SYclAllzhviewEntity.class,id);
			String biaoduanid = sYclAllzhview.getBiaoduanid();
			String leixing = sYclAllzhview.getLeixing();
			String guige = sYclAllzhview.getGuige();
			String xinghao = sYclAllzhview.getXinghao();
			String chandi = sYclAllzhview.getChandi();
			String scchangjia = sYclAllzhview.getScchangjia();
			List<SYclAllEntity> syclalllist = this.sYclAllService.getDatagrid3(sYclAllzhview, dataGrid, biaoduanid,leixing,guige,xinghao,chandi,scchangjia);
			request.setAttribute("syclalllist", syclalllist);
			request.setAttribute("type", leixing);
		}else{
			request.setAttribute("syclalllist", "");
			request.setAttribute("type", "");
		}
		return new ModelAndView("com/shtoone/qms/bhz/sYclAllviewList");
	}
	

	/**
	 * 删除S_YCL_ALLZHView
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(SYclAllzhviewEntity sYclAllzhview, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		sYclAllzhview = systemService.getEntity(SYclAllzhviewEntity.class, sYclAllzhview.getId());
		message = "S_YCL_ALLZHView删除成功";
		try{
			sYclAllzhviewService.delete(sYclAllzhview);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "S_YCL_ALLZHView删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除S_YCL_ALLZHView
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "S_YCL_ALLZHView删除成功";
		try{
			for(String id:ids.split(",")){
				SYclAllzhviewEntity sYclAllzhview = systemService.getEntity(SYclAllzhviewEntity.class, 
				id
				);
				sYclAllzhviewService.delete(sYclAllzhview);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "S_YCL_ALLZHView删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加S_YCL_ALLZHView
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(SYclAllzhviewEntity sYclAllzhview, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "S_YCL_ALLZHView添加成功";
		try{
			sYclAllzhviewService.save(sYclAllzhview);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "S_YCL_ALLZHView添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新S_YCL_ALLZHView
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(SYclAllzhviewEntity sYclAllzhview, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "S_YCL_ALLZHView更新成功";
		SYclAllzhviewEntity t = sYclAllzhviewService.get(SYclAllzhviewEntity.class, sYclAllzhview.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(sYclAllzhview, t);
			sYclAllzhviewService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "S_YCL_ALLZHView更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * S_YCL_ALLZHView新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(SYclAllzhviewEntity sYclAllzhview, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sYclAllzhview.getId())) {
			sYclAllzhview = sYclAllzhviewService.getEntity(SYclAllzhviewEntity.class, sYclAllzhview.getId());
			req.setAttribute("sYclAllzhviewPage", sYclAllzhview);
		}
		return new ModelAndView("com/shtoone/qms/bhz/sYclAllzhview-add");
	}
	/**
	 * S_YCL_ALLZHView编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(SYclAllzhviewEntity sYclAllzhview, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sYclAllzhview.getId())) {
			sYclAllzhview = sYclAllzhviewService.getEntity(SYclAllzhviewEntity.class, sYclAllzhview.getId());
			req.setAttribute("sYclAllzhviewPage", sYclAllzhview);
		}
		return new ModelAndView("com/shtoone/qms/bhz/sYclAllzhview-update");
	}
}
