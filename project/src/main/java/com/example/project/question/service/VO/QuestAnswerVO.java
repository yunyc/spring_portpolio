package com.example.project.question.service.VO;

import java.util.Date;

public class QuestAnswerVO {
	
	private int answerId;
	private String answerContent;
	private String answerSelect;
	private String answerDate;
	private int questId;
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
