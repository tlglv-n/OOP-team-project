package users;
/**import a class Course from package data*/
import data.Course;
/**import a class School from package data*/
import data.School;
/**
 * The class to create SchoolManager
*/
public class SchoolManager extends Manager{
	/** field of school of School object*/
	private School school;
	/**
	 *Constructor-create a new SchoolManager
	 *@see SchoolManager#SchoolManager(String,String)
	*/
	public SchoolManager(){
		super();
	}
	/**
	 *Constructor-create a new SchoolManager
	 *@param login The name of SchoolManager
	 *@param password The password of SchoolManager
	 *@see SchoolManager#SchoolManager()
	*/
	public SchoolManager(String login, String password){
		super(login, password);
	}
	/**
	 *Method to assign course to lector teacher 
	 *@param c Course object
	 *@param t Teacher object
	*/
	public void assignCourseToTeacherLector(Course c, Teacher t) {
		c.setLector(t);	
	}
	/**
	 *Method to assign course to practice teacher 
	 *@param c Course object
	 *@param t Teacher object
	*/
	public void assignCourseToTeacherPractice(Course c, Teacher t){
		c.setPracticeTeacher(t);
	}
	/**
     	 *Method to print info about school manager
	 *@return String
    	*/
	public String toString() {
		return super.toString().replace("Manager", "SchoolManager");
	}
	/**
     	 *Method to get school of school manager
	 *@return School
    	*/
	public School getSchool(){
		return school;
	}
	/**
     	 *Method to get school of school manager
	 *@return School
    	*/
	public void setSchool(School school){
		this.school = school;
	}

}

