package ca.cicccc.madp202.test.services;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import ca.cicccc.madp202.test.database.DatabaseClass;
import ca.cicccc.madp202.test.model.Message;

public class MessagesService {

	//	★Using HashMap
		private Map<Long, Message> messages = DatabaseClass.getMessages();
		
		public List<Message> getAllMessages(){
			return new ArrayList<Message>(messages.values());
		}
		
		//GET idを取得する
		public Message getMessage(long id) {
			return messages.get(id);
		}
		
		//POST keyのindexを1つづつ足していく
		public Message addMessage(Message message) {
			message.setId(messages.size() + 1);
//			messages.put(key, value)
			messages.put(message.getId(), message);
			return message;
		}
		
		//PUT 0(id doesn't exist)だったときはnull、それ以外はkey(id)とvalue(message)を上書きしていく
		public Message updateMessage(Message message) {
			if(message.getId() <= 0) {
				return null;
			}
//			messages.put(key, value)
			messages.put(message.getId(), message);
			return message;
		}
		
		//DELETE idを削除する
		public Message removeMessage(long id) {
//			return messages.remove(key);
			return messages.remove(id);	
		}
	
	
		
	//★Using ArrayList
//	public List<Message> getAllMessages()
//	{
//		//long id, String message, Date created, String outher
//
//		Message m1 = new Message(21,"Message1","Ali");
//		Message m2 = new Message(21,"Message2","Riza");
//		
//		ArrayList<Message> list = new ArrayList<>();
//		
//		list.add(m1);
//		list.add(m2);
//		
//		return list;
//	}
		
}
