package ca.cicccc.madp202.test.model;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Message {
	private long id;
	private String message;
	private Date created;
	private String outher;
	
	
	//constructor
	public Message(long id, String message, String outher) {
		super();
		this.id = id;
		this.message = message;
		this.outher = outher;
		this.created = new Date();
	}
	public Message() {
		
	}
	
	//getter and setter
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getOuther() {
		return outher;
	}
	public void setOuther(String outher) {
		this.outher = outher;
	}


}
