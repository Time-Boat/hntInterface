package com.shtoone.qms.app.service;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.shtoone.qms.app.entity.AppHunnintuView;
import com.shtoone.qms.app.entity.BHZ_SCSJData_Item;
import com.shtoone.qms.app.entity.HntCountAnalyze;
import com.shtoone.qms.app.entity.HntMain;
import com.shtoone.qms.app.entity.HntMainLogoBean;
import com.shtoone.qms.app.entity.ShebeiListBean;
import com.shtoone.qms.app.entity.AppHntBanhejiState;
import com.shtoone.qms.app.entity.AppHntHomePageData;
import com.shtoone.qms.app.entity.AppHntSysHPData;
import com.shtoone.qms.entity.bhz.BanhezhanxinxiEntity;
import com.shtoone.qms.entity.bhz.DepartMappingEntity;
import com.shtoone.qms.entity.bhz.HntviewEntity;
import com.shtoone.qms.entity.bhz.HunnintuView;
import com.shtoone.qms.entity.bhz.HunnintuchaobiaoViewEntity;
import com.shtoone.qms.entity.bhz.HunnintujieguoViewEntity;
import com.shtoone.qms.entity.bhz.Lilunpeibixixx;
import com.shtoone.qms.entity.bhz.SYclAllEntity;
import com.shtoone.qms.entity.bhz.Shigongpeibixixx;
import com.shtoone.qms.entity.bhz.V_SYJZBNEntity;
import com.shtoone.qms.entity.bhz.V_ShiyanshiInfoEntity;
import com.shtoone.qms.entity.bhz.V_YalijiNEntity;
import com.shtoone.qms.entity.bhz.XiangxixxjieguoEntity;


public interface AppInterfaceService extends CommonService{
	public HntviewEntity findonexx();
	public void updxxbyid( Integer id,String biaoshi);
	public HunnintujieguoViewEntity findjieguo();
	public void updjieguobyid( Integer id,String biaoshi);
	public HunnintujieguoViewEntity findchuzhi();
	public XiangxixxjieguoEntity findchuzhibyid( Integer id);
	public void updchuzhibyid( Integer id,Integer biaoshi);
	public Lilunpeibixixx findllphb();
	public V_ShiyanshiInfoEntity findShiyanshiInfobyid( String shiyanshi_guid);
	public void updllphbbyid( String id,Integer biaoshi);
	public Shigongpeibixixx findsjphb();
	public void updsjphbbyid( String id,Integer biaoshi);
	public SYclAllEntity findycl();
	public DepartMappingEntity findDepartMapping( String departid);
	public void updyclbyid( String id,Integer biaoshi);
	public V_SYJZBNEntity findsys();
	public void updsysbyid( String id,Integer biaoshi);
	public V_YalijiNEntity findsysgc();
	public void updsysgcbyid( String id,Integer biaoshi);
	public Integer deletejjgroup();
	
	//获取组织机构的最新修改时间
	public String getUpdateDepartTime();
	/**
	 * 获取指定组织机构下的拌和机信息
	 * @param bhjtype 1:水泥混凝土 2：沥青混凝土 3：万能机 4：压力机
	 * @param userlft
	 * @param userrgt
	 * @return
	 */
	public Integer getBanhejiCount(Integer bhjtype,Integer userlft, Integer userrgt);
	public Integer getBanhezhanCount(Integer bhztype,Integer userlft, Integer userrgt);
	public List<BanhezhanxinxiEntity> getBanhejiList(Integer bhjtype,Integer userlft, Integer userrgt,String startTime,String endTime,Integer bhztype);
	
	/**
	 * 统计指定机构的生产及超标信息
	 * @param lft
	 * @param rgt
	 * @return
	 */
	public HntMain getHntMainObj(Integer lft,Integer rgt,String startTime,String endTime,String shebeibianhao);
	
	/**
	 * 获取混凝土详细信息列表
	 * @param startTime
	 * @param endTime
	 * @param userlft
	 * @param userrgt
	 * @param jiaozuobuwei
	 * @param gongchengmingcheng
	 * @param shebeibianhao
	 * @param pageNo
	 * @param maxPageItems
	 * @return
	 */
	public List<BHZ_SCSJData_Item> AppHntXiangxiList(String startTime, String endTime,
			Integer userlft, Integer userrgt, String jiaozhubuwei,
			String gongchengmincheng,String shebeibianhao,Integer pageNo, Integer maxPageItems);
	
	/**
	 * 获取混凝土超标列表
	 * @param departid
	 * @param startTime
	 * @param endTime
	 * @param leixing
	 * @param chulijieguoType
	 * @param gongchengmingcheng
	 * @param jiaozuobuwei
	 * @param shebeibianhao
	 * @param xinxibianhao
	 * @param userlft
	 * @param userrgt
	 * @param pageNo
	 * @param maxPageItems
	 * @return
	 */
	public List<BHZ_SCSJData_Item> AppHntjieguoList(String departid,String startTime,String endTime,String leixing,String chulijieguoType,
			String gongchengmingcheng,String jiaozuobuwei,String shebeibianhao,String xinxibianhao, Integer userlft, Integer userrgt,Integer pageNo,Integer maxPageItems);
	
	/**
	 * 获取拌和机状态列表
	 * @param departid
	 * @param shebeibianhao
	 * @param userlft
	 * @param userrgt
	 * @param startTime
	 * @param endTime
	 * @param pageNo
	 * @param maxPageItems
	 * @return
	 */
	public List<AppHntBanhejiState> AppHntBanhejiState(String shebeibianhao, Integer userlft, Integer userrgt,Integer pageNo,Integer maxPageItems,String state);
	
	/**
	 * 材料用量核算
	 * @param gongchengmingcheng
	 * @param jiaozuobuwei
	 * @param qiangdudengji
	 * @param startTime
	 * @param endTime
	 * @param userlft
	 * @param userrgt
	 * @param shebeibianhao
	 * @param pageNo
	 * @param maxPageItems
	 * @return
	 */
	public AppHunnintuView AppHntMaterial(String gongchengmingcheng,String jiaozuobuwei,String qiangdudengji,String startTime,String endTime,
			Integer userlft,Integer userrgt,String shebeibianhao,Integer pageNo,Integer maxPageItems);
	
	/**
	 * 混凝土主页logo
	 * @param userlft
	 * @param userrgt
	 * @return
	 */
	public HntMainLogoBean hntMainLogo(Integer userlft,Integer userrgt);
	
	/**
	 * 混凝土拌合站主页数据		(New)
	 * @param userlft
	 * @param userrgt
	 * @return
	 */
	public AppHntHomePageData hntBhzMainLogo(Integer userlft,Integer userrgt);
	
	/**
	 * 混凝土统计分析
	 * @param userlft
	 * @param userrgt
	 * @param startTime
	 * @param endTime
	 * @param shebeibianhao
	 * @param cllx
	 * @return
	 */
	public List<HntCountAnalyze> HntCountAnalyze(Integer userlft,Integer userrgt,String startTime,String endTime,String shebeibianhao,Integer cllx);
	
	/**
	 * 设备列表
	 * @param userlft
	 * @param userrgt
	 * @param shebeileixing
	 * @return
	 */
	public List<ShebeiListBean> getShebeilist(Integer userlft,Integer userrgt);
	
	//生产数据查询详情
	public HunnintuView getXiangxixxDetailById(Integer bianhao);
	
	//超标查询与处置详情
	public HunnintuchaobiaoViewEntity gethntchaobiaoDetailById(Integer bianhao);
}
