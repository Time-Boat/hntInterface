package com.shtoone.qms.entity.bhz;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 拌合站状态查询
 * @author zhangdaihao
 * @date 2015-06-24 14:25:41
 * @version V1.0   
 *
 */
@Entity
@Table(name = "TopsysView", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class TopsysViewEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String shiyanshi_guid;
	
	/**lat*/
	private java.lang.String rgt;
	/**lft*/
	private java.lang.String lft;
	/**lng*/
	private java.lang.String longitude;
	/**rgt*/
	private java.lang.String latitude;
	/**departname*/
	private java.lang.String reportDate;
	
	private java.lang.String F_TRCODE;
	
	private java.lang.String zhuren;
	
	private java.lang.String mianji;
	
	private java.lang.String shuliang;
	
	private java.lang.String F_TRNAME;
	
	
	
	 
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="shiyanshi_guid",nullable=true,length=36)
	public java.lang.String getShiyanshi_guid(){
		return this.shiyanshi_guid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  id
	 */
	public void setShiyanshi_guid(java.lang.String shiyanshi_guid){
		this.shiyanshi_guid = shiyanshi_guid;
	}
	
	

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chaozuozhe
	 */
	@Column(name ="rgt",nullable=true,precision=50,length=50)
	public java.lang.String getRgt() {
		return rgt;
	}

	public void setRgt(java.lang.String rgt) {
		this.rgt = rgt;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chaozuozhe
	 */
	@Column(name ="LFT",nullable=true,precision=50,length=50)
	public java.lang.String getLft() {
		return lft;
	}

	public void setLft(java.lang.String lft) {
		this.lft = lft;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chaozuozhe
	 */
	@Column(name ="longitude",nullable=true,precision=50,length=50)
	public java.lang.String getLongitude() {
		return longitude;
	}

	public void setLongitude(java.lang.String longitude) {
		this.longitude = longitude;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chaozuozhe
	 */
	@Column(name ="latitude",nullable=true,precision=50,length=50)
	public java.lang.String getLatitude() {
		return latitude;
	}

	public void setLatitude(java.lang.String latitude) {
		this.latitude = latitude;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chaozuozhe
	 */
	@Column(name ="reportDate",nullable=true,precision=50,length=50)
	public java.lang.String getReportDate() {
		return reportDate;
	}

	public void setReportDate(java.lang.String reportDate) {
		this.reportDate = reportDate;
	}
	
	
	@Column(name ="F_TRCODE",nullable=true,precision=50,length=50)
	public java.lang.String getF_TRCODE() {
		return F_TRCODE;
	}

	public void setF_TRCODE(java.lang.String F_TRCODE) {
		this.F_TRCODE = F_TRCODE;
	}
	
	
	
	@Column(name ="zhuren",nullable=true,precision=50,length=50)
	public java.lang.String getZhuren() {
		return zhuren;
	}

	public void setZhuren(java.lang.String zhuren) {
		this.zhuren = zhuren;
	}
	
	
	
	@Column(name ="MIANJI",nullable=true,precision=50,length=50)
	public java.lang.String getMianji() {
		return mianji;
	}

	public void setMianji(java.lang.String mianji) {
		this.mianji = mianji;
	}
	
	
	
	@Column(name ="SHULIANG",nullable=true,precision=50,length=50)
	public java.lang.String getShuliang() {
		return shuliang;
	}

	public void setShuliang(java.lang.String shuliang) {
		this.shuliang = shuliang;
	}
	
	@Column(name ="F_TRNAME",nullable=true,precision=50,length=50)
	public java.lang.String getF_TRNAME() {
		return F_TRNAME;
	}

	public void setF_TRNAME(java.lang.String F_TRNAME) {
		this.F_TRNAME = F_TRNAME;
	}
}
