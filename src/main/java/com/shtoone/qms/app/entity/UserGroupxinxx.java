package com.shtoone.qms.app.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserGroupxinxx implements Serializable{
	private String parentId;  //父节点
	private String nodeId;  //子节点
	private String name;    //节点名字
	private String depth;  //层级关系
	private java.lang.Integer lft;  //节点所在组织机构的区间关系lft rgt 
	private java.lang.Integer rgt;
	public java.lang.Integer getLft() {
		return lft;
	}
	public void setLft(java.lang.Integer lft) {
		this.lft = lft;
	}
	public java.lang.Integer getRgt() {
		return rgt;
	}
	public void setRgt(java.lang.Integer rgt) {
		this.rgt = rgt;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
}
