package com.shtoone.qms.entity.intf;


/**
 * 拌和机基本信息的VO对象
 * <p>
 * 创建时间：2015-06-23 09:08:10
 * 
 * @author admin(wafservices@ccccltd.cn)
 */
public class MachineVO  {

	
	/** 唯一码 */
	private String mix_machine_code = "";
	/** 拌和站编号 */
	private String mix_station_code = "";
	/** 经度 */
	private double longitude = 0;
	/** 纬度 */
	private double latitude = 0;
	/** 类型 */
	private String type = "";
	/** 厂家 */
	private String vendor = "";
	/** 备注 */
	private String memo = "";
	/** 数据来源 */
	private String data_source_vendor = "";
	/** 数据上传时间 */
	private String upload_time = "";
	
	/**
	 * 获取“唯一码”属性的值
	 * 
	 * @return “唯一码”属性的值
	 */
	public String getMix_machine_code() {
		return mix_machine_code;
	}
	
	/**
	 * 设置“唯一码”属性的值
	 * 
	 * @param mix_machine_code “唯一码”属性的值
	 */
	public void setMix_machine_code(String mix_machine_code) {
		this.mix_machine_code = mix_machine_code;
	}
	
	/**
	 * 获取“拌和站编号”属性的值
	 * 
	 * @return “拌和站编号”属性的值
	 */
	public String getMix_station_code() {
		return mix_station_code;
	}
	
	/**
	 * 设置“拌和站编号”属性的值
	 * 
	 * @param mix_station_code “拌和站编号”属性的值
	 */
	public void setMix_station_code(String mix_station_code) {
		this.mix_station_code = mix_station_code;
	}
	
	/**
	 * 获取“经度”属性的值
	 * 
	 * @return “经度”属性的值
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * 设置“经度”属性的值
	 * 
	 * @param longitude “经度”属性的值
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * 获取“纬度”属性的值
	 * 
	 * @return “纬度”属性的值
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * 设置“纬度”属性的值
	 * 
	 * @param latitude “纬度”属性的值
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * 获取“类型”属性的值
	 * 
	 * @return “类型”属性的值
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * 设置“类型”属性的值
	 * 
	 * @param type “类型”属性的值
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * 获取“厂家”属性的值
	 * 
	 * @return “厂家”属性的值
	 */
	public String getVendor() {
		return vendor;
	}
	
	/**
	 * 设置“厂家”属性的值
	 * 
	 * @param vendor “厂家”属性的值
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	/**
	 * 获取“备注”属性的值
	 * 
	 * @return “备注”属性的值
	 */
	public String getMemo() {
		return memo;
	}
	
	/**
	 * 设置“备注”属性的值
	 * 
	 * @param memo “备注”属性的值
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	/**
	 * 获取“数据来源”属性的值
	 * 
	 * @return “数据来源”属性的值
	 */
	public String getData_source_vendor() {
		return data_source_vendor;
	}
	
	/**
	 * 设置“数据来源”属性的值
	 * 
	 * @param data_source_vendor “数据来源”属性的值
	 */
	public void setData_source_vendor(String data_source_vendor) {
		this.data_source_vendor = data_source_vendor;
	}
	
	/**
	 * 获取“数据上传时间”属性的值
	 * 
	 * @return “数据上传时间”属性的值
	 */
	public String getUpload_time() {
		return upload_time;
	}
	
	/**
	 * 设置“数据上传时间”属性的值
	 * 
	 * @param upload_time “数据上传时间”属性的值
	 */
	public void setUpload_time(String upload_time) {
		this.upload_time = upload_time;
	}
	
}
