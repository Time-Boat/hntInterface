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
@Table(name = "Xiangxixxjieguo", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class XiangxixxjieguoEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
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
	/**jiaobanshijian*/
	private java.lang.String jiaobanshijian;
	/**xinxibianhao*/
	private java.lang.Integer xinxibianhao;
	/**leiji*/
	private java.lang.Integer leiji;
	/**chulijieguo*/
	private java.lang.String chulijieguo;
	/**chuliaoshijian*/
	private java.lang.String chuliaoshijian;
	/**shebeibianhao*/
	private java.lang.String shebeibianhao;
	/**biaoshi*/
	private java.lang.String biaoshi;
	/**fasongcishu*/
	private java.lang.Integer fasongcishu;
	/**leixing*/
	private java.lang.Integer leixing;
	/**wentiyuanyin*/
	private java.lang.String wentiyuanyin;
	/**chulishijian*/
	private java.lang.String chulishijian;
	/**beizhu*/
	private java.lang.String beizhu;
	/**chulifangshi*/
	private java.lang.String chulifangshi;
	/**filepath*/
	private java.lang.String filepath;
	/**confirmdate*/
	private java.lang.String confirmdate;
	/**jianliresult*/
	private java.lang.String jianliresult;
	/**jianlishenpi*/
	private java.lang.String jianlishenpi;
	/**shenpidate*/
	private java.lang.String shenpidate;
	/**baocunshijian*/
	private java.lang.String baocunshijian;
	/**gongchengmingcheng*/
	private java.lang.String gongchengmingcheng;
	/**sigongdidian*/
	private java.lang.String sigongdidian;
	/**jiaozuobuwei*/
	private java.lang.String jiaozuobuwei;
	/**qiangdudengji*/
	private java.lang.String qiangdudengji;
	/**peifanghao*/
	private java.lang.String peifanghao;
	
	
	private java.lang.String chuliren;
	private java.lang.String shenpiren;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chuliren
	 */
	@Column(name ="CHULIREN",nullable=true,precision=255,length=510)
	public java.lang.String getChuliren(){
		return this.chuliren;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  chuliren
	 */
	public void setChuliren(java.lang.String chuliren){
		this.chuliren = chuliren;
	}
	
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shenpiren
	 */
	@Column(name ="SHENPIREN",nullable=true,precision=255,length=510)
	public java.lang.String getShenpiren(){
		return this.shenpiren;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shenpiren
	 */
	public void setShenpiren(java.lang.String shenpiren){
		this.shenpiren = shenpiren;
	}
	
	
	
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  xinxibianhao
	 */
	@Column(name ="XINXIBIANHAO",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getXinxibianhao(){
		return this.xinxibianhao;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  xinxibianhao
	 */
	public void setXinxibianhao(java.lang.Integer xinxibianhao){
		this.xinxibianhao = xinxibianhao;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  leiji
	 */
	@Column(name ="LEIJI",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getLeiji(){
		return this.leiji;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  leiji
	 */
	public void setLeiji(java.lang.Integer leiji){
		this.leiji = leiji;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chulijieguo
	 */
	@Column(name ="CHULIJIEGUO",nullable=true,precision=5000,length=5000)
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  fasongcishu
	 */
	@Column(name ="FASONGCISHU",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getFasongcishu(){
		return this.fasongcishu;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  fasongcishu
	 */
	public void setFasongcishu(java.lang.Integer fasongcishu){
		this.fasongcishu = fasongcishu;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  leixing
	 */
	@Column(name ="LEIXING",nullable=true,precision=10,scale=0,length=4)
	public java.lang.Integer getLeixing(){
		return this.leixing;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  leixing
	 */
	public void setLeixing(java.lang.Integer leixing){
		this.leixing = leixing;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  wentiyuanyin
	 */
	@Column(name ="WENTIYUANYIN",nullable=true,precision=5000,length=5000)
	public java.lang.String getWentiyuanyin(){
		return this.wentiyuanyin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  wentiyuanyin
	 */
	public void setWentiyuanyin(java.lang.String wentiyuanyin){
		this.wentiyuanyin = wentiyuanyin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chulishijian
	 */
	@Column(name ="CHULISHIJIAN",nullable=true,precision=5000,length=5000)
	public java.lang.String getChulishijian(){
		return this.chulishijian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  chulishijian
	 */
	public void setChulishijian(java.lang.String chulishijian){
		this.chulishijian = chulishijian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  beizhu
	 */
	@Column(name ="BEIZHU",nullable=true,precision=5000,length=5000)
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
	 *@return: java.lang.String  chulifangshi
	 */
	@Column(name ="CHULIFANGSHI",nullable=true,precision=5000,length=5000)
	public java.lang.String getChulifangshi(){
		return this.chulifangshi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  chulifangshi
	 */
	public void setChulifangshi(java.lang.String chulifangshi){
		this.chulifangshi = chulifangshi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  filepath
	 */
	@Column(name ="FILEPATH",nullable=true,precision=500,length=500)
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
	 *@return: java.lang.String  confirmdate
	 */
	@Column(name ="CONFIRMDATE",nullable=true,precision=255,length=255)
	public java.lang.String getConfirmdate(){
		return this.confirmdate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  confirmdate
	 */
	public void setConfirmdate(java.lang.String confirmdate){
		this.confirmdate = confirmdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  jianliresult
	 */
	@Column(name ="JIANLIRESULT",nullable=true,precision=255,length=255)
	public java.lang.String getJianliresult(){
		return this.jianliresult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  jianliresult
	 */
	public void setJianliresult(java.lang.String jianliresult){
		this.jianliresult = jianliresult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  jianlishenpi
	 */
	@Column(name ="JIANLISHENPI",nullable=true,precision=255,length=255)
	public java.lang.String getJianlishenpi(){
		return this.jianlishenpi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  jianlishenpi
	 */
	public void setJianlishenpi(java.lang.String jianlishenpi){
		this.jianlishenpi = jianlishenpi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  shenpidate
	 */
	@Column(name ="SHENPIDATE",nullable=true,precision=255,length=255)
	public java.lang.String getShenpidate(){
		return this.shenpidate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  shenpidate
	 */
	public void setShenpidate(java.lang.String shenpidate){
		this.shenpidate = shenpidate;
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
}
