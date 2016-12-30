package com.shtoone.qms.service.impl;

import java.io.UnsupportedEncodingException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import jodd.util.StringUtil;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.shtoone.qms.dao.IDatasubmitDao;
import com.shtoone.qms.entity.FwangnjEntity;
import com.shtoone.qms.entity.PhonecfgEntity;
import com.shtoone.qms.entity.ShebeiInfoEntity;
import com.shtoone.qms.entity.TconsignEntity;
import com.shtoone.qms.entity.TsyjzbEntity;
import com.shtoone.qms.service.DatasubmitService;
import com.shtoone.qms.util.Smssender;
import com.shtoone.qms.util.XMLUtils;
import com.thoughtworks.xstream.XStream;


@Service("datasubmitService")
@Transactional
public class DatasubmitServiceImpl extends CommonServiceImpl implements DatasubmitService {
	private Logger log = Logger.getLogger(DatasubmitServiceImpl.class);
	private IDatasubmitDao dataDao;	
	
	@Autowired
	public void setDataDao(IDatasubmitDao dataDao) {
		this.dataDao = dataDao;
	}

	private boolean isSpecialElement(Node node, String nodeName) {
        return (Node.ELEMENT_NODE == node.getNodeType()) && node.getNodeName().equals(nodeName);
    }
	
	private String getFieldNameList(Element elRecord) {
        StringBuffer sFieldNameList = new StringBuffer();
        Element elField;
        Node node = elRecord.getFirstChild();
        String fieldName;
        while (null != node) {
            //Filed -> F
            if (isSpecialElement(node, "F")) {
                elField = (Element) node;
                //Name -> N
                fieldName = elField.getAttribute("N");
                if (null != fieldName) {
                    sFieldNameList.append(",[" + fieldName + "]");
                }
            }
            node = node.getNextSibling();
        }
        if (sFieldNameList.length() > 0) {
            sFieldNameList.deleteCharAt(0);
        }
        return sFieldNameList.toString();
    }

	private int getFieldType(String fieldName, HashMap ftypes) throws Exception {
        Object objFieldType = ftypes.get(fieldName);
        if (null != objFieldType) {
            return ((Integer)(objFieldType)).intValue();
        }
        else {
            throw new Exception("表结构异常,请检查数据库是否升级!"+fieldName);
        }
    }
	
	private String getData(int fieldType, Element elField, ArrayList imagelist) {
        String encodedata = XMLUtils.getText(elField); //2011-6-30上传字段全部解码，防止特殊字符
        String data="";
        try {
        if ((Types.CHAR == fieldType) ||
            (Types.VARCHAR == fieldType) ||
            (Types.TIMESTAMP == fieldType) ||
            (Types.DATE == fieldType) || (Types.NVARCHAR == fieldType)|| (Types.CLOB == fieldType)) {
			data = new String(com.shtoone.qms.util.StringUtil.getFromBASE64(encodedata),"gbk");
            return (0 == data.length()) ? "Null" : "'" + data.replaceAll("'", "''") + "'";
        }
        else if ((Types.BIT == fieldType) ||
                 (Types.BOOLEAN == fieldType)) {
        	data = new String(com.shtoone.qms.util.StringUtil.getFromBASE64(encodedata),"gbk");
            if (data.equals("True")) {
                data = "1";
            }
            else if (data.equals("False")) {
                data = "0";
            }
        }  else if (Types.BLOB == fieldType) 
        {    
        	imagelist.add(com.shtoone.qms.util.StringUtil.getFromBASE64(encodedata));
        	data = "?";
        } else {
        	data = new String(com.shtoone.qms.util.StringUtil.getFromBASE64(encodedata),"gbk");
        }
        
       
        } catch (UnsupportedEncodingException e) {
        	
    	}
        return (0 == data.length()) ? "Null" : data;
    }
	
	private String getFieldValueList(Element elRecord, HashMap ftypes, ArrayList imagelist) throws Exception {
        StringBuffer sFieldValueList = new StringBuffer();
        Element elField;
        Node node = elRecord.getFirstChild();
        int fieldType;
        String fieldName;
        while (null != node) {
            //Field -> F
            if (isSpecialElement(node, "F")) {
                elField = (Element) node;
                //Name -> N
                fieldName = elField.getAttribute("N");
                if (null != fieldName) {
                    fieldType = getFieldType(fieldName, ftypes);
                    sFieldValueList.append("," + getData(fieldType, elField, imagelist));
                }
            }
            node = node.getNextSibling();
        }

        if (sFieldValueList.length() > 0) {
            sFieldValueList.deleteCharAt(0);
        }
        return sFieldValueList.toString();
    }
	
