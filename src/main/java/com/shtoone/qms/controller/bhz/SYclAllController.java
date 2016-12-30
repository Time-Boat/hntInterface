package com.shtoone.qms.controller.bhz;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

import com.shtoone.qms.entity.bhz.SYclGuigexinghaomEntity;
import com.shtoone.qms.entity.bhz.SYclGuigexinghaosEntity;
import com.shtoone.qms.entity.bhz.SYclAllEntity;
import com.shtoone.qms.service.bhz.SYclAllServiceI;

@Controller
@RequestMapping("/sYclAllController")
public class SYclAllController extends BaseController {

	@Autowired
	private SYclAllServiceI sYclAllService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	private TSDepart dpt;//上级部门
	private Integer userlft = 0;
	private Integer userrgt =0;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	@RequestMapping(params = "sYclAll")
	public ModelAndView sYclAll(HttpServletRequest request) {
		List<SYclGuigexinghaomEntity> List = new ArrayList<SYclGuigexinghaomEntity>();
		List<SYclGuigexinghaosEntity> sList = new ArrayList<SYclGuigexinghaosEntity>();
		List.addAll((List)systemService.getList(SYclGuigexinghaomEntity.class));
		request.setAttribute("List", List);
		sList.addAll((List)systemService.getList(SYclGuigexinghaosEntity.class));
		request.setAttribute("sList", sList);
		return new ModelAndView("com/shtoone/qms/bhz/sYclAllList");
	}


	@RequestMapping(params = "datagrid")
	public void datagrid(SYclAllEntity sYclAll,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) throws ParseException {
		String jcbianhao=request.getParameter("jinchangbianhao");
		String mingcheng=request.getParameter("mingcheng");
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String daijian=request.getParameter("daijian");
		String leixing=request.getParameter("leixing");
		String guige=request.getParameter("guige");
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
		JSONObject jObject = sYclAllService.getDatagrid5(sYclAll, dataGrid,jcbianhao, mingcheng, startTime, endTime, daijian,leixing,guige,userlft,userrgt);
		responseDatagrid(response, jObject);
	}

