package com.shtoone.qms.entity.bhz;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "Shebeichangjia", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ShebeichangjiaEntity implements java.io.Serializable {
	/**sbbh*/
	@Id
	private java.lang.String sbbh;
	/**sbname*/
	private java.lang.String sbname;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sbbh
	 */
	
	@Column(name ="SBBH",nullable=false,precision=50,length=50)
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
	 *@return: java.lang.String  sbname
	 */
	@Column(name ="SBNAME",nullable=true,precision=500,length=500)
	public java.lang.String getSbname(){
		return this.sbname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sbname
	 */
	public void setSbname(java.lang.String sbname){
		this.sbname = sbname;
	}
}
