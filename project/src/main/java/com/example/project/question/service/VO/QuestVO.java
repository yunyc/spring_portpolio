package com.example.project.question.service.VO;

import javax.validation.constraints.Size;

/**
 * @Class Name : QuestVO.java
 * @Description : QuestVO Class
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


public class QuestVO {
	/** 질문 식별 번호 */
	private int questId;
	
	/** 질문 제목 */
	@Size(min = 1, max = 80)
	private	String questTitle;
	
	/** 질문 내용 */
	private String questContent;
	
	/** 질문 날짜 */
	private String questDate;
	
	/** 질문 좋아요 개수 */
	private int questGood;
	
	/** 질문 싫어요 개수 */
	private int questBad;
	
	/** 답변 개수 */
	private int answerCnt;
	
	/** 질문을 작성한 사용자 ID */
	private String userId;
	
	/** 질문 답변 상태 */
	private String questState;
	
	/** 질문 검색 키워드 */
	private String keyword;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getQuestState() {
		return questState;
	}
	public void setQuestState(String questState) {
		this.questState = questState;
	}
	public int getAnswerCnt() {
		return answerCnt;
	}
	public void setAnswerCnt(int answerCnt) {
		this.answerCnt = answerCnt;
	}
	public String getQuestContent() {
		return questContent;
	}
	public void setQuestContent(String questContent) {
		this.questContent = questContent;
	}
	public int getQuestId() {
		return questId;
	}
	public void setQuestId(int questId) {
		this.questId = questId;
	}
	public String getQuestTitle() {
		return questTitle;
	}
	public void setQuestTitle(String questTitle) {
		this.questTitle = questTitle;
	}
	public String getQuestDate() {
		return questDate;
	}
	public void setQuestDate(String questDate) {
		this.questDate = questDate;
	}
	public int getQuestGood() {
		return questGood;
	}
	public void setQuestGood(int questGood) {
		this.questGood = questGood;
	}
	public int getQuestBad() {
		return questBad;
	}
	public void setQuestBad(int questBad) {
		this.questBad = questBad;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "QuestVO [questId=" + questId + ", questTitle=" + questTitle + ", questContent=" + questContent
				+ ", questDate=" + questDate + ", questGood=" + questGood + ", questBad=" + questBad + ", answerCnt="
				+ answerCnt + ", userId=" + userId + "]";
	}
	
	
	
}
