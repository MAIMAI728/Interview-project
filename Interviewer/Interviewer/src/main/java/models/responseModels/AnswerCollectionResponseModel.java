package models.responseModels;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import models.entities.Topic;

public class AnswerCollectionResponseModel {
	private int interviewid;
	private int questions;
	//questions = total
	private int correctAnswer;
	private int wrongAnswer;
	private int skippedAnswer;
	private Topic topic;
	//topic = type
	private int duration;
	private int score;
	private long date;
	
	public String getDateAsFormatted() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, yyyy", Locale.CANADA);
        return sdf.format(date);
    }
	
	
	public AnswerCollectionResponseModel() {
	}
	
	public AnswerCollectionResponseModel(int interviewid, int questions, int correctAnswer, int wrongAnswer,
			int skippedAnswer, Topic topic, int duration, int score, long date) {
		this.interviewid = interviewid;
		this.questions = questions;
		this.correctAnswer = correctAnswer;
		this.wrongAnswer = wrongAnswer;
		this.skippedAnswer = skippedAnswer;
		this.topic = topic;
		this.duration = duration;
		this.score = score;
		this.date = date;
	}
	public int getInterviewid() {
		return interviewid;
	}
	public void setInterviewid(int interviewid) {
		this.interviewid = interviewid;
	}
	public int getQuestions() {
		return questions;
	}
	public void setQuestions(int questions) {
		this.questions = questions;
	}
	public int getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public int getWrongAnswer() {
		return wrongAnswer;
	}
	public void setWrongAnswer(int wrongAnswer) {
		this.wrongAnswer = wrongAnswer;
	}
	public int getSkippedAnswer() {
		return skippedAnswer;
	}
	public void setSkippedAnswer(int skippedAnswer) {
		this.skippedAnswer = skippedAnswer;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
}
