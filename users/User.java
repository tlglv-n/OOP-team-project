package users;

import java.io.Serializable;
import java.util.Objects;
import data.Data;
import personal_info.PersonalInfo;
/**
 *Abstract class User for create a new user
*/
public abstract class User implements Serializable, Comparable <User>{
	/** @serial serialVersionUID static final field for specifying the version of serialized data */
	private static final long serialVersionUID = 1L;
	/** filed of some information about user */
	private PersonalInfo info;
	/** field of identity number for user*/
	private int id;
	/** field of user name for user */
	private String login;
	/** field for hash of password */
	private int passwordHash;
	/**
	 * block for unique identity number for user
	*/
	{
		id = Data.getInstance().getNextId();
	}
	/**
	 *Constructor - creating a new object
	 *@see User#User(String, String)
	 *@see User#User(String, String, PersonalInfo)
	*/
	protected User(){}
	/**
	 *Constructor - creating a new object with certain values
	 *@param login-user name
	 *@param password-password of user
	 *@see User#User()
	 *@see User#User(String, String, PersonalInfo)
	*/
	public User(String login, String password) {
		this.login = login;
		passwordHash = createPasswordHash(password);
		Data.getInstance().addUser(this);
	}
	/**
	 *Constructor - creating a new object with certain values
	 *@param login-user name
	 *@param password-password of user
	 *@param info-some information about the user
	 *@see User#User()
	 *@see User#User(String, String)
	*/
	public User(String login, String password, PersonalInfo info) {
		this(login, password);
		this.info = info;
	}
	/**
	 *Method for get filed {@link User#login}
	 *@return String user name
	*/
	public String getLogin() {
		return login;	
	}
	/**
	 *Method for get identity number {@link User#id}
	 *@return int identity number of user
	*/
	public int getId() {
		return id;	
	}
	/**
	 *Method for get hashcode of identity number of user
	 *@return int hashcode of identity number
	*/
	public int hashCode() {
		return Objects.hash(id);	
	}
	/**
	 *Method for get information of user {@link User#info}
	 *@return PersonalInfo information about the user
	*/
	public PersonalInfo getPersonalInfo() {
		return info;
	}
	/**
	 *Method for create hashcode of password of user
	 *@return int hashcode of password
	*/
	public static int createPasswordHash(String password) {
		return Objects.hash(password);
	}
	/**
	 *Method for set password of user
	 *@param password- password of user
	*/
	public void setPassword(String password){
		this.passwordHash = createPasswordHash(password);
	}
	/**
	 *Method for check user
	 *@return boolean true if login and password match,
	 *                false if login and password doesn't match
	*/
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
