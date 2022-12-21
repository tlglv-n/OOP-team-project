import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InputTest {

	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1);
		String news = reader.readLine();
		writer.write("Here");
		writer.flush();
	}

}
