package users;

public class Admin extends User{

	protected Admin(){
		super();
	}

	public Admin(String login, String password){
		super(login, password);
	}

	public void addUser(User user) {	
	}
	public void deleteUser(User user) {	
	}
	public User updateUser() {
		return null;	
	}
	
}

