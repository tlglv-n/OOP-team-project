package data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Vector;

import javax.crypto.spec.PBEKeySpec;

import users.User;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public final class Data{

	private static Data instance = new Data();
	private static final String path = ".\\data_info\\";
	private Vector <User> users;
	private HashSet <Course> courses;

	private Data(){
		Object o1 = getObject("users.dat");
		if(o1 instanceof Vector <User>){
			users = (Vector <User>) o1;
		}
		Object o2 = getObject("courses.dat");
		if(o2 instanceof HashSet <Course>){
			courses = (HashSet <Course>) o2;
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
		saveObject("users.data", users);
		saveObject("courses.dat", courses);
	}

	public int hashCode() {
		return Objects.hash(instance);	
	}
	public String toString() {
		return "Data's instance: " + instance + ", Path: " + path;
	}

	private void saveObject(String filename, Object o){
		try{
			FileOutputStream fos = new FileOutputStream(path + filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
			fos.close();
		}
		catch (FileNotFoundException fnfe){
			System.out.println("No file");
		}
		catch (IOException ioe){
			System.out.println("Something wrong with file");
		}
	}

	private Object getObject(String filename){
		try{
			FileInputStream fis = new FileInputStream(path + filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			ois.close();
			fis.close();
			return o;
		}
		catch (FileNotFoundException fnfe){
			System.out.println("No file");
			return null;
		}
		catch (IOException ioe){
			System.out.println("Something wrong with file");
			return null;
		}
		catch (ClassNotFoundException cnfe){
			System.out.println("Pretty much impossible");
			return null;
		}

	}
}

