package users;

import java.util.HashMap;
import java.util.Vector;

import data.Request;

public class Manager extends Employee implements CanHaveRequest{
	
	private static final long serialVersionUID = 1L;
	private static Vector <Manager> listManagers;
	private static HashMap <Student, Vector <Request>> requests;

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

	public String toString() {
		return super.toString().replace("Employee", "Manager");
	}

	@Override
	public void fullfillRequest(Request r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRequest(Request r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void declineRequest(Request r) {
		// TODO Auto-generated method stub
		
	}

	public static HashMap <Student, Vector <Request>> getAllRequests(){
		return requests;
	}
	
}

