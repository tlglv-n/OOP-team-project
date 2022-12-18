package data;

import java.io.Serializable;
import java.util.Objects;
import users.Teacher;

public class Course implements Serializable{

	private static final long serialVersionUID = 1L;
	private int credits;
	private String idCode;
	private String name;
	private Teacher lector;
	private Teacher practice;

	public Course(){}

	public Course(String idCode){
		setIdCode(idCode);
	}

	public Course(String idCode, int credits){
		this(idCode);
		setCredits(credits);
	}

	public Course(String idCode, int credits, String name){
		this(idCode, credits);
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
				+ ", ID code: " + idCode;
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

}

