package users ;

public class UserFactory{

	public static User getUser(UserType type) {
		if(type == UserType.ADMIN){
			return new Admin();
		}
		if(type == UserType.LIBRARIAN){
			return new Librarian();
		}
		if(type == UserType.OR_MANAGER){
			return new ORManager();
		}
		if(type == UserType.SCHOOL_MANAGER){
			return new SchoolManager();
		}
		if(type == UserType.TEACHER){
			return new Teacher();
		}
		if(type == UserType.STUDENT){
			return new Student();
		}
		return null;
	}
	
}

