
public class EscapeTheMaze {
	public static void main(String args[]) {
		int[][] maze = {{1,0,0,0,0,1},
						{1,1,0,0,0,1},
						{0,0,2,1,3,0},
						{0,0,1,0,1,0}};
		System.out.println(solution(maze));
	}
	
	public static boolean solution(int[][] maze) {
		int playerX = 0;
		int playerY = 0;
		int playerDir = 0; //an angle in degrees
		
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[i].length; j++) {
				if(maze[i][j] == 2) {
					playerY = i;
					playerX = j;
				}
			}
		}
		
		int moveCount = 0;
		boolean found = false;
		
		while(maze[playerY][playerX] != 3 && moveCount < 1000) {
			moveCount++;
			int blockInFront = 1;
			if(playerDir == 0 && playerY >= 1) {
				blockInFront = maze[playerY-1][playerX];
			} else if (playerDir == 180 && playerY < maze.length-1) {
				blockInFront = maze[playerY+1][playerX];
			} else if (playerDir == 90 && playerX < maze[0].length-1) {
				blockInFront = maze[playerY][playerX+1];
			} else if (playerDir == 270 && playerX >= 1) {
				blockInFront = maze[playerY][playerX-1];
			}
			
			if(blockInFront == 1) {
				playerDir += 90;
				if(playerDir == 360) {
					playerDir = 0;
				}
			} else {
				if(playerDir == 0) {
					playerY--;
				} else if (playerDir == 180) {
					playerY++;
				} else if (playerDir == 90 && playerX < maze[0].length-1) {
					playerX++;
				} else if (playerDir == 270 && playerX >= 1) {
					playerX--;
				}
			}
			
			System.out.println("player pos: " + playerX + "," + playerY);
			System.out.println("player dir:" + playerDir);
			
			for(int i = 0; i < maze.length; i++) {
				for(int j = 0; j < maze[i].length; j++) {
					if(i == playerY && j == playerX) {
						System.out.print("p");
					} else {
						System.out.print(maze[i][j]);
					}
				}
				System.out.println();
			}
			System.out.println();
			
			found = (maze[playerY][playerX] == 3);
		}
		
		return found;
		
		
	}
}
