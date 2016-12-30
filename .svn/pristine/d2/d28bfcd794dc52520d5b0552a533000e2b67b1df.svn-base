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
 * @Description: 标段部门映射表
 * @author zhangdaihao
 * @date 2015-06-18 11:23:40
 * @version V1.0   
 *
 */
@Entity
@Table(name = "DepartMapping", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class DepartMappingEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**departid*/
	private java.lang.String departid;
	/**mappingcoding*/
	private java.lang.String mappingcoding;
	/**remark*/
	private java.lang.String remark;
	
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
	 *@return: java.lang.String  departid
	 */
	@Column(name ="DEPARTID",nullable=true,precision=500,length=500)
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
	 *@return: java.lang.String  mappingcoding
	 */
	@Column(name ="MAPPINGCODING",nullable=true,precision=500,length=500)
	public java.lang.String getMappingcoding(){
		return this.mappingcoding;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  mappingcoding
	 */
	public void setMappingcoding(java.lang.String mappingcoding){
		this.mappingcoding = mappingcoding;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark
	 */
	@Column(name ="REMARK",nullable=true,precision=500,length=500)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
}
