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
@Table(name = "Xiangxixxsms", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class XiangxixxsmsEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**leiji*/
	private java.lang.Integer leiji;
	/**panshu*/
	private java.lang.Integer panshu;
	/**shebeibianhao*/
	private java.lang.String shebeibianhao;
	
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
	 *@return: java.lang.Integer  leiji
	 */
	@Column(name ="LEIJI",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getLeiji(){
		return this.leiji;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  leiji
	 */
	public void setLeiji(java.lang.Integer leiji){
		this.leiji = leiji;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  panshu
	 */
	@Column(name ="PANSHU",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getPanshu(){
		return this.panshu;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  panshu
	 */
	public void setPanshu(java.lang.Integer panshu){
		this.panshu = panshu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shebeibianhao
	 */
	@Column(name ="SHEBEIBIANHAO",nullable=true,precision=50,length=50)
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
}
