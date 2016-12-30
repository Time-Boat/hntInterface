/**
 * 
 */
package com.shtoone.qms.entity.bhz;

import java.io.Serializable;
import java.util.List;

import com.shtoone.qms.util.StringUtil;

/**
 * @功能说明：Grid分页控件封装Bean
 * 
 * @创建日期： 2010-5-11
 * @
 */
@SuppressWarnings("serial")
public class PageBean implements Serializable {
	// 每页显示的行数
	private int pageSize;
	//请求的当前页
	private int curPage=1;
	//总页数
	private int totalPages;
	//总记录数
	private int records;
	//排序字段
	private String orderBy;
	//排序方式
	private String order;

	 private List<?>       rows;//返回数据
	 private Object        queryParams;
	 private String        querySql;
	 
	/**
	 * 初始化PageBean相关参数
	 * @param totalRecords
	 */
	public void init(int records) {
		this.records = records;
		if (this.getRecords() > 0){
			this.setTotalPages((this.getRecords() - 1) / this.getPageSize() + 1);
		}
		if (this.getCurPage() > this.getRecords()){
			this.setCurPage(this.getRecords());
		}
	}

	public int getPageSize() {
		if (this.pageSize==0){
        	return StringUtil.PAGESIZE;
        }
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	 //起始行
    public Integer getStartRow() {
    	 return this.curPage > 0 ? (this.curPage - 1) * this.pageSize : 0;
    	
    	 /*if (this.curPage==0){
        	 return 0;
        }else {
            if (this.curPage==totalRecords) {
                return this.curPage - this.pageSize;
            }
            return this.curPage;
        }*/
    }

    //每页条数
    public Integer getEndRow() {
    	return  this.curPage * this.pageSize;
       /*  
        if (this.pageSize==0){
        	return CommonConstant.PAGESIZE;
        }else {
            return this.pageSize;
        }*/
    }

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public Object getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(Object queryParams) {
		this.queryParams = queryParams;
	}

	public String getQuerySql() {
		return querySql;
	}

	public void setQuerySql(String querySql) {
		this.querySql = querySql;
	}
    
    
    
}
