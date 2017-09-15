package models.entities;

public class AnswerEntity {
	private int questionid;
	private String answer;
//	AnswerCollectionEntity では HashMap<questionidとAnswer>とinterviewIDとuserIDを持っている
	
	public AnswerEntity() {
		super();
	}
	
	public AnswerEntity(int questionid, String answer) {
		this.questionid = questionid;
		this.answer = answer;
	}
	
	public int getQuestionid() {
		return questionid;
	}
	
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
