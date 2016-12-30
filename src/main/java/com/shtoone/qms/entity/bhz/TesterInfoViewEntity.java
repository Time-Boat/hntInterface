package com.shtoone.qms.entity.bhz;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 人员信息
 * @author zhangdaihao
 * @date 2015-10-08 14:27:53
 * @version V1.0   
 *
 */
@Entity
@Table(name = "TesterInfoView", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class TesterInfoViewEntity implements java.io.Serializable {
	/**testerGuid*/
	private java.lang.String testerGuid;
	/**testerorderid*/
	private java.lang.Integer testerorderid;
	/**fTrpname*/
	private java.lang.String fTrpname;
	/**fbirthday*/
	private java.lang.String fbirthday;
	/**fTrpage*/
	private java.lang.Integer fTrpage;
	/**fTrpsex*/
	private java.lang.String fTrpsex;
	/**fTrpspecial*/
	private java.lang.String fTrpspecial;
	/**fTrpscool*/
	private java.lang.String fTrpscool;
	/**fTrpxl*/
	private java.lang.String fTrpxl;
	/**fTrptel*/
	private java.lang.String fTrptel;
	/**fWorkdate*/
	private java.lang.String fWorkdate;
	/**fJszc*/
	private java.lang.String fJszc;
	/**fZw*/
	private java.lang.String fZw;
	/**fPostime*/
	private java.lang.String fPostime;
	/**fJyjl*/
	private java.lang.String fJyjl;
	/**fGzjl*/
	private java.lang.String fGzjl;
	/**fBake*/
	private java.lang.String fBake;
	/**fIdentitycode*/
	private java.lang.String fIdentitycode;
	/**fPhoto*/
	private java.lang.String fPhoto;
	/**fPhotopath*/
	private java.lang.String fPhotopath;
	/**usergrouporderid*/
	private java.lang.String usergrouporderid;
	/**fTrname*/
	private java.lang.String fTrname;
	/**longitude*/
	private BigDecimal longitude;
	/**latitude*/
	private BigDecimal latitude;
	/**fTrcode*/
	private java.lang.String fTrcode;
	/**fJcqd*/
	private java.lang.String fJcqd;
	/**fAddress*/
	private java.lang.String fAddress;
	/**fPostcode*/
	private java.lang.String fPostcode;
	/**fFax*/
	private java.lang.String fFax;
	/**fTel*/
	private java.lang.String fTel;
	/**fMothroom*/
	private java.lang.String fMothroom;
	/**fMothauth*/
	private java.lang.String fMothauth;
	/**fMothvaliddate*/
	private java.lang.String fMothvaliddate;
	/**fWworg*/
	private java.lang.String fWworg;
	/**fWwaddress*/
	private java.lang.String fWwaddress;
	/**fWwauth*/
	private java.lang.String fWwauth;
	/**fValiddate*/
	private java.lang.String fValiddate;
	/**fWwrange*/
	private java.lang.String fWwrange;
	/**fDesc*/
	private java.lang.String fDesc;
	/**version*/
	private java.lang.Integer version;
	/**id*/
	private java.lang.Integer id;
	/**departname*/
	private java.lang.String departname;
	/**lft*/
	private java.lang.Integer lft;
	/**rgt*/
	private java.lang.Integer rgt;
	/**shiyanshiGuid*/
	private java.lang.String shiyanshiGuid;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  testerGuid
	 */
	@Column(name ="TESTER_GUID",nullable=false,precision=50,length=50)
	public java.lang.String getTesterGuid(){
		return this.testerGuid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  testerGuid
	 */
	public void setTesterGuid(java.lang.String testerGuid){
		this.testerGuid = testerGuid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  testerorderid
	 */
	@Column(name ="TESTERORDERID",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getTesterorderid(){
		return this.testerorderid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  testerorderid
	 */
	public void setTesterorderid(java.lang.Integer testerorderid){
		this.testerorderid = testerorderid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fTrpname
	 */
	@Column(name ="F_TRPNAME",nullable=true,precision=20,length=20)
	public java.lang.String getFTrpname(){
		return this.fTrpname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fTrpname
	 */
	public void setFTrpname(java.lang.String fTrpname){
		this.fTrpname = fTrpname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  f birthday
	 */
	@Column(name ="F_BIRTHDAY",nullable=true,precision=20,length=20)
	public java.lang.String getFbirthday(){
		return this.fbirthday;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  f birthday
	 */
	public void setFbirthday(java.lang.String fbirthday){
		this.fbirthday = fbirthday;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  fTrpage
	 */
	@Column(name ="F_TRPAGE",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getFTrpage(){
		return this.fTrpage;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  fTrpage
	 */
	public void setFTrpage(java.lang.Integer fTrpage){
		this.fTrpage = fTrpage;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fTrpsex
	 */
	@Column(name ="F_TRPSEX",nullable=true,precision=2,length=2)
	public java.lang.String getFTrpsex(){
		return this.fTrpsex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fTrpsex
	 */
	public void setFTrpsex(java.lang.String fTrpsex){
		this.fTrpsex = fTrpsex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fTrpspecial
	 */
	@Column(name ="F_TRPSPECIAL",nullable=true,precision=50,length=50)
	public java.lang.String getFTrpspecial(){
		return this.fTrpspecial;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fTrpspecial
	 */
	public void setFTrpspecial(java.lang.String fTrpspecial){
		this.fTrpspecial = fTrpspecial;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fTrpscool
	 */
	@Column(name ="F_TRPSCOOL",nullable=true,precision=80,length=80)
	public java.lang.String getFTrpscool(){
		return this.fTrpscool;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fTrpscool
	 */
	public void setFTrpscool(java.lang.String fTrpscool){
		this.fTrpscool = fTrpscool;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fTrpxl
	 */
	@Column(name ="F_TRPXL",nullable=true,precision=30,length=30)
	public java.lang.String getFTrpxl(){
		return this.fTrpxl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fTrpxl
	 */
	public void setFTrpxl(java.lang.String fTrpxl){
		this.fTrpxl = fTrpxl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fTrptel
	 */
	@Column(name ="F_TRPTEL",nullable=true,precision=20,length=20)
	public java.lang.String getFTrptel(){
		return this.fTrptel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fTrptel
	 */
	public void setFTrptel(java.lang.String fTrptel){
		this.fTrptel = fTrptel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fWorkdate
	 */
	@Column(name ="F_WORKDATE",nullable=true,precision=20,length=20)
	public java.lang.String getFWorkdate(){
		return this.fWorkdate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fWorkdate
	 */
	public void setFWorkdate(java.lang.String fWorkdate){
		this.fWorkdate = fWorkdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fJszc
	 */
	@Column(name ="F_JSZC",nullable=true,precision=2,length=2)
	public java.lang.String getFJszc(){
		return this.fJszc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fJszc
	 */
	public void setFJszc(java.lang.String fJszc){
		this.fJszc = fJszc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fZw
	 */
	@Column(name ="F_ZW",nullable=true,precision=2,length=2)
	public java.lang.String getFZw(){
		return this.fZw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fZw
	 */
	public void setFZw(java.lang.String fZw){
		this.fZw = fZw;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fPostime
	 */
	@Column(name ="F_POSTIME",nullable=true,precision=10,length=10)
	public java.lang.String getFPostime(){
		return this.fPostime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fPostime
	 */
	public void setFPostime(java.lang.String fPostime){
		this.fPostime = fPostime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fJyjl
	 */
	@Column(name ="F_JYJL",nullable=true,precision=-1,length=-1)
	public java.lang.String getFJyjl(){
		return this.fJyjl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fJyjl
	 */
	public void setFJyjl(java.lang.String fJyjl){
		this.fJyjl = fJyjl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fGzjl
	 */
	@Column(name ="F_GZJL",nullable=true,precision=-1,length=-1)
	public java.lang.String getFGzjl(){
		return this.fGzjl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fGzjl
	 */
	public void setFGzjl(java.lang.String fGzjl){
		this.fGzjl = fGzjl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fBake
	 */
	@Column(name ="F_BAKE",nullable=true,precision=400,length=400)
	public java.lang.String getFBake(){
		return this.fBake;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fBake
	 */
	public void setFBake(java.lang.String fBake){
		this.fBake = fBake;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fIdentitycode
	 */
	@Column(name ="F_IDENTITYCODE",nullable=true,precision=40,length=40)
	public java.lang.String getFIdentitycode(){
		return this.fIdentitycode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fIdentitycode
	 */
	public void setFIdentitycode(java.lang.String fIdentitycode){
		this.fIdentitycode = fIdentitycode;
	}
	/**
	 *方法: 取得java.lang.Object
	 *@return: java.lang.Object  fPhoto
	 */
	@Column(name ="F_PHOTO",nullable=true,precision=2147483647,length=16)
	public java.lang.String getFPhoto(){
		return this.fPhoto;
	}

	/**
	 *方法: 设置java.lang.Object
	 *@param: java.lang.Object  fPhoto
	 */
	public void setFPhoto(java.lang.String fPhoto){
		this.fPhoto = fPhoto;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fPhotopath
	 */
	@Column(name ="F_PHOTOPATH",nullable=true,precision=400,length=400)
	public java.lang.String getFPhotopath(){
		return this.fPhotopath;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fPhotopath
	 */
	public void setFPhotopath(java.lang.String fPhotopath){
		this.fPhotopath = fPhotopath;
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
	public void setFTrname(java.lang.String fTrname){
		this.fTrname = fTrname;
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
	public java.lang.String getFTrcode(){
		return this.fTrcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fTrcode
	 */
	public void setFTrcode(java.lang.String fTrcode){
		this.fTrcode = fTrcode;
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
	public void setFJcqd(java.lang.String fJcqd){
		this.fJcqd = fJcqd;
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
	public void setFAddress(java.lang.String fAddress){
		this.fAddress = fAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fPostcode
	 */
	@Column(name ="F_POSTCODE",nullable=true,precision=20,length=20)
	public java.lang.String getFPostcode(){
		return this.fPostcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fPostcode
	 */
	public void setFPostcode(java.lang.String fPostcode){
		this.fPostcode = fPostcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fFax
	 */
	@Column(name ="F_FAX",nullable=true,precision=20,length=20)
	public java.lang.String getFFax(){
		return this.fFax;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fFax
	 */
	public void setFFax(java.lang.String fFax){
		this.fFax = fFax;
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
	public void setFTel(java.lang.String fTel){
		this.fTel = fTel;
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
	public void setFMothroom(java.lang.String fMothroom){
		this.fMothroom = fMothroom;
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
	public void setFMothauth(java.lang.String fMothauth){
		this.fMothauth = fMothauth;
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
	public void setFMothvaliddate(java.lang.String fMothvaliddate){
		this.fMothvaliddate = fMothvaliddate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fWworg
	 */
	@Column(name ="F_WWORG",nullable=true,precision=100,length=100)
	public java.lang.String getFWworg(){
		return this.fWworg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fWworg
	 */
	public void setFWworg(java.lang.String fWworg){
		this.fWworg = fWworg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fWwaddress
	 */
	@Column(name ="F_WWADDRESS",nullable=true,precision=200,length=200)
	public java.lang.String getFWwaddress(){
		return this.fWwaddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fWwaddress
	 */
	public void setFWwaddress(java.lang.String fWwaddress){
		this.fWwaddress = fWwaddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fWwauth
	 */
	@Column(name ="F_WWAUTH",nullable=true,precision=50,length=50)
	public java.lang.String getFWwauth(){
		return this.fWwauth;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fWwauth
	 */
	public void setFWwauth(java.lang.String fWwauth){
		this.fWwauth = fWwauth;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fValiddate
	 */
	@Column(name ="F_VALIDDATE",nullable=true,precision=20,length=20)
	public java.lang.String getFValiddate(){
		return this.fValiddate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fValiddate
	 */
	public void setFValiddate(java.lang.String fValiddate){
		this.fValiddate = fValiddate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fWwrange
	 */
	@Column(name ="F_WWRANGE",nullable=true,precision=400,length=400)
	public java.lang.String getFWwrange(){
		return this.fWwrange;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fWwrange
	 */
	public void setFWwrange(java.lang.String fWwrange){
		this.fWwrange = fWwrange;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fDesc
	 */
	@Column(name ="F_DESC",nullable=true,precision=400,length=400)
	public java.lang.String getFDesc(){
		return this.fDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fDesc
	 */
	public void setFDesc(java.lang.String fDesc){
		this.fDesc = fDesc;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shiyanshiGuid
	 */
	@Column(name ="SHIYANSHI_GUID",nullable=true,precision=50,length=50)
	public java.lang.String getShiyanshiGuid(){
		return this.shiyanshiGuid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shiyanshiGuid
	 */
	public void setShiyanshiGuid(java.lang.String shiyanshiGuid){
		this.shiyanshiGuid = shiyanshiGuid;
	}
}
