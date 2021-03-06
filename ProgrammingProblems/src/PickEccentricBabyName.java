import java.util.ArrayList;
import java.util.Scanner;

public class PickEccentricBabyName {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] names = new String[n];
		for(int i = 0; i < n; i++) {
			names[i] = sc.nextLine();
		}
		System.out.println(solution(names));
	}
	
	public static String solution(String[] babyNames) {
		int[] letterFrequencies = new int[26];
		String[] letters = {"a","b","c","d","e","f","g", "h", "i", "j", "k", "l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		ArrayList<String> namesWithGoodFirstLetter = new ArrayList<String>();
		for(int i = 0; i < babyNames.length; i++) {
			for(int j = 0; j < letters.length; j++) {
				if(babyNames[i].substring(0, 1).toLowerCase().equals(letters[j])) {
					letterFrequencies[j]++;
				}
			}
		}
		
		
		int greatestVal = Integer.MAX_VALUE;
		int greatestIndex = -1;
		
		for(int i = 0; i < letterFrequencies.length; i++) {
			if(letterFrequencies[i] > 0 && letterFrequencies[i] < greatestVal) {
				greatestVal = letterFrequencies[i];
				greatestIndex = i;
			}
		}
		
		
		for(int i = 0; i < babyNames.length; i++) {
			if(babyNames[i].substring(0,1).toLowerCase().equals(letters[greatestIndex])) {
				namesWithGoodFirstLetter.add(babyNames[i]);
			}
		}
		
		int length = 0;
		int index = 0;
		
		for(int i = 0; i < namesWithGoodFirstLetter.size(); i++) {
			if(namesWithGoodFirstLetter.get(i).length() > length) {
				length = namesWithGoodFirstLetter.get(i).length();
				index = i;
			}
		}
		
		return namesWithGoodFirstLetter.get(index);
	}
}
