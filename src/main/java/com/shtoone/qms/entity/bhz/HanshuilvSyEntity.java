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
@Table(name = "HanShuiLvSY", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class HanshuilvSyEntity implements java.io.Serializable{
	private Integer id;
	private String SYJID;
	private String SBBH;
	private String CLMC;
	private String JCSJ;
	private String SZL;
	private String GZL;
	private String HSL;
	private String SJSCSJ;
	private String CZRY;
	private Integer STATUS;
	private String SGPHB;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id",nullable=false,precision=10,scale=0,length=4)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name ="SYJID",nullable=true,precision=250,length=250)
	public String getSYJID() {
		return SYJID;
	}
	public void setSYJID(String sYJID) {
		SYJID = sYJID;
	}
	
	@Column(name ="SBBH",nullable=true,precision=250,length=250)
	public String getSBBH() {
		return SBBH;
	}
	public void setSBBH(String sBBH) {
		SBBH = sBBH;
	}
	
	@Column(name ="CLMC",nullable=true,precision=250,length=250)
	public String getCLMC() {
		return CLMC;
	}
	public void setCLMC(String cLMC) {
		CLMC = cLMC;
	}
	
	@Column(name ="JCSJ",nullable=true,precision=250,length=250)
	public String getJCSJ() {
		return JCSJ;
	}
	public void setJCSJ(String jCSJ) {
		JCSJ = jCSJ;
	}
	
	@Column(name ="SZL",nullable=true,precision=250,length=250)
	public String getSZL() {
		return SZL;
	}
	public void setSZL(String sZL) {
		SZL = sZL;
	}
	
	@Column(name ="GZL",nullable=true,precision=250,length=250)
	public String getGZL() {
		return GZL;
	}
	public void setGZL(String gZL) {
		GZL = gZL;
	}
	
	@Column(name ="HSL",nullable=true,precision=250,length=250)
	public String getHSL() {
		return HSL;
	}
	public void setHSL(String hSL) {
		HSL = hSL;
	}
	
	@Column(name ="SJSCSJ",nullable=true,precision=250,length=250)
	public String getSJSCSJ() {
		return SJSCSJ;
	}
	public void setSJSCSJ(String sJSCSJ) {
		SJSCSJ = sJSCSJ;
	}
	
	@Column(name ="CZRY",nullable=true,precision=250,length=250)
	public String getCZRY() {
		return CZRY;
	}
	public void setCZRY(String cZRY) {
		CZRY = cZRY;
	}
	
	@Column(name ="STATUS",nullable=false,precision=10,scale=0,length=4)
	public Integer getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(Integer sTATUS) {
		STATUS = sTATUS;
	}
	
	@Column(name ="SGPHB",nullable=true,precision=250,length=250)
	public String getSGPHB() {
		return SGPHB;
	}
	public void setSGPHB(String sGPHB) {
		SGPHB = sGPHB;
	}
	
}
