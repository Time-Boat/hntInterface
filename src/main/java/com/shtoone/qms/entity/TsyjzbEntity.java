package com.shtoone.qms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**   
 * @Title: Entity
 * @Description: 试验机主表
 * @author
 * @date 2014-02-24 14:02:54
 * @version V1.0   
 *
 */
@Entity
@Table(name = "T_SYJZB", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class TsyjzbEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**version*/
	private java.lang.Integer version;
	/**syjid*/
	private java.lang.String syjid;
	/**wtid*/
	private java.lang.String wtid;
	/**sbbh*/
	private java.lang.String sbbh;
	/**sylx*/
	private java.lang.String sylx;
	/**wtbh*/
	private java.lang.String wtbh;
	/**sjbh*/
	private java.lang.String sjbh;
	/**zzrq*/
	private java.lang.String zzrq;
	/**syrq*/
	private java.lang.String syrq;
	/**sywcsj*/
	private java.lang.String sywcsj;
	/**sjscsj*/
	private java.lang.String sjscsj;
	/**lq*/
	private java.lang.Integer lq;
	/**sjcc*/
	private java.lang.String sjcc;
	/**sjmj*/
	private java.lang.String sjmj;
	/**sjsl*/
	private java.lang.String sjsl;
	/**sjqd*/
	private java.lang.String sjqd;
	/**zsxs*/
	private java.lang.String zsxs;
	/**qddbz*/
	private java.lang.String qddbz;
	/**pdjg*/
	private java.lang.String pdjg;
	/**czry*/
	private java.lang.String czry;
	/**cjmc*/
	private java.lang.String cjmc;
	/**pzbm*/
	private java.lang.String pzbm;
	/**gczj*/
	private java.lang.String gczj;
	/**area*/
	private java.lang.String area;
	/**iswjj*/
	private java.lang.Integer iswjj;
	/**rtcode*/
	private java.lang.String rtcode;
	/**szfw*/
	private java.lang.String szfw;
	/**fbl*/
	private java.lang.String fbl;
	/**status*/
	private java.lang.Integer status;
	/**wtzs*/
	private java.lang.String wtzs;
	/**recGuid*/
	private java.lang.String recGuid;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID",nullable=false,precision=19,scale=0,length=8)
	public java.lang.Integer getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  id
	 */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  version
	 */
	@Column(name ="VERSION",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getVersion(){
		return this.version;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  version
	 */
	public void setVersion(java.lang.Integer version){
		this.version = version;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  syjid
	 */
	@Column(name ="SYJID",nullable=false,precision=50,length=100)
	public java.lang.String getSyjid(){
		return this.syjid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  syjid
	 */
	public void setSyjid(java.lang.String syjid){
		this.syjid = syjid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  wtid
	 */
	@Column(name ="WTID",nullable=true,precision=50,length=100)
	public java.lang.String getWtid(){
		return this.wtid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  wtid
	 */
	public void setWtid(java.lang.String wtid){
		this.wtid = wtid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sbbh
	 */
	@Column(name ="SBBH",nullable=true,precision=50,length=100)
	public java.lang.String getSbbh(){
		return this.sbbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sbbh
	 */
	public void setSbbh(java.lang.String sbbh){
		this.sbbh = sbbh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sylx
	 */
	@Column(name ="SYLX",nullable=true,precision=50,length=100)
	public java.lang.String getSylx(){
		return this.sylx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sylx
	 */
	public void setSylx(java.lang.String sylx){
		this.sylx = sylx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  wtbh
	 */
	@Column(name ="WTBH",nullable=true,precision=50,length=100)
	public java.lang.String getWtbh(){
		return this.wtbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  wtbh
	 */
	public void setWtbh(java.lang.String wtbh){
		this.wtbh = wtbh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sjbh
	 */
	@Column(name ="SJBH",nullable=true,precision=50,length=100)
	public java.lang.String getSjbh(){
		return this.sjbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sjbh
	 */
	public void setSjbh(java.lang.String sjbh){
		this.sjbh = sjbh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  zzrq
	 */
	@Column(name ="ZZRQ",nullable=true,precision=50,length=100)
	public java.lang.String getZzrq(){
		return this.zzrq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  zzrq
	 */
	public void setZzrq(java.lang.String zzrq){
		this.zzrq = zzrq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  syrq
	 */
	@Column(name ="SYRQ",nullable=true,precision=50,length=100)
	public java.lang.String getSyrq(){
		return this.syrq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  syrq
	 */
	public void setSyrq(java.lang.String syrq){
		this.syrq = syrq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sywcsj
	 */
	@Column(name ="SYWCSJ",nullable=true,precision=50,length=100)
	public java.lang.String getSywcsj(){
		return this.sywcsj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sywcsj
	 */
	public void setSywcsj(java.lang.String sywcsj){
		this.sywcsj = sywcsj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sjscsj
	 */
	@Column(name ="SJSCSJ",nullable=true,precision=50,length=100)
	public java.lang.String getSjscsj(){
		return this.sjscsj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sjscsj
	 */
	public void setSjscsj(java.lang.String sjscsj){
		this.sjscsj = sjscsj;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  lq
	 */
	@Column(name ="LQ",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getLq(){
		return this.lq;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  lq
	 */
	public void setLq(java.lang.Integer lq){
		this.lq = lq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sjcc
	 */
	@Column(name ="SJCC",nullable=true,precision=50,length=100)
	public java.lang.String getSjcc(){
		return this.sjcc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sjcc
	 */
	public void setSjcc(java.lang.String sjcc){
		this.sjcc = sjcc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sjmj
	 */
	@Column(name ="SJMJ",nullable=true,precision=50,length=100)
	public java.lang.String getSjmj(){
		return this.sjmj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sjmj
	 */
	public void setSjmj(java.lang.String sjmj){
		this.sjmj = sjmj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sjsl
	 */
	@Column(name ="SJSL",nullable=true,precision=50,length=100)
	public java.lang.String getSjsl(){
		return this.sjsl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sjsl
	 */
	public void setSjsl(java.lang.String sjsl){
		this.sjsl = sjsl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sjqd
	 */
	@Column(name ="SJQD",nullable=true,precision=50,length=100)
	public java.lang.String getSjqd(){
		return this.sjqd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sjqd
	 */
	public void setSjqd(java.lang.String sjqd){
		this.sjqd = sjqd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  zsxs
	 */
	@Column(name ="ZSXS",nullable=true,precision=50,length=100)
	public java.lang.String getZsxs(){
		return this.zsxs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  zsxs
	 */
	public void setZsxs(java.lang.String zsxs){
		this.zsxs = zsxs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  qddbz
	 */
	@Column(name ="QDDBZ",nullable=true,precision=50,length=100)
	public java.lang.String getQddbz(){
		return this.qddbz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  qddbz
	 */
	public void setQddbz(java.lang.String qddbz){
		this.qddbz = qddbz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  pdjg
	 */
	@Column(name ="PDJG",nullable=true,precision=50,length=100)
	public java.lang.String getPdjg(){
		return this.pdjg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  pdjg
	 */
	public void setPdjg(java.lang.String pdjg){
		this.pdjg = pdjg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  czry
	 */
	@Column(name ="CZRY",nullable=true,precision=50,length=100)
	public java.lang.String getCzry(){
		return this.czry;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  czry
	 */
	public void setCzry(java.lang.String czry){
		this.czry = czry;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cjmc
	 */
	@Column(name ="CJMC",nullable=true,precision=50,length=100)
	public java.lang.String getCjmc(){
		return this.cjmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cjmc
	 */
	public void setCjmc(java.lang.String cjmc){
		this.cjmc = cjmc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  pzbm
	 */
	@Column(name ="PZBM",nullable=true,precision=50,length=100)
	public java.lang.String getPzbm(){
		return this.pzbm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  pzbm
	 */
	public void setPzbm(java.lang.String pzbm){
		this.pzbm = pzbm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  gczj
	 */
	@Column(name ="GCZJ",nullable=true,precision=50,length=100)
	public java.lang.String getGczj(){
		return this.gczj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  gczj
	 */
	public void setGczj(java.lang.String gczj){
		this.gczj = gczj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  area
	 */
	@Column(name ="AREA",nullable=true,precision=50,length=100)
	public java.lang.String getArea(){
		return this.area;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  area
	 */
	public void setArea(java.lang.String area){
		this.area = area;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  iswjj
	 */
	@Column(name ="ISWJJ",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getIswjj(){
		return this.iswjj;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  iswjj
	 */
	public void setIswjj(java.lang.Integer iswjj){
		this.iswjj = iswjj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  rtcode
	 */
	@Column(name ="RTCODE",nullable=true,precision=50,length=100)
	public java.lang.String getRtcode(){
		return this.rtcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  rtcode
	 */
	public void setRtcode(java.lang.String rtcode){
		this.rtcode = rtcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  szfw
	 */
	@Column(name ="SZFW",nullable=true,precision=50,length=100)
	public java.lang.String getSzfw(){
		return this.szfw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  szfw
	 */
	public void setSzfw(java.lang.String szfw){
		this.szfw = szfw;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fbl
	 */
	@Column(name ="FBL",nullable=true,precision=50,length=100)
	public java.lang.String getFbl(){
		return this.fbl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fbl
	 */
	public void setFbl(java.lang.String fbl){
		this.fbl = fbl;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  status
	 */
	@Column(name ="STATUS",nullable=true,precision=5,scale=0,length=2)
	public java.lang.Integer getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  status
	 */
	public void setStatus(java.lang.Integer status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  wtzs
	 */
	@Column(name ="WTZS",nullable=true,precision=50,length=50)
	public java.lang.String getWtzs(){
		return this.wtzs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  wtzs
	 */
	public void setWtzs(java.lang.String wtzs){
		this.wtzs = wtzs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  recGuid
	 */
	@Column(name ="REC_GUID",nullable=true,precision=50,length=50)
	public java.lang.String getRecGuid(){
		return this.recGuid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  recGuid
	 */
	public void setRecGuid(java.lang.String recGuid){
		this.recGuid = recGuid;
	}
}
