package com.shtoone.qms.entity.intf;

/**
 * 试件压力走势图的VO对象
 * <p>
 * 创建时间：2015-06-15 14:32:04
 * 
 * @author admin(wafservices@ccccltd.cn)
 */
public class ChartVO  {

	/** 压力值过程数据 */
	private String compressive_resistance_data = "";
	/** 时间数据 */
	private String time_data = "";
	/** 试件编号 */
	private String specimen_no = "";
	/** 子表全球唯一编码 */
	private String process_uuid = "";
	/** 主表唯一编码（上传唯一编码） */
	private String result_uuid = "";
	/** 支座间距 */
	private String steadier_distance = "";
	/** 最大抗压 */
	private String max_pressure = "";
	/** 抗压强度 */
	private String pressure_strength = "";
	/** 数据来源 */
	private String data_source_vendors = "";
	/** 数据上传时间 */
	private String upload_time = "";
	
	/**
	 * 获取“压力值过程数据”属性的值
	 * 
	 * @return “压力值过程数据”属性的值
	 */
	public String getCompressive_resistance_data() {
		return compressive_resistance_data;
	}
	
	/**
	 * 设置“压力值过程数据”属性的值
	 * 
	 * @param compressive_resistance_data “压力值过程数据”属性的值
	 */
	public void setCompressive_resistance_data(String compressive_resistance_data) {
		this.compressive_resistance_data = compressive_resistance_data;
	}
	
	/**
	 * 获取“时间数据”属性的值
	 * 
	 * @return “时间数据”属性的值
	 */
	public String getTime_data() {
		return time_data;
	}
	
	/**
	 * 设置“时间数据”属性的值
	 * 
	 * @param time_data “时间数据”属性的值
	 */
	public void setTime_data(String time_data) {
		this.time_data = time_data;
	}
	
	/**
	 * 获取“试件编号”属性的值
	 * 
	 * @return “试件编号”属性的值
	 */
	public String getSpecimen_no() {
		return specimen_no;
	}
	
	/**
	 * 设置“试件编号”属性的值
	 * 
	 * @param specimen_no “试件编号”属性的值
	 */
	public void setSpecimen_no(String specimen_no) {
		this.specimen_no = specimen_no;
	}
	
	/**
	 * 获取“子表全球唯一编码”属性的值
	 * 
	 * @return “子表全球唯一编码”属性的值
	 */
	public String getProcess_uuid() {
		return process_uuid;
	}
	
	/**
	 * 设置“子表全球唯一编码”属性的值
	 * 
	 * @param process_uuid “子表全球唯一编码”属性的值
	 */
	public void setProcess_uuid(String process_uuid) {
		this.process_uuid = process_uuid;
	}
	
	/**
	 * 获取“主表唯一编码（上传唯一编码）”属性的值
	 * 
	 * @return “主表唯一编码（上传唯一编码）”属性的值
	 */
	public String getResult_uuid() {
		return result_uuid;
	}
	
	/**
	 * 设置“主表唯一编码（上传唯一编码）”属性的值
	 * 
	 * @param result_uuid “主表唯一编码（上传唯一编码）”属性的值
	 */
	public void setResult_uuid(String result_uuid) {
		this.result_uuid = result_uuid;
	}
	
	/**
	 * 获取“支座间距”属性的值
	 * 
	 * @return “支座间距”属性的值
	 */
	public String getSteadier_distance() {
		return steadier_distance;
	}
	
	/**
	 * 设置“支座间距”属性的值
	 * 
	 * @param steadier_distance “支座间距”属性的值
	 */
	public void setSteadier_distance(String steadier_distance) {
		this.steadier_distance = steadier_distance;
	}
	
	/**
	 * 获取“最大抗压”属性的值
	 * 
	 * @return “最大抗压”属性的值
	 */
	public String getMax_pressure() {
		return max_pressure;
	}
	
	/**
	 * 设置“最大抗压”属性的值
	 * 
	 * @param max_pressure “最大抗压”属性的值
	 */
	public void setMax_pressure(String max_pressure) {
		this.max_pressure = max_pressure;
	}
	
	/**
	 * 获取“抗压强度”属性的值
	 * 
	 * @return “抗压强度”属性的值
	 */
	public String getPressure_strength() {
		return pressure_strength;
	}
	
	/**
	 * 设置“抗压强度”属性的值
	 * 
	 * @param pressure_strength “抗压强度”属性的值
	 */
	public void setPressure_strength(String pressure_strength) {
		this.pressure_strength = pressure_strength;
	}
	
	/**
	 * 获取“数据来源”属性的值
	 * 
	 * @return “数据来源”属性的值
	 */
	public String getData_source_vendors() {
		return data_source_vendors;
	}
	
	/**
	 * 设置“数据来源”属性的值
	 * 
	 * @param data_source_vendors “数据来源”属性的值
	 */
	public void setData_source_vendors(String data_source_vendors) {
		this.data_source_vendors = data_source_vendors;
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
