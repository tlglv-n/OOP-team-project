package users;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import data.Book;

public class Librarian extends Employee{
	
	private HashSet <Integer> listStudents = new HashSet<>();
	private HashMap <Book, Integer> listBooks = new HashMap<Book, Integer>();

	protected Librarian(){
		super();
	}

	public Librarian(String login, String password){
		super(login, password);
	}
	
	public boolean searchBook(Book book) {
		for(HashMap.Entry<Book, Integer> b : listBooks.entrySet()) {
			if(b.getKey().equals(book)) {
				return true;
			}
		}
		return false;
	}
	public void takeBook(Book book, int studentId) {
		if(searchBook(book) && book.getNumber() > 0) {
			listStudents.add(studentId);
		}
		return;
	}
	public void addBook(Book book) {
		listBooks.put(book, book.getNumber());
	}

	public void deleteBook(Book book) {
		listBooks.remove(book);
	}
	public void setListStudents(HashSet<Integer> listStudents) {
		this.listStudents = listStudents;
	}

	public void setListBooks(HashMap<Book, Integer> listBooks) {
		this.listBooks = listBooks;
	}
	public HashSet<Integer> getListStudents() {
		return listStudents;
	}
	public HashMap<Book, Integer> getListBooks() {
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

