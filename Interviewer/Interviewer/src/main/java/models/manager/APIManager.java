package models.manager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.InterviewerMapper;
import models.InterviewerMapperImplementation;
import models.entities.AnswerCollectionEntity;
import models.entities.AnswerEntity;
import models.entities.CredentialEntity;
import models.entities.HistoryEntity;
import models.entities.InterviewEntity;
import models.entities.InterviewSelectionEntity;
import models.entities.ProfileEntity;
import models.entities.ResultEntity;
import models.entities.Topic;
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

public class APIManager {
	String baseUrl = "http://localhost:8080/InterviewerBackend/webapi";
    Client client = ClientBuilder.newClient();
    
	public ProfileEntity createUser(UserEntity ue) {
		//UserEntity(ue) → convert → UserRequestModel
		//ラムダでの書き方(UserEntity ue) -> { return new UserRequestModel(ue firstname,ue lastname...)};
		//method reference "(インスタンスメソッドの場合)インスタンス変数名::メソッド名"
		//InterviewerMapperImplementation :: convertToURM
		UserRequestModel ur = InterviewerMapper.convertToURM (ue, InterviewerMapperImplementation::convertToURM);
		//send a JSON(http) request
        WebTarget webTarget = client.target(baseUrl).path("/interview/users");
        Entity entity = Entity.entity(ur, MediaType.APPLICATION_JSON);
		// request by GET method without body
        Response res = webTarget.request(MediaType.TEXT_PLAIN).accept(MediaType.APPLICATION_JSON).post(entity);
        // check response. Now we're checking only status code.
        if (res.getStatus() != Response.Status.OK.getStatusCode()) {
        		System.out.println("error");
            return null;
        }
        //JSON request → convert → UserResponseModel
        ProfileEntity pe = res.readEntity(ProfileEntity.class);      
        //check
        System.out.println("UserResponse=" + pe.getAuthtoken() + " " + pe.getUserid());
		//UserResponseModel → convert → ProfileEntity
//		ProfileEntity pe = InterviewerMapper.convertToUPF(urm, InterviewerMapperImplementation::convertToUPF);
		//return ProfileEntity;
		return pe;
	}
	
	
	public ProfileEntity loginUser(CredentialEntity ce) {
		//CredentialEntity(ce) → convert → CredentialRequestModel
		CredentialRequestModel ur =InterviewerMapper.convertToCRM(ce,InterviewerMapperImplementation::convertToCRM);
		
        WebTarget webTarget = client.target(baseUrl).path("/interview/login");
        Entity entity = Entity.entity(ur, MediaType.APPLICATION_JSON);
        Response res = webTarget.request(MediaType.TEXT_PLAIN).accept(MediaType.APPLICATION_JSON).post(entity);   
        if (res.getStatus() != Response.Status.OK.getStatusCode()) {
        		System.out.println(res.readEntity(String.class));
            return null;
        }
        ProfileEntity pe = res.readEntity(ProfileEntity.class);
        //check
//		ProfileEntity pe = InterviewerMapper.convertToCPF(crm, InterviewerMapperImplementation::convertToCPF);
		return pe;
	}

	public InterviewEntity getInterview(Topic topic) {
		//HTTP
		WebTarget webTarget = client.target(baseUrl).path("/interview/topics/" + topic.name().toString());
        Response res = webTarget.request(MediaType.TEXT_PLAIN).accept(MediaType.APPLICATION_JSON).get();
        if (res.getStatus() != Response.Status.OK.getStatusCode()) {
        		System.out.println("error"+res.getStatus());
            return null;
        }
        InterviewEntity ie = res.readEntity(InterviewEntity.class);		
		return ie;
	}
	
	//answer Response
	public ResultEntity submitAnswer(AnswerCollectionEntity ace) {
		//AnswerCollectionEntity → AnswerCollectionRequestModel
		AnswerCollectionRequestModel acr = InterviewerMapper.convertToACRM(ace,InterviewerMapperImplementation::convertToACRM);
		
		//HTTP
		WebTarget webTarget = client.target(baseUrl).path("/interview/interview/" + ace.getInterviewid());
        Entity entity = Entity.entity(acr, MediaType.APPLICATION_JSON);
        Response res = webTarget.request().post(entity);
//        if (res.getStatus() != Response.Status.OK.getStatusCode()) {
//        		System.out.println("error");
//            return null;
//        }
        AnswerCollectionResponseModel acrm = res.readEntity(AnswerCollectionResponseModel.class);
		ResultEntity resultEntity = InterviewerMapper.convertToRE(acrm,InterviewerMapperImplementation::convertToRE);
		//AnswerCollectionResponseModel → ResultEntity
		return resultEntity;
	}

	//history
	public HistoryEntity[] interviewHistory(ProfileEntity pe) {
		//Useridを使うのでオブジェクトをpostせずgetで良い
		//HTTP
		WebTarget webTarget = client.target(baseUrl).path("/interview/history/user/"+pe.getUserid());
        Response res = webTarget.request(MediaType.TEXT_PLAIN).accept(MediaType.APPLICATION_JSON).get();
        if (res.getStatus() != Response.Status.OK.getStatusCode()) {
        		System.out.println("error");
            return null;
        }
        HistoryEntity[] he = res.readEntity(HistoryEntity[].class);
		return he;
	}
}
