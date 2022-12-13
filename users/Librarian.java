package users;

import java.util.Vector;

import data.Book;

public class Librarian extends Employee
{
	
	private Vector <Student> listStudents;
	
	private Vector <Book> listBooks;

	public Librarian(){
		super();
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
	public String toString() {
		return "This is librarian";
	}
	
}

