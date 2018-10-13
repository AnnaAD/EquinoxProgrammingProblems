import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TemperatureDataGenerator {
	public static void main(String[] args) {
		PrintWriter printWriter = null;
		
		for(int i = 0; i < 20; i++) {
			
			String index = i + "";
			if (index.length() < 2) {
				index = "0" + index;
			}
			File file = new File("/Users/anna/Documents/GitHub/EquinoxProgrammingProblems/TestCases/FarenheitCelciusConvertor/input/input" + index + ".txt");
			file.getParentFile().mkdirs();

			
			try {
				printWriter = new PrintWriter(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return;
			}
			
			String value = String.format("%.5g", (Math.random() * 2000) - 1000);
			
			if(Math.random() > 0.5) {
				value += "F";
			} else {
				value += "C";
			}
			printWriter.println(value);
			printWriter.close();
		}
	}
}
