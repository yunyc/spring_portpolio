package com.example.project.paging;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PagingVO {
	
	private int boardCount;
	private int boardSize = 6;
	private int startIndex;
	private int endIndex;
	private int startPage = 1;
	private int endPage = 1;
	private int currentPage = 1;

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
		
		setStartIndex((currentPage - 1) * boardSize);
		setEndIndex((currentPage * boardSize) - 1);
		
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
		
		if (boardCount > 1) {
			setEndPage((boardCount - 1) / boardSize + 1);
		}
		
		if (currentPage > endPage) {
			setStartPage(endPage + 1);
			setEndPage(endPage + 10);
		}
		setStartPage(startPage);
	}

	public int getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}

	@Override
	public String toString() {
		return "PagingVO [boardCount=" + boardCount + ", boardSize=" + boardSize + ", startIndex=" + startIndex
				+ ", endIndex=" + endIndex +  ", startPage=" + startPage + ", endPage="
				+ endPage + ", currentPage=" + currentPage + ", currentPageNum="  + "]";
	}
	
	

	
	
	
	
	
}
