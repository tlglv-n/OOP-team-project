package data;

import java.io.Serializable;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.List;

import users.User;

public class Data implements Serializable{

	private static Data instance;
	private Vector <User> users;
	private String path;

	private Data(){
		super();
	}
	
	public static Data getInstance() {
		return instance;	
	}

	public User getUser(String login, String password) {
		List <User> users = this.users.stream().filter(u-> u.verify(login, password)).collect(Collectors.toList());
		if(users.isEmpty()){return null;}
		return users.get(0);
	}
	
	public void saveUser(User user) {
		// TODO implement me
	}

	public void save(){

	}

	public void addUser(User user){}
	
}

