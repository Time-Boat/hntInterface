package com.shtoone.qms.app.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shtoone.qms.app.entity.AppHntSysHPData;
import com.shtoone.qms.app.entity.AppSyTypeBean;
import com.shtoone.qms.app.entity.HntkangyaWarnBean;
import com.shtoone.qms.app.entity.ShebeiListBean;
import com.shtoone.qms.app.entity.SmsinfoEntity;
import com.shtoone.qms.app.entity.SysCountAnalyze;
import com.shtoone.qms.app.entity.SysCountBean;
import com.shtoone.qms.app.entity.SysMainLogoBean;
import com.shtoone.qms.app.entity.SysWNJDetailBean;
import com.shtoone.qms.app.entity.SysWNJlistBean;
import com.shtoone.qms.app.entity.SysYLJDetailBean;
import com.shtoone.qms.app.entity.SysYLJlistBean;
import com.shtoone.qms.app.service.SmsinfoInterfaceService;
import com.shtoone.qms.app.service.SysInterfaceService;
import com.shtoone.qms.util.GetDate;
import com.shtoone.qms.util.JsonUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/sysController")
public class SysController extends BaseController {
	@Autowired
	private SystemService systemService;

	@Autowired
	private SysInterfaceService sysInfaceService;

	@Autowired
	private SmsinfoInterfaceService smsinfoInterfaceService;

