package com.shtoone.qms.service.impl.bhz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.entity.bhz.BanhezhanxinxiEntity;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgEntity;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.entity.bhz.HntviewEntity;
import com.shtoone.qms.service.bhz.HntbhzziduancfgServiceI;
import com.shtoone.qms.entity.bhz.TopRealMaxhunnintuViewEntity;
import com.shtoone.qms.service.bhz.HntbhzziduancfgViewServiceI;
import com.shtoone.qms.service.bhz.TopRealMaxhunnintuViewServiceI;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl.Db2Page;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.demo.service.test.JeecgJdbcServiceI;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.impl.SystemServiceImpl;

@Service("topRealMaxhunnintuViewService")
@Transactional
public class TopRealMaxhunnintuViewServiceImpl extends CommonServiceImpl implements TopRealMaxhunnintuViewServiceI {
	
	@Autowired
	private JdbcDao jdbcDao;
	@Autowired
	private HntbhzziduancfgServiceI hntbhzziduancfgService;
	
	@Autowired
	private HntbhzziduancfgViewServiceI hntbhzziduancfgViewService;
	
	// 方式3, 取值进一步自己处理(直接转换成easyUI的datagrid需要的东西，执行效率最高，最自由)  -------------------------------	
		public JSONObject getDatagrid3(TopRealMaxhunnintuViewEntity pageObj, DataGrid dataGrid,
				String departid,String shebeibianhao, String userlft, String userrgt) {
			
			StringBuilder queryCondition = new StringBuilder("");
			queryCondition.append(" 1=1 ");
//			if(StringUtil.isNotEmpty(departid)){
//				queryCondition.append(" and departid='"+departid+"'");
//			}
			
			if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
				queryCondition.append(" and lft >= '"+userlft
						+"' and rgt <= '" + userrgt + "'");
			}
			
			if(StringUtil.isNotEmpty(shebeibianhao)){
				queryCondition.append(" and shebeibianhao='"+shebeibianhao+"'");
			}
			
			// 取出总数据条数（为了分页处理, 如果不用分页，取iCount值的这个处理可以不要）
			String sqlCnt = "select count(*) from TopRealMaxhunnintuView t where"+queryCondition.toString();
			Long iCount = getCountForJdbcParam(sqlCnt, null);
			
			// 取出当前页的数据 
			StringBuffer sql = new StringBuffer();
			sql.append("select * from TopRealMaxhunnintuView t where"+queryCondition.toString());
			
