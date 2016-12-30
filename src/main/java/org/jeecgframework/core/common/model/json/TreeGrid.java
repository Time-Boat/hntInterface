package org.jeecgframework.core.common.model.json;

import java.util.Map;
 
@SuppressWarnings("serial")
public class TreeGrid implements java.io.Serializable {
	private String id;
	private String text;  // functionName  菜单名称
 	private String parentId;
 	private String parentText;
 	private String code;   // TSIcon_iconPath  图标
 	private String src;  // functionUrl 菜单地址
 	private String note;
	private Map<String,String> attributes;// 其他参数
 	private String  operations;// 其他参数
 	private String state = "closed";// 是否展开(open,closed)
 	private String order;//排序
 	private String lng;
 	private String lat;
 	private String type;
 	
 	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getOperations() {
		return operations;
	}
	public void setOperations(String operations) {
		this.operations = operations;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	public String getParentText() {
		return parentText;
	}
	public void setParentText(String parentText) {
		this.parentText = parentText;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	 
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}	 
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
 
}
