package views;

import java.io.IOException;

import data.News;
import users.ORManager;

public class ORManagerView extends ManagerView{

    public ORManagerView(){}

    public ORManagerView(ORManager orManager){
        super(orManager);
    }

    public void createNews() throws IOException{
        while(true){
            print("Insert topic or 0 to exit: ");
            String theme = reader.readLine();
            if(theme.equals("0")){
                return;
            }
            print("Insert topic: ");
            String text = reader.readLine();
            new News(theme, text);
            print("News were updated successfully: ");
        }
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
				print("6. Create news");
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
						createNews();
						break;
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