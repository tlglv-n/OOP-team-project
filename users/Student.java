package users;

import java.util.HashMap;
import data.Course;
import data.Mark;
import data.Lesson;


public class Student extends User implements IResearcher{
	
	private StudentType studentType;
	private HashMap <Course, Mark> marks;
	private HashMap <Lesson, Boolean> atttendance;

	public Student(){
		super();
	}

	public Student(String login, String password){
		super(login, password);
	}
	
	public void getMarks(){}
	
	public void register(Course c){}
	
	public String getTeacherInfo(Teacher t){return null;}
	
	public void rateTeacher(Teacher t, int rating) {}


	public void askTeacher() {
		// TODO implement me	
	}

	public void toRequest(Student student, String text) {
		// TODO implement me	
	}
	
	public void setFinancialInfo() {
		// TODO implement me	
	}
	public StudentType getStudentType() {
		return studentType;
	}
	
	public String toString() {
		return "This is student";
	}
}

