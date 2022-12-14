package users;

import data.Course;

public class SchoolManager extends Manager{
	
	public SchoolManager(){
		super();
	}

	public SchoolManager(String login, String password){
		super(login, password);
	}
	
	public void assignCourseToTeacher(Course parameter2, Teacher parameter3) {	
	}
	
	public void updateCourse() {
		// TODO implement me	
	}
	
	public void assignCourseForTeacher(Course course) {
		// TODO implement me
	}
	public String toString() {
		return "This is school manager";
	}
}

