package users;

import data.Course;
import data.Mark;

public class Teacher extends Employee{

    private TeacherType type;

    public Teacher(){}

    public Teacher(String login, String password){
        super(login, password);
    }

    public Teacher(String login, String password, TeacherType type){
        this(login, password);
        setType(type);
    }

    public void setType(TeacherType type){
        this.type = type;
    }

    public TeacherType getType(){
        return type;
    }

    public String toString(){
        return super.toString().replace("Employee", "Teacher") + " " + type;
    }

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

