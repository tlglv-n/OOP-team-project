package users;

import java.util.Collection;
import java.util.Vector; 

public class ResearchTeam extends Researcher{

	private Vector <Researcher> researchers = new Vector <Researcher> ();

	public ResearchTeam(){
		super();
	}

	public ResearchTeam(Collection <Researcher> researchers){
		this.researchers.addAll(researchers);
	}

}

