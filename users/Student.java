package users;

import java.util.HashMap;
import java.util.Set;
/**import a class Course from package data*/
import data.Course;
/**import a class Mark from package data*/
import data.Mark;
/**import a class Transcript from package data*/
import data.Transcript;
/**import a class PersonalInfo from package personal_info*/
import personal_info.PersonalInfo;
/**import a class Lesson from package data*/
import data.Lesson;

/**
 *The class to create a Student
*/
public class Student extends User implements IResearcher{
	/** field of type of student*/
	private StudentType type;
	/** field of marks of courses*/
	private HashMap <Course, Mark> marksCurrent = new HashMap <Course, Mark>();
	/** field of attendances of lessons*/
	private HashMap <Lesson, Boolean> atttendance = new HashMap <Lesson, Boolean>();
	/** field of transcript of student*/
	private Transcript transcript = new Transcript();
	/**
	 *Constructor-create a new Student
	 *@see Student#Student(String,String)
	 *@see Student#Student(String,String,StudentType)
	*/
	public Student(){
		super();
	}
	/**
	 *Constructor-create a new Student
	 *@see Student#Student()
	 *@see Student#Student(String,String,StudentType)
	*/
	public Student(String login, String password){
		super(login, password);
	}
	/**
	 *Constructor-create a new Student
	 *@see Student#Student()
	 *@see Student#Student(String,String)
	*/
	public Student(String login, String password, StudentType type){
		super(login, password);
		this.type = type;
	}
	/**
	 *Method to get marks of courses of student
	 *@return HashMap<Course,Mark>
	*/
	public HashMap <Course, Mark> getCurrentMarks(){
		return marksCurrent;
	}
	/**
	 *Method to get transcript of student
	 *@return Transcript
	*/
	public Transcript getTranscript(){
		return transcript;
	}
	/**
	 *Method to get attendances of lessons os student
	 *@return HashMap<Lesson,Boolean>
	*/
	public HashMap <Lesson, Boolean> getAttendance(){
		return atttendance;
	}
	/**
	 *Method to set marks of courses
	 *@param c Course name
	 *@param m Mark from F to A
	*/
	public void setMark(Course c, Mark m){
		marksCurrent.put(c, m);
		if(m.getFinal() != -1){
			marksCurrent.remove(c);
			transcript.getMarks().put(c, m);
		}
	}
	/**
	 *Method to verify that the course is chosen by the student
	 *@param c Course object
	 *@return boolean
	*/
	public boolean register(Course c){
		if(!checkRegistration(c)){return false;}
		marksCurrent.put(c, new Mark());
		return true;
	}
	/**
	 *Method to check that a student can take a course
	 *@param c Course object
	 *@return boolean
	*/
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
	/**
	 *Method to get info about Teacher
	 *@param t Teacher object
	 *@return PersonalInfo
	*/
	public PersonalInfo getTeacherInfo(Teacher t){
		return t.getPersonalInfo();
	}
	/**
	 *Method to get type of student
	 *@return StudentType
	*/
	public StudentType getStudentType() {
		return type;
	}
	/**
     	 *Method to print info about student
    	*/
	public String toString() {
		return type + " " +  super.toString().replace("User", "Student");
	}
	/**
	 *Method to create researcher from student
	 *@return Researcher
	*/
	public Researcher becomeResearcher(){
		return new Researcher(this);
	}
	/**
	 *Method to get list of courses that is taken by student
	 *@return Set<Course>
	*/
	public Set <Course> getCourses(){
		return marksCurrent.keySet();
	}
	/**
	 *Method to drop course that is taken by student
	 *@param c Course object
	*/
	public void dropCourse(Course c){
		marksCurrent.remove(c);
	}
	/**
	 *Method to put completed courses in the transcript
	*/
	public void checkCourses(){
		for(Course cur: marksCurrent.keySet()){
			if(marksCurrent.get(cur).getFinal() != -1){
				transcript.getMarks().put(cur, marksCurrent.get(cur));
				marksCurrent.remove(cur);
			}
		}
	}
}
