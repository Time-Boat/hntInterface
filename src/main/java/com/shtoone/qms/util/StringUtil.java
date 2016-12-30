package com.shtoone.qms.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;



public class StringUtil {
	
	//文件上传系统的根目录
	public static final String Uploadpath = "uploadfile";
	
	// 默认每页1条
	public static final int PAGESIZE = 20;

	
	private static final String Algorithm = "DESede"; //定义 加密算法,可用 DES,DESede,Blowfish
	private static  final byte[] keyBytes = {0x14, 0x32, 0x4F, 0x58, 0x48, 0x10, 0x40, 0x38  
			 , 0x28, 0x28, 0x79, 0x51, (byte)0x3B, (byte)0xDF, 0x55, 0x66      
			 , 0x77, 0x29, 0x74, (byte)0x98, 0x37, 0x40, 0x36, (byte)0xEE};	

public static String iso2gb(String isostring) {
       try{
		  return new String(isostring.getBytes("8859_1"),"GB2312");

	  }
	  catch(Exception ex) {
		  return isostring;
	  }
  }

  public static String outHtml(String string) {
	  if(string==null) return string;
	  else {
		  String _string=string.replaceAll("<","&lt;");
		  _string=_string.replaceAll(">","&gt;");
		  return _string;
	  }

  }


  public static boolean isNull(String srcString) {
    if(StringUtil.Null2Blank(srcString).equals("")) return true;
    else return false;
  }
  /**
   *
   * @param srcString String
   * @return String
   */
  public static String str2SQLWhere(String srcString) {
    try{
      String _tmp=srcString.replaceAll("'","\'");
                  return _tmp;
          }
          catch(Exception ex) {
                  return srcString;
          }

  }

  /**
   *  将值为null的字符串转为空字符串
   *
   *@param  srcString  Description of the Parameter
   *@return            Description of the Return Value
   */
  public static String Null2Blank(String srcString) {
	    if (srcString == null||srcString.trim().equals("")||srcString.trim().equalsIgnoreCase("null")) {
	      return "";
	    }
	    else {
	      return srcString.trim();
	    }
	  }
  
  public static boolean pdjiaobanshijian(String srcString, String subString) {
	  boolean b = false;
	  //Null2Blank(srcString).contains(subString);
	  if (Null2Blank(srcString).indexOf(subString)!=-1) {
		  b = true;
	  }
	  return b;
  }
  
  public static float StrToFloat(String srcString) {
	  float f = -1;
	    if (Null2Blank(srcString).length()>0) {
	      try {
			f = Float.parseFloat(srcString);
		} catch (Exception e) {
		}
	    }
	    return f;
	  }
  
  public static String Null2Zero(String srcString) {
	    if (srcString == null||srcString.trim().equals("")||srcString.trim().equalsIgnoreCase("null")) {
	      return "0";
	    }
	    else {
	      return srcString.trim();
	    }
	  }


  
  public static float StrToZero(String srcString) {
	  float f = 0;
	    if (Null2Blank(srcString).length()>0) {
	      try {
			f = Float.parseFloat(srcString);
		} catch (Exception e) {
		}
	    }
	    return f;
	  }
  
  public static String toDateString(String str) {
    String tmp="";
    tmp=StringUtil.Null2Blank(str);
    if(tmp.length()>10)
      tmp=tmp.substring(0,10);
    return tmp;
  }

  /**
   *  将值为null或""的字符串转为HTML中的空格
   *
   *@param  srcString  Description of the Parameter
   *@return            Description of the Return Value
   */
  public static String Null2HtmlBlank(String srcString) {
    if (srcString == null || srcString.trim().equals("")) {
      return "&nbsp;";
    }
    return srcString.trim();
  }

