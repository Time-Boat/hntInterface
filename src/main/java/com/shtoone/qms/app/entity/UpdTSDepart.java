package com.shtoone.qms.app.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "upd_t_s_depart", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class UpdTSDepart implements java.io.Serializable {
	
	@Id
	private String departid;
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  gongdanhao
	 */
	@Column(name ="departid",nullable=true,precision=50,length=50)
	public String getDepartid(){
		return this.departid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  gongdanhao
	 */
	public void setDepartid(String departid){
		this.departid = departid;
	}
	
}