	private String generateSQL(String tableName, Element elRecord, String IUID, HashMap ftypes, ArrayList imagelist) throws Exception {
        StringBuffer sql = new StringBuffer();
        try {
            sql.append("INSERT INTO " + tableName + " (" +
                       getFieldNameList(elRecord) + ") VALUES ("+
                       getFieldValueList(elRecord, ftypes, imagelist) + ")");
        }
        catch (Exception ex) {
            throw new Exception(tableName + ":" + ex.getMessage());
        }
        return sql.toString();
    }
	
	private void submitrealRecord(String tableName, Element elRecord, String testno, HashMap ftypes, ArrayList imagelist) throws
    Exception {
    if (null != testno) {
        String sql = generateSQL(tableName, elRecord, testno, ftypes, imagelist);
        try {
        	if (imagelist.size() > 0) {									
        		dataDao.executeUpdate(sql, imagelist);	
			} else {					
				dataDao.executeUpdate(sql);
			}
		} catch (Exception e) {
			throw new Exception(tableName + ":" + e.getMessage());
		}
            
    }
}
	
	private boolean getRecordIsnotExits(String tableName, String fid,  String nfn) throws
    Exception {
		try {
        	return dataDao.executeRecordIsnotExits("select "+nfn+" from "+tableName+" where "+nfn+"='"+fid+"'");
		} catch (Exception e) {
			throw new Exception(tableName + ":" + e.getMessage());
		}
	}
	
	private String getStrData(Element elField) {
        String encodedata = XMLUtils.getText(elField);         
        String data="";
		try {
			data = new String(com.shtoone.qms.util.StringUtil.getFromBASE64(encodedata),"gbk");
		} catch (UnsupportedEncodingException e) {
		}
        return data;
    }
	
	private String getFieldValueByName(Element elRecord, String fdname) throws Exception {
        Element elField;
        Node node = elRecord.getFirstChild();
        String fieldName;
        while (null != node) {
            if (isSpecialElement(node, "F")) {
                elField = (Element) node;
                fieldName = elField.getAttribute("N");
                if (null != fieldName && fieldName.equalsIgnoreCase(fdname)) {
                    return getStrData(elField);
                }
            }
            node = node.getNextSibling();
        }
        return "";
    }
	
	private String generateyljsSQL(Element elRecord) throws Exception {
        StringBuffer sql = new StringBuffer();
        try {
        	String YSKYLZ = getFieldValueByName(elRecord, "YSKYLZ");
        	String SJGC = getFieldValueByName(elRecord, "SJGC");
        	String GUID = getFieldValueByName(elRecord, "F_GUID");
        	if (YSKYLZ.length()>0 && SJGC.length()>0) {
        		String[] xValue = SJGC.split(",");
        		String[] yValue = YSKYLZ.split(",");
        		int dc = xValue.length;
        		if (yValue.length<dc) {
        			dc = yValue.length;
        		}
        		if (dc > 0) {
        			sql.append("DELETE FROM F_Yaliji_S WHERE F_GUID='"+GUID+"';");
				}
        		for (int j = 0; j < dc; j++) {
        			try {
        				//String sj = String.valueOf(Math.round(Float.valueOf(xValue[j])/100)/10);
        				java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.0");  
        				String sj = df.format(Float.valueOf(xValue[j])/1000);
        				sql.append("INSERT INTO F_Yaliji_S (F_GUID,F_SJ,F_LZ) VALUES ('"+GUID + "','"+sj+"','"+yValue[j]+"');");
					} catch (Exception e) {
						// TODO: handle exception
					}
        			
				}  
        	}
        }
        catch (Exception ex) {
            throw new Exception("F_Yaliji_S:" + ex.getMessage());
        }
        return sql.toString();
    }
	

	
	private void submityljsData(Element elRecord) throws Exception {
		String sql = generateyljsSQL(elRecord);
        try {
        	if (StringUtil.isNotEmpty(sql)) {
        	   dataDao.executeBatchInsert(sql);
        	}
		} catch (Exception e) {
			throw new Exception("F_Yaliji_S:" + e.getMessage());
		}
	}
	
