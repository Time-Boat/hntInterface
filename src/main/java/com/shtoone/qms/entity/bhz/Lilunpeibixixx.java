package com.shtoone.qms.entity.bhz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.jeecgframework.core.common.entity.IdEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "S_HNT_Lilun_PHB", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Lilunpeibixixx extends IdEntity implements Serializable{
	private String phbreportId;           //配合比报告编号（配合比编号）
	private Date reportDate;           //报告日期
	private String gongchengbuwei;       //拟使用工程部位
	private String qiangdudengji;        //混凝土强度等级
	private BigDecimal shuiniLlphb;     //混凝土配合比1-水泥用量
	private BigDecimal fenmeihuiLlphb;  //混凝土配合比2-粉煤灰用量
	private BigDecimal kuangfenLlphb;   //混凝土配合比3-矿粉用量
	private BigDecimal xiguliaoLlphb;   //混凝土配合比4-细集料用量
	private BigDecimal cuguliaoLlphb;  //混凝土配合比5-粗集料用量
	private BigDecimal banheshuiLlphb;  //混凝土配合比6-拌合水用量
	private BigDecimal waijiajiLlphb;   //混凝土配合比7-外加剂用量
	private BigDecimal yingqijiLlphb;   //混凝土配合比7-外加剂用量
	
	private String shuiniLlphbid;     //混凝土配合比1-水泥用量配合比编号
	private String fenmeihuiLlphbid;  //混凝土配合比2-粉煤灰用量配合比编号
	private String kuangfenLlphbid;   //混凝土配合比3-矿粉用量配合比编号
	private String xiguliaoLlphbid;   //混凝土配合比4-细集料用量配合比编号
	private String cuguliaoLlphbid;  //混凝土配合比5-粗集料用量配合比编号
	private String banheshuiLlphbid;  //混凝土配合比6-拌合水用量配合比编号
	private String waijiajiLlphbid;   //混凝土配合比7-外加剂用量配合比编号
	private String yingqijiLlphbid;   //混凝土配合比7-外加剂用量配合比编号
	
	
	private BigDecimal shuijiaobiLlphb;  //混凝土配合比参数1-水胶比
	private BigDecimal jiaocaiLlphb;    //混凝土配合比参数2-胶材用量
	private BigDecimal shalvLlphb;      //混凝土配合比参数3-砂率
	private BigDecimal kangyaqiangdu7d;  //混凝土性能1-7d抗压强度
	private BigDecimal kangyaqiangdu28d;  //混凝土性能2-28d抗压强度
	private BigDecimal kangyaqiangdu56d;  //混凝土性能3-56d抗压强度
	private BigDecimal diantongliang;     //混凝土性能4-电通量
	private BigDecimal kangdongxing;      //混凝土性能5-抗冻性
	private BigDecimal lvkuosanxishu;     //混凝土性能6-氯离子扩散系数
	private String testResult;          //试验结论
	private String tester;              //试验人员
	private String userGroup;           //所属单位
	private String superGroup;          //用于关联施工配比
	private String testId;              //所属试验室id
	private String state;               //状态
	
	private String beizhu;               //状态
	@Column(name ="phbreportId",nullable=true,precision=255,length=255)
	public String getPhbreportId() {
		return phbreportId;
	}
	public void setPhbreportId(String phbreportId) {
		this.phbreportId = phbreportId;
	}
	@Column(name ="reportDate",nullable=true)
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	@Column(name ="gongchengbuwei",nullable=true,precision=255,length=255)
	public String getGongchengbuwei() {
		return gongchengbuwei;
	}
	public void setGongchengbuwei(String gongchengbuwei) {
		this.gongchengbuwei = gongchengbuwei;
	}
	@Column(name ="qiangdudengji",nullable=true,precision=255,length=255)
	public String getQiangdudengji() {
		return qiangdudengji;
	}
	public void setQiangdudengji(String qiangdudengji) {
		this.qiangdudengji = qiangdudengji;
	}
	@Column(name ="shuini_llphb",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getShuiniLlphb() {
		return shuiniLlphb;
	}
	public void setShuiniLlphb(BigDecimal shuiniLlphb) {
		this.shuiniLlphb = shuiniLlphb;
	}
	@Column(name ="fenmeihui_llphb",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getFenmeihuiLlphb() {
		return fenmeihuiLlphb;
	}
	public void setFenmeihuiLlphb(BigDecimal fenmeihuiLlphb) {
		this.fenmeihuiLlphb = fenmeihuiLlphb;
	}
	@Column(name ="kuangfen_llphb",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getKuangfenLlphb() {
		return kuangfenLlphb;
	}
	public void setKuangfenLlphb(BigDecimal kuangfenLlphb) {
		this.kuangfenLlphb = kuangfenLlphb;
	}
	@Column(name ="xiguliao_llphb",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getXiguliaoLlphb() {
		return xiguliaoLlphb;
	}
	public void setXiguliaoLlphb(BigDecimal xiguliaoLlphb) {
		this.xiguliaoLlphb = xiguliaoLlphb;
	}
	@Column(name ="cuguliao_llphb",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getCuguliaoLlphb() {
		return cuguliaoLlphb;
	}
	public void setCuguliaoLlphb(BigDecimal cuguliaoLlphb) {
		this.cuguliaoLlphb = cuguliaoLlphb;
	}
	@Column(name ="banheshui_llphb",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getBanheshuiLlphb() {
		return banheshuiLlphb;
	}
	public void setBanheshuiLlphb(BigDecimal banheshuiLlphb) {
		this.banheshuiLlphb = banheshuiLlphb;
	}
	@Column(name ="waijiaji_llphb",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getWaijiajiLlphb() {
		return waijiajiLlphb;
	}
	public void setWaijiajiLlphb(BigDecimal waijiajiLlphb) {
		this.waijiajiLlphb = waijiajiLlphb;
	}
	@Column(name ="shuijiaobi_llphb",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getShuijiaobiLlphb() {
		return shuijiaobiLlphb;
	}
	public void setShuijiaobiLlphb(BigDecimal shuijiaobiLlphb) {
		this.shuijiaobiLlphb = shuijiaobiLlphb;
	}
	@Column(name ="jiaocai_llphb",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getJiaocaiLlphb() {
		return jiaocaiLlphb;
	}
	public void setJiaocaiLlphb(BigDecimal jiaocaiLlphb) {
		this.jiaocaiLlphb = jiaocaiLlphb;
	}
	@Column(name ="shalv_llphb",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getShalvLlphb() {
		return shalvLlphb;
	}
	public void setShalvLlphb(BigDecimal shalvLlphb) {
		this.shalvLlphb = shalvLlphb;
	}
	@Column(name ="kangyaqiangdu7d",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getKangyaqiangdu7d() {
		return kangyaqiangdu7d;
	}
	public void setKangyaqiangdu7d(BigDecimal kangyaqiangdu7d) {
		this.kangyaqiangdu7d = kangyaqiangdu7d;
	}
	@Column(name ="kangyaqiangdu28d",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getKangyaqiangdu28d() {
		return kangyaqiangdu28d;
	}
	public void setKangyaqiangdu28d(BigDecimal kangyaqiangdu28d) {
		this.kangyaqiangdu28d = kangyaqiangdu28d;
	}
	@Column(name ="kangyaqiangdu56d",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getKangyaqiangdu56d() {
		return kangyaqiangdu56d;
	}
	public void setKangyaqiangdu56d(BigDecimal kangyaqiangdu56d) {
		this.kangyaqiangdu56d = kangyaqiangdu56d;
	}
	@Column(name ="diantongliang",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getDiantongliang() {
		return diantongliang;
	}
	public void setDiantongliang(BigDecimal diantongliang) {
		this.diantongliang = diantongliang;
	}
	@Column(name ="kangdongxing",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getKangdongxing() {
		return kangdongxing;
	}
	public void setKangdongxing(BigDecimal kangdongxing) {
		this.kangdongxing = kangdongxing;
	}
	@Column(name ="lvkuosanxishu",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getLvkuosanxishu() {
		return lvkuosanxishu;
	}
	public void setLvkuosanxishu(BigDecimal lvkuosanxishu) {
		this.lvkuosanxishu = lvkuosanxishu;
	}
	@Column(name ="testResult",nullable=true,precision=255,length=255)
	public String getTestResult() {
		return testResult;
	}
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	@Column(name ="tester",nullable=true,precision=255,length=255)
	public String getTester() {
		return tester;
	}
	public void setTester(String tester) {
		this.tester = tester;
	}
	@Column(name ="userGroup",nullable=true,precision=255,length=255)
	public String getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
	@Column(name ="superGroup",nullable=true,precision=255,length=255)
	public String getSuperGroup() {
		return superGroup;
	}
	public void setSuperGroup(String superGroup) {
		this.superGroup = superGroup;
	}
	@Column(name ="testId",nullable=true,precision=255,length=255)
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	@Column(name ="state",nullable=true,precision=255,length=255)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name ="shuiniLlphbid",nullable=true,precision=255,length=255)
	public String getShuiniLlphbid() {
		return shuiniLlphbid;
	}
	public void setShuiniLlphbid(String shuiniLlphbid) {
		this.shuiniLlphbid = shuiniLlphbid;
	}
	
	@Column(name ="fenmeihuiLlphbid",nullable=true,precision=255,length=255)
	public String getFenmeihuiLlphbid() {
		return fenmeihuiLlphbid;
	}
	public void setFenmeihuiLlphbid(String fenmeihuiLlphbid) {
		this.fenmeihuiLlphbid = fenmeihuiLlphbid;
	}
	
	@Column(name ="kuangfenLlphbid",nullable=true,precision=255,length=255)
	public String getKuangfenLlphbid() {
		return kuangfenLlphbid;
	}
	public void setKuangfenLlphbid(String kuangfenLlphbid) {
		this.kuangfenLlphbid = kuangfenLlphbid;
	}
	
	@Column(name ="xiguliaoLlphbid",nullable=true,precision=255,length=255)
	public String getXiguliaoLlphbid() {
		return xiguliaoLlphbid;
	}
	public void setXiguliaoLlphbid(String xiguliaoLlphbid) {
		this.xiguliaoLlphbid = xiguliaoLlphbid;
	}
	
	@Column(name ="cuguliaoLlphbid",nullable=true,precision=255,length=255)
	public String getCuguliaoLlphbid() {
		return cuguliaoLlphbid;
	}
	public void setCuguliaoLlphbid(String cuguliaoLlphbid) {
		this.cuguliaoLlphbid = cuguliaoLlphbid;
	}
	
	@Column(name ="banheshuiLlphbid",nullable=true,precision=255,length=255)
	public String getBanheshuiLlphbid() {
		return banheshuiLlphbid;
	}
	public void setBanheshuiLlphbid(String banheshuiLlphbid) {
		this.banheshuiLlphbid = banheshuiLlphbid;
	}
	
	@Column(name ="waijiajiLlphbid",nullable=true,precision=255,length=255)
	public String getWaijiajiLlphbid() {
		return waijiajiLlphbid;
	}
	public void setWaijiajiLlphbid(String waijiajiLlphbid) {
		this.waijiajiLlphbid = waijiajiLlphbid;
	}
	
	@Column(name ="yingqiji_llphb",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getYingqijiLlphb() {
		return yingqijiLlphb;
	}
	public void setYingqijiLlphb(BigDecimal yingqijiLlphb) {
		this.yingqijiLlphb = yingqijiLlphb;
	}
	
	@Column(name ="yingqijiLlphbid",nullable=true,precision=255,length=255)
	public String getYingqijiLlphbid() {
		return yingqijiLlphbid;
	}
	public void setYingqijiLlphbid(String yingqijiLlphbid) {
		this.yingqijiLlphbid = yingqijiLlphbid;
	}
	@Column(name ="beizhu",nullable=true,precision=255,length=255)
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
}
