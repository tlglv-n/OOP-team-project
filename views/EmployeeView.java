package views;

import java.io.IOException;
import java.util.Vector;
import java.util.stream.Collectors;
import data.Data;
import data.Message;
import users.Employee;
import users.User;

public class EmployeeView extends UserView{

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

	public void main(){
		
	}
}
