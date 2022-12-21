package users;
/** import a class Course from package data*/
import data.Course;
/** import a class Mark from package data*/
import data.Mark;
/**
 *This class create a User of Teacher type.
*/
public class Teacher extends Employee{
    /** field of type of Teacher */
    private TeacherType type;
    /** 
     *Constructor-create a new Teacher
     *@see Teacher#Teacher(String,String)
     *@see Teacher#Teacher(String,String,TeacherType)
    */
    public Teacher(){}
    /** 
     *Constructor-create a new Teacher
     *@param login Username of Teacher
     *@param password Password of Teacher
     *@see Teacher#Teacher()
     *@see Teacher#Teacher(String,String,TeacherType)
    */
    public Teacher(String login, String password){
        super(login, password);
    }
    /** 
     *Constructor-create a new Teacher
     *@param login Username of the Teacher
     *@param password Password of the Teacher
     *@param type TeacherType object
     *@see Teacher#Teacher()
     *@see Teacher#Teacher(String,String)
    */
    public Teacher(String login, String password, TeacherType type){
        this(login, password);
        setType(type);
    }
    /**
     *Method to set type of the Teacher
     *@param type TeacherType object
    */
    public void setType(TeacherType type){
        this.type = type;
    }
    /**
     *Method to get type of the Teacher
     *@return TeacherType 
    */
    public TeacherType getType(){
        return type;
    }
    /**
     *Method to print info about Teacher
     *@return String
    */
    public String toString(){
        return super.toString().replace("Employee", "Teacher") + " " + type;
    }
    /**
     *Method to set mark from Teacher
     *@param c Course object
     *@param s Student object 
     *@param m Mark object
    */
    public void setMark(Course c, Student s, Mark m){
        if(!s.getCurrentMarks().keySet().contains(c)){
            return;
        }
        if(!c.getLector().equals(this) && !c.getPracticeTeacher().equals(this)){
            return;
        }
        s.setMark(c, m);
    }
}

