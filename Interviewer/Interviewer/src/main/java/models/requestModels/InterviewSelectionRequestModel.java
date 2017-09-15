package models.requestModels;
import models.entities.Topic;

public class InterviewSelectionRequestModel {
	
	private Topic topic;

	public InterviewSelectionRequestModel() {
	}
	
	public InterviewSelectionRequestModel(Topic topic) {
		this.topic = topic;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
