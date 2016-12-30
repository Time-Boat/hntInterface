package com.shtoone.qms.controller;

import java.io.ByteArrayInputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

import com.shtoone.qms.service.DatasubmitService;
import com.shtoone.qms.util.DIUtils;


/**
 * 数据提交处理类
 * 
 * @author 
 * 
 */
@Controller
public class DatasubmitController{
	
	private DatasubmitService datasuber;	

	@Autowired
	public void setDatasuber(DatasubmitService datasuber) {
		this.datasuber = datasuber;
	}
	
	@RequestMapping("/submitrealdata")
	public String submitrealdata(@RequestParam("username") String name,  
	        @RequestParam("file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/xml;charset=gbk");  
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out;
        try {
        	if (StringUtil.isEmpty(name, "").equalsIgnoreCase("shtoone") && !file.isEmpty()) {
				byte[]  b1   =  file.getBytes();      
		        ByteArrayInputStream bout = new ByteArrayInputStream((com.shtoone.qms.util.StringUtil.decompressData(b1)));
		        DIUtils.initialize();
				Document doc = DIUtils.loadDocument(bout);
				out = response.getWriter();
	            out.print(datasuber.submitreal(doc.getDocumentElement()));
	            out.close();
			}
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
		return null;
	}

}
