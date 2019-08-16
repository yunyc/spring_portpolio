package com.example.project.paging;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PagingVO {
	
	/** 게시물 총 개수 */
	private int boardCount;
	
	/** 한 페이지 당 게시물 개수 */
	private int indexSize;
	
	/** 게시물 시작 인덱스 */
	private int startIndex;
	
	/** 게시물 종료 인덱스 */
	private int endIndex;
	
	/** 게시물 시작 페이지 */
	private int startPage = 1;
	
	/** 게시물 종료 페이지 */
	private int endPage = 1;
	
	/** 게시물 현재 페이지 */
	private int currentPage = 1;
	
	/** 게시판 총 페이지 */
	private int totalPage;
	
	/** 게시판 페이지 크기 */
	private int pageSize;
	
	public int getIndexSize() {
		return indexSize;
	}

	public void setIndexSize(int indexSize) {
		this.indexSize = indexSize;
		
		startIndex = ((currentPage - 1) * indexSize);
		endIndex = (currentPage * indexSize) - 1;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		
		startPage = ((currentPage - 1) / pageSize) * pageSize + 1;
		endPage  = ((currentPage - 1) / pageSize) * pageSize + pageSize;
		
		if (endPage > totalPage) {
			endPage = totalPage;
		}
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

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
		
		if (boardCount % indexSize == 0) {
			totalPage = boardCount / indexSize;
		} else {
			totalPage = boardCount / indexSize + 1;
		}
	}

	public int getBoardSize() {
		return indexSize;
	}

	@Override
	public String toString() {
		return "PagingVO [boardCount=" + boardCount + ", boardSize=" + ", startIndex=" + startIndex
				+ ", endIndex=" + endIndex +  ", startPage=" + startPage + ", endPage="
				+ endPage + ", currentPage=" + currentPage + ", currentPageNum="  + "]";
	}
	
	

	
	
	
	
	
}
