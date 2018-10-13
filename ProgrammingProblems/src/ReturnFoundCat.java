import java.util.Scanner;

public class ReturnFoundCat {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		
		String[] catCoors = sc.nextLine().split(" ");
		String[][] cityCoors = new String[n][];
		
		
		for(int i = 0; i < n; i++) {
			cityCoors[i] = sc.nextLine().split(" ");
		}
		
		String[] output = solution(catCoors, cityCoors);
		
		for(String f: output) {
			System.out.print(f + " ");
		}
	}
	
	public static String[] solution(String[] catCoors, String[][] cityCoors) {
		float[] distances = new float[cityCoors.length];
		
		float smallestVal =  (float) Math.hypot((Float.parseFloat(catCoors[0]) - Float.parseFloat(cityCoors[0][0])), (Float.parseFloat(catCoors[1]) - Float.parseFloat(cityCoors[0][1])));
		int smallestIndex = 0;
		for(int i = 0; i < distances.length; i++) {
			distances[i] = (float) Math.hypot((Float.parseFloat(catCoors[0]) - Float.parseFloat(cityCoors[i][0])), (Float.parseFloat(catCoors[1]) - Float.parseFloat(cityCoors[i][1])));
			if(distances[i] < smallestVal) {
				smallestVal = distances[i];
				smallestIndex = i;
			}
		}
		
		return cityCoors[smallestIndex];	
		
	}
}
