package views;

import java.io.IOException;
import java.util.Vector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import data.Book;
import users.Librarian;
import users.Student;

public class LibrarianView extends UserView {
	public LibrarianView(){
		super();
	}

	public LibrarianView(Librarian librarian){
		super(librarian);
	}
	public void viewBooks() throws IOException{
		HashMap<Book, Integer> books = ((Librarian)user).getListBooks();
		for(HashMap.Entry<Book, Integer> book : books.entrySet()) {
			print(book.getKey().toString());
		}
	}
	public void viewTakenBooks() throws IOException {
		HashSet<Integer> students = ((Librarian)user).getListStudents();
		for(Integer s: students){
			System.out.println(s);
		}
		// getting list of students, not their books yet
	}
	public void giveBook() throws IOException {
		while(true) {
			print("Insert name of the student. '0' is exit");
			String nameStudent = reader.readLine();
			if(nameStudent.equals("0")) {
				return;
			}
			print("Insert name of the book.");
			String nameBook = reader.readLine();
			Book book = new Book(nameBook);
			if(((Librarian)user).searchBook(book)) {
				((Librarian)user).takeBook(book, ((Student)user).getId());
			}
		}
	}
	public void addBook() throws IOException {
		while(true) {
			print("Insert name of the book. '0' is exit");
			String name = reader.readLine();
			if(name.equals("0")) {
				return;
			}
			print("How many books do you want to add?");
			String inp = reader.readLine();
			int number = Integer.parseInt(inp);
			Book book = new Book(name, number);
			if(number > 0) {
				((Librarian)user).addBook(book);
				print("The book is added!");
			}
			else {
				print("The book(-s) can't be added! Specify the correct number.");
			}
		}
		
	}
	public void deleteBook() throws IOException {
		while(true) {
			print("Insert name of the book for deleting. '0' is exit");
			String name = reader.readLine();
			if(name.equals("0")) {
				return;
			}
			print("How many books were there?");
			String inp = reader.readLine();
			int number = Integer.parseInt(inp);
			Book book = new Book(name, number);
			if(((Librarian)user).searchBook(book)) {
				((Librarian)user).deleteBook(book);
			}
			else {
				print("There is no such book in the library.");
			}
			
		}
	}
	public void main() {
		while(true) {
			try {
				print("0. Exit");
				print("1. View news");
				print("2. View personal info");
				print("3. Change password");
				print("4. View library's books");
				print("5. View the taken books");
				print("6. Add book to library");
				print("7. Give book to student");
				print("8. Delete book from library");
				String ans = reader.readLine();
				if(ans.equals("0")){
					return;
				}
				if(ans.equals("1")){
					viewNews();
				}
				if(ans.equals("2")){
					viewPersonalInfo();
				}
				if(ans.equals("3")){
					changePassword();
				}
				if(ans.equals("4")){
					viewBooks();
				}
				if(ans.equals("5")){
					viewTakenBooks();
				}
				if(ans.equals("6")){
					addBook();
				}
				if(ans.equals("7")) {
					giveBook();
				}
				if(ans.equals("8")) {
					deleteBook();
				}
			}
			catch(IOException ioe) {
				System.out.println("Something is wrong");
			}
			

		}
		
	}
}
