import java.util.ArrayList;

public class AnalyzeSales {

	public static void main(String args[]) {
		String[][] sales = { { "10", "Gender : Female, Region : USA" }, { "25", "Gender : Male, Region : Canada" }, { "20", "Gender : Female, Region : Canada" }};
		System.out.println(solution(sales, "Gender"));
	}

	public static String solution(String[][] sales, String demographic) {
		ArrayList<String> targetDemographicValues = new ArrayList<String>();
		ArrayList<Integer> profitFromDemo = new ArrayList<Integer>();
		for (String[] purchase : sales) {
			int profit = Integer.parseInt(purchase[0]);
			String[][] demographicsInfo = makeDemographicsInfo(purchase[1]);


			for (int i = 0; i < demographicsInfo.length; i++) {
				if (demographicsInfo[i][0].equals(demographic)) {
					boolean found = false;
					for (int j = 0; j < targetDemographicValues.size(); j++) {
						if (targetDemographicValues.get(j).equals(demographicsInfo[i][1])) {
							profitFromDemo.set(j, profitFromDemo.get(i)+profit);
							found = true;
						}
					}
					if (!found) {
						targetDemographicValues.add(demographicsInfo[i][1]);
						profitFromDemo.add(profit);
					}
				}
			}
		}
		
		int maxValue = -1;
		int maxIndex = -1;
		for (int i = 0; i < targetDemographicValues.size(); i++) {
			if (profitFromDemo.get(i) > maxValue) {
				maxValue = profitFromDemo.get(i);
				maxIndex = i;
			}
		}
		return targetDemographicValues.get(maxIndex);
	}

	public static String[][] makeDemographicsInfo(String demographicsString) {
		String[] demographicsRows = demographicsString.split(",");
		String[][] demographicInfo = new String[demographicsRows.length][];
		for (int i = 0; i < demographicsRows.length; i++) {
			demographicInfo[i] = demographicsRows[i].split(" : ");
			for (int j = 0; j < demographicInfo[i].length; j++) {
				demographicInfo[i][j] = demographicInfo[i][j].trim();
			}
		}
		return demographicInfo;
	}

}
