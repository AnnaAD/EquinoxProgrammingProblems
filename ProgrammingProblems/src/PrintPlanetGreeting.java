import java.util.Scanner;
public class PrintPlanetGreeting {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String planet = s.nextLine();
		System.out.println(solution(planet));
	}
	
	public static String solution(String planet) {
		return "Hello " + planet + "!";
	}
}
