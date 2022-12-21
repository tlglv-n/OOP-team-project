import java.util.Scanner;

import data.Data;
import users.Admin;
import users.Librarian;
import users.SchoolManager;
import users.Student;
import users.Teacher;
import users.User;
import views.AdminView;
import views.LibrarianView;
import views.SchoolManagerView;
import views.StudentView;
import views.TeacherView;
import views.UserView;

public class Main {
    
    public static UserView view;
    public static Scanner scanner = new Scanner(System.in);

    public static void setView(User user){
        if(user instanceof Admin){
            view = new AdminView(((Admin)user));
        }
        if(user instanceof Teacher){
            view = new TeacherView(((Teacher)user));
        }
        if(user instanceof Student){
            view = new StudentView(((Student)user));
        }
        if(user instanceof SchoolManager){
            view = new SchoolManagerView((SchoolManager)user);
        }
        if(user instanceof Librarian) {
        	view = new LibrarianView((Librarian)user);
        }
    }

    public static void login(){
        User user;
        while(true){
            System.out.println("Insert your login");
            String login = scanner.next();
            System.out.println("Insert your password: ");
            String password = scanner.next();
            try{
                user = Data.getInstance().getUser(login, password);
                if(user == null){
                	System.out.println("Wrong username of password");
                	continue;
                }
                System.out.println("Login was successfull");
                setView(user);
                return;
            }
            catch (Exception e){
                System.out.println("Wrong username or password");
            }
        }
    }

    public static void main(String args[]){
        System.out.println(Data.getInstance().getUsers());
        login();
        view.main();
        Data.serialize();
    }
}
