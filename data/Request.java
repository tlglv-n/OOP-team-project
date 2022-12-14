package data ;

import java.io.Serializable;
import users.Student;


public class Request extends Message implements Serializable{

	private boolean executed = false;
	private Student sender;

	public Request(){
		super();
	}

	public Request(Student sender, String theme, String text){
		this.sender = sender;
		setTheme(theme);
		setText(text);
	}

	public void execute() {
		this.executed = true;	
	}

	public boolean getExecuted(){
		return executed;
	}

	public Student getSender(){
		return sender;
	}
	
}

