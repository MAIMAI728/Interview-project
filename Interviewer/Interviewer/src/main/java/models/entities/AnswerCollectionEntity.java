package models.entities;
import java.util.ArrayList;

public class AnswerCollectionEntity {
//	AnswerCollectionEntity では HashMap<questionidとAnswer>とinterviewIDとuserIDを持っている
	//integerはクイズのidのこと、AnswerEntityは答えた問題
//	HashMap<Integer,AnswerEntity> answers = new HashMap<Integer,AnswerEntity>();
//	integerはもうQuestionのEntityで持ってるのでArraylistのみ
	private int interviewid;
	private int userid;
	ArrayList<AnswerEntity> answers = new ArrayList<>();

	
	public AnswerCollectionEntity() {
	}
	
	public AnswerCollectionEntity(int interviewid, int userid) {
	this.interviewid = interviewid;
	this.userid = userid;
}

	public int getInterviewid() {
		return interviewid;
	}

	public void setInterviewid(int interviewid) {
		this.interviewid = interviewid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public ArrayList<AnswerEntity> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<AnswerEntity> answers) {
		this.answers = answers;
	}

	public void addAnswer(AnswerEntity ae) {
		answers.add(ae);
	}

//	public void addAnswer(AnswerEntity ae) {
//		this.answers.put(ae.getQuestionid(), ae);
//	}
	
}
