package views;

import java.io.IOException;
import java.util.Vector;
import java.util.stream.Collectors;
import data.Data;
import data.Message;
import users.Employee;
import users.Researcher;
import users.User;

public class EmployeeView extends UserView implements IResearcherView{

	public EmployeeView(){}

	public EmployeeView(Employee employee){
		super(employee);
	}

	public void viewMessages() throws IOException{
		Vector <Message> messages = ((Employee)user).getMessages();
		while(true){
			print("0. Exit");
			int count = 1;
			for(Message cur: messages){
				print(count + "." + cur);
				count++;
			}
			String ans = reader.readLine();
			if(ans.equals("0")){
				return;
			}
			try{
				viewMessage(messages.get(Integer.parseInt(ans) - 1));
			}
			catch (IndexOutOfBoundsException iofe){
				print("Wrong answer");
			}
			catch (NumberFormatException nfe){
				print("Not a number");
			}
		}
	}

	public void viewMessage(Message message) throws IOException{
		print(message.getMessage());
	}

	public void sendMessage() throws IOException{
		System.out.println("Insert Employee's login to send message to: ");
		User receiver;
		String name = reader.readLine();
		while(true){
			try{
				receiver = Data.getInstance().getUsers().stream()
				.filter(u-> u instanceof Employee)
				.filter(e -> e.getLogin().equals(name))
				.collect(Collectors.toList()).get(0);
				break;
			}
			catch (IndexOutOfBoundsException ioofe){
				print("No such user");
			}
		}
		print("Insert message theme: ");
		String theme = reader.readLine();
		print("Insert message text: ");
		String text = reader.readLine();
		((Employee)user).sendMessage((Employee)receiver, theme, text);
	}

	public void researcherMenu(){
		Researcher r = Data.getInstance().getResearcher((Employee)user);
		if(r == null){
			r = new Researcher((Employee)user);
		}
		new ResearcherView(r).main();
	}

	public void main(){
		while(true){
			try{
				print("0. Exit");
				print("1. View news");
				print("2. View personal info");
				print("3. Change password");
				print("4. View messages");
				print("5. Send message");
				print("6. Researcher menu");
				String ans = reader.readLine();
				switch(ans){
					case "0":
						return;
					case "1":
						viewNews();
						break;
					case "2":
						viewPersonalInfo();
						break;
					case "3":
						changePassword();
						break;
					case "4":
						viewMessages();
						break;
					case "5":
						sendMessage();
						break;
					case "6":
						researcherMenu();
					default:
						print("No such option");
				}
			}
			catch (IOException ioe){
				System.out.println("Error");
			}
		}
	}
}
