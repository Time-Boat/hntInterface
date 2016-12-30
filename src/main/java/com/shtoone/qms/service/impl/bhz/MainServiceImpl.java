package com.shtoone.qms.service.impl.bhz;

import java.io.UnsupportedEncodingException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.system.controller.core.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.shtoone.qms.dao.IDatasubmitDao;
import com.shtoone.qms.entity.FwangnjEntity;
import com.shtoone.qms.entity.PhonecfgEntity;
import com.shtoone.qms.entity.ShebeiInfoEntity;
import com.shtoone.qms.entity.TconsignEntity;
import com.shtoone.qms.entity.TsyjzbEntity;
import com.shtoone.qms.entity.bhz.HandsetEntity;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgEntity;
import com.shtoone.qms.entity.bhz.HunnintuView;
import com.shtoone.qms.entity.bhz.XiangxixxsmsEntity;
import com.shtoone.qms.service.DatasubmitService;
import com.shtoone.qms.service.bhz.HandsetServiceI;
import com.shtoone.qms.service.bhz.HntbhzziduancfgServiceI;
import com.shtoone.qms.service.bhz.HunnintuViewServiceI;
import com.shtoone.qms.service.bhz.MainService;
import com.shtoone.qms.service.bhz.TopRealMaxhunnintuViewServiceI;
import com.shtoone.qms.service.bhz.XiangxixxsmsServiceI;
import com.shtoone.qms.util.Smssender;
import com.shtoone.qms.util.XMLUtils;
import com.thoughtworks.xstream.XStream;
import com.shtoone.qms.util.StringUtil;


@Service("mainService")
@Transactional
public class MainServiceImpl extends CommonServiceImpl implements MainService {
	private Logger log = Logger.getLogger(MainServiceImpl.class);
	
	@Autowired
	private HunnintuViewServiceI hntview;
	
	@Autowired
	private HntbhzziduancfgServiceI hntzdcfg;
	
	@Autowired
	private TopRealMaxhunnintuViewServiceI topmaxhnt;
	
	@Autowired
	private XiangxixxsmsServiceI xxsms;
	
	@Autowired
	private HandsetServiceI handsetService;
	//查找一笔记录
	public HunnintuView getHviewById(Integer id) {
		return hntview.get(HunnintuView.class, id);
	}
	
	//获取拌和站字段是否显示,并设置默认值
	public HntbhzziduancfgEntity hntisshowcfgBybh(String gprsbh) {
		HntbhzziduancfgEntity hcfg = topmaxhnt.findByGprsbhandleixin1(gprsbh, "2");	
		if (null == hcfg) {
			hcfg = topmaxhnt.findByGprsbhandleixin1("all", "101");
			if (null == hcfg) {
				HntbhzziduancfgEntity hbisshow = getDefaultziduanshow();
				hbisshow.setGprsbianhao("all");
				hbisshow.setLeixin("101");				
				hntzdcfg.save(hbisshow);
				hcfg = hbisshow;
			}
		}
		return hcfg;
	}
	
	public HntbhzziduancfgEntity getDefaultziduanshow() {
		HntbhzziduancfgEntity hbisshow = new HntbhzziduancfgEntity();
		hbisshow.setShui1_shijizhi("1");
		hbisshow.setShui1_lilunzhi("0");
		hbisshow.setShui2_shijizhi("0");
		hbisshow.setShui2_lilunzhi("0");
		hbisshow.setShuini1_shijizhi("1");
		hbisshow.setShuini1_lilunzhi("0");
		hbisshow.setShuini2_shijizhi("1");
		hbisshow.setShuini2_lilunzhi("0");
		hbisshow.setKuangfen3_shijizhi("1");
		hbisshow.setKuangfen3_lilunzhi("0");
		hbisshow.setFeimeihui4_shijizhi("1");
		hbisshow.setFeimeihui4_lilunzhi("0");
		hbisshow.setFenliao5_shijizhi("0");
		hbisshow.setFenliao5_lilunzhi("0");
		hbisshow.setFenliao6_shijizhi("0");
		hbisshow.setFenliao6_lilunzhi("0");
		hbisshow.setSha1_shijizhi("1");
		hbisshow.setSha1_lilunzhi("0");
		hbisshow.setShi1_shijizhi("1");
		hbisshow.setShi1_lilunzhi("0");
		hbisshow.setShi2_shijizhi("1");
		hbisshow.setShi2_lilunzhi("0");
		hbisshow.setSha2_shijizhi("1");
		hbisshow.setSha2_lilunzhi("0");
		hbisshow.setGuliao5_shijizhi("0");
		hbisshow.setGuliao5_lilunzhi("0");
		hbisshow.setWaijiaji1_shijizhi("1");
		hbisshow.setWaijiaji1_lilunzhi("0");
		hbisshow.setWaijiaji2_shijizhi("0");
		hbisshow.setWaijiaji2_lilunzhi("0");
		hbisshow.setWaijiaji3_shijizhi("0");
		hbisshow.setWaijiaji3_lilunzhi("0");
		hbisshow.setWaijiaji4_shijizhi("0");
		hbisshow.setWaijiaji4_lilunzhi("0");				
		hbisshow.setGongdanhao("0");
		hbisshow.setChaozuozhe("0");
		hbisshow.setChuliaoshijian("0");
		hbisshow.setGongchengmingcheng("1");
		hbisshow.setSigongdidian("0");
		hbisshow.setJiaozuobuwei("1");
		hbisshow.setShuinipingzhong("0");
		hbisshow.setWaijiajipingzhong("0");
		hbisshow.setPeifanghao("0");
		hbisshow.setQiangdudengji("1");
		hbisshow.setJiaobanshijian("0");
		hbisshow.setShebeibianhao("0");
		hbisshow.setBaocunshijian("1");
		hbisshow.setCaijishijian("0");
		hbisshow.setGujifangshu("1");
		return hbisshow;
	}
	
	public XiangxixxsmsEntity getXxsmsbybh(String shebeibianhao) {
		List hlist = xxsms.findHql("from XiangxixxsmsEntity where shebeibianhao=?", shebeibianhao);
		if (hlist.size()>0) {
			return (XiangxixxsmsEntity) hlist.get(0);
		} else {
			return null;
		}	
	}
	
	public HandsetEntity getRealPhoneNumber(String phoneNo) {
		HandsetEntity hs=null;
		if (StringUtil.Null2Blank(phoneNo).length()>0 && 
				StringUtil.Null2Blank(phoneNo).length()<10 && 
				  phoneNo.matches("[0-9]{1,}")) {
			try {
				 hs = handsetService.get(HandsetEntity.class,Integer.parseInt(phoneNo));
			} catch (Exception e) {
			}
		}
		return hs;
	}
}
