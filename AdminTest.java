

import data.Course;
import data.Data;

public class AdminTest {

	public static void main(String[] args) {
		for(Course cur: Data.getInstance().getCourses()){
			System.out.println(cur);
		}
	}
}
