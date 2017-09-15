package models.manager;

import models.entities.ProfileEntity;
import net.bytebuddy.asm.Advice.This;

public class ApplicationManager {
	    private static ApplicationManager applicationManager = new ApplicationManager();
		private static ProfileEntity profile;

	    public static ApplicationManager getInstance(){
	        return applicationManager;
	    }

		public static void setProfileEntity(ProfileEntity pe) {
			profile = pe;
		}
		
		public static ProfileEntity getProfileEntity() {
			return profile;
		}
}
