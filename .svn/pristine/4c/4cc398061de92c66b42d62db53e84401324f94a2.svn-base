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
@Table(name = "TophunnintusyView", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class TophunnintusyViewEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	
	/**lat*/
	private java.lang.String lat;
	/**lft*/
	private java.lang.String lft;
	/**lng*/
	private java.lang.String lng;
	/**rgt*/
	private java.lang.String rgt;
	/**departname*/
	private java.lang.String departname;
	
	private java.lang.String type;
	
	private java.lang.String zhanzhang;
	
	private java.lang.String shebeimianji;
	
	private java.lang.String shuliang;
	
	private java.lang.String departid;
	
	 
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=true,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	
	

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chaozuozhe
	 */
	@Column(name ="LAT",nullable=true,precision=50,length=50)
	public java.lang.String getLat() {
		return lat;
	}

	public void setLat(java.lang.String lat) {
		this.lat = lat;
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
	@Column(name ="LNG",nullable=true,precision=50,length=50)
	public java.lang.String getLng() {
		return lng;
	}

	public void setLng(java.lang.String lng) {
		this.lng = lng;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chaozuozhe
	 */
	@Column(name ="RGT",nullable=true,precision=50,length=50)
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
	@Column(name ="DEPARTNAME",nullable=true,precision=50,length=50)
	public java.lang.String getDepartname() {
		return departname;
	}

	public void setDepartname(java.lang.String departname) {
		this.departname = departname;
	}
	
	
	@Column(name ="TYPE",nullable=true,precision=50,length=50)
	public java.lang.String getType() {
		return type;
	}

	public void setType(java.lang.String type) {
		this.type = type;
	}
	
	
	
	@Column(name ="ZHANZHANG",nullable=true,precision=50,length=50)
	public java.lang.String getZhanzhang() {
		return zhanzhang;
	}

	public void setZhanzhang(java.lang.String zhanzhang) {
		this.zhanzhang = zhanzhang;
	}
	
	
	
	@Column(name ="SHEBEIMIANJI",nullable=true,precision=50,length=50)
	public java.lang.String getShebeimianji() {
		return shebeimianji;
	}

	public void setShebeimianji(java.lang.String shebeimianji) {
		this.shebeimianji = shebeimianji;
	}
	
	
	
	@Column(name ="SHULIANG",nullable=true,precision=50,length=50)
	public java.lang.String getShuliang() {
		return shuliang;
	}

	public void setShuliang(java.lang.String shuliang) {
		this.shuliang = shuliang;
	}
	
	@Column(name ="DEPARTID",nullable=true,precision=50,length=50)
	public java.lang.String getDepartid() {
		return departid;
	}

	public void setDepartid(java.lang.String departid) {
		this.departid = departid;
	}
}
