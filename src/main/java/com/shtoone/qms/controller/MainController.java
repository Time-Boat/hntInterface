package com.shtoone.qms.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.namespace.QName;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import com.alibaba.fastjson.JSONObject;
import com.shtoone.qms.entity.bhz.BanhezhanxinxiEntity;
import com.shtoone.qms.entity.bhz.HandsetEntity;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgEntity;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.entity.bhz.HntviewEntity;
import com.shtoone.qms.entity.bhz.HunnintuView;
import com.shtoone.qms.entity.bhz.SmsrecordEntity;
import com.shtoone.qms.entity.bhz.Systemmanager;
import com.shtoone.qms.entity.bhz.TopRealMaxhunnintuViewEntity;
import com.shtoone.qms.entity.bhz.XiangxixxjieguoEntity;
import com.shtoone.qms.entity.bhz.XiangxixxsmsEntity;
import com.shtoone.qms.service.bhz.BanhezhanxinxiServiceI;
import com.shtoone.qms.service.bhz.HntxiangxixxmaxServiceI;
import com.shtoone.qms.service.bhz.MainService;
import com.shtoone.qms.service.bhz.SmsrecordServiceI;
import com.shtoone.qms.service.bhz.TopRealMaxhunnintuViewServiceI;
import com.shtoone.qms.service.bhz.XiangxixxjieguoServiceI;
import com.shtoone.qms.service.bhz.XiangxixxsmsServiceI;
import com.shtoone.qms.util.StringUtil;
import com.tencent.xinge.ClickAction;
import com.tencent.xinge.Message;
import com.tencent.xinge.Style;
import com.tencent.xinge.TimeInterval;
import com.tencent.xinge.XingeApp;

/**
 * 数据提交处理类
 * 
 * @author
 * 
 */
