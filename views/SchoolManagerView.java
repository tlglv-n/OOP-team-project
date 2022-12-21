package views;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import data.Course;
import data.Data;
import data.School;
import users.SchoolManager;
import users.Teacher;

public class SchoolManagerView extends ManagerView{

    public SchoolManagerView(){}

    public SchoolManagerView(SchoolManager manager){
        super(manager);
    }

    public void setSchool() throws IOException{
        Set <School> schools = Data.getInstance().getSchools();
        for(School s: schools){
            print(s.toString());
        }
        while(true){
            print("Insert name of school you want to work in or 0 to exit");
            String ans = reader.readLine();
            if(ans.equals("0")){
                return;
            }
            School school;
            try{
                school = schools.stream().filter(s -> s.getName().equals(ans))
                                .collect(Collectors.toList()).get(0);
                ((SchoolManager)user).setSchool(school);
                print("School chosen successfully");
                break;
            }
            catch (IndexOutOfBoundsException ioobe){
                print("No such school");
            }
        }
    }

    public void createCourse() throws IOException{
        if(((SchoolManager)user).getSchool() == null){
            print("You cannot create course, choose school first");
            return;
        }
        while(true){
            print("Insert course idCode or 0 to exit: ");
            String idCode = reader.readLine();
            if(idCode.equals("0")){
                return;
            }
            print("Insert number of credits for course");
            int credits = Integer.parseInt(reader.readLine());
            print("Insert course name: ");
            String name = reader.readLine();
            print(idCode);
            print(String.valueOf(credits));
            print(name);
            try{
                if(idCode == null || name == null){
                    print("Something wrong");
                    continue;
                }
                new Course(((SchoolManager)user).getSchool(), idCode, credits, name);
                print("Course created successfully");
            }
            catch (Exception e){
                print("Something wrong happened");
                e.printStackTrace();
            }
        }
    }

    public void assignTeacherToCourse() throws IOException{
        Set <Course> courses = Data.getInstance().getCourses();
        List <Teacher> teachers = Data.getInstance().getUsers().stream()
                                  .filter(u -> u instanceof Teacher)
                                  .map(u -> (Teacher)u).collect(Collectors.toList());
        for(Course c: courses){
            print(c.toString());
        }
        for(Teacher t: teachers){
            print(t.toString());
        }
        while(true){
            print("Insert idCode of course or 0 to exit");
            String idCode = reader.readLine();
            if(idCode.equals("0")){
                return;
            }
            print("Insert login of teacher");
            String login = reader.readLine();
            print("Insert 1 to set teacher as practice teacher anything else to set as lector");
            String type = reader.readLine();
            try{
                Course c = courses.stream()
                           .filter(course -> course.getIdCode().equals(idCode))
                           .collect(Collectors.toList()).get(0);
                Teacher t = teachers.stream()
                            .filter(teacher -> teacher.getLogin().equals(login))
                            .collect(Collectors.toList()).get(0);
                if(type.equals(1)){
                    ((SchoolManager)user).assignCourseToTeacherPractice(c, t);
                }
                else{
                    ((SchoolManager)user).assignCourseToTeacherLector(c, t);
                }
                print("Course assigned successfully");
            }
            catch (Exception e){
                print("Something wrong, try again");
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
				print("4. View messages");
				print("5. Send message");
				print("6. Set school");
                print("7. Create course");
                print("8. Assign course for teacher");
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
						viewMessages();
						break;
					case "5":
						sendMessage();
						break;
					case "6":
						setSchool();
						break;
                    case "7":
						createCourse();
						break;
                    case "8":
						assignTeacherToCourse();
						break;
					default:
						print("No such option");
				}
			}
			catch (IOException ioe){
				System.out.println("Error");
			}
		}
	}
}