package users;

import java.util.Vector;
import data.ResearchPaper;


public class Researcher{

	private IResearcher researcher;
	private Vector <ResearchPaper> researches;

	protected Researcher(){}

	public Researcher(IResearcher researcher){ 
		this.researcher = researcher;
	}

	public IResearcher getDecoratedObject(){
		return researcher;
	}

	public Vector <ResearchPaper> getResearches(){
		return researches;
	}
	
}

