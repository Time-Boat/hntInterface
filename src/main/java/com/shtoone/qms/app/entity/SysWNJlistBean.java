package com.shtoone.qms.app.entity;

import java.io.Serializable;

public class SysWNJlistBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String SYRQ;  //试验日期
	private String shebeiname;  //设备名称
	private String SJBH;  //试件编号
	private String QFLZ;  //屈服拉力
	private String LZQD;  //抗拉强度
	private String PZBM;  //品种
	private String GCMC;  //工程名称
	private String SGBW;  //施工部位
	private String PDJG;  //判定结果
	private String SYJID;  //本条数据的唯一Id
	
	private String testName; //试验名称
	
	private String chuzhi;
	
	public String getChuzhi() {
		return chuzhi;
	}
	public void setChuzhi(String chuzhi) {
		this.chuzhi = chuzhi;
	}
	public String getSYRQ() {
		return SYRQ;
	}
	public void setSYRQ(String sYRQ) {
		SYRQ = sYRQ;
	}
	public String getShebeiname() {
		return shebeiname;
	}
	public void setShebeiname(String shebeiname) {
		this.shebeiname = shebeiname;
	}
	public String getSJBH() {
		return SJBH;
	}
	public void setSJBH(String sJBH) {
		SJBH = sJBH;
	}
	public String getQFLZ() {
		return QFLZ;
	}
	public void setQFLZ(String qFLZ) {
		QFLZ = qFLZ;
	}
	public String getLZQD() {
		return LZQD;
	}
	public void setLZQD(String lZQD) {
		LZQD = lZQD;
	}
	public String getPZBM() {
		return PZBM;
	}
	public void setPZBM(String pZBM) {
		PZBM = pZBM;
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
	public String getPDJG() {
		return PDJG;
	}
	public void setPDJG(String pDJG) {
		PDJG = pDJG;
	}
	public String getSYJID() {
		return SYJID;
	}
	public void setSYJID(String sYJID) {
		SYJID = sYJID;
	}
	
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
}
