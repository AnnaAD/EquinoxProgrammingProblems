import java.util.*;
public class SudokuSolver {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        int size = 9;
        int board [][] = new int[size][size];

        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                board[i][j] = scan.nextInt();
        }

        boolean solved = false;
        while(!solved) {
            solved = true;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (board[i][j] == 0) {
                        solved = false;
                        tryToSolve(board, i, j);
                    }
                }
            }
        }

        for(int i=0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    /**
     * Uses process of elimination to determine number at specific space
     * @param board
     * @param row row of space
     * @param col col of space
     * @return If the board is not empty
     */
    public static void tryToSolve(int [][] board, int row, int col) {
        // Integers that the variable at i, j, cannot be
        ArrayList<Integer> ruledOut = new ArrayList<Integer>();
        for(int i=1; i<=9; i++)
            ruledOut.add(i);
        //Checks row
        for(int i=0; i < board.length; i++) {
            if(ruledOut.contains(board[row][i]) )
                ruledOut.remove((Integer)board[row][i]);
        }

        for(int i=0; i < board.length; i++) {
            if(ruledOut.contains(board[i][col]) )
                ruledOut.remove((Integer)board[i][col]);
        }

        for(int i = (row/3) * 3; i < (row/3) * 3 +3; i++) {
            for(int j = (col/3) * 3; j < (col/3) * 3 +3; j++) {
                if(ruledOut.contains(board[i][j]) )
                    ruledOut.remove((Integer)board[i][j]);
            }
        }

        if(ruledOut.size() == 1) {
            board[row][col] = ruledOut.get(0);
        }
    }
}
