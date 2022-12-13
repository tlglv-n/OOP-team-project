package data;

import users.Employee;
import java.util.Objects;

public class Message{

	private Employee sender;
	private String theme;
	private String text;
	private boolean read = false;

	public Message(){
		super();
	}

	public Message(Employee sender){
		this.sender = sender;
	}

	public Message(Employee sender, String theme){
		this(sender);
		setTheme(theme);
	}

	public Message(Employee sender, String theme, String text){
		this(sender, theme);
		setText(text);
	}

	public Employee getSender(){
		return sender;
	}

	public boolean getRead(){
		return read;
	}

	public String getTheme(){
		return theme;
	}

	public String getText(){
		return text;
	}

	public void setRead(){
		this.read = true;
	}

	public void setTheme(String theme){
		this.theme = theme;
	}

	public void setText(String text){
		this.text = text;
	}

	public int hashCode(){
		return Objects.hash(sender, theme, text);
	}

	public boolean equals(Object o){
		if(o == null){return false;}
		if(this == o){return true;}
		if(this.getClass() != o.getClass()){return false;}
		Message m = (Message) o;
		return this.sender.equals(m.sender) && this.theme.equals(m.theme) && this.text.equals(m.text);
	}

	public String toString(){
		return "Sender: " + sender + "\n" + "Theme: " + theme + "\n" + text;
	}

}

