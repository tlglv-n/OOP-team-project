package users;

import data.Data;

public class Admin extends User{

	private static final long serialVersionUID = 1L;
	protected Admin(){}

	public Admin(String login, String password){
		super(login, password);
	}

	public void addUser(User user){
		Data.getInstance().addUser(user);
	}
	public void deleteUser(User user) {
		
	}
	
}

