
public class Gerrymandering {
	public static void main(String args[]) {
		int i = 10000;
		System.out.println(i);
		for(int j = 0; j < i; j++) {
			int rand = (int)(Math.random() * 100);
			int randother = 100-rand;
			System.out.println(rand + " " + (randother));
		}
	}
}
