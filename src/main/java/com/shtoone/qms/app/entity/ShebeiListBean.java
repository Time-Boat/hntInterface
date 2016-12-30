package com.shtoone.qms.app.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ShebeiListBean implements Serializable{
	private String gprsbianhao;
	private String banhezhanminchen;
	private String departid;
	public String getGprsbianhao() {
		return gprsbianhao;
	}
	public void setGprsbianhao(String gprsbianhao) {
		this.gprsbianhao = gprsbianhao;
	}
	public String getBanhezhanminchen() {
		return banhezhanminchen;
	}
	public void setBanhezhanminchen(String banhezhanminchen) {
		this.banhezhanminchen = banhezhanminchen;
	}
	public String getDepartid() {
		return departid;
	}
	public void setDepartid(String departid) {
		this.departid = departid;
	}
}
