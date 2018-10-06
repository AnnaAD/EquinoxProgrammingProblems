import java.util.ArrayList;

public class DifficultyRanker {
	public static void main (String args[]) {
		String[][] data = {{"catProblem","32"},{"catProblem","80"},{"dogProblem","75"}};
		System.out.println(solution(data));
	}
	
	public static String solution(String[][] problemList) {
		ArrayList<String> problemTypes = new ArrayList<String>();
		ArrayList<Integer> problemTimes = new ArrayList<Integer>();
		
		for(int i = 0; i < problemList.length; i++) {
			if(!problemTypes.contains(problemList[i][0])) {
				problemTypes.add(problemList[i][0]);
				problemTimes.add(Integer.parseInt(problemList[i][1]));
			} else {
				int index = problemTypes.indexOf(problemList[i][0]);
				problemTimes.set(index,problemTimes.get(index) + Integer.parseInt(problemList[i][1]));
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
