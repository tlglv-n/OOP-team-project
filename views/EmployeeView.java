package views;

import java.io.IOException;
import java.util.Vector;
import java.util.stream.Collectors;
import data.Data;
import data.Message;
import users.Employee;
import users.User;

public abstract class EmployeeView extends UserView{

	public EmployeeView(){}

	public EmployeeView(Employee employee){
		super(employee);
	}

	public void viewMessages() throws IOException{
		Vector <Message> messages = ((Employee)user).getMessages();
		while(true){
			System.out.println("0. Exit");
			int count = 1;
			for(Message cur: messages){
				System.out.println(count + "." + cur);
				count++;
			}
			String ans = scanner.next();
			if(ans.equals("0")){
				return;
			}
			try{
				viewMessage(messages.get(Integer.parseInt(ans) - 1));
			}
			catch (IndexOutOfBoundsException iofe){
				System.out.println("Wrong answer");
			}
			catch (NumberFormatException nfe){
				System.out.println("Not a number");
			}
		}
	}

	public void viewMessage(Message message) throws IOException{
		System.out.println(message.getMessage());
	}

	public void sendMessage() throws IOException{
		System.out.println("Insert Employee's login to send message to: ");
		User receiver;
		String name = scanner.next();
		while(true){
			try{
				receiver = Data.getInstance().getUsers().stream()
				.filter(u-> u instanceof Employee)
				.filter(e -> e.getLogin().equals(name))
				.collect(Collectors.toList()).get(0);
				break;
			}
			catch (IndexOutOfBoundsException ioofe){
				System.out.println("No such user");
			}
		}
		System.out.println("Insert message theme: ");
		String theme = scanner.next();
		System.out.println("Insert message text: ");
		String text = scanner.next();
		((Employee)user).sendMessage((Employee)receiver, theme, text);
	}
}
