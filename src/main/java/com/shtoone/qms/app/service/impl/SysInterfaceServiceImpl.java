package com.shtoone.qms.app.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shtoone.qms.app.entity.AppHntSysHPData;
import com.shtoone.qms.app.entity.AppSyTypeBean;
import com.shtoone.qms.app.entity.HntkangyaWarnBean;
import com.shtoone.qms.app.entity.ShebeiListBean;
import com.shtoone.qms.app.entity.SmsinfoEntity;
import com.shtoone.qms.app.entity.SysCountAnalyze;
import com.shtoone.qms.app.entity.SysCountBean;
import com.shtoone.qms.app.entity.SysMainLogoBean;
import com.shtoone.qms.app.entity.SysWNJDetailBean;
import com.shtoone.qms.app.entity.SysWNJlistBean;
import com.shtoone.qms.app.entity.SysYLJDetailBean;
import com.shtoone.qms.app.entity.SysYLJlistBean;
import com.shtoone.qms.app.service.SmsinfoInterfaceService;
import com.shtoone.qms.app.service.SysInterfaceService;

@Service("sysInterfaceService")
@Transactional
public class SysInterfaceServiceImpl extends CommonServiceImpl implements SysInterfaceService{
	
	@Autowired
	private SmsinfoInterfaceService smsinfoService;
	
	@Autowired
	private JdbcDao jdbcDao;
	
