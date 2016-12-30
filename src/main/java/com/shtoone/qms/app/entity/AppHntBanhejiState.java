package com.shtoone.qms.app.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.jeecgframework.core.util.StringUtil;

@SuppressWarnings("serial")
public class AppHntBanhejiState implements Serializable{
	private String departname;
	private String banhezhanminchen;
	private String chuliaoshijian;
	private String baocunshijian;
	private String caijishijian;
	private String state;
	private String shangchuanyanshi;
	public String getShangchuanyanshi() {
		return shangchuanyanshi;
	}
	public void setShangchuanyanshi(String shangchuanyanshi) {
		this.shangchuanyanshi = shangchuanyanshi;
	}
	public String getBanhezhanminchen() {
		return banhezhanminchen;
	}
	public void setBanhezhanminchen(String banhezhanminchen) {
		this.banhezhanminchen = banhezhanminchen;
	}
	public String getChuliaoshijian() {
		return chuliaoshijian;
	}
	public void setChuliaoshijian(String chuliaoshijian) {
		this.chuliaoshijian = chuliaoshijian;
	}
	public String getCaijishijian() {
		return caijishijian;
	}
	public void setCaijishijian(String caijishijian) {
		this.caijishijian = caijishijian;
	}
	public String getState() {
		//这里自定义吧
		Calendar day=Calendar.getInstance();
		day.add(Calendar.DATE, -1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date caiji = day.getTime();					    	
		try {
			caiji = sdf.parse(caijishijian);
		} catch (ParseException ex) {}
		if (caiji.after(day.getTime())){
			double caijiyanshi =0;
			try {
				caijiyanshi = StringUtil.StrToZero(caijishijian);
			} catch (Exception e) {}
			double shangchuanyanshitemp =0;
			try {
				shangchuanyanshitemp = StringUtil.StrToZero(shangchuanyanshi);
			} catch (Exception e) {}
			if  ((caijiyanshi<=1200) && (shangchuanyanshitemp<=1800)){
				this.state="正常工作";
			} else {
				this.state="延时";
			}
		}else{
		  	this.state ="未工作";
		}		
		return state;
	}
	public void setState(String state) {
		this.state=state;
	}
	public String getDepartname() {
		return departname;
	}
	public void setDepartname(String departname) {
		this.departname = departname;
	}
	public String getBaocunshijian() {
		return baocunshijian;
	}
	public void setBaocunshijian(String baocunshijian) {
		this.baocunshijian = baocunshijian;
	}
}
