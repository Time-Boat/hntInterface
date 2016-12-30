package com.shtoone.qms.entity.bhz;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "TemperaturedataView", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class TemperaturedataView implements java.io.Serializable {
	
	private Integer tmpid;
	private String tmpno;
	private String tmpdata;
	private String shidudata;
	private String tmpshijian;
	private String banhezhanminchen;
	private String gprsbianhao;
	private String lft;
	private String rgt;
	private String wdfanwei;
	private String sdfanwei;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="TMPID",nullable=false,precision=10,scale=0,length=4)
	public Integer getTmpid() {
		return tmpid;
	}
	public void setTmpid(Integer tmpid) {
		this.tmpid = tmpid;
	}
	@Column(name ="TMPNO",nullable=true,precision=255,length=255)
	public String getTmpno() {
		return tmpno;
	}
	public void setTmpno(String tmpno) {
		this.tmpno = tmpno;
	}
	@Column(name ="TMPDATA",nullable=true,precision=255,length=255)
	public String getTmpdata() {
		return tmpdata;
	}
	public void setTmpdata(String tmpdata) {
		this.tmpdata = tmpdata;
	}
	@Column(name ="SHIDUDATA",nullable=true,precision=255,length=255)
	public String getShidudata() {
		return shidudata;
	}
	public void setShidudata(String shidudata) {
		this.shidudata = shidudata;
	}
	@Column(name ="TMPSHIJIAN",nullable=true,precision=255,length=255)
	public String getTmpshijian() {
		return tmpshijian;
	}
	public void setTmpshijian(String tmpshijian) {
		this.tmpshijian = tmpshijian;
	}
	@Column(name ="BANHEZHANMINCHEN",nullable=true,precision=255,length=255)
	public String getBanhezhanminchen() {
		return banhezhanminchen;
	}
	public void setBanhezhanminchen(String banhezhanminchen) {
		this.banhezhanminchen = banhezhanminchen;
	}
	@Column(name ="GPRSBIANHAO",nullable=true,precision=255,length=255)
	public String getGprsbianhao() {
		return gprsbianhao;
	}
	public void setGprsbianhao(String gprsbianhao) {
		this.gprsbianhao = gprsbianhao;
	}
	@Column(name ="LFT",nullable=true,precision=255,length=255)
	public String getLft() {
		return lft;
	}
	public void setLft(String lft) {
		this.lft = lft;
	}
	@Column(name ="RGT",nullable=true,precision=255,length=255)
	public String getRgt() {
		return rgt;
	}
	public void setRgt(String rgt) {
		this.rgt = rgt;
	}
	@Column(name ="WDFANWEI",nullable=true,precision=255,length=255)
	public String getWdfanwei() {
		return wdfanwei;
	}
	public void setWdfanwei(String wdfanwei) {
		this.wdfanwei = wdfanwei;
	}
	@Column(name ="SDFANWEI",nullable=true,precision=255,length=255)
	public String getSdfanwei() {
		return sdfanwei;
	}
	public void setSdfanwei(String sdfanwei) {
		this.sdfanwei = sdfanwei;
	}
	
}
