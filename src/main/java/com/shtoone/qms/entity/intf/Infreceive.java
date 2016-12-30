package com.shtoone.qms.entity.intf;

/**
 * 试件压力走势图的VO对象
 * <p>
 * 创建时间：2015-06-15 14:32:04
 * 
 * @author admin(wafservices@ccccltd.cn)
 */
public class Infreceive  {

	/**接收的数据 */
	private String ecode = "";
	/**接收是否成功 */
	private String grade = "";
	private String name="";
	private String oid="";
	private String poid="";
	private String status="";
	private String type="";
	private String typeext="";
	public String getEcode()
	{
		return ecode;
	}
	public void setEcode(String ecode)
	{
		this.ecode = ecode;
	}
	public String getGrade()
	{
		return grade;
	}
	public void setGrade(String grade)
	{
		this.grade = grade;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getOid()
	{
		return oid;
	}
	public void setOid(String oid)
	{
		this.oid = oid;
	}
	public String getPoid()
	{
		return poid;
	}
	public void setPoid(String poid)
	{
		this.poid = poid;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public String getTypeext()
	{
		return typeext;
	}
	public void setTypeext(String typeext)
	{
		this.typeext = typeext;
	}
	

	
}
