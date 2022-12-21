package users ;
/**
 *The class with which we select the user type
*/
public class UserFactory{
	/**
	 *Method for getting a different type of user
	 *@param type The type of user
	 *@return User Create a user of type. If the type is null, then return null
	 *@see UserFactory#getUser(String, String,UserType)
	*/
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
	/**
	 *Method for getting a different type of user
	 *@param type The type of user
	 *@param login The username
	 *@param password The password of user
	 *@return User Create a user of type. If the type is null, then return null
	 *@see UserFactory#getUser(UserType)
	*/
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

