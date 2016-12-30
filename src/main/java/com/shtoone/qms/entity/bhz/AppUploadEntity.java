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
 * @Description: app上传
 * @author zhangdaihao
 * @date 2016-11-23 16:16:33
 * @version V1.0   
 *
 */
@Entity
@Table(name = "app_upload_list", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class AppUploadEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**appName*/
	private java.lang.String appName;
	/**versionCode*/
	private java.lang.String versionCode;
	/**versionName*/
	private java.lang.String versionName;
	/**packageName*/
	private java.lang.String packageName;
	/**description*/
	private java.lang.String description;
	/**downloadCount*/
	private java.lang.String downloadCount;
	/**uploadTime*/
	private java.lang.String uploadTime;
	/**appFilePath*/
	private java.lang.String appFilePath;
	/**remark*/
	private java.lang.String remark;
	/**is_force_update*/
	private java.lang.String isForceUpdate;
	/**appSize*/
	private java.lang.String appSize;
	
	@Column(name ="APP_SIZE",nullable=true,precision=50,length=100)
	public java.lang.String getAppSize() {
		return appSize;
	}

	public void setAppSize(java.lang.String appSize) {
		this.appSize = appSize;
	}
	
	@Column(name ="Is_Force_Update",nullable=true,precision=50,length=100)
	public java.lang.String getIsForceUpdate() {
		return isForceUpdate;
	}

	public void setIsForceUpdate(java.lang.String isForceUpdate) {
		this.isForceUpdate = isForceUpdate;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,precision=32,length=32)
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
	 *@return: java.lang.String  appName
	 */
	@Column(name ="APP_NAME",nullable=true,precision=50,length=100)
	public java.lang.String getAppName(){
		return this.appName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  appName
	 */
	public void setAppName(java.lang.String appName){
		this.appName = appName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  versionCode
	 */
	@Column(name ="VERSION_CODE",nullable=true,precision=50,length=100)
	public java.lang.String getVersionCode(){
		return this.versionCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  versionCode
	 */
	public void setVersionCode(java.lang.String versionCode){
		this.versionCode = versionCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  versionName
	 */
	@Column(name ="VERSION_NAME",nullable=true,precision=50,length=100)
	public java.lang.String getVersionName(){
		return this.versionName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  versionName
	 */
	public void setVersionName(java.lang.String versionName){
		this.versionName = versionName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  packageName
	 */
	@Column(name ="PACKAGE_NAME",nullable=true,precision=50,length=100)
	public java.lang.String getPackageName(){
		return this.packageName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  packageName
	 */
	public void setPackageName(java.lang.String packageName){
		this.packageName = packageName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  description
	 */
	@Column(name ="DESCRIPTION",nullable=true,precision=255,length=510)
	public java.lang.String getDescription(){
		return this.description;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  description
	 */
	public void setDescription(java.lang.String description){
		this.description = description;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  downloadCount
	 */
	@Column(name ="DOWNLOAD_COUNT",nullable=true,precision=10,length=20)
	public java.lang.String getDownloadCount(){
		return this.downloadCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  downloadCount
	 */
	public void setDownloadCount(java.lang.String downloadCount){
		this.downloadCount = downloadCount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  uploadTime
	 */
	@Column(name ="UPLOAD_TIME",nullable=true,precision=50,length=100)
	public java.lang.String getUploadTime(){
		return this.uploadTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  uploadTime
	 */
	public void setUploadTime(java.lang.String uploadTime){
		this.uploadTime = uploadTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  appFilePath
	 */
	@Column(name ="APP_FILE_PATH",nullable=true,precision=256,length=256)
	public java.lang.String getAppFilePath(){
		return this.appFilePath;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  appFilePath
	 */
	public void setAppFilePath(java.lang.String appFilePath){
		this.appFilePath = appFilePath;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark
	 */
	@Column(name ="REMARK",nullable=true,precision=50,length=100)
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
