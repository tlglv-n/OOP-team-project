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
		messages.add(message);
	}
	
	public Vector <Message> getMessages(){
		return messages;
	}

//	public void sendMessage(Employee receiver, String theme, String text){
//		receiver.addMessage(new Message(this, theme, text));
//	}
// 	receiver is Student

	public String toString() {
		return super.toString().replace("User", "Employee");
	}

	public Researcher becomeResearcher(){
		return new Researcher(this);
	}
}