	/**
	 * 试验主页
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "sysHome")
	public void sysHome(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject jsonObj = new JSONObject();
		System.out.println("aaaa");
		try {
			String departid = request.getParameter("userGroupId");// 所属机构编号
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");

			if (null == startTime && null == endTime) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar day = Calendar.getInstance();
				endTime = sdf.format(day.getTime());
				day.add(Calendar.MONTH, -1);
				startTime = sdf.format(day.getTime());
			} else {
				startTime = GetDate.TimetmpConvetDateTime(request.getParameter("startTime"));// 开始时间
				endTime = GetDate.TimetmpConvetDateTime(request.getParameter("endTime"));// 终止时间
			}
			List<List<SysCountBean>> list = new ArrayList<List<SysCountBean>>();
			// 获取组织机构树
			if (StringUtil.Null2Blank(departid).length() > 0) {
				CriteriaQuery cq = new CriteriaQuery(TSDepart.class);
				cq.eq("TSPDepart.id", departid);
				cq.add();
				// 查询下级节点
				List<TSDepart> departList = systemService.getListByCriteriaQuery(cq, false);
				if (departList.size() > 0) { // 管理者进入
					// 循环查询下级节点对象，放入list
					for (TSDepart temp : departList) {
						/*
						 * 为试验室时干掉
						 * if(temp.getType().equalsIgnoreCase(StringUtil.sysType
						 * )){ continue; }
						 */
						List<SysCountBean> sycList = sysInfaceService.getSysHome(temp.getLft(), temp.getRgt(),
								startTime, endTime);
						for (SysCountBean scb : sycList) {
							scb.setUserGroupId(temp.getId());

							scb.setDepartName(temp.getDepartname());
						}
						if (sycList.size() > 0) {
							list.add(sycList);
						}
					}
				}
			}
			if (list.size() > 0) {
				jsonObj.put("data", list);
				jsonObj.put("success", true);
			} else {
				jsonObj.put("data", "[[]]");
				jsonObj.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("管理层主页--试验管理异常");
			jsonObj.put("data", "[]");
			jsonObj.put("success", false);
		}
		responseOutWrite(response, jsonObj);
	}

	/**
	 * 试验主页
	 * 
	 * @param request
	 * @param response
	 * 
	 * @RequestMapping(params = "sysHome") public void
	 *                        sysHome(HttpServletRequest request,
	 *                        HttpServletResponse response) {
	 *                        JsonUtil.responseUTF8(response); JSONObject
	 *                        jsonObj = new JSONObject(); try{ String
	 *                        departid=request.getParameter("userGroupId");//
	 *                        所属机构编号 String
	 *                        startTime=request.getParameter("startTime");
	 *                        String endTime=request.getParameter("endTime");
	 *                        String userlft=null; String userrgt=null; if
	 *                        (StringUtil.isNotEmpty(departid)) { TSDepart
	 *                        dpt=systemService.getEntity(TSDepart.class,
	 *                        departid); userlft=dpt.getLft()+"";
	 *                        userrgt=dpt.getRgt()+""; } if (null == startTime
	 *                        && null == endTime) { SimpleDateFormat sdf = new
	 *                        SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); Calendar
	 *                        day=Calendar.getInstance();
	 *                        endTime=sdf.format(day.getTime());
	 *                        day.add(Calendar.MONTH, -1);
	 *                        startTime=sdf.format(day.getTime()); }else{
	 *                        startTime=GetDate.TimetmpConvetDateTime(request.
	 *                        getParameter("startTime"));//开始时间
	 *                        endTime=GetDate.TimetmpConvetDateTime(request.
	 *                        getParameter("endTime"));//终止时间 } startTime =
	 *                        "2016-01-18 11:39:02"; List
	 *                        <SysCountBean> list=sysInfaceService.getSysHome(
	 *                        userlft, userrgt,startTime,endTime);
	 *                        if(list.size()>0){ jsonObj.put("data",list);
	 *                        jsonObj.put("success",true); }else{
	 *                        jsonObj.put("data","[]");
	 *                        jsonObj.put("success",false); } }catch (Exception
	 *                        e) { System.out.println("管理层主页--试验管理异常");
	 *                        jsonObj.put("data", "[]"); jsonObj.put("success",
	 *                        false); } responseOutWrite(response, jsonObj); }
	 */

	/**
	 * 混凝土试件抗压强度试验
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "hntkangya")
	public void hntkangya(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject jsonObj = new JSONObject();
		try {
			String departid = request.getParameter("userGroupId"); // 所属机构编号
			String shebeibianhao = request.getParameter("shebeibianhao");
			String isQualified = request.getParameter("isQualified"); // 是否合格
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String userlft = null;
			String userrgt = null;
			String pageNoStr = request.getParameter("pageNo");// 当前页
			String maxPageItemsStr = request.getParameter("maxPageItems");// 每页条数
			String isReal = request.getParameter("isReal"); // 0全部 1未处理 2已处理
			String testType = request.getParameter("testId"); // 试验
			Integer pageNo = 1;
			Integer maxPageItems = 10;
			if (StringUtil.Null2Blank(pageNoStr).length() > 0) {
				pageNo = new Integer(pageNoStr);
			}
			if (StringUtil.Null2Blank(maxPageItemsStr).length() > 0) {
				maxPageItems = new Integer(maxPageItemsStr);
			}
			if (StringUtil.isNotEmpty(departid)) {
				TSDepart dpt = systemService.getEntity(TSDepart.class, departid);
				userlft = dpt.getLft() + "";
				userrgt = dpt.getRgt() + "";
			}
			if (null == startTime && null == endTime) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar day = Calendar.getInstance();
				endTime = sdf.format(day.getTime());
				day.add(Calendar.MONTH, -1);
				startTime = sdf.format(day.getTime());
			} else {
				startTime = GetDate.TimetmpConvetDateTime(request.getParameter("startTime"));// 开始时间
				endTime = GetDate.TimetmpConvetDateTime(request.getParameter("endTime"));// 终止时间
			}
			// 处理合格与不合格
//			isQualified = StringUtil.changeVaule(isQualified);
			List<SysYLJlistBean> list = sysInfaceService.hntkangyaSel(userlft, userrgt, startTime, endTime, isQualified,
					pageNo, maxPageItems, shebeibianhao, isReal, testType);
			
			if (list.size() > 0) {
				jsonObj.put("data", list);
				jsonObj.put("success", true);
			} else {
				jsonObj.put("data", "[]");
				jsonObj.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("混凝土强度试验查询异常");
			jsonObj.put("data", "[]");
			jsonObj.put("success", false);
		}
		responseOutWrite(response, jsonObj);
	}
	
	/**
	 * 钢筋试验
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "gangjin")
	public void gangjin(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject jsonObj = new JSONObject();
		try {
			String departid = request.getParameter("userGroupId"); // 所属机构编号
			String shebeibianhao = request.getParameter("shebeibianhao");
			String isQualified = request.getParameter("isQualified"); // 是否合格
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String testType = request.getParameter("testType");// 试验类型
			String userlft = null;
			String userrgt = null;
			String pageNoStr = request.getParameter("pageNo");// 当前页
			String maxPageItemsStr = request.getParameter("maxPageItems");// 每页条数
			String isReal = request.getParameter("isReal"); // 0全部 1未处理 2已处理
			Integer pageNo = 1;
			Integer maxPageItems = 10;
			if (StringUtil.Null2Blank(pageNoStr).length() > 0) {
				pageNo = new Integer(pageNoStr);
			}
			if (StringUtil.Null2Blank(maxPageItemsStr).length() > 0) {
				maxPageItems = new Integer(maxPageItemsStr);
			}
			if (StringUtil.isNotEmpty(departid)) {
				TSDepart dpt = systemService.getEntity(TSDepart.class, departid);
				userlft = dpt.getLft() + "";
				userrgt = dpt.getRgt() + "";
			}
			if (null == startTime && null == endTime) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar day = Calendar.getInstance();
				endTime = sdf.format(day.getTime());
				day.add(Calendar.MONTH, -1);
				startTime = sdf.format(day.getTime());
			} else {
				startTime = GetDate.TimetmpConvetDateTime(request.getParameter("startTime"));// 开始时间
				endTime = GetDate.TimetmpConvetDateTime(request.getParameter("endTime"));// 终止时间
			}
			
			if("1".equals(StringUtil.Null2Blank(isReal))||"2".equals(StringUtil.Null2Blank(isReal))){
				isQualified = "0";
			}
			
			// 处理合格与不合格
			isQualified = StringUtil.changeVaule(isQualified);
			List<SysWNJlistBean> list = sysInfaceService.gangjinSel(userlft, userrgt, startTime, endTime, isQualified,
					pageNo, maxPageItems, shebeibianhao, isReal, testType);
			
			if (list.size() > 0) {
				jsonObj.put("data", list);
				jsonObj.put("success", true);
			} else {
				jsonObj.put("data", "[]");
				jsonObj.put("success", false);
			}
		} catch (Exception e) {
			System.out.println("钢筋拉力试验查询异常");
			jsonObj.put("data", "[]");
			jsonObj.put("success", false);
		}
		responseOutWrite(response, jsonObj);
	}

	/**
	 * 钢筋焊接接头试验
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "gangjinhanjiejietou")
	public void gangjinhanjiejietou(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject jsonObj = new JSONObject();
		try {
			String departid = request.getParameter("userGroupId"); // 所属机构编号
			String shebeibianhao = request.getParameter("shebeibianhao");
			String isQualified = request.getParameter("isQualified"); // 是否合格
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String shijianType = request.getParameter("testId");// 试验类型
			String userlft = null;
			String userrgt = null;
			String pageNoStr = request.getParameter("pageNo");// 当前页
			String maxPageItemsStr = request.getParameter("maxPageItems");// 每页条数
			String isReal = request.getParameter("isReal"); // 0全部 1未处理 2已处理
			Integer pageNo = 1;
			Integer maxPageItems = 10;
			if (StringUtil.Null2Blank(pageNoStr).length() > 0) {
				pageNo = new Integer(pageNoStr);
			}
			if (StringUtil.Null2Blank(maxPageItemsStr).length() > 0) {
				maxPageItems = new Integer(maxPageItemsStr);
			}
			if (StringUtil.isNotEmpty(departid)) {
				TSDepart dpt = systemService.getEntity(TSDepart.class, departid);
				userlft = dpt.getLft() + "";
				userrgt = dpt.getRgt() + "";
			}
			if (null == startTime && null == endTime) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar day = Calendar.getInstance();
				endTime = sdf.format(day.getTime());
				day.add(Calendar.MONTH, -1);
				startTime = sdf.format(day.getTime());
			} else {
				startTime = GetDate.TimetmpConvetDateTime(request.getParameter("startTime"));// 开始时间
				endTime = GetDate.TimetmpConvetDateTime(request.getParameter("endTime"));// 终止时间
			}
			// 处理合格与不合格
			isQualified = StringUtil.changeVaule(isQualified);
			List<SysWNJlistBean> list = sysInfaceService.gangjinhanjiejietouSel(userlft, userrgt, startTime, endTime,
					isQualified, pageNo, maxPageItems, shebeibianhao, isReal, shijianType);
			if (list.size() > 0) {
				jsonObj.put("data", list);
				jsonObj.put("success", true);
			} else {
				jsonObj.put("data", "[]");
				jsonObj.put("success", false);
			}
		} catch (Exception e) {
			System.out.println("钢筋焊接接头试验查询异常");
			jsonObj.put("data", "[]");
			jsonObj.put("success", false);
		}
		responseOutWrite(response, jsonObj);
	}

	/**
	 * 钢筋机械连接接头试验
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "gangjinlianjiejietou")
	public void gangjinlianjiejietou(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject jsonObj = new JSONObject();
		try {
			String departid = request.getParameter("userGroupId"); // 所属机构编号
			String shebeibianhao = request.getParameter("shebeibianhao");
			String isQualified = request.getParameter("isQualified"); // 是否合格
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String testType = request.getParameter("testType");// 试件类型
			String userlft = null;
			String userrgt = null;
			String pageNoStr = request.getParameter("pageNo");// 当前页
			String maxPageItemsStr = request.getParameter("maxPageItems");// 每页条数
			String isReal = request.getParameter("isReal"); // 0全部 1未处理 2已处理
			Integer pageNo = 1;
			Integer maxPageItems = 10;
			if (StringUtil.Null2Blank(pageNoStr).length() > 0) {
				pageNo = new Integer(pageNoStr);
			}
			if (StringUtil.Null2Blank(maxPageItemsStr).length() > 0) {
				maxPageItems = new Integer(maxPageItemsStr);
			}
			if (StringUtil.isNotEmpty(departid)) {
				TSDepart dpt = systemService.getEntity(TSDepart.class, departid);
				userlft = dpt.getLft() + "";
				userrgt = dpt.getRgt() + "";
			}
			if (null == startTime && null == endTime) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar day = Calendar.getInstance();
				endTime = sdf.format(day.getTime());
				day.add(Calendar.MONTH, -1);
				startTime = sdf.format(day.getTime());
			} else {
				startTime = GetDate.TimetmpConvetDateTime(request.getParameter("startTime"));// 开始时间
				endTime = GetDate.TimetmpConvetDateTime(request.getParameter("endTime"));// 终止时间
			}
			// 处理合格与不合格
			isQualified = StringUtil.changeVaule(isQualified);
			List<SysWNJlistBean> list = sysInfaceService.gangjinlianjiejietouSel(userlft, userrgt, startTime, endTime,
					isQualified, pageNo, maxPageItems, shebeibianhao, isReal, testType);
			if (list.size() > 0) {
				jsonObj.put("data", list);
				jsonObj.put("success", true);
			} else {
				jsonObj.put("data", "[]");
				jsonObj.put("success", false);
			}
		} catch (Exception e) {
			System.out.println("钢筋连接接头试验查询异常");
			jsonObj.put("data", "[]");
			jsonObj.put("success", false);
		}
		responseOutWrite(response, jsonObj);
	}

	/**
	 * 混凝土试件抗压强度试验详情
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "hntkangyaDetail")
	public void hntkangyaDetail(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject jsonObj = new JSONObject();
		try {
			String SYJID = request.getParameter("SYJID"); // F_GUID具有唯一标识
			if (StringUtil.isNotEmpty(SYJID)) {
				SysYLJDetailBean sysYLJDetail = sysInfaceService.hntkangyaDetail(SYJID);
				if (sysYLJDetail != null) {
					jsonObj.put("data", sysYLJDetail);
					jsonObj.put("success", true);
				} else {
					jsonObj.put("data", "[]");
					jsonObj.put("success", false);
				}
			} else {
				jsonObj.put("data", "[]");
				jsonObj.put("success", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("混凝土强度试验详情异常");
			jsonObj.put("data", "[]");
			jsonObj.put("success", false);
		}
		responseOutWrite(response, jsonObj);
	}

	/**
	 * 钢筋试验详情
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "gangjinDetail")
	public void gangjinDetail(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject jsonObj = new JSONObject();
		try {
			String SYJID = request.getParameter("SYJID"); // F_GUID具有唯一标识
			if (StringUtil.isNotEmpty(SYJID)) {
				SysWNJDetailBean sysYLJDetail = sysInfaceService.gangjinDetail(SYJID);
				if (sysYLJDetail != null) {
					jsonObj.put("data", sysYLJDetail);
					jsonObj.put("success", true);
				} else {
					jsonObj.put("data", "[]");
					jsonObj.put("success", false);
				}
			} else {
				jsonObj.put("data", "[]");
				jsonObj.put("success", false);
			}
		} catch (Exception e) {
			System.out.println("钢筋拉力详情异常");
			jsonObj.put("data", "[]");
			jsonObj.put("success", false);
		}
		responseOutWrite(response, jsonObj);
	}

	/**
	 * 钢筋焊接接头试验详情
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "gangjinhanjiejietouDetail")
	public void gangjinhanjiejietouDetail(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject jsonObj = new JSONObject();
		try {
			String SYJID = request.getParameter("SYJID"); // F_GUID具有唯一标识
			if (StringUtil.isNotEmpty(SYJID)) {
				SysWNJDetailBean sysYLJDetail = sysInfaceService.gangjinhanjiejietouDetail(SYJID);
				if (sysYLJDetail != null) {
					jsonObj.put("data", sysYLJDetail);
					jsonObj.put("success", true);
				} else {
					jsonObj.put("data", "[]");
					jsonObj.put("success", false);
				}
			} else {
				jsonObj.put("data", "[]");
				jsonObj.put("success", false);
			}
		} catch (Exception e) {
			System.out.println("钢筋焊接接头详情异常");
			jsonObj.put("data", "[]");
			jsonObj.put("success", false);
		}
		responseOutWrite(response, jsonObj);
	}

	/**
	 * 钢筋焊接接头试验详情
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "gangjinlianjiejietouDetail")
	public void gangjinlianjiejietouDetail(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject jsonObj = new JSONObject();
		try {
			String SYJID = request.getParameter("SYJID"); // F_GUID具有唯一标识
			if (StringUtil.isNotEmpty(SYJID)) {
				SysWNJDetailBean sysYLJDetail = sysInfaceService.gangjinlianjiejietouDetail(SYJID);
				if (sysYLJDetail != null) {
					jsonObj.put("data", sysYLJDetail);
					jsonObj.put("success", true);
				} else {
					jsonObj.put("data", "[]");
					jsonObj.put("success", false);
				}
			} else {
				jsonObj.put("data", "[]");
				jsonObj.put("success", false);
			}
		} catch (Exception e) {
			System.out.println("钢筋焊接接头详情异常");
			jsonObj.put("data", "[]");
			jsonObj.put("success", false);
		}
		responseOutWrite(response, jsonObj);
	}

	/**
	 * 混凝土试件抗压强度试验龄期提醒
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "lqWarn")
	public void lqWarn(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject jsonObj = new JSONObject();
		try {
			String departid = request.getParameter("userGroupId"); // 所属机构编号
			String isQualified = request.getParameter("isQualified"); // 是否合格
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String shebeibianhao = request.getParameter("shebeibianhao");
			String userlft = null;
			String userrgt = null;
			if (StringUtil.isNotEmpty(departid)) {
				TSDepart dpt = systemService.getEntity(TSDepart.class, departid);
				userlft = dpt.getLft() + "";
				userrgt = dpt.getRgt() + "";
			}
			if (null == startTime && null == endTime) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar day = Calendar.getInstance();
				endTime = sdf.format(day.getTime());
				day.add(Calendar.MONTH, -1);
				startTime = sdf.format(day.getTime());
			} else {
				startTime = GetDate.TimetmpConvetDateTime(request.getParameter("startTime"));// 开始时间
				endTime = GetDate.TimetmpConvetDateTime(request.getParameter("endTime"));// 终止时间
			}
			// 处理合格与不合格
			isQualified = StringUtil.changeVaule(isQualified);
			List<HntkangyaWarnBean> list = sysInfaceService.hntkangyaWarinSel(userlft, userrgt, startTime, endTime,
					isQualified, shebeibianhao);
			if (list.size() > 0) {
				jsonObj.put("data", list);
				jsonObj.put("success", true);
			} else {
				jsonObj.put("data", "[]");
				jsonObj.put("success", false);
			}
		} catch (Exception e) {
			System.out.println("混凝土试件抗压强度试验龄期提醒异常");
			jsonObj.put("data", "[]");
			jsonObj.put("success", false);
		}
		responseOutWrite(response, jsonObj);
	}

	/**
	 * 不合格试验处置post提交
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "hntkangyaPost", method = RequestMethod.POST)
	@ResponseBody
	public void hntkangyaPost(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject jsonObj = new JSONObject();
		try {
			boolean flag = false;
			String str = request.getParameter("SYJID");
			String str1 = request.getParameter("chaobiaoyuanyin");
			String smsId = oConvertUtils.getString(request.getParameter("SYJID"));// 文件ID
			String chuli = oConvertUtils.getString(request.getParameter("chaobiaoyuanyin"));// 文件ID
			if (StringUtil.isNotEmpty(smsId)) {
				SmsinfoEntity sms = smsinfoInterfaceService.findUniqueByProperty(SmsinfoEntity.class, "syjid", smsId);
				if (sms != null) {
				} else {
					sms = new SmsinfoEntity();
				}
				sms.setSyjid(smsId);
				sms.setChuli(chuli);
				smsinfoInterfaceService.saveOrUpdate(sms);
				flag = true;
			}
			if (flag == true) {
				jsonObj.put("data", "提交成功");
				jsonObj.put("success", true);
			} else {
				jsonObj.put("data", "提交失败");
				jsonObj.put("success", false);
			}
		} catch (Exception e) {
			System.out.println("不合格试验处置post提交异常");
			jsonObj.put("data", "提交失败");
			jsonObj.put("success", false);
		}
		responseOutWrite(response, jsonObj);
	}

	/**
	 * 试验室导航页面
	 * 
	 * @param request
	 * @param response
	 *            //原始导航页面
	 * @RequestMapping (params ="sysMainLogo") public void
	 *                 sysMainLogo(HttpServletRequest
	 *                 request,HttpServletResponse response){
	 *                 JsonUtil.responseUTF8(response); JSONObject
	 *                 returnJsonObj=new JSONObject(); try{ String
	 *                 departId=request.getParameter("userGroupId");//组织机构编号
	 *                 String userlft=null; String userrgt=null; if
	 *                 (StringUtil.isNotEmpty(departId)) { TSDepart
	 *                 dpt=systemService.getEntity(TSDepart.class, departId);
	 *                 userlft=dpt.getLft()+""; userrgt=dpt.getRgt()+""; }
	 *                 SysMainLogoBean
	 *                 syslogo=sysInfaceService.sysMainLogo(userlft,userrgt);
	 *                 if(syslogo!=null){ returnJsonObj.put("data",syslogo);
	 *                 returnJsonObj.put("success",true); }else{
	 *                 returnJsonObj.put("data","[]");
	 *                 returnJsonObj.put("success", false); } }catch(Exception
	 *                 ex){ ex.printStackTrace(); System.out.println("试验室导航页面");
	 *                 returnJsonObj.put("data","[]");
	 *                 returnJsonObj.put("success", false); }
	 *                 responseOutWrite(response, returnJsonObj); }
	 */

	/**
	 * 试验室导航页面 (修改导航页面)
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "sysMainLogo")
	public void sysMainLogo(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj = new JSONObject();
		try {
			String departId = request.getParameter("userGroupId");// 组织机构编号
			String userlft = null;
			String userrgt = null;
			if (StringUtil.isNotEmpty(departId)) {
				TSDepart dpt = systemService.getEntity(TSDepart.class, departId);
				userlft = dpt.getLft() + "";
				userrgt = dpt.getRgt() + "";
			}
			SysMainLogoBean syslogo = sysInfaceService.sysMainLogo(userlft, userrgt);
			if (syslogo != null) {
				returnJsonObj.put("data", syslogo);
				returnJsonObj.put("success", true);
			} else {
				returnJsonObj.put("data", "[]");
				returnJsonObj.put("success", false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("试验室导航页面");
			returnJsonObj.put("data", "[]");
			returnJsonObj.put("success", false);
		}
		responseOutWrite(response, returnJsonObj);
	}

	/**
	 * 混凝土试验室主页    (NEW)
	 * @param request
	 * @param response
	 */
	@RequestMapping (params ="hntSysMainLogo")
	public void hntSysMainLogo(HttpServletRequest request,HttpServletResponse response){
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj=new JSONObject();
		try{
			String departId=request.getParameter("userGroupId");//所属机构编号
			Integer userlft=null;
			Integer userrgt=null;
			if (StringUtil.Null2Blank(departId).length()>0) {
				TSDepart dpt=systemService.getEntity(TSDepart.class, departId);
				userlft=dpt.getLft();
				userrgt=dpt.getRgt();
			}
			AppHntSysHPData hntMain=sysInfaceService.hntSysMainLogo(userlft, userrgt);
			if(hntMain!=null){
				returnJsonObj.put("data", hntMain);
				returnJsonObj.put("success", true);
			}else{
				returnJsonObj.put("data", "[]");
				returnJsonObj.put("success", false);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("获取拌合站主页数据失败！");
			returnJsonObj.put("data", "[]");
			returnJsonObj.put("success", false);
		}
		responseOutWrite(response, returnJsonObj);
	}
	
	/**
	 * 试验室统计分析
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "sysCountAnalyze")
	public void sysCountAnalyze(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj = new JSONObject();
		try {
			String departId = request.getParameter("userGroupId");// 组织机构编号
			String startTime = request.getParameter("startTime");// 开始时间
			String endTime = request.getParameter("endTime");// 结束时间(时间戳)
			String userlft = null;
			String userrgt = null;
			if (StringUtil.isNotEmpty(departId)) {
				TSDepart dpt = systemService.getEntity(TSDepart.class, departId);
				userlft = dpt.getLft() + "";
				userrgt = dpt.getRgt() + "";
			}
			if (null == startTime && null == endTime) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar day = Calendar.getInstance();
				endTime = sdf.format(day.getTime());
				day.add(Calendar.MONTH, -1);
				startTime = sdf.format(day.getTime());
			} else {
				startTime = GetDate.TimetmpConvetDateTime(request.getParameter("startTime"));// 出料时间
				endTime = GetDate.TimetmpConvetDateTime(request.getParameter("endTime"));// 出料时间
			}
			List<SysCountAnalyze> sysCount = sysInfaceService.SysCountAnalyze(userlft, userrgt, startTime, endTime);
			if (sysCount != null) {
				returnJsonObj.put("data", sysCount);
				returnJsonObj.put("success", true);
			} else {
				returnJsonObj.put("data", "[]");
				returnJsonObj.put("success", false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("试验室统计分析出错了！！");
			returnJsonObj.put("data", "[]");
			returnJsonObj.put("success", false);
		}
		responseOutWrite(response, returnJsonObj);
	}

	
	
	/**
	 * 获取试验室的设备列表   (作废)
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "getSysShebeiList")
	public void getSysShebeiList(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject returnJsonObj = new JSONObject();
		try {
			String departId = request.getParameter("userGroupId");// 所属机构编号 
			String userlft = null;
			String userrgt = null;
			if (StringUtil.isNotEmpty(departId)) {
				TSDepart dpt = systemService.getEntity(TSDepart.class, departId);
				userlft = dpt.getLft() + "";
				userrgt = dpt.getRgt() + "";
			}
			List<ShebeiListBean> shebeiList = sysInfaceService.getSysShebeiList(userlft, userrgt);
			if (shebeiList.size() > 0) {
				returnJsonObj.put("data", shebeiList);
				returnJsonObj.put("success", true);
			} else {
				returnJsonObj.put("data", "[]");
				returnJsonObj.put("success", false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("获取设备列表失败！");
			returnJsonObj.put("data", "[]");
			returnJsonObj.put("success", false);
		}
		responseOutWrite(response, returnJsonObj);
	}
	
	/**
	 * 钢筋试验类型         (作废)
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "getSyLx")
	public void getSyLx(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject jsonObj = new JSONObject();
		String testtype = request.getParameter("testType");
		try {
			List<AppSyTypeBean> list = sysInfaceService.shijianType(testtype);
			if (list.size() > 0) {
				jsonObj.put("data", list);
				jsonObj.put("success", true);
			} else {
				jsonObj.put("data", "[]");
				jsonObj.put("success", false);
			}
		} catch (Exception e) {
			System.out.println("试验类型查询异常");
			jsonObj.put("data", "[]");
			jsonObj.put("success", false);
		}
		responseOutWrite(response, jsonObj);
	}
	
	
	/**
	 * 钢筋试验类型和设备类型
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "getSyTpAndMc")
	public void getSyTpAndMc(HttpServletRequest request, HttpServletResponse response) {
		JsonUtil.responseUTF8(response);
		JSONObject jsonObj = new JSONObject();
		String pid = request.getParameter("userGroupId");
		String userlft = null;
		String userrgt = null;
		if (StringUtil.isNotEmpty(pid)) {
			TSDepart dpt = systemService.getEntity(TSDepart.class, pid);
			userlft = dpt.getLft() + "";
			userrgt = dpt.getRgt() + "";
		}
		try {
			//压力机和万能机试验类型
			List<AppSyTypeBean> wnjtp = new ArrayList<AppSyTypeBean>();
			List<AppSyTypeBean> yljtp = new ArrayList<AppSyTypeBean>();
			sysInfaceService.SyType(wnjtp,yljtp);
			
			List<ShebeiListBean> yljsb = new ArrayList<ShebeiListBean>();
			List<ShebeiListBean> wnjsb = new ArrayList<ShebeiListBean>();
			sysInfaceService.SyMac(yljsb,wnjsb,userlft,userrgt);
			
//			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("wnjsb", wnjsb);
			map.put("yljsb", yljsb);
			map.put("wnjtp", wnjtp);
			map.put("yljtp", yljtp);
			
			if (map.size() > 0) {
				jsonObj.put("data", map);
				jsonObj.put("success", true);
			} else {
				jsonObj.put("data", "[]");
				jsonObj.put("success", false);
			}
		} catch (Exception e) {
			System.out.println("试验类型查询异常");
			jsonObj.put("data", "[]");
			jsonObj.put("success", false);
		}
		responseOutWrite(response, jsonObj);
	}
	
}
