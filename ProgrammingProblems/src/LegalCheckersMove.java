
public class LegalCheckersMove {
	// checkers is played on a 10x10 board
	// checkers can only be placed on black squares, even rows and columns
	public static void main(String args[]) {
						//  0  1  2  3  4  5  6  7  8  9
		int[][] board = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 0
						  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 1
						  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 2
						  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 3
						  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 4
						  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 5
						  { 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 }, // 6
						  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 7
						  { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, // 8
						  { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 } };// 9
		System.out.println(solution(board, new Position(6, 9), new Position(2, 5)));

	}

	public static boolean solution(int[][] board, Position startPos, Position endPos) {
		return (getMove(startPos, endPos, board) > 0);
	}

	public static int getMove(Position startPosition, Position endPosition, int[][] board) {
		int successes = 0;
		for (int i = 0; i <= 1; i++) {
			int xMove;

			if (i == 0) {
				xMove = -1;
			} else {
				xMove = 1;
			}

			int yMove = -1;

			Position move = new Position(startPosition.x + xMove, startPosition.y + yMove);
			//System.out.println(move);
			if (move.inBounds(board)) {
				if (!move.isFull(board)) {
					if (move.equals(endPosition)) {
						return 1;
					}
				} else {
					//System.out.println("checking skips around: " + move);
					successes += getSolutionAroundSkipPiece(move, xMove, yMove, endPosition, board);
				}
			}
		}
		return successes;
	}
	
	//really only used for first possible skips...
	public static int getSolutionAroundSkipPiece(Position startPosition, int xMove, int yMove, Position endPosition, int[][] board) {
		int successes = 0;
		if (startPosition.inBounds(board) && startPosition.isFull(board)) {
			Position skip = new Position(startPosition.x + xMove, startPosition.y + yMove);
			//System.out.println("Skipping over: " + startPosition);
			if (skip.equals(endPosition)) {
				successes++;
				return successes;
			} else {
				successes += getSolutionAroundPosition(skip, endPosition, board);
			}
		}
		return successes;
	}

	public static int getSolutionAroundPosition(Position startPosition, Position endPosition, int[][] board) {
		int successes = 0;
		//System.out.println(startPosition);
		for (int i = 0; i <= 1; i++) {
			int xMove;
			int yMove = -1;

			if (i == 0) {
				xMove = -1;
			} else {
				xMove = 1;
			}

			Position skipPiece = new Position(startPosition.x + xMove, startPosition.y + yMove);
			//System.out.println("skip piece: " + skipPiece);
			//System.out.println("inbounds: " + skipPiece.inBounds(board));
			//System.out.println("is full: " + skipPiece.isFull(board));

			if (skipPiece.inBounds(board) && skipPiece.isFull(board)) {
				Position skip = new Position(startPosition.x + xMove * 2, startPosition.y + yMove * 2);
				//System.out.println("Skipping over: " + skipPiece);
				if (skip.equals(endPosition)) {
					successes++;
					return successes;
				} else {
					successes += getSolutionAroundPosition(skip, endPosition, board);
				}
			}
		}
		return successes;
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
			//System.out.println("board piece: " + board[y][x]);
			return (board[y][x] == 1);
		}

		public String toString() {
			return this.x + "," + this.y;
		}
	}

}
