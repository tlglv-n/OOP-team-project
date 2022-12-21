import data.Course;
import data.Data;

public class CourseChecker{
    public static void main(String args[]){
        System.out.println(Data.getInstance().getCourses());
        for(Course c: Data.getInstance().getCourses()){
            if(c.getIdCode() == null){
                Data.getInstance().getCourses().remove(c);
            }
        }
        Data.serialize();
    }
}