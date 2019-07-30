package com.example.project.board.service.VO;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PagingVO {
	
	private Integer boardCount;
	private int startIndex = 0;
	private int endIndex = 9;
	private int pageSize = 10;
	private int startPage;
	private int endPage = 1;
	private int currentPage = 1;
	private int currentPageNum;
	// 페이징 정보 초기화
	public void pageInit() {
		this.startIndex = startIndex + ((currentPage - 1) * 10);
		this.endIndex = endIndex + ((currentPage - 1) * 10);
		this.currentPageNum = (currentPage + 10) / 10;
		this.startPage = 1 + (currentPageNum - 1) * 10;
		this.endPage = 1 + ((boardCount - 1) / 10);
		
		if (this.endPage > (currentPageNum * 10)) {
			this.endPage = currentPageNum * 10;
		}
	}
	
	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public Integer getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(Integer boardCount) {
		this.boardCount = boardCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
