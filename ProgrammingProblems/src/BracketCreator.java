import java.util.*;

public class BracketCreator {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        int numTeams = scan.nextInt();
        scan.nextLine();
        List<String> teams = new ArrayList<>();
        for(int i=0; i< numTeams; i++) {
            teams.add(scan.next());
        }
        System.out.println(seedTeams(teams));

    }

    private static List<String> seedTeams(List<String> unseededTeams) {
        ArrayList<String> seededTeams = new ArrayList<>(unseededTeams);
        int stepSize = 1;

        while (stepSize < unseededTeams.size() / 2) {
            ArrayList<String> newList = new ArrayList<>();
            for (int i = 0; i < unseededTeams.size() / 2; i += stepSize) {
                newList.addAll(seededTeams.subList(i, i + stepSize));
                newList.addAll(seededTeams.subList(seededTeams.size() - i - stepSize,
                        seededTeams.size() - i));
            }
            seededTeams = newList;
            stepSize = stepSize * 2;
        }

        return seededTeams;
    }
}
