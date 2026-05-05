public class DrawCheckUC10 {

    static char[][] board = {
        {'X', 'O', 'X'},
        {'X', 'O', 'O'},
        {'O', 'X', 'X'}
    };

    // Reuse UC9 logic (simplified here)
    public static boolean checkWin(char s) {
        // rows & columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == s && board[i][1] == s && board[i][2] == s) ||
                (board[0][i] == s && board[1][i] == s && board[2][i] == s)) {
                return true;
            }
        }

        // diagonals
        return (board[0][0] == s && board[1][1] == s && board[2][2] == s) ||
               (board[0][2] == s && board[1][1] == s && board[2][0] == s);
    }

    // UC10: Detect Draw Condition
    public static boolean isDraw() {

        // Check for any empty cell
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // still moves left
                }
            }
        }

        // No empty cells → check no winner
        if (!checkWin('X') && !checkWin('O')) {
            return true;
        }

        return false;
    }

    // Test method
    public static void main(String[] args) {

        if (isDraw()) {
            System.out.println("Game is a Draw!");
        } else {
            System.out.println("Not a draw.");
        }
    }
}