@Controller
public class MainController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MainController.class);

	@Autowired
	private SmsrecordServiceI smshntService;

	@Autowired
	private BanhezhanxinxiServiceI bhzService;

	@Autowired
	private SystemService systemService;

	@Autowired
	private TopRealMaxhunnintuViewServiceI TopmaxhntService;

	@Autowired
	private HntxiangxixxmaxServiceI xxmaxService;

	@Autowired
	private MainService mainService;

	@Autowired
	private TopRealMaxhunnintuViewServiceI topmaxhnt;

	@Autowired
	private XiangxixxsmsServiceI xxsmsService;

	@Autowired
	private XiangxixxjieguoServiceI xxjgService;

	@Autowired
	private JdbcDao jdbcDao;

	@RequestMapping("/systemmanager")
	public ModelAndView systemmanager(Systemmanager sys,
		HttpServletRequest request, HttpServletResponse response) {
		String filename = request.getSession().getServletContext().getRealPath("/")+ "WEB-INF"+ File.separator+ "classes"+ File.separator+ "system.ini";
		Properties prop = new Properties();
		File fp = new File(filename);
		if (!fp.exists()) {
			try {
				fp.createNewFile();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		if (fp.exists()) {
			try {
				prop.load(new FileInputStream(fp));
				String smstype = null;
				String sendtype = null;
				String ambegin = null;
				String amend = null;
				String pmbegin = null;
				String pmend = null;
				String panshu = null;
				String sendtime = null;
				String frequency = null;
				String onefrequency = null;
				String apitype = null;
				String panduanpanshu = null;
				String meipan = null;
				String huizong = null;
				if (null == sys.getApitype()) {
					if (smstype == null) {
						smstype = prop.getProperty("smstype", "0");
					}
					if (ambegin == null) {
						ambegin = prop.getProperty("ambegin", "09:00");
					}
					if (amend == null) {
						amend = prop.getProperty("amend", "12:00");
					}
					if (pmbegin == null) {
						pmbegin = prop.getProperty("pmbegin", "14:00");
					}
					if (pmend == null) {
						pmend = prop.getProperty("pmend", "17:00");
					}
					if (sendtype == null) {
						sendtype = prop.getProperty("sendtype", "1");
					}
					if (panshu == null) {
						panshu = prop.getProperty("panshu", "100");
					}
					if (frequency == null) {
						frequency = prop.getProperty("frequency", "0");
					}
					if (sendtime == null) {
						sendtime = prop.getProperty("sendtime", "");
					}
					if (onefrequency == null) {
						onefrequency = prop.getProperty("onefrequency", "1");
					}
					if (apitype == null) {
						apitype = prop.getProperty("apitype", "0");
					}
					if (panduanpanshu == null) {
						panduanpanshu = prop.getProperty("panduanpanshu", "1");
					}
					if (meipan == null) {
						meipan = prop.getProperty("meipan",
								"[%s]%s%s:%s实%s配%s%s%s%%超%s%%");
					}
					if (huizong == null) {
						huizong = prop.getProperty("huizong",
								"[%s]%s:已搅拌盘数%s累计超标准次数%s");
					}
					sys.setSmstype(smstype);
					sys.setAmbegin(ambegin);
					sys.setAmend(amend);
					sys.setPmbegin(pmbegin);
					sys.setPmend(pmend);
					sys.setSendtype(sendtype);
					sys.setPanshu(panshu);
					sys.setFrequency(frequency);
					sys.setSendtime(sendtime);
					sys.setOnefrequency(onefrequency);
					sys.setApitype(apitype);
					sys.setPanduanpanshu(panduanpanshu);
					sys.setMeipan(meipan);
					sys.setHuizong(huizong);
					request.setAttribute("systemmanager", sys);
				}
			} catch (FileNotFoundException e) {
				logger.error(e.getMessage());
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		return new ModelAndView("com/shtoone/qms/bhz/systemmanager");

	}

	@RequestMapping("/systemset")
	@ResponseBody
	public AjaxJson systemset(Systemmanager sys, HttpServletRequest request,
			HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		String filename = request.getSession().getServletContext()
				.getRealPath("/")
				+ "WEB-INF"
				+ File.separator
				+ "classes"
				+ File.separator
				+ "system.ini";
		Properties prop = new Properties();
		File fp = new File(filename);
		if (fp.exists()) {
			try {
				prop.load(new FileInputStream(fp));
				if (null != sys && null != sys.getApitype()) {
					FileOutputStream fos = new FileOutputStream(fp);
					prop.setProperty("smstype", sys.getSmstype());
					prop.setProperty("ambegin", sys.getAmbegin());
					prop.setProperty("amend", sys.getAmend());
					prop.setProperty("pmbegin", sys.getPmbegin());
					prop.setProperty("pmend", sys.getPmend());
					prop.setProperty("sendtype", sys.getSendtype());
					prop.setProperty("panshu", sys.getPanshu());
					prop.setProperty("frequency", sys.getFrequency());
					prop.setProperty("sendtime", sys.getSendtime());
					prop.setProperty("onefrequency", sys.getOnefrequency());
					prop.setProperty("apitype", sys.getApitype());
					prop.setProperty("panduanpanshu", sys.getPanduanpanshu());
					prop.setProperty("meipan", sys.getMeipan());
					prop.setProperty("huizong", sys.getHuizong());
					prop.store(fos, "system");
					fos.close();
					request.setAttribute("systemmanager", sys);
				}

			} catch (FileNotFoundException e) {
				logger.error(e.getMessage());
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		j.setMsg("设置成功");

		return j;

	}

	@RequestMapping("/refreshdata")
	public String refreshdata(HttpServletRequest request,
			HttpServletResponse response) {
		alarmsms();
		TopRealMaxhunnintuViewEntity hv = TopmaxhntService.findTop();
		if (null != hv) {
			String filename = request.getSession().getServletContext()
					.getRealPath("/")
					+ "WEB-INF"
					+ File.separator
					+ "classes"
					+ File.separator
					+ "sms.ini";
			File fp = new File(filename);
			if (!fp.exists()) {
				try {
					fp.createNewFile();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
			if (fp.exists()) {
				try {
					Properties prop = new Properties();
					prop.load(new FileInputStream(fp));
					String maxbh = prop.getProperty("bianhao", "1");
					if (null != hv && hv.getId() > Integer.parseInt(maxbh)) {
						FileOutputStream fos = new FileOutputStream(fp);
						prop.setProperty("bianhao", String.valueOf(hv.getId()));
						prop.store(fos, "sms");
						fos.close();
						xxmaxService.getMaxhntxx();
					}
				} catch (FileNotFoundException e) {
					logger.error(e.getMessage());
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		}
		return null;

	}

	@RequestMapping("/alarmsms")
	public void alarmsms() {
		List<SmsrecordEntity> recordlist = smshntService.getalarmrecordList();
		for (Iterator iterator = recordlist.iterator(); iterator.hasNext();) {
			SmsrecordEntity smsrecord = (SmsrecordEntity) iterator.next();
			if (StringUtil.Null2Blank(smsrecord.getDepartid()).length() > 0
					&& StringUtil.Null2Blank(smsrecord.getAlarmnumber())
							.length() > 0) {
				int alarmcount = 2;
				if (null != smsrecord.getAlarmcount()) {
					alarmcount = smsrecord.getAlarmcount();
				}
				if (smsrecord.getSmscount() <= alarmcount) {
					// TSDepart depart = systemService.getEntity(TSDepart.class,
					// smsrecord.getDepartid());
					BanhezhanxinxiEntity bhz = bhzService
							.getBhzbydepartid(smsrecord.getDepartid());
					if (StringUtil.Null2Blank(bhz.getGprsbianhao()).length() > 0
							&& StringUtil.Null2Blank(smsrecord.getDepartid())
									.length() > 0) {
						smsrecord.setCompletealarm(1);
						smshntService.saveOrUpdate(smsrecord);
						systemService.saveandSendSms(0, bhz.getGprsbianhao(),
								smsrecord.getAlarmnumber(), "", "", "您当前短信余额为"
										+ smsrecord.getSmscount() + "请及时充值!",
								null);
					}
				}
			}
		}

	}

	@RequestMapping("/sms")
	public String sms(HttpServletRequest request, HttpServletResponse response) {
		String filename = request.getSession().getServletContext().getRealPath("/")+ "WEB-INF"+ File.separator+ "classes"+ File.separator+ "sms.ini";
		File fp = new File(filename);
		if (!fp.exists()) {
			try {
				fp.createNewFile();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		if (fp.exists()) {
			try {
				Properties prop = new Properties();
				prop.load(new FileInputStream(fp));
				String maxbh = prop.getProperty("bianhao", "1");
				String curstrbh = prop.getProperty("curbianhao", "0");
				Integer curbh = Integer.parseInt(curstrbh);
				if (curbh == 0) {
					TopRealMaxhunnintuViewEntity tophv = TopmaxhntService.findTop();
					if (null != tophv) {
						curbh = tophv.getId();
						FileOutputStream fos = new FileOutputStream(fp);
						prop.setProperty("curbianhao", String.valueOf(curbh));
						prop.store(fos, "sms");
						fos.close();
					}
				}

				if (curbh > 0 && curbh <= Integer.parseInt(maxbh)) {
					FileOutputStream fos = new FileOutputStream(fp);
					prop.setProperty("curbianhao", String.valueOf(curbh + 1));
					updateBhzstate(request,curbh);
					prop.store(fos, "sms");
					fos.close();
					HunnintuView hv = mainService.getHviewById(curbh);
					if (null != hv) {
						String shebeibianhao = hv.getShebeibianhao();
						HntbhzziduancfgEntity hntissms = topmaxhnt.hntissmsfindBybh(shebeibianhao, false);
						HntbhzziduancfgEntity hntsmslow = topmaxhnt.hntsmslowfindBybh(shebeibianhao, false);
						HntbhzziduancfgEntity hntsmshigh = topmaxhnt.hntsmshighfindBybh(shebeibianhao, false);
						HntbhzziduancfgEntity hntsmsnumber = topmaxhnt.hntsmsnumberfindBybh(shebeibianhao);
						HntbhzziduancfgEntity hntsmscontent = topmaxhnt.hntsmscontentfindBybh(shebeibianhao);
						HntbhzziduancfgViewEntity hntfieldname = topmaxhnt.hntfieldnamefindBybh(shebeibianhao);
						HntbhzziduancfgEntity hntsmssheji = topmaxhnt.hntsmsshejifindBybh(shebeibianhao, false);
						HntbhzziduancfgEntity hntsmssheji2 = topmaxhnt.hntsmsshejifindBybh2(shebeibianhao, false);
						HntbhzziduancfgEntity hntsmslow2 = topmaxhnt.hntsmslowfindBybh2(shebeibianhao, false);
						HntbhzziduancfgEntity hntsmshigh2 = topmaxhnt.hntsmshighfindBybh2(shebeibianhao, false);
						HntbhzziduancfgEntity hntsmsnumber2 = topmaxhnt.hntsmsnumberfindBybh2(shebeibianhao);
						HntbhzziduancfgEntity hntsmslow3 = topmaxhnt.hntsmslowfindBybh3(shebeibianhao, false);
						HntbhzziduancfgEntity hntsmshigh3 = topmaxhnt.hntsmshighfindBybh3(shebeibianhao, false);
						HntbhzziduancfgEntity hntsmsnumber3 = topmaxhnt.hntsmsnumberfindBybh3(shebeibianhao);
						HntbhzziduancfgEntity hntisshowcfg = mainService.hntisshowcfgBybh(shebeibianhao);

						if (null != hntissms && null != hntsmslow && null != hntsmshigh && null != hntsmsnumber&& null != hntsmscontent 
							&& null != hntsmssheji && null != hntsmslow2 && null != hntsmshigh2 && null != hntsmsnumber2 && 
							null != hntsmslow3 && null != hntsmshigh3 && null != hntsmsnumber3) {
							if (StringUtil.pdjiaobanshijian(hv.getJiaozuobuwei(), "喷浆")|| StringUtil.pdjiaobanshijian(hv.getJiaozuobuwei(), "初支")
								|| StringUtil.pdjiaobanshijian(hv.getJiaozuobuwei(), "喷射") || StringUtil.pdjiaobanshijian(hv.getJiaozuobuwei(), "CFG")
								|| StringUtil.pdjiaobanshijian(hv.getJiaozuobuwei(), "临建") || StringUtil.pdjiaobanshijian(hv.getJiaozuobuwei(), "临时")
								|| StringUtil.pdjiaobanshijian(hv.getJiaozuobuwei(), "砂浆") || StringUtil.pdjiaobanshijian(hv.getJiaozuobuwei(), "沙浆")
								|| StringUtil.pdjiaobanshijian(hv.getGongchengmingcheng(), "喷浆") || StringUtil.pdjiaobanshijian(hv.getGongchengmingcheng(), "初支")
								|| StringUtil.pdjiaobanshijian(hv.getGongchengmingcheng(), "喷射") || StringUtil.pdjiaobanshijian(hv.getGongchengmingcheng(), "CFG")
								|| StringUtil.pdjiaobanshijian(hv.getGongchengmingcheng(), "临建") || StringUtil.pdjiaobanshijian(hv.getGongchengmingcheng(), "临时")
								|| StringUtil.pdjiaobanshijian(hv.getGongchengmingcheng(), "砂浆") || StringUtil.pdjiaobanshijian(hv.getGongchengmingcheng(), "沙浆")
								|| StringUtil.pdjiaobanshijian(hv.getPeifanghao(), "喷浆") || StringUtil.pdjiaobanshijian(hv.getPeifanghao(), "初支")
								|| StringUtil.pdjiaobanshijian(hv.getPeifanghao(), "喷射") || StringUtil.pdjiaobanshijian(hv.getPeifanghao(), "CFG")
								|| StringUtil.pdjiaobanshijian(hv.getPeifanghao(), "临建") || StringUtil.pdjiaobanshijian(hv.getPeifanghao(), "临时")
								|| StringUtil.pdjiaobanshijian(hv.getPeifanghao(), "砂浆") || StringUtil.pdjiaobanshijian(hv.getPeifanghao(), "沙浆")) {
								hntsmssheji = hntsmssheji2;
							} else if (StringUtil.pdjiaobanshijian(hv.getJiaozuobuwei(), "高性能") || StringUtil.pdjiaobanshijian(hv.getJiaozuobuwei(), "耐久性")
								|| StringUtil.pdjiaobanshijian(hv.getGongchengmingcheng(), "高性能") || StringUtil.pdjiaobanshijian(hv.getGongchengmingcheng(), "耐久性")
								|| StringUtil.pdjiaobanshijian(hv.getPeifanghao(), "高性能") || StringUtil.pdjiaobanshijian(hv.getPeifanghao(), "耐久性")) {
								hntsmssheji.setJiaobanshijian("120");
							}
							filename = request.getSession().getServletContext().getRealPath("/")+ "WEB-INF"+ File.separator+ "classes"+ File.separator + "system.ini";
							fp = new File(filename);
							int onefrequency = 1;
							int panduanpanshu = 10;
							int ps = 100;
							String panshu = "100";
							if (fp.exists()) {
								prop = new Properties();
								try {
									prop.load(new FileInputStream(fp));
									try {
										onefrequency = Integer.parseInt(prop.getProperty("onefrequency","1"));
									} catch (Exception e) {}
									try {
										panduanpanshu = Integer.parseInt(prop.getProperty("panduanpanshu","10"));
									} catch (Exception e) {}
									panshu = StringUtil.Null2Blank(prop.getProperty("panshu"));
								} catch (FileNotFoundException e) {
									logger.error(e.getMessage());
								} catch (IOException e) {
									logger.error(e.getMessage());
								}
							}

							if (null != hv && StringUtil.Null2Blank(hv.getPanshu()).length() > 0) {
								try {
									panduanpanshu = Integer.valueOf(StringUtil.Null2Blank(hv.getPanshu()));
								} catch (Exception e) {}
							}

							XiangxixxsmsEntity xxsms = mainService.getXxsmsbybh(shebeibianhao);
							if (null == xxsms) {
								xxsms = new XiangxixxsmsEntity();
								xxsms.setShebeibianhao(shebeibianhao);
								xxsms.setLeiji(0);
								xxsms.setPanshu(1);
							} else {
								if (xxsms.getPanshu() >= ps) {
									xxsms.setPanshu(1);
									xxsms.setLeiji(0);
								} else {
									xxsms.setPanshu(xxsms.getPanshu() + 1);
								}
							}
							xxsmsService.save(xxsms);
							XiangxixxjieguoEntity xxjg = xxjgService.findByxinxibianhao(hv.getId());
							if (null == xxjg) {
								xxjg = new XiangxixxjieguoEntity();
							}
							int sendcount = 0;
							chaobiaodenji(hv, filename, hv.getId(),shebeibianhao, hv.getSmsbaojin(), hntissms,hntsmslow, hntsmslow2, hntsmslow3,
									hntsmsnumber, hntsmsnumber2, hntsmsnumber3,hntsmscontent, hntfieldname, hntisshowcfg,xxjg);
						}
					}

				}
			} catch (FileNotFoundException e) {
				logger.error(e.getMessage());
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		csrefreshdata(request,response);
		return null;
	}
	
	//将拌和站中刷新状态的标识更改1
	public void updateBhzstate(HttpServletRequest request,Integer curbh){
		///按规律统计拌和机数据
		String filenamefj=request.getSession().getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"classes"+File.separator+"smstj.ini"; 
		File fptj = new File(filenamefj);
		if(!fptj.exists()){
			try {
				fptj.createNewFile();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		if (fptj.exists()) {
			try{
				Properties proptj=new Properties();
				proptj.load(new FileInputStream(fptj));	
				String curtjstrbh = proptj.getProperty("curtjbianhao", "0");	
				Integer curtjbh = Integer.parseInt(curtjstrbh);
				if (curtjbh > 0 && curtjbh <= curbh) {
					try { 
						jdbcDao.executeSql(" UPDATE Xiangxixx SET tjstate=1 where  id="+curtjbh+"  and  isnull(tjstate,0)=0 ", new Object[]{} );
						if(fptj.exists()){ 
							try {			
								FileOutputStream fos = new FileOutputStream(fptj);
								proptj.setProperty("curtjbianhao", String.valueOf(curtjbh+1));
								proptj.store(fos, "smstj");
								fos.close();
							} catch (IOException e) {
								logger.error(e.getMessage());
							}
						}
					} catch (Exception e) {
						logger.error(e.getMessage());
					} 	
				}
			}catch (FileNotFoundException e) {
				logger.error(e.getMessage());
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
	}


	private void chaobiaodenji(HunnintuView hv, String filename,Integer bianhao, String shebeibianhao, String smsbaojin,
			HntbhzziduancfgEntity issms, HntbhzziduancfgEntity biaozhun,HntbhzziduancfgEntity biaozhun2, HntbhzziduancfgEntity biaozhun3,
			HntbhzziduancfgEntity hntsmsnumber,HntbhzziduancfgEntity hntsmsnumber2,HntbhzziduancfgEntity hntsmsnumber3,
			HntbhzziduancfgEntity hntsmscontent,HntbhzziduancfgViewEntity hntfieldname,HntbhzziduancfgEntity hntisshowcfg, XiangxixxjieguoEntity xxjg) {
		String[] cfg = { "Sha1_", "Shi1_", "Shi2_", "Sha2_", "Guliao5_","Shuini1_", "Shuini2_", "Kuangfen3_", "Feimeihui4_",
				"Fenliao5_", "Fenliao6_", "Shui1_", "Shui2_", "Waijiaji1_","Waijiaji2_", "Waijiaji3_", "Waijiaji4_" };
		String[] shijicfg = { hv.getSha1_shijizhi(), hv.getShi1_shijizhi(),hv.getShi2_shijizhi(), hv.getSha2_shijizhi(),
				hv.getGuliao5_shijizhi(), hv.getShuini1_shijizhi(),hv.getShuini2_shijizhi(), hv.getKuangfen3_shijizhi(),
				hv.getFeimeihui4_shijizhi(), hv.getFenliao5_shijizhi(),hv.getFenliao6_shijizhi(), hv.getShui1_shijizhi(),
				hv.getShui2_shijizhi(), hv.getWaijiaji1_shijizhi(),hv.getWaijiaji2_shijizhi(), hv.getWaijiaji3_shijizhi(),hv.getWaijiaji4_shijizhi() };
		String[] liluncfg = { hv.getSha1_lilunzhi(), hv.getShi1_lilunzhi(),hv.getShi2_lilunzhi(), hv.getSha2_lilunzhi(),
				hv.getGuliao5_lilunzhi(), hv.getShuini1_lilunzhi(),hv.getShuini2_lilunzhi(), hv.getKuangfen3_lilunzhi(),
				hv.getFeimeihui4_lilunzhi(), hv.getFenliao5_lilunzhi(),hv.getFenliao6_lilunzhi(), hv.getShui1_lilunzhi(),
				hv.getShui2_lilunzhi(), hv.getWaijiaji1_lilunzhi(),hv.getWaijiaji2_lilunzhi(), hv.getWaijiaji3_lilunzhi(),hv.getWaijiaji4_lilunzhi() };
		Double[] percfg = { hv.getGlper1(), hv.getGlper2(), hv.getGlper3(),hv.getGlper4(), hv.getGlper5(), hv.getFlper1(), hv.getFlper2(),
				hv.getFlper3(), hv.getFlper4(), hv.getFlper5(), hv.getFlper6(),hv.getShper1(), hv.getShper2(), hv.getWjper1(), hv.getWjper2(),hv.getWjper3(), hv.getWjper4() };
		String[] smscfg = { issms.getSha1_shijizhi(),issms.getShi1_shijizhi(), issms.getShi2_shijizhi(),issms.getSha2_shijizhi(), issms.getGuliao5_shijizhi(),
				issms.getShuini1_shijizhi(), issms.getShuini2_shijizhi(),issms.getKuangfen3_shijizhi(), issms.getFeimeihui4_shijizhi(),
				issms.getFenliao5_shijizhi(), issms.getFenliao6_shijizhi(),issms.getShui1_shijizhi(), issms.getShui2_shijizhi(),issms.getWaijiaji1_shijizhi(), issms.getWaijiaji2_shijizhi(),
				issms.getWaijiaji3_shijizhi(), issms.getWaijiaji4_shijizhi() };
		Integer denjizhi = -1;
		double finalbzzhi = -1;
		Integer ziduantype = -1;
		int smsno = -1;
		int dj3 = -1;
		int dj2 = -1;
		int dj1 = -1;
		double max3 = 0;
		double max2 = 0;
		double max1 = 0;
		for (int i = 0; i < 17; i++) {
			try {
				double bz = -1;
				double bz2 = -1;
				double bz3 = -1;
				double finalbz = -1;
				Integer denji = -1;
				boolean denji1 = false;
				boolean denji2 = false;
				boolean denji3 = false;
				double shiji = 0;
				double lilun = 0;
				try {
					if (StringUtil.Null2Blank(shijicfg[i]).length() > 0) {
						shiji = Double.valueOf(String.format("%1$.3f",Double.valueOf(shijicfg[i])));
					}
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
				try {
					if (StringUtil.Null2Blank(liluncfg[i]).length() > 0) {
						lilun = Double.valueOf(String.format("%1$.3f",Double.valueOf(liluncfg[i])));
					}
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
				double wucha = percfg[i];
				if (null != biaozhun.getClass().getMethod("get" + cfg[i] + "shijizhi", new Class[] {}).invoke(biaozhun, new Object[] {})
					&& StringUtil.Null2Blank((String) biaozhun.getClass().getMethod("get" + cfg[i] + "shijizhi",new Class[] {}).invoke(biaozhun, new Object[] {})).length() > 0) {
					bz = StringUtil.StrToZero((String) biaozhun.getClass().getMethod("get" + cfg[i] + "shijizhi",new Class[] {}).invoke(biaozhun, new Object[] {}));
				}
				if (null != biaozhun2.getClass().getMethod("get" + cfg[i] + "shijizhi", new Class[] {}).invoke(biaozhun2, new Object[] {})
					&& StringUtil.Null2Blank((String) biaozhun2.getClass().getMethod("get" + cfg[i] + "shijizhi",new Class[] {}).invoke(biaozhun2, new Object[] {})).length() > 0) {
					bz2 = StringUtil.StrToZero((String) biaozhun2.getClass().getMethod("get" + cfg[i] + "shijizhi",new Class[] {}).invoke(biaozhun2, new Object[] {}));
				}
				if (null != biaozhun3.getClass().getMethod("get" + cfg[i] + "shijizhi", new Class[] {}).invoke(biaozhun3, new Object[] {})
					&& StringUtil.Null2Blank((String) biaozhun3.getClass().getMethod("get" + cfg[i] + "shijizhi",new Class[] {}).invoke(biaozhun3, new Object[] {})).length() > 0) {
					bz3 = StringUtil.StrToZero((String) biaozhun3.getClass().getMethod("get" + cfg[i] + "shijizhi",new Class[] {}).invoke(biaozhun3, new Object[] {}));
				}
				ziduantype = i + 1;
				if (lilun > 0 && shiji > 0) {
					if (ziduantype != 0 || wucha < 0) {
						if (bz3 > 0 && Math.abs(wucha) > bz3) {
							finalbz = bz3;
							denji = 3;
							denji3 = true;
							denji2 = true;
							denji1 = true;
						} else if (bz2 > 0 && Math.abs(wucha) > bz2) {
							finalbz = bz2;
							denji = 2;
							denji2 = true;
							denji1 = true;
						} else if (bz > 0 && Math.abs(wucha) > bz) {
							finalbz = bz;
							denji = 1;
							denji1 = true;
						}
						if (finalbz > 0) {
							if (StringUtil.Null2Blank(smscfg[i]).equalsIgnoreCase("1")) {
								if (denji == 3 && Math.abs(wucha) > max3) {
									dj3 = i;
								}
								if (denji == 2 && Math.abs(wucha) > max2) {
									dj2 = i;
								}
								if (denji == 1 && Math.abs(wucha) > max1) {
									dj1 = i;
								}
								if (dj3 > -1) {
									smsno = dj3;
									denjizhi = 3;
									finalbzzhi = bz3;
								} else if (dj2 > -1) {
									smsno = dj2;
									denjizhi = 2;
									finalbzzhi = bz2;
								} else if (dj1 > -1) {
									smsno = dj1;
									denjizhi = 1;
									finalbzzhi = bz;
								}

							}

							int biaozhuntype = 0;
							if (wucha > 0) {
								biaozhuntype = 1;
							}

							setSmsTypeDb(filename, bianhao, shebeibianhao,
									denji2, denji3, biaozhuntype, i + 1, xxjg);

							if (null != xxjg.getLeixing()) {
								xxjg.setXinxibianhao(hv.getId());
								xxjg.setChuliaoshijian(hv.getChuliaoshijian());
								xxjg.setShebeibianhao(shebeibianhao);
								xxjg.setGongchengmingcheng(hv.getGongchengmingcheng());
								xxjg.setSigongdidian(hv.getSigongdidian());
								xxjg.setJiaozuobuwei(hv.getJiaozuobuwei());
								xxjg.setQiangdudengji(hv.getQiangdudengji());
								xxjg.setPeifanghao(hv.getPeifanghao());
								xxjg.setBaocunshijian(hv.getBaocunshijian());
								if(StringUtil.Null2Blank(smscfg[i]).equalsIgnoreCase("1")){
									xxjgService.saveOrUpdate(xxjg);
								}
							}
						}
					}
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		if (smsno >= 0 && denjizhi > 0) {
			meipandosms(smsno, hv, filename, bianhao, shebeibianhao,hv.getSmsbaojin(), smscfg[smsno], percfg[smsno],
					hntsmsnumber, hntsmsnumber2, hntsmsnumber3,shijicfg[smsno], liluncfg[smsno], finalbzzhi, denjizhi,
					hntsmscontent, hntfieldname, hv.getBaocunshijian(),hv.getChuliaoshijian(), hntisshowcfg);
		}
	}

	private void setSmsTypeDb(String filename, Integer bianhao,
			String shebeibianhao, boolean denji2, boolean denji3,
			int biaozhuntype, int ziduantype, XiangxixxjieguoEntity xxjg) {
		if (null == xxjg) {
			xxjg = new XiangxixxjieguoEntity();
			xxjg.setXinxibianhao(bianhao);
		}
		String zhuntai = "0";
		Integer leixing = 0;
		switch (biaozhuntype) {
		case 0:
			if (denji3) {
				zhuntai = "3";
				leixing = 3;
			} else if (denji2) {
				zhuntai = "2";
				leixing = 2;
			} else {
				zhuntai = "1";
				leixing = 1;
			}
			break;
		case 1:
			if (denji3) {
				zhuntai = "6";
				leixing = 3;
			} else if (denji2) {
				zhuntai = "5";
				leixing = 2;
			} else {
				zhuntai = "4";
				leixing = 1;
			}
			break;
		default:
			break;
		}

		switch (ziduantype) {
		case 0:
			xxjg.setJiaobanshijian(zhuntai);
			break;
		case 1:
			xxjg.setSha1_shijizhi(zhuntai);
			break;
		case 2:
			xxjg.setShi1_shijizhi(zhuntai);
			break;
		case 3:
			xxjg.setShi2_shijizhi(zhuntai);
			break;
		case 4:
			xxjg.setSha2_shijizhi(zhuntai);
			break;
		case 5:
			xxjg.setGuliao5_shijizhi(zhuntai);
			break;
		case 6:
			xxjg.setShuini1_shijizhi(zhuntai);
			break;
		case 7:
			xxjg.setShuini2_shijizhi(zhuntai);
			break;
		case 8:
			xxjg.setKuangfen3_shijizhi(zhuntai);
			break;
		case 9:
			xxjg.setFeimeihui4_shijizhi(zhuntai);
			break;
		case 10:
			xxjg.setFenliao5_shijizhi(zhuntai);
			break;
		case 11:
			xxjg.setFenliao6_shijizhi(zhuntai);
			break;
		case 12:
			xxjg.setShui1_shijizhi(zhuntai);
			break;
		case 13:
			xxjg.setShui2_shijizhi(zhuntai);
			break;
		case 14:
			xxjg.setWaijiaji1_shijizhi(zhuntai);
			break;
		case 15:
			xxjg.setWaijiaji2_shijizhi(zhuntai);
			break;
		case 16:
			xxjg.setWaijiaji3_shijizhi(zhuntai);
			break;
		case 17:
			xxjg.setWaijiaji4_shijizhi(zhuntai);
			break;
		default:
			break;
		}
		if (null == xxjg.getLeiji()) {
			xxjg.setLeiji(1);
		} else {
			xxjg.setLeiji(xxjg.getLeiji() + 1);
		}
		if (null == xxjg.getShebeibianhao()) {
			xxjg.setShebeibianhao(shebeibianhao);
		}
		if (null == xxjg.getLeixing()) {
			xxjg.setLeixing(leixing);
		} else {
			if (leixing > xxjg.getLeixing()) {
				xxjg.setLeixing(leixing);
			}
		}
		XiangxixxsmsEntity xxsms = mainService.getXxsmsbybh(shebeibianhao);
		if (null != xxsms) {
			xxsms.setLeiji(xxsms.getLeiji() + 1);
			xxsmsService.saveOrUpdate(xxsms);
		}
	}

	private void meipandosms(Integer smsno, HunnintuView hv, String filename,Integer bianhao, String shebeibianhao, String smsbaojin,
			String issms, Double wucha, HntbhzziduancfgEntity hntsmsnumber,HntbhzziduancfgEntity hntsmsnumber2,HntbhzziduancfgEntity hntsmsnumber3, String shiji, String lilun,
			double finalbzzhi, Integer denjizhi,HntbhzziduancfgEntity hntsmscontent,HntbhzziduancfgViewEntity hntfieldname, String baocunshijian,String Chuliaoshijian, HntbhzziduancfgEntity hntisshowcfg) {
		String[] hntsmscontentcfg = { hntsmscontent.getSha1_shijizhi(),hntsmscontent.getShi1_shijizhi(),hntsmscontent.getShi2_shijizhi(),hntsmscontent.getSha2_shijizhi(),
				hntsmscontent.getGuliao5_shijizhi(),hntsmscontent.getShuini1_shijizhi(),hntsmscontent.getShuini2_shijizhi(),hntsmscontent.getKuangfen3_shijizhi(),
				hntsmscontent.getFeimeihui4_shijizhi(),hntsmscontent.getFenliao5_shijizhi(),hntsmscontent.getFenliao6_shijizhi(),hntsmscontent.getShui1_shijizhi(),
				hntsmscontent.getShui2_shijizhi(),hntsmscontent.getWaijiaji1_shijizhi(),hntsmscontent.getWaijiaji2_shijizhi(),hntsmscontent.getWaijiaji3_shijizhi(),
				hntsmscontent.getWaijiaji4_shijizhi()};
		String[] hntsmsnumbercfg = { hntsmsnumber.getSha1_shijizhi(),hntsmsnumber.getShi1_shijizhi(),hntsmsnumber.getShi2_shijizhi(),hntsmsnumber.getSha2_shijizhi(),
				hntsmsnumber.getGuliao5_shijizhi(),hntsmsnumber.getShuini1_shijizhi(),hntsmsnumber.getShuini2_shijizhi(),hntsmsnumber.getKuangfen3_shijizhi(),
				hntsmsnumber.getFeimeihui4_shijizhi(),hntsmsnumber.getFenliao5_shijizhi(),hntsmsnumber.getFenliao6_shijizhi(),hntsmsnumber.getShui1_shijizhi(),
				hntsmsnumber.getShui2_shijizhi(),hntsmsnumber.getWaijiaji1_shijizhi(),hntsmsnumber.getWaijiaji2_shijizhi(),hntsmsnumber.getWaijiaji3_shijizhi(),
				hntsmsnumber.getWaijiaji4_shijizhi() };
		String[] hntsmsnumber2cfg = { hntsmsnumber2.getSha1_shijizhi(),hntsmsnumber2.getShi1_shijizhi(),hntsmsnumber2.getShi2_shijizhi(),hntsmsnumber2.getSha2_shijizhi(),
				hntsmsnumber2.getGuliao5_shijizhi(),hntsmsnumber2.getShuini1_shijizhi(),hntsmsnumber2.getShuini2_shijizhi(),hntsmsnumber2.getKuangfen3_shijizhi(),
				hntsmsnumber2.getFeimeihui4_shijizhi(),hntsmsnumber2.getFenliao5_shijizhi(),hntsmsnumber2.getFenliao6_shijizhi(),hntsmsnumber2.getShui1_shijizhi(),
				hntsmsnumber2.getShui2_shijizhi(),hntsmsnumber2.getWaijiaji1_shijizhi(),hntsmsnumber2.getWaijiaji2_shijizhi(),hntsmsnumber2.getWaijiaji3_shijizhi(),
				hntsmsnumber2.getWaijiaji4_shijizhi() };
		String[] hntsmsnumber3cfg = { hntsmsnumber3.getSha1_shijizhi(),hntsmsnumber3.getShi1_shijizhi(),hntsmsnumber3.getShi2_shijizhi(),hntsmsnumber3.getSha2_shijizhi(),
				hntsmsnumber3.getGuliao5_shijizhi(),hntsmsnumber3.getShuini1_shijizhi(),hntsmsnumber3.getShuini2_shijizhi(),hntsmsnumber3.getKuangfen3_shijizhi(),
				hntsmsnumber3.getFeimeihui4_shijizhi(),hntsmsnumber3.getFenliao5_shijizhi(),hntsmsnumber3.getFenliao6_shijizhi(),hntsmsnumber3.getShui1_shijizhi(),
				hntsmsnumber3.getShui2_shijizhi(),hntsmsnumber3.getWaijiaji1_shijizhi(),hntsmsnumber3.getWaijiaji2_shijizhi(),hntsmsnumber3.getWaijiaji3_shijizhi(),
				hntsmsnumber3.getWaijiaji4_shijizhi() };
		String jiaobanphonenumber = hntsmsnumber.getJiaobanshijian();
		String phonenumber = hntsmsnumbercfg[smsno];
		String jiaobanphonenumber2 = hntsmsnumber2.getJiaobanshijian();
		String phonenumber2 = hntsmsnumber2cfg[smsno];
		String jiaobanphonenumber3 = hntsmsnumber3.getJiaobanshijian();
		String phonenumber3 = hntsmsnumber3cfg[smsno];
		String[] hntfieldnamecfg = { hntfieldname.getSha1_shijizhi(),hntfieldname.getShi1_shijizhi(),hntfieldname.getShi2_shijizhi(),hntfieldname.getSha2_shijizhi(),
				hntfieldname.getGuliao5_shijizhi(),hntfieldname.getShuini1_shijizhi(),hntfieldname.getShuini2_shijizhi(),hntfieldname.getKuangfen3_shijizhi(),
				hntfieldname.getFeimeihui4_shijizhi(),hntfieldname.getFenliao5_shijizhi(),hntfieldname.getFenliao6_shijizhi(),hntfieldname.getShui1_shijizhi(),
				hntfieldname.getShui2_shijizhi(),hntfieldname.getWaijiaji1_shijizhi(),hntfieldname.getWaijiaji2_shijizhi(),hntfieldname.getWaijiaji3_shijizhi(),
				hntfieldname.getWaijiaji4_shijizhi() };
		String fieldname = hntfieldnamecfg[smsno];
		String smscontent = hntsmscontentcfg[smsno];
		String bhzminchen = hv.getBanhezhanminchen();
		if (StringUtil.Null2Blank(shiji).length() > 0 && StringUtil.Null2Blank(lilun).length() > 0) {
			try {
				String leixin = "误";
				String gujifs = hv.getGujifangshu();
				boolean slok = false;
				if (StringUtil.Null2Blank(gujifs).length() > 0) {
					try {
						if (Double.valueOf(gujifs) > 0.2) {
							slok = true;
						}
					} catch (Exception e) {
					}
				}
				if (slok) {
					String sms = "";
					logger.info(hv.getBanhezhanminchen() + shebeibianhao+ fieldname + "超标" + wucha);
					Calendar day = Calendar.getInstance();
					day.add(Calendar.MINUTE, -30);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date baocun = day.getTime();
					try {
						baocun = sdf.parse(Chuliaoshijian);
					} catch (ParseException ex) {

					}
					boolean isnormal = true;

					if (isnormal  && baocun.after(day.getTime())  ) {
						logger.info(hv.getBanhezhanminchen() + shebeibianhao+ "数据正常，保存时间" + baocun);
						if (StringUtil.Null2Blank(smsbaojin).equalsIgnoreCase("1") && StringUtil.Null2Blank(issms).equalsIgnoreCase("1")
							&& getSmsifsend(hv, filename)) {
							String apitype = null;
							String filepanshu = "100";
							String smsmeipan = "[%s]%s%s:%s实%s配%s%s%s%%超%s%%";
							String smshuizong = "[%s]%s:已搅拌盘数%s累计超标准次数%s";
							File fp = new File(filename);
							if (fp.exists()) {
								Properties prop = new Properties();
								try {
									prop.load(new FileInputStream(fp));
									apitype = StringUtil.Null2Blank(prop.getProperty("apitype", "0"));
									filepanshu = StringUtil.Null2Blank(prop.getProperty("panshu", "100"));
									// smsmeipan =StringUtil.Null2Blank(prop.getProperty("meipan","[%s]%s%s:%s实%s配%s%s%s%%超%s%%"));
									smshuizong = StringUtil.Null2Blank(prop.getProperty("huizong","[%s]%s:已搅拌盘数%s累计超标准次数%s"));
								} catch (FileNotFoundException e) {
									logger.error(e.getMessage());
								} catch (IOException e) {
									logger.error(e.getMessage());
								}
								prop.clear();
							}

							// 专门正对成贵平台报警中报浇筑部位字段乱存储的情况
							String[] ArrStr = { "gongdanhao", "chaozuozhe","chuliaoshijian", "gongchengmingcheng","sigongdidian",
									"jiaozuobuwei","shuinipingzhong", "waijiajipingzhong","peifanghao", "qiangdudengji","jiaobanshijian", 
									"shebeibianhao","baocunshijian", "caijishijian","gujifangshu" };
							String jiaozhubuwei = "";
							String strjiaozhubuwei = "";
							for (int m = 0; m < ArrStr.length; m++) {
								if ((((String) hntfieldname.getClass().getMethod("get"+ ArrStr[m].replaceFirst(ArrStr[m].substring(0,1),ArrStr[m].substring(0,1).toUpperCase()),new Class[] {}).invoke(hntfieldname, new Object[] {})).indexOf("浇筑部位") > -1 
									|| ((String) hntfieldname.getClass().getMethod("get"+ ArrStr[m].replaceFirst(ArrStr[m].substring(0,1),ArrStr[m].substring(0,1).toUpperCase()),new Class[] {}).invoke(hntfieldname, new Object[] {})).indexOf("使用部位") > -1)) {
									jiaozhubuwei = ArrStr[m];
								}
							}
							try {
								if (StringUtil.Null2Blank(jiaozhubuwei).length() > 0) {
									strjiaozhubuwei = StringUtil.Null2Blank(((String) hv.getClass().getMethod("get"+ jiaozhubuwei.replaceFirst(jiaozhubuwei.substring(0,1),jiaozhubuwei.substring(0,1).toUpperCase()),new Class[] {}).invoke(hv, new Object[] {})));
								}
							} catch (Exception ex) {
							}

							switch (getSendtype(hv, filename)) {
							case 1:
								String schuliao = baocunshijian;
								if (StringUtil.Null2Blank(Chuliaoshijian).length() > 0 && StringUtil.Null2Blank(Chuliaoshijian).length() < 22) {
									schuliao = Chuliaoshijian;
								}
								if (schuliao.indexOf(" ") > 0) {
									schuliao = schuliao.substring(schuliao.indexOf(" ") + 1);
								}
								if (StringUtil.Null2Blank(fieldname).length() > 0) {
									//在这里判断短信接口
									switch (Integer.parseInt(apitype)) {
									case 97:
									case 100:
									case 123:
										if (StringUtil.Null2Blank(smscontent).length() > 0) {
											sms = String.format(smscontent,schuliao,bhzminchen,StringUtil.Null2Blank(hv.getJiaozuobuwei()),fieldname,String.format("%1$.3f",StringUtil.StrToZero(shiji)),String.format("%1$.3f",StringUtil.StrToZero(lilun)),leixin,String.format("%1$.3f",wucha),finalbzzhi);
											if (sms.length() > 64) {
												sms = String.format(smscontent,schuliao,bhzminchen,"",fieldname,String.format("%1$.3f",StringUtil.StrToZero(shiji)),String.format("%1$.3f",StringUtil.StrToZero(lilun)),leixin,String.format("%1$.3f",wucha),finalbzzhi);
											}
										} else {
											sms = String.format(smsmeipan,schuliao,bhzminchen,strjiaozhubuwei,fieldname,String.format("%1$.3f",StringUtil.StrToZero(shiji)),String.format("%1$.3f",StringUtil.StrToZero(lilun)),leixin,String.format("%1$.3f",wucha),finalbzzhi);
											if (sms.length() > 64) {
												sms = String.format(smsmeipan,schuliao,bhzminchen,"",fieldname,String.format("%1$.3f",StringUtil.StrToZero(shiji)),String.format("%1$.3f",StringUtil.StrToZero(lilun)),leixin,String.format("%1$.3f",wucha),finalbzzhi);
											}
										}
										break;
									default:  //阿里大鱼的短信接口
										JSONObject contentjson = new JSONObject(); 
								        contentjson.put("shijian", schuliao);
								        contentjson.put("name", bhzminchen);
								        contentjson.put("buwei", StringUtil.Null2Blank(hv.getJiaozuobuwei()));
								        contentjson.put("fieldname", fieldname);         
								        contentjson.put("shiji", String.format("%1$.3f",StringUtil.StrToZero(shiji)));
								        contentjson.put("lilun", String.format("%1$.3f",StringUtil.StrToZero(lilun)));
								        contentjson.put("wucha", String.format("%1$.3f",wucha));
								        contentjson.put("bz", String.format("%1$.1f",finalbzzhi));
								         
								        JSONObject obj = new JSONObject();
								        obj.put("qianmin", "");
								        obj.put("moban", "SMS_8906001");
								        obj.put("neirong", contentjson.toJSONString());
								        sms = obj.toJSONString();
								        break;
									}
									logger.info(hv.getBanhezhanminchen()+ shebeibianhao + "字段名" + fieldname+ "短信内容" + sms);
								}

								break;
							case 2:
								String panshu = "100";
								int ps = 100;
								if (null != hv && StringUtil.Null2Blank(hv.getSmssettype()).equalsIgnoreCase("1")) {
									panshu = StringUtil.Null2Blank(hv.getPanshu());
								} else {
									panshu = filepanshu;
								}
								if (panshu.length() > 0) {
									try {
										ps = Integer.valueOf(panshu);
									} catch (Exception e) {
										ps = 100;
									}
								}
								XiangxixxsmsEntity xxsms = mainService.getXxsmsbybh(shebeibianhao);
								if (null != xxsms && xxsms.getPanshu() >= ps) {
									sms = String.format(smshuizong, baocunshijian,bhzminchen,xxsms.getPanshu(),xxsms.getLeiji());
									xxsms.setLeiji(0);
									xxsms.setPanshu(0);
									xxsmsService.saveOrUpdate(xxsms);
								}
								break;
							default:
								break;
							}
							if (sms.length() > 0) {
								String realphonenumber = "";
								String realphonenumber2 = "";
								String realphonenumber3 = "";
								String realphonename = "";
								String realphonename2 = "";
								String realphonename3 = "";
								boolean denji1 = false;
								boolean denji2 = false;
								boolean denji3 = false;
								HandsetEntity hs = null;
								if (denjizhi == 3) {
									denji1 = true;
									denji2 = true;
									denji3 = true;
								} else if (denjizhi == 2) {
									denji1 = true;
									denji2 = true;
									denji3 = false;
								} else if (denjizhi == 1) {
									denji1 = true;
									denji2 = false;
									denji3 = false;
								}
								Hashtable recTable = null;
								if (denji1) {
									hs = mainService.getRealPhoneNumber(phonenumber);
									if (null == hs) {
										hs = mainService.getRealPhoneNumber(jiaobanphonenumber);
									}
									if (null != hs) {
										realphonenumber = hs.getPhone();
										realphonename = hs.getOwername();
									}

								}

								if (denji1 && StringUtil.Null2Blank(realphonenumber).length() > 0) {
									logger.info(hv.getBanhezhanminchen()+ shebeibianhao + "初级号码"+ realphonenumber);
									recTable = null;
									recTable = systemService.saveandSendSms(hv.getId(), shebeibianhao,realphonenumber, realphonename,Chuliaoshijian, sms, apitype);
									if (null == recTable || StringUtil.Null2Blank((String) recTable.get("successphone")).length() == 0) {
										recTable = systemService.saveandSendSms(hv.getId(),shebeibianhao,realphonenumber,realphonename,Chuliaoshijian, sms,apitype);
										if (null == recTable || StringUtil.Null2Blank((String) recTable.get("successphone")).length() == 0) {
											recTable = systemService.saveandSendSms(hv.getId(),shebeibianhao,realphonenumber,realphonename,Chuliaoshijian,sms, "97");
										}
									}
								}
								if (denji2) {
									hs = mainService.getRealPhoneNumber(phonenumber2);
									if (null == hs) {
										hs = mainService.getRealPhoneNumber(jiaobanphonenumber2);
									}
									if (null != hs) {
										realphonenumber2 = hs.getPhone();
										realphonename2 = hs.getOwername();
									}
								}

								if (denji2 && StringUtil.Null2Blank(realphonenumber2).length() > 0) {
									logger.info(hv.getBanhezhanminchen()+ shebeibianhao + "中级号码"+ realphonenumber2);
									recTable = null;
									recTable = systemService.saveandSendSms(hv.getId(), shebeibianhao,realphonenumber2, realphonename2,Chuliaoshijian, sms, apitype);
									if (null == recTable || StringUtil.Null2Blank((String) recTable.get("successphone")).length() == 0) {
										recTable = systemService.saveandSendSms(hv.getId(),shebeibianhao,realphonenumber2,realphonename2,Chuliaoshijian, sms,apitype);
										if (null == recTable || StringUtil.Null2Blank((String) recTable.get("successphone")).length() == 0) {
											recTable = systemService.saveandSendSms(hv.getId(),shebeibianhao,realphonenumber2,realphonename2,Chuliaoshijian,sms, "97");
										}
									}
								}

								if (denji3) {
									hs = mainService.getRealPhoneNumber(phonenumber3);
									if (null == hs) {
										hs = mainService.getRealPhoneNumber(jiaobanphonenumber3);
									}
									if (null != hs) {
										realphonenumber3 = hs.getPhone();
										realphonename3 = hs.getOwername();
									}
								}

								if (denji3 && StringUtil.Null2Blank(realphonenumber3).length() > 0) {
									logger.info(hv.getBanhezhanminchen()+ shebeibianhao + "高级号码"+ realphonenumber3);
									recTable = null;
									recTable = systemService.saveandSendSms(hv.getId(), shebeibianhao,realphonenumber3, realphonename3,Chuliaoshijian, sms, apitype);
									if (null == recTable || StringUtil.Null2Blank((String) recTable.get("successphone")).length() == 0) {
										recTable = systemService.saveandSendSms(hv.getId(),shebeibianhao,realphonenumber3,realphonename3,Chuliaoshijian, sms,apitype);
										if (null == recTable || StringUtil.Null2Blank((String) recTable.get("successphone")).length() == 0) {
											recTable = systemService.saveandSendSms(hv.getId(),shebeibianhao,realphonenumber3,realphonename3,Chuliaoshijian,sms, "97");
										}
									}
								}
							}
						}
					}
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
	}

	private int getSendtype(HunnintuView hv, String filename) {
		int st = 0;
		String sendtype = "";
		if (null != hv && StringUtil.Null2Blank(hv.getSmssettype()).equalsIgnoreCase("1")) {
			sendtype = StringUtil.Null2Blank(hv.getSendtype());
		} else {
			File fp = new File(filename);
			if (fp.exists()) {
				Properties prop = new Properties();
				try {
					prop.load(new FileInputStream(fp));
					sendtype = StringUtil.Null2Blank(prop.getProperty("sendtype"));
					prop.clear();
				} catch (FileNotFoundException e1) {
				} catch (IOException e1) {
				}
			}
		}
		if (sendtype.length() > 0) {
			st = Integer.valueOf(sendtype);
		}
		return st;
	}

	private boolean getSmsifsend(HunnintuView hv, String filename) {
		boolean ifsend = false;
		String smstype = "";
		Integer frequency = 0;
		File fp = new File(filename);
		Properties prop = new Properties();
		Calendar day = Calendar.getInstance();
		SimpleDateFormat senddf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date sendtime = null;
		try {
			sendtime = senddf.parse("2010-01-01 00:00:00");
		} catch (ParseException e2) {
		}
		if (fp.exists()) {
			try {
				prop.load(new FileInputStream(fp));
				smstype = StringUtil.Null2Blank(prop.getProperty("smstype"));
				frequency = Integer.parseInt(prop.getProperty("frequency"));
				sendtime = senddf.parse(prop.getProperty("sendtime"));
			} catch (FileNotFoundException e1) {
			} catch (Exception e1) {
			}
		}
		if (null != hv && StringUtil.Null2Blank(hv.getSmssettype()).equalsIgnoreCase("1")) {
			if (StringUtil.Null2Blank(hv.getSmstype()).equalsIgnoreCase("1")) {
				ifsend = true;
			} else {
				String ambegin = StringUtil.Null2Blank(hv.getAmbegin());
				String amend = StringUtil.Null2Blank(hv.getAmend());
				String pmbegin = StringUtil.Null2Blank(hv.getPmbegin());
				String pmend = StringUtil.Null2Blank(hv.getPmend());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd ");

				ambegin = sdf2.format(day.getTime()) + ambegin;
				amend = sdf2.format(day.getTime()) + amend;
				pmbegin = sdf2.format(day.getTime()) + pmbegin;
				pmend = sdf2.format(day.getTime()) + pmend;
				try {
					if ((day.getTime().after(sdf.parse(ambegin)) && day.getTime().before(sdf.parse(amend)))
							|| (day.getTime().after(sdf.parse(pmbegin)) && day.getTime().before(sdf.parse(pmend)))) {
						ifsend = true;
					}
				} catch (ParseException e) {
				}
			}
		} else {
			if (fp.exists()) {
				if (smstype.equalsIgnoreCase("1")) {
					ifsend = true;
				} else if (smstype.equalsIgnoreCase("0")) {
					String ambegin = StringUtil.Null2Blank(prop.getProperty("ambegin"));
					String amend = StringUtil.Null2Blank(prop.getProperty("amend"));
					String pmbegin = StringUtil.Null2Blank(prop.getProperty("pmbegin"));
					String pmend = StringUtil.Null2Blank(prop.getProperty("pmend"));
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd ");
					ambegin = sdf2.format(day.getTime()) + ambegin;
					amend = sdf2.format(day.getTime()) + amend;
					pmbegin = sdf2.format(day.getTime()) + pmbegin;
					pmend = sdf2.format(day.getTime()) + pmend;
					try {
						if ((day.getTime().after(sdf.parse(ambegin)) && day.getTime().before(sdf.parse(amend)))
							|| (day.getTime().after(sdf.parse(pmbegin)) && day.getTime().before(sdf.parse(pmend)))) {
							ifsend = true;
						}
					} catch (ParseException e) {
					}
				}

			}
		}
		if (ifsend) {
			Calendar curday = Calendar.getInstance();
			day.add(Calendar.SECOND, -frequency);
			if (sendtime.before(day.getTime())) {
				FileOutputStream fos;
				try {
					fos = new FileOutputStream(fp);
					prop.setProperty("sendtime",senddf.format(curday.getTime()));
					prop.store(fos, "system");
					fos.close();
				} catch (FileNotFoundException e) {
				} catch (IOException e) {
				}
			} else {
				ifsend = false;
			}
		}
		prop.clear();
		return ifsend;
	}

	
	
	
	
	//刷新新增拌合站数据xiangxixx,TopRealMaxhunnintuView
			//刷新最大编号
			public String csrefreshdata(HttpServletRequest request,
					HttpServletResponse response) {
				TopRealMaxhunnintuViewEntity hv = TopmaxhntService.findTop();
					if (null != hv) {
						String filename = request.getSession().getServletContext()
								.getRealPath("/")
								+ "WEB-INF"
								+ File.separator
								+ "classes"
								+ File.separator
								+ "cssms.ini";
						File fp = new File(filename);
						if (!fp.exists()) {
							try {
								fp.createNewFile();
							} catch (IOException e) {
								logger.error(e.getMessage());
							}
						}
						if (fp.exists()) {
							try {
								Properties prop = new Properties();
								prop.load(new FileInputStream(fp));
								String maxbh = prop.getProperty("bianhao", "1");
								if (null != hv && hv.getId() > Integer.parseInt(maxbh)) {
									FileOutputStream fos = new FileOutputStream(fp);
									prop.setProperty("bianhao", String.valueOf(hv.getId()));
									prop.store(fos, "cssms");
									fos.close();
									xxmaxService.getMaxhntxx();
									
								}
							} catch (FileNotFoundException e) {
								logger.error(e.getMessage());
							} catch (IOException e) {
								logger.error(e.getMessage());
							}
						}
					}
					BHZData(request,response);
					return null;
			}
			//依次递增传输拌合站数据
			public void BHZData(HttpServletRequest request, HttpServletResponse response) {
					String filename=request.getSession().getServletContext().getRealPath("/")+"WEB-INF"+File.separator
					+"classes"+File.separator+"cssms.ini";			
					File fp = new File(filename);			
					if(!fp.exists()){
						try {
							fp.createNewFile();
						} catch (IOException e) {
							logger.error(e.getMessage());
						}
					}
					if(fp.exists()){
						try {
							Properties prop=new Properties();
							prop.load(new FileInputStream(fp));	
							
							String maxbh = prop.getProperty("bianhao", "1");			
							String curstrbh = prop.getProperty("curchuanshubh", "0");	
							//获取当前编号
							Integer curbh = Integer.parseInt(curstrbh);
							if (curbh == 0) {
								//获取最大编号
								TopRealMaxhunnintuViewEntity hv = TopmaxhntService.findTop();
								  curbh = hv.getId();
								  FileOutputStream fos = new FileOutputStream(fp);
								  prop.setProperty("curchuanshubh", String.valueOf(curbh));
								  prop.store(fos, "cssms");
								  fos.close();
							}
												
							if (curbh > 0 && curbh <= Integer.parseInt(maxbh)) {
								FileOutputStream fos = new FileOutputStream(fp);
								prop.setProperty("curchuanshubh", String.valueOf(curbh+1));
								prop.store(fos, "cssms");
								fos.close();
								//根据当前编号获取相对应的数据组合成json字符串
								HntviewEntity hntview=TopmaxhntService.getHviewById(curbh);
								System.out.println("hntview+---");
								if(hntview!=null){
									System.out.println("发送编号hnt:"+hntview.getId());
									JSONObject json=new JSONObject();
									json.put("SheBeiBianHao", hntview.getShebeibianhao());
									json.put("GongDanHao", hntview.getGongdanhao());
									json.put("ChaoZuoZhe", hntview.getChaozuozhe());
									json.put("SheJiFangLiang", hntview.getWaijiajipingzhong());////
									json.put("GuJiFangShu", hntview.getGujifangshu());
									json.put("XiGuLiao1_ShiJiZhi", hntview.getSha1_shijizhi());
									json.put("XiGuLiao1_LiLunZhi", hntview.getSha1_lilunzhi());
									json.put("XiGuLiao2_ShiJiZhi", hntview.getSha2_shijizhi());
									json.put("XiGuLiao2_LiLnZhi", hntview.getSha2_lilunzhi());
									json.put("CuGuLiao1_ShiJiZhi", hntview.getShi1_shijizhi());
									json.put("CuGuLiao1_LiLunZhi", hntview.getShi1_lilunzhi());
									json.put("CuGuLiao2_ShiJiZhi", hntview.getShi2_shijizhi());
									json.put("CuGuLiao2_LiLunZhi", hntview.getShi2_lilunzhi());
									json.put("CuGuLiao3_ShiJiZhi", hntview.getGuliao5_shijizhi());///
									json.put("CuGuLiao3_LiLunZhi", hntview.getGuliao5_lilunzhi());///
									json.put("ShuiNi1_ShiJiZhi", hntview.getShuini1_shijizhi());
									json.put("ShuiNi1_LiLunZhi", hntview.getShuini1_lilunzhi());
									json.put("ShuiNi2_ShiJiZhi", hntview.getShuini2_shijizhi());
									json.put("ShuiNi2_LiLunZhi", hntview.getShuini2_lilunzhi());
									json.put("KuangFen3_ShiJiZhi", hntview.getKuangfen3_shijizhi());
									json.put("KuangFen3_LiLunZhi", hntview.getKuangfen3_lilunzhi());
									json.put("FenMeiHui4_ShiJiZhi", hntview.getFeimeihui4_shijizhi());
									json.put("FenMeiHui4_LiLunZhi", hntview.getFeimeihui4_lilunzhi());
									json.put("FenLiao5_ShiJiZhi", hntview.getFenliao5_shijizhi());
									json.put("FenLiao5_LiLunZhi", hntview.getFenliao5_lilunzhi());
									json.put("FenLiao6_ShiJiZhi", hntview.getFenliao6_shijizhi());
									json.put("FenLiao6_LiLunZhi", hntview.getFenliao6_lilunzhi());
									json.put("Shui1_ShiJiZhi", hntview.getShui1_shijizhi());
									json.put("Shui1_LiLunZhi", hntview.getShui1_lilunzhi());
									json.put("Shui2_ShijiZhi", hntview.getShui2_shijizhi());
									json.put("Shui2_LiLunZhi", hntview.getShui2_lilunzhi());
									json.put("WaiJiaJi1_ShiJiZhi", hntview.getWaijiaji1_shijizhi());
									json.put("WaiJiaJi1_LiLunZhi", hntview.getWaijiaji1_lilunzhi());
									json.put("WaiJiaJi2_ShiJiZhi", hntview.getWaijiaji2_shijizhi());
									json.put("WaiJiaJi2_LiLunZhi", hntview.getWaijiaji2_lilunzhi());
									json.put("WaiJiaJi3_ShiJiZhi", hntview.getWaijiaji3_shijizhi());
									json.put("WaiJiaJi3_LiLunZhi", hntview.getWaijiaji3_lilunzhi());
									json.put("WaiJiaJi4_ShiJiZhi", hntview.getWaijiaji4_shijizhi());
									json.put("WaiJiaJi4_LiLunZhi", hntview.getWaijiaji4_lilunzhi());
									json.put("ChuLiaoShiJian", hntview.getChuliaoshijian());
									json.put("GongChengMingMheng", hntview.getGongchengmingcheng());
									json.put("SiGongDiDian", hntview.getSigongdidian());
									json.put("JiaoZuoBuWei", hntview.getJiaozuobuwei());
									json.put("ShuiNiPingZhong", hntview.getShuinipingzhong());
									json.put("PeiFangHao", hntview.getPeifanghao());
									json.put("QiangDuDengJi", hntview.getQiangdudengji());
									json.put("JiaoBanShiJian", hntview.getJiaobanshijian());
									json.put("BaoCunShiJian", hntview.getBaocunshijian());
									json.put("KeHuDuanBianhao", hntview.getKehuduanbianhao());
									System.out.println("--test1---");
									//通过此webserver接口发送数据
									String nameSpace="http://tempuri.org/";
									String url = "http://api.cqdkkj.com";
									Service service = new Service();
									Call call = new Call(service);  
									call.setTargetEndpointAddress(new java.net.URL(url));
									call.setUseSOAPAction(true);  
							        call.setSOAPActionURI("http://tempuri.org/OperationMethod");
									call.setOperationName(new QName("http://tempuri.org/", "OperationMethod")) ;
									call.addParameter(new QName(nameSpace,"operationType"), org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN) ;//1
									call.addParameter(new QName(nameSpace,"jsonObj"), org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN) ;//1
									call.setReturnType(new QName("http://tempuri.org/", "OperationMethodResult"), Boolean.class);  
									System.out.println("--test2---");
									boolean res = (Boolean) call.invoke(new Object[]{"AddBHZData",json.toString()});
									System.out.println("--test3---");
									System.out.println("拌合站数据发送情况："+res);
								}
							}
						} catch (IOException e) {
							logger.error(e.getMessage());
						}
					}
			}
			
			
			@RequestMapping("/xgapp")
			public String xgapp(HttpServletRequest request,HttpServletResponse response){
				XingeApp xg = new XingeApp(2100217629, "1ea3ecf07c05bf4fa0d58cf4fbc5032c");
				
//				ClickAction click = new ClickAction();
//				click.setActionType(ClickAction.TYPE_ACTIVITY);
//				click.setActivity("AbcActivity");
				
				Message message = new Message();
				message.setTitle("标题");
				message.setContent("中级");
				message.setType(Message.TYPE_MESSAGE);
				message.setExpireTime(86400);
				
				org.json.JSONObject ret;
				
//				Demo();
				
				ret = xg.pushAllDevice(0, message);
				
				//ret = XingeApp.pushAllAndroid(2100216166, "9a62983c7c210e2a92c0fe01f8ece115", "abcd", "zzzzz");
				System.out.println(ret);
				return null;
			}

			public void Demo()
			{
				message1 = new Message();
				message1.setType(Message.TYPE_NOTIFICATION);
				Style style = new Style(1);
				style = new Style(3,1,0,1,0);
				ClickAction action = new ClickAction();
				action.setActionType(ClickAction.TYPE_URL);
				action.setUrl("http://xg.qq.com");
				Map<String, Object> custom = new HashMap<String, Object>();
				custom.put("key1", "value1");
				custom.put("key2", 2);
				message1.setTitle("title");
				message1.setContent("大小");
				message1.setStyle(style);
				message1.setAction(action);
				message1.setCustom(custom);
				TimeInterval acceptTime1 = new TimeInterval(0,0,23,59);
				message1.addAcceptTime(acceptTime1);
				
				message2 = new Message();
				message2.setType(Message.TYPE_NOTIFICATION);
				message2.setTitle("title");
				message2.setContent("通知点击执行Intent测试");
				style = new Style(1);
				action = new ClickAction();
				action.setActionType(ClickAction.TYPE_INTENT);
				action.setIntent("intent:10086#Intent;scheme=tel;action=android.intent.action.DIAL;S.key=value;end");
				message2.setStyle(style);
				message2.setAction(action);
			}
			
			private Message message1;
			private Message message2;
			
			
			
}
