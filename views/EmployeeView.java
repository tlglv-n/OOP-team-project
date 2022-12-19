package views;

import java.io.IOException;
import java.util.Vector;
import data.Message;
import users.Employee;

public abstract class EmployeeView extends UserView{

	public EmployeeView(){}

	public EmployeeView(Employee employee){
		super(employee);
	}

	public abstract void main();

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

}

