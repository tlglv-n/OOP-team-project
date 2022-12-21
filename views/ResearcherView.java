package views;

import java.io.IOException;
import data.ResearchPaper;
import users.Researcher;

public class ResearcherView extends UserView{

	Researcher researcher;

	public ResearcherView(){
		super();
	}

	public ResearcherView(Researcher researcher){
		this.researcher = researcher;
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
		researcher.addResearch(paper);
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
		researcher.dropResearch(paper);
		print("Researching is dropped!");
	}
	public void viewResearch() throws IOException{
		for(ResearchPaper paper: (researcher.getResearches())) {
			print(paper.toString());
		}
	}
	public void finishResearch() throws IOException {
		print("Print the name, theme and field of study of researching" +
				"By the enter.");
		String name = reader.readLine();
		String theme = reader.readLine();
		String fieldStudy = reader.readLine();
		ResearchPaper needPaper = new ResearchPaper(name, theme, fieldStudy);
		for(ResearchPaper paper: researcher.getResearches()) {
			if(paper.equals(needPaper)) {
				paper.finish();
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
				print("1. Start research");
				print("2. Drop research");
				print("3. View researches");
				print("4. Finish research");
				String ans = reader.readLine();
				switch(ans){
					case "0":
						return;
					case "1":
						startResearch();
						break;
					case "2":
						dropResearch();
						break;
					case "3":
						viewResearch();
						break;
					case "4":
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

