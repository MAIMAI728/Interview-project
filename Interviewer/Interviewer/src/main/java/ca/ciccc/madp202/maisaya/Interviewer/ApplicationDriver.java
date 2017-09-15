package ca.ciccc.madp202.maisaya.Interviewer;

import org.glassfish.jersey.jaxb.internal.XmlCollectionJaxbProvider.App;

import controllers.InterviewSelectionController;
import controllers.LoginController;
import controllers.RegistrationController;
import models.entities.ProfileEntity;
import models.manager.APIManager;
import models.manager.ApplicationManager;
import models.manager.MenuManager;

public class ApplicationDriver {
	public static void main(String[]args) {
	      
		APIManager apim = new APIManager();
		//show MainMenu View
		MenuManager mm = new MenuManager();
		mm.mainMenu();
		String menuType = "";
		System.out.print("Please type :");
		menuType = mm.scn.nextLine();
		
		while(!(menuType.equalsIgnoreCase("L")|menuType.equalsIgnoreCase("R")|menuType.equalsIgnoreCase("T"))) {	
			System.out.println("Again : Please type [Press L] or [Press R] or [Press T]");
			menuType = mm.scn.nextLine();
			}
		
			if(menuType.equalsIgnoreCase("L")) {
				//show Login View
				LoginController lc = new LoginController();
				//lc.login()でCredentialEntityの引数が帰ってきて、そのあとapim.login()の引数となる。
				ProfileEntity pe = apim.loginUser(lc.login());
				ApplicationManager.setProfileEntity(pe);
				if(pe==null) {
					ApplicationDriver.main(null);
				} else {
					InterviewSelectionController isc = new InterviewSelectionController();
					isc.selectionInterview();
				}
			}
			else if(menuType.equalsIgnoreCase("R")) {
				//Registration View
				RegistrationController rc = new RegistrationController();
				ProfileEntity pe2= apim.createUser(rc.buildUser());
				if(pe2==null) {
					System.out.println("Faild");
				}else {
					System.out.println("Success to create your account");
					ApplicationDriver.main(null);
				}
			} 
			else if(menuType.equalsIgnoreCase("T")) {
				System.out.println("Terminate. Good-bye");
				mm.scn.close();
			}
	}
}