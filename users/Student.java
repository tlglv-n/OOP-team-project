package users;

import java.util.HashMap;
import java.util.Set;

import data.Course;
import data.Mark;
import data.Transcript;
import personal_info.PersonalInfo;
import data.Lesson;


public class Student extends User implements IResearcher{
	
	private StudentType type;
	private HashMap <Course, Mark> marksCurrent = new HashMap <Course, Mark>();
	private HashMap <Lesson, Boolean> atttendance = new HashMap <Lesson, Boolean>();;
	private Transcript transcript = new Transcript();

	public Student(){
		super();
	}

	public Student(String login, String password){
		super(login, password);
	}

	public Student(String login, String password, StudentType type){
		super(login, password);
		this.type = type;
	}
	
	public HashMap <Course, Mark> getCurrentMarks(){
		return marksCurrent;
	}

	public Transcript getTranscript(){
		return transcript;
	}

	public HashMap <Lesson, Boolean> getAttendance(){
		return atttendance;
	}

	public void setMark(Course c, Mark m){
		marksCurrent.put(c, m);
		if(m.getFinal() != -1){
			marksCurrent.remove(c);
			transcript.getMarks().put(c, m);
		}
	}
	
	public boolean register(Course c){
		if(!checkRegistration(c)){return false;}
		marksCurrent.put(c, new Mark());
		return true;
	}

	public boolean checkRegistration(Course c){
		int cnt = 0;
		for(Course cur: marksCurrent.keySet()){
			cnt += cur.getCredits();
		}
		if(cnt + c.getCredits() > 21){
			return false;
		}
		return true;
	}
	
	public PersonalInfo getTeacherInfo(Teacher t){
		return t.getPersonalInfo();
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

	public Set <Course> getCourses(){
		return marksCurrent.keySet();
	}

	public void dropCourse(Course c){
		marksCurrent.remove(c);
	}
}
