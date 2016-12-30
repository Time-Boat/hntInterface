package com.shtoone.qms.app.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SysMainLogoBean implements Serializable{
	private String waitWTcount;  //待处置委托试验
	private String waitRealcount;  //待处置不合格试验
	private String hntkangyacount;  
	private String gangjincount;
	private String gangjinhanjiejietoucount;
	private String gangjinlianjiejietoucount;
	
	private String ylnpSQL;  //压力机不合格总数
	private String wnnpSQL;  //万能机不合格总数
	
	public String getYlnpSQL() {
		return ylnpSQL;
	}
	public void setYlnpSQL(String ylnpSQL) {
		this.ylnpSQL = ylnpSQL;
	}
	public String getWnnpSQL() {
		return wnnpSQL;
	}
	public void setWnnpSQL(String wnnpSQL) {
		this.wnnpSQL = wnnpSQL;
	}
	public String getWaitWTcount() {
		return waitWTcount;
	}
	public void setWaitWTcount(String waitWTcount) {
		this.waitWTcount = waitWTcount;
	}
	public String getWaitRealcount() {
		return waitRealcount;
	}
	public void setWaitRealcount(String waitRealcount) {
		this.waitRealcount = waitRealcount;
	}
	public String getHntkangyacount() {
		return hntkangyacount;
	}
	public void setHntkangyacount(String hntkangyacount) {
		this.hntkangyacount = hntkangyacount;
	}
	public String getGangjincount() {
		return gangjincount;
	}
	public void setGangjincount(String gangjincount) {
		this.gangjincount = gangjincount;
	}
	public String getGangjinhanjiejietoucount() {
		return gangjinhanjiejietoucount;
	}
	public void setGangjinhanjiejietoucount(String gangjinhanjiejietoucount) {
		this.gangjinhanjiejietoucount = gangjinhanjiejietoucount;
	}
	public String getGangjinlianjiejietoucount() {
		return gangjinlianjiejietoucount;
	}
	public void setGangjinlianjiejietoucount(String gangjinlianjiejietoucount) {
		this.gangjinlianjiejietoucount = gangjinlianjiejietoucount;
	}
}