  /**
   *  将字符串中的字符替换为其他字符
   *
   *@param  strReplaced  Description of the Parameter
   *@param  strSrc       Description of the Parameter
   *@param  strDes       Description of the Parameter
   *@return              Description of the Return Value
   */
  public static String replace(String strReplaced, String strSrc, String strDes) {
    if (strReplaced == null || strSrc == null || strDes == null ||
        strReplaced.equals("") || strSrc.equals("")) {
      return strReplaced;
    }
    int from = 0;
    int offset = 0;
    int lenSrc = strSrc.length();
    int lenDes = strDes.length();
    StringBuffer sb = null;
    while ( (from = strReplaced.indexOf(strSrc, from)) != -1) {
      if (sb == null) {
        sb = new StringBuffer(strReplaced);
      }
      sb.replace(from + offset, from + offset + lenSrc, strDes);
      offset += lenDes - lenSrc;
      from = from + lenSrc;
    }

    if (sb == null) {
      return strReplaced;
    }
    else {
      return sb.toString();
    }
  }

  /**
   *  将字符串截取后以省略号补充
   *
   *@param  strBegin   传入的字符串
   *@param  theLength  要截取的长度
   *@param  strEnd     后端加的字符串
   *@return            返回的结果
   */

  public static String jqStr(String strBegin, int theLength, String strEnd) {
    String tempStr = " ";
    if (strBegin == null) {
      return " ";
    }

    strBegin = strBegin.trim();

    if (strBegin.length() > theLength) {
      tempStr = strBegin.substring(0, theLength) + strEnd;
      return tempStr;
    }

    return strBegin;
  }

  /**
   *  将字符串按照指定的分隔符分隔为集合
   *
   *@param  str        需要分隔的字符串
   *@param  separator  分隔符
   *@return            Description of the Return Value
   */
  public static Collection split(String str, String separator) {
    ArrayList list = new ArrayList();
    StringTokenizer st = new StringTokenizer(str, separator);
    while (st.hasMoreElements()) {
      String s = (String) st.nextElement();
      list.add(s);
    }
    return list;
  }

  /**
   *  判断一个数字是否在集合中
   *
   *@param  s   Description of the Parameter
   *@param  ss  Description of the Parameter
   *@return     Description of the Return Value
   */
  public static boolean in(int s, String[] ss) {
    if (ss == null || ss.length <= 0) {
      return false;
    }
    for (int i = 0; i < ss.length; i++) {
      if (s == Integer.parseInt(ss[i])) {
        return true;
      }
    }
    return false;
  }

  /**
   *  判断一个数字是否在集合中
   *
   *@param  s   Description of the Parameter
   *@param  ss  Description of the Parameter
   *@return     Description of the Return Value
   */
  public static boolean in(long s, String[] ss) {
    if (ss == null || ss.length <= 0) {
      return false;
    }
    for (int i = 0; i < ss.length; i++) {
      if (s == Long.parseLong(ss[i])) {
        return true;
      }
    }
    return false;
  }

  /**
   *  Description of the Method
   *
   *@param  s   Description of the Parameter
   *@param  ss  Description of the Parameter
   *@return     Description of the Return Value
   */
  public static boolean in(String s, String[] ss) {
    if (ss == null || ss.length <= 0) {
      return false;
    }
    for (int i = 0; i < ss.length; i++) {
      if (s.trim().equalsIgnoreCase(ss[i])) {
        return true;
      }
    }
    return false;
  }

  /**
   *  Gets the true attribute of the StringUtil class
   *
   *@param  flag  Description of the Parameter
   *@return       The true value
   */
  public static boolean isTrue(String flag) {
    String s = StringUtil.Null2Blank(flag);
    return s.equalsIgnoreCase("T") || s.equalsIgnoreCase("TRUE");
  }