			//System.out.println(sql.toString());
			List<Map<String, Object>> mapList = findForJdbc(sql.toString(), dataGrid.getPage(), dataGrid.getRows());
			//System.out.println(mapList.size());
			// 将结果集转换成页面上对应的数据集
			Db2Page[] db2Pages = {
					new Db2Page("id", "id"),
					// ,new Db2Page("quanju","全局")
					new Db2Page("departid", "departid"),
					new Db2Page("banhezhanminchen", "banhezhanminchen"),
					new Db2Page("shebeibianhao", "shebeibianhao"),
					new Db2Page("jianchen", "jianchen")
			};
			JSONObject jObject = getJsonDatagridEasyUI(mapList, iCount.intValue(), db2Pages);
			return jObject;
			// end of 方式3 ========================================= */
		}
			
		
		
	public HntbhzziduancfgViewEntity findByGprsbhandleixin(String gprsbh, String leixin) {
		String queryString = "select model.* from HntbhzziduancfgView as model where model.gprsbianhao='"+gprsbh+"' and model.leixin='"+leixin+"'";
		List<HntbhzziduancfgViewEntity> hlist =jdbcDao.find(queryString, HntbhzziduancfgViewEntity.class, new HashMap<String, String>());
		if (hlist.size()>0) {
			return hlist.get(0);
		} else {
			return null;
		}	
	}
	
	
	//获取拌和站字段名称
	public HntbhzziduancfgViewEntity hntfieldnamefindBybh(String gprsbh) {
		HntbhzziduancfgViewEntity hcfg =  findByGprsbhandleixin(gprsbh, "1");	
		if (null == hcfg) {
			hcfg = findByGprsbhandleixin("all", "100");
		}
		return hcfg;	
	}
	
	
	public HntbhzziduancfgEntity findByGprsbhandleixin1(String gprsbh, String leixin) {
		String queryString = "select * from Hntbhzziduancfg as model where model.gprsbianhao='"+gprsbh+"' and model.leixin='"+leixin+"'";
		List<HntbhzziduancfgEntity> hlist = jdbcDao.find(queryString, HntbhzziduancfgEntity.class, new HashMap<String, String>());
		if (hlist.size()>0) {
			return hlist.get(0);
		} else {
			return null;
		}	
	}
	
	public void setDefaultissmscfg(HntbhzziduancfgEntity hbissmscfg) {
		hbissmscfg.setShui1_shijizhi("1");
		hbissmscfg.setShuini1_shijizhi("1");
		hbissmscfg.setShuini2_shijizhi("1");
		hbissmscfg.setKuangfen3_shijizhi("1");
		hbissmscfg.setFeimeihui4_shijizhi("1");
		hbissmscfg.setSha1_shijizhi("1");
		hbissmscfg.setShi1_shijizhi("1");
		hbissmscfg.setShi2_shijizhi("1");
		hbissmscfg.setSha2_shijizhi("1");
		hbissmscfg.setWaijiaji1_shijizhi("1");
	}
	
	//获取拌和站字段是否短信报警
	public HntbhzziduancfgEntity hntissmsfindBybh(String gprsbh, boolean setdefault) {
		HntbhzziduancfgEntity issmscfg =findByGprsbhandleixin1(gprsbh, "4");
		if (null == issmscfg) {
			issmscfg = new HntbhzziduancfgEntity();
			issmscfg.setGprsbianhao(gprsbh);
			issmscfg.setLeixin("4");
			setDefaultissmscfg(issmscfg);
		} else if (setdefault) {
			setDefaultissmscfg(issmscfg);
		}
		return issmscfg;
	}
	
	public void setDefaultsmslowcfg(HntbhzziduancfgEntity hbsmslowcfg) {
		hbsmslowcfg.setJiaobanshijian("10");
		hbsmslowcfg.setShui1_shijizhi("1");
		hbsmslowcfg.setShui2_shijizhi("1");
		hbsmslowcfg.setShuini1_shijizhi("1");
		hbsmslowcfg.setShuini2_shijizhi("1");
		hbsmslowcfg.setKuangfen3_shijizhi("1");
		hbsmslowcfg.setFeimeihui4_shijizhi("1");
		hbsmslowcfg.setFenliao5_shijizhi("1");
		hbsmslowcfg.setFenliao6_shijizhi("1");
		hbsmslowcfg.setSha1_shijizhi("2");
		hbsmslowcfg.setShi1_shijizhi("2");
		hbsmslowcfg.setShi2_shijizhi("2");
		hbsmslowcfg.setSha2_shijizhi("2");
		hbsmslowcfg.setGuliao5_shijizhi("2");
		hbsmslowcfg.setWaijiaji1_shijizhi("1");
		hbsmslowcfg.setWaijiaji2_shijizhi("1");
		hbsmslowcfg.setWaijiaji3_shijizhi("1");
		hbsmslowcfg.setWaijiaji4_shijizhi("1");
	}
	
	
	//获取拌和站字段短信报警下限
	public HntbhzziduancfgEntity hntsmslowfindBybh(String gprsbh, boolean setdefault) {
		HntbhzziduancfgEntity smslowcfg = findByGprsbhandleixin1(gprsbh, "5");
		if (null == smslowcfg) {
			smslowcfg = new HntbhzziduancfgEntity();
			smslowcfg.setLeixin("5");
			smslowcfg.setGprsbianhao(gprsbh);
			setDefaultsmslowcfg(smslowcfg);
		} else if (setdefault) {
			setDefaultsmslowcfg(smslowcfg);
		}
		return smslowcfg;
	}
	
	public void setDefaultsmshighcfg(HntbhzziduancfgEntity hbsmshighcfg) {
		hbsmshighcfg.setShui1_shijizhi("1");
		hbsmshighcfg.setShui2_shijizhi("1");
		hbsmshighcfg.setShuini1_shijizhi("1");
		hbsmshighcfg.setShuini2_shijizhi("1");
		hbsmshighcfg.setKuangfen3_shijizhi("1");
		hbsmshighcfg.setFeimeihui4_shijizhi("1");
		hbsmshighcfg.setFenliao5_shijizhi("1");
		hbsmshighcfg.setFenliao6_shijizhi("1");
		hbsmshighcfg.setSha1_shijizhi("2");
		hbsmshighcfg.setShi1_shijizhi("2");
		hbsmshighcfg.setShi2_shijizhi("2");
		hbsmshighcfg.setSha2_shijizhi("2");
		hbsmshighcfg.setGuliao5_shijizhi("2");
		hbsmshighcfg.setWaijiaji1_shijizhi("1");
		hbsmshighcfg.setWaijiaji2_shijizhi("1");
		hbsmshighcfg.setWaijiaji3_shijizhi("1");
		hbsmshighcfg.setWaijiaji4_shijizhi("1");
	}
	
	//获取拌和站字段短信报警上限
	public HntbhzziduancfgEntity hntsmshighfindBybh(String gprsbh, boolean setdefault) {
		HntbhzziduancfgEntity smshighcfg = findByGprsbhandleixin1(gprsbh, "6");
		if (null == smshighcfg) {
			smshighcfg = new HntbhzziduancfgEntity();
			smshighcfg.setLeixin("6");
			smshighcfg.setGprsbianhao(gprsbh);
			setDefaultsmshighcfg(smshighcfg);
		} else if (setdefault) {
			setDefaultsmshighcfg(smshighcfg);
		}
		return smshighcfg;
	}
	
	//获取拌和站字段短信报警手机号码
	public HntbhzziduancfgEntity hntsmsnumberfindBybh(String gprsbh) {
		HntbhzziduancfgEntity smsnumber =  findByGprsbhandleixin1(gprsbh, "7");	
		if (null == smsnumber) {
			smsnumber = new HntbhzziduancfgEntity();
		}
		return smsnumber;
	}
	
	//获取拌和站字段短信报警内容格式
	public HntbhzziduancfgEntity hntsmscontentfindBybh(String gprsbh) {
		HntbhzziduancfgEntity smscontent = findByGprsbhandleixin1(gprsbh, "8");
		if (null == smscontent) {
			smscontent = new HntbhzziduancfgEntity();
		}
		return smscontent;
	}
	
	public void setDefaultsmsshejicfg(HntbhzziduancfgEntity hbsmsshejicfg) {
		hbsmsshejicfg.setJiaobanshijian("90");
	}
	
	//获取拌和站字段短信报警设计值
	public HntbhzziduancfgEntity hntsmsshejifindBybh(String gprsbh, boolean setdefault) {
		HntbhzziduancfgEntity smsshejicfg = findByGprsbhandleixin1(gprsbh, "9");
		if (null == smsshejicfg) {
			smsshejicfg =new HntbhzziduancfgEntity();
			smsshejicfg.setLeixin("9");
			smsshejicfg.setGprsbianhao(gprsbh);
			setDefaultsmsshejicfg(smsshejicfg);
		} else if (setdefault) {
			setDefaultsmsshejicfg(smsshejicfg);
		}
		return smsshejicfg;
	}
	
	public void setDefaultsmsshejicfg2(HntbhzziduancfgEntity  hbsmsshejicfg2) {
		hbsmsshejicfg2.setJiaobanshijian("60");
	}
	
	//获取拌和站字段短信报警设计值2
	public HntbhzziduancfgEntity hntsmsshejifindBybh2(String gprsbh, boolean setdefault) {
		HntbhzziduancfgEntity smsshejicfg2 = findByGprsbhandleixin1(gprsbh, "16");
		if (null == smsshejicfg2) {
			smsshejicfg2 = new HntbhzziduancfgEntity();
			smsshejicfg2.setLeixin("16");
			smsshejicfg2.setGprsbianhao(gprsbh);
			setDefaultsmsshejicfg2(smsshejicfg2);
		} else if (setdefault) {
			setDefaultsmsshejicfg2(smsshejicfg2);
		}
		return smsshejicfg2;
	}
	
	public void setDefaultsmslowcfg2(HntbhzziduancfgEntity hbsmslowcfg2) {
		hbsmslowcfg2.setJiaobanshijian("20");
		hbsmslowcfg2.setShui1_shijizhi("5");
		hbsmslowcfg2.setShui2_shijizhi("5");
		hbsmslowcfg2.setShuini1_shijizhi("5");
		hbsmslowcfg2.setShuini2_shijizhi("5");
		hbsmslowcfg2.setKuangfen3_shijizhi("5");
		hbsmslowcfg2.setFeimeihui4_shijizhi("5");
		hbsmslowcfg2.setFenliao5_shijizhi("5");
		hbsmslowcfg2.setFenliao6_shijizhi("5");
		hbsmslowcfg2.setSha1_shijizhi("5");
		hbsmslowcfg2.setShi1_shijizhi("5");
		hbsmslowcfg2.setShi2_shijizhi("5");
		hbsmslowcfg2.setSha2_shijizhi("5");
		hbsmslowcfg2.setGuliao5_shijizhi("5");
		hbsmslowcfg2.setWaijiaji1_shijizhi("5");
		hbsmslowcfg2.setWaijiaji2_shijizhi("5");
		hbsmslowcfg2.setWaijiaji3_shijizhi("5");
		hbsmslowcfg2.setWaijiaji4_shijizhi("5");
	}
	
	
	//获取拌和站字段短信报警下限2
		public HntbhzziduancfgEntity hntsmslowfindBybh2(String gprsbh, boolean setdefault) {
			HntbhzziduancfgEntity smslowcfg2 = findByGprsbhandleixin1(gprsbh, "10");
			if (null == smslowcfg2) {
				smslowcfg2 = new HntbhzziduancfgEntity();
				smslowcfg2.setLeixin("10");
				smslowcfg2.setGprsbianhao(gprsbh);
				setDefaultsmslowcfg2(smslowcfg2);
			} else if (setdefault) {
				setDefaultsmslowcfg2(smslowcfg2);
			}
			return smslowcfg2;
		}
		
		public void setDefaultsmshighcfg2(HntbhzziduancfgEntity hbsmshighcfg2 ) {
			hbsmshighcfg2.setShui1_shijizhi("5");
			hbsmshighcfg2.setShui2_shijizhi("5");
			hbsmshighcfg2.setShuini1_shijizhi("5");
			hbsmshighcfg2.setShuini2_shijizhi("5");
			hbsmshighcfg2.setKuangfen3_shijizhi("5");
			hbsmshighcfg2.setFeimeihui4_shijizhi("5");
			hbsmshighcfg2.setFenliao5_shijizhi("5");
			hbsmshighcfg2.setFenliao6_shijizhi("5");
			hbsmshighcfg2.setSha1_shijizhi("5");
			hbsmshighcfg2.setShi1_shijizhi("5");
			hbsmshighcfg2.setShi2_shijizhi("5");
			hbsmshighcfg2.setSha2_shijizhi("5");
			hbsmshighcfg2.setGuliao5_shijizhi("5");
			hbsmshighcfg2.setWaijiaji1_shijizhi("5");
			hbsmshighcfg2.setWaijiaji2_shijizhi("5");
			hbsmshighcfg2.setWaijiaji3_shijizhi("5");
			hbsmshighcfg2.setWaijiaji4_shijizhi("5");
		}
		
		//获取拌和站字段短信报警上限2
		public HntbhzziduancfgEntity hntsmshighfindBybh2(String gprsbh, boolean setdefault) {
			HntbhzziduancfgEntity smshighcfg2 = findByGprsbhandleixin1(gprsbh, "11");
			if (null == smshighcfg2) {
				smshighcfg2 = new HntbhzziduancfgEntity();
				smshighcfg2.setLeixin("11");
				smshighcfg2.setGprsbianhao(gprsbh);
				setDefaultsmshighcfg2(smshighcfg2);
			} else if (setdefault) {
				setDefaultsmshighcfg2(smshighcfg2);
			}
			return smshighcfg2;
		}
		
		//获取拌和站字段短信报警手机号码2
		public HntbhzziduancfgEntity hntsmsnumberfindBybh2(String gprsbh) {
			HntbhzziduancfgEntity smsnumber2 =  findByGprsbhandleixin1(gprsbh, "12");	
			if (null == smsnumber2) {
				smsnumber2 = new HntbhzziduancfgEntity();
			}
			return smsnumber2;
		}
		
		public void setDefaultsmslowcfg3(HntbhzziduancfgEntity hbsmslowcfg3) {
			hbsmslowcfg3.setJiaobanshijian("30");
			hbsmslowcfg3.setShui1_shijizhi("10");
			hbsmslowcfg3.setShui2_shijizhi("10");
			hbsmslowcfg3.setShuini1_shijizhi("10");
			hbsmslowcfg3.setShuini2_shijizhi("10");
			hbsmslowcfg3.setKuangfen3_shijizhi("10");
			hbsmslowcfg3.setFeimeihui4_shijizhi("10");
			hbsmslowcfg3.setFenliao5_shijizhi("10");
			hbsmslowcfg3.setFenliao6_shijizhi("10");
			hbsmslowcfg3.setSha1_shijizhi("10");
			hbsmslowcfg3.setShi1_shijizhi("10");
			hbsmslowcfg3.setShi2_shijizhi("10");
			hbsmslowcfg3.setSha2_shijizhi("10");
			hbsmslowcfg3.setGuliao5_shijizhi("10");
			hbsmslowcfg3.setWaijiaji1_shijizhi("10");
			hbsmslowcfg3.setWaijiaji2_shijizhi("10");
			hbsmslowcfg3.setWaijiaji3_shijizhi("10");
			hbsmslowcfg3.setWaijiaji4_shijizhi("10");
		}
		
		public void setDefaultsmslowcfg4(HntbhzziduancfgEntity hbsmslowcfg4) {
			hbsmslowcfg4.setJiaobanshijian("40");
			hbsmslowcfg4.setShui1_shijizhi("20");
			hbsmslowcfg4.setShui2_shijizhi("20");
			hbsmslowcfg4.setShuini1_shijizhi("20");
			hbsmslowcfg4.setShuini2_shijizhi("20");
			hbsmslowcfg4.setKuangfen3_shijizhi("20");
			hbsmslowcfg4.setFeimeihui4_shijizhi("20");
			hbsmslowcfg4.setFenliao5_shijizhi("20");
			hbsmslowcfg4.setFenliao6_shijizhi("20");
			hbsmslowcfg4.setSha1_shijizhi("20");
			hbsmslowcfg4.setShi1_shijizhi("20");
			hbsmslowcfg4.setShi2_shijizhi("20");
			hbsmslowcfg4.setSha2_shijizhi("20");
			hbsmslowcfg4.setGuliao5_shijizhi("20");
			hbsmslowcfg4.setWaijiaji1_shijizhi("20");
			hbsmslowcfg4.setWaijiaji2_shijizhi("20");
			hbsmslowcfg4.setWaijiaji3_shijizhi("20");
			hbsmslowcfg4.setWaijiaji4_shijizhi("20");
		}
		
		
		//获取拌和站字段短信报警下限3
		public HntbhzziduancfgEntity hntsmslowfindBybh3(String gprsbh, boolean setdefault) {
			HntbhzziduancfgEntity smslowcfg3 = findByGprsbhandleixin1(gprsbh, "13");
			if (null == smslowcfg3) {
				smslowcfg3 = new HntbhzziduancfgEntity();
				smslowcfg3.setLeixin("13");
				smslowcfg3.setGprsbianhao(gprsbh);
				setDefaultsmslowcfg3(smslowcfg3);
			} else if (setdefault) {
				setDefaultsmslowcfg3(smslowcfg3);
			}
			return smslowcfg3;
		}
		
		
		public void setDefaultsmshighcfg3(HntbhzziduancfgEntity hbsmshighcfg3) {
			hbsmshighcfg3.setShui1_shijizhi("10");
			hbsmshighcfg3.setShui2_shijizhi("10");
			hbsmshighcfg3.setShuini1_shijizhi("10");
			hbsmshighcfg3.setShuini2_shijizhi("10");
			hbsmshighcfg3.setKuangfen3_shijizhi("10");
			hbsmshighcfg3.setFeimeihui4_shijizhi("10");
			hbsmshighcfg3.setFenliao5_shijizhi("10");
			hbsmshighcfg3.setFenliao6_shijizhi("10");
			hbsmshighcfg3.setSha1_shijizhi("10");
			hbsmshighcfg3.setShi1_shijizhi("10");
			hbsmshighcfg3.setShi2_shijizhi("10");
			hbsmshighcfg3.setSha2_shijizhi("10");
			hbsmshighcfg3.setGuliao5_shijizhi("10");
			hbsmshighcfg3.setWaijiaji1_shijizhi("10");
			hbsmshighcfg3.setWaijiaji2_shijizhi("10");
			hbsmshighcfg3.setWaijiaji3_shijizhi("10");
			hbsmshighcfg3.setWaijiaji4_shijizhi("10");
		}
		
		public void setDefaultsmshighcfg4(HntbhzziduancfgEntity hbsmshighcfg4) {
			hbsmshighcfg4.setShui1_shijizhi("20");
			hbsmshighcfg4.setShui2_shijizhi("20");
			hbsmshighcfg4.setShuini1_shijizhi("20");
			hbsmshighcfg4.setShuini2_shijizhi("20");
			hbsmshighcfg4.setKuangfen3_shijizhi("20");
			hbsmshighcfg4.setFeimeihui4_shijizhi("20");
			hbsmshighcfg4.setFenliao5_shijizhi("20");
			hbsmshighcfg4.setFenliao6_shijizhi("20");
			hbsmshighcfg4.setSha1_shijizhi("20");
			hbsmshighcfg4.setShi1_shijizhi("20");
			hbsmshighcfg4.setShi2_shijizhi("20");
			hbsmshighcfg4.setSha2_shijizhi("20");
			hbsmshighcfg4.setGuliao5_shijizhi("20");
			hbsmshighcfg4.setWaijiaji1_shijizhi("20");
			hbsmshighcfg4.setWaijiaji2_shijizhi("20");
			hbsmshighcfg4.setWaijiaji3_shijizhi("20");
			hbsmshighcfg4.setWaijiaji4_shijizhi("20");
		}
		
		//获取拌和站字段短信报警上限3
		public HntbhzziduancfgEntity hntsmshighfindBybh3(String gprsbh, boolean setdefault) {
			HntbhzziduancfgEntity smshighcfg3 = findByGprsbhandleixin1(gprsbh, "14");
			if (null == smshighcfg3) {
				smshighcfg3 = new HntbhzziduancfgEntity();
				smshighcfg3.setLeixin("14");
				smshighcfg3.setGprsbianhao(gprsbh);
				setDefaultsmshighcfg3(smshighcfg3);
			} else if (setdefault) {
				setDefaultsmshighcfg3(smshighcfg3);
			}
			return smshighcfg3;
		}
		
		//获取拌和站字段短信报警手机号码3
		public HntbhzziduancfgEntity hntsmsnumberfindBybh3(String gprsbh) {
			HntbhzziduancfgEntity smsnumber3 =  findByGprsbhandleixin1(gprsbh, "15");	
			if (null == smsnumber3) {
				smsnumber3 = new HntbhzziduancfgEntity();
			}
			return smsnumber3;
		}
		
		
		public String delByGprsbhandleixin(String gprsbh, Integer leixinstart,Integer leixinend) {
			try{
			String queryString = "delete from Hntbhzziduancfg where gprsbianhao='"+gprsbh+"' and leixin>="+leixinstart+" and leixin<="+leixinend;
			Integer temp=jdbcDao.executeSql(queryString, new Object[]{});
			return temp+"";
			}catch(Exception e){}
			return null;
		}
		
		public TopRealMaxhunnintuViewEntity findTop() {
			String queryString = "from TopRealMaxhunnintuViewEntity as model  Order By id DESC ";
			List<TopRealMaxhunnintuViewEntity> topmaxhntlist= this.findHql(queryString);
			if (topmaxhntlist.size() > 0) {
				TopRealMaxhunnintuViewEntity topmaxhnt = topmaxhntlist.get(0);
				return topmaxhnt;
			} else 
			return null;
		}	
		

		public HntbhzziduancfgEntity getDefaultziduancfg() {
			HntbhzziduancfgEntity hbfield = new HntbhzziduancfgEntity();
			hbfield.setShui1_shijizhi("水");
			hbfield.setShui1_lilunzhi("水(施工)");
			hbfield.setShui2_shijizhi("水2");
			hbfield.setShui2_lilunzhi("水2(施工)");
			hbfield.setShuini1_shijizhi("水泥1");
			hbfield.setShuini1_lilunzhi("水泥1(施工)");
			hbfield.setShuini2_shijizhi("水泥2");
			hbfield.setShuini2_lilunzhi("水泥2(施工)");
			hbfield.setKuangfen3_shijizhi("矿粉");
			hbfield.setKuangfen3_lilunzhi("矿粉(施工)");
			hbfield.setFeimeihui4_shijizhi("煤灰");
			hbfield.setFeimeihui4_lilunzhi("煤灰(施工)");
			hbfield.setFenliao5_shijizhi("粉料5");
			hbfield.setFenliao5_lilunzhi("粉料5(施工)");
			hbfield.setFenliao6_shijizhi("粉料6");
			hbfield.setFenliao6_lilunzhi("粉料6(施工)");
			hbfield.setSha1_shijizhi("砂1");
			hbfield.setSha1_lilunzhi("砂1(施工)");
			hbfield.setShi1_shijizhi("砂2");
			hbfield.setShi1_lilunzhi("砂2(施工)");
			hbfield.setShi2_shijizhi("碎石1");
			hbfield.setShi2_lilunzhi("碎石1(施工)");
			hbfield.setSha2_shijizhi("碎石2");
			hbfield.setSha2_lilunzhi("碎石2(施工)");
			hbfield.setGuliao5_shijizhi("碎石3");
			hbfield.setGuliao5_lilunzhi("碎石3(施工)");
			hbfield.setWaijiaji1_shijizhi("减水剂1");
			hbfield.setWaijiaji1_lilunzhi("减水剂1(施工)");
			hbfield.setWaijiaji2_shijizhi("减水剂2");
			hbfield.setWaijiaji2_lilunzhi("减水剂2(施工)");
			hbfield.setWaijiaji3_shijizhi("外加剂3");
			hbfield.setWaijiaji3_lilunzhi("外加剂3(施工)");
			hbfield.setWaijiaji4_shijizhi("外加剂4");
			hbfield.setWaijiaji4_lilunzhi("外加剂4(施工)");				
			hbfield.setGongdanhao("工单号");
			hbfield.setChaozuozhe("操作者");
			hbfield.setChuliaoshijian("出料时间");
			hbfield.setGongchengmingcheng("工程名称");
			hbfield.setSigongdidian("地点/里程");
			hbfield.setJiaozuobuwei("浇筑部位");
			hbfield.setShuinipingzhong("水泥品种");
			hbfield.setWaijiajipingzhong("外加剂品种");
			hbfield.setPeifanghao("施工配合比编号");
			hbfield.setQiangdudengji("强度等级");
			hbfield.setJiaobanshijian("搅拌时间");
			hbfield.setShebeibianhao("设备编号");
			hbfield.setBaocunshijian("保存时间");
			hbfield.setCaijishijian("采集时间");
			hbfield.setGujifangshu("数量");
			return hbfield;
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
		
		//获取拌和站字段名称,并设置默认值
		public HntbhzziduancfgEntity hntfieldnameBybh(String gprsbh) {
			HntbhzziduancfgEntity hcfg =  findByGprsbhandleixin1(gprsbh, "1");	
			if (null == hcfg) {
				hcfg = findByGprsbhandleixin1("all", "100");
				if (null == hcfg) {
					HntbhzziduancfgEntity hbfield = getDefaultziduancfg();
					hbfield.setGprsbianhao("all");
					hbfield.setLeixin("100");				
					hntbhzziduancfgService.save(hbfield);
					hcfg = hbfield;
				}
			}
			return hcfg;
		}
		
		//获取拌和站字段是否显示,并设置默认值
		public HntbhzziduancfgEntity hntisshowcfgBybh(String gprsbh) {
			HntbhzziduancfgEntity hcfg = findByGprsbhandleixin1(gprsbh, "2");	
			if (null == hcfg) {
				hcfg = findByGprsbhandleixin1("all", "101");
				if (null == hcfg) {
					HntbhzziduancfgEntity hbisshow = getDefaultziduanshow();
					hbisshow.setGprsbianhao("all");
					hbisshow.setLeixin("101");				
					hntbhzziduancfgService.save(hbisshow);
					hcfg = hbisshow;
				}
			}
			return hcfg;
		}
		
		
		public HntbhzziduancfgEntity hntisshowcfgBybhDEL(String gprsbh) {
			HntbhzziduancfgEntity hcfg = findByGprsbhandleixin1(gprsbh, "2");
			return hcfg;
		}



		
		public HntviewEntity getHviewById(Integer curbianhao) {
			String queryString = "select * from Hntview as model where model.id='"+curbianhao+"' and (model.gprsbianhao='gzgshnt10_01_02' or model.gprsbianhao='gzgshnt10_01_01')";
			List<HntviewEntity> hlist = jdbcDao.find(queryString, HntviewEntity.class, new HashMap<String, String>());
			if (hlist!=null) {
				if(hlist.size()>0){
					return hlist.get(0);
				}else{
					return null;
				}
			} else {
				return null;
			}	
		}
		
		
		
}