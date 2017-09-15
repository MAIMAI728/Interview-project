package models.manager;
import java.util.Scanner;

import models.entities.InterviewEntity;
import models.entities.ProfileEntity;
import models.entities.Topic;

public class MenuManager {
	public Scanner scn = new Scanner(System.in);
	
	public void mainMenu() {
		
		System.out.println("Welcome to the Mock-up Interview");
		System.out.println("=====================");
		System.out.println("Login if you have already registered [Press L]");
		System.out.println("Register if you are the first time user [Press R]");
		System.out.println("Terminate the application [Press T]");
		
	}
	
	public void showLogin() {
		System.out.println("Login Page");
		System.out.println("=====================");
		System.out.println("Type your User name");
		System.out.println("Type your User password");
	}
	
	public void showRegistration() {
		System.out.println("Registration Page");
		System.out.println("=====================");
		System.out.println("Firstname");
		System.out.println("Lastname");
		System.out.println("Country of Location");
		System.out.println("Username");
		System.out.println("Password");
	}
	
	public void showInterview() {
		System.out.println("Select your topic");
		System.out.println("=====================");
		System.out.println("Start an interview in Java [Press J]");
		System.out.println("Start an interview in SQL[Press S]");
		System.out.println("See the history of past interviews [Press H]");
		System.out.println("Return to Main Menu [Press M]");
	}
	
	public void showQuestion(Topic topic) {
		System.out.println("Welcome to interview Questions.");
		System.out.println("=====================");
		System.out.println("You will be shown 20 questions.");
		System.out.println("When ready, write [start] to begin the interview");

	}
	
	public void showHistory() {
		System.out.println("Your interview history");
		System.out.println("=====================");
	}
	
}
