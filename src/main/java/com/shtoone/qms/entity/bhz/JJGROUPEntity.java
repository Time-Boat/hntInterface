package com.shtoone.qms.entity.bhz;


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
 * @Description: 交建组织机构
 * @author zhangdaihao
 * @date 2015-07-22 10:07:10
 * @version V1.0   
 *
 */
@Entity
@Table(name = "JJGROUP", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class JJGROUPEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**ecode*/
	private java.lang.String ecode;
	/**grade*/
	private java.lang.String grade;
	/**name*/
	private java.lang.String name;
	/**oid*/
	private java.lang.String oid;
	/**poid*/
	private java.lang.String poid;
	/**status*/
	private java.lang.String status;
	/**type*/
	private java.lang.String type;
	/**typeext*/
	private java.lang.String typeext;
	
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ecode
	 */
	@Column(name ="ECODE",nullable=true,precision=50,length=50)
	public java.lang.String getEcode(){
		return this.ecode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ecode
	 */
	public void setEcode(java.lang.String ecode){
		this.ecode = ecode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  grade
	 */
	@Column(name ="GRADE",nullable=true,precision=50,length=50)
	public java.lang.String getGrade(){
		return this.grade;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  grade
	 */
	public void setGrade(java.lang.String grade){
		this.grade = grade;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  name
	 */
	@Column(name ="NAME",nullable=true,precision=500,length=500)
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
	 *@return: java.lang.String  oid
	 */
	@Column(name ="OID",nullable=true,precision=50,length=50)
	public java.lang.String getOid(){
		return this.oid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  oid
	 */
	public void setOid(java.lang.String oid){
		this.oid = oid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  poid
	 */
	@Column(name ="POID",nullable=true,precision=50,length=50)
	public java.lang.String getPoid(){
		return this.poid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  poid
	 */
	public void setPoid(java.lang.String poid){
		this.poid = poid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  status
	 */
	@Column(name ="STATUS",nullable=true,precision=50,length=50)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  status
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  type
	 */
	@Column(name ="TYPE",nullable=true,precision=50,length=50)
	public java.lang.String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  type
	 */
	public void setType(java.lang.String type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  typeext
	 */
	@Column(name ="TYPEEXT",nullable=true,precision=50,length=50)
	public java.lang.String getTypeext(){
		return this.typeext;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  typeext
	 */
	public void setTypeext(java.lang.String typeext){
		this.typeext = typeext;
	}
}
