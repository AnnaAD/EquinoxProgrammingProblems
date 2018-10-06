import java.util.Scanner;

public class BouncyBallTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		float i = sc.nextFloat();
		float j = sc.nextFloat();

		
		System.out.println(solution(i,j));
	}
	
	public static int solution(float altitude, float nextBounceMultiplier) {
		int bounces = 0;
		while(altitude > 0.0001f) {
			altitude *= nextBounceMultiplier;
			bounces++;
		}
		return bounces;
	}

}
