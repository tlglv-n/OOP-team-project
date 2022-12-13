package users ;

import data.Course;

public class ORManager extends Manager{

	public ORManager(){
		super();
	}

	public ORManager(String login, String password){
		super(login, password);
	}

	
	public void manageSchedule() {
		// TODO implement me	
	}

	
	public void confirmRegistration(Student parameter, Course parameter2) {
		// TODO implement me	
	}
	
	public void addCourseForRegister(Course course) {
	}
	
	public void dropCourseForRegister(Course course) {
		// TODO implement me	
	}
	
	public void register() {
		// TODO implement me	
	}
	public String toString() {
		return "This is the office registration";
	}

	
}

