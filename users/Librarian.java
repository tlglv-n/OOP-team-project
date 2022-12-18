package users;

import java.util.Objects;
import java.util.Vector;

import data.Book;

public class Librarian extends Employee{
	
	private Vector <Student> listStudents;
	private Vector <Book> listBooks;

	protected Librarian(){
		super();
	}

	public Librarian(String login, String password){
		super(login, password);
	}
	
	public void takeBook() {
		// TODO implement me	
	}
	
	public void searchBook() {
		// TODO implement me	
	}

	public void addBook() {
		// TODO implement me	
	}

	public void deleteBook() {
		// TODO implement me	
	}
	public void setListStudents(Vector<Student> listStudents) {
		this.listStudents = listStudents;
	}

	public void setListBooks(Vector<Book> listBooks) {
		this.listBooks = listBooks;
	}
	public Vector<Student> getListStudents() {
		return listStudents;
	}
	public Vector<Book> getListBooks() {
		return listBooks;
	}
	
	public int compareTo(Librarian o) {
		if(listStudents.size() > o.listStudents.size()) {return 1;}
		if(listStudents.size() < o.listStudents.size()) {return -1;}
		return 0;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(listBooks, listStudents);
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Librarian other = (Librarian) obj;
		return Objects.equals(listBooks, other.listBooks) && Objects.equals(listStudents, other.listStudents);
	}

	public String toString() {
		return "This is librarian";
	}
	
}