  /**
   *
   * @param arrayList ArrayList
   * @param delimiterChar String
   * @return String
   */
  public static String customConnStr(ArrayList arrayList,
                                     String delimiterChar) {
    String connStr = "";
    for (int i = 0; i < arrayList.size(); i++) {
      connStr = connStr + (String)arrayList.get(i) + delimiterChar;
    }
    connStr=connStr.substring(0, connStr.length() - delimiterChar.length());
    return connStr;
  }
  /**
   * 将给定字符串按给定分隔符分解为子串并置入容器
   * (eg.) abcd;ef;gh;按；分隔符分离出abcd ef gh三个token置入list
   *
   * @param assembledStr String
   * @param delimiterChar char
   * @return Collection
   */
  public static Collection customSeparateStr(String assembledStr,char delimiterChar){
    ArrayList list = new ArrayList();
    String str = assembledStr;
    String token = null;
    int index = 0;
    while(!(str.equals(""))){
      index = str.indexOf(delimiterChar);
      token = str.substring(0,index);
      list.add(token);
      index++;
      str = str.substring(index);
    }
    return list;
  }
  //返回00001
  public  static String getStrLen(String   str,char   ch,int   len) {   
      String   tmpstr=str;   
      int   strlong=tmpstr.length();   
      while(strlong<len)   {   
        tmpstr = ch + tmpstr;   
        strlong=tmpstr.length();    
      } 
      return   tmpstr;           
  }
  //0000100002解析为1.2
  public static String getStrShort(String str) {
	  int K = str.length() / 5;
	  String tmpstr = "";
	  if (K > 0) { 
	  for (int i = 0;i<K; i++) {
		  tmpstr = tmpstr + '.' + Integer.valueOf(str.substring(i*5, i*5+5));
	  }
	  tmpstr = tmpstr.substring(1, tmpstr.length());
	  }
	  return tmpstr;  
  }
  //获取上级级别1.2.2--1.2
  public static String getUpperlevel(String str) {
	  String tmpstr = "";
	  if (str.lastIndexOf(".")>0) {
		  tmpstr = str.substring(0, str.lastIndexOf("."));
	  }
	  return tmpstr;
  }
  //判断是否是数字
  public static boolean isNumeric(String str) 
  { 
  Pattern pattern = Pattern.compile("[0-9]*"); 
  Matcher isNum = pattern.matcher(str); 
  if( !isNum.matches() ) 
  { 
  return false; 
  } 
  return true; 
  } 
  
  public static boolean isNum(char ch){ 
	  if(java.lang.Character.isDigit(ch)){ 
	  return true; 
	  } 
	  return false; 
	  } 

  //获取桩号标识符
  public static String getStakeFlag(String str) {
	  String tmpstr = "";
	  if (str.length() > 0) {
		  if (str.length()>0 && !isNum(str.charAt(0))) {
				tmpstr = tmpstr + String.valueOf(str.charAt(0));
				if (str.length()>1 && !isNum(str.charAt(1))) {
					tmpstr = tmpstr + String.valueOf(str.charAt(1));
				}
			  }		
	  }
	  return tmpstr;	
  }
  
  //获取桩号整数位
  public static String getStake1(String str) {
	  String tmpstr = "";
	  if (str.indexOf("+")>0) {
		 tmpstr = str.substring(0, str.indexOf("+"));  
		 if (tmpstr.length()>0 && !isNum(tmpstr.charAt(0))) {
			tmpstr = tmpstr.substring(1, tmpstr.length());
			 if (tmpstr.length()>0 && !isNum(tmpstr.charAt(0))) {
					tmpstr = tmpstr.substring(1, tmpstr.length());			
				}
		}
	  }
	  return tmpstr;
  }
  
  //获取桩号小数位
  public static String getStake2(String str) {
	  String tmpstr = "";
	  String restr = "";
	  if (str.indexOf("+")>0) {
		 tmpstr = str.substring(str.indexOf("+")+1, str.length());
		 for (int i = 0; i < tmpstr.length(); i++) {
			if (isNum(tmpstr.charAt(i))) {
				restr = restr + tmpstr.charAt(i);
			}
		}
	  }
	  return restr;
  }
  
  //生成台账规则查询字符串（单位工程）
  public static String createRuleStr(String code, int start) {
	  String tmpstr = "";
	  for (int i = 0; i < start-1; i++) {
		tmpstr = tmpstr + "_";
	}
	  tmpstr = tmpstr + code + "%";
	  return tmpstr;
  }
  
