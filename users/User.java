package users;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import personal_info.PersonalInfo;


public abstract class User implements Serializable, Comparable <User>{

	private static final long serialVersionUID = 1L;
	private PersonalInfo info;
	private int id;
	private static int idCount;
	private String login;
	private int passwordHash;

	static{
		try{
			FileInputStream fis = new FileInputStream(".\\users.users_id_count.dat");
			DataInputStream dis = new DataInputStream(fis);
			idCount = dis.readInt();
			dis.close();
			fis.close();
		}
		catch (FileNotFoundException fnfe){
			System.out.println("First user");
		}
		catch (IOException ioe){
			System.out.println("Something wrong");
		}

	}
	
	{
		id = ++idCount;
		try{
			FileOutputStream fos = new FileOutputStream(".\\users.users_id_count.dat");
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeInt(idCount);
			dos.close();
			fos.close();
		}
		catch (IOException ioe){
			System.out.println("Don't know");
		}
	}
	
	protected User(){}
	
	public User(String login, String password) {
		this.login = login;
		passwordHash = createPasswordHash(password);
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
		return "User(login: " + login + ")";
	}
	
	public int compareTo(User u) {
		if(id > u.id) {return 1;}
		if(id < u.id) {return -1;}
		return 0;
	}
}