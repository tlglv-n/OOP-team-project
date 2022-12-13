package users;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Vector;

public class Advisor implements IResearcher, Serializable, Comparable <Advisor>{

    private Vector <Student> students;
    private IAdvisor adv;

    protected Advisor(){}

    public Advisor(IAdvisor adv){
        this.adv = adv;
        students = new Vector <Student>();
    }

    public Advisor(IAdvisor adv, Collection <Student> students){
        this(adv);
        addStudents(students);
    }

    public void addStudent(Student st){
        students.add(st);
    }

    public void addStudents(Collection <Student> students){
        this.students.addAll(students);
    }

    public IAdvisor getAdvisorObject(){
        return adv;
    }

    public Vector <Student> getStudents(){
        return students;
    }

    public boolean removeStudent(Student st){
        return students.remove(st);
    }

    public boolean removeStudents(Collection <Student> students){
        return this.students.removeAll(students);
    }

    public String toString(){
        return adv.toString() + " with students " + students;
    }

    public int hashCode(){
        return Objects.hash(adv, students);
    }

    public boolean equals(Object o){
        return adv.equals(o);
    }

    public int compareTo(Advisor a){
        if(this.students.size() > a.students.size()){return 1;}
        if(this.students.size() == a.students.size()){return 0;}
        return -1;
    }
}

