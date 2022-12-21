import data.Course;
import data.Data;

public class AdminTest {

	public static void main(String[] args) {
		Data.getInstance().addCourse(new Course("21ddd", 3, "OOP"));
		Data.serialize();
	}

}
