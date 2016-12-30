package com.shtoone.qms.controller.bhz;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
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
import org.jeecgframework.web.demo.entity.test.JeecgDemo;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.shtoone.qms.entity.bhz.BanhezhanxinxiEntity;
import com.shtoone.qms.entity.bhz.SYclGuigexinghaomEntity;
import com.shtoone.qms.page.bhz.SYclGuigexinghaomPage;
import com.shtoone.qms.service.bhz.SYclGuigexinghaomServiceI;
import com.shtoone.qms.entity.bhz.SYclGuigexinghaosEntity;
/**   
 * @Title: Controller
 * @Description: s_ycl_guigexinghaom
 * @author onlineGenerator
 * @date 2015-06-16 09:03:13
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/sYclGuigexinghaomController")
public class SYclGuigexinghaomController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SYclGuigexinghaomController.class);

	@Autowired
	private SYclGuigexinghaomServiceI sYclGuigexinghaomService;
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
	 * s_ycl_guigexinghaom列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "sYclGuigexinghaom")
	public ModelAndView sYclGuigexinghaom(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/sYclGuigexinghaomList");
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
	public void datagrid(SYclGuigexinghaomEntity sYclGuigexinghaom,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SYclGuigexinghaomEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sYclGuigexinghaom);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.sYclGuigexinghaomService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除s_ycl_guigexinghaom
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(SYclGuigexinghaomEntity sYclGuigexinghaom, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		sYclGuigexinghaom = systemService.getEntity(SYclGuigexinghaomEntity.class, sYclGuigexinghaom.getId());
		message = "s_ycl_guigexinghaom删除成功";
		try{
			sYclGuigexinghaomService.delete(sYclGuigexinghaom);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "s_ycl_guigexinghaom删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除s_ycl_guigexinghaom
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "s_ycl_guigexinghaom删除成功";
		try{
			for(String id:ids.split(",")){
				SYclGuigexinghaomEntity sYclGuigexinghaom = systemService.getEntity(SYclGuigexinghaomEntity.class,
				id
				);
				sYclGuigexinghaomService.delete(sYclGuigexinghaom);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "s_ycl_guigexinghaom删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加s_ycl_guigexinghaom
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(SYclGuigexinghaomEntity sYclGuigexinghaom,SYclGuigexinghaomPage sYclGuigexinghaomPage, HttpServletRequest request) {
		List<SYclGuigexinghaosEntity> sYclGuigexinghaosList =  sYclGuigexinghaomPage.getSYclGuigexinghaosList();
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			sYclGuigexinghaomService.addMain(sYclGuigexinghaom, sYclGuigexinghaosList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "s_ycl_guigexinghaom添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新s_ycl_guigexinghaom
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(SYclGuigexinghaomEntity sYclGuigexinghaom,SYclGuigexinghaomPage sYclGuigexinghaomPage, HttpServletRequest request) {
		List<SYclGuigexinghaosEntity> sYclGuigexinghaosList =  sYclGuigexinghaomPage.getSYclGuigexinghaosList();
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		try{
			System.out.println(request.getParameter("type"));
			sYclGuigexinghaomService.updateMain(sYclGuigexinghaom, sYclGuigexinghaosList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新s_ycl_guigexinghaom失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * s_ycl_guigexinghaom新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(SYclGuigexinghaomEntity sYclGuigexinghaom, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sYclGuigexinghaom.getId())) {
			sYclGuigexinghaom = sYclGuigexinghaomService.getEntity(SYclGuigexinghaomEntity.class, sYclGuigexinghaom.getId());
			req.setAttribute("sYclGuigexinghaomPage", sYclGuigexinghaom);
		}
		return new ModelAndView("com/shtoone/qms/bhz/sYclGuigexinghaom-add");
	}
	
	/**
	 * s_ycl_guigexinghaom编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(SYclGuigexinghaomEntity sYclGuigexinghaom, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sYclGuigexinghaom.getId())) {
			sYclGuigexinghaom = sYclGuigexinghaomService.getEntity(SYclGuigexinghaomEntity.class, sYclGuigexinghaom.getId());
			req.setAttribute("sYclGuigexinghaomPage", sYclGuigexinghaom);
		}
		return new ModelAndView("com/shtoone/qms/bhz/sYclGuigexinghaom-update");
	}
	
	
	/**
	 * 加载明细列表[型号子表]
	 * 
	 * @return
	 */
	@RequestMapping(params = "sYclGuigexinghaosList")
	public ModelAndView sYclGuigexinghaosList(SYclGuigexinghaomEntity sYclGuigexinghaom, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object sELECTKEY0 = sYclGuigexinghaom.getSelectkey();
		//===================================================================================
		//查询-型号子表
	    String hql0 = "from SYclGuigexinghaosEntity where 1 = 1 AND sELECTKEY = ? ";
	    try{
	    	List<SYclGuigexinghaosEntity> sYclGuigexinghaosEntityList = systemService.findHql(hql0,sELECTKEY0);
			req.setAttribute("sYclGuigexinghaosList", sYclGuigexinghaosEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/shtoone/qms/bhz/sYclGuigexinghaosList");
	}
	
	
	@RequestMapping(params = "xinghaolist")
	public void banhejiSearch(SYclGuigexinghaosEntity banhezhanxinxi, HttpServletRequest request,HttpServletResponse response) {
		
		/*HttpSession session = request.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt =session.getAttribute("userrgt").toString();*/
		
		String name=request.getParameter("name");
		/*String bhjtype=request.getParameter("bhjtype");*/
		
		/*if(name!=null && name.length()>0){
			TSDepart dpt=systemService.getEntity(TSDepart.class, departid);
			//dpt.setId(pid);
			//List<TSDepart> list=systemService.findByQueryString("from t_s_depart where ID = '"+pid+"'");
			userlft=dpt.getLft()+"";
			userrgt=dpt.getRgt()+"";
		}*/
		List<SYclGuigexinghaosEntity> tempList=sYclGuigexinghaomService.getXinghaoBySql(name);
		JSONObject returnJson=new JSONObject();
		returnJson.put("msg", "abc");
		returnJson.put("list", JSONArray.fromObject(tempList));
		responseDatagrid(response, returnJson);
	}
	
}
