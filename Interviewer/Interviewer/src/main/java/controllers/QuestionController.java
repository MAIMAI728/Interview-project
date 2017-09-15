package controllers;

import models.entities.AnswerCollectionEntity;
import models.entities.InterviewEntity;
import models.entities.Question;
import models.entities.TimerSet;
import models.manager.MenuManager;

public class QuestionController {
	AnswerCollectionEntity ace;
	MenuManager mm = new MenuManager();

	public QuestionController(AnswerCollectionEntity ace) {
		this.ace = ace;
	}

	// Viewer for user
	public void showInterview(InterviewEntity ie) {
		AnswerController ac = new AnswerController(ie.getInterviewid());
		TimerSet timerset = new TimerSet("Time for the interview",2,0);
		
		mm.showQuestion(ie.getTopic());
		String start = mm.scn.nextLine();
		
		while (!(start.equalsIgnoreCase("start"))) {
			System.out.println("Again : When ready, write [start] to begin the interview");
			start = mm.scn.nextLine();
		} 
		if(start.equalsIgnoreCase("start")) {
			for (Question q : ie) {
				showQuestion(q,timerset.getTimeSpent());
				ac.readAnswer(q.getQuestionid(),ie.getInterviewid());
			}
			for (Question q : ie) {
				showQuestion(q,timerset.getTimeSpent());
				ac.readAnswer(q.getQuestionid(),ie.getInterviewid());
			}
			for (Question q : ie) {
				showQuestion(q,timerset.getTimeSpent());
				ac.readAnswer(q.getQuestionid(),ie.getInterviewid());
			}
			for (Question q : ie) {
				showQuestion(q,timerset.getTimeSpent());
				ac.readAnswer(q.getQuestionid(),ie.getInterviewid());
			}ac.sayInterviewIsOver();
		}
	}

	public void showQuestion(Question q,int timeSpent) {
		System.out.println("you have "+timeSpent+" minutes left");
		
		System.out.println("----------------");
		System.out.println(q.getDescription());
		System.out.print("A:");
		System.out.println(q.getOptionA());
		System.out.print("B:");
		System.out.println(q.getOptionB());
		System.out.print("C:");
		System.out.println(q.getOptionC());
		System.out.print("D:");
		System.out.println(q.getOptionD());
		System.out.println("----------------");
		System.out.println("Type your answer: [A],[B],[C]or[D]");
		System.out.println(
		"Enter your answer or enter [S] to skip. You cannot come back to a skipped or answered question.");
	}
}
