package com.shtoone.qms.entity.intf;


/**
 * 原材料进场登记信息的VO对象
 * <p>
 * 创建时间：2015-06-19 16:29:22
 * 
 * @author admin(wafservices@ccccltd.cn)
 */
public class StorageVO  {
	
	/** 标段名称 */
	private String section_name = "";
	/** 上传唯一编码 */
	private String uuid = "";
	/** 原材料批次号 */
	private String resource_no = "";
	/** 原材料名称 */
	private String resource_name = "";
	/** 原材料类型 */
	private String resource_type = "";
	/** 原材料存储地点 */
	private String resource_location = "";
	/** 原材料入库时间 */
	private String resource_in_logtime = "";
	/** 生产厂家 */
	private String producer = "";
	/** 产地 */
	private String produce_address = "";
	/** 规格/型号 */
	private String specification = "";
	/** 进场数量 */
	private double resource_in_amount = 0;
	/** 总共库存 */
	private double resource_amount = 0;
	/** 批次 */
	private String batch_no = "";
	/** 所属单位 */
	private String belong_to = "";
	/** 取样时间 */
	private String example_datetime = "";
	/** 试验时间 */
	private String test_time = "";
	/** 试验人 */
	private String testor = "";
	/** 试验项目 */
	private String project = "";
	/** 检测结果1 */
	private String result1 = "";
	/** 检测结果2 */
	private String result2 = "";
	/** 检测结果3 */
	private String result3 = "";
	/** 检测结果4 */
	private String result4 = "";
	/** 检测结果5 */
	private String result5 = "";
	/** 检测结果6 */
	private String result6 = "";
	/** 检测结果7 */
	private String result7 = "";
	/** 检测结果8 */
	private String result8 = "";
	/** 检测结果9 */
	private String result9 = "";
	/** 检测结果10 */
	private String result10 = "";
	/** 检测报告编号 */
	private String report_no = "";
	/** 标段编号 */
	private String section_no = "";
	/** 数据来源厂商 */
	private String data_source_vendors = "";
	/** 上传时间 */
	private String upload_time = "";
	/** 单位全路径 */
	private String belong_to_roule = "";
	/** 检测结论 */
	private String test_result = "";
	
	/**
	 * 获取“标段名称”属性的值
	 * 
	 * @return “标段名称”属性的值
	 */
	public String getSection_name() {
		return section_name;
	}
	
