import java.util.*;
public class Gerrymandering {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.nextLine();
        int list [] = new int[num];
        for(int i=0; i < num; i++)
            list[i] = Integer.parseInt(scan.nextLine().trim().split(" ")[1]);

        // Calculates aggregate percent of votes won
        float total = 0;
        for(int i =0; i< num; i++) {
            total += list[i];
        }
        float aggregatepercent = total / (num);

        //Calculates percent of districts won
        total = 0;
        for(int i=0; i< num; i++) {
            if(list[i] > 50)
                total++;
        }

        float districtpercent = total / ((num) * 100f);

        System.out.println(Math.abs(aggregatepercent - districtpercent));

    }
}