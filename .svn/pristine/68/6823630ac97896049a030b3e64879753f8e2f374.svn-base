package com.shtoone.qms.controller.bhz;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.shtoone.qms.entity.bhz.HntbhzziduancfgEntity;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.entity.bhz.HunnintuView;
import com.shtoone.qms.entity.bhz.SYclGuigexinghaomEntity;
import com.shtoone.qms.entity.bhz.WuchaIsShowData;
import com.shtoone.qms.service.bhz.HntbhzziduancfgServiceI;
import com.shtoone.qms.service.bhz.HntbhzziduancfgViewServiceI;
import com.shtoone.qms.service.bhz.HunnintuViewServiceI;

/**   
 * @Title: Controller
 * @Description: 拌合站时间查询
 * @author zhangdaihao
 * @date 2015-06-18 09:35:27
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hntwuchaViewController")
public class HntwuchaViewController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HntwuchaViewController.class);

	@Autowired
	private HunnintuViewServiceI hunnintuViewService;
	@Autowired
	private SystemService systemService;

	@Autowired
	private HntbhzziduancfgViewServiceI hntbhzziduancfgViewService;
	
	@Autowired
	private HntbhzziduancfgServiceI hntbhzziduancfgService;
	
	private String message;
	private String startTime;
	private String endTime;
	private String jiaozuobuwei;
	private String gongchengmingcheng;
	private String pid;
	private TSDepart dpt;//上级部门
	private Integer userlft = 0;
	private Integer userrgt =0;
	
	String shebeibianhao;
	
	private Integer[] wuchaselect;
	private List<WuchaIsShowData> wuchalist;
	
	
	public TSDepart getDpt() {
		return dpt;
	}

	public void setDpt(TSDepart dpt) {
		this.dpt = dpt;
	}

	public String getGongchengmingcheng() {
		return gongchengmingcheng;
	}

	public void setGongchengmingcheng(String gongchengmingcheng) {
		this.gongchengmingcheng = gongchengmingcheng;
	}

	public String getJiaozuobuwei() {
		return jiaozuobuwei;
	}

	public void setJiaozuobuwei(String jiaozuobuwei) {
		this.jiaozuobuwei = jiaozuobuwei;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public String getShebeibianhao() {
		return shebeibianhao;
	}

	public void setShebeibianhao(String shebeibianhao) {
		this.shebeibianhao = shebeibianhao;
	}

	/**
	 * 拌合站时间查询列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "hntwuchaView")
	public ModelAndView hunnintuViewList(HttpServletRequest request) {
		
		if (null != wuchaselect && wuchaselect.length > 0) {
			HntbhzziduancfgEntity hntcfgisshow = hntbhzziduancfgService.gethntcfg20(shebeibianhao);
			if (null == hntcfgisshow) {
				hntcfgisshow = new HntbhzziduancfgEntity();
				if (StringUtil.isNotEmpty(shebeibianhao)) {
					hntcfgisshow.setGprsbianhao(shebeibianhao);
					hntcfgisshow.setLeixin("21");
				} else {
					hntcfgisshow.setGprsbianhao("all");
					hntcfgisshow.setLeixin("20");
				}
			}
			
			List<Integer> selectlist = new ArrayList<Integer>();
			for (int h = 0; h < wuchaselect.length; h++) {
				selectlist.add(wuchaselect[h]);
			}
			if (selectlist.contains(1)) {
				hntcfgisshow.setShui1_shijizhi("1");
			} else {
				hntcfgisshow.setShui1_shijizhi("0");
			}
			if (selectlist.contains(2)) {
				hntcfgisshow.setShui2_shijizhi("1");
			} else {
				hntcfgisshow.setShui2_shijizhi("0");
			}
			if (selectlist.contains(3)) {
				hntcfgisshow.setShuini1_shijizhi("1");
			} else {
				hntcfgisshow.setShuini1_shijizhi("0");
			}
			if (selectlist.contains(4)) {
				hntcfgisshow.setShuini2_shijizhi("1");
			} else {
				hntcfgisshow.setShuini2_shijizhi("0");
			}
			if (selectlist.contains(5)) {
				hntcfgisshow.setKuangfen3_shijizhi("1");
			} else {
				hntcfgisshow.setKuangfen3_shijizhi("0");
			}
			if (selectlist.contains(6)) {
				hntcfgisshow.setFeimeihui4_shijizhi("1");
			} else {
				hntcfgisshow.setFeimeihui4_shijizhi("0");
			}
			if (selectlist.contains(7)) {
				hntcfgisshow.setFenliao5_shijizhi("1");
			} else {
				hntcfgisshow.setFenliao5_shijizhi("0");
			}
			if (selectlist.contains(8)) {
				hntcfgisshow.setFenliao6_shijizhi("1");
			} else {
				hntcfgisshow.setFenliao6_shijizhi("0");
			} 
			if (selectlist.contains(9)) {
				hntcfgisshow.setSha1_shijizhi("1");
			} else {
				hntcfgisshow.setSha1_shijizhi("0");
			}
			if (selectlist.contains(10)) {
				hntcfgisshow.setShi1_shijizhi("1");
			} else {
				hntcfgisshow.setShi1_shijizhi("0");
			}
			if (selectlist.contains(11)) {
				hntcfgisshow.setShi2_shijizhi("1");
			} else {
				hntcfgisshow.setShi2_shijizhi("0");
			}
			if (selectlist.contains(12)) {
				hntcfgisshow.setSha2_shijizhi("1");
			} else {
				hntcfgisshow.setSha2_shijizhi("0");
			}
			if (selectlist.contains(13)) {
				hntcfgisshow.setGuliao5_shijizhi("1");
			} else {
				hntcfgisshow.setGuliao5_shijizhi("0");
			}
			if (selectlist.contains(14)) {
				hntcfgisshow.setWaijiaji1_shijizhi("1");
			} else {
				hntcfgisshow.setWaijiaji1_shijizhi("0");
			}
			if (selectlist.contains(15)) {
				hntcfgisshow.setWaijiaji2_shijizhi("1");
			} else {
				hntcfgisshow.setWaijiaji2_shijizhi("0");
			}
			if (selectlist.contains(16)) {
				hntcfgisshow.setWaijiaji3_shijizhi("1");
			} else {
				hntcfgisshow.setWaijiaji3_shijizhi("0");
			}
			if (selectlist.contains(17)) {
				hntcfgisshow.setWaijiaji4_shijizhi("1");
			} else  {
				hntcfgisshow.setWaijiaji4_shijizhi("0");
			}
			hntbhzziduancfgService.saveOrUpdate(hntcfgisshow);
		}
		
		//这里加载出所有的材料名称
		HntbhzziduancfgViewEntity hntziduancfgField=hntbhzziduancfgViewService.gethntcfgfield(shebeibianhao);
		HntbhzziduancfgViewEntity hntziduancfgIsshow=hntbhzziduancfgViewService.gethntbhzisShow(shebeibianhao);
		if (null == hntziduancfgIsshow) {
			HntbhzziduancfgEntity hntcfgisshow = hntbhzziduancfgService.gethntcfg20(shebeibianhao);
			if (null == hntcfgisshow) {
				hntcfgisshow = new HntbhzziduancfgEntity();
				if (StringUtil.isNotEmpty(shebeibianhao)) {
					hntcfgisshow.setGprsbianhao(shebeibianhao);
					hntcfgisshow.setLeixin("21");
				} else {
					hntcfgisshow.setGprsbianhao("all");
					hntcfgisshow.setLeixin("20");
				}
			}
			hntcfgisshow.setShui1_shijizhi("1");
			hntcfgisshow.setShui2_shijizhi("1");
			hntcfgisshow.setShuini1_shijizhi("1");
			hntcfgisshow.setShuini2_shijizhi("1");
			hntcfgisshow.setKuangfen3_shijizhi("1");
			hntcfgisshow.setFeimeihui4_shijizhi("1");
			hntcfgisshow.setFenliao5_shijizhi("1");
			hntcfgisshow.setFenliao6_shijizhi("1");
			hntcfgisshow.setSha1_shijizhi("1");
			hntcfgisshow.setShi1_shijizhi("1");
			hntcfgisshow.setShi2_shijizhi("1");
			hntcfgisshow.setSha2_shijizhi("1");
			hntcfgisshow.setGuliao5_shijizhi("1");
			hntcfgisshow.setWaijiaji1_shijizhi("1");
			hntcfgisshow.setWaijiaji2_shijizhi("1");
			hntcfgisshow.setWaijiaji3_shijizhi("1");
			hntcfgisshow.setWaijiaji4_shijizhi("1");
			hntbhzziduancfgService.saveOrUpdate(hntcfgisshow);
			hntziduancfgIsshow = hntbhzziduancfgViewService.gethntbhzisShow(shebeibianhao);
		}		
		wuchalist = new ArrayList<WuchaIsShowData>();
		wuchaselect = new Integer[17];
		int i = 1;
		WuchaIsShowData wd = new WuchaIsShowData();
		if (StringUtil.isEmpty(hntziduancfgIsshow.getShui1_shijizhi(),"").equalsIgnoreCase("1")) {
			wuchaselect[i-1] = i;			
		} 
		wd.setId(i);
		i++;
		wd.setName(hntziduancfgField.getShui1_shijizhi());
		wuchalist.add(wd);
		
		wd = new WuchaIsShowData();
		if (StringUtil.isEmpty(hntziduancfgIsshow.getShui2_shijizhi(),"").equalsIgnoreCase("1")) {
			wuchaselect[i-1] = i;			
		} 
		wd.setId(i);
		i++;
		wd.setName(hntziduancfgField.getShui2_shijizhi());
		wuchalist.add(wd);
		
		wd = new WuchaIsShowData();
		if (StringUtil.isEmpty(hntziduancfgIsshow.getShuini1_shijizhi(),"").equalsIgnoreCase("1")) {
			wuchaselect[i-1] = i;			
		} 
		wd.setId(i);
		i++;
		wd.setName(hntziduancfgField.getShuini1_shijizhi());
		wuchalist.add(wd);
		
		wd = new WuchaIsShowData();
		if (StringUtil.isEmpty(hntziduancfgIsshow.getShuini2_shijizhi(),"").equalsIgnoreCase("1")) {
			wuchaselect[i-1] = i;			
		} 
		wd.setId(i);
		i++;
		wd.setName(hntziduancfgField.getShuini2_shijizhi());
		wuchalist.add(wd);
		
		wd = new WuchaIsShowData();
		if (StringUtil.isEmpty(hntziduancfgIsshow.getKuangfen3_shijizhi(),"").equalsIgnoreCase("1")) {
			wuchaselect[i-1] = i;			
		} 
		wd.setId(i);
		i++;
		wd.setName(hntziduancfgField.getKuangfen3_shijizhi());
		wuchalist.add(wd);
		
		
		wd = new WuchaIsShowData();
		if (StringUtil.isEmpty(hntziduancfgIsshow.getFeimeihui4_shijizhi(),"").equalsIgnoreCase("1")) {
			wuchaselect[i-1] = i;			
		} 
		wd.setId(i);
		i++;
		wd.setName(hntziduancfgField.getFeimeihui4_shijizhi());
		wuchalist.add(wd);
		
		wd = new WuchaIsShowData();
		if (StringUtil.isEmpty(hntziduancfgIsshow.getFenliao5_shijizhi(),"").equalsIgnoreCase("1")) {
			wuchaselect[i-1] = i;			
		} 
		wd.setId(i);
		i++;
		wd.setName(hntziduancfgField.getFenliao5_shijizhi());
		wuchalist.add(wd);
		
		wd = new WuchaIsShowData();
		if (StringUtil.isEmpty(hntziduancfgIsshow.getFenliao6_shijizhi(),"").equalsIgnoreCase("1")) {
			wuchaselect[i-1] = i;			
		} 
		wd.setId(i);
		i++;
		wd.setName(hntziduancfgField.getFenliao6_shijizhi());
		wuchalist.add(wd);
		
		wd = new WuchaIsShowData();
		if (StringUtil.isEmpty(hntziduancfgIsshow.getSha1_shijizhi(),"").equalsIgnoreCase("1")) {
			wuchaselect[i-1] = i;			
		} 
		wd.setId(i);
		i++;
		wd.setName(hntziduancfgField.getSha1_shijizhi());
		wuchalist.add(wd);
		
		wd = new WuchaIsShowData();
		if (StringUtil.isEmpty(hntziduancfgIsshow.getShi1_shijizhi(),"").equalsIgnoreCase("1")) {
			wuchaselect[i-1] = i;			
		} 
		wd.setId(i);
		i++;
		wd.setName(hntziduancfgField.getShi1_shijizhi());
		wuchalist.add(wd);
		
		wd = new WuchaIsShowData();
		if (StringUtil.isEmpty(hntziduancfgIsshow.getShi2_shijizhi(),"").equalsIgnoreCase("1")) {
			wuchaselect[i-1] = i;			
		} 
		wd.setId(i);
		i++;
		wd.setName(hntziduancfgField.getShi2_shijizhi());
		wuchalist.add(wd);
		
		wd = new WuchaIsShowData();
		if (StringUtil.isEmpty(hntziduancfgIsshow.getSha2_shijizhi(),"").equalsIgnoreCase("1")) {
			wuchaselect[i-1] = i;			
		} 
		wd.setId(i);
		i++;
		wd.setName(hntziduancfgField.getSha2_shijizhi());
		wuchalist.add(wd);
		
		wd = new WuchaIsShowData();
		if (StringUtil.isEmpty(hntziduancfgIsshow.getGuliao5_shijizhi(),"").equalsIgnoreCase("1")) {
			wuchaselect[i-1] = i;			
		} 
		wd.setId(i);
		i++;
		wd.setName(hntziduancfgField.getGuliao5_shijizhi());
		wuchalist.add(wd);
		
		wd = new WuchaIsShowData();
		if (StringUtil.isEmpty(hntziduancfgIsshow.getWaijiaji1_shijizhi(),"").equalsIgnoreCase("1")) {
			wuchaselect[i-1] = i;			
		} 
		wd.setId(i);
		i++;
		wd.setName(hntziduancfgField.getWaijiaji1_shijizhi());
		wuchalist.add(wd);
		
		wd = new WuchaIsShowData();
		if (StringUtil.isEmpty(hntziduancfgIsshow.getWaijiaji2_shijizhi(),"").equalsIgnoreCase("1")) {
			wuchaselect[i-1] = i;			
		} 
		wd.setId(i);
		i++;
		wd.setName(hntziduancfgField.getWaijiaji2_shijizhi());
		wuchalist.add(wd);
		
		wd = new WuchaIsShowData();
		if (StringUtil.isEmpty(hntziduancfgIsshow.getWaijiaji3_shijizhi(),"").equalsIgnoreCase("1")) {
			wuchaselect[i-1] = i;			
		} 
		wd.setId(i);
		i++;
		wd.setName(hntziduancfgField.getWaijiaji3_shijizhi());
		wuchalist.add(wd);
		
		wd = new WuchaIsShowData();
		if (StringUtil.isEmpty(hntziduancfgIsshow.getWaijiaji4_shijizhi(),"").equalsIgnoreCase("1")) {
			wuchaselect[i-1] = i;			
		} 
		wd.setId(i);
		i++;
		wd.setName(hntziduancfgField.getWaijiaji4_shijizhi());
		wuchalist.add(wd);
		request.setAttribute("wclist", wuchalist);
		request.setAttribute("wcselect", wuchaselect);
		
		/*HntbhzziduancfgViewEntity hbfield = hntbhzziduancfgViewService.gethntcfgfield(shebeibianhao);
		HntbhzziduancfgViewEntity hbisshow = hntbhzziduancfgViewService.gethntcfgisShow(shebeibianhao);*/
		request.setAttribute("fieldtest", hntziduancfgField);
		request.setAttribute("isshowtest", hntziduancfgIsshow);
		return new ModelAndView("com/shtoone/qms/bhz/hntwuchaViewController");
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
	public void datagrid(HunnintuView hunnintuView,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		setShebeibianhao(hunnintuView.getGprsbianhao());
		jiaozuobuwei=request.getParameter("jiaozuobuwei");//浇筑部位
		startTime=request.getParameter("startTime");//出料开始时间
		endTime=request.getParameter("endTime");//出料结束时间
		pid=request.getParameter("pid");
		String wclist=request.getParameter("wclist");
		shebeibianhao=request.getParameter("shebeibianhao");
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
		gongchengmingcheng=request.getParameter("gongchengmingcheng");//工程名称
		//System.out.println(startTime+"-00-"+endTime+"-11-"+pid+jiaozuobuwei+"-0-"+gongchengmingcheng+"-1-");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar day = Calendar.getInstance();
		if (endTime==null || endTime.equals("")) {
			
			setEndTime(sdf.format(day.getTime()));
			
		}
		if (startTime==null || startTime.equals("")) {
		day.add(Calendar.MONTH, -1);
		setStartTime(sdf.format(day.getTime()));
		}
		JSONObject jObject = hunnintuViewService.getDatagrid5(hunnintuView, dataGrid,startTime,endTime, userlft, userrgt,jiaozuobuwei,gongchengmingcheng,shebeibianhao);
		
		
		
		
		
		
		responseDatagrid(response, jObject);
		
		
		 
		
	}
	
	
	@RequestMapping(params = "datagrid1")
	public ModelAndView datagrid1(HunnintuView hunnintuView, HttpServletRequest req) {
		String id=req.getParameter("id"); 
		if (StringUtil.isNotEmpty(id)) {
			hunnintuView = hunnintuViewService.getEntity(HunnintuView.class, Integer.parseInt(id));
			HntbhzziduancfgViewEntity hbfield = hntbhzziduancfgViewService.gethntcfgfield(hunnintuView.getShebeibianhao());
			HntbhzziduancfgViewEntity hbisshow = hntbhzziduancfgViewService.gethntbhzisShow(hunnintuView.getShebeibianhao());
			req.setAttribute("fieldtest", hbfield);
			req.setAttribute("isshowtest", hbisshow);
			req.setAttribute("hnt", hunnintuView);
		}
		return new ModelAndView("com/shtoone/qms/bhz/hunnituViewxixx");
	}
	
	
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}


	/**
	 * 拌合站时间查询列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(HunnintuView hunnintuView, HttpServletRequest req) {
		String id=req.getParameter("id"); 
		if (StringUtil.isNotEmpty(id)) {
			hunnintuView = hunnintuViewService.getEntity(HunnintuView.class, hunnintuView.getId());
			HntbhzziduancfgViewEntity hbfield = hntbhzziduancfgViewService.gethntcfgfield(hunnintuView.getShebeibianhao());
			HntbhzziduancfgViewEntity hbisshow = hntbhzziduancfgViewService.gethntbhzisShow(hunnintuView.getShebeibianhao());
			req.setAttribute("fieldtest", hbfield);
			req.setAttribute("isshowtest", hbisshow);
			req.setAttribute("hunnintuViewPage", hunnintuView);
		}
		return new ModelAndView("com/shtoone/qms/bhz/hntwuchaViewxinxi");
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
