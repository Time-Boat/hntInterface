package com.shtoone.qms.controller.bhz;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.RoletoJson;
import org.jeecgframework.core.util.StringUtil;

import com.shtoone.qms.entity.bhz.BanhezhanxinxiEntity;
import com.shtoone.qms.entity.bhz.Lilunpeibixixx;
import com.shtoone.qms.entity.bhz.Shigongpeibixixx;
import org.jeecgframework.web.system.pojo.base.TSDepart;

import com.shtoone.qms.service.bhz.BanhezhanxinxiServiceI;
import com.shtoone.qms.service.bhz.LilunpeibixixxService;
import com.shtoone.qms.service.bhz.ShigongpeibixixxService;

import net.sf.json.JSONObject;

import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ingroundManagerController")
public class IngroundManagerController extends BaseController{
		
	@Autowired
	private SystemService systemService;
	@Autowired
	private ShigongpeibixixxService shigongpeibixixxService;
	@Autowired
	private BanhezhanxinxiServiceI banhezhanxinxiService;

	@Autowired
	private LilunpeibixixxService lilunService;
	
	private String message;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@RequestMapping(params = "shigongpeibiList")
	public ModelAndView shigongpeibiList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt =session.getAttribute("userrgt").toString();
		// 给部门查询条件中的下拉框准备数据
		List<TSDepart> departList = systemService.getList(TSDepart.class);
		request.setAttribute("departsReplace", RoletoJson.listToReplaceStr(departList, "departname", "id"));
		// 这里对理论配合比的下拉列表的权限给过滤了
		List<Lilunpeibixixx> lilunList = lilunService.getLilunpeibiBySQL(userlft, userrgt);
		request.setAttribute("lilunReplace", lilunList);
		return new ModelAndView("com/shtoone/qms/bhz/shigong/shigongpeibiList");
	}
	
	/**
	 * easyuiAJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagrid")
	public void datagrid(Shigongpeibixixx shigongph,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String departid="";
		String shebeibianhao="";
		HttpSession session = request.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt =session.getAttribute("userrgt").toString();
		//时间
		String baopidata_begin="";
		String baopidata_end="";
		String pifudata_begin="";
		String pifudata_end="";
		String lilunId="";
		if(StringUtil.isNotEmpty(request.getParameter("baopidata_begin"))){
			baopidata_begin=request.getParameter("baopidata_begin");
		}
		if(StringUtil.isNotEmpty(request.getParameter("baopidata_end"))){
			baopidata_end=request.getParameter("baopidata_end");
		}
		if(StringUtil.isNotEmpty(request.getParameter("superGroup"))){
			departid=request.getParameter("superGroup");
		}
		if(StringUtil.isNotEmpty(departid)){
			TSDepart dpt=systemService.getEntity(TSDepart.class, departid);
			userlft=dpt.getLft()+"";
			userrgt=dpt.getRgt()+"";
		}
		if(StringUtil.isNotEmpty(request.getParameter("shebeibianhao"))){
			shebeibianhao=request.getParameter("shebeibianhao");
		}
		if(StringUtil.isNotEmpty(request.getParameter("pifudata_begin"))){
			pifudata_begin=request.getParameter("pifudata_begin");
		}
		if(StringUtil.isNotEmpty(request.getParameter("pifudata_end"))){
			pifudata_end=request.getParameter("pifudata_end");
		}
		if(StringUtil.isNotEmpty(request.getParameter("lilunId"))){
			lilunId=request.getParameter("lilunId");
		}
		JSONObject jObject = shigongpeibixixxService.getShigongByparams(shigongph, dataGrid, shebeibianhao, 
				baopidata_begin, baopidata_end, pifudata_begin, pifudata_end, userlft, userrgt,lilunId);
		responseDatagrid(response, jObject);
	}

	/**
	 * 施工配合比页面跳转
	 * 
	 * @param icon
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(Shigongpeibixixx shigongph, HttpServletRequest req) {
		HttpSession session = req.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt =session.getAttribute("userrgt").toString();
//		List<BanhezhanxinxiEntity> bhjList=banhezhanxinxiService.getList(BanhezhanxinxiEntity.class);
		List<TSDepart> bhjList=banhezhanxinxiService.getBHZ(userlft, userrgt);
		// 这里对理论配合比的下拉列表的权限给过滤了
		List<Lilunpeibixixx> lilunList = lilunService.getLilunpeibiBySQL(userlft, userrgt);
		//如果是修改的话，就带入对象
		// 给部门查询条件中的下拉框准备数据
		List<TSDepart> departList = systemService.getList(TSDepart.class);
		if (StringUtil.isNotEmpty(shigongph.getId())) {
			shigongph = systemService.getEntity(Shigongpeibixixx.class, shigongph.getId());
		}else{
			shigongph=new Shigongpeibixixx();
		}
		req.setAttribute("shigongph", shigongph);
		req.setAttribute("bhjList", bhjList);
		req.setAttribute("lilunList",lilunList);
		req.setAttribute("departsReplace", RoletoJson.listToReplaceStr(departList, "departname", "id"));
		return new ModelAndView("com/shtoone/qms/bhz/shigong/shigongpeibi");
	}
	
	
	/**
	 * 施工配合比页面跳转
	 * 
	 * @param icon
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "copyandadd")
	public ModelAndView copyandadd(Shigongpeibixixx shigongph, HttpServletRequest req) {
		HttpSession session = req.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt =session.getAttribute("userrgt").toString();
//		List<BanhezhanxinxiEntity> bhjList=banhezhanxinxiService.getList(BanhezhanxinxiEntity.class);
		List<TSDepart> bhjList=banhezhanxinxiService.getBHZ(userlft, userrgt);
		// 这里对理论配合比的下拉列表的权限给过滤了
		List<Lilunpeibixixx> lilunList = lilunService.getLilunpeibiBySQL(userlft, userrgt);
		//如果是修改的话，就带入对象
		// 给部门查询条件中的下拉框准备数据
		List<TSDepart> departList = systemService.getList(TSDepart.class);
		if (StringUtil.isNotEmpty(shigongph.getId())) {
			shigongph = systemService.getEntity(Shigongpeibixixx.class, shigongph.getId());
		}else{
			shigongph=new Shigongpeibixixx();
		}
		req.setAttribute("shigongph", shigongph);
		req.setAttribute("bhjList", bhjList);
		req.setAttribute("lilunList",lilunList);
		req.setAttribute("departsReplace", RoletoJson.listToReplaceStr(departList, "departname", "id"));
		return new ModelAndView("com/shtoone/qms/bhz/shigong/shigongpeibinew");
	}
	
	
	/**
	 * 添加施工配合比信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "copyandsave")
	@ResponseBody
	public AjaxJson copyandsave(Shigongpeibixixx shigongph,HttpServletRequest request) {
		AjaxJson ajaxJson = new AjaxJson();
			message = "生产任务单号: " + shigongph.getProductWorkNo() + "被添加成功";
			//在数据被添加时，将其状态更改为0
			shigongph.setState("0");
			shigongpeibixixxService.save(shigongph);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		//刷新缓存
		
		ajaxJson.setMsg(message);
		return ajaxJson;
	}
	
	/**
	 * 添加施工配合比信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(Shigongpeibixixx shigongph,HttpServletRequest request) {
		AjaxJson ajaxJson = new AjaxJson();
		if (StringUtil.isNotEmpty(shigongph.getId())) {
			//在数据被更新时，将其状态更改为1
			message = "生产任务单号: " + shigongph.getProductWorkNo()+ "被更新成功";
			shigongph.setState("0");
			shigongpeibixixxService.saveOrUpdate(shigongph);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} else {
			message = "生产任务单号: " + shigongph.getProductWorkNo() + "被添加成功";
			//在数据被添加时，将其状态更改为0
			shigongph.setState("0");
			shigongpeibixixxService.save(shigongph);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		//刷新缓存
		
		ajaxJson.setMsg(message);
		return ajaxJson;
	}
	
	/**
	 * 删除施工配合比信息（ID以G开头的是分组）
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(Shigongpeibixixx shigongph, HttpServletRequest request) {
		AjaxJson ajaxJson = new AjaxJson();
		shigongph= shigongpeibixixxService.getEntity(Shigongpeibixixx.class, shigongph.getId());
		message = "生产任务单号: " + shigongph.getProductWorkNo()+ "被删除 成功";
		shigongpeibixixxService.delete(shigongph);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		//刷新缓存
		ajaxJson.setMsg(message);
		return ajaxJson;
	}
}
