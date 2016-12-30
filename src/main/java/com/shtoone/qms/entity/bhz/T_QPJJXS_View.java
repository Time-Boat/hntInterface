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
 * @Description: 气泡间距系数
 * @author zhangdaihao
 * @date 2016-07-05 16:29:49
 * @version V1.0   
 *
 */
@Entity
@Table(name = "T_QPJJXS_View", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class T_QPJJXS_View implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**ID*/
	private java.lang.String syjid;
	/**设备编号*/
	private java.lang.String sbbh;
	/**实验类型*/
	private java.lang.String sylx;
	/**工程名称*/
	private java.lang.String wtbh;
	/**委托组数*/
	private java.lang.String wtzs;
	/**试件编号*/
	private java.lang.String sjbh;
	/**试验日期*/
	private java.lang.String syrq;
	/**试验完成时间*/
	private java.lang.String sywcsj;
	/**数据上传试件*/
	private java.lang.String sjscsj;
	/**状态位*/
	private java.lang.Integer status;
	/**样本编号*/
	private java.lang.String ybbh;
	/**试验编号*/
	private java.lang.String sybh;
	/**试验人员*/
	private java.lang.String syry;
	/**灰度阀值*/
	private java.lang.String hdfz;
	/**气泡个数1*/
	private java.lang.String qpgs1;
	/**气泡个数2*/
	private java.lang.String qpgs2;
	/**气泡个数3*/
	private java.lang.String qpgs3;
	/**气泡总量百分比1*/
	private java.lang.String zzlbfb1;
	/**气泡总量百分比2*/
	private java.lang.String zzlbfb2;
	/**气泡总量百分比3*/
	private java.lang.String zzlbfb3;
	/**气泡总长1*/
	private java.lang.String qpzc1;
	/**气泡总长2*/
	private java.lang.String qpzc2;
	/**气泡总长3*/
	private java.lang.String qpzc3;
	/**气泡总长百分比1*/
	private java.lang.String zzcbfb1;
	/**气泡总长百分比2*/
	private java.lang.String zzcbfb2;
	/**气泡总长百分比3*/
	private java.lang.String zzcbfb3;
	/**空气含量1*/
	private java.lang.String kqhl1;
	/**空气含量2*/
	private java.lang.String kqhl2;
	/**空气含量3*/
	private java.lang.String kqhl3;
	/**平均弦长1*/
	private java.lang.String pjxc1;
	/**平均弦长2*/
	private java.lang.String pjxc2;
	/**平均弦长3*/
	private java.lang.String pjxc3;
	/**浆气比1*/
	private java.lang.String jqb1;
	/**浆气比2*/
	private java.lang.String jqb2;
	/**浆气比3*/
	private java.lang.String jqb3;
	/**表面面积1*/
	private java.lang.String bbmj1;
	/**表面面积2*/
	private java.lang.String bbmj2;
	/**表面面积3*/
	private java.lang.String bbmj3;
	/**孔隙率1*/
	private java.lang.String kxl1;
	/**孔隙率2*/
	private java.lang.String kxl2;
	/**孔隙率3*/
	private java.lang.String kxl3;
	/**间距系数1*/
	private java.lang.String jjxs1;
	/**间距系数2*/
	private java.lang.String jjxs2;
	/**间距系数3*/
	private java.lang.String jjxs3;
	private java.lang.String lft;
	private java.lang.String rgt;
	
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
	 *@return: java.lang.String  ID
	 */
	@Column(name ="SYJID",nullable=false,precision=50,length=100)
	public java.lang.String getSyjid(){
		return this.syjid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ID
	 */
	public void setSyjid(java.lang.String syjid){
		this.syjid = syjid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  设备编号
	 */
	@Column(name ="SBBH",nullable=true,precision=50,length=100)
	public java.lang.String getSbbh(){
		return this.sbbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  设备编号
	 */
	public void setSbbh(java.lang.String sbbh){
		this.sbbh = sbbh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  实验类型
	 */
	@Column(name ="SYLX",nullable=true,precision=50,length=100)
	public java.lang.String getSylx(){
		return this.sylx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  实验类型
	 */
	public void setSylx(java.lang.String sylx){
		this.sylx = sylx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工程名称
	 */
	@Column(name ="WTBH",nullable=true,precision=50,length=100)
	public java.lang.String getWtbh(){
		return this.wtbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工程名称
	 */
	public void setWtbh(java.lang.String wtbh){
		this.wtbh = wtbh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  委托组数
	 */
	@Column(name ="WTZS",nullable=true,precision=255,length=510)
	public java.lang.String getWtzs(){
		return this.wtzs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  委托组数
	 */
	public void setWtzs(java.lang.String wtzs){
		this.wtzs = wtzs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  试件编号
	 */
	@Column(name ="SJBH",nullable=true,precision=50,length=100)
	public java.lang.String getSjbh(){
		return this.sjbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试件编号
	 */
	public void setSjbh(java.lang.String sjbh){
		this.sjbh = sjbh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  试验日期
	 */
	@Column(name ="SYRQ",nullable=true,precision=50,length=100)
	public java.lang.String getSyrq(){
		return this.syrq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试验日期
	 */
	public void setSyrq(java.lang.String syrq){
		this.syrq = syrq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  试验完成时间
	 */
	@Column(name ="SYWCSJ",nullable=true,precision=50,length=100)
	public java.lang.String getSywcsj(){
		return this.sywcsj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试验完成时间
	 */
	public void setSywcsj(java.lang.String sywcsj){
		this.sywcsj = sywcsj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  数据上传试件
	 */
	@Column(name ="SJSCSJ",nullable=true,precision=50,length=100)
	public java.lang.String getSjscsj(){
		return this.sjscsj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数据上传试件
	 */
	public void setSjscsj(java.lang.String sjscsj){
		this.sjscsj = sjscsj;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态位
	 */
	@Column(name ="STATUS",nullable=true,precision=5,scale=0,length=2)
	public java.lang.Integer getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态位
	 */
	public void setStatus(java.lang.Integer status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  样本编号
	 */
	@Column(name ="YBBH",nullable=true,precision=255,length=510)
	public java.lang.String getYbbh(){
		return this.ybbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  样本编号
	 */
	public void setYbbh(java.lang.String ybbh){
		this.ybbh = ybbh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  试验编号
	 */
	@Column(name ="SYBH",nullable=true,precision=255,length=510)
	public java.lang.String getSybh(){
		return this.sybh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试验编号
	 */
	public void setSybh(java.lang.String sybh){
		this.sybh = sybh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  试验人员
	 */
	@Column(name ="SYRY",nullable=true,precision=255,length=510)
	public java.lang.String getSyry(){
		return this.syry;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试验人员
	 */
	public void setSyry(java.lang.String syry){
		this.syry = syry;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  灰度阀值
	 */
	@Column(name ="HDFZ",nullable=true,precision=255,length=510)
	public java.lang.String getHdfz(){
		return this.hdfz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  灰度阀值
	 */
	public void setHdfz(java.lang.String hdfz){
		this.hdfz = hdfz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  气泡个数1
	 */
	@Column(name ="QPGS1",nullable=true,precision=255,length=510)
	public java.lang.String getQpgs1(){
		return this.qpgs1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  气泡个数1
	 */
	public void setQpgs1(java.lang.String qpgs1){
		this.qpgs1 = qpgs1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  气泡个数2
	 */
	@Column(name ="QPGS2",nullable=true,precision=255,length=510)
	public java.lang.String getQpgs2(){
		return this.qpgs2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  气泡个数2
	 */
	public void setQpgs2(java.lang.String qpgs2){
		this.qpgs2 = qpgs2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  气泡个数3
	 */
	@Column(name ="QPGS3",nullable=true,precision=255,length=510)
	public java.lang.String getQpgs3(){
		return this.qpgs3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  气泡个数3
	 */
	public void setQpgs3(java.lang.String qpgs3){
		this.qpgs3 = qpgs3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  气泡总量百分比1
	 */
	@Column(name ="ZZLBFB1",nullable=true,precision=255,length=510)
	public java.lang.String getZzlbfb1(){
		return this.zzlbfb1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  气泡总量百分比1
	 */
	public void setZzlbfb1(java.lang.String zzlbfb1){
		this.zzlbfb1 = zzlbfb1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  气泡总量百分比2
	 */
	@Column(name ="ZZLBFB2",nullable=true,precision=255,length=510)
	public java.lang.String getZzlbfb2(){
		return this.zzlbfb2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  气泡总量百分比2
	 */
	public void setZzlbfb2(java.lang.String zzlbfb2){
		this.zzlbfb2 = zzlbfb2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  气泡总量百分比3
	 */
	@Column(name ="ZZLBFB3",nullable=true,precision=255,length=510)
	public java.lang.String getZzlbfb3(){
		return this.zzlbfb3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  气泡总量百分比3
	 */
	public void setZzlbfb3(java.lang.String zzlbfb3){
		this.zzlbfb3 = zzlbfb3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  气泡总长1
	 */
	@Column(name ="QPZC1",nullable=true,precision=255,length=510)
	public java.lang.String getQpzc1(){
		return this.qpzc1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  气泡总长1
	 */
	public void setQpzc1(java.lang.String qpzc1){
		this.qpzc1 = qpzc1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  气泡总长2
	 */
	@Column(name ="QPZC2",nullable=true,precision=255,length=510)
	public java.lang.String getQpzc2(){
		return this.qpzc2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  气泡总长2
	 */
	public void setQpzc2(java.lang.String qpzc2){
		this.qpzc2 = qpzc2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  气泡总长3
	 */
	@Column(name ="QPZC3",nullable=true,precision=255,length=510)
	public java.lang.String getQpzc3(){
		return this.qpzc3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  气泡总长3
	 */
	public void setQpzc3(java.lang.String qpzc3){
		this.qpzc3 = qpzc3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  气泡总长百分比1
	 */
	@Column(name ="ZZCBFB1",nullable=true,precision=255,length=510)
	public java.lang.String getZzcbfb1(){
		return this.zzcbfb1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  气泡总长百分比1
	 */
	public void setZzcbfb1(java.lang.String zzcbfb1){
		this.zzcbfb1 = zzcbfb1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  气泡总长百分比2
	 */
	@Column(name ="ZZCBFB2",nullable=true,precision=255,length=510)
	public java.lang.String getZzcbfb2(){
		return this.zzcbfb2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  气泡总长百分比2
	 */
	public void setZzcbfb2(java.lang.String zzcbfb2){
		this.zzcbfb2 = zzcbfb2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  气泡总长百分比3
	 */
	@Column(name ="ZZCBFB3",nullable=true,precision=255,length=510)
	public java.lang.String getZzcbfb3(){
		return this.zzcbfb3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  气泡总长百分比3
	 */
	public void setZzcbfb3(java.lang.String zzcbfb3){
		this.zzcbfb3 = zzcbfb3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  空气含量1
	 */
	@Column(name ="KQHL1",nullable=true,precision=255,length=510)
	public java.lang.String getKqhl1(){
		return this.kqhl1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  空气含量1
	 */
	public void setKqhl1(java.lang.String kqhl1){
		this.kqhl1 = kqhl1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  空气含量2
	 */
	@Column(name ="KQHL2",nullable=true,precision=255,length=510)
	public java.lang.String getKqhl2(){
		return this.kqhl2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  空气含量2
	 */
	public void setKqhl2(java.lang.String kqhl2){
		this.kqhl2 = kqhl2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  空气含量3
	 */
	@Column(name ="KQHL3",nullable=true,precision=255,length=510)
	public java.lang.String getKqhl3(){
		return this.kqhl3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  空气含量3
	 */
	public void setKqhl3(java.lang.String kqhl3){
		this.kqhl3 = kqhl3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  平均弦长1
	 */
	@Column(name ="PJXC1",nullable=true,precision=255,length=510)
	public java.lang.String getPjxc1(){
		return this.pjxc1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  平均弦长1
	 */
	public void setPjxc1(java.lang.String pjxc1){
		this.pjxc1 = pjxc1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  平均弦长2
	 */
	@Column(name ="PJXC2",nullable=true,precision=255,length=510)
	public java.lang.String getPjxc2(){
		return this.pjxc2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  平均弦长2
	 */
	public void setPjxc2(java.lang.String pjxc2){
		this.pjxc2 = pjxc2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  平均弦长3
	 */
	@Column(name ="PJXC3",nullable=true,precision=255,length=510)
	public java.lang.String getPjxc3(){
		return this.pjxc3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  平均弦长3
	 */
	public void setPjxc3(java.lang.String pjxc3){
		this.pjxc3 = pjxc3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  浆气比1
	 */
	@Column(name ="JQB1",nullable=true,precision=255,length=510)
	public java.lang.String getJqb1(){
		return this.jqb1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  浆气比1
	 */
	public void setJqb1(java.lang.String jqb1){
		this.jqb1 = jqb1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  浆气比2
	 */
	@Column(name ="JQB2",nullable=true,precision=255,length=510)
	public java.lang.String getJqb2(){
		return this.jqb2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  浆气比2
	 */
	public void setJqb2(java.lang.String jqb2){
		this.jqb2 = jqb2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  浆气比3
	 */
	@Column(name ="JQB3",nullable=true,precision=255,length=510)
	public java.lang.String getJqb3(){
		return this.jqb3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  浆气比3
	 */
	public void setJqb3(java.lang.String jqb3){
		this.jqb3 = jqb3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  表面面积1
	 */
	@Column(name ="BBMJ1",nullable=true,precision=255,length=510)
	public java.lang.String getBbmj1(){
		return this.bbmj1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  表面面积1
	 */
	public void setBbmj1(java.lang.String bbmj1){
		this.bbmj1 = bbmj1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  表面面积2
	 */
	@Column(name ="BBMJ2",nullable=true,precision=255,length=510)
	public java.lang.String getBbmj2(){
		return this.bbmj2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  表面面积2
	 */
	public void setBbmj2(java.lang.String bbmj2){
		this.bbmj2 = bbmj2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  表面面积3
	 */
	@Column(name ="BBMJ3",nullable=true,precision=255,length=510)
	public java.lang.String getBbmj3(){
		return this.bbmj3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  表面面积3
	 */
	public void setBbmj3(java.lang.String bbmj3){
		this.bbmj3 = bbmj3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  孔隙率1
	 */
	@Column(name ="KXL1",nullable=true,precision=255,length=510)
	public java.lang.String getKxl1(){
		return this.kxl1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  孔隙率1
	 */
	public void setKxl1(java.lang.String kxl1){
		this.kxl1 = kxl1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  孔隙率2
	 */
	@Column(name ="KXL2",nullable=true,precision=255,length=510)
	public java.lang.String getKxl2(){
		return this.kxl2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  孔隙率2
	 */
	public void setKxl2(java.lang.String kxl2){
		this.kxl2 = kxl2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  孔隙率3
	 */
	@Column(name ="KXL3",nullable=true,precision=255,length=510)
	public java.lang.String getKxl3(){
		return this.kxl3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  孔隙率3
	 */
	public void setKxl3(java.lang.String kxl3){
		this.kxl3 = kxl3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  间距系数1
	 */
	@Column(name ="JJXS1",nullable=true,precision=255,length=510)
	public java.lang.String getJjxs1(){
		return this.jjxs1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  间距系数1
	 */
	public void setJjxs1(java.lang.String jjxs1){
		this.jjxs1 = jjxs1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  间距系数2
	 */
	@Column(name ="JJXS2",nullable=true,precision=255,length=510)
	public java.lang.String getJjxs2(){
		return this.jjxs2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  间距系数2
	 */
	public void setJjxs2(java.lang.String jjxs2){
		this.jjxs2 = jjxs2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  间距系数3
	 */
	@Column(name ="JJXS3",nullable=true,precision=255,length=510)
	public java.lang.String getJjxs3(){
		return this.jjxs3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  间距系数3
	 */
	public void setJjxs3(java.lang.String jjxs3){
		this.jjxs3 = jjxs3;
	}
	
	
	@Column(name ="LFT",nullable=true,precision=255,length=510)
	public java.lang.String getLft() {
		return lft;
	}

	public void setLft(java.lang.String lft) {
		this.lft = lft;
	}
	@Column(name ="RGT",nullable=true,precision=255,length=510)
	public java.lang.String getRgt() {
		return rgt;
	}

	public void setRgt(java.lang.String rgt) {
		this.rgt = rgt;
	}
	
	
}
