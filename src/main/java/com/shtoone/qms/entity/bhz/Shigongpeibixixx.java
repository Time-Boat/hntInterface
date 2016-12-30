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


@Entity
@Table(name = "S_HNT_PHB", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Shigongpeibixixx extends IdEntity implements Serializable{

	/**                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productWorkNo;  //生产任务单号
	private Date chuliaoshijian;  //出料时间
	private BigDecimal chuliaofangliang;  //出料方量
	private BigDecimal xigl1ph;     //细骨料1配比
	private BigDecimal xigl2ph;     //细骨料2配比
	private BigDecimal chugl1ph;    //粗骨料1配比
	private BigDecimal chugl2ph;    //粗骨料2配比
	private BigDecimal chugl3ph;    //粗骨料3配比
	private BigDecimal shuini1ph;   //水泥1配比
	private BigDecimal kuangfenph;   //矿粉配比
	private BigDecimal fenmeihuiph;  //粉煤灰配比
	private BigDecimal shui1ph;      //水1配比
	private BigDecimal waijijia1ph;  //外加剂1配比
	private BigDecimal waijijia2ph;  //外加剂2配比
	private BigDecimal waijijia3ph;  //外加剂3配比
	private BigDecimal waijijia4ph;  //外加剂4配比
	
	
	private String xigl1phid;     //细骨料1配比编号
	private String xigl2phid;     //细骨料2配比编号
	private String chugl1phid;    //粗骨料1配比编号
	private String chugl2phid;    //粗骨料2配比编号
	private String chugl3phid;    //粗骨料3配比编号
	private String shuini1phid;   //水泥1配比编号
	private String kuangfenphid;   //矿粉配比编号
	private String fenmeihuiphid;  //粉煤灰配比编号
	private String shui1phid;      //水1配比编号
	private String waijijia1phid;  //外加剂1配比编号
	private String waijijia2phid;  //外加剂2配比编号
	private String waijijia3phid;  //外加剂3配比编号
	private String waijijia4phid;  //外加剂4配比编号
	
	private BigDecimal shuijiaobi;   //水胶比
	private Date baopidata;   //报批日期
	private Date pifudata;    //批复日期
	private String remark;     //备注
	private String userGroup;  //所属试验室
	private String shebeibianhao;    //拌和机编号
	private String dataresource;   //数据来源厂商
	private String state;    //状态
	private String lilunId;    //关联的施工配比编号
	private String phbid;// 配合比ID
	
	@Column(name ="productWorkNo",nullable=true,precision=255,length=255)
	public String getProductWorkNo() {
		return productWorkNo;
	}
	public void setProductWorkNo(String productWorkNo) {
		this.productWorkNo = productWorkNo;
	}
	@Column(name ="chuliaoshijian",nullable=true)
	public Date getChuliaoshijian() {
		return chuliaoshijian;
	}
	public void setChuliaoshijian(Date chuliaoshijian) {
		this.chuliaoshijian = chuliaoshijian;
	}
	@Column(name ="chuliaofangliang",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getChuliaofangliang() {
		return chuliaofangliang;
	}
	public void setChuliaofangliang(BigDecimal chuliaofangliang) {
		this.chuliaofangliang = chuliaofangliang;
	}
	@Column(name ="xigl1ph",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getXigl1ph() {
		return xigl1ph;
	}
	public void setXigl1ph(BigDecimal xigl1ph) {
		this.xigl1ph = xigl1ph;
	}
	@Column(name ="xigl2ph",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getXigl2ph() {
		return xigl2ph;
	}
	public void setXigl2ph(BigDecimal xigl2ph) {
		this.xigl2ph = xigl2ph;
	}
	@Column(name ="chugl1ph",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getChugl1ph() {
		return chugl1ph;
	}
	public void setChugl1ph(BigDecimal chugl1ph) {
		this.chugl1ph = chugl1ph;
	}
	@Column(name ="chugl2ph",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getChugl2ph() {
		return chugl2ph;
	}
	public void setChugl2ph(BigDecimal chugl2ph) {
		this.chugl2ph = chugl2ph;
	}
	@Column(name ="chugl3ph",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getChugl3ph() {
		return chugl3ph;
	}
	public void setChugl3ph(BigDecimal chugl3ph) {
		this.chugl3ph = chugl3ph;
	}
	@Column(name ="shuini1ph",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getShuini1ph() {
		return shuini1ph;
	}
	public void setShuini1ph(BigDecimal shuini1ph) {
		this.shuini1ph = shuini1ph;
	}
	@Column(name ="kuangfenph",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getKuangfenph() {
		return kuangfenph;
	}
	public void setKuangfenph(BigDecimal kuangfenph) {
		this.kuangfenph = kuangfenph;
	}
	@Column(name ="fenmeihuiph",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getFenmeihuiph() {
		return fenmeihuiph;
	}
	public void setFenmeihuiph(BigDecimal fenmeihuiph) {
		this.fenmeihuiph = fenmeihuiph;
	}
	@Column(name ="shui1ph",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getShui1ph() {
		return shui1ph;
	}
	public void setShui1ph(BigDecimal shui1ph) {
		this.shui1ph = shui1ph;
	}
	@Column(name ="waijijia1ph",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getWaijijia1ph() {
		return waijijia1ph;
	}
	public void setWaijijia1ph(BigDecimal waijijia1ph) {
		this.waijijia1ph = waijijia1ph;
	}
	@Column(name ="waijijia2ph",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getWaijijia2ph() {
		return waijijia2ph;
	}
	public void setWaijijia2ph(BigDecimal waijijia2ph) {
		this.waijijia2ph = waijijia2ph;
	}
	@Column(name ="waijijia3ph",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getWaijijia3ph() {
		return waijijia3ph;
	}
	public void setWaijijia3ph(BigDecimal waijijia3ph) {
		this.waijijia3ph = waijijia3ph;
	}
	@Column(name ="waijijia4ph",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getWaijijia4ph() {
		return waijijia4ph;
	}
	public void setWaijijia4ph(BigDecimal waijijia4ph) {
		this.waijijia4ph = waijijia4ph;
	}
	@Column(name ="shuijiaobi",nullable=true,precision=18,scale=4,length=9)
	public BigDecimal getShuijiaobi() {
		return shuijiaobi;
	}
	public void setShuijiaobi(BigDecimal shuijiaobi) {
		this.shuijiaobi = shuijiaobi;
	}
	@Column(name ="baopidata",nullable=true)
	public Date getBaopidata() {
		return baopidata;
	}
	public void setBaopidata(Date baopidata) {
		this.baopidata = baopidata;
	}
	@Column(name ="pifudata",nullable=true)
	public Date getPifudata() {
		return pifudata;
	}
	public void setPifudata(Date pifudata) {
		this.pifudata = pifudata;
	}
	@Column(name ="remark",nullable=true,precision=255,length=255)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name ="userGroup",nullable=true,precision=255,length=255)
	public String getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
	@Column(name ="shebeibianhao",nullable=true,precision=255,length=255)
	public String getShebeibianhao() {
		return shebeibianhao;
	}
	public void setShebeibianhao(String shebeibianhao) {
		this.shebeibianhao = shebeibianhao;
	}
	@Column(name ="dataresource",nullable=true,precision=255,length=255)
	public String getDataresource() {
		return dataresource;
	}
	public void setDataresource(String dataresource) {
		this.dataresource = dataresource;
	}
	@Column(name ="state",nullable=true,precision=255,length=255)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name ="lilunId",nullable=true,precision=35,length=35)
	public String getLilunId() {
		return lilunId;
	}
	public void setLilunId(String lilunId) {
		this.lilunId = lilunId;
	}
	
	@Column(name ="phbid",nullable=true,precision=50,length=50)
	public String getPhbid() {
		return phbid;
	}
	public void setPhbid(String phbid) {
		this.phbid = phbid;
	}
	
	@Column(name ="xigl1phid",nullable=true,precision=255,length=255)
	public String getXigl1phid() {
		return xigl1phid;
	}
	public void setXigl1phid(String xigl1phid) {
		this.xigl1phid = xigl1phid;
	}
	
	@Column(name ="xigl2phid",nullable=true,precision=255,length=255)
	public String getXigl2phid() {
		return xigl2phid;
	}
	public void setXigl2phid(String xigl2phid) {
		this.xigl2phid = xigl2phid;
	}
	
	@Column(name ="chugl1phid",nullable=true,precision=255,length=255)
	public String getChugl1phid() {
		return chugl1phid;
	}
	public void setChugl1phid(String chugl1phid) {
		this.chugl1phid = chugl1phid;
	}
	@Column(name ="chugl2phid",nullable=true,precision=255,length=255)
	public String getChugl2phid() {
		return chugl2phid;
	}
	public void setChugl2phid(String chugl2phid) {
		this.chugl2phid = chugl2phid;
	}
	
	@Column(name ="chugl3phid",nullable=true,precision=255,length=255)
	public String getChugl3phid() {
		return chugl3phid;
	}
	public void setChugl3phid(String chugl3phid) {
		this.chugl3phid = chugl3phid;
	}
	
	@Column(name ="shuini1phid",nullable=true,precision=255,length=255)
	public String getShuini1phid() {
		return shuini1phid;
	}
	public void setShuini1phid(String shuini1phid) {
		this.shuini1phid = shuini1phid;
	}
	
	@Column(name ="kuangfenphid",nullable=true,precision=255,length=255)
	public String getKuangfenphid() {
		return kuangfenphid;
	}
	public void setKuangfenphid(String kuangfenphid) {
		this.kuangfenphid = kuangfenphid;
	}
	
	@Column(name ="fenmeihuiphid",nullable=true,precision=255,length=255)
	public String getFenmeihuiphid() {
		return fenmeihuiphid;
	}
	public void setFenmeihuiphid(String fenmeihuiphid) {
		this.fenmeihuiphid = fenmeihuiphid;
	}
	
	@Column(name ="shui1phid",nullable=true,precision=255,length=255)
	public String getShui1phid() {
		return shui1phid;
	}
	
	public void setShui1phid(String shui1phid) {
		this.shui1phid = shui1phid;
	}
	
	@Column(name ="waijijia1phid",nullable=true,precision=255,length=255)
	public String getWaijijia1phid() {
		return waijijia1phid;
	}
	public void setWaijijia1phid(String waijijia1phid) {
		this.waijijia1phid = waijijia1phid;
	}
	
	@Column(name ="waijijia2phid",nullable=true,precision=255,length=255)
	public String getWaijijia2phid() {
		return waijijia2phid;
	}
	public void setWaijijia2phid(String waijijia2phid) {
		this.waijijia2phid = waijijia2phid;
	}
	
	@Column(name ="waijijia3phid",nullable=true,precision=255,length=255)
	public String getWaijijia3phid() {
		return waijijia3phid;
	}
	public void setWaijijia3phid(String waijijia3phid) {
		this.waijijia3phid = waijijia3phid;
	}
	
	@Column(name ="waijijia4phid",nullable=true,precision=255,length=255)
	public String getWaijijia4phid() {
		return waijijia4phid;
	}
	public void setWaijijia4phid(String waijijia4phid) {
		this.waijijia4phid = waijijia4phid;
	}
	
	
	

}
