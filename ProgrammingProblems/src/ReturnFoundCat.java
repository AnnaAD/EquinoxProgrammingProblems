import java.util.Scanner;

public class ReturnFoundCat {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		float[] catCoors = new float[]{sc.nextFloat(), sc.nextFloat()};
		float[][] cityCoors = new float[n][];
		
		
		
		for(int i = 0; i < n; i++) {
			cityCoors[i] = new float[]{sc.nextFloat(), sc.nextFloat()};
		}
		
		float[] output = solution(catCoors, cityCoors);
		
		for(float f: output) {
			System.out.print(f + " ");
		}
	}
	
	public static float[] solution(float[] catCoors, float[][] cityCoors) {
		float[] distances = new float[cityCoors.length];
		
		float smallestVal =  (float) Math.hypot((catCoors[0] - cityCoors[0][0]), (catCoors[1] - cityCoors[0][1]));
		int smallestIndex = 0;
		for(int i = 0; i < distances.length; i++) {
			distances[i] = (float) Math.hypot((catCoors[0] - cityCoors[i][0]), (catCoors[1] - cityCoors[i][1]));
			if(distances[i] < smallestVal) {
				smallestVal = distances[i];
				smallestIndex = i;
			}
		}
		
		return cityCoors[smallestIndex];
		
		
	}
}
