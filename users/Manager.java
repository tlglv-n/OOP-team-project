package users;

import java.util.HashMap;
import java.util.Vector;

import data.Request;

public class Manager extends Employee{
	
	private static final long serialVersionUID = 1L;
	private static Vector <Manager> listManagers;
	private static HashMap<Student, Request> requests;

	public Manager(){
		super();
	}

	public Manager(String login, String password){
		super(login, password);
	}
	
	public String getTeacherInfo(Teacher teacher) {
		// TODO implement me
		return "";	
	}
	
	public String getStudentInfo(Student student) {
		// TODO implement me
		return "";	
	}

	public String getStudentsRequests() {
		// TODO implement me
		return "";	
	}
	
	
	public void getStudentFinancialInfo() {
		// TODO implement me	
	}

	public static Vector <Manager> getManagers(){
		return listManagers;
	}
	public int compareTo(Manager o) {
		if(listManagers.size() > o.listManagers.size()) {return 1;}
		if(listManagers.size() < o.listManagers.size()) {return -1;}
		return 0;
	}
	public String toString() {
		return "This is manager";
	}
	
}

