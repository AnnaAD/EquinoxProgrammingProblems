import java.util.ArrayList;
import java.util.Scanner;

public class DifficultyRanker {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[][] data = new String[n][];
		for(int i = 0; i < n; i++) {
			data[i] = sc.nextLine().split(" ");
		}
		System.out.println(solution(data));
	}
	
	public static String solution(String[][] problemList) {
		ArrayList<String> problemTypes = new ArrayList<String>();
		ArrayList<Integer> problemTimes = new ArrayList<Integer>();
		ArrayList<Integer> problemFrequency = new ArrayList<Integer>();
		for(int i = 0; i < problemList.length; i++) {
			if(!problemTypes.contains(problemList[i][0])) {
				problemTypes.add(problemList[i][0]);
				problemTimes.add(Integer.parseInt(problemList[i][1]));
				problemFrequency.add(1);
			} else {
				int index = problemTypes.indexOf(problemList[i][0]);
				problemFrequency.set(index, problemFrequency.get(index) + 1);
				problemTimes.set(index,(problemTimes.get(index) + Integer.parseInt(problemList[i][1]))/problemFrequency.get(index));
			}
		}
		
		int max = 0;
		int maxI = -1;
		for(int i = 0; i < problemTimes.size(); i++) {
			if(problemTimes.get(i) >= max) {
				max = problemTimes.get(i);
				maxI = i;
			}
		}
		
		return problemTypes.get(maxI);
	}
}
