package com.example.project.board.service.VO;

public class BoardPageVO {
	
	private int boardSize;
	private int endPage;
	private int[] pageList;
	
	public BoardPageVO(int boardSize) {
		this.boardSize = boardSize;
		this.endPage = (boardSize/10) + 1;
		
		makePageList(endPage);
	}
	
	public int[] getPageList() {
		return pageList;
	}

	public void setPageList(int[] pageList) {
		this.pageList = pageList;
	}
	
	public void makePageList(int size) {
		this.pageList = new int[size];
		
		for (int i = 0; i < size; i++) {
			this.pageList[i] = i;
		}
	}
	
	public int getBoardSize() {
		return boardSize;
	}
	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

}