  //生成台账规则查询字符串（分部工程）（一级分项工程）
  public static String createRuleStr(String code, int start, String code2, int start2) {
	  String tmpstr = "";
	  for (int i = 0; i < start-1; i++) {
		tmpstr = tmpstr + "_";
	}
	  tmpstr = tmpstr + code;
	  for (int i = 0; i < start2-start-code.length(); i++) {
			tmpstr = tmpstr + "_";
		}
	  tmpstr = tmpstr + code2 + "%";
	  return tmpstr;
  }

  //生成台账规则查询字符串（二级分项工程）
  public static String createRuleStr(String code, int start, String code2, int start2, String code3, int start3) {
	  String tmpstr = "";
	  for (int i = 0; i < start-1; i++) {
		tmpstr = tmpstr + "_";
	}
	  tmpstr = tmpstr + code;
	  for (int i = 0; i < start2-start-code.length(); i++) {
			tmpstr = tmpstr + "_";
		}
	  tmpstr = tmpstr + code2;
	  
	  for (int i = 0; i < start3-start2-code2.length(); i++) {
			tmpstr = tmpstr + "_";
		}
	  tmpstr = tmpstr + code3+ "%";
	  return tmpstr;
  }
  
  //生成台账规则查询字符串（三级分项工程）
  public static String createRuleStr(String code, int start, String code2, int start2, 
		  String code3, int start3, String code4, int start4) {
	  String tmpstr = "";
	  for (int i = 0; i < start-1; i++) {
		tmpstr = tmpstr + "_";
	}
	  tmpstr = tmpstr + code;
	  for (int i = 0; i < start2-start-code.length(); i++) {
			tmpstr = tmpstr + "_";
		}
	  tmpstr = tmpstr + code2;
	  
	  for (int i = 0; i < start3-start2-code2.length(); i++) {
			tmpstr = tmpstr + "_";
		}
	  tmpstr = tmpstr + code3;
	  
	  for (int i = 0; i < start4-start3-code3.length(); i++) {
			tmpstr = tmpstr + "_";
		}
	  tmpstr = tmpstr + code4+ "%";
	  return tmpstr;
  }
  
  public static byte[] decompressData(byte[] data) {    
	          try {	        	 
	              ByteArrayOutputStream bos = new ByteArrayOutputStream();
	             InflaterOutputStream zos = new InflaterOutputStream(bos);
	             zos.write(data);	              
	              zos.close();	 	              
	              return bos.toByteArray();
	          } catch (Exception ex) {
	             return null;
	         }
	     }
	 
	     //压缩
	     public static byte[] compressData(String data) {
	         try {
	             ByteArrayOutputStream bos = new ByteArrayOutputStream();
	             DeflaterOutputStream zos = new DeflaterOutputStream(bos);
	             zos.write(data.getBytes());
	             zos.close();            
	             return bos.toByteArray();	
	         } catch (Exception ex) {
	             return null;
	         }
	     }
	     
	  // 将 s 进行 BASE64 编码
	public static String getBASE64(String s) {
		if (s == null)
			return null;
		return (new sun.misc.BASE64Encoder()).encode(s.getBytes());
	}

