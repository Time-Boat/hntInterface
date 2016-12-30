package com.shtoone.qms.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.shtoone.qms.entity.intf.ChartVO;
import com.shtoone.qms.entity.intf.CollectionVO;
import com.shtoone.qms.entity.intf.ExcessDataVO;
import com.shtoone.qms.entity.intf.ExcessDealWithVO;
import com.shtoone.qms.entity.intf.Infreceive;
import com.shtoone.qms.entity.intf.RateVO;
import com.shtoone.qms.entity.intf.SampleVO;
import com.shtoone.qms.entity.intf.StorageVO;
import com.shtoone.qms.entity.intf.TheoreticalMixRateVO;
import com.shtoone.qms.entity.bhz.BanhezhanxinxiEntity;
import com.shtoone.qms.entity.bhz.DepartMappingEntity;
import com.shtoone.qms.entity.bhz.HntviewEntity;
import com.shtoone.qms.entity.bhz.HunnintujieguoViewEntity;
import com.shtoone.qms.entity.bhz.JJGROUPEntity;
import com.shtoone.qms.entity.bhz.Lilunpeibixixx;
import com.shtoone.qms.entity.bhz.SYclAllEntity;
import com.shtoone.qms.entity.bhz.Shigongpeibixixx;
import com.shtoone.qms.entity.bhz.V_SYJZBNEntity;
import com.shtoone.qms.entity.bhz.V_ShiyanshiInfoEntity;
import com.shtoone.qms.entity.bhz.V_YalijiNEntity;
import com.shtoone.qms.entity.bhz.XiangxixxjieguoEntity;
import com.shtoone.qms.service.InfService;
import com.shtoone.qms.service.bhz.JJGROUPServiceI;
import com.shtoone.qms.util.StringUtil;

/**
 * 数据接口处理类
 * 
 * @author 
 * 
 */
@Controller
public class InterfaceController{
	
	@Autowired
	private InfService infService;
	
	@Autowired
	private JJGROUPServiceI jjgropuService;
	
