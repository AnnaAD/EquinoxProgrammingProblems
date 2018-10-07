import java.util.Scanner;

public class FindDNAPattern {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String check = sc.nextLine();
		String input = sc.nextLine();
		System.out.println(solution(input,check));
	}
	
	public static int solution(String DNA, String target) {
		int output = 0;
		for(int i = 0; i < DNA.length() - (target.length()-1); i++) {
			if(checkString(DNA.substring(i, i+target.length()), target)) {
				output++;
			}
		}
		return output;
	}
	
	public static boolean checkString(String inputStr, String targetStr) {
		//System.out.println(inputStr);
		String[] letters = inputStr.split("");
		int[] matches = new int[letters.length];
		for(int i = 0; i < letters.length; i++) {
			if(letters[i].equals(targetStr.substring(i,i+1))) {
				matches[i] = 1;
			}
		}
		int total = 0;
		for(int i = 0; i < matches.length; i++) {
			total += matches[i];
		}
		return (total >= targetStr.length()-1);
	}
}
