import java.util.Scanner;

public class DiceRoll {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		float random = sc.nextFloat();
		
		System.out.println((int) (random*6) + 1);

	}

}
