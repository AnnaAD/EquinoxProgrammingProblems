import java.util.ArrayList;
import java.util.Scanner;

public class EvenSplit {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int important = sc.nextInt();
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		
		System.out.println(solution(important, nums));
	}

	private static boolean solution(int important, int[] nums) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		ArrayList<Integer> frequencies = new ArrayList<Integer>();
		if((nums.length % important) == 0) {
			int arraySize = nums.length/important;
			for(int i = 0; i < nums.length; i++) {
				if(values.contains(nums[i])) {
					int index = values.indexOf(new Integer(nums[i]));
					frequencies.set(index, frequencies.get(index)+1);
				} else {
					values.add(nums[i]);
					frequencies.add(1);
				}
			}
			for(int i = 0; i < frequencies.size(); i++) {
				if(frequencies.get(i) != arraySize) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	
}
