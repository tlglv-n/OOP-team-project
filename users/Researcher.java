package users;

import java.util.Vector;
import data.ResearchPaper;


public class Researcher implements IResearcher{

	private IResearcher r;
	private Vector <ResearchPaper>;

	public IResearcher getDecoratedObject(){
		return r;
	}
	
}

