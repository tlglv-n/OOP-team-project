package users;

import java.util.HashMap;
import java.util.Vector;
import data.Book;

public class Librarian extends Employee
{
	
	private HashMap <Student, Vector <Book> > takenBook;

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
	
	public void getListStudents() {
		// TODO implement me	
	}

	public HashMap <Student, Vector <Book> > getTakenBooks(){
		return takenBook;
	}
	
}

