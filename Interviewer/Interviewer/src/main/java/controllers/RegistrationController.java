package controllers;

import java.util.regex.Pattern;

import models.entities.CredentialEntity;
import models.entities.ProfileEntity;
import models.entities.UserEntity;
import models.interfaces.IntegerValidationPredicate;
import models.interfaces.StringValidationPredicate;
import models.manager.APIManager;
import models.manager.MenuManager;

public class RegistrationController {
	
	
	public static UserEntity buildUser() {
		
		MenuManager mm = new MenuManager();
		mm.showRegistration();
		
		String username = "";
		String password;
		String firstname = mm.scn.nextLine();
		String lastname = mm.scn.nextLine();
		String country = mm.scn.nextLine();
		
		//username Regex
		Pattern patternForUsername = Pattern.compile("^[0-9a-zA-Z]+@[.0-9a-zA-Z]+$");
		StringValidationPredicate stringV = new StringValidationPredicate();
		do {
			System.out.println("Username Should be Email address");
			username =  mm.scn.nextLine();
		}
		while(!stringV.validatite(username, patternForUsername));
		
		//password Regex
		Pattern patternForPassword = Pattern.compile("(?=([a-zA-Z0-9].*(\\W))|((\\W).*[a-zA-Z0-9])$).{8,12}");
		do {
			System.out.println("Password shold be alphabet and period");
			password = mm.scn.nextLine();
		}
		while(!stringV.validatite(password,patternForPassword));
		
		UserEntity ue = new UserEntity(firstname,lastname,country,username,password);
		
		return ue;

		}
	}
