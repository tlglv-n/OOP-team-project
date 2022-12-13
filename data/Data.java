package data;

import java.io.Serializable;
import java.util.Vector;
import java.util.stream.Collector;

import users.User;

public class Data implements Serializable{

	private static Data instance;
	private Vector <User> users;
	private String path;
	public Data(){
		super();
	}
	
	public static Data getInstance() {
		return instance;	
	}

	public User getUser(String login, String password) {
		users.stream().filter(u-> u.verify(login, password)).collect(Collector.)
	}
	
	public void saveUser(User user) {
		// TODO implement me
	}

	public void save(){

	}

	public void addUser(User user){}
	
}

