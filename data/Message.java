package data;

import java.io.Serializable;
import java.util.Objects;

import users.Employee;

public class Message implements Serializable{

	private static final long serialVersionUID = 1L;
	private String theme;
	private String text;
	private Employee sender;

	public Message(){
		super();
	}

	public Message(Employee sender, String theme, String text){
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
	public void setSender(Employee sender) {
		this.sender = sender;
	}
	public String getTheme() {
		return theme;
	}

	public String getText() {
		return text;
	}

	public Employee getSender() {
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
		return sender.equals(other.sender) && theme.equals(other.theme) && text.equals(other.text);
	}
	public String toString() {
		return "Message [theme=" + theme + ", text=" + text + ", sender=" + sender + "]";
	}
	
}