	/**
	 * 设置“标段名称”属性的值
	 * 
	 * @param section_name “标段名称”属性的值
	 */
	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}
	
	/**
	 * 获取“上传唯一编码”属性的值
	 * 
	 * @return “上传唯一编码”属性的值
	 */
	public String getUuid() {
		return uuid;
	}
	
	/**
	 * 设置“上传唯一编码”属性的值
	 * 
	 * @param uuid “上传唯一编码”属性的值
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	/**
	 * 获取“原材料批次号”属性的值
	 * 
	 * @return “原材料批次号”属性的值
	 */
	public String getResource_no() {
		return resource_no;
	}
	
	/**
	 * 设置“原材料批次号”属性的值
	 * 
	 * @param resource_no “原材料批次号”属性的值
	 */
	public void setResource_no(String resource_no) {
		this.resource_no = resource_no;
	}
	
	/**
	 * 获取“原材料名称”属性的值
	 * 
	 * @return “原材料名称”属性的值
	 */
	public String getResource_name() {
		return resource_name;
	}
	
	/**
	 * 设置“原材料名称”属性的值
	 * 
	 * @param resource_name “原材料名称”属性的值
	 */
	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	}
	
	/**
	 * 获取“原材料类型”属性的值
	 * 
	 * @return “原材料类型”属性的值
	 */
	public String getResource_type() {
		return resource_type;
	}
	
	/**
	 * 设置“原材料类型”属性的值
	 * 
	 * @param resource_type “原材料类型”属性的值
	 */
	public void setResource_type(String resource_type) {
		this.resource_type = resource_type;
	}
	
	/**
	 * 获取“原材料存储地点”属性的值
	 * 
	 * @return “原材料存储地点”属性的值
	 */
	public String getResource_location() {
		return resource_location;
	}
	
	/**
	 * 设置“原材料存储地点”属性的值
	 * 
	 * @param resource_location “原材料存储地点”属性的值
	 */
	public void setResource_location(String resource_location) {
		this.resource_location = resource_location;
	}
	
	/**
	 * 获取“原材料入库时间”属性的值
	 * 
	 * @return “原材料入库时间”属性的值
	 */
	public String getResource_in_logtime() {
		return resource_in_logtime;
	}
	
	/**
	 * 设置“原材料入库时间”属性的值
	 * 
	 * @param resource_in_logtime “原材料入库时间”属性的值
	 */
	public void setResource_in_logtime(String resource_in_logtime) {
		this.resource_in_logtime = resource_in_logtime;
	}
	
	/**
	 * 获取“生产厂家”属性的值
	 * 
	 * @return “生产厂家”属性的值
	 */
	public String getProducer() {
		return producer;
	}
	
	/**
	 * 设置“生产厂家”属性的值
	 * 
	 * @param producer “生产厂家”属性的值
	 */
	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	/**
	 * 获取“产地”属性的值
	 * 
	 * @return “产地”属性的值
	 */
	public String getProduce_address() {
		return produce_address;
	}
	
	/**
	 * 设置“产地”属性的值
	 * 
	 * @param produce_address “产地”属性的值
	 */
	public void setProduce_address(String produce_address) {
		this.produce_address = produce_address;
	}
	
	/**
	 * 获取“规格/型号”属性的值
	 * 
	 * @return “规格/型号”属性的值
	 */
	public String getSpecification() {
		return specification;
	}
	
	/**
	 * 设置“规格/型号”属性的值
	 * 
	 * @param specification “规格/型号”属性的值
	 */
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	
	/**
	 * 获取“进场数量”属性的值
	 * 
	 * @return “进场数量”属性的值
	 */
	public double getResource_in_amount() {
		return resource_in_amount;
	}
	
	/**
	 * 设置“进场数量”属性的值
	 * 
	 * @param resource_in_amount “进场数量”属性的值
	 */
	public void setResource_in_amount(double resource_in_amount) {
		this.resource_in_amount = resource_in_amount;
	}
	
	/**
	 * 获取“总共库存”属性的值
	 * 
	 * @return “总共库存”属性的值
	 */
	public double getResource_amount() {
		return resource_amount;
	}
	
	/**
	 * 设置“总共库存”属性的值
	 * 
	 * @param resource_amount “总共库存”属性的值
	 */
	public void setResource_amount(double resource_amount) {
		this.resource_amount = resource_amount;
	}
	
	/**
	 * 获取“批次”属性的值
	 * 
	 * @return “批次”属性的值
	 */
	public String getBatch_no() {
		return batch_no;
	}
	
	/**
	 * 设置“批次”属性的值
	 * 
	 * @param batch_no “批次”属性的值
	 */
	public void setBatch_no(String batch_no) {
		this.batch_no = batch_no;
	}
	
	/**
	 * 获取“所属单位”属性的值
	 * 
	 * @return “所属单位”属性的值
	 */
	public String getBelong_to() {
		return belong_to;
	}
	
	/**
	 * 设置“所属单位”属性的值
	 * 
	 * @param belong_to “所属单位”属性的值
	 */
	public void setBelong_to(String belong_to) {
		this.belong_to = belong_to;
	}
	
	/**
	 * 获取“取样时间”属性的值
	 * 
	 * @return “取样时间”属性的值
	 */
	public String getExample_datetime() {
		return example_datetime;
	}
	
	/**
	 * 设置“取样时间”属性的值
	 * 
	 * @param example_datetime “取样时间”属性的值
	 */
	public void setExample_datetime(String example_datetime) {
		this.example_datetime = example_datetime;
	}
	
	/**
	 * 获取“试验时间”属性的值
	 * 
	 * @return “试验时间”属性的值
	 */
	public String getTest_time() {
		return test_time;
	}
	
	/**
	 * 设置“试验时间”属性的值
	 * 
	 * @param test_time “试验时间”属性的值
	 */
	public void setTest_time(String test_time) {
		this.test_time = test_time;
	}
	
	/**
	 * 获取“试验人”属性的值
	 * 
	 * @return “试验人”属性的值
	 */
	public String getTestor() {
		return testor;
	}
	
	/**
	 * 设置“试验人”属性的值
	 * 
	 * @param testor “试验人”属性的值
	 */
	public void setTestor(String testor) {
		this.testor = testor;
	}
	
	/**
	 * 获取“试验项目”属性的值
	 * 
	 * @return “试验项目”属性的值
	 */
	public String getProject() {
		return project;
	}
	
	/**
	 * 设置“试验项目”属性的值
	 * 
	 * @param project “试验项目”属性的值
	 */
	public void setProject(String project) {
		this.project = project;
	}
	
	/**
	 * 获取“检测结果1”属性的值
	 * 
	 * @return “检测结果1”属性的值
	 */
	public String getResult1() {
		return result1;
	}
	
	/**
	 * 设置“检测结果1”属性的值
	 * 
	 * @param result1 “检测结果1”属性的值
	 */
	public void setResult1(String result1) {
		this.result1 = result1;
	}
	
	/**
	 * 获取“检测结果2”属性的值
	 * 
	 * @return “检测结果2”属性的值
	 */
	public String getResult2() {
		return result2;
	}
	
	/**
	 * 设置“检测结果2”属性的值
	 * 
	 * @param result2 “检测结果2”属性的值
	 */
	public void setResult2(String result2) {
		this.result2 = result2;
	}
	
	/**
	 * 获取“检测结果3”属性的值
	 * 
	 * @return “检测结果3”属性的值
	 */
	public String getResult3() {
		return result3;
	}
	
	/**
	 * 设置“检测结果3”属性的值
	 * 
	 * @param result3 “检测结果3”属性的值
	 */
	public void setResult3(String result3) {
		this.result3 = result3;
	}
	
	/**
	 * 获取“检测结果4”属性的值
	 * 
	 * @return “检测结果4”属性的值
	 */
	public String getResult4() {
		return result4;
	}
	
	/**
	 * 设置“检测结果4”属性的值
	 * 
	 * @param result4 “检测结果4”属性的值
	 */
	public void setResult4(String result4) {
		this.result4 = result4;
	}
	
	/**
	 * 获取“检测结果5”属性的值
	 * 
	 * @return “检测结果5”属性的值
	 */
	public String getResult5() {
		return result5;
	}
	
	/**
	 * 设置“检测结果5”属性的值
	 * 
	 * @param result5 “检测结果5”属性的值
	 */
	public void setResult5(String result5) {
		this.result5 = result5;
	}
	
	/**
	 * 获取“检测结果6”属性的值
	 * 
	 * @return “检测结果6”属性的值
	 */
	public String getResult6() {
		return result6;
	}
	
	/**
	 * 设置“检测结果6”属性的值
	 * 
	 * @param result6 “检测结果6”属性的值
	 */
	public void setResult6(String result6) {
		this.result6 = result6;
	}
	
	/**
	 * 获取“检测结果7”属性的值
	 * 
	 * @return “检测结果7”属性的值
	 */
	public String getResult7() {
		return result7;
	}
	
	/**
	 * 设置“检测结果7”属性的值
	 * 
	 * @param result7 “检测结果7”属性的值
	 */
	public void setResult7(String result7) {
		this.result7 = result7;
	}
	
	/**
	 * 获取“检测结果8”属性的值
	 * 
	 * @return “检测结果8”属性的值
	 */
	public String getResult8() {
		return result8;
	}
	
	/**
	 * 设置“检测结果8”属性的值
	 * 
	 * @param result8 “检测结果8”属性的值
	 */
	public void setResult8(String result8) {
		this.result8 = result8;
	}
	
	/**
	 * 获取“检测结果9”属性的值
	 * 
	 * @return “检测结果9”属性的值
	 */
	public String getResult9() {
		return result9;
	}
	
	/**
	 * 设置“检测结果9”属性的值
	 * 
	 * @param result9 “检测结果9”属性的值
	 */
	public void setResult9(String result9) {
		this.result9 = result9;
	}
	
	/**
	 * 获取“检测结果10”属性的值
	 * 
	 * @return “检测结果10”属性的值
	 */
	public String getResult10() {
		return result10;
	}
	
	/**
	 * 设置“检测结果10”属性的值
	 * 
	 * @param result10 “检测结果10”属性的值
	 */
	public void setResult10(String result10) {
		this.result10 = result10;
	}
	
	/**
	 * 获取“检测报告编号”属性的值
	 * 
	 * @return “检测报告编号”属性的值
	 */
	public String getReport_no() {
		return report_no;
	}
	
	/**
	 * 设置“检测报告编号”属性的值
	 * 
	 * @param report_no “检测报告编号”属性的值
	 */
	public void setReport_no(String report_no) {
		this.report_no = report_no;
	}
	
	/**
	 * 获取“标段编号”属性的值
	 * 
	 * @return “标段编号”属性的值
	 */
	public String getSection_no() {
		return section_no;
	}
	
	/**
	 * 设置“标段编号”属性的值
	 * 
	 * @param section_no “标段编号”属性的值
	 */
	public void setSection_no(String section_no) {
		this.section_no = section_no;
	}
	
	/**
	 * 获取“数据来源厂商”属性的值
	 * 
	 * @return “数据来源厂商”属性的值
	 */
	public String getData_source_vendors() {
		return data_source_vendors;
	}
	
	/**
	 * 设置“数据来源厂商”属性的值
	 * 
	 * @param data_source_vendors “数据来源厂商”属性的值
	 */
	public void setData_source_vendors(String data_source_vendors) {
		this.data_source_vendors = data_source_vendors;
	}
	
	/**
	 * 获取“上传时间”属性的值
	 * 
	 * @return “上传时间”属性的值
	 */
	public String getUpload_time() {
		return upload_time;
	}
	
	/**
	 * 设置“上传时间”属性的值
	 * 
	 * @param upload_time “上传时间”属性的值
	 */
	public void setUpload_time(String upload_time) {
		this.upload_time = upload_time;
	}
	
	/**
	 * 获取“单位全路径”属性的值
	 * 
	 * @return “单位全路径”属性的值
	 */
	public String getBelong_to_roule() {
		return belong_to_roule;
	}
	
	/**
	 * 设置“单位全路径”属性的值
	 * 
	 * @param belong_to_roule “单位全路径”属性的值
	 */
	public void setBelong_to_roule(String belong_to_roule) {
		this.belong_to_roule = belong_to_roule;
	}
	
	/**
	 * 获取“检测结论”属性的值
	 * 
	 * @return “检测结论”属性的值
	 */
	public String getTest_result() {
		return test_result;
	}
	
	/**
	 * 设置“检测结论”属性的值
	 * 
	 * @param test_result “检测结论”属性的值
	 */
	public void setTest_result(String test_result) {
		this.test_result = test_result;
	}
	
}
