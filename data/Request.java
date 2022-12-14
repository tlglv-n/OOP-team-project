package data ;

import java.io.Serializable;
import java.util.Objects;

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
	public void setSender(Student sender) {
		this.sender = sender;
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

	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(executed, sender);
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		if (getClass() != obj.getClass()) return false;
		Request other = (Request) obj;
		return executed == other.executed && Objects.equals(sender, other.sender);
	}

	public String toString() {
		return "Request [executed=" + executed + ", sender=" + sender + "]";
	}
	
	
	
}

