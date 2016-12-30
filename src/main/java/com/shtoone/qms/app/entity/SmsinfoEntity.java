package com.shtoone.qms.app.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "Smsinfo", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class SmsinfoEntity implements Serializable{
	/**syjid*/
	private java.lang.String syjid;
	/**fasongshijian*/
	private java.util.Date fasongshijian;
	/**fasongcontent*/
	private java.lang.String fasongcontent;
	/**fasongstatus*/
	private java.lang.String fasongstatus;
	/**fasongphone*/
	private java.lang.String fasongphone;
	/**fasongcount*/
	private java.lang.Integer fasongcount;
	/**fasongname*/
	private java.lang.String fasongname;
	/**successcount*/
	private java.lang.Integer successcount;
	/**successphone*/
	private java.lang.String successphone;
	/**returnmsg*/
	private java.lang.String returnmsg;
	/**shebeibianhao*/
	private java.lang.String shebeibianhao;
	/**smsid*/
	private java.lang.Integer smsid;
	/**chuli*/
	private java.lang.String chuli;
	/**beizhu*/
	private java.lang.String beizhu;
	/**jianliyijian*/
	private java.lang.String jianliyijian;
	/**fujian*/
	private java.lang.String fujian;
	/**fujianmc*/
	private java.lang.String fujianmc;
	/**fujian1*/
	private java.lang.String fujian1;
	/**fujianmc1*/
	private java.lang.String fujianmc1;
	/**fujian2*/
	private java.lang.String fujian2;
	/**fujianmc2*/
	private java.lang.String fujianmc2;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  syjid
	 */
	@Column(name ="SYJID",nullable=true,precision=50,length=50)
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  fasongshijian
	 */
	@Column(name ="FASONGSHIJIAN",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getFasongshijian(){
		return this.fasongshijian;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  fasongshijian
	 */
	public void setFasongshijian(java.util.Date fasongshijian){
		this.fasongshijian = fasongshijian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fasongcontent
	 */
	@Column(name ="FASONGCONTENT",nullable=true,precision=500,length=500)
	public java.lang.String getFasongcontent(){
		return this.fasongcontent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fasongcontent
	 */
	public void setFasongcontent(java.lang.String fasongcontent){
		this.fasongcontent = fasongcontent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fasongstatus
	 */
	@Column(name ="FASONGSTATUS",nullable=true,precision=50,length=50)
	public java.lang.String getFasongstatus(){
		return this.fasongstatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fasongstatus
	 */
	public void setFasongstatus(java.lang.String fasongstatus){
		this.fasongstatus = fasongstatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fasongphone
	 */
	@Column(name ="FASONGPHONE",nullable=true,precision=500,length=500)
	public java.lang.String getFasongphone(){
		return this.fasongphone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fasongphone
	 */
	public void setFasongphone(java.lang.String fasongphone){
		this.fasongphone = fasongphone;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  fasongcount
	 */
	@Column(name ="FASONGCOUNT",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getFasongcount(){
		return this.fasongcount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  fasongcount
	 */
	public void setFasongcount(java.lang.Integer fasongcount){
		this.fasongcount = fasongcount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fasongname
	 */
	@Column(name ="FASONGNAME",nullable=true,precision=500,length=500)
	public java.lang.String getFasongname(){
		return this.fasongname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fasongname
	 */
	public void setFasongname(java.lang.String fasongname){
		this.fasongname = fasongname;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  successcount
	 */
	@Column(name ="SUCCESSCOUNT",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getSuccesscount(){
		return this.successcount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  successcount
	 */
	public void setSuccesscount(java.lang.Integer successcount){
		this.successcount = successcount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  successphone
	 */
	@Column(name ="SUCCESSPHONE",nullable=true,precision=500,length=500)
	public java.lang.String getSuccessphone(){
		return this.successphone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  successphone
	 */
	public void setSuccessphone(java.lang.String successphone){
		this.successphone = successphone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  returnmsg
	 */
	@Column(name ="RETURNMSG",nullable=true,precision=500,length=500)
	public java.lang.String getReturnmsg(){
		return this.returnmsg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  returnmsg
	 */
	public void setReturnmsg(java.lang.String returnmsg){
		this.returnmsg = returnmsg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shebeibianhao
	 */
	@Column(name ="SHEBEIBIANHAO",nullable=true,precision=500,length=500)
	public java.lang.String getShebeibianhao(){
		return this.shebeibianhao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shebeibianhao
	 */
	public void setShebeibianhao(java.lang.String shebeibianhao){
		this.shebeibianhao = shebeibianhao;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  smsid
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="SMSID",nullable=false,precision=19,scale=0,length=8)
	public java.lang.Integer getSmsid(){
		return this.smsid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  smsid
	 */
	public void setSmsid(java.lang.Integer smsid){
		this.smsid = smsid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chuli
	 */
	@Column(name ="CHULI",nullable=true,precision=500,length=500)
	public java.lang.String getChuli(){
		return this.chuli;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  chuli
	 */
	public void setChuli(java.lang.String chuli){
		this.chuli = chuli;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  beizhu
	 */
	@Column(name ="BEIZHU",nullable=true,precision=500,length=500)
	public java.lang.String getBeizhu(){
		return this.beizhu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  beizhu
	 */
	public void setBeizhu(java.lang.String beizhu){
		this.beizhu = beizhu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  jianliyijian
	 */
	@Column(name ="JIANLIYIJIAN",nullable=true,precision=500,length=500)
	public java.lang.String getJianliyijian(){
		return this.jianliyijian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  jianliyijian
	 */
	public void setJianliyijian(java.lang.String jianliyijian){
		this.jianliyijian = jianliyijian;
	}
	/**
	 *方法: 取得java.lang.Object
	 *@return: java.lang.Object  fujian
	 */
	@Column(name ="FUJIAN",nullable=true,precision=50,length=50)
	public java.lang.String getFujian(){
		return this.fujian;
	}

	/**
	 *方法: 设置java.lang.Object
	 *@param: java.lang.Object  fujian
	 */
	public void setFujian(java.lang.String fujian){
		this.fujian = fujian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fujianmc
	 */
	@Column(name ="FUJIANMC",nullable=true,precision=50,length=50)
	public java.lang.String getFujianmc(){
		return this.fujianmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fujianmc
	 */
	public void setFujianmc(java.lang.String fujianmc){
		this.fujianmc = fujianmc;
	}
	/**
	 *方法: 取得java.lang.Object
	 *@return: java.lang.Object  fujian1
	 */
	@Column(name ="FUJIAN1",nullable=true,precision=50,length=50)
	public java.lang.String getFujian1(){
		return this.fujian1;
	}

	/**
	 *方法: 设置java.lang.Object
	 *@param: java.lang.Object  fujian1
	 */
	public void setFujian1(java.lang.String fujian1){
		this.fujian1 = fujian1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fujianmc1
	 */
	@Column(name ="FUJIANMC1",nullable=true,precision=50,length=50)
	public java.lang.String getFujianmc1(){
		return this.fujianmc1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fujianmc1
	 */
	public void setFujianmc1(java.lang.String fujianmc1){
		this.fujianmc1 = fujianmc1;
	}
	/**
	 *方法: 取得java.lang.Object
	 *@return: java.lang.Object  fujian2
	 */
	@Column(name ="FUJIAN2",nullable=true,precision=50,length=50)
	public java.lang.String getFujian2(){
		return this.fujian2;
	}

	/**
	 *方法: 设置java.lang.Object
	 *@param: java.lang.Object  fujian2
	 */
	public void setFujian2(java.lang.String fujian2){
		this.fujian2 = fujian2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fujianmc2
	 */
	@Column(name ="FUJIANMC2",nullable=true,precision=50,length=50)
	public java.lang.String getFujianmc2(){
		return this.fujianmc2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fujianmc2
	 */
	public void setFujianmc2(java.lang.String fujianmc2){
		this.fujianmc2 = fujianmc2;
	}
}