	public List<SysCountBean> getSysHome(Integer lft,Integer rgt,String startTime,String endTime) {
		String CountSQL="select tj.SYLX AS departname,SUM(CAST(tj.SYSL as int)) AS SYSL,SUM(CAST(tj.BUHEGE as int)) AS BUHEGE,tst.testname " +
		" from T_tongji_syjView tj join T_SYJZB_TYPE tst on tj.SYLX = tst.testid where 1=1 ";
		String czpSQL = "select count(*) AS realCount from T_SYJZBRealView where 1=1 and (ISNULL(chuli,'')<>'') ";
		String sysCountSQL = "select count(*) AS sysCount from ShiyanshiInfo si join t_s_depart ts on ts.id = si.shiyanshi_guid where 1=1 ";
		String syjCountSQL = "select count(*) AS syjCount from ShebeiInfo si join t_s_depart ts on ts.id = si.shiyanshi_guid where 1=1 ";
		if(StringUtil.isNotEmpty(lft) && StringUtil.isNotEmpty(rgt)){
			CountSQL+=" and (lft >='"+lft+"' and rgt<='"+rgt+"') ";
			czpSQL+=" and (lft >='"+lft+"' and rgt<='"+rgt+"') ";
			sysCountSQL+=" and (lft >='"+lft+"' and rgt<='"+rgt+"') ";
			syjCountSQL+=" and (lft >='"+lft+"' and rgt<='"+rgt+"') ";
		}
		if(StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)){
			CountSQL+=" and (SYRQ between '"+startTime+"' and '"+endTime+"') ";
			czpSQL+=" and (SYRQ between '"+startTime+"' and '"+endTime+"') ";
		}
		CountSQL+=" GROUP BY tj.SYLX,tst.testname";
		SysCountBean sys = null;
		List<Object[]> list=findListbySql(CountSQL);
		List<SysCountBean> sycList = new ArrayList<SysCountBean>();
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] objArr=list.get(i);
				sys=new SysCountBean();
				sys.setTesttype(String.valueOf(objArr[0]));
				sys.setTestCount(String.valueOf(objArr[1]));
				sys.setNotQualifiedCount(String.valueOf(objArr[2]));
				sys.setTestName(String.valueOf(objArr[3]));
				//这里来寻找特定试验室的处置率
				long realCount=getCountForJdbc(czpSQL+" and SYLX='"+sys.getTesttype()+"' ");
				
				sys.setRealCount(String.valueOf(realCount));
				if(Integer.parseInt(sys.getTestCount())==0){
					sys.setRealPer("0.00");
				}else{
					try{
						if(!StringUtil.isEmpty(sys.getNotQualifiedCount())&&!"0".equals(sys.getNotQualifiedCount())){
							sys.setRealPer(String.format("%1$.2f",Float.parseFloat(String.valueOf(realCount))/Float.parseFloat(sys.getNotQualifiedCount())*100));
						}else{
							sys.setRealPer("0.00");
						}
					}catch(Exception ex){}
				}
				//计算当前组织机构下面用于多少拌和机、试验室
				long sysCount=getCountForJdbc(sysCountSQL);
				sys.setSysCount(String.valueOf(sysCount));
				long syjCount=getCountForJdbc(syjCountSQL);
				sys.setSyjCount(String.valueOf(syjCount));
				sycList.add(sys);
			}
		}
		return sycList;
	}
	
	/*
	@Override
	public List<SysCountBean> getSysHome(String lft,String rgt,String startTime,String endTime) {
		List<SysCountBean> sysCountList=new ArrayList<SysCountBean>();
		String CountSQL="select SYLX,ID,MAX(departname) AS departname,SUM(CAST(SYSL as int)) AS SYSL,SUM(CAST(BUHEGE as int)) AS BUHEGE from T_tongji_syjView where 1=1";
		if(StringUtil.isNotEmpty(lft) && StringUtil.isNotEmpty(rgt)){
			CountSQL+=" and (lft >='"+lft+"' and rgt<='"+rgt+"') ";
		}
		if(StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)){
			CountSQL+=" and (SYRQ between '"+startTime+"' and '"+endTime+"')";
		}
		CountSQL+=" GROUP BY SYLX,ID";
		List<Object[]> list=findListbySql(CountSQL);
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] objArr=list.get(i);
				SysCountBean sys=new SysCountBean();
				sys.setTesttype(String.valueOf(objArr[0]));
				sys.setUserGroupId(String.valueOf(objArr[1]));
				sys.setDepartName(String.valueOf(objArr[2]));
				sys.setTestCount(String.valueOf(objArr[3]));
				sys.setNotQualifiedCount(String.valueOf(objArr[4]));
				//这里来寻找特定试验室的处置率
				long realCount=getCountForJdbc("select count(*) AS realCount from T_SYJZBRealView where 1=1 and (ISNULL(chuli,'')<>'') and departid='"+sys.getUserGroupId()+"' and SYLX='"+sys.getTesttype()+"'");
				sys.setRealCount(String.valueOf(realCount));
				if(Integer.parseInt(sys.getTestCount())==0){
					sys.setRealPer("0");
				}else{
					try{
						sys.setRealPer(String.format("%1$.2f",Float.parseFloat(String.valueOf(realCount))/Float.parseFloat(sys.getTestCount())*100));
					}catch(Exception ex){}
				}
				//计算当前组织机构下面用于多少拌和机、试验室
				long sysCount=getCountForJdbc("select count(*) AS sysCount from ShiyanshiInfo where shiyanshi_guid='"+sys.getUserGroupId()+"'");
				sys.setSysCount(String.valueOf(sysCount));
				long syjCount=getCountForJdbc("select count(*) AS syjCount from ShebeiInfo where shiyanshi_guid='"+sys.getUserGroupId()+"'");
				sys.setSyjCount(String.valueOf(syjCount));
				sysCountList.add(sys);
			}
		}
		return sysCountList;
	}
	*/
	
	public List<SysWNJlistBean> gangjinSel(String lft,String rgt,String startTime,String endTime,String isQualified,Integer pageNo,Integer maxPageItems,String shebeibianhao,String isReal,String testType){
		String sql="select SYRQ,shebeiname,SJBH,PZBM,GCMC,SGBW,PDJG,SYJID,testName,CASE WHEN (isnull(chuli,'')='') THEN '0' WHEN (isnull(chuli,'')!='') THEN '1' ELSE '-1' END as chuzhi from T_SYJZBView where testtype='2' ";
		if(StringUtil.isNotEmpty(lft) && StringUtil.isNotEmpty(rgt)){
			sql+=" and (lft >='"+lft+"' and rgt<='"+rgt+"') ";
		}
		if(StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)){
			sql+=" and (SYRQ between '"+startTime+"' and '"+endTime+"')";
		}
		if(StringUtil.isNotEmpty(testType)){
			sql+=" and SYLX='"+testType+"' ";
		}
		if(StringUtil.isNotEmpty(isQualified)){
			sql+=" and PDJG='"+isQualified+"'";
		}
		if(StringUtil.isNotEmpty(shebeibianhao)){
			sql+=" and SBBH='"+shebeibianhao+"'";
		}
		if(StringUtil.isNotEmpty(isReal)){
			if(isReal.equalsIgnoreCase("0")){
				
			}else if(isReal.equalsIgnoreCase("1")){
				sql+=" and ISNULL(chuli,'')='' ";
			}else if(isReal.equalsIgnoreCase("2")){
				sql+=" and ISNULL(chuli,'')<>'' ";
			}
		}
		sql+=" ORDER BY SYRQ DESC";
		System.out.println(sql);
		List<SysWNJlistBean> list = findObjForJdbc(sql,pageNo,maxPageItems,SysWNJlistBean.class);
		return list;
	}
	
	public List<SysYLJlistBean> hntkangyaSel(String lft,String rgt,String startTime,String endTime,String isQualified,Integer pageNo,Integer maxPageItems,String shebeibianhao,String isReal,String testType){
		String sql="select SYRQ,shebeiname,SJQD,QDDBZ,GCMC,SGBW,PDJG,SYJID,testName,SJBH,CASE WHEN (isnull(chuli,'')='') THEN '0' WHEN (isnull(chuli,'')!='') THEN '1' ELSE '-1' END as chuzhi from T_SYJZBView where testtype='1' ";
		if(StringUtil.isNotEmpty(testType)){
			sql+="and SYLX='"+testType+"' ";
		}
		if(StringUtil.isNotEmpty(lft) && StringUtil.isNotEmpty(rgt)){
			sql+=" and (lft >='"+lft+"' and rgt<='"+rgt+"') ";
		}
		if(StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)){
			sql+=" and (SYRQ between '"+startTime+"' and '"+endTime+"') ";
		}
		if(StringUtil.isNotEmpty(isQualified)){
			//如果是在处置和未处置页面
			if(StringUtil.isNotEmpty(isReal)&&!isReal.equals("0")){
				if(isQualified.equals("3")||isQualified.equals("0")){
					sql+=" and PDJG in ('不合格','无效') ";
				}else if(isQualified.equals("1")||isQualified.equals("2")){
					sql+=" and PDJG in ('合格','有效') ";
				}
			}else{
				sql+=" and PDJG = '"+StringUtil.changeVaule(isQualified)+"' ";
			}
		}
		if(StringUtil.isNotEmpty(shebeibianhao)){
			sql+=" and SBBH='"+shebeibianhao+"' ";
		}
		if(StringUtil.isNotEmpty(isReal)){
			if(isReal.equalsIgnoreCase("0")){
				
			}else if(isReal.equalsIgnoreCase("1")){
				sql+=" and ISNULL(chuli,'')='' ";
			}else if(isReal.equalsIgnoreCase("2")){
				sql+=" and ISNULL(chuli,'')<>'' ";
			}
		}
		sql+=" ORDER BY SYRQ DESC";
		System.out.println(sql);
		return findObjForJdbc(sql,pageNo,maxPageItems,SysYLJlistBean.class);
	}
	
	public List<SysWNJlistBean> gangjinhanjiejietouSel(String lft,String rgt,String startTime,String endTime,String isQualified,Integer pageNo,Integer maxPageItems,String shebeibianhao,String isReal,String testType){
		String sql="select SYRQ,shebeiname,SJBH,PZBM,GCMC,SGBW,PDJG,SYJID,testName from T_SYJZBView where testtype='2' ";
		if(StringUtil.isNotEmpty(lft) && StringUtil.isNotEmpty(rgt)){
			sql+=" and (lft >='"+lft+"' and rgt<='"+rgt+"') ";
		}
		if(StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)){
			sql+=" and (SYRQ between '"+startTime+"' and '"+endTime+"')";
		}
		if(StringUtil.isNotEmpty(isQualified)){
			sql+=" and PDJG='"+isQualified+"'";
		}
		if(StringUtil.isNotEmpty(shebeibianhao)){
			sql+=" and SBBH='"+shebeibianhao+"'";
		}
		if(StringUtil.isNotEmpty(testType)){
			sql+=" and SYLX='"+testType+"' ";
		}
		if(StringUtil.isNotEmpty(isReal)){
			if(isReal.equalsIgnoreCase("0")){
				
			}else if(isReal.equalsIgnoreCase("1")){
				sql+=" and ISNULL(chuli,'')='' ";
			}else if(isReal.equalsIgnoreCase("2")){
				sql+=" and ISNULL(chuli,'')<>'' ";
			}
		}
		sql+=" ORDER BY SYRQ DESC";
		return findObjForJdbc(sql,pageNo,maxPageItems,SysWNJlistBean.class);
	}
	
	public List<AppSyTypeBean> shijianType(String testtype){
		List<AppSyTypeBean> as = null;
		String sql="select * from T_SYJZB_TYPE where 1=1";
		if(StringUtil.isNotEmpty(testtype)){
			sql+=" and testtype='"+testtype+"' ";
		}
		try{
			as = jdbcDao.find(sql, AppSyTypeBean.class, new HashMap<String, String>());
		}catch(Exception e){
			e.printStackTrace();
		}
		return as;
	}
	
	public void SyType(List<AppSyTypeBean> wnj,List<AppSyTypeBean> ylj){
		
		Statement cs = null;
		Connection con = null;
		ResultSet rs = null;
			
		List<AppSyTypeBean> asList = null;
		String sql="select * from T_SYJZB_TYPE";
		try{
			con = SessionFactoryUtils.getDataSource(getSession().getSessionFactory()).getConnection();
			cs = con.createStatement();
			rs = cs.executeQuery(sql);
			while(rs.next()){
				AppSyTypeBean as = new AppSyTypeBean();
				as.setTestId(rs.getString("testid"));
				as.setTestName(rs.getString("testname"));
				as.setTestType(rs.getString("testtype"));
				if("1".equals(rs.getString("testtype"))){
					ylj.add(as);
				}else if("2".equals(rs.getString("testtype"))){
					wnj.add(as);
				}
			}
			
			//asList = jdbcDao.find(sql, AppSyTypeBean.class, new HashMap<String, String>());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				closeCon(con,cs,rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void SyMac(List<ShebeiListBean> wnjsb,List<ShebeiListBean> yljsb,String lft,String rgt){
		
		Statement cs = null;
		Connection con = null;
		ResultSet rs = null;
		
		StringBuffer sql=new StringBuffer("select t.sbbh,tst.testType,v.shebeiname from (select SBBH,SYLX from T_SYJZB group by SBBH,SYLX) t join V_ShebeiInfo v on t.sbbh=v.shebeibianhao join T_SYJZB_TYPE tst on tst.testid = t.sylx");
		if (StringUtil.isNotEmpty(lft) && StringUtil.isNotEmpty(rgt)) {
			sql.append(" and (lft >='"+lft+"' and rgt<='"+rgt+"')");
		}
		
		try{
			con = SessionFactoryUtils.getDataSource(getSession().getSessionFactory()).getConnection();
			con.setAutoCommit(false);
			cs = con.createStatement();
			rs = cs.executeQuery(sql.toString());
			while(rs.next()){
				ShebeiListBean as = new ShebeiListBean();
				as.setGprsbianhao(rs.getString("sbbh"));
				as.setBanhezhanminchen(rs.getString("shebeiname"));
//				as.setDepartid(rs.getString("departid"));
				
				if("1".equals(rs.getString("testType"))){
					wnjsb.add(as);
				}else if("2".equals(rs.getString("testType"))){
					yljsb.add(as);
				}
			}
			con.commit();
			con.setAutoCommit(true);
			
			//asList = jdbcDao.find(sql, AppSyTypeBean.class, new HashMap<String, String>());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				closeCon(con,cs,rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public List<SysWNJlistBean> gangjinlianjiejietouSel(String lft,String rgt,String startTime,String endTime,String isQualified,Integer pageNo,Integer maxPageItems,String shebeibianhao,String isReal,String testType){
		String sql="select SYRQ,shebeiname,WTBH,SJBH,PZBM,GCMC,SGBW,PDJG,SYJID from T_SYJZBView where SYLX='100049' ";
		if(StringUtil.isNotEmpty(lft) && StringUtil.isNotEmpty(rgt)){
			sql+=" and (lft >='"+lft+"' and rgt<='"+rgt+"') ";
		}
		if(StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)){
			sql+=" and (SYRQ between '"+startTime+"' and '"+endTime+"')";
		}
		if(StringUtil.isNotEmpty(isQualified)){
			sql+=" and PDJG='"+isQualified+"'";
		}
		if(StringUtil.isNotEmpty(shebeibianhao)){
			sql+=" and SBBH='"+shebeibianhao+"'";
		}
		if(StringUtil.isNotEmpty(testType)){
			sql+=" and SYLX='"+testType+"' ";
		}
		if(StringUtil.isNotEmpty(isReal)){
			if(isReal.equalsIgnoreCase("0")){
				
			}else if(isReal.equalsIgnoreCase("1")){
				sql+=" and ISNULL(chuli,'')='' ";
			}else if(isReal.equalsIgnoreCase("2")){
				sql+=" and ISNULL(chuli,'')<>'' ";
			}
		}
		sql+=" ORDER BY SYRQ DESC";
		return findObjForJdbc(sql,pageNo,maxPageItems,SysWNJlistBean.class);
	}
	
	public SysYLJDetailBean hntkangyaDetail(String SYJID){
		SysYLJDetailBean sys=new SysYLJDetailBean();
		String fatherSQL="select shebeiname,SYRQ,WTBH AS GCMC,CJMC AS SGBW,SJBH,SJQD,QDDBZ,LQ,SJCC,PDJG,F_GUID,KYLZ,KYQD,testName from V_Yaliji where SYJID='"+SYJID+"'";
		String KYLZ="";  //荷载
		String KYQD="";  //强度单值
		String F_SJ="";  //X轴时间       
		String F_LZ="";  //Y轴力值
		String F_GUID="";  //F_Yaliji表的ID
		List<Object[]> list=findListbySql(fatherSQL);
		String [] ArrStr=new String[list.size()];  //定义空的字符串数组用来存放F_GUID
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] objArr=list.get(i);
				if(i==list.size()-1){
					sys.setShebeiname(StringUtil.isEmpty(String.valueOf(objArr[0]),""));
					sys.setSYRQ(StringUtil.isEmpty(String.valueOf(objArr[1]),""));
					sys.setGCMC(StringUtil.isEmpty(String.valueOf(objArr[2]),""));
					sys.setSGBW(StringUtil.isEmpty(String.valueOf(objArr[3]),""));
					sys.setSJBH(StringUtil.isEmpty(String.valueOf(objArr[4]),""));
					sys.setSJQD(StringUtil.isEmpty(String.valueOf(objArr[5]),""));
					sys.setQDDBZ(StringUtil.isEmpty(String.valueOf(objArr[6]),""));
					sys.setLQ(StringUtil.isEmpty(String.valueOf(objArr[7]),""));
					sys.setSJCC(StringUtil.isEmpty(String.valueOf(objArr[8]),""));
					sys.setPDJG(StringUtil.isEmpty(String.valueOf(objArr[9]),""));
					F_GUID+=StringUtil.isEmpty(String.valueOf(objArr[10]),"");
					KYLZ+=StringUtil.isEmpty(String.valueOf(objArr[11]),"");
					KYQD+=StringUtil.isEmpty(String.valueOf(objArr[12]),"");
					sys.setTestName(StringUtil.isEmpty(String.valueOf(objArr[13]),""));
				}else{
					F_GUID+=StringUtil.isEmpty(String.valueOf(objArr[10]),"")+"&";
					KYLZ+=StringUtil.isEmpty(String.valueOf(objArr[11]),"")+"&";
					KYQD+=StringUtil.isEmpty(String.valueOf(objArr[12]),"")+"&";
				}
				ArrStr[i]=StringUtil.isEmpty(String.valueOf(objArr[10]),"");
				if(i==list.size()-1){
					sys.setF_GUID(F_GUID);
					sys.setKYLZ(KYLZ);
					sys.setKYQD(KYQD);
				}
			}
		}
		//还是需要在外面处理
		for(int j=0;j<ArrStr.length;j++){
			String SQL="select F_SJ,F_LZ from V_Yaliji_S where F_GUID='"+ArrStr[j]+"'";
			//此时来查询字表的数据
			List<Object[]> list2=findListbySql(SQL);
			String F_SJ_temp="";
			String F_LZ_temp="";
			if(list2.size()>0){
				for(int k=0;k<list2.size();k++){
					Object[] objArr2=list2.get(k);
					F_SJ_temp+=StringUtil.isEmpty(String.valueOf(objArr2[0]),"")+",";
					F_LZ_temp+=StringUtil.isEmpty(String.valueOf(objArr2[1]),"")+",";
				}
			}
			F_SJ+=F_SJ_temp+"&";
			F_LZ+=F_LZ_temp+"&";
		}
		sys.setF_LZ(F_LZ);
		sys.setF_SJ(F_SJ);
		//提交处理结果
		SmsinfoEntity sms=smsinfoService.findUniqueByProperty(SmsinfoEntity.class,"syjid",SYJID);
		if(sms!=null){
			sys.setChuli(sms.getChuli());
		}else{
			sys.setChuli("");
		}
		return sys;
	}
	
	//钢筋试验详情
	public SysWNJDetailBean gangjinDetail(String SYJID){
		SysWNJDetailBean sys=new SysWNJDetailBean();
		String fatherSQL="select shebeiname,SYRQ,GCMC,SGBW,SJBH,GGZL,PZBM,PDJG,QFLZ,QFQD,LZ,LZQD,SCL,F_GUID,TestName from V_Wangnj_New where SYJID='"+SYJID+"'";
		String QFLZ="";  //屈服力
		String QFQD="";  //屈服强度
		String LZ="";    //抗拉力
		String LZQD="";  //抗拉强度
		String SCL="";   //伸长率
		String F_SJ="";  //X轴坐标
		String F_LZ="";  //Y轴坐标
		String F_GUID="";  //F_Wangnj表的ID
		System.out.println("详情头信息："+fatherSQL);
		List<Object[]> list=findListbySql(fatherSQL);
		if (list.size()==0) return null;
		
		String [] ArrStr=new String[list.size()];  //定义空的字符串数组用来存放F_GUID
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] objArr=list.get(i);
				if(i==list.size()-1){
					sys.setShebeiname(StringUtil.isEmpty(String.valueOf(objArr[0]),""));
					sys.setSYRQ(StringUtil.isEmpty(String.valueOf(objArr[1]),""));
					sys.setGCMC(StringUtil.isEmpty(String.valueOf(objArr[2]),""));
					sys.setSGBW(StringUtil.isEmpty(String.valueOf(objArr[3]),""));
					sys.setSJBH(StringUtil.isEmpty(String.valueOf(objArr[4]),""));
					sys.setGGZL(StringUtil.isEmpty(String.valueOf(objArr[5]),""));
					sys.setPZBM(StringUtil.isEmpty(String.valueOf(objArr[6]),""));
					sys.setPDJG(StringUtil.isEmpty(String.valueOf(objArr[7]),""));
					QFLZ+=StringUtil.isEmpty(String.valueOf(objArr[8]),"");
					QFQD+=StringUtil.isEmpty(String.valueOf(objArr[9]),"");
					LZ+=StringUtil.isEmpty(String.valueOf(objArr[10]),"");
					LZQD+=StringUtil.isEmpty(String.valueOf(objArr[11]),"");
					SCL+=StringUtil.isEmpty(String.valueOf(objArr[12]),"");
					F_GUID+=StringUtil.isEmpty(String.valueOf(objArr[13]),"");
					sys.setTestName(StringUtil.isEmpty(String.valueOf(objArr[14]),""));
				}else{
					QFLZ+=StringUtil.isEmpty(String.valueOf(objArr[8]),"")+"&";
					QFQD+=StringUtil.isEmpty(String.valueOf(objArr[9]),"")+"&";
					LZ+=StringUtil.isEmpty(String.valueOf(objArr[10]),"")+"&";
					LZQD+=StringUtil.isEmpty(String.valueOf(objArr[11]),"")+"&";
					SCL+=StringUtil.isEmpty(String.valueOf(objArr[12]),"")+"&";
					F_GUID+=StringUtil.isEmpty(String.valueOf(objArr[13]),"")+"&";
					sys.setTestName(StringUtil.isEmpty(String.valueOf(objArr[14]),""));
				}
				ArrStr[i]=StringUtil.isEmpty(String.valueOf(objArr[13]),"");
				if(i==list.size()-1){
					sys.setF_GUID(F_GUID);
					sys.setQFLZ(QFLZ);
					sys.setQFQD(QFQD);
					sys.setLZ(LZ);
					sys.setLZQD(LZQD);
					sys.setSCL(SCL);
				}
			}
		}
		for(int j=0;j<ArrStr.length;j++){
			String SQL="select F_SJ,F_LZ from V_Wangnj_S where F_GUID='"+ArrStr[j]+"'";
			//此时来查询字表的数据
			List<Object[]> list2=findListbySql(SQL);
			String F_SJ_temp="";
			String F_LZ_temp="";
			if(list2.size()>0){
				for(int k=0;k<list2.size();k++){
					Object[] objArr2=list2.get(k);
					F_SJ_temp+=StringUtil.isEmpty(String.valueOf(objArr2[0]),"")+",";
					F_LZ_temp+=StringUtil.isEmpty(String.valueOf(objArr2[1]),"")+",";
				}
			}
			F_SJ+=F_SJ_temp+"&";
			F_LZ+=F_LZ_temp+"&";
		}
		sys.setF_LZ(F_LZ);
		sys.setF_SJ(F_SJ);
		//提交处理结果
		SmsinfoEntity sms=smsinfoService.findUniqueByProperty(SmsinfoEntity.class,"syjid",SYJID);
		if(sms!=null){
			sys.setChuli(sms.getChuli());
		}else{
			sys.setChuli("");
		}
		return sys;
	}
	
	//钢筋焊接接头试验详情
	public SysWNJDetailBean gangjinhanjiejietouDetail(String SYJID){
		SysWNJDetailBean sys=new SysWNJDetailBean();
		String fatherSQL="select shebeiname,SYRQ,GCMC,SGBW,SJBH,GGZL,PZBM,PDJG,LZ,LZQD,F_GUID from V_Wangnj_New where SYJID='"+SYJID+"'";
		String LZ="";    //抗拉力
		String LZQD="";  //抗拉强度
		String F_SJ="";  //X轴坐标
		String F_LZ="";  //Y轴坐标
		String F_GUID="";  //F_Wangnj表的ID
		List<Object[]> list=findListbySql(fatherSQL);
		String [] ArrStr=new String[list.size()];  //定义空的字符串数组用来存放F_GUID
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] objArr=list.get(i);
				if(i==list.size()-1){
					sys.setShebeiname(StringUtil.isEmpty(String.valueOf(objArr[0]),""));
					sys.setSYRQ(StringUtil.isEmpty(String.valueOf(objArr[1]),""));
					sys.setGCMC(StringUtil.isEmpty(String.valueOf(objArr[2]),""));
					sys.setSGBW(StringUtil.isEmpty(String.valueOf(objArr[3]),""));
					sys.setSJBH(StringUtil.isEmpty(String.valueOf(objArr[4]),""));
					sys.setGGZL(StringUtil.isEmpty(String.valueOf(objArr[5]),""));
					sys.setPZBM(StringUtil.isEmpty(String.valueOf(objArr[6]),""));
					sys.setPDJG(StringUtil.isEmpty(String.valueOf(objArr[7]),""));
					LZ+=StringUtil.isEmpty(String.valueOf(objArr[8]),"");
					LZQD+=StringUtil.isEmpty(String.valueOf(objArr[9]),"");
					F_GUID+=StringUtil.isEmpty(String.valueOf(objArr[10]),"");
				}else{
					LZ+=StringUtil.isEmpty(String.valueOf(objArr[8]),"")+"&";
					LZQD+=StringUtil.isEmpty(String.valueOf(objArr[9]),"")+"&";
					F_GUID+=StringUtil.isEmpty(String.valueOf(objArr[10]),"")+"&";
				}
				ArrStr[i]=StringUtil.isEmpty(String.valueOf(objArr[10]),"");
				if(i==list.size()-1){
					sys.setF_GUID(F_GUID);
					sys.setLZ(LZ);
					sys.setLZQD(LZQD);
				}
			}
		}
		for(int j=0;j<ArrStr.length;j++){
			String SQL="select F_SJ,F_LZ from V_Wangnj_S where F_GUID='"+ArrStr[j]+"'";
			//此时来查询字表的数据
			List<Object[]> list2=findListbySql(SQL);
			String F_SJ_temp="";
			String F_LZ_temp="";
			if(list2.size()>0){
				for(int k=0;k<list2.size();k++){
					Object[] objArr2=list2.get(k);
					F_SJ_temp+=StringUtil.isEmpty(String.valueOf(objArr2[0]),"")+",";
					F_LZ_temp+=StringUtil.isEmpty(String.valueOf(objArr2[1]),"")+",";
				}
			}
			F_SJ+=F_SJ_temp+"&";
			F_LZ+=F_LZ_temp+"&";
		}
		sys.setF_LZ(F_LZ);
		sys.setF_SJ(F_SJ);
		//提交处理结果
		SmsinfoEntity sms=smsinfoService.findUniqueByProperty(SmsinfoEntity.class,"syjid",SYJID);
		if(sms!=null){
			sys.setChuli(sms.getChuli());
		}else{
			sys.setChuli("");
		}		
		return sys;
	}
	
	//钢筋机械连接接头试验详情
	public SysWNJDetailBean gangjinlianjiejietouDetail(String SYJID){
		SysWNJDetailBean sys=new SysWNJDetailBean();
		String fatherSQL="select shebeiname,SYRQ,GCMC,SGBW,SJBH,GGZL,PZBM,PDJG,LZ,LZQD,F_GUID from V_Wangnj_New where SYJID='"+SYJID+"'";
		String LZ="";    //抗拉力
		String LZQD="";  //抗拉强度
		String F_SJ="";  //X轴坐标
		String F_LZ="";  //Y轴坐标
		String F_GUID="";  //F_Wangnj表的ID
		List<Object[]> list=findListbySql(fatherSQL);
		String [] ArrStr=new String[list.size()];  //定义空的字符串数组用来存放F_GUID
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] objArr=list.get(i);
				if(i==list.size()-1){
					sys.setShebeiname(StringUtil.isEmpty(String.valueOf(objArr[0]),""));
					sys.setSYRQ(StringUtil.isEmpty(String.valueOf(objArr[1]),""));
					sys.setGCMC(StringUtil.isEmpty(String.valueOf(objArr[2]),""));
					sys.setSGBW(StringUtil.isEmpty(String.valueOf(objArr[3]),""));
					sys.setSJBH(StringUtil.isEmpty(String.valueOf(objArr[4]),""));
					sys.setGGZL(StringUtil.isEmpty(String.valueOf(objArr[5]),""));
					sys.setPZBM(StringUtil.isEmpty(String.valueOf(objArr[6]),""));
					sys.setPDJG(StringUtil.isEmpty(String.valueOf(objArr[7]),""));
					LZ+=StringUtil.isEmpty(String.valueOf(objArr[8]),"");
					LZQD+=StringUtil.isEmpty(String.valueOf(objArr[9]),"");
					F_GUID+=StringUtil.isEmpty(String.valueOf(objArr[10]),"");
				}else{
					LZ+=StringUtil.isEmpty(String.valueOf(objArr[8]),"")+"&";
					LZQD+=StringUtil.isEmpty(String.valueOf(objArr[9]),"")+"&";
					F_GUID+=StringUtil.isEmpty(String.valueOf(objArr[10]),"")+"&";
				}
				ArrStr[i]=StringUtil.isEmpty(String.valueOf(objArr[10]),"");
				if(i==list.size()-1){
					sys.setF_GUID(F_GUID);
					sys.setLZ(LZ);
					sys.setLZQD(LZQD);
				}
			}
		}
		for(int j=0;j<ArrStr.length;j++){
			String SQL="select F_SJ,F_LZ from V_Wangnj_S where F_GUID='"+ArrStr[j]+"'";
			//此时来查询字表的数据
			List<Object[]> list2=findListbySql(SQL);
			String F_SJ_temp="";
			String F_LZ_temp="";
			if(list2.size()>0){
				for(int k=0;k<list2.size();k++){
					Object[] objArr2=list2.get(k);
					F_SJ_temp+=StringUtil.isEmpty(String.valueOf(objArr2[0]),"")+",";
					F_LZ_temp+=StringUtil.isEmpty(String.valueOf(objArr2[1]),"")+",";
				}
			}
			F_SJ+=F_SJ_temp+"&";
			F_LZ+=F_LZ_temp+"&";
		}
		sys.setF_LZ(F_LZ);
		sys.setF_SJ(F_SJ);
		//提交处理结果
		SmsinfoEntity sms=smsinfoService.findUniqueByProperty(SmsinfoEntity.class,"syjid",SYJID);
		if(sms!=null){
			sys.setChuli(sms.getChuli());
		}else{
			sys.setChuli("");
		}		
		return sys;
	}
	
	public List<HntkangyaWarnBean> hntkangyaWarinSel(String lft,String rgt,String startTime,String endTime,String isQualified,String shebeibianhao){
		List<HntkangyaWarnBean> sysYLJlist=new ArrayList<HntkangyaWarnBean>();
		String sql="select SYRQ,shebeiname,WTBH,SJQD,QDDBZ,GCMC,SGBW,PDJG,SYJID,ZZRQ,DATEDIFF(DAY,DATEADD(DAY,LQ,ZZRQ),SYRQ) AS dayDiff from T_SYJZBView where SYLX='100014' and (lft>='"+lft+"' and rgt<='"+rgt+"') and (SYRQ between '"+startTime+"' and '"+endTime+"') ";
		if(StringUtil.isNotEmpty(isQualified)){
			sql+=" and PDJG='"+isQualified+"'";
		}
		if(StringUtil.isNotEmpty(shebeibianhao)){
			sql+=" and SBBH='"+shebeibianhao+"'";
		}
		sql+=" and DATEDIFF(DAY,DATEADD(DAY,LQ,ZZRQ),SYRQ)>0 order by DATEDIFF(DAY,DATEADD(DAY,LQ,ZZRQ),SYRQ) asc";
		List<Object[]> list=findListbySql(sql);
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] objArr=list.get(i);
				HntkangyaWarnBean sys=new HntkangyaWarnBean();
				sys.setSYRQ(StringUtil.isEmpty(String.valueOf(objArr[0]),""));
				sys.setShebeiname(StringUtil.isEmpty(String.valueOf(objArr[1]),""));
				sys.setWTBH(StringUtil.isEmpty(String.valueOf(objArr[2]),""));
				sys.setPDJG(StringUtil.isEmpty(String.valueOf(objArr[3]),""));
				sys.setSJQD(StringUtil.isEmpty(String.valueOf(objArr[4]),""));
				sys.setSJQD(StringUtil.isEmpty(String.valueOf(objArr[5]),""));
				sys.setQDDBZ(StringUtil.isEmpty(String.valueOf(objArr[6]),""));
				sys.setWTBH(StringUtil.isEmpty(String.valueOf(objArr[7]),""));
				sys.setGCMC(StringUtil.isEmpty(String.valueOf(objArr[8]),""));
				sys.setSGBW(StringUtil.isEmpty(String.valueOf(objArr[9]),""));
				sys.setPDJG(StringUtil.isEmpty(String.valueOf(objArr[10]),""));
				sys.setSYJID(StringUtil.isEmpty(String.valueOf(objArr[11]),""));
				sys.setZZRQ(StringUtil.isEmpty(String.valueOf(objArr[12]),""));
				sys.setDayDiff(StringUtil.isEmpty(String.valueOf(objArr[13]),""));
				sysYLJlist.add(sys);
			}
		}
		return sysYLJlist;
	}
	
	/*   原始方法
	public SysMainLogoBean sysMainLogo(String lft,String rgt){
		SysMainLogoBean syslogo=new SysMainLogoBean();
		//查询委托[0表示下发了委托，但是没有去做试验]
		String wtSQL="SELECT COUNT(MSTATUS) AS MSTATUS FROM V_Consign where 1=1 and MSTATUS='0' and (lft>='"+lft+"' and rgt<='"+rgt+"')";
		syslogo.setWaitWTcount(String.valueOf(getCountForJdbc(wtSQL)));
		//查询待处置不合格试验数量
		//String waitRealSQL="select count(*) AS realCount from T_SYJZBRealView where 1=1 and (ISNULL(chuli,'')<>'') and (lft>='"+lft+"' and rgt<='"+rgt+"')";
		String waitRealSQL="select count(*) AS realCount from T_SYJZBWaitRealView where 1=1 and PDJG='不合格' and (ISNULL(chuli,'')='') and (lft>='"+lft+"' and rgt<='"+rgt+"')";
		syslogo.setWaitRealcount(String.valueOf(getCountForJdbc(waitRealSQL)));
		//混凝土抗压试验条数
		String hntkangyaSQL="select count(*) as hntkangyaCount from T_SYJZBView where 1=1 and SYLX='100014' and (lft>='"+lft+"' and rgt<='"+rgt+"') ";
		syslogo.setHntkangyacount(String.valueOf(getCountForJdbc(hntkangyaSQL)));
		//钢筋试验条数
		String gangjinSQL="select count(*) as hntkangyaCount from T_SYJZBView where 1=1 and SYLX='100047' and (lft>='"+lft+"' and rgt<='"+rgt+"') ";
		syslogo.setGangjincount(String.valueOf(getCountForJdbc(gangjinSQL)));
		//钢筋接头试验条数
		String gangjinhanjiejietouSQL="select count(*) as hntkangyaCount from T_SYJZBView where 1=1 and SYLX='100048' and (lft>='"+lft+"' and rgt<='"+rgt+"') ";
		syslogo.setGangjinhanjiejietoucount(String.valueOf(getCountForJdbc(gangjinhanjiejietouSQL)));
		//钢筋接头试验条数
		String gangjinlianjiejietouSQL="select count(*) as hntkangyaCount from T_SYJZBView where 1=1 and SYLX='100049' and (lft>='"+lft+"' and rgt<='"+rgt+"') ";
		syslogo.setGangjinlianjiejietoucount(String.valueOf(getCountForJdbc(gangjinlianjiejietouSQL)));
		return syslogo;
	}
	*/
	
	public AppHntSysHPData hntSysMainLogo(Integer lft,Integer rgt){
		AppHntSysHPData hsp = new AppHntSysHPData();
		StringBuffer sql = new StringBuffer("select sum(case when(PDJG='合格' OR PDJG='有效') then 1 else 0 end) as hg,sum(case when(PDJG='不合格' or PDJG='无效') then 1 else 0 end) as bhg," 
			+" sum(case when(chuli is null and (PDJG='不合格' or PDJG='无效')) then 1 else 0 end) as wcz,sum(case when(chuli is not null) then 1 else 0 end) as cz "
			+" from T_SYJZBView ");
		
		StringBuffer ylSql = new StringBuffer(sql + " where testtype='1' ");
		
		StringBuffer wnSql = new StringBuffer(sql + " where testtype='2' ");
		
		if(lft!=null&&rgt!=null){
			ylSql.append(" and lft >='"+lft+"' and rgt<='"+rgt+"' ");
			wnSql.append(" and lft >='"+lft+"' and rgt<='"+rgt+"' ");
		}
		Statement cs = null;
		Connection con = null;
		ResultSet rs = null;
		try{
			con = getCon();
			cs = con.createStatement();
			rs = cs.executeQuery(ylSql.toString());
			
			if(rs.next()){
				hsp.setYlQual(rs.getString("hg"));
				hsp.setYlDisqual(rs.getString("bhg"));
				hsp.setYlHandle(rs.getString("cz"));
				hsp.setYlNoHandle(rs.getString("wcz"));
			}
			
			rs.close();
			rs = cs.executeQuery(wnSql.toString());
			if(rs.next()){
				hsp.setWnQual(rs.getString("hg"));
				hsp.setWnDisqual(rs.getString("bhg"));
				hsp.setWnHandle(rs.getString("cz"));
				hsp.setWnNoHandle(rs.getString("wcz"));
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
		return hsp;
	}
	
	public SysMainLogoBean sysMainLogo(String lft,String rgt){
		SysMainLogoBean syslogo=new SysMainLogoBean();
		//查询委托[0表示下发了委托，但是没有去做试验]
		String wtSQL="SELECT COUNT(MSTATUS) AS MSTATUS FROM V_Consign where 1=1 and MSTATUS='0' and (lft>='"+lft+"' and rgt<='"+rgt+"')";
		syslogo.setWaitWTcount(String.valueOf(getCountForJdbc(wtSQL)));
		//查询待处置不合格试验数量
		//String waitRealSQL="select count(*) AS realCount from T_SYJZBRealView where 1=1 and (ISNULL(chuli,'')<>'') and (lft>='"+lft+"' and rgt<='"+rgt+"')";
		String waitRealSQL="select count(*) AS realCount from T_SYJZBWaitRealView where 1=1 and PDJG='不合格' and (ISNULL(chuli,'')='') and (lft>='"+lft+"' and rgt<='"+rgt+"')";
		syslogo.setWaitRealcount(String.valueOf(getCountForJdbc(waitRealSQL)));
		
		//查询压力机不合格试验数量
		//String waitRealSQL="select count(*) AS realCount from T_SYJZBRealView where 1=1 and (ISNULL(chuli,'')<>'') and (lft>='"+lft+"' and rgt<='"+rgt+"')";
		String ylnpSQL="select count(*) from T_SYJZBWaitRealView ts join T_SYJZB_TYPE tst on ts.SYLX = tst.testid where tst.testtype=1 and (ts.PDJG='不合格' or ts.PDJG='无效') " ;
		syslogo.setYlnpSQL(String.valueOf(getCountForJdbc(ylnpSQL)));
		//查询万能机不合格试验数量
		//String waitRealSQL="select count(*) AS realCount from T_SYJZBRealView where 1=1 and (ISNULL(chuli,'')<>'') and (lft>='"+lft+"' and rgt<='"+rgt+"')";
		String wnnpSQL="select count(*) from T_SYJZBWaitRealView ts join T_SYJZB_TYPE tst on ts.SYLX = tst.testid where tst.testtype=2 and (ts.PDJG='不合格' or ts.PDJG='无效') ";
		syslogo.setWnnpSQL(String.valueOf(getCountForJdbc(wnnpSQL)));
		
		//混凝土抗压试验条数
		String hntkangyaSQL="select count(*) as hntkangyaCount from T_SYJZBView where 1=1 and SYLX='100014' and (lft>='"+lft+"' and rgt<='"+rgt+"') ";
		syslogo.setHntkangyacount(String.valueOf(getCountForJdbc(hntkangyaSQL)));
		//钢筋试验条数
		String gangjinSQL="select count(*) as hntkangyaCount from T_SYJZBView where 1=1 and SYLX='100047' and (lft>='"+lft+"' and rgt<='"+rgt+"') ";
		syslogo.setGangjincount(String.valueOf(getCountForJdbc(gangjinSQL)));
		//钢筋接头试验条数
		String gangjinhanjiejietouSQL="select count(*) as hntkangyaCount from T_SYJZBView where 1=1 and SYLX='100048' and (lft>='"+lft+"' and rgt<='"+rgt+"') ";
		syslogo.setGangjinhanjiejietoucount(String.valueOf(getCountForJdbc(gangjinhanjiejietouSQL)));
		//钢筋接头试验条数
		String gangjinlianjiejietouSQL="select count(*) as hntkangyaCount from T_SYJZBView where 1=1 and SYLX='100049' and (lft>='"+lft+"' and rgt<='"+rgt+"') ";
		syslogo.setGangjinlianjiejietoucount(String.valueOf(getCountForJdbc(gangjinlianjiejietouSQL)));
		return syslogo;
	}
	
	public List<SysCountAnalyze> SysCountAnalyze(String lft,String rgt,String startTime,String endTime){
		List<SysCountAnalyze> sysCountList=new ArrayList<SysCountAnalyze>();
		String sql="select max(departid) as userGroupId,max(SYLX) as SYLX,count(*) as testCount,sum(case when PDJG='合格' then 1 else 0 end) as qualifiedCount,sum(case when (PDJG='不合格' or PDJG='无效') then 1 else 0 end) as NotqualifiedCount,sum(case when PDJG='有效' then 1 else 0 end) as validCount,TestName from T_SYJZBView where 1=1 and (lft>='"+lft+"' and rgt<='"+rgt+"')";
		if(StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)){
			sql+=" and (SYRQ between '"+startTime+"' and '"+endTime+"')";
		}
		sql+=" group by SYLX,TestName";
		System.out.println(sql);
		List<Object[]> list=findListbySql(sql);
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] objArr=list.get(i);
				SysCountAnalyze sysCount=new SysCountAnalyze();
				sysCount.setUserGroupId(StringUtil.isEmpty(String.valueOf(objArr[0]),""));
				sysCount.setTestType(StringUtil.isEmpty(String.valueOf(objArr[1]),""));
				sysCount.setTestCount(StringUtil.isEmpty(String.valueOf(objArr[2]),"0"));
				sysCount.setQualifiedCount(StringUtil.isEmpty(String.valueOf(objArr[3]),"0"));
				sysCount.setNotqualifiedCount(StringUtil.isEmpty(String.valueOf(objArr[4]),"0"));
				sysCount.setValidCount(StringUtil.isEmpty(String.valueOf(objArr[5]),"0"));
				sysCount.setTestName(StringUtil.isEmpty(String.valueOf(objArr[6]),""));
				String qualifiedPer = null;
				try{
					qualifiedPer=String.format("%1$.2f",Float.parseFloat((Integer.parseInt(StringUtil.isEmpty(String.valueOf(objArr[3]),"0"))+Integer.parseInt(StringUtil.isEmpty(String.valueOf(objArr[5]),"0")))
								/Float.parseFloat(sysCount.getTestCount())*100+""));
				}catch(Exception ex){}
				sysCount.setQualifiedPer(StringUtil.isEmpty(qualifiedPer, "0.00"));
				sysCountList.add(sysCount);
			}
		}
		return sysCountList;
	}
	
	//试验室的设备列表
	public List<ShebeiListBean> getSysShebeiList(String lft,String rgt){
		List<ShebeiListBean> shebeiList=null;
		try{
			StringBuffer sql=new StringBuffer("select shebeibianhao as gprsbianhao,shebeiname as banhezhanminchen,shiyanshi_guid as departid from V_ShebeiInfo where 1=1");
			if (StringUtil.isNotEmpty(lft) && StringUtil.isNotEmpty(rgt)) {
				sql.append(" and (lft >='"+lft+"' and rgt<='"+rgt+"')");
			}
			shebeiList=jdbcDao.find(sql.toString(),ShebeiListBean.class, new HashMap<String, String>());
		}catch(Exception ex){}
		return shebeiList;
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
