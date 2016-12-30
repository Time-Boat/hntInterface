package com.shtoone.qms.controller.bhz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.shtoone.qms.entity.bhz.AppUploadEntity;
import com.shtoone.qms.service.bhz.AppUploadServiceI;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.UploadFile;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @Title: Controller
 * @Description: app上传
 * @author zhangdaihao
 * @date 2016-11-23 16:16:32
 * @version V1.0
 *
 */
@Controller
@RequestMapping("/appUploadController")
public class AppUploadController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AppUploadController.class);

	@Autowired
	private AppUploadServiceI appUploadService;
	@Autowired
	private SystemService systemService;

	/**
	 * app上传列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/shtoone/qms/bhz/appUploadList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(AppUploadEntity appUpload, HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AppUploadEntity.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, appUpload, request.getParameterMap());
		this.appUploadService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除app上传
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(AppUploadEntity appUpload, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		appUpload = systemService.getEntity(AppUploadEntity.class, appUpload.getId());
		
		String path = request.getSession().getServletContext().getRealPath("/")+"dataFile\\apk\\"+appUpload.getId()+".apk";
		File file = new File(path);
		file.delete();
		appUploadService.delete(appUpload);
		message = "app上传删除成功";
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}

	//因为实体类和文件是分段上传，上传实体类后，需要获得其id，所以定义了一个成员变量
	private String uploadId = "";
	
	/**
	 * 添加app上传
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(AppUploadEntity appUpload, HttpServletRequest request) {
		
		Date date = new Date();
		DateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		appUpload.setUploadTime(time.format(date));
		
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(appUpload.getId())) {
			message = "app上传更新成功";
			AppUploadEntity t = appUploadService.get(AppUploadEntity.class, appUpload.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(appUpload, t);
				appUploadService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "app上传更新失败";
			}
		} else {
			message = "app上传添加成功";
			appUploadService.save(appUpload);
			//每次上传后获得id
			uploadId = appUpload.getId();
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(appUpload);
		return j;
	}

	/**
	 * app上传列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(AppUploadEntity appUpload, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(appUpload.getId())) {
			appUpload = appUploadService.getEntity(AppUploadEntity.class, appUpload.getId());
			req.setAttribute("appUploadPage", appUpload);
		}
		return new ModelAndView("com/shtoone/qms/bhz/appUpload");
	}

	/**
	 * app下载
	 * 
	 * @return
	 */
	@RequestMapping(params = "download")
	public String download(AppUploadEntity appUpload, HttpServletRequest request, HttpServletResponse response) {
//		String path = request.getServletContext().getRealPath("/")+"dataFile\\apk\\"+appUpload.getId()+".apk";
		appUpload = appUploadService.getEntity(AppUploadEntity.class, appUpload.getId());
		String count = appUpload.getDownloadCount();
		if(null!=count&&!count.equals("")){
			count = Integer.parseInt(count)+1+"";
		}else{
			count = "1";
		}
		appUpload.setDownloadCount(count);
		appUploadService.saveOrUpdate(appUpload);
//        fileDownload(response,path);
        String str = "redirect:/dataFile/apk/"+appUpload.getId()+".apk";
        return str;
	}
	
	
//	public void fileDownload(HttpServletResponse response,String path){  
//  
//		//1.设置文件ContentType类型，这样设置，会自动判断下载文件类型  
//		response.setContentType("multipart/form-data"); 
//		//2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)  
//        response.setHeader("Content-Disposition", "attachment;fileName="+"shtoone.apk");
//        
//        ServletOutputStream out;
//        //通过文件路径获得File对象(假如此路径中有一个download.pdf文件)  
//        File file = new File(path);  
//  
//        try {  
//            FileInputStream inputStream = new FileInputStream(file);  
//  
//            //3.通过response获取ServletOutputStream对象(out)  
//            out = response.getOutputStream();  
//  
//            int b = 0;  
//            byte[] buffer = new byte[512];  
//            while (b != -1){  
//                b = inputStream.read(buffer);  
//                //4.写到输出流(out)中  
//                out.write(buffer,0,b);  
//            }  
//            inputStream.close();  
//            out.close();  
//            out.flush();  
//  
//        } catch (IOException e) {  
//            e.printStackTrace();  
//        }  
//    }
	
	/**
	 * 保存文件
	 *
	 * @param document
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
//		String id = request.getParameter("appUploadId");
		AppUploadEntity appUpload = appUploadService.getEntity(AppUploadEntity.class, uploadId);
		String path = request.getSession().getServletContext().getRealPath("/")+"dataFile\\apk";
//		appUpload.setAppFilePath(path);
		
		UploadFile uploadFile = new UploadFile(request);
		try {
			uploadFile.getMultipartRequest().setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		MultipartHttpServletRequest multipartRequest = uploadFile.getMultipartRequest();
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		
		Set<String> set = fileMap.keySet(); 
		for (String s:set) {
			MultipartFile mf = fileMap.get(s);
			saveFile(mf,path,uploadId);
			appUpload.setAppFilePath("dataFile"+File.separator+"apk"+File.separator+uploadId+".apk");
			appUpload.setAppSize(mf.getSize()+"");
		}
		appUploadService.saveOrUpdate(appUpload);
		j.setMsg("文件添加成功");
		return j;
	}
	
	public void saveFile(MultipartFile file1 ,String path,String fileName){
		 
		 if (!file1.isEmpty()) {
			 InputStream in1 = null;
			 OutputStream out1 = null;
			 try {
				 String html = null;
				 File dirMd = new File(path);
				 if (!dirMd.exists())
					 dirMd.mkdirs();
				 
				 File serverFile = new File(dirMd.getAbsolutePath() + File.separator +
						 fileName+".apk");

				 in1 = file1.getInputStream();
				 out1 = new FileOutputStream(serverFile);
				 byte[] b = new byte[1024];
				 int len = 0;
				 
				 while ((len = in1.read(b)) > 0) {
					 html += new String(b,0,len,"UTF-8");
					 out1.write(b, 0, len);
				 }
				 out1.close();
				 in1.close();
				 String noNeed = "<p>null</p>";
				 String newHtml="";
				 if(html.startsWith(noNeed)){
					 newHtml = html.replaceFirst(noNeed," ");
				 }
				 System.out.println("=========="+newHtml);
				
			 } catch (Exception e) {
				 e.printStackTrace();
			 } finally {
				 if (out1 != null) {
					 try {
						 out1.close();
						 in1.close();
					 } catch (IOException e) {
						 e.printStackTrace();
					 }
				 	out1 = null;
				 	in1 = null;
				 }
			 }
		 }
	}
}
