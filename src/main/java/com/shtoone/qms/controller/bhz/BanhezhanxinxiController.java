package com.shtoone.qms.controller.bhz;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.RoletoJson;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.shtoone.qms.entity.bhz.BanhezhanxinxiEntity;
import com.shtoone.qms.entity.bhz.GongkongchangjiaEntity;
import com.shtoone.qms.entity.bhz.ShebeichangjiaEntity;
import com.shtoone.qms.entity.bhz.V_ShebeiInfoEntity;
import com.shtoone.qms.entity.bhz.V_ShiyanshiInfoEntity;
import com.shtoone.qms.service.bhz.BanhezhanxinxiServiceI;


@Controller
@RequestMapping("/banhezhanxinxiController")
public class BanhezhanxinxiController extends BaseController {

	@Autowired
	private BanhezhanxinxiServiceI banhezhanxinxiService;
	
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
	 * 拌和机信息基础表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "banhezhanxinxi")
	public ModelAndView banhezhanxinxi(HttpServletRequest request) {
		// 给部门查询条件中的下拉框准备数据
		List<TSDepart> departList = systemService.getList(TSDepart.class);
		request.setAttribute("departsReplace", RoletoJson.listToReplaceStr(departList, "departname", "id"));
		return new ModelAndView("com/shtoone/qms/bhz/banhezhanxinxiList");
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
	public void datagrid(BanhezhanxinxiEntity banhezhanxinxi,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String departid=request.getParameter("departid");//所属机构编号
		String gprstype=request.getParameter("gprstype");//拌和机类型
		String smsbaojin=request.getParameter("smsbaojin");//是否报警
		String shebeibianhao=request.getParameter("shebeibianhao");//设备编号
		HttpSession session = request.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt =session.getAttribute("userrgt").toString();
		
		if(departid!=null && departid.length()>0){
			TSDepart dpt=systemService.getEntity(TSDepart.class, departid);
			userlft=dpt.getLft()+"";
			userrgt=dpt.getRgt()+"";
		}
		JSONObject jObject = banhezhanxinxiService.getDatagrid3(banhezhanxinxi, dataGrid,
				departid,gprstype,smsbaojin,shebeibianhao, userlft, userrgt);
		responseDatagrid(response, jObject);
	}

	/**
	 * 删除拌和机信息基础表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(BanhezhanxinxiEntity banhezhanxinxi, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		banhezhanxinxi = systemService.getEntity(BanhezhanxinxiEntity.class, banhezhanxinxi.getId());
		message = "拌和机信息基础表删除成功";
		banhezhanxinxiService.delete(banhezhanxinxi);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加拌和机信息基础表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(BanhezhanxinxiEntity banhezhanxinxi, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		TSDepart depart = systemService.getEntity(TSDepart.class, banhezhanxinxi.getDepartid());
		banhezhanxinxi.setRemark(depart.getDepartname());
		if (StringUtil.isNotEmpty(banhezhanxinxi.getId())) {
			message = "拌和机信息基础表更新成功"+banhezhanxinxi.getRemark();
			BanhezhanxinxiEntity t = banhezhanxinxiService.get(BanhezhanxinxiEntity.class, banhezhanxinxi.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(banhezhanxinxi, t);
				banhezhanxinxiService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "拌和机信息基础表更新失败";
			}
		} else {
			message = "拌和机信息基础表添加成功"+banhezhanxinxi.getRemark();
			banhezhanxinxiService.save(banhezhanxinxi);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 拌和机信息基础表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(BanhezhanxinxiEntity banhezhanxinxi, HttpServletRequest req) {
		//设备厂家
		List<ShebeichangjiaEntity> ShebeichangjiaTemp=new ArrayList<ShebeichangjiaEntity>();
		ShebeichangjiaTemp.addAll((List)systemService.getList(ShebeichangjiaEntity.class));
		req.setAttribute("ShebeichangjiaTemp", ShebeichangjiaTemp);
		//工控厂家
		List<GongkongchangjiaEntity> GongkongchangjiaTemp=new ArrayList<GongkongchangjiaEntity>();
		GongkongchangjiaTemp.addAll((List)systemService.getList(GongkongchangjiaEntity.class));
		req.setAttribute("GongkongchangjiaTemp", GongkongchangjiaTemp);
		//所属部门
		List<TSDepart> departList = systemService.getList(TSDepart.class);
		req.setAttribute("departList", departList);
		
		if (StringUtil.isNotEmpty(banhezhanxinxi.getId())) {
			banhezhanxinxi = banhezhanxinxiService.getEntity(BanhezhanxinxiEntity.class, banhezhanxinxi.getId());
			req.setAttribute("banhezhanxinxiPage", banhezhanxinxi);
		}else{
			banhezhanxinxi = new BanhezhanxinxiEntity();
			banhezhanxinxi.setGprstype("1");//设备类型默认第一个
			banhezhanxinxi.setSmsbaojin("0");//默认报警
			req.setAttribute("banhezhanxinxiPage", banhezhanxinxi);
		}
		return new ModelAndView("com/shtoone/qms/bhz/banhezhanxinxi");
	}
	
	
	//混凝土拌和站查询
	@RequestMapping(params = "banhejiSearch")
	public void banhejiSearch(BanhezhanxinxiEntity banhezhanxinxi, HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt =session.getAttribute("userrgt").toString();
		
		String departid=request.getParameter("departid");
		String bhjtype=request.getParameter("bhjtype");
		
		if(departid!=null && departid.length()>0){
			TSDepart dpt=systemService.getEntity(TSDepart.class, departid);
			userlft=dpt.getLft()+"";
			userrgt=dpt.getRgt()+"";
		}
		List<BanhezhanxinxiEntity> tempList=banhezhanxinxiService.getBhzBySql(departid,bhjtype,userlft,userrgt);
		JSONObject returnJson=new JSONObject();
		returnJson.put("msg", "abc");
		returnJson.put("list", JSONArray.fromObject(tempList));
		responseDatagrid(response, returnJson);
	}
	
	//实验室拌和机查询
	@RequestMapping(params = "shiyanshiBHJSearch")
	public void shiyanshiBHJSearch(V_ShebeiInfoEntity ShebeiInfo, HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userlft = session.getAttribute("userlft").toString();
		String userrgt =session.getAttribute("userrgt").toString();
		String departid=request.getParameter("departid");
		String bhjtype=request.getParameter("bhjtype");
		if(StringUtil.isNotEmpty(departid)){
			TSDepart dpt=systemService.getEntity(TSDepart.class, departid);
			userlft=dpt.getLft()+"";
			userrgt=dpt.getRgt()+"";
		}
		List<V_ShiyanshiInfoEntity> tempList=banhezhanxinxiService.getWNJBySql(departid,bhjtype,userlft,userrgt);
		JSONObject returnJson=new JSONObject();
		returnJson.put("msg", "abc");
		returnJson.put("list", JSONArray.fromObject(tempList));
		responseDatagrid(response, returnJson);
	}
	
	
	//检查拌和机编号是否存在
	@RequestMapping(params = "checkGprsbianhao")
	public void checkGprsbianhao(BanhezhanxinxiEntity banhezhanxinxi, HttpServletRequest request,HttpServletResponse response) {
		String gprsbianhao=request.getParameter("gprsbianhao");
		BanhezhanxinxiEntity tempList=banhezhanxinxiService.getBhzByShebeibianhao(gprsbianhao);
		JSONObject returnJson=new JSONObject();
		if(null!=tempList&&!tempList.equals("")){
			returnJson.put("msg", "succ");
		}else{
			returnJson.put("msg", "error");
		}
		responseDatagrid(response, returnJson);
	}
	
	@RequestMapping(params = "clearBiaoshi")
	@ResponseBody
	public AjaxJson clearBiaoshi(BanhezhanxinxiEntity banhezhanxinxi, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		banhezhanxinxi = systemService.getEntity(BanhezhanxinxiEntity.class, banhezhanxinxi.getId());
		if(null != banhezhanxinxi){
			Integer row=banhezhanxinxiService.executeSql("update xiangxixx set kehuduanbianhao='' where shebeibianhao='"+banhezhanxinxi.getGprsbianhao()+"' and kehuduanbianhao<>'' ");
			if(row>0){
				message = banhezhanxinxi.getBanhezhanminchen()+"清标识成功！";
			}else{
				message = banhezhanxinxi.getBanhezhanminchen()+"清标识失败！";
			}
		}else{
			message ="清标识失败！";
		}
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}
}