	/**
	 * 删除s_ycl_all
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(SYclAllEntity sYclAll, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		sYclAll = systemService.getEntity(SYclAllEntity.class, sYclAll.getId());
		message = "原材料删除成功";
		try{
			sYclAllService.delete(sYclAll);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "原材料删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除s_ycl_all
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "原材料删除成功";
		try{
			for(String id:ids.split(",")){
				SYclAllEntity sYclAll = systemService.getEntity(SYclAllEntity.class, 
				id
				);
				sYclAllService.delete(sYclAll);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "原材料删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加s_ycl_all
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(SYclAllEntity sYclAll, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "原材料进场登记成功";
		try{
				sYclAll.setJinchangbianhao(request.getParameter("jinchangbianhao"));
				sYclAll.setMingcheng(request.getParameter("mingcheng"));
				sYclAll.setBiaoduanid(request.getParameter("tspdepartId"));
				sYclAll.setScchangjia(request.getParameter("scchangjia"));
				sYclAll.setChandi(request.getParameter("chandi"));
				sYclAll.setGuige(request.getParameter("guige"));
//				sYclAll.setXinghao(request.getParameter("xinghao"));
				sYclAll.setJcshuliang( new BigDecimal(request.getParameter("jcshuliang")).setScale(8,BigDecimal.ROUND_HALF_UP));
				sYclAll.setDanwei(request.getParameter("danwei"));
				sYclAll.setSyxingmu(request.getParameter("syxingmu"));
				sYclAll.setLeixing(request.getParameter("leixing"));
//				sYclAll.setPicihao(request.getParameter("picihao"));
//				sYclAll.setQyshijian(request.getParameter("qyshijian"));
//				sYclAll.setYcl11(request.getParameter("ycl11"));
//				sYclAll.setYcl12(request.getParameter("ycl12"));
//				sYclAll.setBgbianhao(request.getParameter("bgbianhao"));
//				sYclAll.setShiyanren(request.getParameter("shiyanren"));
//				sYclAll.setSyshijian(request.getParameter("syshijian"));
				
				sYclAll.setCunchudidian(request.getParameter("cunchudidian"));
				sYclAll.setRukushijian(request.getParameter("rukushijian"));
				sYclAll.setPici(request.getParameter("pici"));
				sYclAll.setJieshouren(request.getParameter("jieshouren"));
				sYclAll.setBeizhu(request.getParameter("beizhu"));
				
				sYclAll.setBiaoji(0);
				sYclAll.setDaijian("0");//0为待检
				sYclAllService.save(sYclAll);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "原材料进场登记失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	
	
	@RequestMapping(params = "shigongpeibiList")
	public ModelAndView shigongpeibiList(HttpServletRequest request) {
		// 给部门查询条件中的下拉框准备数据
		//添加跳转时，需要带入所属单位
		List<TSDepart> departList = systemService.getList(TSDepart.class);
		request.setAttribute("departList", departList);
		//这里要从登陆用户的Session中获取departId
		String departId=(String)request.getSession().getAttribute("userdepartid");
		if (StringUtil.isNotEmpty(departId)) {
			TSDepart tspDepart = new TSDepart();
			TSDepart tsDepart = new TSDepart();
			TSDepart depart = systemService.getEntity(TSDepart.class, departId);
			tspDepart.setId(depart.getId());
			tspDepart.setDepartname(depart.getDepartname());
			tsDepart.setTSPDepart(tspDepart);
			request.setAttribute("depart", tsDepart);
		}
		return new ModelAndView("system/inground/shigong/shigongpeibiList");
	}
	
	/**
	 * 更新s_ycl_all
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(SYclAllEntity sYclAll, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String pagetype = request.getParameter("pagetype");
		message = "原材料更新成功";
		if(null!=pagetype && "copy".equals(pagetype)){
			message = "原材料复制成功";
		}
		SYclAllEntity t = new SYclAllEntity();
		try {
			if(null!=pagetype && "edit".equals(pagetype)){
				t.setId(request.getParameter("id"));
			}
			t.setJinchangbianhao(request.getParameter("jinchangbianhao"));
			t.setMingcheng(request.getParameter("mingcheng"));
			t.setBiaoduanid(request.getParameter("tspdepartId"));
			t.setScchangjia(request.getParameter("scchangjia"));
			t.setChandi(request.getParameter("chandi"));
			t.setGuige(request.getParameter("guige"));
			t.setJcshuliang( new BigDecimal(request.getParameter("jcshuliang")).setScale(8,BigDecimal.ROUND_HALF_UP));
			t.setDanwei(request.getParameter("danwei"));
			t.setSyxingmu(request.getParameter("syxingmu"));
			t.setLeixing(request.getParameter("leixing"));
			t.setCunchudidian(request.getParameter("cunchudidian"));
			t.setRukushijian(request.getParameter("rukushijian"));
			t.setPici(request.getParameter("pici"));
			t.setJieshouren(request.getParameter("jieshouren"));
			t.setBeizhu(request.getParameter("beizhu"));
			sYclAllService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "原材料更新失败";
			if(null!=pagetype && "copy".equals(pagetype)){
				message = "原材料复制失败";
			}
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	
	
	/**
	 * 更新s_ycl_all
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doCopy")
	@ResponseBody
	public AjaxJson doCopy(SYclAllEntity sYclAll, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "原材料复制成功";
		try {
//			sYclAll.setId(request.getParameter("id"));
			sYclAll.setJinchangbianhao(request.getParameter("jinchangbianhao"));
			sYclAll.setMingcheng(request.getParameter("mingcheng"));
			sYclAll.setBiaoduanid(request.getParameter("tspdepartId"));
			sYclAll.setScchangjia(request.getParameter("scchangjia"));
			sYclAll.setChandi(request.getParameter("chandi"));
			sYclAll.setGuige(request.getParameter("guige"));
			sYclAll.setJcshuliang( new BigDecimal(request.getParameter("jcshuliang")).setScale(8,BigDecimal.ROUND_HALF_UP));
			sYclAll.setDanwei(request.getParameter("danwei"));
			sYclAll.setSyxingmu(request.getParameter("syxingmu"));
			sYclAll.setLeixing(request.getParameter("leixing"));
			sYclAll.setCunchudidian(request.getParameter("cunchudidian"));
			sYclAll.setRukushijian(request.getParameter("rukushijian"));
			sYclAll.setPici(request.getParameter("pici"));
			sYclAll.setJieshouren(request.getParameter("jieshouren"));
			sYclAll.setBeizhu(request.getParameter("beizhu"));
			sYclAllService.save(sYclAll);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "原材料复制失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * s_ycl_all新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(SYclAllEntity sYclAll, HttpServletRequest req) {
		List<SYclGuigexinghaomEntity> List = new ArrayList<SYclGuigexinghaomEntity>();
		List<SYclGuigexinghaosEntity> sList = new ArrayList<SYclGuigexinghaosEntity>();
		if (StringUtil.isNotEmpty(sYclAll.getId())) {
			sYclAll = sYclAllService.getEntity(SYclAllEntity.class, sYclAll.getId());
			req.setAttribute("sYclAllPage", sYclAll);
		}
		List.addAll((List)systemService.getList(SYclGuigexinghaomEntity.class));
		req.setAttribute("List", List);
		sList.addAll((List)systemService.getList(SYclGuigexinghaosEntity.class));
		req.setAttribute("sList", sList);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar day = Calendar.getInstance();
		String time=sdf.format(day.getTime());
		req.setAttribute("time", time);
		String departId=(String)req.getSession().getAttribute("userdepartid");
		//获取对应的下拉项目部
		//第一步获取当前的最上级departid
		List<TSDepart> departlist=new ArrayList<TSDepart>();
		if(StringUtil.isNotEmpty(departId)){
			dpt=systemService.getEntity(TSDepart.class, departId);
			setUserlft(dpt.getLft());
			setUserrgt(dpt.getRgt());
		}else{
			HttpSession session = req.getSession();
			setUserlft(Integer.parseInt( session.getAttribute("userlft").toString()));
			setUserrgt(Integer.parseInt(session.getAttribute("userrgt").toString()));
		}
		DataGrid dataGrid = new DataGrid();
		departlist = sYclAllService.getDatagrid6(dataGrid,userlft,userrgt);
		req.setAttribute("departlist", departlist);

		return new ModelAndView("com/shtoone/qms/bhz/sYclAll-add-new");
	}
	
	
	/**
	 * s_ycl_all编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "copyandadd")
	public ModelAndView copyandadd(SYclAllEntity sYclAll, HttpServletRequest req) {
		List<SYclGuigexinghaomEntity> List = new ArrayList<SYclGuigexinghaomEntity>();
		List<SYclGuigexinghaosEntity> sList = new ArrayList<SYclGuigexinghaosEntity>();
		if (StringUtil.isNotEmpty(sYclAll.getId())) {
			sYclAll = sYclAllService.getEntity(SYclAllEntity.class, sYclAll.getId());
			req.setAttribute("sYclAllPage", sYclAll);
		}
		
		List.addAll((List)systemService.getList(SYclGuigexinghaomEntity.class));
		req.setAttribute("List", List);
		sList.addAll((List)systemService.getList(SYclGuigexinghaosEntity.class));
		req.setAttribute("sList", sList);
		/*String departId=(String)req.getSession().getAttribute("userdepartid");*/
		/*if (StringUtil.isNotEmpty(departId)) {
			TSDepart tspDepart = new TSDepart();
			TSDepart tsDepart = new TSDepart();
			TSDepart depart = systemService.getEntity(TSDepart.class, sYclAll.getBiaoduanid());
			tspDepart.setId(depart.getId());
			tspDepart.setDepartname(depart.getDepartname());
			tsDepart.setTSPDepart(tspDepart);
			req.setAttribute("depart", tsDepart);*/
		/*}*/
			
