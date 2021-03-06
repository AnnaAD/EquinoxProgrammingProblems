
public class LetterFrequency {
	public static void main(String args[]) {
		String input = "aaabbcccc";
		System.out.println(solution(input));
	}
	
	public static String solution(String input) {
		char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int[] frequencies = new int[26];
		for(int i = 0; i < input.length(); i++) {
			for(int j = 0; j < letters.length; j++) {
				if(input.charAt(i) == letters[j]) {
					frequencies[j]++;
				}
			}
		}
		
		
		int max = 0;
		int maxIndex = 0;
		for(int i = 0; i < frequencies.length; i++) {
			if(frequencies[i] > max) {
				maxIndex = i;
				max = frequencies[i];
			}
		}
		
		return ""+letters[maxIndex];
	}
}
