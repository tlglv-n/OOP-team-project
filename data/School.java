package data;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

public class School implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String studies;
	private Vector <String> programs;

	{
		Data.getInstance().addSchool(this);
	}
	
	public School(){
		super();
	}

	public School(String name){
		setName(name);
	}

	public School(String name, String studies){
		this(name);
		setStudies(studies);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudies() {
		return studies;
	}

	public void setStudies(String studies) {
		this.studies = studies;
	}

	public Vector<String> getPrograms() {
		return programs;
	}

	public void setPrograms(Vector<String> programs) {
		this.programs = programs;
	}
	
	public int hashCode() {
		return Objects.hash(name, programs, studies);
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		School other = (School) obj;
		return Objects.equals(name, other.name) && Objects.equals(programs, other.programs)
				&& Objects.equals(studies, other.studies);
	}
	
	public String toString() {
		return "School [name=" + name + ", studies=" + studies + ", programs=" + programs + "]";
	}
	

}

