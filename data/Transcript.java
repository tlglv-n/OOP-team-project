package data;

import java.util.HashMap;
import java.util.Objects;


public class Transcript
{
	private HashMap <Course, Mark> marks;
	private int totalCredits;
	private double gpa;

	public Transcript(){
		super();
	}

	public HashMap<Course, Mark> getMarks() {
		return marks;
	}

	public void setMarks(HashMap<Course, Mark> marks) {
		this.marks = marks;
	}

	public int getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int hashCode() {
		return Objects.hash(gpa, marks, totalCredits);
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Transcript other = (Transcript) obj;
		return this.gpa == other.gpa && Objects.equals(marks, other.marks)
				&& totalCredits == other.totalCredits;
	}

	public String toString() {
		return "Transcript [marks=" + marks + ", totalCredits=" + totalCredits + ", gpa=" + gpa + "]";
	}
	

}

