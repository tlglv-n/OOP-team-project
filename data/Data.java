package data;

import java.util.Objects;

import users.User;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;

public class Data
{
	private Data instance;
	private String path;
	public Data(){
		super();
	}
	
	public Data getInstance() {
		return instance;	
	}
	public String getPath() {
		return path;
	}
	
	public User getUser(String name, String password) {
		return null;	
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
	public int hashCode() {
		return Objects.hash(instance);	
	}
	public String toString() {
		return "Data's instance: " + instance + ", Path: " + path;
	}
	
	
	
}

