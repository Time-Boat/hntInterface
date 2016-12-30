package com.shtoone.qms.app.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HntMainLogoBean implements Serializable{
	private String waitRealCount;
	private String leijiRealCount;
	private String realPer;
	private String todayCount;
	private String leijiCount;
	private String chaobiaoRealCount;
	public String getWaitRealCount() {
		return waitRealCount;
	}
	public void setWaitRealCount(String waitRealCount) {
		this.waitRealCount = waitRealCount;
	}
	public String getLeijiRealCount() {
		return leijiRealCount;
	}
	public void setLeijiRealCount(String leijiRealCount) {
		this.leijiRealCount = leijiRealCount;
	}
	public String getRealPer() {
		return realPer;
	}
	public void setRealPer(String realPer) {
		this.realPer = realPer;
	}
	public String getTodayCount() {
		return todayCount;
	}
	public void setTodayCount(String todayCount) {
		this.todayCount = todayCount;
	}
	public String getLeijiCount() {
		return leijiCount;
	}
	public void setLeijiCount(String leijiCount) {
		this.leijiCount = leijiCount;
	}
	public String getChaobiaoRealCount() {
		return chaobiaoRealCount;
	}
	public void setChaobiaoRealCount(String chaobiaoRealCount) {
		this.chaobiaoRealCount = chaobiaoRealCount;
	}
}
