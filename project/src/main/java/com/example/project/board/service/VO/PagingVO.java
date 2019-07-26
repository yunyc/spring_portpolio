package com.example.project.board.service.VO;

public class PagingVO {
	
	private Integer boardCount;
	private int endPage;
	private int[] pageList;
	
	public Integer getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(Integer boardCount) {
		this.boardCount = boardCount;
	}
	
	public int[] getPageList() {
		return pageList;
	}

	public void setPageList(int[] pageList) {
		this.pageList = pageList;
	}
	
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public void PageInit() {
		endPage = (boardCount/10) + 1;
		pageList = new int[endPage];
		
		for (int i = 0; i < endPage; i++) {
			pageList[i] = i;
		}
	}

}
