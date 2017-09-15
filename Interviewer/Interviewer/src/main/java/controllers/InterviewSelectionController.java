package controllers;

import java.util.Scanner;

import ca.ciccc.madp202.maisaya.Interviewer.ApplicationDriver;
import models.entities.InterviewEntity;
import models.entities.InterviewSelectionEntity;
import models.entities.ProfileEntity;
import models.entities.Topic;
import models.manager.APIManager;
import models.manager.ApplicationManager;
import models.manager.MenuManager;

public class InterviewSelectionController {
	Topic topic;
	Scanner scn;
	String selectionModel;
	
	public void selectionInterview() {
		
		ApplicationManager.getInstance();
		MenuManager mm = new MenuManager();
		APIManager apim = new APIManager();
		QuestionController qc = new QuestionController(null);
		HistoryController hc = new HistoryController();
		
		mm.showInterview();
		scn = new Scanner(System.in);
		selectionModel = scn.nextLine();
		
		while(!(selectionModel.equalsIgnoreCase("J")|selectionModel.equalsIgnoreCase("S")|selectionModel.equalsIgnoreCase("H")|selectionModel.equalsIgnoreCase("M"))) {
			System.out.println("Again : Please type [JAVA: J] or [SQL: S] or [History: H] or [Main: M]");
			selectionModel=scn.nextLine();
		}
		
		if(selectionModel.equalsIgnoreCase("J")){
			InterviewEntity ie = apim.getInterview(Topic.JAVA);
			qc.showInterview(ie);
		}
		else if(selectionModel.equalsIgnoreCase("S")){
			InterviewEntity ie = apim.getInterview(Topic.SQL);
			qc.showInterview(ie);
		}
		else if(selectionModel.equalsIgnoreCase("H")){
			hc.interviewhistory();
		}
		else if(selectionModel.equalsIgnoreCase("M")){
			ApplicationDriver.main(null);
		}
		
	}
}
