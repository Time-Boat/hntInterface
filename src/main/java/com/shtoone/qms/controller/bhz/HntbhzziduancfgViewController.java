package com.shtoone.qms.controller.bhz;
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
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.shtoone.qms.entity.bhz.BanhezhanxinxiEntity;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgEntity;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.service.bhz.BanhezhanxinxiServiceI;
import com.shtoone.qms.service.bhz.HntbhzziduancfgServiceI;
import com.shtoone.qms.service.bhz.HntbhzziduancfgViewServiceI;
import com.shtoone.qms.service.bhz.TopRealMaxhunnintuViewServiceI;

/**   
 * @Title: Controller
 * @Description: 水泥混凝土字段及报警配置视图
 * @author zhangdaihao
 * @date 2015-06-17 10:23:03
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hntbhzziduancfgViewController")
public class HntbhzziduancfgViewController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HntbhzziduancfgViewController.class);

	@Autowired
	private HntbhzziduancfgViewServiceI hntbhzziduancfgViewService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private HntbhzziduancfgServiceI hntbhzziduancfgService;
	@Autowired
	private TopRealMaxhunnintuViewServiceI topRealMaxhunnintuViewService;
	@Autowired
	private BanhezhanxinxiServiceI banhezhanxinxiService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 水泥混凝土字段及报警配置视图列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "hntbhzziduancfgView")
	public ModelAndView hntbhzziduancfgView(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/hntbhzziduancfgList");
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
	public void datagrid(HntbhzziduancfgViewEntity hntbhzziduancfgView,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
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
		
		JSONObject jObject = hntbhzziduancfgService.getDatagrid3(hntbhzziduancfgView, dataGrid,
				departid,shebeibianhao, userlft, userrgt);
		responseDatagrid(response, jObject);
		
//		CriteriaQuery cq = new CriteriaQuery(HntbhzziduancfgViewEntity.class, dataGrid);
//		//查询条件组装器
//		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hntbhzziduancfgView, request.getParameterMap());
//		this.hntbhzziduancfgViewService.getDataGridReturn(cq, true);
//		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除水泥混凝土字段及报警配置视图
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(HntbhzziduancfgViewEntity hntbhzziduancfgView, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();

		//hntbhzziduancfgView = systemService.getEntity(HntbhzziduancfgViewEntity.class, hntbhzziduancfgView.getId());
		HntbhzziduancfgEntity temp=systemService.getEntity(HntbhzziduancfgEntity.class, new Integer(hntbhzziduancfgView.getId()));
		String gprsbianhao=temp.getGprsbianhao();
		hntbhzziduancfgService.delete(temp);
		HntbhzziduancfgEntity hntcfgisshow = topRealMaxhunnintuViewService.hntisshowcfgBybhDEL(gprsbianhao);
		if (null != hntcfgisshow) {
			hntbhzziduancfgService.delete(hntcfgisshow);
		}
		message = "水泥混凝土字段及报警配置视图删除成功";
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加水泥混凝土字段及报警配置视图
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(HntbhzziduancfgViewEntity temp, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		
		String gprsbianhao=request.getParameter("hntcfg.gprsbianhao");
		String hntcfgid=request.getParameter("hntcfg.id");
		String hntisshowcfgid=request.getParameter("hntisshowcfg.id");
		String hntcfgleixin=request.getParameter("hntcfg.leixin");
		String hntisshowcfgleixin=request.getParameter("hntisshowcfg.leixin");
		
		HntbhzziduancfgEntity hntcfg=new HntbhzziduancfgEntity();
		if(StringUtil.isNotEmpty(hntcfgid)){hntcfg.setId(new Integer(hntcfgid));}
		hntcfg.setGprsbianhao(gprsbianhao);
		hntcfg.setLeixin(hntcfgleixin);
		hntcfg.setBaocunshijian(temp.getBaocunshijian()); 
		hntcfg.setChaozuozhe(temp.getChaozuozhe());
		hntcfg.setChuliaoshijian(temp.getChuliaoshijian());
		hntcfg.setGongchengmingcheng(temp.getGongchengmingcheng());
		hntcfg.setGongdanhao(temp.getGongdanhao());
		hntcfg.setJiaozuobuwei(temp.getJiaozuobuwei());
		hntcfg.setPeifanghao(temp.getPeifanghao());
		hntcfg.setQiangdudengji(temp.getQiangdudengji());
		hntcfg.setShebeibianhao(temp.getShebeibianhao());
		hntcfg.setShuinipingzhong(temp.getShuinipingzhong());
		hntcfg.setSigongdidian(temp.getSigongdidian());
		hntcfg.setCaijishijian(temp.getCaijishijian());
		hntcfg.setGujifangshu(temp.getGujifangshu());
		hntcfg.setWaijiajipingzhong(temp.getWaijiajipingzhong());
		hntcfg.setJiaobanshijian(temp.getJiaobanshijian());
		hntcfg.setShuini1_shijizhi(temp.getShuini1_shijizhi());
		hntcfg.setShuini2_shijizhi(temp.getShuini2_shijizhi());
		hntcfg.setKuangfen3_shijizhi(temp.getKuangfen3_shijizhi());
		hntcfg.setFeimeihui4_shijizhi(temp.getFeimeihui4_shijizhi());
		hntcfg.setFenliao5_shijizhi(temp.getFenliao5_shijizhi());
		hntcfg.setFenliao6_shijizhi(temp.getFenliao6_shijizhi());
		hntcfg.setSha1_shijizhi(temp.getSha1_shijizhi());
		hntcfg.setShi1_shijizhi(temp.getShi1_shijizhi());
		hntcfg.setShi2_shijizhi(temp.getShi2_shijizhi());
		hntcfg.setSha2_shijizhi(temp.getSha2_shijizhi());
		hntcfg.setGuliao5_shijizhi(temp.getGuliao5_shijizhi());
		hntcfg.setShui1_shijizhi(temp.getShui1_shijizhi());
		hntcfg.setShui2_shijizhi(temp.getShui2_shijizhi());
		hntcfg.setWaijiaji1_shijizhi(temp.getWaijiaji1_shijizhi());
		hntcfg.setWaijiaji2_shijizhi(temp.getWaijiaji2_shijizhi());
		hntcfg.setWaijiaji3_shijizhi(temp.getWaijiaji3_shijizhi());
		hntcfg.setWaijiaji4_shijizhi(temp.getWaijiaji4_shijizhi());
		
		hntcfg.setShuini1_lilunzhi(temp.getShuini1_lilunzhi());
		hntcfg.setShuini2_lilunzhi(temp.getShuini2_lilunzhi());
		hntcfg.setKuangfen3_lilunzhi(temp.getKuangfen3_lilunzhi());
		hntcfg.setFeimeihui4_lilunzhi(temp.getFeimeihui4_lilunzhi());
		hntcfg.setFenliao5_lilunzhi(temp.getFenliao5_lilunzhi());
		hntcfg.setFenliao6_lilunzhi(temp.getFenliao6_lilunzhi());
		hntcfg.setSha1_lilunzhi(temp.getSha1_lilunzhi());
		hntcfg.setShi1_lilunzhi(temp.getShi1_lilunzhi());
		hntcfg.setShi2_lilunzhi(temp.getShi2_lilunzhi());
		hntcfg.setSha2_lilunzhi(temp.getSha2_lilunzhi());
		hntcfg.setGuliao5_lilunzhi(temp.getGuliao5_lilunzhi());
		hntcfg.setShui1_lilunzhi(temp.getShui1_lilunzhi());
		hntcfg.setShui2_lilunzhi(temp.getShui2_lilunzhi());
		hntcfg.setWaijiaji1_lilunzhi(temp.getWaijiaji1_lilunzhi());
		hntcfg.setWaijiaji2_lilunzhi(temp.getWaijiaji2_lilunzhi());
		hntcfg.setWaijiaji3_lilunzhi(temp.getWaijiaji3_lilunzhi());
		hntcfg.setWaijiaji4_lilunzhi(temp.getWaijiaji4_lilunzhi());
		
		
		hntbhzziduancfgService.saveOrUpdate(hntcfg);
		
		String baocunshijian=request.getParameter("hntisshowcfg.baocunshijian"); 
		//System.out.println(">>>>>>>>>"+baocunshijian+">>>>>hntisshowcfgid："+hntisshowcfgid);
		String chaozuozhe=request.getParameter("hntisshowcfg.chaozuozhe");
		String chuliaoshijian=request.getParameter("hntisshowcfg.chuliaoshijian");
		String gongchengmingcheng=request.getParameter("hntisshowcfg.gongchengmingcheng");
		String gongdanhao=request.getParameter("hntisshowcfg.gongdanhao");
		String jiaozuobuwei=request.getParameter("hntisshowcfg.jiaozuobuwei");
		String peifanghao=request.getParameter("hntisshowcfg.peifanghao");
		String qiangdudengji=request.getParameter("hntisshowcfg.qiangdudengji");
		String shebeibianhao=request.getParameter("hntisshowcfg.shebeibianhao");
		String shuinipingzhong=request.getParameter("hntisshowcfg.shuinipingzhong");
		String sigongdidian=request.getParameter("hntisshowcfg.sigongdidian");
		String caijishijian=request.getParameter("hntisshowcfg.caijishijian");
		String gujifangshu=request.getParameter("hntisshowcfg.gujifangshu");
		String waijiajipingzhong=request.getParameter("hntisshowcfg.waijiajipingzhong");
		String hntissmsjiaobanshijian=request.getParameter("hntisshowcfg.jiaobanshijian");
		String hntissmsshuini1_shijizhi=request.getParameter("hntisshowcfg.shuini1_shijizhi");
		String hntissmsshuini2_shijizhi=request.getParameter("hntisshowcfg.shuini2_shijizhi");
		String hntissmskuangfen3_shijizhi=request.getParameter("hntisshowcfg.kuangfen3_shijizhi");
		String hntissmsfeimeihui4_shijizhi=request.getParameter("hntisshowcfg.feimeihui4_shijizhi");
		String hntissmsfenliao5_shijizhi=request.getParameter("hntisshowcfg.fenliao5_shijizhi");
		String hntissmsfenliao6_shijizhi=request.getParameter("hntisshowcfg.fenliao6_shijizhi");
		String hntissmssha1_shijizhi=request.getParameter("hntisshowcfg.sha1_shijizhi");
		String hntissmsshi1_shijizhi=request.getParameter("hntisshowcfg.shi1_shijizhi");
		String hntissmsshi2_shijizhi=request.getParameter("hntisshowcfg.shi2_shijizhi");
		String hntissmssha2_shijizhi=request.getParameter("hntisshowcfg.sha2_shijizhi");
		String hntissmsguliao5_shijizhi=request.getParameter("hntisshowcfg.guliao5_shijizhi");
		String hntissmsshui1_shijizhi=request.getParameter("hntisshowcfg.shui1_shijizhi");
		String hntissmsshui2_shijizhi=request.getParameter("hntisshowcfg.shui2_shijizhi");
		String hntissmswaijiaji1_shijizhi=request.getParameter("hntisshowcfg.waijiaji1_shijizhi");
		String hntissmswaijiaji2_shijizhi=request.getParameter("hntisshowcfg.waijiaji2_shijizhi");
		String hntissmswaijiaji3_shijizhi=request.getParameter("hntisshowcfg.waijiaji3_shijizhi");
		String hntissmswaijiaji4_shijizhi=request.getParameter("hntisshowcfg.waijiaji4_shijizhi");
		
		String hntissmsshuini1_lilunzhi=request.getParameter("hntisshowcfg.shuini1_lilunzhi");
		String hntissmsshuini2_lilunzhi=request.getParameter("hntisshowcfg.shuini2_lilunzhi");
		String hntissmskuangfen3_lilunzhi=request.getParameter("hntisshowcfg.kuangfen3_lilunzhi");
		String hntissmsfeimeihui4_lilunzhi=request.getParameter("hntisshowcfg.feimeihui4_lilunzhi");
		String hntissmsfenliao5_lilunzhi=request.getParameter("hntisshowcfg.fenliao5_lilunzhi");
		String hntissmsfenliao6_lilunzhi=request.getParameter("hntisshowcfg.fenliao6_lilunzhi");
		String hntissmssha1_lilunzhi=request.getParameter("hntisshowcfg.sha1_lilunzhi");
		String hntissmsshi1_lilunzhi=request.getParameter("hntisshowcfg.shi1_lilunzhi");
		String hntissmsshi2_lilunzhi=request.getParameter("hntisshowcfg.shi2_lilunzhi");
		String hntissmssha2_lilunzhi=request.getParameter("hntisshowcfg.sha2_lilunzhi");
		String hntissmsguliao5_lilunzhi=request.getParameter("hntisshowcfg.guliao5_lilunzhi");
		String hntissmsshui1_lilunzhi=request.getParameter("hntisshowcfg.shui1_lilunzhi");
		String hntissmsshui2_lilunzhi=request.getParameter("hntisshowcfg.shui2_lilunzhi");
		String hntissmswaijiaji1_lilunzhi=request.getParameter("hntisshowcfg.waijiaji1_lilunzhi");
		String hntissmswaijiaji2_lilunzhi=request.getParameter("hntisshowcfg.waijiaji2_lilunzhi");
		String hntissmswaijiaji3_lilunzhi=request.getParameter("hntisshowcfg.waijiaji3_lilunzhi");
		String hntissmswaijiaji4_lilunzhi=request.getParameter("hntisshowcfg.waijiaji4_lilunzhi");
		HntbhzziduancfgEntity hntissms=new HntbhzziduancfgEntity();
		if(StringUtil.isNotEmpty(hntisshowcfgid)){hntissms.setId(new Integer(hntisshowcfgid));}
		hntissms.setGprsbianhao(gprsbianhao);
		hntissms.setLeixin(hntisshowcfgleixin);
		hntissms.setBaocunshijian(baocunshijian); 
		hntissms.setChaozuozhe(chaozuozhe);
		hntissms.setChuliaoshijian(chuliaoshijian);
		hntissms.setGongchengmingcheng(gongchengmingcheng);
		hntissms.setGongdanhao(gongdanhao);
		hntissms.setJiaozuobuwei(jiaozuobuwei);
		hntissms.setPeifanghao(peifanghao);
		hntissms.setQiangdudengji(qiangdudengji);
		hntissms.setShebeibianhao(shebeibianhao);
		hntissms.setShuinipingzhong(shuinipingzhong);
		hntissms.setSigongdidian(sigongdidian);
		hntissms.setCaijishijian(caijishijian);
		hntissms.setGujifangshu(gujifangshu);
		hntissms.setWaijiajipingzhong(waijiajipingzhong);
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
		
		hntissms.setShuini1_lilunzhi(hntissmsshuini1_lilunzhi);
		hntissms.setShuini2_lilunzhi(hntissmsshuini2_lilunzhi);
		hntissms.setKuangfen3_lilunzhi(hntissmskuangfen3_lilunzhi);
		hntissms.setFeimeihui4_lilunzhi(hntissmsfeimeihui4_lilunzhi);
		hntissms.setFenliao5_lilunzhi(hntissmsfenliao5_lilunzhi);
		hntissms.setFenliao6_lilunzhi(hntissmsfenliao6_lilunzhi);
		hntissms.setSha1_lilunzhi(hntissmssha1_lilunzhi);
		hntissms.setShi1_lilunzhi(hntissmsshi1_lilunzhi);
		hntissms.setShi2_lilunzhi(hntissmsshi2_lilunzhi);
		hntissms.setSha2_lilunzhi(hntissmssha2_lilunzhi);
		hntissms.setGuliao5_lilunzhi(hntissmsguliao5_lilunzhi);
		hntissms.setShui1_lilunzhi(hntissmsshui1_lilunzhi);
		hntissms.setShui2_lilunzhi(hntissmsshui2_lilunzhi);
		hntissms.setWaijiaji1_lilunzhi(hntissmswaijiaji1_lilunzhi);
		hntissms.setWaijiaji2_lilunzhi(hntissmswaijiaji2_lilunzhi);
		hntissms.setWaijiaji3_lilunzhi(hntissmswaijiaji3_lilunzhi);
		hntissms.setWaijiaji4_lilunzhi(hntissmswaijiaji4_lilunzhi);
		
		hntbhzziduancfgService.saveOrUpdate(hntissms);
		
		if(StringUtil.isNotEmpty(hntcfgid)){
			message = "水泥混凝土字段配置更新成功";
		}else{
			message = "水泥混凝土字段配置添加成功";
		}
		/*
		if (StringUtil.isNotEmpty(hntbhzziduancfgView.getId())) {
			message = "水泥混凝土字段及报警配置视图更新成功";
			HntbhzziduancfgViewEntity t = hntbhzziduancfgViewService.get(HntbhzziduancfgViewEntity.class, hntbhzziduancfgView.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(hntbhzziduancfgView, t);
				hntbhzziduancfgViewService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "水泥混凝土字段及报警配置视图更新失败";
			}
		} else {
			message = "水泥混凝土字段及报警配置视图添加成功";
			hntbhzziduancfgViewService.save(hntbhzziduancfgView);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}*/
		j.setMsg(message);
		return j;
	}

	/**
	 * 水泥混凝土字段及报警配置视图列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(HntbhzziduancfgViewEntity hntbhzziduancfgView, HttpServletRequest req) {
		
		List<BanhezhanxinxiEntity> banhezhanxinxiList=systemService.getList(BanhezhanxinxiEntity.class);
		req.setAttribute("banhezhanxinxiList", banhezhanxinxiList);
		
		Integer cfgId=0;
		if(null!=req.getParameter("id")){
			cfgId=new Integer(req.getParameter("id"));
		}
		Integer defaultId=new Integer(req.getParameter("defaultId"));
		String leixinbh=req.getParameter("shebeibianhao");
		req.setAttribute("cfgId", cfgId);
		req.setAttribute("defaultId", defaultId);
		//System.out.println(cfgId+"==="+defaultId+"===="+leixinbh);
		HntbhzziduancfgEntity hntcfg=null;
		HntbhzziduancfgEntity hntisshowcfg=null;
		if (cfgId > 0) {//编辑
			hntcfg=hntbhzziduancfgService.getEntity(HntbhzziduancfgEntity.class, cfgId);
			hntisshowcfg=topRealMaxhunnintuViewService.hntisshowcfgBybh(hntcfg.getGprsbianhao());
		} else if (defaultId > 0) {//默认值
			hntcfg=topRealMaxhunnintuViewService.hntfieldnameBybh(leixinbh);
			hntisshowcfg=topRealMaxhunnintuViewService.hntisshowcfgBybh(leixinbh);
		} else {//新增
			hntcfg=topRealMaxhunnintuViewService.getDefaultziduancfg();
			hntisshowcfg=topRealMaxhunnintuViewService.getDefaultziduanshow();			
		}

		req.setAttribute("hntcfg", hntcfg);
		req.setAttribute("hntisshowcfg", hntisshowcfg);
//		if (StringUtil.isNotEmpty(hntbhzziduancfgView.getId())) {
//			
//			hntbhzziduancfgView = hntbhzziduancfgViewService.getEntity(HntbhzziduancfgViewEntity.class, hntbhzziduancfgView.getId());
//			req.setAttribute("hntbhzziduancfgViewPage", hntbhzziduancfgView);
//		}
		return new ModelAndView("com/shtoone/qms/bhz/hntbhzziduancfg");
	}
}
