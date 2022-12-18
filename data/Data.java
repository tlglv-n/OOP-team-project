package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Vector;
import users.User;

public final class Data implements Serializable{

	private static final long serialVersionUID = 1L;
	private static Data instance = new Data();
	private final String path = ".\\data_info\\objects.dat";
	private Vector <User> users;
	private HashSet <Course> courses;
	private int usersIdCount;

	private Data(){
		deserialize();
	}
	
	public static Data getInstance() {
		return instance;	
	}

	public String getPath() {
		return path;
	}
	
	public User getUser(String name, String password) {
		return null;	
	}

	public int getNextId(){
		++usersIdCount;
		serialize();
		return usersIdCount;
	}

	public void addUser(User user){
		instance.users.add(user);
		serialize();
	}

	public void addCourse(Course course){
		instance.courses.add(course);
		serialize();
	}

	public Vector <User> getUsers(){
		return users;
	}

	public HashSet <Course> getCourses(){
		return courses;
	}

	public String toString() {
		return "Data's instance: " + instance + ", Path: " + path;
	}

	private static void serialize(){
		try{
			FileOutputStream fos = new FileOutputStream(instance.path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
			oos.close();
			fos.close();
		}
		catch (FileNotFoundException fnfe){
			System.out.println("No such file");
		}
		catch (IOException ioe){
			System.out.println("Wrong file Format");
		}
	}

	private static void deserialize(){
		try{
			FileInputStream fis = new FileInputStream(instance.path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			instance = (Data)ois.readObject();
			ois.close();
			fis.close();
		}
		catch (FileNotFoundException fnfe){
			System.out.println("No such file");
			instance.setDefault();
		}
		catch (IOException ioe){
			System.out.println("Wrong file format");
			instance.setDefault();
		}
		catch (ClassNotFoundException cnfe){
			System.out.println("I don't know what's wrong");
			instance.setDefault();
		}
	}

	private void setDefault(){
		users = new Vector <User>();
		courses = new HashSet <Course>();
		usersIdCount = 0;
	}

}

