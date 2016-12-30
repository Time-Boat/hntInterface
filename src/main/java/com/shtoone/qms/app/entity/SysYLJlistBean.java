package com.shtoone.qms.app.entity;

import java.io.Serializable;
/**
 * 公路没有委托编号
 * @author Administrator
 *
 */
public class SysYLJlistBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String SYRQ;  //试验日期
	private String shebeiname;  //设备名称
	private String SJQD;  //设计强度
	private String QDDBZ; //强度代表值
	private String GCMC;  //工程名称
	private String SGBW;  //施工部位
	private String PDJG;  //判定结果
	private String SYJID;  //本条数据的唯一Id
	private String testName;  //试验名称
	private String SJBH;
	
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
	public String getSJBH() {
		return SJBH;
	}
	public void setSJBH(String sJBH) {
		SJBH = sJBH;
	}
	
}
