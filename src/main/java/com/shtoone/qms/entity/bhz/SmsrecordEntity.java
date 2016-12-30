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
 * @Description: 短信充值
 * @author zhangdaihao
 * @date 2015-06-11 11:23:16
 * @version V1.0   
 *
 */
@Entity
@Table(name = "Smsrecord", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class SmsrecordEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**alarmcount*/
	private java.lang.Integer alarmcount;
	/**alarmnumber*/
	private java.lang.String alarmnumber;
	/**failcount*/
	private java.lang.Integer failcount;
	/**isalarm*/
	private java.lang.Integer isalarm;
	/**smscount*/
	private java.lang.Integer smscount;
	/**successcount*/
	private java.lang.Integer successcount;
	/**totalcount*/
	private java.lang.Integer totalcount;
	/**completealarm*/
	private java.lang.Integer completealarm;
	/**departid*/
	private java.lang.String departid;
	
	public java.lang.String getDepartid() {
		return departid;
	}

	public void setDepartid(java.lang.String departid) {
		this.departid = departid;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID",nullable=false,precision=19,scale=0,length=8)
	public java.lang.Integer getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  alarmcount
	 */
	@Column(name ="ALARMCOUNT",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getAlarmcount(){
		return this.alarmcount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  alarmcount
	 */
	public void setAlarmcount(java.lang.Integer alarmcount){
		this.alarmcount = alarmcount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  alarmnumber
	 */
	@Column(name ="ALARMNUMBER",nullable=true,precision=255,length=255)
	public java.lang.String getAlarmnumber(){
		return this.alarmnumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  alarmnumber
	 */
	public void setAlarmnumber(java.lang.String alarmnumber){
		this.alarmnumber = alarmnumber;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  failcount
	 */
	@Column(name ="FAILCOUNT",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getFailcount(){
		return this.failcount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  failcount
	 */
	public void setFailcount(java.lang.Integer failcount){
		this.failcount = failcount;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  isalarm
	 */
	@Column(name ="ISALARM",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getIsalarm(){
		return this.isalarm;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  isalarm
	 */
	public void setIsalarm(java.lang.Integer isalarm){
		this.isalarm = isalarm;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  smscount
	 */
	@Column(name ="SMSCOUNT",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getSmscount(){
		return this.smscount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  smscount
	 */
	public void setSmscount(java.lang.Integer smscount){
		this.smscount = smscount;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  totalcount
	 */
	@Column(name ="TOTALCOUNT",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getTotalcount(){
		return this.totalcount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  totalcount
	 */
	public void setTotalcount(java.lang.Integer totalcount){
		this.totalcount = totalcount;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  completealarm
	 */
	@Column(name ="COMPLETEALARM",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getCompletealarm(){
		return this.completealarm;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  completealarm
	 */
	public void setCompletealarm(java.lang.Integer completealarm){
		this.completealarm = completealarm;
	}
}
