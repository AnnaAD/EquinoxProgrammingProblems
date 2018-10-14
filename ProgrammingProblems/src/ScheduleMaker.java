import java.util.Scanner;

public class ScheduleMaker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		String startTime = sc.nextLine();
		String[][] activities = new String[n][2];
		for(int i = 0; i < n; i++) {
			activities[i] = sc.nextLine().split(" ");
		}
		
		// System.out.println(m);

		System.out.println(solution(startTime, m, activities));
	}
	
	public static String solution(String startTime, int bufferTime, String[][] activities) {
		String output = "";
		String openTime = startTime;
		for(int i = 0; i < activities.length; i++) {
			output += openTime + "-" + addTime(openTime,Integer.parseInt(activities[i][1])) + ": " + activities[i][0] + " | ";
			openTime = addTime(openTime,Integer.parseInt(activities[i][1]));
			openTime = addTime(openTime,bufferTime);
		}
		return output.substring(0,output.length()-3);
	}
	
	public static String addTime(String startTime, int minutes) {
		String[] timeParts = startTime.split(":");
		int hour = Integer.parseInt(timeParts[0]);
		int currentMinutes = Integer.parseInt(timeParts[1].substring(0, 2));
		String partOfDay = timeParts[1].substring(2, 4);
		
		currentMinutes+=minutes;
		while(currentMinutes >= 60) {
			currentMinutes -= 60;
			hour++;
			while(hour > 12) {
				hour -= 12;
			}
			
			if(hour == 12) {
				if(partOfDay.equals("pm")) {
					partOfDay = "am";
				} else {
					partOfDay = "pm";
				}
			}
		}
		
		String outputMinutes = currentMinutes + "";
		if(outputMinutes.length() < 2) {
			outputMinutes = "0" + outputMinutes;
		}
		
		return hour+":"+outputMinutes+partOfDay;
	}

}
