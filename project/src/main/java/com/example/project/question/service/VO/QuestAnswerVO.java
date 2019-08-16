package com.example.project.question.service.VO;

import java.util.Date;

/**
 * @Class Name : QuestController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author yunyc
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

public class QuestAnswerVO {
	
	/** 답변 식별 번호 */
	private int answerId;
	
	/** 답변 내용 */
	private String answerContent;
	
	/** 답변 채택 여부 */
	private String answerSelect;
	
	/** 답변 작성 날짜 */
	private String answerDate;
	
	/** 연결된 답변 번호 */
	private int questId;
	
	/** 답변을 작성한 사용자 ID */
	private String userId;
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public String getAnswerSelect() {
		return answerSelect;
	}
	public void setAnswerSelect(String answerSelect) {
		this.answerSelect = answerSelect;
	}
	public String getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}
	public int getQuestId() {
		return questId;
	}
	public void setQuestId(int questId) {
		this.questId = questId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "QuestAnswerVO [answerId=" + answerId + ", answerContent=" + answerContent + ", answerSelect="
				+ answerSelect + ", answerDate=" + answerDate + ", questId=" + questId + ", userId=" + userId + "]";
	}
	
	

}
