package com.shtoone.qms.entity.bhz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**   
 * @Title: Entity
 * @Description: 混凝土超标视图
 * @author zhangdaihao
 * @date 2015-06-19 14:37:11
 * @version V1.0   
 *
 */
@Entity
@Table(name = "HunnintuchaobiaoView", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class HunnintuchaobiaoViewEntity implements java.io.Serializable {
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
	/**yuanchuliaoshijian*/
	private java.lang.String yuanchuliaoshijian;
	/**caijiyanshi*/
	private java.lang.String caijiyanshi;
	/**shangchuanyanshi*/
	private java.lang.String shangchuanyanshi;
	/**changstate*/
	private java.lang.String changstate;
	/**glw1*/
	private java.lang.String glw1;
	/**glw2*/
	private java.lang.String glw2;
	/**glw3*/
	private java.lang.String glw3;
	/**glw4*/
	private java.lang.String glw4;
	/**glw5*/
	private java.lang.String glw5;
	/**flw1*/
	private java.lang.String flw1;
	/**flw2*/
	private java.lang.String flw2;
	/**flw3*/
	private java.lang.String flw3;
	/**flw4*/
	private java.lang.String flw4;
	/**flw5*/
	private java.lang.String flw5;
	/**flw6*/
	private java.lang.String flw6;
	/**shw1*/
	private java.lang.String shw1;
	/**shw2*/
	private java.lang.String shw2;
	/**wjw1*/
	private java.lang.String wjw1;
	/**wjw2*/
	private java.lang.String wjw2;
	/**wjw3*/
	private java.lang.String wjw3;
	/**wjw4*/
	private java.lang.String wjw4;
	/**glper1*/
	private java.lang.String glper1;
	/**glper2*/
	private java.lang.String glper2;
	/**glper3*/
	private java.lang.String glper3;
	/**glper4*/
	private java.lang.String glper4;
	/**glper5*/
	private java.lang.String glper5;
	/**flper1*/
	private java.lang.String flper1;
	/**flper2*/
	private java.lang.String flper2;
	/**flper3*/
	private java.lang.String flper3;
	/**flper4*/
	private java.lang.String flper4;
	/**flper5*/
	private java.lang.String flper5;
	/**flper6*/
	private java.lang.String flper6;
	/**shper1*/
	private java.lang.String shper1;
	/**shper2*/
	private java.lang.String shper2;
	/**wjper1*/
	private java.lang.String wjper1;
	/**wjper2*/
	private java.lang.String wjper2;
	/**wjper3*/
	private java.lang.String wjper3;
	/**wjper4*/
	private java.lang.String wjper4;
	/**departid*/
	private java.lang.String departid;
	/**banhezhanminchen*/
	private java.lang.String banhezhanminchen;
	/**panshu*/
	private java.lang.String panshu;
	/**smsbaojin*/
	private java.lang.String smsbaojin;
	/**smstype*/
	private java.lang.String smstype;
	/**sendtype*/
	private java.lang.String sendtype;
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
	/**jianchen*/
	private java.lang.String jianchen;
	/**jieguobianhao*/
	private java.lang.String jieguobianhao;
	/**cbjiaobanshijian*/
	private java.lang.String cbjiaobanshijian;
	/**cbsha1_shijizhi*/
	private java.lang.String cbsha1_shijizhi;
	/**cbshi1_shijizhi*/
	private java.lang.String cbshi1_shijizhi;
	/**cbshi2_shijizhi*/
	private java.lang.String cbshi2_shijizhi;
	/**cbsha2_shijizhi*/
	private java.lang.String cbsha2_shijizhi;
	/**cbguliao5_shijizhi*/
	private java.lang.String cbguliao5_shijizhi;
	/**cbshuini1_shijizhi*/
	private java.lang.String cbshuini1_shijizhi;
	/**cbshuini2_shijizhi*/
	private java.lang.String cbshuini2_shijizhi;
	/**cbkuangfen3_shijizhi*/
	private java.lang.String cbkuangfen3_shijizhi;
	/**cbfeimeihui4_shijizhi*/
	private java.lang.String cbfeimeihui4_shijizhi;
	/**cbfenliao5_shijizhi*/
	private java.lang.String cbfenliao5_shijizhi;
	/**cbfenliao6_shijizhi*/
	private java.lang.String cbfenliao6_shijizhi;
	/**cbshui1_shijizhi*/
	private java.lang.String cbshui1_shijizhi;
	/**cbshui2_shijizhi*/
	private java.lang.String cbshui2_shijizhi;
	/**cbwaijiaji1_shijizhi*/
	private java.lang.String cbwaijiaji1_shijizhi;
	/**cbwaijiaji2_shijizhi*/
	private java.lang.String cbwaijiaji2_shijizhi;
	/**cbwaijiaji3_shijizhi*/
	private java.lang.String cbwaijiaji3_shijizhi;
	/**cbwaijiaji4_shijizhi*/
	private java.lang.String cbwaijiaji4_shijizhi;
	/**leixing*/
	private java.lang.String leixing;
	/**filepath*/
	private java.lang.String filepath;
	/**chulijieguo*/
	private java.lang.String chulijieguo;
	
	private String wentiyuanyin;
	private String chulishijian;
	private String chulifangshi;
	private String confirmdate;
	private String jianliresult;
	private String jianlishenpi;
	private String shenpidate;
	private String chuliren;
	private String shenpiren;
	
	public String getWentiyuanyin() {
		return wentiyuanyin;
	}

	public void setWentiyuanyin(String wentiyuanyin) {
		this.wentiyuanyin = wentiyuanyin;
	}

	public String getChulishijian() {
		return chulishijian;
	}

	public void setChulishijian(String chulishijian) {
		this.chulishijian = chulishijian;
	}

	public String getChulifangshi() {
		return chulifangshi;
	}

	public void setChulifangshi(String chulifangshi) {
		this.chulifangshi = chulifangshi;
	}

	public String getConfirmdate() {
		return confirmdate;
	}

	public void setConfirmdate(String confirmdate) {
		this.confirmdate = confirmdate;
	}

	public String getJianliresult() {
		return jianliresult;
	}

	public void setJianliresult(String jianliresult) {
		this.jianliresult = jianliresult;
	}

	public String getJianlishenpi() {
		return jianlishenpi;
	}

	public void setJianlishenpi(String jianlishenpi) {
		this.jianlishenpi = jianlishenpi;
	}

	public String getShenpidate() {
		return shenpidate;
	}

	public void setShenpidate(String shenpidate) {
		this.shenpidate = shenpidate;
	}

	public String getChuliren() {
		return chuliren;
	}

	public void setChuliren(String chuliren) {
		this.chuliren = chuliren;
	}

	public String getShenpiren() {
		return shenpiren;
	}

	public void setShenpiren(String shenpiren) {
		this.shenpiren = shenpiren;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID",nullable=true,precision=19,scale=0,length=8)
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
	@Column(name ="GONGDANHAO",nullable=true,precision=255,length=510)
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
	@Column(name ="CHAOZUOZHE",nullable=true,precision=255,length=510)
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
	@Column(name ="SHA1_SHIJIZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="SHI1_SHIJIZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="SHI2_SHIJIZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="SHA2_SHIJIZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="GULIAO5_SHIJIZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="SHUINI1_SHIJIZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="SHUINI2_SHIJIZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="KUANGFEN3_SHIJIZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="FEIMEIHUI4_SHIJIZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="FENLIAO5_SHIJIZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="FENLIAO6_SHIJIZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="SHUI1_SHIJIZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="SHUI2_SHIJIZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="WAIJIAJI1_SHIJIZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="WAIJIAJI2_SHIJIZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="WAIJIAJI3_SHIJIZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="WAIJIAJI4_SHIJIZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="CHULIAOSHIJIAN",nullable=true,precision=255,length=510)
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
	@Column(name ="SHA1_LILUNZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="SHI1_LILUNZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="SHI2_LILUNZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="SHA2_LILUNZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="GULIAO5_LILUNZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="SHUINI1_LILUNZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="SHUINI2_LILUNZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="KUANGFEN3_LILUNZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="FEIMEIHUI4_LILUNZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="FENLIAO5_LILUNZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="FENLIAO6_LILUNZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="SHUI1_LILUNZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="SHUI2_LILUNZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="WAIJIAJI1_LILUNZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="WAIJIAJI2_LILUNZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="WAIJIAJI3_LILUNZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="WAIJIAJI4_LILUNZHI",nullable=true,precision=255,length=510)
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
	@Column(name ="GONGCHENGMINGCHENG",nullable=true,precision=255,length=510)
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
	@Column(name ="SIGONGDIDIAN",nullable=true,precision=255,length=510)
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
	@Column(name ="JIAOZUOBUWEI",nullable=true,precision=255,length=510)
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
	@Column(name ="SHUINIPINGZHONG",nullable=true,precision=255,length=510)
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
	@Column(name ="WAIJIAJIPINGZHONG",nullable=true,precision=255,length=510)
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
	@Column(name ="PEIFANGHAO",nullable=true,precision=255,length=510)
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
	@Column(name ="QIANGDUDENGJI",nullable=true,precision=255,length=510)
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
	@Column(name ="JIAOBANSHIJIAN",nullable=true,precision=255,length=510)
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
	@Column(name ="SHEBEIBIANHAO",nullable=true,precision=255,length=510)
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
	@Column(name ="BAOCUNSHIJIAN",nullable=true,precision=255,length=510)
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
	@Column(name ="KEHUDUANBIANHAO",nullable=true,precision=255,length=510)
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
	@Column(name ="BIAOSHI",nullable=true,precision=255,length=510)
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
	@Column(name ="CAIJISHIJIAN",nullable=true,precision=255,length=510)
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
	@Column(name ="GUJIFANGSHU",nullable=true,precision=255,length=510)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  yuanchuliaoshijian
	 */
	@Column(name ="YUANCHULIAOSHIJIAN",nullable=true,precision=255,length=510)
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
	 *@return: java.lang.String  caijiyanshi
	 */
	@Column(name ="CAIJIYANSHI",nullable=true,precision=255,length=510)
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
	 *@return: java.lang.String  shangchuanyanshi
	 */
	@Column(name ="SHANGCHUANYANSHI",nullable=true,precision=255,length=510)
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
	 *@return: java.lang.String  changstate
	 */
	@Column(name ="CHANGSTATE",nullable=true,precision=255,length=510)
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
	 *@return: java.lang.String  glw1
	 */
	@Column(name ="GLW1",nullable=true,precision=255,length=510)
	public java.lang.String getGlw1(){
		return this.glw1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  glw1
	 */
	public void setGlw1(java.lang.String glw1){
		this.glw1 = glw1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  glw2
	 */
	@Column(name ="GLW2",nullable=true,precision=255,length=510)
	public java.lang.String getGlw2(){
		return this.glw2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  glw2
	 */
	public void setGlw2(java.lang.String glw2){
		this.glw2 = glw2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  glw3
	 */
	@Column(name ="GLW3",nullable=true,precision=255,length=510)
	public java.lang.String getGlw3(){
		return this.glw3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  glw3
	 */
	public void setGlw3(java.lang.String glw3){
		this.glw3 = glw3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  glw4
	 */
	@Column(name ="GLW4",nullable=true,precision=255,length=510)
	public java.lang.String getGlw4(){
		return this.glw4;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  glw4
	 */
	public void setGlw4(java.lang.String glw4){
		this.glw4 = glw4;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  glw5
	 */
	@Column(name ="GLW5",nullable=true,precision=255,length=510)
	public java.lang.String getGlw5(){
		return this.glw5;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  glw5
	 */
	public void setGlw5(java.lang.String glw5){
		this.glw5 = glw5;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  flw1
	 */
	@Column(name ="FLW1",nullable=true,precision=255,length=510)
	public java.lang.String getFlw1(){
		return this.flw1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  flw1
	 */
	public void setFlw1(java.lang.String flw1){
		this.flw1 = flw1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  flw2
	 */
	@Column(name ="FLW2",nullable=true,precision=255,length=510)
	public java.lang.String getFlw2(){
		return this.flw2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  flw2
	 */
	public void setFlw2(java.lang.String flw2){
		this.flw2 = flw2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  flw3
	 */
	@Column(name ="FLW3",nullable=true,precision=255,length=510)
	public java.lang.String getFlw3(){
		return this.flw3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  flw3
	 */
	public void setFlw3(java.lang.String flw3){
		this.flw3 = flw3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  flw4
	 */
	@Column(name ="FLW4",nullable=true,precision=255,length=510)
	public java.lang.String getFlw4(){
		return this.flw4;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  flw4
	 */
	public void setFlw4(java.lang.String flw4){
		this.flw4 = flw4;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  flw5
	 */
	@Column(name ="FLW5",nullable=true,precision=255,length=510)
	public java.lang.String getFlw5(){
		return this.flw5;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  flw5
	 */
	public void setFlw5(java.lang.String flw5){
		this.flw5 = flw5;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  flw6
	 */
	@Column(name ="FLW6",nullable=true,precision=255,length=510)
	public java.lang.String getFlw6(){
		return this.flw6;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  flw6
	 */
	public void setFlw6(java.lang.String flw6){
		this.flw6 = flw6;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shw1
	 */
	@Column(name ="SHW1",nullable=true,precision=255,length=510)
	public java.lang.String getShw1(){
		return this.shw1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shw1
	 */
	public void setShw1(java.lang.String shw1){
		this.shw1 = shw1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shw2
	 */
	@Column(name ="SHW2",nullable=true,precision=255,length=510)
	public java.lang.String getShw2(){
		return this.shw2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shw2
	 */
	public void setShw2(java.lang.String shw2){
		this.shw2 = shw2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  wjw1
	 */
	@Column(name ="WJW1",nullable=true,precision=255,length=510)
	public java.lang.String getWjw1(){
		return this.wjw1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  wjw1
	 */
	public void setWjw1(java.lang.String wjw1){
		this.wjw1 = wjw1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  wjw2
	 */
	@Column(name ="WJW2",nullable=true,precision=255,length=510)
	public java.lang.String getWjw2(){
		return this.wjw2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  wjw2
	 */
	public void setWjw2(java.lang.String wjw2){
		this.wjw2 = wjw2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  wjw3
	 */
	@Column(name ="WJW3",nullable=true,precision=255,length=510)
	public java.lang.String getWjw3(){
		return this.wjw3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  wjw3
	 */
	public void setWjw3(java.lang.String wjw3){
		this.wjw3 = wjw3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  wjw4
	 */
	@Column(name ="WJW4",nullable=true,precision=255,length=510)
	public java.lang.String getWjw4(){
		return this.wjw4;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  wjw4
	 */
	public void setWjw4(java.lang.String wjw4){
		this.wjw4 = wjw4;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  glper1
	 */
	@Column(name ="GLPER1",nullable=true,precision=255,length=510)
	public java.lang.String getGlper1(){
		return this.glper1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  glper1
	 */
	public void setGlper1(java.lang.String glper1){
		this.glper1 = glper1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  glper2
	 */
	@Column(name ="GLPER2",nullable=true,precision=255,length=510)
	public java.lang.String getGlper2(){
		return this.glper2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  glper2
	 */
	public void setGlper2(java.lang.String glper2){
		this.glper2 = glper2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  glper3
	 */
	@Column(name ="GLPER3",nullable=true,precision=255,length=510)
	public java.lang.String getGlper3(){
		return this.glper3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  glper3
	 */
	public void setGlper3(java.lang.String glper3){
		this.glper3 = glper3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  glper4
	 */
	@Column(name ="GLPER4",nullable=true,precision=255,length=510)
	public java.lang.String getGlper4(){
		return this.glper4;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  glper4
	 */
	public void setGlper4(java.lang.String glper4){
		this.glper4 = glper4;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  glper5
	 */
	@Column(name ="GLPER5",nullable=true,precision=255,length=510)
	public java.lang.String getGlper5(){
		return this.glper5;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  glper5
	 */
	public void setGlper5(java.lang.String glper5){
		this.glper5 = glper5;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  flper1
	 */
	@Column(name ="FLPER1",nullable=true,precision=255,length=510)
	public java.lang.String getFlper1(){
		return this.flper1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  flper1
	 */
	public void setFlper1(java.lang.String flper1){
		this.flper1 = flper1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  flper2
	 */
	@Column(name ="FLPER2",nullable=true,precision=255,length=510)
	public java.lang.String getFlper2(){
		return this.flper2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  flper2
	 */
	public void setFlper2(java.lang.String flper2){
		this.flper2 = flper2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  flper3
	 */
	@Column(name ="FLPER3",nullable=true,precision=255,length=510)
	public java.lang.String getFlper3(){
		return this.flper3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  flper3
	 */
	public void setFlper3(java.lang.String flper3){
		this.flper3 = flper3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  flper4
	 */
	@Column(name ="FLPER4",nullable=true,precision=255,length=510)
	public java.lang.String getFlper4(){
		return this.flper4;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  flper4
	 */
	public void setFlper4(java.lang.String flper4){
		this.flper4 = flper4;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  flper5
	 */
	@Column(name ="FLPER5",nullable=true,precision=255,length=510)
	public java.lang.String getFlper5(){
		return this.flper5;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  flper5
	 */
	public void setFlper5(java.lang.String flper5){
		this.flper5 = flper5;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  flper6
	 */
	@Column(name ="FLPER6",nullable=true,precision=255,length=510)
	public java.lang.String getFlper6(){
		return this.flper6;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  flper6
	 */
	public void setFlper6(java.lang.String flper6){
		this.flper6 = flper6;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shper1
	 */
	@Column(name ="SHPER1",nullable=true,precision=255,length=510)
	public java.lang.String getShper1(){
		return this.shper1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shper1
	 */
	public void setShper1(java.lang.String shper1){
		this.shper1 = shper1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shper2
	 */
	@Column(name ="SHPER2",nullable=true,precision=255,length=510)
	public java.lang.String getShper2(){
		return this.shper2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shper2
	 */
	public void setShper2(java.lang.String shper2){
		this.shper2 = shper2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  wjper1
	 */
	@Column(name ="WJPER1",nullable=true,precision=255,length=510)
	public java.lang.String getWjper1(){
		return this.wjper1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  wjper1
	 */
	public void setWjper1(java.lang.String wjper1){
		this.wjper1 = wjper1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  wjper2
	 */
	@Column(name ="WJPER2",nullable=true,precision=255,length=510)
	public java.lang.String getWjper2(){
		return this.wjper2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  wjper2
	 */
	public void setWjper2(java.lang.String wjper2){
		this.wjper2 = wjper2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  wjper3
	 */
	@Column(name ="WJPER3",nullable=true,precision=255,length=510)
	public java.lang.String getWjper3(){
		return this.wjper3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  wjper3
	 */
	public void setWjper3(java.lang.String wjper3){
		this.wjper3 = wjper3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  wjper4
	 */
	@Column(name ="WJPER4",nullable=true,precision=255,length=510)
	public java.lang.String getWjper4(){
		return this.wjper4;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  wjper4
	 */
	public void setWjper4(java.lang.String wjper4){
		this.wjper4 = wjper4;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  departid
	 */
	@Column(name ="DEPARTID",nullable=true,precision=255,length=510)
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
	 *@return: java.lang.String  banhezhanminchen
	 */
	@Column(name ="BANHEZHANMINCHEN",nullable=true,precision=255,length=510)
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
	 *@return: java.lang.String  panshu
	 */
	@Column(name ="PANSHU",nullable=true,precision=255,length=510)
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
	 *@return: java.lang.String  smsbaojin
	 */
	@Column(name ="SMSBAOJIN",nullable=true,precision=255,length=510)
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
	@Column(name ="SMSTYPE",nullable=true,precision=255,length=510)
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
	@Column(name ="SENDTYPE",nullable=true,precision=255,length=510)
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
	 *@return: java.lang.String  ambegin
	 */
	@Column(name ="AMBEGIN",nullable=true,precision=255,length=510)
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
	@Column(name ="AMEND",nullable=true,precision=255,length=510)
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
	@Column(name ="PMBEGIN",nullable=true,precision=255,length=510)
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
	@Column(name ="PMEND",nullable=true,precision=255,length=510)
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
	@Column(name ="SMSSETTYPE",nullable=true,precision=255,length=510)
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
	 *@return: java.lang.String  jianchen
	 */
	@Column(name ="JIANCHEN",nullable=true,precision=255,length=510)
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
	 *@return: java.lang.String  jieguobianhao
	 */
	@Column(name ="JIEGUOBIANHAO",nullable=true,precision=255,length=510)
	public java.lang.String getJieguobianhao(){
		return this.jieguobianhao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  jieguobianhao
	 */
	public void setJieguobianhao(java.lang.String jieguobianhao){
		this.jieguobianhao = jieguobianhao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cbjiaobanshijian
	 */
	@Column(name ="CBJIAOBANSHIJIAN",nullable=true,precision=255,length=510)
	public java.lang.String getCbjiaobanshijian(){
		return this.cbjiaobanshijian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cbjiaobanshijian
	 */
	public void setCbjiaobanshijian(java.lang.String cbjiaobanshijian){
		this.cbjiaobanshijian = cbjiaobanshijian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cbsha1_shijizhi
	 */
	@Column(name ="CBSHA1_SHIJIZHI",nullable=true,precision=255,length=510)
	public java.lang.String getCbsha1_shijizhi(){
		return this.cbsha1_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cbsha1_shijizhi
	 */
	public void setCbsha1_shijizhi(java.lang.String cbsha1_shijizhi){
		this.cbsha1_shijizhi = cbsha1_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cbshi1_shijizhi
	 */
	@Column(name ="CBSHI1_SHIJIZHI",nullable=true,precision=255,length=510)
	public java.lang.String getCbshi1_shijizhi(){
		return this.cbshi1_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cbshi1_shijizhi
	 */
	public void setCbshi1_shijizhi(java.lang.String cbshi1_shijizhi){
		this.cbshi1_shijizhi = cbshi1_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cbshi2_shijizhi
	 */
	@Column(name ="CBSHI2_SHIJIZHI",nullable=true,precision=255,length=510)
	public java.lang.String getCbshi2_shijizhi(){
		return this.cbshi2_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cbshi2_shijizhi
	 */
	public void setCbshi2_shijizhi(java.lang.String cbshi2_shijizhi){
		this.cbshi2_shijizhi = cbshi2_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cbsha2_shijizhi
	 */
	@Column(name ="CBSHA2_SHIJIZHI",nullable=true,precision=255,length=510)
	public java.lang.String getCbsha2_shijizhi(){
		return this.cbsha2_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cbsha2_shijizhi
	 */
	public void setCbsha2_shijizhi(java.lang.String cbsha2_shijizhi){
		this.cbsha2_shijizhi = cbsha2_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cbguliao5_shijizhi
	 */
	@Column(name ="CBGULIAO5_SHIJIZHI",nullable=true,precision=255,length=510)
	public java.lang.String getCbguliao5_shijizhi(){
		return this.cbguliao5_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cbguliao5_shijizhi
	 */
	public void setCbguliao5_shijizhi(java.lang.String cbguliao5_shijizhi){
		this.cbguliao5_shijizhi = cbguliao5_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cbshuini1_shijizhi
	 */
	@Column(name ="CBSHUINI1_SHIJIZHI",nullable=true,precision=255,length=510)
	public java.lang.String getCbshuini1_shijizhi(){
		return this.cbshuini1_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cbshuini1_shijizhi
	 */
	public void setCbshuini1_shijizhi(java.lang.String cbshuini1_shijizhi){
		this.cbshuini1_shijizhi = cbshuini1_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cbshuini2_shijizhi
	 */
	@Column(name ="CBSHUINI2_SHIJIZHI",nullable=true,precision=255,length=510)
	public java.lang.String getCbshuini2_shijizhi(){
		return this.cbshuini2_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cbshuini2_shijizhi
	 */
	public void setCbshuini2_shijizhi(java.lang.String cbshuini2_shijizhi){
		this.cbshuini2_shijizhi = cbshuini2_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cbkuangfen3_shijizhi
	 */
	@Column(name ="CBKUANGFEN3_SHIJIZHI",nullable=true,precision=255,length=510)
	public java.lang.String getCbkuangfen3_shijizhi(){
		return this.cbkuangfen3_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cbkuangfen3_shijizhi
	 */
	public void setCbkuangfen3_shijizhi(java.lang.String cbkuangfen3_shijizhi){
		this.cbkuangfen3_shijizhi = cbkuangfen3_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cbfeimeihui4_shijizhi
	 */
	@Column(name ="CBFEIMEIHUI4_SHIJIZHI",nullable=true,precision=255,length=510)
	public java.lang.String getCbfeimeihui4_shijizhi(){
		return this.cbfeimeihui4_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cbfeimeihui4_shijizhi
	 */
	public void setCbfeimeihui4_shijizhi(java.lang.String cbfeimeihui4_shijizhi){
		this.cbfeimeihui4_shijizhi = cbfeimeihui4_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cbfenliao5_shijizhi
	 */
	@Column(name ="CBFENLIAO5_SHIJIZHI",nullable=true,precision=255,length=510)
	public java.lang.String getCbfenliao5_shijizhi(){
		return this.cbfenliao5_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cbfenliao5_shijizhi
	 */
	public void setCbfenliao5_shijizhi(java.lang.String cbfenliao5_shijizhi){
		this.cbfenliao5_shijizhi = cbfenliao5_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cbfenliao6_shijizhi
	 */
	@Column(name ="CBFENLIAO6_SHIJIZHI",nullable=true,precision=255,length=510)
	public java.lang.String getCbfenliao6_shijizhi(){
		return this.cbfenliao6_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cbfenliao6_shijizhi
	 */
	public void setCbfenliao6_shijizhi(java.lang.String cbfenliao6_shijizhi){
		this.cbfenliao6_shijizhi = cbfenliao6_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cbshui1_shijizhi
	 */
	@Column(name ="CBSHUI1_SHIJIZHI",nullable=true,precision=255,length=510)
	public java.lang.String getCbshui1_shijizhi(){
		return this.cbshui1_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cbshui1_shijizhi
	 */
	public void setCbshui1_shijizhi(java.lang.String cbshui1_shijizhi){
		this.cbshui1_shijizhi = cbshui1_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cbshui2_shijizhi
	 */
	@Column(name ="CBSHUI2_SHIJIZHI",nullable=true,precision=255,length=510)
	public java.lang.String getCbshui2_shijizhi(){
		return this.cbshui2_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cbshui2_shijizhi
	 */
	public void setCbshui2_shijizhi(java.lang.String cbshui2_shijizhi){
		this.cbshui2_shijizhi = cbshui2_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cbwaijiaji1_shijizhi
	 */
	@Column(name ="CBWAIJIAJI1_SHIJIZHI",nullable=true,precision=255,length=510)
	public java.lang.String getCbwaijiaji1_shijizhi(){
		return this.cbwaijiaji1_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cbwaijiaji1_shijizhi
	 */
	public void setCbwaijiaji1_shijizhi(java.lang.String cbwaijiaji1_shijizhi){
		this.cbwaijiaji1_shijizhi = cbwaijiaji1_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cbwaijiaji2_shijizhi
	 */
	@Column(name ="CBWAIJIAJI2_SHIJIZHI",nullable=true,precision=255,length=510)
	public java.lang.String getCbwaijiaji2_shijizhi(){
		return this.cbwaijiaji2_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cbwaijiaji2_shijizhi
	 */
	public void setCbwaijiaji2_shijizhi(java.lang.String cbwaijiaji2_shijizhi){
		this.cbwaijiaji2_shijizhi = cbwaijiaji2_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cbwaijiaji3_shijizhi
	 */
	@Column(name ="CBWAIJIAJI3_SHIJIZHI",nullable=true,precision=255,length=510)
	public java.lang.String getCbwaijiaji3_shijizhi(){
		return this.cbwaijiaji3_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cbwaijiaji3_shijizhi
	 */
	public void setCbwaijiaji3_shijizhi(java.lang.String cbwaijiaji3_shijizhi){
		this.cbwaijiaji3_shijizhi = cbwaijiaji3_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cbwaijiaji4_shijizhi
	 */
	@Column(name ="CBWAIJIAJI4_SHIJIZHI",nullable=true,precision=255,length=510)
	public java.lang.String getCbwaijiaji4_shijizhi(){
		return this.cbwaijiaji4_shijizhi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cbwaijiaji4_shijizhi
	 */
	public void setCbwaijiaji4_shijizhi(java.lang.String cbwaijiaji4_shijizhi){
		this.cbwaijiaji4_shijizhi = cbwaijiaji4_shijizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  leixing
	 */
	@Column(name ="LEIXING",nullable=true,precision=255,length=510)
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
	 *@return: java.lang.String  filepath
	 */
	@Column(name ="FILEPATH",nullable=true,precision=255,length=510)
	public java.lang.String getFilepath(){
		return this.filepath;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  filepath
	 */
	public void setFilepath(java.lang.String filepath){
		this.filepath = filepath;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chulijieguo
	 */
	@Column(name ="CHULIJIEGUO",nullable=true,precision=255,length=510)
	public java.lang.String getChulijieguo(){
		return this.chulijieguo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  chulijieguo
	 */
	public void setChulijieguo(java.lang.String chulijieguo){
		this.chulijieguo = chulijieguo;
	}
}
