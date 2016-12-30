package com.shtoone.qms.app.entity;

import java.io.Serializable;

public class SysWNJDetailBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String shebeiname;  //设备名称
	private String SYRQ;  //试验日期
	private String GCMC;  //工程名称
	private String SGBW;  //施工部位
	private String SJBH;  //试件编号
	private String GGZL;   //直径
	private String PZBM;   //品种
	private String PDJG;   //是否合格
	private String F_GUID;  //本条数据的唯一Id
	/********字表数据*************/
	private String QFLZ;  //屈服力
	private String QFQD;  //屈服强度
	private String LZ;    //抗拉力
	private String LZQD;  //抗拉强度
	private String SCL;   //伸长率
	//过程数据
	private String F_SJ;  //X轴坐标
	private String F_LZ;  //Y轴坐标
	//处理结果
	private String chuli;
	
	private String testName;
	
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
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
	public String getGGZL() {
		return GGZL;
	}
	public void setGGZL(String gGZL) {
		GGZL = gGZL;
	}
	public String getPZBM() {
		return PZBM;
	}
	public void setPZBM(String pZBM) {
		PZBM = pZBM;
	}
	public String getPDJG() {
		return PDJG;
	}
	public void setPDJG(String pDJG) {
		PDJG = pDJG;
	}
	public String getQFLZ() {
		return QFLZ;
	}
	public void setQFLZ(String qFLZ) {
		QFLZ = qFLZ;
	}
	public String getQFQD() {
		return QFQD;
	}
	public void setQFQD(String qFQD) {
		QFQD = qFQD;
	}
	public String getLZ() {
		return LZ;
	}
	public void setLZ(String lZ) {
		LZ = lZ;
	}
	public String getLZQD() {
		return LZQD;
	}
	public void setLZQD(String lZQD) {
		LZQD = lZQD;
	}
	public String getSCL() {
		return SCL;
	}
	public void setSCL(String sCL) {
		SCL = sCL;
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
	public String getF_GUID() {
		return F_GUID;
	}
	public void setF_GUID(String f_GUID) {
		F_GUID = f_GUID;
	}
}
