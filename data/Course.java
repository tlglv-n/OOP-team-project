package data;

import java.util.Objects;

public class Course
{
	private int credits;
	private String idCode;
	private String name;
	public Course(){
		super();
	}
	public void addCourseForRegister(Course course) {
		// TODO implement me
	}
	
	
	public void dropCourseForRegister(Course course) {
		// TODO implement me	
	}

	
	public void assignCourseForTeacher(Course course) {
		// TODO implement me
	}

	public void updateCourse() {
		// TODO implement me	
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
}

