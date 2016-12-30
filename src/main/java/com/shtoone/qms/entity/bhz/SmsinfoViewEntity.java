package com.shtoone.qms.entity.bhz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "SmsinfoView", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class SmsinfoViewEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**fasongcontent*/
	private java.lang.String fasongcontent;
	/**fasongcount*/
	private java.lang.Integer fasongcount;
	/**fasongphone*/
	private java.lang.String fasongphone;
	/**fasongstatus*/
	private java.lang.String fasongstatus;
	/**shijian*/
	private java.lang.String shijian;
	/**successcount*/
	private java.lang.Integer successcount;
	/**successphone*/
	private java.lang.String successphone;
	/**returnmsg*/
	private java.lang.String returnmsg;
	/**shebeibianhao*/
	private java.lang.String shebeibianhao;
	/**banhezhanminchen*/
	private java.lang.String banhezhanminchen;
	/**jianchen*/
	private java.lang.String jianchen;
	/**departid*/
	private java.lang.String departid;
	/**owername*/
	private java.lang.String owername;
	/**xxbianhao*/
	private java.lang.Integer xxbianhao;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	
	@Id
	@Column(name ="ID",nullable=true,precision=10,scale=0,length=4)
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
	 *@return: java.lang.String  fasongcontent
	 */
	@Column(name ="FASONGCONTENT",nullable=true,precision=255,length=255)
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
	 *@return: java.lang.String  fasongphone
	 */
	@Column(name ="FASONGPHONE",nullable=true,precision=255,length=255)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fasongstatus
	 */
	@Column(name ="FASONGSTATUS",nullable=true,precision=255,length=255)
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
	 *@return: java.lang.String  shijian
	 */
	@Column(name ="SHIJIAN",nullable=true,precision=255,length=255)
	public java.lang.String getShijian(){
		return this.shijian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shijian
	 */
	public void setShijian(java.lang.String shijian){
		this.shijian = shijian;
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
	@Column(name ="SUCCESSPHONE",nullable=true,precision=255,length=255)
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
	@Column(name ="RETURNMSG",nullable=true,precision=255,length=255)
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  banhezhanminchen
	 */
	@Column(name ="BANHEZHANMINCHEN",nullable=true,precision=255,length=255)
	public java.lang.String getBanhezhanminchen(){
		return this.banhezhanminchen;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  banhezhanminchen
	 */
	public void setBanhezhanminchen(java.lang.String banhezhanminchen){
		this.banhezhanminchen = banhezhanminchen;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  jianchen
	 */
	@Column(name ="JIANCHEN",nullable=true,precision=50,length=50)
	public java.lang.String getJianchen(){
		return this.jianchen;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  jianchen
	 */
	public void setJianchen(java.lang.String jianchen){
		this.jianchen = jianchen;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  departid
	 */
	@Column(name ="DEPARTID",nullable=true,precision=50,length=50)
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
	 *@return: java.lang.String  owername
	 */
	@Column(name ="OWERNAME",nullable=true,precision=100,length=100)
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
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  xxbianhao
	 */
	@Column(name ="XXBIANHAO",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getXxbianhao(){
		return this.xxbianhao;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  xxbianhao
	 */
	public void setXxbianhao(java.lang.Integer xxbianhao){
		this.xxbianhao = xxbianhao;
	}
}
