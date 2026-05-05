import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    // Display Board
    public static void displayBoard() {
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) {
                System.out.println("--+---+--");
            }
        }
    }

    // UC6: Place Move on Board
    public static boolean placeMove(int row, int col, char symbol) {
        // Check bounds
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            System.out.println("Invalid position! Try again.");
            return false;
        }

        // Check if cell is empty
        if (board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        } else {
            System.out.println("Cell already occupied! Try again.");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X';

        while (true) {
            displayBoard();

            System.out.println("Player " + currentPlayer + " turn.");
            System.out.print("Enter row (0-2): ");
            int row = sc.nextInt();
            System.out.print("Enter col (0-2): ");
            int col = sc.nextInt();

            boolean success = placeMove(row, col, currentPlayer);

            if (success) {
                // Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }
}