	@RequestMapping ("/bhzfasong")
	@ResponseBody
	public String bhzfasong(HttpServletRequest request,HttpServletResponse response){
		//sendxx(request,response);
		//sendjieguo(request,response);
		//sendchuzhi(request,response);
		try {
	    	String res="";
			res=sendPost("http://hseq.ccccltd.cn:8089/SafetyMonitor/dataexchange/is-online.do","username=tongwang001&password=tongwAngtw123456");
			
			if (res.contains("true"))
			{
				sendycl(request,response);
				sendxx(request,response);
				sendjieguo(request,response);
				sendchuzhi(request,response);
				sendllphb(request,response);
				sendsjphb(request,response);
//				sendsys(request,response);
//				sendsysgc(request,response);
				
			} else {
				System.out.println("接收端数据库连接问题");	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("服务器不在线");
		}
		
		return null;
		
	}
	
	
	//详细数据发送中国交建
	
	@RequestMapping ("/sendxx")
	@ResponseBody
	public String sendxx(HttpServletRequest request,HttpServletResponse response){
		
		HntviewEntity xxclass=infService.findonexx();
		if (null!=xxclass)
		{
			CollectionVO vo=new CollectionVO();
		    vo.setTask_id(xxclass.getGongdanhao());
		    vo.setMix_duration(StringUtil.StrToZero(xxclass.getJiaobanshijian()));
		    vo.setOper(xxclass.getChaozuozhe());
		    vo.setActual_amount(StringUtil.StrToZero(xxclass.getGujifangshu()));
	    	vo.setDeesign_amount(StringUtil.StrToZero(xxclass.getWaijiajipingzhong()));
	    	vo.setBone_flour1(StringUtil.StrToZero(xxclass.getSha1_shijizhi()));
		    vo.setBone_flour2(StringUtil.StrToZero(xxclass.getSha2_shijizhi()));
	    	vo.setSkeleton_soil1(StringUtil.StrToZero(xxclass.getShi1_shijizhi()));
	    	vo.setSkeleton_soil2(StringUtil.StrToZero(xxclass.getShi2_shijizhi()));
		    vo.setSkeleton_soil3(StringUtil.StrToZero(xxclass.getGuliao5_shijizhi()));
		    vo.setCement1(StringUtil.StrToZero(xxclass.getShuini1_shijizhi()));
		    vo.setCement2(StringUtil.StrToZero(xxclass.getShuini2_shijizhi()));
		    vo.setPowder_ore(StringUtil.StrToZero(xxclass.getKuangfen3_shijizhi()));
		    vo.setFlyash(StringUtil.StrToZero(xxclass.getFeimeihui4_shijizhi()));
		    vo.setPowder_lot5(StringUtil.StrToZero(xxclass.getFenliao5_shijizhi()));
		    vo.setPowder_lot6(StringUtil.StrToZero(xxclass.getFenliao6_shijizhi()));
		    vo.setWater1(StringUtil.StrToZero(xxclass.getShui1_shijizhi()));
		    vo.setWater2(StringUtil.StrToZero(xxclass.getShui2_shijizhi()));
		    vo.setAddition1(StringUtil.StrToZero(xxclass.getWaijiaji1_shijizhi()));
		    vo.setAddition2(StringUtil.StrToZero(xxclass.getWaijiaji2_shijizhi()));
		    vo.setAddition3(StringUtil.StrToZero(xxclass.getWaijiaji3_shijizhi()));
		    vo.setAddition4(StringUtil.StrToZero(xxclass.getWaijiaji4_shijizhi()));
		    vo.setProduce_time(xxclass.getChuliaoshijian());
	    	vo.setBone_flour1_rate(StringUtil.StrToZero(xxclass.getSha1_lilunzhi()));
		    vo.setBone_flour2_rate(StringUtil.StrToZero(xxclass.getSha2_lilunzhi()));
	    	vo.setSkeleton_soil1_rate(StringUtil.StrToZero(xxclass.getShi1_lilunzhi()));
	    	vo.setSkeleton_soil2_rate(StringUtil.StrToZero(xxclass.getShi2_lilunzhi()));
		    vo.setSkeleton_soil3_rate(StringUtil.StrToZero(xxclass.getGuliao5_lilunzhi()));
		    vo.setCement1_rate(StringUtil.StrToZero(xxclass.getShuini1_lilunzhi()));
		    vo.setCement2_rate(StringUtil.StrToZero(xxclass.getShuini2_lilunzhi()));
		    vo.setPowder_ore_rate(StringUtil.StrToZero(xxclass.getKuangfen3_lilunzhi()));
		    vo.setFlyash_rate(StringUtil.StrToZero(xxclass.getFeimeihui4_lilunzhi()));
		    vo.setPowder_lot5_rate(StringUtil.StrToZero(xxclass.getFenliao5_lilunzhi()));
		    vo.setPowder_lot6_rate(StringUtil.StrToZero(xxclass.getFenliao6_lilunzhi()));
		    vo.setWater1_rate(StringUtil.StrToZero(xxclass.getShui1_lilunzhi()));
		    vo.setWater2_rate(StringUtil.StrToZero(xxclass.getShui2_lilunzhi()));
		    vo.setAddition1_rate(StringUtil.StrToZero(xxclass.getWaijiaji1_lilunzhi()));
		    vo.setAddition2_rate(StringUtil.StrToZero(xxclass.getWaijiaji2_lilunzhi()));
		    vo.setAddition3_rate(StringUtil.StrToZero(xxclass.getWaijiaji3_lilunzhi()));
		    vo.setAddition4_rate(StringUtil.StrToZero(xxclass.getWaijiaji4_lilunzhi()));
		    vo.setMix_machine_no(xxclass.getShebeibianhao());
		    vo.setProj_name(xxclass.getGongchengmingcheng());
		    vo.setWork_place(xxclass.getSigongdidian());
		    vo.setBuild_part(xxclass.getJiaozuobuwei());
		    vo.setCement_type(xxclass.getShuinipingzhong());
		    vo.setWork_mixing_rate_no(xxclass.getPeifanghao());
		    vo.setIntensity_class(xxclass.getQiangdudengji());
		    vo.setCollect_time(xxclass.getBaocunshijian());
		    vo.setSensor_uuid(xxclass.getShebeibianhao()+"-"+xxclass.getId());
		    vo.setData_source_vendors("shtoone");
		    String jsonString=JSON.toJSONString(vo);
		    System.out.println(jsonString);
		    try {
		    	String res="";
				res=sendPost("http://hseq.ccccltd.cn:8089/SafetyMonitor/dataexchange/data-collection.do","username=tongwang001&password=tongwAngtw123456&json="+URLEncoder.encode(jsonString, "utf-8"));
				
				if (res.contains("true"))
				{
					infService.updxxbyid(xxclass.getId(),"8");
					System.out.println("详细数据信息返回的消息是:"+res);	
				} else {
					infService.updxxbyid(xxclass.getId(),"5");
					System.out.println("详细数据信息返回的消息是:"+res);	
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				infService.updxxbyid(xxclass.getId(),"6");
				System.out.println("返回的消息是:发送详细信息异常");
			}
			
		}

		return null;
		
	}
	
	//发送超标数据
	
	@RequestMapping ("/sendjieguo")
	@ResponseBody
	public String sendjieguo(HttpServletRequest request,HttpServletResponse response){
		
		HunnintujieguoViewEntity xxclass=infService.findjieguo();
		if (null!=xxclass)
		{
			ExcessDataVO  vo=new ExcessDataVO();
			vo.setBone_flour1(xxclass.getSha1_shijizhi());
			vo.setBone_flour2(xxclass.getSha2_shijizhi());
			vo.setSkeleton_soil1(xxclass.getShi1_shijizhi());
			vo.setSkeleton_soil2(xxclass.getShi2_shijizhi());
			vo.setSkeleton_soil3(xxclass.getGuliao5_shijizhi());
			vo.setCement1(xxclass.getShuini1_shijizhi());
			vo.setCement2(xxclass.getShuini2_shijizhi());
			vo.setPowder_ore(xxclass.getKuangfen3_shijizhi());
			vo.setFlyash(xxclass.getFeimeihui4_shijizhi());
			vo.setPowder_lot5(xxclass.getFenliao5_shijizhi());
			vo.setPowder_lot6(xxclass.getFenliao6_shijizhi());
			vo.setWater1(xxclass.getShui1_shijizhi());
			vo.setWater2(xxclass.getShui2_shijizhi());
			vo.setAddition1(xxclass.getWaijiaji1_shijizhi());
			vo.setAddition2(xxclass.getWaijiaji2_shijizhi());
			vo.setAddition3(xxclass.getWaijiaji3_shijizhi());
			vo.setAddition4(xxclass.getWaijiaji4_shijizhi());
			vo.setMix_station_no(xxclass.getShebeibianhao());
		    vo.setProj_name(xxclass.getGongchengmingcheng());
		    vo.setWork_place(xxclass.getSigongdidian());
		    vo.setBuild_part(xxclass.getJiaozuobuwei());
		    vo.setWork_mixing_rate_no(xxclass.getPeifanghao());
		    vo.setIntensity_class(xxclass.getQiangdudengji());
		    vo.setCollect_time(xxclass.getBaocunshijian());
		    vo.setSensor_uuid(xxclass.getShebeibianhao()+"-"+xxclass.getId());
		    vo.setProduce_time(xxclass.getChuliaoshijian());
		    if (null != xxclass.getLeixing())
		    {
		    vo.setExcess_type(xxclass.getLeixing().toString());
		    } else vo.setExcess_type("");
		    vo.setExcess_uuid(xxclass.getShebeibianhao()+"-"+xxclass.getXinxibianhao());
		    String jsonString=JSON.toJSONString(vo);
		    System.out.println(jsonString);
		    try {
		    	String res="";
		    	res=sendPost("http://hseq.ccccltd.cn:8089/SafetyMonitor/dataexchange/excess-data.do","username=tongwang001&password=tongwAngtw123456&json="+URLEncoder.encode(jsonString, "utf-8"));//超标接口
				
				if (res.contains("true"))
				{
					infService.updjieguobyid(xxclass.getId(),"8");
					System.out.println("发送超标信息返回的消息是:"+res);	
				} else {
					infService.updjieguobyid(xxclass.getId(),"5");
					System.out.println("发送超标信息返回的消息是:"+res);	
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				infService.updjieguobyid(xxclass.getId(),"6");
				System.out.println("返回的消息是:发送超标信息异常");
			}
			
		}

		return null;
		
	}
	
	//发送处置数据
	
	@RequestMapping ("/sendchuzhi")
	@ResponseBody
	public String sendchuzhi(HttpServletRequest request,HttpServletResponse response){
		
		HunnintujieguoViewEntity xxclass=infService.findchuzhi();
		if (null!=xxclass)
		{
			ExcessDealWithVO  vo=new ExcessDealWithVO();
			vo.setSensor_uuid(xxclass.getShebeibianhao()+"-"+xxclass.getId());
			//vo.setDealman(xxclass.getch);
			vo.setDeal_result(xxclass.getChulijieguo());
			XiangxixxjieguoEntity jgclass=infService.findchuzhibyid(xxclass.getId());
			if (null!=jgclass)
			{
			vo.setManager_approve(jgclass.getJianlishenpi());
			vo.setApprove_time(jgclass.getShenpidate());
			vo.setApprove_result(jgclass.getJianliresult());
			vo.setConfirm_time(jgclass.getConfirmdate());
			vo.setDeal_method(jgclass.getChulifangshi());
			vo.setProblem_reason(jgclass.getWentiyuanyin());
			}
			if ("".equalsIgnoreCase(StringUtil.Null2Blank(xxclass.getFilepath())))
			{
			vo.setWith_attachment("0");
			} else vo.setWith_attachment("1");
			vo.setData_source_vendor("shtoone");
		    String jsonString=JSON.toJSONString(vo);
		    System.out.println(jsonString);
		    try {
		    	String res="";
		    	res=sendPost("http://hseq.ccccltd.cn:8089/SafetyMonitor/dataexchange/excess-deal-with.do","username=tongwang001&password=tongwAngtw123456&json="+URLEncoder.encode(jsonString, "utf-8"));//超标接口
				
				if (res.contains("true"))
				{
					infService.updchuzhibyid(xxclass.getId(),8);
					System.out.println("发送超标处置信息返回的消息是:"+res);	
				} else {
					infService.updchuzhibyid(xxclass.getId(),5);
					System.out.println("发送超标处置信息返回的消息是:"+res);	
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				infService.updchuzhibyid(xxclass.getId(),6);
				System.out.println("返回的消息是:发送超标处置信息异常");
			}
			
		}

		return null;
		
	}
	
	
	//理论配合比
	
	@RequestMapping ("/sendllphb")
	@ResponseBody
	public String sendllphb(HttpServletRequest request,HttpServletResponse response){
		
		Lilunpeibixixx xxclass=infService.findllphb();
		if (null!=xxclass)
		{
			TheoreticalMixRateVO vo=new TheoreticalMixRateVO();
			vo.setUuid(xxclass.getId());
			vo.setMix_rate_no(xxclass.getPhbreportId());
			if (xxclass.getReportDate() !=null)
			{
			vo.setReport_date(xxclass.getReportDate().toString());
			}
			vo.setBuilding_part(xxclass.getGongchengbuwei());
			vo.setIntensity_class(xxclass.getQiangdudengji());
			if (xxclass.getShalvLlphb() !=null)
			{
			vo.setCement(xxclass.getShalvLlphb().doubleValue());
			}
			if (xxclass.getFenmeihuiLlphb() !=null)
			{
			vo.setFlyash(xxclass.getFenmeihuiLlphb().doubleValue());
			}
			if (xxclass.getKuangfenLlphb() !=null)
			{
			vo.setPowder_lot(xxclass.getKuangfenLlphb().doubleValue());
			}
			if (xxclass.getCuguliaoLlphb() !=null)
			{
			vo.setSkeleton_soil(xxclass.getCuguliaoLlphb().doubleValue());
			}
			if (xxclass.getXiguliaoLlphb() !=null)
			{
			vo.setBone_flour(xxclass.getXiguliaoLlphb().doubleValue());
			}
			if (xxclass.getBanheshuiLlphb() !=null)
			{
			vo.setWater(xxclass.getBanheshuiLlphb().doubleValue());
			}
			if (xxclass.getWaijiajiLlphb() !=null)
			{
			vo.setAddition(xxclass.getWaijiajiLlphb().doubleValue());
			}
			if (xxclass.getShuijiaobiLlphb() !=null)
			{
			vo.setWater_binder_rate(xxclass.getShuijiaobiLlphb().doubleValue());
			}
			if (xxclass.getJiaocaiLlphb() !=null)
			{
			vo.setBinder(xxclass.getJiaocaiLlphb().doubleValue());
			}
			if (xxclass.getShalvLlphb() !=null)
			{
			vo.setSand(xxclass.getShalvLlphb().doubleValue());
			}
			if (xxclass.getKangyaqiangdu7d() !=null)
			{
			vo.setT7d_intensity_class(xxclass.getKangyaqiangdu7d().doubleValue());
			}
			if (xxclass.getKangyaqiangdu28d() !=null)
			{
			vo.setT28d_intensity_class(xxclass.getKangyaqiangdu28d().doubleValue());
			}
			if (xxclass.getKangyaqiangdu56d() !=null)
			{
			vo.setT56d_intensity_class(xxclass.getKangyaqiangdu56d().doubleValue());
			}
			if (xxclass.getDiantongliang() !=null)
			{
			vo.setElectricity_property(xxclass.getDiantongliang().doubleValue());
			}
			if (xxclass.getKangdongxing() !=null)
			{
			vo.setFrost_resistance(xxclass.getKangdongxing().doubleValue());
			}
			if (xxclass.getLvkuosanxishu() !=null)
			{
			vo.setCdc(xxclass.getLvkuosanxishu().doubleValue());
			}
			vo.setResult(xxclass.getTestResult());
			vo.setTestor(xxclass.getTester());
			V_ShiyanshiInfoEntity jgclass=infService.findShiyanshiInfobyid(xxclass.getUserGroup());
			if (null!=jgclass)
			{
				
				String trcode=jgclass.getFtrcode();
				vo.setLab_id(trcode);
			}
			vo.setData_source_vendors("shtoone");
		    String jsonString=JSON.toJSONString(vo);
		    try {
		    	String res="";
		    	res=sendPost("http://hseq.ccccltd.cn:8089/SafetyMonitor/dataexchange/theoretical-mix-rate.do","username=tongwang001&password=tongwAngtw123456&json="+URLEncoder.encode(jsonString, "utf-8"));//超标接口
				
				if (res.contains("true")) 
				{
					infService.updllphbbyid(xxclass.getId(),8);
					System.out.println("发送理论配合比信息返回的消息是:"+res);	
				} else {
					infService.updllphbbyid(xxclass.getId(),5);
					System.out.println("发送理论配合比信息返回的消息是:"+res);	
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				infService.updllphbbyid(xxclass.getId(),6);
				System.out.println("返回的消息是:发送理论配合比信息异常");
			}
			
		}

		return null;
		
	}
	
	
	
	//实际配合比
	
		@RequestMapping ("/sendsjphb")
		@ResponseBody
		public String sendsjphb(HttpServletRequest request,HttpServletResponse response){
			
			Shigongpeibixixx xxclass=infService.findsjphb();
			if (null!=xxclass)
			{
				RateVO  vo=new RateVO();
				vo.setWork_mix_id(xxclass.getProductWorkNo());
				//vo.setTask_no("rw00001");
				if (xxclass.getChuliaoshijian() !=null)
				{
				vo.setProduce_time(xxclass.getChuliaoshijian().toString());
				}
				if (xxclass.getChuliaofangliang() !=null)
				{
				vo.setProduce_amount(xxclass.getChuliaofangliang().doubleValue());
				}
				if (xxclass.getXigl1ph() !=null)
				{
				vo.setBone_flour1_rate(xxclass.getXigl1ph().doubleValue());
				}
				if (xxclass.getXigl1ph() !=null)
				{
				vo.setBone_flour2_rate(xxclass.getXigl1ph().doubleValue());
				}
				if (xxclass.getChugl1ph() !=null)
				{
				vo.setSkeleton_soil1_rate(xxclass.getChugl1ph().doubleValue());
				}
				if (xxclass.getChugl2ph() !=null)
				{
				vo.setSkeleton_soil2_rate(xxclass.getChugl2ph().doubleValue());
				}
				if (xxclass.getChugl3ph() !=null)
				{
				vo.setSkeleton_soil3_rate(xxclass.getChugl3ph().doubleValue());
				}
				if (xxclass.getShuini1ph() !=null)
				{
				vo.setCement1_rate(xxclass.getShuini1ph().doubleValue());
				}
				if (xxclass.getKuangfenph() !=null)
				{
				vo.setPowder_lot_rate(xxclass.getKuangfenph().doubleValue());
				}
				if (xxclass.getFenmeihuiph() !=null)
				{
				vo.setFlyash_rate(xxclass.getFenmeihuiph().doubleValue());
				}
				if (xxclass.getShui1ph() !=null)
				{
				vo.setWater1_rate(xxclass.getShui1ph().doubleValue());
				}
				if (xxclass.getWaijijia1ph() !=null)
				{
				vo.setAddition1_rate(xxclass.getWaijijia1ph().doubleValue());
				}
				if (xxclass.getWaijijia2ph() !=null)
				{
				vo.setAddition2_rate(xxclass.getWaijijia2ph().doubleValue());
				}
				if (xxclass.getWaijijia3ph() !=null)
				{
				vo.setAddition3_rate(xxclass.getWaijijia3ph().doubleValue());
				}
				if (xxclass.getWaijijia4ph() !=null)
				{
				vo.setAddition4_rate(xxclass.getWaijijia4ph().doubleValue());
				}
				if (xxclass.getBaopidata() !=null)
				{
				vo.setApply_date(xxclass.getBaopidata().toString());
				}
				if (xxclass.getPifudata() !=null)
				{
				vo.setApprove_date(xxclass.getPifudata().toString());
				}
				vo.setMemo(xxclass.getRemark());
				vo.setUuid(xxclass.getId());
				if(xxclass.getShebeibianhao()!=null){
					BanhezhanxinxiEntity xxtclass=infService.findbanhezhanxinxi(xxclass.getShebeibianhao());
					vo.setMix_machine_no(xxtclass.getGprsbianhao());
				}
				vo.setTheoretical_mix_rate_no(xxclass.getLilunId());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar day = Calendar.getInstance();
				vo.setUpload_time(sdf.format(day.getTime()));
				/*vo.setData_source_vendors("shtoone");*/
			    String jsonString=JSON.toJSONString(vo);
			    System.out.println("返回的消息是:"+jsonString);
			    try {
			    	String res="";
			    	res=sendPost("http://hseq.ccccltd.cn:8089/SafetyMonitor/dataexchange/working-mix-rate.do","username=tongwang001&password=tongwAngtw123456&json="+URLEncoder.encode(jsonString, "utf-8"));
					
					if (res.contains("true"))
					{
						infService.updsjphbbyid(xxclass.getId(),8);
						System.out.println("发送实际配合比信息返回的消息是:"+res);	
					} else {
						infService.updsjphbbyid(xxclass.getId(),5);
						System.out.println("发送实际配合比信息返回的消息是:"+res);	
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					infService.updsjphbbyid(xxclass.getId(),6);
					System.out.println("返回的消息是:实际配合比信息异常");
				}
				
			}

			return null;
			
		}
		
	
		//原材料进场
		
			@RequestMapping ("/sendycl")
			@ResponseBody
			public String sendycl(HttpServletRequest request,HttpServletResponse response){
				
				SYclAllEntity xxclass=infService.findycl();
				if (null!=xxclass)
				{
					StorageVO  vo=new StorageVO();
					//vo.setresource_name("水泥");
					vo.setBatch_no(xxclass.getPici());
					vo.setUuid(xxclass.getId());
					vo.setResource_type(xxclass.getLeixing());
					
					if (null != xxclass.getQyshijian())
					{
					vo.setResource_in_logtime(xxclass.getRukushijian());
					}
					vo.setProducer(xxclass.getScchangjia());
					vo.setProduce_address(xxclass.getChandi());
					vo.setSpecification(xxclass.getGuige()+xxclass.getXinghao());
					vo.setResource_in_amount(StringUtil.StrToZero( xxclass.getJcshuliang().toString()));
					if (null != xxclass.getQyshijian())
					{
					vo.setResource_in_logtime(xxclass.getQyshijian());
					}
					vo.setTest_result(xxclass.getYcl0());
					vo.setResult1(xxclass.getYcl1());
					vo.setResult2(xxclass.getYcl2());
					vo.setResult3(xxclass.getYcl3());
					vo.setResult4(xxclass.getYcl4());
					vo.setResult5(xxclass.getYcl5());
					vo.setResult6(xxclass.getYcl6());
					vo.setResult7(xxclass.getYcl7());
					vo.setResult8(xxclass.getYcl8());
					vo.setResult9(xxclass.getYcl9());
					vo.setResult10(xxclass.getYcl10());
					vo.setReport_no(xxclass.getBgbianhao());
					
					vo.setTest_time(xxclass.getSyshijian());
					vo.setTestor(xxclass.getShiyanren());
					vo.setProject(xxclass.getSyxingmu());
					vo.setExample_datetime(xxclass.getQyshijian());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Calendar day = Calendar.getInstance();
					vo.setUpload_time(sdf.format(day.getTime()));
					
					
					DepartMappingEntity jgclass=infService.findDepartMapping(xxclass.getBiaoduanid());
					
					
					
					if (null!=jgclass)
					{
						vo.setSection_no(jgclass.getMappingcoding());
					}
					vo.setData_source_vendors("shtoone");
				    String jsonString=JSON.toJSONString(vo);
				    System.out.println("返回的消息是:"+jsonString);
				    try {
				    	String res="";
				    	res=sendPost("http://hseq.ccccltd.cn:8089/SafetyMonitor/dataexchange/resource-storage.do","username=tongwang001&password=tongwAngtw123456&json="+URLEncoder.encode(jsonString, "utf-8"));
						
						if (res.contains("true"))
						{
							infService.updyclbyid(xxclass.getId(),8);
							System.out.println("发送原材料进场信息返回的消息是:"+res);	
						} else {
							infService.updyclbyid(xxclass.getId(),5);
							System.out.println("发送原材料进场信息返回的消息是:"+res);	
						}
						
					} catch (Exception e) {
						// TODO: handle exception
						infService.updyclbyid(xxclass.getId(),6);
						System.out.println("返回的消息是:发送原材料进场信息异常");
					}
					
				}

				return null;
				
			}
			
			
			
			//试验室主表
			
			@RequestMapping ("/sendsys")
			@ResponseBody
			public String sendsys(HttpServletRequest request,HttpServletResponse response){
				
				V_SYJZBNEntity xxclass=infService.findsys();
				if (null!=xxclass)
				{
					SampleVO  vo=new SampleVO();
					vo.setSpecimen_no(xxclass.getSjbh());
					vo.setDevice_no(xxclass.getSbbh());
					vo.setProj_name(xxclass.getWtbh());
					vo.setBuilding_part(xxclass.getCjmc());
					vo.setBuild_date(xxclass.getZzrq());
					vo.setTest_date(xxclass.getSyrq());
					vo.setIntensity_rank(xxclass.getSjqd());
					vo.setSpecimen_size(xxclass.getSjcc()); 
					vo.setSquares(StringUtil.StrToZero(xxclass.getSjmj()));
					vo.setTestor(xxclass.getCzry());
					vo.setAge(xxclass.getLq());
					vo.setWitness_type(xxclass.getArea());
					vo.setMax_compressive_resistance(StringUtil.StrToZero(xxclass.getQddbz()));
					vo.setTest_result(xxclass.getPdjg());
					vo.setResult_uuid(xxclass.getSyjid());
					vo.setWork_mix_rate_no(xxclass.getRtcode());
					vo.setData_source_vendors("shtoone");
					String jsonString=JSON.toJSONString(vo);
				    try {
				    	String res="";
				    	res=sendPost("http://hseq.ccccltd.cn:8089/SafetyMonitor/dataexchange/lab-sample-test-result.do","username=tongwang001&password=tongwAngtw123456&json="+URLEncoder.encode(jsonString, "utf-8"));
				    	
						if (res.contains("true"))
						{
							infService.updsysbyid(xxclass.getSyjid(),8);
							System.out.println("发送试验室主表信息返回的消息是:"+java.net.URLDecoder.decode(res, "utf-8"));	
						} else {
							infService.updsysbyid(xxclass.getSyjid(),5);
							System.out.println("发送试验室主表信息返回的消息是:"+java.net.URLDecoder.decode(res, "utf-8"));	
						}
						
					} catch (Exception e) {
						// TODO: handle exception
						infService.updsysbyid(xxclass.getSyjid(),6);
						System.out.println("返回的消息是:发送试验室主表信息异常");
					}
					
				}

				return null;
				
			}
			
			
             //试验室子表
			
			@RequestMapping ("/sendsysgc")
			@ResponseBody
			public String sendsysgc(HttpServletRequest request,HttpServletResponse response){
				
				V_YalijiNEntity xxclass=infService.findsysgc();
				if (null!=xxclass)
				{
					ChartVO vo=new ChartVO();
					vo.setCompressive_resistance_data(xxclass.getYskylz());
					vo.setTime_data(xxclass.getSjgc());
					vo.setSpecimen_no(xxclass.getSjxh());
					vo.setProcess_uuid(xxclass.getF_GUID());
					vo.setResult_uuid(xxclass.getSyjid());
					vo.setMax_pressure(xxclass.getKylz());
					vo.setPressure_strength(xxclass.getKyqd());
					vo.setSteadier_distance(xxclass.getZzjj());
					vo.setData_source_vendors("shtoone");
					String jsonString=JSON.toJSONString(vo);
				    try {
				    	String res="";
				    	res=sendPost("http://hseq.ccccltd.cn:8089/SafetyMonitor/dataexchange/sample-pressure-chart.do","username=tongwang001&password=tongwAngtw123456&json="+URLEncoder.encode(jsonString, "utf-8"));
						
						if (res.contains("true"))
						{
							infService.updsysgcbyid(xxclass.getF_GUID(),8);
							System.out.println("发送试验室子表信息返回的消息是:"+res);	
						} else {
							infService.updsysgcbyid(xxclass.getF_GUID(),5);
							System.out.println("发送试验室子表信息返回的消息是:"+res);	
						}
						
					} catch (Exception e) {
						// TODO: handle exception
						infService.updsysgcbyid(xxclass.getF_GUID(),6);
						System.out.println("返回的消息是:发送试验室子表信息异常");
					}
					
				}

				return null;
				
			}
			
			
            //获取平台组织机构
			
			@RequestMapping ("/getgroup")
			@ResponseBody
			public String getgroup(HttpServletRequest request,HttpServletResponse response){
				try {
			    	String res="";
			    	res=sendPost("http://hseq.ccccltd.cn:8089/SafetyMonitor/dataexchange/get-organ-tree.do","username=tongwang001&password=tongwAngtw123456");
			    	//res=URLDecoder.decode(res,"GBK");
			    /*	System.out.println(res);
			    	Integer begidx=res.indexOf(":[");
			    	Integer endidx=res.indexOf("],");
			    	res=res.substring(begidx+2,endidx);
			    	res =res.replaceAll("},", "}#*");
			    	String[] str = res.split("#*");*/
			    	
			    	//res ="{\"ecode\":\"ms_dataexchange_oporg\",\"grade\":\"\",\"name\":\"中国交通建设集团有限公司\",\"oid\":\"1\",\"poid\":\"0\",\"status\":\"\",\"type\":\"\",\"typeext\":\"\"}";// res.substring(begidx+2,endidx);
					if (res.contains("true"))
					{
						
					/*	for(int i=0;i<str.length;i++)
						{
							//System.out.println(str[i]);
							JSONObject jsonobject = JSONObject.fromObject(str[i]);
							Infreceive vo = (Infreceive)JSONObject.toBean(jsonobject,Infreceive.class);//将建json对象转换为Person对象  
							System.out.println(vo.getEcode());
							//System.out.println(vo.getName());
						}*/
						//res ="{\"data\":[{\"ecode\":\"ms_dataexchange_oporg\",\"grade\":\"\",\"name\":\"中国交通建设集团有限公司\",\"oid\":\"1\",\"poid\":\"0\",\"status\":\"\",\"type\":\"\",\"typeext\":\"\"}],\"success\":true}";// res.substring(begidx+2,endidx);
					//	System.out.println(res);
						    /*Infreceive vo=new Infreceive();*/
						
						
							JSONObject jsonobject = JSONObject.fromObject(res);
						 //获取一个json数组
						   JSONArray array = jsonobject.getJSONArray("data");
						   if (infService.deletejjgroup()==1 )
						   {
						   //将json数组 转换成 List<PassPortForLendsEntity>泛型
						//   List<Infreceive> list = new ArrayList<Infreceive>();
						   for (int i = 0; i < array.size(); i++) {   
						            JSONObject object = (JSONObject)array.get(i);  
						            Infreceive receivedata = (Infreceive)JSONObject.toBean(object,
						            		Infreceive.class);
						            if(receivedata != null){
						            // list.add(receivedata);
						            	JJGROUPEntity vo = new JJGROUPEntity();
						            	vo.setEcode(receivedata.getEcode());
						            	vo.setGrade(receivedata.getGrade());
						            	vo.setName(receivedata.getName());
						            	vo.setOid(receivedata.getOid());
						            	vo.setPoid(receivedata.getPoid());
						            	vo.setStatus(receivedata.getStatus());
						            	vo.setType(receivedata.getType());
						            	vo.setTypeext(receivedata.getTypeext());
						            	//vo = (Infreceive)JSONObject.toBean(jsonobject, Infreceive.class);
						            	if(vo != null){
						                  jjgropuService.save(vo);
						            	}
						             System.out.println(receivedata.getEcode());
						            }  
						         }
						   }
						   //转换PassportLendsEntity 实体类
						 //  vo = (Infreceive)JSONObject.toBean(jsonobject, Infreceive.class);
						 //  System.out.println(vo.getEcode());
					} else {
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}

				return null;
				
			}
	
	
	
	   /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
      public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
           // conn.setRequestProperty("content-type", "application/x-www-form-urlencoded;charset=UTF-8"); 
           // conn.setRequestProperty("Charset", "UTF-8");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }   
		
	
}
