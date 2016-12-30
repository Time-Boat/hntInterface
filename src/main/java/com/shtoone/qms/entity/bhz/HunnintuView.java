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
@Table(name = "HunnintuView", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class HunnintuView implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**gongdanhao*/
	private java.lang.String gongdanhao;
	/**chaozuozhe*/
	private java.lang.String chaozuozhe;
	/**sha1_shijizhi*/
	private java.lang.String sha1_shijizhi;
	/**shi1_shijizhi*/
	private java.lang.String shi1_shijizhi;
	/**shi2_shijizhi*/
	private java.lang.String shi2_shijizhi;
	/**sha2_shijizhi*/
	private java.lang.String sha2_shijizhi;
	/**guliao5_shijizhi*/
	private java.lang.String guliao5_shijizhi;
	/**shuini1_shijizhi*/
	private java.lang.String shuini1_shijizhi;
	/**shuini2_shijizhi*/
	private java.lang.String shuini2_shijizhi;
	/**kuangfen3_shijizhi*/
	private java.lang.String kuangfen3_shijizhi;
	/**feimeihui4_shijizhi*/
	private java.lang.String feimeihui4_shijizhi;
	/**fenliao5_shijizhi*/
	private java.lang.String fenliao5_shijizhi;
	/**fenliao6_shijizhi*/
	private java.lang.String fenliao6_shijizhi;
	/**shui1_shijizhi*/
	private java.lang.String shui1_shijizhi;
	/**shui2_shijizhi*/
	private java.lang.String shui2_shijizhi;
	/**waijiaji1_shijizhi*/
	private java.lang.String waijiaji1_shijizhi;
	/**waijiaji2_shijizhi*/
	private java.lang.String waijiaji2_shijizhi;
	/**waijiaji3_shijizhi*/
	private java.lang.String waijiaji3_shijizhi;
	/**waijiaji4_shijizhi*/
	private java.lang.String waijiaji4_shijizhi;
	/**chuliaoshijian*/
	private java.lang.String chuliaoshijian;
	/**sha1_lilunzhi*/
	private java.lang.String sha1_lilunzhi;
	/**shi1_lilunzhi*/
	private java.lang.String shi1_lilunzhi;
	/**shi2_lilunzhi*/
	private java.lang.String shi2_lilunzhi;
	/**sha2_lilunzhi*/
	private java.lang.String sha2_lilunzhi;
	/**guliao5_lilunzhi*/
	private java.lang.String guliao5_lilunzhi;
	/**shuini1_lilunzhi*/
	private java.lang.String shuini1_lilunzhi;
	/**shuini2_lilunzhi*/
	private java.lang.String shuini2_lilunzhi;
	/**kuangfen3_lilunzhi*/
	private java.lang.String kuangfen3_lilunzhi;
	/**feimeihui4_lilunzhi*/
	private java.lang.String feimeihui4_lilunzhi;
	/**fenliao5_lilunzhi*/
	private java.lang.String fenliao5_lilunzhi;
	/**fenliao6_lilunzhi*/
	private java.lang.String fenliao6_lilunzhi;
	/**shui1_lilunzhi*/
	private java.lang.String shui1_lilunzhi;
	/**shui2_lilunzhi*/
	private java.lang.String shui2_lilunzhi;
	/**waijiaji1_lilunzhi*/
	private java.lang.String waijiaji1_lilunzhi;
	/**waijiaji2_lilunzhi*/
	private java.lang.String waijiaji2_lilunzhi;
	/**waijiaji3_lilunzhi*/
	private java.lang.String waijiaji3_lilunzhi;
	/**waijiaji4_lilunzhi*/
	private java.lang.String waijiaji4_lilunzhi;
	/**gongchengmingcheng*/
	private java.lang.String gongchengmingcheng;
	/**sigongdidian*/
	private java.lang.String sigongdidian;
	/**jiaozuobuwei*/
	private java.lang.String jiaozuobuwei;
	/**shuinipingzhong*/
	private java.lang.String shuinipingzhong;
	/**waijiajipingzhong*/
	private java.lang.String waijiajipingzhong;
	/**peifanghao*/
	private java.lang.String peifanghao;
	/**qiangdudengji*/
	private java.lang.String qiangdudengji;
	/**jiaobanshijian*/
	private java.lang.String jiaobanshijian;
	/**shebeibianhao*/
	private java.lang.String shebeibianhao;
	/**baocunshijian*/
	private java.lang.String baocunshijian;
	/**kehuduanbianhao*/
	private java.lang.String kehuduanbianhao;
	/**biaoshi*/
	private java.lang.String biaoshi;
	/**caijishijian*/
	private java.lang.String caijishijian;
	/**gujifangshu*/
	private java.lang.String gujifangshu;
	/**bhzid*/
	private java.lang.Integer bhzid;
	/**gprsbianhao*/
	private java.lang.String gprsbianhao;
	/**gprstype*/
	private java.lang.String gprstype;
	/**banhezhanminchen*/
	private java.lang.String banhezhanminchen;
	/**jianchen*/
	private java.lang.String jianchen;
	/**shebeichanjia*/
	private java.lang.String shebeichanjia;
	/**shebeixinghao*/
	private java.lang.String shebeixinghao;
	/**gongkongleixin*/
	private java.lang.String gongkongleixin;
	/**caijiduanruanjianbanben*/
	private java.lang.String caijiduanruanjianbanben;
	/**jiekouleixin*/
	private java.lang.String jiekouleixin;
	/**shujukuleixin*/
	private java.lang.String shujukuleixin;
	/**shuliang*/
	private java.lang.String shuliang;
	/**simhao*/
	private java.lang.String simhao;
	/**simpwd*/
	private java.lang.String simpwd;
	/**botelu*/
	private java.lang.String botelu;
	/**taocan*/
	private java.lang.String taocan;
	/**smsbaojin*/
	private java.lang.String smsbaojin;
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
	/**shebeidizhi*/
	private java.lang.String shebeidizhi;
	/**shebeimianji*/
	private java.lang.String shebeimianji;
	/**caozuoren*/
	private java.lang.String caozuoren;
	/**zhanzhang*/
	private java.lang.String zhanzhang;
	/**lianxidianhua*/
	private java.lang.String lianxidianhua;
	/**shijiangeshi*/
	private java.lang.String shijiangeshi;
	/**orderid*/
	private java.lang.Integer orderid;
	/**departid*/
	private java.lang.String departid;
	/**remark*/
	private java.lang.String remark;
	/**lft*/
	private java.lang.Integer lft;
	/**rgt*/
	private java.lang.Integer rgt;
	/**wjper4*/
	private double wjper4;
	private double wjper3;
	private double wjper2;
	private double wjper1;
	private double shper2;
	private double shper1;
	private double flper6;
	private double flper5;
	private double flper4;
	private double flper3;
	private double flper2;
	private double flper1;
	private double glper5;
	private double glper4;
	private double glper3;
	private double glper2;
	private double glper1;
	private double wjw4;
	private double wjw3;
	private double wjw2;
	private double wjw1;
	private double shw2;
	private double shw1;
	private double flw6;
	private double flw5;
	private double flw4;
	private double flw3;
	private double flw2;
	private double flw1;
	private double glw5;
	private double glw4;
	private double glw3;
	private double glw2;
	private double glw1;
	/**changstate*/
	private java.lang.String changstate;
	/**shangchuanyanshi*/
	private java.lang.String shangchuanyanshi;
	/**caijiyanshi*/
	private java.lang.String caijiyanshi;
	/**yuanchuliaoshijian*/
	private java.lang.String yuanchuliaoshijian;
	/**parentdepartid*/
	private java.lang.String parentdepartid;
	
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  gongdanhao
	 */
	@Column(name ="GONGDANHAO",nullable=true,precision=50,length=50)
	public java.lang.String getGongdanhao(){
		return this.gongdanhao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  gongdanhao
	 */
	public void setGongdanhao(java.lang.String gongdanhao){
		this.gongdanhao = gongdanhao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chaozuozhe
	 */
	@Column(name ="CHAOZUOZHE",nullable=true,precision=50,length=50)
	public java.lang.String getChaozuozhe(){
		return this.chaozuozhe;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  chaozuozhe
	 */
	public void setChaozuozhe(java.lang.String chaozuozhe){
		this.chaozuozhe = chaozuozhe;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sha1_shijizhi
	 */
	@Column(name ="SHA1_SHIJIZHI",nullable=true,precision=50,length=50)
	public java.lang.String getSha1_shijizhi(){
		return this.sha1_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sha1_shijizhi
	 */
	public void setSha1_shijizhi(java.lang.String sha1_shijizhi){
		this.sha1_shijizhi = sha1_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shi1_shijizhi
	 */
	@Column(name ="SHI1_SHIJIZHI",nullable=true,precision=50,length=50)
	public java.lang.String getShi1_shijizhi(){
		return this.shi1_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shi1_shijizhi
	 */
	public void setShi1_shijizhi(java.lang.String shi1_shijizhi){
		this.shi1_shijizhi = shi1_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shi2_shijizhi
	 */
	@Column(name ="SHI2_SHIJIZHI",nullable=true,precision=50,length=50)
	public java.lang.String getShi2_shijizhi(){
		return this.shi2_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shi2_shijizhi
	 */
	public void setShi2_shijizhi(java.lang.String shi2_shijizhi){
		this.shi2_shijizhi = shi2_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sha2_shijizhi
	 */
	@Column(name ="SHA2_SHIJIZHI",nullable=true,precision=50,length=50)
	public java.lang.String getSha2_shijizhi(){
		return this.sha2_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sha2_shijizhi
	 */
	public void setSha2_shijizhi(java.lang.String sha2_shijizhi){
		this.sha2_shijizhi = sha2_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  guliao5_shijizhi
	 */
	@Column(name ="GULIAO5_SHIJIZHI",nullable=true,precision=50,length=50)
	public java.lang.String getGuliao5_shijizhi(){
		return this.guliao5_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  guliao5_shijizhi
	 */
	public void setGuliao5_shijizhi(java.lang.String guliao5_shijizhi){
		this.guliao5_shijizhi = guliao5_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shuini1_shijizhi
	 */
	@Column(name ="SHUINI1_SHIJIZHI",nullable=true,precision=50,length=50)
	public java.lang.String getShuini1_shijizhi(){
		return this.shuini1_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shuini1_shijizhi
	 */
	public void setShuini1_shijizhi(java.lang.String shuini1_shijizhi){
		this.shuini1_shijizhi = shuini1_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shuini2_shijizhi
	 */
	@Column(name ="SHUINI2_SHIJIZHI",nullable=true,precision=50,length=50)
	public java.lang.String getShuini2_shijizhi(){
		return this.shuini2_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shuini2_shijizhi
	 */
	public void setShuini2_shijizhi(java.lang.String shuini2_shijizhi){
		this.shuini2_shijizhi = shuini2_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  kuangfen3_shijizhi
	 */
	@Column(name ="KUANGFEN3_SHIJIZHI",nullable=true,precision=50,length=50)
	public java.lang.String getKuangfen3_shijizhi(){
		return this.kuangfen3_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  kuangfen3_shijizhi
	 */
	public void setKuangfen3_shijizhi(java.lang.String kuangfen3_shijizhi){
		this.kuangfen3_shijizhi = kuangfen3_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  feimeihui4_shijizhi
	 */
	@Column(name ="FEIMEIHUI4_SHIJIZHI",nullable=true,precision=50,length=50)
	public java.lang.String getFeimeihui4_shijizhi(){
		return this.feimeihui4_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  feimeihui4_shijizhi
	 */
	public void setFeimeihui4_shijizhi(java.lang.String feimeihui4_shijizhi){
		this.feimeihui4_shijizhi = feimeihui4_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fenliao5_shijizhi
	 */
	@Column(name ="FENLIAO5_SHIJIZHI",nullable=true,precision=50,length=50)
	public java.lang.String getFenliao5_shijizhi(){
		return this.fenliao5_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fenliao5_shijizhi
	 */
	public void setFenliao5_shijizhi(java.lang.String fenliao5_shijizhi){
		this.fenliao5_shijizhi = fenliao5_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fenliao6_shijizhi
	 */
	@Column(name ="FENLIAO6_SHIJIZHI",nullable=true,precision=50,length=50)
	public java.lang.String getFenliao6_shijizhi(){
		return this.fenliao6_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fenliao6_shijizhi
	 */
	public void setFenliao6_shijizhi(java.lang.String fenliao6_shijizhi){
		this.fenliao6_shijizhi = fenliao6_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shui1_shijizhi
	 */
	@Column(name ="SHUI1_SHIJIZHI",nullable=true,precision=50,length=50)
	public java.lang.String getShui1_shijizhi(){
		return this.shui1_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shui1_shijizhi
	 */
	public void setShui1_shijizhi(java.lang.String shui1_shijizhi){
		this.shui1_shijizhi = shui1_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shui2_shijizhi
	 */
	@Column(name ="SHUI2_SHIJIZHI",nullable=true,precision=50,length=50)
	public java.lang.String getShui2_shijizhi(){
		return this.shui2_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shui2_shijizhi
	 */
	public void setShui2_shijizhi(java.lang.String shui2_shijizhi){
		this.shui2_shijizhi = shui2_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  waijiaji1_shijizhi
	 */
	@Column(name ="WAIJIAJI1_SHIJIZHI",nullable=true,precision=50,length=50)
	public java.lang.String getWaijiaji1_shijizhi(){
		return this.waijiaji1_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  waijiaji1_shijizhi
	 */
	public void setWaijiaji1_shijizhi(java.lang.String waijiaji1_shijizhi){
		this.waijiaji1_shijizhi = waijiaji1_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  waijiaji2_shijizhi
	 */
	@Column(name ="WAIJIAJI2_SHIJIZHI",nullable=true,precision=50,length=50)
	public java.lang.String getWaijiaji2_shijizhi(){
		return this.waijiaji2_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  waijiaji2_shijizhi
	 */
	public void setWaijiaji2_shijizhi(java.lang.String waijiaji2_shijizhi){
		this.waijiaji2_shijizhi = waijiaji2_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  waijiaji3_shijizhi
	 */
	@Column(name ="WAIJIAJI3_SHIJIZHI",nullable=true,precision=50,length=50)
	public java.lang.String getWaijiaji3_shijizhi(){
		return this.waijiaji3_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  waijiaji3_shijizhi
	 */
	public void setWaijiaji3_shijizhi(java.lang.String waijiaji3_shijizhi){
		this.waijiaji3_shijizhi = waijiaji3_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  waijiaji4_shijizhi
	 */
	@Column(name ="WAIJIAJI4_SHIJIZHI",nullable=true,precision=50,length=50)
	public java.lang.String getWaijiaji4_shijizhi(){
		return this.waijiaji4_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  waijiaji4_shijizhi
	 */
	public void setWaijiaji4_shijizhi(java.lang.String waijiaji4_shijizhi){
		this.waijiaji4_shijizhi = waijiaji4_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chuliaoshijian
	 */
	@Column(name ="CHULIAOSHIJIAN",nullable=true,precision=50,length=50)
	public java.lang.String getChuliaoshijian(){
		return this.chuliaoshijian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  chuliaoshijian
	 */
	public void setChuliaoshijian(java.lang.String chuliaoshijian){
		this.chuliaoshijian = chuliaoshijian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sha1_lilunzhi
	 */
	@Column(name ="SHA1_LILUNZHI",nullable=true,precision=50,length=50)
	public java.lang.String getSha1_lilunzhi(){
		return this.sha1_lilunzhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sha1_lilunzhi
	 */
	public void setSha1_lilunzhi(java.lang.String sha1_lilunzhi){
		this.sha1_lilunzhi = sha1_lilunzhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shi1_lilunzhi
	 */
	@Column(name ="SHI1_LILUNZHI",nullable=true,precision=50,length=50)
	public java.lang.String getShi1_lilunzhi(){
		return this.shi1_lilunzhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shi1_lilunzhi
	 */
	public void setShi1_lilunzhi(java.lang.String shi1_lilunzhi){
		this.shi1_lilunzhi = shi1_lilunzhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shi2_lilunzhi
	 */
	@Column(name ="SHI2_LILUNZHI",nullable=true,precision=50,length=50)
	public java.lang.String getShi2_lilunzhi(){
		return this.shi2_lilunzhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shi2_lilunzhi
	 */
	public void setShi2_lilunzhi(java.lang.String shi2_lilunzhi){
		this.shi2_lilunzhi = shi2_lilunzhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sha2_lilunzhi
	 */
	@Column(name ="SHA2_LILUNZHI",nullable=true,precision=50,length=50)
	public java.lang.String getSha2_lilunzhi(){
		return this.sha2_lilunzhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sha2_lilunzhi
	 */
	public void setSha2_lilunzhi(java.lang.String sha2_lilunzhi){
		this.sha2_lilunzhi = sha2_lilunzhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  guliao5_lilunzhi
	 */
	@Column(name ="GULIAO5_LILUNZHI",nullable=true,precision=50,length=50)
	public java.lang.String getGuliao5_lilunzhi(){
		return this.guliao5_lilunzhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  guliao5_lilunzhi
	 */
	public void setGuliao5_lilunzhi(java.lang.String guliao5_lilunzhi){
		this.guliao5_lilunzhi = guliao5_lilunzhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shuini1_lilunzhi
	 */
	@Column(name ="SHUINI1_LILUNZHI",nullable=true,precision=50,length=50)
	public java.lang.String getShuini1_lilunzhi(){
		return this.shuini1_lilunzhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shuini1_lilunzhi
	 */
	public void setShuini1_lilunzhi(java.lang.String shuini1_lilunzhi){
		this.shuini1_lilunzhi = shuini1_lilunzhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shuini2_lilunzhi
	 */
	@Column(name ="SHUINI2_LILUNZHI",nullable=true,precision=50,length=50)
	public java.lang.String getShuini2_lilunzhi(){
		return this.shuini2_lilunzhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shuini2_lilunzhi
	 */
	public void setShuini2_lilunzhi(java.lang.String shuini2_lilunzhi){
		this.shuini2_lilunzhi = shuini2_lilunzhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  kuangfen3_lilunzhi
	 */
	@Column(name ="KUANGFEN3_LILUNZHI",nullable=true,precision=50,length=50)
	public java.lang.String getKuangfen3_lilunzhi(){
		return this.kuangfen3_lilunzhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  kuangfen3_lilunzhi
	 */
	public void setKuangfen3_lilunzhi(java.lang.String kuangfen3_lilunzhi){
		this.kuangfen3_lilunzhi = kuangfen3_lilunzhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  feimeihui4_lilunzhi
	 */
	@Column(name ="FEIMEIHUI4_LILUNZHI",nullable=true,precision=50,length=50)
	public java.lang.String getFeimeihui4_lilunzhi(){
		return this.feimeihui4_lilunzhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  feimeihui4_lilunzhi
	 */
	public void setFeimeihui4_lilunzhi(java.lang.String feimeihui4_lilunzhi){
		this.feimeihui4_lilunzhi = feimeihui4_lilunzhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fenliao5_lilunzhi
	 */
	@Column(name ="FENLIAO5_LILUNZHI",nullable=true,precision=50,length=50)
	public java.lang.String getFenliao5_lilunzhi(){
		return this.fenliao5_lilunzhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fenliao5_lilunzhi
	 */
	public void setFenliao5_lilunzhi(java.lang.String fenliao5_lilunzhi){
		this.fenliao5_lilunzhi = fenliao5_lilunzhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fenliao6_lilunzhi
	 */
	@Column(name ="FENLIAO6_LILUNZHI",nullable=true,precision=50,length=50)
	public java.lang.String getFenliao6_lilunzhi(){
		return this.fenliao6_lilunzhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fenliao6_lilunzhi
	 */
	public void setFenliao6_lilunzhi(java.lang.String fenliao6_lilunzhi){
		this.fenliao6_lilunzhi = fenliao6_lilunzhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shui1_lilunzhi
	 */
	@Column(name ="SHUI1_LILUNZHI",nullable=true,precision=50,length=50)
	public java.lang.String getShui1_lilunzhi(){
		return this.shui1_lilunzhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shui1_lilunzhi
	 */
	public void setShui1_lilunzhi(java.lang.String shui1_lilunzhi){
		this.shui1_lilunzhi = shui1_lilunzhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shui2_lilunzhi
	 */
	@Column(name ="SHUI2_LILUNZHI",nullable=true,precision=50,length=50)
	public java.lang.String getShui2_lilunzhi(){
		return this.shui2_lilunzhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shui2_lilunzhi
	 */
	public void setShui2_lilunzhi(java.lang.String shui2_lilunzhi){
		this.shui2_lilunzhi = shui2_lilunzhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  waijiaji1_lilunzhi
	 */
	@Column(name ="WAIJIAJI1_LILUNZHI",nullable=true,precision=50,length=50)
	public java.lang.String getWaijiaji1_lilunzhi(){
		return this.waijiaji1_lilunzhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  waijiaji1_lilunzhi
	 */
	public void setWaijiaji1_lilunzhi(java.lang.String waijiaji1_lilunzhi){
		this.waijiaji1_lilunzhi = waijiaji1_lilunzhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  waijiaji2_lilunzhi
	 */
	@Column(name ="WAIJIAJI2_LILUNZHI",nullable=true,precision=50,length=50)
	public java.lang.String getWaijiaji2_lilunzhi(){
		return this.waijiaji2_lilunzhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  waijiaji2_lilunzhi
	 */
	public void setWaijiaji2_lilunzhi(java.lang.String waijiaji2_lilunzhi){
		this.waijiaji2_lilunzhi = waijiaji2_lilunzhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  waijiaji3_lilunzhi
	 */
	@Column(name ="WAIJIAJI3_LILUNZHI",nullable=true,precision=50,length=50)
	public java.lang.String getWaijiaji3_lilunzhi(){
		return this.waijiaji3_lilunzhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  waijiaji3_lilunzhi
	 */
	public void setWaijiaji3_lilunzhi(java.lang.String waijiaji3_lilunzhi){
		this.waijiaji3_lilunzhi = waijiaji3_lilunzhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  waijiaji4_lilunzhi
	 */
	@Column(name ="WAIJIAJI4_LILUNZHI",nullable=true,precision=50,length=50)
	public java.lang.String getWaijiaji4_lilunzhi(){
		return this.waijiaji4_lilunzhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  waijiaji4_lilunzhi
	 */
	public void setWaijiaji4_lilunzhi(java.lang.String waijiaji4_lilunzhi){
		this.waijiaji4_lilunzhi = waijiaji4_lilunzhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  gongchengmingcheng
	 */
	@Column(name ="GONGCHENGMINGCHENG",nullable=true,precision=100,length=100)
	public java.lang.String getGongchengmingcheng(){
		return this.gongchengmingcheng;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  gongchengmingcheng
	 */
	public void setGongchengmingcheng(java.lang.String gongchengmingcheng){
		this.gongchengmingcheng = gongchengmingcheng;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sigongdidian
	 */
	@Column(name ="SIGONGDIDIAN",nullable=true,precision=100,length=100)
	public java.lang.String getSigongdidian(){
		return this.sigongdidian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sigongdidian
	 */
	public void setSigongdidian(java.lang.String sigongdidian){
		this.sigongdidian = sigongdidian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  jiaozuobuwei
	 */
	@Column(name ="JIAOZUOBUWEI",nullable=true,precision=100,length=100)
	public java.lang.String getJiaozuobuwei(){
		return this.jiaozuobuwei;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  jiaozuobuwei
	 */
	public void setJiaozuobuwei(java.lang.String jiaozuobuwei){
		this.jiaozuobuwei = jiaozuobuwei;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shuinipingzhong
	 */
	@Column(name ="SHUINIPINGZHONG",nullable=true,precision=50,length=50)
	public java.lang.String getShuinipingzhong(){
		return this.shuinipingzhong;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shuinipingzhong
	 */
	public void setShuinipingzhong(java.lang.String shuinipingzhong){
		this.shuinipingzhong = shuinipingzhong;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  waijiajipingzhong
	 */
	@Column(name ="WAIJIAJIPINGZHONG",nullable=true,precision=50,length=50)
	public java.lang.String getWaijiajipingzhong(){
		return this.waijiajipingzhong;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  waijiajipingzhong
	 */
	public void setWaijiajipingzhong(java.lang.String waijiajipingzhong){
		this.waijiajipingzhong = waijiajipingzhong;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  peifanghao
	 */
	@Column(name ="PEIFANGHAO",nullable=true,precision=50,length=50)
	public java.lang.String getPeifanghao(){
		return this.peifanghao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  peifanghao
	 */
	public void setPeifanghao(java.lang.String peifanghao){
		this.peifanghao = peifanghao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  qiangdudengji
	 */
	@Column(name ="QIANGDUDENGJI",nullable=true,precision=50,length=50)
	public java.lang.String getQiangdudengji(){
		return this.qiangdudengji;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  qiangdudengji
	 */
	public void setQiangdudengji(java.lang.String qiangdudengji){
		this.qiangdudengji = qiangdudengji;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  jiaobanshijian
	 */
	@Column(name ="JIAOBANSHIJIAN",nullable=true,precision=50,length=50)
	public java.lang.String getJiaobanshijian(){
		return this.jiaobanshijian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  jiaobanshijian
	 */
	public void setJiaobanshijian(java.lang.String jiaobanshijian){
		this.jiaobanshijian = jiaobanshijian;
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
	 *@return: java.lang.String  baocunshijian
	 */
	@Column(name ="BAOCUNSHIJIAN",nullable=true,precision=50,length=50)
	public java.lang.String getBaocunshijian(){
		return this.baocunshijian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  baocunshijian
	 */
	public void setBaocunshijian(java.lang.String baocunshijian){
		this.baocunshijian = baocunshijian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  kehuduanbianhao
	 */
	@Column(name ="KEHUDUANBIANHAO",nullable=true,precision=50,length=50)
	public java.lang.String getKehuduanbianhao(){
		return this.kehuduanbianhao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  kehuduanbianhao
	 */
	public void setKehuduanbianhao(java.lang.String kehuduanbianhao){
		this.kehuduanbianhao = kehuduanbianhao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  biaoshi
	 */
	@Column(name ="BIAOSHI",nullable=true,precision=50,length=50)
	public java.lang.String getBiaoshi(){
		return this.biaoshi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  biaoshi
	 */
	public void setBiaoshi(java.lang.String biaoshi){
		this.biaoshi = biaoshi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  caijishijian
	 */
	@Column(name ="CAIJISHIJIAN",nullable=true,precision=50,length=50)
	public java.lang.String getCaijishijian(){
		return this.caijishijian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  caijishijian
	 */
	public void setCaijishijian(java.lang.String caijishijian){
		this.caijishijian = caijishijian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  gujifangshu
	 */
	@Column(name ="GUJIFANGSHU",nullable=true,precision=50,length=50)
	public java.lang.String getGujifangshu(){
		return this.gujifangshu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  gujifangshu
	 */
	public void setGujifangshu(java.lang.String gujifangshu){
		this.gujifangshu = gujifangshu;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  bhzid
	 */
	@Column(name ="BHZID",nullable=false,precision=10,scale=0,length=4)
	public java.lang.Integer getBhzid(){
		return this.bhzid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  bhzid
	 */
	public void setBhzid(java.lang.Integer bhzid){
		this.bhzid = bhzid;
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
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  wjper4
=======
	 *方法: 取得double
	 *@return: double  wjper4
>>>>>>> .r3474
	 */
	@Column(name ="WJPER4",nullable=true,precision=18,scale=3,length=9)
	public double getWjper4(){
		return this.wjper4;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  wjper4
=======
	 *方法: 设置double
	 *@param: double  wjper4
>>>>>>> .r3474
	 */
	public void setWjper4(double wjper4){
		this.wjper4 = wjper4;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  wjper3
=======
	 *方法: 取得double
	 *@return: double  wjper3
>>>>>>> .r3474
	 */
	@Column(name ="WJPER3",nullable=true,precision=18,scale=3,length=9)
	public double getWjper3(){
		return this.wjper3;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  wjper3
=======
	 *方法: 设置double
	 *@param: double  wjper3
>>>>>>> .r3474
	 */
	public void setWjper3(double wjper3){
		this.wjper3 = wjper3;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  wjper2
=======
	 *方法: 取得double
	 *@return: double  wjper2
>>>>>>> .r3474
	 */
	@Column(name ="WJPER2",nullable=true,precision=18,scale=3,length=9)
	public double getWjper2(){
		return this.wjper2;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  wjper2
=======
	 *方法: 设置double
	 *@param: double  wjper2
>>>>>>> .r3474
	 */
	public void setWjper2(double wjper2){
		this.wjper2 = wjper2;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  wjper1
=======
	 *方法: 取得double
	 *@return: double  wjper1
>>>>>>> .r3474
	 */
	@Column(name ="WJPER1",nullable=true,precision=18,scale=3,length=9)
	public double getWjper1(){
		return this.wjper1;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  wjper1
=======
	 *方法: 设置double
	 *@param: double  wjper1
>>>>>>> .r3474
	 */
	public void setWjper1(double wjper1){
		this.wjper1 = wjper1;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  shper2
=======
	 *方法: 取得double
	 *@return: double  shper2
>>>>>>> .r3474
	 */
	@Column(name ="SHPER2",nullable=true,precision=18,scale=3,length=9)
	public double getShper2(){
		return this.shper2;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  shper2
=======
	 *方法: 设置double
	 *@param: double  shper2
>>>>>>> .r3474
	 */
	public void setShper2(double shper2){
		this.shper2 = shper2;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  shper1
=======
	 *方法: 取得double
	 *@return: double  shper1
>>>>>>> .r3474
	 */
	@Column(name ="SHPER1",nullable=true,precision=18,scale=3,length=9)
	public double getShper1(){
		return this.shper1;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  shper1
=======
	 *方法: 设置double
	 *@param: double  shper1
>>>>>>> .r3474
	 */
	public void setShper1(double shper1){
		this.shper1 = shper1;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  flper6
=======
	 *方法: 取得double
	 *@return: double  flper6
>>>>>>> .r3474
	 */
	@Column(name ="FLPER6",nullable=true,precision=18,scale=3,length=9)
	public double getFlper6(){
		return this.flper6;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  flper6
=======
	 *方法: 设置double
	 *@param: double  flper6
>>>>>>> .r3474
	 */
	public void setFlper6(double flper6){
		this.flper6 = flper6;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  flper5
=======
	 *方法: 取得double
	 *@return: double  flper5
>>>>>>> .r3474
	 */
	@Column(name ="FLPER5",nullable=true,precision=18,scale=3,length=9)
	public double getFlper5(){
		return this.flper5;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  flper5
=======
	 *方法: 设置double
	 *@param: double  flper5
>>>>>>> .r3474
	 */
	public void setFlper5(double flper5){
		this.flper5 = flper5;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  flper4
=======
	 *方法: 取得double
	 *@return: double  flper4
>>>>>>> .r3474
	 */
	@Column(name ="FLPER4",nullable=true,precision=18,scale=3,length=9)
	public double getFlper4(){
		return this.flper4;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  flper4
=======
	 *方法: 设置double
	 *@param: double  flper4
>>>>>>> .r3474
	 */
	public void setFlper4(double flper4){
		this.flper4 = flper4;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  flper3
=======
	 *方法: 取得double
	 *@return: double  flper3
>>>>>>> .r3474
	 */
	@Column(name ="FLPER3",nullable=true,precision=18,scale=3,length=9)
	public double getFlper3(){
		return this.flper3;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  flper3
=======
	 *方法: 设置double
	 *@param: double  flper3
>>>>>>> .r3474
	 */
	public void setFlper3(double flper3){
		this.flper3 = flper3;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  flper2
=======
	 *方法: 取得double
	 *@return: double  flper2
>>>>>>> .r3474
	 */
	@Column(name ="FLPER2",nullable=true,precision=18,scale=3,length=9)
	public double getFlper2(){
		return this.flper2;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  flper2
=======
	 *方法: 设置double
	 *@param: double  flper2
>>>>>>> .r3474
	 */
	public void setFlper2(double flper2){
		this.flper2 = flper2;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  flper1
=======
	 *方法: 取得double
	 *@return: double  flper1
>>>>>>> .r3474
	 */
	@Column(name ="FLPER1",nullable=true,precision=18,scale=3,length=9)
	public double getFlper1(){
		return this.flper1;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  flper1
=======
	 *方法: 设置double
	 *@param: double  flper1
>>>>>>> .r3474
	 */
	public void setFlper1(double flper1){
		this.flper1 = flper1;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  glper5
=======
	 *方法: 取得double
	 *@return: double  glper5
>>>>>>> .r3474
	 */
	@Column(name ="GLPER5",nullable=true,precision=18,scale=3,length=9)
	public double getGlper5(){
		return this.glper5;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  glper5
=======
	 *方法: 设置double
	 *@param: double  glper5
>>>>>>> .r3474
	 */
	public void setGlper5(double glper5){
		this.glper5 = glper5;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  glper4
=======
	 *方法: 取得double
	 *@return: double  glper4
>>>>>>> .r3474
	 */
	@Column(name ="GLPER4",nullable=true,precision=18,scale=3,length=9)
	public double getGlper4(){
		return this.glper4;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  glper4
=======
	 *方法: 设置double
	 *@param: double  glper4
>>>>>>> .r3474
	 */
	public void setGlper4(double glper4){
		this.glper4 = glper4;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  glper3
=======
	 *方法: 取得double
	 *@return: double  glper3
>>>>>>> .r3474
	 */
	@Column(name ="GLPER3",nullable=true,precision=18,scale=3,length=9)
	public double getGlper3(){
		return this.glper3;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  glper3
=======
	 *方法: 设置double
	 *@param: double  glper3
>>>>>>> .r3474
	 */
	public void setGlper3(double glper3){
		this.glper3 = glper3;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  glper2
=======
	 *方法: 取得double
	 *@return: double  glper2
>>>>>>> .r3474
	 */
	@Column(name ="GLPER2",nullable=true,precision=18,scale=3,length=9)
	public double getGlper2(){
		return this.glper2;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  glper2
=======
	 *方法: 设置double
	 *@param: double  glper2
>>>>>>> .r3474
	 */
	public void setGlper2(double glper2){
		this.glper2 = glper2;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  glper1
=======
	 *方法: 取得double
	 *@return: double  glper1
>>>>>>> .r3474
	 */
	@Column(name ="GLPER1",nullable=true,precision=18,scale=3,length=9)
	public double getGlper1(){
		return this.glper1;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  glper1
=======
	 *方法: 设置double
	 *@param: double  glper1
>>>>>>> .r3474
	 */
	public void setGlper1(double glper1){
		this.glper1 = glper1;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  wjw4
=======
	 *方法: 取得double
	 *@return: double  wjw4
>>>>>>> .r3474
	 */
	@Column(name ="WJW4",nullable=true,precision=18,scale=3,length=9)
	public double getWjw4(){
		return this.wjw4;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  wjw4
=======
	 *方法: 设置double
	 *@param: double  wjw4
	 */
	public void setWjw4(double wjw4){
		this.wjw4 = wjw4;
	}
	/**
	 *方法: 取得double
	 *@return: double  wjw3
	 */
	@Column(name ="WJW3",nullable=true,precision=18,scale=3,length=9)
	public double getWjw3(){
		return this.wjw3;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  wjw3
=======
	 *方法: 设置double
	 *@param: double  wjw3
>>>>>>> .r3474
	 */
	public void setWjw3(double wjw3){
		this.wjw3 = wjw3;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  wjw2
=======
	 *方法: 取得double
	 *@return: double  wjw2
>>>>>>> .r3474
	 */
	@Column(name ="WJW2",nullable=true,precision=18,scale=3,length=9)
	public double getWjw2(){
		return this.wjw2;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  wjw2
=======
	 *方法: 设置double
	 *@param: double  wjw2
>>>>>>> .r3474
	 */
	public void setWjw2(double wjw2){
		this.wjw2 = wjw2;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  wjw1
=======
	 *方法: 取得double
	 *@return: double  wjw1
>>>>>>> .r3474
	 */
	@Column(name ="WJW1",nullable=true,precision=18,scale=3,length=9)
	public double getWjw1(){
		return this.wjw1;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  wjw1
=======
	 *方法: 设置double
	 *@param: double  wjw1
>>>>>>> .r3474
	 */
	public void setWjw1(double wjw1){
		this.wjw1 = wjw1;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  shw2
=======
	 *方法: 取得double
	 *@return: double  shw2
>>>>>>> .r3474
	 */
	@Column(name ="SHW2",nullable=true,precision=18,scale=3,length=9)
	public double getShw2(){
		return this.shw2;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  shw2
=======
	 *方法: 设置double
	 *@param: double  shw2
>>>>>>> .r3474
	 */
	public void setShw2(double shw2){
		this.shw2 = shw2;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  shw1
=======
	 *方法: 取得double
	 *@return: double  shw1
>>>>>>> .r3474
	 */
	@Column(name ="SHW1",nullable=true,precision=18,scale=3,length=9)
	public double getShw1(){
		return this.shw1;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  shw1
=======
	 *方法: 设置double
	 *@param: double  shw1
>>>>>>> .r3474
	 */
	public void setShw1(double shw1){
		this.shw1 = shw1;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  flw6
=======
	 *方法: 取得double
	 *@return: double  flw6
>>>>>>> .r3474
	 */
	@Column(name ="FLW6",nullable=true,precision=18,scale=3,length=9)
	public double getFlw6(){
		return this.flw6;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  flw6
=======
	 *方法: 设置double
	 *@param: double  flw6
>>>>>>> .r3474
	 */
	public void setFlw6(double flw6){
		this.flw6 = flw6;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  flw5
=======
	 *方法: 取得double
	 *@return: double  flw5
>>>>>>> .r3474
	 */
	@Column(name ="FLW5",nullable=true,precision=18,scale=3,length=9)
	public double getFlw5(){
		return this.flw5;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  flw5
=======
	 *方法: 设置double
	 *@param: double  flw5
>>>>>>> .r3474
	 */
	public void setFlw5(double flw5){
		this.flw5 = flw5;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  flw4
=======
	 *方法: 取得double
	 *@return: double  flw4
>>>>>>> .r3474
	 */
	@Column(name ="FLW4",nullable=true,precision=18,scale=3,length=9)
	public double getFlw4(){
		return this.flw4;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  flw4
=======
	 *方法: 设置double
	 *@param: double  flw4
>>>>>>> .r3474
	 */
	public void setFlw4(double flw4){
		this.flw4 = flw4;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  flw3
=======
	 *方法: 取得double
	 *@return: double  flw3
>>>>>>> .r3474
	 */
	@Column(name ="FLW3",nullable=true,precision=18,scale=3,length=9)
	public double getFlw3(){
		return this.flw3;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  flw3
=======
	 *方法: 设置double
	 *@param: double  flw3
>>>>>>> .r3474
	 */
	public void setFlw3(double flw3){
		this.flw3 = flw3;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  flw2
=======
	 *方法: 取得double
	 *@return: double  flw2
>>>>>>> .r3474
	 */
	@Column(name ="FLW2",nullable=true,precision=18,scale=3,length=9)
	public double getFlw2(){
		return this.flw2;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  flw2
=======
	 *方法: 设置double
	 *@param: double  flw2
>>>>>>> .r3474
	 */
	public void setFlw2(double flw2){
		this.flw2 = flw2;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  flw1
=======
	 *方法: 取得double
	 *@return: double  flw1
>>>>>>> .r3474
	 */
	@Column(name ="FLW1",nullable=true,precision=18,scale=3,length=9)
	public double getFlw1(){
		return this.flw1;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  flw1
=======
	 *方法: 设置double
	 *@param: double  flw1
>>>>>>> .r3474
	 */
	public void setFlw1(double flw1){
		this.flw1 = flw1;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  glw5
=======
	 *方法: 取得double
	 *@return: double  glw5
>>>>>>> .r3474
	 */
	@Column(name ="GLW5",nullable=true,precision=18,scale=3,length=9)
	public double getGlw5(){
		return this.glw5;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  glw5
=======
	 *方法: 设置double
	 *@param: double  glw5
>>>>>>> .r3474
	 */
	public void setGlw5(double glw5){
		this.glw5 = glw5;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  glw4
=======
	 *方法: 取得double
	 *@return: double  glw4
>>>>>>> .r3474
	 */
	@Column(name ="GLW4",nullable=true,precision=18,scale=3,length=9)
	public double getGlw4(){
		return this.glw4;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  glw4
=======
	 *方法: 设置double
	 *@param: double  glw4
>>>>>>> .r3474
	 */
	public void setGlw4(double glw4){
		this.glw4 = glw4;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  glw3
=======
	 *方法: 取得double
	 *@return: double  glw3
>>>>>>> .r3474
	 */
	@Column(name ="GLW3",nullable=true,precision=18,scale=3,length=9)
	public double getGlw3(){
		return this.glw3;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  glw3
=======
	 *方法: 设置double
	 *@param: double  glw3
>>>>>>> .r3474
	 */
	public void setGlw3(double glw3){
		this.glw3 = glw3;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  glw2
=======
	 *方法: 取得double
	 *@return: double  glw2
>>>>>>> .r3474
	 */
	@Column(name ="GLW2",nullable=true,precision=18,scale=3,length=9)
	public double getGlw2(){
		return this.glw2;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  glw2
=======
	 *方法: 设置double
	 *@param: double  glw2
>>>>>>> .r3474
	 */
	public void setGlw2(double glw2){
		this.glw2 = glw2;
	}
	/**
<<<<<<< .mine
	 *方法: 取得double
	 *@return: double  glw1
=======
	 *方法: 取得double
	 *@return: double  glw1
>>>>>>> .r3474
	 */
	@Column(name ="GLW1",nullable=true,precision=18,scale=3,length=9)
	public double getGlw1(){
		return this.glw1;
	}

	/**
<<<<<<< .mine
	 *方法: 设置double
	 *@param: double  glw1
=======
	 *方法: 设置double
	 *@param: double  glw1
>>>>>>> .r3474
	 */
	public void setGlw1(double glw1){
		this.glw1 = glw1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  changstate
	 */
	@Column(name ="CHANGSTATE",nullable=true,precision=50,length=50)
	public java.lang.String getChangstate(){
		return this.changstate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  changstate
	 */
	public void setChangstate(java.lang.String changstate){
		this.changstate = changstate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shangchuanyanshi
	 */
	@Column(name ="SHANGCHUANYANSHI",nullable=true,precision=50,length=50)
	public java.lang.String getShangchuanyanshi(){
		return this.shangchuanyanshi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shangchuanyanshi
	 */
	public void setShangchuanyanshi(java.lang.String shangchuanyanshi){
		this.shangchuanyanshi = shangchuanyanshi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  caijiyanshi
	 */
	@Column(name ="CAIJIYANSHI",nullable=true,precision=50,length=50)
	public java.lang.String getCaijiyanshi(){
		return this.caijiyanshi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  caijiyanshi
	 */
	public void setCaijiyanshi(java.lang.String caijiyanshi){
		this.caijiyanshi = caijiyanshi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  yuanchuliaoshijian
	 */
	@Column(name ="YUANCHULIAOSHIJIAN",nullable=true,precision=50,length=50)
	public java.lang.String getYuanchuliaoshijian(){
		return this.yuanchuliaoshijian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  yuanchuliaoshijian
	 */
	public void setYuanchuliaoshijian(java.lang.String yuanchuliaoshijian){
		this.yuanchuliaoshijian = yuanchuliaoshijian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  parentdepartid
	 */
	@Column(name ="PARENTDEPARTID",nullable=true,precision=50,length=50)
	public java.lang.String getParentdepartid(){
		return this.parentdepartid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  parentdepartid
	 */
	public void setParentdepartid(java.lang.String parentdepartid){
		this.parentdepartid = parentdepartid;
	}
}