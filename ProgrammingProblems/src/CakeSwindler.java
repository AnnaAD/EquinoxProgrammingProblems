import java.util.Scanner;
public class CakeSwindler {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] bakeries = new int[num];
        for(int i=0; i< num; i++)
            bakeries[i] = scan.nextInt();
        int result = Math.max( helper(bakeries, 0), helper(bakeries, 1));
        System.out.println(result);
    }

    public static int helper(int [] bakeries, int index) {
        if(index >= bakeries.length)
                return 0;
        int option1 = helper(bakeries, index+2);
        int option2 = helper(bakeries, index+3);
        return bakeries[index] + Math.max(option1, option2);
    }
}

