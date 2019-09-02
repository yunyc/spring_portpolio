package com.example.project.board.service.VO;

import javax.validation.constraints.Size;

/**
 * @Class Name : BoardVO.java
 * @Description : BoardVO Class
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019.09.02               버그 수정
 *
 * @author yunyc
 * @since 2019. 07.01
 * @version 1.0
 * @see
 *
 */

public class BoardVO {
	
	/** 문의사항 식별 번호 */
	private int boardId;
	
	/** 문의사항 제목 */
	@Size(min = 1, max = 80)
	private String boardTitle;
	
	/** 문의사항 내용 */
	private String boardContent;
	
	/** 문의사항 작성 날짜 */
	private String boardDate;
	
	/** 사용자 아이디 */
	private String userId;
	
	/** 문의사항 답변 개수 */
	private int replyCnt;
	
	
	
	public int getReplyCnt() {
		return replyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "BoardVO [boardId=" + boardId + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardType="  + ", boardDate=" + boardDate + ", userId=" + userId + "]";
	}
	
	

}