			String departId=(String)req.getSession().getAttribute("userdepartid");
			//获取对应的下拉项目部
			//第一步获取当前的最上级departid
			List<TSDepart> departlist=new ArrayList<TSDepart>();
			TSDepart depart=new TSDepart();
			
			if(departId!=null && departId.length()>0){
				dpt=systemService.getEntity(TSDepart.class, departId);
				setUserlft(dpt.getLft());
				setUserrgt(dpt.getRgt());
			}else{
				HttpSession session = req.getSession();
				setUserlft(Integer.parseInt( session.getAttribute("userlft").toString()));
				setUserrgt(Integer.parseInt(session.getAttribute("userrgt").toString()));
			}
			DataGrid dataGrid = new DataGrid();
			departlist = sYclAllService.getDatagrid6(dataGrid,userlft,userrgt);
			req.setAttribute("departlist", departlist);
		return new ModelAndView("com/shtoone/qms/bhz/sYclAll-update-new");
	}
	
	
	/**
	 * s_ycl_all编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(SYclAllEntity sYclAll, HttpServletRequest req) {
		String pagetype = req.getParameter("pagetype");
		List<SYclGuigexinghaomEntity> List = new ArrayList<SYclGuigexinghaomEntity>();
		List<SYclGuigexinghaosEntity> sList = new ArrayList<SYclGuigexinghaosEntity>();
		if (StringUtil.isNotEmpty(sYclAll.getId())) {
			sYclAll = sYclAllService.getEntity(SYclAllEntity.class, sYclAll.getId());
			req.setAttribute("sYclAllPage", sYclAll);
			req.setAttribute("pagetype", pagetype);
		}
		
		List.addAll((List)systemService.getList(SYclGuigexinghaomEntity.class));
		req.setAttribute("List", List);
		sList.addAll((List)systemService.getList(SYclGuigexinghaosEntity.class));
		req.setAttribute("sList", sList);
		
		
		String departId=(String)req.getSession().getAttribute("userdepartid");
		//获取对应的下拉项目部
		//第一步获取当前的最上级departid
		List<TSDepart> departlist=new ArrayList<TSDepart>();
		TSDepart depart=new TSDepart();
		
		if(departId!=null && departId.length()>0){
			dpt=systemService.getEntity(TSDepart.class, departId);
			setUserlft(dpt.getLft());
			setUserrgt(dpt.getRgt());
		}else{
			HttpSession session = req.getSession();
			setUserlft(Integer.parseInt( session.getAttribute("userlft").toString()));
			setUserrgt(Integer.parseInt(session.getAttribute("userrgt").toString()));
		}
		DataGrid dataGrid = new DataGrid();
		departlist = sYclAllService.getDatagrid6(dataGrid,userlft,userrgt);
		req.setAttribute("departlist", departlist);
		return new ModelAndView("com/shtoone/qms/bhz/sYclAll-update-new");
	}

}
