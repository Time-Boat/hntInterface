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
@Table(name = "Handsets", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class HandsetsEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	
	private java.lang.String mid;
	
	private java.lang.String type;
	/**phone*/
	private java.lang.String phone;
	/**biaoduan*/
	private java.lang.String phonename;
	/**owername*/
	private java.lang.String apptype;
	
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID",nullable=false,precision=10,scale=0,length=4)
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
	 *@return: java.lang.String  phone
	 */
	@Column(name ="PHONE",nullable=true,precision=2500,length=2500)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  phone
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  biaoduan
	 */
	@Column(name ="MID",nullable=true,precision=2500,length=2500)
	public java.lang.String getMid() {
		return mid;
	}

	public void setMid(java.lang.String mid) {
		this.mid = mid;
	}
	@Column(name ="PHONENAME",nullable=true,precision=2500,length=2500)
	public java.lang.String getPhonename() {
		return phonename;
	}

	public void setPhonename(java.lang.String phonename) {
		this.phonename = phonename;
	}
	
	@Column(name ="TYPE",nullable=true,precision=2500,length=2500)
	public java.lang.String getType() {
		return type;
	}

	public void setType(java.lang.String type) {
		this.type = type;
	}
	
	@Column(name ="APPTYPE",nullable=true,precision=2500,length=2500)
	public java.lang.String getApptype() {
		return apptype;
	}

	public void setApptype(java.lang.String apptype) {
		this.apptype = apptype;
	}
}
