import data.Data;
import users.Admin;

public class AdminTest {

	public static void main(String[] args) {
		Admin check = (Admin)Data.getInstance().getUser("China", "Kaguya");
		System.out.println(check);
	}

}
