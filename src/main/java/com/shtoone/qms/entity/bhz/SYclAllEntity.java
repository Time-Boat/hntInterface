package com.shtoone.qms.entity.bhz;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: s_ycl_all
 * @author onlineGenerator
 * @date 2015-06-15 18:16:55
 * @version V1.0   
 *
 */
@Entity
@Table(name = "s_ycl_all", schema = "")
@SuppressWarnings("serial")
public class SYclAllEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**picihao*/
	private java.lang.String picihao;
	/**mingcheng*/
	private java.lang.String mingcheng;
	/**cunchudidian*/
	private java.lang.String cunchudidian;
	/**leixing*/
	private java.lang.String leixing;
	/**rukushijian*/
	private java.lang.String rukushijian;
	/**scchangjia*/
	private java.lang.String scchangjia;
	/**chandi*/
	private java.lang.String chandi;
	/**guige*/
	private java.lang.String guige;
	/**xinghao*/
	private java.lang.String xinghao;
	/**jcshuliang*/
	private java.math.BigDecimal jcshuliang;
	/**zgkucun*/
	private java.math.BigDecimal zgkucun;
	/**pici*/
	private java.lang.String pici;
	/**scdanwei*/
	private java.lang.String scdanwei;
	/**qyshijian*/
	private java.lang.String qyshijian;
	/**syshijian*/
	private java.lang.String syshijian;
	/**shiyanren*/
	private java.lang.String shiyanren;
	/**syxingmu*/
	private java.lang.String syxingmu;
	/**ycl0*/
	private java.lang.String ycl0;
	/**ycl1*/
	private java.lang.String ycl1;
	/**ycl2*/
	private java.lang.String ycl2;
	/**ycl3*/
	private java.lang.String ycl3;
	/**ycl4*/
	private java.lang.String ycl4;
	/**ycl5*/
	private java.lang.String ycl5;
	/**ycl6*/
	private java.lang.String ycl6;
	/**ycl7*/
	private java.lang.String ycl7;
	/**yc8*/
	private java.lang.String ycl8;
	/**ycl9*/
	private java.lang.String ycl9;
	/**ycl10*/
	private java.lang.String ycl10;
	/**ycl11*/
	private java.lang.String ycl11;
	/**ycl12*/
	private java.lang.String ycl12;
	/**bgbianhao*/
	private java.lang.String bgbianhao;
	/**wybianma*/
	private java.lang.String wybianma;
	/**biaoduanid*/
	private java.lang.String biaoduanid;
	/**shujulaiyuan*/
	private java.lang.String shujulaiyuan;
	/**biaoji*/
	private java.lang.Integer biaoji;
	
	private java.lang.String daijian;
	private java.lang.String danwei;
	private java.lang.String jieshouren;
	private java.lang.String beizhu;
	private java.lang.String jinchangbianhao;
	
	
	@Column(name ="DAIJIAN",nullable=true,length=50)
	public java.lang.String getDaijian() {
		return daijian;
	}

	public void setDaijian(java.lang.String daijian) {
		this.daijian = daijian;
	}

	@Column(name ="DANWEI",nullable=true,length=50)
	public java.lang.String getDanwei() {
		return danwei;
	}

	public void setDanwei(java.lang.String danwei) {
		this.danwei = danwei;
	}
	
	@Column(name ="JIESHOUREN",nullable=true,length=50)
	public java.lang.String getJieshouren() {
		return jieshouren;
	}

	public void setJieshouren(java.lang.String jieshouren) {
		this.jieshouren = jieshouren;
	}

	@Column(name ="BEIZHU",nullable=true,length=255)
	public java.lang.String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(java.lang.String beizhu) {
		this.beizhu = beizhu;
	}

	@Column(name ="JINCHANGBIANHAO",nullable=true,length=50)
	public java.lang.String getJinchangbianhao() {
		return jinchangbianhao;
	}

	public void setJinchangbianhao(java.lang.String jinchangbianhao) {
		this.jinchangbianhao = jinchangbianhao;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  picihao
	 */
	@Column(name ="PICIHAO",nullable=true,length=32)
	public java.lang.String getPicihao(){
		return this.picihao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  picihao
	 */
	public void setPicihao(java.lang.String picihao){
		this.picihao = picihao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  mingcheng
	 */
	@Column(name ="MINGCHENG",nullable=true,length=32)
	public java.lang.String getMingcheng(){
		return this.mingcheng;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  mingcheng
	 */
	public void setMingcheng(java.lang.String mingcheng){
		this.mingcheng = mingcheng;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cunchudidian
	 */
	@Column(name ="CUNCHUDIDIAN",nullable=true,length=20)
	public java.lang.String getCunchudidian(){
		return this.cunchudidian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cunchudidian
	 */
	public void setCunchudidian(java.lang.String cunchudidian){
		this.cunchudidian = cunchudidian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  leixing
	 */
	@Column(name ="LEIXING",nullable=true,length=50)
	public java.lang.String getLeixing(){
		return this.leixing;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  leixing
	 */
	public void setLeixing(java.lang.String leixing){
		this.leixing = leixing;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  rukushijian
	 */
	@Column(name ="RUKUSHIJIAN",nullable=true,length=20)
	public java.lang.String getRukushijian(){
		return this.rukushijian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  rukushijian
	 */
	public void setRukushijian(java.lang.String rukushijian){
		this.rukushijian = rukushijian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  scchangjia
	 */
	@Column(name ="SCCHANGJIA",nullable=true,length=100)
	public java.lang.String getScchangjia(){
		return this.scchangjia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  scchangjia
	 */
	public void setScchangjia(java.lang.String scchangjia){
		this.scchangjia = scchangjia;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chandi
	 */
	@Column(name ="CHANDI",nullable=true,length=100)
	public java.lang.String getChandi(){
		return this.chandi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  chandi
	 */
	public void setChandi(java.lang.String chandi){
		this.chandi = chandi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  guige
	 */
	@Column(name ="GUIGE",nullable=true,length=50)
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
	 *@return: java.lang.String  xinghao
	 */
	@Column(name ="XINGHAO",nullable=true,length=50)
	public java.lang.String getXinghao(){
		return this.xinghao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  xinghao
	 */
	public void setXinghao(java.lang.String xinghao){
		this.xinghao = xinghao;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  jcshuliang
	 */
	@Column(name ="JCSHULIANG",nullable=true,scale=8,length=18)
	public java.math.BigDecimal getJcshuliang(){
		return new BigDecimal(String.format("%1$.2f", this.jcshuliang)).setScale(2,BigDecimal.ROUND_HALF_UP);
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  jcshuliang
	 */
	public void setJcshuliang(java.math.BigDecimal jcshuliang){
		this.jcshuliang = jcshuliang;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  zgkucun
	 */
	@Column(name ="ZGKUCUN",nullable=true,scale=8,length=18)
	public java.math.BigDecimal getZgkucun(){
		return this.zgkucun;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  zgkucun
	 */
	public void setZgkucun(java.math.BigDecimal zgkucun){
		this.zgkucun = zgkucun;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  pici
	 */
	@Column(name ="PICI",nullable=true,length=50)
	public java.lang.String getPici(){
		return this.pici;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  pici
	 */
	public void setPici(java.lang.String pici){
		this.pici = pici;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  scdanwei
	 */
	@Column(name ="SCDANWEI",nullable=true,length=100)
	public java.lang.String getScdanwei(){
		return this.scdanwei;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  scdanwei
	 */
	public void setScdanwei(java.lang.String scdanwei){
		this.scdanwei = scdanwei;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  qyshijian
	 */
	@Column(name ="QYSHIJIAN",nullable=true,length=20)
	public java.lang.String getQyshijian(){
		return this.qyshijian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  qyshijian
	 */
	public void setQyshijian(java.lang.String qyshijian){
		this.qyshijian = qyshijian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  syshijian
	 */
	@Column(name ="SYSHIJIAN",nullable=true,length=20)
	public java.lang.String getSyshijian(){
		return this.syshijian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  syshijian
	 */
	public void setSyshijian(java.lang.String syshijian){
		this.syshijian = syshijian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shiyanren
	 */
	@Column(name ="SHIYANREN",nullable=true,length=32)
	public java.lang.String getShiyanren(){
		return this.shiyanren;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shiyanren
	 */
	public void setShiyanren(java.lang.String shiyanren){
		this.shiyanren = shiyanren;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  syxingmu
	 */
	@Column(name ="SYXINGMU",nullable=true,length=100)
	public java.lang.String getSyxingmu(){
		return this.syxingmu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  syxingmu
	 */
	public void setSyxingmu(java.lang.String syxingmu){
		this.syxingmu = syxingmu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ycl0
	 */
	@Column(name ="YCL0",nullable=true,length=100)
	public java.lang.String getYcl0(){
		return this.ycl0;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ycl0
	 */
	public void setYcl0(java.lang.String ycl0){
		this.ycl0 = ycl0;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ycl1
	 */
	@Column(name ="YCL1",nullable=true,length=100)
	public java.lang.String getYcl1(){
		return this.ycl1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ycl1
	 */
	public void setYcl1(java.lang.String ycl1){
		this.ycl1 = ycl1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ycl2
	 */
	@Column(name ="YCL2",nullable=true,length=100)
	public java.lang.String getYcl2(){
		return this.ycl2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ycl2
	 */
	public void setYcl2(java.lang.String ycl2){
		this.ycl2 = ycl2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ycl3
	 */
	@Column(name ="YCL3",nullable=true,length=100)
	public java.lang.String getYcl3(){
		return this.ycl3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ycl3
	 */
	public void setYcl3(java.lang.String ycl3){
		this.ycl3 = ycl3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ycl4
	 */
	@Column(name ="YCL4",nullable=true,length=100)
	public java.lang.String getYcl4(){
		return this.ycl4;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ycl4
	 */
	public void setYcl4(java.lang.String ycl4){
		this.ycl4 = ycl4;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ycl5
	 */
	@Column(name ="YCL5",nullable=true,length=100)
	public java.lang.String getYcl5(){
		return this.ycl5;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ycl5
	 */
	public void setYcl5(java.lang.String ycl5){
		this.ycl5 = ycl5;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ycl6
	 */
	@Column(name ="YCL6",nullable=true,length=100)
	public java.lang.String getYcl6(){
		return this.ycl6;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ycl6
	 */
	public void setYcl6(java.lang.String ycl6){
		this.ycl6 = ycl6;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ycl7
	 */
	@Column(name ="YCL7",nullable=true,length=100)
	public java.lang.String getYcl7(){
		return this.ycl7;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ycl7
	 */
	public void setYcl7(java.lang.String ycl7){
		this.ycl7 = ycl7;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  yc8
	 */
	@Column(name ="YCL8",nullable=true,length=100)
	public java.lang.String getYcl8(){
		return this.ycl8;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  yc8
	 */
	public void setYcl8(java.lang.String ycl8){
		this.ycl8 = ycl8;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ycl9
	 */
	@Column(name ="YCL9",nullable=true,length=100)
	public java.lang.String getYcl9(){
		return this.ycl9;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ycl9
	 */
	public void setYcl9(java.lang.String ycl9){
		this.ycl9 = ycl9;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ycl10
	 */
	@Column(name ="YCL10",nullable=true,length=100)
	public java.lang.String getYcl10(){
		return this.ycl10;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ycl10
	 */
	public void setYcl10(java.lang.String ycl10){
		this.ycl10 = ycl10;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ycl11
	 */
	@Column(name ="YCL11",nullable=true,length=100)
	public java.lang.String getYcl11(){
		return this.ycl11;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ycl11
	 */
	public void setYcl11(java.lang.String ycl11){
		this.ycl11 = ycl11;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ycl12
	 */
	@Column(name ="YCL12",nullable=true,length=100)
	public java.lang.String getYcl12(){
		return this.ycl12;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ycl12
	 */
	public void setYcl12(java.lang.String ycl12){
		this.ycl12 = ycl12;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  bgbianhao
	 */
	@Column(name ="BGBIANHAO",nullable=true,length=100)
	public java.lang.String getBgbianhao(){
		return this.bgbianhao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  bgbianhao
	 */
	public void setBgbianhao(java.lang.String bgbianhao){
		this.bgbianhao = bgbianhao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  wybianma
	 */
	@Column(name ="WYBIANMA",nullable=true,length=50)
	public java.lang.String getWybianma(){
		return this.wybianma;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  wybianma
	 */
	public void setWybianma(java.lang.String wybianma){
		this.wybianma = wybianma;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  biaoduanid
	 */
	@Column(name ="BIAODUANID",nullable=true,length=50)
	public java.lang.String getBiaoduanid(){
		return this.biaoduanid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  biaoduanid
	 */
	public void setBiaoduanid(java.lang.String biaoduanid){
		this.biaoduanid = biaoduanid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shujulaiyuan
	 */
	@Column(name ="SHUJULAIYUAN",nullable=true,length=100)
	public java.lang.String getShujulaiyuan(){
		return this.shujulaiyuan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shujulaiyuan
	 */
	public void setShujulaiyuan(java.lang.String shujulaiyuan){
		this.shujulaiyuan = shujulaiyuan;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  biaoji
	 */
	@Column(name ="BIAOJI",nullable=true,length=4)
	public java.lang.Integer getBiaoji(){
		return this.biaoji;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  biaoji
	 */
	public void setBiaoji(java.lang.Integer biaoji){
		this.biaoji = biaoji;
	}
}
