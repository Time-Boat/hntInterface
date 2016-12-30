package com.shtoone.qms.app.entity;

import java.io.Serializable;

public class HntkangyaWarnBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String SYRQ;  //试验日期
	private String shebeiname;  //设备名称
	private String WTBH;  //委托编号
	private String SJQD;  //设计强度
	private String QDDBZ; //强度代表值
	private String GCMC;  //工程名称
	private String SGBW;  //施工部位
	private String PDJG;  //判定结果
	private String SYJID;  //本条数据的唯一Id
	private String ZZRQ;  //制件日期
	private String dayDiff;  //日期差值
	
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
	public String getWTBH() {
		return WTBH;
	}
	public void setWTBH(String wTBH) {
		WTBH = wTBH;
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
	public String getZZRQ() {
		return ZZRQ;
	}
	public void setZZRQ(String zZRQ) {
		ZZRQ = zZRQ;
	}
	public String getDayDiff() {
		return dayDiff;
	}
	public void setDayDiff(String dayDiff) {
		this.dayDiff = dayDiff;
	}	
}
