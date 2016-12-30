package com.shtoone.qms.entity.bhz;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "V_ShebeiInfo", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class V_ShebeiInfoEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**version*/
	private java.lang.Integer version;
	/**shebeiGuid*/
	private java.lang.String shebeiGuid;
	/**shiyanshiGuid*/
	private java.lang.String shiyanshiGuid;
	/**shebeibianhao*/
	private java.lang.String shebeibianhao;
	/**shebeijiancheng*/
	private java.lang.String shebeijiancheng;
	/**shebeiname*/
	private java.lang.String shebeiname;
	/**neibubianhao*/
	private java.lang.String neibubianhao;
	/**guige*/
	private java.lang.String guige;
	/**changjia*/
	private java.lang.String changjia;
	/**chuchangnumber*/
	private java.lang.String chuchangnumber;
	/**chuchangriqi*/
	private java.util.Date chuchangriqi;
	/**gouzhiriqi*/
	private java.util.Date gouzhiriqi;
	/**amount*/
	private java.lang.String amount;
	/**danjia*/
	private java.lang.String danjia;
	/**jiandingzhouqi*/
	private java.lang.Integer jiandingzhouqi;
	/**jiandingdanwei*/
	private java.lang.String jiandingdanwei;
	/**jiandingriqi*/
	private java.util.Date jiandingriqi;
	/**nextjiandingriqi*/
	private java.util.Date nextjiandingriqi;
	/**baoguanren*/
	private java.lang.String baoguanren;
	/**caozuoshi*/
	private java.lang.String caozuoshi;
	/**remark*/
	private java.lang.String remark;
	/**leixin*/
	private java.lang.Integer leixin;
	/**departname*/
	private java.lang.String departname;
	/**lft*/
	private java.lang.Integer lft;
	/**rgt*/
	private java.lang.Integer rgt;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID",nullable=false,precision=19,scale=0,length=8)
	public java.lang.Integer getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  id
	 */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  version
	 */
	@Column(name ="VERSION",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getVersion(){
		return this.version;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  version
	 */
	public void setVersion(java.lang.Integer version){
		this.version = version;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shebeiGuid
	 */
	@Column(name ="SHEBEI_GUID",nullable=false,precision=50,length=50)
	public java.lang.String getShebeiGuid(){
		return this.shebeiGuid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shebeiGuid
	 */
	public void setShebeiGuid(java.lang.String shebeiGuid){
		this.shebeiGuid = shebeiGuid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shiyanshiGuid
	 */
	@Column(name ="SHIYANSHI_GUID",nullable=false,precision=50,length=50)
	public java.lang.String getShiyanshiGuid(){
		return this.shiyanshiGuid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shiyanshiGuid
	 */
	public void setShiyanshiGuid(java.lang.String shiyanshiGuid){
		this.shiyanshiGuid = shiyanshiGuid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shebeibianhao
	 */
	@Column(name ="SHEBEIBIANHAO",nullable=true,precision=50,length=50)
	public java.lang.String getShebeibianhao(){
		return this.shebeibianhao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shebeibianhao
	 */
	public void setShebeibianhao(java.lang.String shebeibianhao){
		this.shebeibianhao = shebeibianhao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shebeijiancheng
	 */
	@Column(name ="SHEBEIJIANCHENG",nullable=true,precision=50,length=50)
	public java.lang.String getShebeijiancheng(){
		return this.shebeijiancheng;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shebeijiancheng
	 */
	public void setShebeijiancheng(java.lang.String shebeijiancheng){
		this.shebeijiancheng = shebeijiancheng;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shebeiname
	 */
	@Column(name ="SHEBEINAME",nullable=true,precision=100,length=100)
	public java.lang.String getShebeiname(){
		return this.shebeiname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shebeiname
	 */
	public void setShebeiname(java.lang.String shebeiname){
		this.shebeiname = shebeiname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  neibubianhao
	 */
	@Column(name ="NEIBUBIANHAO",nullable=true,precision=50,length=50)
	public java.lang.String getNeibubianhao(){
		return this.neibubianhao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  neibubianhao
	 */
	public void setNeibubianhao(java.lang.String neibubianhao){
		this.neibubianhao = neibubianhao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  guige
	 */
	@Column(name ="GUIGE",nullable=true,precision=50,length=50)
	public java.lang.String getGuige(){
		return this.guige;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  guige
	 */
	public void setGuige(java.lang.String guige){
		this.guige = guige;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  changjia
	 */
	@Column(name ="CHANGJIA",nullable=true,precision=100,length=100)
	public java.lang.String getChangjia(){
		return this.changjia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  changjia
	 */
	public void setChangjia(java.lang.String changjia){
		this.changjia = changjia;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chuchangnumber
	 */
	@Column(name ="CHUCHANGNUMBER",nullable=true,precision=50,length=50)
	public java.lang.String getChuchangnumber(){
		return this.chuchangnumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  chuchangnumber
	 */
	public void setChuchangnumber(java.lang.String chuchangnumber){
		this.chuchangnumber = chuchangnumber;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  chuchangriqi
	 */
	@Column(name ="CHUCHANGRIQI",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getChuchangriqi(){
		return this.chuchangriqi;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  chuchangriqi
	 */
	public void setChuchangriqi(java.util.Date chuchangriqi){
		this.chuchangriqi = chuchangriqi;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  gouzhiriqi
	 */
	@Column(name ="GOUZHIRIQI",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getGouzhiriqi(){
		return this.gouzhiriqi;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  gouzhiriqi
	 */
	public void setGouzhiriqi(java.util.Date gouzhiriqi){
		this.gouzhiriqi = gouzhiriqi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  amount
	 */
	@Column(name ="AMOUNT",nullable=true,precision=20,length=20)
	public java.lang.String getAmount(){
		return this.amount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  amount
	 */
	public void setAmount(java.lang.String amount){
		this.amount = amount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  danjia
	 */
	@Column(name ="DANJIA",nullable=true,precision=20,length=20)
	public java.lang.String getDanjia(){
		return this.danjia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  danjia
	 */
	public void setDanjia(java.lang.String danjia){
		this.danjia = danjia;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  jiandingzhouqi
	 */
	@Column(name ="JIANDINGZHOUQI",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getJiandingzhouqi(){
		return this.jiandingzhouqi;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  jiandingzhouqi
	 */
	public void setJiandingzhouqi(java.lang.Integer jiandingzhouqi){
		this.jiandingzhouqi = jiandingzhouqi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  jiandingdanwei
	 */
	@Column(name ="JIANDINGDANWEI",nullable=true,precision=100,length=100)
	public java.lang.String getJiandingdanwei(){
		return this.jiandingdanwei;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  jiandingdanwei
	 */
	public void setJiandingdanwei(java.lang.String jiandingdanwei){
		this.jiandingdanwei = jiandingdanwei;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  jiandingriqi
	 */
	@Column(name ="JIANDINGRIQI",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getJiandingriqi(){
		return this.jiandingriqi;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  jiandingriqi
	 */
	public void setJiandingriqi(java.util.Date jiandingriqi){
		this.jiandingriqi = jiandingriqi;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  nextjiandingriqi
	 */
	@Column(name ="NEXTJIANDINGRIQI",nullable=true,precision=23,scale=3,length=8)
	public java.util.Date getNextjiandingriqi(){
		return this.nextjiandingriqi;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  nextjiandingriqi
	 */
	public void setNextjiandingriqi(java.util.Date nextjiandingriqi){
		this.nextjiandingriqi = nextjiandingriqi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  baoguanren
	 */
	@Column(name ="BAOGUANREN",nullable=true,precision=50,length=50)
	public java.lang.String getBaoguanren(){
		return this.baoguanren;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  baoguanren
	 */
	public void setBaoguanren(java.lang.String baoguanren){
		this.baoguanren = baoguanren;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  caozuoshi
	 */
	@Column(name ="CAOZUOSHI",nullable=true,precision=100,length=100)
	public java.lang.String getCaozuoshi(){
		return this.caozuoshi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  caozuoshi
	 */
	public void setCaozuoshi(java.lang.String caozuoshi){
		this.caozuoshi = caozuoshi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark
	 */
	@Column(name ="REMARK",nullable=true,precision=200,length=200)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  leixin
	 */
	@Column(name ="LEIXIN",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getLeixin(){
		return this.leixin;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  leixin
	 */
	public void setLeixin(java.lang.Integer leixin){
		this.leixin = leixin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  departname
	 */
	@Column(name ="DEPARTNAME",nullable=false,precision=100,length=100)
	public java.lang.String getDepartname(){
		return this.departname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  departname
	 */
	public void setDepartname(java.lang.String departname){
		this.departname = departname;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  lft
	 */
	@Column(name ="LFT",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getLft(){
		return this.lft;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  lft
	 */
	public void setLft(java.lang.Integer lft){
		this.lft = lft;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  rgt
	 */
	@Column(name ="RGT",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getRgt(){
		return this.rgt;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  rgt
	 */
	public void setRgt(java.lang.Integer rgt){
		this.rgt = rgt;
	}
}
