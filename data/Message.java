package data;

import java.util.Objects;

import users.Employee;
import users.Student;

public class Message{

	private String theme;
	private String text;
	private Student sender;

	public Message(){
		super();
	}

	public Message(Student sender, String theme, String text){
		this.sender = sender;
		this.theme = theme;
		this.text = text;
	}

	public void setTheme(String theme){
		this.theme = theme;
	}

	public void setText(String text){
		this.text = text;
	}
	public void setSender(Student sender) {
		this.sender = sender;
	}
	public String getTheme() {
		return theme;
	}

	public String getText() {
		return text;
	}

	public Student getSender() {
		return sender;
	}
	public int hashCode() {
		return Objects.hash(sender, text, theme);
	}
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Message other = (Message) obj;
		return Objects.equals(sender, other.sender) && Objects.equals(text, other.text)
				&& Objects.equals(theme, other.theme);
	}
	public String toString() {
		return "Message [theme=" + theme + ", text=" + text + ", sender=" + sender + "]";
	}
	
}

