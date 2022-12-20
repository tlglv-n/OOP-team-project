package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

import users.IResearcher;
import users.Researcher;
import users.User;

public final class Data implements Serializable{

	private static final long serialVersionUID = 1L;
	private static Data instance = new Data();
	private final String path = ".\\data_files\\objects.dat";
	private Vector <User> users;
	private HashSet <Course> courses;
	private Vector <Researcher> researchers;
	private Vector <News> news;
	private int usersIdCount;

	static{
		deserialize();
	}

	private Data(){
	}
	
	public static Data getInstance() {
		return instance;	
	}

	public String getPath() {
		return path;
	}
	
	public User getUser(String name, String password) {
		List <User> temp = users.stream().filter(s->s.verify(name, password)).collect(Collectors.toList());
		if(temp.isEmpty()){
			return null;
		}
		return temp.get(0);
	}

	public boolean deleteUser(User user){
		return users.remove(user);
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

	public void addResearcher(Researcher researcher){
		researchers.add(researcher);
		serialize();
	}

	public Vector <User> getUsers(){
		return users;
	}

	public HashSet <Course> getCourses(){
		return courses;
	}

	public Vector <News> getNews(){
		return news;
	}

	public void addNews(News news){
		this.news.add(news);
	}

	public Vector <Researcher> getResearchers(){
		return researchers;
	}

	public Researcher getResearcher(IResearcher researcher){
		List <Researcher> temp = researchers.stream().filter(r->r.getDecoratedObject().equals(researcher)).collect(Collectors.toList());
		if(temp.isEmpty()){
			return null;
		}
		return temp.get(0);
	}

	public String toString() {
		return "Data's instance: " + instance + ", Path: " + path;
	}

	public static void serialize(){
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

