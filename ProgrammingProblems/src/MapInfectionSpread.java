
public class MapInfectionSpread {

	public static void main(String[] args) {
		int[][] map = {{0,0,0,0,0},
					   {0,1,1,0,1},
					   {0,2,1,0,1},
					   {0,0,0,0,1},
					   {1,0,0,1,2}};
		
		int[][] output = solution(map);
		
		for(int[] i : output) {
			for(int j : i) {
				System.out.print(j);
			}
			System.out.println();
		}
	
		

	}
	
	public static int[][] solution(int[][] map){
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 2) {
					spreadInfection(i,j,map);
				}
			}
		}
		
		return map;
	}
	
	public static void spreadInfection(int i, int j, int[][] map) {
		if(i < map.length-1) {
			if(map[i+1][j] == 1) {
				map[i+1][j] = 2;
				spreadInfection(i+1,j,map);
			}
		}
		
		if(j < map.length-1) {
			if(map[i][j+1] == 1) {
				map[i][j+1] = 2;
				spreadInfection(i,j+1,map);
			}
		}
		
		if(i > 0) {
			if(map[i-1][j] == 1) {
				map[i-1][j] = 2;
				spreadInfection(i-1,j,map);
			}
		}
		
		if(j > 0) {
			if(map[i][j-1] == 1) {
				map[i][j-1] = 2;
				spreadInfection(i,j-1,map);
			}
		}
	}
}
