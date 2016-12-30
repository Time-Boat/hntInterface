package com.shtoone.qms.service.impl;

import java.io.UnsupportedEncodingException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
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
import com.shtoone.qms.service.DatasubmitService;
import com.shtoone.qms.service.InfService;
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


@Service("InfService")
@Transactional
public class InfServiceImpl extends CommonServiceImpl implements InfService {
	private Logger log = Logger.getLogger(InfServiceImpl.class);

	@Autowired
	private JdbcDao jdbcDao;
	public HntviewEntity findonexx() {
		String queryString = "select top 1 * from Hntview as model where model.biaoshi=0 ";
		List<HntviewEntity> xxlist =jdbcDao.find(queryString, HntviewEntity.class, new HashMap<String, String>());
		if (xxlist.size()>0) {
			return xxlist.get(0);
		} else {
			return null;
		}	
	}
	
	//修改为8时表示发送成功，修改为5时表示发送失败，修改为6时表示发送异常
	
	public void updxxbyid( Integer id,String biaoshi) {
		try{
		String queryString = "update  Xiangxixx set biaoshi='"+biaoshi+"'  where id=" +id;
		Integer temp=jdbcDao.executeSql(queryString, new Object[]{});
		}catch(Exception e){
			System.out.println("更新详细信息不成功");
		}
	}
	
	
	public HunnintujieguoViewEntity findjieguo() {
		String queryString = "select top 1 model.* from HunnintujieguoView as model left outer join xiangxixx a on model.xinxibianhao=a.id  where model.biaoshi=0 and a.biaoshi=8 ";
		List<HunnintujieguoViewEntity> xxlist =jdbcDao.find(queryString, HunnintujieguoViewEntity.class, new HashMap<String, String>());
		if (xxlist.size()>0) {
			return xxlist.get(0);
		
		} else {
			return null;
		}	
	}
	
	public void updjieguobyid( Integer id,String biaoshi) {
		try{
		String queryString = "update  Xiangxixxjieguo set biaoshi='"+biaoshi+"'   where id=" +id;
		Integer temp=jdbcDao.executeSql(queryString, new Object[]{});
		}catch(Exception e){
			System.out.println("更新超标信息不成功");
		}
	}
	
	public HunnintujieguoViewEntity findchuzhi() {
		String queryString = "select top 1 * from HunnintujieguoView as model where model.biaoshi='8' and model.fasongcishu=1 ";
		List<HunnintujieguoViewEntity> xxlist =jdbcDao.find(queryString, HunnintujieguoViewEntity.class, new HashMap<String, String>());
		if (xxlist.size()>0) {
			return xxlist.get(0);
		} else {
			return null;
		}	
	}
	
	public XiangxixxjieguoEntity findchuzhibyid( Integer id) {
		String queryString = "select top 1 * from  Xiangxixxjieguo  where id=" +id;
		List<XiangxixxjieguoEntity> xxlist =jdbcDao.find(queryString, XiangxixxjieguoEntity.class, new HashMap<String, String>());
		if (xxlist.size()>0) {
			return xxlist.get(0);
		} else {
			return null;
		}	
	}
	
	public void updchuzhibyid( Integer id,Integer biaoshi) {
		try{
		String queryString = "update  Xiangxixxjieguo set fasongcishu="+biaoshi+"   where id=" +id;
		Integer temp=jdbcDao.executeSql(queryString, new Object[]{});
		}catch(Exception e){
			System.out.println("更新处置信息不成功");
		}
	}
	
	public Lilunpeibixixx findllphb() {
		String queryString = "select top 1 a.* from S_HNT_Lilun_PHB as a,V_ShiyanshiInfo as b where a.userGroup=b.shiyanshi_guid and isnull(b.F_TRCODE,'')<>'' and  a.state=0 ";
		List<Lilunpeibixixx> xxlist =jdbcDao.find(queryString, Lilunpeibixixx.class, new HashMap<String, String>());
		if (xxlist.size()>0) {
			return xxlist.get(0);
		} else {
			return null;
		}	
	}
	
	public void updllphbbyid( String id,Integer biaoshi) {
		try{
		String queryString = "update  S_HNT_Lilun_PHB set state="+biaoshi+"  where id='" +id+"'";
		Integer temp=jdbcDao.executeSql(queryString, new Object[]{});
		}catch(Exception e){
			System.out.println("更新理论配合比信息不成功");
		}
	}
	
	
	public V_ShiyanshiInfoEntity findShiyanshiInfobyid( String shiyanshi_guid) {
		String queryString = "select top 1 * from V_ShiyanshiInfo  where  shiyanshi_guid='" +shiyanshi_guid+"'";
		List<V_ShiyanshiInfoEntity> xxlist =jdbcDao.find(queryString, V_ShiyanshiInfoEntity.class, new HashMap<String, String>());
		if (xxlist.size()>0) {
			return xxlist.get(0);
		} else {
			return null;
		}	
	}
	
