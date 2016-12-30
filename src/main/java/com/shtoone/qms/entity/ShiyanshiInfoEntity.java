package com.shtoone.qms.entity;

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
 * @Description: 试验室配置表
 * @author 
 * @date 2014-02-24 09:52:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "ShiyanshiInfo", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ShiyanshiInfoEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**version*/
	private java.lang.Integer version;
	/**shiyanshiGuid*/
	private java.lang.String shiyanshiGuid;
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
	/**fXmbt*/
	private java.lang.String fXmbt;
	
	/**leixin*/
	private java.lang.String leixin;
	/**zhuren*/
	private java.lang.String zhuren;
	/**mianji*/
	private java.lang.String mianji;
	/**kongzhiqi*/
	private java.lang.String kongzhiqi;
	
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fXmbt
	 */
	@Column(name ="F_XMBT",nullable=true,precision=400,length=400)
	public java.lang.String getFXmbt(){
		return this.fXmbt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fXmbt
	 */
	public void setFXmbt(java.lang.String fXmbt){
		this.fXmbt = fXmbt;
	}

	public java.lang.String getLeixin() {
		return leixin;
	}

	@Column(name ="leixin",nullable=true,precision=400,length=400)
	public void setLeixin(java.lang.String leixin) {
		this.leixin = leixin;
	}

	public java.lang.String getZhuren() {
		return zhuren;
	}

	@Column(name ="zhuren",nullable=true,precision=400,length=400)
	public void setZhuren(java.lang.String zhuren) {
		this.zhuren = zhuren;
	}

	public java.lang.String getMianji() {
		return mianji;
	}

	@Column(name ="mianji",nullable=true,precision=400,length=400)
	public void setMianji(java.lang.String mianji) {
		this.mianji = mianji;
	}

	public java.lang.String getKongzhiqi() {
		return kongzhiqi;
	}

	@Column(name ="kongzhiqi",nullable=true,precision=400,length=400)
	public void setKongzhiqi(java.lang.String kongzhiqi) {
		this.kongzhiqi = kongzhiqi;
	}
}
