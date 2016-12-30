package com.shtoone.qms.app.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.app.entity.AppHunnintuView;
import com.shtoone.qms.app.entity.AppSyTypeBean;
import com.shtoone.qms.app.entity.BHZ_SCSJData_Item;
import com.shtoone.qms.app.entity.HntCountAnalyze;
import com.shtoone.qms.app.entity.HntMain;
import com.shtoone.qms.app.entity.HntMainLogoBean;
import com.shtoone.qms.app.entity.ShebeiListBean;
import com.shtoone.qms.app.entity.UpdTSDepart;
import com.shtoone.qms.app.service.AppInterfaceService;
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


@Service("AppInterfaceService")
@Transactional
public class AppInterfaceServiceImpl extends CommonServiceImpl implements AppInterfaceService {

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
		String queryString = "select top 1 * from HunnintujieguoView as model where model.biaoshi=0 ";
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
	
	
	//获取组织机构的最新修改时间
	public String getUpdateDepartTime(){
		String updateDepartTime="";
		try{
			String queryString="select departid from upd_t_s_depart";
			UpdTSDepart depart =(UpdTSDepart)jdbcDao.findForObject(queryString, UpdTSDepart.class, new HashMap<String, String>());
			if(depart!=null){
				updateDepartTime=depart.getDepartid();
			}	
		}catch(Exception e){}
		return updateDepartTime;
	}
	//修改手机登陆类型
	public void executeSql( String queryString) {
		try{
			Integer temp=jdbcDao.executeSql(queryString, new Object[]{});
		}catch(Exception e){
			System.out.println("执行【"+queryString+"】错误");
		}
	}
	/**
	 * 获取指定组织机构下的拌和机信息
	 * @param bhjtype 1:水泥混凝土 2：沥青混凝土 3：万能机 4：压力机
	 * @param userlft
	 * @param userrgt
	 * @return
	 */
	public Integer getBanhejiCount(Integer bhjtype,Integer userlft, Integer userrgt){
		try{
			String queryString ="select count(*) as orderid from BanhezhanxinxiView where 1=1";
			if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
				queryString+=" and lft >= '"+userlft+"' and rgt <= '" + userrgt + "'";
			}
			if(StringUtil.isNotEmpty(bhjtype)){
				queryString+=" and gprstype="+bhjtype;
			}
			List<BanhezhanxinxiEntity> bhzlist=jdbcDao.find(queryString, BanhezhanxinxiEntity.class, new HashMap<String, String>());
			if(null!=bhzlist&&bhzlist.size()>0){
				return bhzlist.get(0).getOrderid();
			}else{
				return 0;
			}
		}catch(Exception e){
			System.out.println("得到拌和机数量出错了！");
		}
		return 0;
	}
	
	/**
	 * 获取指定组织机构下的拌和机信息
	 * @param bhjtype 1:水泥混凝土 2：沥青混凝土 3：万能机 4：压力机
	 * @param userlft
	 * @param userrgt
	 * @return
	 */
	public Integer getBanhezhanCount(Integer bhztype,Integer userlft, Integer userrgt){
		try{
			String queryString ="select count(*) as lft from t_s_depart where 1=1";
			if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
				queryString+=" and lft >= '"+userlft+"' and rgt <= '" + userrgt + "'";
			}
			if(StringUtil.isNotEmpty(bhztype)){
				queryString+=" and type="+bhztype;
			}
			List<TSDepart> bhzlist=jdbcDao.find(queryString, TSDepart.class, new HashMap<String, String>());
			if(null!=bhzlist&&bhzlist.size()>0){
				return bhzlist.get(0).getLft();
			}else{
				return 0;
			}
		}catch(Exception e){
			System.out.println("得到拌和站数量出错了！");
		}
		return 0;
	}
	
	public List<BanhezhanxinxiEntity> getBanhejiList(Integer bhjtype,Integer userlft, Integer userrgt,String startTime,String endTime,Integer bhztype){
		String queryString ="select gprsbianhao,banhezhanminchen from BanhezhanxinxiView where 1=1";
		if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
			queryString+=" and lft >= '"+userlft+"' and rgt <= '" + userrgt + "'";
		}
		if(StringUtil.isNotEmpty(bhjtype)){
			queryString+=" and gprstype="+bhjtype;
		}
		if(StringUtil.isNotEmpty(bhztype)){
			queryString+=" and type='"+bhztype+"'";
		}
		return jdbcDao.find(queryString, BanhezhanxinxiEntity.class, new HashMap<String, String>());
	}
	
	/**
	 * 统计指定机构的生产及超标信息
	 * @param lft
	 * @param rgt
	 * @return
	 */
	public HntMain getHntMainObj(Integer lft,Integer rgt,String startTime,String endTime,String shebeibianhao){
		HntMain hntMain=null;
		try{
//			String sql="SELECT  max(gprsbianhao) as departId,max(banhezhanminchen) as departName,sum(a.panshu) as totalPanshu,sum(zongfashu) totalFangliang,sum(d.cbpanshu) as cbpanshu,"+
//					   "sum(d.mcbpanshu) as mcbpanshu,sum(d.hcbpanshu) as hcbpanshu,sum(d.cczpanshu) as cczpanshu,sum(d.mczpanshu) as mczpanshu,sum(d.hczpanshu) as hczpanshu,"+
//					   "case when sum(a.panshu)=0 then '0' else convert(numeric(18,2),sum(cast(d.cbpanshu as float))*100/sum(cast(a.panshu as float))) end as cblv,"+
//					   "case when sum(a.panshu)=0 then '0' else convert(numeric(18,2),sum(cast(d.mcbpanshu as float))*100/sum(cast(a.panshu as float))) end as mcblv,"+
//					   "case when sum(a.panshu)=0 then '0' else convert(numeric(18,2),sum(cast(d.hcbpanshu as float))*100/sum(cast(a.panshu as float))) end as hcblv,"+
//					   "case when sum(d.cbpanshu)=0 then '0' else convert(numeric(18,2),sum(cast(d.cczpanshu as float))*100/sum(cast(d.cbpanshu as float))) end as czlv, "+
//					   "case when sum(d.mcbpanshu)=0 then '0' else convert(numeric(18,2),sum(cast(d.mczpanshu as float))*100/sum(cast(d.mcbpanshu as float))) end as mczlv, "+
//					   "case when sum(d.hcbpanshu)=0 then '0' else convert(numeric(18,2),sum(cast(d.hczpanshu as float))*100/sum(cast(d.hcbpanshu as float))) end as hczlv "+
//					   "FROM dbo.tongji_cl AS a INNER JOIN "+
//					   "dbo.Banhezhanxinxi AS b ON a.shebeibianhao = b.gprsbianhao INNER JOIN "+
//					   "dbo.t_s_depart AS c ON b.departid = c.ID LEFT JOIN dbo.TONGJICB AS d on a.shebeibianhao=d.shebeibianhao ";
			String sql="SELECT  max(gprsbianhao) as departId,max(banhezhanminchen) as departName,sum(a.panshu) as totalPanshu,sum(zongfashu) totalFangliang "+
					   "FROM dbo.tongji_cl AS a INNER JOIN "+
					   "dbo.Banhezhanxinxi AS b ON a.shebeibianhao = b.gprsbianhao INNER JOIN "+
					   "dbo.t_s_depart AS c ON b.departid = c.ID";
			String sqlWhere=" where 1=1";
			if (StringUtil.isNotEmpty(lft) && StringUtil.isNotEmpty(rgt)) {
				sqlWhere+=" and lft >= '"+lft+"' and rgt <= '" + rgt + "'";
			}
			if(StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)){
				sqlWhere+=" and (a.chuliaodate between '"+startTime+"' and '"+endTime+"') ";
			}
			if(StringUtil.isNotEmpty(shebeibianhao)){
				sqlWhere+=" and b.gprsbianhao='"+shebeibianhao+"'";
			}
			sql=sql+sqlWhere;
			List<HntMain> bhzlist=jdbcDao.find(sql, HntMain.class, new HashMap<String, String>());
			if(bhzlist.size()>0){
				HntMain hnt=bhzlist.get(0);
				hntMain=new HntMain();
				hnt.setDepartId(hnt.getDepartId());
				hntMain.setDepartName(hnt.getDepartName());
				hntMain.setTotalPanshu(StringUtil.isEmpty(hnt.getTotalPanshu(),"0"));
				hntMain.setTotalFangliang(StringUtil.isEmpty(hnt.getTotalFangliang(), "0"));
				//对超标的情况进行罗列
				sql="SELECT sum(cbpanshu) AS cbpanshu,sum(mcbpanshu) AS mcbpanshu,sum(hcbpanshu) AS hcbpanshu,sum(cczpanshu) AS cczpanshu,sum(mczpanshu) AS mczpanshu,sum(hczpanshu) AS hczpanshu FROM dbo.TONGJICB AS a";
				sql+=" INNER JOIN banhezhanxinxi AS b on a.shebeibianhao=b.gprsbianhao INNER JOIN t_s_depart AS c ON b.departid=c.ID";
				if(StringUtil.isNotEmpty(hnt.getDepartId()) && StringUtil.isEmpty(shebeibianhao)){
					sql+=" and lft >= '"+lft+"' and rgt <= '" + rgt + "'";
				}else if(StringUtil.isNotEmpty(hnt.getDepartId()) && StringUtil.isNotEmpty(shebeibianhao)){
					sql+=" and shebeibianhao='"+hnt.getDepartId()+"'";
				}
				//添加时间过滤条件
				if(StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)){
					sql+=" and (a.chuliaodate between '"+startTime+"' and '"+endTime+"') ";
				}
				List<Object[]> list=findListbySql(sql);
				if(list.size()>0 && StringUtil.isNotEmpty(hnt.getDepartId())){
					for(int i=0;i<list.size();i++){
						Object[] objArr=list.get(i);
						hntMain.setCbpanshu(StringUtil.isEmpty(String.valueOf(objArr[0]),"0"));
						if(Float.parseFloat(hntMain.getTotalPanshu())!=0){
							hntMain.setCblv(StringUtil.formatFloat(Float.parseFloat(hntMain.getCbpanshu())*100/Float.parseFloat(hntMain.getTotalPanshu()),"#0.00"));
						}else{
							hntMain.setCblv("0.00");
						}
						hntMain.setMcbpanshu(StringUtil.isEmpty(String.valueOf(objArr[1]),"0"));
						if(Float.parseFloat(hntMain.getTotalPanshu())!=0){
							hntMain.setMcblv(StringUtil.formatFloat(Float.parseFloat(hntMain.getMcbpanshu())*100/Float.parseFloat(hntMain.getTotalPanshu()),"#0.00"));
						}else{
							hntMain.setMcblv("0.00");
						}
						hntMain.setHcbpanshu(StringUtil.isEmpty(String.valueOf(objArr[2]),"0"));
						if(Float.parseFloat(hntMain.getTotalPanshu())!=0){
							hntMain.setHcblv(StringUtil.formatFloat(Float.parseFloat(hntMain.getHcbpanshu())*100/Float.parseFloat(hntMain.getTotalPanshu()),"#0.00"));
						}else{
							hntMain.setHcblv("0.00");
						}
						hntMain.setCczpanshu(StringUtil.isEmpty(String.valueOf(objArr[3]),"0"));
						if(Float.parseFloat(hntMain.getCbpanshu())!=0){
							hntMain.setCzlv(StringUtil.formatFloat(Float.parseFloat(hntMain.getCczpanshu())*100/Float.parseFloat(hntMain.getCbpanshu()),"#0.00"));
						}else{
							hntMain.setCzlv("0.00");
						}
						hntMain.setMczpanshu(StringUtil.isEmpty(String.valueOf(objArr[4]),"0"));
						if(Float.parseFloat(hntMain.getMcbpanshu())!=0){
							hntMain.setMczlv(StringUtil.formatFloat(Float.parseFloat(hntMain.getMczpanshu())*100/Float.parseFloat(hntMain.getMcbpanshu()),"#0.00"));
						}else{
							hntMain.setMczlv("0.00");
						}
						hntMain.setHczpanshu(StringUtil.isEmpty(String.valueOf(objArr[5]),"0"));
						if(Float.parseFloat(hntMain.getHcbpanshu())!=0){
							hntMain.setHczlv(StringUtil.formatFloat(Float.parseFloat(hntMain.getHczpanshu())*100/Float.parseFloat(hntMain.getHcbpanshu()),"#0.00"));
						}else{
							hntMain.setHczlv("0.00");
						}
					}
				}else{
					hntMain.setCbpanshu("0");
					hntMain.setMcbpanshu("0");
					hntMain.setHcbpanshu("0");
					hntMain.setCblv("0.00");
					hntMain.setMcblv("0.00");
					hntMain.setHcblv("0.00");
					hntMain.setCczpanshu("0");
					hntMain.setMczpanshu("0");
					hntMain.setHczpanshu("0");
					hntMain.setCzlv("0.00");
					hntMain.setMczlv("0.00");
					hntMain.setHczlv("0.00");
				}
				return hntMain;
			}else{
				return hntMain;
			}
		}catch(Exception e){}
		return hntMain;
	}
	
	
	
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
			Integer userlft, Integer userrgt, String jiaozuobuwei,
			String gongchengmingcheng,String shebeibianhao,Integer pageNo, Integer maxPageItems){
		try{
			StringBuilder queryCtest = new StringBuilder("");
			queryCtest.append(" (convert(datetime,chuliaoshijian,121) between '"
					+ startTime + "' and '" + endTime + "')");
			if (StringUtil.isNotEmpty(jiaozuobuwei)) {
				queryCtest.append(" and jiaozuobuwei like '%" + jiaozuobuwei + "%'");
			}
			if (StringUtil.isNotEmpty(gongchengmingcheng)) {
				queryCtest.append(" and gongchengmingcheng like '%"
						+ gongchengmingcheng + "%'");
			}
			if(StringUtil.isNotEmpty(shebeibianhao)){
				queryCtest.append(" and shebeibianhao ='"+shebeibianhao+"'");
			}
			if(userlft>0 && userrgt>0){
				queryCtest.append(" and lft >= '"+userlft+"'"+" and rgt<= '"+userrgt+"'");
			}
			StringBuffer sql = new StringBuffer();
			sql.append("select id,chuliaoshijian,banhezhanminchen,gongchengmingcheng,jiaozuobuwei,sigongdidian,qiangdudengji,gujifangshu from HunnintuView t");
			sql.append(" where "+queryCtest.toString());
			sql.append("order by t.chuliaoshijian desc");
			List<BHZ_SCSJData_Item> tempList=findObjForJdbc(sql.toString(), pageNo, maxPageItems, BHZ_SCSJData_Item.class);
			return tempList;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<BHZ_SCSJData_Item> AppHntjieguoList(String departid,String startTime,String endTime,String leixing,String chulijieguoType,
			String gongchengmingcheng,String jiaozuobuwei,String shebeibianhao,String xinxibianhao, Integer userlft, Integer userrgt,Integer pageNo,Integer maxPageItems){
		try{
			StringBuilder queryCondition = new StringBuilder("");
			queryCondition.append(" (convert(datetime,chuliaoshijian,121) between '" + startTime
			+ "' and '" + endTime + "')");
			
			if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
				queryCondition.append(" and lft >= '"+userlft
						+"' and rgt <= '" + userrgt + "'");
			}
			if(StringUtil.isNotEmpty(gongchengmingcheng)){
				queryCondition.append(" and gongchengmingcheng like '%"+gongchengmingcheng+"%'");
			}
			if(StringUtil.isNotEmpty(jiaozuobuwei)){
				queryCondition.append(" and jiaozuobuwei like '%"+jiaozuobuwei+"%'");
			}
			if(StringUtil.isNotEmpty(shebeibianhao)){
				queryCondition.append(" and shebeibianhao ='"+shebeibianhao+"'");
			}
			if(StringUtil.isNotEmpty(xinxibianhao)){
				queryCondition.append(" and xinxibianhao ='"+xinxibianhao+"'");
			}
			if(StringUtil.isEmpty(chulijieguoType)){
//				chulijieguoType="0";//未处理
			}else{
				//处置情况(0:未处置1：已处置,3:已审批,3:未审批)
				if(new Integer(chulijieguoType)==0){
		        	queryCondition.append(" and  (isnull(filepath,'')='' and isnull(chulijieguo,'')='') ");
		        }else if(new Integer(chulijieguoType)==1){
		        	queryCondition.append(" and (isnull(filepath,'')<>'' or isnull(chulijieguo,'')<>'') ");
		        }else if(new Integer(chulijieguoType)==2){
		        	queryCondition.append(" and  (isnull(shenpiren,'')='' or isnull(shenpidate,'')='') and (isnull(filepath,'')<>'' or isnull(chulijieguo,'')<>'') ");
		        }else if(new Integer(chulijieguoType)==3){
		        	queryCondition.append(" and  (isnull(shenpiren,'')<>'' or isnull(shenpidate,'')<>'') and (isnull(filepath,'')<>'' or isnull(chulijieguo,'')<>'') ");
		        }
			}
			if(StringUtil.isEmpty(leixing)){
				leixing="0";
			}
			//初级包含中级和高级，中级包含高级
	        switch (new Integer(leixing)) {
	           case 1: queryCondition.append(" and leixing=1 ");
	           break;
	           case 2: queryCondition.append(" and leixing=2 ");
	           break;
	           case 3: queryCondition.append(" and leixing=3 ");
	           break;
	           default:break;
	        }
			StringBuffer sql = new StringBuffer();
			
			sql.append("select *, "
				+" CASE WHEN (isnull(filepath,'')='' and isnull(chulijieguo,'')='') THEN '0' "
				+" WHEN (isnull(filepath,'')<>'' or isnull(chulijieguo,'')<>'') THEN '1' "
				+" ELSE '-1' END as chuli, "
				+" CASE WHEN (isnull(shenpiren,'')='' or isnull(shenpidate,'')='') and (isnull(filepath,'')<>'' or isnull(chulijieguo,'')<>'') THEN '0' "
				+" WHEN (isnull(shenpiren,'')<>'' or isnull(shenpidate,'')<>'') and (isnull(filepath,'')<>'' or isnull(chulijieguo,'')<>'') THEN '1' "
				+" ELSE '-1' END as shenhe "
				+" from HunnintujieguoView t where "+queryCondition.toString());

					
//			sql.append("select * from HunnintujieguoView t where"+queryCondition.toString());
			sql.append(" ORDER BY t.id DESC");
			System.out.println(sql);
			List<BHZ_SCSJData_Item> tempList=findObjForJdbc(sql.toString(), pageNo, maxPageItems, BHZ_SCSJData_Item.class);
			return tempList;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
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
	public List<AppHntBanhejiState> AppHntBanhejiState(String shebeibianhao, Integer userlft, Integer userrgt,Integer pageNo,Integer maxPageItems,String state){
		List<AppHntBanhejiState> tempList=null;
		try{
			StringBuilder queryCondition = new StringBuilder(" 1=1 ");
			if (StringUtil.isNotEmpty(userlft) && StringUtil.isNotEmpty(userrgt)) {
				queryCondition.append(" and lft >= '"+userlft+"' and rgt <= '" + userrgt + "'");
			}
			if(StringUtil.isNotEmpty(shebeibianhao)){
				queryCondition.append(" and shebeibianhao='"+shebeibianhao+"'");
			}
			if(StringUtil.isEmpty(state)){
				state="0";
			}
			Calendar day=Calendar.getInstance();
	    	day.add(Calendar.DATE, -1);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			switch (new Integer(state)) {
	           case 1: 
	        	   queryCondition.append(" and convert(datetime,caijishijian,120) >='" + sdf.format(day.getTime()) + "'  and   cast(caijiyanshi as float) <=1200  and  cast(shangchuanyanshi as float)<=1800  ");
	        	   break;
	           case 2: 
	        	   queryCondition.append(" and convert(datetime,caijishijian,120) >='" + sdf.format(day.getTime()) + "'  and  ( cast(caijiyanshi as float) >1200  or  cast(shangchuanyanshi as float)>1800 ) ");
	        	   break;
	           case 3: 
	        	   queryCondition.append(" and convert(datetime,caijishijian,120) <'" + sdf.format(day.getTime()) + "'");
	        	   break;
	           default:
	        	   break;
	        }
			StringBuffer sql = new StringBuffer();
			sql.append("select departname,banhezhanminchen,chuliaoshijian,baocunshijian,caijishijian,shangchuanyanshi from TophunnintuView t where "+queryCondition.toString());
			tempList = findObjForJdbc(sql.toString(), pageNo, maxPageItems,AppHntBanhejiState.class);
		}catch(Exception e){}
		return tempList;
	}
	
	
	private void appendSql(StringBuffer sql) {
		sql.append("SELECT max(b.id) as id, SUM(CAST( shui1_shijizhi as numeric(18,3))) AS shui1_shijizhi, ");
		sql.append(" SUM(CAST( shui2_shijizhi as numeric(18,3))) AS shui2_shijizhi, ");
		sql.append(" SUM(CAST( shuini1_shijizhi as numeric(18,3))) AS shuini1_shijizhi, ");
		sql.append(" SUM(CAST( shuini2_shijizhi as numeric(18,3))) AS shuini2_shijizhi, ");
		sql.append(" SUM(CAST( kuangfen3_shijizhi as numeric(18,3))) AS kuangfen3_shijizhi, ");
		sql.append(" SUM(CAST( feimeihui4_shijizhi as numeric(18,3))) AS feimeihui4_shijizhi, ");
		sql.append(" SUM(CAST( fenliao5_shijizhi as numeric(18,3))) AS fenliao5_shijizhi, ");
		sql.append(" SUM(CAST( fenliao6_shijizhi as numeric(18,3))) AS fenliao6_shijizhi, ");
		sql.append(" SUM(CAST( sha1_shijizhi as numeric(18,3))) AS sha1_shijizhi, ");
		sql.append(" SUM(CAST( shi1_shijizhi as numeric(18,3))) AS shi1_shijizhi, ");
		sql.append(" SUM(CAST( shi2_shijizhi as numeric(18,3))) AS shi2_shijizhi, ");
		sql.append(" SUM(CAST( sha2_shijizhi as numeric(18,3))) AS sha2_shijizhi, ");
		sql.append(" SUM(CAST( guliao5_shijizhi as numeric(18,3))) AS guliao5_shijizhi, ");
		sql.append(" SUM(CAST( waijiaji1_shijizhi as numeric(18,3))) AS waijiaji1_shijizhi, ");
		sql.append(" SUM(CAST( waijiaji2_shijizhi as numeric(18,3))) AS waijiaji2_shijizhi, ");
		sql.append(" SUM(CAST( waijiaji3_shijizhi as numeric(18,3))) AS waijiaji3_shijizhi, ");
		sql.append(" SUM(CAST( waijiaji4_shijizhi as numeric(18,3))) AS waijiaji4_shijizhi, ");
		sql.append(" SUM(CAST( shui1_lilunzhi as numeric(18,3))) AS shui1_lilunzhi, ");
		sql.append(" SUM(CAST( shui2_lilunzhi as numeric(18,3))) AS shui2_lilunzhi, ");
		sql.append(" SUM(CAST( shuini1_lilunzhi as numeric(18,3))) AS shuini1_lilunzhi, ");
		sql.append(" SUM(CAST( shuini2_lilunzhi as numeric(18,3))) AS shuini2_lilunzhi, ");
		sql.append(" SUM(CAST( kuangfen3_lilunzhi as numeric(18,3))) AS kuangfen3_lilunzhi, ");
		sql.append(" SUM(CAST( feimeihui4_lilunzhi as numeric(18,3))) AS feimeihui4_lilunzhi, ");
		sql.append(" SUM(CAST( fenliao5_lilunzhi as numeric(18,3))) AS fenliao5_lilunzhi, ");
		sql.append(" SUM(CAST( fenliao6_lilunzhi as numeric(18,3))) AS fenliao6_lilunzhi, ");
		sql.append(" SUM(CAST( sha1_lilunzhi as numeric(18,3))) AS sha1_lilunzhi, ");
		sql.append(" SUM(CAST( shi1_lilunzhi as numeric(18,3))) AS sha1_lilunzhi, ");
		sql.append(" SUM(CAST( shi2_lilunzhi as numeric(18,3))) AS shi2_lilunzhi, ");
		sql.append(" SUM(CAST( sha2_lilunzhi as numeric(18,3))) AS sha2_lilunzhi, ");
		sql.append(" SUM(CAST( guliao5_lilunzhi as numeric(18,3))) AS guliao5_lilunzhi, ");
		sql.append(" SUM(CAST( waijiaji1_lilunzhi as numeric(18,3))) AS waijiaji1_lilunzhi, ");
		sql.append(" SUM(CAST( waijiaji2_lilunzhi as numeric(18,3))) AS waijiaji2_lilunzhi, ");
		sql.append(" SUM(CAST( waijiaji3_lilunzhi as numeric(18,3))) AS waijiaji3_lilunzhi, ");
		sql.append(" SUM(CAST( waijiaji4_lilunzhi as numeric(18,3))) AS waijiaji4_lilunzhi ,");
		
		/*
		sql.append(" SUM(CAST( shui1_shijizhi as numeric(18,3)))-SUM(CAST( shui1_lilunzhi as numeric(18,3))) AS shui1chazhi, ");
		sql.append(" SUM(CAST( shui2_shijizhi as numeric(18,3)))-SUM(CAST( shui2_lilunzhi as numeric(18,3))) AS shui2chazhi, ");
		sql.append(" SUM(CAST( shuini1_shijizhi as numeric(18,3)))-SUM(CAST( shuini1_lilunzhi as numeric(18,3))) AS shuini1chazhi, ");
		sql.append(" SUM(CAST( shuini2_shijizhi as numeric(18,3)))-SUM(CAST( shuini2_lilunzhi as numeric(18,3))) AS shuini2chazhi, ");
		sql.append(" SUM(CAST( kuangfen3_shijizhi as numeric(18,3)))-SUM(CAST( kuangfen3_lilunzhi as numeric(18,3))) AS kuangfen3chazhi, ");
		sql.append(" SUM(CAST( feimeihui4_shijizhi as numeric(18,3)))-SUM(CAST( feimeihui4_lilunzhi as numeric(18,3))) AS feimeihui4chazhi, ");
		sql.append(" SUM(CAST( fenliao5_shijizhi as numeric(18,3)))-SUM(CAST( fenliao5_lilunzhi as numeric(18,3))) AS fenliao5chazhi, ");
		sql.append(" SUM(CAST( fenliao6_shijizhi as numeric(18,3)))-SUM(CAST( fenliao6_lilunzhi as numeric(18,3))) AS fenliao6chazhi, ");
		sql.append(" SUM(CAST( sha1_shijizhi as numeric(18,3)))-SUM(CAST( sha1_lilunzhi as numeric(18,3))) AS sha1chazhi, ");
		sql.append(" SUM(CAST( shi1_shijizhi as numeric(18,3)))-SUM(CAST( shi1_lilunzhi as numeric(18,3))) AS shi1chazhi, ");
		sql.append(" SUM(CAST( shi2_shijizhi as numeric(18,3)))-SUM(CAST( shi2_lilunzhi as numeric(18,3))) AS shi2chazhi, ");
		sql.append(" SUM(CAST( sha2_shijizhi as numeric(18,3)))-SUM(CAST( sha2_lilunzhi as numeric(18,3))) AS sha2chazhi, ");
		sql.append(" SUM(CAST( guliao5_shijizhi as numeric(18,3)))-SUM(CAST( guliao5_lilunzhi as numeric(18,3))) AS guliao5chazhi, ");
		sql.append(" SUM(CAST( waijiaji1_shijizhi as numeric(18,3)))-SUM(CAST( waijiaji1_lilunzhi as numeric(18,3))) AS waijiaji1chazhi, ");
		sql.append(" SUM(CAST( waijiaji2_shijizhi as numeric(18,3)))-SUM(CAST( waijiaji2_lilunzhi as numeric(18,3))) AS waijiaji2chazhi, ");
		sql.append(" SUM(CAST( waijiaji3_shijizhi as numeric(18,3)))-SUM(CAST( waijiaji3_lilunzhi as numeric(18,3))) AS waijiaji3chazhi, ");
		sql.append(" SUM(CAST( waijiaji4_shijizhi as numeric(18,3)))-SUM(CAST( waijiaji4_lilunzhi as numeric(18,3))) AS waijiaji4chazhi, ");
		*/
		sql.append(" SUM(CAST( gujifangshu as numeric(18,3))) AS gujifangshu  ");
	}
	
	
	// 拼查询条件（where语句）
		String getSqlWhere(String gongchengmingcheng,String jiaozuobuwei,String qiangdudengji, String startTime, String endTime,
				Integer userlft,Integer userrgt,String shebeibianhao) {
			// 拼出条件语句
			String sqlWhere = "";

			if (StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)) {
				if (!sqlWhere.isEmpty()) {
					sqlWhere += " and";
				}
				sqlWhere += " chuliaoshijian between '"
						+ startTime + "' and '" + endTime + "'";
			}
			if (StringUtil.isNotEmpty(gongchengmingcheng) && gongchengmingcheng.length()>0) {
				if (!sqlWhere.isEmpty()) {
					sqlWhere += " and";
				}
				sqlWhere += " gongchengmingcheng like '%"+gongchengmingcheng+"%'";
			}
			if (StringUtil.isNotEmpty(qiangdudengji) && qiangdudengji.length()>0) {
				if (!sqlWhere.isEmpty()) {
					sqlWhere += " and";
				}
				sqlWhere += " qiangdudengji like '%"+qiangdudengji+"%'";
			}
			if (StringUtil.isNotEmpty(jiaozuobuwei) && jiaozuobuwei.length()>0) {
				if (!sqlWhere.isEmpty()) {
					sqlWhere += " and";
				}
				sqlWhere += " jiaozuobuwei like '%"+jiaozuobuwei+"%'";
			}
			if (userlft>0 && userrgt>0) {
				if (!sqlWhere.isEmpty()) {
					sqlWhere += " and";
				}
				sqlWhere += " lft >= '"+userlft+"' and rgt<= '"+userrgt+"'";
			}
			if (StringUtil.isNotEmpty(shebeibianhao)) {
				if (!sqlWhere.isEmpty()) {
					sqlWhere += " and";
				}
				sqlWhere += " b.gprsbianhao= '"+shebeibianhao+"'";
			}
			return sqlWhere;
		}
		
	public AppHunnintuView AppHntMaterial(String gongchengmingcheng,String jiaozuobuwei,String qiangdudengji,String startTime,String endTime,
			Integer userlft,Integer userrgt,String shebeibianhao,Integer pageNo,Integer maxPageItems){
		AppHunnintuView temp=null;
		try{
			String sqlWhere = getSqlWhere(gongchengmingcheng,jiaozuobuwei,qiangdudengji,startTime,endTime,userlft,userrgt,shebeibianhao);
			// 取出当前页的数据
			StringBuffer sql = new StringBuffer();
			appendSql(sql);
			sql.append(" FROM hntview  a, Banhezhanxinxi b ");
			if (!sql.toString().isEmpty()) {
				sql.append(" where a.shebeibianhao=b.gprsbianhao and " +sqlWhere);
			}
			temp=(AppHunnintuView)jdbcDao.findForObject(sql.toString(),AppHunnintuView.class,new HashMap<String, String>());
		}catch(Exception e){}
		return temp;
	}
	
	public HntMainLogoBean hntMainLogo(Integer lft,Integer rgt){
		HntMainLogoBean hntMainlogo=new HntMainLogoBean();
		//得到待处置报警、累计处置报警、处置率
		long chaobiaoCount=getCountForJdbc("select count(*) AS chaobiaoCount from HunnintujieguoView where 1=1 and (lft >='"+lft+"' and rgt<='"+rgt+"')");
		long leijiRealCount=getCountForJdbc("select count(*) AS leijiRealCount from HunnintujieguoView where 1=1 and (lft >='"+lft+"' and rgt<='"+rgt+"') and (isnull(filepath,'')<>'' or isnull(chulijieguo,'')<>'') ");
		long waitRealCount=chaobiaoCount-leijiRealCount;
		String realPer=null;
		try{
			if(chaobiaoCount!=0){
				realPer=String.format("%1$.2f", (float)leijiRealCount*100/(float)chaobiaoCount);
			}else{
				realPer="0";
			}
		}catch(Exception ex){}
		
		//得到今天的时间
		//生产数据查询从凌晨至当前时间生产多少盘，累计多少总量
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar day=Calendar.getInstance(); 
		String startTime=sdf.format(day.getTime())+" 00:00:00";
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar day2=Calendar.getInstance(); 
		String endTime=sdf2.format(day2.getTime());
		long todayCount=getCountForJdbc("select count(*) AS todayCount from Hntview where 1=1 and (chuliaoshijian between '"+startTime+"' and '"+endTime+"') and (lft >='"+lft+"' and rgt<='"+rgt+"')");
		long count=getCountForJdbc("select count(*) AS countps from Hntview where 1=1 and (lft >='"+lft+"' and rgt<='"+rgt+"')");
		hntMainlogo.setWaitRealCount(StringUtil.isEmpty(String.valueOf(waitRealCount),"0"));
		hntMainlogo.setLeijiRealCount(StringUtil.isEmpty(String.valueOf(leijiRealCount),"0"));
		hntMainlogo.setRealPer(StringUtil.isEmpty(realPer,"0.00"));
		hntMainlogo.setTodayCount(StringUtil.isEmpty(String.valueOf(todayCount),"0"));
		hntMainlogo.setLeijiCount(StringUtil.isEmpty(String.valueOf(count),"0"));
		hntMainlogo.setChaobiaoRealCount(StringUtil.isEmpty(String.valueOf(leijiRealCount),"0"));
		return hntMainlogo;
	}
	
	public AppHntHomePageData hntBhzMainLogo(Integer lft,Integer rgt){
		AppHntHomePageData hpd = new AppHntHomePageData();
		StringBuffer sql= new StringBuffer("select sum ( case when (leixing='1') then 1 else 0 end) as c,sum(case when (leixing='2') then 1 else 0 end) as z, "
					+" sum(case when (leixing='3') then 1 else 0 end) as g from HunnintujieguoView where 1=1 ");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar=Calendar.getInstance();
		String endTime=sdf.format(calendar.getTime());
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		
		String dayStratTime = sdf1.format(calendar.getTime())+" 00:00:00";
		//calendar.add(Calendar.DAY_OF_YEAR,-1);
		
		int day = calendar.get(calendar.DAY_OF_WEEK);
		
		if(day>=2){
			day = 2-day;
		}else if(day<2){
			day = -6;
		}
		
		calendar.add(Calendar.DAY_OF_YEAR,day);
		String weekStartTime=sdf1.format(calendar.getTime())+" 00:00:00";
		
		calendar.add(Calendar.DAY_OF_YEAR,Math.abs(day));
		//String monthEndTime=sdf.format(calendar.getTime());
		
		day = calendar.get(calendar.DAY_OF_MONTH);
		
		calendar.add(Calendar.DAY_OF_YEAR,-day+1);
		
		String monthStratTime=sdf1.format(calendar.getTime())+" 00:00:00";
		
		StringBuffer dcSql = new StringBuffer("select count(*) AS todayCount from Hntview where 1=1 and (chuliaoshijian between '"+dayStratTime+"' and '"+endTime+"') ");
		StringBuffer wcSql = new StringBuffer("select count(*) AS todayCount from Hntview where 1=1 and (chuliaoshijian between '"+weekStartTime+"' and '"+endTime+"') ");
		StringBuffer mcSql = new StringBuffer("select count(*) AS todayCount from Hntview where 1=1 and (chuliaoshijian between '"+monthStratTime+"' and '"+endTime+"') ");
		
		if(lft!=null&&rgt!=null){
			sql.append(" and lft >='"+lft+"' and rgt<='"+rgt+"' ");
			dcSql.append(" and lft >='"+lft+"' and rgt<='"+rgt+"' ");
			wcSql.append(" and lft >='"+lft+"' and rgt<='"+rgt+"' ");
			mcSql.append(" and lft >='"+lft+"' and rgt<='"+rgt+"' ");
		}
		long dayCount=getCountForJdbc(dcSql.toString());
		long weekCount=getCountForJdbc(wcSql.toString());
		long monthCount=getCountForJdbc(mcSql.toString());
		
		
		
		hpd.setDayCount(""+dayCount);
		hpd.setWeekCount(""+weekCount);
		hpd.setMonthCount(""+monthCount);
		
		Statement cs = null;
		Connection con = null;
		ResultSet rs = null;
		try{
			con = getCon();
			cs = con.createStatement();
			rs = cs.executeQuery(sql.toString());
			
			if(rs.next()){
				hpd.setPrimary(rs.getString("c"));
				hpd.setMiddle(rs.getString("z"));
				hpd.setHigh(rs.getString("g"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				closeCon(con,cs,rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hpd;
	}
	
	public String appendSQL(Integer cllx){
		StringBuffer sql = new StringBuffer();
		sql.append("select");
		switch (cllx) {
			case 1:  //季度
				sql.append(" year(a.chuliaodate) as xa , datename(quarter,a.chuliaodate) as xb,");
				break;
			case 2:  //月份
				sql.append(" year(a.chuliaodate) as xa , datename(month,a.chuliaodate) as xb,");
				break;
			case 3:  //周
				sql.append(" year(a.chuliaodate) as xa , datename(week,a.chuliaodate) as xb,");
				break;
			default:
				break;
		}
		sql.append(" case when SUM(a.panshu)>0 then SUM(a.panshu) else 0 end  AS pangshu,");
		sql.append(" case when SUM(zongfashu)>0 then SUM(zongfashu) else 0 end AS gujifangshu,");
		sql.append(" case when SUM(cbpanshu+mcbpanshu+hcbpanshu)>0 then SUM(cbpanshu+mcbpanshu+hcbpanshu) else 0 end AS lowcbps,");
		sql.append(" case when SUM(mcbpanshu+hcbpanshu)>0 then SUM(mcbpanshu+hcbpanshu) else 0 end AS midcbps,");
		sql.append(" case when SUM(hcbpanshu)>0 then SUM(hcbpanshu) else 0 end AS highcbps,");
		sql.append(" case  when SUM(a.panshu)>0 then  cast(round(cast((SUM(cbpanshu)+SUM(mcbpanshu)+SUM(hcbpanshu))*100 as numeric)/SUM(a.panshu),2) as numeric(20,2)) else 0 end AS lowcbper,");
		sql.append(" case  when SUM(a.panshu)>0 then  cast(round(cast((SUM(mcbpanshu)+SUM(hcbpanshu))*100 as numeric)/SUM(a.panshu),2) as numeric(20,2))  else 0 end  AS midcbper,");
		sql.append(" case  when SUM(a.panshu)>0 then  cast(round(cast(SUM(hcbpanshu)*100 as numeric)/SUM(a.panshu),2) as numeric(20,2)) else 0 end  AS highcbper ");
		sql.append(" FROM ( select shebeibianhao,chuliaodate,panshu,zongfashu,0 as cbpanshu,0 as mcbpanshu,0 as hcbpanshu,0 as cczpanshu,0 as mczpanshu,0 as hczpanshu from tongji_cl ");
		sql.append(" union all ");
		sql.append(" select shebeibianhao,chuliaodate,0 as panshu,0 as zongfashu,cbpanshu,mcbpanshu,hcbpanshu,cczpanshu,mczpanshu,hczpanshu from TONGJICB )  a, Banhezhanxinxi b ,t_s_depart c ");	
		return sql.toString();
	}
	
	public String sqlWhere(String startTime,String endTime,Integer cllx,Integer userlft,Integer userrgt,String shebeibianhao){
	    String sqlWhere=" a.shebeibianhao=b.gprsbianhao and b.departid=c.ID ";
	    if (StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)) {
			if (!sqlWhere.isEmpty()) {
				sqlWhere += " and";
			}
			sqlWhere += " (convert(varchar(100),chuliaodate,23) between '"+startTime+"' and '" + endTime + "')";
		}
	    if (userlft>0 && userrgt>0) {
			if (!sqlWhere.isEmpty()) {
				sqlWhere += " and";
			}
			sqlWhere += " c.lft >= '"+userlft+"' and c.rgt <= '" + userrgt + "'";
		}
	    if (StringUtil.isNotEmpty(shebeibianhao)) {
			if (!sqlWhere.isEmpty()) {
				sqlWhere += " and";
			}
			sqlWhere += " b.gprsbianhao = '"+shebeibianhao + "'";
		}
		return sqlWhere;
	}
	
	public String sqlGroup(Integer cllx){
		StringBuffer sql=new StringBuffer();
		switch (cllx) {
			case 1:
				sql.append(" group by year(a.chuliaodate)  , datename(quarter,a.chuliaodate)");
				break;
			case 2:
				sql.append(" group by year(a.chuliaodate)  , datename(month,a.chuliaodate)");
				break;
			case 3:
				sql.append(" group by year(a.chuliaodate)  , datename(week,a.chuliaodate) ");
				break;
			default:
				break;
		}
		return sql.toString();
	}
	
	public List<HntCountAnalyze> HntCountAnalyze(Integer userlft,Integer userrgt,String startTime,String endTime,String shebeibianhao,Integer cllx){
		List<HntCountAnalyze> hntCountlist=new ArrayList<HntCountAnalyze>();
		try{
			StringBuffer sql=new StringBuffer();
			sql.append(appendSQL(cllx));
			if (!sqlWhere(startTime,endTime,cllx,userlft,userrgt,shebeibianhao).isEmpty()) {
				sql.append(" where "+sqlWhere(startTime,endTime,cllx,userlft,userrgt,shebeibianhao));
			}
			sql.append(sqlGroup(cllx));
			sql.append(" order by xa asc ,xb asc ");
			List<Object[]> list=findListbySql(sql.toString());
			if(list.size()>0){
				for(int i=0;i<list.size();i++){
					Object[] objArr=list.get(i);
					HntCountAnalyze hntCount=new HntCountAnalyze();
					hntCount.setXa(String.valueOf(objArr[0]));
					hntCount.setXb(String.valueOf(objArr[1]));
					hntCount.setPangshu(String.valueOf(objArr[2]));
					hntCount.setGujifangshu(String.valueOf(objArr[3]));
					hntCount.setLowcbps(String.valueOf(objArr[4]));
					hntCount.setMidcbps(String.valueOf(objArr[5]));
					hntCount.setHighcbps(String.valueOf(objArr[6]));
					hntCount.setLowcbper(String.valueOf(objArr[7]));
					hntCount.setMidcbper(String.valueOf(objArr[8]));
					hntCount.setHighcbper(String.valueOf(objArr[9]));
					hntCountlist.add(hntCount);
				}
			}
		}catch(Exception ex){}
		return hntCountlist;
	}
	
	public List<ShebeiListBean> getShebeilist(Integer userlft,Integer userrgt){
		List<ShebeiListBean> shebeiList=null;
		try{
			StringBuffer sql=new StringBuffer("select gprsbianhao,banhezhanminchen,departid from BanhezhanxinxiView where 1=1");
			if (userlft>0 && userrgt>0) {
				sql.append(" and (lft >='"+userlft+"' and rgt<='"+userrgt+"')");
			}
			shebeiList=jdbcDao.find(sql.toString(),ShebeiListBean.class, new HashMap<String, String>());
		}catch(Exception ex){}
		return shebeiList;
	}
	
	public HunnintuView getXiangxixxDetailById(Integer bianhao){
		HunnintuView hv=getEntity(HunnintuView.class, bianhao);
		//实际用量
		try{
			hv.setSha1_shijizhi(String.format("%1$.2f",hv.getSha1_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setShi1_shijizhi(String.format("%1$.2f",hv.getShi1_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setShi2_shijizhi(String.format("%1$.2f",hv.getShi2_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setSha2_shijizhi(String.format("%1$.2f",hv.getSha2_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setGuliao5_shijizhi(String.format("%1$.2f",hv.getGuliao5_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setShuini1_shijizhi(String.format("%1$.2f",hv.getShuini1_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setShuini2_shijizhi(String.format("%1$.2f",hv.getShuini2_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setKuangfen3_shijizhi(String.format("%1$.2f",hv.getKuangfen3_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setFeimeihui4_shijizhi(String.format("%1$.2f",hv.getFeimeihui4_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setFenliao5_shijizhi(String.format("%1$.2f",hv.getFenliao5_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setFenliao6_shijizhi(String.format("%1$.2f",hv.getFenliao6_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setShui1_shijizhi(String.format("%1$.2f",hv.getShui1_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setShui2_shijizhi(String.format("%1$.2f",hv.getShui2_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setWaijiaji1_shijizhi(String.format("%1$.2f",hv.getWaijiaji1_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setWaijiaji2_shijizhi(String.format("%1$.2f",hv.getWaijiaji2_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setWaijiaji3_shijizhi(String.format("%1$.2f",hv.getWaijiaji3_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setWaijiaji4_shijizhi(String.format("%1$.2f",hv.getWaijiaji4_shijizhi()));
		}catch(Exception ex){}
		//理论配比
		try{
			hv.setSha1_lilunzhi(String.format("%1$.2f",hv.getSha1_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setShi1_lilunzhi(String.format("%1$.2f",hv.getShi1_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setShi2_lilunzhi(String.format("%1$.2f",hv.getShi2_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setSha2_lilunzhi(String.format("%1$.2f",hv.getSha2_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setGuliao5_lilunzhi(String.format("%1$.2f",hv.getGuliao5_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setShuini1_lilunzhi(String.format("%1$.2f",hv.getShuini1_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setShuini2_lilunzhi(String.format("%1$.2f",hv.getShuini2_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setKuangfen3_lilunzhi(String.format("%1$.2f",hv.getKuangfen3_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setFeimeihui4_lilunzhi(String.format("%1$.2f",hv.getFeimeihui4_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setFenliao5_lilunzhi(String.format("%1$.2f",hv.getFenliao5_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setFenliao6_lilunzhi(String.format("%1$.2f",hv.getFenliao6_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setShui1_lilunzhi(String.format("%1$.2f",hv.getShui1_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setShui2_lilunzhi(String.format("%1$.2f",hv.getShui2_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setWaijiaji1_lilunzhi(String.format("%1$.2f",hv.getWaijiaji1_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setWaijiaji2_lilunzhi(String.format("%1$.2f",hv.getWaijiaji2_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setWaijiaji3_lilunzhi(String.format("%1$.2f",hv.getWaijiaji3_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setWaijiaji4_lilunzhi(String.format("%1$.2f",hv.getWaijiaji4_lilunzhi()));
		}catch(Exception ex){}
		//误差
		try{
			hv.setWjw4(StringUtil.toFloat(String.format("%1$.2f",hv.getWjw4())));
		}catch(Exception ex){}
		try{
			hv.setWjw3(StringUtil.toFloat(String.format("%1$.2f",hv.getWjw3())));
		}catch(Exception ex){}
		try{
			hv.setWjw2(StringUtil.toFloat(String.format("%1$.2f",hv.getWjw2())));
		}catch(Exception ex){}
		try{
			hv.setWjw1(StringUtil.toFloat(String.format("%1$.2f",hv.getWjw1())));
		}catch(Exception ex){}
		try{
			hv.setShw2(StringUtil.toFloat(String.format("%1$.2f",hv.getShw2())));
		}catch(Exception ex){}
		try{
			hv.setShw1(StringUtil.toFloat(String.format("%1$.2f",hv.getShw1())));
		}catch(Exception ex){}
		try{
			hv.setFlw6(StringUtil.toFloat(String.format("%1$.2f",hv.getFlw6())));
		}catch(Exception ex){}
		try{
			hv.setFlw5(StringUtil.toFloat(String.format("%1$.2f",hv.getFlw5())));
		}catch(Exception ex){}
		try{
			hv.setFlw4(StringUtil.toFloat(String.format("%1$.2f",hv.getFlw4())));
		}catch(Exception ex){}
		try{
			hv.setFlw3(StringUtil.toFloat(String.format("%1$.2f",hv.getFlw3())));
		}catch(Exception ex){}
		try{
			hv.setFlw2(StringUtil.toFloat(String.format("%1$.2f",hv.getFlw2())));
		}catch(Exception ex){}
		try{
			hv.setFlw1(StringUtil.toFloat(String.format("%1$.2f",hv.getFlw1())));
		}catch(Exception ex){}
		try{
			hv.setGlw5(StringUtil.toFloat(String.format("%1$.2f",hv.getGlw5())));
		}catch(Exception ex){}
		try{
			hv.setGlw4(StringUtil.toFloat(String.format("%1$.2f",hv.getGlw4())));
		}catch(Exception ex){}
		try{
			hv.setGlw3(StringUtil.toFloat(String.format("%1$.2f",hv.getGlw3())));
		}catch(Exception ex){}
		try{
			hv.setGlw2(StringUtil.toFloat(String.format("%1$.2f",hv.getGlw2())));
		}catch(Exception ex){}
		try{
			hv.setGlw1(StringUtil.toFloat(String.format("%1$.2f",hv.getGlw1())));
		}catch(Exception ex){}
		//百分率
		try{
			hv.setWjper4(StringUtil.toFloat(String.format("%1$.2f",hv.getWjper4())));
		}catch(Exception ex){}
		try{
			hv.setWjper3(StringUtil.toFloat(String.format("%1$.2f",hv.getWjper3())));
		}catch(Exception ex){}
		try{
			hv.setWjper2(StringUtil.toFloat(String.format("%1$.2f",hv.getWjper2())));
		}catch(Exception ex){}
		try{
			hv.setWjper1(StringUtil.toFloat(String.format("%1$.2f",hv.getWjper1())));
		}catch(Exception ex){}
		try{
			hv.setShper2(StringUtil.toFloat(String.format("%1$.2f",hv.getShper2())));
		}catch(Exception ex){}
		try{
			hv.setShper1(StringUtil.toFloat(String.format("%1$.2f",hv.getShper1())));
		}catch(Exception ex){}
		try{
			hv.setFlper6(StringUtil.toFloat(String.format("%1$.2f",hv.getFlper6())));
		}catch(Exception ex){}
		try{
			hv.setFlper5(StringUtil.toFloat(String.format("%1$.2f",hv.getFlper5())));
		}catch(Exception ex){}
		try{
			hv.setFlper4(StringUtil.toFloat(String.format("%1$.2f",hv.getFlper4())));
		}catch(Exception ex){}
		try{
			hv.setFlper3(StringUtil.toFloat(String.format("%1$.2f",hv.getFlper3())));
		}catch(Exception ex){}
		try{
			hv.setFlper2(StringUtil.toFloat(String.format("%1$.2f",hv.getFlper2())));
		}catch(Exception ex){}
		try{
			hv.setFlper1(StringUtil.toFloat(String.format("%1$.2f",hv.getFlper1())));
		}catch(Exception ex){}
		try{
			hv.setGlper5(StringUtil.toFloat(String.format("%1$.2f",hv.getGlper5())));
		}catch(Exception ex){}
		try{
			hv.setGlper4(StringUtil.toFloat(String.format("%1$.2f",hv.getGlper4())));
		}catch(Exception ex){}
		try{
			hv.setGlper3(StringUtil.toFloat(String.format("%1$.2f",hv.getGlper3())));
		}catch(Exception ex){}
		try{
			hv.setGlper2(StringUtil.toFloat(String.format("%1$.2f",hv.getGlper2())));
		}catch(Exception ex){}
		try{
			hv.setGlper1(StringUtil.toFloat(String.format("%1$.2f",hv.getGlper1())));
		}catch(Exception ex){}
		return hv;
	}
	
	//超标查询与处置详情
	public HunnintuchaobiaoViewEntity gethntchaobiaoDetailById(Integer bianhao){
		HunnintuchaobiaoViewEntity hv=getEntity(HunnintuchaobiaoViewEntity.class, bianhao);
		//实际用量
		try{
			hv.setSha1_shijizhi(String.format("%1$.2f",hv.getSha1_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setShi1_shijizhi(String.format("%1$.2f",hv.getShi1_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setShi2_shijizhi(String.format("%1$.2f",hv.getShi2_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setSha2_shijizhi(String.format("%1$.2f",hv.getSha2_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setGuliao5_shijizhi(String.format("%1$.2f",hv.getGuliao5_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setShuini1_shijizhi(String.format("%1$.2f",hv.getShuini1_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setShuini2_shijizhi(String.format("%1$.2f",hv.getShuini2_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setKuangfen3_shijizhi(String.format("%1$.2f",hv.getKuangfen3_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setFeimeihui4_shijizhi(String.format("%1$.2f",hv.getFeimeihui4_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setFenliao5_shijizhi(String.format("%1$.2f",hv.getFenliao5_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setFenliao6_shijizhi(String.format("%1$.2f",hv.getFenliao6_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setShui1_shijizhi(String.format("%1$.2f",hv.getShui1_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setShui2_shijizhi(String.format("%1$.2f",hv.getShui2_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setWaijiaji1_shijizhi(String.format("%1$.2f",hv.getWaijiaji1_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setWaijiaji2_shijizhi(String.format("%1$.2f",hv.getWaijiaji2_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setWaijiaji3_shijizhi(String.format("%1$.2f",hv.getWaijiaji3_shijizhi()));
		}catch(Exception ex){}
		try{
			hv.setWaijiaji4_shijizhi(String.format("%1$.2f",hv.getWaijiaji4_shijizhi()));
		}catch(Exception ex){}
		//理论配比
		try{
			hv.setSha1_lilunzhi(String.format("%1$.2f",hv.getSha1_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setShi1_lilunzhi(String.format("%1$.2f",hv.getShi1_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setShi2_lilunzhi(String.format("%1$.2f",hv.getShi2_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setSha2_lilunzhi(String.format("%1$.2f",hv.getSha2_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setGuliao5_lilunzhi(String.format("%1$.2f",hv.getGuliao5_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setShuini1_lilunzhi(String.format("%1$.2f",hv.getShuini1_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setShuini2_lilunzhi(String.format("%1$.2f",hv.getShuini2_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setKuangfen3_lilunzhi(String.format("%1$.2f",hv.getKuangfen3_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setFeimeihui4_lilunzhi(String.format("%1$.2f",hv.getFeimeihui4_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setFenliao5_lilunzhi(String.format("%1$.2f",hv.getFenliao5_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setFenliao6_lilunzhi(String.format("%1$.2f",hv.getFenliao6_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setShui1_lilunzhi(String.format("%1$.2f",hv.getShui1_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setShui2_lilunzhi(String.format("%1$.2f",hv.getShui2_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setWaijiaji1_lilunzhi(String.format("%1$.2f",hv.getWaijiaji1_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setWaijiaji2_lilunzhi(String.format("%1$.2f",hv.getWaijiaji2_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setWaijiaji3_lilunzhi(String.format("%1$.2f",hv.getWaijiaji3_lilunzhi()));
		}catch(Exception ex){}
		try{
			hv.setWaijiaji4_lilunzhi(String.format("%1$.2f",hv.getWaijiaji4_lilunzhi()));
		}catch(Exception ex){}
		//误差
		try{
			hv.setWjw4(String.format("%1$.2f",hv.getWjw4()));
		}catch(Exception ex){}
		try{
			hv.setWjw3(String.format("%1$.2f",hv.getWjw3()));
		}catch(Exception ex){}
		try{
			hv.setWjw2(String.format("%1$.2f",hv.getWjw2()));
		}catch(Exception ex){}
		try{
			hv.setWjw1(String.format("%1$.2f",hv.getWjw1()));
		}catch(Exception ex){}
		try{
			hv.setShw2(String.format("%1$.2f",hv.getShw2()));
		}catch(Exception ex){}
		try{
			hv.setShw1(String.format("%1$.2f",hv.getShw1()));
		}catch(Exception ex){}
		try{
			hv.setFlw6(String.format("%1$.2f",hv.getFlw6()));
		}catch(Exception ex){}
		try{
			hv.setFlw5(String.format("%1$.2f",hv.getFlw5()));
		}catch(Exception ex){}
		try{
			hv.setFlw4(String.format("%1$.2f",hv.getFlw4()));
		}catch(Exception ex){}
		try{
			hv.setFlw3(String.format("%1$.2f",hv.getFlw3()));
		}catch(Exception ex){}
		try{
			hv.setFlw2(String.format("%1$.2f",hv.getFlw2()));
		}catch(Exception ex){}
		try{
			hv.setFlw1(String.format("%1$.2f",hv.getFlw1()));
		}catch(Exception ex){}
		try{
			hv.setGlw5(String.format("%1$.2f",hv.getGlw5()));
		}catch(Exception ex){}
		try{
			hv.setGlw4(String.format("%1$.2f",hv.getGlw4()));
		}catch(Exception ex){}
		try{
			hv.setGlw3(String.format("%1$.2f",hv.getGlw3()));
		}catch(Exception ex){}
		try{
			hv.setGlw2(String.format("%1$.2f",hv.getGlw2()));
		}catch(Exception ex){}
		try{
			hv.setGlw1(String.format("%1$.2f",hv.getGlw1()));
		}catch(Exception ex){}
		//百分率
		try{
			hv.setWjper4(String.format("%1$.2f",hv.getWjper4()));
		}catch(Exception ex){}
		try{
			hv.setWjper3(String.format("%1$.2f",hv.getWjper3()));
		}catch(Exception ex){}
		try{
			hv.setWjper2(String.format("%1$.2f",hv.getWjper2()));
		}catch(Exception ex){}
		try{
			hv.setWjper1(String.format("%1$.2f",hv.getWjper1()));
		}catch(Exception ex){}
		try{
			hv.setShper2(String.format("%1$.2f",hv.getShper2()));
		}catch(Exception ex){}
		try{
			hv.setShper1(String.format("%1$.2f",hv.getShper1()));
		}catch(Exception ex){}
		try{
			hv.setFlper6(String.format("%1$.2f",hv.getFlper6()));
		}catch(Exception ex){}
		try{
			hv.setFlper5(String.format("%1$.2f",hv.getFlper5()));
		}catch(Exception ex){}
		try{
			hv.setFlper4(String.format("%1$.2f",hv.getFlper4()));
		}catch(Exception ex){}
		try{
			hv.setFlper3(String.format("%1$.2f",hv.getFlper3()));
		}catch(Exception ex){}
		try{
			hv.setFlper2(String.format("%1$.2f",hv.getFlper2()));
		}catch(Exception ex){}
		try{
			hv.setFlper1(String.format("%1$.2f",hv.getFlper1()));
		}catch(Exception ex){}
		try{
			hv.setGlper5(String.format("%1$.2f",hv.getGlper5()));
		}catch(Exception ex){}
		try{
			hv.setGlper4(String.format("%1$.2f",hv.getGlper4()));
		}catch(Exception ex){}
		try{
			hv.setGlper3(String.format("%1$.2f",hv.getGlper3()));
		}catch(Exception ex){}
		try{
			hv.setGlper2(String.format("%1$.2f",hv.getGlper2()));
		}catch(Exception ex){}
		try{
			hv.setGlper1(String.format("%1$.2f",hv.getGlper1()));
		}catch(Exception ex){}
		return hv;
	}
	
	//jdbc连接
	public Connection getCon(){
		Connection con = null;
			try {
				con = SessionFactoryUtils.getDataSource(getSession().getSessionFactory()).getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return con;
	}
	
	public void closeCon(Connection con,Statement st,ResultSet rs) throws SQLException{
		if(rs!=null)
			rs.close();
		if(st!=null)
			st.close();
		if(con!=null)
			con.close();
	}
}
