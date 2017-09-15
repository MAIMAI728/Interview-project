package controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import models.entities.AnswerCollectionEntity;
import models.entities.AnswerEntity;
import models.entities.ProfileEntity;
import models.entities.ResultEntity;
import models.manager.APIManager;
import models.manager.ApplicationManager;
import models.manager.MenuManager;

public class AnswerController {
	
	public AnswerCollectionEntity ace;
	private APIManager apim = new APIManager();
	MenuManager mm = new MenuManager();
	public AnswerEntity ae;
	ResultEntity re = new ResultEntity();
	
	public AnswerController(int interviewID) {
		//Questions
		ace = new AnswerCollectionEntity(interviewID, ApplicationManager.getProfileEntity().getUserid());
	}
	
	public void readAnswer(Integer qid, Integer interciewid){
		String answer = mm.scn.nextLine();
		while (!(answer.equalsIgnoreCase("A")|(answer.equalsIgnoreCase("B")|(answer.equalsIgnoreCase("C")|(answer.equalsIgnoreCase("D")|(answer.equalsIgnoreCase("S"))))))) {
			System.out.println("Invalid Input. Try again!");
			answer = mm.scn.nextLine();
		}
		ae = new AnswerEntity(qid, answer);
		ace.addAnswer(ae);
	}
	
	public void sayInterviewIsOver(){
		System.out.println("Finish your interview!");
		ResultEntity re = apim.submitAnswer(ace);
		showDashboard(re);
	}
	
	public void showDashboard(ResultEntity re) {
		
		ProfileEntity pe = ApplicationManager.getProfileEntity();
		System.out.println("Dashboard:");
		System.out.println("===============================");
		System.out.println("Dear " + pe.getUserProfile().getFirstName() + " " + pe.getUserProfile().getLastName());
		System.out.println("Here is your result:");
		System.out.println("-------------------------------");
		System.out.println("Date of test: " + re.getDateAsFormatted());
		System.out.println("Your score: " + re.getScore() + " / 100");
		System.out.println("Total number of questions: " + re.getQuestions());
		System.out.println("Correct responses: " + re.getCorrectAnswer());
		System.out.println("Wrong responses: " + re.getWrongAnswer());
		System.out.println("Skipped responses " + re.getSkippedAnswer());
		System.out.println("The level of ");
		System.out.println("-------------------------------");
		System.out.println("Would you like to take another test? [Y/N]");
		System.out.println("If the user entered Y, then show [interview menu].");
		System.out.println("If the user entered N, then return to the [main menu].");
		
		String option = mm.scn.nextLine();
		
		while (!(option.equalsIgnoreCase("Y")|(option.equalsIgnoreCase("N")))) {
			System.out.println("Invalid Input. Try again!");
			option = mm.scn.nextLine();
		}
		
		// do another test if Y / if N terminate
		if (option.equalsIgnoreCase("Y")) {
			try {
				InterviewSelectionController isc = new InterviewSelectionController();
				isc.selectionInterview();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(option.equalsIgnoreCase("N")){
			System.out.println("Terminate. Good-bye");
			mm.scn.close();
		}
	}
	
	public static class Timeformat{
		public static String getCurrentLocalDateStamp() {
		    return LocalDateTime.now()
		       .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		}
	}
}
