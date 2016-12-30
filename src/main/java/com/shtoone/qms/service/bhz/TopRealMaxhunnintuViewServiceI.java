package com.shtoone.qms.service.bhz;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import com.shtoone.qms.entity.bhz.HntbhzziduancfgEntity;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.entity.bhz.HntviewEntity;
import com.shtoone.qms.entity.bhz.TopRealMaxhunnintuViewEntity;

public interface TopRealMaxhunnintuViewServiceI extends CommonService{
	public HntbhzziduancfgViewEntity hntfieldnamefindBybh(String gprsbh);
	public HntbhzziduancfgEntity hntissmsfindBybh(String gprsbh, boolean setdefault);
	public HntbhzziduancfgEntity hntsmslowfindBybh(String gprsbh, boolean setdefault);
	public HntbhzziduancfgEntity hntsmshighfindBybh(String gprsbh, boolean setdefault);
	public HntbhzziduancfgEntity hntsmsnumberfindBybh(String gprsbh);
	public HntbhzziduancfgEntity hntsmscontentfindBybh(String gprsbh);
	public HntbhzziduancfgEntity hntsmsshejifindBybh(String gprsbh, boolean setdefault);
	public HntbhzziduancfgEntity hntsmsshejifindBybh2(String gprsbh, boolean setdefault);
	public HntbhzziduancfgEntity hntsmslowfindBybh2(String gprsbh, boolean setdefault);
	public HntbhzziduancfgEntity hntsmshighfindBybh2(String gprsbh, boolean setdefault);
	public HntbhzziduancfgEntity hntsmsnumberfindBybh2(String gprsbh);
	public HntbhzziduancfgEntity hntsmslowfindBybh3(String gprsbh, boolean setdefault);
	public HntbhzziduancfgEntity hntsmshighfindBybh3(String gprsbh, boolean setdefault);
	public HntbhzziduancfgEntity hntsmsnumberfindBybh3(String gprsbh);
	public String delByGprsbhandleixin(String gprsbh, Integer leixinstart,Integer leixinend);

	public HntbhzziduancfgEntity getDefaultziduancfg();
	public HntbhzziduancfgEntity getDefaultziduanshow();
	public HntbhzziduancfgEntity hntfieldnameBybh(String gprsbh);
	public HntbhzziduancfgEntity hntisshowcfgBybh(String gprsbh);
	public HntbhzziduancfgEntity hntisshowcfgBybhDEL(String gprsbh);

	public TopRealMaxhunnintuViewEntity findTop();
	
	public HntviewEntity getHviewById(Integer curbianhao);
	
	public HntbhzziduancfgEntity findByGprsbhandleixin1(String gprsbh, String leixin);
	
	public JSONObject getDatagrid3(TopRealMaxhunnintuViewEntity pageObj, DataGrid dataGrid,
			String departid,String shebeibianhao, String userlft, String userrgt);

}
