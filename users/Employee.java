package users;

import java.util.Vector;
import java.util.Collection;
import data.Message;

public class Employee extends User implements IResearcher{
	
	private Vector <Message> messages = new Vector <Message>();

	protected Employee(){
		super();
	}

	public Employee(String login, String password){
		super(login, password);
	}

	public void addMessage(Message message) {
		messages.add(message);
	}

	public void addMessages(Collection <Message> messages){
		this.messages.addAll(messages);
	}
	
	public Vector <Message> getMessages(){
		return messages;
	}

	public void sendMessage(Employee receiver, Message message) {
		
	}

	public Researcher becomeResearcher(){
		return new Researcher(this);
	}
}

