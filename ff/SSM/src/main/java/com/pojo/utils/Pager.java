package com.pojo.utils;

/**
 * 分页信息的
 */
public class Pager {
	/**
	 * 待显示页
	 */
	private int curPage;
	/**
	 * 每页显示的记录数
	 */
	private int perPageRows;
	/**
	 * 记录总数
	 */
	private int rowCount;
	/**
	 * 总页数
	 */
	@SuppressWarnings("unused")
	private int pageCount;
	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPerPageRows() {
		return perPageRows;
	}
	public void setPerPageRows(int perPageRows) {
		this.perPageRows = perPageRows;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	/**
	 * 计算页数
	 * @return
	 */
	public int getPageCount() {
		return (this.rowCount + perPageRows - 1) /perPageRows;
	}
	/**
	 * 分页显示，获取当前页的第一条的记录的索引
	 */
	public int getFirstLimitParam(){
		return (this.curPage - 1) * this.perPageRows;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}
