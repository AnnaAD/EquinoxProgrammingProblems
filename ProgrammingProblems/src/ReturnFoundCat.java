
public class ReturnFoundCat {
	public static void main(String args[]) {
		float[] catCoors = {3f,3f};
		float[][] cityCoors = {{0f,1f},{1f,2f},{2f,2f,}};
		
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