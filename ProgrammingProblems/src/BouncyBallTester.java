
public class BouncyBallTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(1f,0.5f));
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
