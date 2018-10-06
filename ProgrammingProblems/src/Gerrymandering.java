import java.util.*;
public class Gerrymandering {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.nextLine();
        int list [] = new int[num];
        for(int i=0; i < num; i++)
            list[i] = Integer.parseInt(scan.nextLine().trim().split(" ")[0]);

        // Calculates aggregate percent of votes won
        int total = 0;
        for(int i =0; i< num; i++) {
            total += list[i];
        }
        int aggregatepercent = (int)(total / (100.0 *num) * 100);

        //Calculates percent of districts won
        total = 0;
        for(int i=0; i< num; i++) {
            if(list[i] > 50)
                total++;
        }

        int districtpercent = (int)(total / (double)(num) * 100);

        System.out.println(Math.abs(aggregatepercent - districtpercent));
    }
}
