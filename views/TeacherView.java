package views;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import data.Course;
import data.Data;
import users.Student;
import users.Teacher;

public class TeacherView extends EmployeeView{

	public TeacherView(){
		super();
	}

	public TeacherView(Teacher teacher){
		super(teacher);
	}

	public List <Course> viewCourses() throws IOException{
		List <Course> courses = Data.getInstance().getTeacherCourses((Teacher)user);
		for(Course cur: courses){
			print(cur.toString());
		}
		return courses;
	}

	public List <Student> viewStudents(Course c) throws IOException{
		List <Student> students = Data.getInstance().getUsers().stream()
								  .filter(u -> u instanceof Student).map(s -> (Student)s)
								  .filter(s -> ((Student)s).getCourses().contains(c))
								  .collect(Collectors.toList());
		for(Student s: students){
			print(s.toString());
		}
		return students;
	}

	public void putMark() throws IOException{
		Course course;
		while(true){
			List <Course> courses = viewCourses();
			print("Insert your course name or 0 to exit");
			final String ans = reader.readLine();
			if(ans.equals("0")){
				return;
			}
			try{
				course = courses.stream()
						 .filter(c -> c.getName().equals(ans))
						 .collect(Collectors.toList()).get(0);
				break;
			}
			catch (IndexOutOfBoundsException ioobe){
				print("No such course");
			}
		}
		while(true){
			List <Student> students = viewStudents(course);
			print("Insert student's login to put mark to or 0 to exit");
			final String ans = reader.readLine();
			if(ans.equals("0")){
				return;
			}
			Student student;
			try{
				student = students.stream()
						  .filter(s -> s.getLogin().equals(ans))
						  .collect(Collectors.toList()).get(0);
			}
			catch (IndexOutOfBoundsException ioobe){
				print("No such student");
				continue;
			}
			print("Insert points");
			double points = Double.parseDouble(reader.readLine());
			print("Insert 0 to put first attestation");
			print("Insert 1 to put second attestation");
			print("Insert 2 to put final");
			String choose = reader.readLine();
			switch(choose){
				case "0":
					student.getCurrentMarks().get(course).setFirstAtt(points);
				case "1":
					student.getCurrentMarks().get(course).setSecondAtt(points);
				case "2":
					student.getCurrentMarks().get(course).setFinalMark(points);
					student.checkCourses();
				default:
					print("No such option");
					continue;
			}
		}
	}

	public void main(){
		
	}

}

