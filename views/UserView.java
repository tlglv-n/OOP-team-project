package views;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;
import data.Data;
import data.News;
import users.User;

public abstract class UserView{

	protected User user;
	protected Scanner scanner = new Scanner(System.in);

	public UserView(){}

	public UserView(User user){
		this();
		this.user = user;
	}

	public void viewNews(){
		Vector <News> news = Data.getInstance().getNews();
		Collections.reverse(news);
		while(true){
			System.out.println("0. Exit");
			int count = 1;
			for(News cur: news){
				System.out.println(count + "." + cur);
				count++;
			}
			String ans = scanner.next();
			if(ans.equals("0")){
				return;
			}
		}
	}

	public void changePassword(){
		while(true){
			System.out.println("Insert new password: ");
			String password1 = scanner.next();
			System.out.println("Confirm password: ");
			String password2 = scanner.next();
			if(password1 == password2){
				user.setPassword(password2);
				System.out.println("Password changed successfully");
				break;
			}
			System.out.println("Passwords don't match");
		}
	}

	public void viewPersonalInfo(){
		System.out.println(user.getPersonalInfo());
	}

	public abstract void main();

}

