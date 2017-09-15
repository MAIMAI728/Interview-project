package ca.cicccc.madp202.test.resources;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ca.cicccc.madp202.test.services.MessagesService;
import ca.cicccc.madp202.test.model.Message;

@Path("messages")
public class MessageResource {
	
	MessagesService messagesService = new MessagesService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return messagesService.getAllMessages();
	}
	
	//testのパスの時だけ"test"が表示される
//	@GET
//	@Path("test")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String test() {
//		return "test";
//	}
	
	//パス"message/"の後、何を書いても"test"で返される
//	@GET
//	@Path("/{messageId}")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String test() {
//		return "test";
//	}
	
	//[long]の時だけ表示、それ以外は404になる
//	@GET
//	@Path("/{messageId}")
//	@Produces(MediaType.APPLICATION_XML)
//	public Message getMessage(@PathParam("messageId")long id) {
//		return messagesService.getMessage(id);
//	}
	
	//[int]/name/[int]の時だけ表示、それ以外は404になる
//	http://localhost:8080/messenger1/webapi/messages/2/name/1
	@GET
	@Path("/{messageId1}/name/{messageId2}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId1")int id1,@PathParam("messageId2")int id2) {
		return messagesService.getMessage(id1);
	}	
	
	
//	@GET //show the http method associated with this method
//	
//	@Produces(MediaType.APPLICATION_XML) //shows the format of response
//	public List<Message> getMessages() {
//		MessagesService ms = new MessagesService();
//		return ms.getAllMessages();
//	}

}
