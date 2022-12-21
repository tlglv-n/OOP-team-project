package views;

import java.io.IOException;

import users.ORManager;

public class ORManagerView extends ManagerView{

    public ORManagerView(){}

    public ORManagerView(ORManager orManager){
        super(orManager);
    }

    public void createNews() throws IOException{
        print("Insert topic: ");
        String theme = reader.readLine();
        print("Insert topic: ");
        String text = reader.readLine();
    }

    public void main(){

    }
}