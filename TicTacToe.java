public class WinCheckUC9 {

    static char[][] board = {
        {'X', 'O', 'X'},
        {'O', 'X', ' '},
        {'O', ' ', 'X'}
    };

    // UC9: Check Winning Condition
    public static boolean checkWin(char symbol) {

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol &&
                board[1][j] == symbol &&
                board[2][j] == symbol) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {
            return true;
        }

        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) {
            return true;
        }

        return false;
    }

    // Test method
    public static void main(String[] args) {
        char player = 'X';

        if (checkWin(player)) {
            System.out.println("Player " + player + " wins!");
        } else {
            System.out.println("No winner yet.");
        }
    }
}
