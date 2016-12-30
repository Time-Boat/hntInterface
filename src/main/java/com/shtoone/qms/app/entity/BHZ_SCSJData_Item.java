package com.shtoone.qms.app.entity;

import java.io.Serializable;

public class BHZ_SCSJData_Item implements Serializable{
	
	private String id;
	private String xinxibianhao;
	private String chuliaoshijian;
	private String banhezhanminchen;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	//因为IOS中id是关键字，不能做为变量名，搞了一个sId
	public String sId;
	public String getSId() {
		return id;
	}
	public void setSId(String sId) {
		
	}

	private String gongchengmingcheng;
	private String jiaozuobuwei;
	private String sigongdidian;
	private String qiangdudengji;
	private String gujifangshu;
	
	private String jiaobanshijian;
	private String Peifanghao;
	private String Chaozuozhe;
	private String Waijiajipingzhong;
	private String Shuinipingzhong;
	
	private String gongdanhao;
	
	private String chuli;
	private String shenhe;
	
	public String getChuli() {
		return chuli;
	}
	public void setChuli(String chuli) {
		this.chuli = chuli;
	}
	public String getShenhe() {
		return shenhe;
	}
	public void setShenhe(String shenhe) {
		this.shenhe = shenhe;
	}
	public String getGongdanhao() {
		return gongdanhao;
	}
	public void setGongdanhao(String gongdanhao) {
		this.gongdanhao = gongdanhao;
	}
	public String getJiaobanshijian() {
		return jiaobanshijian;
	}
	public void setJiaobanshijian(String jiaobanshijian) {
		this.jiaobanshijian = jiaobanshijian;
	}
	public String getPeifanghao() {
		return Peifanghao;
	}
	public void setPeifanghao(String peifanghao) {
		Peifanghao = peifanghao;
	}
	public String getChaozuozhe() {
		return Chaozuozhe;
	}
	public void setChaozuozhe(String chaozuozhe) {
		Chaozuozhe = chaozuozhe;
	}
	public String getWaijiajipingzhong() {
		return Waijiajipingzhong;
	}
	public void setWaijiajipingzhong(String waijiajipingzhong) {
		Waijiajipingzhong = waijiajipingzhong;
	}
	public String getShuinipingzhong() {
		return Shuinipingzhong;
	}
	public void setShuinipingzhong(String shuinipingzhong) {
		Shuinipingzhong = shuinipingzhong;
	}
	public String getXinxibianhao() {
		return xinxibianhao;
	}
	public void setXinxibianhao(String xinxibianhao) {
		this.xinxibianhao = xinxibianhao;
	}
	public String getChuliaoshijian() {
		return chuliaoshijian;
	}
	public void setChuliaoshijian(String chuliaoshijian) {
		this.chuliaoshijian = chuliaoshijian;
	}
	public String getBanhezhanminchen() {
		return banhezhanminchen;
	}
	public void setBanhezhanminchen(String banhezhanminchen) {
		this.banhezhanminchen = banhezhanminchen;
	}
	public String getGongchengmingcheng() {
		return gongchengmingcheng;
	}
	public void setGongchengmingcheng(String gongchengmingcheng) {
		this.gongchengmingcheng = gongchengmingcheng;
	}
	public String getJiaozuobuwei() {
		return jiaozuobuwei;
	}
	public void setJiaozuobuwei(String jiaozuobuwei) {
		this.jiaozuobuwei = jiaozuobuwei;
	}
	public String getSigongdidian() {
		return sigongdidian;
	}
	public void setSigongdidian(String sigongdidian) {
		this.sigongdidian = sigongdidian;
	}
	public String getQiangdudengji() {
		return qiangdudengji;
	}
	public void setQiangdudengji(String qiangdudengji) {
		this.qiangdudengji = qiangdudengji;
	}
	public String getGujifangshu() {
		return gujifangshu;
	}
	public void setGujifangshu(String gujifangshu) {
		this.gujifangshu = gujifangshu;
	}
	
	
}
