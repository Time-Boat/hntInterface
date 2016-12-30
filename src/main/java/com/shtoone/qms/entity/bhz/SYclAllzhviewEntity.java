package com.shtoone.qms.entity.bhz;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: S_YCL_ALLZHView
 * @author onlineGenerator
 * @date 2015-06-17 09:27:04
 * @version V1.0   
 *
 */
@Entity
@Table(name = "s_ycl_allzhview", schema = "")
@SuppressWarnings("serial")
public class SYclAllzhviewEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**leixing*/
	private java.lang.String leixing;
	/**totalcount*/
	private java.lang.Integer totalcount;
	/**ljjccount*/
	private java.lang.String ljjccount;
	/**biaoduanid*/
	private java.lang.String biaoduanid;
	/**guige*/
	private java.lang.String guige;
	/**xinghao*/
	private java.lang.String xinghao;
	/**chandi*/
	private java.lang.String chandi;
	/**scchangjia*/
	private java.lang.String scchangjia;
	/**bhgcount*/
	private java.lang.Integer bhgcount;
	/**departname*/
	private java.lang.String departname;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=true,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  leixing
	 */
	@Column(name ="LEIXING",nullable=true,length=50)
	public java.lang.String getLeixing(){
		return this.leixing;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  leixing
	 */
	public void setLeixing(java.lang.String leixing){
		this.leixing = leixing;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  totalcount
	 */
	@Column(name ="TOTALCOUNT",nullable=true,length=4)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ljjccount
	 */
	@Column(name ="LJJCCOUNT",nullable=true,length=17)
	public java.lang.String getLjjccount(){
		return this.ljjccount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ljjccount
	 */
	public void setLjjccount(java.lang.String ljjccount){
		this.ljjccount = ljjccount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  biaoduanid
	 */
	@Column(name ="BIAODUANID",nullable=true,length=50)
	public java.lang.String getBiaoduanid(){
		return this.biaoduanid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  biaoduanid
	 */
	public void setBiaoduanid(java.lang.String biaoduanid){
		this.biaoduanid = biaoduanid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  guige
	 */
	@Column(name ="GUIGE",nullable=true,length=50)
	public java.lang.String getGuige(){
		return this.guige;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  guige
	 */
	public void setGuige(java.lang.String guige){
		this.guige = guige;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  xinghao
	 */
	@Column(name ="XINGHAO",nullable=true,length=50)
	public java.lang.String getXinghao(){
		return this.xinghao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  xinghao
	 */
	public void setXinghao(java.lang.String xinghao){
		this.xinghao = xinghao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chandi
	 */
	@Column(name ="CHANDI",nullable=true,length=100)
	public java.lang.String getChandi(){
		return this.chandi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  chandi
	 */
	public void setChandi(java.lang.String chandi){
		this.chandi = chandi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  scchangjia
	 */
	@Column(name ="SCCHANGJIA",nullable=true,length=100)
	public java.lang.String getScchangjia(){
		return this.scchangjia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  scchangjia
	 */
	public void setScchangjia(java.lang.String scchangjia){
		this.scchangjia = scchangjia;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  bhgcount
	 */
	@Column(name ="BHGCOUNT",nullable=true,length=4)
	public java.lang.Integer getBhgcount(){
		return this.bhgcount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  bhgcount
	 */
	public void setBhgcount(java.lang.Integer bhgcount){
		this.bhgcount = bhgcount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  departname
	 */
	@Column(name ="DEPARTNAME",nullable=true,length=100)
	public java.lang.String getDepartname(){
		return this.departname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  departname
	 */
	public void setDepartname(java.lang.String departname){
		this.departname = departname;
	}
}
