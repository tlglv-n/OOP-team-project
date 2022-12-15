package data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Vector;

import users.User;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public final class Data{

	private static Data instance;
	private static String path;
	private Vector <User> users;
	private HashSet <Course> courses;

	private Data(){
		try{
			FileInputStream fis = new FileInputStream(path + "\\data.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Data temp = (Data)ois.readObject();
			instance = temp.instance;
			this.users = temp.users;
			ois.close();
			fis.close();
		}
		catch (FileNotFoundException fnfe){
			System.out.println("No file");
		}
		catch (IOException ioe){
			System.out.println("Something wrong with file");
		}
		catch (ClassNotFoundException cnfe){
			System.out.println("I don't know how to handle this properly");
		}
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

	public void addUser(User user){
		instance.users.add(user);
	}

	public void serialize(){
		try{
			FileOutputStream fos = new FileOutputStream(path + "\\data.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
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

