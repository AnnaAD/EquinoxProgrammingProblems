import java.util.Scanner;

public class BlackJackCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cards = "A,2,3,4,5,6,7,8,9,10,J,Q,K";
		String[] cardList = cards.split(",");
		
		String val1 = sc.nextLine();
		String val2 = sc.nextLine();
		String val3 = sc.nextLine();
		
		int a = 0;
		int total = 0;
		
		for(int i = 0; i < cardList.length; i++) {
			if(cardList[i].equals(val1)) {
				if(cardList[i].equals("A")) {
					a++;
					total += 11;
				} else {
					try {
						total += Integer.valueOf(cardList[i]);
					} catch (NumberFormatException e) {
						total += 10;
					}
				}
			}
		}
		
		for(int i = 0; i < cardList.length; i++) {
			if(cardList[i].equals(val2)) {
				if(cardList[i].equals("A")) {
					a++;
					total += 11;
				} else {
					try {
						total += Integer.valueOf(cardList[i]);
					} catch (NumberFormatException e) {
						total += 10;
					}
				}
			}
		}
		
		for(int i = 0; i < cardList.length; i++) {
			if(cardList[i].equals(val3)) {
				if(cardList[i].equals("A")) {
					a++;
					total += 11;
				} else {
					try {
						total += Integer.valueOf(cardList[i]);
					} catch (NumberFormatException e) {
						total += 10;
					}
				}
			}
		}
		
		while (a>0 && total > 21) {
			total -=10;
		}
		
		
		
		System.out.println(total);

	}

}
