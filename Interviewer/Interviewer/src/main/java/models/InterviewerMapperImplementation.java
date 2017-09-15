package models;

import java.util.Date;

import models.entities.AnswerCollectionEntity;
import models.entities.CredentialEntity;
import models.entities.HistoryEntity;
import models.entities.InterviewEntity;
import models.entities.InterviewSelectionEntity;
import models.entities.ProfileEntity;
import models.entities.ResultEntity;
import models.entities.UserEntity;
import models.requestModels.AnswerCollectionRequestModel;
import models.requestModels.CredentialRequestModel;
import models.requestModels.InterviewSelectionRequestModel;
import models.requestModels.UserRequestModel;
import models.responseModels.AnswerCollectionResponseModel;
import models.responseModels.CredentialResponseModel;
import models.responseModels.HistoryResponseModel;
import models.responseModels.InterviewSelectionResponseModel;
import models.responseModels.UserResponseModel;

public class InterviewerMapperImplementation {
	
	public static UserRequestModel convertToURM(UserEntity ue){
		return new UserRequestModel(ue.getUsername(),ue.getFirstName(),ue.getLastName(),ue.getCountry(),ue.getPassword());
	}
	
	public static ProfileEntity convertToUPF(UserResponseModel urm) {
		return new ProfileEntity(urm.getAuthtoken(),urm.getUserid(),urm.getJoined(),urm.getUserProfile());
	}
	
	public static CredentialRequestModel convertToCRM(CredentialEntity ce) {
		return new CredentialRequestModel(ce.getUsername(),ce.getPassword());
	}
	
	public static ProfileEntity convertToCPF(CredentialResponseModel crm) {
		return new ProfileEntity(crm.getAuthtoken(),crm.getUserid(),crm.getJoined(),crm.getUserProfile());
	}

	public static InterviewSelectionRequestModel convertToISRM(InterviewSelectionEntity ise) {
		return new InterviewSelectionRequestModel(ise.getTopic());
	}
	
	public static InterviewEntity convertToIE(InterviewSelectionResponseModel isrm) {
		return new InterviewEntity(isrm.getInterviewid(),isrm.getQuestions(),isrm.getDuration(),isrm.getTopic(),isrm.getInterviewQuestions());
	}
	
	public static AnswerCollectionRequestModel convertToACRM(AnswerCollectionEntity ace) {
		return new AnswerCollectionRequestModel(ace.getInterviewid(),ace.getUserid(),ace.getAnswers());
	}
	
	public static ResultEntity convertToRE(AnswerCollectionResponseModel acrm) {
		return new ResultEntity(acrm.getInterviewid(),acrm.getQuestions(),acrm.getCorrectAnswer(),acrm.getWrongAnswer(),acrm.getSkippedAnswer(),acrm.getTopic(),acrm.getDuration(),acrm.getScore(),acrm.getDate());
	}
	
//	public static HistoryEntity convertToHE(HistoryResponseModel hrm) {
//		return new HistoryEntity(hrm.getTopic(),hrm.getDate(),hrm.getScore());
//	}

}
