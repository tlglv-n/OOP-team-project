package views;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import data.Course;
import data.Data;
import data.Lesson;
import data.Transcript;
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
		Set <Course> studentCourses = ((Student)user).getCourses();
		while(true){
			Set <Course> registration = Data.getInstance()
					   	.getCourses().stream()
					   	.filter(c -> !studentCourses.contains(c))
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

	public void viewMarks(){
		for(Course c: ((Student)user).getCourses()){
			System.out.println(c.toString() + ((Student)user).getCurrentMarks().get(c).toString());
		}
	}

	public void viewTranscipt(){
		Transcript t = ((Student)user).getTranscript();
		System.out.println(t);
	}

	public void dropCourse(){
		while(true){
			System.out.println("Here is the list of your courses: ");
			Set <Course> courses = ((Student)user).getCourses();
			for(Course cur: courses){
				System.out.println(cur);
			}
			System.out.println("Insert name of course you want to drop or 0 to exit");
			final String ans = scanner.next();
			if(ans.equals("0")){
				return;
			}
			try{
				Course course = courses.stream()
								.filter(c -> c.getName().equals(ans))
								.collect(Collectors.toList()).get(0);
				((Student)user).dropCourse(course);
				System.out.println("Course dropped successfully");
			}
			catch (IndexOutOfBoundsException ioobe){
				System.out.println("No such option");
			}
		}
	}

	public void main(){
		while(true){
			System.out.println("0. Exit");
			System.out.println("1. View news");
			System.out.println("2. View personal info");
			System.out.println("3. Change password");
			System.out.println("4. View attendance");
			System.out.println("5. Register to a course");
			System.out.println("6. Drop course");
			String ans = scanner.next();
			if(ans.equals("0")){
				return;
			}
			if(ans.equals("1")){
				viewNews();
			}
			if(ans.equals("2")){
				viewPersonalInfo();
			}
			if(ans.equals("3")){
				changePassword();
			}
			if(ans.equals("4")){
				viewAttendance();
			}
			if(ans.equals("5")){
				register();
			}
			if(ans.equals("6")){
				dropCourse();
			}
		}
	}

}
