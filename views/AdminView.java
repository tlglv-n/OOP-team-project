package views ;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import data.Data;
import users.Admin;
import users.User;
import users.UserType;
import users.UserFactory;

public class AdminView extends UserView{

	protected AdminView(){}

	public AdminView(Admin admin){
		super(admin);
	}

	public void createUser(){
		UserType type;
		String password;
		String login = "Default";
		System.out.println("Choose kind of user you want to create:");
		for(UserType ut: UserType.values()){
			System.out.println(ut);
		}
		while(true){
			try {
				type = UserType.valueOf(scanner.next());
				break;
			}
			catch (NoSuchElementException nsee){
				System.out.println("No such option ");
			}
		}
		while(true){
			System.out.println("Insert login:");
			login = scanner.next();
			final String costyl = login;
			if(Data.getInstance().getUsers().stream()
			.filter(u -> costyl.equals(u.getLogin()))
			.collect(Collectors.toList()).isEmpty()){
				break;
			}
			System.out.println("Username already used, try again");
		}
		System.out.println("Insert password:");
		password = scanner.next();
		UserFactory.getUser(login, password, type);
	}

	public void main(){
		while(true){
			System.out.println("0. Exit");
			System.out.println("1. View news");
			System.out.println("2. View personal info");
			System.out.println("3. Change password");
			System.out.println("4. Create user");
			System.out.println("5. View users");
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
				createUser();
			}
			if(ans.equals("5")){
				viewUsers();
			}
		}
	}

	public void viewUsers(){
		for(User user: Data.getInstance().getUsers()){
			System.out.println(user);
		}
	}
}

