package users;

import java.util.Vector;
import java.util.Collection;

public class ResearchTeam extends Researcher{
	private Vector <Researcher> researchers = new Vector <Researcher> ();

	public ResearchTeam(){
		super();
	}

	public ResearchTeam(Collection <Researcher> researchers){
		this.researchers.addAll(researchers);
	}

}

