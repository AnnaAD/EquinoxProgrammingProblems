import java.util.*;
public class CoinFlip {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        List<String> combos = new ArrayList<>();
        helper(combos, num/2, num/2, "");
        Collections.sort(combos);
        for(int i=0; i < combos.size(); i++) {
            System.out.print(combos.get(i));
            if (i != combos.size() - 1)
                System.out.print(" ");
        }
    }

    public static void helper(List<String> combos, int numH, int numT, String cur) {
        if(numH > 0)
            helper(combos, numH -1, numT, cur+"H");
        if(numT > 0)
            helper(combos, numH, numT - 1, cur+"T");
        if(numH == 0 && numT == 0)
            combos.add(cur);
    }
}
