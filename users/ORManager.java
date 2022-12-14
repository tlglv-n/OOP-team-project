package users ;

import data.Course;
import data.Mark;
import data.School;

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
		student.getMarks().put(course, new Mark());
	}
	
	public Course addCourseForRegister(String name, School school, Semester sem) {
	}
	
	public void dropCourseForRegister(Course course) {
		// TODO implement me	
	}

	public String toString() {
		return "This is the office registration";
	}

	
}

