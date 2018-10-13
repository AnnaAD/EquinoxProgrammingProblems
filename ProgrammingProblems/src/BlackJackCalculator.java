import java.util.Scanner;

public class BlackJackCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cards = "A,2,3,4,5,6,7,8,9,10,J,Q,K";
		String[] cardList = cards.split(",");
		
		String val1 = sc.nextLine();
		String val2 = sc.nextLine();
		
		boolean a = false;
		int total = 0;
		
		for(int i = 0; i < cardList.length; i++) {
			if(cardList[i].equals(val1)) {
				if(cardList[i].equals("A")) {
					a = true;
					total += 11;
				} else {
					total += i+1; 
				}
			}
		}
		
		for(int i = 0; i < cardList.length; i++) {
			if(cardList[i].equals(val2)) {
				if(cardList[i].equals("A")) {
					a = true;
					total += 11;
				} else {
					total += i+1; 
				}
			}
		}
		
		if(a == true && total > 21) {
			total -= 10;
		}
		
		System.out.println(total);

	}

}
