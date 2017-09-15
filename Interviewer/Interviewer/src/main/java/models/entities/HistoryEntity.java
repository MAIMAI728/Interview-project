package models.entities;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class HistoryEntity {
	private Topic topic;
	//topic = type
	private long date;
	private int score;
	private int correct;
	private int userid;
	
	public HistoryEntity() {
	}

	public String getDateAsFormatted() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, yyyy", Locale.CANADA);
        return sdf.format(date);
    }

	
	public HistoryEntity(Topic topic, long date, int score, int correct, int userid) {
		this.topic = topic;
		this.date = date;
		this.score = score;
		this.correct = correct;
		this.userid = userid;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	
	
}
