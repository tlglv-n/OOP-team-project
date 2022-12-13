package data;

import java.util.Objects;

import users.User;

public class Data
{
	private Data instance;
	private String path;
	public Data(){
		super();
	}

	public Data getInstance() {
		return instance;	
	}
	public String getPath() {
		return path;
	}
	
	public User getUser(String name, String password) {
		return null;	
	}
	
	public void saveUser(User user) {
		
	}
	public boolean equals(Object o) {
		if(o == null) {return false;}
		if(this == o) {return true;}
		if(this.getClass() != o.getClass()) {return false;}
		Data d = (Data) o;
		return instance.equals(d.instance);
	}
	public int hashCode() {
		return Objects.hash(instance);	
	}
	public String toString() {
		return "Data's instance: " + instance + ", Path: " + path;
	}
	
	
	
}

