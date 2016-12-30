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
 * @Description: 短信配置
 * @author zhangdaihao
 * @date 2014-05-01 10:57:20
 * @version V1.0   
 *
 */
@Entity
@Table(name = "Phonecfg", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class PhonecfgEntity implements java.io.Serializable {
	
	private java.lang.Integer phoneid;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="phone_id",nullable=false,precision=19,scale=0,length=8)
	public java.lang.Integer getPhoneid() {
		return phoneid;
	}

	public void setPhoneid(java.lang.Integer phoneid) {
		this.phoneid = phoneid;
	}

	/**shebeiGuid*/
	private java.lang.String shebeiGuid;
	/**phonenumber*/
	private java.lang.String phonenumber;
	/**ownername*/
	private java.lang.String ownername;
	/**isalert*/
	private java.lang.Boolean isalert;
	/**phoneId*/
	private java.lang.Integer phoneId;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shebeiGuid
	 */
	@Column(name ="SHEBEI_GUID",nullable=true,precision=50,length=50)
	public java.lang.String getShebeiGuid(){
		return this.shebeiGuid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shebeiGuid
	 */
	public void setShebeiGuid(java.lang.String shebeiGuid){
		this.shebeiGuid = shebeiGuid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  phonenumber
	 */
	@Column(name ="PHONENUMBER",nullable=true,precision=500,length=500)
	public java.lang.String getPhonenumber(){
		return this.phonenumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  phonenumber
	 */
	public void setPhonenumber(java.lang.String phonenumber){
		this.phonenumber = phonenumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ownername
	 */
	@Column(name ="OWNERNAME",nullable=true,precision=500,length=500)
	public java.lang.String getOwnername(){
		return this.ownername;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ownername
	 */
	public void setOwnername(java.lang.String ownername){
		this.ownername = ownername;
	}
	/**
	 *方法: 取得java.lang.Boolean
	 *@return: java.lang.Boolean  isalert
	 */
	@Column(name ="ISALERT",nullable=true,precision=1,length=1)
	public java.lang.Boolean getIsalert(){
		return this.isalert;
	}

	/**
	 *方法: 设置java.lang.Boolean
	 *@param: java.lang.Boolean  isalert
	 */
	public void setIsalert(java.lang.Boolean isalert){
		this.isalert = isalert;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  phoneId
	 */
	@Column(name ="PHONE_ID",nullable=false,precision=19,scale=0,length=8)
	public java.lang.Integer getPhoneId(){
		return this.phoneId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  phoneId
	 */
	public void setPhoneId(java.lang.Integer phoneId){
		this.phoneId = phoneId;
	}
}
