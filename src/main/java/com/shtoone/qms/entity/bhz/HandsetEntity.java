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
@Table(name = "Handset", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class HandsetEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**name*/
	private java.lang.String name;
	/**phone*/
	private java.lang.String phone;
	/**biaoduan*/
	private java.lang.String biaoduan;
	/**owername*/
	private java.lang.String owername;
	
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
	 *@return: java.lang.String  name
	 */
	@Column(name ="NAME",nullable=true,precision=255,length=255)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  name
	 */
	public void setName(java.lang.String name){
		this.name = name;
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
	@Column(name ="BIAODUAN",nullable=true,precision=2500,length=2500)
	public java.lang.String getBiaoduan(){
		return this.biaoduan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  biaoduan
	 */
	public void setBiaoduan(java.lang.String biaoduan){
		this.biaoduan = biaoduan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  owername
	 */
	@Column(name ="OWERNAME",nullable=true,precision=2500,length=2500)
	public java.lang.String getOwername(){
		return this.owername;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  owername
	 */
	public void setOwername(java.lang.String owername){
		this.owername = owername;
	}
}
