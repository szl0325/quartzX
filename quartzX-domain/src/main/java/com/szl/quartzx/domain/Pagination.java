package com.szl.quartzx.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页对象
 * @param <T>
 */
public class Pagination<T> {
	
	private int draw;
	private int pageSize;
	private int start;
	private int page;
	private int total;
    private List<T> data;
    private Map<String, Object> params = new HashMap<String, Object>();
    
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
 
}