/**
 * TicTacToe
 * UC5 validates the user move ensuring it is within bounds
 * and the selected cell is empty.
 */

public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    public static void main(String[] args) {

        int row = 1;   // example input
        int col = 1;   // example input

        if (isValidMove(row, col)) {
            System.out.println("Valid Move!");
        } else {
            System.out.println("Invalid Move!");
        }
    }

    /**
     * Validates whether the given move is within bounds
     * and the cell is empty.
     */
    static boolean isValidMove(int row, int col) {

        // Check boundaries (0–2)
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        // Check if cell is empty
        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }
}
