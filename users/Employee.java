package users;

import java.util.Vector;
import data.Message;

public class Employee extends User implements IResearcher{
	
	private Vector <Message> messages;

	protected Employee(){
		super();
	}

	public Employee(String login, String password){
		super(login, password);
	}

	public void addMessage(Message message) {
		
	}
	
	public Vector <Message> getMessages(){
		return messages;
	}

	public void sendMessage(Employee receiver, Message message) {
		
	}
}

