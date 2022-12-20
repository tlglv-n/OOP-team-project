import java.util.Scanner;

import data.Data;
import users.Admin;
import users.Teacher;
import users.User;
import views.AdminView;
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
                break;
            }
            catch (Exception e){
                System.out.println("Wrong username or password");
            }
        }
        System.out.println("Login was successfull");
        setView(user);
    }

    public static void main(String args[]){
        System.out.println(Data.getInstance().getUsers());
        login();
        view.main();
        Data.serialize();
    }
}
