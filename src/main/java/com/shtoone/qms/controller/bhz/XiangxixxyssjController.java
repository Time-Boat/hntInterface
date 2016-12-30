package com.shtoone.qms.controller.bhz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.entity.bhz.XiangxixxyssjEntity;
import com.shtoone.qms.service.bhz.HntbhzziduancfgViewServiceI;
import com.shtoone.qms.service.bhz.XiangxixxyssjServiceI;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/xiangxixxyssjController")
public class XiangxixxyssjController extends BaseController{
	
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private XiangxixxyssjServiceI xiangxixxyssjService;
	
	@Autowired
	private HntbhzziduancfgViewServiceI  hntbhzziduancfgViewService; 
	
	@RequestMapping(params = "xiangxixxyssj")
	public ModelAndView xiangxixxyssj(HttpServletRequest request) {
		//得到总页数
		
		return new ModelAndView("com/shtoone/qms/bhz/xiangxixxyssj");
	}
	
	@RequestMapping(params = "datagrid")
	@ResponseBody
	public void datagrid(HttpServletRequest request,HttpServletResponse response){
		String startTime=null;
		String endTime=null;
		String shebeibianhao=null;
		String pid=null;
		String gongchengmingchen=null;
		String userlft=null;
		String userrgt=null;
		Integer pageNo=null;
		Integer maxPageItems=null;
		if(StringUtil.isNotEmpty(request.getParameter("pid"))){
			pid=request.getParameter("pid");
		}
		if(StringUtil.isNotEmpty(request.getParameter("shebeibianhao"))){
			shebeibianhao=request.getParameter("shebeibianhao");
		}
		if(StringUtil.isNotEmpty(request.getParameter("startTime"))){
			startTime=request.getParameter("startTime");
		}
		if(StringUtil.isNotEmpty(request.getParameter("endTime"))){
			endTime=request.getParameter("endTime");
		}
		if(StringUtil.isNotEmpty(request.getParameter("gongchengmingchen"))){
			gongchengmingchen=request.getParameter("gongchengmingchen");
		}
		//进行初始化页面参数
		if(StringUtil.isNotEmpty(request.getParameter("pageNo"))){
			pageNo=Integer.parseInt(request.getParameter("pageNo"));
		}else{
			pageNo=1;
		}
		if(StringUtil.isNotEmpty(request.getParameter("maxPageItems"))){
			maxPageItems=Integer.parseInt(request.getParameter("maxPageItems"));
		}else{
			maxPageItems=20;
		}
		//得到
		if(StringUtil.isNotEmpty(pid)){
			TSDepart dpt=systemService.getEntity(TSDepart.class, pid);
			userlft=dpt.getLft().toString();
			userrgt=dpt.getRgt().toString();
		}else{
			HttpSession session = request.getSession();
			userlft=session.getAttribute("userlft").toString();
			userrgt=session.getAttribute("userrgt").toString();
		}
		if (StringUtil.isEmpty(startTime) && StringUtil.isEmpty(endTime)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar day = Calendar.getInstance();
			endTime=sdf.format(day.getTime());
			day.add(Calendar.MONTH, -1);
			startTime=sdf.format(day.getTime());
		}
		JSONObject jObj=xiangxixxyssjService.getJdGrid(pageNo,maxPageItems, startTime, endTime, shebeibianhao,userlft,userrgt,gongchengmingchen);
		responseStr(response,jObj.toString());
	}
	
