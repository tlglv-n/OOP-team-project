package users;

import java.util.Collection;
import java.util.Vector;

import data.ResearchPaper; 

public class ResearchTeam extends Researcher{

	private Vector <Researcher> researchers = new Vector <Researcher> ();

	public ResearchTeam(){
		super();
	}

	public ResearchTeam(Collection <Researcher> researchers){
		this.researchers.addAll(researchers);
	}

	public Vector <Researcher> getResearchers(){
		return researchers;
	}

	public void addResearch(ResearchPaper researchPaper){
		getResearches().add(researchPaper);
		for(Researcher r : researchers){
			r.addResearch(researchPaper);
		}
	}

	public void dropResearch(ResearchPaper researchPaper){
		getResearches().remove(researchPaper);
		for(Researcher r : researchers){
			r.dropResearch(researchPaper);
		}
	}

}

