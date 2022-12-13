package data;

import users.Employee;

public class Message{

	private String theme;
	private String text;
	private Employee sender;

	public Message(){
		super();
	}

	public Message(Employee e, String theme, String text){
		this.sender = e;
		this.theme = theme;
		this.text = text;
	}

}

