package data;

import java.util.Date;
import java.util.Objects;

public class Book
{
	
	private String name;	
	private Date deadline;

	public Book(){}

	public String getName(){
		return name;
	}
	
	public Date getDeadline(){
		return deadline;
	}
	public boolean equals(Object o) {
		if(o == null) {return false;}
		if(this == o) {return true;}
		if(this.getClass() != o.getClass()) {return false;}
		Book b = (Book) o;
		return this.name.equals(b.name) && this.deadline.equals(b.deadline);
	}
	public int hashCode() {
		return Objects.hash(name, deadline);	
	}
	public String toString() {
		return "Book: " + name;
	}
}

