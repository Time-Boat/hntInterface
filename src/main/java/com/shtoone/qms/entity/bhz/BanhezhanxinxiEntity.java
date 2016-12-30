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
 * @Description: 拌和机信息基础表
 * @author zhangdaihao
 * @date 2015-06-09 16:48:50
 * @version V1.0   
 *
 */
@Entity
@Table(name = "Banhezhanxinxi", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class BanhezhanxinxiEntity implements java.io.Serializable {
		
	/**id*/
	private java.lang.Integer id;
	/**数据传输设备编号*/
	private java.lang.String gprsbianhao;
	/**数据传输设备所属类型，水泥拌和机或沥青拌和机或万能机等*/
	private java.lang.String gprstype;
	/**拌和站名称*/
	private java.lang.String banhezhanminchen;
	/**拌和站简称*/
	private java.lang.String jianchen;
	/**拌和机设备厂家*/
	private java.lang.String shebeichanjia;
	/**拌和机设备型号*/
	private java.lang.String shebeixinghao;
	/**工控机厂家*/
	private java.lang.String gongkongleixin;
	/**采集端软件及版本*/
	private java.lang.String caijiduanruanjianbanben;
	/**接口类型*/
	private java.lang.String jiekouleixin;
	/**工控机数据库类型*/
	private java.lang.String shujukuleixin;
	/**数量*/
	private java.lang.String shuliang;
	/**数据传输设备SIM卡号*/
	private java.lang.String simhao;
	/**数据传输设备SIM卡密码*/
	private java.lang.String simpwd;
	/**波特率*/
	private java.lang.String botelu;
	/**数据传输设备SIM卡套餐*/
	private java.lang.String taocan;
	/**是否报警*/
	private java.lang.String smsbaojin;
	/***报警时段类型 定时or连续*/
	private java.lang.String smstype;
	/**报警方式  实时or汇总*/
	private java.lang.String sendtype;
	/**汇总盘数*/
	private java.lang.String panshu;
	/**上午开始时间*/
	private java.lang.String ambegin;
	/**上午结束时间*/
	private java.lang.String amend;
	/**下午开始时间*/
	private java.lang.String pmbegin;
	/**下午结束时间*/
	private java.lang.String pmend;
	/**短信报警设置方式  全局or个别*/
	private java.lang.String smssettype;
	/**拌和机设备地址*/
	private java.lang.String shebeidizhi;
	/**设备占地面积*/
	private java.lang.String shebeimianji;
	/**拌和站操作人*/
	private java.lang.String caozuoren;
	/**站长*/
	private java.lang.String zhanzhang;
	/**联系电话*/
	private java.lang.String lianxidianhua;
	/**时间格式*/
	private java.lang.String shijiangeshi;
	/**排序编号*/
	private java.lang.Integer orderid;
	/**所属部门编号*/
	private java.lang.String departid;
	/**备注*/
	private java.lang.String remark;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID",nullable=false,precision=10,scale=0,length=4)
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
	 *@return: java.lang.String  gprstype
	 */
	@Column(name ="GPRSTYPE",nullable=true,precision=50,length=50)
	public java.lang.String getGprstype(){
		return this.gprstype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  gprstype
	 */
	public void setGprstype(java.lang.String gprstype){
		this.gprstype = gprstype;
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
	 *@return: java.lang.String  shebeixinghao
	 */
	@Column(name ="SHEBEIXINGHAO",nullable=true,precision=50,length=100)
	public java.lang.String getShebeixinghao(){
		return this.shebeixinghao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shebeixinghao
	 */
	public void setShebeixinghao(java.lang.String shebeixinghao){
		this.shebeixinghao = shebeixinghao;
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
	 *@return: java.lang.String  caijiduanruanjianbanben
	 */
	@Column(name ="CAIJIDUANRUANJIANBANBEN",nullable=true,precision=255,length=255)
	public java.lang.String getCaijiduanruanjianbanben(){
		return this.caijiduanruanjianbanben;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  caijiduanruanjianbanben
	 */
	public void setCaijiduanruanjianbanben(java.lang.String caijiduanruanjianbanben){
		this.caijiduanruanjianbanben = caijiduanruanjianbanben;
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
	 *@return: java.lang.String  shebeidizhi
	 */
	@Column(name ="SHEBEIDIZHI",nullable=true,precision=50,length=100)
	public java.lang.String getShebeidizhi(){
		return this.shebeidizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shebeidizhi
	 */
	public void setShebeidizhi(java.lang.String shebeidizhi){
		this.shebeidizhi = shebeidizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shebeimianji
	 */
	@Column(name ="SHEBEIMIANJI",nullable=true,precision=50,length=100)
	public java.lang.String getShebeimianji(){
		return this.shebeimianji;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shebeimianji
	 */
	public void setShebeimianji(java.lang.String shebeimianji){
		this.shebeimianji = shebeimianji;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  caozuoren
	 */
	@Column(name ="CAOZUOREN",nullable=true,precision=50,length=100)
	public java.lang.String getCaozuoren(){
		return this.caozuoren;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  caozuoren
	 */
	public void setCaozuoren(java.lang.String caozuoren){
		this.caozuoren = caozuoren;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  zhanzhang
	 */
	@Column(name ="ZHANZHANG",nullable=true,precision=50,length=100)
	public java.lang.String getZhanzhang(){
		return this.zhanzhang;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  zhanzhang
	 */
	public void setZhanzhang(java.lang.String zhanzhang){
		this.zhanzhang = zhanzhang;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  lianxidianhua
	 */
	@Column(name ="LIANXIDIANHUA",nullable=true,precision=50,length=100)
	public java.lang.String getLianxidianhua(){
		return this.lianxidianhua;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  lianxidianhua
	 */
	public void setLianxidianhua(java.lang.String lianxidianhua){
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shijiangeshi
	 */
	@Column(name ="SHIJIANGESHI",nullable=true,precision=50,length=50)
	public java.lang.String getShijiangeshi(){
		return this.shijiangeshi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shijiangeshi
	 */
	public void setShijiangeshi(java.lang.String shijiangeshi){
		this.shijiangeshi = shijiangeshi;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  orderid
	 */
	@Column(name ="ORDERID",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getOrderid(){
		return this.orderid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  orderid
	 */
	public void setOrderid(java.lang.Integer orderid){
		this.orderid = orderid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  departid
	 */
	@Column(name ="DEPARTID",nullable=true,precision=50,length=50)
	public java.lang.String getDepartid(){
		return this.departid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  departid
	 */
	public void setDepartid(java.lang.String departid){
		this.departid = departid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark
	 */
	@Column(name ="REMARK",nullable=true,precision=50,length=100)
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
}
