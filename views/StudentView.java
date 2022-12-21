package views;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import data.Course;
import data.Data;
import data.Lesson;
import users.Student;

public class StudentView extends UserView{

	public StudentView(){
		super();
	}

	public StudentView(Student student){
		super(student);
	}

	public void viewAttendance(){
		Object courses [] = ((Student)user).getCurrentMarks().keySet().toArray();
		while(true){
			int cnt = 1;
			System.out.println("Choose subject of attendance");
			System.out.println("0.Exit");
			for(Object cur: courses){
				System.out.println(String.valueOf(cnt)+ '.' + cur);
				cnt++;
			}
			String ans = scanner.next();
			if(ans.equals("0")){
				return;
			}
			try{
				List <Lesson> lessons = ((Student)user).getAttendance()
										.keySet().stream()
										.filter(lesson -> lesson.getCourse().equals(courses[Integer.parseInt(ans)]))
										.collect(Collectors.toList());
				for(Lesson lesson: lessons){
					System.out.println(lesson.toString() + ' ' + ((Student)user).getAttendance().get(lesson));
				}
			}
			catch (IndexOutOfBoundsException ioobe){
				System.out.println("No such course");
			}
		}
	}

	public void register(){
		while(true){
			Set <Course> registration = Data.getInstance()
					   	.getCourses().stream()
					   	.filter(c -> !((Student)user).getCurrentMarks().keySet().contains(c))
					   	.collect(Collectors.toSet());
			for(Course c: registration){
				System.out.println(c);
			}
			System.out.println("Insert name of course you want to register or 0 to exit");
			final String courseString = scanner.next();
			if(courseString.equals("0")){
				return;
			}
			try{
				Course course = registration.stream()
							.filter(c -> c.getName().equals(courseString))
							.collect(Collectors.toList()).get(0);
				if(((Student)user).register(course)){
					System.out.println("Registered succesfully");
				}
				else{
					System.out.println("Cannot register");
				}
			}
			catch (IndexOutOfBoundsException ioobe){
				System.out.println("No such course");
			}
		}
	}

	public void main(){
	}

}
