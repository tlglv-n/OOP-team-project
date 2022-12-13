package users;


public class Dropped implements IDropped{

	private IDropped st;

	public Dropped(IDropped st){
		this.st = st;
	}

	public IDropped getDropped(){
		return st;
	}
}

