package data;

import java.util.Date;
import java.util.Objects;

import users.User;

public class Book
{
	
	private String name;	
	private int id;
	private Date deadline;

	public Book(){}

	public String getName(){
		return name;
	}
	public int id() {
		return id;
	}
	public Date getDeadline() {
		return deadline;
	}
	
	public boolean equals(Object o) {
		if(o == null) {return false;}
		if(this == o) {return true;}
		if(this.getClass() != o.getClass()) {return false;}
		Book b = (Book) o;
		return id == b.id;
	}
	public int hashCode() {
		return Objects.hash(id);	
	}
	public String toString() {
		return "Book: " + name + ", ID: " + id;
	}
	
	public int compareTo(Book b) {
		if(id > b.id) {return 1;}
		if(id < b.id) {return -1;}
		return 0;
	}
}

