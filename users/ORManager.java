package users ;

import data.Course;
import data.School;
import data.Semester;

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
	
	public void confirmRegistration(Student student, Course course) {
		student.register(course);
	}

	public Course addCourseForRegister(String name, School school, Semester sem) {
		return null;
	}
	
	public void dropCourseForRegister(Course course) {
		// TODO implement me	
	}

	public String toString() {
		return "This is the office registration";
	}

	
}

