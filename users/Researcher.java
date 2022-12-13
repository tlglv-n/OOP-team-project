package users;

import java.util.Vector;
import data.ResearchPaper;


public class Researcher{

	private IResearcher researcher;
	private Vector <ResearchPaper> researches = new Vector <ResearchPaper>();

	protected Researcher(){}

	public Researcher(IResearcher researcher){
		this.researcher = researcher;
	}

	public IResearcher getObject(){
		return researcher;
	}

	public Vector <ResearchPaper> getResearches(){
		return researches;
	}

	public void addResearch(ResearchPaper researh){
		researches.add(researh);
	}

	public void finishResearch(ResearchPaper research){}

	public void dropResearch(ResearchPaper research){}
	
}

