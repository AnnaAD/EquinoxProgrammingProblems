import java.util.Scanner;

public class FarenheitCelciusConvertor {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String command = sc.nextLine();
		
		if(command.charAt(command.length()-1) == 'F') {
			float valF = Float.parseFloat(command.substring(0, command.length()-1));
			System.out.println(((valF-32) * 5/9) + "C");
		} else {
			float valC = Float.parseFloat(command.substring(0, command.length()-1));
			System.out.println(((valC * 9 / 5) + 32) + "F");
		}
	}
}
