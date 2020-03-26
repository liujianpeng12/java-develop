package com.vince.model;

public class PageRoll {
	private int pageIndex=1;
	private int pageSize=5;
	private int pageCount;
	private int totalCount;
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		pageCount=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		return pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
