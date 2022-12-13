package data;

import java.io.Serializable;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;

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

	public void save(){

	}

	public void addUser(User user){
		instance.users.add(user);
	}

	public void serialize(){
		try{
			FileOutputStream fos = new FileOutputStream(this.path + "\\data.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.users);
			oos.close();
			fos.close();
		}
		catch (FileNotFoundException fnfe){
			System.out.println("NoOOOO");
		}
		catch (IOException ioe){
			System.out.println("You got the wrong file, the leather club is to blocks down");
		}
	}
}

