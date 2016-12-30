package com.shtoone.qms.entity.bhz;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name = "V_ShiyanshiInfo", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class V_ShiyanshiInfoEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**version*/
	private java.lang.Integer version;
	/**shiyanshiGuid*/
	private java.lang.String shiyanshi_Guid;
	/**usergrouporderid*/
	private java.lang.String usergrouporderid;
	/**fTrname*/
	private java.lang.String fTrname;
	/**longitude*/
	private BigDecimal longitude;
	/**latitude*/
	private BigDecimal latitude;
	/**fTrcode*/
	private java.lang.String ftrcode;
	/**fJcqd*/
	private java.lang.String fJcqd;
	/**fAddress*/
	private java.lang.String fAddress;
	/**fPostcode*/
	private java.lang.String F_POSTCODE;
	/**fFax*/
	private java.lang.String F_FAX;
	/**fTel*/
	private java.lang.String fTel;
	/**fMothroom*/
	private java.lang.String fMothroom;
	/**fMothauth*/
	private java.lang.String fMothauth;
	/**fMothvaliddate*/
	private java.lang.String fMothvaliddate;
	/**fWworg*/
	private java.lang.String F_WWORG;
	/**fWwaddress*/
	private java.lang.String F_WWADDRESS;
	/**fWwauth*/
	private java.lang.String F_WWAUTH;
	/**fValiddate*/
	private java.lang.String F_VALIDDATE;
	/**fWwrange*/
	private java.lang.String F_WWRANGE;
	/**fDesc*/
	private java.lang.String F_DESC;
	/**fXmbt*/
	private java.lang.String F_XMBT;
	/**departid*/
	private java.lang.String departid;
	/**departname*/
	private java.lang.String departname;
	/**description*/
	private java.lang.String description;
	/**parentdepartid*/
	private java.lang.String parentdepartid;
	/**lft*/
	private java.lang.Integer lft;
	/**rgt*/
	private java.lang.Integer rgt;
	/**leixin*/
	private java.lang.Integer leixin;
	
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
	 *@return: java.lang.String  shiyanshiGuid
	 */
	@Column(name ="SHIYANSHI_GUID",nullable=false,precision=50,length=50)
	public java.lang.String getShiyanshi_Guid(){
		return this.shiyanshi_Guid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shiyanshiGuid
	 */
	public void setShiyanshi_Guid(java.lang.String shiyanshi_Guid){
		this.shiyanshi_Guid = shiyanshi_Guid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  usergrouporderid
	 */
	@Column(name ="USERGROUPORDERID",nullable=true,precision=50,length=50)
	public java.lang.String getUsergrouporderid(){
		return this.usergrouporderid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  usergrouporderid
	 */
	public void setUsergrouporderid(java.lang.String usergrouporderid){
		this.usergrouporderid = usergrouporderid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fTrname
	 */
	@Column(name ="F_TRNAME",nullable=true,precision=100,length=100)
	public java.lang.String getFTrname(){
		return this.fTrname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fTrname
	 */
	public void setFTrname(java.lang.String F_TRNAME){
		this.fTrname = F_TRNAME;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  longitude
	 */
	@Column(name ="LONGITUDE",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getLongitude(){
		return this.longitude;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  longitude
	 */
	public void setLongitude(BigDecimal longitude){
		this.longitude = longitude;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  latitude
	 */
	@Column(name ="LATITUDE",nullable=true,precision=18,scale=8,length=9)
	public BigDecimal getLatitude(){
		return this.latitude;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  latitude
	 */
	public void setLatitude(BigDecimal latitude){
		this.latitude = latitude;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fTrcode
	 */
	@Column(name ="F_TRCODE",nullable=true,precision=50,length=50)
	public java.lang.String getFtrcode(){
		return this.ftrcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fTrcode
	 */
	public void setFtrcode(java.lang.String FTRCODE){
		this.ftrcode = FTRCODE;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fJcqd
	 */
	@Column(name ="F_JCQD",nullable=true,precision=200,length=200)
	public java.lang.String getFJcqd(){
		return this.fJcqd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fJcqd
	 */
	public void setFJcqd(java.lang.String F_JCQD){
		this.fJcqd = F_JCQD;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fAddress
	 */
	@Column(name ="F_ADDRESS",nullable=true,precision=200,length=200)
	public java.lang.String getFAddress(){
		return this.fAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fAddress
	 */
	public void setFAddress(java.lang.String F_ADDRESS){
		this.fAddress = F_ADDRESS;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fPostcode
	 */
	@Column(name ="F_POSTCODE",nullable=true,precision=20,length=20)
	public java.lang.String getF_POSTCODE(){
		return this.F_POSTCODE;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fPostcode
	 */
	public void setF_POSTCODE(java.lang.String F_POSTCODE){
		this.F_POSTCODE = F_POSTCODE;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fFax
	 */
	@Column(name ="F_FAX",nullable=true,precision=20,length=20)
	public java.lang.String getF_FAX(){
		return this.F_FAX;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fFax
	 */
	public void setF_FAX(java.lang.String F_FAX){
		this.F_FAX = F_FAX;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fTel
	 */
	@Column(name ="F_TEL",nullable=true,precision=20,length=20)
	public java.lang.String getFTel(){
		return this.fTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fTel
	 */
	public void setFTel(java.lang.String F_TEL){
		this.fTel = F_TEL;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fMothroom
	 */
	@Column(name ="F_MOTHROOM",nullable=true,precision=100,length=100)
	public java.lang.String getFMothroom(){
		return this.fMothroom;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fMothroom
	 */
	public void setFMothroom(java.lang.String F_MOTHROOM){
		this.fMothroom = F_MOTHROOM;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fMothauth
	 */
	@Column(name ="F_MOTHAUTH",nullable=true,precision=50,length=50)
	public java.lang.String getFMothauth(){
		return this.fMothauth;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fMothauth
	 */
	public void setFMothauth(java.lang.String F_MOTHAUTH){
		this.fMothauth = F_MOTHAUTH;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fMothvaliddate
	 */
	@Column(name ="F_MOTHVALIDDATE",nullable=true,precision=20,length=20)
	public java.lang.String getFMothvaliddate(){
		return this.fMothvaliddate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fMothvaliddate
	 */
	public void setFMothvaliddate(java.lang.String F_MOTHVALIDDATE){
		this.fMothvaliddate = F_MOTHVALIDDATE;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fWworg
	 */
	@Column(name ="F_WWORG",nullable=true,precision=100,length=100)
	public java.lang.String getF_WWORG(){
		return this.F_WWORG;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fWworg
	 */
	public void setF_WWORG(java.lang.String F_WWORG){
		this.F_WWORG = F_WWORG;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fWwaddress
	 */
	@Column(name ="F_WWADDRESS",nullable=true,precision=200,length=200)
	public java.lang.String getF_WWADDRESS(){
		return this.F_WWADDRESS;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fWwaddress
	 */
	public void setF_WWADDRESS(java.lang.String F_WWADDRESS){
		this.F_WWADDRESS = F_WWADDRESS;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fWwauth
	 */
	@Column(name ="F_WWAUTH",nullable=true,precision=50,length=50)
	public java.lang.String getF_WWAUTH(){
		return this.F_WWAUTH;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fWwauth
	 */
	public void setF_WWAUTH(java.lang.String F_WWAUTH){
		this.F_WWAUTH = F_WWAUTH;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fValiddate
	 */
	@Column(name ="F_VALIDDATE",nullable=true,precision=20,length=20)
	public java.lang.String getF_VALIDDATE(){
		return this.F_VALIDDATE;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fValiddate
	 */
	public void setF_VALIDDATE(java.lang.String F_VALIDDATE){
		this.F_VALIDDATE = F_VALIDDATE;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fWwrange
	 */
	@Column(name ="F_WWRANGE",nullable=true,precision=400,length=400)
	public java.lang.String getF_WWRANGE(){
		return this.F_WWRANGE;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fWwrange
	 */
	public void setF_WWRANGE(java.lang.String F_WWRANGE){
		this.F_WWRANGE = F_WWRANGE;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fDesc
	 */
	@Column(name ="F_DESC",nullable=true,precision=400,length=400)
	public java.lang.String getF_DESC(){
		return this.F_DESC;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fDesc
	 */
	public void setF_DESC(java.lang.String F_DESC){
		this.F_DESC = F_DESC;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fXmbt
	 */
	@Column(name ="F_XMBT",nullable=true,precision=400,length=400)
	public java.lang.String getF_XMBT(){
		return this.F_XMBT;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fXmbt
	 */
	public void setF_XMBT(java.lang.String F_XMBT){
		this.F_XMBT = F_XMBT;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  departid
	 */
	@Column(name ="DEPARTID",nullable=false,precision=50,length=50)
	public java.lang.String getDepartid(){
		return this.departid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  departid
	 */
	public void setDepartid(java.lang.String departid){
		this.departid = departid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  departname
	 */
	@Column(name ="DEPARTNAME",nullable=false,precision=100,length=100)
	public java.lang.String getDepartname(){
		return this.departname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  departname
	 */
	public void setDepartname(java.lang.String departname){
		this.departname = departname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  description
	 */
	@Column(name ="DESCRIPTION",nullable=true,precision=500,length=500)
	public java.lang.String getDescription(){
		return this.description;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  description
	 */
	public void setDescription(java.lang.String description){
		this.description = description;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  parentdepartid
	 */
	@Column(name ="PARENTDEPARTID",nullable=true,precision=50,length=50)
	public java.lang.String getParentdepartid(){
		return this.parentdepartid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  parentdepartid
	 */
	public void setParentdepartid(java.lang.String parentdepartid){
		this.parentdepartid = parentdepartid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  lft
	 */
	@Column(name ="LFT",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getLft(){
		return this.lft;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  lft
	 */
	public void setLft(java.lang.Integer lft){
		this.lft = lft;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  rgt
	 */
	@Column(name ="RGT",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getRgt(){
		return this.rgt;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  rgt
	 */
	public void setRgt(java.lang.Integer rgt){
		this.rgt = rgt;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  leixin
	 */
	@Column(name ="LEIXIN",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getLeixin(){
		return this.leixin;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  leixin
	 */
	public void setLeixin(java.lang.Integer leixin){
		this.leixin = leixin;
	}
}