	// 将 BASE64 编码的字符串 s 进行解码
	public static byte[] getFromBASE64(String s) {
		if (s == null)
			return null;
		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return b;
		} catch (Exception e) {
			return null;
		}
	}
	     

	     public static String getMD5(String source) {
	    	  //String s = null;
	    	  char hexDigits[] = {       // 用来将字节转换成 16 进制表示的字符
	    	     '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',  'e', 'f'}; 
	    	   try
	    	   {
	    	    java.security.MessageDigest md = java.security.MessageDigest.getInstance( "MD5" );
	    	    md.update(source.getBytes());
	    	    StringBuilder sb = new StringBuilder();
	    	    for (byte b : md.digest()) {
	    	    sb.append(String.format("%02X", b));
	    	    }
	    	    return sb.toString();
	    	    /*byte tmp[] = md.digest();          // MD5 的计算结果是一个 128 位的长整数，
	    	                                                // 用字节表示就是 16 个字节
	    	    char str[] = new char[16 * 2];   // 每个字节用 16 进制表示的话，使用两个字符，
	    	                                                 // 所以表示成 16 进制需要 32 个字符
	    	    int k = 0;                                // 表示转换结果中对应的字符位置
	    	    for (int i = 0; i < 16; i++) {          // 从第一个字节开始，对 MD5 的每一个字节
	    	                                                 // 转换成 16 进制字符的转换
	    	     byte byte0 = tmp[i];                 // 取第 i 个字节
	    	     str[k++] = hexDigits[byte0 >>> 4 & 0xf];  // 取字节中高 4 位的数字转换, 
	    	                                                             // >>> 为逻辑右移，将符号位一起右移
	    	     str[k++] = hexDigits[byte0 & 0xf];            // 取字节中低 4 位的数字转换
	    	    } 
	    	    s = new String(str);                                 // 换后的结果转换为字符串
*/
	    	   }catch( Exception e )
	    	   {
	    	    return "";
	    	   }
	    	   //return s;
	    	 }
	     
	     
	    public static byte[] getEncCode(byte[] byteS, String strKey) {
		byte[] byteFina = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, getKey(strKey));
			byteFina = cipher.doFinal(byteS);
		} catch (Exception e) {
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	public static byte[] getDesCode(byte[] byteD, String strKey) {
		Cipher cipher;
		byte[] byteFina = null;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, getKey(strKey));
			byteFina = cipher.doFinal(byteD);
		} catch (Exception e) {
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	public static Key getKey(String strKey) {
		try {
			KeyGenerator _generator = KeyGenerator.getInstance("DES");
			_generator.init(new SecureRandom(strKey.getBytes()));
			return _generator.generateKey();
		} catch (Exception e) {
			return null;
		}
	}

	public static String getEncString(String strMing, String strKey) {
		byte[] byteMi = null;
		byte[] byteMing = null;
		String strMi = "";
		try {
			byteMing = strMing.getBytes();
			byteMi = getEncCode(byteMing, strKey);			
			strMi =(new sun.misc.BASE64Encoder()).encode(byteMi);
		} catch (Exception e) {
			return "";
		} finally {
			byteMing = null;
			byteMi = null;
		}
		return strMi;
	}

	public static String getDesString(String strMi, String strKey) {
		byte[] byteMing = null;
		byte[] byteMi = null;
		String strMing = "";
		try {
			byteMi = new sun.misc.BASE64Decoder().decodeBuffer(strMi);
			byteMing = getDesCode(byteMi, strKey);
			strMing = new String(byteMing);
		} catch (Exception e) {
		} finally {
			byteMing = null;
			byteMi = null;
		}
		return strMing;
	}

	//转换成十六进制字符串    
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
			if (n < b.length - 1)
				hs = hs + ":";
		}
		return hs.toUpperCase();
	}

	public static String getEncCodeString(String strMing) {
		char [] data=new char[strMing.length()]; 
		strMing.getChars(0,strMing.length(),data,0); 
		for(int i=0;i<strMing.length();i++){ 
		if (data[i]=='Z') { data[i]='B';} 
		else data[i]+=2; 
		}
		return new String(data);  
	}
	
	public static String getDesCodeString(String strMing) {
		char [] data=new char[strMing.length()]; 
		strMing.getChars(0,strMing.length(),data,0); 
		for(int i=0;i<strMing.length();i++){ 
		if (data[i]=='A') { data[i]='Y';} 
		else if (data[i]=='B') { data[i]='Z';} 
		else data[i]-=2; 
		}		
		return new String(data); 
	}
	
	
	
    public static List<String> getAllFiles(String absoluteDir){    
        //存放所有文件绝对路径名的list    
        List<String> files=new ArrayList<String>();    
        //当前目录的file实例    
        File parentDir=new File(absoluteDir);    
        //列举当前目录下的所有文件和目录的名字    
        String []list=parentDir.list();    
        for(String s: list){    
            //绝对路径名    
            String name=absoluteDir+"\\"+s;    
            File instance=new File(name);    
            //如果是文件则添加到list    
            if(instance.isFile()){    
                files.add(s);    
             //如果是目录则使用递归    
            }else{    
                files.addAll(getAllFiles(name));    
            }    
        }    
        return files;    
    } 
    
  //保留指定的扩展名的文件    
    public static List<String> filteFiles(List<String> list, String startTimeOne, String endTimeOne, String... allowedExts){    
        Iterator<String> it=list.iterator();    
        int extCount=allowedExts.length;    
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar day=Calendar.getInstance(); 
		
		Date strendTime = day.getTime();
		day.add(Calendar.DATE, -3);
		Date strstartTime = day.getTime();
		if (StringUtil.Null2Blank(startTimeOne).length() > 0) {
			try {
				strstartTime = sdf.parse(startTimeOne);
			} catch (ParseException e) {
			}
		}
		if (StringUtil.Null2Blank(endTimeOne).length() > 0) {
			try {
				strendTime = sdf.parse(endTimeOne);
			} catch (ParseException e) {
			}
		}
        while(it.hasNext()){    
            int count=0;    
            String s=it.next();  
            Date ds = day.getTime();
            
            for(String ext: allowedExts){    
                if(!s.endsWith("."+ext)){    
                   count++;    
                } else {
                	try {
        				ds = sdf1.parse(s.substring(0, s.length()-3));
        			} catch (ParseException e) {
        			}
                	if (ds.before(strstartTime) || ds.after(strendTime)) {
                		count++;
                    }
                }
                	
                   
            }    
            //如果和所有的扩展名都不匹配，则从list中移除    
            if(count==extCount){    
                it.remove();    
            }    
        }   
        Collections.reverse(list);
        return list;    
    }   
    
    //获取所有日志文件
    public static List<String> getLogs(String absoluteDir, String startTimeOne, String endTimeOne){  
        return filteFiles(getAllFiles(absoluteDir), startTimeOne, endTimeOne, "log");    
    }
    
    /*将数字转成以0补齐的字符例如将1转成001
    *@pqrqm String importString 传入数字字符
    *@pqrqm int length 补齐后字符总长度
    *返回转化后的字符
    */
    public static String getTransformationString(String importString, int length){ 
    	int len = importString.length();
    	StringBuffer  result =new StringBuffer();
    	if (len<length){
    		for(int i=1;i<=length-len;i++ ){
    			result.append("0");
    		}
    		result.append(importString);
    	}else if (len==length){
    		result.append(importString);
    	}else{
    		result =null;
    	}
        return result.toString();    
    }
    
    /*
     * 将字符串011转化成字符数字11
     */
    public static Integer getTransformationInt(String importString){ 
    	int  result = 0;
    	result = Integer.parseInt(importString);
        return result;    
    }
    
    /*
     * SQL SERVER 2000 高效分页查询语句 
     * <summary>
     * 将已经存在的SQL语句包装成分页SQL存储过程。
     * </summary>
     * <param name="sourceSql">已经存在的SQL语句。</param>
     * <param name="key">对于已经存在的SQL语句中能唯一标识的字段名称。</param>
     *<param name="keyType">对于key在SQL中的类型名称。</param>
     *<param name="startRowIndex">分页起始记录索引号。</param>
     *<param name="maximumRows">每页最大记录数。</param>
     *<returns>分页SQL存储过程语句。</returns>
     */
    public static String WrapPagingProcedure(String sourceSql, String key, String keyType, int startRowIndex, int maximumRows)
    {
        if (String.valueOf(startRowIndex) == null || String.valueOf(maximumRows) == null)
        {
            return sourceSql;
        }
        startRowIndex++;

        String sql =
            "DECLARE @PK " + keyType + " " +
            "DECLARE @tblPK TABLE(PK " + keyType + " NOT NULL PRIMARY KEY) " +
            "DECLARE @PagingSize int " +
            "DECLARE PagingCursor CURSOR DYNAMIC READ_ONLY FOR " +
            "SELECT " + key + " FROM(" + sourceSql + ") AS T " +
            "OPEN PagingCursor " +
            "FETCH RELATIVE " + String.valueOf(startRowIndex) + " FROM PagingCursor INTO @PK " +
            "SET @PagingSize = " + String.valueOf(maximumRows) + " " +
            "WHILE @PagingSize > 0 AND @@FETCH_STATUS = 0 " +
            "BEGIN " +
            "   INSERT @tblPK(PK) VALUES(@PK) " +
            "   FETCH NEXT FROM PagingCursor INTO @PK " +
            "   SET @PagingSize = @PagingSize - 1 " +
            "END " +
            "CLOSE PagingCursor " +
            "DEALLOCATE PagingCursor " +
            "SELECT * FROM(" + sourceSql + ") AS T INNER JOIN @tblPK temp ON T." + key + " = temp.PK ";

        return sql;
    }
    
    /*
     * 保存上传文件到指定的路径
     *<param name="uploadfile">上传的文件</param>
     *<param name="savepath">保存文件路径</param>
     *<returns>是否保存成功</returns>
     */
    public static boolean savefile(File uploadfile,String savepath) throws Exception{
    	 File savefile = null;
    	 if (uploadfile != null){
    		 InputStream is = new FileInputStream(uploadfile);
			 savefile = new File(savepath.toString());  
			 if(!savefile.getParentFile().exists()){
				savefile.getParentFile().mkdir();
			 }
			 OutputStream os = new FileOutputStream(savefile); 
			//设置缓存   
		     byte[] buffer = new byte[1024];   
		  
		     int length = 0;   
		  
		     //读取myFile文件输出到savefile文件中   
		     while ((length = is.read(buffer)) > 0) {   
				    os.write(buffer, 0, length);   
			}
		     is.close();
		     os.close();
		     return true;
    	 }
		return false;
    }
    
   /*
    * 计算平均值
    */
    public static double AVERAGE(List arrary){
    	double  average = 0;
    	double  sum =0;
        try{
    	if(arrary!=null){
    		for(int i=0 ;i<arrary.size();i++){
    			sum = sum+Double.valueOf(arrary.get(i).toString());
        	}
    		average = sum/arrary.size();
    		average = (double)Math.round(average*100)/100;
    	}
    	}catch(Exception e){
    		average =-1;
    		return average;
    	}
    	return average;
    }
    
    /*
     * 计算标准差
     */
     public static double STDEV(List arrary){
     	double  stdev = 0;
     	double  sum =0;
     	double  average = 0;
        try{
     	if(arrary!=null&&arrary.size()>1){
     		average = AVERAGE(arrary);
     		for(int i=0 ;i<arrary.size();i++){
     			sum = sum+(Double.valueOf(arrary.get(i).toString())-average)*(Double.valueOf(arrary.get(i).toString())-average);
         	}
     		stdev = (double)Math.round(Math.sqrt(sum/(arrary.size()-1))*1000)/1000;
     	}
     	}catch(Exception e){
     		stdev =-1;
     		return stdev;
     	}
     	return stdev;
     }
    
     /*
      * 计算变异系数
      */
      public static double CV(List arrary){
      	double  stdev = 0;
      	double  cv =0;
      	double  average = 0;
         try{
      	if(arrary!=null&&arrary.size()>1){
      		average = AVERAGE(arrary);
      		stdev = STDEV(arrary);
      		cv = stdev*100/average;
      		cv = (double)Math.round(cv*1000)/1000;
      	}
      	}catch(Exception e){
      		stdev =-1;
      		return cv;
      	}
      	return cv;
      }
      
      //app新增+++
      //水泥混凝土  沥青混凝土  试验室  项目部  水稳拌合站
  	//江苏东交的混凝土拌和站的架构
  	public static final String dj = "001";
  	public static final String hntbhzType="1";    //混凝土拌和站
  	public static final String lqbhzType="2";     //沥青拌和站
  	public static final String sysType="3";       //试验室
  	public static final String xmbType="4";       //项目部
  	public static final String swbhzType="5";     //水稳拌合站
}

