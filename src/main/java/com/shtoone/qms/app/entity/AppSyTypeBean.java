package com.shtoone.qms.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**   
 * @Title: Entity
 * @Description: AppSyTypeBean
 * @author lh
 * @date 2016-05-13 14:51:04
 * @version V1.0   
 *
 */
@SuppressWarnings("serial")
@Entity
public class AppSyTypeBean implements java.io.Serializable  {
	
	@Id
	private Integer id;
	/**试验类型ID*/
	private java.lang.String testId;
	/**试验名称*/
	private java.lang.String testName;
	/**试验类型编号*/
	private java.lang.String testType;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public java.lang.String getTestId() {
		return testId;
	}
	public void setTestId(java.lang.String testId) {
		this.testId = testId;
	}
	public java.lang.String getTestName() {
		return testName;
	}
	public void setTestName(java.lang.String testName) {
		this.testName = testName;
	}
	public java.lang.String getTestType() {
		return testType;
	}
	public void setTestType(java.lang.String testType) {
		this.testType = testType;
	}
	
}
