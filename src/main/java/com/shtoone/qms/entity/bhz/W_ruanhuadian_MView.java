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
@Table(name = "W_ruanhuadian_MView", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class W_ruanhuadian_MView implements java.io.Serializable {
	
	private Integer id;
	private String SYJID;
	private String IS_END;
	private String TIME;
	private String F_SBBH;
	private String ProjectName;
	private String SampleNo;
	private String GCBuWei;
	private String SampleName;
	private String SampleMS;
	private String ruanhuadian1;
	private String ruanhuadian2;
	private String RHDAvg;
	private String biaozhunzhi1;
	private String isQualified;
	private String Status;
	private String GROUPNUM;
	private String submittime;
	private String banhezhanminchen;
	private String gprsbianhao;
	private String lft;
	private String rgt;

	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID",nullable=false,precision=10,scale=0,length=4)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name ="SYJID",nullable=true,precision=50,length=50)
	public String getSYJID() {
		return SYJID;
	}
	public void setSYJID(String sYJID) {
		SYJID = sYJID;
	}
	@Column(name ="IS_END",nullable=true,precision=50,length=50)
	public String getIS_END() {
		return IS_END;
	}
	public void setIS_END(String iS_END) {
		IS_END = iS_END;
	}
	@Column(name ="TIME",nullable=true,precision=50,length=50)
	public String getTIME() {
		return TIME;
	}
	public void setTIME(String TIME) {
		this.TIME = TIME;
	}
	@Column(name ="F_SBBH",nullable=true,precision=50,length=50)
	public String getF_SBBH() {
		return F_SBBH;
	}
	public void setF_SBBH(String f_SBBH) {
		F_SBBH = f_SBBH;
	}
	@Column(name ="PROJECTNAME",nullable=true,precision=50,length=50)
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	@Column(name ="SAMPLENO",nullable=true,precision=50,length=50)
	public String getSampleNo() {
		return SampleNo;
	}
	public void setSampleNo(String sampleNo) {
		SampleNo = sampleNo;
	}
	@Column(name ="GCBUWEI",nullable=true,precision=50,length=50)
	public String getGCBuWei() {
		return GCBuWei;
	}
	public void setGCBuWei(String gCBuWei) {
		GCBuWei = gCBuWei;
	}
	@Column(name ="SAMPLENAME",nullable=true,precision=50,length=50)
	public String getSampleName() {
		return SampleName;
	}
	public void setSampleName(String sampleName) {
		SampleName = sampleName;
	}
	@Column(name ="SAMPLEMS",nullable=true,precision=50,length=50)
	public String getSampleMS() {
		return SampleMS;
	}
	public void setSampleMS(String sampleMS) {
		SampleMS = sampleMS;
	}
	@Column(name ="RUANHUADIAN1",nullable=true,precision=50,length=50)
	public String getRuanhuadian1() {
		return ruanhuadian1;
	}
	public void setRuanhuadian1(String ruanhuadian1) {
		this.ruanhuadian1 = ruanhuadian1;
	}
	@Column(name ="RUANHUADIAN2",nullable=true,precision=50,length=50)
	public String getRuanhuadian2() {
		return ruanhuadian2;
	}
	public void setRuanhuadian2(String ruanhuadian2) {
		this.ruanhuadian2 = ruanhuadian2;
	}
	@Column(name ="RHDAVG",nullable=true,precision=50,length=50)
	public String getRHDAvg() {
		return RHDAvg;
	}
	public void setRHDAvg(String rHDAvg) {
		RHDAvg = rHDAvg;
	}
	@Column(name ="BIAOZHUNZHI1",nullable=true,precision=50,length=50)
	public String getBiaozhunzhi1() {
		return biaozhunzhi1;
	}
	public void setBiaozhunzhi1(String biaozhunzhi1) {
		this.biaozhunzhi1 = biaozhunzhi1;
	}
	@Column(name ="ISQUALIFIED",nullable=true,precision=50,length=50)
	public String getIsQualified() {
		return isQualified;
	}
	public void setIsQualified(String isQualified) {
		this.isQualified = isQualified;
	}
	@Column(name ="STATUS",nullable=true,precision=50,length=50)
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Column(name ="GROUPNUM",nullable=true,precision=50,length=50)
	public String getGROUPNUM() {
		return GROUPNUM;
	}
	public void setGROUPNUM(String gROUPNUM) {
		GROUPNUM = gROUPNUM;
	}
	@Column(name ="SUBMITTIME",nullable=true,precision=50,length=50)
	public String getSubmittime() {
		return submittime;
	}
	public void setSubmittime(String submittime) {
		this.submittime = submittime;
	}
	@Column(name ="BANHEZHANMINCHEN",nullable=true,precision=50,length=50)
	public String getBanhezhanminchen() {
		return banhezhanminchen;
	}
	public void setBanhezhanminchen(String banhezhanminchen) {
		this.banhezhanminchen = banhezhanminchen;
	}
	@Column(name ="GPRSBIANHAO",nullable=true,precision=50,length=50)
	public String getGprsbianhao() {
		return gprsbianhao;
	}
	public void setGprsbianhao(String gprsbianhao) {
		this.gprsbianhao = gprsbianhao;
	}
	@Column(name ="LFT",nullable=true,precision=50,length=50)
	public String getLft() {
		return lft;
	}
	public void setLft(String lft) {
		this.lft = lft;
	}
	@Column(name ="RGT",nullable=true,precision=50,length=50)
	public String getRgt() {
		return rgt;
	}
	public void setRgt(String rgt) {
		this.rgt = rgt;
	}
	
}
