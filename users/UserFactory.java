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

	public static User getUser(String login, String password, UserType type){
		if(type == UserType.ADMIN){
			return new Admin(login, password);
		}
		if(type == UserType.LIBRARIAN){
			return new Librarian(login, password);
		}
		if(type == UserType.OR_MANAGER){
			return new ORManager(login, password);
		}
		if(type == UserType.SCHOOL_MANAGER){
			return new SchoolManager(login, password);
		}
		if(type == UserType.MANAGER){
			return new Manager(login, password);
		}
		if(type == UserType.STUDENT){
			return new Student(login, password);
		}
		if(type == UserType.TEACHER){
			return new Teacher(login, password);
		}
		if(type == UserType.EMPLOYEE){
			return new Employee(login, password);
		}
		return null;
	}
	
}

