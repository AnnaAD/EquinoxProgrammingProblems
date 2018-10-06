import java.util.*;
public class KaprekarsConstant {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.println(helper(num));
    }

    public static int helper(int num) {
        int[] numArr = new int[4];
        for(int i=0; i < 4; i++) {
            numArr[i] = num  % 10;
            num = num/10;
        }

        Arrays.sort(numArr);

        int forward = 0;
        int backward =0;
        for(int i=0; i < 4; i++) {
            forward+= numArr[i] * Math.pow(10, i);
            backward+= numArr[i] * Math.pow(10, 4 - i -1);
        }

        int res = forward - backward;
        if(res == 6174)
            return 1;
        else
            return 1 + helper(res);

    }
}
