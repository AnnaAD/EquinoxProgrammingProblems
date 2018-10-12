import java.util.*;
public class IslandHopper {
    public static void main(String []args){
        // Reads input
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int start = scan.nextInt();
        int end = scan.nextInt();
        int[][] islands = new int[size][size];
        for(int i=0; i < size; i++) {
            for (int j = 0; j < size; j++)
                islands[i][j] = scan.nextInt();
        }

        System.out.println(checkPath(islands, start, end));



    }

    private static boolean checkPath(int [][] islands, int start, int end) {
        ArrayList<Integer> queue= new ArrayList<>();
        // 0 represents unvisited, 1 represents visited
        int [] visited = new int[islands.length];
        queue.add(start);
        while(!queue.isEmpty()) {
            int current = queue.remove(0);
            if(current == end)
                return true;
            for(int i=0; i < islands.length; i++) {
                // checks if there is a path between current and i, and i hasn't already been visited
                if(islands[i][current] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }
        return false;

    }
}
