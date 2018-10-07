import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InstantRunoffVoting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] candidates = new String[n];
		for(int i = 0; i < n; i++) {
			candidates[i] = sc.nextLine();
		}
		int m = sc.nextInt();
		sc.nextLine();
		String[] voters = new String[m];
		for(int i = 0; i < m; i++) {
			voters[i] = sc.nextLine();
		}
		System.out.println(solution(candidates,voters));
	}
	
	public static String solution(String[] candidates, String[] votes) {
		ArrayList<Voter> voters = new ArrayList<Voter>();
		for(int i = 0; i < votes.length; i++) {
			ArrayList<String> prefrences = new ArrayList<String>();
			prefrences.addAll(Arrays.asList(votes[i].split(" ")));
			voters.add(new Voter(prefrences));
		}
		
		ArrayList<String> candidatesRunning = new ArrayList<String>();
		candidatesRunning.addAll(Arrays.asList(candidates));
		while(candidatesRunning.size() > 1) {
			doRound(candidatesRunning,voters);
		}
		return candidatesRunning.get(0);
	}
	
	public static void doRound(ArrayList<String> candidates, ArrayList<Voter> voters) {
		int[] votes = new int[candidates.size()];
		for(int i = 0; i < voters.size(); i++) {
			for(int j = 0; j < candidates.size(); j++) {
				votes[j] += voters.get(i).getScore(candidates.get(j));
			}
		}
		
		int min = votes[0];
		int minI = 0;
		for(int i = 1; i < votes.length; i++) {
			if(votes[i] < min) {
				minI = i;
				min = votes[i];
			}
		}
		
		for(int i = 0; i < voters.size(); i++) {
			voters.get(i).eliminateCandidate(candidates.get(minI));
		}
		
		candidates.remove(minI);
		
	}
	
	private static class Voter {
		ArrayList<String> candidates;
		
		private Voter(ArrayList<String> candidates) {
			this.candidates = candidates;
		}
		
		public void eliminateCandidate(String name) {
			candidates.remove(name);
		}
		
		public int getScore(String name) {
			return (candidates.size() - candidates.indexOf(name));
		}
		
	}

}
