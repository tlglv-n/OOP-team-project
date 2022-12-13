package data;

import java.util.Objects;

public class ResearchPaper
{
	private String name;
	private boolean finished;
	private String theme;
	private String fieldOfStudy;

	public ResearchPaper(){
		super();
	}
	public String getName() {
		return name;
	}
	public boolean isFinished() {
		return finished;
	}
	public String getTheme() {
		return theme;
	}
	public String getFieldOfStudy() {
		return fieldOfStudy;
	}
	public boolean equals(Object o) {
		if(o == null) {return false;}
		if(this == o) {return true;}
		if(this.getClass() != o.getClass()) {return false;}
		ResearchPaper r = (ResearchPaper) o;
		return this.name.equals(r.name) && finished == r.finished
				&& this.fieldOfStudy.equals(r.fieldOfStudy) && this.theme.equals(r.theme);
	}
	public int hashCode() {
		return Objects.hash(name, finished, fieldOfStudy, theme);	
	}
	public String toString() {
		String status = "";
		if(finished) status += "Yes";
		else status += "No";
		return "Research paper's name: " + name + ", Status: " + status
				+ ", The field of study: " + fieldOfStudy + "Paper's theme:" + theme;
	}


}

