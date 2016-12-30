package com.shtoone.qms.controller.bhz;
import java.util.ArrayList;
import java.util.List;

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
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.RoletoJson;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.shtoone.qms.entity.bhz.HandsetEntity;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgEntity;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.entity.bhz.ShebeichangjiaEntity;
import com.shtoone.qms.entity.bhz.TopRealMaxhunnintuViewEntity;
import com.shtoone.qms.service.bhz.HntbhzziduancfgServiceI;
import com.shtoone.qms.service.bhz.TopRealMaxhunnintuViewServiceI;

/**   
 * @Title: Controller
 * @Description: 水泥混凝土刷新最新数据
 * @author zhangdaihao
 * @date 2015-06-17 10:40:59
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/topRealMaxhunnintuViewController")
public class TopRealMaxhunnintuViewController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TopRealMaxhunnintuViewController.class);

	@Autowired
	private TopRealMaxhunnintuViewServiceI topRealMaxhunnintuViewService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private HntbhzziduancfgServiceI hntbhzziduancfgService;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 水泥混凝土刷新最新数据列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "topRealMaxhunnintuView")
	public ModelAndView topRealMaxhunnintuView(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/entity/bhz/topRealMaxhunnintuViewList");
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
	public void datagrid(TopRealMaxhunnintuViewEntity topRealMaxhunnintuView,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		/*
		CriteriaQuery cq = new CriteriaQuery(TopRealMaxhunnintuViewEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, topRealMaxhunnintuView, request.getParameterMap());
		this.topRealMaxhunnintuViewService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
		*/
		String departid=request.getParameter("departid");//所属机构编号
		String shebeibianhao=request.getParameter("shebeibianhao");
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
		
		JSONObject jObject = topRealMaxhunnintuViewService.getDatagrid3(topRealMaxhunnintuView, dataGrid,
				departid,shebeibianhao, userlft, userrgt);
		responseDatagrid(response, jObject);
	}

	/**
	 * 删除水泥混凝土刷新最新数据
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TopRealMaxhunnintuViewEntity topRealMaxhunnintuView, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		topRealMaxhunnintuView = systemService.getEntity(TopRealMaxhunnintuViewEntity.class, topRealMaxhunnintuView.getId());
		message = "水泥混凝土刷新最新数据删除成功";
		topRealMaxhunnintuViewService.delete(topRealMaxhunnintuView);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加水泥混凝土刷新最新数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TopRealMaxhunnintuViewEntity topRealMaxhunnintuView, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(topRealMaxhunnintuView.getId())) {
			message = "水泥混凝土刷新最新数据更新成功";
			TopRealMaxhunnintuViewEntity t = topRealMaxhunnintuViewService.get(TopRealMaxhunnintuViewEntity.class, topRealMaxhunnintuView.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(topRealMaxhunnintuView, t);
				topRealMaxhunnintuViewService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "水泥混凝土刷新最新数据更新失败";
			}
		} else {
			message = "水泥混凝土刷新最新数据添加成功";
			topRealMaxhunnintuViewService.save(topRealMaxhunnintuView);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 水泥混凝土刷新最新数据列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TopRealMaxhunnintuViewEntity topRealMaxhunnintuView, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(topRealMaxhunnintuView.getId())) {
			topRealMaxhunnintuView = topRealMaxhunnintuViewService.getEntity(TopRealMaxhunnintuViewEntity.class, topRealMaxhunnintuView.getId());
			req.setAttribute("topRealMaxhunnintuViewPage", topRealMaxhunnintuView);
		}
		return new ModelAndView("com/shtoone/qms/entity/bhz/topRealMaxhunnintuView");
	}
	
	
	/**
	 * 去到水泥混凝土短信配置主界面
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "smscfglist")
	public ModelAndView smscfglist(HttpServletRequest request) {
		// 给部门查询条件中的下拉框准备数据
		List<TSDepart> departList = systemService.getList(TSDepart.class);
		request.setAttribute("departsReplace", RoletoJson.listToReplaceStr(departList, "departname", "id"));
		return new ModelAndView("com/shtoone/qms/bhz/smscfgList");
	}
	
	@RequestMapping(params = "smscfginput")
	public ModelAndView smscfginput(TopRealMaxhunnintuViewEntity topRealMaxhunnintuView, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(topRealMaxhunnintuView.getId())) {
			
			//手机号码
			List<HandsetEntity> handsetTemp=new ArrayList<HandsetEntity>();
			handsetTemp.addAll((List)systemService.getList(HandsetEntity.class));
			req.setAttribute("handsetTemp", handsetTemp);
			
			Integer cfgId=new Integer(topRealMaxhunnintuView.getId());
			String leixinbh=req.getParameter("leixinbh");
			req.setAttribute("leixinbh", leixinbh);
			if (cfgId > 0) {
				if (StringUtil.isNotEmpty(req.getParameter("setdefault")) && 
						req.getParameter("setdefault").equalsIgnoreCase("1")) {
					HntbhzziduancfgViewEntity smscfgfieldname=topRealMaxhunnintuViewService.hntfieldnamefindBybh(leixinbh);
					req.setAttribute("smscfgfieldname", smscfgfieldname);
					HntbhzziduancfgEntity hntissms=topRealMaxhunnintuViewService.hntissmsfindBybh(leixinbh,true);
					req.setAttribute("hntissms", hntissms);
					HntbhzziduancfgEntity Tlow=topRealMaxhunnintuViewService.hntsmslowfindBybh(leixinbh,true);
					req.setAttribute("Tlow", Tlow);
					HntbhzziduancfgEntity Thigh=topRealMaxhunnintuViewService.hntsmshighfindBybh(leixinbh,true);
					req.setAttribute("Thigh", Thigh);
					HntbhzziduancfgEntity Tnumber=topRealMaxhunnintuViewService.hntsmsnumberfindBybh(leixinbh);
					req.setAttribute("Tnumber", Tnumber);
					HntbhzziduancfgEntity Tcontent=topRealMaxhunnintuViewService.hntsmscontentfindBybh(leixinbh);
					req.setAttribute("Tcontent", Tcontent);
					HntbhzziduancfgEntity Tsheji=topRealMaxhunnintuViewService.hntsmsshejifindBybh(leixinbh,true);
					req.setAttribute("Tsheji", Tsheji);
					HntbhzziduancfgEntity Tsheji2=topRealMaxhunnintuViewService.hntsmsshejifindBybh2(leixinbh,true);
					req.setAttribute("Tsheji2", Tsheji2);
					HntbhzziduancfgEntity Tlow2=topRealMaxhunnintuViewService.hntsmslowfindBybh2(leixinbh,true);
					req.setAttribute("Tlow2", Tlow2);
					HntbhzziduancfgEntity Thigh2=topRealMaxhunnintuViewService.hntsmshighfindBybh2(leixinbh,true);
					req.setAttribute("Thigh2", Thigh2);
					HntbhzziduancfgEntity Tnumber2=topRealMaxhunnintuViewService.hntsmsnumberfindBybh2(leixinbh);
					req.setAttribute("Tnumber2", Tnumber2);
					HntbhzziduancfgEntity Tlow3=topRealMaxhunnintuViewService.hntsmslowfindBybh3(leixinbh,true);
					req.setAttribute("Tlow3", Tlow3);
					HntbhzziduancfgEntity Thigh3=topRealMaxhunnintuViewService.hntsmshighfindBybh3(leixinbh,true);
					req.setAttribute("Thigh3", Thigh3);
					HntbhzziduancfgEntity Tnumber3=topRealMaxhunnintuViewService.hntsmsnumberfindBybh3(leixinbh);
					req.setAttribute("Tnumber3", Tnumber3);
					
				} else {
					/*
				setSmscfgfieldname(topRealMaxhunnintuViewService.hntfieldnamefindBybh(leixinbh));
				setHntissms(topRealMaxhunnintuViewService.hntissmsfindBybh(leixinbh,false));
				setTlow(sysService.TlowfindBybh(leixinbh,false));
				setThigh(sysService.ThighfindBybh(leixinbh,false));
				setTnumber(sysService.TnumberfindBybh(leixinbh));
				setTcontent(sysService.TcontentfindBybh(leixinbh));
				setTsheji(sysService.TshejifindBybh(leixinbh,false));
				setTsheji2(sysService.TshejifindBybh2(leixinbh,false));
				setTlow2(sysService.TlowfindBybh2(leixinbh,false));
				setThigh2(sysService.ThighfindBybh2(leixinbh,false));
				setTnumber2(sysService.TnumberfindBybh2(leixinbh));
				setTlow3(sysService.TlowfindBybh3(leixinbh,false));
				setThigh3(sysService.ThighfindBybh3(leixinbh,false));
				setTnumber3(sysService.TnumberfindBybh3(leixinbh));	*/
					HntbhzziduancfgViewEntity smscfgfieldname=topRealMaxhunnintuViewService.hntfieldnamefindBybh(leixinbh);
					req.setAttribute("smscfgfieldname", smscfgfieldname);
					HntbhzziduancfgEntity hntissms=topRealMaxhunnintuViewService.hntissmsfindBybh(leixinbh,false);
					req.setAttribute("hntissms", hntissms);
					HntbhzziduancfgEntity Tlow=topRealMaxhunnintuViewService.hntsmslowfindBybh(leixinbh,false);
					req.setAttribute("Tlow", Tlow);
					//System.out.println(">>>>>>>>>>>>>>>"+Tlow.getShuini1_shijizhi());
					HntbhzziduancfgEntity Thigh=topRealMaxhunnintuViewService.hntsmshighfindBybh(leixinbh,false);
					req.setAttribute("Thigh", Thigh);
					HntbhzziduancfgEntity Tnumber=topRealMaxhunnintuViewService.hntsmsnumberfindBybh(leixinbh);
					req.setAttribute("Tnumber", Tnumber);
					HntbhzziduancfgEntity Tcontent=topRealMaxhunnintuViewService.hntsmscontentfindBybh(leixinbh);
					req.setAttribute("Tcontent", Tcontent);
					HntbhzziduancfgEntity Tsheji=topRealMaxhunnintuViewService.hntsmsshejifindBybh(leixinbh,false);
					req.setAttribute("Tsheji", Tsheji);
					HntbhzziduancfgEntity Tsheji2=topRealMaxhunnintuViewService.hntsmsshejifindBybh2(leixinbh,false);
					req.setAttribute("Tsheji2", Tsheji2);
					HntbhzziduancfgEntity Tlow2=topRealMaxhunnintuViewService.hntsmslowfindBybh2(leixinbh,false);
					req.setAttribute("Tlow2", Tlow2);
					HntbhzziduancfgEntity Thigh2=topRealMaxhunnintuViewService.hntsmshighfindBybh2(leixinbh,false);
					req.setAttribute("Thigh2", Thigh2);
					HntbhzziduancfgEntity Tnumber2=topRealMaxhunnintuViewService.hntsmsnumberfindBybh2(leixinbh);
					req.setAttribute("Tnumber2", Tnumber2);
					HntbhzziduancfgEntity Tlow3=topRealMaxhunnintuViewService.hntsmslowfindBybh3(leixinbh,false);
					req.setAttribute("Tlow3", Tlow3);
					HntbhzziduancfgEntity Thigh3=topRealMaxhunnintuViewService.hntsmshighfindBybh3(leixinbh,false);
					req.setAttribute("Thigh3", Thigh3);
					HntbhzziduancfgEntity Tnumber3=topRealMaxhunnintuViewService.hntsmsnumberfindBybh3(leixinbh);
					req.setAttribute("Tnumber3", Tnumber3);
				}
			}
			
		}
		return new ModelAndView("com/shtoone/qms/bhz/smscfginput");
	}
	
	
	@RequestMapping(params = "savesmscfginput")
	@ResponseBody
	public AjaxJson savesmscfginput(HntbhzziduancfgEntity topRealMaxhunnintuView, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		//1
		String hntissmsid=request.getParameter("hntissms.id");
		String hntissmsgprsbianhao=request.getParameter("hntissms.gprsbianhao");
		String hntissmsleixin=request.getParameter("hntissms.leixin");
		String hntissmsjiaobanshijian=request.getParameter("hntissms.jiaobanshijian");
		String hntissmsshuini1_shijizhi=request.getParameter("hntissms.shuini1_shijizhi");
		String hntissmsshuini2_shijizhi=request.getParameter("hntissms.shuini2_shijizhi");
		String hntissmskuangfen3_shijizhi=request.getParameter("hntissms.kuangfen3_shijizhi");
		String hntissmsfeimeihui4_shijizhi=request.getParameter("hntissms.feimeihui4_shijizhi");
		String hntissmsfenliao5_shijizhi=request.getParameter("hntissms.fenliao5_shijizhi");
		String hntissmsfenliao6_shijizhi=request.getParameter("hntissms.fenliao6_shijizhi");
		String hntissmssha1_shijizhi=request.getParameter("hntissms.sha1_shijizhi");
		String hntissmsshi1_shijizhi=request.getParameter("hntissms.shi1_shijizhi");
		String hntissmsshi2_shijizhi=request.getParameter("hntissms.shi2_shijizhi");
		String hntissmssha2_shijizhi=request.getParameter("hntissms.sha2_shijizhi");
		String hntissmsguliao5_shijizhi=request.getParameter("hntissms.guliao5_shijizhi");
		String hntissmsshui1_shijizhi=request.getParameter("hntissms.shui1_shijizhi");
		String hntissmsshui2_shijizhi=request.getParameter("hntissms.shui2_shijizhi");
		String hntissmswaijiaji1_shijizhi=request.getParameter("hntissms.waijiaji1_shijizhi");
		String hntissmswaijiaji2_shijizhi=request.getParameter("hntissms.waijiaji2_shijizhi");
		String hntissmswaijiaji3_shijizhi=request.getParameter("hntissms.waijiaji3_shijizhi");
		String hntissmswaijiaji4_shijizhi=request.getParameter("hntissms.waijiaji4_shijizhi");
		HntbhzziduancfgEntity hntissms=new HntbhzziduancfgEntity();
		if(StringUtil.isNotEmpty(hntissmsid)){hntissms.setId(new Integer(hntissmsid));}
		hntissms.setGprsbianhao(hntissmsgprsbianhao);
		hntissms.setLeixin(hntissmsleixin);
		hntissms.setJiaobanshijian(hntissmsjiaobanshijian);
		hntissms.setShuini1_shijizhi(hntissmsshuini1_shijizhi);
		hntissms.setShuini2_shijizhi(hntissmsshuini2_shijizhi);
		hntissms.setKuangfen3_shijizhi(hntissmskuangfen3_shijizhi);
		hntissms.setFeimeihui4_shijizhi(hntissmsfeimeihui4_shijizhi);
		hntissms.setFenliao5_shijizhi(hntissmsfenliao5_shijizhi);
		hntissms.setFenliao6_shijizhi(hntissmsfenliao6_shijizhi);
		hntissms.setSha1_shijizhi(hntissmssha1_shijizhi);
		hntissms.setShi1_shijizhi(hntissmsshi1_shijizhi);
		hntissms.setShi2_shijizhi(hntissmsshi2_shijizhi);
		hntissms.setSha2_shijizhi(hntissmssha2_shijizhi);
		hntissms.setGuliao5_shijizhi(hntissmsguliao5_shijizhi);
		hntissms.setShui1_shijizhi(hntissmsshui1_shijizhi);
		hntissms.setShui2_shijizhi(hntissmsshui2_shijizhi);
		hntissms.setWaijiaji1_shijizhi(hntissmswaijiaji1_shijizhi);
		hntissms.setWaijiaji2_shijizhi(hntissmswaijiaji2_shijizhi);
		hntissms.setWaijiaji3_shijizhi(hntissmswaijiaji3_shijizhi);
		hntissms.setWaijiaji4_shijizhi(hntissmswaijiaji4_shijizhi);
		hntbhzziduancfgService.saveOrUpdate(hntissms);
		//2
		String Tlowid=request.getParameter("Tlow.id");
		String Tlowgprsbianhao=request.getParameter("Tlow.gprsbianhao");
		String Tlowleixin=request.getParameter("Tlow.leixin");
		String Tlowjiaobanshijian=request.getParameter("Tlow.jiaobanshijian");
		String Tlowshuini1_shijizhi=request.getParameter("Tlow.shuini1_shijizhi");
		String Tlowshuini2_shijizhi=request.getParameter("Tlow.shuini2_shijizhi");
		String Tlowkuangfen3_shijizhi=request.getParameter("Tlow.kuangfen3_shijizhi");
		String Tlowfeimeihui4_shijizhi=request.getParameter("Tlow.feimeihui4_shijizhi");
		String Tlowfenliao5_shijizhi=request.getParameter("Tlow.fenliao5_shijizhi");
		String Tlowfenliao6_shijizhi=request.getParameter("Tlow.fenliao6_shijizhi");
		String Tlowsha1_shijizhi=request.getParameter("Tlow.sha1_shijizhi");
		String Tlowshi1_shijizhi=request.getParameter("Tlow.shi1_shijizhi");
		String Tlowshi2_shijizhi=request.getParameter("Tlow.shi2_shijizhi");
		String Tlowsha2_shijizhi=request.getParameter("Tlow.sha2_shijizhi");
		String Tlowguliao5_shijizhi=request.getParameter("Tlow.guliao5_shijizhi");
		String Tlowshui1_shijizhi=request.getParameter("Tlow.shui1_shijizhi");
		String Tlowshui2_shijizhi=request.getParameter("Tlow.shui2_shijizhi");
		String Tlowwaijiaji1_shijizhi=request.getParameter("Tlow.waijiaji1_shijizhi");
		String Tlowwaijiaji2_shijizhi=request.getParameter("Tlow.waijiaji2_shijizhi");
		String Tlowwaijiaji3_shijizhi=request.getParameter("Tlow.waijiaji3_shijizhi");
		String Tlowwaijiaji4_shijizhi=request.getParameter("Tlow.waijiaji4_shijizhi");
		HntbhzziduancfgEntity Tlow=new HntbhzziduancfgEntity();
		if(StringUtil.isNotEmpty(Tlowid)){Tlow.setId(new Integer(Tlowid));}
		if(null==Tlowgprsbianhao||Tlowgprsbianhao.equals("")){
			Tlow.setGprsbianhao(hntissmsgprsbianhao);
		}else{
			Tlow.setGprsbianhao(Tlowgprsbianhao);
		}
		Tlow.setLeixin(Tlowleixin);
		Tlow.setJiaobanshijian(Tlowjiaobanshijian);
		Tlow.setShuini1_shijizhi(Tlowshuini1_shijizhi);
		Tlow.setShuini2_shijizhi(Tlowshuini2_shijizhi);
		Tlow.setKuangfen3_shijizhi(Tlowkuangfen3_shijizhi);
		Tlow.setFeimeihui4_shijizhi(Tlowfeimeihui4_shijizhi);
		Tlow.setFenliao5_shijizhi(Tlowfenliao5_shijizhi);
		Tlow.setFenliao6_shijizhi(Tlowfenliao6_shijizhi);
		Tlow.setSha1_shijizhi(Tlowsha1_shijizhi);
		Tlow.setShi1_shijizhi(Tlowshi1_shijizhi);
		Tlow.setShi2_shijizhi(Tlowshi2_shijizhi);
		Tlow.setSha2_shijizhi(Tlowsha2_shijizhi);
		Tlow.setGuliao5_shijizhi(Tlowguliao5_shijizhi);
		Tlow.setShui1_shijizhi(Tlowshui1_shijizhi);
		Tlow.setShui2_shijizhi(Tlowshui2_shijizhi);
		Tlow.setWaijiaji1_shijizhi(Tlowwaijiaji1_shijizhi);
		Tlow.setWaijiaji2_shijizhi(Tlowwaijiaji2_shijizhi);
		Tlow.setWaijiaji3_shijizhi(Tlowwaijiaji3_shijizhi);
		Tlow.setWaijiaji4_shijizhi(Tlowwaijiaji4_shijizhi);
		hntbhzziduancfgService.saveOrUpdate(Tlow);
		
		//3
		String Thighid=request.getParameter("Thigh.id");
		String Thighgprsbianhao=request.getParameter("Thigh.gprsbianhao");
		String Thighleixin=request.getParameter("Thigh.leixin");
		String Thighjiaobanshijian=request.getParameter("Thigh.jiaobanshijian");
		String Thighshuini1_shijizhi=request.getParameter("Thigh.shuini1_shijizhi");
		String Thighshuini2_shijizhi=request.getParameter("Thigh.shuini2_shijizhi");
		String Thighkuangfen3_shijizhi=request.getParameter("Thigh.kuangfen3_shijizhi");
		String Thighfeimeihui4_shijizhi=request.getParameter("Thigh.feimeihui4_shijizhi");
		String Thighfenliao5_shijizhi=request.getParameter("Thigh.fenliao5_shijizhi");
		String Thighfenliao6_shijizhi=request.getParameter("Thigh.fenliao6_shijizhi");
		String Thighsha1_shijizhi=request.getParameter("Thigh.sha1_shijizhi");
		String Thighshi1_shijizhi=request.getParameter("Thigh.shi1_shijizhi");
		String Thighshi2_shijizhi=request.getParameter("Thigh.shi2_shijizhi");
		String Thighsha2_shijizhi=request.getParameter("Thigh.sha2_shijizhi");
		String Thighguliao5_shijizhi=request.getParameter("Thigh.guliao5_shijizhi");
		String Thighshui1_shijizhi=request.getParameter("Thigh.shui1_shijizhi");
		String Thighshui2_shijizhi=request.getParameter("Thigh.shui2_shijizhi");
		String Thighwaijiaji1_shijizhi=request.getParameter("Thigh.waijiaji1_shijizhi");
		String Thighwaijiaji2_shijizhi=request.getParameter("Thigh.waijiaji2_shijizhi");
		String Thighwaijiaji3_shijizhi=request.getParameter("Thigh.waijiaji3_shijizhi");
		String Thighwaijiaji4_shijizhi=request.getParameter("Thigh.waijiaji4_shijizhi");
		
		HntbhzziduancfgEntity Thigh=new HntbhzziduancfgEntity();
		if(StringUtil.isNotEmpty(Thighid)){Thigh.setId(new Integer(Thighid));}
		if(null==Thighgprsbianhao||Thighgprsbianhao.equals("")){
			Thigh.setGprsbianhao(hntissmsgprsbianhao);
		}else{
			Thigh.setGprsbianhao(Thighgprsbianhao);
		}
		Thigh.setLeixin(Thighleixin);
		Thigh.setJiaobanshijian(Thighjiaobanshijian);
		Thigh.setShuini1_shijizhi(Thighshuini1_shijizhi);
		Thigh.setShuini2_shijizhi(Thighshuini2_shijizhi);
		Thigh.setKuangfen3_shijizhi(Thighkuangfen3_shijizhi);
		Thigh.setFeimeihui4_shijizhi(Thighfeimeihui4_shijizhi);
		Thigh.setFenliao5_shijizhi(Thighfenliao5_shijizhi);
		Thigh.setFenliao6_shijizhi(Thighfenliao6_shijizhi);
		Thigh.setSha1_shijizhi(Thighsha1_shijizhi);
		Thigh.setShi1_shijizhi(Thighshi1_shijizhi);
		Thigh.setShi2_shijizhi(Thighshi2_shijizhi);
		Thigh.setSha2_shijizhi(Thighsha2_shijizhi);
		Thigh.setGuliao5_shijizhi(Thighguliao5_shijizhi);
		Thigh.setShui1_shijizhi(Thighshui1_shijizhi);
		Thigh.setShui2_shijizhi(Thighshui2_shijizhi);
		Thigh.setWaijiaji1_shijizhi(Thighwaijiaji1_shijizhi);
		Thigh.setWaijiaji2_shijizhi(Thighwaijiaji2_shijizhi);
		Thigh.setWaijiaji3_shijizhi(Thighwaijiaji3_shijizhi);
		Thigh.setWaijiaji4_shijizhi(Thighwaijiaji4_shijizhi);
		hntbhzziduancfgService.saveOrUpdate(Thigh);
		
		//4
		String Tnumberid=request.getParameter("Tnumber.id");
		String Tnumbergprsbianhao=request.getParameter("Tnumber.gprsbianhao");
		String Tnumberleixin=request.getParameter("Tnumber.leixin");
		String Tnumberjiaobanshijian=request.getParameter("Tnumber.jiaobanshijian");
		String Tnumbershuini1_shijizhi=request.getParameter("Tnumber.shuini1_shijizhi");
		String Tnumbershuini2_shijizhi=request.getParameter("Tnumber.shuini2_shijizhi");
		String Tnumberkuangfen3_shijizhi=request.getParameter("Tnumber.kuangfen3_shijizhi");
		String Tnumberfeimeihui4_shijizhi=request.getParameter("Tnumber.feimeihui4_shijizhi");
		String Tnumberfenliao5_shijizhi=request.getParameter("Tnumber.fenliao5_shijizhi");
		String Tnumberfenliao6_shijizhi=request.getParameter("Tnumber.fenliao6_shijizhi");
		String Tnumbersha1_shijizhi=request.getParameter("Tnumber.sha1_shijizhi");
		String Tnumbershi1_shijizhi=request.getParameter("Tnumber.shi1_shijizhi");
		String Tnumbershi2_shijizhi=request.getParameter("Tnumber.shi2_shijizhi");
		String Tnumbersha2_shijizhi=request.getParameter("Tnumber.sha2_shijizhi");
		String Tnumberguliao5_shijizhi=request.getParameter("Tnumber.guliao5_shijizhi");
		String Tnumbershui1_shijizhi=request.getParameter("Tnumber.shui1_shijizhi");
		String Tnumbershui2_shijizhi=request.getParameter("Tnumber.shui2_shijizhi");
		String Tnumberwaijiaji1_shijizhi=request.getParameter("Tnumber.waijiaji1_shijizhi");
		String Tnumberwaijiaji2_shijizhi=request.getParameter("Tnumber.waijiaji2_shijizhi");
		String Tnumberwaijiaji3_shijizhi=request.getParameter("Tnumber.waijiaji3_shijizhi");
		String Tnumberwaijiaji4_shijizhi=request.getParameter("Tnumber.waijiaji4_shijizhi");
		HntbhzziduancfgEntity Tnumber=new HntbhzziduancfgEntity();
		if(StringUtil.isNotEmpty(Tnumberid)){Tnumber.setId(new Integer(Tnumberid));}
		if(null==Tnumbergprsbianhao||Tnumbergprsbianhao.equals("")){
			Tnumber.setGprsbianhao(hntissmsgprsbianhao);
		}else{
			Tnumber.setGprsbianhao(Tnumbergprsbianhao);
		}
		Tnumber.setLeixin(Tnumberleixin);
		Tnumber.setJiaobanshijian(Tnumberjiaobanshijian);
		Tnumber.setShuini1_shijizhi(Tnumbershuini1_shijizhi);
		Tnumber.setShuini2_shijizhi(Tnumbershuini2_shijizhi);
		Tnumber.setKuangfen3_shijizhi(Tnumberkuangfen3_shijizhi);
		Tnumber.setFeimeihui4_shijizhi(Tnumberfeimeihui4_shijizhi);
		Tnumber.setFenliao5_shijizhi(Tnumberfenliao5_shijizhi);
		Tnumber.setFenliao6_shijizhi(Tnumberfenliao6_shijizhi);
		Tnumber.setSha1_shijizhi(Tnumbersha1_shijizhi);
		Tnumber.setShi1_shijizhi(Tnumbershi1_shijizhi);
		Tnumber.setShi2_shijizhi(Tnumbershi2_shijizhi);
		Tnumber.setSha2_shijizhi(Tnumbersha2_shijizhi);
		Tnumber.setGuliao5_shijizhi(Tnumberguliao5_shijizhi);
		Tnumber.setShui1_shijizhi(Tnumbershui1_shijizhi);
		Tnumber.setShui2_shijizhi(Tnumbershui2_shijizhi);
		Tnumber.setWaijiaji1_shijizhi(Tnumberwaijiaji1_shijizhi);
		Tnumber.setWaijiaji2_shijizhi(Tnumberwaijiaji2_shijizhi);
		Tnumber.setWaijiaji3_shijizhi(Tnumberwaijiaji3_shijizhi);
		Tnumber.setWaijiaji4_shijizhi(Tnumberwaijiaji4_shijizhi);
		hntbhzziduancfgService.saveOrUpdate(Tnumber);
		
		
		//5
		String Tcontentid=request.getParameter("Tcontent.id");
		String Tcontentgprsbianhao=request.getParameter("Tcontent.gprsbianhao");
		String Tcontentleixin=request.getParameter("Tcontent.leixin");
		String Tcontentjiaobanshijian=request.getParameter("Tcontent.jiaobanshijian");
		String Tcontentshuini1_shijizhi=request.getParameter("Tcontent.shuini1_shijizhi");
		String Tcontentshuini2_shijizhi=request.getParameter("Tcontent.shuini2_shijizhi");
		String Tcontentkuangfen3_shijizhi=request.getParameter("Tcontent.kuangfen3_shijizhi");
		String Tcontentfeimeihui4_shijizhi=request.getParameter("Tcontent.feimeihui4_shijizhi");
		String Tcontentfenliao5_shijizhi=request.getParameter("Tcontent.fenliao5_shijizhi");
		String Tcontentfenliao6_shijizhi=request.getParameter("Tcontent.fenliao6_shijizhi");
		String Tcontentsha1_shijizhi=request.getParameter("Tcontent.sha1_shijizhi");
		String Tcontentshi1_shijizhi=request.getParameter("Tcontent.shi1_shijizhi");
		String Tcontentshi2_shijizhi=request.getParameter("Tcontent.shi2_shijizhi");
		String Tcontentsha2_shijizhi=request.getParameter("Tcontent.sha2_shijizhi");
		String Tcontentguliao5_shijizhi=request.getParameter("Tcontent.guliao5_shijizhi");
		String Tcontentshui1_shijizhi=request.getParameter("Tcontent.shui1_shijizhi");
		String Tcontentshui2_shijizhi=request.getParameter("Tcontent.shui2_shijizhi");
		String Tcontentwaijiaji1_shijizhi=request.getParameter("Tcontent.waijiaji1_shijizhi");
		String Tcontentwaijiaji2_shijizhi=request.getParameter("Tcontent.waijiaji2_shijizhi");
		String Tcontentwaijiaji3_shijizhi=request.getParameter("Tcontent.waijiaji3_shijizhi");
		String Tcontentwaijiaji4_shijizhi=request.getParameter("Tcontent.waijiaji4_shijizhi");
		HntbhzziduancfgEntity Tcontent=new HntbhzziduancfgEntity();
		if(StringUtil.isNotEmpty(Tcontentid)){Tcontent.setId(new Integer(Tcontentid));}
		if(null==Tcontentgprsbianhao||Tcontentgprsbianhao.equals("")){
			Tcontent.setGprsbianhao(hntissmsgprsbianhao);
		}else{
			Tcontent.setGprsbianhao(Tcontentgprsbianhao);
		}
		Tcontent.setLeixin(Tcontentleixin);
		Tcontent.setJiaobanshijian(Tcontentjiaobanshijian);
		Tcontent.setShuini1_shijizhi(Tcontentshuini1_shijizhi);
		Tcontent.setShuini2_shijizhi(Tcontentshuini2_shijizhi);
		Tcontent.setKuangfen3_shijizhi(Tcontentkuangfen3_shijizhi);
		Tcontent.setFeimeihui4_shijizhi(Tcontentfeimeihui4_shijizhi);
		Tcontent.setFenliao5_shijizhi(Tcontentfenliao5_shijizhi);
		Tcontent.setFenliao6_shijizhi(Tcontentfenliao6_shijizhi);
		Tcontent.setSha1_shijizhi(Tcontentsha1_shijizhi);
		Tcontent.setShi1_shijizhi(Tcontentshi1_shijizhi);
		Tcontent.setShi2_shijizhi(Tcontentshi2_shijizhi);
		Tcontent.setSha2_shijizhi(Tcontentsha2_shijizhi);
		Tcontent.setGuliao5_shijizhi(Tcontentguliao5_shijizhi);
		Tcontent.setShui1_shijizhi(Tcontentshui1_shijizhi);
		Tcontent.setShui2_shijizhi(Tcontentshui2_shijizhi);
		Tcontent.setWaijiaji1_shijizhi(Tcontentwaijiaji1_shijizhi);
		Tcontent.setWaijiaji2_shijizhi(Tcontentwaijiaji2_shijizhi);
		Tcontent.setWaijiaji3_shijizhi(Tcontentwaijiaji3_shijizhi);
		Tcontent.setWaijiaji4_shijizhi(Tcontentwaijiaji4_shijizhi);
		hntbhzziduancfgService.saveOrUpdate(Tcontent);
		
		//6
		String Tshejiid=request.getParameter("Tsheji.id");
		String Tshejigprsbianhao=request.getParameter("Tsheji.gprsbianhao");
		String Tshejileixin=request.getParameter("Tsheji.leixin");
		String Tshejijiaobanshijian=request.getParameter("Tsheji.jiaobanshijian");
		String Tshejishuini1_shijizhi=request.getParameter("Tsheji.shuini1_shijizhi");
		String Tshejishuini2_shijizhi=request.getParameter("Tsheji.shuini2_shijizhi");
		String Tshejikuangfen3_shijizhi=request.getParameter("Tsheji.kuangfen3_shijizhi");
		String Tshejifeimeihui4_shijizhi=request.getParameter("Tsheji.feimeihui4_shijizhi");
		String Tshejifenliao5_shijizhi=request.getParameter("Tsheji.fenliao5_shijizhi");
		String Tshejifenliao6_shijizhi=request.getParameter("Tsheji.fenliao6_shijizhi");
		String Tshejisha1_shijizhi=request.getParameter("Tsheji.sha1_shijizhi");
		String Tshejishi1_shijizhi=request.getParameter("Tsheji.shi1_shijizhi");
		String Tshejishi2_shijizhi=request.getParameter("Tsheji.shi2_shijizhi");
		String Tshejisha2_shijizhi=request.getParameter("Tsheji.sha2_shijizhi");
		String Tshejiguliao5_shijizhi=request.getParameter("Tsheji.guliao5_shijizhi");
		String Tshejishui1_shijizhi=request.getParameter("Tsheji.shui1_shijizhi");
		String Tshejishui2_shijizhi=request.getParameter("Tsheji.shui2_shijizhi");
		String Tshejiwaijiaji1_shijizhi=request.getParameter("Tsheji.waijiaji1_shijizhi");
		String Tshejiwaijiaji2_shijizhi=request.getParameter("Tsheji.waijiaji2_shijizhi");
		String Tshejiwaijiaji3_shijizhi=request.getParameter("Tsheji.waijiaji3_shijizhi");
		String Tshejiwaijiaji4_shijizhi=request.getParameter("Tsheji.waijiaji4_shijizhi");
		HntbhzziduancfgEntity Tsheji=new HntbhzziduancfgEntity();
		if(StringUtil.isNotEmpty(Tshejiid)){Tsheji.setId(new Integer(Tshejiid));}
		if(null==Tshejigprsbianhao||Tshejigprsbianhao.equals("")){
			Tsheji.setGprsbianhao(hntissmsgprsbianhao);
		}else{
			Tsheji.setGprsbianhao(Tshejigprsbianhao);
		}
		Tsheji.setLeixin(Tshejileixin);
		Tsheji.setJiaobanshijian(Tshejijiaobanshijian);
		Tsheji.setShuini1_shijizhi(Tshejishuini1_shijizhi);
		Tsheji.setShuini2_shijizhi(Tshejishuini2_shijizhi);
		Tsheji.setKuangfen3_shijizhi(Tshejikuangfen3_shijizhi);
		Tsheji.setFeimeihui4_shijizhi(Tshejifeimeihui4_shijizhi);
		Tsheji.setFenliao5_shijizhi(Tshejifenliao5_shijizhi);
		Tsheji.setFenliao6_shijizhi(Tshejifenliao6_shijizhi);
		Tsheji.setSha1_shijizhi(Tshejisha1_shijizhi);
		Tsheji.setShi1_shijizhi(Tshejishi1_shijizhi);
		Tsheji.setShi2_shijizhi(Tshejishi2_shijizhi);
		Tsheji.setSha2_shijizhi(Tshejisha2_shijizhi);
		Tsheji.setGuliao5_shijizhi(Tshejiguliao5_shijizhi);
		Tsheji.setShui1_shijizhi(Tshejishui1_shijizhi);
		Tsheji.setShui2_shijizhi(Tshejishui2_shijizhi);
		Tsheji.setWaijiaji1_shijizhi(Tshejiwaijiaji1_shijizhi);
		Tsheji.setWaijiaji2_shijizhi(Tshejiwaijiaji2_shijizhi);
		Tsheji.setWaijiaji3_shijizhi(Tshejiwaijiaji3_shijizhi);
		Tsheji.setWaijiaji4_shijizhi(Tshejiwaijiaji4_shijizhi);
		hntbhzziduancfgService.saveOrUpdate(Tsheji);
		//7
		String Tsheji2id=request.getParameter("Tsheji2.id");
		String Tsheji2gprsbianhao=request.getParameter("Tsheji2.gprsbianhao");
		String Tsheji2leixin=request.getParameter("Tsheji2.leixin");
		String Tsheji2jiaobanshijian=request.getParameter("Tsheji2.jiaobanshijian");
		String Tsheji2shuini1_shijizhi=request.getParameter("Tsheji2.shuini1_shijizhi");
		String Tsheji2shuini2_shijizhi=request.getParameter("Tsheji2.shuini2_shijizhi");
		String Tsheji2kuangfen3_shijizhi=request.getParameter("Tsheji2.kuangfen3_shijizhi");
		String Tsheji2feimeihui4_shijizhi=request.getParameter("Tsheji2.feimeihui4_shijizhi");
		String Tsheji2fenliao5_shijizhi=request.getParameter("Tsheji2.fenliao5_shijizhi");
		String Tsheji2fenliao6_shijizhi=request.getParameter("Tsheji2.fenliao6_shijizhi");
		String Tsheji2sha1_shijizhi=request.getParameter("Tsheji2.sha1_shijizhi");
		String Tsheji2shi1_shijizhi=request.getParameter("Tsheji2.shi1_shijizhi");
		String Tsheji2shi2_shijizhi=request.getParameter("Tsheji2.shi2_shijizhi");
		String Tsheji2sha2_shijizhi=request.getParameter("Tsheji2.sha2_shijizhi");
		String Tsheji2guliao5_shijizhi=request.getParameter("Tsheji2.guliao5_shijizhi");
		String Tsheji2shui1_shijizhi=request.getParameter("Tsheji2.shui1_shijizhi");
		String Tsheji2shui2_shijizhi=request.getParameter("Tsheji2.shui2_shijizhi");
		String Tsheji2waijiaji1_shijizhi=request.getParameter("Tsheji2.waijiaji1_shijizhi");
		String Tsheji2waijiaji2_shijizhi=request.getParameter("Tsheji2.waijiaji2_shijizhi");
		String Tsheji2waijiaji3_shijizhi=request.getParameter("Tsheji2.waijiaji3_shijizhi");
		String Tsheji2waijiaji4_shijizhi=request.getParameter("Tsheji2.waijiaji4_shijizhi");
		HntbhzziduancfgEntity Tsheji2=new HntbhzziduancfgEntity();
		if(StringUtil.isNotEmpty(Tsheji2id)){Tsheji2.setId(new Integer(Tsheji2id));}
		if(null==Tsheji2gprsbianhao||Tsheji2gprsbianhao.equals("")){
			Tsheji2.setGprsbianhao(hntissmsgprsbianhao);
		}else{
			Tsheji2.setGprsbianhao(Tsheji2gprsbianhao);
		}
		Tsheji2.setLeixin(Tsheji2leixin);
		Tsheji2.setJiaobanshijian(Tsheji2jiaobanshijian);
		Tsheji2.setShuini1_shijizhi(Tsheji2shuini1_shijizhi);
		Tsheji2.setShuini2_shijizhi(Tsheji2shuini2_shijizhi);
		Tsheji2.setKuangfen3_shijizhi(Tsheji2kuangfen3_shijizhi);
		Tsheji2.setFeimeihui4_shijizhi(Tsheji2feimeihui4_shijizhi);
		Tsheji2.setFenliao5_shijizhi(Tsheji2fenliao5_shijizhi);
		Tsheji2.setFenliao6_shijizhi(Tsheji2fenliao6_shijizhi);
		Tsheji2.setSha1_shijizhi(Tsheji2sha1_shijizhi);
		Tsheji2.setShi1_shijizhi(Tsheji2shi1_shijizhi);
		Tsheji2.setShi2_shijizhi(Tsheji2shi2_shijizhi);
		Tsheji2.setSha2_shijizhi(Tsheji2sha2_shijizhi);
		Tsheji2.setGuliao5_shijizhi(Tsheji2guliao5_shijizhi);
		Tsheji2.setShui1_shijizhi(Tsheji2shui1_shijizhi);
		Tsheji2.setShui2_shijizhi(Tsheji2shui2_shijizhi);
		Tsheji2.setWaijiaji1_shijizhi(Tsheji2waijiaji1_shijizhi);
		Tsheji2.setWaijiaji2_shijizhi(Tsheji2waijiaji2_shijizhi);
		Tsheji2.setWaijiaji3_shijizhi(Tsheji2waijiaji3_shijizhi);
		Tsheji2.setWaijiaji4_shijizhi(Tsheji2waijiaji4_shijizhi);
		hntbhzziduancfgService.saveOrUpdate(Tsheji2);
		
		//8
		String Tlow2id=request.getParameter("Tlow2.id");
		String Tlow2gprsbianhao=request.getParameter("Tlow2.gprsbianhao");
		String Tlow2leixin=request.getParameter("Tlow2.leixin");
		String Tlow2jiaobanshijian=request.getParameter("Tlow2.jiaobanshijian");
		String Tlow2shuini1_shijizhi=request.getParameter("Tlow2.shuini1_shijizhi");
		String Tlow2shuini2_shijizhi=request.getParameter("Tlow2.shuini2_shijizhi");
		String Tlow2kuangfen3_shijizhi=request.getParameter("Tlow2.kuangfen3_shijizhi");
		String Tlow2feimeihui4_shijizhi=request.getParameter("Tlow2.feimeihui4_shijizhi");
		String Tlow2fenliao5_shijizhi=request.getParameter("Tlow2.fenliao5_shijizhi");
		String Tlow2fenliao6_shijizhi=request.getParameter("Tlow2.fenliao6_shijizhi");
		String Tlow2sha1_shijizhi=request.getParameter("Tlow2.sha1_shijizhi");
		String Tlow2shi1_shijizhi=request.getParameter("Tlow2.shi1_shijizhi");
		String Tlow2shi2_shijizhi=request.getParameter("Tlow2.shi2_shijizhi");
		String Tlow2sha2_shijizhi=request.getParameter("Tlow2.sha2_shijizhi");
		String Tlow2guliao5_shijizhi=request.getParameter("Tlow2.guliao5_shijizhi");
		String Tlow2shui1_shijizhi=request.getParameter("Tlow2.shui1_shijizhi");
		String Tlow2shui2_shijizhi=request.getParameter("Tlow2.shui2_shijizhi");
		String Tlow2waijiaji1_shijizhi=request.getParameter("Tlow2.waijiaji1_shijizhi");
		String Tlow2waijiaji2_shijizhi=request.getParameter("Tlow2.waijiaji2_shijizhi");
		String Tlow2waijiaji3_shijizhi=request.getParameter("Tlow2.waijiaji3_shijizhi");
		String Tlow2waijiaji4_shijizhi=request.getParameter("Tlow2.waijiaji4_shijizhi");
		HntbhzziduancfgEntity Tlow2=new HntbhzziduancfgEntity();
		if(StringUtil.isNotEmpty(Tlow2id)){Tlow2.setId(new Integer(Tlow2id));}
		if(null==Tlow2gprsbianhao||Tlow2gprsbianhao.equals("")){
			Tlow2.setGprsbianhao(hntissmsgprsbianhao);
		}else{
			Tlow2.setGprsbianhao(Tlow2gprsbianhao);
		}
		Tlow2.setLeixin(Tlow2leixin);
		Tlow2.setJiaobanshijian(Tlow2jiaobanshijian);
		Tlow2.setShuini1_shijizhi(Tlow2shuini1_shijizhi);
		Tlow2.setShuini2_shijizhi(Tlow2shuini2_shijizhi);
		Tlow2.setKuangfen3_shijizhi(Tlow2kuangfen3_shijizhi);
		Tlow2.setFeimeihui4_shijizhi(Tlow2feimeihui4_shijizhi);
		Tlow2.setFenliao5_shijizhi(Tlow2fenliao5_shijizhi);
		Tlow2.setFenliao6_shijizhi(Tlow2fenliao6_shijizhi);
		Tlow2.setSha1_shijizhi(Tlow2sha1_shijizhi);
		Tlow2.setShi1_shijizhi(Tlow2shi1_shijizhi);
		Tlow2.setShi2_shijizhi(Tlow2shi2_shijizhi);
		Tlow2.setSha2_shijizhi(Tlow2sha2_shijizhi);
		Tlow2.setGuliao5_shijizhi(Tlow2guliao5_shijizhi);
		Tlow2.setShui1_shijizhi(Tlow2shui1_shijizhi);
		Tlow2.setShui2_shijizhi(Tlow2shui2_shijizhi);
		Tlow2.setWaijiaji1_shijizhi(Tlow2waijiaji1_shijizhi);
		Tlow2.setWaijiaji2_shijizhi(Tlow2waijiaji2_shijizhi);
		Tlow2.setWaijiaji3_shijizhi(Tlow2waijiaji3_shijizhi);
		Tlow2.setWaijiaji4_shijizhi(Tlow2waijiaji4_shijizhi);
		hntbhzziduancfgService.saveOrUpdate(Tlow2);
		
		//9
		String Thigh2id=request.getParameter("Thigh2.id");
		String Thigh2gprsbianhao=request.getParameter("Thigh2.gprsbianhao");
		String Thigh2leixin=request.getParameter("Thigh2.leixin");
		String Thigh2jiaobanshijian=request.getParameter("Thigh2.jiaobanshijian");
		String Thigh2shuini1_shijizhi=request.getParameter("Thigh2.shuini1_shijizhi");
		String Thigh2shuini2_shijizhi=request.getParameter("Thigh2.shuini2_shijizhi");
		String Thigh2kuangfen3_shijizhi=request.getParameter("Thigh2.kuangfen3_shijizhi");
		String Thigh2feimeihui4_shijizhi=request.getParameter("Thigh2.feimeihui4_shijizhi");
		String Thigh2fenliao5_shijizhi=request.getParameter("Thigh2.fenliao5_shijizhi");
		String Thigh2fenliao6_shijizhi=request.getParameter("Thigh2.fenliao6_shijizhi");
		String Thigh2sha1_shijizhi=request.getParameter("Thigh2.sha1_shijizhi");
		String Thigh2shi1_shijizhi=request.getParameter("Thigh2.shi1_shijizhi");
		String Thigh2shi2_shijizhi=request.getParameter("Thigh2.shi2_shijizhi");
		String Thigh2sha2_shijizhi=request.getParameter("Thigh2.sha2_shijizhi");
		String Thigh2guliao5_shijizhi=request.getParameter("Thigh2.guliao5_shijizhi");
		String Thigh2shui1_shijizhi=request.getParameter("Thigh2.shui1_shijizhi");
		String Thigh2shui2_shijizhi=request.getParameter("Thigh2.shui2_shijizhi");
		String Thigh2waijiaji1_shijizhi=request.getParameter("Thigh2.waijiaji1_shijizhi");
		String Thigh2waijiaji2_shijizhi=request.getParameter("Thigh2.waijiaji2_shijizhi");
		String Thigh2waijiaji3_shijizhi=request.getParameter("Thigh2.waijiaji3_shijizhi");
		String Thigh2waijiaji4_shijizhi=request.getParameter("Thigh2.waijiaji4_shijizhi");
		HntbhzziduancfgEntity Thigh2=new HntbhzziduancfgEntity();
		if(StringUtil.isNotEmpty(Thigh2id)){Thigh2.setId(new Integer(Thigh2id));}
		if(null==Thigh2gprsbianhao||Thigh2gprsbianhao.equals("")){
			Thigh2.setGprsbianhao(hntissmsgprsbianhao);
		}else{
			Thigh2.setGprsbianhao(Thigh2gprsbianhao);
		}
		Thigh2.setLeixin(Thigh2leixin);
		Thigh2.setJiaobanshijian(Thigh2jiaobanshijian);
		Thigh2.setShuini1_shijizhi(Thigh2shuini1_shijizhi);
		Thigh2.setShuini2_shijizhi(Thigh2shuini2_shijizhi);
		Thigh2.setKuangfen3_shijizhi(Thigh2kuangfen3_shijizhi);
		Thigh2.setFeimeihui4_shijizhi(Thigh2feimeihui4_shijizhi);
		Thigh2.setFenliao5_shijizhi(Thigh2fenliao5_shijizhi);
		Thigh2.setFenliao6_shijizhi(Thigh2fenliao6_shijizhi);
		Thigh2.setSha1_shijizhi(Thigh2sha1_shijizhi);
		Thigh2.setShi1_shijizhi(Thigh2shi1_shijizhi);
		Thigh2.setShi2_shijizhi(Thigh2shi2_shijizhi);
		Thigh2.setSha2_shijizhi(Thigh2sha2_shijizhi);
		Thigh2.setGuliao5_shijizhi(Thigh2guliao5_shijizhi);
		Thigh2.setShui1_shijizhi(Thigh2shui1_shijizhi);
		Thigh2.setShui2_shijizhi(Thigh2shui2_shijizhi);
		Thigh2.setWaijiaji1_shijizhi(Thigh2waijiaji1_shijizhi);
		Thigh2.setWaijiaji2_shijizhi(Thigh2waijiaji2_shijizhi);
		Thigh2.setWaijiaji3_shijizhi(Thigh2waijiaji3_shijizhi);
		Thigh2.setWaijiaji4_shijizhi(Thigh2waijiaji4_shijizhi);
		hntbhzziduancfgService.saveOrUpdate(Thigh2);
		//10
		String Tnumber2id=request.getParameter("Tnumber2.id");
		String Tnumber2gprsbianhao=request.getParameter("Tnumber2.gprsbianhao");
		String Tnumber2leixin=request.getParameter("Tnumber2.leixin");
		String Tnumber2jiaobanshijian=request.getParameter("Tnumber2.jiaobanshijian");
		String Tnumber2shuini1_shijizhi=request.getParameter("Tnumber2.shuini1_shijizhi");
		String Tnumber2shuini2_shijizhi=request.getParameter("Tnumber2.shuini2_shijizhi");
		String Tnumber2kuangfen3_shijizhi=request.getParameter("Tnumber2.kuangfen3_shijizhi");
		String Tnumber2feimeihui4_shijizhi=request.getParameter("Tnumber2.feimeihui4_shijizhi");
		String Tnumber2fenliao5_shijizhi=request.getParameter("Tnumber2.fenliao5_shijizhi");
		String Tnumber2fenliao6_shijizhi=request.getParameter("Tnumber2.fenliao6_shijizhi");
		String Tnumber2sha1_shijizhi=request.getParameter("Tnumber2.sha1_shijizhi");
		String Tnumber2shi1_shijizhi=request.getParameter("Tnumber2.shi1_shijizhi");
		String Tnumber2shi2_shijizhi=request.getParameter("Tnumber2.shi2_shijizhi");
		String Tnumber2sha2_shijizhi=request.getParameter("Tnumber2.sha2_shijizhi");
		String Tnumber2guliao5_shijizhi=request.getParameter("Tnumber2.guliao5_shijizhi");
		String Tnumber2shui1_shijizhi=request.getParameter("Tnumber2.shui1_shijizhi");
		String Tnumber2shui2_shijizhi=request.getParameter("Tnumber2.shui2_shijizhi");
		String Tnumber2waijiaji1_shijizhi=request.getParameter("Tnumber2.waijiaji1_shijizhi");
		String Tnumber2waijiaji2_shijizhi=request.getParameter("Tnumber2.waijiaji2_shijizhi");
		String Tnumber2waijiaji3_shijizhi=request.getParameter("Tnumber2.waijiaji3_shijizhi");
		String Tnumber2waijiaji4_shijizhi=request.getParameter("Tnumber2.waijiaji4_shijizhi");
		HntbhzziduancfgEntity Tnumber2=new HntbhzziduancfgEntity();
		if(StringUtil.isNotEmpty(Tnumber2id)){Tnumber2.setId(new Integer(Tnumber2id));}
		if(null==Tnumber2gprsbianhao||Tnumber2gprsbianhao.equals("")){
			Tnumber2.setGprsbianhao(hntissmsgprsbianhao);
		}else{
			Tnumber2.setGprsbianhao(Tnumber2gprsbianhao);
		}
		Tnumber2.setLeixin(Tnumber2leixin);
		Tnumber2.setJiaobanshijian(Tnumber2jiaobanshijian);
		Tnumber2.setShuini1_shijizhi(Tnumber2shuini1_shijizhi);
		Tnumber2.setShuini2_shijizhi(Tnumber2shuini2_shijizhi);
		Tnumber2.setKuangfen3_shijizhi(Tnumber2kuangfen3_shijizhi);
		Tnumber2.setFeimeihui4_shijizhi(Tnumber2feimeihui4_shijizhi);
		Tnumber2.setFenliao5_shijizhi(Tnumber2fenliao5_shijizhi);
		Tnumber2.setFenliao6_shijizhi(Tnumber2fenliao6_shijizhi);
		Tnumber2.setSha1_shijizhi(Tnumber2sha1_shijizhi);
		Tnumber2.setShi1_shijizhi(Tnumber2shi1_shijizhi);
		Tnumber2.setShi2_shijizhi(Tnumber2shi2_shijizhi);
		Tnumber2.setSha2_shijizhi(Tnumber2sha2_shijizhi);
		Tnumber2.setGuliao5_shijizhi(Tnumber2guliao5_shijizhi);
		Tnumber2.setShui1_shijizhi(Tnumber2shui1_shijizhi);
		Tnumber2.setShui2_shijizhi(Tnumber2shui2_shijizhi);
		Tnumber2.setWaijiaji1_shijizhi(Tnumber2waijiaji1_shijizhi);
		Tnumber2.setWaijiaji2_shijizhi(Tnumber2waijiaji2_shijizhi);
		Tnumber2.setWaijiaji3_shijizhi(Tnumber2waijiaji3_shijizhi);
		Tnumber2.setWaijiaji4_shijizhi(Tnumber2waijiaji4_shijizhi);
		hntbhzziduancfgService.saveOrUpdate(Tnumber2);
		//11
		String Tlow3id=request.getParameter("Tlow3.id");
		String Tlow3gprsbianhao=request.getParameter("Tlow3.gprsbianhao");
		String Tlow3leixin=request.getParameter("Tlow3.leixin");
		String Tlow3jiaobanshijian=request.getParameter("Tlow3.jiaobanshijian");
		String Tlow3shuini1_shijizhi=request.getParameter("Tlow3.shuini1_shijizhi");
		String Tlow3shuini2_shijizhi=request.getParameter("Tlow3.shuini2_shijizhi");
		String Tlow3kuangfen3_shijizhi=request.getParameter("Tlow3.kuangfen3_shijizhi");
		String Tlow3feimeihui4_shijizhi=request.getParameter("Tlow3.feimeihui4_shijizhi");
		String Tlow3fenliao5_shijizhi=request.getParameter("Tlow3.fenliao5_shijizhi");
		String Tlow3fenliao6_shijizhi=request.getParameter("Tlow3.fenliao6_shijizhi");
		String Tlow3sha1_shijizhi=request.getParameter("Tlow3.sha1_shijizhi");
		String Tlow3shi1_shijizhi=request.getParameter("Tlow3.shi1_shijizhi");
		String Tlow3shi2_shijizhi=request.getParameter("Tlow3.shi2_shijizhi");
		String Tlow3sha2_shijizhi=request.getParameter("Tlow3.sha2_shijizhi");
		String Tlow3guliao5_shijizhi=request.getParameter("Tlow3.guliao5_shijizhi");
		String Tlow3shui1_shijizhi=request.getParameter("Tlow3.shui1_shijizhi");
		String Tlow3shui2_shijizhi=request.getParameter("Tlow3.shui2_shijizhi");
		String Tlow3waijiaji1_shijizhi=request.getParameter("Tlow3.waijiaji1_shijizhi");
		String Tlow3waijiaji2_shijizhi=request.getParameter("Tlow3.waijiaji2_shijizhi");
		String Tlow3waijiaji3_shijizhi=request.getParameter("Tlow3.waijiaji3_shijizhi");
		String Tlow3waijiaji4_shijizhi=request.getParameter("Tlow3.waijiaji4_shijizhi");
		HntbhzziduancfgEntity Tlow3=new HntbhzziduancfgEntity();
		if(StringUtil.isNotEmpty(Tlow3id)){Tlow3.setId(new Integer(Tlow3id));}
		if(null==Tlow3gprsbianhao||Tlow3gprsbianhao.equals("")){
			Tlow3.setGprsbianhao(hntissmsgprsbianhao);
		}else{
			Tlow3.setGprsbianhao(Tlow3gprsbianhao);
		}
		Tlow3.setLeixin(Tlow3leixin);
		Tlow3.setJiaobanshijian(Tlow3jiaobanshijian);
		Tlow3.setShuini1_shijizhi(Tlow3shuini1_shijizhi);
		Tlow3.setShuini2_shijizhi(Tlow3shuini2_shijizhi);
		Tlow3.setKuangfen3_shijizhi(Tlow3kuangfen3_shijizhi);
		Tlow3.setFeimeihui4_shijizhi(Tlow3feimeihui4_shijizhi);
		Tlow3.setFenliao5_shijizhi(Tlow3fenliao5_shijizhi);
		Tlow3.setFenliao6_shijizhi(Tlow3fenliao6_shijizhi);
		Tlow3.setSha1_shijizhi(Tlow3sha1_shijizhi);
		Tlow3.setShi1_shijizhi(Tlow3shi1_shijizhi);
		Tlow3.setShi2_shijizhi(Tlow3shi2_shijizhi);
		Tlow3.setSha2_shijizhi(Tlow3sha2_shijizhi);
		Tlow3.setGuliao5_shijizhi(Tlow3guliao5_shijizhi);
		Tlow3.setShui1_shijizhi(Tlow3shui1_shijizhi);
		Tlow3.setShui2_shijizhi(Tlow3shui2_shijizhi);
		Tlow3.setWaijiaji1_shijizhi(Tlow3waijiaji1_shijizhi);
		Tlow3.setWaijiaji2_shijizhi(Tlow3waijiaji2_shijizhi);
		Tlow3.setWaijiaji3_shijizhi(Tlow3waijiaji3_shijizhi);
		Tlow3.setWaijiaji4_shijizhi(Tlow3waijiaji4_shijizhi);
		hntbhzziduancfgService.saveOrUpdate(Tlow3);
		//12
		String Thigh3id=request.getParameter("Thigh3.id");
		String Thigh3gprsbianhao=request.getParameter("Thigh3.gprsbianhao");
		String Thigh3leixin=request.getParameter("Thigh3.leixin");
		String Thigh3jiaobanshijian=request.getParameter("Thigh3.jiaobanshijian");
		String Thigh3shuini1_shijizhi=request.getParameter("Thigh3.shuini1_shijizhi");
		String Thigh3shuini2_shijizhi=request.getParameter("Thigh3.shuini2_shijizhi");
		String Thigh3kuangfen3_shijizhi=request.getParameter("Thigh3.kuangfen3_shijizhi");
		String Thigh3feimeihui4_shijizhi=request.getParameter("Thigh3.feimeihui4_shijizhi");
		String Thigh3fenliao5_shijizhi=request.getParameter("Thigh3.fenliao5_shijizhi");
		String Thigh3fenliao6_shijizhi=request.getParameter("Thigh3.fenliao6_shijizhi");
		String Thigh3sha1_shijizhi=request.getParameter("Thigh3.sha1_shijizhi");
		String Thigh3shi1_shijizhi=request.getParameter("Thigh3.shi1_shijizhi");
		String Thigh3shi2_shijizhi=request.getParameter("Thigh3.shi2_shijizhi");
		String Thigh3sha2_shijizhi=request.getParameter("Thigh3.sha2_shijizhi");
		String Thigh3guliao5_shijizhi=request.getParameter("Thigh3.guliao5_shijizhi");
		String Thigh3shui1_shijizhi=request.getParameter("Thigh3.shui1_shijizhi");
		String Thigh3shui2_shijizhi=request.getParameter("Thigh3.shui2_shijizhi");
		String Thigh3waijiaji1_shijizhi=request.getParameter("Thigh3.waijiaji1_shijizhi");
		String Thigh3waijiaji2_shijizhi=request.getParameter("Thigh3.waijiaji2_shijizhi");
		String Thigh3waijiaji3_shijizhi=request.getParameter("Thigh3.waijiaji3_shijizhi");
		String Thigh3waijiaji4_shijizhi=request.getParameter("Thigh3.waijiaji4_shijizhi");
		HntbhzziduancfgEntity Thigh3=new HntbhzziduancfgEntity();
		if(StringUtil.isNotEmpty(Thigh3id)){Thigh3.setId(new Integer(Thigh3id));}
		if(null==Thigh3gprsbianhao||Thigh3gprsbianhao.equals("")){
			Thigh3.setGprsbianhao(hntissmsgprsbianhao);
		}else{
			Thigh3.setGprsbianhao(Thigh3gprsbianhao);
		}
		Thigh3.setLeixin(Thigh3leixin);
		Thigh3.setJiaobanshijian(Thigh3jiaobanshijian);
		Thigh3.setShuini1_shijizhi(Thigh3shuini1_shijizhi);
		Thigh3.setShuini2_shijizhi(Thigh3shuini2_shijizhi);
		Thigh3.setKuangfen3_shijizhi(Thigh3kuangfen3_shijizhi);
		Thigh3.setFeimeihui4_shijizhi(Thigh3feimeihui4_shijizhi);
		Thigh3.setFenliao5_shijizhi(Thigh3fenliao5_shijizhi);
		Thigh3.setFenliao6_shijizhi(Thigh3fenliao6_shijizhi);
		Thigh3.setSha1_shijizhi(Thigh3sha1_shijizhi);
		Thigh3.setShi1_shijizhi(Thigh3shi1_shijizhi);
		Thigh3.setShi2_shijizhi(Thigh3shi2_shijizhi);
		Thigh3.setSha2_shijizhi(Thigh3sha2_shijizhi);
		Thigh3.setGuliao5_shijizhi(Thigh3guliao5_shijizhi);
		Thigh3.setShui1_shijizhi(Thigh3shui1_shijizhi);
		Thigh3.setShui2_shijizhi(Thigh3shui2_shijizhi);
		Thigh3.setWaijiaji1_shijizhi(Thigh3waijiaji1_shijizhi);
		Thigh3.setWaijiaji2_shijizhi(Thigh3waijiaji2_shijizhi);
		Thigh3.setWaijiaji3_shijizhi(Thigh3waijiaji3_shijizhi);
		Thigh3.setWaijiaji4_shijizhi(Thigh3waijiaji4_shijizhi);
		hntbhzziduancfgService.saveOrUpdate(Thigh3);
		//13
		String Tnumber3id=request.getParameter("Tnumber3.id");
		String Tnumber3gprsbianhao=request.getParameter("Tnumber3.gprsbianhao");
		String Tnumber3leixin=request.getParameter("Tnumber3.leixin");
		String Tnumber3jiaobanshijian=request.getParameter("Tnumber3.jiaobanshijian");
		String Tnumber3shuini1_shijizhi=request.getParameter("Tnumber3.shuini1_shijizhi");
		String Tnumber3shuini2_shijizhi=request.getParameter("Tnumber3.shuini2_shijizhi");
		String Tnumber3kuangfen3_shijizhi=request.getParameter("Tnumber3.kuangfen3_shijizhi");
		String Tnumber3feimeihui4_shijizhi=request.getParameter("Tnumber3.feimeihui4_shijizhi");
		String Tnumber3fenliao5_shijizhi=request.getParameter("Tnumber3.fenliao5_shijizhi");
		String Tnumber3fenliao6_shijizhi=request.getParameter("Tnumber3.fenliao6_shijizhi");
		String Tnumber3sha1_shijizhi=request.getParameter("Tnumber3.sha1_shijizhi");
		String Tnumber3shi1_shijizhi=request.getParameter("Tnumber3.shi1_shijizhi");
		String Tnumber3shi2_shijizhi=request.getParameter("Tnumber3.shi2_shijizhi");
		String Tnumber3sha2_shijizhi=request.getParameter("Tnumber3.sha2_shijizhi");
		String Tnumber3guliao5_shijizhi=request.getParameter("Tnumber3.guliao5_shijizhi");
		String Tnumber3shui1_shijizhi=request.getParameter("Tnumber3.shui1_shijizhi");
		String Tnumber3shui2_shijizhi=request.getParameter("Tnumber3.shui2_shijizhi");
		String Tnumber3waijiaji1_shijizhi=request.getParameter("Tnumber3.waijiaji1_shijizhi");
		String Tnumber3waijiaji2_shijizhi=request.getParameter("Tnumber3.waijiaji2_shijizhi");
		String Tnumber3waijiaji3_shijizhi=request.getParameter("Tnumber3.waijiaji3_shijizhi");
		String Tnumber3waijiaji4_shijizhi=request.getParameter("Tnumber3.waijiaji4_shijizhi");
		
		HntbhzziduancfgEntity Tnumber3=new HntbhzziduancfgEntity();
		if(StringUtil.isNotEmpty(Tnumber3id)){Tnumber3.setId(new Integer(Tnumber3id));}
		if(null==Tnumber3gprsbianhao||Tnumber3gprsbianhao.equals("")){
			Tnumber3.setGprsbianhao(hntissmsgprsbianhao);
		}else{
			Tnumber3.setGprsbianhao(Tnumber3gprsbianhao);
		}
		Tnumber3.setLeixin(Tnumber3leixin);
		Tnumber3.setJiaobanshijian(Tnumber3jiaobanshijian);
		Tnumber3.setShuini1_shijizhi(Tnumber3shuini1_shijizhi);
		Tnumber3.setShuini2_shijizhi(Tnumber3shuini2_shijizhi);
		Tnumber3.setKuangfen3_shijizhi(Tnumber3kuangfen3_shijizhi);
		Tnumber3.setFeimeihui4_shijizhi(Tnumber3feimeihui4_shijizhi);
		Tnumber3.setFenliao5_shijizhi(Tnumber3fenliao5_shijizhi);
		Tnumber3.setFenliao6_shijizhi(Tnumber3fenliao6_shijizhi);
		Tnumber3.setSha1_shijizhi(Tnumber3sha1_shijizhi);
		Tnumber3.setShi1_shijizhi(Tnumber3shi1_shijizhi);
		Tnumber3.setShi2_shijizhi(Tnumber3shi2_shijizhi);
		Tnumber3.setSha2_shijizhi(Tnumber3sha2_shijizhi);
		Tnumber3.setGuliao5_shijizhi(Tnumber3guliao5_shijizhi);
		Tnumber3.setShui1_shijizhi(Tnumber3shui1_shijizhi);
		Tnumber3.setShui2_shijizhi(Tnumber3shui2_shijizhi);
		Tnumber3.setWaijiaji1_shijizhi(Tnumber3waijiaji1_shijizhi);
		Tnumber3.setWaijiaji2_shijizhi(Tnumber3waijiaji2_shijizhi);
		Tnumber3.setWaijiaji3_shijizhi(Tnumber3waijiaji3_shijizhi);
		Tnumber3.setWaijiaji4_shijizhi(Tnumber3waijiaji4_shijizhi);
		hntbhzziduancfgService.saveOrUpdate(Tnumber3);
		
		if (StringUtil.isNotEmpty(hntissmsid)) {
			message = "水泥混凝土短信报警配置更新成功";
			try {
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "水泥混凝土短信报警配置更新失败";
			}
		} else {
			message = "水泥混凝土短信报警配置添加成功";
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}
	
	@RequestMapping(params = "delsmscfg")
	@ResponseBody
	public AjaxJson delsmscfg(TopRealMaxhunnintuViewEntity topRealMaxhunnintuView, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "水泥混凝土短信报警配置删除成功";
		String gprsbh=request.getParameter("shebeibianhao");
		if(StringUtil.isNotEmpty(gprsbh)){
			String temp=topRealMaxhunnintuViewService.delByGprsbhandleixin(gprsbh, 4, 16);
			if(StringUtil.isEmpty(temp)){
				message = "水泥混凝土短信报警配置删除失败";
			}
		}else{
			message = "水泥混凝土短信报警配置删除失败";
		}
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}


	
}
