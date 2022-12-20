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
			writer.write("0. Exit", 0, 0);
			writer.newLine();
			int count = 1;
			for(Message cur: messages){
				writer.write(count + "." + cur);
				writer.newLine();
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
				writer.write("Wrong answer", 0, 0);
				writer.newLine();
			}
			catch (NumberFormatException nfe){
				writer.write("Not a number", 0, 0);
				writer.newLine();
			}
		}
	}

	public void viewMessage(Message message) throws IOException{
		writer.write(message.getMessage());
		writer.newLine();
	}

	public void sendMessage() throws IOException{
		writer.write("Insert Employee's login to send message to: ");
		writer.newLine();
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
				writer.write("No such user", 0, 0);
			}
		}
		writer.write("Insert message theme: ");
		writer.newLine();
		String theme = reader.readLine();
		writer.write("Insert message text: ");
		writer.newLine();
		String text = reader.readLine();
		((Employee)user).sendMessage((Employee)receiver, theme, text);
	}
}
