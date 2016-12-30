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
 * @Description: 万能机
 * @author 
 * @date 2015-04-14 16:34:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "F_Wangnj", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class FwangnjEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**version*/
	private java.lang.Integer version;
	/**fGuid*/
	private java.lang.String fGuid;
	/**sjxh*/
	private java.lang.String sjxh;
	/**syjid*/
	private java.lang.String syjid;
	/**wsbz*/
	private java.lang.String wsbz;
	/**dhbz*/
	private java.lang.String dhbz;
	/**lz*/
	private java.lang.String lz;
	/**lzqd*/
	private java.lang.String lzqd;
	/**wy*/
	private java.lang.String wy;
	/**lzgc*/
	private java.lang.String lzgc;
	/**sjgc*/
	private java.lang.String sjgc;
	/**qflz*/
	private java.lang.String qflz;
	/**qfqd*/
	private java.lang.String qfqd;
	/**scl*/
	private java.lang.String scl;
	/**sysj*/
	private java.lang.String sysj;
	/**wcsj*/
	private java.lang.String wcsj;
	/**status*/
	private java.lang.Integer status;
	/**zdlzscl*/
	private java.lang.String zdlzscl;
	/**ldcms*/
	private java.lang.String ldcms;
	/**dkwz*/
	private java.lang.String dkwz;
	
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
	 *@return: java.lang.String  fGuid
	 */
	@Column(name ="F_GUID",nullable=false,precision=50,length=100)
	public java.lang.String getFGuid(){
		return this.fGuid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fGuid
	 */
	public void setFGuid(java.lang.String fGuid){
		this.fGuid = fGuid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sjxh
	 */
	@Column(name ="SJXH",nullable=true,precision=50,length=100)
	public java.lang.String getSjxh(){
		return this.sjxh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sjxh
	 */
	public void setSjxh(java.lang.String sjxh){
		this.sjxh = sjxh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  syjid
	 */
	@Column(name ="SYJID",nullable=true,precision=50,length=100)
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
	 *@return: java.lang.String  wsbz
	 */
	@Column(name ="WSBZ",nullable=true,precision=50,length=100)
	public java.lang.String getWsbz(){
		return this.wsbz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  wsbz
	 */
	public void setWsbz(java.lang.String wsbz){
		this.wsbz = wsbz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  dhbz
	 */
	@Column(name ="DHBZ",nullable=true,precision=50,length=100)
	public java.lang.String getDhbz(){
		return this.dhbz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  dhbz
	 */
	public void setDhbz(java.lang.String dhbz){
		this.dhbz = dhbz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  lz
	 */
	@Column(name ="LZ",nullable=true,precision=50,length=100)
	public java.lang.String getLz(){
		return this.lz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  lz
	 */
	public void setLz(java.lang.String lz){
		this.lz = lz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  lzqd
	 */
	@Column(name ="LZQD",nullable=true,precision=50,length=100)
	public java.lang.String getLzqd(){
		return this.lzqd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  lzqd
	 */
	public void setLzqd(java.lang.String lzqd){
		this.lzqd = lzqd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  wy
	 */
	@Column(name ="WY",nullable=true,precision=-1,length=-1)
	public java.lang.String getWy(){
		return this.wy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  wy
	 */
	public void setWy(java.lang.String wy){
		this.wy = wy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  lzgc
	 */
	@Column(name ="LZGC",nullable=true,precision=-1,length=-1)
	public java.lang.String getLzgc(){
		return this.lzgc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  lzgc
	 */
	public void setLzgc(java.lang.String lzgc){
		this.lzgc = lzgc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sjgc
	 */
	@Column(name ="SJGC",nullable=true,precision=-1,length=-1)
	public java.lang.String getSjgc(){
		return this.sjgc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sjgc
	 */
	public void setSjgc(java.lang.String sjgc){
		this.sjgc = sjgc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  qflz
	 */
	@Column(name ="QFLZ",nullable=true,precision=50,length=100)
	public java.lang.String getQflz(){
		return this.qflz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  qflz
	 */
	public void setQflz(java.lang.String qflz){
		this.qflz = qflz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  qfqd
	 */
	@Column(name ="QFQD",nullable=true,precision=50,length=100)
	public java.lang.String getQfqd(){
		return this.qfqd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  qfqd
	 */
	public void setQfqd(java.lang.String qfqd){
		this.qfqd = qfqd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  scl
	 */
	@Column(name ="SCL",nullable=true,precision=50,length=100)
	public java.lang.String getScl(){
		return this.scl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  scl
	 */
	public void setScl(java.lang.String scl){
		this.scl = scl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sysj
	 */
	@Column(name ="SYSJ",nullable=true,precision=50,length=100)
	public java.lang.String getSysj(){
		return this.sysj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sysj
	 */
	public void setSysj(java.lang.String sysj){
		this.sysj = sysj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  wcsj
	 */
	@Column(name ="WCSJ",nullable=true,precision=50,length=100)
	public java.lang.String getWcsj(){
		return this.wcsj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  wcsj
	 */
	public void setWcsj(java.lang.String wcsj){
		this.wcsj = wcsj;
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
	 *@return: java.lang.String  zdlzscl
	 */
	@Column(name ="ZDLZSCL",nullable=true,precision=50,length=100)
	public java.lang.String getZdlzscl(){
		return this.zdlzscl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  zdlzscl
	 */
	public void setZdlzscl(java.lang.String zdlzscl){
		this.zdlzscl = zdlzscl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ldcms
	 */
	@Column(name ="LDCMS",nullable=true,precision=50,length=100)
	public java.lang.String getLdcms(){
		return this.ldcms;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ldcms
	 */
	public void setLdcms(java.lang.String ldcms){
		this.ldcms = ldcms;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  dkwz
	 */
	@Column(name ="DKWZ",nullable=true,precision=50,length=100)
	public java.lang.String getDkwz(){
		return this.dkwz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  dkwz
	 */
	public void setDkwz(java.lang.String dkwz){
		this.dkwz = dkwz;
	}
}