	private String generatewnjsSQL(Element elRecord) throws Exception {
        StringBuffer sql = new StringBuffer();
        try {
        	String LZGC = getFieldValueByName(elRecord, "LZGC");
        	String SJGC = getFieldValueByName(elRecord, "SJGC");
        	String GUID = getFieldValueByName(elRecord, "F_GUID");
        	String WY = getFieldValueByName(elRecord, "WY");
        	if (LZGC.length()>0 && SJGC.length()>0) {
        		String[] xValue = SJGC.split(",");
        		String[] yValue = LZGC.split(",");
        		String[] wyValue = WY.split(",");
        		int dc = xValue.length;
        		if (yValue.length<dc) {
        			dc = yValue.length;
        		}
        		if (dc > 0) {
        			sql.append("DELETE FROM F_Wangnj_S WHERE F_GUID='"+GUID+"';");
				}
        		for (int j = 0; j < dc; j++) {
        			try {
        				//String sj = String.valueOf(Math.round(Float.valueOf(xValue[j])/100)/10);
        				java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.0");  
        				String sj = df.format(Float.valueOf(xValue[j])/1000);
        				if(WY.length()>0 && wyValue.length>=j){
        				   sql.append("INSERT INTO F_Wangnj_S (F_GUID,F_SJ,F_LZ,F_WY) VALUES ('"+GUID + "','"+sj+"','"+yValue[j]+"','"+wyValue[j]+"');");
        				} else {
        					sql.append("INSERT INTO F_Wangnj_S (F_GUID,F_SJ,F_LZ) VALUES ('"+GUID + "','"+sj+"','"+yValue[j]+"');");
        				}
					} catch (Exception e) {
						// TODO: handle exception
					}
        			
				}  
        	}
        }
        catch (Exception ex) {
            throw new Exception("F_Wangnj_S:" + ex.getMessage());
        }
        return sql.toString();
    }
	
	private void submitwnjsData(Element elRecord) throws Exception {
		String sql = generatewnjsSQL(elRecord);
        try {
        	if (StringUtil.isNotEmpty(sql)) {
        	   dataDao.executeBatchInsert(sql);
        	}
		} catch (Exception e) {
			throw new Exception("F_Wangnj_S:" + e.getMessage());
		}
	}
	