	@RequestMapping(params = "SubGrid")
	@ResponseBody
	public void SubGrid(HttpServletRequest request,HttpServletResponse response){
		String rowId=null;
		String jsondata="";
		if(StringUtil.isNotEmpty(request.getParameter("rowId"))){
			rowId=request.getParameter("rowId");
		}
		if(StringUtil.isNotEmpty(rowId)){
			XiangxixxyssjEntity xiangxixx=systemService.findUniqueByProperty(XiangxixxyssjEntity.class,"xxid",Integer.parseInt(rowId));
			if(xiangxixx!=null){
				//组合json格式
				jsondata="{"+
				  "    \"page\":\"1\"," +
		          "    \"total\":1," +
		          "    \"records\":\"1\"," +
		          "    \"rows\":[" +
		          "      {" +
		          "        \"id\":\""+rowId+"\"," +
		          "        \"cell\":["+
		          "    \""+xiangxixx.getId()+"\",\""+StringUtil.isEmpty(xiangxixx.getTlwcsj(),"")+"\",\""+StringUtil.isEmpty(xiangxixx.getXhkssj(),"")+"\",\""+StringUtil.isEmpty(xiangxixx.getJieshoushijian(),"")+"\",\""+StringUtil.isEmpty(xiangxixx.getJbsj(),"")+"\"," +
		          "    \""+StringUtil.isEmpty(xiangxixx.getSha1weight(),"")+"\",\""+StringUtil.isEmpty(xiangxixx.getShi1weight(),"")+"\",\""+StringUtil.isEmpty(xiangxixx.getSha2weight(),"")+"\",\""+StringUtil.isEmpty(xiangxixx.getShi2weight(),"")+"\"," +
		          "		\""+StringUtil.isEmpty(xiangxixx.getGuliao5weight(),"")+"\",\""+StringUtil.isEmpty(xiangxixx.getShuini1weight(),"")+"\",\""+StringUtil.isEmpty(xiangxixx.getShuini2weight(),"")+"\",\""+StringUtil.isEmpty(xiangxixx.getKuangfen3weight(),"")+"\","+
		          "		\""+StringUtil.isEmpty(xiangxixx.getFeimeihui4weight(),"")+"\",\""+StringUtil.isEmpty(xiangxixx.getFenliao5weight(),"")+"\",\""+StringUtil.isEmpty(xiangxixx.getFenliao6weight(),"")+"\",\""+StringUtil.isEmpty(xiangxixx.getShui1weight(),"")+"\","+
		          "		\""+StringUtil.isEmpty(xiangxixx.getShui2weight(),"")+"\",\""+StringUtil.isEmpty(xiangxixx.getWaijiaji1weight(),"")+"\",\""+StringUtil.isEmpty(xiangxixx.getWaijiaji2weight(),"")+"\",\""+StringUtil.isEmpty(xiangxixx.getWaijiaji3weight(),"")+"\","+
		          "		\""+StringUtil.isEmpty(xiangxixx.getWaijiaji4weight(),"")+"\""+
		          "      ]}" +
		          "    ]" +
		          "  }";
			}
		}
		responseStr(response,jsondata);
	}
	
	//廖工自定义方法用于动态获取数据的表头
	@RequestMapping(params = "getTableHeader")
	@ResponseBody
	public void getTableHeader(HttpServletRequest request,HttpServletResponse response){
		String shebeibianhao=null;
		if(StringUtil.isNotEmpty(request.getParameter("shebeibianhao"))){
			shebeibianhao=request.getParameter("shebeibianhao");
		}
		HntbhzziduancfgViewEntity hbfield = hntbhzziduancfgViewService.gethntcfgfield(shebeibianhao);
		HntbhzziduancfgViewEntity hntbhzisShow = hntbhzziduancfgViewService.gethntbhzisShow(shebeibianhao);
		JSONObject json=new JSONObject();
		json.put("hbfield", hbfield);
		json.put("hntbhzisShow", hntbhzisShow);
		responseDatagrid(response, json);
	}
	
	//异步得到字表的表头
	@RequestMapping(params = "getOneTableHeader")
	@ResponseBody
	public void getOneTableHeader(HttpServletRequest request,HttpServletResponse response){
		String rowId=null;
		JSONObject json=new JSONObject();
		if(StringUtil.isNotEmpty(request.getParameter("rowId"))){
			rowId=request.getParameter("rowId");
		}
		if(StringUtil.isNotEmpty(rowId)){
			List<XiangxixxyssjEntity> xiangxixxList=systemService.findByQueryString("from XiangxixxyssjEntity where xxid="+Integer.parseInt(rowId)); 
			if(xiangxixxList.size()>0){
				json.put("xiangxixx", xiangxixxList.get(0));
			}
		}
		responseDatagrid(response, json);
	}
	
}
