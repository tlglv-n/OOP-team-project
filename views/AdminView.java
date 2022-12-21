package views ;

import java.io.IOException;
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

	public void createUser() throws IOException{
		UserType type;
		String password;
		String login = "Default";
		print("Choose kind of user you want to create:");
		for(UserType ut: UserType.values()){
			print(ut.toString());
		}
		while(true){
			try {
				type = UserType.valueOf(reader.readLine());
				break;
			}
			catch (IllegalArgumentException iae){
				print("No such option ");
			}
		}
		while(true){
			print("Insert login:");
			login = reader.readLine();
			final String costyl = login;
			if(Data.getInstance().getUsers().stream()
				   .filter(u -> costyl.equals(u.getLogin()))
				   .collect(Collectors.toList()).isEmpty()){
				break;
			}
			print("Username already used, try again");
		}
		print("Insert password:");
		password = reader.readLine();
		UserFactory.getUser(login, password, type);
	}

	public void main(){
		while(true){
			try{
				print("0. Exit");
				print("1. View news");
				print("2. View personal info");
				print("3. Change password");
				print("4. Create user");
				print("5. View users");
				print("6. Delete user");
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
						createUser();
						break;
					case "5":
						viewUsers();
						break;
					case "6":
						deleteUser();
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

	public void viewUsers() throws IOException{
		for(User user: Data.getInstance().getUsers()){
			print(user.toString());
		}
	}

	public void deleteUser() throws IOException{
		viewUsers();
		while(true){
			print("Insert login of user you want to delete or 0 to exit");
			final String login = reader.readLine();
			if(login.equals("0")){
				return;
			}
			try{
				User user = Data.getInstance().getUsers().stream()
							.filter(s -> s.getLogin().equals(login))
							.collect(Collectors.toList()).get(0);
				Data.getInstance().deleteUser(user);
				return;
			}
			catch (Exception e){
				print("No such option");
			}
		}	
	}

}