import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class BlackJackGenerator {
	
	public static void main(String[] args) {
		PrintWriter printWriter = null;
		String cards = "A,2,3,4,5,6,7,8,9,10,J,Q,K";
		String[] cardList = cards.split(",");
		
		
		for(int i = 0; i < 20; i++) {
			
			String index = i + "";
			if (index.length() < 2) {
				index = "0" + index;
			}
			File file = new File("/Users/anna/Documents/GitHub/EquinoxProgrammingProblems/TestCases/BlackjackCalculator/input/input" + index + ".txt");
			file.getParentFile().mkdirs();

			
			try {
				printWriter = new PrintWriter(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return;
			}
			
			for(int j = 0; j < 2; j++) {
				int random = (int) (Math.random()*cardList.length);
				printWriter.println(cardList[random]);
			}
			printWriter.close();
		}
	}
}
