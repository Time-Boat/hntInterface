package com.shtoone.qms.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {
	//将Json对象转String类型输出页面
	public static void convertStringToJSON(HttpServletResponse response,JSONObject jsonObj){
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(jsonObj.toString());
			out.flush();
			out.close();
		} catch (IOException e) {}
	}
	
	//将Json对象转String类型输出页面
	public static void convertStringToJSONArr(HttpServletResponse response,JSONArray jsonArr){
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(jsonArr.toString());
			out.flush();
			out.close();
		} catch (IOException e) {}
	}
	
	//在response返回时,定义文件的编码
	public static void responseUTF8(HttpServletResponse response){
		response.setHeader("Cache-Control", "no-cache");
	    response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
	}
	
	public static void outPrint(HttpServletResponse response,String outPrintStr){
    	PrintWriter out;
    	try{
    		out = response.getWriter();
			out.println(outPrintStr);
		    out.flush();
		    out.close();
    	}catch(Exception e){}
    }
}
