package com.shtoone.qms.app.entity;

import java.io.Serializable;

public class SysCountBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userGroupId;
	private String departName;
	private String testtype;
	private String testCount;
	private String notQualifiedCount;
	private String realCount;
	private String realPer;
	private String sysCount;
	private String syjCount;
	
	private String testName;
	
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getSysCount() {
		return sysCount;
	}
	public void setSysCount(String sysCount) {
		this.sysCount = sysCount;
	}
	public String getSyjCount() {
		return syjCount;
	}
	public void setSyjCount(String syjCount) {
		this.syjCount = syjCount;
	}
	public String getTesttype() {
		return testtype;
	}
	public void setTesttype(String testtype) {
		this.testtype = testtype;
	}
	public String getUserGroupId() {
		return userGroupId;
	}
	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getTestCount() {
		return testCount;
	}
	public void setTestCount(String testCount) {
		this.testCount = testCount;
	}
	public String getNotQualifiedCount() {
		return notQualifiedCount;
	}
	public void setNotQualifiedCount(String notQualifiedCount) {
		this.notQualifiedCount = notQualifiedCount;
	}
	public String getRealCount() {
		return realCount;
	}
	public void setRealCount(String realCount) {
		this.realCount = realCount;
	}
	public String getRealPer() {
		return realPer;
	}
	public void setRealPer(String realPer) {
		this.realPer = realPer;
	}  
}
