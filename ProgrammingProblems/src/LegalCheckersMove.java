import java.util.ArrayList;

import javax.swing.text.Position;

public class LegalCheckersMove {
	//checkers is played on a 10x10 board
	//checkers can only be placed on black squares, even rows and columns
	public static void main(String args[]) {
		//               0 1 2 3 4 5 6 7 8 9
		int [][] board={{0,0,0,0,0,0,0,0,0,0}, // 0
						{0,0,0,0,0,0,0,0,0,0}, //1
						{0,0,0,0,0,0,0,0,0,0}, //2
						{0,0,0,0,0,0,0,0,0,0}, //3
						{0,0,0,0,0,0,0,0,0,0},//4
						{0,0,0,0,0,0,0,0,0,0},//5
						{0,0,0,0,0,1,0,0,0,0},//6
						{0,0,0,0,0,0,0,0,0,0},//7
						{0,0,0,0,0,1,0,0,0,0},//8
						{0,0,0,0,0,0,1,0,0,0}};//9
		System.out.println(solution(board,new Position(6,9), new Position(4,5)));

	}

	public static boolean solution (int[][] board, Position startPos, Position endPos) {		
		return (getMove(startPos, endPos, board) > 0);
	}

	public static int getMove(Position startPosition, Position endPosition, int[][] board) {
		
	}
	
	public static int getSolutionInSkips(Position startPosition, Position endPosition, int[][] board) {
		int success = 0;
		if(new Position(startPosition.x+1,startPosition.y+1).isFull(board)) {
			Position skip = new Position(startPosition.x+1,startPosition.y+1);
			
		}
	}
	
	private static class Position {
		public int x;
		public int y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public boolean equals(Position p) {
			return p.x == this.x && p.y == this.y;
		}
		
		public boolean inBounds(int[][] board) {
			return (this.x < board[0].length && this.y < board.length && this.x >= 0 && this.y >= 0);
		}
		
		public boolean isFull(int[][] board) {
			if(this.inBounds(board)) {
				return(board[y][x] == 1);
			}
			return true;
		}
	}

}



