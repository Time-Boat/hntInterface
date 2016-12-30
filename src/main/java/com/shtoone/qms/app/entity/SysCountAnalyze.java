package com.shtoone.qms.app.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SysCountAnalyze implements Serializable{
	private String userGroupId;
	private String testType;
	private String testCount;
	private String qualifiedCount;
	private String NotqualifiedCount;
	private String validCount;
	private String qualifiedPer;
	
	private String TestName;
	
	public String getTestName() {
		return TestName;
	}
	public void setTestName(String testName) {
		TestName = testName;
	}
	public String getUserGroupId() {
		return userGroupId;
	}
	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}
	public String getTestCount() {
		return testCount;
	}
	public void setTestCount(String testCount) {
		this.testCount = testCount;
	}
	public String getQualifiedCount() {
		return qualifiedCount;
	}
	public void setQualifiedCount(String qualifiedCount) {
		this.qualifiedCount = qualifiedCount;
	}
	public String getNotqualifiedCount() {
		return NotqualifiedCount;
	}
	public void setNotqualifiedCount(String notqualifiedCount) {
		NotqualifiedCount = notqualifiedCount;
	}
	public String getValidCount() {
		return validCount;
	}
	public void setValidCount(String validCount) {
		this.validCount = validCount;
	}
	public String getQualifiedPer() {
		return qualifiedPer;
	}
	public void setQualifiedPer(String qualifiedPer) {
		this.qualifiedPer = qualifiedPer;
	}
}
