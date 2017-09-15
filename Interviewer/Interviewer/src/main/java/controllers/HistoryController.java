package controllers;


import ca.ciccc.madp202.maisaya.Interviewer.ApplicationDriver;
import models.entities.HistoryEntity;
import models.entities.ProfileEntity;
import models.manager.APIManager;
import models.manager.ApplicationManager;
import models.manager.MenuManager;

public class HistoryController{
	
	private APIManager apim = new APIManager();
	MenuManager mm = new MenuManager();
	
	public void interviewhistory() {
		ProfileEntity pe = ApplicationManager.getProfileEntity();
		HistoryEntity[] he = apim.interviewHistory(pe);
		mm.showHistory();
		historyBoard(he);
	}
	
	public void historyBoard(HistoryEntity[] he) {
		System.out.println("");
		for (HistoryEntity hist : he) {
			System.out.println("Topic:" + hist.getTopic().toString());
			System.out.println("Date:" + hist.getDateAsFormatted());
			System.out.println("Score:" + hist.getCorrect() + " / 5");
			System.out.println("-------------------------------------");
		}
		System.out.println("");
		System.out.println("SELECT AN OPTION:");
		System.out.println("Back to Main Menu [M]");
		System.out.println("Exit [E]");

		String option = mm.scn.nextLine();
		
		while (!(option.equalsIgnoreCase("M")|(option.equalsIgnoreCase("E")))) {
			System.out.println("Invalid Input. Try again!");
			option = mm.scn.nextLine();
		}
		// do another test if M/ if E terminate
		if (option.equalsIgnoreCase("M")) {
			ApplicationDriver.main(null);
		}
		else if(option.equalsIgnoreCase("E")){
			System.out.println("Good-bye");
			mm.scn.close();
			return;
		}
				
	}
}
