package com.shtoone.qms.app.service;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.shtoone.qms.app.entity.AppHntSysHPData;
import com.shtoone.qms.app.entity.AppSyTypeBean;
import com.shtoone.qms.app.entity.HntkangyaWarnBean;
import com.shtoone.qms.app.entity.ShebeiListBean;
import com.shtoone.qms.app.entity.SysCountAnalyze;
import com.shtoone.qms.app.entity.SysCountBean;
import com.shtoone.qms.app.entity.SysMainLogoBean;
import com.shtoone.qms.app.entity.SysWNJDetailBean;
import com.shtoone.qms.app.entity.SysWNJlistBean;
import com.shtoone.qms.app.entity.SysYLJDetailBean;
import com.shtoone.qms.app.entity.SysYLJlistBean;

public interface SysInterfaceService extends CommonService{
	//得到试验室的主页
	//public List<SysCountBean> getSysHome(String lft,String rgt,String startTime,String endTime);
	
	//得到试验室的主页
	public List<SysCountBean> getSysHome(Integer lft,Integer rgt,String startTime,String endTime);
		
	//混凝土试件抗压强度试验
	public List<SysYLJlistBean> hntkangyaSel(String lft,String rgt,String startTime,String endTime,String isQualited,Integer pageNo,Integer maxPageItems,String shebeibianhao,String isReal,String testType);
	//钢筋试验
	public List<SysWNJlistBean> gangjinSel(String lft,String rgt,String startTime,String endTime,String isQualited,Integer pageNo,Integer maxPageItems,String shebeibianhao,String isReal,String testType);
	//钢筋焊接接头试验
	public List<SysWNJlistBean> gangjinhanjiejietouSel(String lft,String rgt,String startTime,String endTime,String isQualited,Integer pageNo,Integer maxPageItems,String shebeibianhao,String isReal,String testType);
	//钢筋机械连接接头试验
	public List<SysWNJlistBean> gangjinlianjiejietouSel(String lft,String rgt,String startTime,String endTime,String isQualited,Integer pageNo,Integer maxPageItems,String shebeibianhao,String isReal,String testType);	
	//混凝土试件抗压强度试验详情
	public SysYLJDetailBean hntkangyaDetail(String SYJID);
	//钢筋试验详情
	public SysWNJDetailBean gangjinDetail(String SYJID);
	//钢筋焊接接头试验详情
	public SysWNJDetailBean gangjinhanjiejietouDetail(String SYJID);
	//钢筋机械连接接头试验详情
	public SysWNJDetailBean gangjinlianjiejietouDetail(String SYJID);
	//混凝土试件抗压强度试验过期试验提醒
	public List<HntkangyaWarnBean> hntkangyaWarinSel(String lft,String rgt,String startTime,String endTime,String isQualified,String shebeibianhao);
	//试验室主界面Logo
	public SysMainLogoBean sysMainLogo(String lft,String rgt);
	//试验室统分
	public List<SysCountAnalyze> SysCountAnalyze(String lft,String rgt,String startTime,String endTime);
	//试验室的设备列表
	public List<ShebeiListBean> getSysShebeiList(String lft,String rgt);
	
	//试验室试件类型
	public List<AppSyTypeBean> shijianType(String testtype);
	
	//试验室试件类型 all
	public void SyType(List<AppSyTypeBean> wnj,List<AppSyTypeBean> ylj);
	
	//试验室的设备列表 all
	public void SyMac(List<ShebeiListBean> sb1,List<ShebeiListBean> sb2,String lft,String rgt);
	
	/**
	 * 混凝土试验室主页数据		(New)
	 * @param userlft
	 * @param userrgt
	 * @return
	 */
	public AppHntSysHPData hntSysMainLogo(Integer userlft,Integer userrgt);
	
}
