package com.shtoone.qms.app.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AppInterfaceQuanXianBean implements Serializable {

	//与角色功能中的角度编码是一致的
	private boolean hntchaobiaoReal=false;
	private boolean hntchaobiaoSp=false;  //审批
	private boolean syschaobiaoReal=false;
	
	public boolean isHntchaobiaoReal() {
		return hntchaobiaoReal;
	}
	public void setHntchaobiaoReal(boolean hntchaobiaoReal) {
		this.hntchaobiaoReal = hntchaobiaoReal;
	}
	public boolean isHntchaobiaoSp() {
		return hntchaobiaoSp;
	}
	public void setHntchaobiaoSp(boolean hntchaobiaoSp) {
		this.hntchaobiaoSp = hntchaobiaoSp;
	}
	public boolean isSyschaobiaoReal() {
		return syschaobiaoReal;
	}
	public void setSyschaobiaoReal(boolean syschaobiaoReal) {
		this.syschaobiaoReal = syschaobiaoReal;
	}

}
