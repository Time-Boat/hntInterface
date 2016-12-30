package com.shtoone.qms.entity.bhz;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 出料口温度
 * @author zhangdaihao
 * @date 2015-10-16 10:38:54
 * @version V1.0   
 *
 */
@Entity
@Table(name = "ChuliaokouTemperaturedataView", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ChuliaokouTemperaturedataViewEntity implements java.io.Serializable {
	/**tmpid*/
	private java.lang.Integer tmpid;
	/**tmpno*/
	private java.lang.String tmpno;
	/**tmpdata*/
	private BigDecimal tmpdata;
	/**tmpshijian*/
	private java.lang.String tmpshijian;
	/**id*/
	private java.lang.Integer id;
	/**banhezhanminchen*/
	private java.lang.String banhezhanminchen;
	/**beizhu*/
	private java.lang.String beizhu;
	/**gongkongleixin*/
	private java.lang.String gongkongleixin;
	/**gongkongruanjian*/
	private java.lang.String gongkongruanjian;
	/**gprsbianhao*/
	private java.lang.String gprsbianhao;
	/**jiekouleixin*/
	private java.lang.String jiekouleixin;
	/**shebeichanjia*/
	private java.lang.String shebeichanjia;
	/**shujukuleixin*/
	private java.lang.String shujukuleixin;
	/**shuliang*/
	private java.lang.String shuliang;
	/**xiangmubuminchen*/
	private java.lang.String xiangmubuminchen;
	/**shebeileixin*/
	private java.lang.String shebeileixin;
	/**simhao*/
	private java.lang.String simhao;
	/**shoujihao*/
	private java.lang.String shoujihao;
	/**botelu*/
	private java.lang.String botelu;
	/**taocan*/
	private java.lang.String taocan;
	/**jianchen*/
	private java.lang.String jianchen;
	/**smsbaojin*/
	private java.lang.String smsbaojin;
	/**biaoduanid*/
	private java.lang.Integer biaoduanid;
	/**xiangmubuid*/
	private java.lang.Integer xiangmubuid;
	/**zuoyeduiid*/
	private java.lang.Integer zuoyeduiid;
	/**smstype*/
	private java.lang.String smstype;
	/**sendtype*/
	private java.lang.String sendtype;
	/**panshu*/
	private java.lang.String panshu;
	/**ambegin*/
	private java.lang.String ambegin;
	/**amend*/
	private java.lang.String amend;
	/**pmbegin*/
	private java.lang.String pmbegin;
	/**pmend*/
	private java.lang.String pmend;
	/**smssettype*/
	private java.lang.String smssettype;
	/**simpwd*/
	private java.lang.String simpwd;
	/**rgt*/
	private java.lang.Integer rgt;
	/**lft*/
	private java.lang.Integer lft;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  tmpid
	 */
	@Column(name ="TMPID",nullable=false,precision=19,scale=0,length=8)
	public java.lang.Integer getTmpid(){
		return this.tmpid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  tmpid
	 */
	public void setTmpid(java.lang.Integer tmpid){
		this.tmpid = tmpid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  tmpno
	 */
	@Column(name ="TMPNO",nullable=true,precision=50,length=50)
	public java.lang.String getTmpno(){
		return this.tmpno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  tmpno
	 */
	public void setTmpno(java.lang.String tmpno){
		this.tmpno = tmpno;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  tmpdata
	 */
	@Column(name ="TMPDATA",nullable=true,precision=38,scale=2,length=17)
	public BigDecimal getTmpdata(){
		return this.tmpdata;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  tmpdata
	 */
	public void setTmpdata(BigDecimal tmpdata){
		this.tmpdata = tmpdata;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  tmpshijian
	 */
	@Column(name ="TMPSHIJIAN",nullable=true,precision=50,length=50)
	public java.lang.String getTmpshijian(){
		return this.tmpshijian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  tmpshijian
	 */
	public void setTmpshijian(java.lang.String tmpshijian){
		this.tmpshijian = tmpshijian;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID",nullable=true,precision=10,scale=0,length=4)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  banhezhanminchen
	 */
	@Column(name ="BANHEZHANMINCHEN",nullable=true,precision=255,length=255)
	public java.lang.String getBanhezhanminchen(){
		return this.banhezhanminchen;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  banhezhanminchen
	 */
	public void setBanhezhanminchen(java.lang.String banhezhanminchen){
		this.banhezhanminchen = banhezhanminchen;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  beizhu
	 */
	@Column(name ="BEIZHU",nullable=true,precision=255,length=255)
	public java.lang.String getBeizhu(){
		return this.beizhu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  beizhu
	 */
	public void setBeizhu(java.lang.String beizhu){
		this.beizhu = beizhu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  gongkongleixin
	 */
	@Column(name ="GONGKONGLEIXIN",nullable=true,precision=255,length=255)
	public java.lang.String getGongkongleixin(){
		return this.gongkongleixin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  gongkongleixin
	 */
	public void setGongkongleixin(java.lang.String gongkongleixin){
		this.gongkongleixin = gongkongleixin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  gongkongruanjian
	 */
	@Column(name ="GONGKONGRUANJIAN",nullable=true,precision=255,length=255)
	public java.lang.String getGongkongruanjian(){
		return this.gongkongruanjian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  gongkongruanjian
	 */
	public void setGongkongruanjian(java.lang.String gongkongruanjian){
		this.gongkongruanjian = gongkongruanjian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  gprsbianhao
	 */
	@Column(name ="GPRSBIANHAO",nullable=true,precision=255,length=255)
	public java.lang.String getGprsbianhao(){
		return this.gprsbianhao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  gprsbianhao
	 */
	public void setGprsbianhao(java.lang.String gprsbianhao){
		this.gprsbianhao = gprsbianhao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  jiekouleixin
	 */
	@Column(name ="JIEKOULEIXIN",nullable=true,precision=255,length=255)
	public java.lang.String getJiekouleixin(){
		return this.jiekouleixin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  jiekouleixin
	 */
	public void setJiekouleixin(java.lang.String jiekouleixin){
		this.jiekouleixin = jiekouleixin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shebeichanjia
	 */
	@Column(name ="SHEBEICHANJIA",nullable=true,precision=255,length=255)
	public java.lang.String getShebeichanjia(){
		return this.shebeichanjia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shebeichanjia
	 */
	public void setShebeichanjia(java.lang.String shebeichanjia){
		this.shebeichanjia = shebeichanjia;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shujukuleixin
	 */
	@Column(name ="SHUJUKULEIXIN",nullable=true,precision=255,length=255)
	public java.lang.String getShujukuleixin(){
		return this.shujukuleixin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shujukuleixin
	 */
	public void setShujukuleixin(java.lang.String shujukuleixin){
		this.shujukuleixin = shujukuleixin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shuliang
	 */
	@Column(name ="SHULIANG",nullable=true,precision=50,length=50)
	public java.lang.String getShuliang(){
		return this.shuliang;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shuliang
	 */
	public void setShuliang(java.lang.String shuliang){
		this.shuliang = shuliang;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  xiangmubuminchen
	 */
	@Column(name ="XIANGMUBUMINCHEN",nullable=true,precision=255,length=255)
	public java.lang.String getXiangmubuminchen(){
		return this.xiangmubuminchen;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  xiangmubuminchen
	 */
	public void setXiangmubuminchen(java.lang.String xiangmubuminchen){
		this.xiangmubuminchen = xiangmubuminchen;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shebeileixin
	 */
	@Column(name ="SHEBEILEIXIN",nullable=true,precision=50,length=50)
	public java.lang.String getShebeileixin(){
		return this.shebeileixin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shebeileixin
	 */
	public void setShebeileixin(java.lang.String shebeileixin){
		this.shebeileixin = shebeileixin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  simhao
	 */
	@Column(name ="SIMHAO",nullable=true,precision=50,length=50)
	public java.lang.String getSimhao(){
		return this.simhao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  simhao
	 */
	public void setSimhao(java.lang.String simhao){
		this.simhao = simhao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shoujihao
	 */
	@Column(name ="SHOUJIHAO",nullable=true,precision=50,length=50)
	public java.lang.String getShoujihao(){
		return this.shoujihao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shoujihao
	 */
	public void setShoujihao(java.lang.String shoujihao){
		this.shoujihao = shoujihao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  botelu
	 */
	@Column(name ="BOTELU",nullable=true,precision=50,length=50)
	public java.lang.String getBotelu(){
		return this.botelu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  botelu
	 */
	public void setBotelu(java.lang.String botelu){
		this.botelu = botelu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  taocan
	 */
	@Column(name ="TAOCAN",nullable=true,precision=50,length=50)
	public java.lang.String getTaocan(){
		return this.taocan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  taocan
	 */
	public void setTaocan(java.lang.String taocan){
		this.taocan = taocan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  jianchen
	 */
	@Column(name ="JIANCHEN",nullable=true,precision=50,length=50)
	public java.lang.String getJianchen(){
		return this.jianchen;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  jianchen
	 */
	public void setJianchen(java.lang.String jianchen){
		this.jianchen = jianchen;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  smsbaojin
	 */
	@Column(name ="SMSBAOJIN",nullable=true,precision=50,length=50)
	public java.lang.String getSmsbaojin(){
		return this.smsbaojin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  smsbaojin
	 */
	public void setSmsbaojin(java.lang.String smsbaojin){
		this.smsbaojin = smsbaojin;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  biaoduanid
	 */
	@Column(name ="BIAODUANID",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getBiaoduanid(){
		return this.biaoduanid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  biaoduanid
	 */
	public void setBiaoduanid(java.lang.Integer biaoduanid){
		this.biaoduanid = biaoduanid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  xiangmubuid
	 */
	@Column(name ="XIANGMUBUID",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getXiangmubuid(){
		return this.xiangmubuid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  xiangmubuid
	 */
	public void setXiangmubuid(java.lang.Integer xiangmubuid){
		this.xiangmubuid = xiangmubuid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  zuoyeduiid
	 */
	@Column(name ="ZUOYEDUIID",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getZuoyeduiid(){
		return this.zuoyeduiid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  zuoyeduiid
	 */
	public void setZuoyeduiid(java.lang.Integer zuoyeduiid){
		this.zuoyeduiid = zuoyeduiid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  smstype
	 */
	@Column(name ="SMSTYPE",nullable=true,precision=50,length=50)
	public java.lang.String getSmstype(){
		return this.smstype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  smstype
	 */
	public void setSmstype(java.lang.String smstype){
		this.smstype = smstype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sendtype
	 */
	@Column(name ="SENDTYPE",nullable=true,precision=50,length=50)
	public java.lang.String getSendtype(){
		return this.sendtype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sendtype
	 */
	public void setSendtype(java.lang.String sendtype){
		this.sendtype = sendtype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  panshu
	 */
	@Column(name ="PANSHU",nullable=true,precision=50,length=50)
	public java.lang.String getPanshu(){
		return this.panshu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  panshu
	 */
	public void setPanshu(java.lang.String panshu){
		this.panshu = panshu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ambegin
	 */
	@Column(name ="AMBEGIN",nullable=true,precision=50,length=50)
	public java.lang.String getAmbegin(){
		return this.ambegin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ambegin
	 */
	public void setAmbegin(java.lang.String ambegin){
		this.ambegin = ambegin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  amend
	 */
	@Column(name ="AMEND",nullable=true,precision=50,length=50)
	public java.lang.String getAmend(){
		return this.amend;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  amend
	 */
	public void setAmend(java.lang.String amend){
		this.amend = amend;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  pmbegin
	 */
	@Column(name ="PMBEGIN",nullable=true,precision=50,length=50)
	public java.lang.String getPmbegin(){
		return this.pmbegin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  pmbegin
	 */
	public void setPmbegin(java.lang.String pmbegin){
		this.pmbegin = pmbegin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  pmend
	 */
	@Column(name ="PMEND",nullable=true,precision=50,length=50)
	public java.lang.String getPmend(){
		return this.pmend;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  pmend
	 */
	public void setPmend(java.lang.String pmend){
		this.pmend = pmend;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  smssettype
	 */
	@Column(name ="SMSSETTYPE",nullable=true,precision=50,length=50)
	public java.lang.String getSmssettype(){
		return this.smssettype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  smssettype
	 */
	public void setSmssettype(java.lang.String smssettype){
		this.smssettype = smssettype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  simpwd
	 */
	@Column(name ="SIMPWD",nullable=true,precision=50,length=50)
	public java.lang.String getSimpwd(){
		return this.simpwd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  simpwd
	 */
	public void setSimpwd(java.lang.String simpwd){
		this.simpwd = simpwd;
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
}
