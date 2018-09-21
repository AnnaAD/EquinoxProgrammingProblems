
public class FindDNAPattern {
	public static void main(String args[]) {
		String input = "GDACOTDATQ";
		System.out.println(solution(input,"CAT"));
	}
	
	public static int solution(String DNA, String target) {
		int output = 0;
		for(int i = 0; i < DNA.length() - target.length(); i++) {
			if(checkString(DNA.substring(i, i+target.length()), target)) {
				output++;
			}
		}
		return output;
	}
	
	public static boolean checkString(String inputStr, String targetStr) {
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
