package com.shtoone.qms.app.entity;

public class HntMain implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String departId;
	private String departName;
	private String bhzCount;  //拌和站数量
	private String bhjCount;//拌和机数量
	private String totalPanshu;//总盘数
	private String totalFangliang;//总方量
	private String cbpanshu;//初级超标盘数
	private String mcbpanshu;//中级超标盘数
	private String hcbpanshu;//高级超标盘数
	private String cczpanshu;//初级处置盘数
	private String mczpanshu;  //中级处置盘数
	private String hczpanshu;  //高级处置盘数
	
	private String cblv;//初级超标率
	private String mcblv;//中级超标率
	private String hcblv;//高级超标率
	private String czlv;//初级处置率
	private String mczlv;  //中级处置率
	private String hczlv;  //高级处置率
	public String getMczpanshu() {
		return mczpanshu;
	}
	public void setMczpanshu(String mczpanshu) {
		this.mczpanshu = mczpanshu;
	}
	public String getHczpanshu() {
		return hczpanshu;
	}
	public void setHczpanshu(String hczpanshu) {
		this.hczpanshu = hczpanshu;
	}
	public String getMczlv() {
		return mczlv;
	}
	public void setMczlv(String mczlv) {
		this.mczlv = mczlv;
	}
	public String getHczlv() {
		return hczlv;
	}
	public void setHczlv(String hczlv) {
		this.hczlv = hczlv;
	}
	public String getDepartId() {
		return departId;
	}
	public void setDepartId(String departId) {
		this.departId = departId;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getBhjCount() {
		return bhjCount;
	}
	public void setBhjCount(String bhjCount) {
		this.bhjCount = bhjCount;
	}
	public String getTotalPanshu() {
		return totalPanshu;
	}
	public void setTotalPanshu(String totalPanshu) {
		this.totalPanshu = totalPanshu;
	}
	public String getTotalFangliang() {
		return totalFangliang;
	}
	public void setTotalFangliang(String totalFangliang) {
		this.totalFangliang = totalFangliang;
	}
	public String getCbpanshu() {
		return cbpanshu;
	}
	public void setCbpanshu(String cbpanshu) {
		this.cbpanshu = cbpanshu;
	}
	public String getMcbpanshu() {
		return mcbpanshu;
	}
	public void setMcbpanshu(String mcbpanshu) {
		this.mcbpanshu = mcbpanshu;
	}
	public String getHcbpanshu() {
		return hcbpanshu;
	}
	public void setHcbpanshu(String hcbpanshu) {
		this.hcbpanshu = hcbpanshu;
	}
	public String getCczpanshu() {
		return cczpanshu;
	}
	public void setCczpanshu(String cczpanshu) {
		this.cczpanshu = cczpanshu;
	}
	public String getCblv() {
		return cblv;
	}
	public void setCblv(String cblv) {
		this.cblv = cblv;
	}
	public String getMcblv() {
		return mcblv;
	}
	public void setMcblv(String mcblv) {
		this.mcblv = mcblv;
	}
	public String getHcblv() {
		return hcblv;
	}
	public void setHcblv(String hcblv) {
		this.hcblv = hcblv;
	}
	public String getCzlv() {
		return czlv;
	}
	public void setCzlv(String czlv) {
		this.czlv = czlv;
	}
	public String getBhzCount() {
		return bhzCount;
	}
	public void setBhzCount(String bhzCount) {
		this.bhzCount = bhzCount;
	}
	
	
}
