package views;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Vector;
import data.Data;
import data.News;
import users.User;

public abstract class UserView{

	protected User user;
	protected BufferedReader reader;
	protected BufferedWriter writer;

	protected UserView(){}

	public UserView(User user){
		this.user = user;
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new BufferedWriter(new OutputStreamWriter(System.out));
	}

	public void viewNews() throws IOException{
		Vector <News> news = Data.getInstance().getNews();
		Collections.reverse(news);
		while(true){
			writer.write("0. Exit", 0, 0);
			writer.newLine();
			int count = 1;
			for(News cur: news){
				writer.write(count + "." + cur);
				writer.newLine();
				count++;
			}
			String ans = reader.readLine();
			if(ans.equals("0")){
				return;
			}
		}
	}

	public void changePassword() throws IOException{
		while(true){
			writer.write("Insert new password: ");
			writer.newLine();
			String password1 = reader.readLine();
			writer.write("Confirm password: ");
			writer.newLine();
			String password2 = reader.readLine();
			if(password1 == password2){
				user.setPassword(password2);
				writer.write("Password changed successfully", 0, 0);
				writer.newLine();
				break;
			}
			writer.write("Passwords don't match", 0, 0);
			writer.newLine();
		}
	}

	public void viewPersonalInfo() throws IOException{
		writer.write(user.getPersonalInfo().toString());
		writer.newLine();
	}

	public abstract void main();

}

