import java.util.Scanner;

public class EscapeTheMazeAdvanced {
	private static int playerX = 0;
	private static int playerY = 0;
	private static int playerDir = 0;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		int[][] maze = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int  j = 0; j < m; j++) {
				maze[i][j] = sc.nextInt();
			}
		}
		System.out.println(solution(maze));
	}
	
	public static boolean solution(int[][] maze) {
		 //an angle in degrees
		
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
			int blockToRight = 1;
			if( playerY >= 1) {
				if(playerDir == 0 ) {
					blockInFront = maze[playerY-1][playerX];
				} else if (playerDir == 270) {
					blockToRight = maze[playerY-1][playerX];
					//System.out.println("block to north chosen");
				}
			}
			if (playerY < maze.length-1) {
				if(playerDir == 180) {
					blockInFront = maze[playerY+1][playerX];
					//System.out.println("block to south: " + maze[playerY+1][playerX]);
				} else if (playerDir == 90) {
					blockToRight = maze[playerY+1][playerX];
				}
			}
			if (playerX < maze[0].length-1) {
				if(playerDir == 90) {
					blockInFront = maze[playerY][playerX+1];
				} else if (playerDir == 0) {
					blockToRight = maze[playerY][playerX+1];
					//System.out.println("block to east chosen");
				}
			}
			if (playerX >= 1) {
				if(playerDir == 270) {
					blockInFront = maze[playerY][playerX-1];
				} else if(playerDir == 180) {
					blockToRight = maze[playerY][playerX-1];
					//System.out.println("block to west chosen");
				}
			}
			
			//System.out.println("Right: " + blockToRight);
			//System.out.println("Front: " + blockInFront);
			//System.out.println("before move player dir:" + playerDir);
			
			if(blockToRight != 1) {
				//turn right
				playerDir += 90;
				if(playerDir == 360) {
					playerDir = 0;
				}
				moveForward();

			} else if (blockInFront == 1) {
				//Turn left
				playerDir -= 90;
				if(playerDir == -90) {
					playerDir = 270;
				}
			} else {
				moveForward();
			}
			
			//System.out.println("after move player dir:" + playerDir);
			
			/*for(int i = 0; i < maze.length; i++) {
				for(int j = 0; j < maze[i].length; j++) {
					if(i == playerY && j == playerX) {
						System.out.print("p");
					} else {
						System.out.print(maze[i][j]);
					}
				}
				System.out.println();
			}
			System.out.println();*/
			
			found = (maze[playerY][playerX] == 3);
		}
		
		return found;
		
		
	}
	
	public static void moveForward() {
		if(playerDir == 0) {
			playerY--;
		} else if (playerDir == 180) {
			playerY++;
		} else if (playerDir == 90) {
			playerX++;
		} else if (playerDir == 270) {
			playerX--;
		}
	}
	
}
