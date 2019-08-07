package com.example.project.question.service.VO;

public class QuestVO {
	
	private int questId;
	private	String questTitle;
	private String questContent;
	private String questDate;
	private int questGood;
	private int questBad;
	private int answerCnt;
	private String userId;
	
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
