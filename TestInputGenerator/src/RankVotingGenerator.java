import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class RankVotingGenerator {
	public static String names = "Gregory Sherell Angel Jaqueline Salina Major Lupita Gladis Cristie Laticia Alleen Mertie India Odell Azalee Charlsie Corrine Isela Alonso Laurinda Genoveva Vella Gerard Shu Krystin Layne Guillermo Loris Charlyn Sanjuana Gena Idella Shelia Iola Ressie Karl Joaquina Josefina Lorene Marilou Roxane Chanell Barb Kylee Marcelo Marvin Charles Shawanna Hilario Meghan Marylee Yelena Rebeca Jamar Marcus Raeann Keenan Marietta Argentina Carlie Muriel Wei Carolin Hope Brigida Alise Gertrudis Rema Darcel Kathryne Catharine Karole Tiffani Altagracia Sharolyn Tama Zora Starla Svetlana Paulina Sharleen Vena Williams Simona Rivka Lizabeth Freda Page Gracia Matha Maddie Allyn Shanika Tenesha Neida Donetta Sarina Sherika";
	public static String[] nameList = names.split(" ");
	
	public static void main(String args[]) {
		int numCandidates = 3;
		int numVoters = 10000;
		int numFile = 9;
		
		File file = new File("/Users/anna/Documents/GitHub/EquinoxProgrammingProblems/TestCases/InstantRun-OffVoting/input/input0" + numFile + ".txt");
		
		file.getParentFile().mkdirs();

		PrintWriter printWriter = null;
		
		try {
			printWriter = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		ArrayList<String> candidates = new ArrayList<String>();
		
		
		for(int i = 0; i < numCandidates; i++) {
			int index = (int) (Math.random() * 98);
			if(candidates.indexOf(nameList[index]) == -1) {
				candidates.add(nameList[index]);
			}
		}
		
		printWriter.println(candidates.size());

		for(String vote : candidates) {
			printWriter.println(vote);
		}
		
		printWriter.println(numVoters);
		
		for(int i = 0; i < numVoters; i++) {
			Collections.shuffle(candidates);
			
			for(String vote : candidates) {
				printWriter.print(vote + " ");
			}
			printWriter.println();
		}
		
		printWriter.close();

	}
}
