package com.shtoone.qms.app.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Departxinxi implements Serializable{
	private String ID;
	private String departname;
	private String description;
	private String parentdepartid;
	private String lft;
	private String rgt;
	private String departorderid;
	private String lng;
	private String lat;
	private String type;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getDepartname() {
		return departname;
	}
	public void setDepartname(String departname) {
		this.departname = departname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getParentdepartid() {
		return parentdepartid;
	}
	public void setParentdepartid(String parentdepartid) {
		this.parentdepartid = parentdepartid;
	}
	public String getLft() {
		return lft;
	}
	public void setLft(String lft) {
		this.lft = lft;
	}
	public String getRgt() {
		return rgt;
	}
	public void setRgt(String rgt) {
		this.rgt = rgt;
	}
	public String getDepartorderid() {
		return departorderid;
	}
	public void setDepartorderid(String departorderid) {
		this.departorderid = departorderid;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
