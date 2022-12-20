package views ;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import data.Data;
import users.Admin;
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
		writer.write("Choose kind of user you want to create: \n");
		for(UserType ut: UserType.values()){
			writer.write(ut.toString() + '\n');
		}
		while(true){
			try {
				type = UserType.valueOf(reader.readLine());
				break;
			}
			catch (NoSuchElementException nsee){
				writer.write("No such option \n", 0, 0);
			}
		}
		while(true){
			login = reader.readLine();
			final String costyl = login;
			if(Data.getInstance().getUsers().stream()
			.filter(u -> costyl.equals(u.getLogin()))
			.collect(Collectors.toList()).isEmpty()){
				break;
			}
			writer.write("Username already used, try again\n");
		}
		writer.write("Insert password: \n");
		password = reader.readLine();
		UserFactory.getUser(login, password, type);
	}

	public void main(){
		while(true){
			try{
				writer.write("0. Exit\n");
				writer.write("1. View news\n");
				writer.write("2. View personal info\n");
				writer.write("3. Change password\n");
				writer.write("4. Create user\n");
				String ans = reader.readLine();
				switch(ans){
					case "0":
						return;
					case "1":
						viewNews();
					case "2":
						viewPersonalInfo();
					case "3":
						changePassword();
					case "4":
						createUser();
				}
			}
			catch (IOException ioe){
			}
		}
	}
}

