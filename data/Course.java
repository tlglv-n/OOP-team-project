package data;

import java.io.Serializable;
import java.util.Objects;
import users.Teacher;

public class Course implements Serializable{

	private static final long serialVersionUID = 1L;
	private int credits;
	private String idCode = "default";
	private String name;
	private Teacher lector = new Teacher();
	private Teacher practice = new Teacher();
	private School school;

	{
		Data.getInstance().addCourse(this);
	}

	public Course(){}

	public Course(School school){
		setSchool(school);
	}

	public Course(School school, String idCode){
		this(school);
		setIdCode(idCode);
	}

	public Course(School school, String idCode, int credits){
		this(school, idCode);
		setCredits(credits);
	}

	public Course(School school, String idCode, int credits, String name){
		this(school, idCode, credits);
		setName(name);
	}

	public int getCredits() {
		return credits;
	}
 
	public String getIdCode() {
		return idCode;
	}

	public String getName() {
		return name;
	}

	public boolean equals(Object o) {
		if(o == null) {return false;}
		if(this == o) {return true;}
		if(this.getClass() != o.getClass()) {return false;}
		Course c = (Course) o;
		return idCode.equals(c.idCode);
	}

	public int hashCode() {
		return Objects.hash(idCode);	
	}

	public String toString() {
		return "Course's name: " + name + ", credits: " + credits
				+ ", ID code: " + idCode + ' ' + lector + ' ' + practice;
	}
	
	public int compareTo(Course c) {
		if(credits > c.credits) {return 1;}
		if(credits < c.credits) {return -1;}
		return 0;
	}

	public Teacher getLector(){
		return lector;
	}

	public Teacher getPracticeTeacher(){
		return practice;
	}

	public void setLector(Teacher t){
		lector = t;
	}

	public void setPracticeTeacher(Teacher t){
		practice = t;
	}

	public void setCredits(int credits){
		this.credits = credits;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setIdCode(String idCode){
		this.idCode = idCode;
	}

	public void setSchool(School school){
		this.school = school;
	}

	public School getSchool(){
		return school;
	}
}

