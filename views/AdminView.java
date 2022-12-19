package views ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import users.Admin;

public class AdminView extends UserView{

	private Admin admin;
	private BufferedReader reader;
	private BufferedWriter writer;

	protected AdminView(){}

	public AdminView(Admin admin){
		this.admin = admin;
	}

	public Admin getAdmin(){
		return admin;
	}

	public void main(){
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
	}

}

