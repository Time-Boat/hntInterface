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
 * @Description: 型号子表
 * @author onlineGenerator
 * @date 2015-06-16 09:03:12
 * @version V1.0   
 *
 */
@Entity
@Table(name = "s_ycl_guigexinghaos", schema = "")
@SuppressWarnings("serial")
public class SYclGuigexinghaosEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**子表型号*/
	private java.lang.String mselectkey;
	/**主表规格*/
	private java.lang.String selectkey;
	/**规格描述*/
	private java.lang.String selectvalue;
	/**型号描述*/
	private java.lang.String remark;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
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
	 *@return: java.lang.String  子表型号
	 */
	@Column(name ="MSELECTKEY",nullable=true,length=50)
	public java.lang.String getMselectkey(){
		return this.mselectkey;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  子表型号
	 */
	public void setMselectkey(java.lang.String mselectkey){
		this.mselectkey = mselectkey;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主表规格
	 */
	@Column(name ="SELECTKEY",nullable=true,length=50)
	public java.lang.String getSelectkey(){
		return this.selectkey;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主表规格
	 */
	public void setSelectkey(java.lang.String selectkey){
		this.selectkey = selectkey;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规格描述
	 */
	@Column(name ="SELECTVALUE",nullable=true,length=50)
	public java.lang.String getSelectvalue(){
		return this.selectvalue;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规格描述
	 */
	public void setSelectvalue(java.lang.String selectvalue){
		this.selectvalue = selectvalue;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  型号描述
	 */
	@Column(name ="REMARK",nullable=true,length=50)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  型号描述
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
}
