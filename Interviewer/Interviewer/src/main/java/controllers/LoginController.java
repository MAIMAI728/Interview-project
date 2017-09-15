
package controllers;

import java.util.Scanner;
import models.entities.CredentialEntity;
import models.interfaces.IntegerValidationPredicate;
import models.interfaces.StringValidationPredicate;
import models.manager.MenuManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController {
	private Scanner scn = new Scanner(System.in);
	
	public CredentialEntity login() {
		
		MenuManager mm = new MenuManager();
		mm.showLogin();
		
		String username="";
		String password="";
		
		username =  mm.scn.nextLine();
		password = mm.scn.nextLine();
	
		CredentialEntity ce = new CredentialEntity(username,password);
		
		return ce;
	
		}
}
