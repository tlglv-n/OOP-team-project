import data.Data;
import data.School;
import users.Admin;

public class AdminTest {

	public static void main(String[] args) {
		Data.getInstance().addSchool(new School("SITE", "Informational techs"));
		Data.getInstance().addUser(new Admin("China", "Kaguya"));
		Data.serialize();
	}

}
