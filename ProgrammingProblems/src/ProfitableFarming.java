import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProfitableFarming {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] crops = new String[n];
		int d = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < n; i++) {
			crops[i] = sc.nextLine();
		}
		System.out.println(solution(crops, d));
	}
	
	//[0] = appleCost, [1] = appleProfit, [3] = appleTime
	//[4] - [6] Blueberry information
	//[7] - [9] Carrot information
	//[10] - [12] Tomato Information
	
	public static int solution(String[] crops, int periodLength) {
		ArrayList<Crop> sortedCrops = new ArrayList<Crop>();

		for(int i = 0; i < crops.length; i++) {
			String[] parts = crops[i].split(" ");
			sortedCrops.add(new Crop(parts[0],Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),Integer.parseInt(parts[3])));
		}
		
		int profit = 0;
		
		Collections.sort(sortedCrops);
		//System.out.println(sortedCrops);
		
		int day = 0;
		while(day < periodLength) {
			//System.out.println("Day: " + day);
			for(int i = 0; i < sortedCrops.size(); i++) {
				if(sortedCrops.get(i).canPlant(periodLength - day)) {
					day += sortedCrops.get(i).time;
					profit += sortedCrops.get(i).moneyMadePerSale - sortedCrops.get(i).cost;
					break;
				}
				//we can't plant anything!
				if(i == sortedCrops.size()-1) {
					return profit;
				}
			}
		}
		
		return profit;
		
		
	}
	
	private static class Crop implements Comparable {
		String name;
		int cost;
		int moneyMadePerSale;
		int time;
		int profitperday;
		
		public Crop(String name, int cost, int profit, int time) {
			this.name = name;
			this.cost = cost;
			this.moneyMadePerSale = profit;
			this.time = time;
			this.profitperday = (cost-profit)/time;
		}
		
		public boolean canPlant(int daysLeft) {
			return time <= daysLeft;
		}
		
		@Override
		public int compareTo(Object o) {
			return this.profitperday - ((Crop)o).profitperday;
		}
		
		public String toString() {
			return name;
		}
		
	}
}
