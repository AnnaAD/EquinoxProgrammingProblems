
public class ScheduleMaker {

	public static void main(String[] args) {
		System.out.println(solution("7:30am",5,new String[][] {{"Breakfast","15"},{"School","440"},{"Soccer","75"}}));
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
				if(partOfDay.equals("pm")) {
					partOfDay = "am";
				} else {
					partOfDay = "pm";
				}
			}
		}
		
		String outputMinutes = currentMinutes + "";
		if(outputMinutes.length() < 2) {
			outputMinutes += "0";
		}
		
		return hour+":"+outputMinutes+partOfDay;
	}

}
