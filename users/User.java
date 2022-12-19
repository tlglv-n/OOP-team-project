package users;

import java.io.Serializable;
import java.util.Objects;
import data.Data;
import personal_info.PersonalInfo;

public abstract class User implements Serializable, Comparable <User>{

	private static final long serialVersionUID = 1L;
	private PersonalInfo info;
	private int id;
	private String login;
	private int passwordHash;
	
	{
		id = Data.getInstance().getNextId();
	}
	
	protected User(){}
	
	public User(String login, String password) {
		this.login = login;
		passwordHash = createPasswordHash(password);
		Data.getInstance().addUser(this);
	}
	
	public User(String login, String password, PersonalInfo info) {
		this(login, password);
		this.info = info;
	}

	public String getLogin() {
		return login;	
	}
	
	public int getId() {
		return id;	
	}
	
	public int hashCode() {
		return Objects.hash(id);	
	}
	
	public PersonalInfo getPersonalInfo() {
		return info;
	}
	
	public static int createPasswordHash(String password) {
		return Objects.hash(password);
	}

	public void setPassword(String password){
		this.passwordHash = createPasswordHash(password);
	}
	
	public boolean verify(String login, String password) {
		return this.login.equals(login) && passwordHash == createPasswordHash(password);
	}
	
	public boolean equals(Object o) {
		if(o == null) {return false;}
		if(this == o) {return true;}
		if(this.getClass() != o.getClass()) {return false;}
		User u = (User) o;
		return id == u.id;
	}
	
	public String toString() {
		return "User(login: " + login + " id: " + id + ")";
	}
	
	public int compareTo(User u) {
		if(id > u.id) {return 1;}
		if(id < u.id) {return -1;}
		return 0;
	}
}