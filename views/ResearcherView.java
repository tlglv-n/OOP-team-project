package views;

import java.io.IOException;

import data.ResearchPaper;
import users.Researcher;
public class ResearcherView extends UserView{

	public ResearcherView(){
		super();
	}
	public void startResearch() throws IOException {
		print("Insert the name of researching. '0' is exit");
		String name = reader.readLine();
		if(name.equals("0")) {
			return;
		}
		print("Insert the theme of researching");
		String theme = reader.readLine();
		print("Insert the field of study");
		String fieldStudy = reader.readLine();
		
		ResearchPaper paper = new ResearchPaper(name, theme, fieldStudy);
		((Researcher)user).addResearch(paper);
		print("Researching is started!");
	}
	public void dropResearch() throws IOException {
		print("Print the name of researching that you want to drop."
				+ "'0' is exit.");
		String name = reader.readLine();
		if(name.equals("0")) {
			return;
		}
		print("Print the theme of researching");
		String theme = reader.readLine();
		print("Print the field of study");
		String fieldStudy = reader.readLine();
		
		ResearchPaper paper = new ResearchPaper(name, theme, fieldStudy);
		((Researcher)user).dropResearch(paper);
		print("Researching is dropped!");
	}
	public void viewResearch() {
		for(ResearchPaper paper: ((Researcher)user).getResearches()) {
			print(paper.toString());
		}
	}
	public void finishResearch() {
		print("Print the name, theme and field of study of researching" +
				"By the enter.");
		String name = reader.readLine();
		String theme = reader.readLine();
		String fieldStudy = reader.readLine();
		ResearchPaper needPaper = new ResearchPaper(name, theme, fieldStudy);
		for(ResearchPaper paper: ((Researcher)user).getResearches()) {
			if(paper.equals(needPaper)) {
				paper.setStatus(true);
				print("The status of researching is finished.");
				return;
			}
		}
		print("Something is wrong");
	}
	public void main(){
		while(true){
			try{
				print("0. Exit");
				print("1. View news");
				print("2. View personal info");
				print("3. Change password");
				print("4. Start research");
				print("5. Drop research");
				print("6. View researches");
				print("7. Finish research");
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
						startResearch();
						break;
					case "5":
						dropResearch();
						break;
					case "6":
						viewResearch();
						break;
					case "7":
						finishResearch();
					default:
						print("No such option");
				}
			}
			catch (IOException ioe){
				System.out.println("Something is wrong");
			}
		}
	}

}

