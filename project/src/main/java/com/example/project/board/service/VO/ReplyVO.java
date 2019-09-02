package com.example.project.board.service.VO;

/**
 * @Class Name : ReplyVO.java
 * @Description : ReplyVO Class
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

public class ReplyVO {
	
	/** 답변 식별 번호 */
	private int replyId;
	
	/** 문의사항 식별 번호 */
	private int boardId;
	
	/**  사용자 아이디 */
	private String userId;
	
	/** 답변 내용 */
	private String replyContent;
	
	/** 답변 작성 날짜 */
	private String replyDate;
	
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [replyId=" + replyId + ", boardId=" + boardId + ", userId=" + userId + ", replyContent="
				+ replyContent + ", replyDate=" + replyDate + "]";
	}
	
	

}
