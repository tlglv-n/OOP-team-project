package views;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import data.Course;
import data.Data;
import data.Lesson;
import data.Transcript;
import users.Researcher;
import users.Student;

public class StudentView extends UserView implements IResearcherView{

	public StudentView(){
		super();
	}

	public StudentView(Student student){
		super(student);
	}

	public void viewAttendance() throws IOException{
		Object courses [] = ((Student)user).getCurrentMarks().keySet().toArray();
		while(true){
			int cnt = 1;
			print("Choose subject of attendance");
			print("0.Exit");
			for(Object cur: courses){
				print(String.valueOf(cnt)+ '.' + cur);
				cnt++;
			}
			String ans = reader.readLine();
			if(ans.equals("0")){
				return;
			}
			try{
				List <Lesson> lessons = ((Student)user).getAttendance()
										.keySet().stream()
										.filter(lesson -> lesson.getCourse().equals(courses[Integer.parseInt(ans)]))
										.collect(Collectors.toList());
				for(Lesson lesson: lessons){
					print(lesson.toString() + ' ' + ((Student)user).getAttendance().get(lesson));
				}
			}
			catch (IndexOutOfBoundsException ioobe){
				print("No such course");
			}
		}
	}
	
	public void researcherMenu(){
		Researcher r = Data.getInstance().getResearcher((Student)user);
		if(r == null){
			r = new Researcher((Student)user);
		}
		new ResearcherView(r).main();
	}

	public void register() throws IOException{
		Set <Course> studentCourses = ((Student)user).getCourses();
		while(true){
			Set <Course> registration = Data.getInstance()
					   	.getCourses().stream()
					   	.filter(c -> !studentCourses.contains(c))
					   	.collect(Collectors.toSet());
			for(Course c: registration){
				print(c.toString());
			}
			print("Insert name of course you want to register or 0 to exit");
			final String courseString = reader.readLine();
			if(courseString.equals("0")){
				return;
			}
			try{
				Course course = registration.stream()
							.filter(c -> c.getName().equals(courseString))
							.collect(Collectors.toList()).get(0);
				if(((Student)user).register(course)){
					print("Registered succesfully");
				}
				else{
					print("Cannot register");
				}
			}
			catch (IndexOutOfBoundsException ioobe){
				print("No such course");
			}
		}
	}

	public void viewMarks() throws IOException{
		for(Course c: ((Student)user).getCourses()){
			print(c.toString() + ((Student)user).getCurrentMarks().get(c).toString());
		}
	}

	public void viewTranscipt() throws IOException{
		Transcript t = ((Student)user).getTranscript();
		print(t.toString());
	}

	public void dropCourse() throws IOException{
		while(true){
			print("Here is the list of your courses: ");
			Set <Course> courses = ((Student)user).getCourses();
			for(Course cur: courses){
				writer.write(cur.toString());
			}
			print("Insert name of course you want to drop or 0 to exit");
			final String ans = reader.readLine();
			if(ans.equals("0")){
				return;
			}
			try{
				Course course = courses.stream()
								.filter(c -> c.getName().equals(ans))
								.collect(Collectors.toList()).get(0);
				((Student)user).dropCourse(course);
				print("Course dropped successfully");
			}
			catch (IndexOutOfBoundsException ioobe){
				print("No such option");
			}
		}
	}

	public void main(){
		while(true){
			try{
				print("0. Exit");
				print("1. View news");
				print("2. View personal info");
				print("3. Change password");
				print("4. View attendance");
				print("5. Register to a course");
				print("6. Drop course");
				print("7. View marks");
				print("8. View transcript");
				print("9. Researcher menu");
				String ans = reader.readLine();
				switch(ans){
					case "0":
						return;
					case "1":
						viewNews();
						break;
					case "2":
						viewPersonalInfo();
						break;
					case "3":
						changePassword();
						break;
					case "4":
						viewAttendance();
						break;
					case "5":
						register();
						break;
					case "6":
						dropCourse();
						break;
					case "7":
						viewMarks();
						break;
					case "8":
						viewTranscipt();
						break;
					case "9":
						researcherMenu();
						break;
					default:
						print("No such option");
				}
			}
			catch (IOException ioe){
				System.out.println("Something is wrong");
			}
		}
	}
}
