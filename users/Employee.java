package users;

import java.util.Vector;
import data.Message;
import data.Request;

public class Employee extends User implements IResearcher{
	
	private Vector <Message> allMessages;

	public void addMessage(Message message) {
		
	}
	
	public Vector <Message> getMessages(){
		return null;
	}

	public void sendMessage(Employee receiver, Message message) {
		
	}
	
	public Employee(){
		super();
	}
}

