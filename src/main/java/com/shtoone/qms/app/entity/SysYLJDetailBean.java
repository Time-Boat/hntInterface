package com.shtoone.qms.app.entity;

import java.io.Serializable;

public class SysYLJDetailBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String shebeiname;  //设备名称
	private String SYRQ;  //试验日期
	private String GCMC;  //工程名称
	private String SGBW;  //施工部位
	private String SJBH;  //试件编号
	private String SJQD;  //设计强度
	private String QDDBZ; //强度代表值
	private String LQ;  //龄期
	private String SJCC;   //试件尺寸
	private String PDJG;   //判定结果
	private String F_GUID;  //本条数据的唯一Id
	private String testName;   //试验名称
	/********字表数据*************/
	private String KYLZ;  //荷载
	private String KYQD;  //强度单值
	//字表的过程数据
	private String F_SJ;  //X轴时间
	private String F_LZ;  //Y轴力值
	//处理
	private String chuli;
	
	
	public String getShebeiname() {
		return shebeiname;
	}
	public void setShebeiname(String shebeiname) {
		this.shebeiname = shebeiname;
	}
	public String getSYRQ() {
		return SYRQ;
	}
	public void setSYRQ(String sYRQ) {
		SYRQ = sYRQ;
	}
	public String getGCMC() {
		return GCMC;
	}
	public void setGCMC(String gCMC) {
		GCMC = gCMC;
	}
	public String getSGBW() {
		return SGBW;
	}
	public void setSGBW(String sGBW) {
		SGBW = sGBW;
	}
	public String getSJBH() {
		return SJBH;
	}
	public void setSJBH(String sJBH) {
		SJBH = sJBH;
	}
	public String getSJQD() {
		return SJQD;
	}
	public void setSJQD(String sJQD) {
		SJQD = sJQD;
	}
	public String getQDDBZ() {
		return QDDBZ;
	}
	public void setQDDBZ(String qDDBZ) {
		QDDBZ = qDDBZ;
	}
	public String getLQ() {
		return LQ;
	}
	public void setLQ(String lQ) {
		LQ = lQ;
	}
	public String getSJCC() {
		return SJCC;
	}
	public void setSJCC(String sJCC) {
		SJCC = sJCC;
	}
	public String getPDJG() {
		return PDJG;
	}
	public void setPDJG(String pDJG) {
		PDJG = pDJG;
	}
	public String getF_GUID() {
		return F_GUID;
	}
	public void setF_GUID(String f_GUID) {
		F_GUID = f_GUID;
	}
	public String getKYLZ() {
		return KYLZ;
	}
	public void setKYLZ(String kYLZ) {
		KYLZ = kYLZ;
	}
	public String getKYQD() {
		return KYQD;
	}
	public void setKYQD(String kYQD) {
		KYQD = kYQD;
	}
	public String getF_SJ() {
		return F_SJ;
	}
	public void setF_SJ(String f_SJ) {
		F_SJ = f_SJ;
	}
	public String getF_LZ() {
		return F_LZ;
	}
	public void setF_LZ(String f_LZ) {
		F_LZ = f_LZ;
	}
	public String getChuli() {
		return chuli;
	}
	public void setChuli(String chuli) {
		this.chuli = chuli;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}

}
