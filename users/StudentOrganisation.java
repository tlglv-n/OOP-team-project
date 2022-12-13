package users;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

public class StudentOrganisation implements Serializable, Comparable <StudentOrganisation>{

	private static final long serialVersionUID = 1L;
	private String name;
	private String desc;
	private Vector <Student> members;
	
	protected StudentOrganisation() {}
	
	public StudentOrganisation(String name) {
		this.name = name;
	}
	
	public StudentOrganisation(String name, String desc) {
		this(name);
		setDesc(desc);
	}
	
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Vector <Student> getMembers(){
		return members;
	}
	
	public void addMember(Student member) {
		members.add(member);
	}
	
	public void addMembers(Vector <Student> members) {
		this.members.addAll(members);
	}
	
	public String toString() {
		return "StudentOrganisation(name: " + name + ")";
	}
	
	public boolean equals(Object o) {
		if(o == null) {return false;}
		if(this == o) {return true;}
		if(this.getClass() != o.getClass()) {return false;}
		StudentOrganisation so = (StudentOrganisation) o;
		return this.name.equals(so.name) && this.desc.equals(so.desc) && this.members.equals(so.members);
	}
	
	public int hashCode() {
		return Objects.hash(name, desc, members);
	}

	public int compareTo(StudentOrganisation o) {
		if(members.size() > o.members.size()) {return 1;}
		if(members.size() < o.members.size()) {return -1;}
		return 0;
	}

}

