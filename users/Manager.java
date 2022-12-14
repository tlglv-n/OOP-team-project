package users;

import java.util.Vector;
import data.Request;
import personal_info.PersonalInfo;

public class Manager extends Employee implements CanHaveRequest{
	
	private static final long serialVersionUID = 1L;
	private static Vector <Request> requests;

	public Manager(){
		super();
	}

	public Manager(String login, String password){
		super(login, password);
	}
	
	public PersonalInfo getTeacherInfo(Teacher teacher) {
		return teacher.getPersonalInfo();
	}
	
	public PersonalInfo getStudentInfo(Student student) {
		return student.getPersonalInfo();
	}

	public String toString() {
		return super.toString().replace("Employee", "Manager");
	}

	public void fullfillRequest(Request r) {
		r.execute();
		requests.remove(r);
	}

	public Request getFirstRequest(){
		if(!requests.isEmpty()) {return null;}
		return requests.elementAt(0);
	}

	public static void addRequest(Request r) {
		requests.add(r);
	}

	public void declineRequest(Request r) {
		requests.remove(r);
	}

	public static Vector <Request> getAllRequests(){
		return requests;
	}

}