	private void updateConsignstate(Element elRecord)  throws Exception {
		String WTID = getFieldValueByName(elRecord, "WTID");
		//String WTBH = getFieldValueByName(elRecord, "WTBH");
		log.info(WTID+"数据上传"+this.getClass().getResource("/").getPath());
		String SYJID = getFieldValueByName(elRecord, "SYJID");
		if(StringUtil.isNotEmpty(SYJID)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		       dataDao.executeUpdate("update T_SYJZB set SJSCSJ='"+sdf.format(System.currentTimeMillis())+"' where SYJID='"+SYJID+"'");
		    } catch (Exception e) {
			   throw new Exception("T_SYJZB:" + e.getMessage());
		    }
		}
		List<TconsignEntity> tconsign;
		//if (StringUtil.isEmpty(WTID)) {
			//tconsign = this.commonDao.findByProperty(TconsignEntity.class, "wtbh", WTBH);
		//} else {
			tconsign = this.commonDao.findByProperty(TconsignEntity.class, "wtid", WTID);
		//}
		if (tconsign.size()>0) {
			TconsignEntity oneconsign=tconsign.get(0);
			if (null != oneconsign && null != oneconsign.getSysl()) {
				List<TsyjzbEntity> tsyjzb;
				//if (StringUtil.isEmpty(WTID)) {
					//tsyjzb = this.commonDao.findByProperty(TsyjzbEntity.class, "wtbh", WTBH);
				//} else {
				    tsyjzb = this.commonDao.findByProperty(TsyjzbEntity.class, "wtid", WTID);
				//}
				if (tsyjzb.size()>=Integer.parseInt(oneconsign.getSysl())) {
					oneconsign.setMstatus(1);
					log.info(WTID+"完成试验"+this.getClass().getResource("/").getPath());
				    this.commonDao.saveOrUpdate(oneconsign);
				}
			}
		}
	}
	
	private void Smsalarm(Element elRecord) throws Exception{
		String PDJG = getFieldValueByName(elRecord, "PDJG");
		if(StringUtil.isNotEmpty(PDJG) && (PDJG.equalsIgnoreCase("不合格") || PDJG.equalsIgnoreCase("无效") )) {
			String SYJID = getFieldValueByName(elRecord, "SYJID");
			String SBBH = getFieldValueByName(elRecord, "SBBH");
			List<ShebeiInfoEntity> shebeilist;
			shebeilist = this.commonDao.findByProperty(ShebeiInfoEntity.class, "shebeibianhao", SBBH);
			if (shebeilist.size()>0) {
				ShebeiInfoEntity shebei = shebeilist.get(0);
				if (null != shebei) {
					//String SJBH = getFieldValueByName(elRecord, "SJBH");
					String WTBH = getFieldValueByName(elRecord, "WTBH");
					String SYLX = getFieldValueByName(elRecord, "SYLX");
					String smscontent = "";
					String xiangmu = "";
					List<TSDepart> departList=this.commonDao.findByProperty(TSDepart.class,"parentdepartid",null);
					if(departList.size()>0){
						xiangmu=departList.get(0).getDepartname();
					}
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");						
					if (StringUtil.isNotEmpty(SYLX) && SYLX.equalsIgnoreCase("100014")) {
						smscontent = "["+sdf.format(System.currentTimeMillis())+"]"+xiangmu+shebei.getShebeiname()+"的砼抗压强度试验,委托编号"+
								     WTBH+"强度等级"+getFieldValueByName(elRecord, "SJQD")+"实际强度代表值"+getFieldValueByName(elRecord, "QDDBZ")+"MPa,该试验"+PDJG;
					} else if (StringUtil.isNotEmpty(SYLX) && SYLX.equalsIgnoreCase("100047")){
						smscontent = "["+sdf.format(System.currentTimeMillis())+"]"+xiangmu+shebei.getShebeiname()+"的钢筋试验,委托编号"+
		                             WTBH+"级别"+getFieldValueByName(elRecord, "PZBM")+"直径"+getFieldValueByName(elRecord, "GCZJ")+"mm"+PDJG;
						List<FwangnjEntity> wnjlist;
						wnjlist =  this.commonDao.findByProperty(FwangnjEntity.class, "syjid", SYJID);
						if (wnjlist.size()>0) {
							for (FwangnjEntity wnjEntity : wnjlist) {
								smscontent+="序号"+wnjEntity.getSjxh();
								smscontent+="屈服强度"+wnjEntity.getQfqd()+"MPa";
								smscontent+="抗拉强度"+wnjEntity.getLzqd()+"MPa";
								smscontent+="伸长率"+wnjEntity.getScl()+"%";
							}					
						}
						smscontent+="该试验"+PDJG;
						} else if (StringUtil.isNotEmpty(SYLX) && (SYLX.equalsIgnoreCase("100048") || SYLX.equalsIgnoreCase("200048"))){
							smscontent = "["+sdf.format(System.currentTimeMillis())+"]"+xiangmu+shebei.getShebeiname()+"的钢筋焊接试验,委托编号"+
			                             WTBH+"级别"+getFieldValueByName(elRecord, "PZBM")+"直径"+getFieldValueByName(elRecord, "GCZJ")+"mm"+PDJG;
							List<FwangnjEntity> wnjlist;
							wnjlist =  this.commonDao.findByProperty(FwangnjEntity.class, "syjid", SYJID);
							if (wnjlist.size()>0) {
								for (FwangnjEntity wnjEntity : wnjlist) {
									smscontent+="序号"+wnjEntity.getSjxh();
									smscontent+="抗压强度"+wnjEntity.getLzqd()+"MPa";
									smscontent+="断口"+wnjEntity.getDkwz()+"mm";					
								}
							}
							smscontent+="该试验"+PDJG;
							} else if (StringUtil.isNotEmpty(SYLX) && (SYLX.equalsIgnoreCase("100049") || SYLX.equalsIgnoreCase("200049"))){
								smscontent = "["+sdf.format(System.currentTimeMillis())+"]"+xiangmu+shebei.getShebeiname()+"的钢筋机械连接试验,委托编号"+
				                         WTBH+"级别"+getFieldValueByName(elRecord, "PZBM")+"直径"+
							           getFieldValueByName(elRecord, "GCZJ")+"mm"+PDJG;
								List<FwangnjEntity> wnjlist;
								wnjlist =  this.commonDao.findByProperty(FwangnjEntity.class, "syjid", SYJID);
								if (wnjlist.size()>0) {
									for (FwangnjEntity wnjEntity : wnjlist) {
										smscontent+="序号"+wnjEntity.getSjxh();
										smscontent+="抗压强度"+wnjEntity.getLzqd()+"MPa";
									}
								}
								smscontent+="该试验"+PDJG;
								}
					List<PhonecfgEntity> phonecfglist;
					phonecfglist = this.commonDao.findByProperty(PhonecfgEntity.class, "shebeiGuid", SBBH);
					if (phonecfglist.size()>0) {
						PhonecfgEntity phonecfg = phonecfglist.get(0);
						if (null != phonecfg && null != phonecfg.getIsalert() && phonecfg.getIsalert() && 
								null != phonecfg.getPhonenumber() && StringUtil.isNotEmpty(phonecfg.getPhonenumber())) {
								Hashtable recTable = null;
								recTable = Smssender.SendSms(phonecfg.getPhonenumber(), smscontent, "97");
								if (null != recTable) {
									  StringBuffer sql = new StringBuffer();
									  SimpleDateFormat cursdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									  sql.append("INSERT INTO Smsinfo (SYJID,fasongshijian,fasongcontent,fasongstatus,fasongphone,fasongcount,fasongname,returnmsg,shebeibianhao,successphone,successcount) VALUES (");
									  sql.append("'");
									  sql.append(SYJID);
									  sql.append("','");
									  sql.append(cursdf.format(System.currentTimeMillis()));
									  sql.append("','");
									  sql.append(smscontent);
									  sql.append("','");
									  sql.append((String)recTable.get("smsstatus"));
									  sql.append("','");
									  sql.append(phonecfg.getPhonenumber());
									  sql.append("',");
									  sql.append(phonecfg.getPhonenumber().split(",").length);
									  sql.append(",'");
									  sql.append(phonecfg.getOwnername());
									  sql.append("','");
									  sql.append((String)recTable.get("mymsg"));
									  sql.append("','");
									  sql.append(SBBH);
									  String successphone = (String)recTable.get("successphone");
									 if (StringUtil.isNotEmpty(successphone)) {  
										 sql.append("','");
										 sql.append(successphone);
										 sql.append("',");
										 sql.append(successphone.split(",").length);
										 sql.append(")");
									 } else {
										 sql.append("',0)");							
									 }
									 try {
										 dataDao.executeUpdate(sql.toString());
										} catch (Exception e) {
											throw new Exception( "记录短信发送情况:" + e.getMessage());
										}
								} else {
									StringBuffer sql = new StringBuffer();
									  SimpleDateFormat cursdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									  sql.append("INSERT INTO Smsinfo (SYJID,fasongshijian,fasongcontent,fasongstatus,fasongphone,fasongcount,fasongname,returnmsg,shebeibianhao,successphone,successcount) VALUES (");
									  sql.append("'");
									  sql.append(SYJID);
									  sql.append("','");
									  sql.append(cursdf.format(System.currentTimeMillis()));
									  sql.append("','");
									  sql.append(smscontent);
									  sql.append("','");
									  sql.append("0");
									  sql.append("','");
									  sql.append(phonecfg.getPhonenumber());
									  sql.append("',");
									  sql.append(phonecfg.getPhonenumber().split(",").length);
									  sql.append(",'");
									  sql.append(phonecfg.getOwnername());
									  sql.append("','");
									  sql.append("','");
									  sql.append(SBBH);
									  sql.append("','',0)");								  
									 try {
										 dataDao.executeUpdate(sql.toString());
										} catch (Exception e) {
											throw new Exception( "发送不成功记录不合格情况:" + e.getMessage());
										}
								}
						}
					} else {
						StringBuffer sql = new StringBuffer();
						  SimpleDateFormat cursdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						  sql.append("INSERT INTO Smsinfo (SYJID,fasongshijian,fasongcontent,fasongstatus,fasongphone,fasongcount,fasongname,returnmsg,shebeibianhao,successphone,successcount) VALUES (");
						  sql.append("'");
						  sql.append(SYJID);
						  sql.append("','");
						  sql.append(cursdf.format(System.currentTimeMillis()));
						  sql.append("','");
						  sql.append(smscontent);
						  sql.append("','");
						  sql.append("100");
						  sql.append("','");
						  sql.append("',0");
						  sql.append(",'");
						  sql.append("','");
						  sql.append("','");
						  sql.append(SBBH);
						  sql.append("','',0)");	
						 try {
							 dataDao.executeUpdate(sql.toString());
							} catch (Exception e) {
								throw new Exception( "记录不合格情况:" + e.getMessage());
							}
					}
				}
			}
		}
	}
	
	public String submitreal(Element elData) {
		HashMap fieldTypes = new HashMap();
        ArrayList exceptions= new ArrayList();
        ArrayList imagedataList = new ArrayList();

        Node ndMain, ndTable;
        Element elMain;
        String TableName;
        ndMain = elData.getFirstChild();
        //System.out.println(ndMain.getNodeName());
        ndMain = ndMain.getNextSibling();
        //System.out.println(ndMain.getNodeName());
        StringBuffer xml = new StringBuffer();
        xml.append("<?xml version=\"1.0\" encoding=\"gbk\"?>\n");
        xml.append("<Data>\n");
        if (null != ndMain) {
            if (isSpecialElement(ndMain, "W")) {
                elMain = (Element) ndMain;
                TableName = elMain.getAttribute("N");
                String fid = elMain.getAttribute("No");
                String nfn = elMain.getAttribute("Nfn");
                if (StringUtil.isNotEmpty(TableName) && StringUtil.isNotEmpty(fid)  && StringUtil.isNotEmpty(nfn)) {            
                    try {
                    	//deleterealRecords(TableName, fid, nfn);
                    	dataDao.getFieldTypes(TableName, fieldTypes);
                    	try {
                    		if (getRecordIsnotExits(TableName, fid, nfn)) {
                      		  submitrealRecord(TableName, elMain, fid, fieldTypes, imagedataList);  
                      		  if (TableName.equalsIgnoreCase("F_Yaliji")) {
								  submityljsData(elMain);
								//newYaliji(fid);
							  } else if (TableName.equalsIgnoreCase("F_Wangnj")) {
								  submitwnjsData(elMain);
								//newWnj(fid);
							  } else if (TableName.equalsIgnoreCase("T_SYJZB")) {
								  updateConsignstate(elMain);
								  Smsalarm(elMain);
								//newSyjzb(fid);
							  } 
                    		}
                      		xml.append(generaterealResultXml(TableName, fid));
            			  } catch (Exception e) {
            				  exceptions.add(e.getMessage());
            			  }
        			} catch (Exception e) {
        				exceptions.add(e.getMessage());
        			}
                }
            }
        }
        xml.append("<Other>\n");
        xml.append(generateExceptionsXml(exceptions));
        xml.append("</Other>\n");
        xml.append("</Data>");
        return xml.toString();
	}
	
	
	private String generaterealResultXml(String mainTableName, String fid) {
        StringBuffer xml = new StringBuffer();
        xml.append("<ok N=\"" + mainTableName + "\" No=\""+fid+"\">\n");       
        xml.append("</ok>\n");
        return xml.toString();
    }

	private String generateExceptionsXml(ArrayList exceps) {
        StringBuffer xml = new StringBuffer();
        String exMsg;
        for (Iterator itExceptions = exceps.iterator(); itExceptions.hasNext(); ) {
            exMsg = (String)(itExceptions.next());
            xml.append("<Exception>" + exMsg + "</Exception>\n");
        }
        return xml.toString();
    }
	
	public String findConsignBySbbh(String sbbh) {
		List<ShebeiInfoEntity> shebeiList = this.commonDao.findByProperty(ShebeiInfoEntity.class, "shebeibianhao", sbbh);
		String shiyanshiid = "";
		if (shebeiList.size()>0) 
		{
			shiyanshiid = shebeiList.get(0).getShiyanshiGuid();
		}
		String rt=null;
		if (!StringUtil.isEmpty(shiyanshiid)) {
			List<TconsignEntity> consignlist = this.commonDao.findHql("from TconsignEntity  where sfsyj=1 and mstatus=0 and shiyanshiGuid='"+shiyanshiid+"'");
			if (null != consignlist && consignlist.size()>0) {
				XStream xs = new XStream();
				StringBuffer sf = new StringBuffer();
				sf.append("<?xml version=\"1.0\" encoding=\"GBK\"?><toonedata>");
				for (TconsignEntity tConsign : consignlist) {
					sf.append(xs.toXML(tConsign));
				}
				sf.append("</toonedata>");
				rt = sf.toString(); 
			}
		}
		return rt;
	}
}
