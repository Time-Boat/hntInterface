package com.shtoone.qms.controller.bhz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shtoone.qms.entity.bhz.HntbhzziduancfgEntity;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.entity.bhz.HunnintuView;
import com.shtoone.qms.entity.bhz.WuchaIsShowData;
import com.shtoone.qms.service.bhz.HntbhzziduancfgServiceI;
import com.shtoone.qms.service.bhz.HntbhzziduancfgViewServiceI;
import com.shtoone.qms.service.bhz.HntwuchaAnalyseServiceI;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/hntwuchaAnalyseController")
public class HntwuchaAnalyseController extends BaseController{
	@Autowired
	private SystemService systemService;
	@Autowired
	private HntwuchaAnalyseServiceI hntwuchaAnalyseService;
	@Autowired
	private HntbhzziduancfgViewServiceI hntbhzziduancfgViewService;
	@Autowired
	private HntbhzziduancfgServiceI hntbhzziduancfgService;
	
	private String message;
	private String startTime;
	private String endTime;
	private String gongchengmingcheng;
	private String jiaozuobuwei;
	private String shebeibianhao;   //拌和机编号
	private String tspdepartId;     //组织机构的Id
	private Integer userlft = 0;  //组织机构的所在Id起始
	private Integer userrgt =0;   //组织机构的所在Id终结
	private Integer[] wuchaselect;
	private List<WuchaIsShowData> wuchalist;
	private HntbhzziduancfgViewEntity hntziduancfgField;
	private HntbhzziduancfgViewEntity hntziduancfgIsshow;
	
	public String getTspdepartId() {
		return tspdepartId;
	}

	public void setTspdepartId(String tspdepartId) {
		this.tspdepartId = tspdepartId;
	}

	public Integer[] getWuchaselect() {
		return wuchaselect;
	}

	public void setWuchaselect(Integer[] wuchaselect) {
		this.wuchaselect = wuchaselect;
	}

	public HntbhzziduancfgViewEntity getHntziduancfgField() {
		return hntziduancfgField;
	}

	public void setHntziduancfgField(HntbhzziduancfgViewEntity hntziduancfgField) {
		this.hntziduancfgField = hntziduancfgField;
	}

	public HntbhzziduancfgViewEntity getHntziduancfgIsshow() {
		return hntziduancfgIsshow;
	}

	public void setHntziduancfgIsshow(HntbhzziduancfgViewEntity hntziduancfgIsshow) {
		this.hntziduancfgIsshow = hntziduancfgIsshow;
	}

	public List<WuchaIsShowData> getWuchalist() {
		return wuchalist;
	}

	public void setWuchalist(List<WuchaIsShowData> wuchalist) {
		this.wuchalist = wuchalist;
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

	public String getShebeibianhao() {
		return shebeibianhao;
	}

	public void setShebeibianhao(String shebeibianhao) {
		this.shebeibianhao = shebeibianhao;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * hntwuchaAnalyseController.do?hntwuchaAnalyse&isIframe
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "hntwuchaAnalyse")
	public ModelAndView hntwuchaAnalyse(HttpServletRequest request) {
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
		//这里加载出所有的材料名称
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
		
		return new ModelAndView("com/shtoone/qms/bhz/hntwuchaAnalyse");
	}
	
	@RequestMapping(params = "datagridGetwucha")
	public void datagridGetwucha(HunnintuView hntView,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid){
		HttpSession session = request.getSession();
		if(StringUtil.isNotEmpty(request.getParameter("startTime"))){
			setStartTime(request.getParameter("startTime"));
		}
		System.out.println(startTime+"-------------------------------------------");
		if(StringUtil.isNotEmpty(request.getParameter("endTimewc"))){
			setEndTime(request.getParameter("endTimewc"));
		}
		System.out.println(endTime+"------------------------------------------------");
		if(StringUtil.isNotEmpty(request.getParameter("gongchengmingcheng"))){
			setGongchengmingcheng(request.getParameter("gongchengmingcheng"));
		}
		if(StringUtil.isNotEmpty(request.getParameter("jiaozuobuwei"))){
			setJiaozuobuwei(request.getParameter("jiaozuobuwei"));
		}
		if(StringUtil.isNotEmpty(request.getParameter("shebeibianhao"))){
			setShebeibianhao(request.getParameter("shebeibianhao"));
		}
		if(StringUtil.isNotEmpty(request.getParameter("tspdepartId"))){
			setTspdepartId(request.getParameter("tspdepartId"));
		}
		TSDepart tsDepart=null;
		userlft = Integer.parseInt(session.getAttribute("userlft").toString());
		userrgt = Integer.parseInt(session.getAttribute("userrgt").toString());
		if(StringUtil.isNotEmpty(tspdepartId)){
			tsDepart=systemService.getEntity(TSDepart.class, tspdepartId);
			userlft=tsDepart.getLft();
			userrgt=tsDepart.getRgt();
		}else{
//			HttpSession session = request.getSession();
			setUserlft(Integer.parseInt( session.getAttribute("userlft").toString()));
			setUserrgt(Integer.parseInt(session.getAttribute("userrgt").toString()));
		}
		if (null == startTime && null == endTime) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar day = Calendar.getInstance();
			setEndTime(sdf.format(day.getTime()));
			day.add(Calendar.MONTH, -2);
			setStartTime(sdf.format(day.getTime()));
		}
		
		//这里加载出所有的材料名称
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
		
		//绘制图表
		JSONObject jObject=hntwuchaAnalyseService.HntwuchaAnalyseDataGrid(hntView, dataGrid, startTime, endTime, gongchengmingcheng,
																		  jiaozuobuwei, userlft, userrgt);
		String strxml="";
		String strwuchaxml="";
		if (jObject!=null) {
			strxml=hntwuchaAnalyseService.HntUserImage(jObject, hntziduancfgField, hntziduancfgIsshow);
			strwuchaxml=hntwuchaAnalyseService.HntWuchaImage(jObject, hntziduancfgField, hntziduancfgIsshow);
		}
		jObject.put("hntUserXML",strxml);
		jObject.put("hntWuchaXML",strwuchaxml);
		//强JOSONObject组合成Datagrid
		jObject.put("wuchalist", wuchalist);
		jObject.put("wuchaselect", wuchaselect);
		responseDatagrid(response, jObject);
	}
	
	
}
