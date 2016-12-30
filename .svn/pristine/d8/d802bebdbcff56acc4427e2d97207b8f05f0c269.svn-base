package com.shtoone.qms.service.bhz;

import java.util.List;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;



//import com.mss.shtoone.domain.HunnintuView;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgViewEntity;
import com.shtoone.qms.entity.bhz.HntviewEntity;
import com.shtoone.qms.entity.bhz.HunnintuView;

public interface MaterialServiceI extends CommonService{	
	//public void getDatagrid1(HntsclhsEntity pageObj, DataGrid dataGrid);
	//public void getDatagrid2(HntsclhsEntity pageObj, DataGrid dataGrid);
	public JSONObject materiallist(String gongchengmingcheng,String jiaozuobuwei,String qiangdudengji,String startTime,String endTime,Integer userlft,Integer userrgt,DataGrid dataGrid,String shebeibianhao);
	public String gethntmaterialhsXml(JSONObject jObject, HntbhzziduancfgViewEntity hbfield);
	public HntbhzziduancfgViewEntity hntfieldnamefindBybh(String gprsbh);
}