package com.shtoone.qms.service;

import java.util.Set;

import org.jeecgframework.core.common.service.CommonService;
import org.w3c.dom.Element;

import com.shtoone.qms.entity.bhz.BanhezhanxinxiEntity;
import com.shtoone.qms.entity.bhz.DepartMappingEntity;
import com.shtoone.qms.entity.bhz.HandsetEntity;
import com.shtoone.qms.entity.bhz.HntbhzziduancfgEntity;
import com.shtoone.qms.entity.bhz.HntviewEntity;
import com.shtoone.qms.entity.bhz.HunnintuView;
import com.shtoone.qms.entity.bhz.HunnintujieguoViewEntity;
import com.shtoone.qms.entity.bhz.Lilunpeibixixx;
import com.shtoone.qms.entity.bhz.SYclAllEntity;
import com.shtoone.qms.entity.bhz.Shigongpeibixixx;
import com.shtoone.qms.entity.bhz.V_SYJZBNEntity;
import com.shtoone.qms.entity.bhz.V_ShiyanshiInfoEntity;
import com.shtoone.qms.entity.bhz.V_YalijiNEntity;
import com.shtoone.qms.entity.bhz.XiangxixxEntity;
import com.shtoone.qms.entity.bhz.XiangxixxjieguoEntity;
import com.shtoone.qms.entity.bhz.XiangxixxsmsEntity;

/**
 * 
 * 
 *
 */
public interface InfService extends CommonService{
	public HntviewEntity findonexx();
	
	public BanhezhanxinxiEntity findbanhezhanxinxi( String shebeibianhao);
	
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
}
