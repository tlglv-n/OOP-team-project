package users;

import java.util.HashMap;
import data.Course;
import data.Mark;
import personal_info.PersonalInfo;
import data.Lesson;


public class Student extends User implements IResearcher{
	
	private StudentType type;
	private HashMap <Course, Mark> marks;
	private HashMap <Lesson, Boolean> atttendance;

	public Student(){
		super();
	}

	public Student(String login, String password){
		super(login, password);
	}
	
	public HashMap <Course, Mark> getMarks(){
		return marks;
	}

	public HashMap <Lesson, Boolean> getAttendance(){
		return atttendance;
	}
	
	public void register(Course c){}
	
	public PersonalInfo getTeacherInfo(Teacher t){
		return t.getPersonalInfo();
	}
	
	public void rateTeacher(Teacher t, int rating) {}


	public void askTeacher() {
		// TODO implement me	
	}

	public void toRequest(Student student, String text) {
		// TODO implement me	
	}

	public StudentType getStudentType() {
		return type;
	}
	
	public String toString() {
		return type + " " +  super.toString().replace("User", "Student");
	}

	public Researcher becomeResearcher(){
		return new Researcher(this);
	}
}
