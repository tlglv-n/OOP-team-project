package data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;	
	private Date deadline;
	private int numberOfBooks;

	public Book(){}

	public Book(String name, Date deadline){
		this.name = name;
		this.deadline = deadline;
	}
	public Book(String name, int numberOfBooks) {
		this.name = name;
		this.numberOfBooks = numberOfBooks;
	}
	public Book(String name) {
		this.name = name;
	}

	public String getName(){
		return name;
	}
	
	public Date getDeadline(){
		return deadline;
	}
	public int getNumber() {
		return numberOfBooks;
	}

	public boolean equals(Object o) {
		if(o == null) {return false;}
		if(this == o) {return true;}
		if(this.getClass() != o.getClass()) {return false;}
		Book b = (Book) o;
		return this.name.equals(b.name);
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public void setNumber(int numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}

	public int hashCode() {
		return Objects.hash(name, numberOfBooks);	
	}

	public String toString() {
		return "Book: " + name + ", number: " + numberOfBooks;
	}

}

