/*Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
Example:
Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|
Follow up:
Could you do better than O(n2) per move() operation?
*/

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
 
/*** O(1) ****/
public class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiD;
    private int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rows[row] += score(player);
        cols[col] += score(player);
        if (row == col) diagonal += score(player);
        if (row + col == n - 1) antiD += score(player);
        
        if (rows[row] == n || rows[row] == -n)  return getWinner(rows[row]);
        if (cols[col] == n || cols[col] == -n)  return getWinner(cols[col]);
        
        if (diagonal == n || diagonal == -n)    return getWinner(diagonal);
        if (antiD == n || antiD == -n)  return getWinner(antiD);
        return 0;
    }
    
    private int score(int player) {
        return player == 1 ? 1 : -1;
    }
    
    private int getWinner(int score) {
        return score == n ? 1 : 2;
    }
}

/*** O(n^2) ***/
public class TicTacToe {
    private int[][] board;
    private int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.board = new int[n][n];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        /* row winner*/
        for (int i = 0; i < n; i++) {   //check first col for each row
            int j = 1;
            if (board[i][0] == 1) {
                for (j = 1; j < n; j++) {   //check every col
                    if (board[i][j] != 1)   break;
                }
                if (j == n) return board[i][0];
            }
            if (board[i][0] == 2) {
                for (j = 1; j < n; j++) {
                    if (board[i][j] != 2)   break;
                }
                if (j == n) return board[i][0];
            }
        }
        /* col winner*/
        for (int i = 0; i < n; i++) {   //check first row for each col
            int j = 1;
            if (board[0][i] == 1) {
                for (j = 1; j < n; j++) {   //check every row
                    if (board[j][i] != 1)   break;
                }
                if (j == n) return board[0][i];
            }
            if (board[0][i] == 2) {
                for (j = 1; j < n; j++) {   //check every row
                    if (board[j][i] != 2)   break;
                }
                if (j == n) return board[0][i];
            }
        }
        
        /* diagonal winner*/
        if (board[0][0] == 1) {
            int i = 1;
            for (i = 1; i < n; i++) {
                if (board[i][i] != 1)   break;
            }
            if (i == n) return board[0][0];
        }
        if (board[0][0] == 2) {
            int i = 1;
            for (i = 1; i < n; i++) {
                if (board[i][i] != 2)   break;
            }
            if (i == n) return board[0][0];
        }
        
        /* anti-diagonal winner*/
        if (board[n-1][0] == 1) {
            int i = n - 2;
            for (i = n - 2; i >= 0; i--) {
                if (board[i][n-1-i] != 1)   break;
            }
            if (i == -1) return board[n-1][0];
        }
        if (board[n-1][0] == 2) {
            int i = n - 2;
            for (i = n - 2; i >= 0; i--) {
                if (board[i][n-1-i] != 2)   break;
            }
            if (i == -1) return board[n-1][0];
        }
        
        
        return 0;
        
    }
    
    
}
