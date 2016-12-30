package com.shtoone.qms.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;











import antlr.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shcm.bean.BalanceResultBean;
import com.shcm.bean.SendResultBean;
import com.shcm.send.DataApi;
import com.shcm.send.OpenApi;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.todaynic.client.mobile.SMS;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Smssender {
	static Log logger = LogFactory.getLog(Smssender.class);
	
	private static String sOpenUrl = "http://smsapi.c123.cn/OpenPlatform/OpenApi";
	private static String sDataUrl = "http://smsapi.c123.cn/DataPlatform/DataApi";
	
	// 接口帐号
	private static final String account = "1001@500942230001";
	
	// 接口密钥
	private static final String authkey = "E8AB04C69C98EB56F8991C50AD0F535A";
	
	
	// 通道组编号
	private static final int cgid = 1998;
	
	// 默认使用的签名编号(未指定签名编号时传此值到服务器)
	private static final int csid = 0;
	
	protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6',  
        '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };  
	
	protected static MessageDigest messagedigest = null;  
    static {  
        try {  
            messagedigest = MessageDigest.getInstance("MD5");  
        } catch (NoSuchAlgorithmException nsaex) {  
             logger.error(nsaex.toString());
        }  
    } 
	
	//发送短信函数 通道选择: 0：默认通道； 2：通道2； 3：即时通道
    //阿里大鱼传入apitype为除了123,97,100之外的，MsgContent格式{"qianmin":"签名","moban":"模板编号","neirong":"参数串例子{\"time\":\"08:10:12\",\"name\":\"1号站1号机\"}"}签名和模板编号留空则为默认值
    //默认签名：预警，SMS_7290047单盘报警默认模板：${nameandfield}实${shiji}配${lilun}误${wucha}%超${bz}%
    //SMS_7190001累计超标次数模板(${time})${name}:已搅拌盘数${panshu}累计超标${cbps}次
	public static Hashtable SendSms(String PhoneNumber, String MsgContent, String apitype) {
		Hashtable recTable = null;
		if (StringUtil.Null2Blank(apitype).equalsIgnoreCase("123")) {
			// 发送参数
			OpenApi.initialzeAccount(sOpenUrl, account, authkey, cgid, csid);
			// 状态及回复参数
			DataApi.initialzeAccount(sDataUrl, account, authkey);
			// 取帐户余额
			BalanceResultBean br = OpenApi.getBalance();
			List<SendResultBean> listItem = OpenApi.sendOnce(PhoneNumber, MsgContent,0,0,null);
			if(listItem != null){
				for(SendResultBean t:listItem){
					if(t.getResult() > 0){
						recTable = new Hashtable();
						recTable.put("mymsg", String.valueOf(t.getMsgId()));
						recTable.put("smsstatus", "2");
						recTable.put("successphone", PhoneNumber);
						logger.info("发送成功: " +t.getResult()+"消息编号<" + t.getMsgId() + "> 总数<" + t.getTotal() + "> 余额<" + t.getRemain() + ">"+t.getUnitPrice());
					} else {
						logger.error("发送提交失败: " + t.getErrMsg());
					}
				}
			}
		}else if (StringUtil.Null2Blank(apitype).equalsIgnoreCase("97")) {
			Hashtable paramTable = new Hashtable();
			paramTable.put("cpid", "4758");
			paramTable.put("channelid", "3144");
			String tsp = String.valueOf(System.currentTimeMillis()/1000); 
			String pwd = "shtoonesms_" + tsp +"_topsky";
			paramTable.put("password", getMD5String(pwd));
			paramTable.put("timestamp", tsp);
			String gbkcontent = MsgContent;
			try {
				gbkcontent = URLEncoder.encode(MsgContent,"GBK");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
			}
			paramTable.put("msg", gbkcontent);
			paramTable.put("tele", PhoneNumber);
			String rel = doHttppost("http://admin.sms9.net/houtai/sms.php", paramTable);
			if (StringUtil.Null2Blank(rel).length()>0) {
				recTable = new Hashtable();
				recTable.put("mymsg", rel);
				if (rel.startsWith("success")) {
					recTable.put("smsstatus", "2");
					recTable.put("successphone", PhoneNumber);
				}
			} else {
				logger.error("短信发送失败。");
			}
		} else if (StringUtil.Null2Blank(apitype).equalsIgnoreCase("100")) {
			Hashtable configTable = getConfig();
			if (null != configTable) {
				SMS smssender = new SMS(configTable);
				if (StringUtil.Null2Blank(apitype).length()==0) {
					apitype = (String)configTable.get("APITYPE");
					if (StringUtil.Null2Blank(apitype).length()==0) {
						apitype = "0";
					}
				}
				try {
					smssender.sendSMS(PhoneNumber, MsgContent, "0", apitype);
					recTable = smssender.getRespData();
					recTable.put("mymsg", smssender.getMsg());
					recTable.put("mycode", smssender.getCode());
					if (logger.isDebugEnabled()) {
						logger.debug("发送短信返回状态："+smssender.getCode()+"信息："+smssender.getMsg());
					}
				} catch (Exception e) {
					logger.error("短信发送失败。");
				}
			}
		} else {
			JSONObject smsjson = JSON.parseObject(MsgContent);
			TaobaoClient client = new DefaultTaobaoClient("https://eco.taobao.com/router/rest", "23333619", "e0418a3b84746f088ed40041adb4f37c");
			AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();			
			req.setSmsType("normal");
			String qianmin = "预警";
			String moban = "SMS_8906001";
			if (smsjson != null) {
				if (!StringUtil.isNull(smsjson.getString("qianmin"))) {
				  qianmin = smsjson.getString("qianmin");
				}
				if (!StringUtil.isNull(smsjson.getString("moban"))) {
					moban = smsjson.getString("moban");
				}
			}
			req.setSmsFreeSignName(qianmin);
			req.setSmsParamString(smsjson.getString("neirong"));			
			req.setRecNum(PhoneNumber);
			req.setSmsTemplateCode(moban);
			AlibabaAliqinFcSmsNumSendResponse rsp;
			try {
				rsp = client.execute(req);		
				recTable = new Hashtable();
				recTable.put("mymsg", rsp.getBody());
				JSONObject obj = JSON.parseObject(rsp.getBody());
				//System.out.println(obj.getString("alibaba_aliqin_fc_sms_num_send_response"));
				if (obj != null && !StringUtil.isNull(obj.getString("alibaba_aliqin_fc_sms_num_send_response"))) {
					JSONObject obj1 = JSON.parseObject(obj.getString("alibaba_aliqin_fc_sms_num_send_response"));
					if (obj1 != null && !StringUtil.isNull(obj1.getString("result"))) {
						JSONObject obj2 = JSON.parseObject(obj1.getString("result"));
						if (obj2.getBoolean("success")) {
							recTable.put("smsstatus", "2");
							recTable.put("successphone", PhoneNumber);							
						}
					}					
				}	
			} catch (ApiException e) {
				// TODO Auto-generated catch block
				logger.error("短信发送失败。"+e.getMessage());
			}			
		}
		return recTable;
	}
	

	private static Hashtable getConfig() {
		String filename = System.getProperty("catalina.home") + "\\conf\\VCPConfig.ini";
		Properties prop = new Properties();
		Hashtable configTable = null; 
		try {
			File fp = new File(filename);
			if (!fp.exists()) {
				logger.info("读取不到配置文件" + filename);
			} else {
				prop.load(new FileInputStream(fp));
				fp = null;
				configTable = new Hashtable();
				configTable.put("VCPSERVER", prop.getProperty("VCPSERVER"));
				configTable.put("VCPSVPORT", prop.getProperty("VCPSVPORT"));
				configTable.put("VCPUSERID", prop.getProperty("VCPUSERID"));
				configTable.put("VCPPASSWD", prop.getProperty("VCPPASSWD"));
				configTable.put("APITYPE", prop.getProperty("APITYPE", "2"));
			}
		} catch (Exception e) {
			logger.error("读取配置文件错误。");
		}
		return configTable;
	}
	
	public static String getMD5String(String s) {  
        return getMD5String(s.getBytes());  
    }  
	
	public static String getMD5String(byte[] bytes) {  
        messagedigest.update(bytes);  
        return bufferToHex(messagedigest.digest());  
    }  
	
   
    
    private static String bufferToHex(byte bytes[]) {  
        return bufferToHex(bytes, 0, bytes.length);  
    }  
    
    private static String bufferToHex(byte bytes[], int m, int n) {  
        StringBuffer stringbuffer = new StringBuffer(2 * n);  
        int k = m + n;  
        for (int l = m; l < k; l++) {  
            appendHexPair(bytes[l], stringbuffer);  
        }  
        return stringbuffer.toString();  
    }  
  
    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {  
        char c0 = hexDigits[(bt & 0xf0) >> 4];// 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移,此处未发现两种符号有何不同   
        char c1 = hexDigits[bt & 0xf];// 取字节中低 4 位的数字转换   
        stringbuffer.append(c0);  
        stringbuffer.append(c1);  
    }  
	
	public static String doHttppost(String url, Map<String, String> params) {
		URL u = null;
		HttpURLConnection con = null;
		//构建请求参数
		StringBuffer sb = new StringBuffer();
		if(params!=null){
		for (Entry<String, String> e : params.entrySet()) {
		sb.append(e.getKey());
		sb.append("=");
		sb.append(e.getValue());
		sb.append("&");
		}
		sb.substring(0, sb.length() - 1);
		}
		//尝试发送请求
		try {
		u = new URL(url);
		con = (HttpURLConnection) u.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setUseCaches(false);
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "GBK");
		osw.write(sb.toString());
		osw.flush();
		osw.close();
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
		if (con != null) {
		con.disconnect();
		}
		}
		 
		//读取返回内容
		StringBuffer buffer = new StringBuffer();
		try {
		BufferedReader br = new BufferedReader(new InputStreamReader(con
		.getInputStream(), "GBK"));
		String temp;
		while ((temp = br.readLine()) != null) {
		buffer.append(temp);
		buffer.append("\n");
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		 
		return buffer.toString();
		}
	 
}



