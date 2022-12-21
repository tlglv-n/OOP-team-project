package users;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;
/**
 *The class to create a organization of students
 */
public class StudentOrganisation implements Serializable, Comparable <StudentOrganisation>{
	/**@serial serialVersionUID static final field for specifying the version of serialized data */
	private static final long serialVersionUID = 1L;
	/** field of name of organization*/
	private String name;
	/** field of description of organization*/
	private String desc;
	/** field of list of the student in organization */
	private Vector <Student> members;
	/**
	 *Constructor-create a new students organization
	 *@see StudentOrganisation#StudentOrganisation(String)
	 *@see StudentOrganisation#StudentOrganisation(String, String)
	*/
	protected StudentOrganisation() {}
	/**
	 *Constructor-create a new students organization
	 *@param name The name of organization 
	 *@see StudentOrganisation#StudentOrganisation()
	 *@see StudentOrganisation#StudentOrganisation(String, String)
	*/
	public StudentOrganisation(String name) {
		this.name = name;
	}
	/**
	 *Constructor-create a new students organization
	 *@param name The name of organization 
	 *@param desc The description of organization
	 *@see StudentOrganisation#StudentOrganisation()
	 *@see StudentOrganisation#StudentOrganisation(String)
	*/
	public StudentOrganisation(String name, String desc) {
		this(name);
		setDesc(desc);
	}
	/**
	 *Method for get name of organization 
	 *@return String 
	*/
	public String getName() {
		return name;
	}
	/**
	 *Method for get description of organization 
	 *@return String 
	*/
	public String getDesc() {
		return desc;
	}
	/**
	 *Method for set name of organization
	 *@param name The name of organization 
	*/
	public void setName(String name) {
		this.name = name;
	}
	/**
	 *Method for set description of organization  
	 *@param desc The description of organization 
	*/
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 *Method for get list of students of organization 
	 *@return Vector<Student>
	*/
	public Vector <Student> getMembers(){
		return members;
	}
	/**
	 *Method to add a new student to organization
	 *@param member Student object
	*/
	public void addMember(Student member) {
		members.add(member);
	}
	/**
	 *Method to add list of students to organization  
	 *@param members List of Student objects
	*/
	public void addMembers(Vector <Student> members) {
		this.members.addAll(members);
	}
	/**
	 *Method to print to print info about organization  
	*/
	public String toString() {
		return "StudentOrganisation(name: " + name + ")";
	}
	/**
	 *Method for checking organizations for identity
	 *@param o Object object
	 *@return boolean
	*/
	public boolean equals(Object o) {
		if(o == null) {return false;}
		if(this == o) {return true;}
		if(this.getClass() != o.getClass()) {return false;}
		StudentOrganisation so = (StudentOrganisation) o;
		return this.name.equals(so.name) && this.desc.equals(so.desc) && this.members.equals(so.members);
	}
	/**
	 *Method to get hash of organization
	 *@return int
	*/
	public int hashCode() {
		return Objects.hash(name, desc, members);
	}
	/**
	 *Method for compare number of students in organizations 
	 *@param o StudentOrganization object 
	 *@return int
	*/
	public int compareTo(StudentOrganisation o) {
		if(members.size() > o.members.size()) {return 1;}
		if(members.size() < o.members.size()) {return -1;}
		return 0;
	}

}

