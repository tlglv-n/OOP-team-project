package users;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Vector;
import data.ResearchPaper;


public class Researcher implements Serializable, Comparable <Researcher>{

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

	public int compareTo(Researcher r){
		if(researches.size() > r.researches.size()){return 1;}
		if(researches.size() < r.researches.size()){return -1;}
		return 0;
	}
	
}

