package users;

import java.util.HashMap;
import data.Course;
import data.Mark;
import data.Lesson;


public class Student extends User implements IResearcher{
	
	private StudentType studentType = StudentType.BACHELOR;
	private HashMap <Course, Mark> marks;
	private HashMap <Lesson, Boolean> attendance;

	protected Student(){
		super();
	};

	public Student(String login, String password){
		super(login, password);
	}

	public Student(String login, String password, StudentType studentType){
		this(login, password);
		setStudentType(studentType);
	}
	
	public HashMap <Course, Mark> getMarks(){
		return marks;
	}

	public HashMap <Lesson, Boolean> getAttendance(){
		return attendance;
	}
	
	public void register(Course c){
		// Implement
	}
	
	public String getTeacherInfo(Teacher t){
		// Implement
		return null;
	}
	
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

	public Researcher becomeResearcher(){
		return new Researcher(this);
	}

	public StudentType getType(){
		return studentType;
	}

	public void setStudentType(StudentType studentType){
		this.studentType = studentType;
	}
	
}

