package models;

import models.entities.AnswerCollectionEntity;
import models.entities.AnswerEntity;
import models.entities.CredentialEntity;
import models.entities.HistoryEntity;
import models.entities.InterviewEntity;
import models.entities.InterviewSelectionEntity;
import models.entities.ProfileEntity;
import models.entities.ResultEntity;
import models.entities.UserEntity;
import models.interfaces.MAPFunction;
import models.requestModels.AnswerCollectionRequestModel;
import models.requestModels.CredentialRequestModel;
import models.requestModels.InterviewSelectionRequestModel;
import models.requestModels.UserRequestModel;
import models.responseModels.AnswerCollectionResponseModel;
import models.responseModels.CredentialResponseModel;
import models.responseModels.HistoryResponseModel;
import models.responseModels.InterviewSelectionResponseModel;
import models.responseModels.UserResponseModel;

public class InterviewerMapper {
		
		//convertToURM (convert to User Request Model)
		public static UserRequestModel convertToURM(UserEntity ue, MAPFunction<UserEntity,UserRequestModel> mapfunction)
		{
			return mapfunction.convert(ue);
		}
		//convertToUPF (convert to User Profile)
		public static ProfileEntity convertToUPF(UserResponseModel urm,MAPFunction<UserResponseModel,ProfileEntity> mapfunction)
		{
			return mapfunction.convert(urm);
		}
		
		//convertToCRM (convert to CredentialRequestModel)
		public static CredentialRequestModel convertToCRM(CredentialEntity ce,MAPFunction<CredentialEntity,CredentialRequestModel> mapfunction) 
		{
			return mapfunction.convert(ce);
		}
		//convertToCPF (convert to User Profile)
		public static ProfileEntity convertToCPF(CredentialResponseModel crm,MAPFunction<CredentialResponseModel, ProfileEntity> mapfunction)
		{
			return mapfunction.convert(crm);
		}
		
		
		//convertToISRM (convert to InterviewSelectionRequestModel)
		public static InterviewSelectionRequestModel convertToISRM(InterviewSelectionEntity ise,MAPFunction<InterviewSelectionEntity,InterviewSelectionRequestModel> mapfunction) 
		{
			return mapfunction.convert(ise);
		}
		//convertToISIE (convert to InterviewEntity)
		public static InterviewEntity convertToIE(InterviewSelectionResponseModel isrm,MAPFunction<InterviewSelectionResponseModel, InterviewEntity> mapfunction)
		{
			return mapfunction.convert(isrm);
		}
		
		
		//convertToACRM (convert to AnswerCollectionRequestModel)
		public static AnswerCollectionRequestModel convertToACRM(AnswerCollectionEntity ace,MAPFunction<AnswerCollectionEntity,AnswerCollectionRequestModel> mapfunction)
		{
			return mapfunction.convert(ace);
		}
		//convertToAE (convert to ResultEntity)
		public static ResultEntity convertToRE(AnswerCollectionResponseModel acrm,MAPFunction<AnswerCollectionResponseModel,ResultEntity> mapfunction)
		{
			return mapfunction.convert(acrm);
		}
		
		//convertToHE(convert to HistoryEntity)
		public static HistoryEntity convertToHE(HistoryResponseModel hrm,MAPFunction<HistoryResponseModel,HistoryEntity> mapfunction) {
			return mapfunction.convert(hrm);
		}
		
	}