	public BanhezhanxinxiEntity findbanhezhanxinxi( String shebeibianhao) {
		String queryString = "select top 1 * from Banhezhanxinxi  where  departid='" +shebeibianhao+"'";
		List<BanhezhanxinxiEntity> xxlist =jdbcDao.find(queryString, BanhezhanxinxiEntity.class, new HashMap<String, String>());
		if (xxlist.size()>0) {
			return xxlist.get(0);
		} else {
			return null;
		}	
	}

	public Shigongpeibixixx findsjphb() {
		String queryString = "select top 1 * from S_HNT_PHB as model where model.state=0 ";
		List<Shigongpeibixixx> xxlist =jdbcDao.find(queryString, Shigongpeibixixx.class, new HashMap<String, String>());
		if (xxlist.size()>0) {
			return xxlist.get(0);
		} else {
			return null;
		}	
	}
	
	public void updsjphbbyid( String id,Integer biaoshi) {
		try{
		String queryString = "update  S_HNT_PHB set state="+biaoshi+"  where id='" +id+"'";
		Integer temp=jdbcDao.executeSql(queryString, new Object[]{});
		}catch(Exception e){
			System.out.println("更新实际配合比信息不成功");
		}
	}
	
	
	public SYclAllEntity findycl() {
		String queryString = "select top 1 a.* from s_ycl_all as a,DepartMapping as b where a.biaoduanid=b.departid and isnull(mappingCoding,'')<>'' and a.biaoji=0 ";
		List<SYclAllEntity> xxlist =jdbcDao.find(queryString, SYclAllEntity.class, new HashMap<String, String>());
		if (xxlist.size()>0) {
			return xxlist.get(0);
		} else {
			return null;
		}	
	}
	
	public DepartMappingEntity findDepartMapping( String departid) {
		String queryString = "select top 1 * from  DepartMapping  where  departid='" +departid+"'";
		List<DepartMappingEntity> xxlist =jdbcDao.find(queryString, DepartMappingEntity.class, new HashMap<String, String>());
		if (xxlist.size()>0) {
			return xxlist.get(0);
		} else {
			return null;
		}	
	}
	
	public void updyclbyid( String id,Integer biaoshi) {
		try{
		String queryString = "update  s_ycl_all set biaoji="+biaoshi+"  where id='" +id+"'";
		Integer temp=jdbcDao.executeSql(queryString, new Object[]{});
		}catch(Exception e){
			System.out.println("更新原材料信息不成功");
		}
	}
	
	
	public V_SYJZBNEntity findsys() {
		String queryString = "select top 1 * from V_SYJZBN  where isnull(F_TRCODE,'')<>'' and STATUS=1 ";
		List<V_SYJZBNEntity> xxlist =jdbcDao.find(queryString, V_SYJZBNEntity.class, new HashMap<String, String>());
		if (xxlist.size()>0) {
			return xxlist.get(0);
		} else {
			return null;
		}	
	}
	
	public void updsysbyid( String id,Integer biaoshi) {
		try{
		String queryString = "update  T_SYJZB set STATUS="+biaoshi+"  where SYJID='" +id+"'";
		Integer temp=jdbcDao.executeSql(queryString, new Object[]{});
		}catch(Exception e){
			System.out.println("更新试验室主表信息不成功");
		}
	}
	
	public V_YalijiNEntity findsysgc() {
		String queryString = "select top 1 * from V_YalijiN  where isnull(F_TRCODE,'')<>'' and YSTATUS=1 ";
		List<V_YalijiNEntity> xxlist =jdbcDao.find(queryString, V_YalijiNEntity.class, new HashMap<String, String>());
		if (xxlist.size()>0) {
			return xxlist.get(0);
		} else {
			return null;
		}	
	}
	
	public void updsysgcbyid( String id,Integer biaoshi) {
		try{
		String queryString = "update  F_Yaliji set STATUS="+biaoshi+"  where F_GUID='" +id+"'";
		Integer temp=jdbcDao.executeSql(queryString, new Object[]{});
		}catch(Exception e){
			System.out.println("更新试验室子表信息不成功");
		}
	}
	
	public Integer deletejjgroup() {
		Integer rs=0;
		try{
		   String queryString = "delete from JJGROUP ";
		   Integer temp=jdbcDao.executeSql(queryString, new Object[]{});
		   rs=  1;
		}catch(Exception e){
			System.out.println("删除组织机构表不成功");
		}
		return rs;
	}

 
	
}
