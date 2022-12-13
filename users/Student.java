package users;

import java.util.HashMap;
import data.Course;
import data.Mark;
import data.Lesson;


public class Student extends User implements IResearcher{
	
	private StudentType studentType;
	
	public void getMarks(){}
	
	public void register(Course c){}
	
	public String getTeacherInfo(Teacher t){return null;}
	
	public void rateTeacher(Teacher t, int rating) {}
	
	public Student(){
		super();
	}

	public void askTeacher() {
		// TODO implement me	
	}

	public void toRequest(Student student, String text) {
		// TODO implement me	
	}
	
	public void setFinancialInfo() {
		// TODO implement me	
	}
	
}

