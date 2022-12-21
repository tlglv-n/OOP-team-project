package users;

import data.Course;
import data.School;

public class SchoolManager extends Manager{
	
	private School school;
	
	public SchoolManager(){
		super();
	}

	public SchoolManager(String login, String password){
		super(login, password);
	}
	
	public void assignCourseToTeacherLector(Course c, Teacher t) {
		c.setLector(t);	
	}

	public void assignCourseToTeacherPractice(Course c, Teacher t){
		c.setPracticeTeacher(t);
	}
	
	public String toString() {
		return super.toString().replace("Manager", "SchoolManager");
	}

	public School getSchool(){
		return school;
	}

	public void setSchool(School school){
		this.school = school;
	}

}

